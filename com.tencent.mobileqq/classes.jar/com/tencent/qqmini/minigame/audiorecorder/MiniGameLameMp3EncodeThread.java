package com.tencent.qqmini.minigame.audiorecorder;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioRecord;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MiniGameLameMp3EncodeThread
  extends Thread
{
  public static final String AUDIO_SOURCE_AUTO = "auto";
  public static final String AUDIO_SOURCE_CAMCORDER = "camcorder";
  public static final String AUDIO_SOURCE_MIC = "mic";
  public static final String AUDIO_SOURCE_VOICE_COMMUNICATION = "voice_communication";
  public static final String AUDIO_SOURCE_VOICE_RECOGNITION = "voice_recognition";
  public static final String TAG = MiniGameLameMp3EncodeThread.class.getSimpleName();
  private boolean isPause = false;
  private boolean isRecording = false;
  private String mAudioFileFormat = "mp3";
  private int mAudioSource = 1;
  private int mBufferTime = 5;
  private int mCallbackFrameSize;
  private int mChannelConfig = 16;
  private int mEncodingPcmFormat = 2;
  private int mInChannel = 1;
  private int mOutBitRate = 32;
  private final int mQuality = 7;
  private String mRecordFilePath;
  private Resources mResources = AppLoaderFactory.g().getContext().getResources();
  private int mSampleRate = 8000;
  private MiniGameLameMp3Recorder.RecorderHandler recorderHandler;
  
  public MiniGameLameMp3EncodeThread(MiniGameLameMp3Recorder.RecorderHandler paramRecorderHandler)
  {
    super(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_game_record_encode_thread));
    this.recorderHandler = paramRecorderHandler;
  }
  
  private FileOutputStream getFileOutputStream()
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(createSDFile(this.mRecordFilePath));
      return localFileOutputStream;
    }
    catch (Exception localException)
    {
      QMLog.e(TAG, "getFileOutputStream exception", localException);
    }
    return null;
  }
  
  private void sendAfterRecording(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte;
    if (this.mCallbackFrameSize > 0)
    {
      if (paramInt <= this.mCallbackFrameSize) {
        break label82;
      }
      arrayOfByte = new byte[this.mCallbackFrameSize];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, this.mCallbackFrameSize);
      this.recorderHandler.sendFrameRecordMessage(arrayOfByte, false);
    }
    label82:
    for (int i = this.mCallbackFrameSize + 0;; i = 0)
    {
      arrayOfByte = new byte[this.mCallbackFrameSize];
      System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, paramInt - i);
      this.recorderHandler.sendFrameRecordMessage(arrayOfByte, true);
      return;
    }
  }
  
  private int sendWhenRecording(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int k;
    if (this.mCallbackFrameSize > 0)
    {
      k = paramInt2 + paramInt1;
      if (k >= this.mCallbackFrameSize * 2) {
        break label265;
      }
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt2, paramInt1);
      return paramInt2 + paramInt1;
    }
    for (;;)
    {
      byte[] arrayOfByte;
      if (k >= this.mCallbackFrameSize * 2)
      {
        arrayOfByte = new byte[this.mCallbackFrameSize];
        int m = paramInt2 - j;
        if (m >= this.mCallbackFrameSize)
        {
          System.arraycopy(paramArrayOfByte2, j, arrayOfByte, 0, this.mCallbackFrameSize);
          j += this.mCallbackFrameSize;
        }
        for (;;)
        {
          k -= this.mCallbackFrameSize;
          this.recorderHandler.sendFrameRecordMessage(arrayOfByte, false);
          break;
          if (m > 0)
          {
            System.arraycopy(paramArrayOfByte2, j, arrayOfByte, 0, m);
            System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, m, this.mCallbackFrameSize - m);
            i += this.mCallbackFrameSize - m;
            j = paramInt2;
          }
          else
          {
            System.arraycopy(paramArrayOfByte1, i, arrayOfByte, 0, this.mCallbackFrameSize);
            i += this.mCallbackFrameSize;
          }
        }
      }
      paramInt2 -= j;
      paramInt1 -= i;
      if (paramInt2 > 0)
      {
        arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte2, j, arrayOfByte, 0, paramInt2);
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 0, paramInt2);
        System.arraycopy(paramArrayOfByte1, i, paramArrayOfByte2, paramInt2, paramInt1);
        return paramInt1 + paramInt2;
      }
      System.arraycopy(paramArrayOfByte1, i, paramArrayOfByte2, 0, paramInt1);
      return paramInt1;
      return 0;
      label265:
      int i = 0;
      int j = 0;
    }
  }
  
  private void setAudioSource(int paramInt)
  {
    this.mAudioSource = paramInt;
  }
  
  public File createSDFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    File localFile;
    do
    {
      return paramString;
      localFile = new File(paramString);
      paramString = localFile;
    } while (localFile.exists());
    if (localFile.isDirectory())
    {
      localFile.mkdirs();
      return localFile;
    }
    localFile.createNewFile();
    return localFile;
  }
  
  public void deleteTmpFile()
  {
    if (TextUtils.isEmpty(this.mRecordFilePath)) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.mRecordFilePath);
    } while (!localFile.exists());
    localFile.delete();
  }
  
  public int getAudioSource()
  {
    return this.mAudioSource;
  }
  
  public int getCallbackFrameSize()
  {
    return this.mCallbackFrameSize;
  }
  
  public int getInChannel()
  {
    return this.mInChannel;
  }
  
  public int getMinBufferSize()
  {
    return AudioRecord.getMinBufferSize(this.mSampleRate, this.mChannelConfig, this.mEncodingPcmFormat);
  }
  
  public int getOutBitRate()
  {
    return this.mOutBitRate;
  }
  
  public String getRecordFileFormat()
  {
    return this.mAudioFileFormat;
  }
  
  public String getRecordFilePath()
  {
    return this.mRecordFilePath;
  }
  
  public int getSampleRate()
  {
    return this.mSampleRate;
  }
  
  public boolean isPause()
  {
    return this.isPause;
  }
  
  public boolean isRecording()
  {
    return this.isRecording;
  }
  
  public void pauseRecord()
  {
    this.isPause = true;
    this.recorderHandler.sendEmptyMessage(3);
  }
  
  public boolean recording(FileOutputStream paramFileOutputStream, int paramInt)
  {
    short[] arrayOfShort = new short[this.mSampleRate * 2 * this.mBufferTime];
    byte[] arrayOfByte1 = new byte[(int)(7200.0D + arrayOfShort.length * 1.25D)];
    byte[] arrayOfByte2 = new byte[this.mCallbackFrameSize * 3];
    try
    {
      this.isRecording = true;
      this.isPause = false;
      this.recorderHandler.sendEmptyMessage(1);
      AudioRecord localAudioRecord = new AudioRecord(this.mAudioSource, this.mSampleRate, this.mChannelConfig, this.mEncodingPcmFormat, paramInt * 2);
      localAudioRecord.startRecording();
      int i = 0;
      while (this.isRecording) {
        if (!this.isPause)
        {
          int j = localAudioRecord.read(arrayOfShort, 0, paramInt);
          if (j < 0)
          {
            QMLog.e(TAG, "recording readSize < 0");
            this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_error));
            return false;
          }
          j = MiniGameLameMp3Native.jniEncode(arrayOfShort, arrayOfShort, j, arrayOfByte1);
          if (j < 0)
          {
            QMLog.e(TAG, "recording encodeOutputLength < 0");
            this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_encode_error));
            return false;
          }
          if (j != 0)
          {
            paramFileOutputStream.write(arrayOfByte1, 0, j);
            i = sendWhenRecording(arrayOfByte1, j, arrayOfByte2, i);
          }
        }
      }
      sendAfterRecording(arrayOfByte2, i);
      paramInt = MiniGameLameMp3Native.jniFlush(arrayOfByte1);
      if (paramInt < 0)
      {
        QMLog.e(TAG, "recording flushOutputLength < 0");
        this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_encode_error));
        return false;
      }
      paramFileOutputStream.write(arrayOfByte1, 0, paramInt);
      paramFileOutputStream.close();
      localAudioRecord.stop();
      localAudioRecord.release();
      this.isRecording = false;
      this.isPause = false;
      return true;
    }
    catch (IOException paramFileOutputStream)
    {
      QMLog.e(TAG, "recording IOException", paramFileOutputStream);
      this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_write_file_error));
      return false;
    }
    catch (IllegalStateException paramFileOutputStream)
    {
      QMLog.e(TAG, "recording IllegalStateException", paramFileOutputStream);
      this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_init_error));
    }
    return false;
  }
  
  public void resumeRecord()
  {
    this.isPause = false;
    this.recorderHandler.sendEmptyMessage(2);
  }
  
  public void run()
  {
    if (this.isRecording)
    {
      QMLog.w(TAG, "run thread is already running");
      return;
    }
    if (TextUtils.isEmpty(this.mRecordFilePath))
    {
      QMLog.e(TAG, "run record file path is null");
      return;
    }
    Process.setThreadPriority(-19);
    FileOutputStream localFileOutputStream = getFileOutputStream();
    if (localFileOutputStream == null)
    {
      QMLog.e(TAG, "startRecording FileOutputStream output is null");
      this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_file_output_stream_error));
      return;
    }
    int i = getMinBufferSize();
    if (i < 0)
    {
      QMLog.e(TAG, "startRecording get minBufferSize < 0");
      this.recorderHandler.sendErrorMessage(this.mResources.getString(R.string.mini_game_record_sample_rate_error));
      return;
    }
    try
    {
      MiniGameLameMp3Native.jniInit(this.mSampleRate, this.mInChannel, this.mSampleRate, this.mOutBitRate, 7);
      boolean bool = recording(localFileOutputStream, i);
      MiniGameLameMp3Native.jniClose();
      if (bool) {
        this.recorderHandler.sendEmptyMessage(4);
      }
      QMLog.d(TAG, "startRecording stop isSuccess: " + bool);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e(TAG, "startRecording fail", localException);
    }
  }
  
  public void setAudioSource(String paramString)
  {
    int j = 1;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      if (!"auto".equals(paramString)) {
        break label33;
      }
      i = 0;
    }
    for (;;)
    {
      setAudioSource(i);
      return;
      label33:
      i = j;
      if (!"mic".equals(paramString)) {
        if ("camcorder".equals(paramString))
        {
          i = 5;
        }
        else if ("voice_communication".equals(paramString))
        {
          i = 7;
        }
        else
        {
          i = j;
          if ("voice_recognition".equals(paramString)) {
            i = 6;
          }
        }
      }
    }
  }
  
  public void setCallbackFrameSize(int paramInt)
  {
    this.mCallbackFrameSize = paramInt;
  }
  
  public void setInChannel(int paramInt)
  {
    this.mInChannel = paramInt;
  }
  
  public void setOutBitRate(int paramInt)
  {
    this.mOutBitRate = paramInt;
  }
  
  public void setRecordFileFormat(String paramString)
  {
    this.mAudioFileFormat = paramString;
  }
  
  public void setRecordFilePath(String paramString)
  {
    this.mRecordFilePath = paramString;
  }
  
  public void setSampleRate(int paramInt)
  {
    this.mSampleRate = paramInt;
  }
  
  public void startRecord()
  {
    start();
  }
  
  public void stopRecord()
  {
    this.isRecording = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */