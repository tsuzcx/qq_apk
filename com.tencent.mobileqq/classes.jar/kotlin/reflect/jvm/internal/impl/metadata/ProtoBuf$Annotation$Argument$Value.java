package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$Annotation$Argument$Value
  extends GeneratedMessageLite
  implements ProtoBuf.Annotation.Argument.ValueOrBuilder
{
  public static Parser<Value> PARSER = new ProtoBuf.Annotation.Argument.Value.1();
  private static final Value defaultInstance = new Value(true);
  private ProtoBuf.Annotation annotation_;
  private int arrayDimensionCount_;
  private List<Value> arrayElement_;
  private int bitField0_;
  private int classId_;
  private double doubleValue_;
  private int enumValueId_;
  private int flags_;
  private float floatValue_;
  private long intValue_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int stringValue_;
  private ProtoBuf.Annotation.Argument.Value.Type type_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Annotation$Argument$Value(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 60	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 62	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 64	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 53	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:initFields	()V
    //   18: invokestatic 70	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 12
    //   23: aload 12
    //   25: iconst_1
    //   26: invokestatic 76	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 13
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +897 -> 935
    //   41: iload_3
    //   42: istore 5
    //   44: iload_3
    //   45: istore 6
    //   47: iload_3
    //   48: istore 7
    //   50: aload_1
    //   51: invokevirtual 82	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 4
    //   56: iload 4
    //   58: lookupswitch	default:+941->999, 0:+769->827, 8:+661->719, 16:+622->680, 29:+583->641, 33:+543->601, 40:+503->561, 48:+463->521, 56:+423->481, 66:+289->347, 74:+212->270, 80:+171->229, 88:+130->188
    //   165: istore 5
    //   167: iload_3
    //   168: istore 6
    //   170: iload_3
    //   171: istore 7
    //   173: aload_0
    //   174: aload_1
    //   175: aload 13
    //   177: aload_2
    //   178: iload 4
    //   180: invokevirtual 86	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   183: istore 10
    //   185: goto +648 -> 833
    //   188: iload_3
    //   189: istore 5
    //   191: iload_3
    //   192: istore 6
    //   194: iload_3
    //   195: istore 7
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   202: sipush 256
    //   205: ior
    //   206: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   209: iload_3
    //   210: istore 5
    //   212: iload_3
    //   213: istore 6
    //   215: iload_3
    //   216: istore 7
    //   218: aload_0
    //   219: aload_1
    //   220: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   223: putfield 93	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:arrayDimensionCount_	I
    //   226: goto -190 -> 36
    //   229: iload_3
    //   230: istore 5
    //   232: iload_3
    //   233: istore 6
    //   235: iload_3
    //   236: istore 7
    //   238: aload_0
    //   239: aload_0
    //   240: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   243: sipush 512
    //   246: ior
    //   247: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   250: iload_3
    //   251: istore 5
    //   253: iload_3
    //   254: istore 6
    //   256: iload_3
    //   257: istore 7
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   264: putfield 95	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:flags_	I
    //   267: goto -231 -> 36
    //   270: iload_3
    //   271: istore 4
    //   273: iload_3
    //   274: sipush 256
    //   277: iand
    //   278: sipush 256
    //   281: if_icmpeq +30 -> 311
    //   284: iload_3
    //   285: istore 5
    //   287: iload_3
    //   288: istore 6
    //   290: iload_3
    //   291: istore 7
    //   293: aload_0
    //   294: new 97	java/util/ArrayList
    //   297: dup
    //   298: invokespecial 98	java/util/ArrayList:<init>	()V
    //   301: putfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:arrayElement_	Ljava/util/List;
    //   304: iload_3
    //   305: sipush 256
    //   308: ior
    //   309: istore 4
    //   311: iload 4
    //   313: istore 5
    //   315: iload 4
    //   317: istore 6
    //   319: iload 4
    //   321: istore 7
    //   323: aload_0
    //   324: getfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:arrayElement_	Ljava/util/List;
    //   327: aload_1
    //   328: getstatic 45	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   331: aload_2
    //   332: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   335: invokeinterface 110 2 0
    //   340: pop
    //   341: iload 4
    //   343: istore_3
    //   344: goto -308 -> 36
    //   347: aconst_null
    //   348: astore 11
    //   350: iload_3
    //   351: istore 5
    //   353: iload_3
    //   354: istore 6
    //   356: iload_3
    //   357: istore 7
    //   359: aload_0
    //   360: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   363: sipush 128
    //   366: iand
    //   367: sipush 128
    //   370: if_icmpne +21 -> 391
    //   373: iload_3
    //   374: istore 5
    //   376: iload_3
    //   377: istore 6
    //   379: iload_3
    //   380: istore 7
    //   382: aload_0
    //   383: getfield 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:annotation_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation;
    //   386: invokevirtual 118	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Builder;
    //   389: astore 11
    //   391: iload_3
    //   392: istore 5
    //   394: iload_3
    //   395: istore 6
    //   397: iload_3
    //   398: istore 7
    //   400: aload_0
    //   401: aload_1
    //   402: getstatic 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   405: aload_2
    //   406: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   409: checkcast 114	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation
    //   412: putfield 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:annotation_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation;
    //   415: aload 11
    //   417: ifnull +40 -> 457
    //   420: iload_3
    //   421: istore 5
    //   423: iload_3
    //   424: istore 6
    //   426: iload_3
    //   427: istore 7
    //   429: aload 11
    //   431: aload_0
    //   432: getfield 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:annotation_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation;
    //   435: invokevirtual 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Builder;
    //   438: pop
    //   439: iload_3
    //   440: istore 5
    //   442: iload_3
    //   443: istore 6
    //   445: iload_3
    //   446: istore 7
    //   448: aload_0
    //   449: aload 11
    //   451: invokevirtual 129	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation;
    //   454: putfield 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:annotation_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation;
    //   457: iload_3
    //   458: istore 5
    //   460: iload_3
    //   461: istore 6
    //   463: iload_3
    //   464: istore 7
    //   466: aload_0
    //   467: aload_0
    //   468: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   471: sipush 128
    //   474: ior
    //   475: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   478: goto -442 -> 36
    //   481: iload_3
    //   482: istore 5
    //   484: iload_3
    //   485: istore 6
    //   487: iload_3
    //   488: istore 7
    //   490: aload_0
    //   491: aload_0
    //   492: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   495: bipush 64
    //   497: ior
    //   498: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   501: iload_3
    //   502: istore 5
    //   504: iload_3
    //   505: istore 6
    //   507: iload_3
    //   508: istore 7
    //   510: aload_0
    //   511: aload_1
    //   512: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   515: putfield 131	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:enumValueId_	I
    //   518: goto -482 -> 36
    //   521: iload_3
    //   522: istore 5
    //   524: iload_3
    //   525: istore 6
    //   527: iload_3
    //   528: istore 7
    //   530: aload_0
    //   531: aload_0
    //   532: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   535: bipush 32
    //   537: ior
    //   538: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   541: iload_3
    //   542: istore 5
    //   544: iload_3
    //   545: istore 6
    //   547: iload_3
    //   548: istore 7
    //   550: aload_0
    //   551: aload_1
    //   552: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   555: putfield 133	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:classId_	I
    //   558: goto -522 -> 36
    //   561: iload_3
    //   562: istore 5
    //   564: iload_3
    //   565: istore 6
    //   567: iload_3
    //   568: istore 7
    //   570: aload_0
    //   571: aload_0
    //   572: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   575: bipush 16
    //   577: ior
    //   578: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   581: iload_3
    //   582: istore 5
    //   584: iload_3
    //   585: istore 6
    //   587: iload_3
    //   588: istore 7
    //   590: aload_0
    //   591: aload_1
    //   592: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   595: putfield 135	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:stringValue_	I
    //   598: goto -562 -> 36
    //   601: iload_3
    //   602: istore 5
    //   604: iload_3
    //   605: istore 6
    //   607: iload_3
    //   608: istore 7
    //   610: aload_0
    //   611: aload_0
    //   612: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   615: bipush 8
    //   617: ior
    //   618: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   621: iload_3
    //   622: istore 5
    //   624: iload_3
    //   625: istore 6
    //   627: iload_3
    //   628: istore 7
    //   630: aload_0
    //   631: aload_1
    //   632: invokevirtual 139	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readDouble	()D
    //   635: putfield 141	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:doubleValue_	D
    //   638: goto -602 -> 36
    //   641: iload_3
    //   642: istore 5
    //   644: iload_3
    //   645: istore 6
    //   647: iload_3
    //   648: istore 7
    //   650: aload_0
    //   651: aload_0
    //   652: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   655: iconst_4
    //   656: ior
    //   657: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   660: iload_3
    //   661: istore 5
    //   663: iload_3
    //   664: istore 6
    //   666: iload_3
    //   667: istore 7
    //   669: aload_0
    //   670: aload_1
    //   671: invokevirtual 145	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readFloat	()F
    //   674: putfield 147	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:floatValue_	F
    //   677: goto -641 -> 36
    //   680: iload_3
    //   681: istore 5
    //   683: iload_3
    //   684: istore 6
    //   686: iload_3
    //   687: istore 7
    //   689: aload_0
    //   690: aload_0
    //   691: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   694: iconst_2
    //   695: ior
    //   696: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   699: iload_3
    //   700: istore 5
    //   702: iload_3
    //   703: istore 6
    //   705: iload_3
    //   706: istore 7
    //   708: aload_0
    //   709: aload_1
    //   710: invokevirtual 151	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readSInt64	()J
    //   713: putfield 153	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:intValue_	J
    //   716: goto -680 -> 36
    //   719: iload_3
    //   720: istore 5
    //   722: iload_3
    //   723: istore 6
    //   725: iload_3
    //   726: istore 7
    //   728: aload_1
    //   729: invokevirtual 156	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   732: istore 9
    //   734: iload_3
    //   735: istore 5
    //   737: iload_3
    //   738: istore 6
    //   740: iload_3
    //   741: istore 7
    //   743: iload 9
    //   745: invokestatic 162	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Type:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Type;
    //   748: astore 11
    //   750: aload 11
    //   752: ifnonnull +38 -> 790
    //   755: iload_3
    //   756: istore 5
    //   758: iload_3
    //   759: istore 6
    //   761: iload_3
    //   762: istore 7
    //   764: aload 13
    //   766: iload 4
    //   768: invokevirtual 166	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   771: iload_3
    //   772: istore 5
    //   774: iload_3
    //   775: istore 6
    //   777: iload_3
    //   778: istore 7
    //   780: aload 13
    //   782: iload 9
    //   784: invokevirtual 166	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   787: goto -751 -> 36
    //   790: iload_3
    //   791: istore 5
    //   793: iload_3
    //   794: istore 6
    //   796: iload_3
    //   797: istore 7
    //   799: aload_0
    //   800: aload_0
    //   801: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   804: iconst_1
    //   805: ior
    //   806: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:bitField0_	I
    //   809: iload_3
    //   810: istore 5
    //   812: iload_3
    //   813: istore 6
    //   815: iload_3
    //   816: istore 7
    //   818: aload_0
    //   819: aload 11
    //   821: putfield 168	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Type;
    //   824: goto -788 -> 36
    //   827: iconst_1
    //   828: istore 8
    //   830: goto -794 -> 36
    //   833: iload 10
    //   835: ifne -799 -> 36
    //   838: goto -11 -> 827
    //   841: astore_1
    //   842: goto +35 -> 877
    //   845: astore_1
    //   846: iload 6
    //   848: istore 5
    //   850: new 57	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   853: dup
    //   854: aload_1
    //   855: invokevirtual 172	java/io/IOException:getMessage	()Ljava/lang/String;
    //   858: invokespecial 175	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   861: aload_0
    //   862: invokevirtual 179	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   865: athrow
    //   866: astore_1
    //   867: iload 7
    //   869: istore 5
    //   871: aload_1
    //   872: aload_0
    //   873: invokevirtual 179	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   876: athrow
    //   877: iload 5
    //   879: sipush 256
    //   882: iand
    //   883: sipush 256
    //   886: if_icmpne +14 -> 900
    //   889: aload_0
    //   890: aload_0
    //   891: getfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:arrayElement_	Ljava/util/List;
    //   894: invokestatic 185	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   897: putfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:arrayElement_	Ljava/util/List;
    //   900: aload 13
    //   902: invokevirtual 188	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   905: aload_0
    //   906: aload 12
    //   908: invokevirtual 194	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   911: putfield 196	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   914: goto +15 -> 929
    //   917: astore_1
    //   918: aload_0
    //   919: aload 12
    //   921: invokevirtual 194	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   924: putfield 196	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   927: aload_1
    //   928: athrow
    //   929: aload_0
    //   930: invokevirtual 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:makeExtensionsImmutable	()V
    //   933: aload_1
    //   934: athrow
    //   935: iload_3
    //   936: sipush 256
    //   939: iand
    //   940: sipush 256
    //   943: if_icmpne +14 -> 957
    //   946: aload_0
    //   947: aload_0
    //   948: getfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:arrayElement_	Ljava/util/List;
    //   951: invokestatic 185	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   954: putfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:arrayElement_	Ljava/util/List;
    //   957: aload 13
    //   959: invokevirtual 188	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   962: aload_0
    //   963: aload 12
    //   965: invokevirtual 194	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   968: putfield 196	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   971: goto +15 -> 986
    //   974: astore_1
    //   975: aload_0
    //   976: aload 12
    //   978: invokevirtual 194	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   981: putfield 196	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   984: aload_1
    //   985: athrow
    //   986: aload_0
    //   987: invokevirtual 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:makeExtensionsImmutable	()V
    //   990: return
    //   991: astore_2
    //   992: goto -87 -> 905
    //   995: astore_1
    //   996: goto -34 -> 962
    //   999: goto -835 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1002	0	this	Value
    //   0	1002	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	1002	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	905	3	i	int
    //   54	713	4	j	int
    //   42	841	5	k	int
    //   45	802	6	m	int
    //   48	820	7	n	int
    //   32	797	8	i1	int
    //   732	51	9	i2	int
    //   183	651	10	bool	boolean
    //   348	472	11	localObject	java.lang.Object
    //   21	956	12	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	929	13	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	841	finally
    //   173	185	841	finally
    //   197	209	841	finally
    //   218	226	841	finally
    //   238	250	841	finally
    //   259	267	841	finally
    //   293	304	841	finally
    //   323	341	841	finally
    //   359	373	841	finally
    //   382	391	841	finally
    //   400	415	841	finally
    //   429	439	841	finally
    //   448	457	841	finally
    //   466	478	841	finally
    //   490	501	841	finally
    //   510	518	841	finally
    //   530	541	841	finally
    //   550	558	841	finally
    //   570	581	841	finally
    //   590	598	841	finally
    //   610	621	841	finally
    //   630	638	841	finally
    //   650	660	841	finally
    //   669	677	841	finally
    //   689	699	841	finally
    //   708	716	841	finally
    //   728	734	841	finally
    //   743	750	841	finally
    //   764	771	841	finally
    //   780	787	841	finally
    //   799	809	841	finally
    //   818	824	841	finally
    //   850	866	841	finally
    //   871	877	841	finally
    //   50	56	845	java/io/IOException
    //   173	185	845	java/io/IOException
    //   197	209	845	java/io/IOException
    //   218	226	845	java/io/IOException
    //   238	250	845	java/io/IOException
    //   259	267	845	java/io/IOException
    //   293	304	845	java/io/IOException
    //   323	341	845	java/io/IOException
    //   359	373	845	java/io/IOException
    //   382	391	845	java/io/IOException
    //   400	415	845	java/io/IOException
    //   429	439	845	java/io/IOException
    //   448	457	845	java/io/IOException
    //   466	478	845	java/io/IOException
    //   490	501	845	java/io/IOException
    //   510	518	845	java/io/IOException
    //   530	541	845	java/io/IOException
    //   550	558	845	java/io/IOException
    //   570	581	845	java/io/IOException
    //   590	598	845	java/io/IOException
    //   610	621	845	java/io/IOException
    //   630	638	845	java/io/IOException
    //   650	660	845	java/io/IOException
    //   669	677	845	java/io/IOException
    //   689	699	845	java/io/IOException
    //   708	716	845	java/io/IOException
    //   728	734	845	java/io/IOException
    //   743	750	845	java/io/IOException
    //   764	771	845	java/io/IOException
    //   780	787	845	java/io/IOException
    //   799	809	845	java/io/IOException
    //   818	824	845	java/io/IOException
    //   50	56	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   173	185	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   197	209	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   218	226	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   238	250	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   259	267	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   293	304	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   323	341	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   359	373	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   382	391	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   400	415	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   429	439	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   448	457	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   466	478	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   490	501	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   510	518	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   530	541	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   550	558	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   570	581	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   590	598	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   610	621	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   630	638	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   650	660	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   669	677	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   689	699	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   708	716	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   728	734	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   743	750	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   764	771	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   780	787	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   799	809	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   818	824	866	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   900	905	917	finally
    //   957	962	974	finally
    //   900	905	991	java/io/IOException
    //   957	962	995	java/io/IOException
  }
  
  private ProtoBuf$Annotation$Argument$Value(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Annotation$Argument$Value(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Value getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.type_ = ProtoBuf.Annotation.Argument.Value.Type.BYTE;
    this.intValue_ = 0L;
    this.floatValue_ = 0.0F;
    this.doubleValue_ = 0.0D;
    this.stringValue_ = 0;
    this.classId_ = 0;
    this.enumValueId_ = 0;
    this.annotation_ = ProtoBuf.Annotation.getDefaultInstance();
    this.arrayElement_ = Collections.emptyList();
    this.arrayDimensionCount_ = 0;
    this.flags_ = 0;
  }
  
  public static ProtoBuf.Annotation.Argument.Value.Builder newBuilder()
  {
    return ProtoBuf.Annotation.Argument.Value.Builder.access$2100();
  }
  
  public static ProtoBuf.Annotation.Argument.Value.Builder newBuilder(Value paramValue)
  {
    return newBuilder().mergeFrom(paramValue);
  }
  
  public ProtoBuf.Annotation getAnnotation()
  {
    return this.annotation_;
  }
  
  public int getArrayDimensionCount()
  {
    return this.arrayDimensionCount_;
  }
  
  public Value getArrayElement(int paramInt)
  {
    return (Value)this.arrayElement_.get(paramInt);
  }
  
  public int getArrayElementCount()
  {
    return this.arrayElement_.size();
  }
  
  public List<Value> getArrayElementList()
  {
    return this.arrayElement_;
  }
  
  public int getClassId()
  {
    return this.classId_;
  }
  
  public Value getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public double getDoubleValue()
  {
    return this.doubleValue_;
  }
  
  public int getEnumValueId()
  {
    return this.enumValueId_;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public float getFloatValue()
  {
    return this.floatValue_;
  }
  
  public long getIntValue()
  {
    return this.intValue_;
  }
  
  public Parser<Value> getParserForType()
  {
    return PARSER;
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
      j = CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0;
    } else {
      j = 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeSInt64Size(2, this.intValue_);
    }
    int j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeFloatSize(3, this.floatValue_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeInt32Size(5, this.stringValue_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeInt32Size(6, this.classId_);
    }
    j = i;
    if ((this.bitField0_ & 0x40) == 64) {
      j = i + CodedOutputStream.computeInt32Size(7, this.enumValueId_);
    }
    i = j;
    int k = m;
    if ((this.bitField0_ & 0x80) == 128)
    {
      i = j + CodedOutputStream.computeMessageSize(8, this.annotation_);
      k = m;
    }
    while (k < this.arrayElement_.size())
    {
      i += CodedOutputStream.computeMessageSize(9, (MessageLite)this.arrayElement_.get(k));
      k += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x200) == 512) {
      j = i + CodedOutputStream.computeInt32Size(10, this.flags_);
    }
    i = j;
    if ((this.bitField0_ & 0x100) == 256) {
      i = j + CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
    }
    i += this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getStringValue()
  {
    return this.stringValue_;
  }
  
  public ProtoBuf.Annotation.Argument.Value.Type getType()
  {
    return this.type_;
  }
  
  public boolean hasAnnotation()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public boolean hasArrayDimensionCount()
  {
    return (this.bitField0_ & 0x100) == 256;
  }
  
  public boolean hasClassId()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasDoubleValue()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasEnumValueId()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public boolean hasFlags()
  {
    return (this.bitField0_ & 0x200) == 512;
  }
  
  public boolean hasFloatValue()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasIntValue()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasStringValue()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasType()
  {
    return (this.bitField0_ & 0x1) == 1;
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
    if ((hasAnnotation()) && (!getAnnotation().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    i = 0;
    while (i < getArrayElementCount())
    {
      if (!getArrayElement(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Annotation.Argument.Value.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Annotation.Argument.Value.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeEnum(1, this.type_.getNumber());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeSInt64(2, this.intValue_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeFloat(3, this.floatValue_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeDouble(4, this.doubleValue_);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeInt32(5, this.stringValue_);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeInt32(6, this.classId_);
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeInt32(7, this.enumValueId_);
    }
    if ((this.bitField0_ & 0x80) == 128) {
      paramCodedOutputStream.writeMessage(8, this.annotation_);
    }
    int i = 0;
    while (i < this.arrayElement_.size())
    {
      paramCodedOutputStream.writeMessage(9, (MessageLite)this.arrayElement_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x200) == 512) {
      paramCodedOutputStream.writeInt32(10, this.flags_);
    }
    if ((this.bitField0_ & 0x100) == 256) {
      paramCodedOutputStream.writeInt32(11, this.arrayDimensionCount_);
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value
 * JD-Core Version:    0.7.0.1
 */