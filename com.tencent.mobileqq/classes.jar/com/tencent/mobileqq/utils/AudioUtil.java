package com.tencent.mobileqq.utils;

import ajni;
import ajnj;
import ajnk;
import ajnm;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.IOException;
import mqq.app.AppRuntime;

public class AudioUtil
{
  private static int a;
  public static MediaPlayer a;
  
  public static int a()
  {
    return ((AudioManager)BaseApplicationImpl.sApplication.getSystemService("audio")).getRingerMode();
  }
  
  private static MediaPlayer a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getResources().openRawResourceFd(paramInt);
      if (paramContext == null) {
        return null;
      }
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
      paramContext.close();
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramContext);
      }
    }
    return null;
  }
  
  private static MediaPlayer a(Context paramContext, Uri paramUri)
  {
    try
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext, paramUri);
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramContext);
      }
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      label12:
      jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      a(paramInt1, paramInt2, paramOnCompletionListener, null);
      return;
    }
    finally
    {
      paramOnCompletionListener = finally;
      throw paramOnCompletionListener;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener, Handler paramHandler)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        boolean bool = jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (paramOnCompletionListener == null) {
          continue;
        }
        if ((paramHandler != null) && (paramHandler.getLooper() != Looper.myLooper())) {
          break label154;
        }
        paramOnCompletionListener.onCompletion(jdField_a_of_type_AndroidMediaMediaPlayer);
        continue;
      }
      finally {}
      return;
      a();
      if (paramInt1 != AppSetting.e)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, paramInt1);
        if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          jdField_a_of_type_Int = paramInt2;
          if (jdField_a_of_type_Int != 0) {
            jdField_a_of_type_Int -= 1;
          }
          jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new ajnk(paramOnCompletionListener, paramHandler));
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      continue;
      label154:
      paramHandler.post(new ajnm(paramOnCompletionListener));
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("mediaPlayerStartForMsg", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is playing");
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer exception", localException1);
        continue;
      }
      finally {}
      return;
      try
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer release exception", localException2);
        label167:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.e)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplicationImpl.sApplication, paramInt);
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is null");
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("mediaPlayerStartForMsg", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new ajni());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  private static void a(MediaPlayer paramMediaPlayer)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      paramMediaPlayer.setAudioStreamType(3);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MediaPlayerStart", 2, "get QQAppInterface error");
  }
  
  /* Error */
  public static void a(Uri paramUri, int paramInt, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 5
    //   12: aload 7
    //   14: astore 6
    //   16: aload 8
    //   18: astore 4
    //   20: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: ifnull +63 -> 86
    //   26: aload 7
    //   28: astore 6
    //   30: aload 8
    //   32: astore 4
    //   34: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   37: invokevirtual 106	android/media/MediaPlayer:isPlaying	()Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifeq +33 -> 75
    //   45: iconst_0
    //   46: ifeq +11 -> 57
    //   49: new 239	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 240	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: ldc 2
    //   59: monitorexit
    //   60: return
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   66: goto -9 -> 57
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    //   75: aload 7
    //   77: astore 6
    //   79: aload 8
    //   81: astore 4
    //   83: invokestatic 108	com/tencent/mobileqq/utils/AudioUtil:a	()V
    //   86: aload 7
    //   88: astore 6
    //   90: aload 8
    //   92: astore 4
    //   94: aload_0
    //   95: invokevirtual 248	android/net/Uri:getScheme	()Ljava/lang/String;
    //   98: ldc 250
    //   100: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifeq +67 -> 170
    //   106: aload 7
    //   108: astore 6
    //   110: aload 8
    //   112: astore 4
    //   114: new 47	android/media/MediaPlayer
    //   117: dup
    //   118: invokespecial 48	android/media/MediaPlayer:<init>	()V
    //   121: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   124: aload 7
    //   126: astore 6
    //   128: aload 8
    //   130: astore 4
    //   132: new 258	java/io/FileInputStream
    //   135: dup
    //   136: new 260	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokevirtual 263	android/net/Uri:getPath	()Ljava/lang/String;
    //   144: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: invokespecial 269	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   150: astore_0
    //   151: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   154: aload_0
    //   155: invokevirtual 272	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   158: invokevirtual 275	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   161: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   164: invokevirtual 74	android/media/MediaPlayer:prepare	()V
    //   167: aload_0
    //   168: astore 5
    //   170: aload 5
    //   172: astore 6
    //   174: aload 5
    //   176: astore 4
    //   178: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   181: astore_0
    //   182: aload_0
    //   183: ifnonnull +24 -> 207
    //   186: aload 5
    //   188: ifnull -131 -> 57
    //   191: aload 5
    //   193: invokevirtual 276	java/io/FileInputStream:close	()V
    //   196: goto -139 -> 57
    //   199: astore_0
    //   200: aload_0
    //   201: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   204: goto -147 -> 57
    //   207: aload 5
    //   209: astore 6
    //   211: aload 5
    //   213: astore 4
    //   215: iload_1
    //   216: putstatic 118	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   219: aload 5
    //   221: astore 6
    //   223: aload 5
    //   225: astore 4
    //   227: getstatic 118	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   230: ifeq +19 -> 249
    //   233: aload 5
    //   235: astore 6
    //   237: aload 5
    //   239: astore 4
    //   241: getstatic 118	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   244: iconst_1
    //   245: isub
    //   246: putstatic 118	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   249: aload 5
    //   251: astore 6
    //   253: aload 5
    //   255: astore 4
    //   257: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   260: new 278	ajno
    //   263: dup
    //   264: aload_2
    //   265: invokespecial 279	ajno:<init>	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   268: invokevirtual 127	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   271: aload 5
    //   273: astore 6
    //   275: aload 5
    //   277: astore 4
    //   279: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   282: invokevirtual 130	android/media/MediaPlayer:start	()V
    //   285: aload 5
    //   287: astore 6
    //   289: aload 5
    //   291: astore 4
    //   293: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   296: iconst_0
    //   297: invokevirtual 134	android/media/MediaPlayer:setLooping	(Z)V
    //   300: aload 5
    //   302: ifnull -245 -> 57
    //   305: aload 5
    //   307: invokevirtual 276	java/io/FileInputStream:close	()V
    //   310: goto -253 -> 57
    //   313: astore_0
    //   314: aload_0
    //   315: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   318: goto -261 -> 57
    //   321: astore_0
    //   322: aload 6
    //   324: astore 4
    //   326: aload_0
    //   327: invokevirtual 280	java/lang/Exception:printStackTrace	()V
    //   330: aload 6
    //   332: ifnull -275 -> 57
    //   335: aload 6
    //   337: invokevirtual 276	java/io/FileInputStream:close	()V
    //   340: goto -283 -> 57
    //   343: astore_0
    //   344: aload_0
    //   345: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   348: goto -291 -> 57
    //   351: astore_0
    //   352: aload 4
    //   354: ifnull +8 -> 362
    //   357: aload 4
    //   359: invokevirtual 276	java/io/FileInputStream:close	()V
    //   362: aload_0
    //   363: athrow
    //   364: astore_2
    //   365: aload_2
    //   366: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   369: goto -7 -> 362
    //   372: astore_2
    //   373: aload_0
    //   374: astore 4
    //   376: aload_2
    //   377: astore_0
    //   378: goto -26 -> 352
    //   381: astore_2
    //   382: aload_0
    //   383: astore 6
    //   385: aload_2
    //   386: astore_0
    //   387: goto -65 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramUri	Uri
    //   0	390	1	paramInt	int
    //   0	390	2	paramOnCompletionListener	MediaPlayer.OnCompletionListener
    //   40	2	3	bool	boolean
    //   18	357	4	localObject1	Object
    //   10	296	5	localUri	Uri
    //   14	370	6	localObject2	Object
    //   4	121	7	localObject3	Object
    //   7	122	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	61	java/io/IOException
    //   49	57	69	finally
    //   62	66	69	finally
    //   191	196	69	finally
    //   200	204	69	finally
    //   305	310	69	finally
    //   314	318	69	finally
    //   335	340	69	finally
    //   344	348	69	finally
    //   357	362	69	finally
    //   362	364	69	finally
    //   365	369	69	finally
    //   191	196	199	java/io/IOException
    //   305	310	313	java/io/IOException
    //   20	26	321	java/lang/Exception
    //   34	41	321	java/lang/Exception
    //   83	86	321	java/lang/Exception
    //   94	106	321	java/lang/Exception
    //   114	124	321	java/lang/Exception
    //   132	151	321	java/lang/Exception
    //   178	182	321	java/lang/Exception
    //   215	219	321	java/lang/Exception
    //   227	233	321	java/lang/Exception
    //   241	249	321	java/lang/Exception
    //   257	271	321	java/lang/Exception
    //   279	285	321	java/lang/Exception
    //   293	300	321	java/lang/Exception
    //   335	340	343	java/io/IOException
    //   20	26	351	finally
    //   34	41	351	finally
    //   83	86	351	finally
    //   94	106	351	finally
    //   114	124	351	finally
    //   132	151	351	finally
    //   178	182	351	finally
    //   215	219	351	finally
    //   227	233	351	finally
    //   241	249	351	finally
    //   257	271	351	finally
    //   279	285	351	finally
    //   293	300	351	finally
    //   326	330	351	finally
    //   357	362	364	java/io/IOException
    //   151	167	372	finally
    //   151	167	381	java/lang/Exception
  }
  
  /* Error */
  public static void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +13 -> 25
    //   15: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: invokevirtual 99	android/media/MediaPlayer:release	()V
    //   21: aconst_null
    //   22: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   25: aload_0
    //   26: invokevirtual 248	android/net/Uri:getScheme	()Ljava/lang/String;
    //   29: ldc 250
    //   31: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +195 -> 229
    //   37: new 47	android/media/MediaPlayer
    //   40: dup
    //   41: invokespecial 48	android/media/MediaPlayer:<init>	()V
    //   44: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   47: iload_2
    //   48: ifeq +25 -> 73
    //   51: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc_w 283
    //   60: iconst_2
    //   61: ldc_w 285
    //   64: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   70: invokestatic 51	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   73: new 258	java/io/FileInputStream
    //   76: dup
    //   77: new 260	java/io/File
    //   80: dup
    //   81: aload_0
    //   82: invokevirtual 263	android/net/Uri:getPath	()Ljava/lang/String;
    //   85: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokespecial 269	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_0
    //   92: aload_0
    //   93: astore_3
    //   94: aload_0
    //   95: astore 4
    //   97: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   100: aload_0
    //   101: invokevirtual 272	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   104: invokevirtual 275	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   107: aload_0
    //   108: astore_3
    //   109: aload_0
    //   110: astore 4
    //   112: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   115: invokevirtual 74	android/media/MediaPlayer:prepare	()V
    //   118: aload_0
    //   119: astore_3
    //   120: aload_0
    //   121: astore 4
    //   123: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   126: new 287	ajnn
    //   129: dup
    //   130: invokespecial 288	ajnn:<init>	()V
    //   133: invokevirtual 127	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   136: aload_0
    //   137: astore_3
    //   138: aload_0
    //   139: astore 4
    //   141: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   144: invokevirtual 130	android/media/MediaPlayer:start	()V
    //   147: aload_0
    //   148: astore_3
    //   149: aload_0
    //   150: astore 4
    //   152: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   155: iload_1
    //   156: invokevirtual 134	android/media/MediaPlayer:setLooping	(Z)V
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 276	java/io/FileInputStream:close	()V
    //   167: ldc 2
    //   169: monitorexit
    //   170: return
    //   171: astore 4
    //   173: aconst_null
    //   174: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   177: goto -152 -> 25
    //   180: astore_0
    //   181: aconst_null
    //   182: astore 4
    //   184: aload 4
    //   186: ifnull -19 -> 167
    //   189: aload 4
    //   191: invokevirtual 276	java/io/FileInputStream:close	()V
    //   194: goto -27 -> 167
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   202: goto -35 -> 167
    //   205: astore_0
    //   206: ldc 2
    //   208: monitorexit
    //   209: aload_0
    //   210: athrow
    //   211: astore_0
    //   212: aconst_null
    //   213: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   216: aload_0
    //   217: athrow
    //   218: astore_0
    //   219: aload_3
    //   220: ifnull +7 -> 227
    //   223: aload_3
    //   224: invokevirtual 276	java/io/FileInputStream:close	()V
    //   227: aload_0
    //   228: athrow
    //   229: getstatic 19	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   232: aload_0
    //   233: invokestatic 158	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   236: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   239: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   242: astore_0
    //   243: aload_0
    //   244: ifnonnull +23 -> 267
    //   247: iconst_0
    //   248: ifeq -81 -> 167
    //   251: new 239	java/lang/NullPointerException
    //   254: dup
    //   255: invokespecial 240	java/lang/NullPointerException:<init>	()V
    //   258: athrow
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   264: goto -97 -> 167
    //   267: iload_2
    //   268: ifeq +25 -> 293
    //   271: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +13 -> 287
    //   277: ldc_w 283
    //   280: iconst_2
    //   281: ldc_w 285
    //   284: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   290: invokestatic 51	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   293: aconst_null
    //   294: astore_0
    //   295: goto -177 -> 118
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   303: goto -136 -> 167
    //   306: astore_3
    //   307: aload_3
    //   308: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   311: goto -84 -> 227
    //   314: astore_0
    //   315: goto -96 -> 219
    //   318: astore_0
    //   319: goto -135 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramUri	Uri
    //   0	322	1	paramBoolean1	boolean
    //   0	322	2	paramBoolean2	boolean
    //   1	223	3	localUri	Uri
    //   306	2	3	localIOException	IOException
    //   8	143	4	localObject1	Object
    //   171	1	4	localException	Exception
    //   182	8	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	171	java/lang/Exception
    //   5	10	180	java/lang/Exception
    //   21	25	180	java/lang/Exception
    //   25	47	180	java/lang/Exception
    //   51	67	180	java/lang/Exception
    //   67	73	180	java/lang/Exception
    //   73	92	180	java/lang/Exception
    //   173	177	180	java/lang/Exception
    //   212	218	180	java/lang/Exception
    //   229	243	180	java/lang/Exception
    //   271	287	180	java/lang/Exception
    //   287	293	180	java/lang/Exception
    //   189	194	197	java/io/IOException
    //   163	167	205	finally
    //   189	194	205	finally
    //   198	202	205	finally
    //   223	227	205	finally
    //   227	229	205	finally
    //   251	259	205	finally
    //   260	264	205	finally
    //   299	303	205	finally
    //   307	311	205	finally
    //   15	21	211	finally
    //   5	10	218	finally
    //   21	25	218	finally
    //   25	47	218	finally
    //   51	67	218	finally
    //   67	73	218	finally
    //   73	92	218	finally
    //   173	177	218	finally
    //   212	218	218	finally
    //   229	243	218	finally
    //   271	287	218	finally
    //   287	293	218	finally
    //   251	259	259	java/io/IOException
    //   163	167	298	java/io/IOException
    //   223	227	306	java/io/IOException
    //   97	107	314	finally
    //   112	118	314	finally
    //   123	136	314	finally
    //   141	147	314	finally
    //   152	159	314	finally
    //   97	107	318	java/lang/Exception
    //   112	118	318	java/lang/Exception
    //   123	136	318	java/lang/Exception
    //   141	147	318	java/lang/Exception
    //   152	159	318	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.lang.String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload 5
    //   11: astore_3
    //   12: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   15: ifnull +60 -> 75
    //   18: aload 5
    //   20: astore_3
    //   21: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: invokevirtual 106	android/media/MediaPlayer:isPlaying	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +33 -> 62
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 239	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 240	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   53: goto -9 -> 44
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    //   62: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   65: invokevirtual 99	android/media/MediaPlayer:release	()V
    //   68: aload 5
    //   70: astore_3
    //   71: aconst_null
    //   72: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   75: aload 5
    //   77: astore_3
    //   78: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   81: ifnonnull +16 -> 97
    //   84: aload 5
    //   86: astore_3
    //   87: new 47	android/media/MediaPlayer
    //   90: dup
    //   91: invokespecial 48	android/media/MediaPlayer:<init>	()V
    //   94: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   97: aload 5
    //   99: astore_3
    //   100: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   103: invokevirtual 292	android/media/MediaPlayer:reset	()V
    //   106: aload 5
    //   108: astore_3
    //   109: new 258	java/io/FileInputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 293	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   121: aload_0
    //   122: invokevirtual 272	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   125: invokevirtual 275	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   128: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   131: invokestatic 51	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   134: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   137: invokevirtual 74	android/media/MediaPlayer:prepare	()V
    //   140: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: new 295	ajnh
    //   146: dup
    //   147: invokespecial 296	ajnh:<init>	()V
    //   150: invokevirtual 127	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   153: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   156: invokevirtual 130	android/media/MediaPlayer:start	()V
    //   159: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   162: iload_1
    //   163: invokevirtual 134	android/media/MediaPlayer:setLooping	(Z)V
    //   166: aload_0
    //   167: ifnull -123 -> 44
    //   170: aload_0
    //   171: invokevirtual 276	java/io/FileInputStream:close	()V
    //   174: goto -130 -> 44
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   182: goto -138 -> 44
    //   185: astore_3
    //   186: aload 5
    //   188: astore_3
    //   189: aconst_null
    //   190: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   193: goto -118 -> 75
    //   196: astore_3
    //   197: aload 4
    //   199: astore_0
    //   200: aload_3
    //   201: astore 4
    //   203: aload_0
    //   204: astore_3
    //   205: aload 4
    //   207: invokevirtual 280	java/lang/Exception:printStackTrace	()V
    //   210: aload_0
    //   211: ifnull -167 -> 44
    //   214: aload_0
    //   215: invokevirtual 276	java/io/FileInputStream:close	()V
    //   218: goto -174 -> 44
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   226: goto -182 -> 44
    //   229: astore_0
    //   230: aload 5
    //   232: astore_3
    //   233: aconst_null
    //   234: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   237: aload 5
    //   239: astore_3
    //   240: aload_0
    //   241: athrow
    //   242: astore_0
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 276	java/io/FileInputStream:close	()V
    //   251: aload_0
    //   252: athrow
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   258: goto -7 -> 251
    //   261: astore 4
    //   263: aload_0
    //   264: astore_3
    //   265: aload 4
    //   267: astore_0
    //   268: goto -25 -> 243
    //   271: astore 4
    //   273: goto -70 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	java.lang.String
    //   0	276	1	paramBoolean	boolean
    //   27	2	2	bool	boolean
    //   11	98	3	localObject1	Object
    //   185	1	3	localException1	Exception
    //   188	1	3	localObject2	Object
    //   196	5	3	localException2	Exception
    //   204	44	3	localObject3	Object
    //   253	2	3	localIOException	IOException
    //   264	1	3	str	java.lang.String
    //   4	202	4	localObject4	Object
    //   261	5	4	localObject5	Object
    //   271	1	4	localException3	Exception
    //   1	237	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	48	java/io/IOException
    //   36	44	56	finally
    //   49	53	56	finally
    //   170	174	56	finally
    //   178	182	56	finally
    //   214	218	56	finally
    //   222	226	56	finally
    //   247	251	56	finally
    //   251	253	56	finally
    //   254	258	56	finally
    //   170	174	177	java/io/IOException
    //   62	68	185	java/lang/Exception
    //   12	18	196	java/lang/Exception
    //   21	28	196	java/lang/Exception
    //   71	75	196	java/lang/Exception
    //   78	84	196	java/lang/Exception
    //   87	97	196	java/lang/Exception
    //   100	106	196	java/lang/Exception
    //   109	118	196	java/lang/Exception
    //   189	193	196	java/lang/Exception
    //   233	237	196	java/lang/Exception
    //   240	242	196	java/lang/Exception
    //   214	218	221	java/io/IOException
    //   62	68	229	finally
    //   12	18	242	finally
    //   21	28	242	finally
    //   71	75	242	finally
    //   78	84	242	finally
    //   87	97	242	finally
    //   100	106	242	finally
    //   109	118	242	finally
    //   189	193	242	finally
    //   205	210	242	finally
    //   233	237	242	finally
    //   240	242	242	finally
    //   247	251	253	java/io/IOException
    //   118	166	261	finally
    //   118	166	271	java/lang/Exception
  }
  
  @TargetApi(8)
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "context is null.");
      }
    }
    do
    {
      return false;
      if (VersionUtils.b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AudioUtil", 2, "Android 2.1 and below can not stop music");
    return false;
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramBoolean) {
      if (paramContext.requestAudioFocus(null, 3, 2) == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "pauseMusic bMute=" + paramBoolean + " result=" + bool);
      }
      return bool;
      bool = false;
      continue;
      try
      {
        int i = paramContext.abandonAudioFocus(null);
        if (i == 1) {
          continue;
        }
        for (;;)
        {
          bool = false;
        }
      }
      catch (NullPointerException paramContext)
      {
        QLog.e("AudioUtil", 1, "caught npe", paramContext);
        bool = false;
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerStart", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("MediaPlayerStart", 2, "media palyer is playing");
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer exception", localException1);
        continue;
      }
      finally {}
      return;
      try
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer release exception", localException2);
        label167:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.e)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, paramInt);
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("MediaPlayerStart", 2, "media palyer is null");
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MediaPlayerStart", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new ajnj());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil
 * JD-Core Version:    0.7.0.1
 */