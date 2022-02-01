package com.tencent.turingfd.sdk.xq;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.TimeUnit;

public class CanisMinor
{
  public static CanisMinor a = new CanisMinor();
  public static int[] b = { 0, 5, 10, 30, 60, 120, 180, 240, 420, 660, 1080, 1800 };
  public static long c = TimeUnit.MINUTES.toMillis(5L);
  public Handler d;
  public final byte[] e = new byte[0];
  public String f;
  public int g;
  
  public CanisMinor()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IAS_61_");
    localStringBuilder.append(native.a);
    localStringBuilder.append("_");
    localStringBuilder.append("xqMini");
    this.f = localStringBuilder.toString();
    this.g = 3;
  }
  
  /* Error */
  public final CanisMinor.do a(java.util.Map<java.lang.Integer, Caelum> paramMap, android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 81	com/tencent/turingfd/sdk/xq/CanisMinor:a	()Lcom/tencent/turingfd/sdk/xq/Centaurus;
    //   4: aload_2
    //   5: invokevirtual 86	com/tencent/turingfd/sdk/xq/Centaurus:a	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/synchronized;
    //   8: astore 13
    //   10: aload 13
    //   12: getfield 91	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   15: invokevirtual 97	java/util/LinkedList:size	()I
    //   18: istore 4
    //   20: iconst_1
    //   21: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: astore 14
    //   26: iload 4
    //   28: ifne +6 -> 34
    //   31: goto +240 -> 271
    //   34: aload_0
    //   35: invokevirtual 81	com/tencent/turingfd/sdk/xq/CanisMinor:a	()Lcom/tencent/turingfd/sdk/xq/Centaurus;
    //   38: pop
    //   39: aload_2
    //   40: ldc 105
    //   42: invokestatic 108	com/tencent/turingfd/sdk/xq/Centaurus:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 15
    //   47: aload 15
    //   49: invokestatic 113	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   52: invokevirtual 117	java/lang/Long:longValue	()J
    //   55: lstore 7
    //   57: goto +6 -> 63
    //   60: lconst_0
    //   61: lstore 7
    //   63: lload 7
    //   65: lconst_0
    //   66: lcmp
    //   67: ifgt +6 -> 73
    //   70: goto +135 -> 205
    //   73: aload 13
    //   75: getfield 91	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   78: invokevirtual 121	java/util/LinkedList:getLast	()Ljava/lang/Object;
    //   81: checkcast 110	java/lang/Long
    //   84: invokevirtual 117	java/lang/Long:longValue	()J
    //   87: lstore 9
    //   89: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   92: lload 9
    //   94: lsub
    //   95: invokestatic 131	java/lang/Math:abs	(J)J
    //   98: lstore 9
    //   100: getstatic 27	com/tencent/turingfd/sdk/xq/CanisMinor:b	[I
    //   103: astore 15
    //   105: lload 7
    //   107: aload 15
    //   109: arraylength
    //   110: i2l
    //   111: lcmp
    //   112: ifge +11 -> 123
    //   115: lload 7
    //   117: l2i
    //   118: istore 4
    //   120: goto +10 -> 130
    //   123: aload 15
    //   125: arraylength
    //   126: iconst_1
    //   127: isub
    //   128: istore 4
    //   130: iload 4
    //   132: iconst_1
    //   133: if_icmpge +6 -> 139
    //   136: goto +69 -> 205
    //   139: aload 15
    //   141: iload 4
    //   143: iconst_1
    //   144: isub
    //   145: iaload
    //   146: istore 5
    //   148: aload 15
    //   150: iload 4
    //   152: iaload
    //   153: istore 4
    //   155: iload 5
    //   157: iload 4
    //   159: if_icmpge +4047 -> 4206
    //   162: new 133	java/util/Random
    //   165: dup
    //   166: invokespecial 134	java/util/Random:<init>	()V
    //   169: iload 4
    //   171: iload 5
    //   173: isub
    //   174: iconst_1
    //   175: iadd
    //   176: invokevirtual 138	java/util/Random:nextInt	(I)I
    //   179: istore 4
    //   181: lload 9
    //   183: getstatic 141	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   186: iload 4
    //   188: iload 5
    //   190: iadd
    //   191: i2l
    //   192: invokevirtual 39	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   195: lcmp
    //   196: ifgt +9 -> 205
    //   199: iconst_0
    //   200: istore 4
    //   202: goto +6 -> 208
    //   205: iconst_1
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +10 -> 220
    //   213: iload_3
    //   214: ifeq +63 -> 277
    //   217: goto +54 -> 271
    //   220: aload 13
    //   222: getfield 91	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   225: invokevirtual 144	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   228: checkcast 110	java/lang/Long
    //   231: astore 15
    //   233: aload 13
    //   235: getfield 91	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   238: invokevirtual 97	java/util/LinkedList:size	()I
    //   241: aload 13
    //   243: getfield 145	com/tencent/turingfd/sdk/xq/synchronized:a	I
    //   246: if_icmpge +6 -> 252
    //   249: goto +22 -> 271
    //   252: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   255: aload 15
    //   257: invokevirtual 117	java/lang/Long:longValue	()J
    //   260: lsub
    //   261: invokestatic 131	java/lang/Math:abs	(J)J
    //   264: getstatic 41	com/tencent/turingfd/sdk/xq/CanisMinor:c	J
    //   267: lcmp
    //   268: iflt +9 -> 277
    //   271: iconst_1
    //   272: istore 4
    //   274: goto +6 -> 280
    //   277: iconst_0
    //   278: istore 4
    //   280: iload 4
    //   282: ifne +97 -> 379
    //   285: new 47	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   292: astore_1
    //   293: aload_1
    //   294: ldc2_w 146
    //   297: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_1
    //   302: ldc 63
    //   304: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_1
    //   309: lconst_0
    //   310: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_1
    //   315: ldc 63
    //   317: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_1
    //   322: lconst_0
    //   323: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_1
    //   328: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: astore_1
    //   332: getstatic 154	com/tencent/turingfd/sdk/xq/Date:a	Ljava/lang/String;
    //   335: astore 13
    //   337: new 156	java/util/HashMap
    //   340: dup
    //   341: invokespecial 157	java/util/HashMap:<init>	()V
    //   344: astore 13
    //   346: aload 13
    //   348: ldc 159
    //   350: aload_1
    //   351: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   354: pop
    //   355: aload_2
    //   356: aload 13
    //   358: invokestatic 166	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   361: new 168	com/tencent/turingfd/sdk/xq/CanisMinor$do
    //   364: dup
    //   365: ldc2_w 146
    //   368: new 156	java/util/HashMap
    //   371: dup
    //   372: invokespecial 157	java/util/HashMap:<init>	()V
    //   375: invokespecial 171	com/tencent/turingfd/sdk/xq/CanisMinor$do:<init>	(JLjava/util/Map;)V
    //   378: areturn
    //   379: new 156	java/util/HashMap
    //   382: dup
    //   383: invokespecial 157	java/util/HashMap:<init>	()V
    //   386: astore 13
    //   388: new 173	com/tencent/turingfd/sdk/xq/Cepheus
    //   391: dup
    //   392: aload_1
    //   393: aload 13
    //   395: invokespecial 176	com/tencent/turingfd/sdk/xq/Cepheus:<init>	(Ljava/util/Map;Ljava/util/Map;)V
    //   398: astore 20
    //   400: aload 20
    //   402: aload_2
    //   403: putfield 179	com/tencent/turingfd/sdk/xq/Cepheus:d	Landroid/content/Context;
    //   406: ldc2_w 180
    //   409: lstore 11
    //   411: aload_1
    //   412: ifnull +940 -> 1352
    //   415: aload_1
    //   416: invokeinterface 184 1 0
    //   421: ifne +6 -> 427
    //   424: goto +928 -> 1352
    //   427: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   430: lstore 7
    //   432: new 186	com/tencent/turingfd/sdk/xq/Scorpius
    //   435: dup
    //   436: invokespecial 187	com/tencent/turingfd/sdk/xq/Scorpius:<init>	()V
    //   439: astore 17
    //   441: ldc 189
    //   443: monitorenter
    //   444: getstatic 191	com/tencent/turingfd/sdk/xq/const:a	Landroid/content/Context;
    //   447: astore 16
    //   449: ldc 189
    //   451: monitorexit
    //   452: new 193	com/tencent/turingfd/sdk/xq/Serpens
    //   455: dup
    //   456: invokespecial 194	com/tencent/turingfd/sdk/xq/Serpens:<init>	()V
    //   459: astore 18
    //   461: new 196	com/tencent/turingfd/sdk/xq/Bergamot
    //   464: dup
    //   465: invokespecial 197	com/tencent/turingfd/sdk/xq/Bergamot:<init>	()V
    //   468: astore_1
    //   469: aload_1
    //   470: bipush 11
    //   472: putfield 199	com/tencent/turingfd/sdk/xq/Bergamot:e	I
    //   475: aload_1
    //   476: iconst_1
    //   477: putfield 201	com/tencent/turingfd/sdk/xq/Bergamot:f	I
    //   480: aload_1
    //   481: iconst_1
    //   482: putfield 202	com/tencent/turingfd/sdk/xq/Bergamot:g	I
    //   485: aload_1
    //   486: iconst_0
    //   487: putfield 205	com/tencent/turingfd/sdk/xq/Bergamot:h	I
    //   490: aload_1
    //   491: iconst_0
    //   492: putfield 208	com/tencent/turingfd/sdk/xq/Bergamot:i	I
    //   495: aload_1
    //   496: aconst_null
    //   497: putfield 211	com/tencent/turingfd/sdk/xq/Bergamot:j	[B
    //   500: aload_1
    //   501: iconst_0
    //   502: putfield 214	com/tencent/turingfd/sdk/xq/Bergamot:k	I
    //   505: aload_1
    //   506: iconst_1
    //   507: putfield 217	com/tencent/turingfd/sdk/xq/Bergamot:p	I
    //   510: new 219	com/tencent/turingfd/sdk/xq/Arbutus
    //   513: dup
    //   514: invokespecial 220	com/tencent/turingfd/sdk/xq/Arbutus:<init>	()V
    //   517: astore 15
    //   519: aload 15
    //   521: iconst_1
    //   522: putfield 221	com/tencent/turingfd/sdk/xq/Arbutus:a	I
    //   525: aload_1
    //   526: aload 15
    //   528: putfield 225	com/tencent/turingfd/sdk/xq/Bergamot:r	Lcom/tencent/turingfd/sdk/xq/Arbutus;
    //   531: aload 18
    //   533: aload_1
    //   534: putfield 228	com/tencent/turingfd/sdk/xq/Serpens:c	Lcom/tencent/turingfd/sdk/xq/Bergamot;
    //   537: new 230	com/tencent/turingfd/sdk/xq/Berry
    //   540: dup
    //   541: invokespecial 231	com/tencent/turingfd/sdk/xq/Berry:<init>	()V
    //   544: astore 19
    //   546: aload 19
    //   548: getstatic 236	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   551: invokestatic 241	com/tencent/turingfd/sdk/xq/implements:a	(Ljava/lang/String;)Ljava/lang/String;
    //   554: putfield 242	com/tencent/turingfd/sdk/xq/Berry:a	Ljava/lang/String;
    //   557: aload 19
    //   559: iconst_0
    //   560: invokestatic 245	com/tencent/turingfd/sdk/xq/implements:a	(Z)Ljava/lang/String;
    //   563: putfield 247	com/tencent/turingfd/sdk/xq/Berry:b	Ljava/lang/String;
    //   566: aload 19
    //   568: getstatic 250	android/os/Build:BRAND	Ljava/lang/String;
    //   571: invokestatic 241	com/tencent/turingfd/sdk/xq/implements:a	(Ljava/lang/String;)Ljava/lang/String;
    //   574: putfield 252	com/tencent/turingfd/sdk/xq/Berry:c	Ljava/lang/String;
    //   577: aload 19
    //   579: getstatic 255	android/os/Build:MODEL	Ljava/lang/String;
    //   582: invokestatic 241	com/tencent/turingfd/sdk/xq/implements:a	(Ljava/lang/String;)Ljava/lang/String;
    //   585: putfield 257	com/tencent/turingfd/sdk/xq/Berry:d	Ljava/lang/String;
    //   588: aload 19
    //   590: getstatic 262	android/os/Build$VERSION:SDK_INT	I
    //   593: putfield 263	com/tencent/turingfd/sdk/xq/Berry:e	I
    //   596: aload 19
    //   598: getstatic 266	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   601: invokestatic 241	com/tencent/turingfd/sdk/xq/implements:a	(Ljava/lang/String;)Ljava/lang/String;
    //   604: putfield 267	com/tencent/turingfd/sdk/xq/Berry:f	Ljava/lang/String;
    //   607: ldc_w 269
    //   610: invokestatic 275	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   613: astore_1
    //   614: aload_1
    //   615: ldc_w 277
    //   618: iconst_1
    //   619: anewarray 271	java/lang/Class
    //   622: dup
    //   623: iconst_0
    //   624: ldc_w 279
    //   627: aastore
    //   628: invokevirtual 283	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   631: astore_1
    //   632: aload_1
    //   633: iconst_1
    //   634: invokevirtual 289	java/lang/reflect/Method:setAccessible	(Z)V
    //   637: aload_1
    //   638: aconst_null
    //   639: iconst_1
    //   640: anewarray 4	java/lang/Object
    //   643: dup
    //   644: iconst_0
    //   645: ldc_w 291
    //   648: aastore
    //   649: invokevirtual 295	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   652: checkcast 279	java/lang/String
    //   655: astore 15
    //   657: aload 15
    //   659: astore_1
    //   660: aload 15
    //   662: ifnonnull +7 -> 669
    //   665: ldc_w 297
    //   668: astore_1
    //   669: aload 19
    //   671: aload_1
    //   672: invokestatic 241	com/tencent/turingfd/sdk/xq/implements:a	(Ljava/lang/String;)Ljava/lang/String;
    //   675: putfield 299	com/tencent/turingfd/sdk/xq/Berry:g	Ljava/lang/String;
    //   678: getstatic 300	com/tencent/turingfd/sdk/xq/Cepheus:a	I
    //   681: iconst_m1
    //   682: if_icmpeq +68 -> 750
    //   685: new 302	android/util/SparseArray
    //   688: dup
    //   689: invokespecial 303	android/util/SparseArray:<init>	()V
    //   692: pop
    //   693: new 302	android/util/SparseArray
    //   696: dup
    //   697: invokespecial 303	android/util/SparseArray:<init>	()V
    //   700: aload 16
    //   702: sipush 201
    //   705: invokestatic 308	com/tencent/turingfd/sdk/xq/TNative$aa:d	(Landroid/util/SparseArray;Landroid/content/Context;I)Landroid/util/SparseArray;
    //   708: sipush 201
    //   711: ldc_w 279
    //   714: invokestatic 311	com/tencent/turingfd/sdk/xq/const:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   717: checkcast 279	java/lang/String
    //   720: astore 15
    //   722: aload 15
    //   724: astore_1
    //   725: aload 15
    //   727: ifnonnull +7 -> 734
    //   730: ldc_w 297
    //   733: astore_1
    //   734: aload_1
    //   735: invokestatic 315	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   738: putstatic 300	com/tencent/turingfd/sdk/xq/Cepheus:a	I
    //   741: goto +9 -> 750
    //   744: iconst_m1
    //   745: istore 4
    //   747: goto +8 -> 755
    //   750: getstatic 300	com/tencent/turingfd/sdk/xq/Cepheus:a	I
    //   753: istore 4
    //   755: aload 19
    //   757: iload 4
    //   759: putfield 316	com/tencent/turingfd/sdk/xq/Berry:h	I
    //   762: aload 18
    //   764: aload 19
    //   766: putfield 319	com/tencent/turingfd/sdk/xq/Serpens:d	Lcom/tencent/turingfd/sdk/xq/Berry;
    //   769: aload 18
    //   771: iconst_1
    //   772: putfield 320	com/tencent/turingfd/sdk/xq/Serpens:e	I
    //   775: aload 18
    //   777: ldc_w 297
    //   780: putfield 321	com/tencent/turingfd/sdk/xq/Serpens:g	Ljava/lang/String;
    //   783: aload 18
    //   785: aload 16
    //   787: invokestatic 326	com/tencent/turingfd/sdk/xq/while:a	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/break;
    //   790: checkcast 328	com/tencent/turingfd/sdk/xq/Chestnut
    //   793: getfield 329	com/tencent/turingfd/sdk/xq/Chestnut:b	Ljava/lang/String;
    //   796: putfield 330	com/tencent/turingfd/sdk/xq/Serpens:f	Ljava/lang/String;
    //   799: aload 17
    //   801: aload 18
    //   803: putfield 333	com/tencent/turingfd/sdk/xq/Scorpius:e	Lcom/tencent/turingfd/sdk/xq/Serpens;
    //   806: new 335	java/util/ArrayList
    //   809: dup
    //   810: invokespecial 336	java/util/ArrayList:<init>	()V
    //   813: astore 18
    //   815: aload 20
    //   817: getfield 339	com/tencent/turingfd/sdk/xq/Cepheus:b	Ljava/util/Map;
    //   820: invokeinterface 343 1 0
    //   825: invokeinterface 349 1 0
    //   830: astore 19
    //   832: aload 14
    //   834: astore_1
    //   835: aload 19
    //   837: invokeinterface 355 1 0
    //   842: ifeq +449 -> 1291
    //   845: aload 19
    //   847: invokeinterface 358 1 0
    //   852: checkcast 99	java/lang/Integer
    //   855: astore 14
    //   857: aload 20
    //   859: getfield 339	com/tencent/turingfd/sdk/xq/Cepheus:b	Ljava/util/Map;
    //   862: aload 14
    //   864: invokeinterface 361 2 0
    //   869: checkcast 363	com/tencent/turingfd/sdk/xq/Caelum
    //   872: astore 21
    //   874: new 365	com/tencent/turingfd/sdk/xq/Sculptor
    //   877: dup
    //   878: invokespecial 366	com/tencent/turingfd/sdk/xq/Sculptor:<init>	()V
    //   881: astore 22
    //   883: aload 14
    //   885: invokevirtual 369	java/lang/Integer:intValue	()I
    //   888: istore 4
    //   890: aload 21
    //   892: ifnonnull +9 -> 901
    //   895: aconst_null
    //   896: astore 14
    //   898: goto +185 -> 1083
    //   901: new 371	com/tencent/turingfd/sdk/xq/Bennet
    //   904: dup
    //   905: invokespecial 372	com/tencent/turingfd/sdk/xq/Bennet:<init>	()V
    //   908: astore 15
    //   910: aload 15
    //   912: iload 4
    //   914: putfield 373	com/tencent/turingfd/sdk/xq/Bennet:h	I
    //   917: aload 21
    //   919: getfield 374	com/tencent/turingfd/sdk/xq/Caelum:f	Ljava/lang/String;
    //   922: astore 16
    //   924: aload 16
    //   926: astore 14
    //   928: aload 16
    //   930: ifnonnull +8 -> 938
    //   933: ldc_w 297
    //   936: astore 14
    //   938: aload 15
    //   940: aload 14
    //   942: invokestatic 377	com/tencent/turingfd/sdk/xq/const:b	(Ljava/lang/String;)[B
    //   945: putfield 379	com/tencent/turingfd/sdk/xq/Bennet:i	[B
    //   948: aload 21
    //   950: getfield 380	com/tencent/turingfd/sdk/xq/Caelum:a	Ljava/lang/String;
    //   953: astore 16
    //   955: aload 16
    //   957: astore 14
    //   959: aload 16
    //   961: ifnonnull +8 -> 969
    //   964: ldc_w 297
    //   967: astore 14
    //   969: aload 15
    //   971: aload 14
    //   973: putfield 382	com/tencent/turingfd/sdk/xq/Bennet:j	Ljava/lang/String;
    //   976: aload 21
    //   978: getfield 383	com/tencent/turingfd/sdk/xq/Caelum:b	Ljava/lang/String;
    //   981: astore 16
    //   983: aload 16
    //   985: astore 14
    //   987: aload 16
    //   989: ifnonnull +8 -> 997
    //   992: ldc_w 297
    //   995: astore 14
    //   997: aload 15
    //   999: aload 14
    //   1001: invokestatic 377	com/tencent/turingfd/sdk/xq/const:b	(Ljava/lang/String;)[B
    //   1004: putfield 385	com/tencent/turingfd/sdk/xq/Bennet:k	[B
    //   1007: aload 15
    //   1009: aload 21
    //   1011: getfield 386	com/tencent/turingfd/sdk/xq/Caelum:c	J
    //   1014: putfield 389	com/tencent/turingfd/sdk/xq/Bennet:l	J
    //   1017: aload 15
    //   1019: iconst_0
    //   1020: putfield 390	com/tencent/turingfd/sdk/xq/Bennet:p	I
    //   1023: aload 15
    //   1025: ldc_w 297
    //   1028: putfield 393	com/tencent/turingfd/sdk/xq/Bennet:q	Ljava/lang/String;
    //   1031: aload 15
    //   1033: iconst_0
    //   1034: putfield 395	com/tencent/turingfd/sdk/xq/Bennet:r	I
    //   1037: aload 15
    //   1039: iconst_0
    //   1040: putfield 398	com/tencent/turingfd/sdk/xq/Bennet:s	I
    //   1043: aload 15
    //   1045: iconst_0
    //   1046: putfield 401	com/tencent/turingfd/sdk/xq/Bennet:t	I
    //   1049: aload 15
    //   1051: aconst_null
    //   1052: putfield 405	com/tencent/turingfd/sdk/xq/Bennet:u	Ljava/util/List;
    //   1055: aload 15
    //   1057: iconst_0
    //   1058: putfield 408	com/tencent/turingfd/sdk/xq/Bennet:v	I
    //   1061: aload 15
    //   1063: iconst_0
    //   1064: putfield 412	com/tencent/turingfd/sdk/xq/Bennet:w	Z
    //   1067: aload 15
    //   1069: iconst_0
    //   1070: putfield 415	com/tencent/turingfd/sdk/xq/Bennet:x	I
    //   1073: aload 15
    //   1075: iconst_0
    //   1076: putfield 418	com/tencent/turingfd/sdk/xq/Bennet:y	I
    //   1079: aload 15
    //   1081: astore 14
    //   1083: aload 22
    //   1085: aload 14
    //   1087: putfield 421	com/tencent/turingfd/sdk/xq/Sculptor:g	Lcom/tencent/turingfd/sdk/xq/Bennet;
    //   1090: aload 21
    //   1092: getfield 422	com/tencent/turingfd/sdk/xq/Caelum:g	Ljava/lang/String;
    //   1095: astore 15
    //   1097: aload 15
    //   1099: astore 14
    //   1101: aload 15
    //   1103: ifnonnull +8 -> 1111
    //   1106: ldc_w 297
    //   1109: astore 14
    //   1111: aload 22
    //   1113: aload 14
    //   1115: putfield 424	com/tencent/turingfd/sdk/xq/Sculptor:h	Ljava/lang/String;
    //   1118: aload 21
    //   1120: getfield 425	com/tencent/turingfd/sdk/xq/Caelum:d	Ljava/lang/String;
    //   1123: astore 15
    //   1125: aload 15
    //   1127: astore 14
    //   1129: aload 15
    //   1131: ifnonnull +8 -> 1139
    //   1134: ldc_w 297
    //   1137: astore 14
    //   1139: aload 22
    //   1141: aload 14
    //   1143: putfield 427	com/tencent/turingfd/sdk/xq/Sculptor:i	Ljava/lang/String;
    //   1146: aload 22
    //   1148: aload 21
    //   1150: getfield 428	com/tencent/turingfd/sdk/xq/Caelum:h	I
    //   1153: putfield 429	com/tencent/turingfd/sdk/xq/Sculptor:k	I
    //   1156: aload 21
    //   1158: getfield 431	com/tencent/turingfd/sdk/xq/Caelum:e	Ljava/lang/String;
    //   1161: astore 15
    //   1163: aload 15
    //   1165: astore 14
    //   1167: aload 15
    //   1169: ifnonnull +8 -> 1177
    //   1172: ldc_w 297
    //   1175: astore 14
    //   1177: aload 22
    //   1179: aload 14
    //   1181: invokestatic 377	com/tencent/turingfd/sdk/xq/const:b	(Ljava/lang/String;)[B
    //   1184: putfield 433	com/tencent/turingfd/sdk/xq/Sculptor:l	[B
    //   1187: aload 22
    //   1189: aload 21
    //   1191: getfield 436	com/tencent/turingfd/sdk/xq/Caelum:i	Ljava/util/ArrayList;
    //   1194: putfield 439	com/tencent/turingfd/sdk/xq/Sculptor:m	Ljava/util/List;
    //   1197: aload 21
    //   1199: getfield 440	com/tencent/turingfd/sdk/xq/Caelum:j	Ljava/lang/String;
    //   1202: astore 15
    //   1204: aload 15
    //   1206: astore 14
    //   1208: aload 15
    //   1210: ifnonnull +8 -> 1218
    //   1213: ldc_w 297
    //   1216: astore 14
    //   1218: aload 22
    //   1220: aload 14
    //   1222: putfield 443	com/tencent/turingfd/sdk/xq/Sculptor:n	Ljava/lang/String;
    //   1225: aload 20
    //   1227: getfield 444	com/tencent/turingfd/sdk/xq/Cepheus:e	Ljava/lang/String;
    //   1230: astore 15
    //   1232: aload 15
    //   1234: ifnull +26 -> 1260
    //   1237: aload 15
    //   1239: invokevirtual 447	java/lang/String:isEmpty	()Z
    //   1242: ifeq +18 -> 1260
    //   1245: aload 14
    //   1247: invokevirtual 447	java/lang/String:isEmpty	()Z
    //   1250: ifne +10 -> 1260
    //   1253: aload 20
    //   1255: aload 14
    //   1257: putfield 444	com/tencent/turingfd/sdk/xq/Cepheus:e	Ljava/lang/String;
    //   1260: aload 22
    //   1262: aload 21
    //   1264: getfield 449	com/tencent/turingfd/sdk/xq/Caelum:k	Ljava/util/ArrayList;
    //   1267: putfield 452	com/tencent/turingfd/sdk/xq/Sculptor:o	Ljava/util/List;
    //   1270: aload 22
    //   1272: aload 21
    //   1274: getfield 454	com/tencent/turingfd/sdk/xq/Caelum:l	Ljava/util/ArrayList;
    //   1277: putfield 456	com/tencent/turingfd/sdk/xq/Sculptor:p	Ljava/util/List;
    //   1280: aload 18
    //   1282: aload 22
    //   1284: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1287: pop
    //   1288: goto -453 -> 835
    //   1291: aload_1
    //   1292: astore 14
    //   1294: aload 17
    //   1296: aload 18
    //   1298: putfield 462	com/tencent/turingfd/sdk/xq/Scorpius:f	Ljava/util/List;
    //   1301: new 464	com/tencent/turingfd/sdk/xq/case
    //   1304: dup
    //   1305: sipush 128
    //   1308: invokespecial 467	com/tencent/turingfd/sdk/xq/case:<init>	(I)V
    //   1311: astore_1
    //   1312: aload_1
    //   1313: ldc_w 469
    //   1316: putfield 470	com/tencent/turingfd/sdk/xq/case:b	Ljava/lang/String;
    //   1319: aload 17
    //   1321: aload_1
    //   1322: invokevirtual 473	com/tencent/turingfd/sdk/xq/Scorpius:a	(Lcom/tencent/turingfd/sdk/xq/case;)V
    //   1325: aload_1
    //   1326: invokevirtual 476	com/tencent/turingfd/sdk/xq/case:a	()[B
    //   1329: astore_1
    //   1330: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   1333: lload 7
    //   1335: lsub
    //   1336: lstore 11
    //   1338: aload_1
    //   1339: arraylength
    //   1340: i2l
    //   1341: lstore 9
    //   1343: goto +16 -> 1359
    //   1346: astore_1
    //   1347: ldc 189
    //   1349: monitorexit
    //   1350: aload_1
    //   1351: athrow
    //   1352: ldc2_w 180
    //   1355: lstore 9
    //   1357: aconst_null
    //   1358: astore_1
    //   1359: aload_1
    //   1360: ifnonnull +19 -> 1379
    //   1363: aload 20
    //   1365: ldc2_w 477
    //   1368: invokevirtual 480	com/tencent/turingfd/sdk/xq/Cepheus:a	(J)J
    //   1371: lstore 7
    //   1373: aload 13
    //   1375: astore_1
    //   1376: goto +2524 -> 3900
    //   1379: getstatic 485	com/tencent/turingfd/sdk/xq/Papaya:b	Lcom/tencent/turingfd/sdk/xq/Papaya;
    //   1382: astore 17
    //   1384: aload 20
    //   1386: getfield 444	com/tencent/turingfd/sdk/xq/Cepheus:e	Ljava/lang/String;
    //   1389: astore 16
    //   1391: aload 17
    //   1393: invokevirtual 489	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1396: pop
    //   1397: new 491	com/tencent/turingfd/sdk/xq/Octans
    //   1400: dup
    //   1401: invokespecial 492	com/tencent/turingfd/sdk/xq/Octans:<init>	()V
    //   1404: astore 18
    //   1406: aload 18
    //   1408: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   1411: putfield 494	com/tencent/turingfd/sdk/xq/Octans:g	J
    //   1414: new 156	java/util/HashMap
    //   1417: dup
    //   1418: invokespecial 157	java/util/HashMap:<init>	()V
    //   1421: astore 15
    //   1423: aload 15
    //   1425: aload 14
    //   1427: aload_1
    //   1428: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1431: pop
    //   1432: aload 18
    //   1434: aload 15
    //   1436: putfield 496	com/tencent/turingfd/sdk/xq/Octans:h	Ljava/util/Map;
    //   1439: aload 18
    //   1441: iconst_0
    //   1442: putfield 497	com/tencent/turingfd/sdk/xq/Octans:i	I
    //   1445: new 499	com/tencent/turingfd/sdk/xq/Perseus
    //   1448: dup
    //   1449: invokespecial 500	com/tencent/turingfd/sdk/xq/Perseus:<init>	()V
    //   1452: astore_1
    //   1453: aload_1
    //   1454: bipush 61
    //   1456: putfield 501	com/tencent/turingfd/sdk/xq/Perseus:a	I
    //   1459: aload_1
    //   1460: ldc_w 503
    //   1463: putfield 504	com/tencent/turingfd/sdk/xq/Perseus:b	Ljava/lang/String;
    //   1466: aload_1
    //   1467: ldc_w 506
    //   1470: putfield 507	com/tencent/turingfd/sdk/xq/Perseus:c	Ljava/lang/String;
    //   1473: new 47	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   1480: astore 15
    //   1482: aload 15
    //   1484: ldc_w 297
    //   1487: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: aload 15
    //   1493: getstatic 58	com/tencent/turingfd/sdk/xq/native:a	I
    //   1496: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1499: pop
    //   1500: aload_1
    //   1501: aload 15
    //   1503: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: putfield 508	com/tencent/turingfd/sdk/xq/Perseus:d	Ljava/lang/String;
    //   1509: aload_1
    //   1510: iconst_2
    //   1511: putfield 509	com/tencent/turingfd/sdk/xq/Perseus:e	I
    //   1514: aload 18
    //   1516: aload_1
    //   1517: putfield 512	com/tencent/turingfd/sdk/xq/Octans:j	Lcom/tencent/turingfd/sdk/xq/Perseus;
    //   1520: aload 17
    //   1522: getfield 515	com/tencent/turingfd/sdk/xq/Papaya:d	Lcom/tencent/turingfd/sdk/xq/Orion;
    //   1525: ifnonnull +141 -> 1666
    //   1528: aload 17
    //   1530: new 517	com/tencent/turingfd/sdk/xq/Orion
    //   1533: dup
    //   1534: invokespecial 518	com/tencent/turingfd/sdk/xq/Orion:<init>	()V
    //   1537: putfield 515	com/tencent/turingfd/sdk/xq/Papaya:d	Lcom/tencent/turingfd/sdk/xq/Orion;
    //   1540: ldc 189
    //   1542: monitorenter
    //   1543: getstatic 191	com/tencent/turingfd/sdk/xq/const:a	Landroid/content/Context;
    //   1546: astore 19
    //   1548: ldc 189
    //   1550: monitorexit
    //   1551: aload 17
    //   1553: getfield 515	com/tencent/turingfd/sdk/xq/Papaya:d	Lcom/tencent/turingfd/sdk/xq/Orion;
    //   1556: astore 21
    //   1558: aload 19
    //   1560: invokevirtual 523	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1563: astore 15
    //   1565: aload 15
    //   1567: astore_1
    //   1568: aload 15
    //   1570: ifnonnull +7 -> 1577
    //   1573: ldc_w 297
    //   1576: astore_1
    //   1577: aload 21
    //   1579: aload_1
    //   1580: putfield 524	com/tencent/turingfd/sdk/xq/Orion:b	Ljava/lang/String;
    //   1583: aload 19
    //   1585: invokevirtual 523	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1588: astore_1
    //   1589: aload 19
    //   1591: invokevirtual 528	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1594: aload_1
    //   1595: bipush 64
    //   1597: invokevirtual 534	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1600: astore 15
    //   1602: aload 15
    //   1604: getfield 539	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   1607: astore_1
    //   1608: aload 15
    //   1610: getfield 542	android/content/pm/PackageInfo:versionCode	I
    //   1613: istore 4
    //   1615: goto +10 -> 1625
    //   1618: ldc_w 544
    //   1621: astore_1
    //   1622: iconst_0
    //   1623: istore 4
    //   1625: ldc_w 546
    //   1628: iconst_2
    //   1629: anewarray 4	java/lang/Object
    //   1632: dup
    //   1633: iconst_0
    //   1634: aload_1
    //   1635: aastore
    //   1636: dup
    //   1637: iconst_1
    //   1638: iload 4
    //   1640: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1643: aastore
    //   1644: invokestatic 550	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1647: astore_1
    //   1648: aload 17
    //   1650: getfield 515	com/tencent/turingfd/sdk/xq/Papaya:d	Lcom/tencent/turingfd/sdk/xq/Orion;
    //   1653: aload_1
    //   1654: putfield 551	com/tencent/turingfd/sdk/xq/Orion:a	Ljava/lang/String;
    //   1657: goto +9 -> 1666
    //   1660: astore_1
    //   1661: ldc 189
    //   1663: monitorexit
    //   1664: aload_1
    //   1665: athrow
    //   1666: aload 18
    //   1668: aload 17
    //   1670: getfield 515	com/tencent/turingfd/sdk/xq/Papaya:d	Lcom/tencent/turingfd/sdk/xq/Orion;
    //   1673: putfield 553	com/tencent/turingfd/sdk/xq/Octans:k	Lcom/tencent/turingfd/sdk/xq/Orion;
    //   1676: new 555	com/tencent/turingfd/sdk/xq/Phoenix
    //   1679: dup
    //   1680: invokespecial 556	com/tencent/turingfd/sdk/xq/Phoenix:<init>	()V
    //   1683: astore_1
    //   1684: aload_1
    //   1685: aload 17
    //   1687: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   1690: invokevirtual 563	com/tencent/turingfd/sdk/xq/final:a	()Ljava/lang/String;
    //   1693: putfield 564	com/tencent/turingfd/sdk/xq/Phoenix:h	Ljava/lang/String;
    //   1696: aload 17
    //   1698: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   1701: invokevirtual 489	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1704: pop
    //   1705: aload_1
    //   1706: aconst_null
    //   1707: putfield 565	com/tencent/turingfd/sdk/xq/Phoenix:b	Ljava/lang/String;
    //   1710: aload 17
    //   1712: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   1715: astore 15
    //   1717: aload_1
    //   1718: aload 15
    //   1720: getfield 566	com/tencent/turingfd/sdk/xq/final:g	Ljava/lang/String;
    //   1723: putfield 567	com/tencent/turingfd/sdk/xq/Phoenix:c	Ljava/lang/String;
    //   1726: aload_1
    //   1727: aload 15
    //   1729: getfield 568	com/tencent/turingfd/sdk/xq/final:i	I
    //   1732: putfield 570	com/tencent/turingfd/sdk/xq/Phoenix:d	I
    //   1735: aload_1
    //   1736: aload 15
    //   1738: getfield 571	com/tencent/turingfd/sdk/xq/final:h	Ljava/lang/String;
    //   1741: putfield 572	com/tencent/turingfd/sdk/xq/Phoenix:e	Ljava/lang/String;
    //   1744: aload_1
    //   1745: aload 15
    //   1747: getfield 573	com/tencent/turingfd/sdk/xq/final:j	Ljava/lang/String;
    //   1750: putfield 574	com/tencent/turingfd/sdk/xq/Phoenix:f	Ljava/lang/String;
    //   1753: aload 18
    //   1755: aload_1
    //   1756: putfield 577	com/tencent/turingfd/sdk/xq/Octans:l	Lcom/tencent/turingfd/sdk/xq/Phoenix;
    //   1759: new 156	java/util/HashMap
    //   1762: dup
    //   1763: invokespecial 157	java/util/HashMap:<init>	()V
    //   1766: astore 19
    //   1768: ldc 189
    //   1770: monitorenter
    //   1771: getstatic 191	com/tencent/turingfd/sdk/xq/const:a	Landroid/content/Context;
    //   1774: astore 22
    //   1776: ldc 189
    //   1778: monitorexit
    //   1779: aload 22
    //   1781: invokestatic 326	com/tencent/turingfd/sdk/xq/while:a	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/break;
    //   1784: checkcast 328	com/tencent/turingfd/sdk/xq/Chestnut
    //   1787: astore 21
    //   1789: aload 21
    //   1791: getfield 329	com/tencent/turingfd/sdk/xq/Chestnut:b	Ljava/lang/String;
    //   1794: astore 15
    //   1796: aload 15
    //   1798: astore_1
    //   1799: aload 15
    //   1801: ifnonnull +7 -> 1808
    //   1804: ldc_w 297
    //   1807: astore_1
    //   1808: aload 19
    //   1810: aload 14
    //   1812: aload_1
    //   1813: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1816: pop
    //   1817: aload 17
    //   1819: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   1822: getfield 580	com/tencent/turingfd/sdk/xq/final:a	Lcom/tencent/turingfd/sdk/xq/class;
    //   1825: astore_1
    //   1826: aload_1
    //   1827: ifnull +19 -> 1846
    //   1830: aload_1
    //   1831: checkcast 582	com/tencent/turingfd/sdk/xq/TuringSDK$do
    //   1834: getfield 585	com/tencent/turingfd/sdk/xq/TuringSDK$do:a	Lcom/tencent/turingfd/sdk/xq/ITuringPrivacyLite;
    //   1837: invokeinterface 589 1 0
    //   1842: istore_3
    //   1843: goto +5 -> 1848
    //   1846: iconst_1
    //   1847: istore_3
    //   1848: iload_3
    //   1849: ifeq +33 -> 1882
    //   1852: aload 22
    //   1854: invokestatic 592	com/tencent/turingfd/sdk/xq/implements:a	(Landroid/content/Context;)Ljava/lang/String;
    //   1857: astore 15
    //   1859: aload 15
    //   1861: astore_1
    //   1862: aload 15
    //   1864: ifnonnull +7 -> 1871
    //   1867: ldc_w 297
    //   1870: astore_1
    //   1871: aload 19
    //   1873: iconst_2
    //   1874: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1877: aload_1
    //   1878: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1881: pop
    //   1882: aload 17
    //   1884: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   1887: astore_1
    //   1888: aload_1
    //   1889: getfield 593	com/tencent/turingfd/sdk/xq/final:d	Ljava/lang/String;
    //   1892: invokestatic 598	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1895: ifeq +10 -> 1905
    //   1898: ldc_w 297
    //   1901: astore_1
    //   1902: goto +8 -> 1910
    //   1905: aload_1
    //   1906: getfield 593	com/tencent/turingfd/sdk/xq/final:d	Ljava/lang/String;
    //   1909: astore_1
    //   1910: aload_1
    //   1911: astore 15
    //   1913: aload_1
    //   1914: ifnonnull +8 -> 1922
    //   1917: ldc_w 297
    //   1920: astore 15
    //   1922: aload 19
    //   1924: bipush 6
    //   1926: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1929: aload 15
    //   1931: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1934: pop
    //   1935: aload 16
    //   1937: astore_1
    //   1938: aload 16
    //   1940: ifnonnull +7 -> 1947
    //   1943: ldc_w 297
    //   1946: astore_1
    //   1947: aload 19
    //   1949: iconst_4
    //   1950: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1953: aload_1
    //   1954: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1957: pop
    //   1958: aload 21
    //   1960: getfield 599	com/tencent/turingfd/sdk/xq/Chestnut:g	Ljava/lang/String;
    //   1963: astore 15
    //   1965: aload 15
    //   1967: astore_1
    //   1968: aload 15
    //   1970: ifnonnull +7 -> 1977
    //   1973: ldc_w 297
    //   1976: astore_1
    //   1977: aload 19
    //   1979: iconst_3
    //   1980: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1983: aload_1
    //   1984: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1987: pop
    //   1988: aload 18
    //   1990: aload 19
    //   1992: putfield 601	com/tencent/turingfd/sdk/xq/Octans:m	Ljava/util/Map;
    //   1995: new 156	java/util/HashMap
    //   1998: dup
    //   1999: invokespecial 157	java/util/HashMap:<init>	()V
    //   2002: astore 15
    //   2004: aload 17
    //   2006: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   2009: getfield 603	com/tencent/turingfd/sdk/xq/final:b	Landroid/content/Context;
    //   2012: astore 19
    //   2014: getstatic 154	com/tencent/turingfd/sdk/xq/Date:a	Ljava/lang/String;
    //   2017: astore_1
    //   2018: new 156	java/util/HashMap
    //   2021: dup
    //   2022: invokespecial 157	java/util/HashMap:<init>	()V
    //   2025: astore 16
    //   2027: aload 19
    //   2029: invokestatic 606	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;)Ljava/util/Set;
    //   2032: checkcast 608	java/util/HashSet
    //   2035: invokevirtual 609	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   2038: astore_1
    //   2039: aload_1
    //   2040: invokeinterface 355 1 0
    //   2045: ifeq +61 -> 2106
    //   2048: aload_1
    //   2049: invokeinterface 358 1 0
    //   2054: checkcast 279	java/lang/String
    //   2057: astore 21
    //   2059: new 47	java/lang/StringBuilder
    //   2062: dup
    //   2063: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2066: astore 22
    //   2068: aload 22
    //   2070: ldc_w 611
    //   2073: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: pop
    //   2077: aload 22
    //   2079: aload 21
    //   2081: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: pop
    //   2085: aload 16
    //   2087: aload 21
    //   2089: aload 19
    //   2091: aload 22
    //   2093: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2096: invokestatic 613	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   2099: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2102: pop
    //   2103: goto -64 -> 2039
    //   2106: aload 16
    //   2108: invokevirtual 614	java/util/HashMap:keySet	()Ljava/util/Set;
    //   2111: invokeinterface 349 1 0
    //   2116: astore_1
    //   2117: aload_1
    //   2118: invokeinterface 355 1 0
    //   2123: ifeq +47 -> 2170
    //   2126: aload_1
    //   2127: invokeinterface 358 1 0
    //   2132: checkcast 279	java/lang/String
    //   2135: astore 19
    //   2137: aload 15
    //   2139: aload 19
    //   2141: invokestatic 617	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2144: invokevirtual 369	java/lang/Integer:intValue	()I
    //   2147: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2150: aload 16
    //   2152: aload 19
    //   2154: invokevirtual 618	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2157: checkcast 279	java/lang/String
    //   2160: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2163: pop
    //   2164: goto -47 -> 2117
    //   2167: goto -50 -> 2117
    //   2170: aload 15
    //   2172: iconst_2
    //   2173: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2176: aload 17
    //   2178: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   2181: getfield 603	com/tencent/turingfd/sdk/xq/final:b	Landroid/content/Context;
    //   2184: ldc 159
    //   2186: invokestatic 613	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   2189: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2192: pop
    //   2193: aload 15
    //   2195: iconst_3
    //   2196: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2199: aload 17
    //   2201: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   2204: getfield 603	com/tencent/turingfd/sdk/xq/final:b	Landroid/content/Context;
    //   2207: ldc_w 620
    //   2210: invokestatic 613	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   2213: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2216: pop
    //   2217: aload 15
    //   2219: iconst_4
    //   2220: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2223: aload 17
    //   2225: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   2228: getfield 603	com/tencent/turingfd/sdk/xq/final:b	Landroid/content/Context;
    //   2231: ldc_w 622
    //   2234: invokestatic 613	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   2237: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2240: pop
    //   2241: aload 18
    //   2243: aload 15
    //   2245: putfield 624	com/tencent/turingfd/sdk/xq/Octans:n	Ljava/util/Map;
    //   2248: ldc 189
    //   2250: monitorenter
    //   2251: getstatic 191	com/tencent/turingfd/sdk/xq/const:a	Landroid/content/Context;
    //   2254: astore_1
    //   2255: ldc 189
    //   2257: monitorexit
    //   2258: aload_1
    //   2259: invokestatic 627	com/tencent/turingfd/sdk/xq/const:e	(Landroid/content/Context;)B
    //   2262: istore 4
    //   2264: getstatic 628	com/tencent/turingfd/sdk/xq/Papaya:a	Ljava/lang/String;
    //   2267: astore_1
    //   2268: new 630	com/tencent/turingfd/sdk/xq/Ara
    //   2271: dup
    //   2272: invokespecial 631	com/tencent/turingfd/sdk/xq/Ara:<init>	()V
    //   2275: astore 15
    //   2277: aload 15
    //   2279: getfield 634	com/tencent/turingfd/sdk/xq/Ara:b	Lcom/tencent/turingfd/sdk/xq/if;
    //   2282: astore 16
    //   2284: aload 16
    //   2286: aload_1
    //   2287: putfield 637	com/tencent/turingfd/sdk/xq/if:h	Ljava/lang/String;
    //   2290: aload 16
    //   2292: aload_1
    //   2293: putfield 638	com/tencent/turingfd/sdk/xq/if:i	Ljava/lang/String;
    //   2296: aload 15
    //   2298: ldc_w 640
    //   2301: aload 18
    //   2303: invokevirtual 643	com/tencent/turingfd/sdk/xq/Ara:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2306: aload 15
    //   2308: invokevirtual 644	com/tencent/turingfd/sdk/xq/Ara:a	()[B
    //   2311: invokestatic 647	com/tencent/turingfd/sdk/xq/const:b	([B)[B
    //   2314: astore_1
    //   2315: aload_1
    //   2316: ifnull +14 -> 2330
    //   2319: aload_1
    //   2320: invokestatic 649	com/tencent/turingfd/sdk/xq/const:g	()[B
    //   2323: invokestatic 652	com/tencent/turingfd/sdk/xq/const:b	([B[B)[B
    //   2326: astore_1
    //   2327: goto +16 -> 2343
    //   2330: new 654	java/lang/RuntimeException
    //   2333: dup
    //   2334: ldc_w 656
    //   2337: invokespecial 659	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   2340: athrow
    //   2341: aconst_null
    //   2342: astore_1
    //   2343: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   2346: lstore 7
    //   2348: new 4	java/lang/Object
    //   2351: dup
    //   2352: invokespecial 43	java/lang/Object:<init>	()V
    //   2355: astore 15
    //   2357: new 661	java/util/concurrent/atomic/AtomicReference
    //   2360: dup
    //   2361: invokespecial 662	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   2364: astore 16
    //   2366: new 664	java/util/concurrent/atomic/AtomicBoolean
    //   2369: dup
    //   2370: iconst_0
    //   2371: invokespecial 666	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   2374: astore 18
    //   2376: aload 16
    //   2378: new 668	com/tencent/turingfd/sdk/xq/catch$do
    //   2381: dup
    //   2382: bipush 246
    //   2384: iconst_0
    //   2385: newarray byte
    //   2387: invokespecial 671	com/tencent/turingfd/sdk/xq/catch$do:<init>	(I[B)V
    //   2390: invokevirtual 675	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   2393: new 677	com/tencent/turingfd/sdk/xq/Orange
    //   2396: dup
    //   2397: aload 17
    //   2399: aload_1
    //   2400: aload 18
    //   2402: aload 16
    //   2404: aload 15
    //   2406: invokespecial 680	com/tencent/turingfd/sdk/xq/Orange:<init>	(Lcom/tencent/turingfd/sdk/xq/Papaya;[BLjava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   2409: invokevirtual 685	java/lang/Thread:start	()V
    //   2412: aload 15
    //   2414: monitorenter
    //   2415: aload 15
    //   2417: ldc2_w 686
    //   2420: invokevirtual 691	java/lang/Object:wait	(J)V
    //   2423: goto +7 -> 2430
    //   2426: astore_1
    //   2427: goto +1762 -> 4189
    //   2430: aload 15
    //   2432: monitorexit
    //   2433: aload 18
    //   2435: iconst_1
    //   2436: invokevirtual 693	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   2439: aload 16
    //   2441: invokevirtual 695	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   2444: checkcast 668	com/tencent/turingfd/sdk/xq/catch$do
    //   2447: astore 15
    //   2449: new 697	com/tencent/turingfd/sdk/xq/Olive$do
    //   2452: dup
    //   2453: invokespecial 698	com/tencent/turingfd/sdk/xq/Olive$do:<init>	()V
    //   2456: astore 16
    //   2458: aload 16
    //   2460: aload_1
    //   2461: arraylength
    //   2462: i2l
    //   2463: putfield 699	com/tencent/turingfd/sdk/xq/Olive$do:c	J
    //   2466: aload 16
    //   2468: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   2471: lload 7
    //   2473: lsub
    //   2474: putfield 701	com/tencent/turingfd/sdk/xq/Olive$do:d	J
    //   2477: aload 16
    //   2479: iconst_1
    //   2480: putfield 703	com/tencent/turingfd/sdk/xq/Olive$do:a	Z
    //   2483: aload 16
    //   2485: iload 4
    //   2487: putfield 705	com/tencent/turingfd/sdk/xq/Olive$do:b	I
    //   2490: new 707	com/tencent/turingfd/sdk/xq/Olive
    //   2493: dup
    //   2494: aload 16
    //   2496: invokespecial 710	com/tencent/turingfd/sdk/xq/Olive:<init>	(Lcom/tencent/turingfd/sdk/xq/Olive$do;)V
    //   2499: astore_1
    //   2500: aload 15
    //   2502: getfield 711	com/tencent/turingfd/sdk/xq/catch$do:a	I
    //   2505: istore 4
    //   2507: iload 4
    //   2509: ifeq +18 -> 2527
    //   2512: iload 4
    //   2514: i2l
    //   2515: ldc2_w 686
    //   2518: lsub
    //   2519: aload_1
    //   2520: invokestatic 716	com/tencent/turingfd/sdk/xq/Nucleus:a	(JLcom/tencent/turingfd/sdk/xq/Olive;)Lcom/tencent/turingfd/sdk/xq/Nucleus;
    //   2523: astore_1
    //   2524: goto +190 -> 2714
    //   2527: aload 15
    //   2529: getfield 718	com/tencent/turingfd/sdk/xq/catch$do:b	[B
    //   2532: astore 15
    //   2534: new 720	com/tencent/turingfd/sdk/xq/Pegasus
    //   2537: dup
    //   2538: invokespecial 721	com/tencent/turingfd/sdk/xq/Pegasus:<init>	()V
    //   2541: astore 16
    //   2543: aload 16
    //   2545: aload 15
    //   2547: invokestatic 724	com/tencent/turingfd/sdk/xq/const:a	(Lcom/tencent/turingfd/sdk/xq/else;[B)Lcom/tencent/turingfd/sdk/xq/else;
    //   2550: astore 15
    //   2552: aload 15
    //   2554: ifnull +141 -> 2695
    //   2557: aload 15
    //   2559: instanceof 720
    //   2562: ifne +6 -> 2568
    //   2565: goto +130 -> 2695
    //   2568: aload 15
    //   2570: checkcast 720	com/tencent/turingfd/sdk/xq/Pegasus
    //   2573: astore 15
    //   2575: aload 15
    //   2577: getfield 726	com/tencent/turingfd/sdk/xq/Pegasus:c	I
    //   2580: istore 4
    //   2582: iload 4
    //   2584: ifeq +18 -> 2602
    //   2587: iload 4
    //   2589: i2l
    //   2590: ldc2_w 727
    //   2593: lsub
    //   2594: aload_1
    //   2595: invokestatic 716	com/tencent/turingfd/sdk/xq/Nucleus:a	(JLcom/tencent/turingfd/sdk/xq/Olive;)Lcom/tencent/turingfd/sdk/xq/Nucleus;
    //   2598: astore_1
    //   2599: goto +115 -> 2714
    //   2602: aload 15
    //   2604: getfield 730	com/tencent/turingfd/sdk/xq/Pegasus:d	Ljava/util/Map;
    //   2607: astore 15
    //   2609: aload 15
    //   2611: ifnull +73 -> 2684
    //   2614: aload 15
    //   2616: invokeinterface 184 1 0
    //   2621: ifne +6 -> 2627
    //   2624: goto +60 -> 2684
    //   2627: aload 15
    //   2629: aload 14
    //   2631: invokeinterface 733 2 0
    //   2636: ifne +14 -> 2650
    //   2639: ldc2_w 734
    //   2642: aload_1
    //   2643: invokestatic 716	com/tencent/turingfd/sdk/xq/Nucleus:a	(JLcom/tencent/turingfd/sdk/xq/Olive;)Lcom/tencent/turingfd/sdk/xq/Nucleus;
    //   2646: astore_1
    //   2647: goto +67 -> 2714
    //   2650: aload 15
    //   2652: aload 14
    //   2654: invokeinterface 361 2 0
    //   2659: checkcast 736	[B
    //   2662: astore 14
    //   2664: aload_1
    //   2665: lconst_0
    //   2666: putfield 738	com/tencent/turingfd/sdk/xq/Olive:a	J
    //   2669: new 713	com/tencent/turingfd/sdk/xq/Nucleus
    //   2672: dup
    //   2673: lconst_0
    //   2674: aload 14
    //   2676: aload_1
    //   2677: invokespecial 741	com/tencent/turingfd/sdk/xq/Nucleus:<init>	(J[BLcom/tencent/turingfd/sdk/xq/Olive;)V
    //   2680: astore_1
    //   2681: goto +33 -> 2714
    //   2684: ldc2_w 742
    //   2687: aload_1
    //   2688: invokestatic 716	com/tencent/turingfd/sdk/xq/Nucleus:a	(JLcom/tencent/turingfd/sdk/xq/Olive;)Lcom/tencent/turingfd/sdk/xq/Nucleus;
    //   2691: astore_1
    //   2692: goto +22 -> 2714
    //   2695: ldc2_w 744
    //   2698: aload_1
    //   2699: invokestatic 716	com/tencent/turingfd/sdk/xq/Nucleus:a	(JLcom/tencent/turingfd/sdk/xq/Olive;)Lcom/tencent/turingfd/sdk/xq/Nucleus;
    //   2702: astore_1
    //   2703: goto +11 -> 2714
    //   2706: ldc2_w 746
    //   2709: aload_1
    //   2710: invokestatic 716	com/tencent/turingfd/sdk/xq/Nucleus:a	(JLcom/tencent/turingfd/sdk/xq/Olive;)Lcom/tencent/turingfd/sdk/xq/Nucleus;
    //   2713: astore_1
    //   2714: aload 17
    //   2716: getfield 559	com/tencent/turingfd/sdk/xq/Papaya:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   2719: getfield 603	com/tencent/turingfd/sdk/xq/final:b	Landroid/content/Context;
    //   2722: astore 15
    //   2724: aload_1
    //   2725: getfield 750	com/tencent/turingfd/sdk/xq/Nucleus:d	Lcom/tencent/turingfd/sdk/xq/Olive;
    //   2728: astore 16
    //   2730: new 47	java/lang/StringBuilder
    //   2733: dup
    //   2734: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2737: astore 17
    //   2739: aload 17
    //   2741: aload 16
    //   2743: getfield 738	com/tencent/turingfd/sdk/xq/Olive:a	J
    //   2746: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2749: pop
    //   2750: aload 17
    //   2752: ldc 63
    //   2754: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2757: pop
    //   2758: aload 16
    //   2760: getfield 752	com/tencent/turingfd/sdk/xq/Olive:b	Z
    //   2763: ifeq +11 -> 2774
    //   2766: ldc_w 754
    //   2769: astore 14
    //   2771: goto +8 -> 2779
    //   2774: ldc_w 756
    //   2777: astore 14
    //   2779: aload 17
    //   2781: aload 14
    //   2783: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: pop
    //   2787: aload 17
    //   2789: ldc 63
    //   2791: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2794: pop
    //   2795: aload 17
    //   2797: aload 16
    //   2799: getfield 757	com/tencent/turingfd/sdk/xq/Olive:c	I
    //   2802: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2805: pop
    //   2806: aload 17
    //   2808: ldc 63
    //   2810: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: pop
    //   2814: aload 17
    //   2816: aload 16
    //   2818: getfield 758	com/tencent/turingfd/sdk/xq/Olive:d	J
    //   2821: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2824: pop
    //   2825: aload 17
    //   2827: ldc 63
    //   2829: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: pop
    //   2833: aload 17
    //   2835: aload 16
    //   2837: getfield 760	com/tencent/turingfd/sdk/xq/Olive:e	J
    //   2840: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2843: pop
    //   2844: aload 17
    //   2846: ldc 63
    //   2848: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2851: pop
    //   2852: aload 17
    //   2854: iconst_0
    //   2855: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2858: pop
    //   2859: aload 17
    //   2861: ldc 63
    //   2863: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2866: pop
    //   2867: aload 17
    //   2869: iconst_0
    //   2870: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2873: pop
    //   2874: aload 17
    //   2876: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2879: astore 16
    //   2881: new 156	java/util/HashMap
    //   2884: dup
    //   2885: invokespecial 157	java/util/HashMap:<init>	()V
    //   2888: astore 14
    //   2890: new 47	java/lang/StringBuilder
    //   2893: dup
    //   2894: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2897: astore 17
    //   2899: aload 17
    //   2901: ldc_w 611
    //   2904: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2907: pop
    //   2908: aload 17
    //   2910: iconst_1
    //   2911: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2914: pop
    //   2915: aload 14
    //   2917: aload 17
    //   2919: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2922: aload 16
    //   2924: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2927: pop
    //   2928: aload 15
    //   2930: invokestatic 606	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;)Ljava/util/Set;
    //   2933: astore 16
    //   2935: new 47	java/lang/StringBuilder
    //   2938: dup
    //   2939: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2942: astore 17
    //   2944: aload 17
    //   2946: ldc_w 297
    //   2949: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2952: pop
    //   2953: aload 17
    //   2955: iconst_1
    //   2956: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2959: pop
    //   2960: aload 17
    //   2962: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2965: astore 17
    //   2967: aload 16
    //   2969: checkcast 608	java/util/HashSet
    //   2972: astore 16
    //   2974: aload 16
    //   2976: aload 17
    //   2978: invokevirtual 763	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   2981: ifne +116 -> 3097
    //   2984: new 47	java/lang/StringBuilder
    //   2987: dup
    //   2988: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   2991: astore 17
    //   2993: aload 17
    //   2995: ldc_w 297
    //   2998: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3001: pop
    //   3002: aload 17
    //   3004: iconst_1
    //   3005: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3008: pop
    //   3009: aload 16
    //   3011: aload 17
    //   3013: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3016: invokevirtual 764	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   3019: pop
    //   3020: aload 16
    //   3022: invokevirtual 609	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   3025: astore 16
    //   3027: new 47	java/lang/StringBuilder
    //   3030: dup
    //   3031: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3034: astore 17
    //   3036: aload 16
    //   3038: invokeinterface 355 1 0
    //   3043: ifeq +40 -> 3083
    //   3046: aload 17
    //   3048: aload 16
    //   3050: invokeinterface 358 1 0
    //   3055: checkcast 279	java/lang/String
    //   3058: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3061: pop
    //   3062: aload 16
    //   3064: invokeinterface 355 1 0
    //   3069: ifeq -33 -> 3036
    //   3072: aload 17
    //   3074: ldc 63
    //   3076: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: pop
    //   3080: goto -44 -> 3036
    //   3083: aload 14
    //   3085: ldc_w 766
    //   3088: aload 17
    //   3090: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3093: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3096: pop
    //   3097: aload 15
    //   3099: aload 14
    //   3101: invokestatic 166	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   3104: aload_1
    //   3105: getfield 768	com/tencent/turingfd/sdk/xq/Nucleus:b	J
    //   3108: lstore 7
    //   3110: lload 7
    //   3112: lconst_0
    //   3113: lcmp
    //   3114: ifne +770 -> 3884
    //   3117: aload_1
    //   3118: getfield 770	com/tencent/turingfd/sdk/xq/Nucleus:c	[B
    //   3121: astore 14
    //   3123: aload 14
    //   3125: ifnull +743 -> 3868
    //   3128: aload 14
    //   3130: arraylength
    //   3131: ifne +6 -> 3137
    //   3134: goto +734 -> 3868
    //   3137: new 772	com/tencent/turingfd/sdk/xq/Vulpecula
    //   3140: dup
    //   3141: invokespecial 773	com/tencent/turingfd/sdk/xq/Vulpecula:<init>	()V
    //   3144: astore_1
    //   3145: new 775	com/tencent/turingfd/sdk/xq/try
    //   3148: dup
    //   3149: aload 14
    //   3151: invokespecial 778	com/tencent/turingfd/sdk/xq/try:<init>	([B)V
    //   3154: astore 14
    //   3156: aload 14
    //   3158: ldc_w 469
    //   3161: putfield 779	com/tencent/turingfd/sdk/xq/try:b	Ljava/lang/String;
    //   3164: aload_1
    //   3165: aload 14
    //   3167: invokevirtual 782	com/tencent/turingfd/sdk/xq/Vulpecula:a	(Lcom/tencent/turingfd/sdk/xq/try;)V
    //   3170: aload_1
    //   3171: getfield 783	com/tencent/turingfd/sdk/xq/Vulpecula:d	I
    //   3174: i2l
    //   3175: lstore 7
    //   3177: lload 7
    //   3179: lconst_0
    //   3180: lcmp
    //   3181: ifeq +19 -> 3200
    //   3184: aload 20
    //   3186: lload 7
    //   3188: ldc2_w 784
    //   3191: lsub
    //   3192: invokevirtual 480	com/tencent/turingfd/sdk/xq/Cepheus:a	(J)J
    //   3195: lstore 7
    //   3197: goto -1824 -> 1373
    //   3200: aload_1
    //   3201: getfield 788	com/tencent/turingfd/sdk/xq/Vulpecula:g	Lcom/tencent/turingfd/sdk/xq/Apple;
    //   3204: astore_1
    //   3205: aload_1
    //   3206: ifnonnull +16 -> 3222
    //   3209: aload 20
    //   3211: ldc2_w 789
    //   3214: invokevirtual 480	com/tencent/turingfd/sdk/xq/Cepheus:a	(J)J
    //   3217: lstore 7
    //   3219: goto -22 -> 3197
    //   3222: aload_1
    //   3223: getfield 793	com/tencent/turingfd/sdk/xq/Apple:h	I
    //   3226: i2l
    //   3227: lconst_0
    //   3228: lcmp
    //   3229: ifeq +19 -> 3248
    //   3232: aload 20
    //   3234: lload 7
    //   3236: ldc2_w 794
    //   3239: lsub
    //   3240: invokevirtual 480	com/tencent/turingfd/sdk/xq/Cepheus:a	(J)J
    //   3243: lstore 7
    //   3245: goto -48 -> 3197
    //   3248: aload_1
    //   3249: getfield 797	com/tencent/turingfd/sdk/xq/Apple:i	Ljava/util/List;
    //   3252: astore_1
    //   3253: aload_1
    //   3254: ifnull +582 -> 3836
    //   3257: aload_1
    //   3258: invokeinterface 800 1 0
    //   3263: ifne +6 -> 3269
    //   3266: goto +570 -> 3836
    //   3269: aload_1
    //   3270: invokeinterface 801 1 0
    //   3275: astore_1
    //   3276: aload 13
    //   3278: astore 14
    //   3280: aload_1
    //   3281: astore 13
    //   3283: aload 13
    //   3285: invokeinterface 355 1 0
    //   3290: ifeq +441 -> 3731
    //   3293: aload 13
    //   3295: invokeinterface 358 1 0
    //   3300: checkcast 803	com/tencent/turingfd/sdk/xq/Triangulum
    //   3303: astore 21
    //   3305: aload 21
    //   3307: getfield 804	com/tencent/turingfd/sdk/xq/Triangulum:f	Ljava/lang/String;
    //   3310: astore 15
    //   3312: aload 15
    //   3314: astore_1
    //   3315: aload 15
    //   3317: ifnonnull +7 -> 3324
    //   3320: ldc_w 297
    //   3323: astore_1
    //   3324: aload 21
    //   3326: getfield 807	com/tencent/turingfd/sdk/xq/Triangulum:c	Lcom/tencent/turingfd/sdk/xq/Betelnut;
    //   3329: astore 22
    //   3331: ldc_w 297
    //   3334: astore 19
    //   3336: aload 22
    //   3338: ifnull +227 -> 3565
    //   3341: aload 22
    //   3343: getfield 810	com/tencent/turingfd/sdk/xq/Betelnut:d	I
    //   3346: istore 6
    //   3348: aload 20
    //   3350: getfield 339	com/tencent/turingfd/sdk/xq/Cepheus:b	Ljava/util/Map;
    //   3353: iload 6
    //   3355: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3358: invokeinterface 733 2 0
    //   3363: ifeq +202 -> 3565
    //   3366: aload 20
    //   3368: getfield 339	com/tencent/turingfd/sdk/xq/Cepheus:b	Ljava/util/Map;
    //   3371: iload 6
    //   3373: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3376: invokeinterface 361 2 0
    //   3381: checkcast 363	com/tencent/turingfd/sdk/xq/Caelum
    //   3384: astore 23
    //   3386: aload 23
    //   3388: getfield 422	com/tencent/turingfd/sdk/xq/Caelum:g	Ljava/lang/String;
    //   3391: astore 16
    //   3393: aload 16
    //   3395: astore 15
    //   3397: aload 16
    //   3399: ifnonnull +8 -> 3407
    //   3402: ldc_w 297
    //   3405: astore 15
    //   3407: aload 23
    //   3409: getfield 431	com/tencent/turingfd/sdk/xq/Caelum:e	Ljava/lang/String;
    //   3412: astore 17
    //   3414: aload 17
    //   3416: astore 16
    //   3418: aload 17
    //   3420: ifnonnull +8 -> 3428
    //   3423: ldc_w 297
    //   3426: astore 16
    //   3428: aload 23
    //   3430: getfield 380	com/tencent/turingfd/sdk/xq/Caelum:a	Ljava/lang/String;
    //   3433: astore 18
    //   3435: aload 18
    //   3437: astore 17
    //   3439: aload 18
    //   3441: ifnonnull +8 -> 3449
    //   3444: ldc_w 297
    //   3447: astore 17
    //   3449: aload 17
    //   3451: astore 19
    //   3453: aload 23
    //   3455: getfield 374	com/tencent/turingfd/sdk/xq/Caelum:f	Ljava/lang/String;
    //   3458: astore 18
    //   3460: aload 18
    //   3462: astore 17
    //   3464: aload 18
    //   3466: ifnonnull +8 -> 3474
    //   3469: ldc_w 297
    //   3472: astore 17
    //   3474: aload 22
    //   3476: getfield 811	com/tencent/turingfd/sdk/xq/Betelnut:e	I
    //   3479: istore 4
    //   3481: aload 22
    //   3483: getfield 812	com/tencent/turingfd/sdk/xq/Betelnut:g	I
    //   3486: istore 5
    //   3488: aload_1
    //   3489: astore 18
    //   3491: aload_1
    //   3492: invokevirtual 447	java/lang/String:isEmpty	()Z
    //   3495: ifeq +20 -> 3515
    //   3498: iload 4
    //   3500: iconst_1
    //   3501: if_icmplt +20 -> 3521
    //   3504: iload 4
    //   3506: iconst_3
    //   3507: if_icmpgt +14 -> 3521
    //   3510: ldc_w 814
    //   3513: astore 18
    //   3515: aload 18
    //   3517: astore_1
    //   3518: goto +21 -> 3539
    //   3521: iload 4
    //   3523: ifeq +12 -> 3535
    //   3526: iload 4
    //   3528: iconst_4
    //   3529: if_icmpne +10 -> 3539
    //   3532: goto +3 -> 3535
    //   3535: ldc_w 816
    //   3538: astore_1
    //   3539: aload_1
    //   3540: astore 18
    //   3542: iconst_1
    //   3543: istore_3
    //   3544: lconst_0
    //   3545: lstore 7
    //   3547: aload 15
    //   3549: astore_1
    //   3550: aload 16
    //   3552: astore 15
    //   3554: aload 17
    //   3556: astore 16
    //   3558: aload 18
    //   3560: astore 17
    //   3562: goto +40 -> 3602
    //   3565: ldc_w 297
    //   3568: astore 15
    //   3570: ldc_w 297
    //   3573: astore 16
    //   3575: ldc_w 297
    //   3578: astore 18
    //   3580: iconst_m1
    //   3581: istore 6
    //   3583: iconst_0
    //   3584: istore_3
    //   3585: iconst_m1
    //   3586: istore 4
    //   3588: iconst_m1
    //   3589: istore 5
    //   3591: ldc2_w 817
    //   3594: lstore 7
    //   3596: aload_1
    //   3597: astore 17
    //   3599: aload 18
    //   3601: astore_1
    //   3602: iload 6
    //   3604: iconst_m1
    //   3605: if_icmpeq +123 -> 3728
    //   3608: aload 20
    //   3610: getfield 820	com/tencent/turingfd/sdk/xq/Cepheus:c	Ljava/util/Map;
    //   3613: astore 22
    //   3615: new 822	com/tencent/turingfd/sdk/xq/Canesatici$do
    //   3618: dup
    //   3619: iload_3
    //   3620: lload 7
    //   3622: invokespecial 825	com/tencent/turingfd/sdk/xq/Canesatici$do:<init>	(ZJ)V
    //   3625: astore 23
    //   3627: aload 23
    //   3629: aload 19
    //   3631: putfield 826	com/tencent/turingfd/sdk/xq/Canesatici$do:c	Ljava/lang/String;
    //   3634: aload 23
    //   3636: iload 4
    //   3638: putfield 827	com/tencent/turingfd/sdk/xq/Canesatici$do:d	I
    //   3641: aload 23
    //   3643: iload 5
    //   3645: putfield 828	com/tencent/turingfd/sdk/xq/Canesatici$do:e	I
    //   3648: aload 21
    //   3650: getfield 829	com/tencent/turingfd/sdk/xq/Triangulum:d	Ljava/lang/String;
    //   3653: astore 19
    //   3655: aload 19
    //   3657: astore 18
    //   3659: aload 19
    //   3661: ifnonnull +8 -> 3669
    //   3664: ldc_w 297
    //   3667: astore 18
    //   3669: aload 23
    //   3671: aload 18
    //   3673: putfield 830	com/tencent/turingfd/sdk/xq/Canesatici$do:f	Ljava/lang/String;
    //   3676: aload 23
    //   3678: aload 15
    //   3680: putfield 831	com/tencent/turingfd/sdk/xq/Canesatici$do:g	Ljava/lang/String;
    //   3683: aload 23
    //   3685: aload 16
    //   3687: putfield 832	com/tencent/turingfd/sdk/xq/Canesatici$do:h	Ljava/lang/String;
    //   3690: aload 23
    //   3692: aload_1
    //   3693: putfield 833	com/tencent/turingfd/sdk/xq/Canesatici$do:i	Ljava/lang/String;
    //   3696: aload 23
    //   3698: aload 17
    //   3700: putfield 834	com/tencent/turingfd/sdk/xq/Canesatici$do:j	Ljava/lang/String;
    //   3703: aload 22
    //   3705: iload 6
    //   3707: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3710: new 836	com/tencent/turingfd/sdk/xq/Canesatici
    //   3713: dup
    //   3714: aload 23
    //   3716: invokespecial 839	com/tencent/turingfd/sdk/xq/Canesatici:<init>	(Lcom/tencent/turingfd/sdk/xq/Canesatici$do;)V
    //   3719: invokeinterface 840 3 0
    //   3724: pop
    //   3725: goto -442 -> 3283
    //   3728: goto -445 -> 3283
    //   3731: aload 14
    //   3733: astore_1
    //   3734: aload 20
    //   3736: getfield 339	com/tencent/turingfd/sdk/xq/Cepheus:b	Ljava/util/Map;
    //   3739: invokeinterface 343 1 0
    //   3744: invokeinterface 349 1 0
    //   3749: astore 13
    //   3751: ldc2_w 841
    //   3754: lstore 7
    //   3756: aload 13
    //   3758: invokeinterface 355 1 0
    //   3763: ifeq +70 -> 3833
    //   3766: aload 13
    //   3768: invokeinterface 358 1 0
    //   3773: checkcast 99	java/lang/Integer
    //   3776: astore 14
    //   3778: aload 20
    //   3780: getfield 820	com/tencent/turingfd/sdk/xq/Cepheus:c	Ljava/util/Map;
    //   3783: aload 14
    //   3785: invokeinterface 733 2 0
    //   3790: ifne +37 -> 3827
    //   3793: aload 20
    //   3795: getfield 820	com/tencent/turingfd/sdk/xq/Cepheus:c	Ljava/util/Map;
    //   3798: aload 14
    //   3800: new 836	com/tencent/turingfd/sdk/xq/Canesatici
    //   3803: dup
    //   3804: new 822	com/tencent/turingfd/sdk/xq/Canesatici$do
    //   3807: dup
    //   3808: iconst_0
    //   3809: ldc2_w 841
    //   3812: invokespecial 825	com/tencent/turingfd/sdk/xq/Canesatici$do:<init>	(ZJ)V
    //   3815: invokespecial 839	com/tencent/turingfd/sdk/xq/Canesatici:<init>	(Lcom/tencent/turingfd/sdk/xq/Canesatici$do;)V
    //   3818: invokeinterface 840 3 0
    //   3823: pop
    //   3824: goto -68 -> 3756
    //   3827: lconst_0
    //   3828: lstore 7
    //   3830: goto -74 -> 3756
    //   3833: goto +67 -> 3900
    //   3836: aload 13
    //   3838: astore_1
    //   3839: aload 20
    //   3841: ldc2_w 841
    //   3844: invokevirtual 480	com/tencent/turingfd/sdk/xq/Cepheus:a	(J)J
    //   3847: lstore 7
    //   3849: goto +51 -> 3900
    //   3852: aload 13
    //   3854: astore_1
    //   3855: aload 20
    //   3857: ldc2_w 843
    //   3860: invokevirtual 480	com/tencent/turingfd/sdk/xq/Cepheus:a	(J)J
    //   3863: lstore 7
    //   3865: goto +35 -> 3900
    //   3868: aload 13
    //   3870: astore_1
    //   3871: aload 20
    //   3873: ldc2_w 845
    //   3876: invokevirtual 480	com/tencent/turingfd/sdk/xq/Cepheus:a	(J)J
    //   3879: lstore 7
    //   3881: goto +19 -> 3900
    //   3884: aload 13
    //   3886: astore_1
    //   3887: aload 20
    //   3889: lload 7
    //   3891: ldc2_w 847
    //   3894: lsub
    //   3895: invokevirtual 480	com/tencent/turingfd/sdk/xq/Cepheus:a	(J)J
    //   3898: lstore 7
    //   3900: iconst_0
    //   3901: istore 4
    //   3903: lload 7
    //   3905: lconst_0
    //   3906: lcmp
    //   3907: istore 5
    //   3909: iload 5
    //   3911: ifeq +115 -> 4026
    //   3914: aload_0
    //   3915: invokevirtual 81	com/tencent/turingfd/sdk/xq/CanisMinor:a	()Lcom/tencent/turingfd/sdk/xq/Centaurus;
    //   3918: aload_2
    //   3919: invokevirtual 86	com/tencent/turingfd/sdk/xq/Centaurus:a	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/synchronized;
    //   3922: astore 13
    //   3924: aload 13
    //   3926: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   3929: invokestatic 851	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3932: invokevirtual 853	com/tencent/turingfd/sdk/xq/synchronized:a	(Ljava/lang/Object;)V
    //   3935: aload_0
    //   3936: invokevirtual 81	com/tencent/turingfd/sdk/xq/CanisMinor:a	()Lcom/tencent/turingfd/sdk/xq/Centaurus;
    //   3939: astore 14
    //   3941: new 47	java/lang/StringBuilder
    //   3944: dup
    //   3945: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   3948: astore 15
    //   3950: iload 4
    //   3952: aload 13
    //   3954: getfield 91	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   3957: invokevirtual 97	java/util/LinkedList:size	()I
    //   3960: if_icmpge +51 -> 4011
    //   3963: aload 15
    //   3965: aload 13
    //   3967: getfield 91	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   3970: iload 4
    //   3972: invokevirtual 856	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   3975: invokevirtual 859	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3978: pop
    //   3979: iload 4
    //   3981: aload 13
    //   3983: getfield 91	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   3986: invokevirtual 97	java/util/LinkedList:size	()I
    //   3989: iconst_1
    //   3990: isub
    //   3991: if_icmpeq +11 -> 4002
    //   3994: aload 15
    //   3996: ldc 63
    //   3998: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4001: pop
    //   4002: iload 4
    //   4004: iconst_1
    //   4005: iadd
    //   4006: istore 4
    //   4008: goto -58 -> 3950
    //   4011: aload 14
    //   4013: aload_2
    //   4014: ldc_w 861
    //   4017: aload 15
    //   4019: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4022: iconst_1
    //   4023: invokevirtual 864	com/tencent/turingfd/sdk/xq/Centaurus:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4026: new 168	com/tencent/turingfd/sdk/xq/CanisMinor$do
    //   4029: dup
    //   4030: lload 7
    //   4032: aload_1
    //   4033: invokespecial 171	com/tencent/turingfd/sdk/xq/CanisMinor$do:<init>	(JLjava/util/Map;)V
    //   4036: astore_1
    //   4037: new 47	java/lang/StringBuilder
    //   4040: dup
    //   4041: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   4044: astore 13
    //   4046: aload 13
    //   4048: lload 7
    //   4050: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4053: pop
    //   4054: aload 13
    //   4056: ldc 63
    //   4058: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4061: pop
    //   4062: aload 13
    //   4064: lload 9
    //   4066: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4069: pop
    //   4070: aload 13
    //   4072: ldc 63
    //   4074: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4077: pop
    //   4078: aload 13
    //   4080: lload 11
    //   4082: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4085: pop
    //   4086: aload 13
    //   4088: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4091: astore 13
    //   4093: getstatic 154	com/tencent/turingfd/sdk/xq/Date:a	Ljava/lang/String;
    //   4096: astore 14
    //   4098: new 156	java/util/HashMap
    //   4101: dup
    //   4102: invokespecial 157	java/util/HashMap:<init>	()V
    //   4105: astore 14
    //   4107: aload 14
    //   4109: ldc 159
    //   4111: aload 13
    //   4113: invokevirtual 163	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4116: pop
    //   4117: aload_2
    //   4118: aload 14
    //   4120: invokestatic 166	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   4123: aload_0
    //   4124: invokevirtual 81	com/tencent/turingfd/sdk/xq/CanisMinor:a	()Lcom/tencent/turingfd/sdk/xq/Centaurus;
    //   4127: pop
    //   4128: aload_2
    //   4129: ldc 105
    //   4131: invokestatic 108	com/tencent/turingfd/sdk/xq/Centaurus:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   4134: astore 13
    //   4136: aload 13
    //   4138: invokestatic 113	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   4141: invokevirtual 117	java/lang/Long:longValue	()J
    //   4144: lstore 7
    //   4146: goto +6 -> 4152
    //   4149: lconst_0
    //   4150: lstore 7
    //   4152: iload 5
    //   4154: ifge +17 -> 4171
    //   4157: aload_0
    //   4158: invokevirtual 81	com/tencent/turingfd/sdk/xq/CanisMinor:a	()Lcom/tencent/turingfd/sdk/xq/Centaurus;
    //   4161: aload_2
    //   4162: lload 7
    //   4164: lconst_1
    //   4165: ladd
    //   4166: invokevirtual 867	com/tencent/turingfd/sdk/xq/Centaurus:a	(Landroid/content/Context;J)V
    //   4169: aload_1
    //   4170: areturn
    //   4171: lload 7
    //   4173: lconst_0
    //   4174: lcmp
    //   4175: ifeq +12 -> 4187
    //   4178: aload_0
    //   4179: invokevirtual 81	com/tencent/turingfd/sdk/xq/CanisMinor:a	()Lcom/tencent/turingfd/sdk/xq/Centaurus;
    //   4182: aload_2
    //   4183: lconst_0
    //   4184: invokevirtual 867	com/tencent/turingfd/sdk/xq/Centaurus:a	(Landroid/content/Context;J)V
    //   4187: aload_1
    //   4188: areturn
    //   4189: aload 15
    //   4191: monitorexit
    //   4192: aload_1
    //   4193: athrow
    //   4194: astore_1
    //   4195: ldc 189
    //   4197: monitorexit
    //   4198: aload_1
    //   4199: athrow
    //   4200: astore_1
    //   4201: ldc 189
    //   4203: monitorexit
    //   4204: aload_1
    //   4205: athrow
    //   4206: new 869	java/lang/IllegalArgumentException
    //   4209: dup
    //   4210: ldc_w 297
    //   4213: invokespecial 870	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   4216: astore_1
    //   4217: goto +5 -> 4222
    //   4220: aload_1
    //   4221: athrow
    //   4222: goto -2 -> 4220
    //   4225: astore 15
    //   4227: goto -4167 -> 60
    //   4230: astore_1
    //   4231: goto -3469 -> 762
    //   4234: astore_1
    //   4235: goto -3570 -> 665
    //   4238: astore_1
    //   4239: goto -3495 -> 744
    //   4242: astore_1
    //   4243: goto -2625 -> 1618
    //   4246: astore 15
    //   4248: goto -2626 -> 1622
    //   4251: astore 19
    //   4253: goto -2086 -> 2167
    //   4256: astore_1
    //   4257: goto -1916 -> 2341
    //   4260: astore 19
    //   4262: goto -1832 -> 2430
    //   4265: astore 14
    //   4267: goto -1561 -> 2706
    //   4270: astore_1
    //   4271: goto -419 -> 3852
    //   4274: astore 13
    //   4276: goto -127 -> 4149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4279	0	this	CanisMinor
    //   0	4279	1	paramMap	java.util.Map<java.lang.Integer, Caelum>
    //   0	4279	2	paramContext	android.content.Context
    //   0	4279	3	paramBoolean	boolean
    //   18	3989	4	i	int
    //   146	3498	5	j	int
    //   3907	246	5	bool	boolean
    //   3346	360	6	k	int
    //   55	4117	7	l1	long
    //   87	3978	9	l2	long
    //   409	3672	11	l3	long
    //   8	4129	13	localObject1	Object
    //   4274	1	13	localObject2	Object
    //   24	4095	14	localObject3	Object
    //   4265	1	14	localObject4	Object
    //   45	4145	15	localObject5	Object
    //   4225	1	15	localObject6	Object
    //   4246	1	15	localObject7	Object
    //   447	3239	16	localObject8	Object
    //   439	3260	17	localObject9	Object
    //   459	3213	18	localObject10	Object
    //   544	3116	19	localObject11	Object
    //   4251	1	19	localObject12	Object
    //   4260	1	19	localInterruptedException	java.lang.InterruptedException
    //   398	3490	20	localCepheus	Cepheus
    //   872	2777	21	localObject13	Object
    //   881	2823	22	localObject14	Object
    //   3384	331	23	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   444	449	1346	finally
    //   1543	1548	1660	finally
    //   2415	2423	2426	finally
    //   2430	2433	2426	finally
    //   4189	4192	2426	finally
    //   2251	2255	4194	finally
    //   1771	1776	4200	finally
    //   47	57	4225	finally
    //   546	607	4230	java/lang/Exception
    //   669	693	4230	java/lang/Exception
    //   750	755	4230	java/lang/Exception
    //   755	762	4230	java/lang/Exception
    //   607	614	4234	finally
    //   614	657	4234	finally
    //   693	722	4238	finally
    //   734	741	4238	finally
    //   1589	1608	4242	finally
    //   1608	1615	4246	finally
    //   2137	2164	4251	finally
    //   2268	2315	4256	java/lang/Exception
    //   2319	2327	4256	java/lang/Exception
    //   2330	2341	4256	java/lang/Exception
    //   2415	2423	4260	java/lang/InterruptedException
    //   2543	2552	4265	finally
    //   3137	3156	4270	finally
    //   3156	3170	4270	finally
    //   4136	4146	4274	finally
  }
  
  public final Centaurus a()
  {
    if (this.d == null)
    {
      HandlerThread localHandlerThread = new HandlerThread(this.f, -8);
      localHandlerThread.start();
      this.d = new Handler(localHandlerThread.getLooper());
    }
    return new Centaurus(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.CanisMinor
 * JD-Core Version:    0.7.0.1
 */