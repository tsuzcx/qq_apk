package com.tencent.rtmp.sharp.jni;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AudioDecoder
{
  private static final String TAG = "AudioDecoder";
  boolean IsTenFramesReady = false;
  int channels = 0;
  private boolean codeOver = true;
  private RingBuffer decRingBuffer = null;
  private MediaCodec.BufferInfo decodeBufferInfo = null;
  private ByteBuffer[] decodeInputBuffers = null;
  private ByteBuffer[] decodeOutputBuffers = null;
  private long fileTotalMs = 0L;
  int m_nIndex = 0;
  private MediaCodec mediaDecode = null;
  private MediaExtractor mediaExtractor = null;
  int nFirstThreeFrameInfo = 3;
  int nFrameSize = 3840;
  private AudioDecoder.OnCompleteListener onCompleteListener = null;
  private AudioDecoder.OnProgressListener onProgressListener = null;
  int sampleRate = 0;
  private String srcPath;
  
  private int initMediaDecode(int paramInt)
  {
    for (;;)
    {
      try
      {
        this.mediaExtractor = new MediaExtractor();
        this.mediaExtractor.setDataSource(this.srcPath);
        i = this.mediaExtractor.getTrackCount();
        if (i <= 1) {
          break label594;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("m_nIndex: ");
          ((StringBuilder)localObject).append(this.m_nIndex);
          ((StringBuilder)localObject).append(" initMediaDecode mediaExtractor container video, getTrackCount: ");
          ((StringBuilder)localObject).append(this.mediaExtractor.getTrackCount());
          QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
        }
        this.codeOver = true;
        return -2;
      }
      catch (IOException localIOException)
      {
        Object localObject;
        String str;
        StringBuilder localStringBuilder;
        TXCLog.e("AudioDecoder", "init media decode failed.", localIOException);
        this.codeOver = true;
        return -1;
      }
      if (i < this.mediaExtractor.getTrackCount())
      {
        localObject = this.mediaExtractor.getTrackFormat(i);
        str = ((MediaFormat)localObject).getString("mime");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("m_nIndex: ");
          localStringBuilder.append(this.m_nIndex);
          localStringBuilder.append(" initMediaDecode mediaExtractor audio type:");
          localStringBuilder.append(str);
          QLog.w("TRAE", 2, localStringBuilder.toString());
        }
        if (str.startsWith("audio/mpeg"))
        {
          this.mediaExtractor.selectTrack(i);
          this.mediaDecode = MediaCodec.createDecoderByType(str);
          this.mediaDecode.configure((MediaFormat)localObject, null, null, 0);
          this.sampleRate = ((MediaFormat)localObject).getInteger("sample-rate");
          this.channels = ((MediaFormat)localObject).getInteger("channel-count");
          this.fileTotalMs = (((MediaFormat)localObject).getLong("durationUs") / 1000L);
          this.nFrameSize = (this.sampleRate * this.channels * 2 * 20 / 1000);
          this.decRingBuffer = new RingBuffer(this.nFrameSize * paramInt);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("m_nIndex: ");
            ((StringBuilder)localObject).append(this.m_nIndex);
            ((StringBuilder)localObject).append(" initMediaDecode open succeed, mp3 format:(");
            ((StringBuilder)localObject).append(this.sampleRate);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(this.channels);
            ((StringBuilder)localObject).append("), fileTotalMs:");
            ((StringBuilder)localObject).append(this.fileTotalMs);
            ((StringBuilder)localObject).append("ms RingBufferFrame:");
            ((StringBuilder)localObject).append(paramInt);
            QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          i += 1;
          continue;
        }
      }
      localObject = this.mediaDecode;
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("m_nIndex: ");
        ((StringBuilder)localObject).append(this.m_nIndex);
        ((StringBuilder)localObject).append(" initMediaDecode create mediaDecode failed");
        Log.e("AudioDecoder", ((StringBuilder)localObject).toString());
        this.codeOver = true;
        return -1;
      }
      if (this.decRingBuffer == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("m_nIndex: ");
        ((StringBuilder)localObject).append(this.m_nIndex);
        ((StringBuilder)localObject).append(" initMediaDecode create decRingBuffer failed");
        Log.e("AudioDecoder", ((StringBuilder)localObject).toString());
        this.codeOver = true;
        return -1;
      }
      ((MediaCodec)localObject).start();
      this.decodeInputBuffers = this.mediaDecode.getInputBuffers();
      this.decodeOutputBuffers = this.mediaDecode.getOutputBuffers();
      this.decodeBufferInfo = new MediaCodec.BufferInfo();
      this.codeOver = false;
      this.IsTenFramesReady = false;
      this.nFirstThreeFrameInfo = 3;
      return 0;
      label594:
      int i = 0;
    }
  }
  
  private void showLog(String paramString)
  {
    Log.e("AudioCodec", paramString);
  }
  
  private void srcAudioFormatToPCM()
  {
    Object localObject;
    if (this.decodeInputBuffers.length <= 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("m_nIndex: ");
        ((StringBuilder)localObject).append(this.m_nIndex);
        ((StringBuilder)localObject).append(" srcAudioFormatToPCM decodeInputBuffers.length to small,");
        ((StringBuilder)localObject).append(this.decodeInputBuffers.length);
        QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
      }
      this.codeOver = true;
      return;
    }
    int i = this.mediaDecode.dequeueInputBuffer(-1L);
    if (i < 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("m_nIndex: ");
        ((StringBuilder)localObject).append(this.m_nIndex);
        ((StringBuilder)localObject).append(" srcAudioFormatToPCM decodeInputBuffers.inputIndex <0");
        QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
      }
      this.codeOver = true;
      return;
    }
    int j = Build.VERSION.SDK_INT;
    if (j >= 21) {
      localObject = this.mediaDecode.getInputBuffer(i);
    } else {
      localObject = this.decodeInputBuffers[i];
    }
    ((ByteBuffer)localObject).clear();
    int k = this.mediaExtractor.readSampleData((ByteBuffer)localObject, 0);
    if (k < 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("m_nIndex: ");
        ((StringBuilder)localObject).append(this.m_nIndex);
        ((StringBuilder)localObject).append(" srcAudioFormatToPCM readSampleData over,end");
        QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
      }
      this.codeOver = true;
    }
    else
    {
      this.mediaDecode.queueInputBuffer(i, 0, k, 0L, 0);
      this.mediaExtractor.advance();
    }
    i = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000L);
    for (;;)
    {
      if (i < 0) {
        break label599;
      }
      if (j >= 21) {
        localObject = this.mediaDecode.getOutputBuffer(i);
      } else {
        localObject = this.decodeOutputBuffers[i];
      }
      byte[] arrayOfByte = new byte[this.decodeBufferInfo.size];
      try
      {
        ((ByteBuffer)localObject).get(arrayOfByte);
        ((ByteBuffer)localObject).clear();
        if ((this.decRingBuffer != null) && (this.decodeBufferInfo.size > 0))
        {
          this.decRingBuffer.Push(arrayOfByte, this.decodeBufferInfo.size);
          k = this.nFirstThreeFrameInfo;
          this.nFirstThreeFrameInfo = (k - 1);
          if ((k > 0) && (QLog.isColorLevel()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("m_nIndex: ");
            ((StringBuilder)localObject).append(this.m_nIndex);
            ((StringBuilder)localObject).append(" DecodeOneFrame size: ");
            ((StringBuilder)localObject).append(this.decodeBufferInfo.size);
            ((StringBuilder)localObject).append(" Remain: ");
            ((StringBuilder)localObject).append(this.decRingBuffer.RemainRead() / this.nFrameSize);
            QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
          }
        }
        this.mediaDecode.releaseOutputBuffer(i, false);
        if (this.decodeBufferInfo.size > 0) {
          return;
        }
        i = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000L);
      }
      catch (Exception localException)
      {
        label534:
        label599:
        break label534;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("m_nIndex: ");
      ((StringBuilder)localObject).append(this.m_nIndex);
      ((StringBuilder)localObject).append(" srcAudioFormatToPCM wrong outputIndex: ");
      ((StringBuilder)localObject).append(i);
      QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
    }
    this.codeOver = true;
  }
  
  public int ReadOneFrame(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = this.IsTenFramesReady;
    int j = 20;
    int i = j;
    if (!bool)
    {
      i = 20;
      while ((this.decRingBuffer.RemainRead() / this.nFrameSize < 10) && (i > 0) && (!this.codeOver))
      {
        srcAudioFormatToPCM();
        i -= 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("m_nIndex: ");
        localStringBuilder.append(this.m_nIndex);
        localStringBuilder.append(" 10 FramesReady Remain frame: ");
        localStringBuilder.append(this.decRingBuffer.RemainRead() / this.nFrameSize);
        QLog.w("TRAE", 2, localStringBuilder.toString());
      }
      this.IsTenFramesReady = true;
      i = j;
    }
    while ((!this.codeOver) && (this.decRingBuffer.RemainRead() / this.nFrameSize < 10) && (i > 0))
    {
      srcAudioFormatToPCM();
      i -= 1;
    }
    if (this.decRingBuffer.RemainRead() >= paramInt)
    {
      this.decRingBuffer.Pop(paramArrayOfByte, paramInt);
      return paramInt;
    }
    return -1;
  }
  
  public int SeekTo(int paramInt)
  {
    Object localObject = this.mediaExtractor;
    if (localObject != null)
    {
      long l1 = ((MediaExtractor)localObject).getSampleTime();
      paramInt += this.decRingBuffer.RemainRead() * 20 / this.nFrameSize;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("m_nIndex: ");
        ((StringBuilder)localObject).append(this.m_nIndex);
        ((StringBuilder)localObject).append(" current PlayMs: ");
        ((StringBuilder)localObject).append(l1 / 1000L);
        ((StringBuilder)localObject).append(" SeekTo: ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
      }
      this.mediaExtractor.seekTo(paramInt * 1000, 2);
      long l2 = this.mediaExtractor.getSampleTime();
      paramInt = (int)((l2 - l1) / 1000L);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("m_nIndex: ");
        ((StringBuilder)localObject).append(this.m_nIndex);
        ((StringBuilder)localObject).append(" total SeekTo time: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" t2:");
        ((StringBuilder)localObject).append(l2 / 1000L);
        QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
      }
      return paramInt;
    }
    return 0;
  }
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public long getFileTotalMs()
  {
    return this.fileTotalMs;
  }
  
  public int getFrameSize()
  {
    return this.nFrameSize;
  }
  
  public int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public int prepare(int paramInt)
  {
    if (this.srcPath == null) {
      return -1;
    }
    return initMediaDecode(paramInt);
  }
  
  public void release()
  {
    Object localObject = this.mediaDecode;
    if (localObject != null)
    {
      ((MediaCodec)localObject).stop();
      this.mediaDecode.release();
      this.mediaDecode = null;
    }
    localObject = this.mediaExtractor;
    if (localObject != null)
    {
      ((MediaExtractor)localObject).release();
      this.mediaExtractor = null;
    }
    if (this.onCompleteListener != null) {
      this.onCompleteListener = null;
    }
    if (this.onProgressListener != null) {
      this.onProgressListener = null;
    }
    showLog("release");
  }
  
  public void setIOPath(String paramString)
  {
    this.srcPath = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.m_nIndex = paramInt;
  }
  
  public void setOnCompleteListener(AudioDecoder.OnCompleteListener paramOnCompleteListener)
  {
    this.onCompleteListener = paramOnCompleteListener;
  }
  
  public void setOnProgressListener(AudioDecoder.OnProgressListener paramOnProgressListener)
  {
    this.onProgressListener = paramOnProgressListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */