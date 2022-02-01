package cooperation.qzone.webviewplugin.sound;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import java.io.IOException;

public class QzoneSoundPlayerHelper
{
  private MediaPlayer mp;
  
  /* Error */
  public int getCurrentPosition()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_m1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   21: invokevirtual 19	android/media/MediaPlayer:getCurrentPosition	()I
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	QzoneSoundPlayerHelper
    //   12	13	1	i	int
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public int getDuration()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_m1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   21: invokevirtual 22	android/media/MediaPlayer:getDuration	()I
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	QzoneSoundPlayerHelper
    //   12	13	1	i	int
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public boolean isPlaying()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
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
    //   18: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   21: invokevirtual 26	android/media/MediaPlayer:isPlaying	()Z
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	QzoneSoundPlayerHelper
    //   12	13	1	bool	boolean
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public boolean pause()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   21: invokevirtual 31	android/media/MediaPlayer:pause	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	QzoneSoundPlayerHelper
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
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   18: invokevirtual 38	android/media/MediaPlayer:stop	()V
    //   21: aload_0
    //   22: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   25: invokevirtual 40	android/media/MediaPlayer:release	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	QzoneSoundPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   36	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   14	33	36	finally
  }
  
  public boolean setDataSource(Context paramContext, Uri paramUri)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.mp == null) {
          this.mp = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        this.mp.setAudioStreamType(3);
        this.mp.setDataSource(paramContext, paramUri);
        this.mp.prepare();
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
      this.mp.reset();
    }
  }
  
  /* Error */
  public boolean setDataSource(Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   9: ifnonnull +87 -> 96
    //   12: aload_0
    //   13: new 17	android/media/MediaPlayer
    //   16: dup
    //   17: invokespecial 49	android/media/MediaPlayer:<init>	()V
    //   20: putfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   23: aconst_null
    //   24: astore 7
    //   26: aconst_null
    //   27: astore 8
    //   29: aconst_null
    //   30: astore 9
    //   32: aconst_null
    //   33: astore 6
    //   35: aload 9
    //   37: astore 5
    //   39: aload_0
    //   40: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   43: iconst_3
    //   44: invokevirtual 53	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   47: aload 9
    //   49: astore 5
    //   51: new 68	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokevirtual 74	android/content/Context:getFilesDir	()Ljava/io/File;
    //   59: aload_2
    //   60: invokespecial 77	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload 9
    //   66: astore 5
    //   68: aload_1
    //   69: invokevirtual 80	java/io/File:exists	()Z
    //   72: istore_3
    //   73: iload_3
    //   74: ifne +37 -> 111
    //   77: iload 4
    //   79: istore_3
    //   80: iconst_0
    //   81: ifeq +11 -> 92
    //   84: new 82	java/lang/NullPointerException
    //   87: dup
    //   88: invokespecial 83	java/lang/NullPointerException:<init>	()V
    //   91: athrow
    //   92: aload_0
    //   93: monitorexit
    //   94: iload_3
    //   95: ireturn
    //   96: aload_0
    //   97: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   100: invokevirtual 62	android/media/MediaPlayer:reset	()V
    //   103: goto -80 -> 23
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    //   111: aload 9
    //   113: astore 5
    //   115: new 85	java/io/FileInputStream
    //   118: dup
    //   119: aload_1
    //   120: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   126: astore_1
    //   127: aload_1
    //   128: astore_2
    //   129: aload_0
    //   130: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   133: aload_1
    //   134: invokevirtual 96	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   137: invokevirtual 99	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   140: aload_1
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   146: invokevirtual 59	android/media/MediaPlayer:prepare	()V
    //   149: aload_1
    //   150: astore_2
    //   151: aload_1
    //   152: invokevirtual 102	java/io/FileInputStream:close	()V
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 102	java/io/FileInputStream:close	()V
    //   163: iconst_1
    //   164: istore_3
    //   165: goto -73 -> 92
    //   168: astore 5
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_1
    //   173: astore_2
    //   174: aload 5
    //   176: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
    //   179: iload 4
    //   181: istore_3
    //   182: aload_1
    //   183: ifnull -91 -> 92
    //   186: aload_1
    //   187: invokevirtual 102	java/io/FileInputStream:close	()V
    //   190: iload 4
    //   192: istore_3
    //   193: goto -101 -> 92
    //   196: astore_1
    //   197: iload 4
    //   199: istore_3
    //   200: goto -108 -> 92
    //   203: astore_2
    //   204: aload 6
    //   206: astore_1
    //   207: aload_1
    //   208: astore 5
    //   210: aload_2
    //   211: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   214: iload 4
    //   216: istore_3
    //   217: aload_1
    //   218: ifnull -126 -> 92
    //   221: aload_1
    //   222: invokevirtual 102	java/io/FileInputStream:close	()V
    //   225: iload 4
    //   227: istore_3
    //   228: goto -136 -> 92
    //   231: astore_1
    //   232: iload 4
    //   234: istore_3
    //   235: goto -143 -> 92
    //   238: astore_2
    //   239: aload 7
    //   241: astore_1
    //   242: aload_1
    //   243: astore 5
    //   245: aload_2
    //   246: invokevirtual 64	java/lang/IllegalArgumentException:printStackTrace	()V
    //   249: iload 4
    //   251: istore_3
    //   252: aload_1
    //   253: ifnull -161 -> 92
    //   256: aload_1
    //   257: invokevirtual 102	java/io/FileInputStream:close	()V
    //   260: iload 4
    //   262: istore_3
    //   263: goto -171 -> 92
    //   266: astore_1
    //   267: iload 4
    //   269: istore_3
    //   270: goto -178 -> 92
    //   273: astore_2
    //   274: aload 8
    //   276: astore_1
    //   277: aload_1
    //   278: astore 5
    //   280: aload_2
    //   281: invokevirtual 65	java/lang/SecurityException:printStackTrace	()V
    //   284: iload 4
    //   286: istore_3
    //   287: aload_1
    //   288: ifnull -196 -> 92
    //   291: aload_1
    //   292: invokevirtual 102	java/io/FileInputStream:close	()V
    //   295: iload 4
    //   297: istore_3
    //   298: goto -206 -> 92
    //   301: astore_1
    //   302: iload 4
    //   304: istore_3
    //   305: goto -213 -> 92
    //   308: astore_1
    //   309: aload 5
    //   311: ifnull +8 -> 319
    //   314: aload 5
    //   316: invokevirtual 102	java/io/FileInputStream:close	()V
    //   319: aload_1
    //   320: athrow
    //   321: astore_1
    //   322: iload 4
    //   324: istore_3
    //   325: goto -233 -> 92
    //   328: astore_1
    //   329: goto -166 -> 163
    //   332: astore_2
    //   333: goto -14 -> 319
    //   336: astore_1
    //   337: aload_2
    //   338: astore 5
    //   340: goto -31 -> 309
    //   343: astore_2
    //   344: goto -67 -> 277
    //   347: astore_2
    //   348: goto -106 -> 242
    //   351: astore_2
    //   352: goto -145 -> 207
    //   355: astore 5
    //   357: goto -185 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	QzoneSoundPlayerHelper
    //   0	360	1	paramContext	Context
    //   0	360	2	paramString	java.lang.String
    //   72	253	3	bool1	boolean
    //   1	322	4	bool2	boolean
    //   37	77	5	localObject1	Object
    //   168	7	5	localIllegalStateException1	IllegalStateException
    //   208	131	5	localObject2	Object
    //   355	1	5	localIllegalStateException2	IllegalStateException
    //   33	172	6	localObject3	Object
    //   24	216	7	localObject4	Object
    //   27	248	8	localObject5	Object
    //   30	82	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   5	23	106	finally
    //   84	92	106	finally
    //   96	103	106	finally
    //   159	163	106	finally
    //   186	190	106	finally
    //   221	225	106	finally
    //   256	260	106	finally
    //   291	295	106	finally
    //   314	319	106	finally
    //   319	321	106	finally
    //   39	47	168	java/lang/IllegalStateException
    //   51	64	168	java/lang/IllegalStateException
    //   68	73	168	java/lang/IllegalStateException
    //   115	127	168	java/lang/IllegalStateException
    //   186	190	196	java/io/IOException
    //   39	47	203	java/io/IOException
    //   51	64	203	java/io/IOException
    //   68	73	203	java/io/IOException
    //   115	127	203	java/io/IOException
    //   221	225	231	java/io/IOException
    //   39	47	238	java/lang/IllegalArgumentException
    //   51	64	238	java/lang/IllegalArgumentException
    //   68	73	238	java/lang/IllegalArgumentException
    //   115	127	238	java/lang/IllegalArgumentException
    //   256	260	266	java/io/IOException
    //   39	47	273	java/lang/SecurityException
    //   51	64	273	java/lang/SecurityException
    //   68	73	273	java/lang/SecurityException
    //   115	127	273	java/lang/SecurityException
    //   291	295	301	java/io/IOException
    //   39	47	308	finally
    //   51	64	308	finally
    //   68	73	308	finally
    //   115	127	308	finally
    //   210	214	308	finally
    //   245	249	308	finally
    //   280	284	308	finally
    //   84	92	321	java/io/IOException
    //   159	163	328	java/io/IOException
    //   314	319	332	java/io/IOException
    //   129	140	336	finally
    //   142	149	336	finally
    //   151	155	336	finally
    //   174	179	336	finally
    //   129	140	343	java/lang/SecurityException
    //   142	149	343	java/lang/SecurityException
    //   151	155	343	java/lang/SecurityException
    //   129	140	347	java/lang/IllegalArgumentException
    //   142	149	347	java/lang/IllegalArgumentException
    //   151	155	347	java/lang/IllegalArgumentException
    //   129	140	351	java/io/IOException
    //   142	149	351	java/io/IOException
    //   151	155	351	java/io/IOException
    //   129	140	355	java/lang/IllegalStateException
    //   142	149	355	java/lang/IllegalStateException
    //   151	155	355	java/lang/IllegalStateException
  }
  
  /* Error */
  public boolean setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   8: ifnonnull +82 -> 90
    //   11: aload_0
    //   12: new 17	android/media/MediaPlayer
    //   15: dup
    //   16: invokespecial 49	android/media/MediaPlayer:<init>	()V
    //   19: putfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   22: aconst_null
    //   23: astore 6
    //   25: aconst_null
    //   26: astore 7
    //   28: aconst_null
    //   29: astore 8
    //   31: aconst_null
    //   32: astore 5
    //   34: aload 8
    //   36: astore 4
    //   38: aload_0
    //   39: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   42: iconst_3
    //   43: invokevirtual 53	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   46: aload 8
    //   48: astore 4
    //   50: new 68	java/io/File
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload 8
    //   61: astore 4
    //   63: aload_1
    //   64: invokevirtual 80	java/io/File:exists	()Z
    //   67: istore_2
    //   68: iload_2
    //   69: ifne +36 -> 105
    //   72: iload_3
    //   73: istore_2
    //   74: iconst_0
    //   75: ifeq +11 -> 86
    //   78: new 82	java/lang/NullPointerException
    //   81: dup
    //   82: invokespecial 83	java/lang/NullPointerException:<init>	()V
    //   85: athrow
    //   86: aload_0
    //   87: monitorexit
    //   88: iload_2
    //   89: ireturn
    //   90: aload_0
    //   91: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   94: invokevirtual 62	android/media/MediaPlayer:reset	()V
    //   97: goto -75 -> 22
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: aload 8
    //   107: astore 4
    //   109: new 85	java/io/FileInputStream
    //   112: dup
    //   113: aload_1
    //   114: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   117: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   120: astore_1
    //   121: aload_1
    //   122: astore 4
    //   124: aload_0
    //   125: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   128: aload_1
    //   129: invokevirtual 96	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   132: invokevirtual 99	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   135: aload_1
    //   136: astore 4
    //   138: aload_0
    //   139: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   142: invokevirtual 59	android/media/MediaPlayer:prepare	()V
    //   145: aload_1
    //   146: astore 4
    //   148: aload_1
    //   149: invokevirtual 102	java/io/FileInputStream:close	()V
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 102	java/io/FileInputStream:close	()V
    //   160: iconst_1
    //   161: istore_2
    //   162: goto -76 -> 86
    //   165: astore 5
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: astore 4
    //   172: aload 5
    //   174: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
    //   177: iload_3
    //   178: istore_2
    //   179: aload_1
    //   180: ifnull -94 -> 86
    //   183: aload_1
    //   184: invokevirtual 102	java/io/FileInputStream:close	()V
    //   187: iload_3
    //   188: istore_2
    //   189: goto -103 -> 86
    //   192: astore_1
    //   193: iload_3
    //   194: istore_2
    //   195: goto -109 -> 86
    //   198: astore 4
    //   200: aload 5
    //   202: astore_1
    //   203: aload 4
    //   205: astore 5
    //   207: aload_1
    //   208: astore 4
    //   210: aload 5
    //   212: invokevirtual 63	java/io/IOException:printStackTrace	()V
    //   215: iload_3
    //   216: istore_2
    //   217: aload_1
    //   218: ifnull -132 -> 86
    //   221: aload_1
    //   222: invokevirtual 102	java/io/FileInputStream:close	()V
    //   225: iload_3
    //   226: istore_2
    //   227: goto -141 -> 86
    //   230: astore_1
    //   231: iload_3
    //   232: istore_2
    //   233: goto -147 -> 86
    //   236: astore 5
    //   238: aload 6
    //   240: astore_1
    //   241: aload_1
    //   242: astore 4
    //   244: aload 5
    //   246: invokevirtual 64	java/lang/IllegalArgumentException:printStackTrace	()V
    //   249: iload_3
    //   250: istore_2
    //   251: aload_1
    //   252: ifnull -166 -> 86
    //   255: aload_1
    //   256: invokevirtual 102	java/io/FileInputStream:close	()V
    //   259: iload_3
    //   260: istore_2
    //   261: goto -175 -> 86
    //   264: astore_1
    //   265: iload_3
    //   266: istore_2
    //   267: goto -181 -> 86
    //   270: astore 5
    //   272: aload 7
    //   274: astore_1
    //   275: aload_1
    //   276: astore 4
    //   278: aload 5
    //   280: invokevirtual 65	java/lang/SecurityException:printStackTrace	()V
    //   283: iload_3
    //   284: istore_2
    //   285: aload_1
    //   286: ifnull -200 -> 86
    //   289: aload_1
    //   290: invokevirtual 102	java/io/FileInputStream:close	()V
    //   293: iload_3
    //   294: istore_2
    //   295: goto -209 -> 86
    //   298: astore_1
    //   299: iload_3
    //   300: istore_2
    //   301: goto -215 -> 86
    //   304: astore_1
    //   305: aload 4
    //   307: ifnull +8 -> 315
    //   310: aload 4
    //   312: invokevirtual 102	java/io/FileInputStream:close	()V
    //   315: aload_1
    //   316: athrow
    //   317: astore_1
    //   318: iload_3
    //   319: istore_2
    //   320: goto -234 -> 86
    //   323: astore_1
    //   324: goto -164 -> 160
    //   327: astore 4
    //   329: goto -14 -> 315
    //   332: astore_1
    //   333: goto -28 -> 305
    //   336: astore 5
    //   338: goto -63 -> 275
    //   341: astore 5
    //   343: goto -102 -> 241
    //   346: astore 5
    //   348: goto -141 -> 207
    //   351: astore 5
    //   353: goto -184 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	QzoneSoundPlayerHelper
    //   0	356	1	paramString	java.lang.String
    //   67	253	2	bool1	boolean
    //   1	318	3	bool2	boolean
    //   36	135	4	localObject1	Object
    //   198	6	4	localIOException1	IOException
    //   208	103	4	str	java.lang.String
    //   327	1	4	localIOException2	IOException
    //   32	1	5	localObject2	Object
    //   165	36	5	localIllegalStateException1	IllegalStateException
    //   205	6	5	localObject3	Object
    //   236	9	5	localIllegalArgumentException1	IllegalArgumentException
    //   270	9	5	localSecurityException1	SecurityException
    //   336	1	5	localSecurityException2	SecurityException
    //   341	1	5	localIllegalArgumentException2	IllegalArgumentException
    //   346	1	5	localIOException3	IOException
    //   351	1	5	localIllegalStateException2	IllegalStateException
    //   23	216	6	localObject4	Object
    //   26	247	7	localObject5	Object
    //   29	77	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   4	22	100	finally
    //   78	86	100	finally
    //   90	97	100	finally
    //   156	160	100	finally
    //   183	187	100	finally
    //   221	225	100	finally
    //   255	259	100	finally
    //   289	293	100	finally
    //   310	315	100	finally
    //   315	317	100	finally
    //   38	46	165	java/lang/IllegalStateException
    //   50	59	165	java/lang/IllegalStateException
    //   63	68	165	java/lang/IllegalStateException
    //   109	121	165	java/lang/IllegalStateException
    //   183	187	192	java/io/IOException
    //   38	46	198	java/io/IOException
    //   50	59	198	java/io/IOException
    //   63	68	198	java/io/IOException
    //   109	121	198	java/io/IOException
    //   221	225	230	java/io/IOException
    //   38	46	236	java/lang/IllegalArgumentException
    //   50	59	236	java/lang/IllegalArgumentException
    //   63	68	236	java/lang/IllegalArgumentException
    //   109	121	236	java/lang/IllegalArgumentException
    //   255	259	264	java/io/IOException
    //   38	46	270	java/lang/SecurityException
    //   50	59	270	java/lang/SecurityException
    //   63	68	270	java/lang/SecurityException
    //   109	121	270	java/lang/SecurityException
    //   289	293	298	java/io/IOException
    //   38	46	304	finally
    //   50	59	304	finally
    //   63	68	304	finally
    //   109	121	304	finally
    //   210	215	304	finally
    //   244	249	304	finally
    //   278	283	304	finally
    //   78	86	317	java/io/IOException
    //   156	160	323	java/io/IOException
    //   310	315	327	java/io/IOException
    //   124	135	332	finally
    //   138	145	332	finally
    //   148	152	332	finally
    //   172	177	332	finally
    //   124	135	336	java/lang/SecurityException
    //   138	145	336	java/lang/SecurityException
    //   148	152	336	java/lang/SecurityException
    //   124	135	341	java/lang/IllegalArgumentException
    //   138	145	341	java/lang/IllegalArgumentException
    //   148	152	341	java/lang/IllegalArgumentException
    //   124	135	346	java/io/IOException
    //   138	145	346	java/io/IOException
    //   148	152	346	java/io/IOException
    //   124	135	351	java/lang/IllegalStateException
    //   138	145	351	java/lang/IllegalStateException
    //   148	152	351	java/lang/IllegalStateException
  }
  
  /* Error */
  public boolean setLooping(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
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
    //   20: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   23: iload_1
    //   24: invokevirtual 109	android/media/MediaPlayer:setLooping	(Z)V
    //   27: iconst_1
    //   28: istore_1
    //   29: goto -14 -> 15
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
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
    //   0	47	0	this	QzoneSoundPlayerHelper
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
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      if (this.mp == null) {
        this.mp = new MediaPlayer();
      }
      this.mp.setOnCompletionListener(paramOnCompletionListener);
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean start()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   21: invokevirtual 116	android/media/MediaPlayer:start	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	QzoneSoundPlayerHelper
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
  public boolean stop()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   21: invokevirtual 38	android/media/MediaPlayer:stop	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	QzoneSoundPlayerHelper
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.sound.QzoneSoundPlayerHelper
 * JD-Core Version:    0.7.0.1
 */