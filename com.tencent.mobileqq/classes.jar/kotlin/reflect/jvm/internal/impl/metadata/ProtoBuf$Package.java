package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$Package
  extends GeneratedMessageLite.ExtendableMessage<Package>
  implements ProtoBuf.PackageOrBuilder
{
  public static Parser<Package> PARSER = new ProtoBuf.Package.1();
  private static final Package defaultInstance = new Package(true);
  private int bitField0_;
  private List<ProtoBuf.Function> function_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private List<ProtoBuf.Property> property_;
  private List<ProtoBuf.TypeAlias> typeAlias_;
  private ProtoBuf.TypeTable typeTable_;
  private final ByteString unknownFields;
  private ProtoBuf.VersionRequirementTable versionRequirementTable_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Package(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 54	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 56	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 58	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 47	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:initFields	()V
    //   18: invokestatic 64	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 11
    //   23: aload 11
    //   25: iconst_1
    //   26: invokestatic 70	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 12
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +692 -> 730
    //   41: iload_3
    //   42: istore 4
    //   44: iload_3
    //   45: istore 5
    //   47: iload_3
    //   48: istore 6
    //   50: aload_1
    //   51: invokevirtual 76	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 7
    //   56: iload 7
    //   58: ifeq +538 -> 596
    //   61: iload 7
    //   63: bipush 26
    //   65: if_icmpeq +460 -> 525
    //   68: iload 7
    //   70: bipush 34
    //   72: if_icmpeq +382 -> 454
    //   75: iload 7
    //   77: bipush 42
    //   79: if_icmpeq +304 -> 383
    //   82: aconst_null
    //   83: astore 10
    //   85: aconst_null
    //   86: astore 9
    //   88: iload 7
    //   90: sipush 242
    //   93: if_icmpeq +161 -> 254
    //   96: iload 7
    //   98: sipush 258
    //   101: if_icmpeq +28 -> 129
    //   104: iload_3
    //   105: istore 4
    //   107: iload_3
    //   108: istore 5
    //   110: iload_3
    //   111: istore 6
    //   113: aload_0
    //   114: aload_1
    //   115: aload 12
    //   117: aload_2
    //   118: iload 7
    //   120: invokevirtual 80	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   123: ifne -87 -> 36
    //   126: goto +470 -> 596
    //   129: iload_3
    //   130: istore 4
    //   132: iload_3
    //   133: istore 5
    //   135: iload_3
    //   136: istore 6
    //   138: aload_0
    //   139: getfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:bitField0_	I
    //   142: iconst_2
    //   143: iand
    //   144: iconst_2
    //   145: if_icmpne +21 -> 166
    //   148: iload_3
    //   149: istore 4
    //   151: iload_3
    //   152: istore 5
    //   154: iload_3
    //   155: istore 6
    //   157: aload_0
    //   158: getfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:versionRequirementTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   161: invokevirtual 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder;
    //   164: astore 9
    //   166: iload_3
    //   167: istore 4
    //   169: iload_3
    //   170: istore 5
    //   172: iload_3
    //   173: istore 6
    //   175: aload_0
    //   176: aload_1
    //   177: getstatic 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   180: aload_2
    //   181: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   184: checkcast 86	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable
    //   187: putfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:versionRequirementTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   190: aload 9
    //   192: ifnull +40 -> 232
    //   195: iload_3
    //   196: istore 4
    //   198: iload_3
    //   199: istore 5
    //   201: iload_3
    //   202: istore 6
    //   204: aload 9
    //   206: aload_0
    //   207: getfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:versionRequirementTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   210: invokevirtual 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder;
    //   213: pop
    //   214: iload_3
    //   215: istore 4
    //   217: iload_3
    //   218: istore 5
    //   220: iload_3
    //   221: istore 6
    //   223: aload_0
    //   224: aload 9
    //   226: invokevirtual 105	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   229: putfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:versionRequirementTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   232: iload_3
    //   233: istore 4
    //   235: iload_3
    //   236: istore 5
    //   238: iload_3
    //   239: istore 6
    //   241: aload_0
    //   242: aload_0
    //   243: getfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:bitField0_	I
    //   246: iconst_2
    //   247: ior
    //   248: putfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:bitField0_	I
    //   251: goto -215 -> 36
    //   254: aload 10
    //   256: astore 9
    //   258: iload_3
    //   259: istore 4
    //   261: iload_3
    //   262: istore 5
    //   264: iload_3
    //   265: istore 6
    //   267: aload_0
    //   268: getfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:bitField0_	I
    //   271: iconst_1
    //   272: iand
    //   273: iconst_1
    //   274: if_icmpne +21 -> 295
    //   277: iload_3
    //   278: istore 4
    //   280: iload_3
    //   281: istore 5
    //   283: iload_3
    //   284: istore 6
    //   286: aload_0
    //   287: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   290: invokevirtual 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder;
    //   293: astore 9
    //   295: iload_3
    //   296: istore 4
    //   298: iload_3
    //   299: istore 5
    //   301: iload_3
    //   302: istore 6
    //   304: aload_0
    //   305: aload_1
    //   306: getstatic 113	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   309: aload_2
    //   310: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   313: checkcast 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable
    //   316: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   319: aload 9
    //   321: ifnull +40 -> 361
    //   324: iload_3
    //   325: istore 4
    //   327: iload_3
    //   328: istore 5
    //   330: iload_3
    //   331: istore 6
    //   333: aload 9
    //   335: aload_0
    //   336: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   339: invokevirtual 118	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder;
    //   342: pop
    //   343: iload_3
    //   344: istore 4
    //   346: iload_3
    //   347: istore 5
    //   349: iload_3
    //   350: istore 6
    //   352: aload_0
    //   353: aload 9
    //   355: invokevirtual 121	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   358: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   361: iload_3
    //   362: istore 4
    //   364: iload_3
    //   365: istore 5
    //   367: iload_3
    //   368: istore 6
    //   370: aload_0
    //   371: aload_0
    //   372: getfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:bitField0_	I
    //   375: iconst_1
    //   376: ior
    //   377: putfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:bitField0_	I
    //   380: goto -344 -> 36
    //   383: iload_3
    //   384: istore 7
    //   386: iload_3
    //   387: iconst_4
    //   388: iand
    //   389: iconst_4
    //   390: if_icmpeq +28 -> 418
    //   393: iload_3
    //   394: istore 4
    //   396: iload_3
    //   397: istore 5
    //   399: iload_3
    //   400: istore 6
    //   402: aload_0
    //   403: new 123	java/util/ArrayList
    //   406: dup
    //   407: invokespecial 124	java/util/ArrayList:<init>	()V
    //   410: putfield 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeAlias_	Ljava/util/List;
    //   413: iload_3
    //   414: iconst_4
    //   415: ior
    //   416: istore 7
    //   418: iload 7
    //   420: istore 4
    //   422: iload 7
    //   424: istore 5
    //   426: iload 7
    //   428: istore 6
    //   430: aload_0
    //   431: getfield 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeAlias_	Ljava/util/List;
    //   434: aload_1
    //   435: getstatic 129	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   438: aload_2
    //   439: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   442: invokeinterface 135 2 0
    //   447: pop
    //   448: iload 7
    //   450: istore_3
    //   451: goto -415 -> 36
    //   454: iload_3
    //   455: istore 7
    //   457: iload_3
    //   458: iconst_2
    //   459: iand
    //   460: iconst_2
    //   461: if_icmpeq +28 -> 489
    //   464: iload_3
    //   465: istore 4
    //   467: iload_3
    //   468: istore 5
    //   470: iload_3
    //   471: istore 6
    //   473: aload_0
    //   474: new 123	java/util/ArrayList
    //   477: dup
    //   478: invokespecial 124	java/util/ArrayList:<init>	()V
    //   481: putfield 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:property_	Ljava/util/List;
    //   484: iload_3
    //   485: iconst_2
    //   486: ior
    //   487: istore 7
    //   489: iload 7
    //   491: istore 4
    //   493: iload 7
    //   495: istore 5
    //   497: iload 7
    //   499: istore 6
    //   501: aload_0
    //   502: getfield 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:property_	Ljava/util/List;
    //   505: aload_1
    //   506: getstatic 140	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   509: aload_2
    //   510: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   513: invokeinterface 135 2 0
    //   518: pop
    //   519: iload 7
    //   521: istore_3
    //   522: goto -486 -> 36
    //   525: iload_3
    //   526: istore 7
    //   528: iload_3
    //   529: iconst_1
    //   530: iand
    //   531: iconst_1
    //   532: if_icmpeq +28 -> 560
    //   535: iload_3
    //   536: istore 4
    //   538: iload_3
    //   539: istore 5
    //   541: iload_3
    //   542: istore 6
    //   544: aload_0
    //   545: new 123	java/util/ArrayList
    //   548: dup
    //   549: invokespecial 124	java/util/ArrayList:<init>	()V
    //   552: putfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:function_	Ljava/util/List;
    //   555: iload_3
    //   556: iconst_1
    //   557: ior
    //   558: istore 7
    //   560: iload 7
    //   562: istore 4
    //   564: iload 7
    //   566: istore 5
    //   568: iload 7
    //   570: istore 6
    //   572: aload_0
    //   573: getfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:function_	Ljava/util/List;
    //   576: aload_1
    //   577: getstatic 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   580: aload_2
    //   581: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   584: invokeinterface 135 2 0
    //   589: pop
    //   590: iload 7
    //   592: istore_3
    //   593: goto -557 -> 36
    //   596: iconst_1
    //   597: istore 8
    //   599: goto -563 -> 36
    //   602: astore_1
    //   603: goto +35 -> 638
    //   606: astore_1
    //   607: iload 5
    //   609: istore 4
    //   611: new 51	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   614: dup
    //   615: aload_1
    //   616: invokevirtual 149	java/io/IOException:getMessage	()Ljava/lang/String;
    //   619: invokespecial 152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   622: aload_0
    //   623: invokevirtual 156	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   626: athrow
    //   627: astore_1
    //   628: iload 6
    //   630: istore 4
    //   632: aload_1
    //   633: aload_0
    //   634: invokevirtual 156	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   637: athrow
    //   638: iload 4
    //   640: iconst_1
    //   641: iand
    //   642: iconst_1
    //   643: if_icmpne +14 -> 657
    //   646: aload_0
    //   647: aload_0
    //   648: getfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:function_	Ljava/util/List;
    //   651: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   654: putfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:function_	Ljava/util/List;
    //   657: iload 4
    //   659: iconst_2
    //   660: iand
    //   661: iconst_2
    //   662: if_icmpne +14 -> 676
    //   665: aload_0
    //   666: aload_0
    //   667: getfield 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:property_	Ljava/util/List;
    //   670: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   673: putfield 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:property_	Ljava/util/List;
    //   676: iload 4
    //   678: iconst_4
    //   679: iand
    //   680: iconst_4
    //   681: if_icmpne +14 -> 695
    //   684: aload_0
    //   685: aload_0
    //   686: getfield 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeAlias_	Ljava/util/List;
    //   689: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   692: putfield 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeAlias_	Ljava/util/List;
    //   695: aload 12
    //   697: invokevirtual 165	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   700: aload_0
    //   701: aload 11
    //   703: invokevirtual 171	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   706: putfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   709: goto +15 -> 724
    //   712: astore_1
    //   713: aload_0
    //   714: aload 11
    //   716: invokevirtual 171	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   719: putfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   722: aload_1
    //   723: athrow
    //   724: aload_0
    //   725: invokevirtual 176	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:makeExtensionsImmutable	()V
    //   728: aload_1
    //   729: athrow
    //   730: iload_3
    //   731: iconst_1
    //   732: iand
    //   733: iconst_1
    //   734: if_icmpne +14 -> 748
    //   737: aload_0
    //   738: aload_0
    //   739: getfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:function_	Ljava/util/List;
    //   742: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   745: putfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:function_	Ljava/util/List;
    //   748: iload_3
    //   749: iconst_2
    //   750: iand
    //   751: iconst_2
    //   752: if_icmpne +14 -> 766
    //   755: aload_0
    //   756: aload_0
    //   757: getfield 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:property_	Ljava/util/List;
    //   760: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   763: putfield 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:property_	Ljava/util/List;
    //   766: iload_3
    //   767: iconst_4
    //   768: iand
    //   769: iconst_4
    //   770: if_icmpne +14 -> 784
    //   773: aload_0
    //   774: aload_0
    //   775: getfield 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeAlias_	Ljava/util/List;
    //   778: invokestatic 162	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   781: putfield 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:typeAlias_	Ljava/util/List;
    //   784: aload 12
    //   786: invokevirtual 165	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   789: aload_0
    //   790: aload 11
    //   792: invokevirtual 171	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   795: putfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   798: goto +15 -> 813
    //   801: astore_1
    //   802: aload_0
    //   803: aload 11
    //   805: invokevirtual 171	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   808: putfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   811: aload_1
    //   812: athrow
    //   813: aload_0
    //   814: invokevirtual 176	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:makeExtensionsImmutable	()V
    //   817: return
    //   818: astore_2
    //   819: goto -119 -> 700
    //   822: astore_1
    //   823: goto -34 -> 789
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	826	0	this	Package
    //   0	826	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	826	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   35	734	3	i	int
    //   42	638	4	j	int
    //   45	563	5	k	int
    //   48	581	6	m	int
    //   54	537	7	n	int
    //   32	566	8	i1	int
    //   86	268	9	localObject1	java.lang.Object
    //   83	172	10	localObject2	java.lang.Object
    //   21	783	11	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	756	12	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	602	finally
    //   113	126	602	finally
    //   138	148	602	finally
    //   157	166	602	finally
    //   175	190	602	finally
    //   204	214	602	finally
    //   223	232	602	finally
    //   241	251	602	finally
    //   267	277	602	finally
    //   286	295	602	finally
    //   304	319	602	finally
    //   333	343	602	finally
    //   352	361	602	finally
    //   370	380	602	finally
    //   402	413	602	finally
    //   430	448	602	finally
    //   473	484	602	finally
    //   501	519	602	finally
    //   544	555	602	finally
    //   572	590	602	finally
    //   611	627	602	finally
    //   632	638	602	finally
    //   50	56	606	java/io/IOException
    //   113	126	606	java/io/IOException
    //   138	148	606	java/io/IOException
    //   157	166	606	java/io/IOException
    //   175	190	606	java/io/IOException
    //   204	214	606	java/io/IOException
    //   223	232	606	java/io/IOException
    //   241	251	606	java/io/IOException
    //   267	277	606	java/io/IOException
    //   286	295	606	java/io/IOException
    //   304	319	606	java/io/IOException
    //   333	343	606	java/io/IOException
    //   352	361	606	java/io/IOException
    //   370	380	606	java/io/IOException
    //   402	413	606	java/io/IOException
    //   430	448	606	java/io/IOException
    //   473	484	606	java/io/IOException
    //   501	519	606	java/io/IOException
    //   544	555	606	java/io/IOException
    //   572	590	606	java/io/IOException
    //   50	56	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   113	126	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   138	148	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   157	166	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   175	190	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   204	214	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   223	232	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   241	251	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   267	277	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   286	295	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   304	319	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   333	343	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   352	361	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   370	380	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   402	413	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   430	448	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   473	484	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   501	519	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   544	555	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   572	590	627	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   695	700	712	finally
    //   784	789	801	finally
    //   695	700	818	java/io/IOException
    //   784	789	822	java/io/IOException
  }
  
  private ProtoBuf$Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Package(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Package getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.function_ = Collections.emptyList();
    this.property_ = Collections.emptyList();
    this.typeAlias_ = Collections.emptyList();
    this.typeTable_ = ProtoBuf.TypeTable.getDefaultInstance();
    this.versionRequirementTable_ = ProtoBuf.VersionRequirementTable.getDefaultInstance();
  }
  
  public static ProtoBuf.Package.Builder newBuilder()
  {
    return ProtoBuf.Package.Builder.access$10800();
  }
  
  public static ProtoBuf.Package.Builder newBuilder(Package paramPackage)
  {
    return newBuilder().mergeFrom(paramPackage);
  }
  
  public static Package parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Package)PARSER.parseFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public Package getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public ProtoBuf.Function getFunction(int paramInt)
  {
    return (ProtoBuf.Function)this.function_.get(paramInt);
  }
  
  public int getFunctionCount()
  {
    return this.function_.size();
  }
  
  public List<ProtoBuf.Function> getFunctionList()
  {
    return this.function_;
  }
  
  public Parser<Package> getParserForType()
  {
    return PARSER;
  }
  
  public ProtoBuf.Property getProperty(int paramInt)
  {
    return (ProtoBuf.Property)this.property_.get(paramInt);
  }
  
  public int getPropertyCount()
  {
    return this.property_.size();
  }
  
  public List<ProtoBuf.Property> getPropertyList()
  {
    return this.property_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int n = 0;
    int j = 0;
    i = 0;
    while (j < this.function_.size())
    {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.function_.get(j));
      j += 1;
    }
    int k = 0;
    int m;
    for (;;)
    {
      m = n;
      j = i;
      if (k >= this.property_.size()) {
        break;
      }
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.property_.get(k));
      k += 1;
    }
    while (m < this.typeAlias_.size())
    {
      j += CodedOutputStream.computeMessageSize(5, (MessageLite)this.typeAlias_.get(m));
      m += 1;
    }
    i = j;
    if ((this.bitField0_ & 0x1) == 1) {
      i = j + CodedOutputStream.computeMessageSize(30, this.typeTable_);
    }
    j = i;
    if ((this.bitField0_ & 0x2) == 2) {
      j = i + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
    }
    i = j + extensionsSerializedSize() + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ProtoBuf.TypeAlias getTypeAlias(int paramInt)
  {
    return (ProtoBuf.TypeAlias)this.typeAlias_.get(paramInt);
  }
  
  public int getTypeAliasCount()
  {
    return this.typeAlias_.size();
  }
  
  public List<ProtoBuf.TypeAlias> getTypeAliasList()
  {
    return this.typeAlias_;
  }
  
  public ProtoBuf.TypeTable getTypeTable()
  {
    return this.typeTable_;
  }
  
  public ProtoBuf.VersionRequirementTable getVersionRequirementTable()
  {
    return this.versionRequirementTable_;
  }
  
  public boolean hasTypeTable()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasVersionRequirementTable()
  {
    return (this.bitField0_ & 0x2) == 2;
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
    i = 0;
    while (i < getFunctionCount())
    {
      if (!getFunction(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getPropertyCount())
    {
      if (!getProperty(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getTypeAliasCount())
    {
      if (!getTypeAlias(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if ((hasTypeTable()) && (!getTypeTable().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if (!extensionsAreInitialized())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Package.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Package.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    GeneratedMessageLite.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    int k = 0;
    int i = 0;
    while (i < this.function_.size())
    {
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.function_.get(i));
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.property_.size()) {
        break;
      }
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.property_.get(i));
      i += 1;
    }
    while (j < this.typeAlias_.size())
    {
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.typeAlias_.get(j));
      j += 1;
    }
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeMessage(30, this.typeTable_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeMessage(32, this.versionRequirementTable_);
    }
    localExtensionWriter.writeUntil(200, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package
 * JD-Core Version:    0.7.0.1
 */