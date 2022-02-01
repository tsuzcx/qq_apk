package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class JvmProtoBuf$StringTableTypes$Record
  extends GeneratedMessageLite
  implements JvmProtoBuf.StringTableTypes.RecordOrBuilder
{
  public static Parser<Record> PARSER = new JvmProtoBuf.StringTableTypes.Record.1();
  private static final Record defaultInstance = new Record(true);
  private int bitField0_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private JvmProtoBuf.StringTableTypes.Record.Operation operation_;
  private int predefinedIndex_;
  private int range_;
  private int replaceCharMemoizedSerializedSize = -1;
  private List<Integer> replaceChar_;
  private Object string_;
  private int substringIndexMemoizedSerializedSize = -1;
  private List<Integer> substringIndex_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private JvmProtoBuf$StringTableTypes$Record(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 54	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 56	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndexMemoizedSerializedSize	I
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 58	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceCharMemoizedSerializedSize	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 60	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:memoizedIsInitialized	B
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 62	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:memoizedSerializedSize	I
    //   24: aload_0
    //   25: invokespecial 47	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:initFields	()V
    //   28: invokestatic 68	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   31: astore 10
    //   33: aload 10
    //   35: iconst_1
    //   36: invokestatic 74	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   39: astore 11
    //   41: iconst_0
    //   42: istore 8
    //   44: iconst_0
    //   45: istore_3
    //   46: iload 8
    //   48: ifne +910 -> 958
    //   51: iload_3
    //   52: istore 4
    //   54: iload_3
    //   55: istore 5
    //   57: iload_3
    //   58: istore 6
    //   60: aload_1
    //   61: invokevirtual 80	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   64: istore 7
    //   66: iload 7
    //   68: ifeq +771 -> 839
    //   71: iload 7
    //   73: bipush 8
    //   75: if_icmpeq +725 -> 800
    //   78: iload 7
    //   80: bipush 16
    //   82: if_icmpeq +679 -> 761
    //   85: iload 7
    //   87: bipush 24
    //   89: if_icmpeq +563 -> 652
    //   92: iload 7
    //   94: bipush 32
    //   96: if_icmpeq +483 -> 579
    //   99: iload 7
    //   101: bipush 34
    //   103: if_icmpeq +325 -> 428
    //   106: iload 7
    //   108: bipush 40
    //   110: if_icmpeq +245 -> 355
    //   113: iload 7
    //   115: bipush 42
    //   117: if_icmpeq +87 -> 204
    //   120: iload 7
    //   122: bipush 50
    //   124: if_icmpeq +28 -> 152
    //   127: iload_3
    //   128: istore 4
    //   130: iload_3
    //   131: istore 5
    //   133: iload_3
    //   134: istore 6
    //   136: aload_0
    //   137: aload_1
    //   138: aload 11
    //   140: aload_2
    //   141: iload 7
    //   143: invokevirtual 84	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   146: ifne -100 -> 46
    //   149: goto +690 -> 839
    //   152: iload_3
    //   153: istore 4
    //   155: iload_3
    //   156: istore 5
    //   158: iload_3
    //   159: istore 6
    //   161: aload_1
    //   162: invokevirtual 88	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readBytes	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   165: astore 12
    //   167: iload_3
    //   168: istore 4
    //   170: iload_3
    //   171: istore 5
    //   173: iload_3
    //   174: istore 6
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:bitField0_	I
    //   181: iconst_4
    //   182: ior
    //   183: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:bitField0_	I
    //   186: iload_3
    //   187: istore 4
    //   189: iload_3
    //   190: istore 5
    //   192: iload_3
    //   193: istore 6
    //   195: aload_0
    //   196: aload 12
    //   198: putfield 92	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:string_	Ljava/lang/Object;
    //   201: goto -155 -> 46
    //   204: iload_3
    //   205: istore 4
    //   207: iload_3
    //   208: istore 5
    //   210: iload_3
    //   211: istore 6
    //   213: aload_1
    //   214: aload_1
    //   215: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   218: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   221: istore 9
    //   223: iload_3
    //   224: istore 7
    //   226: iload_3
    //   227: bipush 32
    //   229: iand
    //   230: bipush 32
    //   232: if_icmpeq +48 -> 280
    //   235: iload_3
    //   236: istore 7
    //   238: iload_3
    //   239: istore 4
    //   241: iload_3
    //   242: istore 5
    //   244: iload_3
    //   245: istore 6
    //   247: aload_1
    //   248: invokevirtual 102	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   251: ifle +29 -> 280
    //   254: iload_3
    //   255: istore 4
    //   257: iload_3
    //   258: istore 5
    //   260: iload_3
    //   261: istore 6
    //   263: aload_0
    //   264: new 104	java/util/ArrayList
    //   267: dup
    //   268: invokespecial 105	java/util/ArrayList:<init>	()V
    //   271: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceChar_	Ljava/util/List;
    //   274: iload_3
    //   275: bipush 32
    //   277: ior
    //   278: istore 7
    //   280: iload 7
    //   282: istore 4
    //   284: iload 7
    //   286: istore 5
    //   288: iload 7
    //   290: istore 6
    //   292: aload_1
    //   293: invokevirtual 102	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   296: ifle +35 -> 331
    //   299: iload 7
    //   301: istore 4
    //   303: iload 7
    //   305: istore 5
    //   307: iload 7
    //   309: istore 6
    //   311: aload_0
    //   312: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceChar_	Ljava/util/List;
    //   315: aload_1
    //   316: invokevirtual 110	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   319: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   322: invokeinterface 122 2 0
    //   327: pop
    //   328: goto -48 -> 280
    //   331: iload 7
    //   333: istore 4
    //   335: iload 7
    //   337: istore 5
    //   339: iload 7
    //   341: istore 6
    //   343: aload_1
    //   344: iload 9
    //   346: invokevirtual 126	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   349: iload 7
    //   351: istore_3
    //   352: goto -306 -> 46
    //   355: iload_3
    //   356: istore 7
    //   358: iload_3
    //   359: bipush 32
    //   361: iand
    //   362: bipush 32
    //   364: if_icmpeq +29 -> 393
    //   367: iload_3
    //   368: istore 4
    //   370: iload_3
    //   371: istore 5
    //   373: iload_3
    //   374: istore 6
    //   376: aload_0
    //   377: new 104	java/util/ArrayList
    //   380: dup
    //   381: invokespecial 105	java/util/ArrayList:<init>	()V
    //   384: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceChar_	Ljava/util/List;
    //   387: iload_3
    //   388: bipush 32
    //   390: ior
    //   391: istore 7
    //   393: iload 7
    //   395: istore 4
    //   397: iload 7
    //   399: istore 5
    //   401: iload 7
    //   403: istore 6
    //   405: aload_0
    //   406: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceChar_	Ljava/util/List;
    //   409: aload_1
    //   410: invokevirtual 110	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   413: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   416: invokeinterface 122 2 0
    //   421: pop
    //   422: iload 7
    //   424: istore_3
    //   425: goto -379 -> 46
    //   428: iload_3
    //   429: istore 4
    //   431: iload_3
    //   432: istore 5
    //   434: iload_3
    //   435: istore 6
    //   437: aload_1
    //   438: aload_1
    //   439: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   442: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   445: istore 9
    //   447: iload_3
    //   448: istore 7
    //   450: iload_3
    //   451: bipush 16
    //   453: iand
    //   454: bipush 16
    //   456: if_icmpeq +48 -> 504
    //   459: iload_3
    //   460: istore 7
    //   462: iload_3
    //   463: istore 4
    //   465: iload_3
    //   466: istore 5
    //   468: iload_3
    //   469: istore 6
    //   471: aload_1
    //   472: invokevirtual 102	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   475: ifle +29 -> 504
    //   478: iload_3
    //   479: istore 4
    //   481: iload_3
    //   482: istore 5
    //   484: iload_3
    //   485: istore 6
    //   487: aload_0
    //   488: new 104	java/util/ArrayList
    //   491: dup
    //   492: invokespecial 105	java/util/ArrayList:<init>	()V
    //   495: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndex_	Ljava/util/List;
    //   498: iload_3
    //   499: bipush 16
    //   501: ior
    //   502: istore 7
    //   504: iload 7
    //   506: istore 4
    //   508: iload 7
    //   510: istore 5
    //   512: iload 7
    //   514: istore 6
    //   516: aload_1
    //   517: invokevirtual 102	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   520: ifle +35 -> 555
    //   523: iload 7
    //   525: istore 4
    //   527: iload 7
    //   529: istore 5
    //   531: iload 7
    //   533: istore 6
    //   535: aload_0
    //   536: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndex_	Ljava/util/List;
    //   539: aload_1
    //   540: invokevirtual 110	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   543: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: invokeinterface 122 2 0
    //   551: pop
    //   552: goto -48 -> 504
    //   555: iload 7
    //   557: istore 4
    //   559: iload 7
    //   561: istore 5
    //   563: iload 7
    //   565: istore 6
    //   567: aload_1
    //   568: iload 9
    //   570: invokevirtual 126	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   573: iload 7
    //   575: istore_3
    //   576: goto -530 -> 46
    //   579: iload_3
    //   580: istore 7
    //   582: iload_3
    //   583: bipush 16
    //   585: iand
    //   586: bipush 16
    //   588: if_icmpeq +29 -> 617
    //   591: iload_3
    //   592: istore 4
    //   594: iload_3
    //   595: istore 5
    //   597: iload_3
    //   598: istore 6
    //   600: aload_0
    //   601: new 104	java/util/ArrayList
    //   604: dup
    //   605: invokespecial 105	java/util/ArrayList:<init>	()V
    //   608: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndex_	Ljava/util/List;
    //   611: iload_3
    //   612: bipush 16
    //   614: ior
    //   615: istore 7
    //   617: iload 7
    //   619: istore 4
    //   621: iload 7
    //   623: istore 5
    //   625: iload 7
    //   627: istore 6
    //   629: aload_0
    //   630: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndex_	Ljava/util/List;
    //   633: aload_1
    //   634: invokevirtual 110	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   637: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   640: invokeinterface 122 2 0
    //   645: pop
    //   646: iload 7
    //   648: istore_3
    //   649: goto -603 -> 46
    //   652: iload_3
    //   653: istore 4
    //   655: iload_3
    //   656: istore 5
    //   658: iload_3
    //   659: istore 6
    //   661: aload_1
    //   662: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   665: istore 9
    //   667: iload_3
    //   668: istore 4
    //   670: iload_3
    //   671: istore 5
    //   673: iload_3
    //   674: istore 6
    //   676: iload 9
    //   678: invokestatic 136	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Operation:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Operation;
    //   681: astore 12
    //   683: aload 12
    //   685: ifnonnull +38 -> 723
    //   688: iload_3
    //   689: istore 4
    //   691: iload_3
    //   692: istore 5
    //   694: iload_3
    //   695: istore 6
    //   697: aload 11
    //   699: iload 7
    //   701: invokevirtual 139	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   704: iload_3
    //   705: istore 4
    //   707: iload_3
    //   708: istore 5
    //   710: iload_3
    //   711: istore 6
    //   713: aload 11
    //   715: iload 9
    //   717: invokevirtual 139	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   720: goto -674 -> 46
    //   723: iload_3
    //   724: istore 4
    //   726: iload_3
    //   727: istore 5
    //   729: iload_3
    //   730: istore 6
    //   732: aload_0
    //   733: aload_0
    //   734: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:bitField0_	I
    //   737: bipush 8
    //   739: ior
    //   740: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:bitField0_	I
    //   743: iload_3
    //   744: istore 4
    //   746: iload_3
    //   747: istore 5
    //   749: iload_3
    //   750: istore 6
    //   752: aload_0
    //   753: aload 12
    //   755: putfield 141	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:operation_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record$Operation;
    //   758: goto -712 -> 46
    //   761: iload_3
    //   762: istore 4
    //   764: iload_3
    //   765: istore 5
    //   767: iload_3
    //   768: istore 6
    //   770: aload_0
    //   771: aload_0
    //   772: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:bitField0_	I
    //   775: iconst_2
    //   776: ior
    //   777: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:bitField0_	I
    //   780: iload_3
    //   781: istore 4
    //   783: iload_3
    //   784: istore 5
    //   786: iload_3
    //   787: istore 6
    //   789: aload_0
    //   790: aload_1
    //   791: invokevirtual 110	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   794: putfield 143	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:predefinedIndex_	I
    //   797: goto -751 -> 46
    //   800: iload_3
    //   801: istore 4
    //   803: iload_3
    //   804: istore 5
    //   806: iload_3
    //   807: istore 6
    //   809: aload_0
    //   810: aload_0
    //   811: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:bitField0_	I
    //   814: iconst_1
    //   815: ior
    //   816: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:bitField0_	I
    //   819: iload_3
    //   820: istore 4
    //   822: iload_3
    //   823: istore 5
    //   825: iload_3
    //   826: istore 6
    //   828: aload_0
    //   829: aload_1
    //   830: invokevirtual 110	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   833: putfield 145	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:range_	I
    //   836: goto -790 -> 46
    //   839: iconst_1
    //   840: istore 8
    //   842: goto -796 -> 46
    //   845: astore_1
    //   846: goto +35 -> 881
    //   849: astore_1
    //   850: iload 5
    //   852: istore 4
    //   854: new 51	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   857: dup
    //   858: aload_1
    //   859: invokevirtual 149	java/io/IOException:getMessage	()Ljava/lang/String;
    //   862: invokespecial 152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   865: aload_0
    //   866: invokevirtual 156	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   869: athrow
    //   870: astore_1
    //   871: iload 6
    //   873: istore 4
    //   875: aload_1
    //   876: aload_0
    //   877: invokevirtual 156	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   880: athrow
    //   881: iload 4
    //   883: bipush 16
    //   885: iand
    //   886: bipush 16
    //   888: if_icmpne +14 -> 902
    //   891: aload_0
    //   892: aload_0
    //   893: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndex_	Ljava/util/List;
    //   896: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   899: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndex_	Ljava/util/List;
    //   902: iload 4
    //   904: bipush 32
    //   906: iand
    //   907: bipush 32
    //   909: if_icmpne +14 -> 923
    //   912: aload_0
    //   913: aload_0
    //   914: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceChar_	Ljava/util/List;
    //   917: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   920: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceChar_	Ljava/util/List;
    //   923: aload 11
    //   925: invokevirtual 165	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   928: aload_0
    //   929: aload 10
    //   931: invokevirtual 170	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   934: putfield 172	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   937: goto +15 -> 952
    //   940: astore_1
    //   941: aload_0
    //   942: aload 10
    //   944: invokevirtual 170	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   947: putfield 172	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   950: aload_1
    //   951: athrow
    //   952: aload_0
    //   953: invokevirtual 175	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:makeExtensionsImmutable	()V
    //   956: aload_1
    //   957: athrow
    //   958: iload_3
    //   959: bipush 16
    //   961: iand
    //   962: bipush 16
    //   964: if_icmpne +14 -> 978
    //   967: aload_0
    //   968: aload_0
    //   969: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndex_	Ljava/util/List;
    //   972: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   975: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:substringIndex_	Ljava/util/List;
    //   978: iload_3
    //   979: bipush 32
    //   981: iand
    //   982: bipush 32
    //   984: if_icmpne +14 -> 998
    //   987: aload_0
    //   988: aload_0
    //   989: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceChar_	Ljava/util/List;
    //   992: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   995: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:replaceChar_	Ljava/util/List;
    //   998: aload 11
    //   1000: invokevirtual 165	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1003: aload_0
    //   1004: aload 10
    //   1006: invokevirtual 170	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1009: putfield 172	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1012: goto +15 -> 1027
    //   1015: astore_1
    //   1016: aload_0
    //   1017: aload 10
    //   1019: invokevirtual 170	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1022: putfield 172	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1025: aload_1
    //   1026: athrow
    //   1027: aload_0
    //   1028: invokevirtual 175	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:makeExtensionsImmutable	()V
    //   1031: return
    //   1032: astore_2
    //   1033: goto -105 -> 928
    //   1036: astore_1
    //   1037: goto -34 -> 1003
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1040	0	this	Record
    //   0	1040	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	1040	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   45	937	3	i	int
    //   52	855	4	j	int
    //   55	796	5	k	int
    //   58	814	6	m	int
    //   64	636	7	n	int
    //   42	799	8	i1	int
    //   221	495	9	i2	int
    //   31	987	10	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   39	960	11	localCodedOutputStream	CodedOutputStream
    //   165	589	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   60	66	845	finally
    //   136	149	845	finally
    //   161	167	845	finally
    //   176	186	845	finally
    //   195	201	845	finally
    //   213	223	845	finally
    //   247	254	845	finally
    //   263	274	845	finally
    //   292	299	845	finally
    //   311	328	845	finally
    //   343	349	845	finally
    //   376	387	845	finally
    //   405	422	845	finally
    //   437	447	845	finally
    //   471	478	845	finally
    //   487	498	845	finally
    //   516	523	845	finally
    //   535	552	845	finally
    //   567	573	845	finally
    //   600	611	845	finally
    //   629	646	845	finally
    //   661	667	845	finally
    //   676	683	845	finally
    //   697	704	845	finally
    //   713	720	845	finally
    //   732	743	845	finally
    //   752	758	845	finally
    //   770	780	845	finally
    //   789	797	845	finally
    //   809	819	845	finally
    //   828	836	845	finally
    //   854	870	845	finally
    //   875	881	845	finally
    //   60	66	849	java/io/IOException
    //   136	149	849	java/io/IOException
    //   161	167	849	java/io/IOException
    //   176	186	849	java/io/IOException
    //   195	201	849	java/io/IOException
    //   213	223	849	java/io/IOException
    //   247	254	849	java/io/IOException
    //   263	274	849	java/io/IOException
    //   292	299	849	java/io/IOException
    //   311	328	849	java/io/IOException
    //   343	349	849	java/io/IOException
    //   376	387	849	java/io/IOException
    //   405	422	849	java/io/IOException
    //   437	447	849	java/io/IOException
    //   471	478	849	java/io/IOException
    //   487	498	849	java/io/IOException
    //   516	523	849	java/io/IOException
    //   535	552	849	java/io/IOException
    //   567	573	849	java/io/IOException
    //   600	611	849	java/io/IOException
    //   629	646	849	java/io/IOException
    //   661	667	849	java/io/IOException
    //   676	683	849	java/io/IOException
    //   697	704	849	java/io/IOException
    //   713	720	849	java/io/IOException
    //   732	743	849	java/io/IOException
    //   752	758	849	java/io/IOException
    //   770	780	849	java/io/IOException
    //   789	797	849	java/io/IOException
    //   809	819	849	java/io/IOException
    //   828	836	849	java/io/IOException
    //   60	66	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   136	149	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   161	167	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   176	186	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   195	201	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   213	223	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   247	254	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   263	274	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   292	299	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   311	328	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   343	349	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   376	387	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   405	422	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   437	447	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   471	478	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   487	498	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   516	523	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   535	552	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   567	573	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   600	611	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   629	646	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   661	667	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   676	683	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   697	704	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   713	720	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   732	743	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   752	758	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   770	780	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   789	797	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   809	819	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   828	836	870	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   923	928	940	finally
    //   998	1003	1015	finally
    //   923	928	1032	java/io/IOException
    //   998	1003	1036	java/io/IOException
  }
  
  private JvmProtoBuf$StringTableTypes$Record(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private JvmProtoBuf$StringTableTypes$Record(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Record getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.range_ = 1;
    this.predefinedIndex_ = 0;
    this.string_ = "";
    this.operation_ = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
    this.substringIndex_ = Collections.emptyList();
    this.replaceChar_ = Collections.emptyList();
  }
  
  public static JvmProtoBuf.StringTableTypes.Record.Builder newBuilder()
  {
    return JvmProtoBuf.StringTableTypes.Record.Builder.access$200();
  }
  
  public static JvmProtoBuf.StringTableTypes.Record.Builder newBuilder(Record paramRecord)
  {
    return newBuilder().mergeFrom(paramRecord);
  }
  
  public Record getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public JvmProtoBuf.StringTableTypes.Record.Operation getOperation()
  {
    return this.operation_;
  }
  
  public Parser<Record> getParserForType()
  {
    return PARSER;
  }
  
  public int getPredefinedIndex()
  {
    return this.predefinedIndex_;
  }
  
  public int getRange()
  {
    return this.range_;
  }
  
  public int getReplaceCharCount()
  {
    return this.replaceChar_.size();
  }
  
  public List<Integer> getReplaceCharList()
  {
    return this.replaceChar_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int m = 0;
    if ((i & 0x1) == 1) {
      j = CodedOutputStream.computeInt32Size(1, this.range_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
    }
    int j = i;
    if ((this.bitField0_ & 0x8) == 8) {
      j = i + CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
    }
    i = 0;
    int k = 0;
    while (i < this.substringIndex_.size())
    {
      k += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.substringIndex_.get(i)).intValue());
      i += 1;
    }
    j += k;
    i = j;
    if (!getSubstringIndexList().isEmpty()) {
      i = j + 1 + CodedOutputStream.computeInt32SizeNoTag(k);
    }
    this.substringIndexMemoizedSerializedSize = k;
    j = 0;
    k = m;
    while (k < this.replaceChar_.size())
    {
      j += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.replaceChar_.get(k)).intValue());
      k += 1;
    }
    k = i + j;
    i = k;
    if (!getReplaceCharList().isEmpty()) {
      i = k + 1 + CodedOutputStream.computeInt32SizeNoTag(j);
    }
    this.replaceCharMemoizedSerializedSize = j;
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeBytesSize(6, getStringBytes());
    }
    i = j + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getString()
  {
    Object localObject = this.string_;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (ByteString)localObject;
    String str = ((ByteString)localObject).toStringUtf8();
    if (((ByteString)localObject).isValidUtf8()) {
      this.string_ = str;
    }
    return str;
  }
  
  public ByteString getStringBytes()
  {
    Object localObject = this.string_;
    if ((localObject instanceof String))
    {
      localObject = ByteString.copyFromUtf8((String)localObject);
      this.string_ = localObject;
      return localObject;
    }
    return (ByteString)localObject;
  }
  
  public int getSubstringIndexCount()
  {
    return this.substringIndex_.size();
  }
  
  public List<Integer> getSubstringIndexList()
  {
    return this.substringIndex_;
  }
  
  public boolean hasOperation()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasPredefinedIndex()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasRange()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasString()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public final boolean isInitialized()
  {
    int i = this.memoizedIsInitialized;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public JvmProtoBuf.StringTableTypes.Record.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public JvmProtoBuf.StringTableTypes.Record.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.range_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(2, this.predefinedIndex_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeEnum(3, this.operation_.getNumber());
    }
    if (getSubstringIndexList().size() > 0)
    {
      paramCodedOutputStream.writeRawVarint32(34);
      paramCodedOutputStream.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
    }
    int j = 0;
    int i = 0;
    while (i < this.substringIndex_.size())
    {
      paramCodedOutputStream.writeInt32NoTag(((Integer)this.substringIndex_.get(i)).intValue());
      i += 1;
    }
    i = j;
    if (getReplaceCharList().size() > 0)
    {
      paramCodedOutputStream.writeRawVarint32(42);
      paramCodedOutputStream.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
      i = j;
    }
    while (i < this.replaceChar_.size())
    {
      paramCodedOutputStream.writeInt32NoTag(((Integer)this.replaceChar_.get(i)).intValue());
      i += 1;
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeBytes(6, getStringBytes());
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record
 * JD-Core Version:    0.7.0.1
 */