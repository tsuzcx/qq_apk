package com.tencent.mobileqq.utils;

import akjb;
import akjc;
import akjd;
import akjf;
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
          jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new akjd(paramOnCompletionListener, paramHandler));
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
      paramHandler.post(new akjf(paramOnCompletionListener));
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
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new akjb());
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
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aload 8
    //   14: astore 6
    //   16: aload 7
    //   18: astore 4
    //   20: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: ifnull +63 -> 86
    //   26: aload 8
    //   28: astore 6
    //   30: aload 7
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
    //   75: aload 8
    //   77: astore 6
    //   79: aload 7
    //   81: astore 4
    //   83: invokestatic 108	com/tencent/mobileqq/utils/AudioUtil:a	()V
    //   86: aload 8
    //   88: astore 6
    //   90: aload 7
    //   92: astore 4
    //   94: aload_0
    //   95: invokevirtual 248	android/net/Uri:getScheme	()Ljava/lang/String;
    //   98: ldc 250
    //   100: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifeq +67 -> 170
    //   106: aload 8
    //   108: astore 6
    //   110: aload 7
    //   112: astore 4
    //   114: new 47	android/media/MediaPlayer
    //   117: dup
    //   118: invokespecial 48	android/media/MediaPlayer:<init>	()V
    //   121: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   124: aload 8
    //   126: astore 6
    //   128: aload 7
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
    //   260: new 278	akjh
    //   263: dup
    //   264: aload_2
    //   265: invokespecial 279	akjh:<init>	(Landroid/media/MediaPlayer$OnCompletionListener;)V
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
    //   7	122	7	localObject3	Object
    //   4	121	8	localObject4	Object
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
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +13 -> 24
    //   14: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   17: invokevirtual 99	android/media/MediaPlayer:release	()V
    //   20: aconst_null
    //   21: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: aload_0
    //   25: invokevirtual 248	android/net/Uri:getScheme	()Ljava/lang/String;
    //   28: ldc 250
    //   30: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +193 -> 226
    //   36: new 47	android/media/MediaPlayer
    //   39: dup
    //   40: invokespecial 48	android/media/MediaPlayer:<init>	()V
    //   43: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   46: iload_2
    //   47: ifeq +25 -> 72
    //   50: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +13 -> 66
    //   56: ldc_w 283
    //   59: iconst_2
    //   60: ldc_w 285
    //   63: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   69: invokestatic 51	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   72: new 258	java/io/FileInputStream
    //   75: dup
    //   76: new 260	java/io/File
    //   79: dup
    //   80: aload_0
    //   81: invokevirtual 263	android/net/Uri:getPath	()Ljava/lang/String;
    //   84: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: invokespecial 269	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: astore_0
    //   91: aload_0
    //   92: astore 4
    //   94: aload_0
    //   95: astore_3
    //   96: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   99: aload_0
    //   100: invokevirtual 272	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   103: invokevirtual 275	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   106: aload_0
    //   107: astore 4
    //   109: aload_0
    //   110: astore_3
    //   111: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   114: invokevirtual 74	android/media/MediaPlayer:prepare	()V
    //   117: aload_0
    //   118: astore 4
    //   120: aload_0
    //   121: astore_3
    //   122: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   125: new 287	akjg
    //   128: dup
    //   129: invokespecial 288	akjg:<init>	()V
    //   132: invokevirtual 127	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   135: aload_0
    //   136: astore 4
    //   138: aload_0
    //   139: astore_3
    //   140: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: invokevirtual 130	android/media/MediaPlayer:start	()V
    //   146: aload_0
    //   147: astore 4
    //   149: aload_0
    //   150: astore_3
    //   151: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   154: iload_1
    //   155: invokevirtual 134	android/media/MediaPlayer:setLooping	(Z)V
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 276	java/io/FileInputStream:close	()V
    //   166: ldc 2
    //   168: monitorexit
    //   169: return
    //   170: astore_3
    //   171: aconst_null
    //   172: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   175: goto -151 -> 24
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_3
    //   181: aload_3
    //   182: ifnull -16 -> 166
    //   185: aload_3
    //   186: invokevirtual 276	java/io/FileInputStream:close	()V
    //   189: goto -23 -> 166
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   197: goto -31 -> 166
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    //   206: astore_0
    //   207: aconst_null
    //   208: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   211: aload_0
    //   212: athrow
    //   213: astore_0
    //   214: aload 4
    //   216: ifnull +8 -> 224
    //   219: aload 4
    //   221: invokevirtual 276	java/io/FileInputStream:close	()V
    //   224: aload_0
    //   225: athrow
    //   226: getstatic 19	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   229: aload_0
    //   230: invokestatic 158	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   233: putstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   236: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   239: astore_0
    //   240: aload_0
    //   241: ifnonnull +23 -> 264
    //   244: iconst_0
    //   245: ifeq -79 -> 166
    //   248: new 239	java/lang/NullPointerException
    //   251: dup
    //   252: invokespecial 240	java/lang/NullPointerException:<init>	()V
    //   255: athrow
    //   256: astore_0
    //   257: aload_0
    //   258: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   261: goto -95 -> 166
    //   264: iload_2
    //   265: ifeq +25 -> 290
    //   268: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +13 -> 284
    //   274: ldc_w 283
    //   277: iconst_2
    //   278: ldc_w 285
    //   281: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: getstatic 96	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   287: invokestatic 51	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   290: aconst_null
    //   291: astore_0
    //   292: goto -175 -> 117
    //   295: astore_0
    //   296: aload_0
    //   297: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   300: goto -134 -> 166
    //   303: astore_3
    //   304: aload_3
    //   305: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   308: goto -84 -> 224
    //   311: astore_0
    //   312: goto -98 -> 214
    //   315: astore_0
    //   316: goto -135 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramUri	Uri
    //   0	319	1	paramBoolean1	boolean
    //   0	319	2	paramBoolean2	boolean
    //   9	142	3	localObject1	Object
    //   170	1	3	localException	Exception
    //   180	6	3	localObject2	Object
    //   303	2	3	localIOException	IOException
    //   1	219	4	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   14	20	170	java/lang/Exception
    //   6	10	178	java/lang/Exception
    //   20	24	178	java/lang/Exception
    //   24	46	178	java/lang/Exception
    //   50	66	178	java/lang/Exception
    //   66	72	178	java/lang/Exception
    //   72	91	178	java/lang/Exception
    //   171	175	178	java/lang/Exception
    //   207	213	178	java/lang/Exception
    //   226	240	178	java/lang/Exception
    //   268	284	178	java/lang/Exception
    //   284	290	178	java/lang/Exception
    //   185	189	192	java/io/IOException
    //   162	166	200	finally
    //   185	189	200	finally
    //   193	197	200	finally
    //   219	224	200	finally
    //   224	226	200	finally
    //   248	256	200	finally
    //   257	261	200	finally
    //   296	300	200	finally
    //   304	308	200	finally
    //   14	20	206	finally
    //   6	10	213	finally
    //   20	24	213	finally
    //   24	46	213	finally
    //   50	66	213	finally
    //   66	72	213	finally
    //   72	91	213	finally
    //   171	175	213	finally
    //   207	213	213	finally
    //   226	240	213	finally
    //   268	284	213	finally
    //   284	290	213	finally
    //   248	256	256	java/io/IOException
    //   162	166	295	java/io/IOException
    //   219	224	303	java/io/IOException
    //   96	106	311	finally
    //   111	117	311	finally
    //   122	135	311	finally
    //   140	146	311	finally
    //   151	158	311	finally
    //   96	106	315	java/lang/Exception
    //   111	117	315	java/lang/Exception
    //   122	135	315	java/lang/Exception
    //   140	146	315	java/lang/Exception
    //   151	158	315	java/lang/Exception
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
    //   143: new 295	akja
    //   146: dup
    //   147: invokespecial 296	akja:<init>	()V
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
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new akjc());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil
 * JD-Core Version:    0.7.0.1
 */