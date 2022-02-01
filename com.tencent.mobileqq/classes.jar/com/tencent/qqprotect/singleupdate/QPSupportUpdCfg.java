package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import android.text.TextUtils;
import bkcx;
import bkcy;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class QPSupportUpdCfg
  implements Serializable
{
  static String CFG_FILEPATH;
  public QPSupportUpdCfg.QPUpdFileItem[] fileItem;
  public int iConfigFileVersion;
  public int iRequestTime = 24;
  
  QPSupportUpdCfg()
  {
    Object localObject = BaseApplication.getContext();
    CFG_FILEPATH = ((Context)localObject).getFilesDir().getAbsoluteFile() + "/TxSingleUpd/SupportUpd.cfg";
    localObject = new File(CFG_FILEPATH);
    if (!((File)localObject).exists())
    {
      this.fileItem = new QPSupportUpdCfg.QPUpdFileItem[1];
      this.fileItem[0] = new QPSupportUpdCfg.QPUpdFileItem(this);
      this.fileItem[0].strFilePath = new String(CFG_FILEPATH);
      this.fileItem[0].strFileHash = new String("");
    }
    try
    {
      ((File)localObject).createNewFile();
      WriteConfigFile();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private boolean a(File paramFile)
  {
    return (paramFile.exists()) && (paramFile.canRead()) && (paramFile.length() < 10002432L);
  }
  
  public static boolean deleteCfg()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (CFG_FILEPATH != null)
    {
      File localFile = new File(CFG_FILEPATH);
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = localFile.delete();
      }
    }
    return bool1;
  }
  
  public boolean CheckFileState()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.fileItem == null)
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      for (;;)
      {
        if (i >= this.fileItem.length) {
          break label126;
        }
        File localFile = new File(this.fileItem[i].strFilePath);
        bool1 = bool2;
        if (!localFile.exists()) {
          break;
        }
        String str = null;
        try
        {
          if (a(localFile)) {
            str = bkcx.a(this.fileItem[i].strFilePath);
          }
          if (!TextUtils.isEmpty(str))
          {
            boolean bool3 = TextUtils.equals(str, this.fileItem[i].strFileHash);
            bool1 = bool2;
            if (!bool3) {
              break;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      i += 1;
    }
    label126:
    return true;
  }
  
  public boolean IsFileInConfigFile(String paramString)
  {
    paramString = bkcy.a(paramString);
    if (this.fileItem == null) {}
    for (;;)
    {
      return false;
      int j = this.fileItem.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equalsIgnoreCase(bkcy.a(this.fileItem[i].strFilePath))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public boolean ReadConfigFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 38	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 63	java/io/File:exists	()Z
    //   16: ifne +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: new 140	java/io/FileInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore 6
    //   31: new 145	java/io/DataInputStream
    //   34: dup
    //   35: aload 6
    //   37: invokespecial 148	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_1
    //   41: aload_0
    //   42: aload_1
    //   43: invokevirtual 152	java/io/DataInputStream:readInt	()I
    //   46: putfield 154	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:iConfigFileVersion	I
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 152	java/io/DataInputStream:readInt	()I
    //   54: putfield 21	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:iRequestTime	I
    //   57: aload_1
    //   58: invokevirtual 152	java/io/DataInputStream:readInt	()I
    //   61: istore_2
    //   62: iload_2
    //   63: bipush 100
    //   65: if_icmpgt +311 -> 376
    //   68: iload_2
    //   69: ifge +304 -> 373
    //   72: goto +304 -> 376
    //   75: iload_2
    //   76: ifeq +141 -> 217
    //   79: aload_0
    //   80: iload_2
    //   81: anewarray 65	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem
    //   84: putfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   87: iconst_0
    //   88: istore_3
    //   89: iload_3
    //   90: iload_2
    //   91: if_icmpge +126 -> 217
    //   94: aload_0
    //   95: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   98: iload_3
    //   99: new 65	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem
    //   102: dup
    //   103: aload_0
    //   104: invokespecial 70	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:<init>	(Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg;)V
    //   107: aastore
    //   108: sipush 512
    //   111: newarray byte
    //   113: astore 5
    //   115: aload_1
    //   116: invokevirtual 152	java/io/DataInputStream:readInt	()I
    //   119: istore 4
    //   121: aload_1
    //   122: aload 5
    //   124: iconst_0
    //   125: iload 4
    //   127: invokevirtual 158	java/io/DataInputStream:read	([BII)I
    //   130: pop
    //   131: new 72	java/lang/String
    //   134: dup
    //   135: aload 5
    //   137: invokespecial 161	java/lang/String:<init>	([B)V
    //   140: astore 5
    //   142: aload_0
    //   143: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   146: iload_3
    //   147: aaload
    //   148: aload 5
    //   150: iconst_0
    //   151: iload 4
    //   153: invokevirtual 165	java/lang/String:substring	(II)Ljava/lang/String;
    //   156: putfield 76	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFilePath	Ljava/lang/String;
    //   159: sipush 128
    //   162: newarray byte
    //   164: astore 5
    //   166: aload_1
    //   167: invokevirtual 152	java/io/DataInputStream:readInt	()I
    //   170: istore 4
    //   172: aload_1
    //   173: aload 5
    //   175: iconst_0
    //   176: iload 4
    //   178: invokevirtual 158	java/io/DataInputStream:read	([BII)I
    //   181: pop
    //   182: new 72	java/lang/String
    //   185: dup
    //   186: aload 5
    //   188: invokespecial 161	java/lang/String:<init>	([B)V
    //   191: astore 5
    //   193: aload_0
    //   194: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   197: iload_3
    //   198: aaload
    //   199: aload 5
    //   201: iconst_0
    //   202: iload 4
    //   204: invokevirtual 165	java/lang/String:substring	(II)Ljava/lang/String;
    //   207: putfield 81	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFileHash	Ljava/lang/String;
    //   210: iload_3
    //   211: iconst_1
    //   212: iadd
    //   213: istore_3
    //   214: goto -125 -> 89
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 168	java/io/FileInputStream:close	()V
    //   227: aload_1
    //   228: ifnull +7 -> 235
    //   231: aload_1
    //   232: invokevirtual 169	java/io/DataInputStream:close	()V
    //   235: iconst_1
    //   236: ireturn
    //   237: astore 6
    //   239: aconst_null
    //   240: astore_1
    //   241: aload 6
    //   243: invokevirtual 170	java/lang/Throwable:printStackTrace	()V
    //   246: aload 5
    //   248: ifnull +8 -> 256
    //   251: aload 5
    //   253: invokevirtual 168	java/io/FileInputStream:close	()V
    //   256: aload_1
    //   257: ifnull -238 -> 19
    //   260: aload_1
    //   261: invokevirtual 169	java/io/DataInputStream:close	()V
    //   264: iconst_0
    //   265: ireturn
    //   266: astore_1
    //   267: iconst_0
    //   268: ireturn
    //   269: astore 5
    //   271: aconst_null
    //   272: astore_1
    //   273: aconst_null
    //   274: astore 6
    //   276: aload 6
    //   278: ifnull +8 -> 286
    //   281: aload 6
    //   283: invokevirtual 168	java/io/FileInputStream:close	()V
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 169	java/io/DataInputStream:close	()V
    //   294: aload 5
    //   296: athrow
    //   297: astore 5
    //   299: goto -72 -> 227
    //   302: astore_1
    //   303: goto -68 -> 235
    //   306: astore 5
    //   308: goto -52 -> 256
    //   311: astore 6
    //   313: goto -27 -> 286
    //   316: astore_1
    //   317: goto -23 -> 294
    //   320: astore 5
    //   322: aconst_null
    //   323: astore_1
    //   324: goto -48 -> 276
    //   327: astore 5
    //   329: goto -53 -> 276
    //   332: astore 7
    //   334: aload 5
    //   336: astore 6
    //   338: aload 7
    //   340: astore 5
    //   342: goto -66 -> 276
    //   345: astore 7
    //   347: aconst_null
    //   348: astore_1
    //   349: aload 6
    //   351: astore 5
    //   353: aload 7
    //   355: astore 6
    //   357: goto -116 -> 241
    //   360: astore 7
    //   362: aload 6
    //   364: astore 5
    //   366: aload 7
    //   368: astore 6
    //   370: goto -129 -> 241
    //   373: goto -298 -> 75
    //   376: iconst_0
    //   377: istore_2
    //   378: goto -303 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	QPSupportUpdCfg
    //   0	381	1	paramString	String
    //   61	317	2	i	int
    //   88	126	3	j	int
    //   119	84	4	k	int
    //   1	251	5	localObject1	Object
    //   269	26	5	localObject2	Object
    //   297	1	5	localIOException1	IOException
    //   306	1	5	localIOException2	IOException
    //   320	1	5	localObject3	Object
    //   327	8	5	localObject4	Object
    //   340	25	5	localObject5	Object
    //   29	194	6	localFileInputStream	java.io.FileInputStream
    //   237	5	6	localThrowable1	java.lang.Throwable
    //   274	8	6	localObject6	Object
    //   311	1	6	localIOException3	IOException
    //   336	33	6	localObject7	Object
    //   332	7	7	localObject8	Object
    //   345	9	7	localThrowable2	java.lang.Throwable
    //   360	7	7	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   21	31	237	java/lang/Throwable
    //   260	264	266	java/io/IOException
    //   21	31	269	finally
    //   222	227	297	java/io/IOException
    //   231	235	302	java/io/IOException
    //   251	256	306	java/io/IOException
    //   281	286	311	java/io/IOException
    //   290	294	316	java/io/IOException
    //   31	41	320	finally
    //   41	62	327	finally
    //   79	87	327	finally
    //   94	210	327	finally
    //   241	246	332	finally
    //   31	41	345	java/lang/Throwable
    //   41	62	360	java/lang/Throwable
    //   79	87	360	java/lang/Throwable
    //   94	210	360	java/lang/Throwable
  }
  
  /* Error */
  public boolean WriteConfigFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: new 38	java/io/File
    //   7: dup
    //   8: getstatic 56	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:CFG_FILEPATH	Ljava/lang/String;
    //   11: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 63	java/io/File:exists	()Z
    //   19: ifeq +12 -> 31
    //   22: aload_2
    //   23: invokevirtual 106	java/io/File:delete	()Z
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 174	java/io/FileOutputStream
    //   34: dup
    //   35: getstatic 56	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:CFG_FILEPATH	Ljava/lang/String;
    //   38: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   41: astore_2
    //   42: new 177	java/io/DataOutputStream
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 180	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: astore_3
    //   51: aload_3
    //   52: astore 4
    //   54: aload_2
    //   55: astore 5
    //   57: aload_3
    //   58: aload_0
    //   59: getfield 154	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:iConfigFileVersion	I
    //   62: invokevirtual 184	java/io/DataOutputStream:writeInt	(I)V
    //   65: aload_3
    //   66: astore 4
    //   68: aload_2
    //   69: astore 5
    //   71: aload_3
    //   72: aload_0
    //   73: getfield 21	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:iRequestTime	I
    //   76: invokevirtual 184	java/io/DataOutputStream:writeInt	(I)V
    //   79: aload_3
    //   80: astore 4
    //   82: aload_2
    //   83: astore 5
    //   85: aload_0
    //   86: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   89: ifnonnull +32 -> 121
    //   92: aload_3
    //   93: astore 4
    //   95: aload_2
    //   96: astore 5
    //   98: aload_3
    //   99: iconst_0
    //   100: invokevirtual 184	java/io/DataOutputStream:writeInt	(I)V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 186	java/io/DataOutputStream:close	()V
    //   119: iconst_1
    //   120: ireturn
    //   121: aload_3
    //   122: astore 4
    //   124: aload_2
    //   125: astore 5
    //   127: aload_3
    //   128: aload_0
    //   129: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   132: arraylength
    //   133: invokevirtual 184	java/io/DataOutputStream:writeInt	(I)V
    //   136: aload_3
    //   137: astore 4
    //   139: aload_2
    //   140: astore 5
    //   142: iload_1
    //   143: aload_0
    //   144: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   147: arraylength
    //   148: if_icmpge -45 -> 103
    //   151: aload_3
    //   152: astore 4
    //   154: aload_2
    //   155: astore 5
    //   157: aload_3
    //   158: aload_0
    //   159: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   162: iload_1
    //   163: aaload
    //   164: getfield 76	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFilePath	Ljava/lang/String;
    //   167: invokevirtual 188	java/lang/String:length	()I
    //   170: invokevirtual 184	java/io/DataOutputStream:writeInt	(I)V
    //   173: aload_3
    //   174: astore 4
    //   176: aload_2
    //   177: astore 5
    //   179: aload_3
    //   180: aload_0
    //   181: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   184: iload_1
    //   185: aaload
    //   186: getfield 76	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFilePath	Ljava/lang/String;
    //   189: invokevirtual 192	java/lang/String:getBytes	()[B
    //   192: invokevirtual 195	java/io/DataOutputStream:write	([B)V
    //   195: aload_3
    //   196: astore 4
    //   198: aload_2
    //   199: astore 5
    //   201: aload_3
    //   202: aload_0
    //   203: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   206: iload_1
    //   207: aaload
    //   208: getfield 81	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFileHash	Ljava/lang/String;
    //   211: invokevirtual 188	java/lang/String:length	()I
    //   214: invokevirtual 184	java/io/DataOutputStream:writeInt	(I)V
    //   217: aload_3
    //   218: astore 4
    //   220: aload_2
    //   221: astore 5
    //   223: aload_3
    //   224: aload_0
    //   225: getfield 67	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg:fileItem	[Lcom/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem;
    //   228: iload_1
    //   229: aaload
    //   230: getfield 81	com/tencent/qqprotect/singleupdate/QPSupportUpdCfg$QPUpdFileItem:strFileHash	Ljava/lang/String;
    //   233: invokevirtual 192	java/lang/String:getBytes	()[B
    //   236: invokevirtual 195	java/io/DataOutputStream:write	([B)V
    //   239: iload_1
    //   240: iconst_1
    //   241: iadd
    //   242: istore_1
    //   243: goto -107 -> 136
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   251: goto -140 -> 111
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   259: goto -140 -> 119
    //   262: astore 4
    //   264: aconst_null
    //   265: astore_2
    //   266: aload 4
    //   268: invokevirtual 196	java/io/FileNotFoundException:printStackTrace	()V
    //   271: aload_3
    //   272: ifnull +7 -> 279
    //   275: aload_3
    //   276: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   279: aload_2
    //   280: ifnull -161 -> 119
    //   283: aload_2
    //   284: invokevirtual 186	java/io/DataOutputStream:close	()V
    //   287: goto -168 -> 119
    //   290: astore_2
    //   291: aload_2
    //   292: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   295: goto -176 -> 119
    //   298: astore_3
    //   299: aload_3
    //   300: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   303: goto -24 -> 279
    //   306: astore 6
    //   308: aconst_null
    //   309: astore_3
    //   310: aconst_null
    //   311: astore_2
    //   312: aload_3
    //   313: astore 4
    //   315: aload_2
    //   316: astore 5
    //   318: aload 6
    //   320: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   323: aload_2
    //   324: ifnull +7 -> 331
    //   327: aload_2
    //   328: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   331: aload_3
    //   332: ifnull -213 -> 119
    //   335: aload_3
    //   336: invokevirtual 186	java/io/DataOutputStream:close	()V
    //   339: goto -220 -> 119
    //   342: astore_2
    //   343: aload_2
    //   344: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   347: goto -228 -> 119
    //   350: astore_2
    //   351: aload_2
    //   352: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   355: goto -24 -> 331
    //   358: astore_3
    //   359: aconst_null
    //   360: astore 4
    //   362: aconst_null
    //   363: astore_2
    //   364: aload_2
    //   365: ifnull +7 -> 372
    //   368: aload_2
    //   369: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   372: aload 4
    //   374: ifnull +8 -> 382
    //   377: aload 4
    //   379: invokevirtual 186	java/io/DataOutputStream:close	()V
    //   382: aload_3
    //   383: athrow
    //   384: astore_2
    //   385: aload_2
    //   386: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   389: goto -17 -> 372
    //   392: astore_2
    //   393: aload_2
    //   394: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   397: goto -15 -> 382
    //   400: astore_3
    //   401: aconst_null
    //   402: astore 4
    //   404: goto -40 -> 364
    //   407: astore_3
    //   408: aload 5
    //   410: astore_2
    //   411: goto -47 -> 364
    //   414: astore 4
    //   416: aload_3
    //   417: astore 5
    //   419: aload 4
    //   421: astore_3
    //   422: aload_2
    //   423: astore 4
    //   425: aload 5
    //   427: astore_2
    //   428: goto -64 -> 364
    //   431: astore 6
    //   433: aconst_null
    //   434: astore_3
    //   435: goto -123 -> 312
    //   438: astore 6
    //   440: goto -128 -> 312
    //   443: astore 4
    //   445: aconst_null
    //   446: astore 5
    //   448: aload_2
    //   449: astore_3
    //   450: aload 5
    //   452: astore_2
    //   453: goto -187 -> 266
    //   456: astore 4
    //   458: aload_2
    //   459: astore 5
    //   461: aload_3
    //   462: astore_2
    //   463: aload 5
    //   465: astore_3
    //   466: goto -200 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	QPSupportUpdCfg
    //   3	240	1	i	int
    //   14	207	2	localObject1	Object
    //   246	2	2	localIOException1	IOException
    //   254	2	2	localIOException2	IOException
    //   265	19	2	localObject2	Object
    //   290	2	2	localIOException3	IOException
    //   311	17	2	localObject3	Object
    //   342	2	2	localIOException4	IOException
    //   350	2	2	localIOException5	IOException
    //   363	6	2	localObject4	Object
    //   384	2	2	localIOException6	IOException
    //   392	2	2	localIOException7	IOException
    //   410	53	2	localObject5	Object
    //   1	275	3	localDataOutputStream1	java.io.DataOutputStream
    //   298	2	3	localIOException8	IOException
    //   309	27	3	localObject6	Object
    //   358	25	3	localObject7	Object
    //   400	1	3	localObject8	Object
    //   407	10	3	localObject9	Object
    //   421	45	3	localObject10	Object
    //   52	167	4	localDataOutputStream2	java.io.DataOutputStream
    //   262	5	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   313	90	4	localObject11	Object
    //   414	6	4	localObject12	Object
    //   423	1	4	localObject13	Object
    //   443	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   456	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   55	409	5	localObject14	Object
    //   306	13	6	localIOException9	IOException
    //   431	1	6	localIOException10	IOException
    //   438	1	6	localIOException11	IOException
    // Exception table:
    //   from	to	target	type
    //   107	111	246	java/io/IOException
    //   115	119	254	java/io/IOException
    //   31	42	262	java/io/FileNotFoundException
    //   283	287	290	java/io/IOException
    //   275	279	298	java/io/IOException
    //   31	42	306	java/io/IOException
    //   335	339	342	java/io/IOException
    //   327	331	350	java/io/IOException
    //   31	42	358	finally
    //   368	372	384	java/io/IOException
    //   377	382	392	java/io/IOException
    //   42	51	400	finally
    //   57	65	407	finally
    //   71	79	407	finally
    //   85	92	407	finally
    //   98	103	407	finally
    //   127	136	407	finally
    //   142	151	407	finally
    //   157	173	407	finally
    //   179	195	407	finally
    //   201	217	407	finally
    //   223	239	407	finally
    //   318	323	407	finally
    //   266	271	414	finally
    //   42	51	431	java/io/IOException
    //   57	65	438	java/io/IOException
    //   71	79	438	java/io/IOException
    //   85	92	438	java/io/IOException
    //   98	103	438	java/io/IOException
    //   127	136	438	java/io/IOException
    //   142	151	438	java/io/IOException
    //   157	173	438	java/io/IOException
    //   179	195	438	java/io/IOException
    //   201	217	438	java/io/IOException
    //   223	239	438	java/io/IOException
    //   42	51	443	java/io/FileNotFoundException
    //   57	65	456	java/io/FileNotFoundException
    //   71	79	456	java/io/FileNotFoundException
    //   85	92	456	java/io/FileNotFoundException
    //   98	103	456	java/io/FileNotFoundException
    //   127	136	456	java/io/FileNotFoundException
    //   142	151	456	java/io/FileNotFoundException
    //   157	173	456	java/io/FileNotFoundException
    //   179	195	456	java/io/FileNotFoundException
    //   201	217	456	java/io/FileNotFoundException
    //   223	239	456	java/io/FileNotFoundException
  }
  
  public void addFileItem(String paramString1, File paramFile, String paramString2)
  {
    if (this.fileItem == null) {}
    for (int i = 1;; i = this.fileItem.length + 1)
    {
      QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = this.fileItem;
      this.fileItem = new QPSupportUpdCfg.QPUpdFileItem[i];
      int j = 0;
      while (j < i - 1)
      {
        this.fileItem[j] = arrayOfQPUpdFileItem[j];
        j += 1;
      }
    }
    this.fileItem[(i - 1)] = new QPSupportUpdCfg.QPUpdFileItem(this);
    this.fileItem[(i - 1)].strFilePath = paramString2;
    this.fileItem[(i - 1)].strFileHash = "00000000000000000000000000000000";
    if (a(paramFile))
    {
      paramString1 = bkcx.a(paramString1);
      if (paramString1 != null) {
        this.fileItem[(i - 1)].strFileHash = paramString1;
      }
    }
  }
  
  public boolean addFileItem(String paramString, File paramFile)
  {
    boolean bool = false;
    int k = 0;
    if (paramFile.exists()) {
      if (this.fileItem == null) {
        break label167;
      }
    }
    label167:
    for (int i = this.fileItem.length;; i = 0)
    {
      QPSupportUpdCfg.QPUpdFileItem[] arrayOfQPUpdFileItem = new QPSupportUpdCfg.QPUpdFileItem[i + 1];
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
        paramString = bkcx.a(paramString);
        if (paramString != null) {
          arrayOfQPUpdFileItem[i].strFileHash = paramString;
        }
      }
      arrayOfQPUpdFileItem[i].strFilePath = paramFile.getAbsolutePath();
      this.fileItem = arrayOfQPUpdFileItem;
      WriteConfigFile();
      bool = true;
      return bool;
    }
  }
  
  public String getFileDstPath(String paramString)
  {
    paramString = bkcy.a(paramString);
    if (this.fileItem == null) {}
    for (;;)
    {
      return null;
      int j = this.fileItem.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equalsIgnoreCase(bkcy.a(this.fileItem[i].strFilePath))) {
          return this.fileItem[i].strFilePath;
        }
        i += 1;
      }
    }
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
    paramString = bkcy.a(paramString);
    if (this.fileItem == null) {}
    for (;;)
    {
      return -1;
      int j = this.fileItem.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equalsIgnoreCase(bkcy.a(this.fileItem[i].strFilePath)))
        {
          paramString = this.fileItem[i].strFilePath;
          return i;
        }
        i += 1;
      }
    }
  }
  
  public int getFileItemCount()
  {
    if (this.fileItem == null) {
      return 0;
    }
    return this.fileItem.length;
  }
  
  public void updateCfgHash()
  {
    if (this.fileItem == null) {
      return;
    }
    int i = 0;
    label10:
    if (i < this.fileItem.length) {
      if (!bkcy.a(this.fileItem[i].strFilePath).equalsIgnoreCase("SupportUpd.cfg")) {
        break label46;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label46:
      Object localObject = new File(this.fileItem[i].strFilePath);
      this.fileItem[i].strFileHash = "00000000000000000000000000000000";
      if (a((File)localObject))
      {
        localObject = bkcx.a(this.fileItem[i].strFilePath);
        if (localObject != null) {
          this.fileItem[i].strFileHash = ((String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSupportUpdCfg
 * JD-Core Version:    0.7.0.1
 */