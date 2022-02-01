package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;

public class VsGuidUtil
{
  private static VsGuidUtil instance = null;
  private final String VSGUID_APPLOCAL_PATH = "/vs/vsguid.dat";
  private final String VSGUID_SDCARD_PATH = "/tencent/vs/vsguid.dat";
  private final Context context;
  private String mGuid = "";
  private boolean saveGuid = false;
  
  public VsGuidUtil(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static VsGuidUtil getInstance(Context paramContext)
  {
    try
    {
      if (instance == null) {
        instance = new VsGuidUtil(paramContext);
      }
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  public void SaveVsGuid(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {}
    do
    {
      return;
      saveVsGuidToApplocal(paramString);
      VsLog.debug("[vsguid] Save vsguid:%s to AppLocal", new Object[] { paramString });
    } while (!VsDeviceInfo.getVsDeviceInfo(this.context).checkIsHaveCard());
    saveVsGuidToSdcard(paramString);
    VsLog.debug("[vsguid] Save vsguid:%s to SDCard", new Object[] { paramString });
  }
  
  public String loadVsGuid()
  {
    if ((this.mGuid != null) && (!this.mGuid.trim().equals(""))) {
      return this.mGuid;
    }
    Object localObject2 = loadVsGuidFromApp();
    VsLog.debug("[vsguid] Load vsguid:%s from AppLocal", new Object[] { localObject2 });
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).trim().equals("")) {}
    }
    else
    {
      localObject1 = localObject2;
      if (VsDeviceInfo.getVsDeviceInfo(this.context).checkIsHaveCard())
      {
        localObject1 = loadVsGuidFromSdcard();
        VsLog.debug("[vsguid] Load vsguid:%s from SDCard", new Object[] { localObject1 });
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).trim().equals("")) {}
    }
    else
    {
      localObject1 = VsGuidInfo.getInstance(this.context).getVsGuid();
      localObject2 = localObject1;
      if (((String)localObject1).length() == 32)
      {
        this.mGuid = ((String)localObject1);
        localObject2 = localObject1;
      }
    }
    if ((this.mGuid == null) || (this.mGuid.trim().equals(""))) {
      this.mGuid = ((String)localObject2);
    }
    return this.mGuid;
  }
  
  /* Error */
  public String loadVsGuidFromApp()
  {
    // Byte code:
    //   0: new 110	java/io/File
    //   3: dup
    //   4: new 112	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   11: ldc 115
    //   13: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 39	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsGuidUtil:context	Landroid/content/Context;
    //   20: invokestatic 125	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsAppInfo:getPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   23: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 29
    //   28: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: aconst_null
    //   39: astore_2
    //   40: new 132	java/io/FileInputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: astore_1
    //   49: aload_3
    //   50: invokevirtual 138	java/io/File:length	()J
    //   53: l2i
    //   54: newarray byte
    //   56: astore_2
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 142	java/io/FileInputStream:read	([B)I
    //   62: pop
    //   63: aload_1
    //   64: invokevirtual 145	java/io/FileInputStream:close	()V
    //   67: aload_2
    //   68: invokestatic 151	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsEncryptUtil:VsDecrypt_SDCARD	([B)[B
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull +22 -> 95
    //   76: new 47	java/lang/String
    //   79: dup
    //   80: aload_2
    //   81: invokespecial 154	java/lang/String:<init>	([B)V
    //   84: astore_2
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 145	java/io/FileInputStream:close	()V
    //   93: aload_2
    //   94: areturn
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 145	java/io/FileInputStream:close	()V
    //   103: ldc 33
    //   105: areturn
    //   106: astore_1
    //   107: aload_2
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull -7 -> 103
    //   113: aload_1
    //   114: invokevirtual 145	java/io/FileInputStream:close	()V
    //   117: goto -14 -> 103
    //   120: astore_1
    //   121: goto -18 -> 103
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull -25 -> 103
    //   131: aload_1
    //   132: invokevirtual 145	java/io/FileInputStream:close	()V
    //   135: goto -32 -> 103
    //   138: astore_1
    //   139: goto -36 -> 103
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 145	java/io/FileInputStream:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: aload_2
    //   157: areturn
    //   158: astore_1
    //   159: goto -56 -> 103
    //   162: astore_1
    //   163: goto -10 -> 153
    //   166: astore_2
    //   167: goto -22 -> 145
    //   170: astore_2
    //   171: goto -44 -> 127
    //   174: astore_2
    //   175: goto -66 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	VsGuidUtil
    //   48	52	1	localFileInputStream	java.io.FileInputStream
    //   106	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   108	6	1	localObject1	Object
    //   120	1	1	localIOException1	java.io.IOException
    //   124	1	1	localIOException2	java.io.IOException
    //   126	6	1	localObject2	Object
    //   138	1	1	localIOException3	java.io.IOException
    //   144	6	1	localObject3	Object
    //   155	1	1	localIOException4	java.io.IOException
    //   158	1	1	localIOException5	java.io.IOException
    //   162	1	1	localIOException6	java.io.IOException
    //   39	69	2	localObject4	Object
    //   142	15	2	str	String
    //   166	1	2	localObject5	Object
    //   170	1	2	localIOException7	java.io.IOException
    //   174	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   37	13	3	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   40	49	106	java/io/FileNotFoundException
    //   113	117	120	java/io/IOException
    //   40	49	124	java/io/IOException
    //   131	135	138	java/io/IOException
    //   40	49	142	finally
    //   89	93	155	java/io/IOException
    //   99	103	158	java/io/IOException
    //   149	153	162	java/io/IOException
    //   49	72	166	finally
    //   76	85	166	finally
    //   49	72	170	java/io/IOException
    //   76	85	170	java/io/IOException
    //   49	72	174	java/io/FileNotFoundException
    //   76	85	174	java/io/FileNotFoundException
  }
  
  /* Error */
  public String loadVsGuidFromSdcard()
  {
    // Byte code:
    //   0: new 110	java/io/File
    //   3: dup
    //   4: invokestatic 160	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: ldc 25
    //   9: invokespecial 163	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: new 132	java/io/FileInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_1
    //   24: aload_3
    //   25: invokevirtual 138	java/io/File:length	()J
    //   28: l2i
    //   29: newarray byte
    //   31: astore_2
    //   32: aload_1
    //   33: aload_2
    //   34: invokevirtual 142	java/io/FileInputStream:read	([B)I
    //   37: pop
    //   38: aload_1
    //   39: invokevirtual 145	java/io/FileInputStream:close	()V
    //   42: aload_2
    //   43: invokestatic 151	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsEncryptUtil:VsDecrypt_SDCARD	([B)[B
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +22 -> 70
    //   51: new 47	java/lang/String
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 154	java/lang/String:<init>	([B)V
    //   59: astore_2
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 145	java/io/FileInputStream:close	()V
    //   68: aload_2
    //   69: areturn
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 145	java/io/FileInputStream:close	()V
    //   78: ldc 33
    //   80: areturn
    //   81: astore_1
    //   82: aload_2
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull -7 -> 78
    //   88: aload_1
    //   89: invokevirtual 145	java/io/FileInputStream:close	()V
    //   92: goto -14 -> 78
    //   95: astore_1
    //   96: goto -18 -> 78
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull -25 -> 78
    //   106: aload_1
    //   107: invokevirtual 145	java/io/FileInputStream:close	()V
    //   110: goto -32 -> 78
    //   113: astore_1
    //   114: goto -36 -> 78
    //   117: astore_2
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 145	java/io/FileInputStream:close	()V
    //   128: aload_2
    //   129: athrow
    //   130: astore_1
    //   131: aload_2
    //   132: areturn
    //   133: astore_1
    //   134: goto -56 -> 78
    //   137: astore_1
    //   138: goto -10 -> 128
    //   141: astore_2
    //   142: goto -22 -> 120
    //   145: astore_2
    //   146: goto -44 -> 102
    //   149: astore_2
    //   150: goto -66 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	VsGuidUtil
    //   23	52	1	localFileInputStream	java.io.FileInputStream
    //   81	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   83	6	1	localObject1	Object
    //   95	1	1	localIOException1	java.io.IOException
    //   99	1	1	localIOException2	java.io.IOException
    //   101	6	1	localObject2	Object
    //   113	1	1	localIOException3	java.io.IOException
    //   119	6	1	localObject3	Object
    //   130	1	1	localIOException4	java.io.IOException
    //   133	1	1	localIOException5	java.io.IOException
    //   137	1	1	localIOException6	java.io.IOException
    //   14	69	2	localObject4	Object
    //   117	15	2	str	String
    //   141	1	2	localObject5	Object
    //   145	1	2	localIOException7	java.io.IOException
    //   149	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   12	13	3	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   15	24	81	java/io/FileNotFoundException
    //   88	92	95	java/io/IOException
    //   15	24	99	java/io/IOException
    //   106	110	113	java/io/IOException
    //   15	24	117	finally
    //   64	68	130	java/io/IOException
    //   74	78	133	java/io/IOException
    //   124	128	137	java/io/IOException
    //   24	47	141	finally
    //   51	60	141	finally
    //   24	47	145	java/io/IOException
    //   51	60	145	java/io/IOException
    //   24	47	149	java/io/FileNotFoundException
    //   51	60	149	java/io/FileNotFoundException
  }
  
  /* Error */
  public void saveVsGuidToApplocal(String paramString)
  {
    // Byte code:
    //   0: new 110	java/io/File
    //   3: dup
    //   4: new 112	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   11: ldc 115
    //   13: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 39	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsGuidUtil:context	Landroid/content/Context;
    //   20: invokestatic 125	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsAppInfo:getPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   23: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 29
    //   28: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_2
    //   38: aconst_null
    //   39: astore 4
    //   41: aconst_null
    //   42: astore_3
    //   43: aload_2
    //   44: invokevirtual 166	java/io/File:getParentFile	()Ljava/io/File;
    //   47: invokevirtual 169	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: aload_2
    //   52: invokevirtual 172	java/io/File:createNewFile	()Z
    //   55: pop
    //   56: new 174	java/io/FileOutputStream
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore_2
    //   65: aload_2
    //   66: aload_1
    //   67: invokevirtual 179	java/lang/String:getBytes	()[B
    //   70: invokestatic 182	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsEncryptUtil:VsEncrypt_SDCARD	([B)[B
    //   73: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   76: aload_2
    //   77: invokevirtual 188	java/io/FileOutputStream:flush	()V
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   88: return
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull -5 -> 88
    //   96: aload_2
    //   97: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   100: return
    //   101: astore_1
    //   102: return
    //   103: astore_1
    //   104: aload_3
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull -19 -> 88
    //   110: aload_1
    //   111: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   114: return
    //   115: astore_1
    //   116: return
    //   117: astore_1
    //   118: aload 4
    //   120: astore_2
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: return
    //   133: astore_2
    //   134: goto -5 -> 129
    //   137: astore_1
    //   138: goto -17 -> 121
    //   141: astore_1
    //   142: aload_2
    //   143: astore_1
    //   144: goto -38 -> 106
    //   147: astore_1
    //   148: goto -56 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	VsGuidUtil
    //   0	151	1	paramString	String
    //   37	89	2	localObject1	Object
    //   133	10	2	localIOException	java.io.IOException
    //   42	63	3	localObject2	Object
    //   39	80	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   43	65	89	java/io/FileNotFoundException
    //   96	100	101	java/io/IOException
    //   43	65	103	java/io/IOException
    //   110	114	115	java/io/IOException
    //   43	65	117	finally
    //   84	88	131	java/io/IOException
    //   125	129	133	java/io/IOException
    //   65	80	137	finally
    //   65	80	141	java/io/IOException
    //   65	80	147	java/io/FileNotFoundException
  }
  
  /* Error */
  public void saveVsGuidToSdcard(String paramString)
  {
    // Byte code:
    //   0: new 110	java/io/File
    //   3: dup
    //   4: invokestatic 160	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: ldc 25
    //   9: invokespecial 163	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_2
    //   19: invokevirtual 166	java/io/File:getParentFile	()Ljava/io/File;
    //   22: invokevirtual 169	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: aload_2
    //   27: invokevirtual 172	java/io/File:createNewFile	()Z
    //   30: pop
    //   31: new 174	java/io/FileOutputStream
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore_2
    //   40: aload_2
    //   41: aload_1
    //   42: invokevirtual 179	java/lang/String:getBytes	()[B
    //   45: invokestatic 182	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsEncryptUtil:VsEncrypt_SDCARD	([B)[B
    //   48: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   51: aload_2
    //   52: invokevirtual 188	java/io/FileOutputStream:flush	()V
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   63: return
    //   64: astore_1
    //   65: aconst_null
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull -5 -> 63
    //   71: aload_2
    //   72: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   75: return
    //   76: astore_1
    //   77: return
    //   78: astore_1
    //   79: aload_3
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull -19 -> 63
    //   85: aload_1
    //   86: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   89: return
    //   90: astore_1
    //   91: return
    //   92: astore_1
    //   93: aload 4
    //   95: astore_2
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: return
    //   108: astore_2
    //   109: goto -5 -> 104
    //   112: astore_1
    //   113: goto -17 -> 96
    //   116: astore_1
    //   117: aload_2
    //   118: astore_1
    //   119: goto -38 -> 81
    //   122: astore_1
    //   123: goto -56 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	VsGuidUtil
    //   0	126	1	paramString	String
    //   12	89	2	localObject1	Object
    //   108	10	2	localIOException	java.io.IOException
    //   17	63	3	localObject2	Object
    //   14	80	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	40	64	java/io/FileNotFoundException
    //   71	75	76	java/io/IOException
    //   18	40	78	java/io/IOException
    //   85	89	90	java/io/IOException
    //   18	40	92	finally
    //   59	63	106	java/io/IOException
    //   100	104	108	java/io/IOException
    //   40	55	112	finally
    //   40	55	116	java/io/IOException
    //   40	55	122	java/io/FileNotFoundException
  }
  
  public void updateVsGuid()
  {
    String str = VsGuidInfo.getInstance(this.context).getVsGuid();
    if ((str.length() == 32) && (!this.saveGuid))
    {
      SaveVsGuid(str);
      this.saveGuid = true;
      this.mGuid = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsGuidUtil
 * JD-Core Version:    0.7.0.1
 */