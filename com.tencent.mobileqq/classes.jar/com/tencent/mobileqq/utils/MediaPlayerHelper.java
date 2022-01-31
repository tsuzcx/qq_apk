package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import java.io.IOException;

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
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: invokevirtual 23	android/media/MediaPlayer:stop	()V
    //   21: aload_0
    //   22: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   25: invokevirtual 26	android/media/MediaPlayer:release	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   36	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   14	33	36	finally
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
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
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 37	android/media/MediaPlayer:start	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 40	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  public boolean a(Context paramContext, Uri paramUri)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramContext, paramUri);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        bool = true;
      }
      catch (IllegalStateException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (SecurityException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      return bool;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
  }
  
  /* Error */
  public boolean a(Context paramContext, java.lang.String paramString, com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.PreparedListener paramPreparedListener)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   9: ifnonnull +91 -> 100
    //   12: aload_0
    //   13: new 20	android/media/MediaPlayer
    //   16: dup
    //   17: invokespecial 28	android/media/MediaPlayer:<init>	()V
    //   20: putfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: aconst_null
    //   24: astore 7
    //   26: aconst_null
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 10
    //   32: aconst_null
    //   33: astore 9
    //   35: aload 10
    //   37: astore 6
    //   39: aload_0
    //   40: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   43: iconst_3
    //   44: invokevirtual 51	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   47: aload 10
    //   49: astore 6
    //   51: new 67	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokevirtual 73	android/content/Context:getFilesDir	()Ljava/io/File;
    //   59: aload_2
    //   60: invokespecial 76	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload 10
    //   66: astore 6
    //   68: aload_1
    //   69: invokevirtual 79	java/io/File:exists	()Z
    //   72: istore 4
    //   74: iload 4
    //   76: ifne +39 -> 115
    //   79: iload 5
    //   81: istore 4
    //   83: iconst_0
    //   84: ifeq +11 -> 95
    //   87: new 81	java/lang/NullPointerException
    //   90: dup
    //   91: invokespecial 82	java/lang/NullPointerException:<init>	()V
    //   94: athrow
    //   95: aload_0
    //   96: monitorexit
    //   97: iload 4
    //   99: ireturn
    //   100: aload_0
    //   101: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   104: invokevirtual 61	android/media/MediaPlayer:reset	()V
    //   107: goto -84 -> 23
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: aload 10
    //   117: astore 6
    //   119: new 84	java/io/FileInputStream
    //   122: dup
    //   123: aload_1
    //   124: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   130: astore_1
    //   131: aload_1
    //   132: astore_2
    //   133: aload_0
    //   134: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   137: aload_1
    //   138: invokevirtual 95	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   141: invokevirtual 98	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   144: aload_1
    //   145: astore_2
    //   146: aload_0
    //   147: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   150: invokevirtual 101	android/media/MediaPlayer:prepareAsync	()V
    //   153: aload_1
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   159: aload_3
    //   160: invokevirtual 105	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   163: aload_1
    //   164: astore_2
    //   165: aload_1
    //   166: invokevirtual 108	java/io/FileInputStream:close	()V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 108	java/io/FileInputStream:close	()V
    //   177: iconst_1
    //   178: istore 4
    //   180: goto -85 -> 95
    //   183: astore 6
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: astore_2
    //   189: aload 6
    //   191: invokevirtual 40	java/lang/IllegalStateException:printStackTrace	()V
    //   194: aload_1
    //   195: astore_2
    //   196: aload_3
    //   197: invokevirtual 112	com/tencent/mobileqq/activity/specialcare/VipSpecialSoundWebViewPlugin$PreparedListener:a	()V
    //   200: iload 5
    //   202: istore 4
    //   204: aload_1
    //   205: ifnull -110 -> 95
    //   208: aload_1
    //   209: invokevirtual 108	java/io/FileInputStream:close	()V
    //   212: iload 5
    //   214: istore 4
    //   216: goto -121 -> 95
    //   219: astore_1
    //   220: iload 5
    //   222: istore 4
    //   224: goto -129 -> 95
    //   227: astore_2
    //   228: aload 9
    //   230: astore_1
    //   231: aload_1
    //   232: astore 6
    //   234: aload_2
    //   235: invokevirtual 62	java/io/IOException:printStackTrace	()V
    //   238: aload_1
    //   239: astore 6
    //   241: aload_3
    //   242: invokevirtual 112	com/tencent/mobileqq/activity/specialcare/VipSpecialSoundWebViewPlugin$PreparedListener:a	()V
    //   245: iload 5
    //   247: istore 4
    //   249: aload_1
    //   250: ifnull -155 -> 95
    //   253: aload_1
    //   254: invokevirtual 108	java/io/FileInputStream:close	()V
    //   257: iload 5
    //   259: istore 4
    //   261: goto -166 -> 95
    //   264: astore_1
    //   265: iload 5
    //   267: istore 4
    //   269: goto -174 -> 95
    //   272: astore_2
    //   273: aload 7
    //   275: astore_1
    //   276: aload_1
    //   277: astore 6
    //   279: aload_2
    //   280: invokevirtual 63	java/lang/IllegalArgumentException:printStackTrace	()V
    //   283: aload_1
    //   284: astore 6
    //   286: aload_3
    //   287: invokevirtual 112	com/tencent/mobileqq/activity/specialcare/VipSpecialSoundWebViewPlugin$PreparedListener:a	()V
    //   290: iload 5
    //   292: istore 4
    //   294: aload_1
    //   295: ifnull -200 -> 95
    //   298: aload_1
    //   299: invokevirtual 108	java/io/FileInputStream:close	()V
    //   302: iload 5
    //   304: istore 4
    //   306: goto -211 -> 95
    //   309: astore_1
    //   310: iload 5
    //   312: istore 4
    //   314: goto -219 -> 95
    //   317: astore_2
    //   318: aload 8
    //   320: astore_1
    //   321: aload_1
    //   322: astore 6
    //   324: aload_2
    //   325: invokevirtual 64	java/lang/SecurityException:printStackTrace	()V
    //   328: aload_1
    //   329: astore 6
    //   331: aload_3
    //   332: invokevirtual 112	com/tencent/mobileqq/activity/specialcare/VipSpecialSoundWebViewPlugin$PreparedListener:a	()V
    //   335: iload 5
    //   337: istore 4
    //   339: aload_1
    //   340: ifnull -245 -> 95
    //   343: aload_1
    //   344: invokevirtual 108	java/io/FileInputStream:close	()V
    //   347: iload 5
    //   349: istore 4
    //   351: goto -256 -> 95
    //   354: astore_1
    //   355: iload 5
    //   357: istore 4
    //   359: goto -264 -> 95
    //   362: astore_1
    //   363: aload 6
    //   365: astore_2
    //   366: aload_2
    //   367: ifnull +7 -> 374
    //   370: aload_2
    //   371: invokevirtual 108	java/io/FileInputStream:close	()V
    //   374: aload_1
    //   375: athrow
    //   376: astore_1
    //   377: iload 5
    //   379: istore 4
    //   381: goto -286 -> 95
    //   384: astore_1
    //   385: goto -208 -> 177
    //   388: astore_2
    //   389: goto -15 -> 374
    //   392: astore_1
    //   393: goto -27 -> 366
    //   396: astore_2
    //   397: goto -76 -> 321
    //   400: astore_2
    //   401: goto -125 -> 276
    //   404: astore_2
    //   405: goto -174 -> 231
    //   408: astore 6
    //   410: goto -223 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	MediaPlayerHelper
    //   0	413	1	paramContext	Context
    //   0	413	2	paramString	java.lang.String
    //   0	413	3	paramPreparedListener	com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.PreparedListener
    //   72	308	4	bool1	boolean
    //   1	377	5	bool2	boolean
    //   37	81	6	localObject1	Object
    //   183	7	6	localIllegalStateException1	IllegalStateException
    //   232	132	6	localContext	Context
    //   408	1	6	localIllegalStateException2	IllegalStateException
    //   24	250	7	localObject2	Object
    //   27	292	8	localObject3	Object
    //   33	196	9	localObject4	Object
    //   30	86	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   5	23	110	finally
    //   87	95	110	finally
    //   100	107	110	finally
    //   173	177	110	finally
    //   208	212	110	finally
    //   253	257	110	finally
    //   298	302	110	finally
    //   343	347	110	finally
    //   370	374	110	finally
    //   374	376	110	finally
    //   39	47	183	java/lang/IllegalStateException
    //   51	64	183	java/lang/IllegalStateException
    //   68	74	183	java/lang/IllegalStateException
    //   119	131	183	java/lang/IllegalStateException
    //   208	212	219	java/io/IOException
    //   39	47	227	java/io/IOException
    //   51	64	227	java/io/IOException
    //   68	74	227	java/io/IOException
    //   119	131	227	java/io/IOException
    //   253	257	264	java/io/IOException
    //   39	47	272	java/lang/IllegalArgumentException
    //   51	64	272	java/lang/IllegalArgumentException
    //   68	74	272	java/lang/IllegalArgumentException
    //   119	131	272	java/lang/IllegalArgumentException
    //   298	302	309	java/io/IOException
    //   39	47	317	java/lang/SecurityException
    //   51	64	317	java/lang/SecurityException
    //   68	74	317	java/lang/SecurityException
    //   119	131	317	java/lang/SecurityException
    //   343	347	354	java/io/IOException
    //   39	47	362	finally
    //   51	64	362	finally
    //   68	74	362	finally
    //   119	131	362	finally
    //   234	238	362	finally
    //   241	245	362	finally
    //   279	283	362	finally
    //   286	290	362	finally
    //   324	328	362	finally
    //   331	335	362	finally
    //   87	95	376	java/io/IOException
    //   173	177	384	java/io/IOException
    //   370	374	388	java/io/IOException
    //   133	144	392	finally
    //   146	153	392	finally
    //   155	163	392	finally
    //   165	169	392	finally
    //   189	194	392	finally
    //   196	200	392	finally
    //   133	144	396	java/lang/SecurityException
    //   146	153	396	java/lang/SecurityException
    //   155	163	396	java/lang/SecurityException
    //   165	169	396	java/lang/SecurityException
    //   133	144	400	java/lang/IllegalArgumentException
    //   146	153	400	java/lang/IllegalArgumentException
    //   155	163	400	java/lang/IllegalArgumentException
    //   165	169	400	java/lang/IllegalArgumentException
    //   133	144	404	java/io/IOException
    //   146	153	404	java/io/IOException
    //   155	163	404	java/io/IOException
    //   165	169	404	java/io/IOException
    //   133	144	408	java/lang/IllegalStateException
    //   146	153	408	java/lang/IllegalStateException
    //   155	163	408	java/lang/IllegalStateException
    //   165	169	408	java/lang/IllegalStateException
  }
  
  /* Error */
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +9 -> 19
    //   13: iload_2
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: iload_1
    //   24: invokevirtual 117	android/media/MediaPlayer:setLooping	(Z)V
    //   27: iconst_1
    //   28: istore_1
    //   29: goto -14 -> 15
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 40	java/lang/IllegalStateException:printStackTrace	()V
    //   37: iload_2
    //   38: istore_1
    //   39: goto -24 -> 15
    //   42: astore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_3
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	MediaPlayerHelper
    //   0	47	1	paramBoolean	boolean
    //   1	37	2	bool	boolean
    //   8	2	3	localMediaPlayer	MediaPlayer
    //   32	2	3	localIllegalStateException	IllegalStateException
    //   42	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	27	32	java/lang/IllegalStateException
    //   4	9	42	finally
    //   19	27	42	finally
    //   33	37	42	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 23	android/media/MediaPlayer:stop	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 40	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 122	android/media/MediaPlayer:pause	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 40	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 18	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 126	android/media/MediaPlayer:isPlaying	()Z
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MediaPlayerHelper
    //   12	13	1	bool	boolean
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MediaPlayerHelper
 * JD-Core Version:    0.7.0.1
 */