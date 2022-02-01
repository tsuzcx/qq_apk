package cooperation.qzone.webviewplugin.sound;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class QzoneSoundPlayerHelper
{
  private MediaPlayer mp;
  
  public int getCurrentPosition()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.mp;
      if (localMediaPlayer == null) {
        return -1;
      }
      int i = this.mp.getCurrentPosition();
      return i;
    }
    finally {}
  }
  
  public int getDuration()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.mp;
      if (localMediaPlayer == null) {
        return -1;
      }
      int i = this.mp.getDuration();
      return i;
    }
    finally {}
  }
  
  public boolean isPlaying()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.mp;
      if (localMediaPlayer == null) {
        return false;
      }
      boolean bool = this.mp.isPlaying();
      return bool;
    }
    finally {}
  }
  
  /* Error */
  public boolean pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   19: invokevirtual 31	android/media/MediaPlayer:pause	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_1
    //   25: ireturn
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
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
    //   0	40	0	this	QzoneSoundPlayerHelper
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
  
  public void release()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.mp;
      if (localMediaPlayer == null) {
        return;
      }
      this.mp.stop();
      this.mp.release();
      this.mp = null;
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean setDataSource(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: ifnonnull +17 -> 23
    //   9: aload_0
    //   10: new 17	android/media/MediaPlayer
    //   13: dup
    //   14: invokespecial 49	android/media/MediaPlayer:<init>	()V
    //   17: putfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   20: goto +10 -> 30
    //   23: aload_0
    //   24: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   27: invokevirtual 52	android/media/MediaPlayer:reset	()V
    //   30: aload_0
    //   31: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   34: iconst_3
    //   35: invokevirtual 56	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   38: aload_0
    //   39: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   42: aload_1
    //   43: aload_2
    //   44: invokevirtual 59	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   47: aload_0
    //   48: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   51: invokevirtual 62	android/media/MediaPlayer:prepare	()V
    //   54: aload_0
    //   55: monitorexit
    //   56: iconst_1
    //   57: ireturn
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 63	java/lang/SecurityException:printStackTrace	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 64	java/lang/IllegalArgumentException:printStackTrace	()V
    //   72: aload_0
    //   73: monitorexit
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   81: aload_0
    //   82: monitorexit
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
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
    //   0	99	0	this	QzoneSoundPlayerHelper
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
  public boolean setDataSource(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: ifnonnull +17 -> 23
    //   9: aload_0
    //   10: new 17	android/media/MediaPlayer
    //   13: dup
    //   14: invokespecial 49	android/media/MediaPlayer:<init>	()V
    //   17: putfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   20: goto +10 -> 30
    //   23: aload_0
    //   24: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   27: invokevirtual 52	android/media/MediaPlayer:reset	()V
    //   30: aconst_null
    //   31: astore 5
    //   33: aconst_null
    //   34: astore 6
    //   36: aconst_null
    //   37: astore 7
    //   39: aconst_null
    //   40: astore 8
    //   42: aconst_null
    //   43: astore 9
    //   45: aload 9
    //   47: astore 4
    //   49: aload_0
    //   50: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   53: iconst_3
    //   54: invokevirtual 56	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   57: aload 9
    //   59: astore 4
    //   61: new 68	java/io/File
    //   64: dup
    //   65: aload_1
    //   66: invokevirtual 74	android/content/Context:getFilesDir	()Ljava/io/File;
    //   69: aload_2
    //   70: invokespecial 77	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: astore_1
    //   74: aload 9
    //   76: astore 4
    //   78: aload_1
    //   79: invokevirtual 80	java/io/File:exists	()Z
    //   82: istore_3
    //   83: iload_3
    //   84: ifne +7 -> 91
    //   87: aload_0
    //   88: monitorexit
    //   89: iconst_0
    //   90: ireturn
    //   91: aload 9
    //   93: astore 4
    //   95: new 82	java/io/FileInputStream
    //   98: dup
    //   99: aload_1
    //   100: invokevirtual 86	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   106: astore_1
    //   107: aload_0
    //   108: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   111: aload_1
    //   112: invokevirtual 93	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   115: invokevirtual 96	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   118: aload_0
    //   119: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   122: invokevirtual 62	android/media/MediaPlayer:prepare	()V
    //   125: aload_1
    //   126: invokevirtual 99	java/io/FileInputStream:close	()V
    //   129: aload_1
    //   130: invokevirtual 99	java/io/FileInputStream:close	()V
    //   133: aload_0
    //   134: monitorexit
    //   135: iconst_1
    //   136: ireturn
    //   137: astore_2
    //   138: aload_1
    //   139: astore 4
    //   141: aload_2
    //   142: astore_1
    //   143: goto +115 -> 258
    //   146: astore_2
    //   147: goto +23 -> 170
    //   150: astore_2
    //   151: goto +42 -> 193
    //   154: astore_2
    //   155: goto +61 -> 216
    //   158: astore_2
    //   159: goto +80 -> 239
    //   162: astore_1
    //   163: goto +95 -> 258
    //   166: astore_2
    //   167: aload 5
    //   169: astore_1
    //   170: aload_1
    //   171: astore 4
    //   173: aload_2
    //   174: invokevirtual 63	java/lang/SecurityException:printStackTrace	()V
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 99	java/io/FileInputStream:close	()V
    //   185: aload_0
    //   186: monitorexit
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_2
    //   190: aload 6
    //   192: astore_1
    //   193: aload_1
    //   194: astore 4
    //   196: aload_2
    //   197: invokevirtual 64	java/lang/IllegalArgumentException:printStackTrace	()V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 99	java/io/FileInputStream:close	()V
    //   208: aload_0
    //   209: monitorexit
    //   210: iconst_0
    //   211: ireturn
    //   212: astore_2
    //   213: aload 7
    //   215: astore_1
    //   216: aload_1
    //   217: astore 4
    //   219: aload_2
    //   220: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 99	java/io/FileInputStream:close	()V
    //   231: aload_0
    //   232: monitorexit
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_2
    //   236: aload 8
    //   238: astore_1
    //   239: aload_1
    //   240: astore 4
    //   242: aload_2
    //   243: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 99	java/io/FileInputStream:close	()V
    //   254: aload_0
    //   255: monitorexit
    //   256: iconst_0
    //   257: ireturn
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 99	java/io/FileInputStream:close	()V
    //   268: aload_1
    //   269: athrow
    //   270: astore_1
    //   271: aload_0
    //   272: monitorexit
    //   273: aload_1
    //   274: athrow
    //   275: astore_1
    //   276: goto -143 -> 133
    //   279: astore_1
    //   280: goto -95 -> 185
    //   283: astore_1
    //   284: goto -76 -> 208
    //   287: astore_1
    //   288: goto -57 -> 231
    //   291: astore_1
    //   292: goto -38 -> 254
    //   295: astore_2
    //   296: goto -28 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	QzoneSoundPlayerHelper
    //   0	299	1	paramContext	android.content.Context
    //   0	299	2	paramString	java.lang.String
    //   82	2	3	bool	boolean
    //   47	217	4	localObject1	Object
    //   31	137	5	localObject2	Object
    //   34	157	6	localObject3	Object
    //   37	177	7	localObject4	Object
    //   40	197	8	localObject5	Object
    //   43	49	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   107	129	137	finally
    //   107	129	146	java/lang/SecurityException
    //   107	129	150	java/lang/IllegalArgumentException
    //   107	129	154	java/io/IOException
    //   107	129	158	java/lang/IllegalStateException
    //   49	57	162	finally
    //   61	74	162	finally
    //   78	83	162	finally
    //   95	107	162	finally
    //   173	177	162	finally
    //   196	200	162	finally
    //   219	223	162	finally
    //   242	246	162	finally
    //   49	57	166	java/lang/SecurityException
    //   61	74	166	java/lang/SecurityException
    //   78	83	166	java/lang/SecurityException
    //   95	107	166	java/lang/SecurityException
    //   49	57	189	java/lang/IllegalArgumentException
    //   61	74	189	java/lang/IllegalArgumentException
    //   78	83	189	java/lang/IllegalArgumentException
    //   95	107	189	java/lang/IllegalArgumentException
    //   49	57	212	java/io/IOException
    //   61	74	212	java/io/IOException
    //   78	83	212	java/io/IOException
    //   95	107	212	java/io/IOException
    //   49	57	235	java/lang/IllegalStateException
    //   61	74	235	java/lang/IllegalStateException
    //   78	83	235	java/lang/IllegalStateException
    //   95	107	235	java/lang/IllegalStateException
    //   2	20	270	finally
    //   23	30	270	finally
    //   129	133	270	finally
    //   181	185	270	finally
    //   204	208	270	finally
    //   227	231	270	finally
    //   250	254	270	finally
    //   263	268	270	finally
    //   268	270	270	finally
    //   129	133	275	java/io/IOException
    //   181	185	279	java/io/IOException
    //   204	208	283	java/io/IOException
    //   227	231	287	java/io/IOException
    //   250	254	291	java/io/IOException
    //   263	268	295	java/io/IOException
  }
  
  /* Error */
  public boolean setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: ifnonnull +17 -> 23
    //   9: aload_0
    //   10: new 17	android/media/MediaPlayer
    //   13: dup
    //   14: invokespecial 49	android/media/MediaPlayer:<init>	()V
    //   17: putfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   20: goto +10 -> 30
    //   23: aload_0
    //   24: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   27: invokevirtual 52	android/media/MediaPlayer:reset	()V
    //   30: aconst_null
    //   31: astore 5
    //   33: aconst_null
    //   34: astore 6
    //   36: aconst_null
    //   37: astore 7
    //   39: aconst_null
    //   40: astore 8
    //   42: aconst_null
    //   43: astore 4
    //   45: aload 4
    //   47: astore_3
    //   48: aload_0
    //   49: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   52: iconst_3
    //   53: invokevirtual 56	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   56: aload 4
    //   58: astore_3
    //   59: new 68	java/io/File
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore_1
    //   68: aload 4
    //   70: astore_3
    //   71: aload_1
    //   72: invokevirtual 80	java/io/File:exists	()Z
    //   75: istore_2
    //   76: iload_2
    //   77: ifne +7 -> 84
    //   80: aload_0
    //   81: monitorexit
    //   82: iconst_0
    //   83: ireturn
    //   84: aload 4
    //   86: astore_3
    //   87: new 82	java/io/FileInputStream
    //   90: dup
    //   91: aload_1
    //   92: invokevirtual 86	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   103: aload_1
    //   104: invokevirtual 93	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   107: invokevirtual 96	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   110: aload_0
    //   111: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   114: invokevirtual 62	android/media/MediaPlayer:prepare	()V
    //   117: aload_1
    //   118: invokevirtual 99	java/io/FileInputStream:close	()V
    //   121: aload_1
    //   122: invokevirtual 99	java/io/FileInputStream:close	()V
    //   125: aload_0
    //   126: monitorexit
    //   127: iconst_1
    //   128: ireturn
    //   129: astore 4
    //   131: aload_1
    //   132: astore_3
    //   133: goto +124 -> 257
    //   136: astore 4
    //   138: goto +28 -> 166
    //   141: astore 4
    //   143: goto +47 -> 190
    //   146: astore 4
    //   148: goto +66 -> 214
    //   151: astore 4
    //   153: goto +85 -> 238
    //   156: astore 4
    //   158: goto +99 -> 257
    //   161: astore 4
    //   163: aload 5
    //   165: astore_1
    //   166: aload_1
    //   167: astore_3
    //   168: aload 4
    //   170: invokevirtual 63	java/lang/SecurityException:printStackTrace	()V
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 99	java/io/FileInputStream:close	()V
    //   181: aload_0
    //   182: monitorexit
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 4
    //   187: aload 6
    //   189: astore_1
    //   190: aload_1
    //   191: astore_3
    //   192: aload 4
    //   194: invokevirtual 64	java/lang/IllegalArgumentException:printStackTrace	()V
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 99	java/io/FileInputStream:close	()V
    //   205: aload_0
    //   206: monitorexit
    //   207: iconst_0
    //   208: ireturn
    //   209: astore 4
    //   211: aload 7
    //   213: astore_1
    //   214: aload_1
    //   215: astore_3
    //   216: aload 4
    //   218: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 99	java/io/FileInputStream:close	()V
    //   229: aload_0
    //   230: monitorexit
    //   231: iconst_0
    //   232: ireturn
    //   233: astore 4
    //   235: aload 8
    //   237: astore_1
    //   238: aload_1
    //   239: astore_3
    //   240: aload 4
    //   242: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
    //   245: aload_1
    //   246: ifnull +7 -> 253
    //   249: aload_1
    //   250: invokevirtual 99	java/io/FileInputStream:close	()V
    //   253: aload_0
    //   254: monitorexit
    //   255: iconst_0
    //   256: ireturn
    //   257: aload_3
    //   258: ifnull +7 -> 265
    //   261: aload_3
    //   262: invokevirtual 99	java/io/FileInputStream:close	()V
    //   265: aload 4
    //   267: athrow
    //   268: astore_1
    //   269: aload_0
    //   270: monitorexit
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: goto -149 -> 125
    //   277: astore_1
    //   278: goto -97 -> 181
    //   281: astore_1
    //   282: goto -77 -> 205
    //   285: astore_1
    //   286: goto -57 -> 229
    //   289: astore_1
    //   290: goto -37 -> 253
    //   293: astore_1
    //   294: goto -29 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	QzoneSoundPlayerHelper
    //   0	297	1	paramString	java.lang.String
    //   75	2	2	bool	boolean
    //   47	215	3	localObject1	Object
    //   43	42	4	localObject2	Object
    //   129	1	4	localObject3	Object
    //   136	1	4	localSecurityException1	java.lang.SecurityException
    //   141	1	4	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   146	1	4	localIOException1	java.io.IOException
    //   151	1	4	localIllegalStateException1	java.lang.IllegalStateException
    //   156	1	4	localObject4	Object
    //   161	8	4	localSecurityException2	java.lang.SecurityException
    //   185	8	4	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   209	8	4	localIOException2	java.io.IOException
    //   233	33	4	localIllegalStateException2	java.lang.IllegalStateException
    //   31	133	5	localObject5	Object
    //   34	154	6	localObject6	Object
    //   37	175	7	localObject7	Object
    //   40	196	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   99	121	129	finally
    //   99	121	136	java/lang/SecurityException
    //   99	121	141	java/lang/IllegalArgumentException
    //   99	121	146	java/io/IOException
    //   99	121	151	java/lang/IllegalStateException
    //   48	56	156	finally
    //   59	68	156	finally
    //   71	76	156	finally
    //   87	99	156	finally
    //   168	173	156	finally
    //   192	197	156	finally
    //   216	221	156	finally
    //   240	245	156	finally
    //   48	56	161	java/lang/SecurityException
    //   59	68	161	java/lang/SecurityException
    //   71	76	161	java/lang/SecurityException
    //   87	99	161	java/lang/SecurityException
    //   48	56	185	java/lang/IllegalArgumentException
    //   59	68	185	java/lang/IllegalArgumentException
    //   71	76	185	java/lang/IllegalArgumentException
    //   87	99	185	java/lang/IllegalArgumentException
    //   48	56	209	java/io/IOException
    //   59	68	209	java/io/IOException
    //   71	76	209	java/io/IOException
    //   87	99	209	java/io/IOException
    //   48	56	233	java/lang/IllegalStateException
    //   59	68	233	java/lang/IllegalStateException
    //   71	76	233	java/lang/IllegalStateException
    //   87	99	233	java/lang/IllegalStateException
    //   2	20	268	finally
    //   23	30	268	finally
    //   121	125	268	finally
    //   177	181	268	finally
    //   201	205	268	finally
    //   225	229	268	finally
    //   249	253	268	finally
    //   261	265	268	finally
    //   265	268	268	finally
    //   121	125	273	java/io/IOException
    //   177	181	277	java/io/IOException
    //   201	205	281	java/io/IOException
    //   225	229	285	java/io/IOException
    //   249	253	289	java/io/IOException
    //   261	265	293	java/io/IOException
  }
  
  /* Error */
  public boolean setLooping(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   19: iload_1
    //   20: invokevirtual 106	android/media/MediaPlayer:setLooping	(Z)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iconst_1
    //   26: ireturn
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
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
    //   0	41	0	this	QzoneSoundPlayerHelper
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
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   19: invokevirtual 113	android/media/MediaPlayer:start	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_1
    //   25: ireturn
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
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
    //   0	40	0	this	QzoneSoundPlayerHelper
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
  public boolean stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 15	cooperation/qzone/webviewplugin/sound/QzoneSoundPlayerHelper:mp	Landroid/media/MediaPlayer;
    //   19: invokevirtual 38	android/media/MediaPlayer:stop	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_1
    //   25: ireturn
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 34	java/lang/IllegalStateException:printStackTrace	()V
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
    //   0	40	0	this	QzoneSoundPlayerHelper
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.sound.QzoneSoundPlayerHelper
 * JD-Core Version:    0.7.0.1
 */