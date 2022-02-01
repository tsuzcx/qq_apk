package com.tencent.qqmini.miniapp.audiorecorder;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.MiniAppSoLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LameMp3EncodeThread
  extends Thread
{
  public static final String TAG = LameMp3EncodeThread.class.getName();
  private boolean isPause = false;
  private boolean isRecording = false;
  private String mAudioFileFormat = "mp3";
  private int mAudioSource = 1;
  private int mCallbackFrameSize;
  private int mEncodingPcmFormat = 2;
  private int mInSampleRate = 8000;
  private Handler mMainHandler;
  private MediaPlayer mMediaPlayer;
  private boolean mNativeLoaded = false;
  private int mOutBitRate = 32;
  private int mOutChannel = 1;
  private int mOutSampleRate = 8000;
  private String mPlayFilePath;
  private int mQuality = 7;
  private String mRecordFilPath;
  private long mRecordTime = 60000L;
  private int mVoiceLevel;
  private LameMp3Recorder mp3Player;
  
  public LameMp3EncodeThread(LameMp3Recorder paramLameMp3Recorder, Handler paramHandler)
  {
    super(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_thread));
    this.mp3Player = paramLameMp3Recorder;
    this.mMainHandler = paramHandler;
    start();
    loadLameMp3So();
  }
  
  public static File createSDFile(String paramString)
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
  
  private int encodeAndSave(int paramInt1, short[] paramArrayOfShort, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, FileOutputStream paramFileOutputStream, AudioRecord paramAudioRecord, boolean paramBoolean)
  {
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = paramArrayOfByte2;
      i = paramInt2;
      if (!this.isRecording) {
        break label120;
      }
      if (!this.isPause) {
        break;
      }
      if (!paramBoolean) {
        paramBoolean = true;
      }
    }
    boolean bool = paramBoolean;
    if (paramBoolean) {
      bool = false;
    }
    i = paramAudioRecord.read(paramArrayOfShort, 0, paramInt1);
    this.mVoiceLevel = getVoiceSize(i, paramArrayOfShort);
    if (i < 0)
    {
      arrayOfByte = paramArrayOfByte2;
      i = paramInt2;
      if (this.mMainHandler != null)
      {
        this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_error)));
        i = paramInt2;
        arrayOfByte = paramArrayOfByte2;
      }
      label120:
      if (arrayOfByte != null) {
        if (i != 0) {
          break label627;
        }
      }
    }
    label617:
    label627:
    for (paramBoolean = true;; paramBoolean = false)
    {
      for (;;)
      {
        for (;;)
        {
          onFrameRecord(arrayOfByte, paramBoolean);
          return i;
          paramBoolean = bool;
          if (i == 0) {
            break;
          }
          i = LameMp3Native.jniEncode(paramArrayOfShort, paramArrayOfShort, i, paramArrayOfByte1);
          if (i < 0)
          {
            arrayOfByte = paramArrayOfByte2;
            i = paramInt2;
            if (this.mMainHandler == null) {
              break label120;
            }
            this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_encode_error)));
            arrayOfByte = paramArrayOfByte2;
            i = paramInt2;
            break label120;
          }
          paramBoolean = bool;
          if (i == 0) {
            break;
          }
          try
          {
            paramFileOutputStream.write(paramArrayOfByte1, 0, i);
            paramBoolean = bool;
            if (this.mCallbackFrameSize <= 0) {
              break;
            }
            arrayOfByte = paramArrayOfByte2;
            if (paramArrayOfByte2 != null)
            {
              onFrameRecord(paramArrayOfByte2, false);
              arrayOfByte = null;
            }
            k = 0;
            j = paramInt2;
            i += paramInt2;
            paramArrayOfByte2 = arrayOfByte;
            paramInt2 = j;
          }
          catch (Throwable paramArrayOfShort)
          {
            for (;;)
            {
              int j;
              int m;
              continue;
              i = paramInt2;
              paramInt2 = k;
              int k = i;
              i = m;
            }
          }
        }
        j = paramInt2;
        arrayOfByte = paramArrayOfByte2;
        try
        {
          if (i >= this.mCallbackFrameSize)
          {
            j = paramInt2;
            arrayOfByte = paramArrayOfByte2;
            paramArrayOfByte2 = new byte[this.mCallbackFrameSize];
            if (paramInt2 > 0)
            {
              j = paramInt2;
              arrayOfByte = paramArrayOfByte2;
              System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, 0, paramInt2);
              j = paramInt2;
              arrayOfByte = paramArrayOfByte2;
              m = this.mCallbackFrameSize - paramInt2;
              j = paramInt2;
              arrayOfByte = paramArrayOfByte2;
              System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt2, m);
              j = 0;
              paramInt2 = k + m;
              k = j;
            }
            for (;;)
            {
              j = k;
              arrayOfByte = paramArrayOfByte2;
              m = i - this.mCallbackFrameSize;
              j = k;
              arrayOfByte = paramArrayOfByte2;
              if (m < this.mCallbackFrameSize) {
                break label637;
              }
              j = k;
              arrayOfByte = paramArrayOfByte2;
              onFrameRecord(paramArrayOfByte2, false);
              paramArrayOfByte2 = null;
              i = paramInt2;
              paramInt2 = k;
              k = i;
              i = m;
              break;
              j = paramInt2;
              arrayOfByte = paramArrayOfByte2;
              System.arraycopy(paramArrayOfByte1, k, paramArrayOfByte2, 0, this.mCallbackFrameSize);
              j = paramInt2;
              arrayOfByte = paramArrayOfByte2;
              m = this.mCallbackFrameSize + k;
              k = paramInt2;
              paramInt2 = m;
            }
          }
          if (i <= 0) {
            break label617;
          }
          j = paramInt2;
          arrayOfByte = paramArrayOfByte2;
          System.arraycopy(paramArrayOfByte1, k, paramArrayOfByte3, paramInt2, i - paramInt2);
          paramInt2 = i;
          paramBoolean = bool;
        }
        catch (Throwable paramArrayOfShort)
        {
          paramInt2 = j;
          paramArrayOfByte2 = arrayOfByte;
        }
      }
      arrayOfByte = paramArrayOfByte2;
      i = paramInt2;
      if (this.mMainHandler == null) {
        break label120;
      }
      this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_write_file_error)));
      arrayOfByte = paramArrayOfByte2;
      i = paramInt2;
      break label120;
      paramInt2 = 0;
      paramBoolean = bool;
      break;
    }
  }
  
  private FileOutputStream getFileOutputStream()
  {
    try
    {
      FileOutputStream localFileOutputStream1 = new FileOutputStream(createSDFile(this.mRecordFilPath));
      if (localFileOutputStream1 == null)
      {
        QMLog.e(TAG, "output is null!");
        if (this.mMainHandler != null) {
          this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_input_null)));
        }
        return null;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (this.mMainHandler == null) {}
      this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_mk_file_error)));
      return null;
    }
    catch (IOException localIOException)
    {
      FileOutputStream localFileOutputStream2;
      for (;;)
      {
        if (this.mMainHandler != null) {
          this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_wr_file_error)));
        }
        localFileOutputStream2 = null;
      }
      return localFileOutputStream2;
    }
  }
  
  private void loadLameMp3So()
  {
    this.mNativeLoaded = MiniAppSoLoader.g().isLameMp3SoLoaded();
    QMLog.e("[miniapp]-LameMp3Native", "mNativeLoaded : " + this.mNativeLoaded);
    if (!this.mNativeLoaded) {}
    try
    {
      this.mNativeLoaded = MiniAppSoLoader.g().loadLameMp3So();
      if (this.mNativeLoaded) {}
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          System.loadLibrary("mini_lamemp3");
          this.mNativeLoaded = true;
          QMLog.i("[miniapp]-LameMp3Native", "load so exception, load local libmini_lamemp3.so success!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          this.mNativeLoaded = false;
          QMLog.i("[miniapp]-LameMp3Native", "load so exception, fail to load local libmini_lamemp3.so:" + this.mNativeLoaded, localThrowable2);
        }
        localThrowable1 = localThrowable1;
        QMLog.e("[miniapp]-LameMp3Native", "load so exception, fail to load network libmini_lamemp3.so:" + this.mNativeLoaded, localThrowable1);
      }
    }
  }
  
  private void onFrameRecord(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Message localMessage;
    if ((this.mMainHandler != null) && (paramArrayOfByte != null))
    {
      localMessage = Message.obtain();
      localMessage.obj = paramArrayOfByte;
      localMessage.what = 6;
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.mMainHandler.sendMessage(localMessage);
      return;
    }
  }
  
  /* Error */
  private void startRecording(int paramInt1, short[] paramArrayOfShort, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, FileOutputStream paramFileOutputStream, AudioRecord paramAudioRecord)
  {
    // Byte code:
    //   0: aload 8
    //   2: invokevirtual 302	android/media/AudioRecord:startRecording	()V
    //   5: aload_0
    //   6: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   9: ifnull +12 -> 21
    //   12: aload_0
    //   13: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   16: iconst_1
    //   17: invokevirtual 306	android/os/Handler:sendEmptyMessage	(I)Z
    //   20: pop
    //   21: aload_0
    //   22: iload_1
    //   23: aload_2
    //   24: aload_3
    //   25: aload 4
    //   27: aload 5
    //   29: iload 6
    //   31: aload 7
    //   33: aload 8
    //   35: iconst_0
    //   36: invokespecial 308	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:encodeAndSave	(I[S[B[B[BILjava/io/FileOutputStream;Landroid/media/AudioRecord;Z)I
    //   39: istore_1
    //   40: iload_1
    //   41: ifle +22 -> 63
    //   44: iload_1
    //   45: newarray byte
    //   47: astore_2
    //   48: aload 5
    //   50: iconst_0
    //   51: aload_2
    //   52: iconst_0
    //   53: iload_1
    //   54: invokestatic 200	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   57: aload_0
    //   58: aload_2
    //   59: iconst_1
    //   60: invokespecial 177	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   63: aload_3
    //   64: invokestatic 312	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniFlush	([B)I
    //   67: istore_1
    //   68: iload_1
    //   69: ifge +36 -> 105
    //   72: aload_0
    //   73: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   76: ifnull +29 -> 105
    //   79: aload_0
    //   80: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   83: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   86: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   89: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   92: getstatic 186	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_encode_error	I
    //   95: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   98: invokestatic 167	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   101: invokevirtual 173	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   104: pop
    //   105: iload_1
    //   106: ifeq +11 -> 117
    //   109: aload 7
    //   111: aload_3
    //   112: iconst_0
    //   113: iload_1
    //   114: invokevirtual 192	java/io/FileOutputStream:write	([BII)V
    //   117: aload 7
    //   119: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   122: aload 8
    //   124: invokevirtual 318	android/media/AudioRecord:stop	()V
    //   127: aload 8
    //   129: invokevirtual 321	android/media/AudioRecord:release	()V
    //   132: invokestatic 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   140: aload_0
    //   141: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   144: ifnull +24 -> 168
    //   147: aload_0
    //   148: getfield 104	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mp3Player	Lcom/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder;
    //   151: invokevirtual 328	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:getRecordDuration	()J
    //   154: lconst_1
    //   155: lcmp
    //   156: ifle +154 -> 310
    //   159: aload_0
    //   160: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   163: iconst_5
    //   164: invokevirtual 306	android/os/Handler:sendEmptyMessage	(I)Z
    //   167: pop
    //   168: return
    //   169: astore_2
    //   170: aload_0
    //   171: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   174: ifnull +29 -> 203
    //   177: aload_0
    //   178: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   181: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   184: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   187: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   190: getstatic 331	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_init_error	I
    //   193: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   196: invokestatic 167	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   199: invokevirtual 173	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   202: pop
    //   203: invokestatic 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   211: return
    //   212: astore_2
    //   213: aload_0
    //   214: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   217: ifnull -100 -> 117
    //   220: aload_0
    //   221: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   224: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   227: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   230: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   233: getstatic 203	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_write_file_error	I
    //   236: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   239: invokestatic 167	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   242: invokevirtual 173	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   245: pop
    //   246: goto -129 -> 117
    //   249: astore_2
    //   250: aload 8
    //   252: invokevirtual 318	android/media/AudioRecord:stop	()V
    //   255: aload 8
    //   257: invokevirtual 321	android/media/AudioRecord:release	()V
    //   260: aload_2
    //   261: athrow
    //   262: astore_2
    //   263: invokestatic 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   266: aload_0
    //   267: iconst_0
    //   268: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   271: aload_2
    //   272: athrow
    //   273: astore_2
    //   274: aload_0
    //   275: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   278: ifnull -156 -> 122
    //   281: aload_0
    //   282: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   285: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   288: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   291: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   294: getstatic 334	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_close_error	I
    //   297: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   300: invokestatic 167	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   303: invokevirtual 173	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   306: pop
    //   307: goto -185 -> 122
    //   310: new 128	java/io/File
    //   313: dup
    //   314: aload_0
    //   315: getfield 211	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   318: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   321: astore_2
    //   322: aload_2
    //   323: invokevirtual 133	java/io/File:exists	()Z
    //   326: ifeq -158 -> 168
    //   329: aload_2
    //   330: invokevirtual 337	java/io/File:delete	()Z
    //   333: pop
    //   334: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	LameMp3EncodeThread
    //   0	335	1	paramInt1	int
    //   0	335	2	paramArrayOfShort	short[]
    //   0	335	3	paramArrayOfByte1	byte[]
    //   0	335	4	paramArrayOfByte2	byte[]
    //   0	335	5	paramArrayOfByte3	byte[]
    //   0	335	6	paramInt2	int
    //   0	335	7	paramFileOutputStream	FileOutputStream
    //   0	335	8	paramAudioRecord	AudioRecord
    // Exception table:
    //   from	to	target	type
    //   0	5	169	java/lang/IllegalStateException
    //   109	117	212	java/lang/Throwable
    //   5	21	249	finally
    //   21	40	249	finally
    //   44	63	249	finally
    //   63	68	249	finally
    //   72	105	249	finally
    //   109	117	249	finally
    //   117	122	249	finally
    //   213	246	249	finally
    //   274	307	249	finally
    //   0	5	262	finally
    //   122	132	262	finally
    //   170	203	262	finally
    //   250	262	262	finally
    //   117	122	273	java/lang/Throwable
  }
  
  public int getAudioSource()
  {
    return this.mAudioSource;
  }
  
  public int getEncodingPcmFormat()
  {
    return this.mEncodingPcmFormat;
  }
  
  public int getInSampleRate()
  {
    return this.mInSampleRate;
  }
  
  public MediaPlayer getMediaPlayer()
  {
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    return this.mMediaPlayer;
  }
  
  public int getOutBitRate()
  {
    return this.mOutBitRate;
  }
  
  public int getOutChannel()
  {
    return this.mOutChannel;
  }
  
  public int getOutSampleRate()
  {
    return this.mOutSampleRate;
  }
  
  public void getPlayTime()
  {
    if (this.mMediaPlayer != null) {}
  }
  
  public int getQuality()
  {
    return this.mQuality;
  }
  
  public String getRecordFilPath()
  {
    return this.mRecordFilPath;
  }
  
  public long getRecordTime()
  {
    return this.mRecordTime;
  }
  
  public int getVoiceLevel()
  {
    return this.mVoiceLevel;
  }
  
  public int getVoiceSize(int paramInt, short[] paramArrayOfShort)
  {
    if (this.isRecording)
    {
      long l = 0L;
      int i = 0;
      try
      {
        while (i < paramArrayOfShort.length)
        {
          l += paramArrayOfShort[i] * paramArrayOfShort[i];
          i += 1;
        }
        paramInt = (int)(Math.log10(l / paramInt) * 10.0D) / 10;
        return paramInt - 1;
      }
      catch (Exception paramArrayOfShort)
      {
        paramArrayOfShort.printStackTrace();
      }
    }
    return 1;
  }
  
  public boolean isPause()
  {
    return this.isPause;
  }
  
  public boolean isRecording()
  {
    return this.isRecording;
  }
  
  public void onDestory()
  {
    stopPlay();
    restoreRecording();
  }
  
  public boolean play()
  {
    return play(this.mPlayFilePath);
  }
  
  public boolean play(String paramString)
  {
    if (this.isRecording)
    {
      QMLog.e(TAG, "请先关闭录音");
      return false;
    }
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    try
    {
      this.mMediaPlayer.setAudioStreamType(3);
      this.mMediaPlayer.setDataSource(paramString);
      this.mMediaPlayer.prepareAsync();
      this.mMediaPlayer.setOnPreparedListener(new LameMp3EncodeThread.1(this));
      this.mMediaPlayer.setOnCompletionListener(new LameMp3EncodeThread.2(this));
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.mMainHandler.sendMessage(LameMp3Recorder.generatePlayErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_play_error)));
      stopPlay();
    }
    return false;
  }
  
  public boolean playPause()
  {
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()))
    {
      this.mMediaPlayer.pause();
      return true;
    }
    return false;
  }
  
  public boolean playResume()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.start();
      return true;
    }
    return false;
  }
  
  public void restoreRecording()
  {
    this.isRecording = false;
  }
  
  public void run()
  {
    if (this.isRecording) {
      QMLog.w(TAG, "record thread is allready running!");
    }
    int i;
    byte[] arrayOfByte;
    FileOutputStream localFileOutputStream;
    do
    {
      do
      {
        do
        {
          return;
          if (TextUtils.isEmpty(this.mRecordFilPath))
          {
            QMLog.e(TAG, "run(), record file is null");
            return;
          }
          if (this.mNativeLoaded) {
            break;
          }
        } while (this.mMainHandler == null);
        this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_so_unload)));
        return;
        Process.setThreadPriority(-19);
        i = AudioRecord.getMinBufferSize(this.mInSampleRate, 16, 2);
        if (i >= 0) {
          break;
        }
      } while (this.mMainHandler == null);
      this.mMainHandler.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_samplerate_error)));
      return;
      arrayOfByte = null;
      if (this.mCallbackFrameSize > 0) {
        arrayOfByte = new byte[this.mCallbackFrameSize];
      }
      localFileOutputStream = getFileOutputStream();
    } while (localFileOutputStream == null);
    LameMp3Native.jniInit(this.mInSampleRate, this.mOutChannel, this.mInSampleRate, this.mOutBitRate, this.mQuality);
    this.isRecording = true;
    this.isPause = false;
    AudioRecord localAudioRecord = new AudioRecord(this.mAudioSource, this.mInSampleRate, 16, this.mEncodingPcmFormat, i * 2);
    short[] arrayOfShort = new short[this.mInSampleRate * 2 * 1 * 5];
    startRecording(i, arrayOfShort, new byte[(int)(7200.0D + arrayOfShort.length * 1.25D)], null, arrayOfByte, 0, localFileOutputStream, localAudioRecord);
  }
  
  public void setAudioSource(int paramInt)
  {
    this.mAudioSource = paramInt;
  }
  
  public void setAudioSource(String paramString)
  {
    int j = 1;
    int i;
    if (TextUtils.isEmpty(paramString)) {
      i = j;
    }
    for (;;)
    {
      setAudioSource(i);
      return;
      paramString = paramString.toLowerCase();
      if ("auto".equals(paramString))
      {
        i = 0;
      }
      else
      {
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
  }
  
  public void setCallbackFrameSize(int paramInt)
  {
    this.mCallbackFrameSize = paramInt;
  }
  
  public void setEncodingPcmFormat(int paramInt)
  {
    this.mEncodingPcmFormat = paramInt;
  }
  
  public void setFilePath(String paramString)
  {
    this.mRecordFilPath = paramString;
  }
  
  public void setFilePlayPath(String paramString)
  {
    this.mPlayFilePath = paramString;
  }
  
  public void setInSampleRate(int paramInt)
  {
    this.mInSampleRate = paramInt;
  }
  
  public void setOutBitRate(int paramInt)
  {
    this.mOutBitRate = paramInt;
  }
  
  public void setOutChannel(int paramInt)
  {
    this.mOutChannel = paramInt;
  }
  
  public void setOutSampleRate(int paramInt)
  {
    this.mOutSampleRate = paramInt;
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.isPause = paramBoolean;
  }
  
  public void setQuality(int paramInt)
  {
    this.mQuality = paramInt;
  }
  
  public void setRecordFilPath(String paramString)
  {
    this.mRecordFilPath = paramString;
  }
  
  public void setRecordFileFormat(String paramString)
  {
    this.mAudioFileFormat = paramString;
  }
  
  public void setRecordTime(long paramLong)
  {
    this.mRecordTime = paramLong;
  }
  
  public void startRecord()
  {
    ThreadManager.getSubThreadHandler().post(this);
  }
  
  public boolean stopPlay()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */