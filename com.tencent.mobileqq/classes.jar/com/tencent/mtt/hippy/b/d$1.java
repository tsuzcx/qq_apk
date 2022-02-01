package com.tencent.mtt.hippy.b;

class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   4: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   7: invokevirtual 34	java/net/URI:getPort	()I
    //   10: iconst_m1
    //   11: if_icmpeq +527 -> 538
    //   14: aload_0
    //   15: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   18: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   21: invokevirtual 34	java/net/URI:getPort	()I
    //   24: istore_1
    //   25: aload_0
    //   26: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   29: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   32: invokevirtual 38	java/net/URI:getPath	()Ljava/lang/String;
    //   35: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +539 -> 577
    //   41: ldc 46
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   48: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   51: invokevirtual 49	java/net/URI:getQuery	()Ljava/lang/String;
    //   54: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +1155 -> 1212
    //   60: new 51	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   67: aload_2
    //   68: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 58
    //   73: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   80: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   83: invokevirtual 49	java/net/URI:getQuery	()Ljava/lang/String;
    //   86: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_2
    //   93: aload_0
    //   94: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   97: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   100: invokevirtual 64	java/net/URI:getScheme	()Ljava/lang/String;
    //   103: ldc 66
    //   105: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifeq +1120 -> 1228
    //   111: ldc 74
    //   113: astore_3
    //   114: new 30	java/net/URI
    //   117: dup
    //   118: aload_3
    //   119: new 51	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   126: ldc 76
    //   128: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   135: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   138: invokevirtual 79	java/net/URI:getHost	()Ljava/lang/String;
    //   141: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aconst_null
    //   148: invokespecial 82	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   151: astore 4
    //   153: aload_0
    //   154: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   157: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   160: invokevirtual 64	java/net/URI:getScheme	()Ljava/lang/String;
    //   163: ldc 66
    //   165: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifne +21 -> 189
    //   171: aload_0
    //   172: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   175: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   178: invokevirtual 64	java/net/URI:getScheme	()Ljava/lang/String;
    //   181: ldc 74
    //   183: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +405 -> 591
    //   189: aload_0
    //   190: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   193: invokestatic 86	com/tencent/mtt/hippy/b/d:b	(Lcom/tencent/mtt/hippy/b/d;)Ljavax/net/ssl/SSLSocketFactory;
    //   196: astore_3
    //   197: aload_0
    //   198: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   201: aload_3
    //   202: aload_0
    //   203: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   206: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   209: invokevirtual 79	java/net/URI:getHost	()Ljava/lang/String;
    //   212: iload_1
    //   213: invokevirtual 92	javax/net/SocketFactory:createSocket	(Ljava/lang/String;I)Ljava/net/Socket;
    //   216: invokestatic 95	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;Ljava/net/Socket;)Ljava/net/Socket;
    //   219: pop
    //   220: new 97	java/io/PrintWriter
    //   223: dup
    //   224: aload_0
    //   225: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   228: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   231: invokevirtual 107	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   234: invokespecial 110	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   237: astore 5
    //   239: aload_0
    //   240: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   243: invokestatic 114	com/tencent/mtt/hippy/b/d:d	(Lcom/tencent/mtt/hippy/b/d;)Ljava/lang/String;
    //   246: astore_3
    //   247: aload 5
    //   249: new 51	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   256: ldc 116
    //   258: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_2
    //   262: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 118
    //   267: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   276: aload 5
    //   278: ldc 124
    //   280: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   283: aload 5
    //   285: ldc 126
    //   287: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   290: aload 5
    //   292: new 51	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   299: ldc 128
    //   301: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_0
    //   305: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   308: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   311: invokevirtual 79	java/net/URI:getHost	()Ljava/lang/String;
    //   314: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc 130
    //   319: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   328: aload 5
    //   330: new 51	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   337: ldc 132
    //   339: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 4
    //   344: invokevirtual 133	java/net/URI:toString	()Ljava/lang/String;
    //   347: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 130
    //   352: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   361: aload 5
    //   363: new 51	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   370: ldc 135
    //   372: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_3
    //   376: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc 130
    //   381: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   390: aload 5
    //   392: ldc 137
    //   394: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   397: aload_0
    //   398: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   401: invokestatic 141	com/tencent/mtt/hippy/b/d:e	(Lcom/tencent/mtt/hippy/b/d;)Ljava/util/List;
    //   404: ifnull +194 -> 598
    //   407: aload_0
    //   408: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   411: invokestatic 141	com/tencent/mtt/hippy/b/d:e	(Lcom/tencent/mtt/hippy/b/d;)Ljava/util/List;
    //   414: invokeinterface 147 1 0
    //   419: astore_2
    //   420: aload_2
    //   421: invokeinterface 153 1 0
    //   426: ifeq +172 -> 598
    //   429: aload_2
    //   430: invokeinterface 157 1 0
    //   435: checkcast 159	com/tencent/mtt/hippy/b/a
    //   438: astore 4
    //   440: aload 5
    //   442: ldc 161
    //   444: iconst_2
    //   445: anewarray 4	java/lang/Object
    //   448: dup
    //   449: iconst_0
    //   450: aload 4
    //   452: invokevirtual 163	com/tencent/mtt/hippy/b/a:a	()Ljava/lang/String;
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: aload 4
    //   460: invokevirtual 165	com/tencent/mtt/hippy/b/a:b	()Ljava/lang/String;
    //   463: aastore
    //   464: invokestatic 169	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   467: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   470: goto -50 -> 420
    //   473: astore_2
    //   474: ldc 171
    //   476: ldc 173
    //   478: aload_2
    //   479: invokestatic 178	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   482: pop
    //   483: aload_0
    //   484: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   487: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   490: iconst_0
    //   491: ldc 184
    //   493: invokeinterface 189 3 0
    //   498: aload_0
    //   499: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   502: iconst_0
    //   503: invokestatic 192	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;Z)Z
    //   506: pop
    //   507: aload_0
    //   508: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   511: invokestatic 196	com/tencent/mtt/hippy/b/d:h	(Lcom/tencent/mtt/hippy/b/d;)Z
    //   514: ifne +23 -> 537
    //   517: aload_0
    //   518: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   521: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   524: ifnull +13 -> 537
    //   527: aload_0
    //   528: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   531: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   534: invokevirtual 199	java/net/Socket:close	()V
    //   537: return
    //   538: aload_0
    //   539: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   542: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   545: invokevirtual 64	java/net/URI:getScheme	()Ljava/lang/String;
    //   548: ldc 66
    //   550: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   553: ifne +662 -> 1215
    //   556: aload_0
    //   557: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   560: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   563: invokevirtual 64	java/net/URI:getScheme	()Ljava/lang/String;
    //   566: ldc 74
    //   568: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   571: ifeq +651 -> 1222
    //   574: goto +641 -> 1215
    //   577: aload_0
    //   578: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   581: invokestatic 28	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/URI;
    //   584: invokevirtual 38	java/net/URI:getPath	()Ljava/lang/String;
    //   587: astore_2
    //   588: goto -544 -> 44
    //   591: invokestatic 203	javax/net/SocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   594: astore_3
    //   595: goto -398 -> 197
    //   598: aload 5
    //   600: ldc 130
    //   602: invokevirtual 122	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   605: aload 5
    //   607: invokevirtual 206	java/io/PrintWriter:flush	()V
    //   610: new 208	com/tencent/mtt/hippy/b/b$a
    //   613: dup
    //   614: aload_0
    //   615: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   618: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   621: invokevirtual 212	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   624: invokespecial 215	com/tencent/mtt/hippy/b/b$a:<init>	(Ljava/io/InputStream;)V
    //   627: astore_2
    //   628: aload_0
    //   629: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   632: aload_0
    //   633: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   636: aload_2
    //   637: invokestatic 218	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;Lcom/tencent/mtt/hippy/b/b$a;)Ljava/lang/String;
    //   640: invokestatic 221	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;Ljava/lang/String;)Lcom/tencent/mtt/hippy/b/c;
    //   643: astore 4
    //   645: aload 4
    //   647: ifnonnull +109 -> 756
    //   650: new 223	java/net/ConnectException
    //   653: dup
    //   654: ldc 225
    //   656: invokespecial 227	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   659: athrow
    //   660: astore_2
    //   661: ldc 171
    //   663: ldc 229
    //   665: aload_2
    //   666: invokestatic 178	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   669: pop
    //   670: aload_0
    //   671: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   674: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   677: iconst_0
    //   678: ldc 231
    //   680: invokeinterface 189 3 0
    //   685: aload_0
    //   686: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   689: iconst_0
    //   690: invokestatic 192	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;Z)Z
    //   693: pop
    //   694: aload_0
    //   695: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   698: invokestatic 196	com/tencent/mtt/hippy/b/d:h	(Lcom/tencent/mtt/hippy/b/d;)Z
    //   701: ifne -164 -> 537
    //   704: aload_0
    //   705: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   708: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   711: ifnull -174 -> 537
    //   714: aload_0
    //   715: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   718: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   721: invokevirtual 199	java/net/Socket:close	()V
    //   724: return
    //   725: astore_2
    //   726: ldc 171
    //   728: ldc 233
    //   730: aload_2
    //   731: invokestatic 178	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   734: pop
    //   735: aload_0
    //   736: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   739: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   742: new 235	java/lang/Exception
    //   745: dup
    //   746: aload_2
    //   747: invokespecial 238	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   750: invokeinterface 241 2 0
    //   755: return
    //   756: aload 4
    //   758: getfield 246	com/tencent/mtt/hippy/b/c:a	I
    //   761: bipush 101
    //   763: if_icmpeq +130 -> 893
    //   766: new 223	java/net/ConnectException
    //   769: dup
    //   770: new 51	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   777: ldc 248
    //   779: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload 4
    //   784: getfield 246	com/tencent/mtt/hippy/b/c:a	I
    //   787: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   790: ldc 253
    //   792: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: aload 4
    //   797: getfield 256	com/tencent/mtt/hippy/b/c:b	Ljava/lang/String;
    //   800: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: invokespecial 227	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   809: athrow
    //   810: astore_2
    //   811: aload_0
    //   812: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   815: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   818: new 235	java/lang/Exception
    //   821: dup
    //   822: aload_2
    //   823: invokespecial 238	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   826: invokeinterface 241 2 0
    //   831: aload_0
    //   832: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   835: invokestatic 196	com/tencent/mtt/hippy/b/d:h	(Lcom/tencent/mtt/hippy/b/d;)Z
    //   838: ifne -301 -> 537
    //   841: aload_0
    //   842: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   845: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   848: ifnull -311 -> 537
    //   851: aload_0
    //   852: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   855: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   858: invokevirtual 199	java/net/Socket:close	()V
    //   861: return
    //   862: astore_2
    //   863: ldc 171
    //   865: ldc 233
    //   867: aload_2
    //   868: invokestatic 178	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   871: pop
    //   872: aload_0
    //   873: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   876: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   879: new 235	java/lang/Exception
    //   882: dup
    //   883: aload_2
    //   884: invokespecial 238	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   887: invokeinterface 241 2 0
    //   892: return
    //   893: aload_0
    //   894: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   897: aload_2
    //   898: invokestatic 218	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;Lcom/tencent/mtt/hippy/b/b$a;)Ljava/lang/String;
    //   901: astore 4
    //   903: aload 4
    //   905: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   908: ifne +146 -> 1054
    //   911: aload_0
    //   912: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   915: aload 4
    //   917: invokestatic 259	com/tencent/mtt/hippy/b/d:b	(Lcom/tencent/mtt/hippy/b/d;Ljava/lang/String;)Lcom/tencent/mtt/hippy/b/a;
    //   920: astore 4
    //   922: aload 4
    //   924: invokevirtual 163	com/tencent/mtt/hippy/b/a:a	()Ljava/lang/String;
    //   927: ldc_w 261
    //   930: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   933: ifeq -40 -> 893
    //   936: aload_0
    //   937: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   940: aload_3
    //   941: invokestatic 264	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;Ljava/lang/String;)Ljava/lang/String;
    //   944: astore 5
    //   946: aload 5
    //   948: ifnonnull +47 -> 995
    //   951: new 223	java/net/ConnectException
    //   954: dup
    //   955: ldc_w 266
    //   958: invokespecial 227	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   961: athrow
    //   962: astore_2
    //   963: aload_0
    //   964: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   967: invokestatic 196	com/tencent/mtt/hippy/b/d:h	(Lcom/tencent/mtt/hippy/b/d;)Z
    //   970: ifne +23 -> 993
    //   973: aload_0
    //   974: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   977: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   980: ifnull +13 -> 993
    //   983: aload_0
    //   984: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   987: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   990: invokevirtual 199	java/net/Socket:close	()V
    //   993: aload_2
    //   994: athrow
    //   995: aload 5
    //   997: aload 4
    //   999: invokevirtual 165	com/tencent/mtt/hippy/b/a:b	()Ljava/lang/String;
    //   1002: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   1005: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1008: ifne -115 -> 893
    //   1011: new 223	java/net/ConnectException
    //   1014: dup
    //   1015: new 51	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1022: ldc_w 271
    //   1025: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: aload 5
    //   1030: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: ldc_w 273
    //   1036: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload 4
    //   1041: invokevirtual 165	com/tencent/mtt/hippy/b/a:b	()Ljava/lang/String;
    //   1044: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokespecial 227	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   1053: athrow
    //   1054: aload_0
    //   1055: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1058: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   1061: invokeinterface 275 1 0
    //   1066: aload_0
    //   1067: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1070: iconst_1
    //   1071: invokestatic 192	com/tencent/mtt/hippy/b/d:a	(Lcom/tencent/mtt/hippy/b/d;Z)Z
    //   1074: pop
    //   1075: aload_0
    //   1076: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1079: invokestatic 279	com/tencent/mtt/hippy/b/d:g	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/b;
    //   1082: aload_2
    //   1083: invokevirtual 284	com/tencent/mtt/hippy/b/b:a	(Lcom/tencent/mtt/hippy/b/b$a;)V
    //   1086: aload_0
    //   1087: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1090: invokestatic 196	com/tencent/mtt/hippy/b/d:h	(Lcom/tencent/mtt/hippy/b/d;)Z
    //   1093: ifne -556 -> 537
    //   1096: aload_0
    //   1097: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1100: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   1103: ifnull -566 -> 537
    //   1106: aload_0
    //   1107: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1110: invokestatic 101	com/tencent/mtt/hippy/b/d:c	(Lcom/tencent/mtt/hippy/b/d;)Ljava/net/Socket;
    //   1113: invokevirtual 199	java/net/Socket:close	()V
    //   1116: return
    //   1117: astore_2
    //   1118: ldc 171
    //   1120: ldc 233
    //   1122: aload_2
    //   1123: invokestatic 178	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1126: pop
    //   1127: aload_0
    //   1128: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1131: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   1134: new 235	java/lang/Exception
    //   1137: dup
    //   1138: aload_2
    //   1139: invokespecial 238	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   1142: invokeinterface 241 2 0
    //   1147: return
    //   1148: astore_2
    //   1149: ldc 171
    //   1151: ldc 233
    //   1153: aload_2
    //   1154: invokestatic 178	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1157: pop
    //   1158: aload_0
    //   1159: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1162: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   1165: new 235	java/lang/Exception
    //   1168: dup
    //   1169: aload_2
    //   1170: invokespecial 238	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   1173: invokeinterface 241 2 0
    //   1178: return
    //   1179: astore_3
    //   1180: ldc 171
    //   1182: ldc 233
    //   1184: aload_3
    //   1185: invokestatic 178	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1188: pop
    //   1189: aload_0
    //   1190: getfield 12	com/tencent/mtt/hippy/b/d$1:a	Lcom/tencent/mtt/hippy/b/d;
    //   1193: invokestatic 182	com/tencent/mtt/hippy/b/d:f	(Lcom/tencent/mtt/hippy/b/d;)Lcom/tencent/mtt/hippy/b/d$a;
    //   1196: new 235	java/lang/Exception
    //   1199: dup
    //   1200: aload_3
    //   1201: invokespecial 238	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   1204: invokeinterface 241 2 0
    //   1209: goto -216 -> 993
    //   1212: goto -1119 -> 93
    //   1215: sipush 443
    //   1218: istore_1
    //   1219: goto -1194 -> 25
    //   1222: bipush 80
    //   1224: istore_1
    //   1225: goto -1200 -> 25
    //   1228: ldc_w 286
    //   1231: astore_3
    //   1232: goto -1118 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1235	0	this	1
    //   24	1201	1	i	int
    //   43	387	2	localObject1	Object
    //   473	6	2	localEOFException	java.io.EOFException
    //   587	50	2	localObject2	Object
    //   660	6	2	localSSLException	javax.net.ssl.SSLException
    //   725	22	2	localThrowable1	java.lang.Throwable
    //   810	13	2	localThrowable2	java.lang.Throwable
    //   862	36	2	localThrowable3	java.lang.Throwable
    //   962	121	2	locala	b.a
    //   1117	22	2	localThrowable4	java.lang.Throwable
    //   1148	22	2	localThrowable5	java.lang.Throwable
    //   113	828	3	localObject3	Object
    //   1179	22	3	localThrowable6	java.lang.Throwable
    //   1231	1	3	str	java.lang.String
    //   151	889	4	localObject4	Object
    //   237	792	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	25	473	java/io/EOFException
    //   25	41	473	java/io/EOFException
    //   44	93	473	java/io/EOFException
    //   93	111	473	java/io/EOFException
    //   114	189	473	java/io/EOFException
    //   189	197	473	java/io/EOFException
    //   197	420	473	java/io/EOFException
    //   420	470	473	java/io/EOFException
    //   538	574	473	java/io/EOFException
    //   577	588	473	java/io/EOFException
    //   591	595	473	java/io/EOFException
    //   598	645	473	java/io/EOFException
    //   650	660	473	java/io/EOFException
    //   756	810	473	java/io/EOFException
    //   893	946	473	java/io/EOFException
    //   951	962	473	java/io/EOFException
    //   995	1054	473	java/io/EOFException
    //   1054	1086	473	java/io/EOFException
    //   0	25	660	javax/net/ssl/SSLException
    //   25	41	660	javax/net/ssl/SSLException
    //   44	93	660	javax/net/ssl/SSLException
    //   93	111	660	javax/net/ssl/SSLException
    //   114	189	660	javax/net/ssl/SSLException
    //   189	197	660	javax/net/ssl/SSLException
    //   197	420	660	javax/net/ssl/SSLException
    //   420	470	660	javax/net/ssl/SSLException
    //   538	574	660	javax/net/ssl/SSLException
    //   577	588	660	javax/net/ssl/SSLException
    //   591	595	660	javax/net/ssl/SSLException
    //   598	645	660	javax/net/ssl/SSLException
    //   650	660	660	javax/net/ssl/SSLException
    //   756	810	660	javax/net/ssl/SSLException
    //   893	946	660	javax/net/ssl/SSLException
    //   951	962	660	javax/net/ssl/SSLException
    //   995	1054	660	javax/net/ssl/SSLException
    //   1054	1086	660	javax/net/ssl/SSLException
    //   714	724	725	java/lang/Throwable
    //   0	25	810	java/lang/Throwable
    //   25	41	810	java/lang/Throwable
    //   44	93	810	java/lang/Throwable
    //   93	111	810	java/lang/Throwable
    //   114	189	810	java/lang/Throwable
    //   189	197	810	java/lang/Throwable
    //   197	420	810	java/lang/Throwable
    //   420	470	810	java/lang/Throwable
    //   538	574	810	java/lang/Throwable
    //   577	588	810	java/lang/Throwable
    //   591	595	810	java/lang/Throwable
    //   598	645	810	java/lang/Throwable
    //   650	660	810	java/lang/Throwable
    //   756	810	810	java/lang/Throwable
    //   893	946	810	java/lang/Throwable
    //   951	962	810	java/lang/Throwable
    //   995	1054	810	java/lang/Throwable
    //   1054	1086	810	java/lang/Throwable
    //   851	861	862	java/lang/Throwable
    //   0	25	962	finally
    //   25	41	962	finally
    //   44	93	962	finally
    //   93	111	962	finally
    //   114	189	962	finally
    //   189	197	962	finally
    //   197	420	962	finally
    //   420	470	962	finally
    //   474	507	962	finally
    //   538	574	962	finally
    //   577	588	962	finally
    //   591	595	962	finally
    //   598	645	962	finally
    //   650	660	962	finally
    //   661	694	962	finally
    //   756	810	962	finally
    //   811	831	962	finally
    //   893	946	962	finally
    //   951	962	962	finally
    //   995	1054	962	finally
    //   1054	1086	962	finally
    //   1106	1116	1117	java/lang/Throwable
    //   527	537	1148	java/lang/Throwable
    //   983	993	1179	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.b.d.1
 * JD-Core Version:    0.7.0.1
 */