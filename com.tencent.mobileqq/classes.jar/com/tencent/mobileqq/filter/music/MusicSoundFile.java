package com.tencent.mobileqq.filter.music;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"NewApi"})
public class MusicSoundFile
{
  private int jdField_a_of_type_Int;
  private MusicSoundFile.ProgressListener jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile$ProgressListener = null;
  private ArrayList<Float> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int b = 0;
  private int c = 1024;
  
  public MusicSoundFile()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private int a(int paramInt)
  {
    double d1 = paramInt;
    Double.isNaN(d1);
    double d2 = this.jdField_a_of_type_Int;
    Double.isNaN(d2);
    double d3 = a();
    Double.isNaN(d3);
    return (int)(d1 * 1.0D * d2 / (d3 * 1000.0D) + 0.5D);
  }
  
  private void a(MusicSoundFile.ProgressListener paramProgressListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile$ProgressListener = paramProgressListener;
  }
  
  public static boolean a()
  {
    return ("Meizu".equals(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT <= 22);
  }
  
  /* Error */
  private boolean a(File paramFile, int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    // Byte code:
    //   0: new 79	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 80	android/media/MediaExtractor:<init>	()V
    //   7: astore 30
    //   9: aload_1
    //   10: invokevirtual 86	java/io/File:length	()J
    //   13: l2i
    //   14: istore 20
    //   16: aload 30
    //   18: aload_1
    //   19: invokevirtual 90	java/io/File:getPath	()Ljava/lang/String;
    //   22: invokevirtual 94	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   25: aload 30
    //   27: invokevirtual 97	android/media/MediaExtractor:getTrackCount	()I
    //   30: istore 14
    //   32: aconst_null
    //   33: astore 24
    //   35: iconst_0
    //   36: istore 13
    //   38: iload 13
    //   40: iload 14
    //   42: if_icmpge +51 -> 93
    //   45: aload 30
    //   47: iload 13
    //   49: invokevirtual 101	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   52: astore 24
    //   54: aload 24
    //   56: ifnull +28 -> 84
    //   59: aload 24
    //   61: ldc 103
    //   63: invokevirtual 109	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: ldc 111
    //   68: invokevirtual 115	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifeq +13 -> 84
    //   74: aload 30
    //   76: iload 13
    //   78: invokevirtual 119	android/media/MediaExtractor:selectTrack	(I)V
    //   81: goto +12 -> 93
    //   84: iload 13
    //   86: iconst_1
    //   87: iadd
    //   88: istore 13
    //   90: goto -52 -> 38
    //   93: iload 13
    //   95: iload 14
    //   97: if_icmpeq +2036 -> 2133
    //   100: aload 24
    //   102: ifnonnull +10 -> 112
    //   105: aload 30
    //   107: invokevirtual 122	android/media/MediaExtractor:release	()V
    //   110: iconst_0
    //   111: ireturn
    //   112: aload_3
    //   113: getfield 127	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   116: iload_2
    //   117: iadd
    //   118: istore 13
    //   120: iload 13
    //   122: ifle +16 -> 138
    //   125: aload 30
    //   127: iload 13
    //   129: i2l
    //   130: ldc2_w 128
    //   133: lmul
    //   134: iconst_2
    //   135: invokevirtual 133	android/media/MediaExtractor:seekTo	(JI)V
    //   138: aload 24
    //   140: ldc 135
    //   142: invokevirtual 139	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   145: istore 16
    //   147: aload_0
    //   148: aload 24
    //   150: ldc 141
    //   152: invokevirtual 139	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   155: putfield 42	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_Int	I
    //   158: aload_3
    //   159: invokevirtual 144	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:isMyMusicInfo	()Z
    //   162: ifeq +18 -> 180
    //   165: aload_3
    //   166: getfield 147	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicEnd	I
    //   169: istore 14
    //   171: aload_3
    //   172: getfield 127	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   175: istore 13
    //   177: goto +26 -> 203
    //   180: aload 24
    //   182: ldc 149
    //   184: invokevirtual 153	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   187: l2f
    //   188: ldc 154
    //   190: fdiv
    //   191: ldc 155
    //   193: fadd
    //   194: f2i
    //   195: istore 14
    //   197: aload_3
    //   198: getfield 127	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   201: istore 13
    //   203: iload 14
    //   205: iload 13
    //   207: iload_2
    //   208: iadd
    //   209: isub
    //   210: i2f
    //   211: ldc 154
    //   213: fdiv
    //   214: aload_0
    //   215: getfield 42	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_Int	I
    //   218: i2f
    //   219: fmul
    //   220: ldc 155
    //   222: fadd
    //   223: f2i
    //   224: istore 21
    //   226: aload_0
    //   227: sipush 1024
    //   230: putfield 23	com/tencent/mobileqq/filter/music/MusicSoundFile:c	I
    //   233: aload_0
    //   234: getfield 42	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_Int	I
    //   237: i2f
    //   238: fstore 10
    //   240: aload_0
    //   241: getfield 23	com/tencent/mobileqq/filter/music/MusicSoundFile:c	I
    //   244: istore_2
    //   245: fload 10
    //   247: fconst_1
    //   248: fmul
    //   249: iload_2
    //   250: i2f
    //   251: fdiv
    //   252: ldc 156
    //   254: fcmpg
    //   255: ifge +20 -> 275
    //   258: iload_2
    //   259: sipush 128
    //   262: if_icmple +13 -> 275
    //   265: aload_0
    //   266: iload_2
    //   267: iconst_2
    //   268: idiv
    //   269: putfield 23	com/tencent/mobileqq/filter/music/MusicSoundFile:c	I
    //   272: goto -39 -> 233
    //   275: aload 24
    //   277: ldc 103
    //   279: invokevirtual 109	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokestatic 162	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   285: astore 33
    //   287: aload 33
    //   289: aload 24
    //   291: aconst_null
    //   292: aconst_null
    //   293: iconst_0
    //   294: invokevirtual 166	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   297: aload 33
    //   299: invokevirtual 169	android/media/MediaCodec:start	()V
    //   302: aload 33
    //   304: invokevirtual 173	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   307: astore 34
    //   309: aload 33
    //   311: invokevirtual 176	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   314: astore 25
    //   316: new 178	android/media/MediaCodec$BufferInfo
    //   319: dup
    //   320: invokespecial 179	android/media/MediaCodec$BufferInfo:<init>	()V
    //   323: astore 29
    //   325: ldc 180
    //   327: invokestatic 186	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   330: astore_1
    //   331: iconst_1
    //   332: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   335: astore 26
    //   337: aload_0
    //   338: monitorenter
    //   339: aload_0
    //   340: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   343: invokevirtual 195	java/util/ArrayList:clear	()V
    //   346: aload_0
    //   347: monitorexit
    //   348: aload_0
    //   349: iconst_0
    //   350: putfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   353: aload_0
    //   354: invokevirtual 45	com/tencent/mobileqq/filter/music/MusicSoundFile:a	()I
    //   357: iload 16
    //   359: imul
    //   360: newarray short
    //   362: astore 28
    //   364: aload_0
    //   365: iconst_1
    //   366: putfield 25	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_Boolean	Z
    //   369: aconst_null
    //   370: astore 27
    //   372: iconst_0
    //   373: istore 14
    //   375: iconst_0
    //   376: istore 15
    //   378: iconst_0
    //   379: istore 13
    //   381: ldc 196
    //   383: fstore 11
    //   385: ldc 196
    //   387: fstore 10
    //   389: ldc 196
    //   391: fstore 12
    //   393: aload 24
    //   395: astore 31
    //   397: iload 16
    //   399: istore_2
    //   400: aload 33
    //   402: ldc2_w 197
    //   405: invokevirtual 202	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   408: istore 16
    //   410: iload 15
    //   412: ifne +215 -> 627
    //   415: iload 16
    //   417: iflt +210 -> 627
    //   420: aload 30
    //   422: aload 34
    //   424: iload 16
    //   426: aaload
    //   427: iconst_0
    //   428: invokevirtual 206	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   431: istore 17
    //   433: aload 26
    //   435: invokevirtual 209	java/lang/Boolean:booleanValue	()Z
    //   438: istore 23
    //   440: iload 23
    //   442: ifeq +44 -> 486
    //   445: aload 31
    //   447: ldc 103
    //   449: invokevirtual 109	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   452: ldc 211
    //   454: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   457: ifeq +29 -> 486
    //   460: iload 17
    //   462: iconst_2
    //   463: if_icmpne +23 -> 486
    //   466: aload 30
    //   468: invokevirtual 214	android/media/MediaExtractor:advance	()Z
    //   471: pop
    //   472: iload 13
    //   474: iload 17
    //   476: iadd
    //   477: istore 13
    //   479: goto +131 -> 610
    //   482: astore_3
    //   483: goto +141 -> 624
    //   486: iload 17
    //   488: ifge +22 -> 510
    //   491: aload 33
    //   493: iload 16
    //   495: iconst_0
    //   496: iconst_0
    //   497: ldc2_w 215
    //   500: iconst_4
    //   501: invokevirtual 220	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   504: iconst_1
    //   505: istore 15
    //   507: goto +103 -> 610
    //   510: aload_1
    //   511: astore_3
    //   512: aload 33
    //   514: iload 16
    //   516: iconst_0
    //   517: iload 17
    //   519: aload 30
    //   521: invokevirtual 223	android/media/MediaExtractor:getSampleTime	()J
    //   524: iconst_0
    //   525: invokevirtual 220	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   528: aload 30
    //   530: invokevirtual 214	android/media/MediaExtractor:advance	()Z
    //   533: pop
    //   534: iload 13
    //   536: iload 17
    //   538: iadd
    //   539: istore 13
    //   541: aload_0
    //   542: getfield 21	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile$ProgressListener	Lcom/tencent/mobileqq/filter/music/MusicSoundFile$ProgressListener;
    //   545: ifnull +65 -> 610
    //   548: aload_0
    //   549: getfield 21	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_ComTencentMobileqqFilterMusicMusicSoundFile$ProgressListener	Lcom/tencent/mobileqq/filter/music/MusicSoundFile$ProgressListener;
    //   552: iload 13
    //   554: i2f
    //   555: iload 20
    //   557: i2f
    //   558: fdiv
    //   559: f2d
    //   560: invokeinterface 227 3 0
    //   565: ifne +45 -> 610
    //   568: aload_3
    //   569: invokevirtual 230	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   572: pop
    //   573: aload 30
    //   575: invokevirtual 122	android/media/MediaExtractor:release	()V
    //   578: aload 33
    //   580: invokevirtual 233	android/media/MediaCodec:stop	()V
    //   583: aload 33
    //   585: invokevirtual 234	android/media/MediaCodec:release	()V
    //   588: aload_3
    //   589: invokevirtual 230	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   592: pop
    //   593: aload 30
    //   595: invokevirtual 122	android/media/MediaExtractor:release	()V
    //   598: aload 33
    //   600: invokevirtual 233	android/media/MediaCodec:stop	()V
    //   603: aload 33
    //   605: invokevirtual 234	android/media/MediaCodec:release	()V
    //   608: iconst_1
    //   609: ireturn
    //   610: iconst_0
    //   611: invokestatic 192	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   614: astore 26
    //   616: goto +11 -> 627
    //   619: astore_3
    //   620: goto +1413 -> 2033
    //   623: astore_3
    //   624: goto +1445 -> 2069
    //   627: aload_1
    //   628: astore_3
    //   629: aload 29
    //   631: astore 32
    //   633: aload 33
    //   635: aload 32
    //   637: ldc2_w 197
    //   640: invokevirtual 238	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   643: istore 18
    //   645: iload 18
    //   647: iflt +625 -> 1272
    //   650: aload 32
    //   652: getfield 241	android/media/MediaCodec$BufferInfo:size	I
    //   655: ifle +617 -> 1272
    //   658: aload 32
    //   660: getfield 241	android/media/MediaCodec$BufferInfo:size	I
    //   663: istore 16
    //   665: iload 14
    //   667: iload 16
    //   669: if_icmpge +23 -> 692
    //   672: aload 32
    //   674: getfield 241	android/media/MediaCodec$BufferInfo:size	I
    //   677: istore 14
    //   679: iload 14
    //   681: newarray byte
    //   683: astore 27
    //   685: goto +7 -> 692
    //   688: astore_3
    //   689: goto -65 -> 624
    //   692: aload 25
    //   694: iload 18
    //   696: aaload
    //   697: aload 27
    //   699: iconst_0
    //   700: aload 32
    //   702: getfield 241	android/media/MediaCodec$BufferInfo:size	I
    //   705: invokevirtual 245	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   708: pop
    //   709: aload 25
    //   711: iload 18
    //   713: aaload
    //   714: invokevirtual 230	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   717: pop
    //   718: aload_3
    //   719: invokevirtual 248	java/nio/ByteBuffer:remaining	()I
    //   722: aload 32
    //   724: getfield 241	android/media/MediaCodec$BufferInfo:size	I
    //   727: if_icmpge +1471 -> 2198
    //   730: aload_3
    //   731: invokevirtual 251	java/nio/ByteBuffer:position	()I
    //   734: istore 19
    //   736: iload 19
    //   738: i2d
    //   739: dstore 4
    //   741: iload 20
    //   743: i2d
    //   744: dstore 6
    //   746: dload 6
    //   748: invokestatic 40	java/lang/Double:isNaN	(D)Z
    //   751: pop
    //   752: iload 13
    //   754: i2d
    //   755: dstore 8
    //   757: dload 8
    //   759: invokestatic 40	java/lang/Double:isNaN	(D)Z
    //   762: pop
    //   763: dload 6
    //   765: dconst_1
    //   766: dmul
    //   767: dload 8
    //   769: ddiv
    //   770: dstore 6
    //   772: dload 4
    //   774: invokestatic 40	java/lang/Double:isNaN	(D)Z
    //   777: pop
    //   778: dload 4
    //   780: dload 6
    //   782: dmul
    //   783: ldc2_w 252
    //   786: dmul
    //   787: d2i
    //   788: istore 17
    //   790: aload 32
    //   792: getfield 241	android/media/MediaCodec$BufferInfo:size	I
    //   795: istore 22
    //   797: iload 17
    //   799: istore 16
    //   801: iload 17
    //   803: iload 19
    //   805: isub
    //   806: iload 22
    //   808: ldc 254
    //   810: iadd
    //   811: if_icmpge +33 -> 844
    //   814: aload 32
    //   816: getfield 241	android/media/MediaCodec$BufferInfo:size	I
    //   819: istore 16
    //   821: iload 16
    //   823: iload 19
    //   825: iadd
    //   826: ldc 254
    //   828: iadd
    //   829: istore 16
    //   831: goto +13 -> 844
    //   834: astore 24
    //   836: aload_3
    //   837: astore_1
    //   838: aload 24
    //   840: astore_3
    //   841: goto +1228 -> 2069
    //   844: bipush 10
    //   846: istore 17
    //   848: iload 17
    //   850: ifle +21 -> 871
    //   853: iload 16
    //   855: invokestatic 186	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   858: astore_1
    //   859: goto +14 -> 873
    //   862: iload 17
    //   864: iconst_1
    //   865: isub
    //   866: istore 17
    //   868: goto -20 -> 848
    //   871: aconst_null
    //   872: astore_1
    //   873: iload 17
    //   875: ifne +8 -> 883
    //   878: aload_3
    //   879: astore_1
    //   880: goto +1118 -> 1998
    //   883: aload_3
    //   884: invokevirtual 257	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   887: pop
    //   888: aload_3
    //   889: astore 29
    //   891: aload 29
    //   893: astore_3
    //   894: aload 29
    //   896: astore 24
    //   898: aload_1
    //   899: aload 29
    //   901: invokevirtual 261	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   904: pop
    //   905: aload_1
    //   906: astore_3
    //   907: aload_1
    //   908: astore 24
    //   910: aload_1
    //   911: iload 19
    //   913: invokevirtual 264	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   916: pop
    //   917: goto +3 -> 920
    //   920: aload_1
    //   921: astore_3
    //   922: aload_1
    //   923: astore 24
    //   925: aload_1
    //   926: aload 27
    //   928: iconst_0
    //   929: aload 32
    //   931: getfield 241	android/media/MediaCodec$BufferInfo:size	I
    //   934: invokevirtual 266	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   937: pop
    //   938: aload_1
    //   939: astore_3
    //   940: aload_1
    //   941: astore 24
    //   943: aload 33
    //   945: iload 18
    //   947: iconst_0
    //   948: invokevirtual 270	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   951: aload_1
    //   952: astore_3
    //   953: aload_1
    //   954: astore 24
    //   956: aload_1
    //   957: invokevirtual 251	java/nio/ByteBuffer:position	()I
    //   960: istore 22
    //   962: aload_1
    //   963: astore_3
    //   964: aload_1
    //   965: astore 24
    //   967: iload 22
    //   969: aload_0
    //   970: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   973: isub
    //   974: aload_0
    //   975: invokevirtual 45	com/tencent/mobileqq/filter/music/MusicSoundFile:a	()I
    //   978: iconst_2
    //   979: imul
    //   980: iload_2
    //   981: imul
    //   982: if_icmple +276 -> 1258
    //   985: aload_1
    //   986: astore_3
    //   987: aload_1
    //   988: astore 24
    //   990: aload_1
    //   991: aload_0
    //   992: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   995: invokevirtual 264	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   998: pop
    //   999: aload_1
    //   1000: astore_3
    //   1001: aload_1
    //   1002: astore 24
    //   1004: aload_1
    //   1005: getstatic 276	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1008: invokevirtual 280	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1011: invokevirtual 284	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1014: aload 28
    //   1016: invokevirtual 289	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1019: pop
    //   1020: aload_1
    //   1021: astore_3
    //   1022: aload_1
    //   1023: astore 24
    //   1025: aload_1
    //   1026: iload 22
    //   1028: invokevirtual 264	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1031: pop
    //   1032: aload_1
    //   1033: astore_3
    //   1034: aload_1
    //   1035: astore 24
    //   1037: aload_0
    //   1038: aload_0
    //   1039: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1042: aload_0
    //   1043: invokevirtual 45	com/tencent/mobileqq/filter/music/MusicSoundFile:a	()I
    //   1046: iconst_2
    //   1047: imul
    //   1048: iload_2
    //   1049: imul
    //   1050: iadd
    //   1051: putfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1054: iconst_0
    //   1055: istore 16
    //   1057: iconst_m1
    //   1058: istore 17
    //   1060: aload_1
    //   1061: astore_3
    //   1062: aload_1
    //   1063: astore 24
    //   1065: iload 16
    //   1067: aload 28
    //   1069: arraylength
    //   1070: iload_2
    //   1071: idiv
    //   1072: if_icmpge +76 -> 1148
    //   1075: iconst_0
    //   1076: istore 18
    //   1078: iconst_0
    //   1079: istore 19
    //   1081: iload 18
    //   1083: iload_2
    //   1084: if_icmpge +35 -> 1119
    //   1087: aload_1
    //   1088: astore_3
    //   1089: aload_1
    //   1090: astore 24
    //   1092: iload 19
    //   1094: aload 28
    //   1096: iload 16
    //   1098: iload_2
    //   1099: imul
    //   1100: iload 18
    //   1102: iadd
    //   1103: saload
    //   1104: invokestatic 294	java/lang/Math:abs	(I)I
    //   1107: iadd
    //   1108: istore 19
    //   1110: iload 18
    //   1112: iconst_1
    //   1113: iadd
    //   1114: istore 18
    //   1116: goto -35 -> 1081
    //   1119: aload_1
    //   1120: astore_3
    //   1121: aload_1
    //   1122: astore 24
    //   1124: iload 19
    //   1126: iload_2
    //   1127: idiv
    //   1128: istore 19
    //   1130: iload 17
    //   1132: istore 18
    //   1134: iload 17
    //   1136: iload 19
    //   1138: if_icmpge +1065 -> 2203
    //   1141: iload 19
    //   1143: istore 18
    //   1145: goto +1058 -> 2203
    //   1148: aload_1
    //   1149: astore_3
    //   1150: aload_1
    //   1151: astore 24
    //   1153: iload 17
    //   1155: i2d
    //   1156: invokestatic 298	java/lang/Math:sqrt	(D)D
    //   1159: d2f
    //   1160: fstore 12
    //   1162: aload_1
    //   1163: astore_3
    //   1164: aload_1
    //   1165: astore 24
    //   1167: aload_0
    //   1168: monitorenter
    //   1169: fload 10
    //   1171: fconst_0
    //   1172: fcmpg
    //   1173: ifge +6 -> 1179
    //   1176: goto +57 -> 1233
    //   1179: fload 11
    //   1181: fconst_0
    //   1182: fcmpg
    //   1183: ifge +24 -> 1207
    //   1186: aload_0
    //   1187: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1190: fload 10
    //   1192: fload 12
    //   1194: fadd
    //   1195: fconst_2
    //   1196: fdiv
    //   1197: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1200: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1203: pop
    //   1204: goto +1012 -> 2216
    //   1207: aload_0
    //   1208: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1211: fload 11
    //   1213: fload 10
    //   1215: fadd
    //   1216: fload 12
    //   1218: fadd
    //   1219: ldc_w 307
    //   1222: fdiv
    //   1223: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1226: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1229: pop
    //   1230: goto +986 -> 2216
    //   1233: aload_0
    //   1234: monitorexit
    //   1235: fload 12
    //   1237: fstore 10
    //   1239: fload 10
    //   1241: fstore 12
    //   1243: goto -281 -> 962
    //   1246: astore 25
    //   1248: aload_0
    //   1249: monitorexit
    //   1250: aload_1
    //   1251: astore_3
    //   1252: aload_1
    //   1253: astore 24
    //   1255: aload 25
    //   1257: athrow
    //   1258: goto +38 -> 1296
    //   1261: astore_1
    //   1262: goto +844 -> 2106
    //   1265: astore_3
    //   1266: aload 24
    //   1268: astore_1
    //   1269: goto +800 -> 2069
    //   1272: aload_3
    //   1273: astore_1
    //   1274: iload 18
    //   1276: bipush 253
    //   1278: if_icmpne +953 -> 2231
    //   1281: aload_1
    //   1282: astore_3
    //   1283: aload_1
    //   1284: astore 24
    //   1286: aload 33
    //   1288: invokevirtual 176	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1291: astore 25
    //   1293: goto +938 -> 2231
    //   1296: aload_1
    //   1297: astore_3
    //   1298: aload_1
    //   1299: astore 24
    //   1301: aload 32
    //   1303: getfield 310	android/media/MediaCodec$BufferInfo:flags	I
    //   1306: iconst_4
    //   1307: iand
    //   1308: ifne +24 -> 1332
    //   1311: aload_1
    //   1312: astore_3
    //   1313: aload_1
    //   1314: astore 24
    //   1316: aload_1
    //   1317: invokevirtual 251	java/nio/ByteBuffer:position	()I
    //   1320: iload_2
    //   1321: iconst_2
    //   1322: imul
    //   1323: idiv
    //   1324: iload 21
    //   1326: if_icmplt +908 -> 2234
    //   1329: goto +3 -> 1332
    //   1332: aload_1
    //   1333: astore_3
    //   1334: aload_1
    //   1335: astore 24
    //   1337: aload_1
    //   1338: invokevirtual 251	java/nio/ByteBuffer:position	()I
    //   1341: istore 17
    //   1343: aload_1
    //   1344: astore_3
    //   1345: aload_1
    //   1346: astore 24
    //   1348: iload 17
    //   1350: aload_0
    //   1351: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1354: isub
    //   1355: aload_0
    //   1356: invokevirtual 45	com/tencent/mobileqq/filter/music/MusicSoundFile:a	()I
    //   1359: iconst_2
    //   1360: imul
    //   1361: iload_2
    //   1362: imul
    //   1363: if_icmple +277 -> 1640
    //   1366: aload_1
    //   1367: astore_3
    //   1368: aload_1
    //   1369: astore 24
    //   1371: aload_1
    //   1372: aload_0
    //   1373: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1376: invokevirtual 264	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1379: pop
    //   1380: aload_1
    //   1381: astore_3
    //   1382: aload_1
    //   1383: astore 24
    //   1385: aload_1
    //   1386: getstatic 276	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1389: invokevirtual 280	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1392: invokevirtual 284	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1395: aload 28
    //   1397: invokevirtual 289	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1400: pop
    //   1401: aload_1
    //   1402: astore_3
    //   1403: aload_1
    //   1404: astore 24
    //   1406: aload_1
    //   1407: iload 17
    //   1409: invokevirtual 264	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1412: pop
    //   1413: aload_1
    //   1414: astore_3
    //   1415: aload_1
    //   1416: astore 24
    //   1418: aload_0
    //   1419: aload_0
    //   1420: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1423: aload_0
    //   1424: invokevirtual 45	com/tencent/mobileqq/filter/music/MusicSoundFile:a	()I
    //   1427: iconst_2
    //   1428: imul
    //   1429: iload_2
    //   1430: imul
    //   1431: iadd
    //   1432: putfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1435: iconst_0
    //   1436: istore 13
    //   1438: iconst_m1
    //   1439: istore 14
    //   1441: aload_1
    //   1442: astore_3
    //   1443: aload_1
    //   1444: astore 24
    //   1446: iload 13
    //   1448: aload 28
    //   1450: arraylength
    //   1451: iload_2
    //   1452: idiv
    //   1453: if_icmpge +76 -> 1529
    //   1456: iconst_0
    //   1457: istore 15
    //   1459: iconst_0
    //   1460: istore 16
    //   1462: iload 15
    //   1464: iload_2
    //   1465: if_icmpge +35 -> 1500
    //   1468: aload_1
    //   1469: astore_3
    //   1470: aload_1
    //   1471: astore 24
    //   1473: iload 16
    //   1475: aload 28
    //   1477: iload 13
    //   1479: iload_2
    //   1480: imul
    //   1481: iload 15
    //   1483: iadd
    //   1484: saload
    //   1485: invokestatic 294	java/lang/Math:abs	(I)I
    //   1488: iadd
    //   1489: istore 16
    //   1491: iload 15
    //   1493: iconst_1
    //   1494: iadd
    //   1495: istore 15
    //   1497: goto -35 -> 1462
    //   1500: aload_1
    //   1501: astore_3
    //   1502: aload_1
    //   1503: astore 24
    //   1505: iload 16
    //   1507: iload_2
    //   1508: idiv
    //   1509: istore 16
    //   1511: iload 14
    //   1513: istore 15
    //   1515: iload 14
    //   1517: iload 16
    //   1519: if_icmpge +722 -> 2241
    //   1522: iload 16
    //   1524: istore 15
    //   1526: goto +715 -> 2241
    //   1529: aload_1
    //   1530: astore_3
    //   1531: aload_1
    //   1532: astore 24
    //   1534: iload 14
    //   1536: i2d
    //   1537: invokestatic 298	java/lang/Math:sqrt	(D)D
    //   1540: d2i
    //   1541: i2f
    //   1542: fstore 12
    //   1544: aload_1
    //   1545: astore_3
    //   1546: aload_1
    //   1547: astore 24
    //   1549: aload_0
    //   1550: monitorenter
    //   1551: fload 10
    //   1553: fconst_0
    //   1554: fcmpg
    //   1555: ifge +6 -> 1561
    //   1558: goto +57 -> 1615
    //   1561: fload 11
    //   1563: fconst_0
    //   1564: fcmpg
    //   1565: ifge +24 -> 1589
    //   1568: aload_0
    //   1569: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1572: fload 10
    //   1574: fload 12
    //   1576: fadd
    //   1577: fconst_2
    //   1578: fdiv
    //   1579: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1582: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1585: pop
    //   1586: goto +668 -> 2254
    //   1589: aload_0
    //   1590: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1593: fload 11
    //   1595: fload 10
    //   1597: fadd
    //   1598: fload 12
    //   1600: fadd
    //   1601: ldc_w 307
    //   1604: fdiv
    //   1605: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1608: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1611: pop
    //   1612: goto +642 -> 2254
    //   1615: aload_0
    //   1616: monitorexit
    //   1617: fload 12
    //   1619: fstore 10
    //   1621: fload 10
    //   1623: fstore 12
    //   1625: goto -282 -> 1343
    //   1628: astore 25
    //   1630: aload_0
    //   1631: monitorexit
    //   1632: aload_1
    //   1633: astore_3
    //   1634: aload_1
    //   1635: astore 24
    //   1637: aload 25
    //   1639: athrow
    //   1640: aload_1
    //   1641: astore_3
    //   1642: aload_1
    //   1643: astore 24
    //   1645: iload 17
    //   1647: aload_0
    //   1648: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1651: if_icmple +320 -> 1971
    //   1654: aload_1
    //   1655: astore_3
    //   1656: aload_1
    //   1657: astore 24
    //   1659: iload 17
    //   1661: aload_0
    //   1662: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1665: isub
    //   1666: iconst_2
    //   1667: idiv
    //   1668: newarray short
    //   1670: astore 25
    //   1672: aload_1
    //   1673: astore_3
    //   1674: aload_1
    //   1675: astore 24
    //   1677: aload_1
    //   1678: aload_0
    //   1679: getfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1682: invokevirtual 264	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1685: pop
    //   1686: aload_1
    //   1687: astore_3
    //   1688: aload_1
    //   1689: astore 24
    //   1691: aload_1
    //   1692: getstatic 276	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1695: invokevirtual 280	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1698: invokevirtual 284	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1701: aload 25
    //   1703: invokevirtual 289	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1706: pop
    //   1707: aload_1
    //   1708: astore_3
    //   1709: aload_1
    //   1710: astore 24
    //   1712: aload_1
    //   1713: iload 17
    //   1715: invokevirtual 264	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1718: pop
    //   1719: aload_1
    //   1720: astore_3
    //   1721: aload_1
    //   1722: astore 24
    //   1724: aload_0
    //   1725: iload 17
    //   1727: putfield 27	com/tencent/mobileqq/filter/music/MusicSoundFile:b	I
    //   1730: iconst_0
    //   1731: istore 13
    //   1733: iconst_m1
    //   1734: istore 14
    //   1736: aload_1
    //   1737: astore_3
    //   1738: aload_1
    //   1739: astore 24
    //   1741: iload 13
    //   1743: aload 25
    //   1745: arraylength
    //   1746: iload_2
    //   1747: idiv
    //   1748: if_icmpge +76 -> 1824
    //   1751: iconst_0
    //   1752: istore 15
    //   1754: iconst_0
    //   1755: istore 16
    //   1757: iload 15
    //   1759: iload_2
    //   1760: if_icmpge +35 -> 1795
    //   1763: aload_1
    //   1764: astore_3
    //   1765: aload_1
    //   1766: astore 24
    //   1768: iload 16
    //   1770: aload 25
    //   1772: iload 13
    //   1774: iload_2
    //   1775: imul
    //   1776: iload 15
    //   1778: iadd
    //   1779: saload
    //   1780: invokestatic 294	java/lang/Math:abs	(I)I
    //   1783: iadd
    //   1784: istore 16
    //   1786: iload 15
    //   1788: iconst_1
    //   1789: iadd
    //   1790: istore 15
    //   1792: goto -35 -> 1757
    //   1795: aload_1
    //   1796: astore_3
    //   1797: aload_1
    //   1798: astore 24
    //   1800: iload 16
    //   1802: iload_2
    //   1803: idiv
    //   1804: istore 16
    //   1806: iload 14
    //   1808: istore 15
    //   1810: iload 14
    //   1812: iload 16
    //   1814: if_icmpge +447 -> 2261
    //   1817: iload 16
    //   1819: istore 15
    //   1821: goto +440 -> 2261
    //   1824: aload_1
    //   1825: astore_3
    //   1826: aload_1
    //   1827: astore 24
    //   1829: iload 14
    //   1831: i2d
    //   1832: invokestatic 298	java/lang/Math:sqrt	(D)D
    //   1835: d2f
    //   1836: fstore 12
    //   1838: aload_1
    //   1839: astore_3
    //   1840: aload_1
    //   1841: astore 24
    //   1843: aload_0
    //   1844: monitorenter
    //   1845: fload 10
    //   1847: fconst_0
    //   1848: fcmpg
    //   1849: ifge +19 -> 1868
    //   1852: aload_0
    //   1853: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1856: fload 12
    //   1858: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1861: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1864: pop
    //   1865: goto +91 -> 1956
    //   1868: fload 11
    //   1870: fconst_0
    //   1871: fcmpg
    //   1872: ifge +43 -> 1915
    //   1875: aload_0
    //   1876: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1879: astore_3
    //   1880: fload 10
    //   1882: fload 12
    //   1884: fadd
    //   1885: fconst_2
    //   1886: fdiv
    //   1887: fstore 10
    //   1889: aload_3
    //   1890: fload 10
    //   1892: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1895: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1898: pop
    //   1899: aload_0
    //   1900: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1903: fload 10
    //   1905: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1908: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1911: pop
    //   1912: goto +44 -> 1956
    //   1915: aload_0
    //   1916: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1919: fload 11
    //   1921: fload 10
    //   1923: fadd
    //   1924: fload 12
    //   1926: fadd
    //   1927: ldc_w 307
    //   1930: fdiv
    //   1931: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1934: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1937: pop
    //   1938: aload_0
    //   1939: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1942: fload 10
    //   1944: fload 12
    //   1946: fadd
    //   1947: fconst_2
    //   1948: fdiv
    //   1949: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1952: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1955: pop
    //   1956: aload_0
    //   1957: monitorexit
    //   1958: goto +40 -> 1998
    //   1961: aload_0
    //   1962: monitorexit
    //   1963: aload_1
    //   1964: astore_3
    //   1965: aload_1
    //   1966: astore 24
    //   1968: aload 25
    //   1970: athrow
    //   1971: aload_1
    //   1972: astore_3
    //   1973: aload_1
    //   1974: astore 24
    //   1976: aload_0
    //   1977: monitorenter
    //   1978: aload_0
    //   1979: getfield 32	com/tencent/mobileqq/filter/music/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1982: fload 10
    //   1984: fload 12
    //   1986: fadd
    //   1987: fconst_2
    //   1988: fdiv
    //   1989: invokestatic 303	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1992: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1995: pop
    //   1996: aload_0
    //   1997: monitorexit
    //   1998: aload_1
    //   1999: invokevirtual 230	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2002: pop
    //   2003: aload 30
    //   2005: invokevirtual 122	android/media/MediaExtractor:release	()V
    //   2008: aload 33
    //   2010: invokevirtual 233	android/media/MediaCodec:stop	()V
    //   2013: aload 33
    //   2015: invokevirtual 234	android/media/MediaCodec:release	()V
    //   2018: iconst_1
    //   2019: ireturn
    //   2020: astore 25
    //   2022: aload_0
    //   2023: monitorexit
    //   2024: aload_1
    //   2025: astore_3
    //   2026: aload_1
    //   2027: astore 24
    //   2029: aload 25
    //   2031: athrow
    //   2032: astore_3
    //   2033: aload_1
    //   2034: astore 24
    //   2036: aload_3
    //   2037: astore_1
    //   2038: aload 24
    //   2040: astore_3
    //   2041: goto +65 -> 2106
    //   2044: astore_1
    //   2045: aload_3
    //   2046: astore 24
    //   2048: aload_1
    //   2049: astore_3
    //   2050: aload 24
    //   2052: astore_1
    //   2053: goto +16 -> 2069
    //   2056: astore_3
    //   2057: aload_1
    //   2058: astore 24
    //   2060: aload_3
    //   2061: astore_1
    //   2062: aload 24
    //   2064: astore_3
    //   2065: goto +41 -> 2106
    //   2068: astore_3
    //   2069: ldc_w 312
    //   2072: iconst_1
    //   2073: ldc_w 314
    //   2076: aload_3
    //   2077: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2080: aload_1
    //   2081: invokevirtual 230	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2084: pop
    //   2085: aload 30
    //   2087: invokevirtual 122	android/media/MediaExtractor:release	()V
    //   2090: aload 33
    //   2092: invokevirtual 233	android/media/MediaCodec:stop	()V
    //   2095: aload 33
    //   2097: invokevirtual 234	android/media/MediaCodec:release	()V
    //   2100: iconst_1
    //   2101: ireturn
    //   2102: astore_3
    //   2103: goto -46 -> 2057
    //   2106: aload_3
    //   2107: invokevirtual 230	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2110: pop
    //   2111: aload 30
    //   2113: invokevirtual 122	android/media/MediaExtractor:release	()V
    //   2116: aload 33
    //   2118: invokevirtual 233	android/media/MediaCodec:stop	()V
    //   2121: aload 33
    //   2123: invokevirtual 234	android/media/MediaCodec:release	()V
    //   2126: aload_1
    //   2127: athrow
    //   2128: astore_1
    //   2129: aload_0
    //   2130: monitorexit
    //   2131: aload_1
    //   2132: athrow
    //   2133: new 322	java/lang/StringBuilder
    //   2136: dup
    //   2137: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   2140: astore_3
    //   2141: aload_3
    //   2142: ldc_w 325
    //   2145: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2148: pop
    //   2149: aload_3
    //   2150: aload_1
    //   2151: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2154: pop
    //   2155: new 334	java/lang/RuntimeException
    //   2158: dup
    //   2159: aload_3
    //   2160: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2163: invokespecial 339	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   2166: athrow
    //   2167: astore_1
    //   2168: aload 30
    //   2170: invokevirtual 122	android/media/MediaExtractor:release	()V
    //   2173: goto +5 -> 2178
    //   2176: aload_1
    //   2177: athrow
    //   2178: goto -2 -> 2176
    //   2181: astore_1
    //   2182: goto -1320 -> 862
    //   2185: astore_1
    //   2186: goto -80 -> 2106
    //   2189: astore_1
    //   2190: aload_3
    //   2191: astore 24
    //   2193: aload_1
    //   2194: astore_3
    //   2195: goto -145 -> 2050
    //   2198: aload_3
    //   2199: astore_1
    //   2200: goto -1280 -> 920
    //   2203: iload 16
    //   2205: iconst_1
    //   2206: iadd
    //   2207: istore 16
    //   2209: iload 18
    //   2211: istore 17
    //   2213: goto -1153 -> 1060
    //   2216: fload 10
    //   2218: fstore 11
    //   2220: goto -987 -> 1233
    //   2223: astore_1
    //   2224: goto -118 -> 2106
    //   2227: astore_3
    //   2228: goto -178 -> 2050
    //   2231: goto -935 -> 1296
    //   2234: aload 32
    //   2236: astore 29
    //   2238: goto -1838 -> 400
    //   2241: iload 13
    //   2243: iconst_1
    //   2244: iadd
    //   2245: istore 13
    //   2247: iload 15
    //   2249: istore 14
    //   2251: goto -810 -> 1441
    //   2254: fload 10
    //   2256: fstore 11
    //   2258: goto -643 -> 1615
    //   2261: iload 13
    //   2263: iconst_1
    //   2264: iadd
    //   2265: istore 13
    //   2267: iload 15
    //   2269: istore 14
    //   2271: goto -535 -> 1736
    //   2274: astore 25
    //   2276: goto -315 -> 1961
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2279	0	this	MusicSoundFile
    //   0	2279	1	paramFile	File
    //   0	2279	2	paramInt	int
    //   0	2279	3	paramMusicItemInfo	MusicItemInfo
    //   739	40	4	d1	double
    //   744	37	6	d2	double
    //   755	13	8	d3	double
    //   238	2017	10	f1	float
    //   383	1874	11	f2	float
    //   391	1594	12	f3	float
    //   36	2230	13	i	int
    //   30	2240	14	j	int
    //   376	1892	15	k	int
    //   145	2063	16	m	int
    //   431	1781	17	n	int
    //   643	1567	18	i1	int
    //   734	408	19	i2	int
    //   14	728	20	i3	int
    //   224	1103	21	i4	int
    //   795	232	22	i5	int
    //   438	3	23	bool	boolean
    //   33	361	24	localMediaFormat1	android.media.MediaFormat
    //   834	5	24	localCryptoException	android.media.MediaCodec.CryptoException
    //   896	1296	24	localObject1	Object
    //   314	396	25	arrayOfByteBuffer1	java.nio.ByteBuffer[]
    //   1246	10	25	localObject2	Object
    //   1291	1	25	arrayOfByteBuffer2	java.nio.ByteBuffer[]
    //   1628	10	25	localObject3	Object
    //   1670	299	25	arrayOfShort1	short[]
    //   2020	10	25	localObject4	Object
    //   2274	1	25	localObject5	Object
    //   335	280	26	localBoolean	java.lang.Boolean
    //   370	557	27	arrayOfByte	byte[]
    //   362	1114	28	arrayOfShort2	short[]
    //   323	1914	29	localObject6	Object
    //   7	2162	30	localMediaExtractor	android.media.MediaExtractor
    //   395	51	31	localMediaFormat2	android.media.MediaFormat
    //   631	1604	32	localObject7	Object
    //   285	1837	33	localMediaCodec	android.media.MediaCodec
    //   307	116	34	arrayOfByteBuffer3	java.nio.ByteBuffer[]
    // Exception table:
    //   from	to	target	type
    //   445	460	482	android/media/MediaCodec$CryptoException
    //   466	472	482	android/media/MediaCodec$CryptoException
    //   420	440	619	finally
    //   420	440	623	android/media/MediaCodec$CryptoException
    //   491	504	688	android/media/MediaCodec$CryptoException
    //   512	534	688	android/media/MediaCodec$CryptoException
    //   541	588	688	android/media/MediaCodec$CryptoException
    //   672	685	688	android/media/MediaCodec$CryptoException
    //   814	821	834	android/media/MediaCodec$CryptoException
    //   853	859	834	android/media/MediaCodec$CryptoException
    //   1186	1204	1246	finally
    //   1207	1230	1246	finally
    //   1233	1235	1246	finally
    //   1248	1250	1246	finally
    //   910	917	1261	finally
    //   925	938	1261	finally
    //   943	951	1261	finally
    //   956	962	1261	finally
    //   967	985	1261	finally
    //   990	999	1261	finally
    //   1004	1020	1261	finally
    //   1025	1032	1261	finally
    //   1037	1054	1261	finally
    //   1065	1075	1261	finally
    //   1092	1110	1261	finally
    //   1124	1130	1261	finally
    //   1153	1162	1261	finally
    //   1167	1169	1261	finally
    //   1255	1258	1261	finally
    //   910	917	1265	android/media/MediaCodec$CryptoException
    //   925	938	1265	android/media/MediaCodec$CryptoException
    //   943	951	1265	android/media/MediaCodec$CryptoException
    //   956	962	1265	android/media/MediaCodec$CryptoException
    //   967	985	1265	android/media/MediaCodec$CryptoException
    //   990	999	1265	android/media/MediaCodec$CryptoException
    //   1004	1020	1265	android/media/MediaCodec$CryptoException
    //   1025	1032	1265	android/media/MediaCodec$CryptoException
    //   1037	1054	1265	android/media/MediaCodec$CryptoException
    //   1065	1075	1265	android/media/MediaCodec$CryptoException
    //   1092	1110	1265	android/media/MediaCodec$CryptoException
    //   1124	1130	1265	android/media/MediaCodec$CryptoException
    //   1153	1162	1265	android/media/MediaCodec$CryptoException
    //   1167	1169	1265	android/media/MediaCodec$CryptoException
    //   1255	1258	1265	android/media/MediaCodec$CryptoException
    //   1568	1586	1628	finally
    //   1589	1612	1628	finally
    //   1615	1617	1628	finally
    //   1630	1632	1628	finally
    //   1978	1998	2020	finally
    //   2022	2024	2020	finally
    //   491	504	2032	finally
    //   512	534	2032	finally
    //   541	588	2032	finally
    //   633	645	2032	finally
    //   650	665	2032	finally
    //   672	685	2032	finally
    //   692	736	2032	finally
    //   633	645	2044	android/media/MediaCodec$CryptoException
    //   650	665	2044	android/media/MediaCodec$CryptoException
    //   692	736	2044	android/media/MediaCodec$CryptoException
    //   400	410	2056	finally
    //   445	460	2056	finally
    //   466	472	2056	finally
    //   400	410	2068	android/media/MediaCodec$CryptoException
    //   2069	2080	2102	finally
    //   339	348	2128	finally
    //   2129	2131	2128	finally
    //   16	25	2167	java/io/IOException
    //   853	859	2181	java/lang/OutOfMemoryError
    //   790	797	2185	finally
    //   814	821	2185	finally
    //   853	859	2185	finally
    //   883	888	2185	finally
    //   790	797	2189	android/media/MediaCodec$CryptoException
    //   883	888	2189	android/media/MediaCodec$CryptoException
    //   898	905	2223	finally
    //   1286	1293	2223	finally
    //   1301	1311	2223	finally
    //   1316	1329	2223	finally
    //   1337	1343	2223	finally
    //   1348	1366	2223	finally
    //   1371	1380	2223	finally
    //   1385	1401	2223	finally
    //   1406	1413	2223	finally
    //   1418	1435	2223	finally
    //   1446	1456	2223	finally
    //   1473	1491	2223	finally
    //   1505	1511	2223	finally
    //   1534	1544	2223	finally
    //   1549	1551	2223	finally
    //   1637	1640	2223	finally
    //   1645	1654	2223	finally
    //   1659	1672	2223	finally
    //   1677	1686	2223	finally
    //   1691	1707	2223	finally
    //   1712	1719	2223	finally
    //   1724	1730	2223	finally
    //   1741	1751	2223	finally
    //   1768	1786	2223	finally
    //   1800	1806	2223	finally
    //   1829	1838	2223	finally
    //   1843	1845	2223	finally
    //   1968	1971	2223	finally
    //   1976	1978	2223	finally
    //   2029	2032	2223	finally
    //   898	905	2227	android/media/MediaCodec$CryptoException
    //   1286	1293	2227	android/media/MediaCodec$CryptoException
    //   1301	1311	2227	android/media/MediaCodec$CryptoException
    //   1316	1329	2227	android/media/MediaCodec$CryptoException
    //   1337	1343	2227	android/media/MediaCodec$CryptoException
    //   1348	1366	2227	android/media/MediaCodec$CryptoException
    //   1371	1380	2227	android/media/MediaCodec$CryptoException
    //   1385	1401	2227	android/media/MediaCodec$CryptoException
    //   1406	1413	2227	android/media/MediaCodec$CryptoException
    //   1418	1435	2227	android/media/MediaCodec$CryptoException
    //   1446	1456	2227	android/media/MediaCodec$CryptoException
    //   1473	1491	2227	android/media/MediaCodec$CryptoException
    //   1505	1511	2227	android/media/MediaCodec$CryptoException
    //   1534	1544	2227	android/media/MediaCodec$CryptoException
    //   1549	1551	2227	android/media/MediaCodec$CryptoException
    //   1637	1640	2227	android/media/MediaCodec$CryptoException
    //   1645	1654	2227	android/media/MediaCodec$CryptoException
    //   1659	1672	2227	android/media/MediaCodec$CryptoException
    //   1677	1686	2227	android/media/MediaCodec$CryptoException
    //   1691	1707	2227	android/media/MediaCodec$CryptoException
    //   1712	1719	2227	android/media/MediaCodec$CryptoException
    //   1724	1730	2227	android/media/MediaCodec$CryptoException
    //   1741	1751	2227	android/media/MediaCodec$CryptoException
    //   1768	1786	2227	android/media/MediaCodec$CryptoException
    //   1800	1806	2227	android/media/MediaCodec$CryptoException
    //   1829	1838	2227	android/media/MediaCodec$CryptoException
    //   1843	1845	2227	android/media/MediaCodec$CryptoException
    //   1968	1971	2227	android/media/MediaCodec$CryptoException
    //   1976	1978	2227	android/media/MediaCodec$CryptoException
    //   2029	2032	2227	android/media/MediaCodec$CryptoException
    //   1852	1865	2274	finally
    //   1875	1912	2274	finally
    //   1915	1956	2274	finally
    //   1956	1958	2274	finally
    //   1961	1963	2274	finally
  }
  
  public static String[] a()
  {
    return new String[] { "mp3", "wav", "3gpp", "3gp", "amr", "aac", "m4a", "ogg" };
  }
  
  public float a(int paramInt)
  {
    try
    {
      n = a(paramInt);
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= n)) {
        break label253;
      }
      paramInt = a(2000);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < paramInt)
      {
        paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
        break label271;
      }
      j = n - paramInt / 2;
      if (j < 0) {
        break label271;
      }
      i = paramInt / 2 + n;
      if (i <= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label279;
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size() - paramInt;
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    finally
    {
      for (;;)
      {
        int n;
        float f3;
        Object localObject2;
        float f5;
        Object localObject1;
        Object localObject3;
        for (;;)
        {
          label253:
          throw localObject4;
        }
        label271:
        int i = paramInt;
        paramInt = 0;
        break label282;
        label279:
        paramInt = j;
        label282:
        int j = paramInt;
        float f2 = 65535.0F;
        float f1 = 0.0F;
        float f4 = 0.0F;
        int k = 0;
        continue;
        float f6 = f1;
        if (f3 > f1) {
          f6 = f3;
        }
        f4 += f3;
        int m;
        if (f3 > 0.0F) {
          m = 0;
        } else {
          m = 1;
        }
        k += m;
        j += 1;
        f2 = f5;
        f1 = f6;
      }
    }
    if (j < i)
    {
      f3 = ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(j)).floatValue();
      f5 = localObject2;
      if (f3 < localObject2)
      {
        f5 = localObject2;
        if (f3 > 0.0F) {
          f5 = f3;
        }
      }
    }
    else
    {
      if ((localObject2 < localObject1) && (((Float)this.jdField_a_of_type_JavaUtilArrayList.get(n)).floatValue() > 0.0F))
      {
        f2 = localObject3 / (i - paramInt - k);
        f2 = (((Float)this.jdField_a_of_type_JavaUtilArrayList.get(n)).floatValue() - f2) / (localObject1 - f2);
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = -1.0F;
        }
        return f1;
      }
      return -1.0F;
      return -1.0F;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, MusicSoundFile.ProgressListener paramProgressListener, int paramInt)
  {
    if (paramMusicItemInfo == null) {
      return false;
    }
    Object localObject = paramMusicItemInfo.getLocalPath();
    if (localObject == null) {
      return false;
    }
    File localFile = new File((String)localObject);
    if (localFile.exists())
    {
      localObject = localFile.getName().toLowerCase().split("\\.");
      if (localObject.length < 2) {
        return false;
      }
      if (!Arrays.asList(a()).contains(localObject[(localObject.length - 1)])) {
        return false;
      }
      a(paramProgressListener);
      return a(localFile, paramInt, paramMusicItemInfo);
    }
    throw new FileNotFoundException((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filter.music.MusicSoundFile
 * JD-Core Version:    0.7.0.1
 */