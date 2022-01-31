package com.tencent.mobileqq.filemanager.fileviewer;

import acsc;
import android.content.BroadcastReceiver;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class FileViewMusicService
  implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder = null;
  IFileViewMusicEvent jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent;
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString = "FileViewMusicService<FileAssistant>";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public static FileViewMusicService a()
  {
    FileViewMusicService localFileViewMusicService1 = null;
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {
      localFileViewMusicService1 = (FileViewMusicService)jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    FileViewMusicService localFileViewMusicService2 = localFileViewMusicService1;
    if (localFileViewMusicService1 == null)
    {
      localFileViewMusicService2 = new FileViewMusicService();
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localFileViewMusicService2);
    }
    return localFileViewMusicService2;
  }
  
  private void f()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {}
    label99:
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0)) {
              break label99;
            }
            if (!QLog.isDevelopLevel()) {
              break;
            }
            throw new NullPointerException("没有初始化");
          }
          catch (Exception localException1) {}
        } while (!QLog.isColorLevel());
        QLog.e("FileViewMusicService<FileAssistant>", 2, "musicPathString not init " + localException1.toString());
        return;
      } while (!QLog.isColorLevel());
      QLog.e("FileViewMusicService<FileAssistant>", 2, "musci path not init!");
      return;
      if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
      {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
        return;
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      try
      {
        ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a(true, 25, Boolean.valueOf(true));
        return;
      }
      catch (Exception localException2) {}
    } while (!QLog.isColorLevel());
    QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public String a()
  {
    return FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a(true, 25, Boolean.valueOf(true));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.d = true;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(IFileViewMusicEvent paramIFileViewMusicEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent = paramIFileViewMusicEvent;
  }
  
  public void a(String paramString, FileViewMusicService.IGetTotalTime paramIGetTotalTime)
  {
    ThreadManager.executeOnSubThread(new acsc(this, paramString, paramIGetTotalTime));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +22 -> 28
    //   9: aload_0
    //   10: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   13: invokevirtual 215	android/media/MediaPlayer:stop	()V
    //   16: aload_0
    //   17: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   20: invokevirtual 218	android/media/MediaPlayer:release	()V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   28: aload_0
    //   29: new 127	android/media/MediaPlayer
    //   32: dup
    //   33: invokespecial 219	android/media/MediaPlayer:<init>	()V
    //   36: putfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   39: aload_0
    //   40: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   43: aload_0
    //   44: invokevirtual 223	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   47: aload_0
    //   48: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   51: aload_0
    //   52: invokevirtual 227	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   55: aload_0
    //   56: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   59: aload_0
    //   60: invokevirtual 231	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   63: aload_0
    //   64: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   67: iconst_0
    //   68: invokevirtual 235	android/media/MediaPlayer:setLooping	(Z)V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 57	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   76: new 237	java/io/FileInputStream
    //   79: dup
    //   80: new 239	java/io/File
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokespecial 243	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore 4
    //   93: aload 4
    //   95: astore_3
    //   96: aload_0
    //   97: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   100: iconst_3
    //   101: invokevirtual 246	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   104: aload 4
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   111: aload 4
    //   113: invokevirtual 250	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   116: invokevirtual 254	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   119: aload 4
    //   121: astore_3
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 55	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:c	Z
    //   127: aload 4
    //   129: astore_3
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_b_of_type_Boolean	Z
    //   135: aload 4
    //   137: astore_3
    //   138: aload_0
    //   139: iconst_0
    //   140: putfield 183	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_Int	I
    //   143: aload 4
    //   145: astore_3
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 185	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:d	Z
    //   151: aload 4
    //   153: astore_3
    //   154: aload_0
    //   155: getfield 172	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   158: ifnonnull +57 -> 215
    //   161: aload 4
    //   163: astore_3
    //   164: aload_0
    //   165: new 256	acse
    //   168: dup
    //   169: aload_0
    //   170: invokespecial 259	acse:<init>	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)V
    //   173: putfield 172	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   176: aload 4
    //   178: astore_3
    //   179: new 261	android/content/IntentFilter
    //   182: dup
    //   183: invokespecial 262	android/content/IntentFilter:<init>	()V
    //   186: astore 5
    //   188: aload 4
    //   190: astore_3
    //   191: aload 5
    //   193: ldc_w 264
    //   196: invokevirtual 267	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   199: aload 4
    //   201: astore_3
    //   202: invokestatic 105	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   205: aload_0
    //   206: getfield 172	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   209: aload 5
    //   211: invokevirtual 271	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   214: pop
    //   215: aload 4
    //   217: astore_3
    //   218: aload_0
    //   219: getfield 123	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   222: invokevirtual 274	android/media/MediaPlayer:prepareAsync	()V
    //   225: aload 4
    //   227: ifnull +8 -> 235
    //   230: aload 4
    //   232: invokevirtual 277	java/io/FileInputStream:close	()V
    //   235: aload_0
    //   236: aload_1
    //   237: putfield 57	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: iconst_1
    //   241: istore_2
    //   242: iload_2
    //   243: ireturn
    //   244: astore_3
    //   245: aload_3
    //   246: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   249: goto -14 -> 235
    //   252: astore_1
    //   253: aconst_null
    //   254: astore 4
    //   256: aload 4
    //   258: astore_3
    //   259: aload_0
    //   260: getfield 191	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent	Lcom/tencent/mobileqq/filemanager/fileviewer/IFileViewMusicEvent;
    //   263: ifnull +16 -> 279
    //   266: aload 4
    //   268: astore_3
    //   269: aload_0
    //   270: getfield 191	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent	Lcom/tencent/mobileqq/filemanager/fileviewer/IFileViewMusicEvent;
    //   273: aconst_null
    //   274: invokeinterface 284 2 0
    //   279: aload 4
    //   281: astore_3
    //   282: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +35 -> 320
    //   288: aload 4
    //   290: astore_3
    //   291: ldc 30
    //   293: iconst_2
    //   294: new 81	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 286
    //   304: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 287	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   311: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload 4
    //   322: ifnull -80 -> 242
    //   325: aload 4
    //   327: invokevirtual 277	java/io/FileInputStream:close	()V
    //   330: iconst_0
    //   331: ireturn
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   337: iconst_0
    //   338: ireturn
    //   339: astore_1
    //   340: aconst_null
    //   341: astore 4
    //   343: aload 4
    //   345: astore_3
    //   346: aload_0
    //   347: getfield 191	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent	Lcom/tencent/mobileqq/filemanager/fileviewer/IFileViewMusicEvent;
    //   350: ifnull +16 -> 366
    //   353: aload 4
    //   355: astore_3
    //   356: aload_0
    //   357: getfield 191	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent	Lcom/tencent/mobileqq/filemanager/fileviewer/IFileViewMusicEvent;
    //   360: aconst_null
    //   361: invokeinterface 284 2 0
    //   366: aload 4
    //   368: astore_3
    //   369: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +35 -> 407
    //   375: aload 4
    //   377: astore_3
    //   378: ldc 30
    //   380: iconst_2
    //   381: new 81	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 289
    //   391: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_1
    //   395: invokevirtual 290	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   398: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 4
    //   409: ifnull -167 -> 242
    //   412: aload 4
    //   414: invokevirtual 277	java/io/FileInputStream:close	()V
    //   417: iconst_0
    //   418: ireturn
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   424: iconst_0
    //   425: ireturn
    //   426: astore_1
    //   427: aconst_null
    //   428: astore 4
    //   430: aload 4
    //   432: astore_3
    //   433: aload_0
    //   434: getfield 191	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent	Lcom/tencent/mobileqq/filemanager/fileviewer/IFileViewMusicEvent;
    //   437: ifnull +16 -> 453
    //   440: aload 4
    //   442: astore_3
    //   443: aload_0
    //   444: getfield 191	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent	Lcom/tencent/mobileqq/filemanager/fileviewer/IFileViewMusicEvent;
    //   447: aconst_null
    //   448: invokeinterface 284 2 0
    //   453: aload 4
    //   455: astore_3
    //   456: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +35 -> 494
    //   462: aload 4
    //   464: astore_3
    //   465: ldc 30
    //   467: iconst_2
    //   468: new 81	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   475: ldc_w 292
    //   478: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_1
    //   482: invokevirtual 293	java/lang/IllegalStateException:toString	()Ljava/lang/String;
    //   485: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: aload 4
    //   496: astore_3
    //   497: aload_1
    //   498: invokevirtual 294	java/lang/IllegalStateException:printStackTrace	()V
    //   501: aload 4
    //   503: ifnull -261 -> 242
    //   506: aload 4
    //   508: invokevirtual 277	java/io/FileInputStream:close	()V
    //   511: iconst_0
    //   512: ireturn
    //   513: astore_1
    //   514: aload_1
    //   515: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   518: iconst_0
    //   519: ireturn
    //   520: astore_1
    //   521: aconst_null
    //   522: astore 4
    //   524: aload 4
    //   526: astore_3
    //   527: aload_0
    //   528: getfield 191	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent	Lcom/tencent/mobileqq/filemanager/fileviewer/IFileViewMusicEvent;
    //   531: ifnull +18 -> 549
    //   534: aload 4
    //   536: astore_3
    //   537: aload_0
    //   538: getfield 191	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent	Lcom/tencent/mobileqq/filemanager/fileviewer/IFileViewMusicEvent;
    //   541: ldc_w 296
    //   544: invokeinterface 284 2 0
    //   549: aload 4
    //   551: astore_3
    //   552: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +35 -> 590
    //   558: aload 4
    //   560: astore_3
    //   561: ldc 30
    //   563: iconst_2
    //   564: new 81	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 298
    //   574: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_1
    //   578: invokevirtual 299	java/io/IOException:toString	()Ljava/lang/String;
    //   581: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: aload 4
    //   592: ifnull -350 -> 242
    //   595: aload 4
    //   597: invokevirtual 277	java/io/FileInputStream:close	()V
    //   600: iconst_0
    //   601: ireturn
    //   602: astore_1
    //   603: aload_1
    //   604: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   607: iconst_0
    //   608: ireturn
    //   609: astore_1
    //   610: aconst_null
    //   611: astore_3
    //   612: aload_3
    //   613: ifnull +7 -> 620
    //   616: aload_3
    //   617: invokevirtual 277	java/io/FileInputStream:close	()V
    //   620: aload_1
    //   621: athrow
    //   622: astore_3
    //   623: aload_3
    //   624: invokevirtual 280	java/io/IOException:printStackTrace	()V
    //   627: goto -7 -> 620
    //   630: astore_1
    //   631: goto -19 -> 612
    //   634: astore_1
    //   635: goto -111 -> 524
    //   638: astore_1
    //   639: goto -209 -> 430
    //   642: astore_1
    //   643: goto -300 -> 343
    //   646: astore_1
    //   647: goto -391 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	FileViewMusicService
    //   0	650	1	paramString	String
    //   1	242	2	bool	boolean
    //   95	123	3	localFileInputStream1	java.io.FileInputStream
    //   244	2	3	localIOException1	java.io.IOException
    //   258	359	3	localFileInputStream2	java.io.FileInputStream
    //   622	2	3	localIOException2	java.io.IOException
    //   91	505	4	localFileInputStream3	java.io.FileInputStream
    //   186	24	5	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   230	235	244	java/io/IOException
    //   76	93	252	java/lang/IllegalArgumentException
    //   325	330	332	java/io/IOException
    //   76	93	339	java/lang/SecurityException
    //   412	417	419	java/io/IOException
    //   76	93	426	java/lang/IllegalStateException
    //   506	511	513	java/io/IOException
    //   76	93	520	java/io/IOException
    //   595	600	602	java/io/IOException
    //   76	93	609	finally
    //   616	620	622	java/io/IOException
    //   96	104	630	finally
    //   107	119	630	finally
    //   122	127	630	finally
    //   130	135	630	finally
    //   138	143	630	finally
    //   146	151	630	finally
    //   154	161	630	finally
    //   164	176	630	finally
    //   179	188	630	finally
    //   191	199	630	finally
    //   202	215	630	finally
    //   218	225	630	finally
    //   259	266	630	finally
    //   269	279	630	finally
    //   282	288	630	finally
    //   291	320	630	finally
    //   346	353	630	finally
    //   356	366	630	finally
    //   369	375	630	finally
    //   378	407	630	finally
    //   433	440	630	finally
    //   443	453	630	finally
    //   456	462	630	finally
    //   465	494	630	finally
    //   497	501	630	finally
    //   527	534	630	finally
    //   537	549	630	finally
    //   552	558	630	finally
    //   561	590	630	finally
    //   96	104	634	java/io/IOException
    //   107	119	634	java/io/IOException
    //   122	127	634	java/io/IOException
    //   130	135	634	java/io/IOException
    //   138	143	634	java/io/IOException
    //   146	151	634	java/io/IOException
    //   154	161	634	java/io/IOException
    //   164	176	634	java/io/IOException
    //   179	188	634	java/io/IOException
    //   191	199	634	java/io/IOException
    //   202	215	634	java/io/IOException
    //   218	225	634	java/io/IOException
    //   96	104	638	java/lang/IllegalStateException
    //   107	119	638	java/lang/IllegalStateException
    //   122	127	638	java/lang/IllegalStateException
    //   130	135	638	java/lang/IllegalStateException
    //   138	143	638	java/lang/IllegalStateException
    //   146	151	638	java/lang/IllegalStateException
    //   154	161	638	java/lang/IllegalStateException
    //   164	176	638	java/lang/IllegalStateException
    //   179	188	638	java/lang/IllegalStateException
    //   191	199	638	java/lang/IllegalStateException
    //   202	215	638	java/lang/IllegalStateException
    //   218	225	638	java/lang/IllegalStateException
    //   96	104	642	java/lang/SecurityException
    //   107	119	642	java/lang/SecurityException
    //   122	127	642	java/lang/SecurityException
    //   130	135	642	java/lang/SecurityException
    //   138	143	642	java/lang/SecurityException
    //   146	151	642	java/lang/SecurityException
    //   154	161	642	java/lang/SecurityException
    //   164	176	642	java/lang/SecurityException
    //   179	188	642	java/lang/SecurityException
    //   191	199	642	java/lang/SecurityException
    //   202	215	642	java/lang/SecurityException
    //   218	225	642	java/lang/SecurityException
    //   96	104	646	java/lang/IllegalArgumentException
    //   107	119	646	java/lang/IllegalArgumentException
    //   122	127	646	java/lang/IllegalArgumentException
    //   130	135	646	java/lang/IllegalArgumentException
    //   138	143	646	java/lang/IllegalArgumentException
    //   146	151	646	java/lang/IllegalArgumentException
    //   154	161	646	java/lang/IllegalArgumentException
    //   164	176	646	java/lang/IllegalArgumentException
    //   179	188	646	java/lang/IllegalArgumentException
    //   191	199	646	java/lang/IllegalArgumentException
    //   202	215	646	java/lang/IllegalArgumentException
    //   218	225	646	java/lang/IllegalArgumentException
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.c = true;
    f();
  }
  
  public boolean b(String paramString)
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString) == true);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    try
    {
      if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not abandon audio focus");
      }
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a(true, 25, Boolean.valueOf(true));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
        }
      }
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
      try
      {
        if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
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
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
      a();
      return;
    } while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(0.1F, 0.1F);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.Z_();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a(true, 25, Boolean.valueOf(true));
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
        }
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "what[" + paramInt1 + "],extra[" + paramInt2 + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewMusicEvent.a("系统资源不足，文件解码失败！请稍后再试。");
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a(true, 25, Boolean.valueOf(true));
      return true;
    }
    catch (Exception paramMediaPlayer)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
    }
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.jdField_b_of_type_Boolean = true;
    f();
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.d)) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService
 * JD-Core Version:    0.7.0.1
 */