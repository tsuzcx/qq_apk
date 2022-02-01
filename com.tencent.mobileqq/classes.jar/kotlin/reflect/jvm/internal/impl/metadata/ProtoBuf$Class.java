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

public final class ProtoBuf$Class
  extends GeneratedMessageLite.ExtendableMessage<Class>
  implements ProtoBuf.ClassOrBuilder
{
  public static Parser<Class> PARSER = new ProtoBuf.Class.1();
  private static final Class defaultInstance = new Class(true);
  private int bitField0_;
  private int companionObjectName_;
  private List<ProtoBuf.Constructor> constructor_;
  private List<ProtoBuf.EnumEntry> enumEntry_;
  private int flags_;
  private int fqName_;
  private List<ProtoBuf.Function> function_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int nestedClassNameMemoizedSerializedSize = -1;
  private List<Integer> nestedClassName_;
  private List<ProtoBuf.Property> property_;
  private int sealedSubclassFqNameMemoizedSerializedSize = -1;
  private List<Integer> sealedSubclassFqName_;
  private int supertypeIdMemoizedSerializedSize = -1;
  private List<Integer> supertypeId_;
  private List<ProtoBuf.Type> supertype_;
  private List<ProtoBuf.TypeAlias> typeAlias_;
  private List<ProtoBuf.TypeParameter> typeParameter_;
  private ProtoBuf.TypeTable typeTable_;
  private final ByteString unknownFields;
  private ProtoBuf.VersionRequirementTable versionRequirementTable_;
  private List<Integer> versionRequirement_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Class(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 73	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeIdMemoizedSerializedSize	I
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassNameMemoizedSerializedSize	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqNameMemoizedSerializedSize	I
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 81	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:memoizedIsInitialized	B
    //   24: aload_0
    //   25: iconst_m1
    //   26: putfield 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:memoizedSerializedSize	I
    //   29: aload_0
    //   30: invokespecial 66	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:initFields	()V
    //   33: invokestatic 89	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   36: astore 13
    //   38: aload 13
    //   40: iconst_1
    //   41: invokestatic 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   44: astore 14
    //   46: iconst_0
    //   47: istore 8
    //   49: iconst_0
    //   50: istore_3
    //   51: iload 8
    //   53: ifne +2390 -> 2443
    //   56: iload_3
    //   57: istore 4
    //   59: iload_3
    //   60: istore 5
    //   62: iload_3
    //   63: istore 6
    //   65: aload_1
    //   66: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   69: istore 7
    //   71: aconst_null
    //   72: astore 12
    //   74: aconst_null
    //   75: astore 11
    //   77: iload 7
    //   79: lookupswitch	default:+2640->2719, 0:+2022->2101, 8:+1980->2059, 16:+1907->1986, 18:+1756->1835, 24:+1717->1796, 32:+1678->1757, 42:+1604->1683, 50:+1530->1609, 56:+1457->1536, 58:+1306->1385, 66:+1229->1308, 74:+1152->1231, 82:+1075->1154, 90:+998->1077, 106:+921->1000, 128:+845->924, 130:+691->770, 242:+559->638, 248:+483->562, 250:+329->408, 258:+201->280
    //   257: istore 4
    //   259: iload_3
    //   260: istore 5
    //   262: iload_3
    //   263: istore 6
    //   265: aload_0
    //   266: aload_1
    //   267: aload 14
    //   269: aload_2
    //   270: iload 7
    //   272: invokevirtual 105	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   275: istore 10
    //   277: goto +1833 -> 2110
    //   280: iload_3
    //   281: istore 4
    //   283: iload_3
    //   284: istore 5
    //   286: iload_3
    //   287: istore 6
    //   289: aload_0
    //   290: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   293: bipush 16
    //   295: iand
    //   296: bipush 16
    //   298: if_icmpne +21 -> 319
    //   301: iload_3
    //   302: istore 4
    //   304: iload_3
    //   305: istore 5
    //   307: iload_3
    //   308: istore 6
    //   310: aload_0
    //   311: getfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirementTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   314: invokevirtual 115	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder;
    //   317: astore 11
    //   319: iload_3
    //   320: istore 4
    //   322: iload_3
    //   323: istore 5
    //   325: iload_3
    //   326: istore 6
    //   328: aload_0
    //   329: aload_1
    //   330: getstatic 116	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   333: aload_2
    //   334: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   337: checkcast 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable
    //   340: putfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirementTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   343: aload 11
    //   345: ifnull +40 -> 385
    //   348: iload_3
    //   349: istore 4
    //   351: iload_3
    //   352: istore 5
    //   354: iload_3
    //   355: istore 6
    //   357: aload 11
    //   359: aload_0
    //   360: getfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirementTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   363: invokevirtual 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder;
    //   366: pop
    //   367: iload_3
    //   368: istore 4
    //   370: iload_3
    //   371: istore 5
    //   373: iload_3
    //   374: istore 6
    //   376: aload_0
    //   377: aload 11
    //   379: invokevirtual 130	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   382: putfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirementTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;
    //   385: iload_3
    //   386: istore 4
    //   388: iload_3
    //   389: istore 5
    //   391: iload_3
    //   392: istore 6
    //   394: aload_0
    //   395: aload_0
    //   396: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   399: bipush 16
    //   401: ior
    //   402: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   405: goto +2317 -> 2722
    //   408: iload_3
    //   409: istore 4
    //   411: iload_3
    //   412: istore 5
    //   414: iload_3
    //   415: istore 6
    //   417: aload_1
    //   418: aload_1
    //   419: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   422: invokevirtual 137	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   425: istore 9
    //   427: iload_3
    //   428: istore 7
    //   430: iload_3
    //   431: sipush 16384
    //   434: iand
    //   435: sipush 16384
    //   438: if_icmpeq +49 -> 487
    //   441: iload_3
    //   442: istore 7
    //   444: iload_3
    //   445: istore 4
    //   447: iload_3
    //   448: istore 5
    //   450: iload_3
    //   451: istore 6
    //   453: aload_1
    //   454: invokevirtual 140	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   457: ifle +30 -> 487
    //   460: iload_3
    //   461: istore 4
    //   463: iload_3
    //   464: istore 5
    //   466: iload_3
    //   467: istore 6
    //   469: aload_0
    //   470: new 142	java/util/ArrayList
    //   473: dup
    //   474: invokespecial 143	java/util/ArrayList:<init>	()V
    //   477: putfield 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirement_	Ljava/util/List;
    //   480: iload_3
    //   481: sipush 16384
    //   484: ior
    //   485: istore 7
    //   487: iload 7
    //   489: istore 4
    //   491: iload 7
    //   493: istore 5
    //   495: iload 7
    //   497: istore 6
    //   499: aload_1
    //   500: invokevirtual 140	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   503: ifle +35 -> 538
    //   506: iload 7
    //   508: istore 4
    //   510: iload 7
    //   512: istore 5
    //   514: iload 7
    //   516: istore 6
    //   518: aload_0
    //   519: getfield 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirement_	Ljava/util/List;
    //   522: aload_1
    //   523: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   526: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: invokeinterface 160 2 0
    //   534: pop
    //   535: goto -48 -> 487
    //   538: iload 7
    //   540: istore 4
    //   542: iload 7
    //   544: istore 5
    //   546: iload 7
    //   548: istore 6
    //   550: aload_1
    //   551: iload 9
    //   553: invokevirtual 164	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   556: iload 7
    //   558: istore_3
    //   559: goto +2163 -> 2722
    //   562: iload_3
    //   563: istore 7
    //   565: iload_3
    //   566: sipush 16384
    //   569: iand
    //   570: sipush 16384
    //   573: if_icmpeq +30 -> 603
    //   576: iload_3
    //   577: istore 4
    //   579: iload_3
    //   580: istore 5
    //   582: iload_3
    //   583: istore 6
    //   585: aload_0
    //   586: new 142	java/util/ArrayList
    //   589: dup
    //   590: invokespecial 143	java/util/ArrayList:<init>	()V
    //   593: putfield 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirement_	Ljava/util/List;
    //   596: iload_3
    //   597: sipush 16384
    //   600: ior
    //   601: istore 7
    //   603: iload 7
    //   605: istore 4
    //   607: iload 7
    //   609: istore 5
    //   611: iload 7
    //   613: istore 6
    //   615: aload_0
    //   616: getfield 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirement_	Ljava/util/List;
    //   619: aload_1
    //   620: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   623: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: invokeinterface 160 2 0
    //   631: pop
    //   632: iload 7
    //   634: istore_3
    //   635: goto +2087 -> 2722
    //   638: aload 12
    //   640: astore 11
    //   642: iload_3
    //   643: istore 4
    //   645: iload_3
    //   646: istore 5
    //   648: iload_3
    //   649: istore 6
    //   651: aload_0
    //   652: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   655: bipush 8
    //   657: iand
    //   658: bipush 8
    //   660: if_icmpne +21 -> 681
    //   663: iload_3
    //   664: istore 4
    //   666: iload_3
    //   667: istore 5
    //   669: iload_3
    //   670: istore 6
    //   672: aload_0
    //   673: getfield 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   676: invokevirtual 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder;
    //   679: astore 11
    //   681: iload_3
    //   682: istore 4
    //   684: iload_3
    //   685: istore 5
    //   687: iload_3
    //   688: istore 6
    //   690: aload_0
    //   691: aload_1
    //   692: getstatic 172	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   695: aload_2
    //   696: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   699: checkcast 168	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable
    //   702: putfield 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   705: aload 11
    //   707: ifnull +40 -> 747
    //   710: iload_3
    //   711: istore 4
    //   713: iload_3
    //   714: istore 5
    //   716: iload_3
    //   717: istore 6
    //   719: aload 11
    //   721: aload_0
    //   722: getfield 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   725: invokevirtual 177	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder;
    //   728: pop
    //   729: iload_3
    //   730: istore 4
    //   732: iload_3
    //   733: istore 5
    //   735: iload_3
    //   736: istore 6
    //   738: aload_0
    //   739: aload 11
    //   741: invokevirtual 180	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   744: putfield 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   747: iload_3
    //   748: istore 4
    //   750: iload_3
    //   751: istore 5
    //   753: iload_3
    //   754: istore 6
    //   756: aload_0
    //   757: aload_0
    //   758: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   761: bipush 8
    //   763: ior
    //   764: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   767: goto +1955 -> 2722
    //   770: iload_3
    //   771: istore 4
    //   773: iload_3
    //   774: istore 5
    //   776: iload_3
    //   777: istore 6
    //   779: aload_1
    //   780: aload_1
    //   781: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   784: invokevirtual 137	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   787: istore 9
    //   789: iload_3
    //   790: istore 7
    //   792: iload_3
    //   793: sipush 4096
    //   796: iand
    //   797: sipush 4096
    //   800: if_icmpeq +49 -> 849
    //   803: iload_3
    //   804: istore 7
    //   806: iload_3
    //   807: istore 4
    //   809: iload_3
    //   810: istore 5
    //   812: iload_3
    //   813: istore 6
    //   815: aload_1
    //   816: invokevirtual 140	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   819: ifle +30 -> 849
    //   822: iload_3
    //   823: istore 4
    //   825: iload_3
    //   826: istore 5
    //   828: iload_3
    //   829: istore 6
    //   831: aload_0
    //   832: new 142	java/util/ArrayList
    //   835: dup
    //   836: invokespecial 143	java/util/ArrayList:<init>	()V
    //   839: putfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqName_	Ljava/util/List;
    //   842: iload_3
    //   843: sipush 4096
    //   846: ior
    //   847: istore 7
    //   849: iload 7
    //   851: istore 4
    //   853: iload 7
    //   855: istore 5
    //   857: iload 7
    //   859: istore 6
    //   861: aload_1
    //   862: invokevirtual 140	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   865: ifle +35 -> 900
    //   868: iload 7
    //   870: istore 4
    //   872: iload 7
    //   874: istore 5
    //   876: iload 7
    //   878: istore 6
    //   880: aload_0
    //   881: getfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqName_	Ljava/util/List;
    //   884: aload_1
    //   885: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   888: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   891: invokeinterface 160 2 0
    //   896: pop
    //   897: goto -48 -> 849
    //   900: iload 7
    //   902: istore 4
    //   904: iload 7
    //   906: istore 5
    //   908: iload 7
    //   910: istore 6
    //   912: aload_1
    //   913: iload 9
    //   915: invokevirtual 164	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   918: iload 7
    //   920: istore_3
    //   921: goto +1801 -> 2722
    //   924: iload_3
    //   925: istore 7
    //   927: iload_3
    //   928: sipush 4096
    //   931: iand
    //   932: sipush 4096
    //   935: if_icmpeq +30 -> 965
    //   938: iload_3
    //   939: istore 4
    //   941: iload_3
    //   942: istore 5
    //   944: iload_3
    //   945: istore 6
    //   947: aload_0
    //   948: new 142	java/util/ArrayList
    //   951: dup
    //   952: invokespecial 143	java/util/ArrayList:<init>	()V
    //   955: putfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqName_	Ljava/util/List;
    //   958: iload_3
    //   959: sipush 4096
    //   962: ior
    //   963: istore 7
    //   965: iload 7
    //   967: istore 4
    //   969: iload 7
    //   971: istore 5
    //   973: iload 7
    //   975: istore 6
    //   977: aload_0
    //   978: getfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqName_	Ljava/util/List;
    //   981: aload_1
    //   982: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   985: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   988: invokeinterface 160 2 0
    //   993: pop
    //   994: iload 7
    //   996: istore_3
    //   997: goto +1725 -> 2722
    //   1000: iload_3
    //   1001: istore 7
    //   1003: iload_3
    //   1004: sipush 2048
    //   1007: iand
    //   1008: sipush 2048
    //   1011: if_icmpeq +30 -> 1041
    //   1014: iload_3
    //   1015: istore 4
    //   1017: iload_3
    //   1018: istore 5
    //   1020: iload_3
    //   1021: istore 6
    //   1023: aload_0
    //   1024: new 142	java/util/ArrayList
    //   1027: dup
    //   1028: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1031: putfield 184	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:enumEntry_	Ljava/util/List;
    //   1034: iload_3
    //   1035: sipush 2048
    //   1038: ior
    //   1039: istore 7
    //   1041: iload 7
    //   1043: istore 4
    //   1045: iload 7
    //   1047: istore 5
    //   1049: iload 7
    //   1051: istore 6
    //   1053: aload_0
    //   1054: getfield 184	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:enumEntry_	Ljava/util/List;
    //   1057: aload_1
    //   1058: getstatic 187	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1061: aload_2
    //   1062: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1065: invokeinterface 160 2 0
    //   1070: pop
    //   1071: iload 7
    //   1073: istore_3
    //   1074: goto +1648 -> 2722
    //   1077: iload_3
    //   1078: istore 7
    //   1080: iload_3
    //   1081: sipush 1024
    //   1084: iand
    //   1085: sipush 1024
    //   1088: if_icmpeq +30 -> 1118
    //   1091: iload_3
    //   1092: istore 4
    //   1094: iload_3
    //   1095: istore 5
    //   1097: iload_3
    //   1098: istore 6
    //   1100: aload_0
    //   1101: new 142	java/util/ArrayList
    //   1104: dup
    //   1105: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1108: putfield 189	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeAlias_	Ljava/util/List;
    //   1111: iload_3
    //   1112: sipush 1024
    //   1115: ior
    //   1116: istore 7
    //   1118: iload 7
    //   1120: istore 4
    //   1122: iload 7
    //   1124: istore 5
    //   1126: iload 7
    //   1128: istore 6
    //   1130: aload_0
    //   1131: getfield 189	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeAlias_	Ljava/util/List;
    //   1134: aload_1
    //   1135: getstatic 192	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1138: aload_2
    //   1139: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1142: invokeinterface 160 2 0
    //   1147: pop
    //   1148: iload 7
    //   1150: istore_3
    //   1151: goto +1571 -> 2722
    //   1154: iload_3
    //   1155: istore 7
    //   1157: iload_3
    //   1158: sipush 512
    //   1161: iand
    //   1162: sipush 512
    //   1165: if_icmpeq +30 -> 1195
    //   1168: iload_3
    //   1169: istore 4
    //   1171: iload_3
    //   1172: istore 5
    //   1174: iload_3
    //   1175: istore 6
    //   1177: aload_0
    //   1178: new 142	java/util/ArrayList
    //   1181: dup
    //   1182: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1185: putfield 194	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:property_	Ljava/util/List;
    //   1188: iload_3
    //   1189: sipush 512
    //   1192: ior
    //   1193: istore 7
    //   1195: iload 7
    //   1197: istore 4
    //   1199: iload 7
    //   1201: istore 5
    //   1203: iload 7
    //   1205: istore 6
    //   1207: aload_0
    //   1208: getfield 194	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:property_	Ljava/util/List;
    //   1211: aload_1
    //   1212: getstatic 197	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1215: aload_2
    //   1216: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1219: invokeinterface 160 2 0
    //   1224: pop
    //   1225: iload 7
    //   1227: istore_3
    //   1228: goto +1494 -> 2722
    //   1231: iload_3
    //   1232: istore 7
    //   1234: iload_3
    //   1235: sipush 256
    //   1238: iand
    //   1239: sipush 256
    //   1242: if_icmpeq +30 -> 1272
    //   1245: iload_3
    //   1246: istore 4
    //   1248: iload_3
    //   1249: istore 5
    //   1251: iload_3
    //   1252: istore 6
    //   1254: aload_0
    //   1255: new 142	java/util/ArrayList
    //   1258: dup
    //   1259: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1262: putfield 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:function_	Ljava/util/List;
    //   1265: iload_3
    //   1266: sipush 256
    //   1269: ior
    //   1270: istore 7
    //   1272: iload 7
    //   1274: istore 4
    //   1276: iload 7
    //   1278: istore 5
    //   1280: iload 7
    //   1282: istore 6
    //   1284: aload_0
    //   1285: getfield 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:function_	Ljava/util/List;
    //   1288: aload_1
    //   1289: getstatic 202	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1292: aload_2
    //   1293: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1296: invokeinterface 160 2 0
    //   1301: pop
    //   1302: iload 7
    //   1304: istore_3
    //   1305: goto +1417 -> 2722
    //   1308: iload_3
    //   1309: istore 7
    //   1311: iload_3
    //   1312: sipush 128
    //   1315: iand
    //   1316: sipush 128
    //   1319: if_icmpeq +30 -> 1349
    //   1322: iload_3
    //   1323: istore 4
    //   1325: iload_3
    //   1326: istore 5
    //   1328: iload_3
    //   1329: istore 6
    //   1331: aload_0
    //   1332: new 142	java/util/ArrayList
    //   1335: dup
    //   1336: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1339: putfield 204	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:constructor_	Ljava/util/List;
    //   1342: iload_3
    //   1343: sipush 128
    //   1346: ior
    //   1347: istore 7
    //   1349: iload 7
    //   1351: istore 4
    //   1353: iload 7
    //   1355: istore 5
    //   1357: iload 7
    //   1359: istore 6
    //   1361: aload_0
    //   1362: getfield 204	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:constructor_	Ljava/util/List;
    //   1365: aload_1
    //   1366: getstatic 207	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1369: aload_2
    //   1370: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1373: invokeinterface 160 2 0
    //   1378: pop
    //   1379: iload 7
    //   1381: istore_3
    //   1382: goto +1340 -> 2722
    //   1385: iload_3
    //   1386: istore 4
    //   1388: iload_3
    //   1389: istore 5
    //   1391: iload_3
    //   1392: istore 6
    //   1394: aload_1
    //   1395: aload_1
    //   1396: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   1399: invokevirtual 137	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   1402: istore 9
    //   1404: iload_3
    //   1405: istore 7
    //   1407: iload_3
    //   1408: bipush 64
    //   1410: iand
    //   1411: bipush 64
    //   1413: if_icmpeq +48 -> 1461
    //   1416: iload_3
    //   1417: istore 7
    //   1419: iload_3
    //   1420: istore 4
    //   1422: iload_3
    //   1423: istore 5
    //   1425: iload_3
    //   1426: istore 6
    //   1428: aload_1
    //   1429: invokevirtual 140	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   1432: ifle +29 -> 1461
    //   1435: iload_3
    //   1436: istore 4
    //   1438: iload_3
    //   1439: istore 5
    //   1441: iload_3
    //   1442: istore 6
    //   1444: aload_0
    //   1445: new 142	java/util/ArrayList
    //   1448: dup
    //   1449: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1452: putfield 209	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassName_	Ljava/util/List;
    //   1455: iload_3
    //   1456: bipush 64
    //   1458: ior
    //   1459: istore 7
    //   1461: iload 7
    //   1463: istore 4
    //   1465: iload 7
    //   1467: istore 5
    //   1469: iload 7
    //   1471: istore 6
    //   1473: aload_1
    //   1474: invokevirtual 140	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   1477: ifle +35 -> 1512
    //   1480: iload 7
    //   1482: istore 4
    //   1484: iload 7
    //   1486: istore 5
    //   1488: iload 7
    //   1490: istore 6
    //   1492: aload_0
    //   1493: getfield 209	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassName_	Ljava/util/List;
    //   1496: aload_1
    //   1497: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1500: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1503: invokeinterface 160 2 0
    //   1508: pop
    //   1509: goto -48 -> 1461
    //   1512: iload 7
    //   1514: istore 4
    //   1516: iload 7
    //   1518: istore 5
    //   1520: iload 7
    //   1522: istore 6
    //   1524: aload_1
    //   1525: iload 9
    //   1527: invokevirtual 164	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   1530: iload 7
    //   1532: istore_3
    //   1533: goto +1189 -> 2722
    //   1536: iload_3
    //   1537: istore 7
    //   1539: iload_3
    //   1540: bipush 64
    //   1542: iand
    //   1543: bipush 64
    //   1545: if_icmpeq +29 -> 1574
    //   1548: iload_3
    //   1549: istore 4
    //   1551: iload_3
    //   1552: istore 5
    //   1554: iload_3
    //   1555: istore 6
    //   1557: aload_0
    //   1558: new 142	java/util/ArrayList
    //   1561: dup
    //   1562: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1565: putfield 209	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassName_	Ljava/util/List;
    //   1568: iload_3
    //   1569: bipush 64
    //   1571: ior
    //   1572: istore 7
    //   1574: iload 7
    //   1576: istore 4
    //   1578: iload 7
    //   1580: istore 5
    //   1582: iload 7
    //   1584: istore 6
    //   1586: aload_0
    //   1587: getfield 209	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassName_	Ljava/util/List;
    //   1590: aload_1
    //   1591: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1594: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1597: invokeinterface 160 2 0
    //   1602: pop
    //   1603: iload 7
    //   1605: istore_3
    //   1606: goto +1116 -> 2722
    //   1609: iload_3
    //   1610: istore 7
    //   1612: iload_3
    //   1613: bipush 16
    //   1615: iand
    //   1616: bipush 16
    //   1618: if_icmpeq +29 -> 1647
    //   1621: iload_3
    //   1622: istore 4
    //   1624: iload_3
    //   1625: istore 5
    //   1627: iload_3
    //   1628: istore 6
    //   1630: aload_0
    //   1631: new 142	java/util/ArrayList
    //   1634: dup
    //   1635: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1638: putfield 211	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertype_	Ljava/util/List;
    //   1641: iload_3
    //   1642: bipush 16
    //   1644: ior
    //   1645: istore 7
    //   1647: iload 7
    //   1649: istore 4
    //   1651: iload 7
    //   1653: istore 5
    //   1655: iload 7
    //   1657: istore 6
    //   1659: aload_0
    //   1660: getfield 211	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertype_	Ljava/util/List;
    //   1663: aload_1
    //   1664: getstatic 214	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1667: aload_2
    //   1668: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1671: invokeinterface 160 2 0
    //   1676: pop
    //   1677: iload 7
    //   1679: istore_3
    //   1680: goto +1042 -> 2722
    //   1683: iload_3
    //   1684: istore 7
    //   1686: iload_3
    //   1687: bipush 8
    //   1689: iand
    //   1690: bipush 8
    //   1692: if_icmpeq +29 -> 1721
    //   1695: iload_3
    //   1696: istore 4
    //   1698: iload_3
    //   1699: istore 5
    //   1701: iload_3
    //   1702: istore 6
    //   1704: aload_0
    //   1705: new 142	java/util/ArrayList
    //   1708: dup
    //   1709: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1712: putfield 216	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeParameter_	Ljava/util/List;
    //   1715: iload_3
    //   1716: bipush 8
    //   1718: ior
    //   1719: istore 7
    //   1721: iload 7
    //   1723: istore 4
    //   1725: iload 7
    //   1727: istore 5
    //   1729: iload 7
    //   1731: istore 6
    //   1733: aload_0
    //   1734: getfield 216	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeParameter_	Ljava/util/List;
    //   1737: aload_1
    //   1738: getstatic 219	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1741: aload_2
    //   1742: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1745: invokeinterface 160 2 0
    //   1750: pop
    //   1751: iload 7
    //   1753: istore_3
    //   1754: goto +968 -> 2722
    //   1757: iload_3
    //   1758: istore 4
    //   1760: iload_3
    //   1761: istore 5
    //   1763: iload_3
    //   1764: istore 6
    //   1766: aload_0
    //   1767: aload_0
    //   1768: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   1771: iconst_4
    //   1772: ior
    //   1773: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   1776: iload_3
    //   1777: istore 4
    //   1779: iload_3
    //   1780: istore 5
    //   1782: iload_3
    //   1783: istore 6
    //   1785: aload_0
    //   1786: aload_1
    //   1787: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1790: putfield 221	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:companionObjectName_	I
    //   1793: goto +929 -> 2722
    //   1796: iload_3
    //   1797: istore 4
    //   1799: iload_3
    //   1800: istore 5
    //   1802: iload_3
    //   1803: istore 6
    //   1805: aload_0
    //   1806: aload_0
    //   1807: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   1810: iconst_2
    //   1811: ior
    //   1812: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   1815: iload_3
    //   1816: istore 4
    //   1818: iload_3
    //   1819: istore 5
    //   1821: iload_3
    //   1822: istore 6
    //   1824: aload_0
    //   1825: aload_1
    //   1826: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1829: putfield 223	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:fqName_	I
    //   1832: goto +890 -> 2722
    //   1835: iload_3
    //   1836: istore 4
    //   1838: iload_3
    //   1839: istore 5
    //   1841: iload_3
    //   1842: istore 6
    //   1844: aload_1
    //   1845: aload_1
    //   1846: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   1849: invokevirtual 137	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   1852: istore 9
    //   1854: iload_3
    //   1855: istore 7
    //   1857: iload_3
    //   1858: bipush 32
    //   1860: iand
    //   1861: bipush 32
    //   1863: if_icmpeq +48 -> 1911
    //   1866: iload_3
    //   1867: istore 7
    //   1869: iload_3
    //   1870: istore 4
    //   1872: iload_3
    //   1873: istore 5
    //   1875: iload_3
    //   1876: istore 6
    //   1878: aload_1
    //   1879: invokevirtual 140	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   1882: ifle +29 -> 1911
    //   1885: iload_3
    //   1886: istore 4
    //   1888: iload_3
    //   1889: istore 5
    //   1891: iload_3
    //   1892: istore 6
    //   1894: aload_0
    //   1895: new 142	java/util/ArrayList
    //   1898: dup
    //   1899: invokespecial 143	java/util/ArrayList:<init>	()V
    //   1902: putfield 225	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeId_	Ljava/util/List;
    //   1905: iload_3
    //   1906: bipush 32
    //   1908: ior
    //   1909: istore 7
    //   1911: iload 7
    //   1913: istore 4
    //   1915: iload 7
    //   1917: istore 5
    //   1919: iload 7
    //   1921: istore 6
    //   1923: aload_1
    //   1924: invokevirtual 140	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   1927: ifle +35 -> 1962
    //   1930: iload 7
    //   1932: istore 4
    //   1934: iload 7
    //   1936: istore 5
    //   1938: iload 7
    //   1940: istore 6
    //   1942: aload_0
    //   1943: getfield 225	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeId_	Ljava/util/List;
    //   1946: aload_1
    //   1947: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1950: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1953: invokeinterface 160 2 0
    //   1958: pop
    //   1959: goto -48 -> 1911
    //   1962: iload 7
    //   1964: istore 4
    //   1966: iload 7
    //   1968: istore 5
    //   1970: iload 7
    //   1972: istore 6
    //   1974: aload_1
    //   1975: iload 9
    //   1977: invokevirtual 164	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   1980: iload 7
    //   1982: istore_3
    //   1983: goto +739 -> 2722
    //   1986: iload_3
    //   1987: istore 7
    //   1989: iload_3
    //   1990: bipush 32
    //   1992: iand
    //   1993: bipush 32
    //   1995: if_icmpeq +29 -> 2024
    //   1998: iload_3
    //   1999: istore 4
    //   2001: iload_3
    //   2002: istore 5
    //   2004: iload_3
    //   2005: istore 6
    //   2007: aload_0
    //   2008: new 142	java/util/ArrayList
    //   2011: dup
    //   2012: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2015: putfield 225	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeId_	Ljava/util/List;
    //   2018: iload_3
    //   2019: bipush 32
    //   2021: ior
    //   2022: istore 7
    //   2024: iload 7
    //   2026: istore 4
    //   2028: iload 7
    //   2030: istore 5
    //   2032: iload 7
    //   2034: istore 6
    //   2036: aload_0
    //   2037: getfield 225	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeId_	Ljava/util/List;
    //   2040: aload_1
    //   2041: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   2044: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2047: invokeinterface 160 2 0
    //   2052: pop
    //   2053: iload 7
    //   2055: istore_3
    //   2056: goto +666 -> 2722
    //   2059: iload_3
    //   2060: istore 4
    //   2062: iload_3
    //   2063: istore 5
    //   2065: iload_3
    //   2066: istore 6
    //   2068: aload_0
    //   2069: aload_0
    //   2070: getfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   2073: iconst_1
    //   2074: ior
    //   2075: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:bitField0_	I
    //   2078: iload_3
    //   2079: istore 4
    //   2081: iload_3
    //   2082: istore 5
    //   2084: iload_3
    //   2085: istore 6
    //   2087: aload_0
    //   2088: aload_1
    //   2089: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   2092: putfield 227	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:flags_	I
    //   2095: iload_3
    //   2096: istore 4
    //   2098: goto +23 -> 2121
    //   2101: iconst_1
    //   2102: istore 8
    //   2104: iload_3
    //   2105: istore 4
    //   2107: goto +14 -> 2121
    //   2110: iload_3
    //   2111: istore 4
    //   2113: iload 10
    //   2115: ifne +6 -> 2121
    //   2118: goto -17 -> 2101
    //   2121: iload 4
    //   2123: istore_3
    //   2124: goto -2073 -> 51
    //   2127: astore_1
    //   2128: goto +35 -> 2163
    //   2131: astore_1
    //   2132: iload 5
    //   2134: istore 4
    //   2136: new 70	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   2139: dup
    //   2140: aload_1
    //   2141: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2144: invokespecial 234	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   2147: aload_0
    //   2148: invokevirtual 238	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   2151: athrow
    //   2152: astore_1
    //   2153: iload 6
    //   2155: istore 4
    //   2157: aload_1
    //   2158: aload_0
    //   2159: invokevirtual 238	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   2162: athrow
    //   2163: iload 4
    //   2165: bipush 32
    //   2167: iand
    //   2168: bipush 32
    //   2170: if_icmpne +14 -> 2184
    //   2173: aload_0
    //   2174: aload_0
    //   2175: getfield 225	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeId_	Ljava/util/List;
    //   2178: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2181: putfield 225	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeId_	Ljava/util/List;
    //   2184: iload 4
    //   2186: bipush 8
    //   2188: iand
    //   2189: bipush 8
    //   2191: if_icmpne +14 -> 2205
    //   2194: aload_0
    //   2195: aload_0
    //   2196: getfield 216	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeParameter_	Ljava/util/List;
    //   2199: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2202: putfield 216	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeParameter_	Ljava/util/List;
    //   2205: iload 4
    //   2207: bipush 16
    //   2209: iand
    //   2210: bipush 16
    //   2212: if_icmpne +14 -> 2226
    //   2215: aload_0
    //   2216: aload_0
    //   2217: getfield 211	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertype_	Ljava/util/List;
    //   2220: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2223: putfield 211	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertype_	Ljava/util/List;
    //   2226: iload 4
    //   2228: bipush 64
    //   2230: iand
    //   2231: bipush 64
    //   2233: if_icmpne +14 -> 2247
    //   2236: aload_0
    //   2237: aload_0
    //   2238: getfield 209	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassName_	Ljava/util/List;
    //   2241: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2244: putfield 209	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassName_	Ljava/util/List;
    //   2247: iload 4
    //   2249: sipush 128
    //   2252: iand
    //   2253: sipush 128
    //   2256: if_icmpne +14 -> 2270
    //   2259: aload_0
    //   2260: aload_0
    //   2261: getfield 204	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:constructor_	Ljava/util/List;
    //   2264: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2267: putfield 204	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:constructor_	Ljava/util/List;
    //   2270: iload 4
    //   2272: sipush 256
    //   2275: iand
    //   2276: sipush 256
    //   2279: if_icmpne +14 -> 2293
    //   2282: aload_0
    //   2283: aload_0
    //   2284: getfield 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:function_	Ljava/util/List;
    //   2287: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2290: putfield 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:function_	Ljava/util/List;
    //   2293: iload 4
    //   2295: sipush 512
    //   2298: iand
    //   2299: sipush 512
    //   2302: if_icmpne +14 -> 2316
    //   2305: aload_0
    //   2306: aload_0
    //   2307: getfield 194	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:property_	Ljava/util/List;
    //   2310: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2313: putfield 194	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:property_	Ljava/util/List;
    //   2316: iload 4
    //   2318: sipush 1024
    //   2321: iand
    //   2322: sipush 1024
    //   2325: if_icmpne +14 -> 2339
    //   2328: aload_0
    //   2329: aload_0
    //   2330: getfield 189	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeAlias_	Ljava/util/List;
    //   2333: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2336: putfield 189	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeAlias_	Ljava/util/List;
    //   2339: iload 4
    //   2341: sipush 2048
    //   2344: iand
    //   2345: sipush 2048
    //   2348: if_icmpne +14 -> 2362
    //   2351: aload_0
    //   2352: aload_0
    //   2353: getfield 184	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:enumEntry_	Ljava/util/List;
    //   2356: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2359: putfield 184	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:enumEntry_	Ljava/util/List;
    //   2362: iload 4
    //   2364: sipush 4096
    //   2367: iand
    //   2368: sipush 4096
    //   2371: if_icmpne +14 -> 2385
    //   2374: aload_0
    //   2375: aload_0
    //   2376: getfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqName_	Ljava/util/List;
    //   2379: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2382: putfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqName_	Ljava/util/List;
    //   2385: iload 4
    //   2387: sipush 16384
    //   2390: iand
    //   2391: sipush 16384
    //   2394: if_icmpne +14 -> 2408
    //   2397: aload_0
    //   2398: aload_0
    //   2399: getfield 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirement_	Ljava/util/List;
    //   2402: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2405: putfield 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirement_	Ljava/util/List;
    //   2408: aload 14
    //   2410: invokevirtual 247	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   2413: aload_0
    //   2414: aload 13
    //   2416: invokevirtual 253	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   2419: putfield 255	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   2422: goto +15 -> 2437
    //   2425: astore_1
    //   2426: aload_0
    //   2427: aload 13
    //   2429: invokevirtual 253	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   2432: putfield 255	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   2435: aload_1
    //   2436: athrow
    //   2437: aload_0
    //   2438: invokevirtual 258	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:makeExtensionsImmutable	()V
    //   2441: aload_1
    //   2442: athrow
    //   2443: iload_3
    //   2444: bipush 32
    //   2446: iand
    //   2447: bipush 32
    //   2449: if_icmpne +14 -> 2463
    //   2452: aload_0
    //   2453: aload_0
    //   2454: getfield 225	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeId_	Ljava/util/List;
    //   2457: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2460: putfield 225	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertypeId_	Ljava/util/List;
    //   2463: iload_3
    //   2464: bipush 8
    //   2466: iand
    //   2467: bipush 8
    //   2469: if_icmpne +14 -> 2483
    //   2472: aload_0
    //   2473: aload_0
    //   2474: getfield 216	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeParameter_	Ljava/util/List;
    //   2477: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2480: putfield 216	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeParameter_	Ljava/util/List;
    //   2483: iload_3
    //   2484: bipush 16
    //   2486: iand
    //   2487: bipush 16
    //   2489: if_icmpne +14 -> 2503
    //   2492: aload_0
    //   2493: aload_0
    //   2494: getfield 211	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertype_	Ljava/util/List;
    //   2497: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2500: putfield 211	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:supertype_	Ljava/util/List;
    //   2503: iload_3
    //   2504: bipush 64
    //   2506: iand
    //   2507: bipush 64
    //   2509: if_icmpne +14 -> 2523
    //   2512: aload_0
    //   2513: aload_0
    //   2514: getfield 209	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassName_	Ljava/util/List;
    //   2517: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2520: putfield 209	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:nestedClassName_	Ljava/util/List;
    //   2523: iload_3
    //   2524: sipush 128
    //   2527: iand
    //   2528: sipush 128
    //   2531: if_icmpne +14 -> 2545
    //   2534: aload_0
    //   2535: aload_0
    //   2536: getfield 204	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:constructor_	Ljava/util/List;
    //   2539: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2542: putfield 204	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:constructor_	Ljava/util/List;
    //   2545: iload_3
    //   2546: sipush 256
    //   2549: iand
    //   2550: sipush 256
    //   2553: if_icmpne +14 -> 2567
    //   2556: aload_0
    //   2557: aload_0
    //   2558: getfield 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:function_	Ljava/util/List;
    //   2561: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2564: putfield 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:function_	Ljava/util/List;
    //   2567: iload_3
    //   2568: sipush 512
    //   2571: iand
    //   2572: sipush 512
    //   2575: if_icmpne +14 -> 2589
    //   2578: aload_0
    //   2579: aload_0
    //   2580: getfield 194	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:property_	Ljava/util/List;
    //   2583: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2586: putfield 194	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:property_	Ljava/util/List;
    //   2589: iload_3
    //   2590: sipush 1024
    //   2593: iand
    //   2594: sipush 1024
    //   2597: if_icmpne +14 -> 2611
    //   2600: aload_0
    //   2601: aload_0
    //   2602: getfield 189	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeAlias_	Ljava/util/List;
    //   2605: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2608: putfield 189	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:typeAlias_	Ljava/util/List;
    //   2611: iload_3
    //   2612: sipush 2048
    //   2615: iand
    //   2616: sipush 2048
    //   2619: if_icmpne +14 -> 2633
    //   2622: aload_0
    //   2623: aload_0
    //   2624: getfield 184	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:enumEntry_	Ljava/util/List;
    //   2627: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2630: putfield 184	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:enumEntry_	Ljava/util/List;
    //   2633: iload_3
    //   2634: sipush 4096
    //   2637: iand
    //   2638: sipush 4096
    //   2641: if_icmpne +14 -> 2655
    //   2644: aload_0
    //   2645: aload_0
    //   2646: getfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqName_	Ljava/util/List;
    //   2649: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2652: putfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:sealedSubclassFqName_	Ljava/util/List;
    //   2655: iload_3
    //   2656: sipush 16384
    //   2659: iand
    //   2660: sipush 16384
    //   2663: if_icmpne +14 -> 2677
    //   2666: aload_0
    //   2667: aload_0
    //   2668: getfield 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirement_	Ljava/util/List;
    //   2671: invokestatic 244	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   2674: putfield 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:versionRequirement_	Ljava/util/List;
    //   2677: aload 14
    //   2679: invokevirtual 247	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   2682: aload_0
    //   2683: aload 13
    //   2685: invokevirtual 253	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   2688: putfield 255	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   2691: goto +15 -> 2706
    //   2694: astore_1
    //   2695: aload_0
    //   2696: aload 13
    //   2698: invokevirtual 253	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   2701: putfield 255	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   2704: aload_1
    //   2705: athrow
    //   2706: aload_0
    //   2707: invokevirtual 258	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:makeExtensionsImmutable	()V
    //   2710: return
    //   2711: astore_2
    //   2712: goto -299 -> 2413
    //   2715: astore_1
    //   2716: goto -34 -> 2682
    //   2719: goto -2463 -> 256
    //   2722: iload_3
    //   2723: istore 4
    //   2725: goto -604 -> 2121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2728	0	this	Class
    //   0	2728	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	2728	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   50	2673	3	i	int
    //   57	2667	4	j	int
    //   60	2073	5	k	int
    //   63	2091	6	m	int
    //   69	1985	7	n	int
    //   47	2056	8	i1	int
    //   425	1551	9	i2	int
    //   275	1839	10	bool	boolean
    //   75	665	11	localObject1	java.lang.Object
    //   72	567	12	localObject2	java.lang.Object
    //   36	2661	13	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   44	2634	14	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   65	71	2127	finally
    //   265	277	2127	finally
    //   289	301	2127	finally
    //   310	319	2127	finally
    //   328	343	2127	finally
    //   357	367	2127	finally
    //   376	385	2127	finally
    //   394	405	2127	finally
    //   417	427	2127	finally
    //   453	460	2127	finally
    //   469	480	2127	finally
    //   499	506	2127	finally
    //   518	535	2127	finally
    //   550	556	2127	finally
    //   585	596	2127	finally
    //   615	632	2127	finally
    //   651	663	2127	finally
    //   672	681	2127	finally
    //   690	705	2127	finally
    //   719	729	2127	finally
    //   738	747	2127	finally
    //   756	767	2127	finally
    //   779	789	2127	finally
    //   815	822	2127	finally
    //   831	842	2127	finally
    //   861	868	2127	finally
    //   880	897	2127	finally
    //   912	918	2127	finally
    //   947	958	2127	finally
    //   977	994	2127	finally
    //   1023	1034	2127	finally
    //   1053	1071	2127	finally
    //   1100	1111	2127	finally
    //   1130	1148	2127	finally
    //   1177	1188	2127	finally
    //   1207	1225	2127	finally
    //   1254	1265	2127	finally
    //   1284	1302	2127	finally
    //   1331	1342	2127	finally
    //   1361	1379	2127	finally
    //   1394	1404	2127	finally
    //   1428	1435	2127	finally
    //   1444	1455	2127	finally
    //   1473	1480	2127	finally
    //   1492	1509	2127	finally
    //   1524	1530	2127	finally
    //   1557	1568	2127	finally
    //   1586	1603	2127	finally
    //   1630	1641	2127	finally
    //   1659	1677	2127	finally
    //   1704	1715	2127	finally
    //   1733	1751	2127	finally
    //   1766	1776	2127	finally
    //   1785	1793	2127	finally
    //   1805	1815	2127	finally
    //   1824	1832	2127	finally
    //   1844	1854	2127	finally
    //   1878	1885	2127	finally
    //   1894	1905	2127	finally
    //   1923	1930	2127	finally
    //   1942	1959	2127	finally
    //   1974	1980	2127	finally
    //   2007	2018	2127	finally
    //   2036	2053	2127	finally
    //   2068	2078	2127	finally
    //   2087	2095	2127	finally
    //   2136	2152	2127	finally
    //   2157	2163	2127	finally
    //   65	71	2131	java/io/IOException
    //   265	277	2131	java/io/IOException
    //   289	301	2131	java/io/IOException
    //   310	319	2131	java/io/IOException
    //   328	343	2131	java/io/IOException
    //   357	367	2131	java/io/IOException
    //   376	385	2131	java/io/IOException
    //   394	405	2131	java/io/IOException
    //   417	427	2131	java/io/IOException
    //   453	460	2131	java/io/IOException
    //   469	480	2131	java/io/IOException
    //   499	506	2131	java/io/IOException
    //   518	535	2131	java/io/IOException
    //   550	556	2131	java/io/IOException
    //   585	596	2131	java/io/IOException
    //   615	632	2131	java/io/IOException
    //   651	663	2131	java/io/IOException
    //   672	681	2131	java/io/IOException
    //   690	705	2131	java/io/IOException
    //   719	729	2131	java/io/IOException
    //   738	747	2131	java/io/IOException
    //   756	767	2131	java/io/IOException
    //   779	789	2131	java/io/IOException
    //   815	822	2131	java/io/IOException
    //   831	842	2131	java/io/IOException
    //   861	868	2131	java/io/IOException
    //   880	897	2131	java/io/IOException
    //   912	918	2131	java/io/IOException
    //   947	958	2131	java/io/IOException
    //   977	994	2131	java/io/IOException
    //   1023	1034	2131	java/io/IOException
    //   1053	1071	2131	java/io/IOException
    //   1100	1111	2131	java/io/IOException
    //   1130	1148	2131	java/io/IOException
    //   1177	1188	2131	java/io/IOException
    //   1207	1225	2131	java/io/IOException
    //   1254	1265	2131	java/io/IOException
    //   1284	1302	2131	java/io/IOException
    //   1331	1342	2131	java/io/IOException
    //   1361	1379	2131	java/io/IOException
    //   1394	1404	2131	java/io/IOException
    //   1428	1435	2131	java/io/IOException
    //   1444	1455	2131	java/io/IOException
    //   1473	1480	2131	java/io/IOException
    //   1492	1509	2131	java/io/IOException
    //   1524	1530	2131	java/io/IOException
    //   1557	1568	2131	java/io/IOException
    //   1586	1603	2131	java/io/IOException
    //   1630	1641	2131	java/io/IOException
    //   1659	1677	2131	java/io/IOException
    //   1704	1715	2131	java/io/IOException
    //   1733	1751	2131	java/io/IOException
    //   1766	1776	2131	java/io/IOException
    //   1785	1793	2131	java/io/IOException
    //   1805	1815	2131	java/io/IOException
    //   1824	1832	2131	java/io/IOException
    //   1844	1854	2131	java/io/IOException
    //   1878	1885	2131	java/io/IOException
    //   1894	1905	2131	java/io/IOException
    //   1923	1930	2131	java/io/IOException
    //   1942	1959	2131	java/io/IOException
    //   1974	1980	2131	java/io/IOException
    //   2007	2018	2131	java/io/IOException
    //   2036	2053	2131	java/io/IOException
    //   2068	2078	2131	java/io/IOException
    //   2087	2095	2131	java/io/IOException
    //   65	71	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   265	277	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   289	301	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   310	319	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   328	343	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   357	367	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   376	385	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   394	405	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   417	427	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   453	460	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   469	480	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   499	506	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   518	535	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   550	556	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   585	596	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   615	632	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   651	663	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   672	681	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   690	705	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   719	729	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   738	747	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   756	767	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   779	789	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   815	822	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   831	842	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   861	868	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   880	897	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   912	918	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   947	958	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   977	994	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1023	1034	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1053	1071	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1100	1111	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1130	1148	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1177	1188	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1207	1225	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1254	1265	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1284	1302	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1331	1342	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1361	1379	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1394	1404	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1428	1435	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1444	1455	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1473	1480	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1492	1509	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1524	1530	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1557	1568	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1586	1603	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1630	1641	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1659	1677	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1704	1715	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1733	1751	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1766	1776	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1785	1793	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1805	1815	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1824	1832	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1844	1854	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1878	1885	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1894	1905	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1923	1930	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1942	1959	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1974	1980	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   2007	2018	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   2036	2053	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   2068	2078	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   2087	2095	2152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   2408	2413	2425	finally
    //   2677	2682	2694	finally
    //   2408	2413	2711	java/io/IOException
    //   2677	2682	2715	java/io/IOException
  }
  
  private ProtoBuf$Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Class(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Class getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.flags_ = 6;
    this.fqName_ = 0;
    this.companionObjectName_ = 0;
    this.typeParameter_ = Collections.emptyList();
    this.supertype_ = Collections.emptyList();
    this.supertypeId_ = Collections.emptyList();
    this.nestedClassName_ = Collections.emptyList();
    this.constructor_ = Collections.emptyList();
    this.function_ = Collections.emptyList();
    this.property_ = Collections.emptyList();
    this.typeAlias_ = Collections.emptyList();
    this.enumEntry_ = Collections.emptyList();
    this.sealedSubclassFqName_ = Collections.emptyList();
    this.typeTable_ = ProtoBuf.TypeTable.getDefaultInstance();
    this.versionRequirement_ = Collections.emptyList();
    this.versionRequirementTable_ = ProtoBuf.VersionRequirementTable.getDefaultInstance();
  }
  
  public static ProtoBuf.Class.Builder newBuilder()
  {
    return ProtoBuf.Class.Builder.access$8700();
  }
  
  public static ProtoBuf.Class.Builder newBuilder(Class paramClass)
  {
    return newBuilder().mergeFrom(paramClass);
  }
  
  public static Class parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Class)PARSER.parseFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public int getCompanionObjectName()
  {
    return this.companionObjectName_;
  }
  
  public ProtoBuf.Constructor getConstructor(int paramInt)
  {
    return (ProtoBuf.Constructor)this.constructor_.get(paramInt);
  }
  
  public int getConstructorCount()
  {
    return this.constructor_.size();
  }
  
  public List<ProtoBuf.Constructor> getConstructorList()
  {
    return this.constructor_;
  }
  
  public Class getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public ProtoBuf.EnumEntry getEnumEntry(int paramInt)
  {
    return (ProtoBuf.EnumEntry)this.enumEntry_.get(paramInt);
  }
  
  public int getEnumEntryCount()
  {
    return this.enumEntry_.size();
  }
  
  public List<ProtoBuf.EnumEntry> getEnumEntryList()
  {
    return this.enumEntry_;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public int getFqName()
  {
    return this.fqName_;
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
  
  public List<Integer> getNestedClassNameList()
  {
    return this.nestedClassName_;
  }
  
  public Parser<Class> getParserForType()
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
  
  public List<Integer> getSealedSubclassFqNameList()
  {
    return this.sealedSubclassFqName_;
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
      i = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
    } else {
      i = 0;
    }
    int k = 0;
    int j = 0;
    while (k < this.supertypeId_.size())
    {
      j += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.supertypeId_.get(k)).intValue());
      k += 1;
    }
    k = i + j;
    i = k;
    if (!getSupertypeIdList().isEmpty()) {
      i = k + 1 + CodedOutputStream.computeInt32SizeNoTag(j);
    }
    this.supertypeIdMemoizedSerializedSize = j;
    j = i;
    if ((this.bitField0_ & 0x2) == 2) {
      j = i + CodedOutputStream.computeInt32Size(3, this.fqName_);
    }
    i = j;
    if ((this.bitField0_ & 0x4) == 4) {
      i = j + CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
    }
    j = 0;
    while (j < this.typeParameter_.size())
    {
      i += CodedOutputStream.computeMessageSize(5, (MessageLite)this.typeParameter_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.supertype_.size())
    {
      i += CodedOutputStream.computeMessageSize(6, (MessageLite)this.supertype_.get(j));
      j += 1;
    }
    k = 0;
    j = 0;
    while (k < this.nestedClassName_.size())
    {
      j += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.nestedClassName_.get(k)).intValue());
      k += 1;
    }
    k = i + j;
    i = k;
    if (!getNestedClassNameList().isEmpty()) {
      i = k + 1 + CodedOutputStream.computeInt32SizeNoTag(j);
    }
    this.nestedClassNameMemoizedSerializedSize = j;
    j = 0;
    while (j < this.constructor_.size())
    {
      i += CodedOutputStream.computeMessageSize(8, (MessageLite)this.constructor_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.function_.size())
    {
      i += CodedOutputStream.computeMessageSize(9, (MessageLite)this.function_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.property_.size())
    {
      i += CodedOutputStream.computeMessageSize(10, (MessageLite)this.property_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.typeAlias_.size())
    {
      i += CodedOutputStream.computeMessageSize(11, (MessageLite)this.typeAlias_.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.enumEntry_.size())
    {
      i += CodedOutputStream.computeMessageSize(13, (MessageLite)this.enumEntry_.get(j));
      j += 1;
    }
    k = 0;
    j = 0;
    while (k < this.sealedSubclassFqName_.size())
    {
      j += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.sealedSubclassFqName_.get(k)).intValue());
      k += 1;
    }
    k = i + j;
    i = k;
    if (!getSealedSubclassFqNameList().isEmpty()) {
      i = k + 2 + CodedOutputStream.computeInt32SizeNoTag(j);
    }
    this.sealedSubclassFqNameMemoizedSerializedSize = j;
    j = i;
    if ((this.bitField0_ & 0x8) == 8) {
      j = i + CodedOutputStream.computeMessageSize(30, this.typeTable_);
    }
    k = 0;
    i = m;
    while (i < this.versionRequirement_.size())
    {
      k += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.versionRequirement_.get(i)).intValue());
      i += 1;
    }
    j = j + k + getVersionRequirementList().size() * 2;
    i = j;
    if ((this.bitField0_ & 0x10) == 16) {
      i = j + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
    }
    i = i + extensionsSerializedSize() + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ProtoBuf.Type getSupertype(int paramInt)
  {
    return (ProtoBuf.Type)this.supertype_.get(paramInt);
  }
  
  public int getSupertypeCount()
  {
    return this.supertype_.size();
  }
  
  public List<Integer> getSupertypeIdList()
  {
    return this.supertypeId_;
  }
  
  public List<ProtoBuf.Type> getSupertypeList()
  {
    return this.supertype_;
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
  
  public ProtoBuf.TypeParameter getTypeParameter(int paramInt)
  {
    return (ProtoBuf.TypeParameter)this.typeParameter_.get(paramInt);
  }
  
  public int getTypeParameterCount()
  {
    return this.typeParameter_.size();
  }
  
  public List<ProtoBuf.TypeParameter> getTypeParameterList()
  {
    return this.typeParameter_;
  }
  
  public ProtoBuf.TypeTable getTypeTable()
  {
    return this.typeTable_;
  }
  
  public List<Integer> getVersionRequirementList()
  {
    return this.versionRequirement_;
  }
  
  public ProtoBuf.VersionRequirementTable getVersionRequirementTable()
  {
    return this.versionRequirementTable_;
  }
  
  public boolean hasCompanionObjectName()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasFlags()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasFqName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasTypeTable()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasVersionRequirementTable()
  {
    return (this.bitField0_ & 0x10) == 16;
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
    if (!hasFqName())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    i = 0;
    while (i < getTypeParameterCount())
    {
      if (!getTypeParameter(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getSupertypeCount())
    {
      if (!getSupertype(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getConstructorCount())
    {
      if (!getConstructor(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
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
    i = 0;
    while (i < getEnumEntryCount())
    {
      if (!getEnumEntry(i).isInitialized())
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
  
  public ProtoBuf.Class.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Class.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    GeneratedMessageLite.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.flags_);
    }
    if (getSupertypeIdList().size() > 0)
    {
      paramCodedOutputStream.writeRawVarint32(18);
      paramCodedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
    }
    int j = 0;
    int i = 0;
    while (i < this.supertypeId_.size())
    {
      paramCodedOutputStream.writeInt32NoTag(((Integer)this.supertypeId_.get(i)).intValue());
      i += 1;
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(3, this.fqName_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeInt32(4, this.companionObjectName_);
    }
    i = 0;
    while (i < this.typeParameter_.size())
    {
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.typeParameter_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.supertype_.size())
    {
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.supertype_.get(i));
      i += 1;
    }
    if (getNestedClassNameList().size() > 0)
    {
      paramCodedOutputStream.writeRawVarint32(58);
      paramCodedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
    }
    i = 0;
    while (i < this.nestedClassName_.size())
    {
      paramCodedOutputStream.writeInt32NoTag(((Integer)this.nestedClassName_.get(i)).intValue());
      i += 1;
    }
    i = 0;
    while (i < this.constructor_.size())
    {
      paramCodedOutputStream.writeMessage(8, (MessageLite)this.constructor_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.function_.size())
    {
      paramCodedOutputStream.writeMessage(9, (MessageLite)this.function_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.property_.size())
    {
      paramCodedOutputStream.writeMessage(10, (MessageLite)this.property_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.typeAlias_.size())
    {
      paramCodedOutputStream.writeMessage(11, (MessageLite)this.typeAlias_.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.enumEntry_.size())
    {
      paramCodedOutputStream.writeMessage(13, (MessageLite)this.enumEntry_.get(i));
      i += 1;
    }
    if (getSealedSubclassFqNameList().size() > 0)
    {
      paramCodedOutputStream.writeRawVarint32(130);
      paramCodedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
    }
    i = 0;
    while (i < this.sealedSubclassFqName_.size())
    {
      paramCodedOutputStream.writeInt32NoTag(((Integer)this.sealedSubclassFqName_.get(i)).intValue());
      i += 1;
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8)
    {
      paramCodedOutputStream.writeMessage(30, this.typeTable_);
      i = j;
    }
    while (i < this.versionRequirement_.size())
    {
      paramCodedOutputStream.writeInt32(31, ((Integer)this.versionRequirement_.get(i)).intValue());
      i += 1;
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeMessage(32, this.versionRequirementTable_);
    }
    localExtensionWriter.writeUntil(19000, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class
 * JD-Core Version:    0.7.0.1
 */