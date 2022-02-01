package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.IOException;
import java.lang.reflect.Method;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AudioUtil
{
  private static int jdField_a_of_type_Int = 0;
  public static MediaPlayer a;
  static final int[] jdField_a_of_type_ArrayOfInt = { 35, 36 };
  static final int[] b = { 26, 27 };
  
  public static int a()
  {
    return ((AudioManager)BaseApplication.getContext().getSystemService("audio")).getRingerMode();
  }
  
  /* Error */
  private static MediaPlayer a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 54	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +93 -> 103
    //   13: aload_3
    //   14: astore 4
    //   16: new 56	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   19: dup
    //   20: invokespecial 57	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   23: astore 5
    //   25: aload_3
    //   26: astore 4
    //   28: aload 5
    //   30: invokestatic 60	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   33: aload_3
    //   34: astore 4
    //   36: aload 5
    //   38: aload_3
    //   39: invokevirtual 66	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   42: aload_3
    //   43: invokevirtual 70	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   46: aload_3
    //   47: invokevirtual 73	android/content/res/AssetFileDescriptor:getLength	()J
    //   50: invokevirtual 79	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   53: aload_3
    //   54: astore 4
    //   56: aload_3
    //   57: invokevirtual 82	android/content/res/AssetFileDescriptor:close	()V
    //   60: aload 5
    //   62: invokevirtual 85	android/media/MediaPlayer:prepare	()V
    //   65: aconst_null
    //   66: astore_3
    //   67: aload 5
    //   69: astore_0
    //   70: goto +35 -> 105
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_0
    //   76: aload 5
    //   78: astore_3
    //   79: goto +51 -> 130
    //   82: astore_2
    //   83: aload_3
    //   84: astore_0
    //   85: aload 5
    //   87: astore_3
    //   88: goto +42 -> 130
    //   91: astore_2
    //   92: aconst_null
    //   93: astore 4
    //   95: aload_3
    //   96: astore_0
    //   97: aload 4
    //   99: astore_3
    //   100: goto +30 -> 130
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore 4
    //   108: aload_3
    //   109: ifnull +71 -> 180
    //   112: aload_3
    //   113: invokevirtual 82	android/content/res/AssetFileDescriptor:close	()V
    //   116: aload_0
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore 4
    //   122: goto +62 -> 184
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: astore_3
    //   130: aload_0
    //   131: astore 4
    //   133: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +15 -> 151
    //   139: aload_0
    //   140: astore 4
    //   142: ldc 93
    //   144: iconst_2
    //   145: ldc 95
    //   147: aload_2
    //   148: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: aload_3
    //   152: astore_2
    //   153: aload_3
    //   154: ifnull +12 -> 166
    //   157: aload_0
    //   158: astore 4
    //   160: aload_3
    //   161: invokevirtual 102	android/media/MediaPlayer:release	()V
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: astore 4
    //   169: aload_0
    //   170: ifnull +10 -> 180
    //   173: aload_0
    //   174: astore_3
    //   175: aload_2
    //   176: astore_0
    //   177: goto -65 -> 112
    //   180: aload 4
    //   182: areturn
    //   183: astore_0
    //   184: aload 4
    //   186: ifnull +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 82	android/content/res/AssetFileDescriptor:close	()V
    //   194: goto +5 -> 199
    //   197: aload_0
    //   198: athrow
    //   199: goto -2 -> 197
    //   202: astore_2
    //   203: aload_0
    //   204: areturn
    //   205: astore_2
    //   206: goto -42 -> 164
    //   209: astore_2
    //   210: goto -16 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramContext	Context
    //   0	213	1	paramInt	int
    //   73	1	2	localException1	Exception
    //   82	1	2	localException2	Exception
    //   91	1	2	localException3	Exception
    //   125	23	2	localException4	Exception
    //   152	24	2	localObject1	Object
    //   202	1	2	localException5	Exception
    //   205	1	2	localException6	Exception
    //   209	1	2	localException7	Exception
    //   8	167	3	localObject2	Object
    //   14	176	4	localObject3	Object
    //   23	63	5	localReportMediaPlayer	ReportMediaPlayer
    // Exception table:
    //   from	to	target	type
    //   60	65	73	java/lang/Exception
    //   28	33	82	java/lang/Exception
    //   36	53	82	java/lang/Exception
    //   56	60	82	java/lang/Exception
    //   16	25	91	java/lang/Exception
    //   0	9	118	finally
    //   60	65	118	finally
    //   0	9	125	java/lang/Exception
    //   16	25	183	finally
    //   28	33	183	finally
    //   36	53	183	finally
    //   56	60	183	finally
    //   133	139	183	finally
    //   142	151	183	finally
    //   160	164	183	finally
    //   112	116	202	java/lang/Exception
    //   160	164	205	java/lang/Exception
    //   189	194	209	java/lang/Exception
  }
  
  private static MediaPlayer a(Context paramContext, Uri paramUri)
  {
    try
    {
      ReportMediaPlayer localReportMediaPlayer = new ReportMediaPlayer();
      try
      {
        a(localReportMediaPlayer);
        localReportMediaPlayer.setDataSource(paramContext, paramUri);
        localReportMediaPlayer.prepare();
        return localReportMediaPlayer;
      }
      catch (IOException paramUri)
      {
        paramContext = localReportMediaPlayer;
      }
      if (!QLog.isColorLevel()) {
        break label48;
      }
    }
    catch (IOException paramUri)
    {
      paramContext = null;
    }
    QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramUri);
    label48:
    paramUri = paramContext;
    if (paramContext != null) {}
    try
    {
      paramContext.release();
      label58:
      paramUri = null;
      return paramUri;
    }
    catch (Exception paramContext)
    {
      break label58;
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
  
  public static void a(int paramInt)
  {
    b(paramInt, false);
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
  
  /* Error */
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener, android.os.Handler paramHandler)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 4
    //   6: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   9: ifnull +23 -> 32
    //   12: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   15: invokevirtual 130	android/media/MediaPlayer:isPlaying	()Z
    //   18: istore 5
    //   20: iload 5
    //   22: ifeq +7 -> 29
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: invokestatic 132	com/tencent/mobileqq/utils/AudioUtil:a	()V
    //   32: iload_0
    //   33: getstatic 136	com/tencent/common/config/AppSetting:d	I
    //   36: if_icmpeq +30 -> 66
    //   39: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 110
    //   47: iconst_2
    //   48: ldc 138
    //   50: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: invokestatic 28	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: iload_0
    //   57: invokestatic 141	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   60: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   63: goto +29 -> 92
    //   66: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +11 -> 80
    //   72: ldc 110
    //   74: iconst_2
    //   75: ldc 143
    //   77: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: invokestatic 28	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   83: getstatic 149	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   86: invokestatic 151	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   89: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   92: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   95: astore 6
    //   97: aload 6
    //   99: ifnonnull +7 -> 106
    //   102: ldc 2
    //   104: monitorexit
    //   105: return
    //   106: iload_1
    //   107: putstatic 17	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   110: getstatic 17	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   113: ifeq +11 -> 124
    //   116: getstatic 17	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   119: iconst_1
    //   120: isub
    //   121: putstatic 17	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   124: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   127: new 153	com/tencent/mobileqq/utils/AudioUtil$4
    //   130: dup
    //   131: aload_2
    //   132: aload_3
    //   133: invokespecial 156	com/tencent/mobileqq/utils/AudioUtil$4:<init>	(Landroid/media/MediaPlayer$OnCompletionListener;Landroid/os/Handler;)V
    //   136: invokevirtual 160	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   139: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   142: invokevirtual 163	android/media/MediaPlayer:start	()V
    //   145: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +11 -> 159
    //   151: ldc 110
    //   153: iconst_2
    //   154: ldc 165
    //   156: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   162: iconst_0
    //   163: invokevirtual 169	android/media/MediaPlayer:setLooping	(Z)V
    //   166: goto +118 -> 284
    //   169: astore_2
    //   170: goto +118 -> 288
    //   173: astore 6
    //   175: new 171	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   182: astore 7
    //   184: aload 7
    //   186: ldc 174
    //   188: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   195: ifnonnull +6 -> 201
    //   198: iconst_1
    //   199: istore 4
    //   201: aload 7
    //   203: iload 4
    //   205: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: ldc 110
    //   211: iconst_1
    //   212: aload 7
    //   214: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload 6
    //   219: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_2
    //   223: ifnull +61 -> 284
    //   226: aload_3
    //   227: ifnull +40 -> 267
    //   230: aload_3
    //   231: invokevirtual 194	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   234: invokestatic 199	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   237: if_acmpne +6 -> 243
    //   240: goto +27 -> 267
    //   243: ldc 110
    //   245: iconst_1
    //   246: ldc 201
    //   248: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_3
    //   252: new 205	com/tencent/mobileqq/utils/AudioUtil$5
    //   255: dup
    //   256: aload_2
    //   257: invokespecial 207	com/tencent/mobileqq/utils/AudioUtil$5:<init>	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   260: invokevirtual 211	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   263: pop
    //   264: goto +20 -> 284
    //   267: ldc 110
    //   269: iconst_1
    //   270: ldc 213
    //   272: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_2
    //   276: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   279: invokeinterface 218 2 0
    //   284: ldc 2
    //   286: monitorexit
    //   287: return
    //   288: ldc 2
    //   290: monitorexit
    //   291: aload_2
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramInt1	int
    //   0	293	1	paramInt2	int
    //   0	293	2	paramOnCompletionListener	MediaPlayer.OnCompletionListener
    //   0	293	3	paramHandler	android.os.Handler
    //   4	200	4	bool1	boolean
    //   18	3	5	bool2	boolean
    //   95	3	6	localMediaPlayer	MediaPlayer
    //   173	45	6	localException	Exception
    //   182	31	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	20	169	finally
    //   29	32	169	finally
    //   32	53	169	finally
    //   53	63	169	finally
    //   66	80	169	finally
    //   80	92	169	finally
    //   92	97	169	finally
    //   106	124	169	finally
    //   124	159	169	finally
    //   159	166	169	finally
    //   175	192	169	finally
    //   192	198	169	finally
    //   201	222	169	finally
    //   230	240	169	finally
    //   243	264	169	finally
    //   267	284	169	finally
    //   6	20	173	java/lang/Exception
    //   29	32	173	java/lang/Exception
    //   32	53	173	java/lang/Exception
    //   53	63	173	java/lang/Exception
    //   66	80	173	java/lang/Exception
    //   80	92	173	java/lang/Exception
    //   92	97	173	java/lang/Exception
    //   106	124	173	java/lang/Exception
    //   124	159	173	java/lang/Exception
    //   159	166	173	java/lang/Exception
  }
  
  /* Error */
  public static void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +47 -> 53
    //   9: new 171	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   16: astore_2
    //   17: aload_2
    //   18: ldc 220
    //   20: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: iload_0
    //   26: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: ldc 225
    //   33: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: iload_1
    //   39: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: ldc 227
    //   45: iconst_2
    //   46: aload_2
    //   47: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   56: ifnull +72 -> 128
    //   59: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   62: invokevirtual 130	android/media/MediaPlayer:isPlaying	()Z
    //   65: ifeq +21 -> 86
    //   68: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +11 -> 82
    //   74: ldc 227
    //   76: iconst_2
    //   77: ldc 229
    //   79: invokestatic 232	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: ldc 2
    //   84: monitorexit
    //   85: return
    //   86: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   89: invokevirtual 102	android/media/MediaPlayer:release	()V
    //   92: aconst_null
    //   93: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   96: goto +32 -> 128
    //   99: astore_2
    //   100: goto +22 -> 122
    //   103: astore_2
    //   104: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq -15 -> 92
    //   110: ldc 227
    //   112: iconst_2
    //   113: ldc 234
    //   115: aload_2
    //   116: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   119: goto -27 -> 92
    //   122: aconst_null
    //   123: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   126: aload_2
    //   127: athrow
    //   128: iload_0
    //   129: getstatic 136	com/tencent/common/config/AppSetting:d	I
    //   132: if_icmpeq +16 -> 148
    //   135: invokestatic 28	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   138: iload_0
    //   139: invokestatic 236	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   142: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   145: goto +54 -> 199
    //   148: invokestatic 28	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   151: getstatic 149	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   154: invokestatic 238	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   157: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   160: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +36 -> 199
    //   166: new 171	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   173: astore_2
    //   174: aload_2
    //   175: ldc 240
    //   177: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_2
    //   182: getstatic 149	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   185: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 227
    //   191: iconst_2
    //   192: aload_2
    //   193: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   202: ifnonnull +21 -> 223
    //   205: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +11 -> 219
    //   211: ldc 227
    //   213: iconst_2
    //   214: ldc 245
    //   216: invokestatic 232	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: ldc 2
    //   221: monitorexit
    //   222: return
    //   223: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   226: new 247	com/tencent/mobileqq/utils/AudioUtil$2
    //   229: dup
    //   230: invokespecial 248	com/tencent/mobileqq/utils/AudioUtil$2:<init>	()V
    //   233: invokevirtual 160	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   236: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   239: invokevirtual 163	android/media/MediaPlayer:start	()V
    //   242: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   245: iload_1
    //   246: invokevirtual 169	android/media/MediaPlayer:setLooping	(Z)V
    //   249: goto +23 -> 272
    //   252: astore_2
    //   253: goto +23 -> 276
    //   256: astore_2
    //   257: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +12 -> 272
    //   263: ldc 227
    //   265: iconst_2
    //   266: ldc 250
    //   268: aload_2
    //   269: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   272: ldc 2
    //   274: monitorexit
    //   275: return
    //   276: ldc 2
    //   278: monitorexit
    //   279: goto +5 -> 284
    //   282: aload_2
    //   283: athrow
    //   284: goto -2 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramInt	int
    //   0	287	1	paramBoolean	boolean
    //   16	31	2	localStringBuilder1	StringBuilder
    //   99	1	2	localObject1	Object
    //   103	24	2	localException1	Exception
    //   173	20	2	localStringBuilder2	StringBuilder
    //   252	1	2	localObject2	Object
    //   256	27	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   86	92	99	finally
    //   104	119	99	finally
    //   86	92	103	java/lang/Exception
    //   3	53	252	finally
    //   53	82	252	finally
    //   92	96	252	finally
    //   122	128	252	finally
    //   128	145	252	finally
    //   148	199	252	finally
    //   199	219	252	finally
    //   223	249	252	finally
    //   257	272	252	finally
    //   3	53	256	java/lang/Exception
    //   53	82	256	java/lang/Exception
    //   92	96	256	java/lang/Exception
    //   122	128	256	java/lang/Exception
    //   128	145	256	java/lang/Exception
    //   148	199	256	java/lang/Exception
    //   199	219	256	java/lang/Exception
    //   223	249	256	java/lang/Exception
  }
  
  private static void a(MediaPlayer paramMediaPlayer)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && ((localAppRuntime instanceof BaseQQAppInterface)))
    {
      paramMediaPlayer.setAudioStreamType(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerStart", 2, "get QQAppInterface error");
    }
  }
  
  /* Error */
  public static void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aload 5
    //   14: astore_3
    //   15: aload 6
    //   17: astore 4
    //   19: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   22: astore 8
    //   24: aload 8
    //   26: ifnull +44 -> 70
    //   29: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   32: invokevirtual 102	android/media/MediaPlayer:release	()V
    //   35: aload 5
    //   37: astore_3
    //   38: aload 6
    //   40: astore 4
    //   42: aconst_null
    //   43: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   46: goto +24 -> 70
    //   49: astore_0
    //   50: aload 5
    //   52: astore_3
    //   53: aload 6
    //   55: astore 4
    //   57: aconst_null
    //   58: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   61: aload 5
    //   63: astore_3
    //   64: aload 6
    //   66: astore 4
    //   68: aload_0
    //   69: athrow
    //   70: aload 5
    //   72: astore_3
    //   73: aload 6
    //   75: astore 4
    //   77: aload_0
    //   78: invokevirtual 275	android/net/Uri:getScheme	()Ljava/lang/String;
    //   81: ldc_w 277
    //   84: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +124 -> 211
    //   90: aload 5
    //   92: astore_3
    //   93: aload 6
    //   95: astore 4
    //   97: new 56	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   100: dup
    //   101: invokespecial 57	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   104: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   107: iload_2
    //   108: ifeq +46 -> 154
    //   111: aload 5
    //   113: astore_3
    //   114: aload 6
    //   116: astore 4
    //   118: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +20 -> 141
    //   124: aload 5
    //   126: astore_3
    //   127: aload 6
    //   129: astore 4
    //   131: ldc_w 285
    //   134: iconst_2
    //   135: ldc_w 287
    //   138: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 5
    //   143: astore_3
    //   144: aload 6
    //   146: astore 4
    //   148: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   151: invokestatic 60	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   154: aload 5
    //   156: astore_3
    //   157: aload 6
    //   159: astore 4
    //   161: new 289	java/io/FileInputStream
    //   164: dup
    //   165: new 291	java/io/File
    //   168: dup
    //   169: aload_0
    //   170: invokevirtual 294	android/net/Uri:getPath	()Ljava/lang/String;
    //   173: invokespecial 297	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: invokespecial 300	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   179: astore_0
    //   180: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   183: aload_0
    //   184: invokevirtual 303	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   187: invokevirtual 306	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   190: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   193: invokevirtual 85	android/media/MediaPlayer:prepare	()V
    //   196: goto +104 -> 300
    //   199: astore_3
    //   200: aload_0
    //   201: astore 4
    //   203: aload_3
    //   204: astore_0
    //   205: goto +159 -> 364
    //   208: goto +176 -> 384
    //   211: aload 5
    //   213: astore_3
    //   214: aload 6
    //   216: astore 4
    //   218: invokestatic 28	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   221: aload_0
    //   222: invokestatic 151	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   225: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   228: aload 5
    //   230: astore_3
    //   231: aload 6
    //   233: astore 4
    //   235: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   238: astore_0
    //   239: aload_0
    //   240: ifnonnull +7 -> 247
    //   243: ldc 2
    //   245: monitorexit
    //   246: return
    //   247: aload 7
    //   249: astore_0
    //   250: iload_2
    //   251: ifeq +49 -> 300
    //   254: aload 5
    //   256: astore_3
    //   257: aload 6
    //   259: astore 4
    //   261: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +20 -> 284
    //   267: aload 5
    //   269: astore_3
    //   270: aload 6
    //   272: astore 4
    //   274: ldc_w 285
    //   277: iconst_2
    //   278: ldc_w 287
    //   281: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload 5
    //   286: astore_3
    //   287: aload 6
    //   289: astore 4
    //   291: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   294: invokestatic 60	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   297: aload 7
    //   299: astore_0
    //   300: aload_0
    //   301: astore_3
    //   302: aload_0
    //   303: astore 4
    //   305: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   308: new 308	com/tencent/mobileqq/utils/AudioUtil$7
    //   311: dup
    //   312: invokespecial 309	com/tencent/mobileqq/utils/AudioUtil$7:<init>	()V
    //   315: invokevirtual 160	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   318: aload_0
    //   319: astore_3
    //   320: aload_0
    //   321: astore 4
    //   323: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   326: invokevirtual 163	android/media/MediaPlayer:start	()V
    //   329: aload_0
    //   330: astore_3
    //   331: aload_0
    //   332: astore 4
    //   334: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   337: iload_1
    //   338: invokevirtual 169	android/media/MediaPlayer:setLooping	(Z)V
    //   341: aload_0
    //   342: ifnull +66 -> 408
    //   345: aload_0
    //   346: invokevirtual 310	java/io/FileInputStream:close	()V
    //   349: goto +59 -> 408
    //   352: astore_0
    //   353: aload_0
    //   354: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   357: goto +51 -> 408
    //   360: astore_0
    //   361: aload_3
    //   362: astore 4
    //   364: aload 4
    //   366: ifnull +16 -> 382
    //   369: aload 4
    //   371: invokevirtual 310	java/io/FileInputStream:close	()V
    //   374: goto +8 -> 382
    //   377: astore_3
    //   378: aload_3
    //   379: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   382: aload_0
    //   383: athrow
    //   384: aload_0
    //   385: ifnull +23 -> 408
    //   388: aload_0
    //   389: invokevirtual 310	java/io/FileInputStream:close	()V
    //   392: goto +16 -> 408
    //   395: astore_0
    //   396: goto +7 -> 403
    //   399: astore_0
    //   400: goto -47 -> 353
    //   403: ldc 2
    //   405: monitorexit
    //   406: aload_0
    //   407: athrow
    //   408: ldc 2
    //   410: monitorexit
    //   411: return
    //   412: astore_0
    //   413: aload 4
    //   415: astore_0
    //   416: goto -32 -> 384
    //   419: astore_3
    //   420: goto -385 -> 35
    //   423: astore_3
    //   424: goto -216 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramUri	Uri
    //   0	427	1	paramBoolean1	boolean
    //   0	427	2	paramBoolean2	boolean
    //   14	143	3	localObject1	Object
    //   199	5	3	localObject2	Object
    //   213	149	3	localObject3	Object
    //   377	2	3	localIOException	IOException
    //   419	1	3	localException1	Exception
    //   423	1	3	localException2	Exception
    //   17	397	4	localObject4	Object
    //   4	281	5	localObject5	Object
    //   7	281	6	localObject6	Object
    //   10	288	7	localObject7	Object
    //   22	3	8	localMediaPlayer	MediaPlayer
    // Exception table:
    //   from	to	target	type
    //   29	35	49	finally
    //   180	196	199	finally
    //   345	349	352	java/io/IOException
    //   19	24	360	finally
    //   42	46	360	finally
    //   57	61	360	finally
    //   68	70	360	finally
    //   77	90	360	finally
    //   97	107	360	finally
    //   118	124	360	finally
    //   131	141	360	finally
    //   148	154	360	finally
    //   161	180	360	finally
    //   218	228	360	finally
    //   235	239	360	finally
    //   261	267	360	finally
    //   274	284	360	finally
    //   291	297	360	finally
    //   305	318	360	finally
    //   323	329	360	finally
    //   334	341	360	finally
    //   369	374	377	java/io/IOException
    //   345	349	395	finally
    //   353	357	395	finally
    //   369	374	395	finally
    //   378	382	395	finally
    //   382	384	395	finally
    //   388	392	395	finally
    //   388	392	399	java/io/IOException
    //   19	24	412	java/lang/Exception
    //   42	46	412	java/lang/Exception
    //   57	61	412	java/lang/Exception
    //   68	70	412	java/lang/Exception
    //   77	90	412	java/lang/Exception
    //   97	107	412	java/lang/Exception
    //   118	124	412	java/lang/Exception
    //   131	141	412	java/lang/Exception
    //   148	154	412	java/lang/Exception
    //   161	180	412	java/lang/Exception
    //   218	228	412	java/lang/Exception
    //   235	239	412	java/lang/Exception
    //   261	267	412	java/lang/Exception
    //   274	284	412	java/lang/Exception
    //   291	297	412	java/lang/Exception
    //   305	318	412	java/lang/Exception
    //   323	329	412	java/lang/Exception
    //   334	341	412	java/lang/Exception
    //   29	35	419	java/lang/Exception
    //   180	196	423	java/lang/Exception
  }
  
  /* Error */
  public static void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   15: ifnull +50 -> 65
    //   18: aload 4
    //   20: astore_3
    //   21: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   24: invokevirtual 130	android/media/MediaPlayer:isPlaying	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +7 -> 36
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   39: invokevirtual 102	android/media/MediaPlayer:release	()V
    //   42: aload 4
    //   44: astore_3
    //   45: aconst_null
    //   46: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   49: goto +16 -> 65
    //   52: astore_0
    //   53: aload 4
    //   55: astore_3
    //   56: aconst_null
    //   57: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   60: aload 4
    //   62: astore_3
    //   63: aload_0
    //   64: athrow
    //   65: aload 4
    //   67: astore_3
    //   68: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   71: ifnonnull +16 -> 87
    //   74: aload 4
    //   76: astore_3
    //   77: new 56	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   80: dup
    //   81: invokespecial 57	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   84: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   87: aload 4
    //   89: astore_3
    //   90: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   93: invokevirtual 317	android/media/MediaPlayer:reset	()V
    //   96: aload 4
    //   98: astore_3
    //   99: new 289	java/io/FileInputStream
    //   102: dup
    //   103: aload_0
    //   104: invokespecial 318	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   107: astore_0
    //   108: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   111: aload_0
    //   112: invokevirtual 303	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   115: invokevirtual 306	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   118: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   121: invokestatic 60	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   124: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   127: invokevirtual 85	android/media/MediaPlayer:prepare	()V
    //   130: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   133: new 320	com/tencent/mobileqq/utils/AudioUtil$1
    //   136: dup
    //   137: invokespecial 321	com/tencent/mobileqq/utils/AudioUtil$1:<init>	()V
    //   140: invokevirtual 160	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   143: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   146: invokevirtual 163	android/media/MediaPlayer:start	()V
    //   149: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   152: iload_1
    //   153: invokevirtual 169	android/media/MediaPlayer:setLooping	(Z)V
    //   156: aload_0
    //   157: invokevirtual 310	java/io/FileInputStream:close	()V
    //   160: goto +78 -> 238
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   168: goto +70 -> 238
    //   171: astore 4
    //   173: aload_0
    //   174: astore_3
    //   175: aload 4
    //   177: astore_0
    //   178: goto +64 -> 242
    //   181: astore 4
    //   183: goto +12 -> 195
    //   186: astore_0
    //   187: goto +55 -> 242
    //   190: astore 4
    //   192: aload 5
    //   194: astore_0
    //   195: aload_0
    //   196: astore_3
    //   197: aload 4
    //   199: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   202: aload_0
    //   203: astore_3
    //   204: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +16 -> 223
    //   210: aload_0
    //   211: astore_3
    //   212: ldc 110
    //   214: iconst_2
    //   215: ldc_w 324
    //   218: aload 4
    //   220: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   223: aload_0
    //   224: ifnull +14 -> 238
    //   227: aload_0
    //   228: invokevirtual 310	java/io/FileInputStream:close	()V
    //   231: goto +7 -> 238
    //   234: astore_0
    //   235: goto -71 -> 164
    //   238: ldc 2
    //   240: monitorexit
    //   241: return
    //   242: aload_3
    //   243: ifnull +15 -> 258
    //   246: aload_3
    //   247: invokevirtual 310	java/io/FileInputStream:close	()V
    //   250: goto +8 -> 258
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   258: aload_0
    //   259: athrow
    //   260: astore_0
    //   261: ldc 2
    //   263: monitorexit
    //   264: goto +5 -> 269
    //   267: aload_0
    //   268: athrow
    //   269: goto -2 -> 267
    //   272: astore_3
    //   273: goto -231 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   0	276	1	paramBoolean	boolean
    //   27	2	2	bool	boolean
    //   11	236	3	localObject1	Object
    //   253	2	3	localIOException	IOException
    //   272	1	3	localException1	Exception
    //   7	90	4	localObject2	Object
    //   171	5	4	localObject3	Object
    //   181	1	4	localException2	Exception
    //   190	29	4	localException3	Exception
    //   4	189	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	42	52	finally
    //   156	160	163	java/io/IOException
    //   108	156	171	finally
    //   108	156	181	java/lang/Exception
    //   12	18	186	finally
    //   21	28	186	finally
    //   45	49	186	finally
    //   56	60	186	finally
    //   63	65	186	finally
    //   68	74	186	finally
    //   77	87	186	finally
    //   90	96	186	finally
    //   99	108	186	finally
    //   197	202	186	finally
    //   204	210	186	finally
    //   212	223	186	finally
    //   12	18	190	java/lang/Exception
    //   21	28	190	java/lang/Exception
    //   45	49	190	java/lang/Exception
    //   56	60	190	java/lang/Exception
    //   63	65	190	java/lang/Exception
    //   68	74	190	java/lang/Exception
    //   77	87	190	java/lang/Exception
    //   90	96	190	java/lang/Exception
    //   99	108	190	java/lang/Exception
    //   227	231	234	java/io/IOException
    //   246	250	253	java/io/IOException
    //   156	160	260	finally
    //   164	168	260	finally
    //   227	231	260	finally
    //   246	250	260	finally
    //   254	258	260	finally
    //   258	260	260	finally
    //   36	42	272	java/lang/Exception
  }
  
  private static boolean a()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean a(int paramInt)
  {
    return a(paramInt, BaseApplication.getContext());
  }
  
  public static boolean a(int paramInt, Context paramContext)
  {
    boolean bool2 = a();
    boolean bool1 = false;
    if (bool2)
    {
      if (Build.VERSION.SDK_INT < 17) {
        return false;
      }
      paramContext = paramContext.getSystemService("appops");
      if ((paramContext != null) && (paramContext.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = paramContext.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = b[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i = jdField_a_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplication.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(paramContext, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("isForbidByRubbishMeizu(), result = ");
            paramContext.append(paramInt);
            QLog.d("AudioUtil", 2, paramContext.toString());
          }
          if (paramInt != 0) {
            bool1 = true;
          }
          return bool1;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AudioUtil", 2, paramContext.toString());
          }
        }
      }
    }
    return false;
  }
  
  /* Error */
  public static void b(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +48 -> 54
    //   9: new 171	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   16: astore_2
    //   17: aload_2
    //   18: ldc 220
    //   20: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: iload_0
    //   26: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: ldc 225
    //   33: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: iload_1
    //   39: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: ldc_w 267
    //   46: iconst_2
    //   47: aload_2
    //   48: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   57: ifnull +74 -> 131
    //   60: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   63: invokevirtual 130	android/media/MediaPlayer:isPlaying	()Z
    //   66: ifeq +22 -> 88
    //   69: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +12 -> 84
    //   75: ldc_w 267
    //   78: iconst_2
    //   79: ldc 229
    //   81: invokestatic 232	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: ldc 2
    //   86: monitorexit
    //   87: return
    //   88: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   91: invokevirtual 102	android/media/MediaPlayer:release	()V
    //   94: aconst_null
    //   95: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   98: goto +33 -> 131
    //   101: astore_2
    //   102: goto +23 -> 125
    //   105: astore_2
    //   106: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq -15 -> 94
    //   112: ldc_w 267
    //   115: iconst_2
    //   116: ldc 234
    //   118: aload_2
    //   119: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: goto -28 -> 94
    //   125: aconst_null
    //   126: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   129: aload_2
    //   130: athrow
    //   131: iload_0
    //   132: getstatic 136	com/tencent/common/config/AppSetting:d	I
    //   135: if_icmpeq +16 -> 151
    //   138: invokestatic 28	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   141: iload_0
    //   142: invokestatic 141	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   145: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   148: goto +55 -> 203
    //   151: invokestatic 28	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   154: getstatic 149	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   157: invokestatic 151	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   160: putstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   163: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +37 -> 203
    //   169: new 171	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   176: astore_2
    //   177: aload_2
    //   178: ldc 240
    //   180: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: getstatic 149	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   188: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: ldc_w 267
    //   195: iconst_2
    //   196: aload_2
    //   197: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   206: ifnonnull +22 -> 228
    //   209: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +12 -> 224
    //   215: ldc_w 267
    //   218: iconst_2
    //   219: ldc 245
    //   221: invokestatic 232	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: ldc 2
    //   226: monitorexit
    //   227: return
    //   228: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   231: new 403	com/tencent/mobileqq/utils/AudioUtil$3
    //   234: dup
    //   235: invokespecial 404	com/tencent/mobileqq/utils/AudioUtil$3:<init>	()V
    //   238: invokevirtual 160	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   241: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   244: invokevirtual 163	android/media/MediaPlayer:start	()V
    //   247: getstatic 117	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   250: iload_1
    //   251: invokevirtual 169	android/media/MediaPlayer:setLooping	(Z)V
    //   254: goto +24 -> 278
    //   257: astore_2
    //   258: goto +24 -> 282
    //   261: astore_2
    //   262: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +13 -> 278
    //   268: ldc_w 267
    //   271: iconst_2
    //   272: ldc 250
    //   274: aload_2
    //   275: invokestatic 188	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   278: ldc 2
    //   280: monitorexit
    //   281: return
    //   282: ldc 2
    //   284: monitorexit
    //   285: goto +5 -> 290
    //   288: aload_2
    //   289: athrow
    //   290: goto -2 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramInt	int
    //   0	293	1	paramBoolean	boolean
    //   16	32	2	localStringBuilder1	StringBuilder
    //   101	1	2	localObject1	Object
    //   105	25	2	localException1	Exception
    //   176	21	2	localStringBuilder2	StringBuilder
    //   257	1	2	localObject2	Object
    //   261	28	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   88	94	101	finally
    //   106	122	101	finally
    //   88	94	105	java/lang/Exception
    //   3	54	257	finally
    //   54	84	257	finally
    //   94	98	257	finally
    //   125	131	257	finally
    //   131	148	257	finally
    //   151	203	257	finally
    //   203	224	257	finally
    //   228	254	257	finally
    //   262	278	257	finally
    //   3	54	261	java/lang/Exception
    //   54	84	261	java/lang/Exception
    //   94	98	261	java/lang/Exception
    //   125	131	261	java/lang/Exception
    //   131	148	261	java/lang/Exception
    //   151	203	261	java/lang/Exception
    //   203	224	261	java/lang/Exception
    //   228	254	261	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil
 * JD-Core Version:    0.7.0.1
 */