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

public final class ProtoBuf$Property
  extends GeneratedMessageLite.ExtendableMessage<Property>
  implements ProtoBuf.PropertyOrBuilder
{
  public static Parser<Property> PARSER = new ProtoBuf.Property.1();
  private static final Property defaultInstance = new Property(true);
  private int bitField0_;
  private int flags_;
  private int getterFlags_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int name_;
  private int oldFlags_;
  private int receiverTypeId_;
  private ProtoBuf.Type receiverType_;
  private int returnTypeId_;
  private ProtoBuf.Type returnType_;
  private int setterFlags_;
  private ProtoBuf.ValueParameter setterValueParameter_;
  private List<ProtoBuf.TypeParameter> typeParameter_;
  private final ByteString unknownFields;
  private List<Integer> versionRequirement_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Property(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 60	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 62	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 64	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 53	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:initFields	()V
    //   18: invokestatic 70	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 14
    //   23: aload 14
    //   25: iconst_1
    //   26: invokestatic 76	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 15
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +1281 -> 1319
    //   41: iload_3
    //   42: istore 4
    //   44: iload_3
    //   45: istore 5
    //   47: iload_3
    //   48: istore 6
    //   50: aload_1
    //   51: invokevirtual 82	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 7
    //   56: aconst_null
    //   57: astore 12
    //   59: aconst_null
    //   60: astore 13
    //   62: aconst_null
    //   63: astore 11
    //   65: iload 7
    //   67: lookupswitch	default:+1336->1403, 0:+1123->1190, 8:+1084->1151, 16:+1045->1112, 26:+913->980, 34:+839->906, 42:+707->774, 50:+576->643, 56:+535->602, 64:+494->561, 72:+454->521, 80:+414->481, 88:+375->442, 248:+299->366, 250:+145->212
    //   189: istore 4
    //   191: iload_3
    //   192: istore 5
    //   194: iload_3
    //   195: istore 6
    //   197: aload_0
    //   198: aload_1
    //   199: aload 15
    //   201: aload_2
    //   202: iload 7
    //   204: invokevirtual 86	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   207: istore 10
    //   209: goto +987 -> 1196
    //   212: iload_3
    //   213: istore 4
    //   215: iload_3
    //   216: istore 5
    //   218: iload_3
    //   219: istore 6
    //   221: aload_1
    //   222: aload_1
    //   223: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   226: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   229: istore 9
    //   231: iload_3
    //   232: istore 7
    //   234: iload_3
    //   235: sipush 2048
    //   238: iand
    //   239: sipush 2048
    //   242: if_icmpeq +49 -> 291
    //   245: iload_3
    //   246: istore 7
    //   248: iload_3
    //   249: istore 4
    //   251: iload_3
    //   252: istore 5
    //   254: iload_3
    //   255: istore 6
    //   257: aload_1
    //   258: invokevirtual 96	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   261: ifle +30 -> 291
    //   264: iload_3
    //   265: istore 4
    //   267: iload_3
    //   268: istore 5
    //   270: iload_3
    //   271: istore 6
    //   273: aload_0
    //   274: new 98	java/util/ArrayList
    //   277: dup
    //   278: invokespecial 99	java/util/ArrayList:<init>	()V
    //   281: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:versionRequirement_	Ljava/util/List;
    //   284: iload_3
    //   285: sipush 2048
    //   288: ior
    //   289: istore 7
    //   291: iload 7
    //   293: istore 4
    //   295: iload 7
    //   297: istore 5
    //   299: iload 7
    //   301: istore 6
    //   303: aload_1
    //   304: invokevirtual 96	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   307: ifle +35 -> 342
    //   310: iload 7
    //   312: istore 4
    //   314: iload 7
    //   316: istore 5
    //   318: iload 7
    //   320: istore 6
    //   322: aload_0
    //   323: getfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:versionRequirement_	Ljava/util/List;
    //   326: aload_1
    //   327: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   330: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: invokeinterface 116 2 0
    //   338: pop
    //   339: goto -48 -> 291
    //   342: iload 7
    //   344: istore 4
    //   346: iload 7
    //   348: istore 5
    //   350: iload 7
    //   352: istore 6
    //   354: aload_1
    //   355: iload 9
    //   357: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   360: iload 7
    //   362: istore_3
    //   363: goto -327 -> 36
    //   366: iload_3
    //   367: istore 7
    //   369: iload_3
    //   370: sipush 2048
    //   373: iand
    //   374: sipush 2048
    //   377: if_icmpeq +30 -> 407
    //   380: iload_3
    //   381: istore 4
    //   383: iload_3
    //   384: istore 5
    //   386: iload_3
    //   387: istore 6
    //   389: aload_0
    //   390: new 98	java/util/ArrayList
    //   393: dup
    //   394: invokespecial 99	java/util/ArrayList:<init>	()V
    //   397: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:versionRequirement_	Ljava/util/List;
    //   400: iload_3
    //   401: sipush 2048
    //   404: ior
    //   405: istore 7
    //   407: iload 7
    //   409: istore 4
    //   411: iload 7
    //   413: istore 5
    //   415: iload 7
    //   417: istore 6
    //   419: aload_0
    //   420: getfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:versionRequirement_	Ljava/util/List;
    //   423: aload_1
    //   424: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   427: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: invokeinterface 116 2 0
    //   435: pop
    //   436: iload 7
    //   438: istore_3
    //   439: goto -403 -> 36
    //   442: iload_3
    //   443: istore 4
    //   445: iload_3
    //   446: istore 5
    //   448: iload_3
    //   449: istore 6
    //   451: aload_0
    //   452: aload_0
    //   453: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   456: iconst_1
    //   457: ior
    //   458: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   461: iload_3
    //   462: istore 4
    //   464: iload_3
    //   465: istore 5
    //   467: iload_3
    //   468: istore 6
    //   470: aload_0
    //   471: aload_1
    //   472: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   475: putfield 124	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:flags_	I
    //   478: goto -442 -> 36
    //   481: iload_3
    //   482: istore 4
    //   484: iload_3
    //   485: istore 5
    //   487: iload_3
    //   488: istore 6
    //   490: aload_0
    //   491: aload_0
    //   492: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   495: bipush 64
    //   497: ior
    //   498: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   501: iload_3
    //   502: istore 4
    //   504: iload_3
    //   505: istore 5
    //   507: iload_3
    //   508: istore 6
    //   510: aload_0
    //   511: aload_1
    //   512: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   515: putfield 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:receiverTypeId_	I
    //   518: goto -482 -> 36
    //   521: iload_3
    //   522: istore 4
    //   524: iload_3
    //   525: istore 5
    //   527: iload_3
    //   528: istore 6
    //   530: aload_0
    //   531: aload_0
    //   532: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   535: bipush 16
    //   537: ior
    //   538: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   541: iload_3
    //   542: istore 4
    //   544: iload_3
    //   545: istore 5
    //   547: iload_3
    //   548: istore 6
    //   550: aload_0
    //   551: aload_1
    //   552: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   555: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:returnTypeId_	I
    //   558: goto -522 -> 36
    //   561: iload_3
    //   562: istore 4
    //   564: iload_3
    //   565: istore 5
    //   567: iload_3
    //   568: istore 6
    //   570: aload_0
    //   571: aload_0
    //   572: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   575: sipush 512
    //   578: ior
    //   579: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   582: iload_3
    //   583: istore 4
    //   585: iload_3
    //   586: istore 5
    //   588: iload_3
    //   589: istore 6
    //   591: aload_0
    //   592: aload_1
    //   593: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   596: putfield 130	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:setterFlags_	I
    //   599: goto -563 -> 36
    //   602: iload_3
    //   603: istore 4
    //   605: iload_3
    //   606: istore 5
    //   608: iload_3
    //   609: istore 6
    //   611: aload_0
    //   612: aload_0
    //   613: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   616: sipush 256
    //   619: ior
    //   620: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   623: iload_3
    //   624: istore 4
    //   626: iload_3
    //   627: istore 5
    //   629: iload_3
    //   630: istore 6
    //   632: aload_0
    //   633: aload_1
    //   634: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   637: putfield 132	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:getterFlags_	I
    //   640: goto -604 -> 36
    //   643: iload_3
    //   644: istore 4
    //   646: iload_3
    //   647: istore 5
    //   649: iload_3
    //   650: istore 6
    //   652: aload_0
    //   653: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   656: sipush 128
    //   659: iand
    //   660: sipush 128
    //   663: if_icmpne +21 -> 684
    //   666: iload_3
    //   667: istore 4
    //   669: iload_3
    //   670: istore 5
    //   672: iload_3
    //   673: istore 6
    //   675: aload_0
    //   676: getfield 134	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:setterValueParameter_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter;
    //   679: invokevirtual 140	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter$Builder;
    //   682: astore 11
    //   684: iload_3
    //   685: istore 4
    //   687: iload_3
    //   688: istore 5
    //   690: iload_3
    //   691: istore 6
    //   693: aload_0
    //   694: aload_1
    //   695: getstatic 141	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   698: aload_2
    //   699: invokevirtual 145	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   702: checkcast 136	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter
    //   705: putfield 134	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:setterValueParameter_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter;
    //   708: aload 11
    //   710: ifnull +40 -> 750
    //   713: iload_3
    //   714: istore 4
    //   716: iload_3
    //   717: istore 5
    //   719: iload_3
    //   720: istore 6
    //   722: aload 11
    //   724: aload_0
    //   725: getfield 134	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:setterValueParameter_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter;
    //   728: invokevirtual 151	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter$Builder;
    //   731: pop
    //   732: iload_3
    //   733: istore 4
    //   735: iload_3
    //   736: istore 5
    //   738: iload_3
    //   739: istore 6
    //   741: aload_0
    //   742: aload 11
    //   744: invokevirtual 155	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter;
    //   747: putfield 134	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:setterValueParameter_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter;
    //   750: iload_3
    //   751: istore 4
    //   753: iload_3
    //   754: istore 5
    //   756: iload_3
    //   757: istore 6
    //   759: aload_0
    //   760: aload_0
    //   761: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   764: sipush 128
    //   767: ior
    //   768: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   771: goto -735 -> 36
    //   774: aload 12
    //   776: astore 11
    //   778: iload_3
    //   779: istore 4
    //   781: iload_3
    //   782: istore 5
    //   784: iload_3
    //   785: istore 6
    //   787: aload_0
    //   788: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   791: bipush 32
    //   793: iand
    //   794: bipush 32
    //   796: if_icmpne +21 -> 817
    //   799: iload_3
    //   800: istore 4
    //   802: iload_3
    //   803: istore 5
    //   805: iload_3
    //   806: istore 6
    //   808: aload_0
    //   809: getfield 157	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:receiverType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   812: invokevirtual 162	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   815: astore 11
    //   817: iload_3
    //   818: istore 4
    //   820: iload_3
    //   821: istore 5
    //   823: iload_3
    //   824: istore 6
    //   826: aload_0
    //   827: aload_1
    //   828: getstatic 163	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   831: aload_2
    //   832: invokevirtual 145	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   835: checkcast 159	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   838: putfield 157	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:receiverType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   841: aload 11
    //   843: ifnull +40 -> 883
    //   846: iload_3
    //   847: istore 4
    //   849: iload_3
    //   850: istore 5
    //   852: iload_3
    //   853: istore 6
    //   855: aload 11
    //   857: aload_0
    //   858: getfield 157	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:receiverType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   861: invokevirtual 168	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   864: pop
    //   865: iload_3
    //   866: istore 4
    //   868: iload_3
    //   869: istore 5
    //   871: iload_3
    //   872: istore 6
    //   874: aload_0
    //   875: aload 11
    //   877: invokevirtual 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   880: putfield 157	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:receiverType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   883: iload_3
    //   884: istore 4
    //   886: iload_3
    //   887: istore 5
    //   889: iload_3
    //   890: istore 6
    //   892: aload_0
    //   893: aload_0
    //   894: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   897: bipush 32
    //   899: ior
    //   900: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   903: goto -867 -> 36
    //   906: iload_3
    //   907: istore 7
    //   909: iload_3
    //   910: bipush 32
    //   912: iand
    //   913: bipush 32
    //   915: if_icmpeq +29 -> 944
    //   918: iload_3
    //   919: istore 4
    //   921: iload_3
    //   922: istore 5
    //   924: iload_3
    //   925: istore 6
    //   927: aload_0
    //   928: new 98	java/util/ArrayList
    //   931: dup
    //   932: invokespecial 99	java/util/ArrayList:<init>	()V
    //   935: putfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:typeParameter_	Ljava/util/List;
    //   938: iload_3
    //   939: bipush 32
    //   941: ior
    //   942: istore 7
    //   944: iload 7
    //   946: istore 4
    //   948: iload 7
    //   950: istore 5
    //   952: iload 7
    //   954: istore 6
    //   956: aload_0
    //   957: getfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:typeParameter_	Ljava/util/List;
    //   960: aload_1
    //   961: getstatic 176	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   964: aload_2
    //   965: invokevirtual 145	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   968: invokeinterface 116 2 0
    //   973: pop
    //   974: iload 7
    //   976: istore_3
    //   977: goto -941 -> 36
    //   980: aload 13
    //   982: astore 11
    //   984: iload_3
    //   985: istore 4
    //   987: iload_3
    //   988: istore 5
    //   990: iload_3
    //   991: istore 6
    //   993: aload_0
    //   994: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   997: bipush 8
    //   999: iand
    //   1000: bipush 8
    //   1002: if_icmpne +21 -> 1023
    //   1005: iload_3
    //   1006: istore 4
    //   1008: iload_3
    //   1009: istore 5
    //   1011: iload_3
    //   1012: istore 6
    //   1014: aload_0
    //   1015: getfield 178	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:returnType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1018: invokevirtual 162	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   1021: astore 11
    //   1023: iload_3
    //   1024: istore 4
    //   1026: iload_3
    //   1027: istore 5
    //   1029: iload_3
    //   1030: istore 6
    //   1032: aload_0
    //   1033: aload_1
    //   1034: getstatic 163	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1037: aload_2
    //   1038: invokevirtual 145	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1041: checkcast 159	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   1044: putfield 178	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:returnType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1047: aload 11
    //   1049: ifnull +40 -> 1089
    //   1052: iload_3
    //   1053: istore 4
    //   1055: iload_3
    //   1056: istore 5
    //   1058: iload_3
    //   1059: istore 6
    //   1061: aload 11
    //   1063: aload_0
    //   1064: getfield 178	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:returnType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1067: invokevirtual 168	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   1070: pop
    //   1071: iload_3
    //   1072: istore 4
    //   1074: iload_3
    //   1075: istore 5
    //   1077: iload_3
    //   1078: istore 6
    //   1080: aload_0
    //   1081: aload 11
    //   1083: invokevirtual 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1086: putfield 178	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:returnType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1089: iload_3
    //   1090: istore 4
    //   1092: iload_3
    //   1093: istore 5
    //   1095: iload_3
    //   1096: istore 6
    //   1098: aload_0
    //   1099: aload_0
    //   1100: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   1103: bipush 8
    //   1105: ior
    //   1106: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   1109: goto -1073 -> 36
    //   1112: iload_3
    //   1113: istore 4
    //   1115: iload_3
    //   1116: istore 5
    //   1118: iload_3
    //   1119: istore 6
    //   1121: aload_0
    //   1122: aload_0
    //   1123: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   1126: iconst_4
    //   1127: ior
    //   1128: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   1131: iload_3
    //   1132: istore 4
    //   1134: iload_3
    //   1135: istore 5
    //   1137: iload_3
    //   1138: istore 6
    //   1140: aload_0
    //   1141: aload_1
    //   1142: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1145: putfield 180	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:name_	I
    //   1148: goto -1112 -> 36
    //   1151: iload_3
    //   1152: istore 4
    //   1154: iload_3
    //   1155: istore 5
    //   1157: iload_3
    //   1158: istore 6
    //   1160: aload_0
    //   1161: aload_0
    //   1162: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   1165: iconst_2
    //   1166: ior
    //   1167: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:bitField0_	I
    //   1170: iload_3
    //   1171: istore 4
    //   1173: iload_3
    //   1174: istore 5
    //   1176: iload_3
    //   1177: istore 6
    //   1179: aload_0
    //   1180: aload_1
    //   1181: invokevirtual 104	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1184: putfield 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:oldFlags_	I
    //   1187: goto -1151 -> 36
    //   1190: iconst_1
    //   1191: istore 8
    //   1193: goto -1157 -> 36
    //   1196: iload 10
    //   1198: ifne -1162 -> 36
    //   1201: goto -11 -> 1190
    //   1204: astore_1
    //   1205: goto +35 -> 1240
    //   1208: astore_1
    //   1209: iload 5
    //   1211: istore 4
    //   1213: new 57	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1216: dup
    //   1217: aload_1
    //   1218: invokevirtual 186	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1221: invokespecial 189	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   1224: aload_0
    //   1225: invokevirtual 193	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   1228: athrow
    //   1229: astore_1
    //   1230: iload 6
    //   1232: istore 4
    //   1234: aload_1
    //   1235: aload_0
    //   1236: invokevirtual 193	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   1239: athrow
    //   1240: iload 4
    //   1242: bipush 32
    //   1244: iand
    //   1245: bipush 32
    //   1247: if_icmpne +14 -> 1261
    //   1250: aload_0
    //   1251: aload_0
    //   1252: getfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:typeParameter_	Ljava/util/List;
    //   1255: invokestatic 199	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1258: putfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:typeParameter_	Ljava/util/List;
    //   1261: iload 4
    //   1263: sipush 2048
    //   1266: iand
    //   1267: sipush 2048
    //   1270: if_icmpne +14 -> 1284
    //   1273: aload_0
    //   1274: aload_0
    //   1275: getfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:versionRequirement_	Ljava/util/List;
    //   1278: invokestatic 199	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1281: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:versionRequirement_	Ljava/util/List;
    //   1284: aload 15
    //   1286: invokevirtual 202	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1289: aload_0
    //   1290: aload 14
    //   1292: invokevirtual 208	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1295: putfield 210	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1298: goto +15 -> 1313
    //   1301: astore_1
    //   1302: aload_0
    //   1303: aload 14
    //   1305: invokevirtual 208	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1308: putfield 210	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1311: aload_1
    //   1312: athrow
    //   1313: aload_0
    //   1314: invokevirtual 213	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:makeExtensionsImmutable	()V
    //   1317: aload_1
    //   1318: athrow
    //   1319: iload_3
    //   1320: bipush 32
    //   1322: iand
    //   1323: bipush 32
    //   1325: if_icmpne +14 -> 1339
    //   1328: aload_0
    //   1329: aload_0
    //   1330: getfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:typeParameter_	Ljava/util/List;
    //   1333: invokestatic 199	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1336: putfield 173	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:typeParameter_	Ljava/util/List;
    //   1339: iload_3
    //   1340: sipush 2048
    //   1343: iand
    //   1344: sipush 2048
    //   1347: if_icmpne +14 -> 1361
    //   1350: aload_0
    //   1351: aload_0
    //   1352: getfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:versionRequirement_	Ljava/util/List;
    //   1355: invokestatic 199	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1358: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:versionRequirement_	Ljava/util/List;
    //   1361: aload 15
    //   1363: invokevirtual 202	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1366: aload_0
    //   1367: aload 14
    //   1369: invokevirtual 208	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1372: putfield 210	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1375: goto +15 -> 1390
    //   1378: astore_1
    //   1379: aload_0
    //   1380: aload 14
    //   1382: invokevirtual 208	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1385: putfield 210	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1388: aload_1
    //   1389: athrow
    //   1390: aload_0
    //   1391: invokevirtual 213	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:makeExtensionsImmutable	()V
    //   1394: return
    //   1395: astore_2
    //   1396: goto -107 -> 1289
    //   1399: astore_1
    //   1400: goto -34 -> 1366
    //   1403: goto -1215 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1406	0	this	Property
    //   0	1406	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	1406	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	1309	3	i	int
    //   42	1225	4	j	int
    //   45	1165	5	k	int
    //   48	1183	6	m	int
    //   54	921	7	n	int
    //   32	1160	8	i1	int
    //   229	127	9	i2	int
    //   207	990	10	bool	boolean
    //   63	1019	11	localObject1	java.lang.Object
    //   57	718	12	localObject2	java.lang.Object
    //   60	921	13	localObject3	java.lang.Object
    //   21	1360	14	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	1333	15	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	1204	finally
    //   197	209	1204	finally
    //   221	231	1204	finally
    //   257	264	1204	finally
    //   273	284	1204	finally
    //   303	310	1204	finally
    //   322	339	1204	finally
    //   354	360	1204	finally
    //   389	400	1204	finally
    //   419	436	1204	finally
    //   451	461	1204	finally
    //   470	478	1204	finally
    //   490	501	1204	finally
    //   510	518	1204	finally
    //   530	541	1204	finally
    //   550	558	1204	finally
    //   570	582	1204	finally
    //   591	599	1204	finally
    //   611	623	1204	finally
    //   632	640	1204	finally
    //   652	666	1204	finally
    //   675	684	1204	finally
    //   693	708	1204	finally
    //   722	732	1204	finally
    //   741	750	1204	finally
    //   759	771	1204	finally
    //   787	799	1204	finally
    //   808	817	1204	finally
    //   826	841	1204	finally
    //   855	865	1204	finally
    //   874	883	1204	finally
    //   892	903	1204	finally
    //   927	938	1204	finally
    //   956	974	1204	finally
    //   993	1005	1204	finally
    //   1014	1023	1204	finally
    //   1032	1047	1204	finally
    //   1061	1071	1204	finally
    //   1080	1089	1204	finally
    //   1098	1109	1204	finally
    //   1121	1131	1204	finally
    //   1140	1148	1204	finally
    //   1160	1170	1204	finally
    //   1179	1187	1204	finally
    //   1213	1229	1204	finally
    //   1234	1240	1204	finally
    //   50	56	1208	java/io/IOException
    //   197	209	1208	java/io/IOException
    //   221	231	1208	java/io/IOException
    //   257	264	1208	java/io/IOException
    //   273	284	1208	java/io/IOException
    //   303	310	1208	java/io/IOException
    //   322	339	1208	java/io/IOException
    //   354	360	1208	java/io/IOException
    //   389	400	1208	java/io/IOException
    //   419	436	1208	java/io/IOException
    //   451	461	1208	java/io/IOException
    //   470	478	1208	java/io/IOException
    //   490	501	1208	java/io/IOException
    //   510	518	1208	java/io/IOException
    //   530	541	1208	java/io/IOException
    //   550	558	1208	java/io/IOException
    //   570	582	1208	java/io/IOException
    //   591	599	1208	java/io/IOException
    //   611	623	1208	java/io/IOException
    //   632	640	1208	java/io/IOException
    //   652	666	1208	java/io/IOException
    //   675	684	1208	java/io/IOException
    //   693	708	1208	java/io/IOException
    //   722	732	1208	java/io/IOException
    //   741	750	1208	java/io/IOException
    //   759	771	1208	java/io/IOException
    //   787	799	1208	java/io/IOException
    //   808	817	1208	java/io/IOException
    //   826	841	1208	java/io/IOException
    //   855	865	1208	java/io/IOException
    //   874	883	1208	java/io/IOException
    //   892	903	1208	java/io/IOException
    //   927	938	1208	java/io/IOException
    //   956	974	1208	java/io/IOException
    //   993	1005	1208	java/io/IOException
    //   1014	1023	1208	java/io/IOException
    //   1032	1047	1208	java/io/IOException
    //   1061	1071	1208	java/io/IOException
    //   1080	1089	1208	java/io/IOException
    //   1098	1109	1208	java/io/IOException
    //   1121	1131	1208	java/io/IOException
    //   1140	1148	1208	java/io/IOException
    //   1160	1170	1208	java/io/IOException
    //   1179	1187	1208	java/io/IOException
    //   50	56	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   197	209	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   221	231	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   257	264	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   273	284	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   303	310	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   322	339	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   354	360	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   389	400	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   419	436	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   451	461	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   470	478	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   490	501	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   510	518	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   530	541	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   550	558	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   570	582	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   591	599	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   611	623	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   632	640	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   652	666	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   675	684	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   693	708	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   722	732	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   741	750	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   759	771	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   787	799	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   808	817	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   826	841	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   855	865	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   874	883	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   892	903	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   927	938	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   956	974	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   993	1005	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1014	1023	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1032	1047	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1061	1071	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1080	1089	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1098	1109	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1121	1131	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1140	1148	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1160	1170	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1179	1187	1229	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1284	1289	1301	finally
    //   1361	1366	1378	finally
    //   1284	1289	1395	java/io/IOException
    //   1361	1366	1399	java/io/IOException
  }
  
  private ProtoBuf$Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Property(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Property getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.flags_ = 518;
    this.oldFlags_ = 2054;
    this.name_ = 0;
    this.returnType_ = ProtoBuf.Type.getDefaultInstance();
    this.returnTypeId_ = 0;
    this.typeParameter_ = Collections.emptyList();
    this.receiverType_ = ProtoBuf.Type.getDefaultInstance();
    this.receiverTypeId_ = 0;
    this.setterValueParameter_ = ProtoBuf.ValueParameter.getDefaultInstance();
    this.getterFlags_ = 0;
    this.setterFlags_ = 0;
    this.versionRequirement_ = Collections.emptyList();
  }
  
  public static ProtoBuf.Property.Builder newBuilder()
  {
    return ProtoBuf.Property.Builder.access$15000();
  }
  
  public static ProtoBuf.Property.Builder newBuilder(Property paramProperty)
  {
    return newBuilder().mergeFrom(paramProperty);
  }
  
  public Property getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public int getGetterFlags()
  {
    return this.getterFlags_;
  }
  
  public int getName()
  {
    return this.name_;
  }
  
  public int getOldFlags()
  {
    return this.oldFlags_;
  }
  
  public Parser<Property> getParserForType()
  {
    return PARSER;
  }
  
  public ProtoBuf.Type getReceiverType()
  {
    return this.receiverType_;
  }
  
  public int getReceiverTypeId()
  {
    return this.receiverTypeId_;
  }
  
  public ProtoBuf.Type getReturnType()
  {
    return this.returnType_;
  }
  
  public int getReturnTypeId()
  {
    return this.returnTypeId_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int k = 0;
    if ((i & 0x2) == 2) {
      j = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if ((this.bitField0_ & 0x4) == 4) {
      i = j + CodedOutputStream.computeInt32Size(2, this.name_);
    }
    int j = i;
    if ((this.bitField0_ & 0x8) == 8) {
      j = i + CodedOutputStream.computeMessageSize(3, this.returnType_);
    }
    i = j;
    j = 0;
    while (j < this.typeParameter_.size())
    {
      i += CodedOutputStream.computeMessageSize(4, (MessageLite)this.typeParameter_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x20) == 32) {
      j = i + CodedOutputStream.computeMessageSize(5, this.receiverType_);
    }
    i = j;
    if ((this.bitField0_ & 0x80) == 128) {
      i = j + CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
    }
    j = i;
    if ((this.bitField0_ & 0x100) == 256) {
      j = i + CodedOutputStream.computeInt32Size(7, this.getterFlags_);
    }
    i = j;
    if ((this.bitField0_ & 0x200) == 512) {
      i = j + CodedOutputStream.computeInt32Size(8, this.setterFlags_);
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
    }
    i = j;
    if ((this.bitField0_ & 0x40) == 64) {
      i = j + CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
    }
    j = i;
    if ((this.bitField0_ & 0x1) == 1) {
      j = i + CodedOutputStream.computeInt32Size(11, this.flags_);
    }
    int m = 0;
    i = k;
    k = m;
    while (i < this.versionRequirement_.size())
    {
      k += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.versionRequirement_.get(i)).intValue());
      i += 1;
    }
    i = j + k + getVersionRequirementList().size() * 2 + extensionsSerializedSize() + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getSetterFlags()
  {
    return this.setterFlags_;
  }
  
  public ProtoBuf.ValueParameter getSetterValueParameter()
  {
    return this.setterValueParameter_;
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
  
  public List<Integer> getVersionRequirementList()
  {
    return this.versionRequirement_;
  }
  
  public boolean hasFlags()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasGetterFlags()
  {
    return (this.bitField0_ & 0x100) == 256;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasOldFlags()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasReceiverType()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasReceiverTypeId()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public boolean hasReturnType()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasReturnTypeId()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasSetterFlags()
  {
    return (this.bitField0_ & 0x200) == 512;
  }
  
  public boolean hasSetterValueParameter()
  {
    return (this.bitField0_ & 0x80) == 128;
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
    if ((hasReturnType()) && (!getReturnType().isInitialized()))
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
    if ((hasReceiverType()) && (!getReceiverType().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if ((hasSetterValueParameter()) && (!getSetterValueParameter().isInitialized()))
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
  
  public ProtoBuf.Property.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Property.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    GeneratedMessageLite.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(1, this.oldFlags_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeInt32(2, this.name_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeMessage(3, this.returnType_);
    }
    int j = 0;
    int i = 0;
    while (i < this.typeParameter_.size())
    {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.typeParameter_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeMessage(5, this.receiverType_);
    }
    if ((this.bitField0_ & 0x80) == 128) {
      paramCodedOutputStream.writeMessage(6, this.setterValueParameter_);
    }
    if ((this.bitField0_ & 0x100) == 256) {
      paramCodedOutputStream.writeInt32(7, this.getterFlags_);
    }
    if ((this.bitField0_ & 0x200) == 512) {
      paramCodedOutputStream.writeInt32(8, this.setterFlags_);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeInt32(9, this.returnTypeId_);
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeInt32(10, this.receiverTypeId_);
    }
    i = j;
    if ((this.bitField0_ & 0x1) == 1)
    {
      paramCodedOutputStream.writeInt32(11, this.flags_);
      i = j;
    }
    while (i < this.versionRequirement_.size())
    {
      paramCodedOutputStream.writeInt32(31, ((Integer)this.versionRequirement_.get(i)).intValue());
      i += 1;
    }
    localExtensionWriter.writeUntil(19000, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property
 * JD-Core Version:    0.7.0.1
 */