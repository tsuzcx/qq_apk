package com.tencent.mobileqq.utils;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

public class MediaPlayerHelper
{
  private static MediaPlayerHelper jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  
  public static MediaPlayerHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper == null) {
      jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper = new MediaPlayerHelper();
    }
    return jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
  }
  
  public void a()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if (localMediaPlayer == null) {
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return;
    }
    finally {}
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   19: invokevirtual 42	android/media/MediaPlayer:start	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_1
    //   25: ireturn
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 45	java/lang/IllegalStateException:printStackTrace	()V
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   26	2	1	localIllegalStateException	java.lang.IllegalStateException
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	22	26	java/lang/IllegalStateException
    //   2	7	35	finally
    //   15	22	35	finally
    //   27	31	35	finally
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnonnull +17 -> 23
    //   9: aload_0
    //   10: new 32	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   13: dup
    //   14: invokespecial 33	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   17: putfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   20: goto +10 -> 30
    //   23: aload_0
    //   24: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   27: invokevirtual 26	android/media/MediaPlayer:reset	()V
    //   30: aload_0
    //   31: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   34: iconst_3
    //   35: invokevirtual 56	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   38: aload_0
    //   39: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   42: aload_1
    //   43: aload_2
    //   44: invokevirtual 60	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   47: aload_0
    //   48: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   51: invokevirtual 63	android/media/MediaPlayer:prepare	()V
    //   54: aload_0
    //   55: monitorexit
    //   56: iconst_1
    //   57: ireturn
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 64	java/lang/SecurityException:printStackTrace	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 65	java/lang/IllegalArgumentException:printStackTrace	()V
    //   72: aload_0
    //   73: monitorexit
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   81: aload_0
    //   82: monitorexit
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 45	java/lang/IllegalStateException:printStackTrace	()V
    //   90: aload_0
    //   91: monitorexit
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	MediaPlayerHelper
    //   0	99	1	paramContext	android.content.Context
    //   0	99	2	paramUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   30	54	58	java/lang/SecurityException
    //   30	54	67	java/lang/IllegalArgumentException
    //   30	54	76	java/io/IOException
    //   30	54	85	java/lang/IllegalStateException
    //   2	20	94	finally
    //   23	30	94	finally
    //   30	54	94	finally
    //   59	63	94	finally
    //   68	72	94	finally
    //   77	81	94	finally
    //   86	90	94	finally
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext, java.lang.String paramString, com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.PreparedListener paramPreparedListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnonnull +17 -> 23
    //   9: aload_0
    //   10: new 32	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   13: dup
    //   14: invokespecial 33	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   17: putfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   20: goto +10 -> 30
    //   23: aload_0
    //   24: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   27: invokevirtual 26	android/media/MediaPlayer:reset	()V
    //   30: aload_0
    //   31: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   34: iconst_3
    //   35: invokevirtual 56	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   38: new 69	java/io/File
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 75	java/io/File:exists	()Z
    //   51: istore 4
    //   53: iload 4
    //   55: ifne +7 -> 62
    //   58: aload_0
    //   59: monitorexit
    //   60: iconst_0
    //   61: ireturn
    //   62: new 77	java/io/FileInputStream
    //   65: dup
    //   66: aload_1
    //   67: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   70: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   73: astore_2
    //   74: aload_2
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   80: aload_2
    //   81: invokevirtual 86	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   84: invokevirtual 89	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   87: aload_2
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   93: aload_3
    //   94: invokevirtual 93	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   97: aload_2
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   103: invokevirtual 96	android/media/MediaPlayer:prepareAsync	()V
    //   106: aload_2
    //   107: astore_1
    //   108: aload_2
    //   109: invokevirtual 99	java/io/FileInputStream:close	()V
    //   112: aload_2
    //   113: invokevirtual 99	java/io/FileInputStream:close	()V
    //   116: aload_0
    //   117: monitorexit
    //   118: iconst_1
    //   119: ireturn
    //   120: astore 5
    //   122: goto +28 -> 150
    //   125: astore 5
    //   127: goto +52 -> 179
    //   130: astore 5
    //   132: goto +76 -> 208
    //   135: astore 5
    //   137: goto +100 -> 237
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_2
    //   143: goto +124 -> 267
    //   146: astore 5
    //   148: aconst_null
    //   149: astore_2
    //   150: aload_2
    //   151: astore_1
    //   152: aload 5
    //   154: invokevirtual 64	java/lang/SecurityException:printStackTrace	()V
    //   157: aload_2
    //   158: astore_1
    //   159: aload_3
    //   160: invokevirtual 103	com/tencent/mobileqq/activity/specialcare/VipSpecialSoundWebViewPlugin$PreparedListener:a	()V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 99	java/io/FileInputStream:close	()V
    //   171: aload_0
    //   172: monitorexit
    //   173: iconst_0
    //   174: ireturn
    //   175: astore 5
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_2
    //   180: astore_1
    //   181: aload 5
    //   183: invokevirtual 65	java/lang/IllegalArgumentException:printStackTrace	()V
    //   186: aload_2
    //   187: astore_1
    //   188: aload_3
    //   189: invokevirtual 103	com/tencent/mobileqq/activity/specialcare/VipSpecialSoundWebViewPlugin$PreparedListener:a	()V
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 99	java/io/FileInputStream:close	()V
    //   200: aload_0
    //   201: monitorexit
    //   202: iconst_0
    //   203: ireturn
    //   204: astore 5
    //   206: aconst_null
    //   207: astore_2
    //   208: aload_2
    //   209: astore_1
    //   210: aload 5
    //   212: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   215: aload_2
    //   216: astore_1
    //   217: aload_3
    //   218: invokevirtual 103	com/tencent/mobileqq/activity/specialcare/VipSpecialSoundWebViewPlugin$PreparedListener:a	()V
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 99	java/io/FileInputStream:close	()V
    //   229: aload_0
    //   230: monitorexit
    //   231: iconst_0
    //   232: ireturn
    //   233: astore 5
    //   235: aconst_null
    //   236: astore_2
    //   237: aload_2
    //   238: astore_1
    //   239: aload 5
    //   241: invokevirtual 45	java/lang/IllegalStateException:printStackTrace	()V
    //   244: aload_2
    //   245: astore_1
    //   246: aload_3
    //   247: invokevirtual 103	com/tencent/mobileqq/activity/specialcare/VipSpecialSoundWebViewPlugin$PreparedListener:a	()V
    //   250: aload_2
    //   251: ifnull +7 -> 258
    //   254: aload_2
    //   255: invokevirtual 99	java/io/FileInputStream:close	()V
    //   258: aload_0
    //   259: monitorexit
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_3
    //   263: aload_1
    //   264: astore_2
    //   265: aload_3
    //   266: astore_1
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 99	java/io/FileInputStream:close	()V
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: aload_0
    //   279: monitorexit
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: goto -167 -> 116
    //   286: astore_1
    //   287: goto -116 -> 171
    //   290: astore_1
    //   291: goto -91 -> 200
    //   294: astore_1
    //   295: goto -66 -> 229
    //   298: astore_1
    //   299: goto -41 -> 258
    //   302: astore_2
    //   303: goto -28 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	MediaPlayerHelper
    //   0	306	1	paramContext	android.content.Context
    //   0	306	2	paramString	java.lang.String
    //   0	306	3	paramPreparedListener	com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.PreparedListener
    //   51	3	4	bool	boolean
    //   120	1	5	localSecurityException1	java.lang.SecurityException
    //   125	1	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   130	1	5	localIOException1	java.io.IOException
    //   135	1	5	localIllegalStateException1	java.lang.IllegalStateException
    //   146	7	5	localSecurityException2	java.lang.SecurityException
    //   175	7	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   204	7	5	localIOException2	java.io.IOException
    //   233	7	5	localIllegalStateException2	java.lang.IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   76	87	120	java/lang/SecurityException
    //   89	97	120	java/lang/SecurityException
    //   99	106	120	java/lang/SecurityException
    //   108	112	120	java/lang/SecurityException
    //   76	87	125	java/lang/IllegalArgumentException
    //   89	97	125	java/lang/IllegalArgumentException
    //   99	106	125	java/lang/IllegalArgumentException
    //   108	112	125	java/lang/IllegalArgumentException
    //   76	87	130	java/io/IOException
    //   89	97	130	java/io/IOException
    //   99	106	130	java/io/IOException
    //   108	112	130	java/io/IOException
    //   76	87	135	java/lang/IllegalStateException
    //   89	97	135	java/lang/IllegalStateException
    //   99	106	135	java/lang/IllegalStateException
    //   108	112	135	java/lang/IllegalStateException
    //   30	53	140	finally
    //   62	74	140	finally
    //   30	53	146	java/lang/SecurityException
    //   62	74	146	java/lang/SecurityException
    //   30	53	175	java/lang/IllegalArgumentException
    //   62	74	175	java/lang/IllegalArgumentException
    //   30	53	204	java/io/IOException
    //   62	74	204	java/io/IOException
    //   30	53	233	java/lang/IllegalStateException
    //   62	74	233	java/lang/IllegalStateException
    //   76	87	262	finally
    //   89	97	262	finally
    //   99	106	262	finally
    //   108	112	262	finally
    //   152	157	262	finally
    //   159	163	262	finally
    //   181	186	262	finally
    //   188	192	262	finally
    //   210	215	262	finally
    //   217	221	262	finally
    //   239	244	262	finally
    //   246	250	262	finally
    //   2	20	277	finally
    //   23	30	277	finally
    //   112	116	277	finally
    //   167	171	277	finally
    //   196	200	277	finally
    //   225	229	277	finally
    //   254	258	277	finally
    //   271	275	277	finally
    //   275	277	277	finally
    //   112	116	282	java/io/IOException
    //   167	171	286	java/io/IOException
    //   196	200	290	java/io/IOException
    //   225	229	294	java/io/IOException
    //   254	258	298	java/io/IOException
    //   271	275	302	java/io/IOException
  }
  
  /* Error */
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   19: iload_1
    //   20: invokevirtual 108	android/media/MediaPlayer:setLooping	(Z)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iconst_1
    //   26: ireturn
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 45	java/lang/IllegalStateException:printStackTrace	()V
    //   32: aload_0
    //   33: monitorexit
    //   34: iconst_0
    //   35: ireturn
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	MediaPlayerHelper
    //   0	41	1	paramBoolean	boolean
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   27	2	2	localIllegalStateException	java.lang.IllegalStateException
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	23	27	java/lang/IllegalStateException
    //   2	7	36	finally
    //   15	23	36	finally
    //   28	32	36	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   19: invokevirtual 23	android/media/MediaPlayer:stop	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_1
    //   25: ireturn
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 45	java/lang/IllegalStateException:printStackTrace	()V
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   26	2	1	localIllegalStateException	java.lang.IllegalStateException
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	22	26	java/lang/IllegalStateException
    //   2	7	35	finally
    //   15	22	35	finally
    //   27	31	35	finally
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   19: invokevirtual 113	android/media/MediaPlayer:pause	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_1
    //   25: ireturn
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 45	java/lang/IllegalStateException:printStackTrace	()V
    //   31: aload_0
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   26	2	1	localIllegalStateException	java.lang.IllegalStateException
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	22	26	java/lang/IllegalStateException
    //   2	7	35	finally
    //   15	22	35	finally
    //   27	31	35	finally
  }
  
  public boolean d()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if (localMediaPlayer == null) {
        return false;
      }
      boolean bool = this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MediaPlayerHelper
 * JD-Core Version:    0.7.0.1
 */