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
  private java.net.HttpURLConnection a(java.lang.String paramString1, long paramLong1, long paramLong2, java.lang.String paramString2, boolean paramBoolean, ajpk paramajpk)
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
    //   51: aload_0
    //   52: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   55: aload 9
    //   57: putfield 56	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   64: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   67: putfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   70: new 68	java/net/URL
    //   73: dup
    //   74: aload 9
    //   76: invokespecial 71	java/net/URL:<init>	(Ljava/lang/String;)V
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 75	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   84: checkcast 77	java/net/HttpURLConnection
    //   87: astore 6
    //   89: aload 6
    //   91: ifnonnull +30 -> 121
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: areturn
    //   98: astore_1
    //   99: iload 7
    //   101: ifeq +18 -> 119
    //   104: aload_0
    //   105: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   108: aload_0
    //   109: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   112: bipush 10
    //   114: bipush 102
    //   116: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   119: aconst_null
    //   120: areturn
    //   121: aload 6
    //   123: sipush 30000
    //   126: invokevirtual 86	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   129: aload 6
    //   131: sipush 30000
    //   134: invokevirtual 89	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   137: aload 6
    //   139: ldc 91
    //   141: invokevirtual 94	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   144: aload 6
    //   146: ldc 96
    //   148: ldc 98
    //   150: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: lload 4
    //   155: lconst_0
    //   156: lcmp
    //   157: ifeq +30 -> 187
    //   160: aload 6
    //   162: ldc 104
    //   164: new 27	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   171: ldc 106
    //   173: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 10
    //   178: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 6
    //   189: ldc 108
    //   191: ldc 110
    //   193: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 8
    //   198: ifnull +13 -> 211
    //   201: aload 8
    //   203: aload 6
    //   205: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   208: putfield 119	ajpk:jdField_a_of_type_Int	I
    //   211: aload 6
    //   213: astore_1
    //   214: aload 6
    //   216: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   219: sipush 200
    //   222: if_icmpeq -126 -> 96
    //   225: aload 6
    //   227: astore_1
    //   228: aload 6
    //   230: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   233: sipush 206
    //   236: if_icmpeq -140 -> 96
    //   239: aload 6
    //   241: ldc 121
    //   243: invokevirtual 125	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore_1
    //   247: aload_1
    //   248: ifnull +14 -> 262
    //   251: aload 8
    //   253: ifnull +9 -> 262
    //   256: aload 8
    //   258: aload_1
    //   259: putfield 127	ajpk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   262: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +41 -> 306
    //   268: ldc 135
    //   270: iconst_2
    //   271: new 27	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   278: ldc 137
    //   280: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 6
    //   285: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   288: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc 142
    //   293: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_1
    //   297: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aconst_null
    //   307: areturn
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   313: aconst_null
    //   314: areturn
    //   315: astore_1
    //   316: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +41 -> 360
    //   322: ldc 135
    //   324: iconst_2
    //   325: new 27	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   332: ldc 151
    //   334: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 9
    //   339: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc 153
    //   344: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_1
    //   348: invokevirtual 156	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   351: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aconst_null
    //   361: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	TaskHttpDownload
    //   0	362	1	paramString1	java.lang.String
    //   0	362	2	paramLong1	long
    //   0	362	4	paramLong2	long
    //   0	362	6	paramString2	java.lang.String
    //   0	362	7	paramBoolean	boolean
    //   0	362	8	paramajpk	ajpk
    //   49	289	9	str1	java.lang.String
    //   19	158	10	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   70	80	98	java/net/MalformedURLException
    //   80	89	308	java/io/IOException
    //   121	153	308	java/io/IOException
    //   160	187	308	java/io/IOException
    //   187	196	308	java/io/IOException
    //   201	211	308	java/io/IOException
    //   214	225	308	java/io/IOException
    //   228	247	308	java/io/IOException
    //   256	262	308	java/io/IOException
    //   262	306	308	java/io/IOException
    //   80	89	315	java/lang/NullPointerException
    //   121	153	315	java/lang/NullPointerException
    //   160	187	315	java/lang/NullPointerException
    //   187	196	315	java/lang/NullPointerException
    //   201	211	315	java/lang/NullPointerException
    //   214	225	315	java/lang/NullPointerException
    //   228	247	315	java/lang/NullPointerException
    //   256	262	315	java/lang/NullPointerException
    //   262	306	315	java/lang/NullPointerException
  }
  
  /* Error */
  private java.net.HttpURLConnection a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, long paramLong1, long paramLong2, java.lang.String paramString4, java.lang.String paramString5, boolean paramBoolean, ajpk paramajpk)
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
    //   33: ifne +92 -> 125
    //   36: new 27	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   43: ldc 161
    //   45: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 163
    //   54: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 165
    //   63: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokestatic 169	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 9
    //   75: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   86: aload_1
    //   87: putfield 56	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   90: aload_0
    //   91: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   94: invokestatic 62	java/lang/System:currentTimeMillis	()J
    //   97: putfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   100: new 68	java/net/URL
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 71	java/net/URL:<init>	(Ljava/lang/String;)V
    //   108: astore_2
    //   109: aload_2
    //   110: invokevirtual 75	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   113: checkcast 77	java/net/HttpURLConnection
    //   116: astore_3
    //   117: aload_3
    //   118: ifnonnull +89 -> 207
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: areturn
    //   125: new 27	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   132: ldc 161
    //   134: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 163
    //   143: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_2
    //   147: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 165
    //   152: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_3
    //   156: invokestatic 169	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 171
    //   164: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 12
    //   169: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 9
    //   174: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore_1
    //   181: goto -99 -> 82
    //   184: astore_1
    //   185: iload 10
    //   187: ifeq +18 -> 205
    //   190: aload_0
    //   191: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   194: aload_0
    //   195: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   198: bipush 10
    //   200: bipush 102
    //   202: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   205: aconst_null
    //   206: areturn
    //   207: aload_3
    //   208: sipush 30000
    //   211: invokevirtual 86	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   214: aload_3
    //   215: sipush 30000
    //   218: invokevirtual 89	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   221: aload_3
    //   222: ldc 91
    //   224: invokevirtual 94	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   227: aload_3
    //   228: ldc 96
    //   230: ldc 173
    //   232: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: lload 6
    //   237: lconst_0
    //   238: lcmp
    //   239: ifeq +29 -> 268
    //   242: aload_3
    //   243: ldc 104
    //   245: new 27	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   252: ldc 106
    //   254: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 12
    //   259: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_3
    //   269: ldc 108
    //   271: ldc 110
    //   273: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_3
    //   277: ldc 175
    //   279: new 27	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   286: ldc 177
    //   288: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 8
    //   293: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokevirtual 102	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload 11
    //   304: ifnull +12 -> 316
    //   307: aload 11
    //   309: aload_3
    //   310: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   313: putfield 119	ajpk:jdField_a_of_type_Int	I
    //   316: aload_3
    //   317: astore_2
    //   318: aload_3
    //   319: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   322: sipush 200
    //   325: if_icmpeq -202 -> 123
    //   328: aload_3
    //   329: astore_2
    //   330: aload_3
    //   331: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   334: sipush 206
    //   337: if_icmpeq -214 -> 123
    //   340: aload_3
    //   341: ldc 121
    //   343: invokevirtual 125	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   346: astore_2
    //   347: aload_2
    //   348: ifnull +14 -> 362
    //   351: aload 11
    //   353: ifnull +9 -> 362
    //   356: aload 11
    //   358: aload_2
    //   359: putfield 127	ajpk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   362: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +40 -> 405
    //   368: ldc 135
    //   370: iconst_2
    //   371: new 27	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   378: ldc 137
    //   380: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_3
    //   384: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   387: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: ldc 142
    //   392: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_2
    //   396: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aconst_null
    //   406: areturn
    //   407: astore_2
    //   408: ldc 135
    //   410: iconst_1
    //   411: new 27	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   418: ldc 179
    //   420: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: aload_2
    //   431: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   434: aconst_null
    //   435: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	TaskHttpDownload
    //   0	436	1	paramString1	java.lang.String
    //   0	436	2	paramString2	java.lang.String
    //   0	436	3	paramString3	java.lang.String
    //   0	436	4	paramLong1	long
    //   0	436	6	paramLong2	long
    //   0	436	8	paramString4	java.lang.String
    //   0	436	9	paramString5	java.lang.String
    //   0	436	10	paramBoolean	boolean
    //   0	436	11	paramajpk	ajpk
    //   27	231	12	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   100	109	184	java/net/MalformedURLException
    //   109	117	407	java/lang/Exception
    //   207	235	407	java/lang/Exception
    //   242	268	407	java/lang/Exception
    //   268	302	407	java/lang/Exception
    //   307	316	407	java/lang/Exception
    //   318	328	407	java/lang/Exception
    //   330	347	407	java/lang/Exception
    //   356	362	407	java/lang/Exception
    //   362	405	407	java/lang/Exception
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 192	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 135
    //   23: iconst_4
    //   24: ldc 197
    //   26: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: invokestatic 204	com/tencent/open/appcommon/Common:a	()Z
    //   32: ifne +29 -> 61
    //   35: aload_0
    //   36: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   39: aload_0
    //   40: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   43: bipush 10
    //   45: sipush 308
    //   48: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   51: getstatic 208	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   54: getstatic 211	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:m	I
    //   57: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   60: return
    //   61: new 218	java/io/File
    //   64: dup
    //   65: getstatic 223	com/tencent/mobileqq/app/AppConstants:ba	Ljava/lang/String;
    //   68: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 10
    //   73: aload 10
    //   75: invokevirtual 227	java/io/File:exists	()Z
    //   78: ifne +9 -> 87
    //   81: aload 10
    //   83: invokevirtual 230	java/io/File:mkdirs	()Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   91: new 27	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   98: getstatic 223	com/tencent/mobileqq/app/AppConstants:ba	Ljava/lang/String;
    //   101: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   108: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   111: invokevirtual 239	java/lang/String:getBytes	()[B
    //   114: invokestatic 242	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   117: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 244
    //   122: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: putfield 247	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   131: new 218	java/io/File
    //   134: dup
    //   135: aload_0
    //   136: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   139: getfield 247	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   142: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore 13
    //   147: aload 13
    //   149: invokevirtual 227	java/io/File:exists	()Z
    //   152: ifne +9 -> 161
    //   155: aload 13
    //   157: invokevirtual 250	java/io/File:createNewFile	()Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   165: aload 13
    //   167: invokevirtual 253	java/io/File:length	()J
    //   170: putfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   173: aload_0
    //   174: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   177: iconst_0
    //   178: putfield 259	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   181: aload_0
    //   182: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   185: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   188: aload_0
    //   189: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   192: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   195: lcmp
    //   196: ifgt +15 -> 211
    //   199: aload_0
    //   200: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   203: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   206: lconst_0
    //   207: lcmp
    //   208: ifne +25 -> 233
    //   211: iconst_0
    //   212: istore_3
    //   213: iconst_0
    //   214: istore_1
    //   215: aload_0
    //   216: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   219: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   222: aload_0
    //   223: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   226: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   229: lcmp
    //   230: ifne +318 -> 548
    //   233: aload_0
    //   234: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   237: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   240: invokevirtual 267	java/lang/String:length	()I
    //   243: bipush 85
    //   245: if_icmple +62 -> 307
    //   248: aload_0
    //   249: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   252: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   255: bipush 46
    //   257: invokevirtual 271	java/lang/String:lastIndexOf	(I)I
    //   260: istore_2
    //   261: iload_2
    //   262: istore_1
    //   263: iload_2
    //   264: ifge +5 -> 269
    //   267: iconst_0
    //   268: istore_1
    //   269: aload_0
    //   270: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   273: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   276: invokevirtual 267	java/lang/String:length	()I
    //   279: bipush 85
    //   281: isub
    //   282: istore_2
    //   283: iload_1
    //   284: ifne +1689 -> 1973
    //   287: aload_0
    //   288: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   291: aload_0
    //   292: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   295: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   298: iconst_0
    //   299: bipush 85
    //   301: invokevirtual 275	java/lang/String:substring	(II)Ljava/lang/String;
    //   304: putfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   307: aload_0
    //   308: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   311: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   314: astore 11
    //   316: aload 11
    //   318: astore 10
    //   320: aload_0
    //   321: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   324: getfield 278	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   327: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   330: ifne +27 -> 357
    //   333: aload 11
    //   335: astore 10
    //   337: aload_0
    //   338: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   341: getfield 287	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
    //   344: iconst_2
    //   345: if_icmpne +12 -> 357
    //   348: aload_0
    //   349: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   352: getfield 278	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
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
    //   374: invokevirtual 271	java/lang/String:lastIndexOf	(I)I
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
    //   393: getstatic 290	com/tencent/mobileqq/app/AppConstants:aX	Ljava/lang/String;
    //   396: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 10
    //   401: iconst_0
    //   402: iload_2
    //   403: invokevirtual 275	java/lang/String:substring	(II)Ljava/lang/String;
    //   406: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 292
    //   412: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: iload_1
    //   416: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: ldc_w 294
    //   422: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 10
    //   427: iload_2
    //   428: invokevirtual 297	java/lang/String:substring	(I)Ljava/lang/String;
    //   431: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: astore 11
    //   439: new 218	java/io/File
    //   442: dup
    //   443: aload 11
    //   445: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   448: astore 12
    //   450: aload 12
    //   452: invokevirtual 227	java/io/File:exists	()Z
    //   455: ifne +1604 -> 2059
    //   458: aload 13
    //   460: aload 12
    //   462: invokevirtual 301	java/io/File:renameTo	(Ljava/io/File;)Z
    //   465: ifeq +1594 -> 2059
    //   468: aload_0
    //   469: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   472: aload 11
    //   474: putfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   477: aload_0
    //   478: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   481: aload_0
    //   482: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   485: bipush 11
    //   487: invokevirtual 307	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   490: aload_0
    //   491: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   494: aload_0
    //   495: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   498: aload_0
    //   499: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   502: getfield 310	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	J
    //   505: invokevirtual 314	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   508: iconst_0
    //   509: invokevirtual 317	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   512: getstatic 318	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:jdField_a_of_type_Int	I
    //   515: iconst_0
    //   516: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   519: return
    //   520: astore 10
    //   522: aload_0
    //   523: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   526: aload_0
    //   527: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   530: bipush 10
    //   532: sipush 303
    //   535: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   538: getstatic 208	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   541: getstatic 321	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:h	I
    //   544: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   547: return
    //   548: iload_1
    //   549: iconst_3
    //   550: if_icmplt +77 -> 627
    //   553: aload_0
    //   554: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   557: aload_0
    //   558: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   561: bipush 10
    //   563: bipush 105
    //   565: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   568: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +35 -> 606
    //   574: ldc 135
    //   576: iconst_2
    //   577: new 27	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 323
    //   587: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_0
    //   591: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   594: getfield 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   597: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: iload_3
    //   607: ifne -593 -> 14
    //   610: getstatic 328	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   613: getstatic 331	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:o	I
    //   616: aload_0
    //   617: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   620: getfield 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   623: invokestatic 334	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   626: return
    //   627: iload_1
    //   628: ifle +118 -> 746
    //   631: invokestatic 340	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   634: invokestatic 346	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   637: ifne +28 -> 665
    //   640: aload_0
    //   641: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   644: aload_0
    //   645: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   648: bipush 10
    //   650: bipush 106
    //   652: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   655: getstatic 208	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   658: getstatic 349	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   661: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   664: return
    //   665: iconst_0
    //   666: istore_2
    //   667: iload_2
    //   668: iload_1
    //   669: bipush 100
    //   671: imul
    //   672: if_icmpge +74 -> 746
    //   675: ldc2_w 350
    //   678: invokestatic 357	java/lang/Thread:sleep	(J)V
    //   681: aload_0
    //   682: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   685: aload_0
    //   686: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   689: invokevirtual 192	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   692: ifne -678 -> 14
    //   695: invokestatic 340	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   698: invokestatic 346	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   701: ifne +38 -> 739
    //   704: aload_0
    //   705: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   708: aload_0
    //   709: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   712: bipush 10
    //   714: bipush 106
    //   716: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   719: getstatic 208	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   722: getstatic 349	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:k	I
    //   725: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   728: return
    //   729: astore 10
    //   731: aload 10
    //   733: invokevirtual 358	java/lang/InterruptedException:printStackTrace	()V
    //   736: goto -55 -> 681
    //   739: iload_2
    //   740: iconst_1
    //   741: iadd
    //   742: istore_2
    //   743: goto -76 -> 667
    //   746: aload_0
    //   747: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   750: aload_0
    //   751: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   754: invokevirtual 192	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   757: ifne -743 -> 14
    //   760: iload_1
    //   761: iconst_1
    //   762: iadd
    //   763: istore_1
    //   764: aload_0
    //   765: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   768: iload_1
    //   769: putfield 259	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   772: aconst_null
    //   773: astore 12
    //   775: aconst_null
    //   776: astore 11
    //   778: new 116	ajpk
    //   781: dup
    //   782: aload_0
    //   783: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   786: invokespecial 361	ajpk:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   789: astore 14
    //   791: aload 12
    //   793: astore 10
    //   795: aload_0
    //   796: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   799: invokevirtual 364	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   802: ifnull +251 -> 1053
    //   805: aload 12
    //   807: astore 10
    //   809: aload_0
    //   810: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   813: getfield 367	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   816: ifne +237 -> 1053
    //   819: aload_0
    //   820: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   823: invokevirtual 364	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   826: iconst_5
    //   827: invokeinterface 373 2 0
    //   832: astore 15
    //   834: aload 12
    //   836: astore 10
    //   838: aload 15
    //   840: ifnull +213 -> 1053
    //   843: aload 12
    //   845: astore 10
    //   847: aload 15
    //   849: invokeinterface 377 1 0
    //   854: ifne +199 -> 1053
    //   857: aload 15
    //   859: invokeinterface 381 1 0
    //   864: astore 12
    //   866: aload 11
    //   868: astore 10
    //   870: aload 12
    //   872: invokeinterface 386 1 0
    //   877: ifeq +176 -> 1053
    //   880: aload 12
    //   882: invokeinterface 390 1 0
    //   887: checkcast 392	mqq/manager/ProxyIpManager$ProxyIp
    //   890: astore 10
    //   892: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   895: ifeq +38 -> 933
    //   898: ldc 135
    //   900: iconst_2
    //   901: ldc_w 394
    //   904: iconst_2
    //   905: anewarray 396	java/lang/Object
    //   908: dup
    //   909: iconst_0
    //   910: aload 10
    //   912: getfield 399	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   915: aastore
    //   916: dup
    //   917: iconst_1
    //   918: aload 10
    //   920: getfield 402	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   923: invokestatic 408	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   926: aastore
    //   927: invokestatic 412	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   930: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   933: ldc_w 414
    //   936: iconst_2
    //   937: anewarray 396	java/lang/Object
    //   940: dup
    //   941: iconst_0
    //   942: aload_0
    //   943: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   946: getfield 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   949: aastore
    //   950: dup
    //   951: iconst_1
    //   952: bipush 80
    //   954: invokestatic 408	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   957: aastore
    //   958: invokestatic 412	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   961: astore 11
    //   963: aload_0
    //   964: aload 10
    //   966: getfield 399	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   969: aload_0
    //   970: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   973: getfield 417	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   976: aload_0
    //   977: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   980: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   983: aload_0
    //   984: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   987: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   990: aload_0
    //   991: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   994: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   997: aload_0
    //   998: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1001: getfield 420	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1004: aload 11
    //   1006: iconst_0
    //   1007: aload 14
    //   1009: invokespecial 422	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLajpk;)Ljava/net/HttpURLConnection;
    //   1012: astore 11
    //   1014: aload 11
    //   1016: astore 10
    //   1018: aload 11
    //   1020: ifnull -150 -> 870
    //   1023: aload 11
    //   1025: astore 10
    //   1027: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1030: ifeq +23 -> 1053
    //   1033: ldc 135
    //   1035: iconst_2
    //   1036: ldc_w 424
    //   1039: iconst_0
    //   1040: anewarray 396	java/lang/Object
    //   1043: invokestatic 412	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1046: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1049: aload 11
    //   1051: astore 10
    //   1053: aload 10
    //   1055: astore 11
    //   1057: aload 10
    //   1059: ifnonnull +315 -> 1374
    //   1062: aload_0
    //   1063: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1066: getfield 367	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   1069: ifeq +218 -> 1287
    //   1072: aload_0
    //   1073: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1076: getfield 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   1079: ifnull +208 -> 1287
    //   1082: aload_0
    //   1083: aload_0
    //   1084: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1087: getfield 427	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
    //   1090: aload_0
    //   1091: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1094: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1097: aload_0
    //   1098: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1101: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1104: aload_0
    //   1105: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1108: getfield 420	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1111: iconst_0
    //   1112: aload 14
    //   1114: invokespecial 429	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;JJLjava/lang/String;ZLajpk;)Ljava/net/HttpURLConnection;
    //   1117: astore 10
    //   1119: aload 10
    //   1121: ifnonnull +223 -> 1344
    //   1124: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1127: ifeq +65 -> 1192
    //   1130: new 27	java/lang/StringBuilder
    //   1133: dup
    //   1134: ldc_w 431
    //   1137: invokespecial 432	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1140: astore 10
    //   1142: aload 10
    //   1144: iload_1
    //   1145: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1148: ldc_w 434
    //   1151: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload_0
    //   1155: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1158: getfield 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1161: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: ldc_w 436
    //   1167: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: aload_0
    //   1171: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1174: getfield 417	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1177: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: pop
    //   1181: ldc 135
    //   1183: iconst_2
    //   1184: aload 10
    //   1186: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1192: iload_1
    //   1193: iconst_3
    //   1194: if_icmpne +942 -> 2136
    //   1197: getstatic 439	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:u	I
    //   1200: istore_3
    //   1201: iload_3
    //   1202: istore_2
    //   1203: aload 14
    //   1205: getfield 119	ajpk:jdField_a_of_type_Int	I
    //   1208: sipush 200
    //   1211: if_icmpeq +22 -> 1233
    //   1214: iload_3
    //   1215: istore_2
    //   1216: aload 14
    //   1218: getfield 119	ajpk:jdField_a_of_type_Int	I
    //   1221: sipush 206
    //   1224: if_icmpeq +9 -> 1233
    //   1227: aload 14
    //   1229: getfield 119	ajpk:jdField_a_of_type_Int	I
    //   1232: istore_2
    //   1233: iload_2
    //   1234: istore_3
    //   1235: aload 14
    //   1237: getfield 127	ajpk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1240: ifnull +28 -> 1268
    //   1243: iload_2
    //   1244: istore_3
    //   1245: aload 14
    //   1247: getfield 127	ajpk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1250: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1253: ifne +15 -> 1268
    //   1256: aload 14
    //   1258: getfield 127	ajpk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1261: invokestatic 442	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1264: invokevirtual 445	java/lang/Integer:intValue	()I
    //   1267: istore_3
    //   1268: getstatic 328	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   1271: iload_3
    //   1272: aload_0
    //   1273: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1276: getfield 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1279: invokestatic 334	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   1282: iconst_1
    //   1283: istore_3
    //   1284: goto -1069 -> 215
    //   1287: aload_0
    //   1288: aload_0
    //   1289: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1292: getfield 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1295: aload_0
    //   1296: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1299: getfield 417	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   1302: aload_0
    //   1303: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1306: getfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   1309: aload_0
    //   1310: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1313: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1316: aload_0
    //   1317: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1320: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1323: aload_0
    //   1324: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1327: getfield 420	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   1330: ldc_w 447
    //   1333: iconst_1
    //   1334: aload 14
    //   1336: invokespecial 422	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLajpk;)Ljava/net/HttpURLConnection;
    //   1339: astore 10
    //   1341: goto -222 -> 1119
    //   1344: aload 10
    //   1346: astore 11
    //   1348: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1351: ifeq +23 -> 1374
    //   1354: ldc 135
    //   1356: iconst_2
    //   1357: ldc_w 449
    //   1360: iconst_0
    //   1361: anewarray 396	java/lang/Object
    //   1364: invokestatic 412	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1367: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1370: aload 10
    //   1372: astore 11
    //   1374: iload_1
    //   1375: istore_2
    //   1376: new 451	java/io/BufferedInputStream
    //   1379: dup
    //   1380: aload 11
    //   1382: invokevirtual 455	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1385: invokespecial 458	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1388: astore 12
    //   1390: iload_1
    //   1391: istore_2
    //   1392: aload_0
    //   1393: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1396: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1399: lconst_0
    //   1400: lcmp
    //   1401: ifne +18 -> 1419
    //   1404: iload_1
    //   1405: istore_2
    //   1406: aload_0
    //   1407: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1410: aload 11
    //   1412: invokevirtual 461	java/net/HttpURLConnection:getContentLength	()I
    //   1415: i2l
    //   1416: putfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1419: iload_1
    //   1420: istore_2
    //   1421: new 463	java/io/FileOutputStream
    //   1424: dup
    //   1425: aload 13
    //   1427: iconst_1
    //   1428: invokespecial 466	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
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
    //   1448: invokevirtual 472	java/io/InputStream:read	([B)I
    //   1451: istore 4
    //   1453: iload 4
    //   1455: iconst_m1
    //   1456: if_icmpeq +484 -> 1940
    //   1459: iload_1
    //   1460: istore_2
    //   1461: aload_0
    //   1462: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1465: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1468: iload 4
    //   1470: i2l
    //   1471: ladd
    //   1472: aload_0
    //   1473: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1476: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1479: lcmp
    //   1480: ifle +246 -> 1726
    //   1483: iload_1
    //   1484: istore_2
    //   1485: aload_0
    //   1486: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1489: aload_0
    //   1490: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1493: bipush 10
    //   1495: sipush 305
    //   1498: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1501: iload_1
    //   1502: istore_2
    //   1503: getstatic 208	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1506: getstatic 475	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:p	I
    //   1509: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   1512: aload 12
    //   1514: invokevirtual 478	java/io/InputStream:close	()V
    //   1517: aload 10
    //   1519: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   1522: return
    //   1523: astore 10
    //   1525: return
    //   1526: astore 10
    //   1528: iload_1
    //   1529: istore_2
    //   1530: aload_0
    //   1531: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1534: aload_0
    //   1535: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1538: bipush 10
    //   1540: sipush 304
    //   1543: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1546: iload_1
    //   1547: istore_2
    //   1548: getstatic 208	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1551: getstatic 481	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   1554: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   1557: return
    //   1558: astore 10
    //   1560: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1563: ifeq +33 -> 1596
    //   1566: ldc 135
    //   1568: iconst_4
    //   1569: new 27	java/lang/StringBuilder
    //   1572: dup
    //   1573: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1576: ldc_w 483
    //   1579: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: aload 10
    //   1584: invokevirtual 484	java/io/IOException:toString	()Ljava/lang/String;
    //   1587: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1593: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1596: aload 10
    //   1598: instanceof 486
    //   1601: ifeq +86 -> 1687
    //   1604: sipush 206
    //   1607: aload 11
    //   1609: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   1612: if_icmpne +75 -> 1687
    //   1615: aload_0
    //   1616: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1619: aload_0
    //   1620: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1623: bipush 10
    //   1625: bipush 105
    //   1627: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1630: getstatic 328	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:d	I
    //   1633: aload 11
    //   1635: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   1638: aload_0
    //   1639: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1642: getfield 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   1645: invokestatic 334	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(IILjava/lang/String;)V
    //   1648: return
    //   1649: astore 11
    //   1651: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1654: ifeq +33 -> 1687
    //   1657: ldc 135
    //   1659: iconst_4
    //   1660: new 27	java/lang/StringBuilder
    //   1663: dup
    //   1664: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1667: ldc_w 483
    //   1670: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: aload 10
    //   1675: invokevirtual 484	java/io/IOException:toString	()Ljava/lang/String;
    //   1678: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1684: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1687: iload_2
    //   1688: istore_1
    //   1689: invokestatic 195	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1692: ifeq -1477 -> 215
    //   1695: ldc 135
    //   1697: iconst_4
    //   1698: new 27	java/lang/StringBuilder
    //   1701: dup
    //   1702: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1705: ldc_w 488
    //   1708: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: iload_2
    //   1712: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1718: invokestatic 146	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1721: iload_2
    //   1722: istore_1
    //   1723: goto -1508 -> 215
    //   1726: iload_1
    //   1727: istore_2
    //   1728: aload 10
    //   1730: aload 14
    //   1732: iconst_0
    //   1733: iload 4
    //   1735: invokevirtual 492	java/io/FileOutputStream:write	([BII)V
    //   1738: iload_1
    //   1739: istore_2
    //   1740: aload_0
    //   1741: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1744: astore 15
    //   1746: iload_1
    //   1747: istore_2
    //   1748: aload 15
    //   1750: aload 15
    //   1752: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1755: iload 4
    //   1757: i2l
    //   1758: ladd
    //   1759: putfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1762: iload_1
    //   1763: istore_2
    //   1764: aload_0
    //   1765: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1768: astore 15
    //   1770: iload_1
    //   1771: istore_2
    //   1772: aload 15
    //   1774: aload 15
    //   1776: getfield 495	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1779: iload 4
    //   1781: i2l
    //   1782: ladd
    //   1783: putfield 495	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1786: iload_1
    //   1787: istore_2
    //   1788: aload_0
    //   1789: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1792: iconst_1
    //   1793: iload 4
    //   1795: i2l
    //   1796: invokevirtual 498	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   1799: iload_1
    //   1800: istore_2
    //   1801: aload_0
    //   1802: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1805: aload_0
    //   1806: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1809: invokevirtual 192	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   1812: istore 5
    //   1814: iload 5
    //   1816: ifeq +62 -> 1878
    //   1819: aload 12
    //   1821: invokevirtual 478	java/io/InputStream:close	()V
    //   1824: aload 10
    //   1826: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   1829: return
    //   1830: astore 10
    //   1832: return
    //   1833: astore 14
    //   1835: iload_1
    //   1836: istore_2
    //   1837: aload_0
    //   1838: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1841: aload_0
    //   1842: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1845: bipush 10
    //   1847: sipush 306
    //   1850: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1853: iload_1
    //   1854: istore_2
    //   1855: getstatic 208	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   1858: getstatic 501	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:i	I
    //   1861: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
    //   1864: aload 12
    //   1866: invokevirtual 478	java/io/InputStream:close	()V
    //   1869: aload 10
    //   1871: invokevirtual 479	java/io/FileOutputStream:close	()V
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
    //   1887: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1890: iconst_0
    //   1891: putfield 259	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   1894: iload 4
    //   1896: istore_2
    //   1897: aload_0
    //   1898: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1901: aload_0
    //   1902: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1905: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1908: iload 4
    //   1910: istore_2
    //   1911: aload_0
    //   1912: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1915: getfield 256	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1918: lstore 6
    //   1920: iload 4
    //   1922: istore_2
    //   1923: aload_0
    //   1924: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1927: getfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   1930: lstore 8
    //   1932: lload 6
    //   1934: lload 8
    //   1936: lcmp
    //   1937: ifne -495 -> 1442
    //   1940: aload 12
    //   1942: invokevirtual 478	java/io/InputStream:close	()V
    //   1945: aload 10
    //   1947: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   1950: goto -1717 -> 233
    //   1953: astore 10
    //   1955: goto -1722 -> 233
    //   1958: astore 14
    //   1960: aload 12
    //   1962: invokevirtual 478	java/io/InputStream:close	()V
    //   1965: aload 10
    //   1967: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   1970: aload 14
    //   1972: athrow
    //   1973: iload_1
    //   1974: iload_2
    //   1975: if_icmple -1668 -> 307
    //   1978: new 27	java/lang/StringBuilder
    //   1981: dup
    //   1982: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1985: aload_0
    //   1986: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1989: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1992: iconst_0
    //   1993: iload_1
    //   1994: iload_2
    //   1995: isub
    //   1996: invokevirtual 275	java/lang/String:substring	(II)Ljava/lang/String;
    //   1999: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2002: aload_0
    //   2003: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2006: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   2009: iload_1
    //   2010: invokevirtual 297	java/lang/String:substring	(I)Ljava/lang/String;
    //   2013: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2019: astore 10
    //   2021: aload_0
    //   2022: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2025: aload 10
    //   2027: putfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   2030: goto -1723 -> 307
    //   2033: new 27	java/lang/StringBuilder
    //   2036: dup
    //   2037: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2040: getstatic 290	com/tencent/mobileqq/app/AppConstants:aX	Ljava/lang/String;
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
    //   2071: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2074: bipush 10
    //   2076: sipush 307
    //   2079: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   2082: getstatic 208	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   2085: getstatic 507	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:n	I
    //   2088: invokestatic 216	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:b	(II)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */