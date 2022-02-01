package com.tencent.qqmini.miniapp.audiorecorder;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
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
  public static final String TAG = "com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread";
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
      return null;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (paramString.isDirectory())
      {
        paramString.mkdirs();
        return paramString;
      }
      paramString.createNewFile();
    }
    return paramString;
  }
  
  private int encodeAndSave(int paramInt1, short[] paramArrayOfShort, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, FileOutputStream paramFileOutputStream, AudioRecord paramAudioRecord, boolean paramBoolean)
  {
    boolean bool1;
    Object localObject;
    int i;
    do
    {
      for (;;)
      {
        boolean bool2 = this.isRecording;
        bool1 = false;
        localObject = paramArrayOfByte2;
        i = paramInt2;
        if (!bool2) {
          break label596;
        }
        if (!this.isPause) {
          break;
        }
        if (!paramBoolean) {
          paramBoolean = true;
        }
      }
      if (paramBoolean) {
        paramBoolean = false;
      }
      i = paramAudioRecord.read(paramArrayOfShort, 0, paramInt1);
      this.mVoiceLevel = getVoiceSize(i, paramArrayOfShort);
      if (i < 0)
      {
        paramArrayOfShort = this.mMainHandler;
        localObject = paramArrayOfByte2;
        i = paramInt2;
        if (paramArrayOfShort == null) {
          break;
        }
        paramArrayOfShort.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_error)));
        localObject = paramArrayOfByte2;
        i = paramInt2;
        break;
      }
    } while (i == 0);
    for (;;)
    {
      int j = LameMp3Native.jniEncode(paramArrayOfShort, paramArrayOfShort, i, paramArrayOfByte1);
      if (j < 0)
      {
        paramArrayOfShort = this.mMainHandler;
        localObject = paramArrayOfByte2;
        i = paramInt2;
        if (paramArrayOfShort == null) {
          break;
        }
        paramArrayOfShort.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_encode_error)));
        localObject = paramArrayOfByte2;
        i = paramInt2;
        break;
      }
      if (j != 0) {}
      for (;;)
      {
        try
        {
          paramFileOutputStream.write(paramArrayOfByte1, 0, j);
          if (this.mCallbackFrameSize > 0)
          {
            localObject = paramArrayOfByte2;
            if (paramArrayOfByte2 != null)
            {
              onFrameRecord(paramArrayOfByte2, false);
              localObject = null;
            }
            paramArrayOfByte2 = (byte[])localObject;
            n = 0;
            i = paramInt2;
            paramInt2 = j + paramInt2;
            j = i;
            localObject = paramArrayOfByte2;
          }
        }
        catch (Throwable paramArrayOfShort)
        {
          int n;
          continue;
        }
        try
        {
          if (paramInt2 >= this.mCallbackFrameSize)
          {
            j = i;
            localObject = paramArrayOfByte2;
            byte[] arrayOfByte = new byte[this.mCallbackFrameSize];
            int k;
            int m;
            if (i > 0)
            {
              j = i;
              localObject = arrayOfByte;
              System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 0, i);
              j = i;
              localObject = arrayOfByte;
              k = this.mCallbackFrameSize - i;
              j = i;
              localObject = arrayOfByte;
              System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, i, k);
              k = n + k;
              m = 0;
            }
            else
            {
              j = i;
              localObject = arrayOfByte;
              System.arraycopy(paramArrayOfByte1, n, arrayOfByte, 0, this.mCallbackFrameSize);
              j = i;
              localObject = arrayOfByte;
              k = n + this.mCallbackFrameSize;
              m = i;
            }
            j = m;
            localObject = arrayOfByte;
            int i1 = paramInt2 - this.mCallbackFrameSize;
            n = k;
            paramInt2 = i1;
            i = m;
            paramArrayOfByte2 = arrayOfByte;
            j = m;
            localObject = arrayOfByte;
            if (i1 >= this.mCallbackFrameSize)
            {
              j = m;
              localObject = arrayOfByte;
              onFrameRecord(arrayOfByte, false);
              paramArrayOfByte2 = null;
              n = k;
              paramInt2 = i1;
              i = m;
            }
          }
          else if (paramInt2 > 0)
          {
            j = i;
            localObject = paramArrayOfByte2;
            System.arraycopy(paramArrayOfByte1, n, paramArrayOfByte3, i, paramInt2 - i);
          }
          else
          {
            paramInt2 = 0;
          }
        }
        catch (Throwable paramArrayOfShort) {}
      }
      paramInt2 = j;
      paramArrayOfByte2 = (byte[])localObject;
      break label542;
      continue;
      label542:
      paramArrayOfShort = this.mMainHandler;
      localObject = paramArrayOfByte2;
      i = paramInt2;
      if (paramArrayOfShort == null) {
        break;
      }
      paramArrayOfShort.sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_write_file_error)));
      localObject = paramArrayOfByte2;
      i = paramInt2;
      break;
    }
    label596:
    if (localObject != null)
    {
      paramBoolean = bool1;
      if (i == 0) {
        paramBoolean = true;
      }
      onFrameRecord((byte[])localObject, paramBoolean);
    }
    return i;
  }
  
  private FileOutputStream getFileOutputStream()
  {
    try
    {
      localObject = new FileOutputStream(createSDFile(this.mRecordFilPath));
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject;
      break label100;
    }
    catch (IOException localIOException)
    {
      label18:
      label100:
      break label18;
    }
    localObject = this.mMainHandler;
    if (localObject != null) {
      ((Handler)localObject).sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_wr_file_error)));
    }
    localObject = null;
    if (localObject == null)
    {
      QMLog.e(TAG, "output is null!");
      localObject = this.mMainHandler;
      if (localObject != null) {
        ((Handler)localObject).sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_input_null)));
      }
      return null;
    }
    return localObject;
    localObject = this.mMainHandler;
    if (localObject != null) {
      ((Handler)localObject).sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_mk_file_error)));
    }
    return null;
  }
  
  private void loadLameMp3So()
  {
    this.mNativeLoaded = MiniAppSoLoader.g().isLameMp3SoLoaded();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("mNativeLoaded : ");
    localStringBuilder1.append(this.mNativeLoaded);
    QMLog.e("[miniapp]-LameMp3Native", localStringBuilder1.toString());
    StringBuilder localStringBuilder2;
    if (!this.mNativeLoaded) {
      try
      {
        this.mNativeLoaded = MiniAppSoLoader.g().loadLameMp3So();
      }
      catch (Throwable localThrowable1)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("load so exception, fail to load network libmini_lamemp3.so:");
        localStringBuilder2.append(this.mNativeLoaded);
        QMLog.e("[miniapp]-LameMp3Native", localStringBuilder2.toString(), localThrowable1);
      }
    }
    if (!this.mNativeLoaded) {
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
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("load so exception, fail to load local libmini_lamemp3.so:");
        localStringBuilder2.append(this.mNativeLoaded);
        QMLog.i("[miniapp]-LameMp3Native", localStringBuilder2.toString(), localThrowable2);
      }
    }
  }
  
  private void onFrameRecord(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  private void startRecording(int paramInt1, short[] paramArrayOfShort, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, FileOutputStream paramFileOutputStream, AudioRecord paramAudioRecord)
  {
    // Byte code:
    //   0: aload 8
    //   2: invokevirtual 290	android/media/AudioRecord:startRecording	()V
    //   5: aload_0
    //   6: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   9: ifnull +12 -> 21
    //   12: aload_0
    //   13: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   16: iconst_1
    //   17: invokevirtual 294	android/os/Handler:sendEmptyMessage	(I)Z
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
    //   36: invokespecial 296	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:encodeAndSave	(I[S[B[B[BILjava/io/FileOutputStream;Landroid/media/AudioRecord;Z)I
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
    //   54: invokestatic 194	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   57: aload_0
    //   58: aload_2
    //   59: iconst_1
    //   60: invokespecial 188	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   63: aload_3
    //   64: invokestatic 300	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniFlush	([B)I
    //   67: istore_1
    //   68: iload_1
    //   69: ifge +36 -> 105
    //   72: aload_0
    //   73: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   76: ifnull +29 -> 105
    //   79: aload_0
    //   80: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   83: invokestatic 44	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   86: invokevirtual 48	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   89: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   92: getstatic 176	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_encode_error	I
    //   95: invokevirtual 65	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   98: invokestatic 161	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   101: invokevirtual 167	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   104: pop
    //   105: iload_1
    //   106: ifeq +50 -> 156
    //   109: aload 7
    //   111: aload_3
    //   112: iconst_0
    //   113: iload_1
    //   114: invokevirtual 182	java/io/FileOutputStream:write	([BII)V
    //   117: goto +39 -> 156
    //   120: aload_0
    //   121: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   124: ifnull +32 -> 156
    //   127: aload_0
    //   128: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   131: invokestatic 44	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   134: invokevirtual 48	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   137: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   140: getstatic 197	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_write_file_error	I
    //   143: invokevirtual 65	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   146: invokestatic 161	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   149: invokevirtual 167	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   152: pop
    //   153: goto +3 -> 156
    //   156: aload 7
    //   158: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   161: goto +36 -> 197
    //   164: aload_0
    //   165: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   168: ifnull +29 -> 197
    //   171: aload_0
    //   172: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   175: invokestatic 44	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   178: invokevirtual 48	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   181: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   184: getstatic 306	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_close_error	I
    //   187: invokevirtual 65	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   190: invokestatic 161	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   193: invokevirtual 167	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   196: pop
    //   197: aload 8
    //   199: invokevirtual 309	android/media/AudioRecord:stop	()V
    //   202: aload 8
    //   204: invokevirtual 312	android/media/AudioRecord:release	()V
    //   207: invokestatic 315	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   210: aload_0
    //   211: iconst_0
    //   212: putfield 88	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   215: aload_0
    //   216: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   219: ifnull +49 -> 268
    //   222: aload_0
    //   223: getfield 98	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mp3Player	Lcom/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder;
    //   226: invokevirtual 319	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:getRecordDuration	()J
    //   229: lconst_1
    //   230: lcmp
    //   231: ifle +13 -> 244
    //   234: aload_0
    //   235: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   238: iconst_5
    //   239: invokevirtual 294	android/os/Handler:sendEmptyMessage	(I)Z
    //   242: pop
    //   243: return
    //   244: new 122	java/io/File
    //   247: dup
    //   248: aload_0
    //   249: getfield 205	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   252: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: astore_2
    //   256: aload_2
    //   257: invokevirtual 127	java/io/File:exists	()Z
    //   260: ifeq +8 -> 268
    //   263: aload_2
    //   264: invokevirtual 322	java/io/File:delete	()Z
    //   267: pop
    //   268: return
    //   269: astore_2
    //   270: aload 8
    //   272: invokevirtual 309	android/media/AudioRecord:stop	()V
    //   275: aload 8
    //   277: invokevirtual 312	android/media/AudioRecord:release	()V
    //   280: aload_2
    //   281: athrow
    //   282: aload_0
    //   283: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   286: ifnull +29 -> 315
    //   289: aload_0
    //   290: getfield 100	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   293: invokestatic 44	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   296: invokevirtual 48	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   299: invokevirtual 54	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   302: getstatic 325	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_init_error	I
    //   305: invokevirtual 65	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   308: invokestatic 161	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   311: invokevirtual 167	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   314: pop
    //   315: invokestatic 315	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   318: aload_0
    //   319: iconst_0
    //   320: putfield 88	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   323: return
    //   324: invokestatic 315	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   327: aload_0
    //   328: iconst_0
    //   329: putfield 88	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   332: aload_2
    //   333: athrow
    //   334: astore_2
    //   335: goto -53 -> 282
    //   338: astore_2
    //   339: goto -219 -> 120
    //   342: astore_2
    //   343: goto -179 -> 164
    //   346: astore_2
    //   347: goto -23 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	LameMp3EncodeThread
    //   0	350	1	paramInt1	int
    //   0	350	2	paramArrayOfShort	short[]
    //   0	350	3	paramArrayOfByte1	byte[]
    //   0	350	4	paramArrayOfByte2	byte[]
    //   0	350	5	paramArrayOfByte3	byte[]
    //   0	350	6	paramInt2	int
    //   0	350	7	paramFileOutputStream	FileOutputStream
    //   0	350	8	paramAudioRecord	AudioRecord
    // Exception table:
    //   from	to	target	type
    //   5	21	269	finally
    //   21	40	269	finally
    //   44	63	269	finally
    //   63	68	269	finally
    //   72	105	269	finally
    //   109	117	269	finally
    //   120	153	269	finally
    //   156	161	269	finally
    //   164	197	269	finally
    //   0	5	334	java/lang/IllegalStateException
    //   109	117	338	java/lang/Throwable
    //   156	161	342	java/lang/Throwable
    //   0	5	346	finally
    //   197	207	346	finally
    //   270	282	346	finally
    //   282	315	346	finally
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
      this.mMediaPlayer = new ReportMediaPlayer();
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
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
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
          int j = paramArrayOfShort[i];
          int k = paramArrayOfShort[i];
          l += j * k;
          i += 1;
        }
        double d1 = l;
        double d2 = paramInt;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        paramInt = (int)(Math.log10(d1) * 10.0D) / 10;
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
      this.mMediaPlayer = new ReportMediaPlayer();
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
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying()))
    {
      this.mMediaPlayer.pause();
      return true;
    }
    return false;
  }
  
  public boolean playResume()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.start();
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
    if (this.isRecording)
    {
      QMLog.w(TAG, "record thread is allready running!");
      return;
    }
    if (TextUtils.isEmpty(this.mRecordFilPath))
    {
      QMLog.e(TAG, "run(), record file is null");
      return;
    }
    if (!this.mNativeLoaded)
    {
      localObject = this.mMainHandler;
      if (localObject != null) {
        ((Handler)localObject).sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_so_unload)));
      }
      return;
    }
    Process.setThreadPriority(-19);
    int i = AudioRecord.getMinBufferSize(this.mInSampleRate, 16, 2);
    if (i < 0)
    {
      localObject = this.mMainHandler;
      if (localObject != null) {
        ((Handler)localObject).sendMessage(LameMp3Recorder.generateRecordErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_samplerate_error)));
      }
      return;
    }
    Object localObject = null;
    int j = this.mCallbackFrameSize;
    if (j > 0) {
      localObject = new byte[j];
    }
    FileOutputStream localFileOutputStream = getFileOutputStream();
    if (localFileOutputStream == null) {
      return;
    }
    j = this.mInSampleRate;
    LameMp3Native.jniInit(j, this.mOutChannel, j, this.mOutBitRate, this.mQuality);
    this.isRecording = true;
    this.isPause = false;
    AudioRecord localAudioRecord = new AudioRecord(this.mAudioSource, this.mInSampleRate, 16, this.mEncodingPcmFormat, i * 2);
    short[] arrayOfShort = new short[this.mInSampleRate * 2 * 1 * 5];
    double d = arrayOfShort.length;
    Double.isNaN(d);
    startRecording(i, arrayOfShort, new byte[(int)(d * 1.25D + 7200.0D)], null, (byte[])localObject, 0, localFileOutputStream, localAudioRecord);
  }
  
  public void setAudioSource(int paramInt)
  {
    this.mAudioSource = paramInt;
  }
  
  public void setAudioSource(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 1;
    if (!bool)
    {
      paramString = paramString.toLowerCase();
      if ("auto".equals(paramString)) {
        i = 0;
      } else if (!"mic".equals(paramString)) {
        if ("camcorder".equals(paramString)) {
          i = 5;
        } else if ("voice_communication".equals(paramString)) {
          i = 7;
        } else if ("voice_recognition".equals(paramString)) {
          i = 6;
        }
      }
    }
    setAudioSource(i);
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
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */