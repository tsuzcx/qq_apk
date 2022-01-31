package com.tencent.tvkbeacon.core.b;

import android.content.Context;
import com.tencent.tvkbeacon.core.c.c;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

final class e$b
  extends e
{
  private int a = 30000;
  private int b = 3;
  private long c = 5000L;
  private Context d;
  
  public e$b(Context paramContext)
  {
    this.d = paramContext;
  }
  
  private static byte[] a(Socket paramSocket)
  {
    c.b("[net] begin waiting server response.", new Object[0]);
    paramSocket = paramSocket.getInputStream();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[2048];
    for (;;)
    {
      int i = paramSocket.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    c.b("[net] server response length: %d [need >= 4]", new Object[] { Integer.valueOf(arrayOfByte.length) });
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length - 4);
    localByteBuffer.put(arrayOfByte, 2, arrayOfByte.length - 4);
    arrayOfByte = localByteBuffer.array();
    localByteArrayOutputStream.close();
    paramSocket.close();
    return arrayOfByte;
  }
  
  public final boolean a()
  {
    return true;
  }
  
  /* Error */
  public final byte[] a(java.lang.String paramString, int paramInt, byte[] paramArrayOfByte, a parama, d paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: iload_2
    //   5: ifgt +14 -> 19
    //   8: ldc 100
    //   10: iconst_0
    //   11: anewarray 32	java/lang/Object
    //   14: invokestatic 102	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aconst_null
    //   18: areturn
    //   19: ldc 104
    //   21: iconst_3
    //   22: anewarray 32	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload 4
    //   29: getfield 107	com/tencent/tvkbeacon/core/b/a:a	I
    //   32: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload 4
    //   40: getfield 108	com/tencent/tvkbeacon/core/b/a:b	I
    //   43: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: dup
    //   48: iconst_2
    //   49: aload 4
    //   51: getfield 111	com/tencent/tvkbeacon/core/b/a:e	I
    //   54: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: ldc 113
    //   63: astore 12
    //   65: iconst_0
    //   66: istore 6
    //   68: iload 6
    //   70: iconst_1
    //   71: iadd
    //   72: istore 7
    //   74: iload 6
    //   76: iconst_3
    //   77: if_icmpge +1052 -> 1129
    //   80: iload 7
    //   82: iconst_1
    //   83: if_icmple +44 -> 127
    //   86: ldc 115
    //   88: iload 7
    //   90: invokestatic 120	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   93: invokevirtual 124	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   96: iconst_0
    //   97: anewarray 32	java/lang/Object
    //   100: invokestatic 127	com/tencent/tvkbeacon/core/c/c:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: iload 7
    //   105: iconst_2
    //   106: if_icmpne +18 -> 124
    //   109: aload 4
    //   111: invokevirtual 130	com/tencent/tvkbeacon/core/b/a:c	()I
    //   114: iconst_2
    //   115: if_icmpne +9 -> 124
    //   118: aload 4
    //   120: iconst_0
    //   121: invokevirtual 133	com/tencent/tvkbeacon/core/b/a:b	(Z)V
    //   124: invokestatic 135	com/tencent/tvkbeacon/core/b/e$b:b	()V
    //   127: aload_3
    //   128: ifnonnull +663 -> 791
    //   131: lconst_0
    //   132: lstore 8
    //   134: aload 5
    //   136: new 137	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   143: aload_1
    //   144: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 144
    //   149: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: iload_2
    //   153: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: lload 8
    //   161: aload_0
    //   162: getfield 26	com/tencent/tvkbeacon/core/b/e$b:d	Landroid/content/Context;
    //   165: invokestatic 156	com/tencent/tvkbeacon/core/c/d:c	(Landroid/content/Context;)Ljava/lang/String;
    //   168: iload 7
    //   170: invokeinterface 161 6 0
    //   175: new 163	java/util/Date
    //   178: dup
    //   179: invokespecial 164	java/util/Date:<init>	()V
    //   182: invokevirtual 168	java/util/Date:getTime	()J
    //   185: lstore 8
    //   187: aload_1
    //   188: invokestatic 174	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   191: astore 13
    //   193: ldc 176
    //   195: iconst_2
    //   196: anewarray 32	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload 13
    //   203: invokevirtual 179	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: iconst_1
    //   209: iload_2
    //   210: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aconst_null
    //   218: astore 14
    //   220: aconst_null
    //   221: astore 15
    //   223: new 39	java/net/Socket
    //   226: dup
    //   227: aload 13
    //   229: invokevirtual 179	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   232: iload_2
    //   233: invokespecial 182	java/net/Socket:<init>	(Ljava/lang/String;I)V
    //   236: astore 13
    //   238: aload 13
    //   240: astore 14
    //   242: aload 13
    //   244: sipush 30000
    //   247: invokevirtual 186	java/net/Socket:setSoTimeout	(I)V
    //   250: aload 13
    //   252: astore 14
    //   254: ldc 188
    //   256: iconst_3
    //   257: anewarray 32	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload 13
    //   264: invokevirtual 192	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   267: invokevirtual 195	java/net/InetAddress:getHostName	()Ljava/lang/String;
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: aload 13
    //   275: invokevirtual 198	java/net/Socket:getLocalPort	()I
    //   278: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: aload_3
    //   285: arraylength
    //   286: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload 13
    //   295: astore 14
    //   297: new 200	java/util/HashMap
    //   300: dup
    //   301: invokespecial 201	java/util/HashMap:<init>	()V
    //   304: astore 15
    //   306: aload 13
    //   308: astore 14
    //   310: aload 4
    //   312: invokevirtual 203	com/tencent/tvkbeacon/core/b/a:d	()Ljava/lang/String;
    //   315: astore 16
    //   317: aload 16
    //   319: ifnull +36 -> 355
    //   322: aload 13
    //   324: astore 14
    //   326: ldc 113
    //   328: aload 16
    //   330: invokevirtual 207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: ifne +22 -> 355
    //   336: aload 13
    //   338: astore 14
    //   340: aload 15
    //   342: ldc 209
    //   344: aload 4
    //   346: invokevirtual 203	com/tencent/tvkbeacon/core/b/a:d	()Ljava/lang/String;
    //   349: invokeinterface 214 3 0
    //   354: pop
    //   355: aload 13
    //   357: astore 14
    //   359: aload_0
    //   360: getfield 26	com/tencent/tvkbeacon/core/b/e$b:d	Landroid/content/Context;
    //   363: invokestatic 219	com/tencent/tvkbeacon/core/strategy/d:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/strategy/d;
    //   366: invokevirtual 221	com/tencent/tvkbeacon/core/strategy/d:a	()Ljava/lang/String;
    //   369: astore 16
    //   371: aload 16
    //   373: ifnull +33 -> 406
    //   376: aload 13
    //   378: astore 14
    //   380: ldc 113
    //   382: aload 16
    //   384: invokevirtual 207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   387: ifne +19 -> 406
    //   390: aload 13
    //   392: astore 14
    //   394: aload 15
    //   396: ldc 223
    //   398: aload 16
    //   400: invokeinterface 214 3 0
    //   405: pop
    //   406: aload 13
    //   408: astore 14
    //   410: aload 15
    //   412: ldc 225
    //   414: ldc 227
    //   416: invokeinterface 214 3 0
    //   421: pop
    //   422: aload 13
    //   424: astore 14
    //   426: aload 15
    //   428: ldc 229
    //   430: ldc 231
    //   432: invokeinterface 214 3 0
    //   437: pop
    //   438: aload 13
    //   440: astore 14
    //   442: aload 15
    //   444: ldc 233
    //   446: ldc 235
    //   448: invokeinterface 214 3 0
    //   453: pop
    //   454: aload 13
    //   456: astore 14
    //   458: aload_0
    //   459: getfield 26	com/tencent/tvkbeacon/core/b/e$b:d	Landroid/content/Context;
    //   462: invokestatic 219	com/tencent/tvkbeacon/core/strategy/d:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/strategy/d;
    //   465: astore 16
    //   467: aload 16
    //   469: ifnull +22 -> 491
    //   472: aload 13
    //   474: astore 14
    //   476: aload 15
    //   478: ldc 237
    //   480: aload 16
    //   482: invokevirtual 239	com/tencent/tvkbeacon/core/strategy/d:c	()Ljava/lang/String;
    //   485: invokeinterface 214 3 0
    //   490: pop
    //   491: aload 13
    //   493: astore 14
    //   495: new 241	com/tencent/tvkbeacon/core/protocol/common/SocketRequestPackage
    //   498: dup
    //   499: aload 15
    //   501: aload_3
    //   502: invokespecial 244	com/tencent/tvkbeacon/core/protocol/common/SocketRequestPackage:<init>	(Ljava/util/Map;[B)V
    //   505: astore 15
    //   507: aload 13
    //   509: astore 14
    //   511: new 246	com/tencent/tvkbeacon/core/wup/b
    //   514: dup
    //   515: invokespecial 247	com/tencent/tvkbeacon/core/wup/b:<init>	()V
    //   518: astore 16
    //   520: aload 13
    //   522: astore 14
    //   524: aload 15
    //   526: aload 16
    //   528: invokevirtual 251	com/tencent/tvkbeacon/core/protocol/common/SocketRequestPackage:writeTo	(Lcom/tencent/tvkbeacon/core/wup/b;)V
    //   531: aload 13
    //   533: astore 14
    //   535: aload 13
    //   537: invokevirtual 255	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   540: astore 15
    //   542: aload 13
    //   544: astore 14
    //   546: aload 16
    //   548: invokevirtual 257	com/tencent/tvkbeacon/core/wup/b:b	()[B
    //   551: astore 16
    //   553: aload 13
    //   555: astore 14
    //   557: aload 16
    //   559: arraylength
    //   560: istore 6
    //   562: aload 13
    //   564: astore 14
    //   566: ldc_w 259
    //   569: iconst_2
    //   570: anewarray 32	java/lang/Object
    //   573: dup
    //   574: iconst_0
    //   575: aload_3
    //   576: arraylength
    //   577: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   580: aastore
    //   581: dup
    //   582: iconst_1
    //   583: iload 6
    //   585: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   588: aastore
    //   589: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   592: aload 13
    //   594: astore 14
    //   596: iload 6
    //   598: iconst_4
    //   599: iadd
    //   600: invokestatic 77	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   603: astore 17
    //   605: aload 13
    //   607: astore 14
    //   609: aload 17
    //   611: getstatic 265	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   614: invokevirtual 269	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   617: pop
    //   618: aload 13
    //   620: astore 14
    //   622: aload 17
    //   624: iload 6
    //   626: iconst_4
    //   627: iadd
    //   628: i2s
    //   629: invokevirtual 273	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   632: pop
    //   633: aload 13
    //   635: astore 14
    //   637: aload 17
    //   639: aload 16
    //   641: invokevirtual 276	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   644: pop
    //   645: aload 13
    //   647: astore 14
    //   649: aload 17
    //   651: bipush 13
    //   653: invokevirtual 279	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   656: pop
    //   657: aload 13
    //   659: astore 14
    //   661: aload 17
    //   663: bipush 10
    //   665: invokevirtual 279	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
    //   668: pop
    //   669: iload 6
    //   671: ldc_w 280
    //   674: if_icmplt +17 -> 691
    //   677: aload 13
    //   679: astore 14
    //   681: ldc_w 282
    //   684: iconst_0
    //   685: anewarray 32	java/lang/Object
    //   688: invokestatic 102	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   691: aload 13
    //   693: astore 14
    //   695: aload 15
    //   697: aload 17
    //   699: invokevirtual 84	java/nio/ByteBuffer:array	()[B
    //   702: invokevirtual 287	java/io/OutputStream:write	([B)V
    //   705: aload 13
    //   707: astore 14
    //   709: aload 15
    //   711: invokevirtual 288	java/io/OutputStream:flush	()V
    //   714: aload 13
    //   716: astore 14
    //   718: aload 13
    //   720: invokestatic 290	com/tencent/tvkbeacon/core/b/e$b:a	(Ljava/net/Socket;)[B
    //   723: astore 15
    //   725: aload 15
    //   727: astore 14
    //   729: ldc_w 292
    //   732: iconst_0
    //   733: anewarray 32	java/lang/Object
    //   736: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   739: aload 13
    //   741: invokevirtual 293	java/net/Socket:close	()V
    //   744: aload 14
    //   746: astore 13
    //   748: aload 13
    //   750: ifnonnull +364 -> 1114
    //   753: iconst_0
    //   754: istore 6
    //   756: new 163	java/util/Date
    //   759: dup
    //   760: invokespecial 164	java/util/Date:<init>	()V
    //   763: invokevirtual 168	java/util/Date:getTime	()J
    //   766: lstore 10
    //   768: aload 5
    //   770: iload 6
    //   772: i2l
    //   773: lload 10
    //   775: lload 8
    //   777: lsub
    //   778: invokeinterface 296 5 0
    //   783: aload 13
    //   785: ifnull +337 -> 1122
    //   788: aload 13
    //   790: areturn
    //   791: aload_3
    //   792: arraylength
    //   793: i2l
    //   794: lstore 8
    //   796: goto -662 -> 134
    //   799: astore 13
    //   801: aload 14
    //   803: astore 13
    //   805: goto -57 -> 748
    //   808: astore 13
    //   810: aconst_null
    //   811: astore 15
    //   813: aload 15
    //   815: astore 14
    //   817: aload 5
    //   819: invokeinterface 298 1 0
    //   824: aload 15
    //   826: astore 14
    //   828: new 137	java/lang/StringBuilder
    //   831: dup
    //   832: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   835: aload 12
    //   837: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: iload 7
    //   842: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   845: ldc_w 300
    //   848: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: astore 13
    //   856: ldc_w 292
    //   859: iconst_0
    //   860: anewarray 32	java/lang/Object
    //   863: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   866: aload 13
    //   868: astore 12
    //   870: aload 15
    //   872: ifnull +306 -> 1178
    //   875: aload 15
    //   877: invokevirtual 293	java/net/Socket:close	()V
    //   880: aconst_null
    //   881: astore 14
    //   883: aload 13
    //   885: astore 12
    //   887: aload 14
    //   889: astore 13
    //   891: goto -143 -> 748
    //   894: astore 12
    //   896: aconst_null
    //   897: astore 14
    //   899: aload 13
    //   901: astore 12
    //   903: aload 14
    //   905: astore 13
    //   907: goto -159 -> 748
    //   910: astore 13
    //   912: aconst_null
    //   913: astore 15
    //   915: aload 15
    //   917: astore 14
    //   919: new 137	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   926: aload 12
    //   928: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: iload 7
    //   933: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   936: ldc_w 302
    //   939: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   945: astore 13
    //   947: ldc_w 292
    //   950: iconst_0
    //   951: anewarray 32	java/lang/Object
    //   954: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   957: aload 13
    //   959: astore 12
    //   961: aload 15
    //   963: ifnull +215 -> 1178
    //   966: aload 15
    //   968: invokevirtual 293	java/net/Socket:close	()V
    //   971: aconst_null
    //   972: astore 14
    //   974: aload 13
    //   976: astore 12
    //   978: aload 14
    //   980: astore 13
    //   982: goto -234 -> 748
    //   985: astore 12
    //   987: aconst_null
    //   988: astore 14
    //   990: aload 13
    //   992: astore 12
    //   994: aload 14
    //   996: astore 13
    //   998: goto -250 -> 748
    //   1001: astore 13
    //   1003: aload 15
    //   1005: astore 14
    //   1007: new 137	java/lang/StringBuilder
    //   1010: dup
    //   1011: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1014: aload 12
    //   1016: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc 144
    //   1021: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload 13
    //   1026: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1029: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1035: astore 13
    //   1037: ldc_w 292
    //   1040: iconst_0
    //   1041: anewarray 32	java/lang/Object
    //   1044: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1047: aload 13
    //   1049: astore 12
    //   1051: aload 15
    //   1053: ifnull +125 -> 1178
    //   1056: aload 15
    //   1058: invokevirtual 293	java/net/Socket:close	()V
    //   1061: aconst_null
    //   1062: astore 14
    //   1064: aload 13
    //   1066: astore 12
    //   1068: aload 14
    //   1070: astore 13
    //   1072: goto -324 -> 748
    //   1075: astore 12
    //   1077: aconst_null
    //   1078: astore 14
    //   1080: aload 13
    //   1082: astore 12
    //   1084: aload 14
    //   1086: astore 13
    //   1088: goto -340 -> 748
    //   1091: astore_1
    //   1092: ldc_w 292
    //   1095: iconst_0
    //   1096: anewarray 32	java/lang/Object
    //   1099: invokestatic 37	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1102: aload 14
    //   1104: ifnull +8 -> 1112
    //   1107: aload 14
    //   1109: invokevirtual 293	java/net/Socket:close	()V
    //   1112: aload_1
    //   1113: athrow
    //   1114: aload 13
    //   1116: arraylength
    //   1117: istore 6
    //   1119: goto -363 -> 756
    //   1122: iload 7
    //   1124: istore 6
    //   1126: goto -1058 -> 68
    //   1129: new 94	java/net/ConnectException
    //   1132: dup
    //   1133: aload 12
    //   1135: invokespecial 308	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   1138: athrow
    //   1139: astore_3
    //   1140: goto -28 -> 1112
    //   1143: astore_1
    //   1144: goto -52 -> 1092
    //   1147: astore 14
    //   1149: aload 13
    //   1151: astore 15
    //   1153: aload 14
    //   1155: astore 13
    //   1157: goto -154 -> 1003
    //   1160: astore 14
    //   1162: aload 13
    //   1164: astore 15
    //   1166: goto -251 -> 915
    //   1169: astore 14
    //   1171: aload 13
    //   1173: astore 15
    //   1175: goto -362 -> 813
    //   1178: aconst_null
    //   1179: astore 13
    //   1181: goto -433 -> 748
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1184	0	this	b
    //   0	1184	1	paramString	java.lang.String
    //   0	1184	2	paramInt	int
    //   0	1184	3	paramArrayOfByte	byte[]
    //   0	1184	4	parama	a
    //   0	1184	5	paramd	d
    //   66	1059	6	i	int
    //   72	1051	7	j	int
    //   132	663	8	l1	long
    //   766	8	10	l2	long
    //   63	823	12	localObject1	Object
    //   894	1	12	localIOException1	java.io.IOException
    //   901	76	12	localObject2	Object
    //   985	1	12	localIOException2	java.io.IOException
    //   992	75	12	localObject3	Object
    //   1075	1	12	localIOException3	java.io.IOException
    //   1082	52	12	localObject4	Object
    //   191	598	13	localObject5	Object
    //   799	1	13	localIOException4	java.io.IOException
    //   803	1	13	localObject6	Object
    //   808	1	13	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   854	52	13	localObject7	Object
    //   910	1	13	localConnectException1	java.net.ConnectException
    //   945	52	13	localObject8	Object
    //   1001	24	13	localException1	java.lang.Exception
    //   1035	145	13	localObject9	Object
    //   218	890	14	localObject10	Object
    //   1147	7	14	localException2	java.lang.Exception
    //   1160	1	14	localConnectException2	java.net.ConnectException
    //   1169	1	14	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   221	953	15	localObject11	Object
    //   315	325	16	localObject12	Object
    //   603	95	17	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   739	744	799	java/io/IOException
    //   223	238	808	java/net/SocketTimeoutException
    //   875	880	894	java/io/IOException
    //   223	238	910	java/net/ConnectException
    //   966	971	985	java/io/IOException
    //   223	238	1001	java/lang/Exception
    //   1056	1061	1075	java/io/IOException
    //   223	238	1091	finally
    //   1007	1037	1091	finally
    //   1107	1112	1139	java/io/IOException
    //   242	250	1143	finally
    //   254	293	1143	finally
    //   297	306	1143	finally
    //   310	317	1143	finally
    //   326	336	1143	finally
    //   340	355	1143	finally
    //   359	371	1143	finally
    //   380	390	1143	finally
    //   394	406	1143	finally
    //   410	422	1143	finally
    //   426	438	1143	finally
    //   442	454	1143	finally
    //   458	467	1143	finally
    //   476	491	1143	finally
    //   495	507	1143	finally
    //   511	520	1143	finally
    //   524	531	1143	finally
    //   535	542	1143	finally
    //   546	553	1143	finally
    //   557	562	1143	finally
    //   566	592	1143	finally
    //   596	605	1143	finally
    //   609	618	1143	finally
    //   622	633	1143	finally
    //   637	645	1143	finally
    //   649	657	1143	finally
    //   661	669	1143	finally
    //   681	691	1143	finally
    //   695	705	1143	finally
    //   709	714	1143	finally
    //   718	725	1143	finally
    //   817	824	1143	finally
    //   828	856	1143	finally
    //   919	947	1143	finally
    //   242	250	1147	java/lang/Exception
    //   254	293	1147	java/lang/Exception
    //   297	306	1147	java/lang/Exception
    //   310	317	1147	java/lang/Exception
    //   326	336	1147	java/lang/Exception
    //   340	355	1147	java/lang/Exception
    //   359	371	1147	java/lang/Exception
    //   380	390	1147	java/lang/Exception
    //   394	406	1147	java/lang/Exception
    //   410	422	1147	java/lang/Exception
    //   426	438	1147	java/lang/Exception
    //   442	454	1147	java/lang/Exception
    //   458	467	1147	java/lang/Exception
    //   476	491	1147	java/lang/Exception
    //   495	507	1147	java/lang/Exception
    //   511	520	1147	java/lang/Exception
    //   524	531	1147	java/lang/Exception
    //   535	542	1147	java/lang/Exception
    //   546	553	1147	java/lang/Exception
    //   557	562	1147	java/lang/Exception
    //   566	592	1147	java/lang/Exception
    //   596	605	1147	java/lang/Exception
    //   609	618	1147	java/lang/Exception
    //   622	633	1147	java/lang/Exception
    //   637	645	1147	java/lang/Exception
    //   649	657	1147	java/lang/Exception
    //   661	669	1147	java/lang/Exception
    //   681	691	1147	java/lang/Exception
    //   695	705	1147	java/lang/Exception
    //   709	714	1147	java/lang/Exception
    //   718	725	1147	java/lang/Exception
    //   242	250	1160	java/net/ConnectException
    //   254	293	1160	java/net/ConnectException
    //   297	306	1160	java/net/ConnectException
    //   310	317	1160	java/net/ConnectException
    //   326	336	1160	java/net/ConnectException
    //   340	355	1160	java/net/ConnectException
    //   359	371	1160	java/net/ConnectException
    //   380	390	1160	java/net/ConnectException
    //   394	406	1160	java/net/ConnectException
    //   410	422	1160	java/net/ConnectException
    //   426	438	1160	java/net/ConnectException
    //   442	454	1160	java/net/ConnectException
    //   458	467	1160	java/net/ConnectException
    //   476	491	1160	java/net/ConnectException
    //   495	507	1160	java/net/ConnectException
    //   511	520	1160	java/net/ConnectException
    //   524	531	1160	java/net/ConnectException
    //   535	542	1160	java/net/ConnectException
    //   546	553	1160	java/net/ConnectException
    //   557	562	1160	java/net/ConnectException
    //   566	592	1160	java/net/ConnectException
    //   596	605	1160	java/net/ConnectException
    //   609	618	1160	java/net/ConnectException
    //   622	633	1160	java/net/ConnectException
    //   637	645	1160	java/net/ConnectException
    //   649	657	1160	java/net/ConnectException
    //   661	669	1160	java/net/ConnectException
    //   681	691	1160	java/net/ConnectException
    //   695	705	1160	java/net/ConnectException
    //   709	714	1160	java/net/ConnectException
    //   718	725	1160	java/net/ConnectException
    //   242	250	1169	java/net/SocketTimeoutException
    //   254	293	1169	java/net/SocketTimeoutException
    //   297	306	1169	java/net/SocketTimeoutException
    //   310	317	1169	java/net/SocketTimeoutException
    //   326	336	1169	java/net/SocketTimeoutException
    //   340	355	1169	java/net/SocketTimeoutException
    //   359	371	1169	java/net/SocketTimeoutException
    //   380	390	1169	java/net/SocketTimeoutException
    //   394	406	1169	java/net/SocketTimeoutException
    //   410	422	1169	java/net/SocketTimeoutException
    //   426	438	1169	java/net/SocketTimeoutException
    //   442	454	1169	java/net/SocketTimeoutException
    //   458	467	1169	java/net/SocketTimeoutException
    //   476	491	1169	java/net/SocketTimeoutException
    //   495	507	1169	java/net/SocketTimeoutException
    //   511	520	1169	java/net/SocketTimeoutException
    //   524	531	1169	java/net/SocketTimeoutException
    //   535	542	1169	java/net/SocketTimeoutException
    //   546	553	1169	java/net/SocketTimeoutException
    //   557	562	1169	java/net/SocketTimeoutException
    //   566	592	1169	java/net/SocketTimeoutException
    //   596	605	1169	java/net/SocketTimeoutException
    //   609	618	1169	java/net/SocketTimeoutException
    //   622	633	1169	java/net/SocketTimeoutException
    //   637	645	1169	java/net/SocketTimeoutException
    //   649	657	1169	java/net/SocketTimeoutException
    //   661	669	1169	java/net/SocketTimeoutException
    //   681	691	1169	java/net/SocketTimeoutException
    //   695	705	1169	java/net/SocketTimeoutException
    //   709	714	1169	java/net/SocketTimeoutException
    //   718	725	1169	java/net/SocketTimeoutException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.b.e.b
 * JD-Core Version:    0.7.0.1
 */