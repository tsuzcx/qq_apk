package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaCodecEncoder
{
  private static final String TAG = "MediaCodecEncoder";
  private static boolean mDumpEnable = false;
  private MediaCodec.BufferInfo mAACEncBufferInfo = null;
  private MediaCodec mAudioAACEncoder = null;
  private MediaFormat mAudioFormat = null;
  private int mBitrate = 32000;
  private int mChannels = 1;
  private Context mContext;
  private ByteBuffer mEncInBuffer;
  private ByteBuffer mEncOutBuffer;
  private boolean mFormatChangeFlag = false;
  private ByteBuffer mInputBuffer = null;
  private ByteBuffer[] mMediaInputBuffers;
  private ByteBuffer[] mMediaOutputBuffers;
  private ByteBuffer mOutputBuffer = null;
  private File mRecFileDump = null;
  private FileOutputStream mRecFileOut = null;
  private int mSampleRate = 48000;
  private byte[] mTempBufEncIn;
  private byte[] mTempBufEncOut;
  private int nMaxBitRate = 256000;
  
  public MediaCodecEncoder()
  {
    this.mContext = TXCCommonUtil.getAppContext();
    this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
    this.mTempBufEncIn = new byte[7680];
    this.mEncOutBuffer = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
    this.mTempBufEncOut = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
  }
  
  public MediaCodecEncoder(Context paramContext)
  {
    this.mContext = paramContext;
    this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
    this.mTempBufEncIn = new byte[7680];
    this.mEncOutBuffer = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
    this.mTempBufEncOut = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
  }
  
  private void addADTStoPacket(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.mSampleRate;
    if (i == 48000) {}
    do
    {
      i = 3;
      break;
      if (i == 44100)
      {
        i = 4;
        break;
      }
      if (i == 32000)
      {
        i = 5;
        break;
      }
      if (i == 24000)
      {
        i = 6;
        break;
      }
    } while (i != 16000);
    i = 8;
    int j = this.mChannels;
    paramArrayOfByte[0] = -1;
    paramArrayOfByte[1] = -7;
    paramArrayOfByte[2] = ((byte)(64 + (i << 2) + (j >> 2)));
    paramArrayOfByte[3] = ((byte)(((j & 0x3) << 6) + (paramInt >> 11)));
    paramArrayOfByte[4] = ((byte)((paramInt & 0x7FF) >> 3));
    paramArrayOfByte[5] = ((byte)(((paramInt & 0x7) << 5) + 31));
    paramArrayOfByte[6] = -4;
  }
  
  private String getDumpFilePath(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("manufacture:");
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MODEL:");
      ((StringBuilder)localObject).append(Build.MODEL);
      QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mContext;
    if (localObject == null) {
      return null;
    }
    localObject = ((Context)localObject).getExternalFilesDir(null);
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getPath());
    localStringBuilder.append("/MF-");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-M-");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localObject = new File(paramString);
    if (!((File)localObject).getParentFile().exists()) {
      ((File)localObject).getParentFile().mkdirs();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dump:");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dump replace:");
      ((StringBuilder)localObject).append(paramString.replace(" ", "_"));
      QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
    }
    return paramString.replace(" ", "_");
  }
  
  @SuppressLint({"NewApi"})
  public int createAACEncoder(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.mAudioAACEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
      this.mAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
      this.mAudioFormat.setInteger("aac-profile", 2);
      this.mAudioFormat.setInteger("sample-rate", paramInt1);
      this.mAudioFormat.setInteger("channel-count", paramInt2);
      this.mAudioFormat.setInteger("bitrate", paramInt3);
      this.mAudioAACEncoder.configure(this.mAudioFormat, null, null, 1);
      if (this.mAudioAACEncoder != null)
      {
        this.mAudioAACEncoder.start();
        this.mAACEncBufferInfo = new MediaCodec.BufferInfo();
        this.mSampleRate = paramInt1;
        this.mChannels = paramInt2;
        this.mBitrate = paramInt3;
      }
      if (mDumpEnable) {
        this.mRecFileDump = new File(getDumpFilePath("jnirecord.aac"));
      }
    }
    catch (Exception localException)
    {
      label155:
      StringBuilder localStringBuilder;
      label250:
      break label250;
    }
    try
    {
      this.mRecFileOut = new FileOutputStream(this.mRecFileDump);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label155;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MediaCodecEncoder", 2, "open jnirecord.aac file failed.");
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("createAACEncoder succeed!!! : (");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(")");
      QLog.w("MediaCodecEncoder", 2, localStringBuilder.toString());
    }
    return 0;
    if (QLog.isColorLevel()) {
      QLog.e("MediaCodecEncoder", 2, "create AAC Encoder failed.");
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ERROR] creating aac encode stream failed!!! : (");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(")");
      QLog.e("MediaCodecEncoder", 2, localStringBuilder.toString());
    }
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  public int encodeAACFrame(int paramInt)
  {
    if (this.mFormatChangeFlag)
    {
      this.mFormatChangeFlag = false;
      this.mAudioAACEncoder.stop();
      this.mAudioFormat.setInteger("bitrate", this.mBitrate);
      this.mAudioAACEncoder.configure(this.mAudioFormat, null, null, 1);
      this.mAudioAACEncoder.start();
    }
    this.mEncInBuffer.get(this.mTempBufEncIn, 0, paramInt);
    int i = encodeInternalAACFrame(paramInt);
    this.mEncOutBuffer.rewind();
    if (i > 0)
    {
      this.mEncOutBuffer.put(this.mTempBufEncOut, 0, i);
      paramInt = i;
      if (!mDumpEnable) {
        break label176;
      }
      paramInt = i;
      if (this.mRecFileOut == null) {
        break label176;
      }
      paramInt = i + 7;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      addADTStoPacket(arrayOfByte, paramInt);
      System.arraycopy(this.mTempBufEncOut, 0, arrayOfByte, 7, i);
      this.mRecFileOut.write(arrayOfByte, 0, paramInt);
      return i;
    }
    catch (IOException localIOException)
    {
      label155:
      break label155;
    }
    paramInt = i;
    if (QLog.isColorLevel())
    {
      QLog.e("MediaCodecEncoder", 2, "write file failed.");
      return i;
      paramInt = 0;
    }
    label176:
    return paramInt;
  }
  
  @SuppressLint({"NewApi"})
  public int encodeInternalAACFrame(int paramInt)
  {
    try
    {
      i = this.mAudioAACEncoder.dequeueInputBuffer(2000L);
      if (i != -1)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          this.mInputBuffer = this.mAudioAACEncoder.getInputBuffer(i);
        }
        else
        {
          this.mMediaInputBuffers = this.mAudioAACEncoder.getInputBuffers();
          this.mInputBuffer = this.mMediaInputBuffers[i];
        }
        this.mInputBuffer.clear();
        this.mInputBuffer.put(this.mTempBufEncIn, 0, paramInt);
        this.mAudioAACEncoder.queueInputBuffer(i, 0, paramInt, 0L, 0);
        this.mEncInBuffer.rewind();
      }
      i = this.mAudioAACEncoder.dequeueOutputBuffer(this.mAACEncBufferInfo, 0L);
      if (i < 0) {
        return 0;
      }
      j = this.mAACEncBufferInfo.size;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mOutputBuffer = this.mAudioAACEncoder.getOutputBuffer(i);
      }
      else
      {
        this.mMediaOutputBuffers = this.mAudioAACEncoder.getOutputBuffers();
        this.mOutputBuffer = this.mMediaOutputBuffers[i];
      }
      if ((this.mAACEncBufferInfo.flags & 0x2) == 2) {
        paramInt = 0;
      } else {
        paramInt = this.mAACEncBufferInfo.size;
      }
    }
    catch (Exception localException1)
    {
      int i;
      int j;
      label265:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("encode failed.");
        localStringBuilder.append(localException1.getMessage());
        QLog.e("MediaCodecEncoder", 2, localStringBuilder.toString());
      }
      return 0;
    }
    try
    {
      this.mOutputBuffer.position(this.mAACEncBufferInfo.offset);
      this.mOutputBuffer.limit(this.mAACEncBufferInfo.offset + j);
      this.mOutputBuffer.get(this.mTempBufEncOut, 0, paramInt);
      this.mOutputBuffer.position(0);
      this.mAudioAACEncoder.releaseOutputBuffer(i, false);
      return paramInt;
    }
    catch (Exception localException2)
    {
      break label265;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MediaCodecEncoder", 2, "[ERROR] encoding aac stream failed!!!");
    }
    return paramInt;
  }
  
  @SuppressLint({"NewApi"})
  public int releaseAACEncoder()
  {
    try
    {
      if (this.mAudioAACEncoder != null)
      {
        this.mAudioAACEncoder.stop();
        this.mAudioAACEncoder.release();
        this.mAudioAACEncoder = null;
        if (QLog.isColorLevel()) {
          QLog.w("MediaCodecEncoder", 2, "releaseAACEncoder, release aac encode stream succeed!!");
        }
        return 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("release aac encoder failed.");
        localStringBuilder.append(localException.getMessage());
        QLog.e("MediaCodecEncoder", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.e("MediaCodecEncoder", 2, "[ERROR] releaseAACEncoder, release aac encode stream failed!!!");
      }
    }
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  public int setAACEncodeBitrate(int paramInt)
  {
    if ((this.mAudioAACEncoder != null) && (this.mBitrate != paramInt))
    {
      this.mFormatChangeFlag = true;
      this.mBitrate = paramInt;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Set AAC bitrate = ");
        localStringBuilder.append(paramInt);
        QLog.w("MediaCodecEncoder", 2, localStringBuilder.toString());
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.MediaCodecEncoder
 * JD-Core Version:    0.7.0.1
 */