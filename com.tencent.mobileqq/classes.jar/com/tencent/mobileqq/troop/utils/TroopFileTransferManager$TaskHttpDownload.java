package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpDownload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpDownload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 3);
    this.jdField_b_of_type_Boolean = true;
  }
  
  /* Error */
  private java.net.HttpURLConnection a(java.lang.String paramString1, long paramLong1, long paramLong2, java.lang.String paramString2, boolean paramBoolean, ajwx paramajwx)
  {
    // Byte code:
    //   0: new 27	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   7: lload_2
    //   8: invokevirtual 34	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11: ldc 36
    //   13: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 10
    //   21: new 27	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   28: aload_1
    //   29: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 45
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: lload_2
    //   38: invokevirtual 34	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: ldc 47
    //   43: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore 9
    //   51: ldc 49
    //   53: iconst_1
    //   54: new 27	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   61: ldc 51
    //   63: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 9
    //   68: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 57	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   81: aload 9
    //   83: putfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   86: aload_0
    //   87: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   90: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   93: putfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   96: new 78	java/net/URL
    //   99: dup
    //   100: aload 9
    //   102: invokespecial 81	java/net/URL:<init>	(Ljava/lang/String;)V
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   110: checkcast 87	java/net/HttpURLConnection
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
    //   131: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   134: aload_0
    //   135: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   138: bipush 10
    //   140: bipush 102
    //   142: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload 6
    //   149: sipush 30000
    //   152: invokevirtual 96	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   155: aload 6
    //   157: sipush 30000
    //   160: invokevirtual 99	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   163: aload 6
    //   165: ldc 101
    //   167: invokevirtual 104	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   170: aload 6
    //   172: ldc 106
    //   174: ldc 108
    //   176: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: lload 4
    //   181: lconst_0
    //   182: lcmp
    //   183: ifeq +30 -> 213
    //   186: aload 6
    //   188: ldc 114
    //   190: new 27	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   197: ldc 116
    //   199: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 10
    //   204: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 6
    //   215: ldc 118
    //   217: ldc 120
    //   219: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 8
    //   224: ifnull +13 -> 237
    //   227: aload 8
    //   229: aload 6
    //   231: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   234: putfield 129	ajwx:jdField_a_of_type_Int	I
    //   237: aload 6
    //   239: astore_1
    //   240: aload 6
    //   242: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   245: sipush 200
    //   248: if_icmpeq -126 -> 122
    //   251: aload 6
    //   253: astore_1
    //   254: aload 6
    //   256: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   259: sipush 206
    //   262: if_icmpeq -140 -> 122
    //   265: aload 6
    //   267: ldc 131
    //   269: invokevirtual 135	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   272: astore_1
    //   273: aload_1
    //   274: ifnull +14 -> 288
    //   277: aload 8
    //   279: ifnull +9 -> 288
    //   282: aload 8
    //   284: aload_1
    //   285: putfield 137	ajwx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   288: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +41 -> 332
    //   294: ldc 49
    //   296: iconst_2
    //   297: new 27	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   304: ldc 143
    //   306: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 6
    //   311: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   314: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: ldc 148
    //   319: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aconst_null
    //   333: areturn
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   339: aconst_null
    //   340: areturn
    //   341: astore_1
    //   342: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +41 -> 386
    //   348: ldc 49
    //   350: iconst_2
    //   351: new 27	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   358: ldc 156
    //   360: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload 9
    //   365: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc 158
    //   370: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_1
    //   374: invokevirtual 161	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   377: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	388	8	paramajwx	ajwx
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
  private java.net.HttpURLConnection a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, long paramLong1, long paramLong2, java.lang.String paramString4, java.lang.String paramString5, boolean paramBoolean, ajwx paramajwx)
  {
    // Byte code:
    //   0: new 27	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   7: lload 4
    //   9: invokevirtual 34	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12: ldc 36
    //   14: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload 6
    //   19: lconst_1
    //   20: lsub
    //   21: invokevirtual 34	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 12
    //   29: lload 4
    //   31: lconst_0
    //   32: lcmp
    //   33: ifne +117 -> 150
    //   36: new 27	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   43: ldc 166
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 168
    //   54: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 170
    //   63: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokestatic 174	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 9
    //   75: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_1
    //   82: ldc 49
    //   84: iconst_1
    //   85: new 27	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   92: ldc 176
    //   94: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 57	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_0
    //   108: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   111: aload_1
    //   112: putfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   115: aload_0
    //   116: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   119: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   122: putfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   125: new 78	java/net/URL
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 81	java/net/URL:<init>	(Ljava/lang/String;)V
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   138: checkcast 87	java/net/HttpURLConnection
    //   141: astore_3
    //   142: aload_3
    //   143: ifnonnull +89 -> 232
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: areturn
    //   150: new 27	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   157: ldc 166
    //   159: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 168
    //   168: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 170
    //   177: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: invokestatic 174	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   184: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 178
    //   189: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 12
    //   194: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 9
    //   199: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore_1
    //   206: goto -124 -> 82
    //   209: astore_1
    //   210: iload 10
    //   212: ifeq +18 -> 230
    //   215: aload_0
    //   216: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   219: aload_0
    //   220: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   223: bipush 10
    //   225: bipush 102
    //   227: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   230: aconst_null
    //   231: areturn
    //   232: aload_3
    //   233: sipush 30000
    //   236: invokevirtual 96	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   239: aload_3
    //   240: sipush 30000
    //   243: invokevirtual 99	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   246: aload_3
    //   247: ldc 101
    //   249: invokevirtual 104	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   252: aload_3
    //   253: ldc 106
    //   255: ldc 180
    //   257: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: lload 6
    //   262: lconst_0
    //   263: lcmp
    //   264: ifeq +29 -> 293
    //   267: aload_3
    //   268: ldc 114
    //   270: new 27	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   277: ldc 116
    //   279: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 12
    //   284: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_3
    //   294: ldc 118
    //   296: ldc 120
    //   298: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_3
    //   302: ldc 182
    //   304: new 27	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   311: ldc 184
    //   313: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 8
    //   318: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokevirtual 112	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload 11
    //   329: ifnull +12 -> 341
    //   332: aload 11
    //   334: aload_3
    //   335: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   338: putfield 129	ajwx:jdField_a_of_type_Int	I
    //   341: aload_3
    //   342: astore_2
    //   343: aload_3
    //   344: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   347: sipush 200
    //   350: if_icmpeq -202 -> 148
    //   353: aload_3
    //   354: astore_2
    //   355: aload_3
    //   356: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   359: sipush 206
    //   362: if_icmpeq -214 -> 148
    //   365: aload_3
    //   366: ldc 131
    //   368: invokevirtual 135	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   371: astore_2
    //   372: aload_2
    //   373: ifnull +14 -> 387
    //   376: aload 11
    //   378: ifnull +9 -> 387
    //   381: aload 11
    //   383: aload_2
    //   384: putfield 137	ajwx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   387: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +40 -> 430
    //   393: ldc 49
    //   395: iconst_2
    //   396: new 27	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   403: ldc 143
    //   405: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_3
    //   409: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   412: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: ldc 148
    //   417: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_2
    //   421: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: aconst_null
    //   431: areturn
    //   432: astore_2
    //   433: ldc 49
    //   435: iconst_1
    //   436: new 27	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   443: ldc 186
    //   445: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_1
    //   449: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: aload_2
    //   456: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   0	461	11	paramajwx	ajwx
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
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 203	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 49
    //   23: iconst_4
    //   24: ldc 205
    //   26: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: invokestatic 212	com/tencent/open/appcommon/Common:a	()Z
    //   32: ifne +29 -> 61
    //   35: aload_0
    //   36: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   39: aload_0
    //   40: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   43: bipush 10
    //   45: sipush 308
    //   48: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   51: getstatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   54: getstatic 219	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:n	I
    //   57: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   60: return
    //   61: new 226	java/io/File
    //   64: dup
    //   65: getstatic 231	com/tencent/mobileqq/app/AppConstants:bb	Ljava/lang/String;
    //   68: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 10
    //   73: aload 10
    //   75: invokevirtual 235	java/io/File:exists	()Z
    //   78: ifne +9 -> 87
    //   81: aload 10
    //   83: invokevirtual 238	java/io/File:mkdirs	()Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   91: new 27	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   98: getstatic 231	com/tencent/mobileqq/app/AppConstants:bb	Ljava/lang/String;
    //   101: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   108: getfield 241	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   111: invokevirtual 247	java/lang/String:getBytes	()[B
    //   114: invokestatic 250	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   117: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 252
    //   122: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: putfield 255	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   131: new 226	java/io/File
    //   134: dup
    //   135: aload_0
    //   136: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   139: getfield 255	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   142: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore 13
    //   147: aload 13
    //   149: invokevirtual 235	java/io/File:exists	()Z
    //   152: ifne +9 -> 161
    //   155: aload 13
    //   157: invokevirtual 258	java/io/File:createNewFile	()Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   165: aload 13
    //   167: invokevirtual 261	java/io/File:length	()J
    //   170: putfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   173: aload_0
    //   174: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   177: iconst_0
    //   178: putfield 267	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   181: aload_0
    //   182: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   185: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   188: aload_0
    //   189: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   192: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   195: lcmp
    //   196: ifgt +15 -> 211
    //   199: aload_0
    //   200: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   203: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   206: lconst_0
    //   207: lcmp
    //   208: ifne +25 -> 233
    //   211: iconst_0
    //   212: istore_3
    //   213: iconst_0
    //   214: istore_1
    //   215: aload_0
    //   216: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   219: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   222: aload_0
    //   223: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   226: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   229: lcmp
    //   230: ifne +318 -> 548
    //   233: aload_0
    //   234: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   237: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   240: invokevirtual 275	java/lang/String:length	()I
    //   243: bipush 85
    //   245: if_icmple +62 -> 307
    //   248: aload_0
    //   249: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   252: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   255: bipush 46
    //   257: invokevirtual 279	java/lang/String:lastIndexOf	(I)I
    //   260: istore_2
    //   261: iload_2
    //   262: istore_1
    //   263: iload_2
    //   264: ifge +5 -> 269
    //   267: iconst_0
    //   268: istore_1
    //   269: aload_0
    //   270: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   273: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   276: invokevirtual 275	java/lang/String:length	()I
    //   279: bipush 85
    //   281: isub
    //   282: istore_2
    //   283: iload_1
    //   284: ifne +1689 -> 1973
    //   287: aload_0
    //   288: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   291: aload_0
    //   292: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   295: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   298: iconst_0
    //   299: bipush 85
    //   301: invokevirtual 283	java/lang/String:substring	(II)Ljava/lang/String;
    //   304: putfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   307: aload_0
    //   308: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   311: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   314: astore 11
    //   316: aload 11
    //   318: astore 10
    //   320: aload_0
    //   321: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   324: getfield 286	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   327: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   330: ifne +27 -> 357
    //   333: aload 11
    //   335: astore 10
    //   337: aload_0
    //   338: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   341: getfield 295	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
    //   344: iconst_2
    //   345: if_icmpne +12 -> 357
    //   348: aload_0
    //   349: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   352: getfield 286	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   355: astore 10
    //   357: iconst_0
    //   358: istore_1
    //   359: iload_1
    //   360: sipush 1000
    //   363: if_icmpge +1703 -> 2066
    //   366: iload_1
    //   367: ifle +1666 -> 2033
    //   370: aload 10
    //   372: bipush 46
    //   374: invokevirtual 279	java/lang/String:lastIndexOf	(I)I
    //   377: istore_3
    //   378: iload_3
    //   379: istore_2
    //   380: iload_3
    //   381: ifge +5 -> 386
    //   384: iconst_0
    //   385: istore_2
    //   386: new 27	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   393: getstatic 298	com/tencent/mobileqq/app/AppConstants:aY	Ljava/lang/String;
    //   396: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 10
    //   401: iconst_0
    //   402: iload_2
    //   403: invokevirtual 283	java/lang/String:substring	(II)Ljava/lang/String;
    //   406: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 300
    //   412: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: iload_1
    //   416: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: ldc_w 302
    //   422: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 10
    //   427: iload_2
    //   428: invokevirtual 305	java/lang/String:substring	(I)Ljava/lang/String;
    //   431: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: astore 11
    //   439: new 226	java/io/File
    //   442: dup
    //   443: aload 11
    //   445: invokespecial 232	java/io/File:<init>	(Ljava/lang/String;)V
    //   448: astore 12
    //   450: aload 12
    //   452: invokevirtual 235	java/io/File:exists	()Z
    //   455: ifne +1604 -> 2059
    //   458: aload 13
    //   460: aload 12
    //   462: invokevirtual 309	java/io/File:renameTo	(Ljava/io/File;)Z
    //   465: ifeq +1594 -> 2059
    //   468: aload_0
    //   469: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   472: aload 11
    //   474: putfield 312	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   477: aload_0
    //   478: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   481: aload_0
    //   482: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   485: bipush 11
    //   487: invokevirtual 315	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   490: aload_0
    //   491: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   494: aload_0
    //   495: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   498: aload_0
    //   499: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   502: getfield 317	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   505: invokevirtual 321	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   508: iconst_0
    //   509: invokevirtual 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   512: getstatic 325	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:jdField_a_of_type_Int	I
    //   515: iconst_0
    //   516: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   519: return
    //   520: astore 10
    //   522: aload_0
    //   523: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   526: aload_0
    //   527: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   530: bipush 10
    //   532: sipush 303
    //   535: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   538: getstatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   541: getstatic 328	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:h	I
    //   544: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   547: return
    //   548: iload_1
    //   549: iconst_3
    //   550: if_icmplt +77 -> 627
    //   553: aload_0
    //   554: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   557: aload_0
    //   558: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   561: bipush 10
    //   563: bipush 105
    //   565: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   568: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +35 -> 606
    //   574: ldc 49
    //   576: iconst_2
    //   577: new 27	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 330
    //   587: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_0
    //   591: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   594: getfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   597: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: iload_3
    //   607: ifne -593 -> 14
    //   610: getstatic 335	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   613: getstatic 338	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:p	I
    //   616: aload_0
    //   617: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   620: getfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   623: invokestatic 341	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   626: return
    //   627: iload_1
    //   628: ifle +118 -> 746
    //   631: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   634: invokestatic 353	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   637: ifne +28 -> 665
    //   640: aload_0
    //   641: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   644: aload_0
    //   645: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   648: bipush 10
    //   650: bipush 106
    //   652: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   655: getstatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   658: getstatic 356	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   661: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   664: return
    //   665: iconst_0
    //   666: istore_2
    //   667: iload_2
    //   668: iload_1
    //   669: bipush 100
    //   671: imul
    //   672: if_icmpge +74 -> 746
    //   675: ldc2_w 357
    //   678: invokestatic 364	java/lang/Thread:sleep	(J)V
    //   681: aload_0
    //   682: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   685: aload_0
    //   686: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   689: invokevirtual 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   692: ifne -678 -> 14
    //   695: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   698: invokestatic 353	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   701: ifne +38 -> 739
    //   704: aload_0
    //   705: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   708: aload_0
    //   709: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   712: bipush 10
    //   714: bipush 106
    //   716: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   719: getstatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   722: getstatic 356	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   725: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   728: return
    //   729: astore 10
    //   731: aload 10
    //   733: invokevirtual 365	java/lang/InterruptedException:printStackTrace	()V
    //   736: goto -55 -> 681
    //   739: iload_2
    //   740: iconst_1
    //   741: iadd
    //   742: istore_2
    //   743: goto -76 -> 667
    //   746: aload_0
    //   747: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   750: aload_0
    //   751: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   754: invokevirtual 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   757: ifne -743 -> 14
    //   760: iload_1
    //   761: iconst_1
    //   762: iadd
    //   763: istore_1
    //   764: aload_0
    //   765: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   768: iload_1
    //   769: putfield 267	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   772: aconst_null
    //   773: astore 12
    //   775: aconst_null
    //   776: astore 11
    //   778: new 126	ajwx
    //   781: dup
    //   782: aload_0
    //   783: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   786: invokespecial 368	ajwx:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   789: astore 14
    //   791: aload 12
    //   793: astore 10
    //   795: aload_0
    //   796: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   799: invokevirtual 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   802: ifnull +251 -> 1053
    //   805: aload 12
    //   807: astore 10
    //   809: aload_0
    //   810: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   813: getfield 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   816: ifne +237 -> 1053
    //   819: aload_0
    //   820: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   823: invokevirtual 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   826: iconst_5
    //   827: invokeinterface 380 2 0
    //   832: astore 15
    //   834: aload 12
    //   836: astore 10
    //   838: aload 15
    //   840: ifnull +213 -> 1053
    //   843: aload 12
    //   845: astore 10
    //   847: aload 15
    //   849: invokeinterface 384 1 0
    //   854: ifne +199 -> 1053
    //   857: aload 15
    //   859: invokeinterface 388 1 0
    //   864: astore 12
    //   866: aload 11
    //   868: astore 10
    //   870: aload 12
    //   872: invokeinterface 393 1 0
    //   877: ifeq +176 -> 1053
    //   880: aload 12
    //   882: invokeinterface 397 1 0
    //   887: checkcast 399	mqq/manager/ProxyIpManager$ProxyIp
    //   890: astore 10
    //   892: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   895: ifeq +38 -> 933
    //   898: ldc 49
    //   900: iconst_2
    //   901: ldc_w 401
    //   904: iconst_2
    //   905: anewarray 403	java/lang/Object
    //   908: dup
    //   909: iconst_0
    //   910: aload 10
    //   912: getfield 406	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   915: aastore
    //   916: dup
    //   917: iconst_1
    //   918: aload 10
    //   920: getfield 409	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   923: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   926: aastore
    //   927: invokestatic 419	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   930: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   933: ldc_w 421
    //   936: iconst_2
    //   937: anewarray 403	java/lang/Object
    //   940: dup
    //   941: iconst_0
    //   942: aload_0
    //   943: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   946: getfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   949: aastore
    //   950: dup
    //   951: iconst_1
    //   952: bipush 80
    //   954: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   957: aastore
    //   958: invokestatic 419	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   961: astore 11
    //   963: aload_0
    //   964: aload 10
    //   966: getfield 406	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   969: aload_0
    //   970: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   973: getfield 424	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   976: aload_0
    //   977: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   980: getfield 241	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   983: aload_0
    //   984: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   987: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   990: aload_0
    //   991: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   994: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   997: aload_0
    //   998: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1001: getfield 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1004: aload 11
    //   1006: iconst_0
    //   1007: aload 14
    //   1009: invokespecial 429	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLajwx;)Ljava/net/HttpURLConnection;
    //   1012: astore 11
    //   1014: aload 11
    //   1016: astore 10
    //   1018: aload 11
    //   1020: ifnull -150 -> 870
    //   1023: aload 11
    //   1025: astore 10
    //   1027: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1030: ifeq +23 -> 1053
    //   1033: ldc 49
    //   1035: iconst_2
    //   1036: ldc_w 431
    //   1039: iconst_0
    //   1040: anewarray 403	java/lang/Object
    //   1043: invokestatic 419	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1046: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1049: aload 11
    //   1051: astore 10
    //   1053: aload 10
    //   1055: astore 11
    //   1057: aload 10
    //   1059: ifnonnull +315 -> 1374
    //   1062: aload_0
    //   1063: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1066: getfield 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   1069: ifeq +218 -> 1287
    //   1072: aload_0
    //   1073: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1076: getfield 434	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   1079: ifnull +208 -> 1287
    //   1082: aload_0
    //   1083: aload_0
    //   1084: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1087: getfield 434	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   1090: aload_0
    //   1091: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1094: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1097: aload_0
    //   1098: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1101: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1104: aload_0
    //   1105: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1108: getfield 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1111: iconst_0
    //   1112: aload 14
    //   1114: invokespecial 436	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;JJLjava/lang/String;ZLajwx;)Ljava/net/HttpURLConnection;
    //   1117: astore 10
    //   1119: aload 10
    //   1121: ifnonnull +223 -> 1344
    //   1124: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1127: ifeq +65 -> 1192
    //   1130: new 27	java/lang/StringBuilder
    //   1133: dup
    //   1134: ldc_w 438
    //   1137: invokespecial 439	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1140: astore 10
    //   1142: aload 10
    //   1144: iload_1
    //   1145: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1148: ldc_w 441
    //   1151: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload_0
    //   1155: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1158: getfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1161: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: ldc_w 443
    //   1167: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: aload_0
    //   1171: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1174: getfield 424	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1177: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: ldc 49
    //   1183: iconst_2
    //   1184: aload 10
    //   1186: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1192: iload_1
    //   1193: iconst_3
    //   1194: if_icmpne +942 -> 2136
    //   1197: getstatic 446	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:y	I
    //   1200: istore_3
    //   1201: iload_3
    //   1202: istore_2
    //   1203: aload 14
    //   1205: getfield 129	ajwx:jdField_a_of_type_Int	I
    //   1208: sipush 200
    //   1211: if_icmpeq +22 -> 1233
    //   1214: iload_3
    //   1215: istore_2
    //   1216: aload 14
    //   1218: getfield 129	ajwx:jdField_a_of_type_Int	I
    //   1221: sipush 206
    //   1224: if_icmpeq +9 -> 1233
    //   1227: aload 14
    //   1229: getfield 129	ajwx:jdField_a_of_type_Int	I
    //   1232: istore_2
    //   1233: iload_2
    //   1234: istore_3
    //   1235: aload 14
    //   1237: getfield 137	ajwx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1240: ifnull +28 -> 1268
    //   1243: iload_2
    //   1244: istore_3
    //   1245: aload 14
    //   1247: getfield 137	ajwx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1250: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1253: ifne +15 -> 1268
    //   1256: aload 14
    //   1258: getfield 137	ajwx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1261: invokestatic 449	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1264: invokevirtual 452	java/lang/Integer:intValue	()I
    //   1267: istore_3
    //   1268: getstatic 335	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   1271: iload_3
    //   1272: aload_0
    //   1273: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1276: getfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1279: invokestatic 341	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   1282: iconst_1
    //   1283: istore_3
    //   1284: goto -1069 -> 215
    //   1287: aload_0
    //   1288: aload_0
    //   1289: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1292: getfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1295: aload_0
    //   1296: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1299: getfield 424	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1302: aload_0
    //   1303: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1306: getfield 241	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   1309: aload_0
    //   1310: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1313: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1316: aload_0
    //   1317: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1320: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1323: aload_0
    //   1324: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1327: getfield 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1330: ldc_w 454
    //   1333: iconst_1
    //   1334: aload 14
    //   1336: invokespecial 429	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLajwx;)Ljava/net/HttpURLConnection;
    //   1339: astore 10
    //   1341: goto -222 -> 1119
    //   1344: aload 10
    //   1346: astore 11
    //   1348: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1351: ifeq +23 -> 1374
    //   1354: ldc 49
    //   1356: iconst_2
    //   1357: ldc_w 456
    //   1360: iconst_0
    //   1361: anewarray 403	java/lang/Object
    //   1364: invokestatic 419	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1367: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1370: aload 10
    //   1372: astore 11
    //   1374: iload_1
    //   1375: istore_2
    //   1376: new 458	java/io/BufferedInputStream
    //   1379: dup
    //   1380: aload 11
    //   1382: invokevirtual 462	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1385: invokespecial 465	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1388: astore 12
    //   1390: iload_1
    //   1391: istore_2
    //   1392: aload_0
    //   1393: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1396: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1399: lconst_0
    //   1400: lcmp
    //   1401: ifne +18 -> 1419
    //   1404: iload_1
    //   1405: istore_2
    //   1406: aload_0
    //   1407: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1410: aload 11
    //   1412: invokevirtual 468	java/net/HttpURLConnection:getContentLength	()I
    //   1415: i2l
    //   1416: putfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1419: iload_1
    //   1420: istore_2
    //   1421: new 470	java/io/FileOutputStream
    //   1424: dup
    //   1425: aload 13
    //   1427: iconst_1
    //   1428: invokespecial 473	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1431: astore 10
    //   1433: iload_1
    //   1434: istore_2
    //   1435: sipush 8192
    //   1438: newarray byte
    //   1440: astore 14
    //   1442: iload_1
    //   1443: istore_2
    //   1444: aload 12
    //   1446: aload 14
    //   1448: invokevirtual 479	java/io/InputStream:read	([B)I
    //   1451: istore 4
    //   1453: iload 4
    //   1455: iconst_m1
    //   1456: if_icmpeq +484 -> 1940
    //   1459: iload_1
    //   1460: istore_2
    //   1461: aload_0
    //   1462: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1465: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1468: iload 4
    //   1470: i2l
    //   1471: ladd
    //   1472: aload_0
    //   1473: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1476: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1479: lcmp
    //   1480: ifle +246 -> 1726
    //   1483: iload_1
    //   1484: istore_2
    //   1485: aload_0
    //   1486: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1489: aload_0
    //   1490: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1493: bipush 10
    //   1495: sipush 305
    //   1498: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1501: iload_1
    //   1502: istore_2
    //   1503: getstatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1506: getstatic 482	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:q	I
    //   1509: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   1512: aload 12
    //   1514: invokevirtual 485	java/io/InputStream:close	()V
    //   1517: aload 10
    //   1519: invokevirtual 486	java/io/FileOutputStream:close	()V
    //   1522: return
    //   1523: astore 10
    //   1525: return
    //   1526: astore 10
    //   1528: iload_1
    //   1529: istore_2
    //   1530: aload_0
    //   1531: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1534: aload_0
    //   1535: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1538: bipush 10
    //   1540: sipush 304
    //   1543: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1546: iload_1
    //   1547: istore_2
    //   1548: getstatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1551: getstatic 488	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   1554: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   1557: return
    //   1558: astore 10
    //   1560: invokestatic 203	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1563: ifeq +33 -> 1596
    //   1566: ldc 49
    //   1568: iconst_4
    //   1569: new 27	java/lang/StringBuilder
    //   1572: dup
    //   1573: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1576: ldc_w 490
    //   1579: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: aload 10
    //   1584: invokevirtual 491	java/io/IOException:toString	()Ljava/lang/String;
    //   1587: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1593: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1596: aload 10
    //   1598: instanceof 493
    //   1601: ifeq +86 -> 1687
    //   1604: sipush 206
    //   1607: aload 11
    //   1609: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   1612: if_icmpne +75 -> 1687
    //   1615: aload_0
    //   1616: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1619: aload_0
    //   1620: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1623: bipush 10
    //   1625: bipush 105
    //   1627: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1630: getstatic 335	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   1633: aload 11
    //   1635: invokevirtual 124	java/net/HttpURLConnection:getResponseCode	()I
    //   1638: aload_0
    //   1639: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1642: getfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1645: invokestatic 341	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   1648: return
    //   1649: astore 11
    //   1651: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1654: ifeq +33 -> 1687
    //   1657: ldc 49
    //   1659: iconst_4
    //   1660: new 27	java/lang/StringBuilder
    //   1663: dup
    //   1664: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1667: ldc_w 490
    //   1670: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: aload 10
    //   1675: invokevirtual 491	java/io/IOException:toString	()Ljava/lang/String;
    //   1678: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1684: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1687: iload_2
    //   1688: istore_1
    //   1689: invokestatic 203	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1692: ifeq -1477 -> 215
    //   1695: ldc 49
    //   1697: iconst_4
    //   1698: new 27	java/lang/StringBuilder
    //   1701: dup
    //   1702: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1705: ldc_w 495
    //   1708: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: iload_2
    //   1712: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1718: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1721: iload_2
    //   1722: istore_1
    //   1723: goto -1508 -> 215
    //   1726: iload_1
    //   1727: istore_2
    //   1728: aload 10
    //   1730: aload 14
    //   1732: iconst_0
    //   1733: iload 4
    //   1735: invokevirtual 499	java/io/FileOutputStream:write	([BII)V
    //   1738: iload_1
    //   1739: istore_2
    //   1740: aload_0
    //   1741: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1744: astore 15
    //   1746: iload_1
    //   1747: istore_2
    //   1748: aload 15
    //   1750: aload 15
    //   1752: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1755: iload 4
    //   1757: i2l
    //   1758: ladd
    //   1759: putfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1762: iload_1
    //   1763: istore_2
    //   1764: aload_0
    //   1765: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1768: astore 15
    //   1770: iload_1
    //   1771: istore_2
    //   1772: aload 15
    //   1774: aload 15
    //   1776: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1779: iload 4
    //   1781: i2l
    //   1782: ladd
    //   1783: putfield 502	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1786: iload_1
    //   1787: istore_2
    //   1788: aload_0
    //   1789: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1792: iconst_1
    //   1793: iload 4
    //   1795: i2l
    //   1796: invokestatic 505	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
    //   1799: iload_1
    //   1800: istore_2
    //   1801: aload_0
    //   1802: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1805: aload_0
    //   1806: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1809: invokevirtual 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   1812: istore 5
    //   1814: iload 5
    //   1816: ifeq +62 -> 1878
    //   1819: aload 12
    //   1821: invokevirtual 485	java/io/InputStream:close	()V
    //   1824: aload 10
    //   1826: invokevirtual 486	java/io/FileOutputStream:close	()V
    //   1829: return
    //   1830: astore 10
    //   1832: return
    //   1833: astore 14
    //   1835: iload_1
    //   1836: istore_2
    //   1837: aload_0
    //   1838: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1841: aload_0
    //   1842: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1845: bipush 10
    //   1847: sipush 306
    //   1850: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1853: iload_1
    //   1854: istore_2
    //   1855: getstatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1858: getstatic 507	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:i	I
    //   1861: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   1864: aload 12
    //   1866: invokevirtual 485	java/io/InputStream:close	()V
    //   1869: aload 10
    //   1871: invokevirtual 486	java/io/FileOutputStream:close	()V
    //   1874: return
    //   1875: astore 10
    //   1877: return
    //   1878: iconst_0
    //   1879: istore 4
    //   1881: iconst_0
    //   1882: istore_1
    //   1883: iload 4
    //   1885: istore_2
    //   1886: aload_0
    //   1887: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1890: iconst_0
    //   1891: putfield 267	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   1894: iload 4
    //   1896: istore_2
    //   1897: aload_0
    //   1898: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1901: aload_0
    //   1902: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1905: invokevirtual 510	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1908: iload 4
    //   1910: istore_2
    //   1911: aload_0
    //   1912: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1915: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1918: lstore 6
    //   1920: iload 4
    //   1922: istore_2
    //   1923: aload_0
    //   1924: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1927: getfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1930: lstore 8
    //   1932: lload 6
    //   1934: lload 8
    //   1936: lcmp
    //   1937: ifne -495 -> 1442
    //   1940: aload 12
    //   1942: invokevirtual 485	java/io/InputStream:close	()V
    //   1945: aload 10
    //   1947: invokevirtual 486	java/io/FileOutputStream:close	()V
    //   1950: goto -1717 -> 233
    //   1953: astore 10
    //   1955: goto -1722 -> 233
    //   1958: astore 14
    //   1960: aload 12
    //   1962: invokevirtual 485	java/io/InputStream:close	()V
    //   1965: aload 10
    //   1967: invokevirtual 486	java/io/FileOutputStream:close	()V
    //   1970: aload 14
    //   1972: athrow
    //   1973: iload_1
    //   1974: iload_2
    //   1975: if_icmple -1668 -> 307
    //   1978: new 27	java/lang/StringBuilder
    //   1981: dup
    //   1982: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1985: aload_0
    //   1986: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1989: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1992: iconst_0
    //   1993: iload_1
    //   1994: iload_2
    //   1995: isub
    //   1996: invokevirtual 283	java/lang/String:substring	(II)Ljava/lang/String;
    //   1999: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2002: aload_0
    //   2003: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2006: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   2009: iload_1
    //   2010: invokevirtual 305	java/lang/String:substring	(I)Ljava/lang/String;
    //   2013: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2019: astore 10
    //   2021: aload_0
    //   2022: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2025: aload 10
    //   2027: putfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   2030: goto -1723 -> 307
    //   2033: new 27	java/lang/StringBuilder
    //   2036: dup
    //   2037: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2040: getstatic 298	com/tencent/mobileqq/app/AppConstants:aY	Ljava/lang/String;
    //   2043: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2046: aload 10
    //   2048: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2054: astore 11
    //   2056: goto -1617 -> 439
    //   2059: iload_1
    //   2060: iconst_1
    //   2061: iadd
    //   2062: istore_1
    //   2063: goto -1704 -> 359
    //   2066: aload_0
    //   2067: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   2070: aload_0
    //   2071: getfield 60	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2074: bipush 10
    //   2076: sipush 307
    //   2079: invokevirtual 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2082: getstatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   2085: getstatic 513	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:o	I
    //   2088: invokestatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   2091: return
    //   2092: astore 11
    //   2094: goto -577 -> 1517
    //   2097: astore 11
    //   2099: goto -230 -> 1869
    //   2102: astore 11
    //   2104: goto -280 -> 1824
    //   2107: astore 11
    //   2109: goto -164 -> 1945
    //   2112: astore 12
    //   2114: goto -149 -> 1965
    //   2117: astore 10
    //   2119: goto -149 -> 1970
    //   2122: astore 10
    //   2124: iload_2
    //   2125: istore_3
    //   2126: goto -858 -> 1268
    //   2129: astore 10
    //   2131: iload_2
    //   2132: istore_3
    //   2133: goto -865 -> 1268
    //   2136: goto -1921 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2139	0	this	TaskHttpDownload
    //   214	1849	1	i	int
    //   260	1872	2	j	int
    //   212	1921	3	k	int
    //   1451	470	4	m	int
    //   1812	3	5	bool	boolean
    //   1918	15	6	l1	long
    //   1930	5	8	l2	long
    //   71	355	10	localObject1	java.lang.Object
    //   520	1	10	localIOException1	java.io.IOException
    //   729	3	10	localInterruptedException	java.lang.InterruptedException
    //   793	725	10	localObject2	java.lang.Object
    //   1523	1	10	localIOException2	java.io.IOException
    //   1526	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   1558	267	10	localIOException3	java.io.IOException
    //   1830	40	10	localIOException4	java.io.IOException
    //   1875	71	10	localIOException5	java.io.IOException
    //   1953	13	10	localIOException6	java.io.IOException
    //   2019	28	10	str1	java.lang.String
    //   2117	1	10	localIOException7	java.io.IOException
    //   2122	1	10	localException	java.lang.Exception
    //   2129	1	10	localNumberFormatException	java.lang.NumberFormatException
    //   314	1320	11	localObject3	java.lang.Object
    //   1649	1	11	localIOException8	java.io.IOException
    //   2054	1	11	str2	java.lang.String
    //   2092	1	11	localIOException9	java.io.IOException
    //   2097	1	11	localIOException10	java.io.IOException
    //   2102	1	11	localIOException11	java.io.IOException
    //   2107	1	11	localIOException12	java.io.IOException
    //   448	1513	12	localObject4	java.lang.Object
    //   2112	1	12	localIOException13	java.io.IOException
    //   145	1281	13	localFile	java.io.File
    //   789	942	14	localObject5	java.lang.Object
    //   1833	1	14	localIOException14	java.io.IOException
    //   1958	13	14	localObject6	java.lang.Object
    //   832	943	15	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   155	161	520	java/io/IOException
    //   675	681	729	java/lang/InterruptedException
    //   1517	1522	1523	java/io/IOException
    //   1421	1433	1526	java/io/FileNotFoundException
    //   1376	1390	1558	java/io/IOException
    //   1392	1404	1558	java/io/IOException
    //   1406	1419	1558	java/io/IOException
    //   1421	1433	1558	java/io/IOException
    //   1530	1546	1558	java/io/IOException
    //   1548	1557	1558	java/io/IOException
    //   1970	1973	1558	java/io/IOException
    //   1596	1648	1649	java/io/IOException
    //   1824	1829	1830	java/io/IOException
    //   1728	1738	1833	java/io/IOException
    //   1869	1874	1875	java/io/IOException
    //   1945	1950	1953	java/io/IOException
    //   1435	1442	1958	finally
    //   1444	1453	1958	finally
    //   1461	1483	1958	finally
    //   1485	1501	1958	finally
    //   1503	1512	1958	finally
    //   1728	1738	1958	finally
    //   1740	1746	1958	finally
    //   1748	1762	1958	finally
    //   1764	1770	1958	finally
    //   1772	1786	1958	finally
    //   1788	1799	1958	finally
    //   1801	1814	1958	finally
    //   1837	1853	1958	finally
    //   1855	1864	1958	finally
    //   1886	1894	1958	finally
    //   1897	1908	1958	finally
    //   1911	1920	1958	finally
    //   1923	1932	1958	finally
    //   1512	1517	2092	java/io/IOException
    //   1864	1869	2097	java/io/IOException
    //   1819	1824	2102	java/io/IOException
    //   1940	1945	2107	java/io/IOException
    //   1960	1965	2112	java/io/IOException
    //   1965	1970	2117	java/io/IOException
    //   1235	1243	2122	java/lang/Exception
    //   1245	1268	2122	java/lang/Exception
    //   1235	1243	2129	java/lang/NumberFormatException
    //   1245	1268	2129	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */