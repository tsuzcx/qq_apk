package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;

public class VsGuidUtil
{
  private static VsGuidUtil instance;
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
    if (paramString != null)
    {
      if (paramString.trim().equals("")) {
        return;
      }
      saveVsGuidToApplocal(paramString);
      VsLog.debug("[vsguid] Save vsguid:%s to AppLocal", new Object[] { paramString });
      if (VsDeviceInfo.getVsDeviceInfo(this.context).checkIsHaveCard())
      {
        saveVsGuidToSdcard(paramString);
        VsLog.debug("[vsguid] Save vsguid:%s to SDCard", new Object[] { paramString });
      }
    }
  }
  
  public String loadVsGuid()
  {
    Object localObject1 = this.mGuid;
    if ((localObject1 != null) && (!((String)localObject1).trim().equals(""))) {
      return this.mGuid;
    }
    Object localObject2 = loadVsGuidFromApp();
    VsLog.debug("[vsguid] Load vsguid:%s from AppLocal", new Object[] { localObject2 });
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
    localObject1 = this.mGuid;
    if ((localObject1 == null) || (((String)localObject1).trim().equals(""))) {
      this.mGuid = ((String)localObject2);
    }
    return this.mGuid;
  }
  
  /* Error */
  public String loadVsGuidFromApp()
  {
    // Byte code:
    //   0: new 110	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 113
    //   11: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 37	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsGuidUtil:context	Landroid/content/Context;
    //   20: invokestatic 123	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsAppInfo:getPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   23: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: ldc 27
    //   30: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: new 125	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: new 132	java/io/FileInputStream
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 138	java/io/File:length	()J
    //   59: l2i
    //   60: newarray byte
    //   62: astore_2
    //   63: aload_1
    //   64: aload_2
    //   65: invokevirtual 142	java/io/FileInputStream:read	([B)I
    //   68: pop
    //   69: aload_1
    //   70: invokevirtual 145	java/io/FileInputStream:close	()V
    //   73: aload_2
    //   74: invokestatic 151	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsEncryptUtil:VsDecrypt_SDCARD	([B)[B
    //   77: astore_3
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull +18 -> 99
    //   84: new 47	java/lang/String
    //   87: dup
    //   88: aload_3
    //   89: invokespecial 154	java/lang/String:<init>	([B)V
    //   92: astore_2
    //   93: aload_1
    //   94: invokevirtual 145	java/io/FileInputStream:close	()V
    //   97: aload_2
    //   98: areturn
    //   99: aload_2
    //   100: invokevirtual 145	java/io/FileInputStream:close	()V
    //   103: goto +48 -> 151
    //   106: astore_2
    //   107: goto +12 -> 119
    //   110: goto +21 -> 131
    //   113: goto +29 -> 142
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 145	java/io/FileInputStream:close	()V
    //   127: aload_2
    //   128: athrow
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_1
    //   132: ifnull +19 -> 151
    //   135: aload_1
    //   136: astore_2
    //   137: goto -38 -> 99
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +8 -> 151
    //   146: aload_1
    //   147: astore_2
    //   148: goto -49 -> 99
    //   151: ldc 31
    //   153: areturn
    //   154: astore_1
    //   155: goto -15 -> 140
    //   158: astore_1
    //   159: goto -30 -> 129
    //   162: astore_2
    //   163: goto -50 -> 113
    //   166: astore_2
    //   167: goto -57 -> 110
    //   170: astore_1
    //   171: aload_2
    //   172: areturn
    //   173: astore_1
    //   174: goto -23 -> 151
    //   177: astore_1
    //   178: goto -51 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	VsGuidUtil
    //   7	140	1	localObject1	Object
    //   154	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   158	1	1	localIOException1	java.io.IOException
    //   170	1	1	localIOException2	java.io.IOException
    //   173	1	1	localIOException3	java.io.IOException
    //   177	1	1	localIOException4	java.io.IOException
    //   45	55	2	localObject2	Object
    //   106	1	2	localObject3	Object
    //   116	12	2	localObject4	Object
    //   136	12	2	localObject5	Object
    //   162	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   166	6	2	localIOException5	java.io.IOException
    //   77	12	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   55	78	106	finally
    //   84	93	106	finally
    //   46	55	116	finally
    //   46	55	154	java/io/FileNotFoundException
    //   46	55	158	java/io/IOException
    //   55	78	162	java/io/FileNotFoundException
    //   84	93	162	java/io/FileNotFoundException
    //   55	78	166	java/io/IOException
    //   84	93	166	java/io/IOException
    //   93	97	170	java/io/IOException
    //   99	103	173	java/io/IOException
    //   123	127	177	java/io/IOException
  }
  
  /* Error */
  public String loadVsGuidFromSdcard()
  {
    // Byte code:
    //   0: new 125	java/io/File
    //   3: dup
    //   4: invokestatic 160	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: ldc 23
    //   9: invokespecial 163	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_2
    //   13: new 132	java/io/FileInputStream
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: astore_1
    //   22: aload_2
    //   23: invokevirtual 138	java/io/File:length	()J
    //   26: l2i
    //   27: newarray byte
    //   29: astore_2
    //   30: aload_1
    //   31: aload_2
    //   32: invokevirtual 142	java/io/FileInputStream:read	([B)I
    //   35: pop
    //   36: aload_1
    //   37: invokevirtual 145	java/io/FileInputStream:close	()V
    //   40: aload_2
    //   41: invokestatic 151	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsEncryptUtil:VsDecrypt_SDCARD	([B)[B
    //   44: astore_3
    //   45: aload_1
    //   46: astore_2
    //   47: aload_3
    //   48: ifnull +18 -> 66
    //   51: new 47	java/lang/String
    //   54: dup
    //   55: aload_3
    //   56: invokespecial 154	java/lang/String:<init>	([B)V
    //   59: astore_2
    //   60: aload_1
    //   61: invokevirtual 145	java/io/FileInputStream:close	()V
    //   64: aload_2
    //   65: areturn
    //   66: aload_2
    //   67: invokevirtual 145	java/io/FileInputStream:close	()V
    //   70: goto +48 -> 118
    //   73: astore_2
    //   74: goto +12 -> 86
    //   77: goto +21 -> 98
    //   80: goto +29 -> 109
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 145	java/io/FileInputStream:close	()V
    //   94: aload_2
    //   95: athrow
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +19 -> 118
    //   102: aload_1
    //   103: astore_2
    //   104: goto -38 -> 66
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull +8 -> 118
    //   113: aload_1
    //   114: astore_2
    //   115: goto -49 -> 66
    //   118: ldc 31
    //   120: areturn
    //   121: astore_1
    //   122: goto -15 -> 107
    //   125: astore_1
    //   126: goto -30 -> 96
    //   129: astore_2
    //   130: goto -50 -> 80
    //   133: astore_2
    //   134: goto -57 -> 77
    //   137: astore_1
    //   138: aload_2
    //   139: areturn
    //   140: astore_1
    //   141: goto -23 -> 118
    //   144: astore_1
    //   145: goto -51 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	VsGuidUtil
    //   21	93	1	localFileInputStream	java.io.FileInputStream
    //   121	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   125	1	1	localIOException1	java.io.IOException
    //   137	1	1	localIOException2	java.io.IOException
    //   140	1	1	localIOException3	java.io.IOException
    //   144	1	1	localIOException4	java.io.IOException
    //   12	55	2	localObject1	Object
    //   73	1	2	localObject2	Object
    //   83	12	2	localObject3	Object
    //   103	12	2	localObject4	Object
    //   129	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   133	6	2	localIOException5	java.io.IOException
    //   44	12	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	45	73	finally
    //   51	60	73	finally
    //   13	22	83	finally
    //   13	22	121	java/io/FileNotFoundException
    //   13	22	125	java/io/IOException
    //   22	45	129	java/io/FileNotFoundException
    //   51	60	129	java/io/FileNotFoundException
    //   22	45	133	java/io/IOException
    //   51	60	133	java/io/IOException
    //   60	64	137	java/io/IOException
    //   66	70	140	java/io/IOException
    //   90	94	144	java/io/IOException
  }
  
  /* Error */
  public void saveVsGuidToApplocal(String paramString)
  {
    // Byte code:
    //   0: new 110	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 113
    //   11: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: aload_0
    //   17: getfield 37	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsGuidUtil:context	Landroid/content/Context;
    //   20: invokestatic 123	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsAppInfo:getPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   23: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc 27
    //   30: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: new 125	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aconst_null
    //   47: astore 4
    //   49: aconst_null
    //   50: astore 5
    //   52: aconst_null
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 166	java/io/File:getParentFile	()Ljava/io/File;
    //   58: invokevirtual 169	java/io/File:mkdirs	()Z
    //   61: pop
    //   62: aload_2
    //   63: invokevirtual 172	java/io/File:createNewFile	()Z
    //   66: pop
    //   67: new 174	java/io/FileOutputStream
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: astore_2
    //   76: aload_2
    //   77: aload_1
    //   78: invokevirtual 179	java/lang/String:getBytes	()[B
    //   81: invokestatic 182	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsEncryptUtil:VsEncrypt_SDCARD	([B)[B
    //   84: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   87: aload_2
    //   88: invokevirtual 188	java/io/FileOutputStream:flush	()V
    //   91: aload_2
    //   92: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   95: return
    //   96: astore_1
    //   97: goto +16 -> 113
    //   100: aload_2
    //   101: astore_1
    //   102: goto +21 -> 123
    //   105: aload_2
    //   106: astore_1
    //   107: goto +25 -> 132
    //   110: astore_1
    //   111: aload_3
    //   112: astore_2
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   121: aload_1
    //   122: athrow
    //   123: aload_1
    //   124: ifnull +15 -> 139
    //   127: aload_1
    //   128: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   131: return
    //   132: aload_1
    //   133: ifnull +6 -> 139
    //   136: goto -9 -> 127
    //   139: return
    //   140: astore_1
    //   141: aload 5
    //   143: astore_1
    //   144: goto -12 -> 132
    //   147: astore_1
    //   148: aload 4
    //   150: astore_1
    //   151: goto -28 -> 123
    //   154: astore_1
    //   155: goto -50 -> 105
    //   158: astore_1
    //   159: goto -59 -> 100
    //   162: astore_1
    //   163: return
    //   164: astore_2
    //   165: goto -44 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	VsGuidUtil
    //   0	168	1	paramString	String
    //   7	111	2	localObject1	Object
    //   164	1	2	localIOException	java.io.IOException
    //   53	59	3	localObject2	Object
    //   47	102	4	localObject3	Object
    //   50	92	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   76	91	96	finally
    //   54	76	110	finally
    //   54	76	140	java/io/FileNotFoundException
    //   54	76	147	java/io/IOException
    //   76	91	154	java/io/FileNotFoundException
    //   76	91	158	java/io/IOException
    //   91	95	162	java/io/IOException
    //   127	131	162	java/io/IOException
    //   117	121	164	java/io/IOException
  }
  
  /* Error */
  public void saveVsGuidToSdcard(String paramString)
  {
    // Byte code:
    //   0: new 125	java/io/File
    //   3: dup
    //   4: invokestatic 160	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: ldc 23
    //   9: invokespecial 163	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore_3
    //   21: aload_2
    //   22: invokevirtual 166	java/io/File:getParentFile	()Ljava/io/File;
    //   25: invokevirtual 169	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: aload_2
    //   30: invokevirtual 172	java/io/File:createNewFile	()Z
    //   33: pop
    //   34: new 174	java/io/FileOutputStream
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   42: astore_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 179	java/lang/String:getBytes	()[B
    //   48: invokestatic 182	com/tencent/qqlive/tvkplayer/vinfo/ckey/comm/VsEncryptUtil:VsEncrypt_SDCARD	([B)[B
    //   51: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   54: aload_2
    //   55: invokevirtual 188	java/io/FileOutputStream:flush	()V
    //   58: aload_2
    //   59: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   62: return
    //   63: astore_1
    //   64: goto +16 -> 80
    //   67: aload_2
    //   68: astore_1
    //   69: goto +21 -> 90
    //   72: aload_2
    //   73: astore_1
    //   74: goto +25 -> 99
    //   77: astore_1
    //   78: aload_3
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   88: aload_1
    //   89: athrow
    //   90: aload_1
    //   91: ifnull +15 -> 106
    //   94: aload_1
    //   95: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   98: return
    //   99: aload_1
    //   100: ifnull +6 -> 106
    //   103: goto -9 -> 94
    //   106: return
    //   107: astore_1
    //   108: aload 5
    //   110: astore_1
    //   111: goto -12 -> 99
    //   114: astore_1
    //   115: aload 4
    //   117: astore_1
    //   118: goto -28 -> 90
    //   121: astore_1
    //   122: goto -50 -> 72
    //   125: astore_1
    //   126: goto -59 -> 67
    //   129: astore_1
    //   130: return
    //   131: astore_2
    //   132: goto -44 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	VsGuidUtil
    //   0	135	1	paramString	String
    //   12	73	2	localObject1	Object
    //   131	1	2	localIOException	java.io.IOException
    //   20	59	3	localObject2	Object
    //   14	102	4	localObject3	Object
    //   17	92	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   43	58	63	finally
    //   21	43	77	finally
    //   21	43	107	java/io/FileNotFoundException
    //   21	43	114	java/io/IOException
    //   43	58	121	java/io/FileNotFoundException
    //   43	58	125	java/io/IOException
    //   58	62	129	java/io/IOException
    //   94	98	129	java/io/IOException
    //   84	88	131	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsGuidUtil
 * JD-Core Version:    0.7.0.1
 */