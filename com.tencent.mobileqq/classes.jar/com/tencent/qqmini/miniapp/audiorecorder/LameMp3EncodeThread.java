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
    //   2: invokevirtual 263	android/media/AudioRecord:startRecording	()V
    //   5: aload_0
    //   6: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   9: ifnull +782 -> 791
    //   12: aload_0
    //   13: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   16: iconst_1
    //   17: invokevirtual 267	android/os/Handler:sendEmptyMessage	(I)Z
    //   20: pop
    //   21: goto +770 -> 791
    //   24: aload_0
    //   25: getfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   28: ifeq +754 -> 782
    //   31: aload_0
    //   32: getfield 96	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   35: istore 13
    //   37: iload 13
    //   39: ifeq +57 -> 96
    //   42: iload 9
    //   44: ifne -20 -> 24
    //   47: iconst_1
    //   48: istore 9
    //   50: goto -26 -> 24
    //   53: astore_2
    //   54: aload_0
    //   55: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   58: ifnull +29 -> 87
    //   61: aload_0
    //   62: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   65: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   68: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   71: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   74: getstatic 270	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_init_error	I
    //   77: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   80: invokestatic 174	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   83: invokevirtual 180	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   86: pop
    //   87: invokestatic 275	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   95: return
    //   96: iload 9
    //   98: ifeq +690 -> 788
    //   101: iconst_0
    //   102: istore 9
    //   104: aload 8
    //   106: aload_2
    //   107: iconst_0
    //   108: iload_1
    //   109: invokevirtual 279	android/media/AudioRecord:read	([SII)I
    //   112: istore 10
    //   114: aload_0
    //   115: aload_0
    //   116: iload 10
    //   118: aload_2
    //   119: invokevirtual 283	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:getVoiceSize	(I[S)I
    //   122: putfield 285	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mVoiceLevel	I
    //   125: iload 10
    //   127: ifge +181 -> 308
    //   130: aload_0
    //   131: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   134: ifnull +648 -> 782
    //   137: aload_0
    //   138: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   141: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   144: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   147: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   150: getstatic 288	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_error	I
    //   153: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   156: invokestatic 174	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   159: invokevirtual 180	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   162: pop
    //   163: aload 4
    //   165: astore_2
    //   166: goto +631 -> 797
    //   169: aload_0
    //   170: aload_2
    //   171: iload 13
    //   173: invokespecial 290	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   176: iload 6
    //   178: ifle +24 -> 202
    //   181: iload 6
    //   183: newarray byte
    //   185: astore_2
    //   186: aload 5
    //   188: iconst_0
    //   189: aload_2
    //   190: iconst_0
    //   191: iload 6
    //   193: invokestatic 294	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   196: aload_0
    //   197: aload_2
    //   198: iconst_1
    //   199: invokespecial 290	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   202: aload_3
    //   203: invokestatic 298	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniFlush	([B)I
    //   206: istore_1
    //   207: iload_1
    //   208: ifge +36 -> 244
    //   211: aload_0
    //   212: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   215: ifnull +29 -> 244
    //   218: aload_0
    //   219: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   222: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   225: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   228: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   231: getstatic 301	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_encode_error	I
    //   234: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   237: invokestatic 174	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   240: invokevirtual 180	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   243: pop
    //   244: iload_1
    //   245: ifeq +11 -> 256
    //   248: aload 7
    //   250: aload_3
    //   251: iconst_0
    //   252: iload_1
    //   253: invokevirtual 305	java/io/FileOutputStream:write	([BII)V
    //   256: aload 7
    //   258: invokevirtual 308	java/io/FileOutputStream:close	()V
    //   261: aload 8
    //   263: invokevirtual 311	android/media/AudioRecord:stop	()V
    //   266: aload 8
    //   268: invokevirtual 314	android/media/AudioRecord:release	()V
    //   271: invokestatic 275	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   274: aload_0
    //   275: iconst_0
    //   276: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   279: aload_0
    //   280: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   283: ifnull -188 -> 95
    //   286: aload_0
    //   287: getfield 104	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mp3Player	Lcom/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder;
    //   290: invokevirtual 318	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:getRecordDuration	()J
    //   293: lconst_1
    //   294: lcmp
    //   295: ifle +432 -> 727
    //   298: aload_0
    //   299: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   302: iconst_5
    //   303: invokevirtual 267	android/os/Handler:sendEmptyMessage	(I)Z
    //   306: pop
    //   307: return
    //   308: iload 10
    //   310: ifne +6 -> 316
    //   313: goto -289 -> 24
    //   316: aload_2
    //   317: aload_2
    //   318: iload 10
    //   320: aload_3
    //   321: invokestatic 322	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniEncode	([S[SI[B)I
    //   324: istore 12
    //   326: iload 12
    //   328: ifge +42 -> 370
    //   331: aload_0
    //   332: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   335: ifnull +447 -> 782
    //   338: aload_0
    //   339: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   342: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   345: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   348: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   351: getstatic 301	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_encode_error	I
    //   354: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   357: invokestatic 174	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   360: invokevirtual 180	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   363: pop
    //   364: aload 4
    //   366: astore_2
    //   367: goto +430 -> 797
    //   370: iload 12
    //   372: ifeq +407 -> 779
    //   375: aload 7
    //   377: aload_3
    //   378: iconst_0
    //   379: iload 12
    //   381: invokevirtual 305	java/io/FileOutputStream:write	([BII)V
    //   384: aload_0
    //   385: getfield 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   388: ifle +391 -> 779
    //   391: aload 4
    //   393: astore 14
    //   395: aload 4
    //   397: ifnull +13 -> 410
    //   400: aload_0
    //   401: aload 4
    //   403: iconst_0
    //   404: invokespecial 290	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   407: aconst_null
    //   408: astore 14
    //   410: iconst_0
    //   411: istore 10
    //   413: iload 6
    //   415: istore 11
    //   417: aload 14
    //   419: astore 4
    //   421: iload 6
    //   423: iload 12
    //   425: iadd
    //   426: istore 12
    //   428: iload 11
    //   430: istore 6
    //   432: iload 12
    //   434: istore 11
    //   436: iload 11
    //   438: aload_0
    //   439: getfield 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   442: if_icmplt +117 -> 559
    //   445: aload_0
    //   446: getfield 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   449: newarray byte
    //   451: astore 14
    //   453: iload 6
    //   455: ifle +75 -> 530
    //   458: aload 5
    //   460: iconst_0
    //   461: aload 14
    //   463: iconst_0
    //   464: iload 6
    //   466: invokestatic 294	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   469: aload_0
    //   470: getfield 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   473: iload 6
    //   475: isub
    //   476: istore 12
    //   478: aload_3
    //   479: iconst_0
    //   480: aload 14
    //   482: iload 6
    //   484: iload 12
    //   486: invokestatic 294	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   489: iconst_0
    //   490: istore 6
    //   492: iload 12
    //   494: iload 10
    //   496: iadd
    //   497: istore 10
    //   499: iload 11
    //   501: aload_0
    //   502: getfield 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   505: isub
    //   506: istore 11
    //   508: iload 11
    //   510: aload_0
    //   511: getfield 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   514: if_icmplt +258 -> 772
    //   517: aload_0
    //   518: aload 14
    //   520: iconst_0
    //   521: invokespecial 290	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   524: aconst_null
    //   525: astore 4
    //   527: goto -91 -> 436
    //   530: aload_3
    //   531: iload 10
    //   533: aload 14
    //   535: iconst_0
    //   536: aload_0
    //   537: getfield 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   540: invokestatic 294	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   543: aload_0
    //   544: getfield 324	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   547: istore 12
    //   549: iload 12
    //   551: iload 10
    //   553: iadd
    //   554: istore 10
    //   556: goto -57 -> 499
    //   559: iload 11
    //   561: ifle +25 -> 586
    //   564: aload_3
    //   565: iload 10
    //   567: aload 5
    //   569: iload 6
    //   571: iload 11
    //   573: iload 6
    //   575: isub
    //   576: invokestatic 294	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   579: iload 11
    //   581: istore 6
    //   583: goto -559 -> 24
    //   586: iconst_0
    //   587: istore 6
    //   589: goto -6 -> 583
    //   592: astore_2
    //   593: aload_0
    //   594: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   597: ifnull +215 -> 812
    //   600: aload_0
    //   601: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   604: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   607: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   610: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   613: getstatic 327	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_write_file_error	I
    //   616: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   619: invokestatic 174	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   622: invokevirtual 180	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   625: pop
    //   626: goto +186 -> 812
    //   629: astore_2
    //   630: aload_0
    //   631: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   634: ifnull -378 -> 256
    //   637: aload_0
    //   638: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   641: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   644: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   647: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   650: getstatic 327	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_write_file_error	I
    //   653: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   656: invokestatic 174	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   659: invokevirtual 180	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   662: pop
    //   663: goto -407 -> 256
    //   666: astore_2
    //   667: aload 8
    //   669: invokevirtual 311	android/media/AudioRecord:stop	()V
    //   672: aload 8
    //   674: invokevirtual 314	android/media/AudioRecord:release	()V
    //   677: aload_2
    //   678: athrow
    //   679: astore_2
    //   680: invokestatic 275	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   683: aload_0
    //   684: iconst_0
    //   685: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   688: aload_2
    //   689: athrow
    //   690: astore_2
    //   691: aload_0
    //   692: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   695: ifnull -434 -> 261
    //   698: aload_0
    //   699: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   702: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   705: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   708: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   711: getstatic 330	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_close_error	I
    //   714: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   717: invokestatic 174	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   720: invokevirtual 180	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   723: pop
    //   724: goto -463 -> 261
    //   727: new 128	java/io/File
    //   730: dup
    //   731: aload_0
    //   732: getfield 152	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   735: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   738: astore_2
    //   739: aload_2
    //   740: invokevirtual 133	java/io/File:exists	()Z
    //   743: ifeq -648 -> 95
    //   746: aload_2
    //   747: invokevirtual 333	java/io/File:delete	()Z
    //   750: pop
    //   751: return
    //   752: astore_2
    //   753: goto -160 -> 593
    //   756: astore_2
    //   757: aload 14
    //   759: astore 4
    //   761: goto -168 -> 593
    //   764: astore_2
    //   765: aload 14
    //   767: astore 4
    //   769: goto -176 -> 593
    //   772: aload 14
    //   774: astore 4
    //   776: goto -340 -> 436
    //   779: goto -196 -> 583
    //   782: aload 4
    //   784: astore_2
    //   785: goto +12 -> 797
    //   788: goto -684 -> 104
    //   791: iconst_0
    //   792: istore 9
    //   794: goto -770 -> 24
    //   797: aload_2
    //   798: ifnull -622 -> 176
    //   801: iload 6
    //   803: ifne +15 -> 818
    //   806: iconst_1
    //   807: istore 13
    //   809: goto -640 -> 169
    //   812: aload 4
    //   814: astore_2
    //   815: goto -18 -> 797
    //   818: iconst_0
    //   819: istore 13
    //   821: goto -652 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	824	0	this	LameMp3EncodeThread
    //   0	824	1	paramInt1	int
    //   0	824	2	paramArrayOfShort	short[]
    //   0	824	3	paramArrayOfByte1	byte[]
    //   0	824	4	paramArrayOfByte2	byte[]
    //   0	824	5	paramArrayOfByte3	byte[]
    //   0	824	6	paramInt2	int
    //   0	824	7	paramFileOutputStream	FileOutputStream
    //   0	824	8	paramAudioRecord	AudioRecord
    //   42	751	9	i	int
    //   112	454	10	j	int
    //   415	165	11	k	int
    //   324	230	12	m	int
    //   35	785	13	bool	boolean
    //   393	380	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	5	53	java/lang/IllegalStateException
    //   375	391	592	java/lang/Throwable
    //   400	407	592	java/lang/Throwable
    //   248	256	629	java/lang/Throwable
    //   5	21	666	finally
    //   24	37	666	finally
    //   104	125	666	finally
    //   130	163	666	finally
    //   169	176	666	finally
    //   181	202	666	finally
    //   202	207	666	finally
    //   211	244	666	finally
    //   248	256	666	finally
    //   256	261	666	finally
    //   316	326	666	finally
    //   331	364	666	finally
    //   375	391	666	finally
    //   400	407	666	finally
    //   436	453	666	finally
    //   458	489	666	finally
    //   499	524	666	finally
    //   530	549	666	finally
    //   564	579	666	finally
    //   593	626	666	finally
    //   630	663	666	finally
    //   691	724	666	finally
    //   0	5	679	finally
    //   54	87	679	finally
    //   261	271	679	finally
    //   667	679	679	finally
    //   256	261	690	java/lang/Throwable
    //   436	453	752	java/lang/Throwable
    //   564	579	752	java/lang/Throwable
    //   458	489	756	java/lang/Throwable
    //   530	549	756	java/lang/Throwable
    //   499	524	764	java/lang/Throwable
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
    short[] arrayOfShort = new short[this.mInSampleRate * 2 * 1 * 5];
    byte[] arrayOfByte2 = new byte[(int)(7200.0D + arrayOfShort.length * 1.25D)];
    if (this.mCallbackFrameSize > 0) {}
    for (byte[] arrayOfByte1 = new byte[this.mCallbackFrameSize];; arrayOfByte1 = null)
    {
      FileOutputStream localFileOutputStream = getFileOutputStream();
      if (localFileOutputStream == null) {
        break;
      }
      LameMp3Native.jniInit(this.mInSampleRate, this.mOutChannel, this.mInSampleRate, this.mOutBitRate, this.mQuality);
      this.isRecording = true;
      this.isPause = false;
      startRecording(i, arrayOfShort, arrayOfByte2, null, arrayOfByte1, 0, localFileOutputStream, new AudioRecord(this.mAudioSource, this.mInSampleRate, 16, this.mEncodingPcmFormat, i * 2));
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */