package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$TypeParameter
  extends GeneratedMessageLite.ExtendableMessage<TypeParameter>
  implements ProtoBuf.TypeParameterOrBuilder
{
  public static Parser<TypeParameter> PARSER = new ProtoBuf.TypeParameter.1();
  private static final TypeParameter defaultInstance = new TypeParameter(true);
  private int bitField0_;
  private int id_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int name_;
  private boolean reified_;
  private final ByteString unknownFields;
  private int upperBoundIdMemoizedSerializedSize = -1;
  private List<Integer> upperBoundId_;
  private List<ProtoBuf.Type> upperBound_;
  private ProtoBuf.TypeParameter.Variance variance_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$TypeParameter(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 55	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 57	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundIdMemoizedSerializedSize	I
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 59	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 61	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:memoizedSerializedSize	I
    //   19: aload_0
    //   20: invokespecial 48	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:initFields	()V
    //   23: invokestatic 67	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   26: astore 10
    //   28: aload 10
    //   30: iconst_1
    //   31: invokestatic 73	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   34: astore 11
    //   36: iconst_0
    //   37: istore 8
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 8
    //   43: ifne +740 -> 783
    //   46: iload_3
    //   47: istore 4
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 79	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   59: istore 7
    //   61: iload 7
    //   63: ifeq +601 -> 664
    //   66: iload 7
    //   68: bipush 8
    //   70: if_icmpeq +555 -> 625
    //   73: iload 7
    //   75: bipush 16
    //   77: if_icmpeq +509 -> 586
    //   80: iload 7
    //   82: bipush 24
    //   84: if_icmpeq +463 -> 547
    //   87: iload 7
    //   89: bipush 32
    //   91: if_icmpeq +347 -> 438
    //   94: iload 7
    //   96: bipush 42
    //   98: if_icmpeq +266 -> 364
    //   101: iload 7
    //   103: bipush 48
    //   105: if_icmpeq +186 -> 291
    //   108: iload 7
    //   110: bipush 50
    //   112: if_icmpeq +28 -> 140
    //   115: iload_3
    //   116: istore 4
    //   118: iload_3
    //   119: istore 5
    //   121: iload_3
    //   122: istore 6
    //   124: aload_0
    //   125: aload_1
    //   126: aload 11
    //   128: aload_2
    //   129: iload 7
    //   131: invokevirtual 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   134: ifne -93 -> 41
    //   137: goto +527 -> 664
    //   140: iload_3
    //   141: istore 4
    //   143: iload_3
    //   144: istore 5
    //   146: iload_3
    //   147: istore 6
    //   149: aload_1
    //   150: aload_1
    //   151: invokevirtual 86	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   154: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   157: istore 9
    //   159: iload_3
    //   160: istore 7
    //   162: iload_3
    //   163: bipush 32
    //   165: iand
    //   166: bipush 32
    //   168: if_icmpeq +48 -> 216
    //   171: iload_3
    //   172: istore 7
    //   174: iload_3
    //   175: istore 4
    //   177: iload_3
    //   178: istore 5
    //   180: iload_3
    //   181: istore 6
    //   183: aload_1
    //   184: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   187: ifle +29 -> 216
    //   190: iload_3
    //   191: istore 4
    //   193: iload_3
    //   194: istore 5
    //   196: iload_3
    //   197: istore 6
    //   199: aload_0
    //   200: new 95	java/util/ArrayList
    //   203: dup
    //   204: invokespecial 96	java/util/ArrayList:<init>	()V
    //   207: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundId_	Ljava/util/List;
    //   210: iload_3
    //   211: bipush 32
    //   213: ior
    //   214: istore 7
    //   216: iload 7
    //   218: istore 4
    //   220: iload 7
    //   222: istore 5
    //   224: iload 7
    //   226: istore 6
    //   228: aload_1
    //   229: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   232: ifle +35 -> 267
    //   235: iload 7
    //   237: istore 4
    //   239: iload 7
    //   241: istore 5
    //   243: iload 7
    //   245: istore 6
    //   247: aload_0
    //   248: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundId_	Ljava/util/List;
    //   251: aload_1
    //   252: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   255: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokeinterface 113 2 0
    //   263: pop
    //   264: goto -48 -> 216
    //   267: iload 7
    //   269: istore 4
    //   271: iload 7
    //   273: istore 5
    //   275: iload 7
    //   277: istore 6
    //   279: aload_1
    //   280: iload 9
    //   282: invokevirtual 117	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   285: iload 7
    //   287: istore_3
    //   288: goto -247 -> 41
    //   291: iload_3
    //   292: istore 7
    //   294: iload_3
    //   295: bipush 32
    //   297: iand
    //   298: bipush 32
    //   300: if_icmpeq +29 -> 329
    //   303: iload_3
    //   304: istore 4
    //   306: iload_3
    //   307: istore 5
    //   309: iload_3
    //   310: istore 6
    //   312: aload_0
    //   313: new 95	java/util/ArrayList
    //   316: dup
    //   317: invokespecial 96	java/util/ArrayList:<init>	()V
    //   320: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundId_	Ljava/util/List;
    //   323: iload_3
    //   324: bipush 32
    //   326: ior
    //   327: istore 7
    //   329: iload 7
    //   331: istore 4
    //   333: iload 7
    //   335: istore 5
    //   337: iload 7
    //   339: istore 6
    //   341: aload_0
    //   342: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundId_	Ljava/util/List;
    //   345: aload_1
    //   346: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   349: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: invokeinterface 113 2 0
    //   357: pop
    //   358: iload 7
    //   360: istore_3
    //   361: goto -320 -> 41
    //   364: iload_3
    //   365: istore 7
    //   367: iload_3
    //   368: bipush 16
    //   370: iand
    //   371: bipush 16
    //   373: if_icmpeq +29 -> 402
    //   376: iload_3
    //   377: istore 4
    //   379: iload_3
    //   380: istore 5
    //   382: iload_3
    //   383: istore 6
    //   385: aload_0
    //   386: new 95	java/util/ArrayList
    //   389: dup
    //   390: invokespecial 96	java/util/ArrayList:<init>	()V
    //   393: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBound_	Ljava/util/List;
    //   396: iload_3
    //   397: bipush 16
    //   399: ior
    //   400: istore 7
    //   402: iload 7
    //   404: istore 4
    //   406: iload 7
    //   408: istore 5
    //   410: iload 7
    //   412: istore 6
    //   414: aload_0
    //   415: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBound_	Ljava/util/List;
    //   418: aload_1
    //   419: getstatic 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   422: aload_2
    //   423: invokevirtual 126	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   426: invokeinterface 113 2 0
    //   431: pop
    //   432: iload 7
    //   434: istore_3
    //   435: goto -394 -> 41
    //   438: iload_3
    //   439: istore 4
    //   441: iload_3
    //   442: istore 5
    //   444: iload_3
    //   445: istore 6
    //   447: aload_1
    //   448: invokevirtual 129	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   451: istore 9
    //   453: iload_3
    //   454: istore 4
    //   456: iload_3
    //   457: istore 5
    //   459: iload_3
    //   460: istore 6
    //   462: iload 9
    //   464: invokestatic 134	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter$Variance:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter$Variance;
    //   467: astore 12
    //   469: aload 12
    //   471: ifnonnull +38 -> 509
    //   474: iload_3
    //   475: istore 4
    //   477: iload_3
    //   478: istore 5
    //   480: iload_3
    //   481: istore 6
    //   483: aload 11
    //   485: iload 7
    //   487: invokevirtual 137	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   490: iload_3
    //   491: istore 4
    //   493: iload_3
    //   494: istore 5
    //   496: iload_3
    //   497: istore 6
    //   499: aload 11
    //   501: iload 9
    //   503: invokevirtual 137	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   506: goto -465 -> 41
    //   509: iload_3
    //   510: istore 4
    //   512: iload_3
    //   513: istore 5
    //   515: iload_3
    //   516: istore 6
    //   518: aload_0
    //   519: aload_0
    //   520: getfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:bitField0_	I
    //   523: bipush 8
    //   525: ior
    //   526: putfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:bitField0_	I
    //   529: iload_3
    //   530: istore 4
    //   532: iload_3
    //   533: istore 5
    //   535: iload_3
    //   536: istore 6
    //   538: aload_0
    //   539: aload 12
    //   541: putfield 141	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:variance_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter$Variance;
    //   544: goto -503 -> 41
    //   547: iload_3
    //   548: istore 4
    //   550: iload_3
    //   551: istore 5
    //   553: iload_3
    //   554: istore 6
    //   556: aload_0
    //   557: aload_0
    //   558: getfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:bitField0_	I
    //   561: iconst_4
    //   562: ior
    //   563: putfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:bitField0_	I
    //   566: iload_3
    //   567: istore 4
    //   569: iload_3
    //   570: istore 5
    //   572: iload_3
    //   573: istore 6
    //   575: aload_0
    //   576: aload_1
    //   577: invokevirtual 145	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readBool	()Z
    //   580: putfield 147	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:reified_	Z
    //   583: goto -542 -> 41
    //   586: iload_3
    //   587: istore 4
    //   589: iload_3
    //   590: istore 5
    //   592: iload_3
    //   593: istore 6
    //   595: aload_0
    //   596: aload_0
    //   597: getfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:bitField0_	I
    //   600: iconst_2
    //   601: ior
    //   602: putfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:bitField0_	I
    //   605: iload_3
    //   606: istore 4
    //   608: iload_3
    //   609: istore 5
    //   611: iload_3
    //   612: istore 6
    //   614: aload_0
    //   615: aload_1
    //   616: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   619: putfield 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:name_	I
    //   622: goto -581 -> 41
    //   625: iload_3
    //   626: istore 4
    //   628: iload_3
    //   629: istore 5
    //   631: iload_3
    //   632: istore 6
    //   634: aload_0
    //   635: aload_0
    //   636: getfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:bitField0_	I
    //   639: iconst_1
    //   640: ior
    //   641: putfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:bitField0_	I
    //   644: iload_3
    //   645: istore 4
    //   647: iload_3
    //   648: istore 5
    //   650: iload_3
    //   651: istore 6
    //   653: aload_0
    //   654: aload_1
    //   655: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   658: putfield 151	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:id_	I
    //   661: goto -620 -> 41
    //   664: iconst_1
    //   665: istore 8
    //   667: goto -626 -> 41
    //   670: astore_1
    //   671: goto +35 -> 706
    //   674: astore_1
    //   675: iload 5
    //   677: istore 4
    //   679: new 52	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   682: dup
    //   683: aload_1
    //   684: invokevirtual 155	java/io/IOException:getMessage	()Ljava/lang/String;
    //   687: invokespecial 158	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   690: aload_0
    //   691: invokevirtual 162	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   694: athrow
    //   695: astore_1
    //   696: iload 6
    //   698: istore 4
    //   700: aload_1
    //   701: aload_0
    //   702: invokevirtual 162	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   705: athrow
    //   706: iload 4
    //   708: bipush 16
    //   710: iand
    //   711: bipush 16
    //   713: if_icmpne +14 -> 727
    //   716: aload_0
    //   717: aload_0
    //   718: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBound_	Ljava/util/List;
    //   721: invokestatic 168	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   724: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBound_	Ljava/util/List;
    //   727: iload 4
    //   729: bipush 32
    //   731: iand
    //   732: bipush 32
    //   734: if_icmpne +14 -> 748
    //   737: aload_0
    //   738: aload_0
    //   739: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundId_	Ljava/util/List;
    //   742: invokestatic 168	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   745: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundId_	Ljava/util/List;
    //   748: aload 11
    //   750: invokevirtual 171	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   753: aload_0
    //   754: aload 10
    //   756: invokevirtual 177	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   759: putfield 179	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   762: goto +15 -> 777
    //   765: astore_1
    //   766: aload_0
    //   767: aload 10
    //   769: invokevirtual 177	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   772: putfield 179	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   775: aload_1
    //   776: athrow
    //   777: aload_0
    //   778: invokevirtual 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:makeExtensionsImmutable	()V
    //   781: aload_1
    //   782: athrow
    //   783: iload_3
    //   784: bipush 16
    //   786: iand
    //   787: bipush 16
    //   789: if_icmpne +14 -> 803
    //   792: aload_0
    //   793: aload_0
    //   794: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBound_	Ljava/util/List;
    //   797: invokestatic 168	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   800: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBound_	Ljava/util/List;
    //   803: iload_3
    //   804: bipush 32
    //   806: iand
    //   807: bipush 32
    //   809: if_icmpne +14 -> 823
    //   812: aload_0
    //   813: aload_0
    //   814: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundId_	Ljava/util/List;
    //   817: invokestatic 168	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   820: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:upperBoundId_	Ljava/util/List;
    //   823: aload 11
    //   825: invokevirtual 171	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   828: aload_0
    //   829: aload 10
    //   831: invokevirtual 177	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   834: putfield 179	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   837: goto +15 -> 852
    //   840: astore_1
    //   841: aload_0
    //   842: aload 10
    //   844: invokevirtual 177	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   847: putfield 179	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   850: aload_1
    //   851: athrow
    //   852: aload_0
    //   853: invokevirtual 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:makeExtensionsImmutable	()V
    //   856: return
    //   857: astore_2
    //   858: goto -105 -> 753
    //   861: astore_1
    //   862: goto -34 -> 828
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	865	0	this	TypeParameter
    //   0	865	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	865	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   40	767	3	i	int
    //   47	685	4	j	int
    //   50	626	5	k	int
    //   53	644	6	m	int
    //   59	427	7	n	int
    //   37	629	8	i1	int
    //   157	345	9	i2	int
    //   26	817	10	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   34	790	11	localCodedOutputStream	CodedOutputStream
    //   467	73	12	localVariance	ProtoBuf.TypeParameter.Variance
    // Exception table:
    //   from	to	target	type
    //   55	61	670	finally
    //   124	137	670	finally
    //   149	159	670	finally
    //   183	190	670	finally
    //   199	210	670	finally
    //   228	235	670	finally
    //   247	264	670	finally
    //   279	285	670	finally
    //   312	323	670	finally
    //   341	358	670	finally
    //   385	396	670	finally
    //   414	432	670	finally
    //   447	453	670	finally
    //   462	469	670	finally
    //   483	490	670	finally
    //   499	506	670	finally
    //   518	529	670	finally
    //   538	544	670	finally
    //   556	566	670	finally
    //   575	583	670	finally
    //   595	605	670	finally
    //   614	622	670	finally
    //   634	644	670	finally
    //   653	661	670	finally
    //   679	695	670	finally
    //   700	706	670	finally
    //   55	61	674	java/io/IOException
    //   124	137	674	java/io/IOException
    //   149	159	674	java/io/IOException
    //   183	190	674	java/io/IOException
    //   199	210	674	java/io/IOException
    //   228	235	674	java/io/IOException
    //   247	264	674	java/io/IOException
    //   279	285	674	java/io/IOException
    //   312	323	674	java/io/IOException
    //   341	358	674	java/io/IOException
    //   385	396	674	java/io/IOException
    //   414	432	674	java/io/IOException
    //   447	453	674	java/io/IOException
    //   462	469	674	java/io/IOException
    //   483	490	674	java/io/IOException
    //   499	506	674	java/io/IOException
    //   518	529	674	java/io/IOException
    //   538	544	674	java/io/IOException
    //   556	566	674	java/io/IOException
    //   575	583	674	java/io/IOException
    //   595	605	674	java/io/IOException
    //   614	622	674	java/io/IOException
    //   634	644	674	java/io/IOException
    //   653	661	674	java/io/IOException
    //   55	61	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   124	137	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   149	159	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   183	190	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   199	210	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   228	235	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   247	264	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   279	285	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   312	323	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   341	358	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   385	396	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   414	432	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   447	453	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   462	469	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   483	490	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   499	506	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   518	529	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   538	544	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   556	566	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   575	583	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   595	605	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   614	622	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   634	644	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   653	661	695	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   748	753	765	finally
    //   823	828	840	finally
    //   748	753	857	java/io/IOException
    //   823	828	861	java/io/IOException
  }
  
  private ProtoBuf$TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$TypeParameter(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static TypeParameter getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.id_ = 0;
    this.name_ = 0;
    this.reified_ = false;
    this.variance_ = ProtoBuf.TypeParameter.Variance.INV;
    this.upperBound_ = Collections.emptyList();
    this.upperBoundId_ = Collections.emptyList();
  }
  
  public static ProtoBuf.TypeParameter.Builder newBuilder()
  {
    return ProtoBuf.TypeParameter.Builder.access$7600();
  }
  
  public static ProtoBuf.TypeParameter.Builder newBuilder(TypeParameter paramTypeParameter)
  {
    return newBuilder().mergeFrom(paramTypeParameter);
  }
  
  public TypeParameter getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getId()
  {
    return this.id_;
  }
  
  public int getName()
  {
    return this.name_;
  }
  
  public Parser<TypeParameter> getParserForType()
  {
    return PARSER;
  }
  
  public boolean getReified()
  {
    return this.reified_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int k = 0;
    if ((i & 0x1) == 1) {
      j = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeInt32Size(2, this.name_);
    }
    int j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeBoolSize(3, this.reified_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
    }
    j = 0;
    while (j < this.upperBound_.size())
    {
      i += CodedOutputStream.computeMessageSize(5, (MessageLite)this.upperBound_.get(j));
      j += 1;
    }
    j = 0;
    while (k < this.upperBoundId_.size())
    {
      j += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.upperBoundId_.get(k)).intValue());
      k += 1;
    }
    k = i + j;
    i = k;
    if (!getUpperBoundIdList().isEmpty()) {
      i = k + 1 + CodedOutputStream.computeInt32SizeNoTag(j);
    }
    this.upperBoundIdMemoizedSerializedSize = j;
    i = i + extensionsSerializedSize() + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ProtoBuf.Type getUpperBound(int paramInt)
  {
    return (ProtoBuf.Type)this.upperBound_.get(paramInt);
  }
  
  public int getUpperBoundCount()
  {
    return this.upperBound_.size();
  }
  
  public List<Integer> getUpperBoundIdList()
  {
    return this.upperBoundId_;
  }
  
  public List<ProtoBuf.Type> getUpperBoundList()
  {
    return this.upperBound_;
  }
  
  public ProtoBuf.TypeParameter.Variance getVariance()
  {
    return this.variance_;
  }
  
  public boolean hasId()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasReified()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasVariance()
  {
    return (this.bitField0_ & 0x8) == 8;
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
    if (!hasId())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if (!hasName())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    i = 0;
    while (i < getUpperBoundCount())
    {
      if (!getUpperBound(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if (!extensionsAreInitialized())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.TypeParameter.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.TypeParameter.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    GeneratedMessageLite.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.id_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(2, this.name_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeBool(3, this.reified_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeEnum(4, this.variance_.getNumber());
    }
    int j = 0;
    int i = 0;
    while (i < this.upperBound_.size())
    {
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.upperBound_.get(i));
      i += 1;
    }
    i = j;
    if (getUpperBoundIdList().size() > 0)
    {
      paramCodedOutputStream.writeRawVarint32(50);
      paramCodedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
      i = j;
    }
    while (i < this.upperBoundId_.size())
    {
      paramCodedOutputStream.writeInt32NoTag(((Integer)this.upperBoundId_.get(i)).intValue());
      i += 1;
    }
    localExtensionWriter.writeUntil(1000, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter
 * JD-Core Version:    0.7.0.1
 */