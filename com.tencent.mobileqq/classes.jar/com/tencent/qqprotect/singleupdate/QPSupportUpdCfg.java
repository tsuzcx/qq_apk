package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class QPSupportUpdCfg
  implements Serializable
{
  static String CFG_FILEPATH;
  public QPSupportUpdCfg.QPUpdFileItem[] fileItem;
  public int iConfigFileVersion = 0;
  public int iRequestTime = 24;
  
  QPSupportUpdCfg()
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject).getFilesDir().getAbsoluteFile());
    localStringBuilder.append("/TxSingleUpd/SupportUpd.cfg");
    CFG_FILEPATH = localStringBuilder.toString();
    localObject = new File(CFG_FILEPATH);
    if (!((File)localObject).exists())
    {
      this.fileItem = new QPSupportUpdCfg.QPUpdFileItem[1];
      this.fileItem[0] = new QPSupportUpdCfg.QPUpdFileItem(this);
      this.fileItem[0].strFilePath = new String(CFG_FILEPATH);
      this.fileItem[0].strFileHash = new String("");
      try
      {
        ((File)localObject).createNewFile();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      WriteConfigFile();
    }
  }
  
  private boolean a(File paramFile)
  {
    return (paramFile.exists()) && (paramFile.canRead()) && (paramFile.length() < 10002432L);
  }
  
  public static boolean deleteCfg()
  {
    Object localObject = CFG_FILEPATH;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return ((File)localObject).delete();
      }
    }
    return true;
  }
  
  public boolean CheckFileState()
  {
    if (this.fileItem == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      Object localObject = this.fileItem;
      if (i >= localObject.length) {
        break;
      }
      File localFile = new File(localObject[i].strFilePath);
      if (!localFile.exists()) {
        return false;
      }
      localObject = null;
      try
      {
        if (a(localFile)) {
          localObject = MD5FileUtil.a(this.fileItem[i].strFilePath);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool = TextUtils.equals((CharSequence)localObject, this.fileItem[i].strFileHash);
          if (!bool) {
            return false;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i += 1;
      }
    }
    return true;
  }
  
  public boolean IsFileInConfigFile(String paramString)
  {
    paramString = QPUpdFileOperation.b(paramString);
    QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = this.fileItem;
    if (arrayOfQPUpdFileItem == null) {
      return false;
    }
    int j = arrayOfQPUpdFileItem.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equalsIgnoreCase(QPUpdFileOperation.b(this.fileItem[i].strFilePath))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  /* Error */
  public boolean ReadConfigFile(String paramString)
  {
    // Byte code:
    //   0: new 42	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 67	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: new 145	java/io/FileInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore 5
    //   28: new 150	java/io/DataInputStream
    //   31: dup
    //   32: aload 5
    //   34: invokespecial 153	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_1
    //   38: aload_1
    //   39: astore 6
    //   41: aload 5
    //   43: astore 7
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 157	java/io/DataInputStream:readInt	()I
    //   50: putfield 23	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:iConfigFileVersion	I
    //   53: aload_1
    //   54: astore 6
    //   56: aload 5
    //   58: astore 7
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 157	java/io/DataInputStream:readInt	()I
    //   65: putfield 25	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:iRequestTime	I
    //   68: aload_1
    //   69: astore 6
    //   71: aload 5
    //   73: astore 7
    //   75: aload_1
    //   76: invokevirtual 157	java/io/DataInputStream:readInt	()I
    //   79: istore_3
    //   80: iload_3
    //   81: bipush 100
    //   83: if_icmpgt +385 -> 468
    //   86: iload_3
    //   87: istore_2
    //   88: iload_3
    //   89: ifge +6 -> 95
    //   92: goto +376 -> 468
    //   95: iload_2
    //   96: ifeq +225 -> 321
    //   99: aload_1
    //   100: astore 6
    //   102: aload 5
    //   104: astore 7
    //   106: aload_0
    //   107: iload_2
    //   108: anewarray 69	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem
    //   111: putfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   114: iconst_0
    //   115: istore_3
    //   116: iload_3
    //   117: iload_2
    //   118: if_icmpge +203 -> 321
    //   121: aload_1
    //   122: astore 6
    //   124: aload 5
    //   126: astore 7
    //   128: aload_0
    //   129: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   132: iload_3
    //   133: new 69	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem
    //   136: dup
    //   137: aload_0
    //   138: invokespecial 74	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:<init>	(Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg;)V
    //   141: aastore
    //   142: aload_1
    //   143: astore 6
    //   145: aload 5
    //   147: astore 7
    //   149: sipush 512
    //   152: newarray byte
    //   154: astore 8
    //   156: aload_1
    //   157: astore 6
    //   159: aload 5
    //   161: astore 7
    //   163: aload_1
    //   164: invokevirtual 157	java/io/DataInputStream:readInt	()I
    //   167: istore 4
    //   169: aload_1
    //   170: astore 6
    //   172: aload 5
    //   174: astore 7
    //   176: aload_1
    //   177: aload 8
    //   179: iconst_0
    //   180: iload 4
    //   182: invokevirtual 161	java/io/DataInputStream:read	([BII)I
    //   185: pop
    //   186: aload_1
    //   187: astore 6
    //   189: aload 5
    //   191: astore 7
    //   193: new 76	java/lang/String
    //   196: dup
    //   197: aload 8
    //   199: invokespecial 164	java/lang/String:<init>	([B)V
    //   202: astore 8
    //   204: aload_1
    //   205: astore 6
    //   207: aload 5
    //   209: astore 7
    //   211: aload_0
    //   212: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   215: iload_3
    //   216: aaload
    //   217: aload 8
    //   219: iconst_0
    //   220: iload 4
    //   222: invokevirtual 168	java/lang/String:substring	(II)Ljava/lang/String;
    //   225: putfield 80	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFilePath	Ljava/lang/String;
    //   228: aload_1
    //   229: astore 6
    //   231: aload 5
    //   233: astore 7
    //   235: sipush 128
    //   238: newarray byte
    //   240: astore 8
    //   242: aload_1
    //   243: astore 6
    //   245: aload 5
    //   247: astore 7
    //   249: aload_1
    //   250: invokevirtual 157	java/io/DataInputStream:readInt	()I
    //   253: istore 4
    //   255: aload_1
    //   256: astore 6
    //   258: aload 5
    //   260: astore 7
    //   262: aload_1
    //   263: aload 8
    //   265: iconst_0
    //   266: iload 4
    //   268: invokevirtual 161	java/io/DataInputStream:read	([BII)I
    //   271: pop
    //   272: aload_1
    //   273: astore 6
    //   275: aload 5
    //   277: astore 7
    //   279: new 76	java/lang/String
    //   282: dup
    //   283: aload 8
    //   285: invokespecial 164	java/lang/String:<init>	([B)V
    //   288: astore 8
    //   290: aload_1
    //   291: astore 6
    //   293: aload 5
    //   295: astore 7
    //   297: aload_0
    //   298: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   301: iload_3
    //   302: aaload
    //   303: aload 8
    //   305: iconst_0
    //   306: iload 4
    //   308: invokevirtual 168	java/lang/String:substring	(II)Ljava/lang/String;
    //   311: putfield 85	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFileHash	Ljava/lang/String;
    //   314: iload_3
    //   315: iconst_1
    //   316: iadd
    //   317: istore_3
    //   318: goto -202 -> 116
    //   321: aload 5
    //   323: invokevirtual 171	java/io/FileInputStream:close	()V
    //   326: aload_1
    //   327: invokevirtual 172	java/io/DataInputStream:close	()V
    //   330: iconst_1
    //   331: ireturn
    //   332: astore 8
    //   334: goto +36 -> 370
    //   337: astore_1
    //   338: aconst_null
    //   339: astore 6
    //   341: goto +69 -> 410
    //   344: astore 8
    //   346: aconst_null
    //   347: astore_1
    //   348: goto +22 -> 370
    //   351: astore_1
    //   352: aconst_null
    //   353: astore 5
    //   355: aload 5
    //   357: astore 6
    //   359: goto +51 -> 410
    //   362: astore 8
    //   364: aconst_null
    //   365: astore 5
    //   367: aload 5
    //   369: astore_1
    //   370: aload_1
    //   371: astore 6
    //   373: aload 5
    //   375: astore 7
    //   377: aload 8
    //   379: invokevirtual 173	java/lang/Throwable:printStackTrace	()V
    //   382: aload 5
    //   384: ifnull +11 -> 395
    //   387: aload 5
    //   389: invokevirtual 171	java/io/FileInputStream:close	()V
    //   392: goto +3 -> 395
    //   395: aload_1
    //   396: ifnull +7 -> 403
    //   399: aload_1
    //   400: invokevirtual 172	java/io/DataInputStream:close	()V
    //   403: iconst_0
    //   404: ireturn
    //   405: astore_1
    //   406: aload 7
    //   408: astore 5
    //   410: aload 5
    //   412: ifnull +11 -> 423
    //   415: aload 5
    //   417: invokevirtual 171	java/io/FileInputStream:close	()V
    //   420: goto +3 -> 423
    //   423: aload 6
    //   425: ifnull +8 -> 433
    //   428: aload 6
    //   430: invokevirtual 172	java/io/DataInputStream:close	()V
    //   433: goto +5 -> 438
    //   436: aload_1
    //   437: athrow
    //   438: goto -2 -> 436
    //   441: astore 5
    //   443: goto -117 -> 326
    //   446: astore_1
    //   447: goto -117 -> 330
    //   450: astore 5
    //   452: goto -57 -> 395
    //   455: astore_1
    //   456: iconst_0
    //   457: ireturn
    //   458: astore 5
    //   460: goto -37 -> 423
    //   463: astore 5
    //   465: goto -32 -> 433
    //   468: iconst_0
    //   469: istore_2
    //   470: goto -375 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	QPSupportUpdCfg
    //   0	473	1	paramString	String
    //   87	383	2	i	int
    //   79	239	3	j	int
    //   167	140	4	k	int
    //   26	390	5	localObject1	Object
    //   441	1	5	localIOException1	IOException
    //   450	1	5	localIOException2	IOException
    //   458	1	5	localIOException3	IOException
    //   463	1	5	localIOException4	IOException
    //   39	390	6	localObject2	Object
    //   43	364	7	localObject3	Object
    //   154	150	8	localObject4	Object
    //   332	1	8	localThrowable1	java.lang.Throwable
    //   344	1	8	localThrowable2	java.lang.Throwable
    //   362	16	8	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   45	53	332	java/lang/Throwable
    //   60	68	332	java/lang/Throwable
    //   75	80	332	java/lang/Throwable
    //   106	114	332	java/lang/Throwable
    //   128	142	332	java/lang/Throwable
    //   149	156	332	java/lang/Throwable
    //   163	169	332	java/lang/Throwable
    //   176	186	332	java/lang/Throwable
    //   193	204	332	java/lang/Throwable
    //   211	228	332	java/lang/Throwable
    //   235	242	332	java/lang/Throwable
    //   249	255	332	java/lang/Throwable
    //   262	272	332	java/lang/Throwable
    //   279	290	332	java/lang/Throwable
    //   297	314	332	java/lang/Throwable
    //   28	38	337	finally
    //   28	38	344	java/lang/Throwable
    //   18	28	351	finally
    //   18	28	362	java/lang/Throwable
    //   45	53	405	finally
    //   60	68	405	finally
    //   75	80	405	finally
    //   106	114	405	finally
    //   128	142	405	finally
    //   149	156	405	finally
    //   163	169	405	finally
    //   176	186	405	finally
    //   193	204	405	finally
    //   211	228	405	finally
    //   235	242	405	finally
    //   249	255	405	finally
    //   262	272	405	finally
    //   279	290	405	finally
    //   297	314	405	finally
    //   377	382	405	finally
    //   321	326	441	java/io/IOException
    //   326	330	446	java/io/IOException
    //   387	392	450	java/io/IOException
    //   399	403	455	java/io/IOException
    //   415	420	458	java/io/IOException
    //   428	433	463	java/io/IOException
  }
  
  /* Error */
  public boolean WriteConfigFile()
  {
    // Byte code:
    //   0: new 42	java/io/File
    //   3: dup
    //   4: getstatic 60	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:CFG_FILEPATH	Ljava/lang/String;
    //   7: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 67	java/io/File:exists	()Z
    //   15: istore_2
    //   16: iconst_0
    //   17: istore_1
    //   18: iload_2
    //   19: ifeq +12 -> 31
    //   22: aload_3
    //   23: invokevirtual 109	java/io/File:delete	()Z
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 177	java/io/FileOutputStream
    //   34: dup
    //   35: getstatic 60	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:CFG_FILEPATH	Ljava/lang/String;
    //   38: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   41: astore_3
    //   42: new 180	java/io/DataOutputStream
    //   45: dup
    //   46: aload_3
    //   47: invokespecial 183	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: astore 6
    //   52: aload_3
    //   53: astore 4
    //   55: aload 6
    //   57: astore 5
    //   59: aload 6
    //   61: aload_0
    //   62: getfield 23	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:iConfigFileVersion	I
    //   65: invokevirtual 187	java/io/DataOutputStream:writeInt	(I)V
    //   68: aload_3
    //   69: astore 4
    //   71: aload 6
    //   73: astore 5
    //   75: aload 6
    //   77: aload_0
    //   78: getfield 25	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:iRequestTime	I
    //   81: invokevirtual 187	java/io/DataOutputStream:writeInt	(I)V
    //   84: aload_3
    //   85: astore 4
    //   87: aload 6
    //   89: astore 5
    //   91: aload_0
    //   92: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   95: ifnonnull +19 -> 114
    //   98: aload_3
    //   99: astore 4
    //   101: aload 6
    //   103: astore 5
    //   105: aload 6
    //   107: iconst_0
    //   108: invokevirtual 187	java/io/DataOutputStream:writeInt	(I)V
    //   111: goto +139 -> 250
    //   114: aload_3
    //   115: astore 4
    //   117: aload 6
    //   119: astore 5
    //   121: aload 6
    //   123: aload_0
    //   124: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   127: arraylength
    //   128: invokevirtual 187	java/io/DataOutputStream:writeInt	(I)V
    //   131: aload_3
    //   132: astore 4
    //   134: aload 6
    //   136: astore 5
    //   138: iload_1
    //   139: aload_0
    //   140: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   143: arraylength
    //   144: if_icmpge +106 -> 250
    //   147: aload_3
    //   148: astore 4
    //   150: aload 6
    //   152: astore 5
    //   154: aload 6
    //   156: aload_0
    //   157: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   160: iload_1
    //   161: aaload
    //   162: getfield 80	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFilePath	Ljava/lang/String;
    //   165: invokevirtual 189	java/lang/String:length	()I
    //   168: invokevirtual 187	java/io/DataOutputStream:writeInt	(I)V
    //   171: aload_3
    //   172: astore 4
    //   174: aload 6
    //   176: astore 5
    //   178: aload 6
    //   180: aload_0
    //   181: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   184: iload_1
    //   185: aaload
    //   186: getfield 80	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFilePath	Ljava/lang/String;
    //   189: invokevirtual 193	java/lang/String:getBytes	()[B
    //   192: invokevirtual 196	java/io/DataOutputStream:write	([B)V
    //   195: aload_3
    //   196: astore 4
    //   198: aload 6
    //   200: astore 5
    //   202: aload 6
    //   204: aload_0
    //   205: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   208: iload_1
    //   209: aaload
    //   210: getfield 85	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFileHash	Ljava/lang/String;
    //   213: invokevirtual 189	java/lang/String:length	()I
    //   216: invokevirtual 187	java/io/DataOutputStream:writeInt	(I)V
    //   219: aload_3
    //   220: astore 4
    //   222: aload 6
    //   224: astore 5
    //   226: aload 6
    //   228: aload_0
    //   229: getfield 71	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   232: iload_1
    //   233: aaload
    //   234: getfield 85	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFileHash	Ljava/lang/String;
    //   237: invokevirtual 193	java/lang/String:getBytes	()[B
    //   240: invokevirtual 196	java/io/DataOutputStream:write	([B)V
    //   243: iload_1
    //   244: iconst_1
    //   245: iadd
    //   246: istore_1
    //   247: goto -116 -> 131
    //   250: aload_3
    //   251: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   254: goto +8 -> 262
    //   257: astore_3
    //   258: aload_3
    //   259: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   262: aload 6
    //   264: invokevirtual 198	java/io/DataOutputStream:close	()V
    //   267: goto +177 -> 444
    //   270: astore 7
    //   272: aload_3
    //   273: astore 8
    //   275: aload 6
    //   277: astore_3
    //   278: goto +68 -> 346
    //   281: astore 7
    //   283: aload_3
    //   284: astore 8
    //   286: aload 6
    //   288: astore_3
    //   289: goto +107 -> 396
    //   292: astore 4
    //   294: aconst_null
    //   295: astore 5
    //   297: goto +158 -> 455
    //   300: astore 7
    //   302: aconst_null
    //   303: astore 4
    //   305: aload_3
    //   306: astore 8
    //   308: aload 4
    //   310: astore_3
    //   311: goto +35 -> 346
    //   314: astore 7
    //   316: aconst_null
    //   317: astore 4
    //   319: aload_3
    //   320: astore 8
    //   322: aload 4
    //   324: astore_3
    //   325: goto +71 -> 396
    //   328: astore 4
    //   330: aconst_null
    //   331: astore 5
    //   333: aload 5
    //   335: astore_3
    //   336: goto +119 -> 455
    //   339: astore 7
    //   341: aconst_null
    //   342: astore_3
    //   343: aload_3
    //   344: astore 8
    //   346: aload 8
    //   348: astore 4
    //   350: aload_3
    //   351: astore 5
    //   353: aload 7
    //   355: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   358: aload 8
    //   360: ifnull +18 -> 378
    //   363: aload 8
    //   365: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   368: goto +10 -> 378
    //   371: astore 4
    //   373: aload 4
    //   375: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   378: aload_3
    //   379: ifnull +65 -> 444
    //   382: aload_3
    //   383: invokevirtual 198	java/io/DataOutputStream:close	()V
    //   386: goto +58 -> 444
    //   389: astore 7
    //   391: aconst_null
    //   392: astore_3
    //   393: aload_3
    //   394: astore 8
    //   396: aload 8
    //   398: astore 4
    //   400: aload_3
    //   401: astore 5
    //   403: aload 7
    //   405: invokevirtual 199	java/io/FileNotFoundException:printStackTrace	()V
    //   408: aload 8
    //   410: ifnull +18 -> 428
    //   413: aload 8
    //   415: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   418: goto +10 -> 428
    //   421: astore 4
    //   423: aload 4
    //   425: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   428: aload_3
    //   429: ifnull +15 -> 444
    //   432: aload_3
    //   433: invokevirtual 198	java/io/DataOutputStream:close	()V
    //   436: goto +8 -> 444
    //   439: astore_3
    //   440: aload_3
    //   441: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   444: iconst_1
    //   445: ireturn
    //   446: astore 6
    //   448: aload 4
    //   450: astore_3
    //   451: aload 6
    //   453: astore 4
    //   455: aload_3
    //   456: ifnull +15 -> 471
    //   459: aload_3
    //   460: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   463: goto +8 -> 471
    //   466: astore_3
    //   467: aload_3
    //   468: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   471: aload 5
    //   473: ifnull +16 -> 489
    //   476: aload 5
    //   478: invokevirtual 198	java/io/DataOutputStream:close	()V
    //   481: goto +8 -> 489
    //   484: astore_3
    //   485: aload_3
    //   486: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   489: goto +6 -> 495
    //   492: aload 4
    //   494: athrow
    //   495: goto -3 -> 492
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	this	QPSupportUpdCfg
    //   17	230	1	i	int
    //   15	4	2	bool	boolean
    //   10	241	3	localObject1	Object
    //   257	16	3	localIOException1	IOException
    //   277	156	3	localObject2	Object
    //   439	2	3	localIOException2	IOException
    //   450	10	3	localObject3	Object
    //   466	2	3	localIOException3	IOException
    //   484	2	3	localIOException4	IOException
    //   53	168	4	localObject4	Object
    //   292	1	4	localObject5	Object
    //   303	20	4	localObject6	Object
    //   328	1	4	localObject7	Object
    //   348	1	4	localObject8	Object
    //   371	3	4	localIOException5	IOException
    //   398	1	4	localObject9	Object
    //   421	28	4	localIOException6	IOException
    //   453	40	4	localObject10	Object
    //   57	420	5	localObject11	Object
    //   50	237	6	localDataOutputStream	java.io.DataOutputStream
    //   446	6	6	localObject12	Object
    //   270	1	7	localIOException7	IOException
    //   281	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   300	1	7	localIOException8	IOException
    //   314	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   339	15	7	localIOException9	IOException
    //   389	15	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   273	141	8	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   250	254	257	java/io/IOException
    //   59	68	270	java/io/IOException
    //   75	84	270	java/io/IOException
    //   91	98	270	java/io/IOException
    //   105	111	270	java/io/IOException
    //   121	131	270	java/io/IOException
    //   138	147	270	java/io/IOException
    //   154	171	270	java/io/IOException
    //   178	195	270	java/io/IOException
    //   202	219	270	java/io/IOException
    //   226	243	270	java/io/IOException
    //   59	68	281	java/io/FileNotFoundException
    //   75	84	281	java/io/FileNotFoundException
    //   91	98	281	java/io/FileNotFoundException
    //   105	111	281	java/io/FileNotFoundException
    //   121	131	281	java/io/FileNotFoundException
    //   138	147	281	java/io/FileNotFoundException
    //   154	171	281	java/io/FileNotFoundException
    //   178	195	281	java/io/FileNotFoundException
    //   202	219	281	java/io/FileNotFoundException
    //   226	243	281	java/io/FileNotFoundException
    //   42	52	292	finally
    //   42	52	300	java/io/IOException
    //   42	52	314	java/io/FileNotFoundException
    //   31	42	328	finally
    //   31	42	339	java/io/IOException
    //   363	368	371	java/io/IOException
    //   31	42	389	java/io/FileNotFoundException
    //   413	418	421	java/io/IOException
    //   262	267	439	java/io/IOException
    //   382	386	439	java/io/IOException
    //   432	436	439	java/io/IOException
    //   59	68	446	finally
    //   75	84	446	finally
    //   91	98	446	finally
    //   105	111	446	finally
    //   121	131	446	finally
    //   138	147	446	finally
    //   154	171	446	finally
    //   178	195	446	finally
    //   202	219	446	finally
    //   226	243	446	finally
    //   353	358	446	finally
    //   403	408	446	finally
    //   459	463	466	java/io/IOException
    //   476	481	484	java/io/IOException
  }
  
  public void addFileItem(String paramString1, File paramFile, String paramString2)
  {
    QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = this.fileItem;
    int i;
    if (arrayOfQPUpdFileItem == null) {
      i = 1;
    } else {
      i = arrayOfQPUpdFileItem.length + 1;
    }
    arrayOfQPUpdFileItem = this.fileItem;
    this.fileItem = new QPSupportUpdCfg.QPUpdFileItem[i];
    int j = 0;
    int k;
    for (;;)
    {
      k = i - 1;
      if (j >= k) {
        break;
      }
      this.fileItem[j] = arrayOfQPUpdFileItem[j];
      j += 1;
    }
    this.fileItem[k] = new QPSupportUpdCfg.QPUpdFileItem(this);
    arrayOfQPUpdFileItem = this.fileItem;
    arrayOfQPUpdFileItem[k].strFilePath = paramString2;
    arrayOfQPUpdFileItem[k].strFileHash = "00000000000000000000000000000000";
    if (a(paramFile))
    {
      paramString1 = MD5FileUtil.a(paramString1);
      if (paramString1 != null) {
        this.fileItem[k].strFileHash = paramString1;
      }
    }
  }
  
  public boolean addFileItem(String paramString, File paramFile)
  {
    boolean bool = paramFile.exists();
    int k = 0;
    if (bool)
    {
      QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = this.fileItem;
      int i;
      if (arrayOfQPUpdFileItem != null) {
        i = arrayOfQPUpdFileItem.length;
      } else {
        i = 0;
      }
      arrayOfQPUpdFileItem = new QPSupportUpdCfg.QPUpdFileItem[i + 1];
      int j = 0;
      while (j < arrayOfQPUpdFileItem.length)
      {
        arrayOfQPUpdFileItem[j] = new QPSupportUpdCfg.QPUpdFileItem(this);
        j += 1;
      }
      if (this.fileItem != null)
      {
        j = k;
        while (j < i)
        {
          arrayOfQPUpdFileItem[j] = this.fileItem[j];
          j += 1;
        }
      }
      arrayOfQPUpdFileItem[i].strFileHash = "00000000000000000000000000000000";
      if (a(paramFile))
      {
        paramString = MD5FileUtil.a(paramString);
        if (paramString != null) {
          arrayOfQPUpdFileItem[i].strFileHash = paramString;
        }
      }
      arrayOfQPUpdFileItem[i].strFilePath = paramFile.getAbsolutePath();
      this.fileItem = arrayOfQPUpdFileItem;
      WriteConfigFile();
      return true;
    }
    return false;
  }
  
  public String getFileDstPath(String paramString)
  {
    paramString = QPUpdFileOperation.b(paramString);
    QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = this.fileItem;
    if (arrayOfQPUpdFileItem == null) {
      return null;
    }
    int j = arrayOfQPUpdFileItem.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equalsIgnoreCase(QPUpdFileOperation.b(this.fileItem[i].strFilePath))) {
        return this.fileItem[i].strFilePath;
      }
      i += 1;
    }
    return null;
  }
  
  public String getFileHash(String paramString)
  {
    int i = getFileIndexInConfigFile(paramString);
    if (i == -1) {
      return null;
    }
    return this.fileItem[i].strFileHash;
  }
  
  public int getFileIndexInConfigFile(String paramString)
  {
    paramString = QPUpdFileOperation.b(paramString);
    QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = this.fileItem;
    if (arrayOfQPUpdFileItem == null) {
      return -1;
    }
    int j = arrayOfQPUpdFileItem.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equalsIgnoreCase(QPUpdFileOperation.b(this.fileItem[i].strFilePath)))
      {
        paramString = this.fileItem[i].strFilePath;
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getFileItemCount()
  {
    QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = this.fileItem;
    if (arrayOfQPUpdFileItem == null) {
      return 0;
    }
    return arrayOfQPUpdFileItem.length;
  }
  
  public void updateCfgHash()
  {
    if (this.fileItem == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      Object localObject = this.fileItem;
      if (i >= localObject.length) {
        break;
      }
      if (!QPUpdFileOperation.b(localObject[i].strFilePath).equalsIgnoreCase("SupportUpd.cfg"))
      {
        localObject = new File(this.fileItem[i].strFilePath);
        this.fileItem[i].strFileHash = "00000000000000000000000000000000";
        if (a((File)localObject))
        {
          localObject = MD5FileUtil.a(this.fileItem[i].strFilePath);
          if (localObject != null) {
            this.fileItem[i].strFileHash = ((String)localObject);
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSupportUpdCfg
 * JD-Core Version:    0.7.0.1
 */