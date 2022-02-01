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

public final class ProtoBuf$TypeAlias
  extends GeneratedMessageLite.ExtendableMessage<TypeAlias>
  implements ProtoBuf.TypeAliasOrBuilder
{
  public static Parser<TypeAlias> PARSER = new ProtoBuf.TypeAlias.1();
  private static final TypeAlias defaultInstance = new TypeAlias(true);
  private List<ProtoBuf.Annotation> annotation_;
  private int bitField0_;
  private int expandedTypeId_;
  private ProtoBuf.Type expandedType_;
  private int flags_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int name_;
  private List<ProtoBuf.TypeParameter> typeParameter_;
  private int underlyingTypeId_;
  private ProtoBuf.Type underlyingType_;
  private final ByteString unknownFields;
  private List<Integer> versionRequirement_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$TypeAlias(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 59	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 61	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 50	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:initFields	()V
    //   18: invokestatic 67	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 13
    //   23: aload 13
    //   25: iconst_1
    //   26: invokestatic 73	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 14
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +1093 -> 1131
    //   41: iload_3
    //   42: istore 4
    //   44: iload_3
    //   45: istore 5
    //   47: iload_3
    //   48: istore 6
    //   50: aload_1
    //   51: invokevirtual 79	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 7
    //   56: aconst_null
    //   57: astore 12
    //   59: aconst_null
    //   60: astore 11
    //   62: iload 7
    //   64: lookupswitch	default:+1171->1235, 0:+917->981, 8:+878->942, 16:+839->903, 26:+768->832, 34:+639->703, 40:+599->663, 50:+471->535, 56:+431->495, 66:+354->418, 248:+278->342, 250:+124->188
    //   165: istore 4
    //   167: iload_3
    //   168: istore 5
    //   170: iload_3
    //   171: istore 6
    //   173: aload_0
    //   174: aload_1
    //   175: aload 14
    //   177: aload_2
    //   178: iload 7
    //   180: invokevirtual 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   183: istore 10
    //   185: goto +802 -> 987
    //   188: iload_3
    //   189: istore 4
    //   191: iload_3
    //   192: istore 5
    //   194: iload_3
    //   195: istore 6
    //   197: aload_1
    //   198: aload_1
    //   199: invokevirtual 86	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   202: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   205: istore 9
    //   207: iload_3
    //   208: istore 7
    //   210: iload_3
    //   211: sipush 256
    //   214: iand
    //   215: sipush 256
    //   218: if_icmpeq +49 -> 267
    //   221: iload_3
    //   222: istore 7
    //   224: iload_3
    //   225: istore 4
    //   227: iload_3
    //   228: istore 5
    //   230: iload_3
    //   231: istore 6
    //   233: aload_1
    //   234: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   237: ifle +30 -> 267
    //   240: iload_3
    //   241: istore 4
    //   243: iload_3
    //   244: istore 5
    //   246: iload_3
    //   247: istore 6
    //   249: aload_0
    //   250: new 95	java/util/ArrayList
    //   253: dup
    //   254: invokespecial 96	java/util/ArrayList:<init>	()V
    //   257: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:versionRequirement_	Ljava/util/List;
    //   260: iload_3
    //   261: sipush 256
    //   264: ior
    //   265: istore 7
    //   267: iload 7
    //   269: istore 4
    //   271: iload 7
    //   273: istore 5
    //   275: iload 7
    //   277: istore 6
    //   279: aload_1
    //   280: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   283: ifle +35 -> 318
    //   286: iload 7
    //   288: istore 4
    //   290: iload 7
    //   292: istore 5
    //   294: iload 7
    //   296: istore 6
    //   298: aload_0
    //   299: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:versionRequirement_	Ljava/util/List;
    //   302: aload_1
    //   303: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   306: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: invokeinterface 113 2 0
    //   314: pop
    //   315: goto -48 -> 267
    //   318: iload 7
    //   320: istore 4
    //   322: iload 7
    //   324: istore 5
    //   326: iload 7
    //   328: istore 6
    //   330: aload_1
    //   331: iload 9
    //   333: invokevirtual 117	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   336: iload 7
    //   338: istore_3
    //   339: goto -303 -> 36
    //   342: iload_3
    //   343: istore 7
    //   345: iload_3
    //   346: sipush 256
    //   349: iand
    //   350: sipush 256
    //   353: if_icmpeq +30 -> 383
    //   356: iload_3
    //   357: istore 4
    //   359: iload_3
    //   360: istore 5
    //   362: iload_3
    //   363: istore 6
    //   365: aload_0
    //   366: new 95	java/util/ArrayList
    //   369: dup
    //   370: invokespecial 96	java/util/ArrayList:<init>	()V
    //   373: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:versionRequirement_	Ljava/util/List;
    //   376: iload_3
    //   377: sipush 256
    //   380: ior
    //   381: istore 7
    //   383: iload 7
    //   385: istore 4
    //   387: iload 7
    //   389: istore 5
    //   391: iload 7
    //   393: istore 6
    //   395: aload_0
    //   396: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:versionRequirement_	Ljava/util/List;
    //   399: aload_1
    //   400: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   403: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: invokeinterface 113 2 0
    //   411: pop
    //   412: iload 7
    //   414: istore_3
    //   415: goto -379 -> 36
    //   418: iload_3
    //   419: istore 7
    //   421: iload_3
    //   422: sipush 128
    //   425: iand
    //   426: sipush 128
    //   429: if_icmpeq +30 -> 459
    //   432: iload_3
    //   433: istore 4
    //   435: iload_3
    //   436: istore 5
    //   438: iload_3
    //   439: istore 6
    //   441: aload_0
    //   442: new 95	java/util/ArrayList
    //   445: dup
    //   446: invokespecial 96	java/util/ArrayList:<init>	()V
    //   449: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:annotation_	Ljava/util/List;
    //   452: iload_3
    //   453: sipush 128
    //   456: ior
    //   457: istore 7
    //   459: iload 7
    //   461: istore 4
    //   463: iload 7
    //   465: istore 5
    //   467: iload 7
    //   469: istore 6
    //   471: aload_0
    //   472: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:annotation_	Ljava/util/List;
    //   475: aload_1
    //   476: getstatic 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   479: aload_2
    //   480: invokevirtual 126	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   483: invokeinterface 113 2 0
    //   488: pop
    //   489: iload 7
    //   491: istore_3
    //   492: goto -456 -> 36
    //   495: iload_3
    //   496: istore 4
    //   498: iload_3
    //   499: istore 5
    //   501: iload_3
    //   502: istore 6
    //   504: aload_0
    //   505: aload_0
    //   506: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   509: bipush 32
    //   511: ior
    //   512: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   515: iload_3
    //   516: istore 4
    //   518: iload_3
    //   519: istore 5
    //   521: iload_3
    //   522: istore 6
    //   524: aload_0
    //   525: aload_1
    //   526: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   529: putfield 130	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:expandedTypeId_	I
    //   532: goto -496 -> 36
    //   535: iload_3
    //   536: istore 4
    //   538: iload_3
    //   539: istore 5
    //   541: iload_3
    //   542: istore 6
    //   544: aload_0
    //   545: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   548: bipush 16
    //   550: iand
    //   551: bipush 16
    //   553: if_icmpne +21 -> 574
    //   556: iload_3
    //   557: istore 4
    //   559: iload_3
    //   560: istore 5
    //   562: iload_3
    //   563: istore 6
    //   565: aload_0
    //   566: getfield 132	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:expandedType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   569: invokevirtual 138	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   572: astore 11
    //   574: iload_3
    //   575: istore 4
    //   577: iload_3
    //   578: istore 5
    //   580: iload_3
    //   581: istore 6
    //   583: aload_0
    //   584: aload_1
    //   585: getstatic 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   588: aload_2
    //   589: invokevirtual 126	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   592: checkcast 134	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   595: putfield 132	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:expandedType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   598: aload 11
    //   600: ifnull +40 -> 640
    //   603: iload_3
    //   604: istore 4
    //   606: iload_3
    //   607: istore 5
    //   609: iload_3
    //   610: istore 6
    //   612: aload 11
    //   614: aload_0
    //   615: getfield 132	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:expandedType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   618: invokevirtual 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   621: pop
    //   622: iload_3
    //   623: istore 4
    //   625: iload_3
    //   626: istore 5
    //   628: iload_3
    //   629: istore 6
    //   631: aload_0
    //   632: aload 11
    //   634: invokevirtual 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   637: putfield 132	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:expandedType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   640: iload_3
    //   641: istore 4
    //   643: iload_3
    //   644: istore 5
    //   646: iload_3
    //   647: istore 6
    //   649: aload_0
    //   650: aload_0
    //   651: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   654: bipush 16
    //   656: ior
    //   657: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   660: goto -624 -> 36
    //   663: iload_3
    //   664: istore 4
    //   666: iload_3
    //   667: istore 5
    //   669: iload_3
    //   670: istore 6
    //   672: aload_0
    //   673: aload_0
    //   674: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   677: bipush 8
    //   679: ior
    //   680: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   683: iload_3
    //   684: istore 4
    //   686: iload_3
    //   687: istore 5
    //   689: iload_3
    //   690: istore 6
    //   692: aload_0
    //   693: aload_1
    //   694: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   697: putfield 151	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:underlyingTypeId_	I
    //   700: goto -664 -> 36
    //   703: aload 12
    //   705: astore 11
    //   707: iload_3
    //   708: istore 4
    //   710: iload_3
    //   711: istore 5
    //   713: iload_3
    //   714: istore 6
    //   716: aload_0
    //   717: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   720: iconst_4
    //   721: iand
    //   722: iconst_4
    //   723: if_icmpne +21 -> 744
    //   726: iload_3
    //   727: istore 4
    //   729: iload_3
    //   730: istore 5
    //   732: iload_3
    //   733: istore 6
    //   735: aload_0
    //   736: getfield 153	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:underlyingType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   739: invokevirtual 138	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   742: astore 11
    //   744: iload_3
    //   745: istore 4
    //   747: iload_3
    //   748: istore 5
    //   750: iload_3
    //   751: istore 6
    //   753: aload_0
    //   754: aload_1
    //   755: getstatic 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   758: aload_2
    //   759: invokevirtual 126	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   762: checkcast 134	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   765: putfield 153	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:underlyingType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   768: aload 11
    //   770: ifnull +40 -> 810
    //   773: iload_3
    //   774: istore 4
    //   776: iload_3
    //   777: istore 5
    //   779: iload_3
    //   780: istore 6
    //   782: aload 11
    //   784: aload_0
    //   785: getfield 153	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:underlyingType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   788: invokevirtual 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   791: pop
    //   792: iload_3
    //   793: istore 4
    //   795: iload_3
    //   796: istore 5
    //   798: iload_3
    //   799: istore 6
    //   801: aload_0
    //   802: aload 11
    //   804: invokevirtual 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   807: putfield 153	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:underlyingType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   810: iload_3
    //   811: istore 4
    //   813: iload_3
    //   814: istore 5
    //   816: iload_3
    //   817: istore 6
    //   819: aload_0
    //   820: aload_0
    //   821: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   824: iconst_4
    //   825: ior
    //   826: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   829: goto -793 -> 36
    //   832: iload_3
    //   833: istore 7
    //   835: iload_3
    //   836: iconst_4
    //   837: iand
    //   838: iconst_4
    //   839: if_icmpeq +28 -> 867
    //   842: iload_3
    //   843: istore 4
    //   845: iload_3
    //   846: istore 5
    //   848: iload_3
    //   849: istore 6
    //   851: aload_0
    //   852: new 95	java/util/ArrayList
    //   855: dup
    //   856: invokespecial 96	java/util/ArrayList:<init>	()V
    //   859: putfield 155	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:typeParameter_	Ljava/util/List;
    //   862: iload_3
    //   863: iconst_4
    //   864: ior
    //   865: istore 7
    //   867: iload 7
    //   869: istore 4
    //   871: iload 7
    //   873: istore 5
    //   875: iload 7
    //   877: istore 6
    //   879: aload_0
    //   880: getfield 155	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:typeParameter_	Ljava/util/List;
    //   883: aload_1
    //   884: getstatic 158	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   887: aload_2
    //   888: invokevirtual 126	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   891: invokeinterface 113 2 0
    //   896: pop
    //   897: iload 7
    //   899: istore_3
    //   900: goto -864 -> 36
    //   903: iload_3
    //   904: istore 4
    //   906: iload_3
    //   907: istore 5
    //   909: iload_3
    //   910: istore 6
    //   912: aload_0
    //   913: aload_0
    //   914: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   917: iconst_2
    //   918: ior
    //   919: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   922: iload_3
    //   923: istore 4
    //   925: iload_3
    //   926: istore 5
    //   928: iload_3
    //   929: istore 6
    //   931: aload_0
    //   932: aload_1
    //   933: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   936: putfield 160	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:name_	I
    //   939: goto -903 -> 36
    //   942: iload_3
    //   943: istore 4
    //   945: iload_3
    //   946: istore 5
    //   948: iload_3
    //   949: istore 6
    //   951: aload_0
    //   952: aload_0
    //   953: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   956: iconst_1
    //   957: ior
    //   958: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:bitField0_	I
    //   961: iload_3
    //   962: istore 4
    //   964: iload_3
    //   965: istore 5
    //   967: iload_3
    //   968: istore 6
    //   970: aload_0
    //   971: aload_1
    //   972: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   975: putfield 162	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:flags_	I
    //   978: goto -942 -> 36
    //   981: iconst_1
    //   982: istore 8
    //   984: goto -948 -> 36
    //   987: iload 10
    //   989: ifne -953 -> 36
    //   992: goto -11 -> 981
    //   995: astore_1
    //   996: goto +35 -> 1031
    //   999: astore_1
    //   1000: iload 5
    //   1002: istore 4
    //   1004: new 54	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1007: dup
    //   1008: aload_1
    //   1009: invokevirtual 166	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1012: invokespecial 169	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   1015: aload_0
    //   1016: invokevirtual 173	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   1019: athrow
    //   1020: astore_1
    //   1021: iload 6
    //   1023: istore 4
    //   1025: aload_1
    //   1026: aload_0
    //   1027: invokevirtual 173	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   1030: athrow
    //   1031: iload 4
    //   1033: iconst_4
    //   1034: iand
    //   1035: iconst_4
    //   1036: if_icmpne +14 -> 1050
    //   1039: aload_0
    //   1040: aload_0
    //   1041: getfield 155	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:typeParameter_	Ljava/util/List;
    //   1044: invokestatic 179	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1047: putfield 155	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:typeParameter_	Ljava/util/List;
    //   1050: iload 4
    //   1052: sipush 128
    //   1055: iand
    //   1056: sipush 128
    //   1059: if_icmpne +14 -> 1073
    //   1062: aload_0
    //   1063: aload_0
    //   1064: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:annotation_	Ljava/util/List;
    //   1067: invokestatic 179	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1070: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:annotation_	Ljava/util/List;
    //   1073: iload 4
    //   1075: sipush 256
    //   1078: iand
    //   1079: sipush 256
    //   1082: if_icmpne +14 -> 1096
    //   1085: aload_0
    //   1086: aload_0
    //   1087: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:versionRequirement_	Ljava/util/List;
    //   1090: invokestatic 179	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1093: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:versionRequirement_	Ljava/util/List;
    //   1096: aload 14
    //   1098: invokevirtual 182	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1101: aload_0
    //   1102: aload 13
    //   1104: invokevirtual 188	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1107: putfield 190	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1110: goto +15 -> 1125
    //   1113: astore_1
    //   1114: aload_0
    //   1115: aload 13
    //   1117: invokevirtual 188	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1120: putfield 190	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1123: aload_1
    //   1124: athrow
    //   1125: aload_0
    //   1126: invokevirtual 193	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:makeExtensionsImmutable	()V
    //   1129: aload_1
    //   1130: athrow
    //   1131: iload_3
    //   1132: iconst_4
    //   1133: iand
    //   1134: iconst_4
    //   1135: if_icmpne +14 -> 1149
    //   1138: aload_0
    //   1139: aload_0
    //   1140: getfield 155	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:typeParameter_	Ljava/util/List;
    //   1143: invokestatic 179	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1146: putfield 155	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:typeParameter_	Ljava/util/List;
    //   1149: iload_3
    //   1150: sipush 128
    //   1153: iand
    //   1154: sipush 128
    //   1157: if_icmpne +14 -> 1171
    //   1160: aload_0
    //   1161: aload_0
    //   1162: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:annotation_	Ljava/util/List;
    //   1165: invokestatic 179	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1168: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:annotation_	Ljava/util/List;
    //   1171: iload_3
    //   1172: sipush 256
    //   1175: iand
    //   1176: sipush 256
    //   1179: if_icmpne +14 -> 1193
    //   1182: aload_0
    //   1183: aload_0
    //   1184: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:versionRequirement_	Ljava/util/List;
    //   1187: invokestatic 179	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1190: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:versionRequirement_	Ljava/util/List;
    //   1193: aload 14
    //   1195: invokevirtual 182	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1198: aload_0
    //   1199: aload 13
    //   1201: invokevirtual 188	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1204: putfield 190	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1207: goto +15 -> 1222
    //   1210: astore_1
    //   1211: aload_0
    //   1212: aload 13
    //   1214: invokevirtual 188	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1217: putfield 190	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1220: aload_1
    //   1221: athrow
    //   1222: aload_0
    //   1223: invokevirtual 193	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:makeExtensionsImmutable	()V
    //   1226: return
    //   1227: astore_2
    //   1228: goto -127 -> 1101
    //   1231: astore_1
    //   1232: goto -34 -> 1198
    //   1235: goto -1071 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1238	0	this	TypeAlias
    //   0	1238	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	1238	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   35	1141	3	i	int
    //   42	1037	4	j	int
    //   45	956	5	k	int
    //   48	974	6	m	int
    //   54	844	7	n	int
    //   32	951	8	i1	int
    //   205	127	9	i2	int
    //   183	805	10	bool	boolean
    //   60	743	11	localObject1	java.lang.Object
    //   57	647	12	localObject2	java.lang.Object
    //   21	1192	13	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	1165	14	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	995	finally
    //   173	185	995	finally
    //   197	207	995	finally
    //   233	240	995	finally
    //   249	260	995	finally
    //   279	286	995	finally
    //   298	315	995	finally
    //   330	336	995	finally
    //   365	376	995	finally
    //   395	412	995	finally
    //   441	452	995	finally
    //   471	489	995	finally
    //   504	515	995	finally
    //   524	532	995	finally
    //   544	556	995	finally
    //   565	574	995	finally
    //   583	598	995	finally
    //   612	622	995	finally
    //   631	640	995	finally
    //   649	660	995	finally
    //   672	683	995	finally
    //   692	700	995	finally
    //   716	726	995	finally
    //   735	744	995	finally
    //   753	768	995	finally
    //   782	792	995	finally
    //   801	810	995	finally
    //   819	829	995	finally
    //   851	862	995	finally
    //   879	897	995	finally
    //   912	922	995	finally
    //   931	939	995	finally
    //   951	961	995	finally
    //   970	978	995	finally
    //   1004	1020	995	finally
    //   1025	1031	995	finally
    //   50	56	999	java/io/IOException
    //   173	185	999	java/io/IOException
    //   197	207	999	java/io/IOException
    //   233	240	999	java/io/IOException
    //   249	260	999	java/io/IOException
    //   279	286	999	java/io/IOException
    //   298	315	999	java/io/IOException
    //   330	336	999	java/io/IOException
    //   365	376	999	java/io/IOException
    //   395	412	999	java/io/IOException
    //   441	452	999	java/io/IOException
    //   471	489	999	java/io/IOException
    //   504	515	999	java/io/IOException
    //   524	532	999	java/io/IOException
    //   544	556	999	java/io/IOException
    //   565	574	999	java/io/IOException
    //   583	598	999	java/io/IOException
    //   612	622	999	java/io/IOException
    //   631	640	999	java/io/IOException
    //   649	660	999	java/io/IOException
    //   672	683	999	java/io/IOException
    //   692	700	999	java/io/IOException
    //   716	726	999	java/io/IOException
    //   735	744	999	java/io/IOException
    //   753	768	999	java/io/IOException
    //   782	792	999	java/io/IOException
    //   801	810	999	java/io/IOException
    //   819	829	999	java/io/IOException
    //   851	862	999	java/io/IOException
    //   879	897	999	java/io/IOException
    //   912	922	999	java/io/IOException
    //   931	939	999	java/io/IOException
    //   951	961	999	java/io/IOException
    //   970	978	999	java/io/IOException
    //   50	56	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   173	185	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   197	207	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   233	240	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   249	260	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   279	286	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   298	315	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   330	336	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   365	376	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   395	412	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   441	452	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   471	489	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   504	515	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   524	532	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   544	556	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   565	574	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   583	598	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   612	622	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   631	640	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   649	660	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   672	683	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   692	700	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   716	726	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   735	744	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   753	768	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   782	792	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   801	810	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   819	829	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   851	862	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   879	897	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   912	922	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   931	939	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   951	961	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   970	978	1020	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1096	1101	1113	finally
    //   1193	1198	1210	finally
    //   1096	1101	1227	java/io/IOException
    //   1193	1198	1231	java/io/IOException
  }
  
  private ProtoBuf$TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$TypeAlias(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static TypeAlias getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.flags_ = 6;
    this.name_ = 0;
    this.typeParameter_ = Collections.emptyList();
    this.underlyingType_ = ProtoBuf.Type.getDefaultInstance();
    this.underlyingTypeId_ = 0;
    this.expandedType_ = ProtoBuf.Type.getDefaultInstance();
    this.expandedTypeId_ = 0;
    this.annotation_ = Collections.emptyList();
    this.versionRequirement_ = Collections.emptyList();
  }
  
  public static ProtoBuf.TypeAlias.Builder newBuilder()
  {
    return ProtoBuf.TypeAlias.Builder.access$17800();
  }
  
  public static ProtoBuf.TypeAlias.Builder newBuilder(TypeAlias paramTypeAlias)
  {
    return newBuilder().mergeFrom(paramTypeAlias);
  }
  
  public static TypeAlias parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (TypeAlias)PARSER.parseDelimitedFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public ProtoBuf.Annotation getAnnotation(int paramInt)
  {
    return (ProtoBuf.Annotation)this.annotation_.get(paramInt);
  }
  
  public int getAnnotationCount()
  {
    return this.annotation_.size();
  }
  
  public List<ProtoBuf.Annotation> getAnnotationList()
  {
    return this.annotation_;
  }
  
  public TypeAlias getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public ProtoBuf.Type getExpandedType()
  {
    return this.expandedType_;
  }
  
  public int getExpandedTypeId()
  {
    return this.expandedTypeId_;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public int getName()
  {
    return this.name_;
  }
  
  public Parser<TypeAlias> getParserForType()
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
    int k = 0;
    if ((i & 0x1) == 1) {
      i = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
    } else {
      i = 0;
    }
    int j = i;
    if ((this.bitField0_ & 0x2) == 2) {
      j = i + CodedOutputStream.computeInt32Size(2, this.name_);
    }
    i = j;
    j = 0;
    while (j < this.typeParameter_.size())
    {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.typeParameter_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeMessageSize(4, this.underlyingType_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeMessageSize(6, this.expandedType_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
    }
    j = 0;
    while (j < this.annotation_.size())
    {
      i += CodedOutputStream.computeMessageSize(8, (MessageLite)this.annotation_.get(j));
      j += 1;
    }
    int m = 0;
    j = k;
    k = m;
    while (j < this.versionRequirement_.size())
    {
      k += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.versionRequirement_.get(j)).intValue());
      j += 1;
    }
    i = i + k + getVersionRequirementList().size() * 2 + extensionsSerializedSize() + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
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
  
  public ProtoBuf.Type getUnderlyingType()
  {
    return this.underlyingType_;
  }
  
  public int getUnderlyingTypeId()
  {
    return this.underlyingTypeId_;
  }
  
  public List<Integer> getVersionRequirementList()
  {
    return this.versionRequirement_;
  }
  
  public boolean hasExpandedType()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasExpandedTypeId()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasFlags()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasUnderlyingType()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasUnderlyingTypeId()
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
    if (!hasName())
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
    if ((hasUnderlyingType()) && (!getUnderlyingType().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if ((hasExpandedType()) && (!getExpandedType().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    i = 0;
    while (i < getAnnotationCount())
    {
      if (!getAnnotation(i).isInitialized())
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
  
  public ProtoBuf.TypeAlias.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.TypeAlias.Builder toBuilder()
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
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(2, this.name_);
    }
    int k = 0;
    int i = 0;
    while (i < this.typeParameter_.size())
    {
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.typeParameter_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeMessage(4, this.underlyingType_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeInt32(5, this.underlyingTypeId_);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeMessage(6, this.expandedType_);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeInt32(7, this.expandedTypeId_);
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.annotation_.size()) {
        break;
      }
      paramCodedOutputStream.writeMessage(8, (MessageLite)this.annotation_.get(i));
      i += 1;
    }
    while (j < this.versionRequirement_.size())
    {
      paramCodedOutputStream.writeInt32(31, ((Integer)this.versionRequirement_.get(j)).intValue());
      j += 1;
    }
    localExtensionWriter.writeUntil(200, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias
 * JD-Core Version:    0.7.0.1
 */