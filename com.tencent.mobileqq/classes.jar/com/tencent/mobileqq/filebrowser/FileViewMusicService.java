package com.tencent.mobileqq.filebrowser;

import android.content.BroadcastReceiver;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class FileViewMusicService
  implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static WeakReference<FileViewMusicService> c;
  String a;
  FileViewMusicService.IFileViewMusicEvent b;
  private MediaPlayer d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private int h;
  private boolean i = false;
  private BroadcastReceiver j;
  
  public static FileViewMusicService a()
  {
    Object localObject1 = c;
    if (localObject1 != null) {
      localObject1 = (FileViewMusicService)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new FileViewMusicService();
      c = new WeakReference(localObject2);
    }
    return localObject2;
  }
  
  private void i()
  {
    if (this.f)
    {
      if (!this.g) {
        return;
      }
      try
      {
        if ((this.a != null) && (this.a.length() != 0))
        {
          if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
          {
            QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
            return;
          }
          if ((this.d != null) && (this.e)) {
            this.d.start();
          }
        }
        else
        {
          if (!QLog.isDevelopLevel())
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e("FileViewMusicService<FileAssistant>", 2, "musci path not init!");
            return;
          }
          throw new NullPointerException(BaseApplication.getContext().getString(2131889459));
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("musicPathString not init ");
          localStringBuilder.append(localException.toString());
          QLog.e("FileViewMusicService<FileAssistant>", 2, localStringBuilder.toString());
        }
      }
    }
    else {}
  }
  
  public void a(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer != null)
    {
      this.h = paramInt;
      this.i = true;
      if (this.f) {
        localMediaPlayer.seekTo(this.h);
      }
    }
  }
  
  public void a(FileViewMusicService.IFileViewMusicEvent paramIFileViewMusicEvent)
  {
    this.b = paramIFileViewMusicEvent;
  }
  
  public void a(String paramString, FileViewMusicService.IGetTotalTime paramIGetTotalTime)
  {
    ThreadManager.executeOnSubThread(new FileViewMusicService.1(this, paramString, paramIGetTotalTime));
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_3
    //   11: ifnull +19 -> 30
    //   14: aload_3
    //   15: invokevirtual 167	android/media/MediaPlayer:stop	()V
    //   18: aload_0
    //   19: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   22: invokevirtual 170	android/media/MediaPlayer:release	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   30: aload_0
    //   31: new 172	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   34: dup
    //   35: invokespecial 173	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   38: putfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   41: aload_0
    //   42: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   45: aload_0
    //   46: invokevirtual 177	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   49: aload_0
    //   50: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   53: aload_0
    //   54: invokevirtual 181	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   57: aload_0
    //   58: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   61: aload_0
    //   62: invokevirtual 185	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   65: aload_0
    //   66: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   69: iconst_0
    //   70: invokevirtual 189	android/media/MediaPlayer:setLooping	(Z)V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 61	com/tencent/mobileqq/filebrowser/FileViewMusicService:a	Ljava/lang/String;
    //   78: new 191	java/io/FileInputStream
    //   81: dup
    //   82: new 193	java/io/File
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokespecial 197	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: astore_3
    //   94: aload_3
    //   95: astore_2
    //   96: aload_0
    //   97: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   100: iconst_3
    //   101: invokevirtual 200	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   104: aload_3
    //   105: astore_2
    //   106: aload_0
    //   107: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   110: aload_3
    //   111: invokevirtual 204	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   114: invokevirtual 208	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   117: aload_3
    //   118: astore_2
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield 42	com/tencent/mobileqq/filebrowser/FileViewMusicService:g	Z
    //   124: aload_3
    //   125: astore_2
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 40	com/tencent/mobileqq/filebrowser/FileViewMusicService:f	Z
    //   131: aload_3
    //   132: astore_2
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 137	com/tencent/mobileqq/filebrowser/FileViewMusicService:h	I
    //   138: aload_3
    //   139: astore_2
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 44	com/tencent/mobileqq/filebrowser/FileViewMusicService:i	Z
    //   145: aload_3
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 210	com/tencent/mobileqq/filebrowser/FileViewMusicService:j	Landroid/content/BroadcastReceiver;
    //   151: ifnonnull +52 -> 203
    //   154: aload_3
    //   155: astore_2
    //   156: aload_0
    //   157: new 212	com/tencent/mobileqq/filebrowser/FileViewMusicService$2
    //   160: dup
    //   161: aload_0
    //   162: invokespecial 215	com/tencent/mobileqq/filebrowser/FileViewMusicService$2:<init>	(Lcom/tencent/mobileqq/filebrowser/FileViewMusicService;)V
    //   165: putfield 210	com/tencent/mobileqq/filebrowser/FileViewMusicService:j	Landroid/content/BroadcastReceiver;
    //   168: aload_3
    //   169: astore_2
    //   170: new 217	android/content/IntentFilter
    //   173: dup
    //   174: invokespecial 218	android/content/IntentFilter:<init>	()V
    //   177: astore 4
    //   179: aload_3
    //   180: astore_2
    //   181: aload 4
    //   183: ldc 220
    //   185: invokevirtual 223	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   188: aload_3
    //   189: astore_2
    //   190: invokestatic 73	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   193: aload_0
    //   194: getfield 210	com/tencent/mobileqq/filebrowser/FileViewMusicService:j	Landroid/content/BroadcastReceiver;
    //   197: aload 4
    //   199: invokevirtual 227	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   202: pop
    //   203: aload_3
    //   204: astore_2
    //   205: aload_0
    //   206: getfield 96	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Landroid/media/MediaPlayer;
    //   209: invokevirtual 230	android/media/MediaPlayer:prepareAsync	()V
    //   212: aload_3
    //   213: invokevirtual 233	java/io/FileInputStream:close	()V
    //   216: goto +8 -> 224
    //   219: astore_2
    //   220: aload_2
    //   221: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   224: aload_0
    //   225: aload_1
    //   226: putfield 61	com/tencent/mobileqq/filebrowser/FileViewMusicService:a	Ljava/lang/String;
    //   229: iconst_1
    //   230: ireturn
    //   231: astore_2
    //   232: aload_3
    //   233: astore_1
    //   234: aload_2
    //   235: astore_3
    //   236: goto +23 -> 259
    //   239: astore_1
    //   240: goto +121 -> 361
    //   243: astore_1
    //   244: goto +218 -> 462
    //   247: astore_1
    //   248: goto +309 -> 557
    //   251: astore_1
    //   252: goto +398 -> 650
    //   255: astore_3
    //   256: aload 4
    //   258: astore_1
    //   259: aload_1
    //   260: astore_2
    //   261: aload_0
    //   262: getfield 143	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   265: ifnull +22 -> 287
    //   268: aload_1
    //   269: astore_2
    //   270: aload_0
    //   271: getfield 143	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   274: invokestatic 73	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   277: ldc 237
    //   279: invokevirtual 117	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   282: invokeinterface 241 2 0
    //   287: aload_1
    //   288: astore_2
    //   289: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +49 -> 341
    //   295: aload_1
    //   296: astore_2
    //   297: new 122	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   304: astore 4
    //   306: aload_1
    //   307: astore_2
    //   308: aload 4
    //   310: ldc 243
    //   312: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: astore_2
    //   318: aload 4
    //   320: aload_3
    //   321: invokevirtual 244	java/io/IOException:toString	()Ljava/lang/String;
    //   324: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: astore_2
    //   330: ldc 87
    //   332: iconst_2
    //   333: aload 4
    //   335: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_1
    //   342: ifnull +14 -> 356
    //   345: aload_1
    //   346: invokevirtual 233	java/io/FileInputStream:close	()V
    //   349: iconst_0
    //   350: ireturn
    //   351: astore_1
    //   352: aload_1
    //   353: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_1
    //   359: aconst_null
    //   360: astore_3
    //   361: aload_3
    //   362: astore_2
    //   363: aload_0
    //   364: getfield 143	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   367: ifnull +15 -> 382
    //   370: aload_3
    //   371: astore_2
    //   372: aload_0
    //   373: getfield 143	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   376: aconst_null
    //   377: invokeinterface 241 2 0
    //   382: aload_3
    //   383: astore_2
    //   384: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +49 -> 436
    //   390: aload_3
    //   391: astore_2
    //   392: new 122	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   399: astore 4
    //   401: aload_3
    //   402: astore_2
    //   403: aload 4
    //   405: ldc 246
    //   407: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_3
    //   412: astore_2
    //   413: aload 4
    //   415: aload_1
    //   416: invokevirtual 247	java/lang/IllegalStateException:toString	()Ljava/lang/String;
    //   419: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_3
    //   424: astore_2
    //   425: ldc 87
    //   427: iconst_2
    //   428: aload 4
    //   430: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload_3
    //   437: astore_2
    //   438: aload_1
    //   439: invokevirtual 248	java/lang/IllegalStateException:printStackTrace	()V
    //   442: aload_3
    //   443: ifnull +14 -> 457
    //   446: aload_3
    //   447: invokevirtual 233	java/io/FileInputStream:close	()V
    //   450: iconst_0
    //   451: ireturn
    //   452: astore_1
    //   453: aload_1
    //   454: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   457: iconst_0
    //   458: ireturn
    //   459: astore_1
    //   460: aconst_null
    //   461: astore_3
    //   462: aload_3
    //   463: astore_2
    //   464: aload_0
    //   465: getfield 143	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   468: ifnull +15 -> 483
    //   471: aload_3
    //   472: astore_2
    //   473: aload_0
    //   474: getfield 143	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   477: aconst_null
    //   478: invokeinterface 241 2 0
    //   483: aload_3
    //   484: astore_2
    //   485: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +49 -> 537
    //   491: aload_3
    //   492: astore_2
    //   493: new 122	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   500: astore 4
    //   502: aload_3
    //   503: astore_2
    //   504: aload 4
    //   506: ldc 250
    //   508: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload_3
    //   513: astore_2
    //   514: aload 4
    //   516: aload_1
    //   517: invokevirtual 251	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   520: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload_3
    //   525: astore_2
    //   526: ldc 87
    //   528: iconst_2
    //   529: aload 4
    //   531: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: aload_3
    //   538: ifnull +14 -> 552
    //   541: aload_3
    //   542: invokevirtual 233	java/io/FileInputStream:close	()V
    //   545: iconst_0
    //   546: ireturn
    //   547: astore_1
    //   548: aload_1
    //   549: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   552: iconst_0
    //   553: ireturn
    //   554: astore_1
    //   555: aconst_null
    //   556: astore_3
    //   557: aload_3
    //   558: astore_2
    //   559: aload_0
    //   560: getfield 143	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   563: ifnull +15 -> 578
    //   566: aload_3
    //   567: astore_2
    //   568: aload_0
    //   569: getfield 143	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   572: aconst_null
    //   573: invokeinterface 241 2 0
    //   578: aload_3
    //   579: astore_2
    //   580: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +49 -> 632
    //   586: aload_3
    //   587: astore_2
    //   588: new 122	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   595: astore 4
    //   597: aload_3
    //   598: astore_2
    //   599: aload 4
    //   601: ldc 253
    //   603: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_3
    //   608: astore_2
    //   609: aload 4
    //   611: aload_1
    //   612: invokevirtual 254	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   615: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload_3
    //   620: astore_2
    //   621: ldc 87
    //   623: iconst_2
    //   624: aload 4
    //   626: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload_3
    //   633: ifnull +14 -> 647
    //   636: aload_3
    //   637: invokevirtual 233	java/io/FileInputStream:close	()V
    //   640: iconst_0
    //   641: ireturn
    //   642: astore_1
    //   643: aload_1
    //   644: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   647: iconst_0
    //   648: ireturn
    //   649: astore_1
    //   650: aload_2
    //   651: ifnull +15 -> 666
    //   654: aload_2
    //   655: invokevirtual 233	java/io/FileInputStream:close	()V
    //   658: goto +8 -> 666
    //   661: astore_2
    //   662: aload_2
    //   663: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   666: aload_1
    //   667: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	668	0	this	FileViewMusicService
    //   0	668	1	paramString	String
    //   9	196	2	localObject1	Object
    //   219	2	2	localIOException1	java.io.IOException
    //   231	4	2	localIOException2	java.io.IOException
    //   260	395	2	localObject2	Object
    //   661	2	2	localIOException3	java.io.IOException
    //   4	232	3	localObject3	Object
    //   255	66	3	localIOException4	java.io.IOException
    //   360	277	3	localObject4	Object
    //   6	619	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   212	216	219	java/io/IOException
    //   96	104	231	java/io/IOException
    //   106	117	231	java/io/IOException
    //   119	124	231	java/io/IOException
    //   126	131	231	java/io/IOException
    //   133	138	231	java/io/IOException
    //   140	145	231	java/io/IOException
    //   147	154	231	java/io/IOException
    //   156	168	231	java/io/IOException
    //   170	179	231	java/io/IOException
    //   181	188	231	java/io/IOException
    //   190	203	231	java/io/IOException
    //   205	212	231	java/io/IOException
    //   96	104	239	java/lang/IllegalStateException
    //   106	117	239	java/lang/IllegalStateException
    //   119	124	239	java/lang/IllegalStateException
    //   126	131	239	java/lang/IllegalStateException
    //   133	138	239	java/lang/IllegalStateException
    //   140	145	239	java/lang/IllegalStateException
    //   147	154	239	java/lang/IllegalStateException
    //   156	168	239	java/lang/IllegalStateException
    //   170	179	239	java/lang/IllegalStateException
    //   181	188	239	java/lang/IllegalStateException
    //   190	203	239	java/lang/IllegalStateException
    //   205	212	239	java/lang/IllegalStateException
    //   96	104	243	java/lang/SecurityException
    //   106	117	243	java/lang/SecurityException
    //   119	124	243	java/lang/SecurityException
    //   126	131	243	java/lang/SecurityException
    //   133	138	243	java/lang/SecurityException
    //   140	145	243	java/lang/SecurityException
    //   147	154	243	java/lang/SecurityException
    //   156	168	243	java/lang/SecurityException
    //   170	179	243	java/lang/SecurityException
    //   181	188	243	java/lang/SecurityException
    //   190	203	243	java/lang/SecurityException
    //   205	212	243	java/lang/SecurityException
    //   96	104	247	java/lang/IllegalArgumentException
    //   106	117	247	java/lang/IllegalArgumentException
    //   119	124	247	java/lang/IllegalArgumentException
    //   126	131	247	java/lang/IllegalArgumentException
    //   133	138	247	java/lang/IllegalArgumentException
    //   140	145	247	java/lang/IllegalArgumentException
    //   147	154	247	java/lang/IllegalArgumentException
    //   156	168	247	java/lang/IllegalArgumentException
    //   170	179	247	java/lang/IllegalArgumentException
    //   181	188	247	java/lang/IllegalArgumentException
    //   190	203	247	java/lang/IllegalArgumentException
    //   205	212	247	java/lang/IllegalArgumentException
    //   78	94	251	finally
    //   261	268	251	finally
    //   270	287	251	finally
    //   289	295	251	finally
    //   297	306	251	finally
    //   308	316	251	finally
    //   318	328	251	finally
    //   330	341	251	finally
    //   78	94	255	java/io/IOException
    //   345	349	351	java/io/IOException
    //   78	94	358	java/lang/IllegalStateException
    //   446	450	452	java/io/IOException
    //   78	94	459	java/lang/SecurityException
    //   541	545	547	java/io/IOException
    //   78	94	554	java/lang/IllegalArgumentException
    //   636	640	642	java/io/IOException
    //   96	104	649	finally
    //   106	117	649	finally
    //   119	124	649	finally
    //   126	131	649	finally
    //   133	138	649	finally
    //   140	145	649	finally
    //   147	154	649	finally
    //   156	168	649	finally
    //   170	179	649	finally
    //   181	188	649	finally
    //   190	203	649	finally
    //   205	212	649	finally
    //   363	370	649	finally
    //   372	382	649	finally
    //   384	390	649	finally
    //   392	401	649	finally
    //   403	411	649	finally
    //   413	423	649	finally
    //   425	436	649	finally
    //   438	442	649	finally
    //   464	471	649	finally
    //   473	483	649	finally
    //   485	491	649	finally
    //   493	502	649	finally
    //   504	512	649	finally
    //   514	524	649	finally
    //   526	537	649	finally
    //   559	566	649	finally
    //   568	578	649	finally
    //   580	586	649	finally
    //   588	597	649	finally
    //   599	607	649	finally
    //   609	619	649	finally
    //   621	632	649	finally
    //   654	658	661	java/io/IOException
  }
  
  public int b()
  {
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer != null) {
      return localMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public boolean b(String paramString)
  {
    String str = this.a;
    return (str != null) && (str.equalsIgnoreCase(paramString));
  }
  
  public boolean c()
  {
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer == null) {
      return false;
    }
    return localMediaPlayer.isPlaying();
  }
  
  public void d()
  {
    MediaPlayer localMediaPlayer = this.d;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying())) {
      this.d.pause();
    }
    this.e = false;
    if (this.j != null)
    {
      BaseApplication.getContext().unregisterReceiver(this.j);
      this.j = null;
    }
    if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
  }
  
  public void e()
  {
    this.e = true;
    this.g = true;
    i();
  }
  
  public void f()
  {
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.d.release();
      this.d = null;
    }
    if (this.j != null)
    {
      BaseApplication.getContext().unregisterReceiver(this.j);
      this.j = null;
    }
    try
    {
      if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this) != 0) {
        break label92;
      }
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not abandon audio focus");
    }
    catch (Exception localException)
    {
      label77:
      label92:
      break label77;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
    }
    this.a = null;
  }
  
  public void g()
  {
    MediaPlayer localMediaPlayer = this.d;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying())) {
      this.d.pause();
    }
  }
  
  public void h()
  {
    if ((this.d != null) && (this.e)) {
      try
      {
        if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
        {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
          return;
        }
        this.d.start();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt != -3)
    {
      if ((paramInt != -2) && (paramInt != -1)) {
        return;
      }
      if (this.d.isPlaying()) {
        d();
      }
    }
    else
    {
      MediaPlayer localMediaPlayer = this.d;
      if (localMediaPlayer != null) {
        localMediaPlayer.setVolume(0.1F, 0.1F);
      }
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.d.seekTo(0);
    paramMediaPlayer = this.b;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.cf_();
    }
    if (this.j != null)
    {
      BaseApplication.getContext().unregisterReceiver(this.j);
      this.j = null;
    }
    if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    this.e = false;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("what[");
      paramMediaPlayer.append(paramInt1);
      paramMediaPlayer.append("],extra[");
      paramMediaPlayer.append(paramInt2);
      paramMediaPlayer.append("]");
      QLog.e("FileViewMusicService<FileAssistant>", 2, paramMediaPlayer.toString());
    }
    paramMediaPlayer = this.b;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a(BaseApplication.getContext().getString(2131889458));
    }
    this.d.release();
    this.d = null;
    this.a = null;
    if (this.j != null)
    {
      BaseApplication.getContext().unregisterReceiver(this.j);
      this.j = null;
    }
    if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.f = true;
    i();
    paramMediaPlayer = this.d;
    if ((paramMediaPlayer != null) && (this.i)) {
      paramMediaPlayer.seekTo(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileViewMusicService
 * JD-Core Version:    0.7.0.1
 */