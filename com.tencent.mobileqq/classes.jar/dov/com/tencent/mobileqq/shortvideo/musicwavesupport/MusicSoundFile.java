package dov.com.tencent.mobileqq.shortvideo.musicwavesupport;

import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicSoundFile
{
  private int jdField_a_of_type_Int;
  private MusicSoundFile.ProgressListener jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile$ProgressListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int b = 0;
  private int c = 1024;
  
  private int a(int paramInt)
  {
    return (int)(paramInt * 1.0D * this.jdField_a_of_type_Int / (1000.0D * a()) + 0.5D);
  }
  
  private void a(MusicSoundFile.ProgressListener paramProgressListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile$ProgressListener = paramProgressListener;
  }
  
  /* Error */
  private void a(File paramFile, int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    // Byte code:
    //   0: new 45	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 46	android/media/MediaExtractor:<init>	()V
    //   7: astore 22
    //   9: aload_1
    //   10: invokevirtual 52	java/io/File:length	()J
    //   13: l2i
    //   14: istore 15
    //   16: aload 22
    //   18: aload_1
    //   19: invokevirtual 56	java/io/File:getPath	()Ljava/lang/String;
    //   22: invokevirtual 60	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   25: aload 22
    //   27: invokevirtual 63	android/media/MediaExtractor:getTrackCount	()I
    //   30: istore 9
    //   32: aconst_null
    //   33: astore 18
    //   35: iconst_0
    //   36: istore 8
    //   38: iload 8
    //   40: iload 9
    //   42: if_icmpge +1784 -> 1826
    //   45: aload 22
    //   47: iload 8
    //   49: invokevirtual 67	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   52: astore 18
    //   54: aload 18
    //   56: ldc 69
    //   58: invokevirtual 75	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: ldc 77
    //   63: invokevirtual 83	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   66: ifeq +56 -> 122
    //   69: aload 22
    //   71: iload 8
    //   73: invokevirtual 87	android/media/MediaExtractor:selectTrack	(I)V
    //   76: aload 18
    //   78: astore 21
    //   80: iload 8
    //   82: iload 9
    //   84: if_icmpne +47 -> 131
    //   87: new 89	java/lang/RuntimeException
    //   90: dup
    //   91: new 91	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   98: ldc 94
    //   100: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 106	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   113: athrow
    //   114: astore_1
    //   115: aload 22
    //   117: invokevirtual 109	android/media/MediaExtractor:release	()V
    //   120: aload_1
    //   121: athrow
    //   122: iload 8
    //   124: iconst_1
    //   125: iadd
    //   126: istore 8
    //   128: goto -90 -> 38
    //   131: aload_3
    //   132: getfield 114	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:e	I
    //   135: iload_2
    //   136: iadd
    //   137: istore 8
    //   139: iload 8
    //   141: ifle +16 -> 157
    //   144: aload 22
    //   146: iload 8
    //   148: i2l
    //   149: ldc2_w 115
    //   152: lmul
    //   153: iconst_2
    //   154: invokevirtual 120	android/media/MediaExtractor:seekTo	(JI)V
    //   157: aload 21
    //   159: ldc 122
    //   161: invokevirtual 126	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   164: istore 14
    //   166: aload_0
    //   167: aload 21
    //   169: ldc 128
    //   171: invokevirtual 126	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   174: putfield 28	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_Int	I
    //   177: aload_3
    //   178: invokevirtual 131	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:e	()Z
    //   181: ifeq +81 -> 262
    //   184: aload_3
    //   185: getfield 134	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:f	I
    //   188: aload_3
    //   189: getfield 114	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:e	I
    //   192: iload_2
    //   193: iadd
    //   194: isub
    //   195: istore_2
    //   196: iload_2
    //   197: i2f
    //   198: ldc 135
    //   200: fdiv
    //   201: aload_0
    //   202: getfield 28	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_Int	I
    //   205: i2f
    //   206: fmul
    //   207: ldc 136
    //   209: fadd
    //   210: f2i
    //   211: istore 16
    //   213: aload_0
    //   214: sipush 1024
    //   217: putfield 17	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:c	I
    //   220: fconst_1
    //   221: aload_0
    //   222: getfield 28	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_Int	I
    //   225: i2f
    //   226: fmul
    //   227: aload_0
    //   228: getfield 17	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:c	I
    //   231: i2f
    //   232: fdiv
    //   233: ldc 137
    //   235: fcmpg
    //   236: ifge +52 -> 288
    //   239: aload_0
    //   240: getfield 17	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:c	I
    //   243: sipush 128
    //   246: if_icmple +42 -> 288
    //   249: aload_0
    //   250: aload_0
    //   251: getfield 17	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:c	I
    //   254: iconst_2
    //   255: idiv
    //   256: putfield 17	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:c	I
    //   259: goto -39 -> 220
    //   262: aload 21
    //   264: ldc 139
    //   266: invokevirtual 143	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   269: l2f
    //   270: ldc 135
    //   272: fdiv
    //   273: ldc 136
    //   275: fadd
    //   276: f2i
    //   277: aload_3
    //   278: getfield 114	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:e	I
    //   281: iload_2
    //   282: iadd
    //   283: isub
    //   284: istore_2
    //   285: goto -89 -> 196
    //   288: aload 21
    //   290: ldc 69
    //   292: invokevirtual 75	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   295: invokestatic 149	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   298: astore 23
    //   300: aload 23
    //   302: aload 21
    //   304: aconst_null
    //   305: aconst_null
    //   306: iconst_0
    //   307: invokevirtual 153	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   310: aload 23
    //   312: invokevirtual 156	android/media/MediaCodec:start	()V
    //   315: iconst_0
    //   316: istore 9
    //   318: aconst_null
    //   319: astore 19
    //   321: aload 23
    //   323: invokevirtual 160	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   326: astore 24
    //   328: aload 23
    //   330: invokevirtual 163	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   333: astore_3
    //   334: new 165	android/media/MediaCodec$BufferInfo
    //   337: dup
    //   338: invokespecial 166	android/media/MediaCodec$BufferInfo:<init>	()V
    //   341: astore 25
    //   343: ldc 167
    //   345: invokestatic 173	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   348: astore_1
    //   349: aload_0
    //   350: monitorenter
    //   351: aload_0
    //   352: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   355: invokevirtual 176	java/util/ArrayList:clear	()V
    //   358: aload_0
    //   359: monitorexit
    //   360: aload_0
    //   361: iconst_0
    //   362: putfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   365: aload_0
    //   366: invokevirtual 33	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:a	()I
    //   369: iload 14
    //   371: imul
    //   372: newarray short
    //   374: astore 26
    //   376: ldc 177
    //   378: fstore 4
    //   380: ldc 177
    //   382: fstore 6
    //   384: ldc 177
    //   386: fstore 5
    //   388: aload_0
    //   389: iconst_1
    //   390: putfield 179	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_Boolean	Z
    //   393: iconst_0
    //   394: istore_2
    //   395: iconst_0
    //   396: istore 8
    //   398: iconst_1
    //   399: invokestatic 185	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   402: astore 18
    //   404: aload 23
    //   406: ldc2_w 186
    //   409: invokevirtual 191	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   412: istore 10
    //   414: iload_2
    //   415: ifne +1364 -> 1779
    //   418: iload 10
    //   420: iflt +1359 -> 1779
    //   423: aload 22
    //   425: aload 24
    //   427: iload 10
    //   429: aaload
    //   430: iconst_0
    //   431: invokevirtual 195	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   434: istore 11
    //   436: aload 18
    //   438: invokevirtual 198	java/lang/Boolean:booleanValue	()Z
    //   441: ifeq +242 -> 683
    //   444: aload 21
    //   446: ldc 69
    //   448: invokevirtual 75	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   451: ldc 200
    //   453: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   456: ifeq +227 -> 683
    //   459: iload 11
    //   461: iconst_2
    //   462: if_icmpne +221 -> 683
    //   465: aload 22
    //   467: invokevirtual 207	android/media/MediaExtractor:advance	()Z
    //   470: pop
    //   471: iload 8
    //   473: iload 11
    //   475: iadd
    //   476: istore 8
    //   478: iload_2
    //   479: istore 10
    //   481: iload 8
    //   483: istore_2
    //   484: iload 10
    //   486: istore 8
    //   488: iconst_0
    //   489: invokestatic 185	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   492: astore 18
    //   494: aload 23
    //   496: aload 25
    //   498: ldc2_w 186
    //   501: invokevirtual 211	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   504: istore 12
    //   506: iload 12
    //   508: iflt +625 -> 1133
    //   511: aload 25
    //   513: getfield 214	android/media/MediaCodec$BufferInfo:size	I
    //   516: ifle +617 -> 1133
    //   519: iload 9
    //   521: aload 25
    //   523: getfield 214	android/media/MediaCodec$BufferInfo:size	I
    //   526: if_icmpge +1250 -> 1776
    //   529: aload 25
    //   531: getfield 214	android/media/MediaCodec$BufferInfo:size	I
    //   534: istore 9
    //   536: iload 9
    //   538: newarray byte
    //   540: astore 19
    //   542: aload_3
    //   543: iload 12
    //   545: aaload
    //   546: aload 19
    //   548: iconst_0
    //   549: aload 25
    //   551: getfield 214	android/media/MediaCodec$BufferInfo:size	I
    //   554: invokevirtual 218	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   557: pop
    //   558: aload_3
    //   559: iload 12
    //   561: aaload
    //   562: invokevirtual 221	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   565: pop
    //   566: aload_1
    //   567: invokevirtual 224	java/nio/ByteBuffer:remaining	()I
    //   570: aload 25
    //   572: getfield 214	android/media/MediaCodec$BufferInfo:size	I
    //   575: if_icmpge +1245 -> 1820
    //   578: aload_1
    //   579: invokevirtual 227	java/nio/ByteBuffer:position	()I
    //   582: istore 13
    //   584: iload 13
    //   586: i2d
    //   587: dconst_1
    //   588: iload 15
    //   590: i2d
    //   591: dmul
    //   592: iload_2
    //   593: i2d
    //   594: ddiv
    //   595: dmul
    //   596: ldc2_w 228
    //   599: dmul
    //   600: d2i
    //   601: istore 11
    //   603: iload 11
    //   605: istore 10
    //   607: iload 11
    //   609: iload 13
    //   611: isub
    //   612: aload 25
    //   614: getfield 214	android/media/MediaCodec$BufferInfo:size	I
    //   617: ldc 230
    //   619: iadd
    //   620: if_icmpge +16 -> 636
    //   623: aload 25
    //   625: getfield 214	android/media/MediaCodec$BufferInfo:size	I
    //   628: iload 13
    //   630: iadd
    //   631: ldc 230
    //   633: iadd
    //   634: istore 10
    //   636: bipush 10
    //   638: istore 11
    //   640: iload 11
    //   642: ifle +1172 -> 1814
    //   645: iload 10
    //   647: invokestatic 173	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   650: astore 20
    //   652: iload 11
    //   654: ifne +155 -> 809
    //   657: aload_1
    //   658: invokevirtual 221	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   661: pop
    //   662: aload 22
    //   664: invokevirtual 109	android/media/MediaExtractor:release	()V
    //   667: aload 23
    //   669: invokevirtual 233	android/media/MediaCodec:stop	()V
    //   672: aload 23
    //   674: invokevirtual 234	android/media/MediaCodec:release	()V
    //   677: return
    //   678: astore_1
    //   679: aload_0
    //   680: monitorexit
    //   681: aload_1
    //   682: athrow
    //   683: iload 11
    //   685: ifge +22 -> 707
    //   688: aload 23
    //   690: iload 10
    //   692: iconst_0
    //   693: iconst_0
    //   694: ldc2_w 235
    //   697: iconst_4
    //   698: invokevirtual 240	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   701: iconst_1
    //   702: istore 10
    //   704: goto -223 -> 481
    //   707: aload 23
    //   709: iload 10
    //   711: iconst_0
    //   712: iload 11
    //   714: aload 22
    //   716: invokevirtual 243	android/media/MediaExtractor:getSampleTime	()J
    //   719: iconst_0
    //   720: invokevirtual 240	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   723: aload 22
    //   725: invokevirtual 207	android/media/MediaExtractor:advance	()Z
    //   728: pop
    //   729: iload 8
    //   731: iload 11
    //   733: iadd
    //   734: istore 11
    //   736: iload_2
    //   737: istore 10
    //   739: iload 11
    //   741: istore 8
    //   743: aload_0
    //   744: getfield 38	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile$ProgressListener	Ldov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile$ProgressListener;
    //   747: ifnull -266 -> 481
    //   750: iload_2
    //   751: istore 10
    //   753: iload 11
    //   755: istore 8
    //   757: aload_0
    //   758: getfield 38	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_DovComTencentMobileqqShortvideoMusicwavesupportMusicSoundFile$ProgressListener	Ldov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile$ProgressListener;
    //   761: iload 11
    //   763: i2f
    //   764: iload 15
    //   766: i2f
    //   767: fdiv
    //   768: f2d
    //   769: invokeinterface 248 3 0
    //   774: ifne -293 -> 481
    //   777: aload_1
    //   778: invokevirtual 221	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   781: pop
    //   782: aload 22
    //   784: invokevirtual 109	android/media/MediaExtractor:release	()V
    //   787: aload 23
    //   789: invokevirtual 233	android/media/MediaCodec:stop	()V
    //   792: aload 23
    //   794: invokevirtual 234	android/media/MediaCodec:release	()V
    //   797: return
    //   798: astore 20
    //   800: iload 11
    //   802: iconst_1
    //   803: isub
    //   804: istore 11
    //   806: goto -166 -> 640
    //   809: aload_1
    //   810: invokevirtual 251	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   813: pop
    //   814: aload 20
    //   816: aload_1
    //   817: invokevirtual 255	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   820: pop
    //   821: aload 20
    //   823: iload 13
    //   825: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   828: pop
    //   829: aload 20
    //   831: aload 19
    //   833: iconst_0
    //   834: aload 25
    //   836: getfield 214	android/media/MediaCodec$BufferInfo:size	I
    //   839: invokevirtual 260	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   842: pop
    //   843: aload 23
    //   845: iload 12
    //   847: iconst_0
    //   848: invokevirtual 264	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   851: aload 20
    //   853: invokevirtual 227	java/nio/ByteBuffer:position	()I
    //   856: istore 17
    //   858: fload 5
    //   860: fstore 7
    //   862: fload 4
    //   864: fstore 5
    //   866: fload 6
    //   868: fstore 4
    //   870: fload 7
    //   872: fstore 6
    //   874: iload 17
    //   876: aload_0
    //   877: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   880: isub
    //   881: aload_0
    //   882: invokevirtual 33	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:a	()I
    //   885: iconst_2
    //   886: imul
    //   887: iload 14
    //   889: imul
    //   890: if_icmple +902 -> 1792
    //   893: aload 20
    //   895: aload_0
    //   896: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   899: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   902: pop
    //   903: aload 20
    //   905: getstatic 270	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   908: invokevirtual 274	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   911: invokevirtual 278	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   914: aload 26
    //   916: invokevirtual 283	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   919: pop
    //   920: aload 20
    //   922: iload 17
    //   924: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   927: pop
    //   928: aload_0
    //   929: aload_0
    //   930: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   933: aload_0
    //   934: invokevirtual 33	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:a	()I
    //   937: iconst_2
    //   938: imul
    //   939: iload 14
    //   941: imul
    //   942: iadd
    //   943: putfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   946: iconst_m1
    //   947: istore 11
    //   949: iconst_0
    //   950: istore 10
    //   952: iload 10
    //   954: aload 26
    //   956: arraylength
    //   957: iload 14
    //   959: idiv
    //   960: if_icmpge +79 -> 1039
    //   963: iconst_0
    //   964: istore 13
    //   966: iconst_0
    //   967: istore 12
    //   969: iload 12
    //   971: iload 14
    //   973: if_icmpge +31 -> 1004
    //   976: iload 13
    //   978: aload 26
    //   980: iload 10
    //   982: iload 14
    //   984: imul
    //   985: iload 12
    //   987: iadd
    //   988: saload
    //   989: invokestatic 288	java/lang/Math:abs	(I)I
    //   992: iadd
    //   993: istore 13
    //   995: iload 12
    //   997: iconst_1
    //   998: iadd
    //   999: istore 12
    //   1001: goto -32 -> 969
    //   1004: iload 13
    //   1006: iload 14
    //   1008: idiv
    //   1009: istore 13
    //   1011: iload 11
    //   1013: istore 12
    //   1015: iload 11
    //   1017: iload 13
    //   1019: if_icmpge +7 -> 1026
    //   1022: iload 13
    //   1024: istore 12
    //   1026: iload 10
    //   1028: iconst_1
    //   1029: iadd
    //   1030: istore 10
    //   1032: iload 12
    //   1034: istore 11
    //   1036: goto -84 -> 952
    //   1039: iload 11
    //   1041: i2d
    //   1042: invokestatic 292	java/lang/Math:sqrt	(D)D
    //   1045: d2f
    //   1046: fstore 6
    //   1048: aload_0
    //   1049: monitorenter
    //   1050: fload 4
    //   1052: fconst_0
    //   1053: fcmpg
    //   1054: ifge +17 -> 1071
    //   1057: fload 6
    //   1059: fstore 4
    //   1061: aload_0
    //   1062: monitorexit
    //   1063: goto -189 -> 874
    //   1066: astore_1
    //   1067: aload_0
    //   1068: monitorexit
    //   1069: aload_1
    //   1070: athrow
    //   1071: fload 5
    //   1073: fconst_0
    //   1074: fcmpg
    //   1075: ifge +28 -> 1103
    //   1078: aload_0
    //   1079: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1082: fload 4
    //   1084: fload 6
    //   1086: fadd
    //   1087: fconst_2
    //   1088: fdiv
    //   1089: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1092: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1095: pop
    //   1096: fload 4
    //   1098: fstore 5
    //   1100: goto -43 -> 1057
    //   1103: aload_0
    //   1104: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1107: fload 5
    //   1109: fload 4
    //   1111: fadd
    //   1112: fload 6
    //   1114: fadd
    //   1115: ldc_w 301
    //   1118: fdiv
    //   1119: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1122: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1125: pop
    //   1126: fload 4
    //   1128: fstore 5
    //   1130: goto -73 -> 1057
    //   1133: iload 12
    //   1135: bipush 253
    //   1137: if_icmpne +175 -> 1312
    //   1140: aload 23
    //   1142: invokevirtual 163	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1145: astore_3
    //   1146: aload 25
    //   1148: getfield 304	android/media/MediaCodec$BufferInfo:flags	I
    //   1151: iconst_4
    //   1152: iand
    //   1153: ifne +17 -> 1170
    //   1156: aload_1
    //   1157: invokevirtual 227	java/nio/ByteBuffer:position	()I
    //   1160: iload 14
    //   1162: iconst_2
    //   1163: imul
    //   1164: idiv
    //   1165: iload 16
    //   1167: if_icmplt +596 -> 1763
    //   1170: aload_1
    //   1171: invokevirtual 227	java/nio/ByteBuffer:position	()I
    //   1174: istore 11
    //   1176: fload 4
    //   1178: fstore 7
    //   1180: fload 6
    //   1182: fstore 4
    //   1184: fload 5
    //   1186: fstore 6
    //   1188: iload 11
    //   1190: aload_0
    //   1191: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   1194: isub
    //   1195: aload_0
    //   1196: invokevirtual 33	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:a	()I
    //   1199: iconst_2
    //   1200: imul
    //   1201: iload 14
    //   1203: imul
    //   1204: if_icmple +254 -> 1458
    //   1207: aload_1
    //   1208: aload_0
    //   1209: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   1212: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1215: pop
    //   1216: aload_1
    //   1217: getstatic 270	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1220: invokevirtual 274	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1223: invokevirtual 278	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1226: aload 26
    //   1228: invokevirtual 283	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1231: pop
    //   1232: aload_1
    //   1233: iload 11
    //   1235: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1238: pop
    //   1239: aload_0
    //   1240: aload_0
    //   1241: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   1244: aload_0
    //   1245: invokevirtual 33	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:a	()I
    //   1248: iconst_2
    //   1249: imul
    //   1250: iload 14
    //   1252: imul
    //   1253: iadd
    //   1254: putfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   1257: iconst_m1
    //   1258: istore 8
    //   1260: iconst_0
    //   1261: istore_2
    //   1262: iload_2
    //   1263: aload 26
    //   1265: arraylength
    //   1266: iload 14
    //   1268: idiv
    //   1269: if_icmpge +86 -> 1355
    //   1272: iconst_0
    //   1273: istore 10
    //   1275: iconst_0
    //   1276: istore 9
    //   1278: iload 9
    //   1280: iload 14
    //   1282: if_icmpge +40 -> 1322
    //   1285: iload 10
    //   1287: aload 26
    //   1289: iload_2
    //   1290: iload 14
    //   1292: imul
    //   1293: iload 9
    //   1295: iadd
    //   1296: saload
    //   1297: invokestatic 288	java/lang/Math:abs	(I)I
    //   1300: iadd
    //   1301: istore 10
    //   1303: iload 9
    //   1305: iconst_1
    //   1306: iadd
    //   1307: istore 9
    //   1309: goto -31 -> 1278
    //   1312: iload 12
    //   1314: bipush 254
    //   1316: if_icmpne +3 -> 1319
    //   1319: goto -173 -> 1146
    //   1322: iload 10
    //   1324: iload 14
    //   1326: idiv
    //   1327: istore 10
    //   1329: iload 8
    //   1331: istore 9
    //   1333: iload 8
    //   1335: iload 10
    //   1337: if_icmpge +7 -> 1344
    //   1340: iload 10
    //   1342: istore 9
    //   1344: iload_2
    //   1345: iconst_1
    //   1346: iadd
    //   1347: istore_2
    //   1348: iload 9
    //   1350: istore 8
    //   1352: goto -90 -> 1262
    //   1355: iload 8
    //   1357: i2d
    //   1358: invokestatic 292	java/lang/Math:sqrt	(D)D
    //   1361: d2i
    //   1362: i2f
    //   1363: fstore 6
    //   1365: aload_0
    //   1366: monitorenter
    //   1367: fload 4
    //   1369: fconst_0
    //   1370: fcmpg
    //   1371: ifge +25 -> 1396
    //   1374: fload 7
    //   1376: fstore 5
    //   1378: fload 6
    //   1380: fstore 4
    //   1382: aload_0
    //   1383: monitorexit
    //   1384: fload 5
    //   1386: fstore 7
    //   1388: goto -200 -> 1188
    //   1391: astore_1
    //   1392: aload_0
    //   1393: monitorexit
    //   1394: aload_1
    //   1395: athrow
    //   1396: fload 7
    //   1398: fconst_0
    //   1399: fcmpg
    //   1400: ifge +28 -> 1428
    //   1403: aload_0
    //   1404: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1407: fload 4
    //   1409: fload 6
    //   1411: fadd
    //   1412: fconst_2
    //   1413: fdiv
    //   1414: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1417: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1420: pop
    //   1421: fload 4
    //   1423: fstore 5
    //   1425: goto -47 -> 1378
    //   1428: aload_0
    //   1429: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1432: fload 7
    //   1434: fload 4
    //   1436: fadd
    //   1437: fload 6
    //   1439: fadd
    //   1440: ldc_w 301
    //   1443: fdiv
    //   1444: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1447: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1450: pop
    //   1451: fload 4
    //   1453: fstore 5
    //   1455: goto -77 -> 1378
    //   1458: iload 11
    //   1460: aload_0
    //   1461: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   1464: if_icmple +269 -> 1733
    //   1467: iload 11
    //   1469: aload_0
    //   1470: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   1473: isub
    //   1474: iconst_2
    //   1475: idiv
    //   1476: newarray short
    //   1478: astore_3
    //   1479: aload_1
    //   1480: aload_0
    //   1481: getfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   1484: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1487: pop
    //   1488: aload_1
    //   1489: getstatic 270	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   1492: invokevirtual 274	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1495: invokevirtual 278	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   1498: aload_3
    //   1499: invokevirtual 283	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   1502: pop
    //   1503: aload_1
    //   1504: iload 11
    //   1506: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1509: pop
    //   1510: aload_0
    //   1511: iload 11
    //   1513: putfield 19	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:b	I
    //   1516: iconst_m1
    //   1517: istore 8
    //   1519: iconst_0
    //   1520: istore_2
    //   1521: iload_2
    //   1522: aload_3
    //   1523: arraylength
    //   1524: iload 14
    //   1526: idiv
    //   1527: if_icmpge +75 -> 1602
    //   1530: iconst_0
    //   1531: istore 10
    //   1533: iconst_0
    //   1534: istore 9
    //   1536: iload 9
    //   1538: iload 14
    //   1540: if_icmpge +29 -> 1569
    //   1543: iload 10
    //   1545: aload_3
    //   1546: iload_2
    //   1547: iload 14
    //   1549: imul
    //   1550: iload 9
    //   1552: iadd
    //   1553: saload
    //   1554: invokestatic 288	java/lang/Math:abs	(I)I
    //   1557: iadd
    //   1558: istore 10
    //   1560: iload 9
    //   1562: iconst_1
    //   1563: iadd
    //   1564: istore 9
    //   1566: goto -30 -> 1536
    //   1569: iload 10
    //   1571: iload 14
    //   1573: idiv
    //   1574: istore 10
    //   1576: iload 8
    //   1578: istore 9
    //   1580: iload 8
    //   1582: iload 10
    //   1584: if_icmpge +7 -> 1591
    //   1587: iload 10
    //   1589: istore 9
    //   1591: iload_2
    //   1592: iconst_1
    //   1593: iadd
    //   1594: istore_2
    //   1595: iload 9
    //   1597: istore 8
    //   1599: goto -78 -> 1521
    //   1602: iload 8
    //   1604: i2d
    //   1605: invokestatic 292	java/lang/Math:sqrt	(D)D
    //   1608: d2f
    //   1609: fstore 5
    //   1611: aload_0
    //   1612: monitorenter
    //   1613: fload 4
    //   1615: fconst_0
    //   1616: fcmpg
    //   1617: ifge +26 -> 1643
    //   1620: aload_0
    //   1621: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1624: fload 5
    //   1626: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1629: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1632: pop
    //   1633: aload_0
    //   1634: monitorexit
    //   1635: goto -978 -> 657
    //   1638: astore_1
    //   1639: aload_0
    //   1640: monitorexit
    //   1641: aload_1
    //   1642: athrow
    //   1643: fload 7
    //   1645: fconst_0
    //   1646: fcmpg
    //   1647: ifge +42 -> 1689
    //   1650: aload_0
    //   1651: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1654: fload 4
    //   1656: fload 5
    //   1658: fadd
    //   1659: fconst_2
    //   1660: fdiv
    //   1661: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1664: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1667: pop
    //   1668: aload_0
    //   1669: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1672: fload 5
    //   1674: fload 4
    //   1676: fadd
    //   1677: fconst_2
    //   1678: fdiv
    //   1679: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1682: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1685: pop
    //   1686: goto -53 -> 1633
    //   1689: aload_0
    //   1690: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1693: fload 7
    //   1695: fload 4
    //   1697: fadd
    //   1698: fload 5
    //   1700: fadd
    //   1701: ldc_w 301
    //   1704: fdiv
    //   1705: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1708: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1711: pop
    //   1712: aload_0
    //   1713: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1716: fload 5
    //   1718: fload 4
    //   1720: fadd
    //   1721: fconst_2
    //   1722: fdiv
    //   1723: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1726: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1729: pop
    //   1730: goto -97 -> 1633
    //   1733: aload_0
    //   1734: monitorenter
    //   1735: aload_0
    //   1736: getfield 24	dov/com/tencent/mobileqq/shortvideo/musicwavesupport/MusicSoundFile:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1739: fload 4
    //   1741: fload 6
    //   1743: fadd
    //   1744: fconst_2
    //   1745: fdiv
    //   1746: invokestatic 297	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1749: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1752: pop
    //   1753: aload_0
    //   1754: monitorexit
    //   1755: goto -1098 -> 657
    //   1758: astore_1
    //   1759: aload_0
    //   1760: monitorexit
    //   1761: aload_1
    //   1762: athrow
    //   1763: iload_2
    //   1764: istore 10
    //   1766: iload 8
    //   1768: istore_2
    //   1769: iload 10
    //   1771: istore 8
    //   1773: goto -1369 -> 404
    //   1776: goto -1234 -> 542
    //   1779: iload 8
    //   1781: istore 10
    //   1783: iload_2
    //   1784: istore 8
    //   1786: iload 10
    //   1788: istore_2
    //   1789: goto -1295 -> 494
    //   1792: fload 5
    //   1794: fstore 7
    //   1796: aload 20
    //   1798: astore_1
    //   1799: fload 6
    //   1801: fstore 5
    //   1803: fload 4
    //   1805: fstore 6
    //   1807: fload 7
    //   1809: fstore 4
    //   1811: goto -665 -> 1146
    //   1814: aconst_null
    //   1815: astore 20
    //   1817: goto -1165 -> 652
    //   1820: aload_1
    //   1821: astore 20
    //   1823: goto -994 -> 829
    //   1826: aload 18
    //   1828: astore 21
    //   1830: goto -1750 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1833	0	this	MusicSoundFile
    //   0	1833	1	paramFile	File
    //   0	1833	2	paramInt	int
    //   0	1833	3	paramMusicItemInfo	MusicItemInfo
    //   378	1432	4	f1	float
    //   386	1416	5	f2	float
    //   382	1424	6	f3	float
    //   860	948	7	f4	float
    //   36	1749	8	i	int
    //   30	1566	9	j	int
    //   412	1375	10	k	int
    //   434	1078	11	m	int
    //   504	813	12	n	int
    //   582	441	13	i1	int
    //   164	1410	14	i2	int
    //   14	751	15	i3	int
    //   211	957	16	i4	int
    //   856	67	17	i5	int
    //   33	1794	18	localObject1	Object
    //   319	513	19	arrayOfByte	byte[]
    //   650	1	20	localByteBuffer	java.nio.ByteBuffer
    //   798	999	20	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1815	7	20	localFile	File
    //   78	1751	21	localObject2	Object
    //   7	776	22	localMediaExtractor	android.media.MediaExtractor
    //   298	843	23	localMediaCodec	android.media.MediaCodec
    //   326	100	24	arrayOfByteBuffer	java.nio.ByteBuffer[]
    //   341	806	25	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   374	914	26	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   16	25	114	java/io/IOException
    //   351	360	678	finally
    //   679	681	678	finally
    //   645	652	798	java/lang/OutOfMemoryError
    //   1061	1063	1066	finally
    //   1067	1069	1066	finally
    //   1078	1096	1066	finally
    //   1103	1126	1066	finally
    //   1382	1384	1391	finally
    //   1392	1394	1391	finally
    //   1403	1421	1391	finally
    //   1428	1451	1391	finally
    //   1620	1633	1638	finally
    //   1633	1635	1638	finally
    //   1639	1641	1638	finally
    //   1650	1686	1638	finally
    //   1689	1730	1638	finally
    //   1735	1755	1758	finally
    //   1759	1761	1758	finally
  }
  
  public static String[] a()
  {
    return new String[] { "mp3", "wav", "3gpp", "3gp", "amr", "aac", "m4a", "ogg" };
  }
  
  public float a(int paramInt)
  {
    int j;
    float f2;
    float f4;
    int k;
    float f1;
    label277:
    float f3;
    for (;;)
    {
      try
      {
        int n = a(paramInt);
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= n)) {
          return -1.0F;
        }
        j = a(2000);
        int i;
        Object localObject3;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < j)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.size();
          paramInt = 0;
          break label277;
          if (j < i)
          {
            f2 = ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(j)).floatValue();
            f4 = localObject3;
            if (f2 >= localObject3) {
              break;
            }
            f4 = localObject3;
            if (f2 <= 0.0F) {
              break;
            }
            f4 = f2;
            break;
          }
        }
        else
        {
          paramInt = n - j / 2;
          if (paramInt < 0)
          {
            i = j;
            paramInt = 0;
            break label277;
          }
          k = j / 2 + n;
          i = k;
          if (k <= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label277;
          }
          paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
          i = this.jdField_a_of_type_JavaUtilArrayList.size();
          paramInt -= j;
          break label277;
        }
        Object localObject1;
        if ((localObject3 >= localObject1) || (((Float)this.jdField_a_of_type_JavaUtilArrayList.get(n)).floatValue() <= 0.0F)) {
          return -1.0F;
        }
        Object localObject2;
        f2 = localObject2 / (i - paramInt - k);
        f2 = (((Float)this.jdField_a_of_type_JavaUtilArrayList.get(n)).floatValue() - f2) / (localObject1 - f2);
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = -1.0F;
        }
        return f1;
      }
      finally {}
      f5 = 65535.0F;
      j = paramInt;
      k = 0;
      f3 = 0.0F;
      f1 = 0.0F;
    }
    float f5 = f1;
    if (f2 > f1) {
      f5 = f2;
    }
    f3 += f2;
    if (f2 > 0.0F) {}
    for (int m = 0;; m = 1)
    {
      k += m;
      j += 1;
      f1 = f5;
      f5 = f4;
      break;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, MusicSoundFile.ProgressListener paramProgressListener, int paramInt)
  {
    if (paramMusicItemInfo == null) {}
    File localFile;
    String[] arrayOfString;
    do
    {
      return false;
      localFile = new File(paramMusicItemInfo.a());
      if (!localFile.exists()) {
        throw new FileNotFoundException(paramMusicItemInfo.a());
      }
      arrayOfString = localFile.getName().toLowerCase().split("\\.");
    } while ((arrayOfString.length < 2) || (!Arrays.asList(a()).contains(arrayOfString[(arrayOfString.length - 1)])));
    a(paramProgressListener);
    a(localFile, paramInt, paramMusicItemInfo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.musicwavesupport.MusicSoundFile
 * JD-Core Version:    0.7.0.1
 */