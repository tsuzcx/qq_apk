package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpDownload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpDownload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 3);
    this.b = true;
  }
  
  /* Error */
  private java.net.HttpURLConnection a(java.lang.String paramString1, long paramLong1, long paramLong2, java.lang.String paramString2, boolean paramBoolean, bake parambake)
  {
    // Byte code:
    //   0: new 28	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   7: lload_2
    //   8: invokevirtual 35	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11: ldc 37
    //   13: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 10
    //   21: new 28	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   28: aload_1
    //   29: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 46
    //   34: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: lload_2
    //   38: invokevirtual 35	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: ldc 48
    //   43: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore 9
    //   51: ldc 50
    //   53: iconst_1
    //   54: new 28	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   61: ldc 52
    //   63: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 9
    //   68: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 58	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   81: aload 9
    //   83: putfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   86: aload_0
    //   87: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   90: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   93: putfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   96: new 79	java/net/URL
    //   99: dup
    //   100: aload 9
    //   102: invokespecial 82	java/net/URL:<init>	(Ljava/lang/String;)V
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 86	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   110: checkcast 88	java/net/HttpURLConnection
    //   113: astore 6
    //   115: aload 6
    //   117: ifnonnull +30 -> 147
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_1
    //   123: areturn
    //   124: astore_1
    //   125: iload 7
    //   127: ifeq +18 -> 145
    //   130: aload_0
    //   131: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   134: aload_0
    //   135: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   138: bipush 10
    //   140: bipush 102
    //   142: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload 6
    //   149: sipush 30000
    //   152: invokevirtual 97	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   155: aload 6
    //   157: sipush 30000
    //   160: invokevirtual 100	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   163: aload 6
    //   165: ldc 102
    //   167: invokevirtual 105	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   170: aload 6
    //   172: ldc 107
    //   174: ldc 109
    //   176: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: lload 4
    //   181: lconst_0
    //   182: lcmp
    //   183: ifeq +30 -> 213
    //   186: aload 6
    //   188: ldc 115
    //   190: new 28	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   197: ldc 117
    //   199: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 10
    //   204: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 6
    //   215: ldc 119
    //   217: ldc 121
    //   219: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 8
    //   224: ifnull +13 -> 237
    //   227: aload 8
    //   229: aload 6
    //   231: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   234: putfield 130	bake:jdField_a_of_type_Int	I
    //   237: aload 6
    //   239: astore_1
    //   240: aload 6
    //   242: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   245: sipush 200
    //   248: if_icmpeq -126 -> 122
    //   251: aload 6
    //   253: astore_1
    //   254: aload 6
    //   256: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   259: sipush 206
    //   262: if_icmpeq -140 -> 122
    //   265: aload 6
    //   267: ldc 132
    //   269: invokevirtual 136	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   272: astore_1
    //   273: aload_1
    //   274: ifnull +14 -> 288
    //   277: aload 8
    //   279: ifnull +9 -> 288
    //   282: aload 8
    //   284: aload_1
    //   285: putfield 138	bake:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   288: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +41 -> 332
    //   294: ldc 50
    //   296: iconst_2
    //   297: new 28	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   304: ldc 144
    //   306: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 6
    //   311: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   314: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: ldc 149
    //   319: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aconst_null
    //   333: areturn
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   339: aconst_null
    //   340: areturn
    //   341: astore_1
    //   342: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +41 -> 386
    //   348: ldc 50
    //   350: iconst_2
    //   351: new 28	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   358: ldc 157
    //   360: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload 9
    //   365: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc 159
    //   370: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_1
    //   374: invokevirtual 162	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   377: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aconst_null
    //   387: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	TaskHttpDownload
    //   0	388	1	paramString1	java.lang.String
    //   0	388	2	paramLong1	long
    //   0	388	4	paramLong2	long
    //   0	388	6	paramString2	java.lang.String
    //   0	388	7	paramBoolean	boolean
    //   0	388	8	parambake	bake
    //   49	315	9	str1	java.lang.String
    //   19	184	10	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   96	106	124	java/net/MalformedURLException
    //   106	115	334	java/io/IOException
    //   147	179	334	java/io/IOException
    //   186	213	334	java/io/IOException
    //   213	222	334	java/io/IOException
    //   227	237	334	java/io/IOException
    //   240	251	334	java/io/IOException
    //   254	273	334	java/io/IOException
    //   282	288	334	java/io/IOException
    //   288	332	334	java/io/IOException
    //   106	115	341	java/lang/NullPointerException
    //   147	179	341	java/lang/NullPointerException
    //   186	213	341	java/lang/NullPointerException
    //   213	222	341	java/lang/NullPointerException
    //   227	237	341	java/lang/NullPointerException
    //   240	251	341	java/lang/NullPointerException
    //   254	273	341	java/lang/NullPointerException
    //   282	288	341	java/lang/NullPointerException
    //   288	332	341	java/lang/NullPointerException
  }
  
  /* Error */
  private java.net.HttpURLConnection a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, long paramLong1, long paramLong2, java.lang.String paramString4, java.lang.String paramString5, boolean paramBoolean, bake parambake)
  {
    // Byte code:
    //   0: new 28	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   7: lload 4
    //   9: invokevirtual 35	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12: ldc 37
    //   14: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload 6
    //   19: lconst_1
    //   20: lsub
    //   21: invokevirtual 35	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 12
    //   29: lload 4
    //   31: lconst_0
    //   32: lcmp
    //   33: ifne +117 -> 150
    //   36: new 28	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   43: ldc 167
    //   45: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 169
    //   54: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 171
    //   63: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokestatic 175	bbdm:b	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 9
    //   75: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_1
    //   82: ldc 50
    //   84: iconst_1
    //   85: new 28	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   92: ldc 177
    //   94: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 58	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_0
    //   108: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   111: aload_1
    //   112: putfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   115: aload_0
    //   116: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   119: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   122: putfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   125: new 79	java/net/URL
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 82	java/net/URL:<init>	(Ljava/lang/String;)V
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 86	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   138: checkcast 88	java/net/HttpURLConnection
    //   141: astore_3
    //   142: aload_3
    //   143: ifnonnull +89 -> 232
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: areturn
    //   150: new 28	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   157: ldc 167
    //   159: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 169
    //   168: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 171
    //   177: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokestatic 175	bbdm:b	(Ljava/lang/String;)Ljava/lang/String;
    //   184: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 179
    //   189: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 12
    //   194: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 9
    //   199: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore_1
    //   206: goto -124 -> 82
    //   209: astore_1
    //   210: iload 10
    //   212: ifeq +18 -> 230
    //   215: aload_0
    //   216: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   219: aload_0
    //   220: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   223: bipush 10
    //   225: bipush 102
    //   227: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   230: aconst_null
    //   231: areturn
    //   232: aload_3
    //   233: sipush 30000
    //   236: invokevirtual 97	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   239: aload_3
    //   240: sipush 30000
    //   243: invokevirtual 100	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   246: aload_3
    //   247: ldc 102
    //   249: invokevirtual 105	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   252: aload_3
    //   253: ldc 107
    //   255: ldc 181
    //   257: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: lload 6
    //   262: lconst_0
    //   263: lcmp
    //   264: ifeq +29 -> 293
    //   267: aload_3
    //   268: ldc 115
    //   270: new 28	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   277: ldc 117
    //   279: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 12
    //   284: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_3
    //   294: ldc 119
    //   296: ldc 121
    //   298: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_3
    //   302: ldc 183
    //   304: new 28	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   311: ldc 185
    //   313: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 8
    //   318: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokevirtual 113	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload 11
    //   329: ifnull +12 -> 341
    //   332: aload 11
    //   334: aload_3
    //   335: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   338: putfield 130	bake:jdField_a_of_type_Int	I
    //   341: aload_3
    //   342: astore_2
    //   343: aload_3
    //   344: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   347: sipush 200
    //   350: if_icmpeq -202 -> 148
    //   353: aload_3
    //   354: astore_2
    //   355: aload_3
    //   356: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   359: sipush 206
    //   362: if_icmpeq -214 -> 148
    //   365: aload_3
    //   366: ldc 132
    //   368: invokevirtual 136	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   371: astore_2
    //   372: aload_2
    //   373: ifnull +14 -> 387
    //   376: aload 11
    //   378: ifnull +9 -> 387
    //   381: aload 11
    //   383: aload_2
    //   384: putfield 138	bake:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   387: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +40 -> 430
    //   393: ldc 50
    //   395: iconst_2
    //   396: new 28	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   403: ldc 144
    //   405: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_3
    //   409: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   412: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: ldc 149
    //   417: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_2
    //   421: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: aconst_null
    //   431: areturn
    //   432: astore_2
    //   433: ldc 50
    //   435: iconst_1
    //   436: new 28	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   443: ldc 187
    //   445: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_1
    //   449: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: aload_2
    //   456: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: aconst_null
    //   460: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	TaskHttpDownload
    //   0	461	1	paramString1	java.lang.String
    //   0	461	2	paramString2	java.lang.String
    //   0	461	3	paramString3	java.lang.String
    //   0	461	4	paramLong1	long
    //   0	461	6	paramLong2	long
    //   0	461	8	paramString4	java.lang.String
    //   0	461	9	paramString5	java.lang.String
    //   0	461	10	paramBoolean	boolean
    //   0	461	11	parambake	bake
    //   27	256	12	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   125	134	209	java/net/MalformedURLException
    //   134	142	432	java/lang/Exception
    //   232	260	432	java/lang/Exception
    //   267	293	432	java/lang/Exception
    //   293	327	432	java/lang/Exception
    //   332	341	432	java/lang/Exception
    //   343	353	432	java/lang/Exception
    //   355	372	432	java/lang/Exception
    //   381	387	432	java/lang/Exception
    //   387	430	432	java/lang/Exception
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 204	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 50
    //   23: iconst_4
    //   24: ldc 206
    //   26: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: invokestatic 213	bdey:a	()Z
    //   32: ifne +29 -> 61
    //   35: aload_0
    //   36: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   39: aload_0
    //   40: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   43: bipush 10
    //   45: sipush 308
    //   48: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   51: getstatic 217	bami:b	I
    //   54: getstatic 220	bami:n	I
    //   57: invokestatic 225	bamh:b	(II)V
    //   60: return
    //   61: new 227	java/io/File
    //   64: dup
    //   65: getstatic 232	ajsf:bo	Ljava/lang/String;
    //   68: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 10
    //   73: aload 10
    //   75: invokevirtual 236	java/io/File:exists	()Z
    //   78: ifne +9 -> 87
    //   81: aload 10
    //   83: invokevirtual 239	java/io/File:mkdirs	()Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   91: new 28	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   98: getstatic 232	ajsf:bo	Ljava/lang/String;
    //   101: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   108: getfield 242	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   111: invokevirtual 248	java/lang/String:getBytes	()[B
    //   114: invokestatic 251	bbdm:a	([B)Ljava/lang/String;
    //   117: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 253
    //   122: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: putfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   131: new 227	java/io/File
    //   134: dup
    //   135: aload_0
    //   136: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   139: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   142: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore 13
    //   147: aload 13
    //   149: invokevirtual 236	java/io/File:exists	()Z
    //   152: ifne +9 -> 161
    //   155: aload 13
    //   157: invokevirtual 259	java/io/File:createNewFile	()Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   165: aload 13
    //   167: invokevirtual 262	java/io/File:length	()J
    //   170: putfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   173: aload_0
    //   174: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   177: iconst_0
    //   178: putfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   181: aload_0
    //   182: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   185: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   188: aload_0
    //   189: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   192: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   195: lcmp
    //   196: ifgt +15 -> 211
    //   199: aload_0
    //   200: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   203: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   206: lconst_0
    //   207: lcmp
    //   208: ifne +25 -> 233
    //   211: iconst_0
    //   212: istore_3
    //   213: iconst_0
    //   214: istore_1
    //   215: aload_0
    //   216: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   219: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   222: aload_0
    //   223: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   226: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   229: lcmp
    //   230: ifne +353 -> 583
    //   233: aload_0
    //   234: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   237: getfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   240: invokevirtual 276	java/lang/String:length	()I
    //   243: bipush 85
    //   245: if_icmple +62 -> 307
    //   248: aload_0
    //   249: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   252: getfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   255: bipush 46
    //   257: invokevirtual 280	java/lang/String:lastIndexOf	(I)I
    //   260: istore_2
    //   261: iload_2
    //   262: istore_1
    //   263: iload_2
    //   264: ifge +5 -> 269
    //   267: iconst_0
    //   268: istore_1
    //   269: aload_0
    //   270: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   273: getfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   276: invokevirtual 276	java/lang/String:length	()I
    //   279: bipush 85
    //   281: isub
    //   282: istore_2
    //   283: iload_1
    //   284: ifne +1724 -> 2008
    //   287: aload_0
    //   288: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   291: aload_0
    //   292: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   295: getfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   298: iconst_0
    //   299: bipush 85
    //   301: invokevirtual 284	java/lang/String:substring	(II)Ljava/lang/String;
    //   304: putfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   307: aload_0
    //   308: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   311: getfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   314: astore 11
    //   316: aload 11
    //   318: astore 10
    //   320: aload_0
    //   321: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   324: getfield 287	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   327: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   330: ifne +27 -> 357
    //   333: aload 11
    //   335: astore 10
    //   337: aload_0
    //   338: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   341: getfield 296	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
    //   344: iconst_2
    //   345: if_icmpne +12 -> 357
    //   348: aload_0
    //   349: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   352: getfield 287	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   355: astore 10
    //   357: iconst_0
    //   358: istore_1
    //   359: iload_1
    //   360: sipush 1000
    //   363: if_icmpge +1738 -> 2101
    //   366: iload_1
    //   367: ifle +1701 -> 2068
    //   370: aload 10
    //   372: bipush 46
    //   374: invokevirtual 280	java/lang/String:lastIndexOf	(I)I
    //   377: istore_3
    //   378: iload_3
    //   379: istore_2
    //   380: iload_3
    //   381: ifge +5 -> 386
    //   384: iconst_0
    //   385: istore_2
    //   386: new 28	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   393: getstatic 299	ajsf:bl	Ljava/lang/String;
    //   396: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 10
    //   401: iconst_0
    //   402: iload_2
    //   403: invokevirtual 284	java/lang/String:substring	(II)Ljava/lang/String;
    //   406: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 301
    //   412: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: iload_1
    //   416: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: ldc_w 303
    //   422: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 10
    //   427: iload_2
    //   428: invokevirtual 306	java/lang/String:substring	(I)Ljava/lang/String;
    //   431: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: astore 11
    //   439: new 227	java/io/File
    //   442: dup
    //   443: aload 11
    //   445: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   448: astore 12
    //   450: aload 12
    //   452: invokevirtual 236	java/io/File:exists	()Z
    //   455: ifne +1639 -> 2094
    //   458: aload 13
    //   460: aload 12
    //   462: invokevirtual 310	java/io/File:renameTo	(Ljava/io/File;)Z
    //   465: ifeq +1629 -> 2094
    //   468: aload_0
    //   469: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   472: aload 11
    //   474: putfield 313	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   477: aload_0
    //   478: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   481: aload_0
    //   482: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   485: bipush 11
    //   487: invokevirtual 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   490: aload_0
    //   491: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   494: getfield 320	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   497: invokestatic 251	bbdm:a	([B)Ljava/lang/String;
    //   500: astore 10
    //   502: aload_0
    //   503: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   506: getfield 323	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   509: invokestatic 251	bbdm:a	([B)Ljava/lang/String;
    //   512: astore 11
    //   514: aload_0
    //   515: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   518: aload_0
    //   519: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   522: aload_0
    //   523: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   526: getfield 325	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   529: invokevirtual 329	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lazqt;
    //   532: iconst_0
    //   533: aload 10
    //   535: aload 11
    //   537: aload_0
    //   538: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   541: getfield 332	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   544: invokevirtual 335	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lazqt;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   547: getstatic 336	bami:jdField_a_of_type_Int	I
    //   550: iconst_0
    //   551: invokestatic 225	bamh:b	(II)V
    //   554: return
    //   555: astore 10
    //   557: aload_0
    //   558: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   561: aload_0
    //   562: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   565: bipush 10
    //   567: sipush 303
    //   570: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   573: getstatic 217	bami:b	I
    //   576: getstatic 339	bami:h	I
    //   579: invokestatic 225	bamh:b	(II)V
    //   582: return
    //   583: iload_1
    //   584: iconst_3
    //   585: if_icmplt +77 -> 662
    //   588: aload_0
    //   589: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   592: aload_0
    //   593: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   596: bipush 10
    //   598: bipush 105
    //   600: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   603: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq +35 -> 641
    //   609: ldc 50
    //   611: iconst_2
    //   612: new 28	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   619: ldc_w 341
    //   622: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload_0
    //   626: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   629: getfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   632: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: iload_3
    //   642: ifne -628 -> 14
    //   645: getstatic 346	bami:d	I
    //   648: getstatic 349	bami:p	I
    //   651: aload_0
    //   652: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   655: getfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   658: invokestatic 352	bamh:b	(IILjava/lang/String;)V
    //   661: return
    //   662: iload_1
    //   663: ifle +118 -> 781
    //   666: invokestatic 358	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   669: invokestatic 364	bbev:g	(Landroid/content/Context;)Z
    //   672: ifne +28 -> 700
    //   675: aload_0
    //   676: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   679: aload_0
    //   680: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   683: bipush 10
    //   685: bipush 106
    //   687: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   690: getstatic 217	bami:b	I
    //   693: getstatic 367	bami:k	I
    //   696: invokestatic 225	bamh:b	(II)V
    //   699: return
    //   700: iconst_0
    //   701: istore_2
    //   702: iload_2
    //   703: iload_1
    //   704: bipush 100
    //   706: imul
    //   707: if_icmpge +74 -> 781
    //   710: ldc2_w 368
    //   713: invokestatic 375	java/lang/Thread:sleep	(J)V
    //   716: aload_0
    //   717: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   720: aload_0
    //   721: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   724: invokevirtual 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   727: ifne -713 -> 14
    //   730: invokestatic 358	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   733: invokestatic 364	bbev:g	(Landroid/content/Context;)Z
    //   736: ifne +38 -> 774
    //   739: aload_0
    //   740: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   743: aload_0
    //   744: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   747: bipush 10
    //   749: bipush 106
    //   751: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   754: getstatic 217	bami:b	I
    //   757: getstatic 367	bami:k	I
    //   760: invokestatic 225	bamh:b	(II)V
    //   763: return
    //   764: astore 10
    //   766: aload 10
    //   768: invokevirtual 376	java/lang/InterruptedException:printStackTrace	()V
    //   771: goto -55 -> 716
    //   774: iload_2
    //   775: iconst_1
    //   776: iadd
    //   777: istore_2
    //   778: goto -76 -> 702
    //   781: aload_0
    //   782: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   785: aload_0
    //   786: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   789: invokevirtual 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   792: ifne -778 -> 14
    //   795: iload_1
    //   796: iconst_1
    //   797: iadd
    //   798: istore_1
    //   799: aload_0
    //   800: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   803: iload_1
    //   804: putfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   807: aconst_null
    //   808: astore 12
    //   810: aconst_null
    //   811: astore 11
    //   813: new 127	bake
    //   816: dup
    //   817: aload_0
    //   818: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   821: invokespecial 379	bake:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   824: astore 14
    //   826: aload 12
    //   828: astore 10
    //   830: aload_0
    //   831: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   834: invokevirtual 382	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   837: ifnull +251 -> 1088
    //   840: aload 12
    //   842: astore 10
    //   844: aload_0
    //   845: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   848: getfield 385	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   851: ifne +237 -> 1088
    //   854: aload_0
    //   855: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   858: invokevirtual 382	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   861: iconst_5
    //   862: invokeinterface 391 2 0
    //   867: astore 15
    //   869: aload 12
    //   871: astore 10
    //   873: aload 15
    //   875: ifnull +213 -> 1088
    //   878: aload 12
    //   880: astore 10
    //   882: aload 15
    //   884: invokeinterface 395 1 0
    //   889: ifne +199 -> 1088
    //   892: aload 15
    //   894: invokeinterface 399 1 0
    //   899: astore 12
    //   901: aload 11
    //   903: astore 10
    //   905: aload 12
    //   907: invokeinterface 404 1 0
    //   912: ifeq +176 -> 1088
    //   915: aload 12
    //   917: invokeinterface 408 1 0
    //   922: checkcast 410	mqq/manager/ProxyIpManager$ProxyIp
    //   925: astore 10
    //   927: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +38 -> 968
    //   933: ldc 50
    //   935: iconst_2
    //   936: ldc_w 412
    //   939: iconst_2
    //   940: anewarray 414	java/lang/Object
    //   943: dup
    //   944: iconst_0
    //   945: aload 10
    //   947: getfield 417	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   950: aastore
    //   951: dup
    //   952: iconst_1
    //   953: aload 10
    //   955: getfield 420	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   958: invokestatic 426	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   961: aastore
    //   962: invokestatic 430	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   965: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   968: ldc_w 432
    //   971: iconst_2
    //   972: anewarray 414	java/lang/Object
    //   975: dup
    //   976: iconst_0
    //   977: aload_0
    //   978: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   981: getfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   984: aastore
    //   985: dup
    //   986: iconst_1
    //   987: bipush 80
    //   989: invokestatic 426	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   992: aastore
    //   993: invokestatic 430	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   996: astore 11
    //   998: aload_0
    //   999: aload 10
    //   1001: getfield 417	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   1004: aload_0
    //   1005: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1008: getfield 435	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1011: aload_0
    //   1012: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1015: getfield 242	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   1018: aload_0
    //   1019: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1022: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1025: aload_0
    //   1026: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1029: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1032: aload_0
    //   1033: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1036: getfield 438	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1039: aload 11
    //   1041: iconst_0
    //   1042: aload 14
    //   1044: invokespecial 440	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLbake;)Ljava/net/HttpURLConnection;
    //   1047: astore 11
    //   1049: aload 11
    //   1051: astore 10
    //   1053: aload 11
    //   1055: ifnull -150 -> 905
    //   1058: aload 11
    //   1060: astore 10
    //   1062: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1065: ifeq +23 -> 1088
    //   1068: ldc 50
    //   1070: iconst_2
    //   1071: ldc_w 442
    //   1074: iconst_0
    //   1075: anewarray 414	java/lang/Object
    //   1078: invokestatic 430	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1081: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1084: aload 11
    //   1086: astore 10
    //   1088: aload 10
    //   1090: astore 11
    //   1092: aload 10
    //   1094: ifnonnull +315 -> 1409
    //   1097: aload_0
    //   1098: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1101: getfield 385	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   1104: ifeq +218 -> 1322
    //   1107: aload_0
    //   1108: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1111: getfield 445	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   1114: ifnull +208 -> 1322
    //   1117: aload_0
    //   1118: aload_0
    //   1119: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1122: getfield 445	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   1125: aload_0
    //   1126: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1129: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1132: aload_0
    //   1133: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1136: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1139: aload_0
    //   1140: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1143: getfield 438	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1146: iconst_0
    //   1147: aload 14
    //   1149: invokespecial 447	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;JJLjava/lang/String;ZLbake;)Ljava/net/HttpURLConnection;
    //   1152: astore 10
    //   1154: aload 10
    //   1156: ifnonnull +223 -> 1379
    //   1159: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1162: ifeq +65 -> 1227
    //   1165: new 28	java/lang/StringBuilder
    //   1168: dup
    //   1169: ldc_w 449
    //   1172: invokespecial 450	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1175: astore 10
    //   1177: aload 10
    //   1179: iload_1
    //   1180: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1183: ldc_w 452
    //   1186: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: aload_0
    //   1190: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1193: getfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1196: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: ldc_w 454
    //   1202: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: aload_0
    //   1206: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1209: getfield 435	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1212: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: ldc 50
    //   1218: iconst_2
    //   1219: aload 10
    //   1221: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: iload_1
    //   1228: iconst_3
    //   1229: if_icmpne +942 -> 2171
    //   1232: getstatic 457	bami:z	I
    //   1235: istore_3
    //   1236: iload_3
    //   1237: istore_2
    //   1238: aload 14
    //   1240: getfield 130	bake:jdField_a_of_type_Int	I
    //   1243: sipush 200
    //   1246: if_icmpeq +22 -> 1268
    //   1249: iload_3
    //   1250: istore_2
    //   1251: aload 14
    //   1253: getfield 130	bake:jdField_a_of_type_Int	I
    //   1256: sipush 206
    //   1259: if_icmpeq +9 -> 1268
    //   1262: aload 14
    //   1264: getfield 130	bake:jdField_a_of_type_Int	I
    //   1267: istore_2
    //   1268: iload_2
    //   1269: istore_3
    //   1270: aload 14
    //   1272: getfield 138	bake:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1275: ifnull +28 -> 1303
    //   1278: iload_2
    //   1279: istore_3
    //   1280: aload 14
    //   1282: getfield 138	bake:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1285: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1288: ifne +15 -> 1303
    //   1291: aload 14
    //   1293: getfield 138	bake:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1296: invokestatic 460	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1299: invokevirtual 463	java/lang/Integer:intValue	()I
    //   1302: istore_3
    //   1303: getstatic 346	bami:d	I
    //   1306: iload_3
    //   1307: aload_0
    //   1308: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1311: getfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1314: invokestatic 352	bamh:b	(IILjava/lang/String;)V
    //   1317: iconst_1
    //   1318: istore_3
    //   1319: goto -1104 -> 215
    //   1322: aload_0
    //   1323: aload_0
    //   1324: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1327: getfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1330: aload_0
    //   1331: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1334: getfield 435	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1337: aload_0
    //   1338: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1341: getfield 242	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   1344: aload_0
    //   1345: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1348: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1351: aload_0
    //   1352: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1355: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1358: aload_0
    //   1359: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1362: getfield 438	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1365: ldc_w 465
    //   1368: iconst_1
    //   1369: aload 14
    //   1371: invokespecial 440	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLbake;)Ljava/net/HttpURLConnection;
    //   1374: astore 10
    //   1376: goto -222 -> 1154
    //   1379: aload 10
    //   1381: astore 11
    //   1383: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1386: ifeq +23 -> 1409
    //   1389: ldc 50
    //   1391: iconst_2
    //   1392: ldc_w 467
    //   1395: iconst_0
    //   1396: anewarray 414	java/lang/Object
    //   1399: invokestatic 430	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1402: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1405: aload 10
    //   1407: astore 11
    //   1409: iload_1
    //   1410: istore_2
    //   1411: new 469	java/io/BufferedInputStream
    //   1414: dup
    //   1415: aload 11
    //   1417: invokevirtual 473	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1420: invokespecial 476	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1423: astore 12
    //   1425: iload_1
    //   1426: istore_2
    //   1427: aload_0
    //   1428: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1431: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1434: lconst_0
    //   1435: lcmp
    //   1436: ifne +18 -> 1454
    //   1439: iload_1
    //   1440: istore_2
    //   1441: aload_0
    //   1442: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1445: aload 11
    //   1447: invokevirtual 479	java/net/HttpURLConnection:getContentLength	()I
    //   1450: i2l
    //   1451: putfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1454: iload_1
    //   1455: istore_2
    //   1456: new 481	java/io/FileOutputStream
    //   1459: dup
    //   1460: aload 13
    //   1462: iconst_1
    //   1463: invokespecial 484	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1466: astore 10
    //   1468: iload_1
    //   1469: istore_2
    //   1470: sipush 8192
    //   1473: newarray byte
    //   1475: astore 14
    //   1477: iload_1
    //   1478: istore_2
    //   1479: aload 12
    //   1481: aload 14
    //   1483: invokevirtual 490	java/io/InputStream:read	([B)I
    //   1486: istore 4
    //   1488: iload 4
    //   1490: iconst_m1
    //   1491: if_icmpeq +484 -> 1975
    //   1494: iload_1
    //   1495: istore_2
    //   1496: aload_0
    //   1497: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1500: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1503: iload 4
    //   1505: i2l
    //   1506: ladd
    //   1507: aload_0
    //   1508: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1511: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1514: lcmp
    //   1515: ifle +246 -> 1761
    //   1518: iload_1
    //   1519: istore_2
    //   1520: aload_0
    //   1521: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1524: aload_0
    //   1525: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1528: bipush 10
    //   1530: sipush 305
    //   1533: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1536: iload_1
    //   1537: istore_2
    //   1538: getstatic 217	bami:b	I
    //   1541: getstatic 493	bami:q	I
    //   1544: invokestatic 225	bamh:b	(II)V
    //   1547: aload 12
    //   1549: invokevirtual 496	java/io/InputStream:close	()V
    //   1552: aload 10
    //   1554: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   1557: return
    //   1558: astore 10
    //   1560: return
    //   1561: astore 10
    //   1563: iload_1
    //   1564: istore_2
    //   1565: aload_0
    //   1566: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1569: aload_0
    //   1570: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1573: bipush 10
    //   1575: sipush 304
    //   1578: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1581: iload_1
    //   1582: istore_2
    //   1583: getstatic 217	bami:b	I
    //   1586: getstatic 499	bami:g	I
    //   1589: invokestatic 225	bamh:b	(II)V
    //   1592: return
    //   1593: astore 10
    //   1595: invokestatic 204	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1598: ifeq +33 -> 1631
    //   1601: ldc 50
    //   1603: iconst_4
    //   1604: new 28	java/lang/StringBuilder
    //   1607: dup
    //   1608: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   1611: ldc_w 501
    //   1614: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: aload 10
    //   1619: invokevirtual 502	java/io/IOException:toString	()Ljava/lang/String;
    //   1622: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1628: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1631: aload 10
    //   1633: instanceof 504
    //   1636: ifeq +86 -> 1722
    //   1639: sipush 206
    //   1642: aload 11
    //   1644: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   1647: if_icmpne +75 -> 1722
    //   1650: aload_0
    //   1651: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1654: aload_0
    //   1655: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1658: bipush 10
    //   1660: bipush 105
    //   1662: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1665: getstatic 346	bami:d	I
    //   1668: aload 11
    //   1670: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   1673: aload_0
    //   1674: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1677: getfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1680: invokestatic 352	bamh:b	(IILjava/lang/String;)V
    //   1683: return
    //   1684: astore 11
    //   1686: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1689: ifeq +33 -> 1722
    //   1692: ldc 50
    //   1694: iconst_4
    //   1695: new 28	java/lang/StringBuilder
    //   1698: dup
    //   1699: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   1702: ldc_w 501
    //   1705: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: aload 10
    //   1710: invokevirtual 502	java/io/IOException:toString	()Ljava/lang/String;
    //   1713: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1719: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1722: iload_2
    //   1723: istore_1
    //   1724: invokestatic 204	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1727: ifeq -1512 -> 215
    //   1730: ldc 50
    //   1732: iconst_4
    //   1733: new 28	java/lang/StringBuilder
    //   1736: dup
    //   1737: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   1740: ldc_w 506
    //   1743: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: iload_2
    //   1747: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1750: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1753: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1756: iload_2
    //   1757: istore_1
    //   1758: goto -1543 -> 215
    //   1761: iload_1
    //   1762: istore_2
    //   1763: aload 10
    //   1765: aload 14
    //   1767: iconst_0
    //   1768: iload 4
    //   1770: invokevirtual 510	java/io/FileOutputStream:write	([BII)V
    //   1773: iload_1
    //   1774: istore_2
    //   1775: aload_0
    //   1776: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1779: astore 15
    //   1781: iload_1
    //   1782: istore_2
    //   1783: aload 15
    //   1785: aload 15
    //   1787: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1790: iload 4
    //   1792: i2l
    //   1793: ladd
    //   1794: putfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1797: iload_1
    //   1798: istore_2
    //   1799: aload_0
    //   1800: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1803: astore 15
    //   1805: iload_1
    //   1806: istore_2
    //   1807: aload 15
    //   1809: aload 15
    //   1811: getfield 513	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1814: iload 4
    //   1816: i2l
    //   1817: ladd
    //   1818: putfield 513	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1821: iload_1
    //   1822: istore_2
    //   1823: aload_0
    //   1824: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1827: iconst_1
    //   1828: iload 4
    //   1830: i2l
    //   1831: invokestatic 516	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
    //   1834: iload_1
    //   1835: istore_2
    //   1836: aload_0
    //   1837: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1840: aload_0
    //   1841: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1844: invokevirtual 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   1847: istore 5
    //   1849: iload 5
    //   1851: ifeq +62 -> 1913
    //   1854: aload 12
    //   1856: invokevirtual 496	java/io/InputStream:close	()V
    //   1859: aload 10
    //   1861: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   1864: return
    //   1865: astore 10
    //   1867: return
    //   1868: astore 14
    //   1870: iload_1
    //   1871: istore_2
    //   1872: aload_0
    //   1873: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1876: aload_0
    //   1877: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1880: bipush 10
    //   1882: sipush 306
    //   1885: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1888: iload_1
    //   1889: istore_2
    //   1890: getstatic 217	bami:b	I
    //   1893: getstatic 518	bami:i	I
    //   1896: invokestatic 225	bamh:b	(II)V
    //   1899: aload 12
    //   1901: invokevirtual 496	java/io/InputStream:close	()V
    //   1904: aload 10
    //   1906: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   1909: return
    //   1910: astore 10
    //   1912: return
    //   1913: iconst_0
    //   1914: istore 4
    //   1916: iconst_0
    //   1917: istore_1
    //   1918: iload 4
    //   1920: istore_2
    //   1921: aload_0
    //   1922: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1925: iconst_0
    //   1926: putfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   1929: iload 4
    //   1931: istore_2
    //   1932: aload_0
    //   1933: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1936: aload_0
    //   1937: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1940: invokevirtual 521	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1943: iload 4
    //   1945: istore_2
    //   1946: aload_0
    //   1947: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1950: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1953: lstore 6
    //   1955: iload 4
    //   1957: istore_2
    //   1958: aload_0
    //   1959: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1962: getfield 271	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1965: lstore 8
    //   1967: lload 6
    //   1969: lload 8
    //   1971: lcmp
    //   1972: ifne -495 -> 1477
    //   1975: aload 12
    //   1977: invokevirtual 496	java/io/InputStream:close	()V
    //   1980: aload 10
    //   1982: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   1985: goto -1752 -> 233
    //   1988: astore 10
    //   1990: goto -1757 -> 233
    //   1993: astore 14
    //   1995: aload 12
    //   1997: invokevirtual 496	java/io/InputStream:close	()V
    //   2000: aload 10
    //   2002: invokevirtual 497	java/io/FileOutputStream:close	()V
    //   2005: aload 14
    //   2007: athrow
    //   2008: iload_1
    //   2009: iload_2
    //   2010: if_icmple -1703 -> 307
    //   2013: new 28	java/lang/StringBuilder
    //   2016: dup
    //   2017: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   2020: aload_0
    //   2021: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2024: getfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   2027: iconst_0
    //   2028: iload_1
    //   2029: iload_2
    //   2030: isub
    //   2031: invokevirtual 284	java/lang/String:substring	(II)Ljava/lang/String;
    //   2034: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2037: aload_0
    //   2038: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2041: getfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   2044: iload_1
    //   2045: invokevirtual 306	java/lang/String:substring	(I)Ljava/lang/String;
    //   2048: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2054: astore 10
    //   2056: aload_0
    //   2057: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2060: aload 10
    //   2062: putfield 274	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   2065: goto -1758 -> 307
    //   2068: new 28	java/lang/StringBuilder
    //   2071: dup
    //   2072: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   2075: getstatic 299	ajsf:bl	Ljava/lang/String;
    //   2078: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2081: aload 10
    //   2083: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2089: astore 11
    //   2091: goto -1652 -> 439
    //   2094: iload_1
    //   2095: iconst_1
    //   2096: iadd
    //   2097: istore_1
    //   2098: goto -1739 -> 359
    //   2101: aload_0
    //   2102: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2105: aload_0
    //   2106: getfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2109: bipush 10
    //   2111: sipush 307
    //   2114: invokevirtual 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2117: getstatic 217	bami:b	I
    //   2120: getstatic 524	bami:o	I
    //   2123: invokestatic 225	bamh:b	(II)V
    //   2126: return
    //   2127: astore 11
    //   2129: goto -577 -> 1552
    //   2132: astore 11
    //   2134: goto -230 -> 1904
    //   2137: astore 11
    //   2139: goto -280 -> 1859
    //   2142: astore 11
    //   2144: goto -164 -> 1980
    //   2147: astore 12
    //   2149: goto -149 -> 2000
    //   2152: astore 10
    //   2154: goto -149 -> 2005
    //   2157: astore 10
    //   2159: iload_2
    //   2160: istore_3
    //   2161: goto -858 -> 1303
    //   2164: astore 10
    //   2166: iload_2
    //   2167: istore_3
    //   2168: goto -865 -> 1303
    //   2171: goto -1956 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2174	0	this	TaskHttpDownload
    //   214	1884	1	i	int
    //   260	1907	2	j	int
    //   212	1956	3	k	int
    //   1486	470	4	m	int
    //   1847	3	5	bool	boolean
    //   1953	15	6	l1	long
    //   1965	5	8	l2	long
    //   71	463	10	localObject1	java.lang.Object
    //   555	1	10	localIOException1	java.io.IOException
    //   764	3	10	localInterruptedException	java.lang.InterruptedException
    //   828	725	10	localObject2	java.lang.Object
    //   1558	1	10	localIOException2	java.io.IOException
    //   1561	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   1593	267	10	localIOException3	java.io.IOException
    //   1865	40	10	localIOException4	java.io.IOException
    //   1910	71	10	localIOException5	java.io.IOException
    //   1988	13	10	localIOException6	java.io.IOException
    //   2054	28	10	str1	java.lang.String
    //   2152	1	10	localIOException7	java.io.IOException
    //   2157	1	10	localException	java.lang.Exception
    //   2164	1	10	localNumberFormatException	java.lang.NumberFormatException
    //   314	1355	11	localObject3	java.lang.Object
    //   1684	1	11	localIOException8	java.io.IOException
    //   2089	1	11	str2	java.lang.String
    //   2127	1	11	localIOException9	java.io.IOException
    //   2132	1	11	localIOException10	java.io.IOException
    //   2137	1	11	localIOException11	java.io.IOException
    //   2142	1	11	localIOException12	java.io.IOException
    //   448	1548	12	localObject4	java.lang.Object
    //   2147	1	12	localIOException13	java.io.IOException
    //   145	1316	13	localFile	java.io.File
    //   824	942	14	localObject5	java.lang.Object
    //   1868	1	14	localIOException14	java.io.IOException
    //   1993	13	14	localObject6	java.lang.Object
    //   867	943	15	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   155	161	555	java/io/IOException
    //   710	716	764	java/lang/InterruptedException
    //   1552	1557	1558	java/io/IOException
    //   1456	1468	1561	java/io/FileNotFoundException
    //   1411	1425	1593	java/io/IOException
    //   1427	1439	1593	java/io/IOException
    //   1441	1454	1593	java/io/IOException
    //   1456	1468	1593	java/io/IOException
    //   1565	1581	1593	java/io/IOException
    //   1583	1592	1593	java/io/IOException
    //   2005	2008	1593	java/io/IOException
    //   1631	1683	1684	java/io/IOException
    //   1859	1864	1865	java/io/IOException
    //   1763	1773	1868	java/io/IOException
    //   1904	1909	1910	java/io/IOException
    //   1980	1985	1988	java/io/IOException
    //   1470	1477	1993	finally
    //   1479	1488	1993	finally
    //   1496	1518	1993	finally
    //   1520	1536	1993	finally
    //   1538	1547	1993	finally
    //   1763	1773	1993	finally
    //   1775	1781	1993	finally
    //   1783	1797	1993	finally
    //   1799	1805	1993	finally
    //   1807	1821	1993	finally
    //   1823	1834	1993	finally
    //   1836	1849	1993	finally
    //   1872	1888	1993	finally
    //   1890	1899	1993	finally
    //   1921	1929	1993	finally
    //   1932	1943	1993	finally
    //   1946	1955	1993	finally
    //   1958	1967	1993	finally
    //   1547	1552	2127	java/io/IOException
    //   1899	1904	2132	java/io/IOException
    //   1854	1859	2137	java/io/IOException
    //   1975	1980	2142	java/io/IOException
    //   1995	2000	2147	java/io/IOException
    //   2000	2005	2152	java/io/IOException
    //   1270	1278	2157	java/lang/Exception
    //   1280	1303	2157	java/lang/Exception
    //   1270	1278	2164	java/lang/NumberFormatException
    //   1280	1303	2164	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */