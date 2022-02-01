package com.tencent.turingfd.sdk.xq;

public class Cranberry
{
  public static final String NAME = const.get(const.ef);
  public static Cranberry zg = new Cranberry();
  public CanisMinor Eh = null;
  public void Yg;
  
  /* Error */
  public Chestnut a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: new 46	com/tencent/turingfd/sdk/xq/Canesatici
    //   3: dup
    //   4: invokespecial 47	com/tencent/turingfd/sdk/xq/Canesatici:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   14: putfield 57	com/tencent/turingfd/sdk/xq/Canesatici:timestamp	J
    //   17: new 59	java/util/HashMap
    //   20: dup
    //   21: invokespecial 60	java/util/HashMap:<init>	()V
    //   24: astore 6
    //   26: aload 6
    //   28: iconst_1
    //   29: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aload_1
    //   33: invokeinterface 72 3 0
    //   38: pop
    //   39: aload 7
    //   41: aload 6
    //   43: putfield 76	com/tencent/turingfd/sdk/xq/Canesatici:fa	Ljava/util/Map;
    //   46: aload 7
    //   48: iconst_0
    //   49: putfield 80	com/tencent/turingfd/sdk/xq/Canesatici:ga	I
    //   52: new 82	com/tencent/turingfd/sdk/xq/Cassiopeia
    //   55: dup
    //   56: invokespecial 83	com/tencent/turingfd/sdk/xq/Cassiopeia:<init>	()V
    //   59: astore_1
    //   60: aload_1
    //   61: bipush 50
    //   63: putfield 86	com/tencent/turingfd/sdk/xq/Cassiopeia:qa	I
    //   66: aload_1
    //   67: ldc 88
    //   69: putfield 91	com/tencent/turingfd/sdk/xq/Cassiopeia:ra	Ljava/lang/String;
    //   72: aload_1
    //   73: ldc 93
    //   75: putfield 96	com/tencent/turingfd/sdk/xq/Cassiopeia:sa	Ljava/lang/String;
    //   78: aload_1
    //   79: ldc 98
    //   81: invokestatic 103	com/tencent/turingfd/sdk/xq/do:a	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 108	com/tencent/turingfd/sdk/xq/final:jf	I
    //   87: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: putfield 121	com/tencent/turingfd/sdk/xq/Cassiopeia:ta	Ljava/lang/String;
    //   96: aload_1
    //   97: iconst_2
    //   98: putfield 124	com/tencent/turingfd/sdk/xq/Cassiopeia:ua	I
    //   101: aload 7
    //   103: aload_1
    //   104: putfield 128	com/tencent/turingfd/sdk/xq/Canesatici:ha	Lcom/tencent/turingfd/sdk/xq/Cassiopeia;
    //   107: aload_0
    //   108: getfield 35	com/tencent/turingfd/sdk/xq/Cranberry:Eh	Lcom/tencent/turingfd/sdk/xq/CanisMinor;
    //   111: ifnonnull +113 -> 224
    //   114: aload_0
    //   115: new 130	com/tencent/turingfd/sdk/xq/CanisMinor
    //   118: dup
    //   119: invokespecial 131	com/tencent/turingfd/sdk/xq/CanisMinor:<init>	()V
    //   122: putfield 35	com/tencent/turingfd/sdk/xq/Cranberry:Eh	Lcom/tencent/turingfd/sdk/xq/CanisMinor;
    //   125: invokestatic 136	com/tencent/turingfd/sdk/xq/this:get	()Landroid/content/Context;
    //   128: astore 8
    //   130: aload_0
    //   131: getfield 35	com/tencent/turingfd/sdk/xq/Cranberry:Eh	Lcom/tencent/turingfd/sdk/xq/CanisMinor;
    //   134: astore 9
    //   136: aload 8
    //   138: invokevirtual 141	android/content/Context:getPackageName	()Ljava/lang/String;
    //   141: astore 6
    //   143: aload 6
    //   145: astore_1
    //   146: aload 6
    //   148: ifnonnull +6 -> 154
    //   151: ldc 98
    //   153: astore_1
    //   154: aload 9
    //   156: aload_1
    //   157: putfield 144	com/tencent/turingfd/sdk/xq/CanisMinor:na	Ljava/lang/String;
    //   160: aload 8
    //   162: invokevirtual 141	android/content/Context:getPackageName	()Ljava/lang/String;
    //   165: astore_1
    //   166: ldc 146
    //   168: astore 6
    //   170: aload 8
    //   172: invokevirtual 150	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   175: aload_1
    //   176: bipush 64
    //   178: invokevirtual 156	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   181: astore 8
    //   183: aload 8
    //   185: getfield 161	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   188: astore_1
    //   189: aload 8
    //   191: getfield 164	android/content/pm/PackageInfo:versionCode	I
    //   194: istore_3
    //   195: ldc 166
    //   197: iconst_2
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_1
    //   204: aastore
    //   205: dup
    //   206: iconst_1
    //   207: iload_3
    //   208: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: aastore
    //   212: invokestatic 172	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   215: astore_1
    //   216: aload_0
    //   217: getfield 35	com/tencent/turingfd/sdk/xq/Cranberry:Eh	Lcom/tencent/turingfd/sdk/xq/CanisMinor;
    //   220: aload_1
    //   221: putfield 175	com/tencent/turingfd/sdk/xq/CanisMinor:ma	Ljava/lang/String;
    //   224: aload 7
    //   226: aload_0
    //   227: getfield 35	com/tencent/turingfd/sdk/xq/Cranberry:Eh	Lcom/tencent/turingfd/sdk/xq/CanisMinor;
    //   230: putfield 178	com/tencent/turingfd/sdk/xq/Canesatici:ia	Lcom/tencent/turingfd/sdk/xq/CanisMinor;
    //   233: new 180	com/tencent/turingfd/sdk/xq/Centaurus
    //   236: dup
    //   237: invokespecial 181	com/tencent/turingfd/sdk/xq/Centaurus:<init>	()V
    //   240: astore_1
    //   241: aload_1
    //   242: aload_0
    //   243: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   246: invokevirtual 186	com/tencent/turingfd/sdk/xq/void:f	()Ljava/lang/String;
    //   249: putfield 189	com/tencent/turingfd/sdk/xq/Centaurus:ya	Ljava/lang/String;
    //   252: aload_1
    //   253: aload_0
    //   254: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   257: invokevirtual 192	com/tencent/turingfd/sdk/xq/void:getMetaData	()Ljava/lang/String;
    //   260: putfield 195	com/tencent/turingfd/sdk/xq/Centaurus:metaData	Ljava/lang/String;
    //   263: aload_1
    //   264: aload_0
    //   265: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   268: invokevirtual 198	com/tencent/turingfd/sdk/xq/void:h	()Ljava/lang/String;
    //   271: putfield 199	com/tencent/turingfd/sdk/xq/Centaurus:ta	Ljava/lang/String;
    //   274: aload_1
    //   275: aload_0
    //   276: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   279: invokevirtual 203	com/tencent/turingfd/sdk/xq/void:g	()I
    //   282: putfield 206	com/tencent/turingfd/sdk/xq/Centaurus:wa	I
    //   285: aload_1
    //   286: aload_0
    //   287: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   290: invokevirtual 209	com/tencent/turingfd/sdk/xq/void:j	()Ljava/lang/String;
    //   293: putfield 212	com/tencent/turingfd/sdk/xq/Centaurus:version	Ljava/lang/String;
    //   296: aload_1
    //   297: aload_0
    //   298: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   301: invokevirtual 215	com/tencent/turingfd/sdk/xq/void:i	()Ljava/lang/String;
    //   304: putfield 216	com/tencent/turingfd/sdk/xq/Centaurus:sa	Ljava/lang/String;
    //   307: aload 7
    //   309: aload_1
    //   310: putfield 220	com/tencent/turingfd/sdk/xq/Canesatici:ja	Lcom/tencent/turingfd/sdk/xq/Centaurus;
    //   313: new 59	java/util/HashMap
    //   316: dup
    //   317: invokespecial 60	java/util/HashMap:<init>	()V
    //   320: astore 8
    //   322: invokestatic 136	com/tencent/turingfd/sdk/xq/this:get	()Landroid/content/Context;
    //   325: astore 10
    //   327: aload 10
    //   329: invokestatic 225	com/tencent/turingfd/sdk/xq/class:g	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/goto;
    //   332: checkcast 227	com/tencent/turingfd/sdk/xq/Serpens
    //   335: astore 9
    //   337: aload 9
    //   339: getfield 230	com/tencent/turingfd/sdk/xq/Serpens:Og	Ljava/lang/String;
    //   342: astore 6
    //   344: aload 6
    //   346: astore_1
    //   347: aload 6
    //   349: ifnonnull +6 -> 355
    //   352: ldc 98
    //   354: astore_1
    //   355: aload 8
    //   357: iconst_1
    //   358: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: aload_1
    //   362: invokeinterface 72 3 0
    //   367: pop
    //   368: aload_0
    //   369: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   372: invokevirtual 233	com/tencent/turingfd/sdk/xq/void:o	()V
    //   375: aload 10
    //   377: ldc 235
    //   379: invokevirtual 239	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   382: checkcast 241	android/telephony/TelephonyManager
    //   385: invokevirtual 244	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   388: astore_1
    //   389: aload_1
    //   390: astore 6
    //   392: aload_1
    //   393: ifnonnull +7 -> 400
    //   396: ldc 98
    //   398: astore 6
    //   400: aload 8
    //   402: iconst_2
    //   403: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: aload 6
    //   408: invokeinterface 72 3 0
    //   413: pop
    //   414: aload_0
    //   415: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   418: invokevirtual 247	com/tencent/turingfd/sdk/xq/void:getUniqueId	()Ljava/lang/String;
    //   421: astore 6
    //   423: aload 6
    //   425: astore_1
    //   426: aload 6
    //   428: ifnonnull +6 -> 434
    //   431: ldc 98
    //   433: astore_1
    //   434: aload 8
    //   436: bipush 6
    //   438: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: aload_1
    //   442: invokeinterface 72 3 0
    //   447: pop
    //   448: aload_2
    //   449: astore_1
    //   450: aload_2
    //   451: ifnonnull +6 -> 457
    //   454: ldc 98
    //   456: astore_1
    //   457: aload 8
    //   459: iconst_4
    //   460: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   463: aload_1
    //   464: invokeinterface 72 3 0
    //   469: pop
    //   470: aload 9
    //   472: getfield 250	com/tencent/turingfd/sdk/xq/Serpens:Tg	Ljava/lang/String;
    //   475: astore_2
    //   476: aload_2
    //   477: astore_1
    //   478: aload_2
    //   479: ifnonnull +6 -> 485
    //   482: ldc 98
    //   484: astore_1
    //   485: aload 8
    //   487: iconst_3
    //   488: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: aload_1
    //   492: invokeinterface 72 3 0
    //   497: pop
    //   498: aload 7
    //   500: aload 8
    //   502: putfield 253	com/tencent/turingfd/sdk/xq/Canesatici:ka	Ljava/util/Map;
    //   505: new 59	java/util/HashMap
    //   508: dup
    //   509: invokespecial 60	java/util/HashMap:<init>	()V
    //   512: astore_1
    //   513: aload_1
    //   514: iconst_1
    //   515: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aload_0
    //   519: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   522: invokevirtual 256	com/tencent/turingfd/sdk/xq/void:getContext	()Landroid/content/Context;
    //   525: ldc_w 258
    //   528: invokestatic 264	com/tencent/turingfd/sdk/xq/Almond:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   531: invokeinterface 72 3 0
    //   536: pop
    //   537: aload_1
    //   538: iconst_2
    //   539: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   542: aload_0
    //   543: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   546: invokevirtual 256	com/tencent/turingfd/sdk/xq/void:getContext	()Landroid/content/Context;
    //   549: ldc_w 266
    //   552: invokestatic 264	com/tencent/turingfd/sdk/xq/Almond:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   555: invokeinterface 72 3 0
    //   560: pop
    //   561: aload 7
    //   563: aload_1
    //   564: putfield 269	com/tencent/turingfd/sdk/xq/Canesatici:la	Ljava/util/Map;
    //   567: invokestatic 136	com/tencent/turingfd/sdk/xq/this:get	()Landroid/content/Context;
    //   570: invokestatic 273	com/tencent/turingfd/sdk/xq/this:e	(Landroid/content/Context;)B
    //   573: istore_3
    //   574: getstatic 26	com/tencent/turingfd/sdk/xq/Cranberry:NAME	Ljava/lang/String;
    //   577: astore_1
    //   578: new 275	com/tencent/turingfd/sdk/xq/private
    //   581: dup
    //   582: invokespecial 276	com/tencent/turingfd/sdk/xq/private:<init>	()V
    //   585: astore_2
    //   586: aload_2
    //   587: getfield 280	com/tencent/turingfd/sdk/xq/private:bg	Lcom/tencent/turingfd/sdk/xq/for;
    //   590: aload_1
    //   591: putfield 285	com/tencent/turingfd/sdk/xq/for:r	Ljava/lang/String;
    //   594: aload_2
    //   595: getfield 280	com/tencent/turingfd/sdk/xq/private:bg	Lcom/tencent/turingfd/sdk/xq/for;
    //   598: aload_1
    //   599: putfield 288	com/tencent/turingfd/sdk/xq/for:s	Ljava/lang/String;
    //   602: aload_2
    //   603: ldc_w 290
    //   606: aload 7
    //   608: invokevirtual 293	com/tencent/turingfd/sdk/xq/private:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   611: aload_2
    //   612: invokevirtual 297	com/tencent/turingfd/sdk/xq/private:x	()[B
    //   615: invokestatic 300	com/tencent/turingfd/sdk/xq/this:c	([B)[B
    //   618: astore_1
    //   619: aload_1
    //   620: ifnull +129 -> 749
    //   623: aload_1
    //   624: invokestatic 302	com/tencent/turingfd/sdk/xq/this:e	()[B
    //   627: invokestatic 306	com/tencent/turingfd/sdk/xq/this:b	([B[B)[B
    //   630: astore_1
    //   631: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   634: lstore 4
    //   636: aload_0
    //   637: aload_1
    //   638: ldc2_w 307
    //   641: invokevirtual 311	com/tencent/turingfd/sdk/xq/Cranberry:a	([BJ)Lcom/tencent/turingfd/sdk/xq/long$do;
    //   644: astore_2
    //   645: new 313	com/tencent/turingfd/sdk/xq/Codlin$do
    //   648: dup
    //   649: aconst_null
    //   650: invokespecial 316	com/tencent/turingfd/sdk/xq/Codlin$do:<init>	(Lcom/tencent/turingfd/sdk/xq/Coconut;)V
    //   653: astore 6
    //   655: aload 6
    //   657: aload_1
    //   658: arraylength
    //   659: i2l
    //   660: putfield 319	com/tencent/turingfd/sdk/xq/Codlin$do:Ch	J
    //   663: aload 6
    //   665: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   668: lload 4
    //   670: lsub
    //   671: putfield 322	com/tencent/turingfd/sdk/xq/Codlin$do:Dh	J
    //   674: aload 6
    //   676: iconst_1
    //   677: putfield 326	com/tencent/turingfd/sdk/xq/Codlin$do:Ah	Z
    //   680: aload 6
    //   682: iload_3
    //   683: putfield 329	com/tencent/turingfd/sdk/xq/Codlin$do:Bh	I
    //   686: new 331	com/tencent/turingfd/sdk/xq/Codlin
    //   689: dup
    //   690: aload 6
    //   692: invokespecial 334	com/tencent/turingfd/sdk/xq/Codlin:<init>	(Lcom/tencent/turingfd/sdk/xq/Codlin$do;)V
    //   695: astore_1
    //   696: aload_2
    //   697: getfield 339	com/tencent/turingfd/sdk/xq/long$do:nd	I
    //   700: istore_3
    //   701: iload_3
    //   702: ifeq +64 -> 766
    //   705: iload_3
    //   706: i2l
    //   707: ldc2_w 307
    //   710: lsub
    //   711: aload_1
    //   712: invokestatic 344	com/tencent/turingfd/sdk/xq/Chestnut:a	(JLcom/tencent/turingfd/sdk/xq/Codlin;)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   715: astore_1
    //   716: aload_0
    //   717: getfield 39	com/tencent/turingfd/sdk/xq/Cranberry:Yg	Lcom/tencent/turingfd/sdk/xq/void;
    //   720: invokevirtual 256	com/tencent/turingfd/sdk/xq/void:getContext	()Landroid/content/Context;
    //   723: aload_1
    //   724: getfield 348	com/tencent/turingfd/sdk/xq/Chestnut:zh	Lcom/tencent/turingfd/sdk/xq/Codlin;
    //   727: invokevirtual 351	com/tencent/turingfd/sdk/xq/Codlin:y	()Ljava/lang/String;
    //   730: invokestatic 354	com/tencent/turingfd/sdk/xq/Almond:g	(Landroid/content/Context;Ljava/lang/String;)V
    //   733: aload_1
    //   734: areturn
    //   735: astore 6
    //   737: iconst_0
    //   738: istore_3
    //   739: goto -544 -> 195
    //   742: astore_1
    //   743: ldc 98
    //   745: astore_1
    //   746: goto -357 -> 389
    //   749: new 356	java/lang/RuntimeException
    //   752: dup
    //   753: ldc_w 358
    //   756: invokespecial 361	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   759: athrow
    //   760: astore_1
    //   761: aconst_null
    //   762: astore_1
    //   763: goto -132 -> 631
    //   766: aload_2
    //   767: getfield 365	com/tencent/turingfd/sdk/xq/long$do:data	[B
    //   770: astore_2
    //   771: new 367	com/tencent/turingfd/sdk/xq/CanisMajor
    //   774: dup
    //   775: invokespecial 368	com/tencent/turingfd/sdk/xq/CanisMajor:<init>	()V
    //   778: astore 6
    //   780: aload 6
    //   782: aload_2
    //   783: invokestatic 371	com/tencent/turingfd/sdk/xq/this:a	(Lcom/tencent/turingfd/sdk/xq/case;[B)Lcom/tencent/turingfd/sdk/xq/case;
    //   786: astore_2
    //   787: aload_2
    //   788: ifnull +10 -> 798
    //   791: aload_2
    //   792: instanceof 367
    //   795: ifne +14 -> 809
    //   798: ldc2_w 372
    //   801: aload_1
    //   802: invokestatic 344	com/tencent/turingfd/sdk/xq/Chestnut:a	(JLcom/tencent/turingfd/sdk/xq/Codlin;)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   805: astore_1
    //   806: goto -90 -> 716
    //   809: aload_2
    //   810: checkcast 367	com/tencent/turingfd/sdk/xq/CanisMajor
    //   813: astore_2
    //   814: aload_2
    //   815: getfield 376	com/tencent/turingfd/sdk/xq/CanisMajor:R	I
    //   818: istore_3
    //   819: iload_3
    //   820: ifeq +17 -> 837
    //   823: iload_3
    //   824: i2l
    //   825: ldc2_w 377
    //   828: lsub
    //   829: aload_1
    //   830: invokestatic 344	com/tencent/turingfd/sdk/xq/Chestnut:a	(JLcom/tencent/turingfd/sdk/xq/Codlin;)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   833: astore_1
    //   834: goto -118 -> 716
    //   837: aload_2
    //   838: getfield 381	com/tencent/turingfd/sdk/xq/CanisMajor:pa	Ljava/util/Map;
    //   841: astore_2
    //   842: aload_2
    //   843: ifnull +12 -> 855
    //   846: aload_2
    //   847: invokeinterface 384 1 0
    //   852: ifne +14 -> 866
    //   855: ldc2_w 385
    //   858: aload_1
    //   859: invokestatic 344	com/tencent/turingfd/sdk/xq/Chestnut:a	(JLcom/tencent/turingfd/sdk/xq/Codlin;)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   862: astore_1
    //   863: goto -147 -> 716
    //   866: aload_2
    //   867: iconst_1
    //   868: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   871: invokeinterface 390 2 0
    //   876: ifne +14 -> 890
    //   879: ldc2_w 391
    //   882: aload_1
    //   883: invokestatic 344	com/tencent/turingfd/sdk/xq/Chestnut:a	(JLcom/tencent/turingfd/sdk/xq/Codlin;)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   886: astore_1
    //   887: goto -171 -> 716
    //   890: aload_2
    //   891: iconst_1
    //   892: invokestatic 66	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   895: invokeinterface 395 2 0
    //   900: checkcast 396	[B
    //   903: aload_1
    //   904: invokestatic 399	com/tencent/turingfd/sdk/xq/Chestnut:a	([BLcom/tencent/turingfd/sdk/xq/Codlin;)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   907: astore_1
    //   908: goto -192 -> 716
    //   911: astore_2
    //   912: ldc2_w 400
    //   915: aload_1
    //   916: invokestatic 344	com/tencent/turingfd/sdk/xq/Chestnut:a	(JLcom/tencent/turingfd/sdk/xq/Codlin;)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   919: astore_1
    //   920: goto -204 -> 716
    //   923: astore_1
    //   924: aload 6
    //   926: astore_1
    //   927: goto -190 -> 737
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	930	0	this	Cranberry
    //   0	930	1	paramArrayOfByte	byte[]
    //   0	930	2	paramString	String
    //   194	630	3	i	int
    //   634	35	4	l	long
    //   24	667	6	localObject1	Object
    //   735	1	6	localThrowable	java.lang.Throwable
    //   778	147	6	localCanisMajor	CanisMajor
    //   7	600	7	localCanesatici	Canesatici
    //   128	373	8	localObject2	Object
    //   134	337	9	localObject3	Object
    //   325	51	10	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   189	195	735	java/lang/Throwable
    //   375	389	742	java/lang/Throwable
    //   578	602	760	java/lang/Exception
    //   602	619	760	java/lang/Exception
    //   623	631	760	java/lang/Exception
    //   749	760	760	java/lang/Exception
    //   780	787	911	java/lang/Throwable
    //   170	189	923	java/lang/Throwable
  }
  
  /* Error */
  public final long.do a(byte[] paramArrayOfByte, long paramLong)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 33	java/lang/Object:<init>	()V
    //   7: astore 4
    //   9: new 405	java/util/concurrent/atomic/AtomicReference
    //   12: dup
    //   13: invokespecial 406	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   16: astore 5
    //   18: new 408	java/util/concurrent/atomic/AtomicBoolean
    //   21: dup
    //   22: iconst_0
    //   23: invokespecial 411	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   26: astore 6
    //   28: aload 5
    //   30: bipush 246
    //   32: iconst_0
    //   33: newarray byte
    //   35: invokestatic 414	com/tencent/turingfd/sdk/xq/long$do:a	(I[B)Lcom/tencent/turingfd/sdk/xq/long$do;
    //   38: invokevirtual 418	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   41: new 420	com/tencent/turingfd/sdk/xq/Core
    //   44: dup
    //   45: aload_0
    //   46: aload_1
    //   47: aload 6
    //   49: aload 5
    //   51: aload 4
    //   53: invokespecial 423	com/tencent/turingfd/sdk/xq/Core:<init>	(Lcom/tencent/turingfd/sdk/xq/Cranberry;[BLjava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   56: invokevirtual 428	java/lang/Thread:start	()V
    //   59: aload 4
    //   61: monitorenter
    //   62: aload 4
    //   64: lload_2
    //   65: invokevirtual 432	java/lang/Object:wait	(J)V
    //   68: aload 4
    //   70: monitorexit
    //   71: aload 6
    //   73: iconst_1
    //   74: invokevirtual 434	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   77: aload 5
    //   79: invokevirtual 437	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   82: checkcast 336	com/tencent/turingfd/sdk/xq/long$do
    //   85: areturn
    //   86: astore_1
    //   87: aload 4
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: goto -25 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	Cranberry
    //   0	96	1	paramArrayOfByte	byte[]
    //   0	96	2	paramLong	long
    //   7	81	4	localObject	Object
    //   16	62	5	localAtomicReference	java.util.concurrent.atomic.AtomicReference
    //   26	46	6	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    // Exception table:
    //   from	to	target	type
    //   62	68	86	finally
    //   68	71	86	finally
    //   87	90	86	finally
    //   62	68	92	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cranberry
 * JD-Core Version:    0.7.0.1
 */