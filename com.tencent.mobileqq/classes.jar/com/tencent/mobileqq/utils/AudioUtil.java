package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AudioUtil
{
  private static int a;
  public static MediaPlayer a;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    return ((AudioManager)BaseApplication.getContext().getSystemService("audio")).getRingerMode();
  }
  
  /* Error */
  private static MediaPlayer a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 42	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: iload_1
    //   7: invokevirtual 48	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +151 -> 163
    //   15: new 50	android/media/MediaPlayer
    //   18: dup
    //   19: invokespecial 51	android/media/MediaPlayer:<init>	()V
    //   22: astore_2
    //   23: aload_2
    //   24: invokestatic 54	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 60	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   32: aload_0
    //   33: invokevirtual 64	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   36: aload_0
    //   37: invokevirtual 67	android/content/res/AssetFileDescriptor:getLength	()J
    //   40: invokevirtual 71	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   43: aload_0
    //   44: invokevirtual 74	android/content/res/AssetFileDescriptor:close	()V
    //   47: aload_2
    //   48: invokevirtual 77	android/media/MediaPlayer:prepare	()V
    //   51: aload_3
    //   52: astore_0
    //   53: aload_2
    //   54: astore_3
    //   55: aload_0
    //   56: ifnull +9 -> 65
    //   59: aload_0
    //   60: invokevirtual 74	android/content/res/AssetFileDescriptor:close	()V
    //   63: aload_2
    //   64: astore_3
    //   65: aload_3
    //   66: areturn
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_0
    //   72: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +12 -> 87
    //   78: ldc 85
    //   80: iconst_2
    //   81: ldc 87
    //   83: aload_3
    //   84: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_2
    //   88: ifnull +72 -> 160
    //   91: aload_2
    //   92: invokevirtual 94	android/media/MediaPlayer:release	()V
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: aload_0
    //   100: ifnull -35 -> 65
    //   103: aload_0
    //   104: invokevirtual 74	android/content/res/AssetFileDescriptor:close	()V
    //   107: aload_2
    //   108: areturn
    //   109: astore_0
    //   110: aload_2
    //   111: areturn
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 74	android/content/res/AssetFileDescriptor:close	()V
    //   123: aload_2
    //   124: athrow
    //   125: astore_0
    //   126: aload_2
    //   127: areturn
    //   128: astore_2
    //   129: goto -34 -> 95
    //   132: astore_0
    //   133: goto -10 -> 123
    //   136: astore_2
    //   137: goto -22 -> 115
    //   140: astore_2
    //   141: goto -26 -> 115
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: goto -75 -> 72
    //   150: astore_3
    //   151: goto -79 -> 72
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_0
    //   157: goto -85 -> 72
    //   160: goto -63 -> 97
    //   163: aconst_null
    //   164: astore_2
    //   165: goto -112 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	Context
    //   0	168	1	paramInt	int
    //   22	89	2	localMediaPlayer1	MediaPlayer
    //   112	15	2	localMediaPlayer2	MediaPlayer
    //   128	1	2	localException1	Exception
    //   136	1	2	localObject1	Object
    //   140	1	2	localObject2	Object
    //   146	19	2	localObject3	Object
    //   1	65	3	localObject4	Object
    //   67	17	3	localException2	Exception
    //   98	1	3	localObject5	Object
    //   144	1	3	localException3	Exception
    //   150	1	3	localException4	Exception
    //   154	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	67	java/lang/Exception
    //   103	107	109	java/lang/Exception
    //   2	11	112	finally
    //   47	51	112	finally
    //   59	63	125	java/lang/Exception
    //   91	95	128	java/lang/Exception
    //   119	123	132	java/lang/Exception
    //   15	23	136	finally
    //   23	47	136	finally
    //   72	87	140	finally
    //   91	95	140	finally
    //   15	23	144	java/lang/Exception
    //   23	47	150	java/lang/Exception
    //   47	51	154	java/lang/Exception
  }
  
  private static MediaPlayer a(Context paramContext, Uri paramUri)
  {
    label42:
    do
    {
      try
      {
        localObject = new MediaPlayer();
        if (!QLog.isColorLevel()) {
          break label42;
        }
      }
      catch (IOException paramUri)
      {
        try
        {
          a((MediaPlayer)localObject);
          ((MediaPlayer)localObject).setDataSource(paramContext, paramUri);
          ((MediaPlayer)localObject).prepare();
          return localObject;
        }
        catch (IOException paramUri)
        {
          for (;;)
          {
            Object localObject;
            paramContext = (Context)localObject;
          }
        }
        paramUri = paramUri;
        paramContext = null;
      }
      QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramUri);
      localObject = paramContext;
    } while (paramContext == null);
    try
    {
      paramContext.release();
      label52:
      return null;
    }
    catch (Exception paramContext)
    {
      break label52;
    }
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioUtil", 2, "[silkPlayer]mediaPlayerStop");
    }
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "[silkPlayer]mediaPlayerStop,mediaPalyer.release()");
        }
      }
      label40:
      jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return;
    }
    catch (Exception localException)
    {
      break label40;
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
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        boolean bool2 = jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        if (!bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("[SilkPlayer]mediaPlayerStart, exception, mediaPalyer == null ?  ");
        if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
          break label245;
        }
        QLog.e("AudioUtil", 1, bool1, localException);
        if (paramOnCompletionListener == null) {
          continue;
        }
        if ((paramHandler != null) && (paramHandler.getLooper() != Looper.myLooper())) {
          break label251;
        }
        QLog.e("AudioUtil", 1, "MediaPlayerStart, exception, branch 1");
        paramOnCompletionListener.onCompletion(jdField_a_of_type_AndroidMediaMediaPlayer);
        continue;
      }
      finally {}
      return;
      a();
      if (paramInt1 != AppSetting.d)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "[SilkPlayer] MediaPlayerStart, resId != AppSetting.TypeSystemSoundId");
        }
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplication.getContext(), paramInt1);
        if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          jdField_a_of_type_Int = paramInt2;
          if (jdField_a_of_type_Int != 0) {
            jdField_a_of_type_Int -= 1;
          }
          jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new AudioUtil.4(paramOnCompletionListener, paramHandler));
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          if (QLog.isColorLevel()) {
            QLog.d("AudioUtil", 2, "[SilkPlayer]mediaPlayerStart, 播放提示音，mediaPalyer.start().");
          }
          jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "[SilkPlayer] MediaPlayerStart, resId == AppSetting.TypeSystemSoundId");
        }
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplication.getContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      continue;
      label245:
      bool1 = false;
      continue;
      label251:
      QLog.e("AudioUtil", 1, "MediaPlayerStart, exception, branch 2");
      paramHandler.post(new AudioUtil.5(paramOnCompletionListener));
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
      if (paramInt != AppSetting.d)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplication.getContext(), paramInt);
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
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplication.getContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("mediaPlayerStartForMsg", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new AudioUtil.2());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  private static void a(MediaPlayer paramMediaPlayer)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && ((localAppRuntime instanceof BaseQQAppInterface))) {
      paramMediaPlayer.setAudioStreamType(3);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MediaPlayerStart", 2, "get QQAppInterface error");
  }
  
  /* Error */
  public static void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +13 -> 24
    //   14: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   17: invokevirtual 94	android/media/MediaPlayer:release	()V
    //   20: aconst_null
    //   21: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: aload_0
    //   25: invokevirtual 265	android/net/Uri:getScheme	()Ljava/lang/String;
    //   28: ldc_w 267
    //   31: invokevirtual 273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +193 -> 227
    //   37: new 50	android/media/MediaPlayer
    //   40: dup
    //   41: invokespecial 51	android/media/MediaPlayer:<init>	()V
    //   44: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   47: iload_2
    //   48: ifeq +25 -> 73
    //   51: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc_w 275
    //   60: iconst_2
    //   61: ldc_w 277
    //   64: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   70: invokestatic 54	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   73: new 279	java/io/FileInputStream
    //   76: dup
    //   77: new 281	java/io/File
    //   80: dup
    //   81: aload_0
    //   82: invokevirtual 284	android/net/Uri:getPath	()Ljava/lang/String;
    //   85: invokespecial 287	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokespecial 290	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_0
    //   92: aload_0
    //   93: astore 4
    //   95: aload_0
    //   96: astore_3
    //   97: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   100: aload_0
    //   101: invokevirtual 293	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   104: invokevirtual 296	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   107: aload_0
    //   108: astore 4
    //   110: aload_0
    //   111: astore_3
    //   112: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   115: invokevirtual 77	android/media/MediaPlayer:prepare	()V
    //   118: aload_0
    //   119: astore 4
    //   121: aload_0
    //   122: astore_3
    //   123: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   126: new 298	com/tencent/mobileqq/utils/AudioUtil$7
    //   129: dup
    //   130: invokespecial 299	com/tencent/mobileqq/utils/AudioUtil$7:<init>	()V
    //   133: invokevirtual 138	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   136: aload_0
    //   137: astore 4
    //   139: aload_0
    //   140: astore_3
    //   141: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   144: invokevirtual 141	android/media/MediaPlayer:start	()V
    //   147: aload_0
    //   148: astore 4
    //   150: aload_0
    //   151: astore_3
    //   152: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   155: iload_1
    //   156: invokevirtual 147	android/media/MediaPlayer:setLooping	(Z)V
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 300	java/io/FileInputStream:close	()V
    //   167: ldc 2
    //   169: monitorexit
    //   170: return
    //   171: astore_3
    //   172: aconst_null
    //   173: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   176: goto -152 -> 24
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_3
    //   183: ifnull -16 -> 167
    //   186: aload_3
    //   187: invokevirtual 300	java/io/FileInputStream:close	()V
    //   190: goto -23 -> 167
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   198: goto -31 -> 167
    //   201: astore_0
    //   202: ldc 2
    //   204: monitorexit
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: aconst_null
    //   209: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 300	java/io/FileInputStream:close	()V
    //   225: aload_0
    //   226: athrow
    //   227: invokestatic 22	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   230: aload_0
    //   231: invokestatic 196	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   234: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   237: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   240: astore_0
    //   241: aload_0
    //   242: ifnonnull +23 -> 265
    //   245: iconst_0
    //   246: ifeq -79 -> 167
    //   249: new 305	java/lang/NullPointerException
    //   252: dup
    //   253: invokespecial 306	java/lang/NullPointerException:<init>	()V
    //   256: athrow
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   262: goto -95 -> 167
    //   265: iload_2
    //   266: ifeq +25 -> 291
    //   269: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +13 -> 285
    //   275: ldc_w 275
    //   278: iconst_2
    //   279: ldc_w 277
    //   282: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   288: invokestatic 54	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   291: aconst_null
    //   292: astore_0
    //   293: goto -175 -> 118
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   301: goto -134 -> 167
    //   304: astore_3
    //   305: aload_3
    //   306: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   309: goto -84 -> 225
    //   312: astore_0
    //   313: goto -98 -> 215
    //   316: astore_0
    //   317: goto -135 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramUri	Uri
    //   0	320	1	paramBoolean1	boolean
    //   0	320	2	paramBoolean2	boolean
    //   9	143	3	localObject1	Object
    //   171	1	3	localException	Exception
    //   181	6	3	localObject2	Object
    //   304	2	3	localIOException	IOException
    //   1	220	4	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   14	20	171	java/lang/Exception
    //   6	10	179	java/lang/Exception
    //   20	24	179	java/lang/Exception
    //   24	47	179	java/lang/Exception
    //   51	67	179	java/lang/Exception
    //   67	73	179	java/lang/Exception
    //   73	92	179	java/lang/Exception
    //   172	176	179	java/lang/Exception
    //   208	214	179	java/lang/Exception
    //   227	241	179	java/lang/Exception
    //   269	285	179	java/lang/Exception
    //   285	291	179	java/lang/Exception
    //   186	190	193	java/io/IOException
    //   163	167	201	finally
    //   186	190	201	finally
    //   194	198	201	finally
    //   220	225	201	finally
    //   225	227	201	finally
    //   249	257	201	finally
    //   258	262	201	finally
    //   297	301	201	finally
    //   305	309	201	finally
    //   14	20	207	finally
    //   6	10	214	finally
    //   20	24	214	finally
    //   24	47	214	finally
    //   51	67	214	finally
    //   67	73	214	finally
    //   73	92	214	finally
    //   172	176	214	finally
    //   208	214	214	finally
    //   227	241	214	finally
    //   269	285	214	finally
    //   285	291	214	finally
    //   249	257	257	java/io/IOException
    //   163	167	296	java/io/IOException
    //   220	225	304	java/io/IOException
    //   97	107	312	finally
    //   112	118	312	finally
    //   123	136	312	finally
    //   141	147	312	finally
    //   152	159	312	finally
    //   97	107	316	java/lang/Exception
    //   112	118	316	java/lang/Exception
    //   123	136	316	java/lang/Exception
    //   141	147	316	java/lang/Exception
    //   152	159	316	java/lang/Exception
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
    //   12: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   15: ifnull +60 -> 75
    //   18: aload 5
    //   20: astore_3
    //   21: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: invokevirtual 118	android/media/MediaPlayer:isPlaying	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +33 -> 62
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 305	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 306	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   53: goto -9 -> 44
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    //   62: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   65: invokevirtual 94	android/media/MediaPlayer:release	()V
    //   68: aload 5
    //   70: astore_3
    //   71: aconst_null
    //   72: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   75: aload 5
    //   77: astore_3
    //   78: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   81: ifnonnull +16 -> 97
    //   84: aload 5
    //   86: astore_3
    //   87: new 50	android/media/MediaPlayer
    //   90: dup
    //   91: invokespecial 51	android/media/MediaPlayer:<init>	()V
    //   94: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   97: aload 5
    //   99: astore_3
    //   100: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   103: invokevirtual 310	android/media/MediaPlayer:reset	()V
    //   106: aload 5
    //   108: astore_3
    //   109: new 279	java/io/FileInputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 311	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   121: aload_0
    //   122: invokevirtual 293	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   125: invokevirtual 296	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   128: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   131: invokestatic 54	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   134: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   137: invokevirtual 77	android/media/MediaPlayer:prepare	()V
    //   140: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: new 313	com/tencent/mobileqq/utils/AudioUtil$1
    //   146: dup
    //   147: invokespecial 314	com/tencent/mobileqq/utils/AudioUtil$1:<init>	()V
    //   150: invokevirtual 138	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   153: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   156: invokevirtual 141	android/media/MediaPlayer:start	()V
    //   159: getstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   162: iload_1
    //   163: invokevirtual 147	android/media/MediaPlayer:setLooping	(Z)V
    //   166: aload_0
    //   167: ifnull -123 -> 44
    //   170: aload_0
    //   171: invokevirtual 300	java/io/FileInputStream:close	()V
    //   174: goto -130 -> 44
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   182: goto -138 -> 44
    //   185: astore_3
    //   186: aload 5
    //   188: astore_3
    //   189: aconst_null
    //   190: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   193: goto -118 -> 75
    //   196: astore_3
    //   197: aload 4
    //   199: astore_0
    //   200: aload_3
    //   201: astore 4
    //   203: aload_0
    //   204: astore_3
    //   205: aload 4
    //   207: invokevirtual 315	java/lang/Exception:printStackTrace	()V
    //   210: aload_0
    //   211: astore_3
    //   212: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +16 -> 231
    //   218: aload_0
    //   219: astore_3
    //   220: ldc 102
    //   222: iconst_2
    //   223: ldc_w 317
    //   226: aload 4
    //   228: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_0
    //   232: ifnull -188 -> 44
    //   235: aload_0
    //   236: invokevirtual 300	java/io/FileInputStream:close	()V
    //   239: goto -195 -> 44
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   247: goto -203 -> 44
    //   250: astore_0
    //   251: aload 5
    //   253: astore_3
    //   254: aconst_null
    //   255: putstatic 109	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   258: aload 5
    //   260: astore_3
    //   261: aload_0
    //   262: athrow
    //   263: astore_0
    //   264: aload_3
    //   265: ifnull +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 300	java/io/FileInputStream:close	()V
    //   272: aload_0
    //   273: athrow
    //   274: astore_3
    //   275: aload_3
    //   276: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   279: goto -7 -> 272
    //   282: astore 4
    //   284: aload_0
    //   285: astore_3
    //   286: aload 4
    //   288: astore_0
    //   289: goto -25 -> 264
    //   292: astore 4
    //   294: goto -91 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramString	java.lang.String
    //   0	297	1	paramBoolean	boolean
    //   27	2	2	bool	boolean
    //   11	98	3	localObject1	Object
    //   185	1	3	localException1	Exception
    //   188	1	3	localObject2	Object
    //   196	5	3	localException2	Exception
    //   204	65	3	localObject3	Object
    //   274	2	3	localIOException	IOException
    //   285	1	3	str	java.lang.String
    //   4	223	4	localObject4	Object
    //   282	5	4	localObject5	Object
    //   292	1	4	localException3	Exception
    //   1	258	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	48	java/io/IOException
    //   36	44	56	finally
    //   49	53	56	finally
    //   170	174	56	finally
    //   178	182	56	finally
    //   235	239	56	finally
    //   243	247	56	finally
    //   268	272	56	finally
    //   272	274	56	finally
    //   275	279	56	finally
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
    //   254	258	196	java/lang/Exception
    //   261	263	196	java/lang/Exception
    //   235	239	242	java/io/IOException
    //   62	68	250	finally
    //   12	18	263	finally
    //   21	28	263	finally
    //   71	75	263	finally
    //   78	84	263	finally
    //   87	97	263	finally
    //   100	106	263	finally
    //   109	118	263	finally
    //   189	193	263	finally
    //   205	210	263	finally
    //   212	218	263	finally
    //   220	231	263	finally
    //   254	258	263	finally
    //   261	263	263	finally
    //   268	272	274	java/io/IOException
    //   118	166	282	finally
    //   118	166	292	java/lang/Exception
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
          break label172;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer release exception", localException2);
        label172:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.d)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplication.getContext(), paramInt);
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
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplication.getContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MediaPlayerStart", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new AudioUtil.3());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil
 * JD-Core Version:    0.7.0.1
 */