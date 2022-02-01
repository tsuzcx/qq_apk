package oicq.wlogin_sdk.a;

public class b
  extends c
{
  public b()
  {
    this.b = 17;
  }
  
  /* Error */
  public byte[] a(long paramLong, int paramInt1, byte paramByte1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10)
  {
    // Byte code:
    //   0: aload 16
    //   2: ifnull +984 -> 986
    //   5: aload 16
    //   7: arraylength
    //   8: ifne +6 -> 14
    //   11: goto +975 -> 986
    //   14: bipush 13
    //   16: newarray int
    //   18: astore 26
    //   20: aload 26
    //   22: dup
    //   23: iconst_0
    //   24: iconst_2
    //   25: iastore
    //   26: dup
    //   27: iconst_1
    //   28: iconst_3
    //   29: iastore
    //   30: dup
    //   31: iconst_2
    //   32: bipush 6
    //   34: iastore
    //   35: dup
    //   36: iconst_3
    //   37: bipush 10
    //   39: iastore
    //   40: dup
    //   41: iconst_4
    //   42: bipush 13
    //   44: iastore
    //   45: dup
    //   46: iconst_5
    //   47: bipush 14
    //   49: iastore
    //   50: dup
    //   51: bipush 6
    //   53: bipush 18
    //   55: iastore
    //   56: dup
    //   57: bipush 7
    //   59: bipush 19
    //   61: iastore
    //   62: dup
    //   63: bipush 8
    //   65: bipush 20
    //   67: iastore
    //   68: dup
    //   69: bipush 9
    //   71: bipush 23
    //   73: iastore
    //   74: dup
    //   75: bipush 10
    //   77: bipush 24
    //   79: iastore
    //   80: dup
    //   81: bipush 11
    //   83: bipush 32
    //   85: iastore
    //   86: dup
    //   87: bipush 12
    //   89: bipush 37
    //   91: iastore
    //   92: pop
    //   93: new 19	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 20	java/util/ArrayList:<init>	()V
    //   100: astore 25
    //   102: aload 26
    //   104: arraylength
    //   105: istore 22
    //   107: iconst_0
    //   108: istore 17
    //   110: iconst_0
    //   111: istore 18
    //   113: iconst_0
    //   114: istore 19
    //   116: aload 12
    //   118: astore 24
    //   120: aload 8
    //   122: astore 23
    //   124: iload 18
    //   126: iload 22
    //   128: if_icmpge +554 -> 682
    //   131: aload 26
    //   133: iload 18
    //   135: iaload
    //   136: istore 20
    //   138: iload 20
    //   140: iconst_2
    //   141: if_icmpeq +464 -> 605
    //   144: iload 20
    //   146: iconst_3
    //   147: if_icmpeq +431 -> 578
    //   150: iload 20
    //   152: bipush 6
    //   154: if_icmpeq +393 -> 547
    //   157: iload 20
    //   159: bipush 10
    //   161: if_icmpeq +355 -> 516
    //   164: iload 20
    //   166: bipush 32
    //   168: if_icmpeq +317 -> 485
    //   171: iload 20
    //   173: bipush 37
    //   175: if_icmpeq +281 -> 456
    //   178: iload 20
    //   180: bipush 13
    //   182: if_icmpeq +246 -> 428
    //   185: iload 20
    //   187: bipush 14
    //   189: if_icmpeq +208 -> 397
    //   192: iload 20
    //   194: bipush 23
    //   196: if_icmpeq +174 -> 370
    //   199: iload 20
    //   201: bipush 24
    //   203: if_icmpeq +134 -> 337
    //   206: iload 20
    //   208: tableswitch	default:+28 -> 236, 18:+98->306, 19:+67->275, 20:+36->244
    //   237: newarray byte
    //   239: astore 23
    //   241: goto +387 -> 628
    //   244: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   247: dup
    //   248: bipush 20
    //   250: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   253: astore 23
    //   255: aload 23
    //   257: aload 14
    //   259: aload 14
    //   261: arraylength
    //   262: invokevirtual 29	oicq/wlogin_sdk/tlv_type/RegTLV:setData	([BI)V
    //   265: aload 23
    //   267: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   270: astore 23
    //   272: goto +153 -> 425
    //   275: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   278: dup
    //   279: bipush 19
    //   281: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   284: astore 23
    //   286: aload 23
    //   288: aload 13
    //   290: aload 13
    //   292: arraylength
    //   293: invokevirtual 29	oicq/wlogin_sdk/tlv_type/RegTLV:setData	([BI)V
    //   296: aload 23
    //   298: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   301: astore 23
    //   303: goto +122 -> 425
    //   306: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   309: dup
    //   310: bipush 18
    //   312: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   315: astore 23
    //   317: aload 23
    //   319: aload 24
    //   321: aload 24
    //   323: arraylength
    //   324: invokevirtual 29	oicq/wlogin_sdk/tlv_type/RegTLV:setData	([BI)V
    //   327: aload 23
    //   329: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   332: astore 23
    //   334: goto +91 -> 425
    //   337: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   340: dup
    //   341: bipush 24
    //   343: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   346: astore 23
    //   348: aload 23
    //   350: getstatic 39	oicq/wlogin_sdk/request/t:K	[B
    //   353: getstatic 39	oicq/wlogin_sdk/request/t:K	[B
    //   356: arraylength
    //   357: invokevirtual 29	oicq/wlogin_sdk/tlv_type/RegTLV:setData	([BI)V
    //   360: aload 23
    //   362: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   365: astore 23
    //   367: goto +58 -> 425
    //   370: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   373: dup
    //   374: bipush 23
    //   376: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   379: astore 23
    //   381: aload 23
    //   383: iconst_5
    //   384: invokevirtual 43	oicq/wlogin_sdk/tlv_type/RegTLV:setByte	(B)V
    //   387: aload 23
    //   389: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   392: astore 23
    //   394: goto +31 -> 425
    //   397: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   400: dup
    //   401: bipush 14
    //   403: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   406: astore 23
    //   408: aload 23
    //   410: aload 11
    //   412: aload 11
    //   414: arraylength
    //   415: invokevirtual 29	oicq/wlogin_sdk/tlv_type/RegTLV:setData	([BI)V
    //   418: aload 23
    //   420: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   423: astore 23
    //   425: goto +203 -> 628
    //   428: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   431: dup
    //   432: bipush 13
    //   434: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   437: astore 23
    //   439: aload 23
    //   441: iload 10
    //   443: invokevirtual 46	oicq/wlogin_sdk/tlv_type/RegTLV:setInt	(I)V
    //   446: aload 23
    //   448: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   451: astore 23
    //   453: goto +175 -> 628
    //   456: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   459: dup
    //   460: bipush 37
    //   462: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   465: astore 23
    //   467: aload 23
    //   469: getstatic 49	oicq/wlogin_sdk/request/t:aA	I
    //   472: invokevirtual 52	oicq/wlogin_sdk/tlv_type/RegTLV:setShort	(I)V
    //   475: aload 23
    //   477: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   480: astore 23
    //   482: goto +146 -> 628
    //   485: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   488: dup
    //   489: bipush 32
    //   491: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   494: astore 23
    //   496: aload 23
    //   498: aload 15
    //   500: aload 15
    //   502: arraylength
    //   503: invokevirtual 29	oicq/wlogin_sdk/tlv_type/RegTLV:setData	([BI)V
    //   506: aload 23
    //   508: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   511: astore 23
    //   513: goto +115 -> 628
    //   516: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   519: dup
    //   520: bipush 10
    //   522: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   525: astore 23
    //   527: aload 23
    //   529: aload 9
    //   531: aload 9
    //   533: arraylength
    //   534: invokevirtual 29	oicq/wlogin_sdk/tlv_type/RegTLV:setData	([BI)V
    //   537: aload 23
    //   539: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   542: astore 23
    //   544: goto +84 -> 628
    //   547: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   550: dup
    //   551: bipush 6
    //   553: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   556: astore 24
    //   558: aload 24
    //   560: aload 23
    //   562: aload 23
    //   564: arraylength
    //   565: invokevirtual 29	oicq/wlogin_sdk/tlv_type/RegTLV:setData	([BI)V
    //   568: aload 24
    //   570: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   573: astore 23
    //   575: goto +53 -> 628
    //   578: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   581: dup
    //   582: iconst_3
    //   583: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   586: astore 23
    //   588: aload 23
    //   590: iload 7
    //   592: invokevirtual 43	oicq/wlogin_sdk/tlv_type/RegTLV:setByte	(B)V
    //   595: aload 23
    //   597: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   600: astore 23
    //   602: goto +26 -> 628
    //   605: new 22	oicq/wlogin_sdk/tlv_type/RegTLV
    //   608: dup
    //   609: iconst_2
    //   610: invokespecial 25	oicq/wlogin_sdk/tlv_type/RegTLV:<init>	(I)V
    //   613: astore 23
    //   615: aload 23
    //   617: iload_3
    //   618: invokevirtual 46	oicq/wlogin_sdk/tlv_type/RegTLV:setInt	(I)V
    //   621: aload 23
    //   623: invokevirtual 33	oicq/wlogin_sdk/tlv_type/RegTLV:getBuf	()[B
    //   626: astore 23
    //   628: iload 17
    //   630: istore 21
    //   632: iload 19
    //   634: istore 20
    //   636: aload 23
    //   638: arraylength
    //   639: iconst_4
    //   640: if_icmple +25 -> 665
    //   643: iload 17
    //   645: iconst_1
    //   646: iadd
    //   647: istore 21
    //   649: iload 19
    //   651: aload 23
    //   653: arraylength
    //   654: iadd
    //   655: istore 20
    //   657: aload 25
    //   659: aload 23
    //   661: invokevirtual 56	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   664: pop
    //   665: iload 18
    //   667: iconst_1
    //   668: iadd
    //   669: istore 18
    //   671: iload 21
    //   673: istore 17
    //   675: iload 20
    //   677: istore 19
    //   679: goto -563 -> 116
    //   682: iload 19
    //   684: iconst_2
    //   685: iadd
    //   686: newarray byte
    //   688: astore 8
    //   690: aload 8
    //   692: iconst_0
    //   693: iload 17
    //   695: invokestatic 62	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   698: iconst_0
    //   699: istore 10
    //   701: iconst_2
    //   702: istore 18
    //   704: iload 10
    //   706: iload 17
    //   708: if_icmpge +45 -> 753
    //   711: aload 25
    //   713: iload 10
    //   715: invokevirtual 66	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   718: checkcast 67	[B
    //   721: astore 9
    //   723: aload 9
    //   725: iconst_0
    //   726: aload 8
    //   728: iload 18
    //   730: aload 9
    //   732: arraylength
    //   733: invokestatic 73	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   736: iload 18
    //   738: aload 9
    //   740: arraylength
    //   741: iadd
    //   742: istore 18
    //   744: iload 10
    //   746: iconst_1
    //   747: iadd
    //   748: istore 10
    //   750: goto -46 -> 704
    //   753: new 75	java/io/ByteArrayOutputStream
    //   756: dup
    //   757: invokespecial 76	java/io/ByteArrayOutputStream:<init>	()V
    //   760: astore 9
    //   762: new 78	java/io/DataOutputStream
    //   765: dup
    //   766: aload 9
    //   768: invokespecial 81	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   771: astore 11
    //   773: aload 11
    //   775: aload 16
    //   777: arraylength
    //   778: invokevirtual 84	java/io/DataOutputStream:writeByte	(I)V
    //   781: aload 11
    //   783: aload 16
    //   785: invokevirtual 88	java/io/DataOutputStream:write	([B)V
    //   788: aload 11
    //   790: iconst_1
    //   791: invokevirtual 84	java/io/DataOutputStream:writeByte	(I)V
    //   794: aload 11
    //   796: lload_1
    //   797: invokevirtual 92	java/io/DataOutputStream:writeLong	(J)V
    //   800: aload 11
    //   802: iload_3
    //   803: invokevirtual 95	java/io/DataOutputStream:writeInt	(I)V
    //   806: aload 11
    //   808: iload 4
    //   810: invokevirtual 84	java/io/DataOutputStream:writeByte	(I)V
    //   813: aload 11
    //   815: aload 5
    //   817: arraylength
    //   818: invokevirtual 98	java/io/DataOutputStream:writeShort	(I)V
    //   821: aload 11
    //   823: aload 5
    //   825: invokevirtual 88	java/io/DataOutputStream:write	([B)V
    //   828: aload 8
    //   830: iconst_0
    //   831: aload 8
    //   833: arraylength
    //   834: aload 6
    //   836: invokestatic 104	oicq/wlogin_sdk/tools/cryptor:encrypt	([BII[B)[B
    //   839: astore 5
    //   841: aload 5
    //   843: ifnonnull +12 -> 855
    //   846: ldc 106
    //   848: ldc 108
    //   850: invokestatic 112	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   853: aconst_null
    //   854: areturn
    //   855: aload 11
    //   857: aload 5
    //   859: arraylength
    //   860: invokevirtual 98	java/io/DataOutputStream:writeShort	(I)V
    //   863: aload 11
    //   865: aload 5
    //   867: invokevirtual 88	java/io/DataOutputStream:write	([B)V
    //   870: aload 9
    //   872: invokevirtual 115	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   875: astore 5
    //   877: aload 11
    //   879: invokevirtual 118	java/io/DataOutputStream:close	()V
    //   882: aload 9
    //   884: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   887: aload_0
    //   888: aload 5
    //   890: invokevirtual 122	oicq/wlogin_sdk/a/b:a	([B)[B
    //   893: astore 5
    //   895: aload 5
    //   897: areturn
    //   898: astore 5
    //   900: goto +15 -> 915
    //   903: astore 5
    //   905: goto +10 -> 915
    //   908: astore 5
    //   910: goto +5 -> 915
    //   913: astore 5
    //   915: new 124	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   922: astore 6
    //   924: aload 6
    //   926: ldc 127
    //   928: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload 6
    //   934: aload 5
    //   936: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   939: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload 6
    //   945: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: astore 5
    //   950: new 124	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   957: astore 6
    //   959: aload 6
    //   961: ldc 108
    //   963: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: aload 6
    //   969: lload_1
    //   970: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 5
    //   976: aload 6
    //   978: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: invokestatic 112	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   984: aconst_null
    //   985: areturn
    //   986: ldc 143
    //   988: ldc 108
    //   990: invokestatic 112	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   993: aconst_null
    //   994: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	995	0	this	b
    //   0	995	1	paramLong	long
    //   0	995	3	paramInt1	int
    //   0	995	4	paramByte1	byte
    //   0	995	5	paramArrayOfByte1	byte[]
    //   0	995	6	paramArrayOfByte2	byte[]
    //   0	995	7	paramByte2	byte
    //   0	995	8	paramArrayOfByte3	byte[]
    //   0	995	9	paramArrayOfByte4	byte[]
    //   0	995	10	paramInt2	int
    //   0	995	11	paramArrayOfByte5	byte[]
    //   0	995	12	paramArrayOfByte6	byte[]
    //   0	995	13	paramArrayOfByte7	byte[]
    //   0	995	14	paramArrayOfByte8	byte[]
    //   0	995	15	paramArrayOfByte9	byte[]
    //   0	995	16	paramArrayOfByte10	byte[]
    //   108	601	17	i	int
    //   111	632	18	j	int
    //   114	572	19	k	int
    //   136	540	20	m	int
    //   630	42	21	n	int
    //   105	24	22	i1	int
    //   122	538	23	localObject1	java.lang.Object
    //   118	451	24	localObject2	java.lang.Object
    //   100	612	25	localArrayList	java.util.ArrayList
    //   18	114	26	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   887	895	898	java/lang/Exception
    //   846	853	903	java/lang/Exception
    //   855	887	903	java/lang/Exception
    //   794	841	908	java/lang/Exception
    //   773	794	913	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */