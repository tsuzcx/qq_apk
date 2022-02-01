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
  private static WeakReference<FileViewMusicService> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  FileViewMusicService.IFileViewMusicEvent jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent;
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  public static FileViewMusicService a()
  {
    Object localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 != null) {
      localObject1 = (FileViewMusicService)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new FileViewMusicService();
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject2);
    }
    return localObject2;
  }
  
  private void f()
  {
    if (this.b)
    {
      if (!this.c) {
        return;
      }
      try
      {
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0))
        {
          if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
          {
            QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
            return;
          }
          if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
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
          throw new NullPointerException(BaseApplication.getContext().getString(2131692471));
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
  
  public int a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      return localMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public void a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplication.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
  }
  
  public void a(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.d = true;
      if (this.b) {
        localMediaPlayer.seekTo(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(FileViewMusicService.IFileViewMusicEvent paramIFileViewMusicEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent = paramIFileViewMusicEvent;
  }
  
  public void a(String paramString, FileViewMusicService.IGetTotalTime paramIGetTotalTime)
  {
    ThreadManager.executeOnSubThread(new FileViewMusicService.1(this, paramString, paramIGetTotalTime));
  }
  
  public boolean a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer == null) {
      return false;
    }
    return localMediaPlayer.isPlaying();
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_3
    //   11: ifnull +19 -> 30
    //   14: aload_3
    //   15: invokevirtual 182	android/media/MediaPlayer:stop	()V
    //   18: aload_0
    //   19: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   22: invokevirtual 185	android/media/MediaPlayer:release	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   30: aload_0
    //   31: new 187	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   34: dup
    //   35: invokespecial 188	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   38: putfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   41: aload_0
    //   42: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   45: aload_0
    //   46: invokevirtual 192	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   49: aload_0
    //   50: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   53: aload_0
    //   54: invokevirtual 196	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   57: aload_0
    //   58: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   61: aload_0
    //   62: invokevirtual 200	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   65: aload_0
    //   66: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   69: iconst_0
    //   70: invokevirtual 204	android/media/MediaPlayer:setLooping	(Z)V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 56	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: new 206	java/io/FileInputStream
    //   81: dup
    //   82: new 208	java/io/File
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 209	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: astore_3
    //   94: aload_3
    //   95: astore_2
    //   96: aload_0
    //   97: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   100: iconst_3
    //   101: invokevirtual 215	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   104: aload_3
    //   105: astore_2
    //   106: aload_0
    //   107: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   110: aload_3
    //   111: invokevirtual 219	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   114: invokevirtual 223	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   117: aload_3
    //   118: astore_2
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield 36	com/tencent/mobileqq/filebrowser/FileViewMusicService:c	Z
    //   124: aload_3
    //   125: astore_2
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 34	com/tencent/mobileqq/filebrowser/FileViewMusicService:b	Z
    //   131: aload_3
    //   132: astore_2
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 152	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_Int	I
    //   138: aload_3
    //   139: astore_2
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 38	com/tencent/mobileqq/filebrowser/FileViewMusicService:d	Z
    //   145: aload_3
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 141	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   151: ifnonnull +52 -> 203
    //   154: aload_3
    //   155: astore_2
    //   156: aload_0
    //   157: new 225	com/tencent/mobileqq/filebrowser/FileViewMusicService$2
    //   160: dup
    //   161: aload_0
    //   162: invokespecial 228	com/tencent/mobileqq/filebrowser/FileViewMusicService$2:<init>	(Lcom/tencent/mobileqq/filebrowser/FileViewMusicService;)V
    //   165: putfield 141	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   168: aload_3
    //   169: astore_2
    //   170: new 230	android/content/IntentFilter
    //   173: dup
    //   174: invokespecial 231	android/content/IntentFilter:<init>	()V
    //   177: astore 4
    //   179: aload_3
    //   180: astore_2
    //   181: aload 4
    //   183: ldc 233
    //   185: invokevirtual 236	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   188: aload_3
    //   189: astore_2
    //   190: invokestatic 68	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   193: aload_0
    //   194: getfield 141	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   197: aload 4
    //   199: invokevirtual 240	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   202: pop
    //   203: aload_3
    //   204: astore_2
    //   205: aload_0
    //   206: getfield 92	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   209: invokevirtual 243	android/media/MediaPlayer:prepareAsync	()V
    //   212: aload_3
    //   213: invokevirtual 246	java/io/FileInputStream:close	()V
    //   216: goto +8 -> 224
    //   219: astore_2
    //   220: aload_2
    //   221: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   224: aload_0
    //   225: aload_1
    //   226: putfield 56	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: iconst_1
    //   230: ireturn
    //   231: astore_2
    //   232: aload_3
    //   233: astore_1
    //   234: aload_2
    //   235: astore_3
    //   236: goto +23 -> 259
    //   239: astore_1
    //   240: goto +122 -> 362
    //   243: astore_1
    //   244: goto +220 -> 464
    //   247: astore_1
    //   248: goto +312 -> 560
    //   251: astore_1
    //   252: goto +402 -> 654
    //   255: astore_3
    //   256: aload 4
    //   258: astore_1
    //   259: aload_1
    //   260: astore_2
    //   261: aload_0
    //   262: getfield 158	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   265: ifnull +22 -> 287
    //   268: aload_1
    //   269: astore_2
    //   270: aload_0
    //   271: getfield 158	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   274: invokestatic 68	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   277: ldc 250
    //   279: invokevirtual 113	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   282: invokeinterface 254 2 0
    //   287: aload_1
    //   288: astore_2
    //   289: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +50 -> 342
    //   295: aload_1
    //   296: astore_2
    //   297: new 118	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   304: astore 4
    //   306: aload_1
    //   307: astore_2
    //   308: aload 4
    //   310: ldc_w 256
    //   313: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_1
    //   318: astore_2
    //   319: aload 4
    //   321: aload_3
    //   322: invokevirtual 257	java/io/IOException:toString	()Ljava/lang/String;
    //   325: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_1
    //   330: astore_2
    //   331: ldc 82
    //   333: iconst_2
    //   334: aload 4
    //   336: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: aload_1
    //   343: ifnull +14 -> 357
    //   346: aload_1
    //   347: invokevirtual 246	java/io/FileInputStream:close	()V
    //   350: iconst_0
    //   351: ireturn
    //   352: astore_1
    //   353: aload_1
    //   354: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   357: iconst_0
    //   358: ireturn
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_3
    //   362: aload_3
    //   363: astore_2
    //   364: aload_0
    //   365: getfield 158	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   368: ifnull +15 -> 383
    //   371: aload_3
    //   372: astore_2
    //   373: aload_0
    //   374: getfield 158	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   377: aconst_null
    //   378: invokeinterface 254 2 0
    //   383: aload_3
    //   384: astore_2
    //   385: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +50 -> 438
    //   391: aload_3
    //   392: astore_2
    //   393: new 118	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   400: astore 4
    //   402: aload_3
    //   403: astore_2
    //   404: aload 4
    //   406: ldc_w 259
    //   409: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload_3
    //   414: astore_2
    //   415: aload 4
    //   417: aload_1
    //   418: invokevirtual 260	java/lang/IllegalStateException:toString	()Ljava/lang/String;
    //   421: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_3
    //   426: astore_2
    //   427: ldc 82
    //   429: iconst_2
    //   430: aload 4
    //   432: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload_3
    //   439: astore_2
    //   440: aload_1
    //   441: invokevirtual 261	java/lang/IllegalStateException:printStackTrace	()V
    //   444: aload_3
    //   445: ifnull +14 -> 459
    //   448: aload_3
    //   449: invokevirtual 246	java/io/FileInputStream:close	()V
    //   452: iconst_0
    //   453: ireturn
    //   454: astore_1
    //   455: aload_1
    //   456: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   459: iconst_0
    //   460: ireturn
    //   461: astore_1
    //   462: aconst_null
    //   463: astore_3
    //   464: aload_3
    //   465: astore_2
    //   466: aload_0
    //   467: getfield 158	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   470: ifnull +15 -> 485
    //   473: aload_3
    //   474: astore_2
    //   475: aload_0
    //   476: getfield 158	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   479: aconst_null
    //   480: invokeinterface 254 2 0
    //   485: aload_3
    //   486: astore_2
    //   487: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   490: ifeq +50 -> 540
    //   493: aload_3
    //   494: astore_2
    //   495: new 118	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   502: astore 4
    //   504: aload_3
    //   505: astore_2
    //   506: aload 4
    //   508: ldc_w 263
    //   511: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_3
    //   516: astore_2
    //   517: aload 4
    //   519: aload_1
    //   520: invokevirtual 264	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   523: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_3
    //   528: astore_2
    //   529: ldc 82
    //   531: iconst_2
    //   532: aload 4
    //   534: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: aload_3
    //   541: ifnull +14 -> 555
    //   544: aload_3
    //   545: invokevirtual 246	java/io/FileInputStream:close	()V
    //   548: iconst_0
    //   549: ireturn
    //   550: astore_1
    //   551: aload_1
    //   552: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   555: iconst_0
    //   556: ireturn
    //   557: astore_1
    //   558: aconst_null
    //   559: astore_3
    //   560: aload_3
    //   561: astore_2
    //   562: aload_0
    //   563: getfield 158	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   566: ifnull +15 -> 581
    //   569: aload_3
    //   570: astore_2
    //   571: aload_0
    //   572: getfield 158	com/tencent/mobileqq/filebrowser/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent	Lcom/tencent/mobileqq/filebrowser/FileViewMusicService$IFileViewMusicEvent;
    //   575: aconst_null
    //   576: invokeinterface 254 2 0
    //   581: aload_3
    //   582: astore_2
    //   583: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq +50 -> 636
    //   589: aload_3
    //   590: astore_2
    //   591: new 118	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   598: astore 4
    //   600: aload_3
    //   601: astore_2
    //   602: aload 4
    //   604: ldc_w 266
    //   607: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload_3
    //   612: astore_2
    //   613: aload 4
    //   615: aload_1
    //   616: invokevirtual 267	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   619: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload_3
    //   624: astore_2
    //   625: ldc 82
    //   627: iconst_2
    //   628: aload 4
    //   630: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: aload_3
    //   637: ifnull +14 -> 651
    //   640: aload_3
    //   641: invokevirtual 246	java/io/FileInputStream:close	()V
    //   644: iconst_0
    //   645: ireturn
    //   646: astore_1
    //   647: aload_1
    //   648: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   651: iconst_0
    //   652: ireturn
    //   653: astore_1
    //   654: aload_2
    //   655: ifnull +15 -> 670
    //   658: aload_2
    //   659: invokevirtual 246	java/io/FileInputStream:close	()V
    //   662: goto +8 -> 670
    //   665: astore_2
    //   666: aload_2
    //   667: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   670: aload_1
    //   671: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	this	FileViewMusicService
    //   0	672	1	paramString	String
    //   9	196	2	localObject1	Object
    //   219	2	2	localIOException1	java.io.IOException
    //   231	4	2	localIOException2	java.io.IOException
    //   260	399	2	localObject2	Object
    //   665	2	2	localIOException3	java.io.IOException
    //   4	232	3	localObject3	Object
    //   255	67	3	localIOException4	java.io.IOException
    //   361	280	3	localObject4	Object
    //   6	623	4	localObject5	Object
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
    //   308	317	251	finally
    //   319	329	251	finally
    //   331	342	251	finally
    //   78	94	255	java/io/IOException
    //   346	350	352	java/io/IOException
    //   78	94	359	java/lang/IllegalStateException
    //   448	452	454	java/io/IOException
    //   78	94	461	java/lang/SecurityException
    //   544	548	550	java/io/IOException
    //   78	94	557	java/lang/IllegalArgumentException
    //   640	644	646	java/io/IOException
    //   96	104	653	finally
    //   106	117	653	finally
    //   119	124	653	finally
    //   126	131	653	finally
    //   133	138	653	finally
    //   140	145	653	finally
    //   147	154	653	finally
    //   156	168	653	finally
    //   170	179	653	finally
    //   181	188	653	finally
    //   190	203	653	finally
    //   205	212	653	finally
    //   364	371	653	finally
    //   373	383	653	finally
    //   385	391	653	finally
    //   393	402	653	finally
    //   404	413	653	finally
    //   415	425	653	finally
    //   427	438	653	finally
    //   440	444	653	finally
    //   466	473	653	finally
    //   475	485	653	finally
    //   487	493	653	finally
    //   495	504	653	finally
    //   506	515	653	finally
    //   517	527	653	finally
    //   529	540	653	finally
    //   562	569	653	finally
    //   571	581	653	finally
    //   583	589	653	finally
    //   591	600	653	finally
    //   602	611	653	finally
    //   613	623	653	finally
    //   625	636	653	finally
    //   658	662	665	java/io/IOException
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.c = true;
    f();
  }
  
  public boolean b(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    return (str != null) && (str.equalsIgnoreCase(paramString));
  }
  
  public void c()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplication.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
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
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void d()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
      try
      {
        if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
        {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
          return;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
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
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        a();
      }
    }
    else
    {
      MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if (localMediaPlayer != null) {
        localMediaPlayer.setVolume(0.1F, 0.1F);
      }
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.ah_();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplication.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    this.jdField_a_of_type_Boolean = false;
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
    paramMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileViewMusicService$IFileViewMusicEvent;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a(BaseApplication.getContext().getString(2131692470));
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplication.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.b = true;
    f();
    paramMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((paramMediaPlayer != null) && (this.d)) {
      paramMediaPlayer.seekTo(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileViewMusicService
 * JD-Core Version:    0.7.0.1
 */