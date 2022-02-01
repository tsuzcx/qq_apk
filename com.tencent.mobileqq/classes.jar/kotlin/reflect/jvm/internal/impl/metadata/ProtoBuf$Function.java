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

public final class ProtoBuf$Function
  extends GeneratedMessageLite.ExtendableMessage<Function>
  implements ProtoBuf.FunctionOrBuilder
{
  public static Parser<Function> PARSER = new ProtoBuf.Function.1();
  private static final Function defaultInstance = new Function(true);
  private int bitField0_;
  private ProtoBuf.Contract contract_;
  private int flags_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int name_;
  private int oldFlags_;
  private int receiverTypeId_;
  private ProtoBuf.Type receiverType_;
  private int returnTypeId_;
  private ProtoBuf.Type returnType_;
  private List<ProtoBuf.TypeParameter> typeParameter_;
  private ProtoBuf.TypeTable typeTable_;
  private final ByteString unknownFields;
  private List<ProtoBuf.ValueParameter> valueParameter_;
  private List<Integer> versionRequirement_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Function(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 62	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 64	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 66	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 55	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:initFields	()V
    //   18: invokestatic 72	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 15
    //   23: aload 15
    //   25: iconst_1
    //   26: invokestatic 78	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 16
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +1438 -> 1476
    //   41: iload_3
    //   42: istore 4
    //   44: iload_3
    //   45: istore 5
    //   47: iload_3
    //   48: istore 6
    //   50: aload_1
    //   51: invokevirtual 84	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 7
    //   56: aconst_null
    //   57: astore 12
    //   59: aconst_null
    //   60: astore 13
    //   62: aconst_null
    //   63: astore 14
    //   65: aconst_null
    //   66: astore 11
    //   68: iload 7
    //   70: lookupswitch	default:+1512->1582, 0:+1254->1324, 8:+1215->1285, 16:+1176->1246, 26:+1044->1114, 34:+970->1040, 42:+838->908, 50:+761->831, 56:+721->791, 64:+681->751, 72:+642->712, 242:+507->577, 248:+431->501, 250:+277->347, 258:+146->216
    //   193: istore 4
    //   195: iload_3
    //   196: istore 5
    //   198: iload_3
    //   199: istore 6
    //   201: aload_0
    //   202: aload_1
    //   203: aload 16
    //   205: aload_2
    //   206: iload 7
    //   208: invokevirtual 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   211: istore 10
    //   213: goto +1117 -> 1330
    //   216: iload_3
    //   217: istore 4
    //   219: iload_3
    //   220: istore 5
    //   222: iload_3
    //   223: istore 6
    //   225: aload_0
    //   226: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   229: sipush 256
    //   232: iand
    //   233: sipush 256
    //   236: if_icmpne +21 -> 257
    //   239: iload_3
    //   240: istore 4
    //   242: iload_3
    //   243: istore 5
    //   245: iload_3
    //   246: istore 6
    //   248: aload_0
    //   249: getfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:contract_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract;
    //   252: invokevirtual 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract$Builder;
    //   255: astore 11
    //   257: iload_3
    //   258: istore 4
    //   260: iload_3
    //   261: istore 5
    //   263: iload_3
    //   264: istore 6
    //   266: aload_0
    //   267: aload_1
    //   268: getstatic 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   271: aload_2
    //   272: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   275: checkcast 94	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract
    //   278: putfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:contract_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract;
    //   281: aload 11
    //   283: ifnull +40 -> 323
    //   286: iload_3
    //   287: istore 4
    //   289: iload_3
    //   290: istore 5
    //   292: iload_3
    //   293: istore 6
    //   295: aload 11
    //   297: aload_0
    //   298: getfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:contract_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract;
    //   301: invokevirtual 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract$Builder;
    //   304: pop
    //   305: iload_3
    //   306: istore 4
    //   308: iload_3
    //   309: istore 5
    //   311: iload_3
    //   312: istore 6
    //   314: aload_0
    //   315: aload 11
    //   317: invokevirtual 113	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract;
    //   320: putfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:contract_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract;
    //   323: iload_3
    //   324: istore 4
    //   326: iload_3
    //   327: istore 5
    //   329: iload_3
    //   330: istore 6
    //   332: aload_0
    //   333: aload_0
    //   334: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   337: sipush 256
    //   340: ior
    //   341: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   344: goto -308 -> 36
    //   347: iload_3
    //   348: istore 4
    //   350: iload_3
    //   351: istore 5
    //   353: iload_3
    //   354: istore 6
    //   356: aload_1
    //   357: aload_1
    //   358: invokevirtual 116	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   361: invokevirtual 120	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   364: istore 9
    //   366: iload_3
    //   367: istore 7
    //   369: iload_3
    //   370: sipush 1024
    //   373: iand
    //   374: sipush 1024
    //   377: if_icmpeq +49 -> 426
    //   380: iload_3
    //   381: istore 7
    //   383: iload_3
    //   384: istore 4
    //   386: iload_3
    //   387: istore 5
    //   389: iload_3
    //   390: istore 6
    //   392: aload_1
    //   393: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   396: ifle +30 -> 426
    //   399: iload_3
    //   400: istore 4
    //   402: iload_3
    //   403: istore 5
    //   405: iload_3
    //   406: istore 6
    //   408: aload_0
    //   409: new 125	java/util/ArrayList
    //   412: dup
    //   413: invokespecial 126	java/util/ArrayList:<init>	()V
    //   416: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:versionRequirement_	Ljava/util/List;
    //   419: iload_3
    //   420: sipush 1024
    //   423: ior
    //   424: istore 7
    //   426: iload 7
    //   428: istore 4
    //   430: iload 7
    //   432: istore 5
    //   434: iload 7
    //   436: istore 6
    //   438: aload_1
    //   439: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   442: ifle +35 -> 477
    //   445: iload 7
    //   447: istore 4
    //   449: iload 7
    //   451: istore 5
    //   453: iload 7
    //   455: istore 6
    //   457: aload_0
    //   458: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:versionRequirement_	Ljava/util/List;
    //   461: aload_1
    //   462: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   465: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: invokeinterface 143 2 0
    //   473: pop
    //   474: goto -48 -> 426
    //   477: iload 7
    //   479: istore 4
    //   481: iload 7
    //   483: istore 5
    //   485: iload 7
    //   487: istore 6
    //   489: aload_1
    //   490: iload 9
    //   492: invokevirtual 147	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   495: iload 7
    //   497: istore_3
    //   498: goto -462 -> 36
    //   501: iload_3
    //   502: istore 7
    //   504: iload_3
    //   505: sipush 1024
    //   508: iand
    //   509: sipush 1024
    //   512: if_icmpeq +30 -> 542
    //   515: iload_3
    //   516: istore 4
    //   518: iload_3
    //   519: istore 5
    //   521: iload_3
    //   522: istore 6
    //   524: aload_0
    //   525: new 125	java/util/ArrayList
    //   528: dup
    //   529: invokespecial 126	java/util/ArrayList:<init>	()V
    //   532: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:versionRequirement_	Ljava/util/List;
    //   535: iload_3
    //   536: sipush 1024
    //   539: ior
    //   540: istore 7
    //   542: iload 7
    //   544: istore 4
    //   546: iload 7
    //   548: istore 5
    //   550: iload 7
    //   552: istore 6
    //   554: aload_0
    //   555: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:versionRequirement_	Ljava/util/List;
    //   558: aload_1
    //   559: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   562: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: invokeinterface 143 2 0
    //   570: pop
    //   571: iload 7
    //   573: istore_3
    //   574: goto -538 -> 36
    //   577: aload 12
    //   579: astore 11
    //   581: iload_3
    //   582: istore 4
    //   584: iload_3
    //   585: istore 5
    //   587: iload_3
    //   588: istore 6
    //   590: aload_0
    //   591: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   594: sipush 128
    //   597: iand
    //   598: sipush 128
    //   601: if_icmpne +21 -> 622
    //   604: iload_3
    //   605: istore 4
    //   607: iload_3
    //   608: istore 5
    //   610: iload_3
    //   611: istore 6
    //   613: aload_0
    //   614: getfield 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   617: invokevirtual 154	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder;
    //   620: astore 11
    //   622: iload_3
    //   623: istore 4
    //   625: iload_3
    //   626: istore 5
    //   628: iload_3
    //   629: istore 6
    //   631: aload_0
    //   632: aload_1
    //   633: getstatic 155	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   636: aload_2
    //   637: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   640: checkcast 151	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable
    //   643: putfield 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   646: aload 11
    //   648: ifnull +40 -> 688
    //   651: iload_3
    //   652: istore 4
    //   654: iload_3
    //   655: istore 5
    //   657: iload_3
    //   658: istore 6
    //   660: aload 11
    //   662: aload_0
    //   663: getfield 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   666: invokevirtual 160	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder;
    //   669: pop
    //   670: iload_3
    //   671: istore 4
    //   673: iload_3
    //   674: istore 5
    //   676: iload_3
    //   677: istore 6
    //   679: aload_0
    //   680: aload 11
    //   682: invokevirtual 163	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   685: putfield 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeTable_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;
    //   688: iload_3
    //   689: istore 4
    //   691: iload_3
    //   692: istore 5
    //   694: iload_3
    //   695: istore 6
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   702: sipush 128
    //   705: ior
    //   706: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   709: goto -673 -> 36
    //   712: iload_3
    //   713: istore 4
    //   715: iload_3
    //   716: istore 5
    //   718: iload_3
    //   719: istore 6
    //   721: aload_0
    //   722: aload_0
    //   723: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   726: iconst_1
    //   727: ior
    //   728: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   731: iload_3
    //   732: istore 4
    //   734: iload_3
    //   735: istore 5
    //   737: iload_3
    //   738: istore 6
    //   740: aload_0
    //   741: aload_1
    //   742: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   745: putfield 165	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:flags_	I
    //   748: goto -712 -> 36
    //   751: iload_3
    //   752: istore 4
    //   754: iload_3
    //   755: istore 5
    //   757: iload_3
    //   758: istore 6
    //   760: aload_0
    //   761: aload_0
    //   762: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   765: bipush 64
    //   767: ior
    //   768: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   771: iload_3
    //   772: istore 4
    //   774: iload_3
    //   775: istore 5
    //   777: iload_3
    //   778: istore 6
    //   780: aload_0
    //   781: aload_1
    //   782: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   785: putfield 167	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:receiverTypeId_	I
    //   788: goto -752 -> 36
    //   791: iload_3
    //   792: istore 4
    //   794: iload_3
    //   795: istore 5
    //   797: iload_3
    //   798: istore 6
    //   800: aload_0
    //   801: aload_0
    //   802: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   805: bipush 16
    //   807: ior
    //   808: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   811: iload_3
    //   812: istore 4
    //   814: iload_3
    //   815: istore 5
    //   817: iload_3
    //   818: istore 6
    //   820: aload_0
    //   821: aload_1
    //   822: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   825: putfield 169	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:returnTypeId_	I
    //   828: goto -792 -> 36
    //   831: iload_3
    //   832: istore 7
    //   834: iload_3
    //   835: sipush 256
    //   838: iand
    //   839: sipush 256
    //   842: if_icmpeq +30 -> 872
    //   845: iload_3
    //   846: istore 4
    //   848: iload_3
    //   849: istore 5
    //   851: iload_3
    //   852: istore 6
    //   854: aload_0
    //   855: new 125	java/util/ArrayList
    //   858: dup
    //   859: invokespecial 126	java/util/ArrayList:<init>	()V
    //   862: putfield 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:valueParameter_	Ljava/util/List;
    //   865: iload_3
    //   866: sipush 256
    //   869: ior
    //   870: istore 7
    //   872: iload 7
    //   874: istore 4
    //   876: iload 7
    //   878: istore 5
    //   880: iload 7
    //   882: istore 6
    //   884: aload_0
    //   885: getfield 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:valueParameter_	Ljava/util/List;
    //   888: aload_1
    //   889: getstatic 174	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   892: aload_2
    //   893: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   896: invokeinterface 143 2 0
    //   901: pop
    //   902: iload 7
    //   904: istore_3
    //   905: goto -869 -> 36
    //   908: aload 13
    //   910: astore 11
    //   912: iload_3
    //   913: istore 4
    //   915: iload_3
    //   916: istore 5
    //   918: iload_3
    //   919: istore 6
    //   921: aload_0
    //   922: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   925: bipush 32
    //   927: iand
    //   928: bipush 32
    //   930: if_icmpne +21 -> 951
    //   933: iload_3
    //   934: istore 4
    //   936: iload_3
    //   937: istore 5
    //   939: iload_3
    //   940: istore 6
    //   942: aload_0
    //   943: getfield 176	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:receiverType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   946: invokevirtual 181	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   949: astore 11
    //   951: iload_3
    //   952: istore 4
    //   954: iload_3
    //   955: istore 5
    //   957: iload_3
    //   958: istore 6
    //   960: aload_0
    //   961: aload_1
    //   962: getstatic 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   965: aload_2
    //   966: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   969: checkcast 178	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   972: putfield 176	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:receiverType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   975: aload 11
    //   977: ifnull +40 -> 1017
    //   980: iload_3
    //   981: istore 4
    //   983: iload_3
    //   984: istore 5
    //   986: iload_3
    //   987: istore 6
    //   989: aload 11
    //   991: aload_0
    //   992: getfield 176	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:receiverType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   995: invokevirtual 187	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   998: pop
    //   999: iload_3
    //   1000: istore 4
    //   1002: iload_3
    //   1003: istore 5
    //   1005: iload_3
    //   1006: istore 6
    //   1008: aload_0
    //   1009: aload 11
    //   1011: invokevirtual 190	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1014: putfield 176	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:receiverType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1017: iload_3
    //   1018: istore 4
    //   1020: iload_3
    //   1021: istore 5
    //   1023: iload_3
    //   1024: istore 6
    //   1026: aload_0
    //   1027: aload_0
    //   1028: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1031: bipush 32
    //   1033: ior
    //   1034: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1037: goto -1001 -> 36
    //   1040: iload_3
    //   1041: istore 7
    //   1043: iload_3
    //   1044: bipush 32
    //   1046: iand
    //   1047: bipush 32
    //   1049: if_icmpeq +29 -> 1078
    //   1052: iload_3
    //   1053: istore 4
    //   1055: iload_3
    //   1056: istore 5
    //   1058: iload_3
    //   1059: istore 6
    //   1061: aload_0
    //   1062: new 125	java/util/ArrayList
    //   1065: dup
    //   1066: invokespecial 126	java/util/ArrayList:<init>	()V
    //   1069: putfield 192	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeParameter_	Ljava/util/List;
    //   1072: iload_3
    //   1073: bipush 32
    //   1075: ior
    //   1076: istore 7
    //   1078: iload 7
    //   1080: istore 4
    //   1082: iload 7
    //   1084: istore 5
    //   1086: iload 7
    //   1088: istore 6
    //   1090: aload_0
    //   1091: getfield 192	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeParameter_	Ljava/util/List;
    //   1094: aload_1
    //   1095: getstatic 195	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1098: aload_2
    //   1099: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1102: invokeinterface 143 2 0
    //   1107: pop
    //   1108: iload 7
    //   1110: istore_3
    //   1111: goto -1075 -> 36
    //   1114: aload 14
    //   1116: astore 11
    //   1118: iload_3
    //   1119: istore 4
    //   1121: iload_3
    //   1122: istore 5
    //   1124: iload_3
    //   1125: istore 6
    //   1127: aload_0
    //   1128: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1131: bipush 8
    //   1133: iand
    //   1134: bipush 8
    //   1136: if_icmpne +21 -> 1157
    //   1139: iload_3
    //   1140: istore 4
    //   1142: iload_3
    //   1143: istore 5
    //   1145: iload_3
    //   1146: istore 6
    //   1148: aload_0
    //   1149: getfield 197	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:returnType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1152: invokevirtual 181	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   1155: astore 11
    //   1157: iload_3
    //   1158: istore 4
    //   1160: iload_3
    //   1161: istore 5
    //   1163: iload_3
    //   1164: istore 6
    //   1166: aload_0
    //   1167: aload_1
    //   1168: getstatic 182	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1171: aload_2
    //   1172: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1175: checkcast 178	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   1178: putfield 197	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:returnType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1181: aload 11
    //   1183: ifnull +40 -> 1223
    //   1186: iload_3
    //   1187: istore 4
    //   1189: iload_3
    //   1190: istore 5
    //   1192: iload_3
    //   1193: istore 6
    //   1195: aload 11
    //   1197: aload_0
    //   1198: getfield 197	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:returnType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1201: invokevirtual 187	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   1204: pop
    //   1205: iload_3
    //   1206: istore 4
    //   1208: iload_3
    //   1209: istore 5
    //   1211: iload_3
    //   1212: istore 6
    //   1214: aload_0
    //   1215: aload 11
    //   1217: invokevirtual 190	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1220: putfield 197	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:returnType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   1223: iload_3
    //   1224: istore 4
    //   1226: iload_3
    //   1227: istore 5
    //   1229: iload_3
    //   1230: istore 6
    //   1232: aload_0
    //   1233: aload_0
    //   1234: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1237: bipush 8
    //   1239: ior
    //   1240: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1243: goto -1207 -> 36
    //   1246: iload_3
    //   1247: istore 4
    //   1249: iload_3
    //   1250: istore 5
    //   1252: iload_3
    //   1253: istore 6
    //   1255: aload_0
    //   1256: aload_0
    //   1257: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1260: iconst_4
    //   1261: ior
    //   1262: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1265: iload_3
    //   1266: istore 4
    //   1268: iload_3
    //   1269: istore 5
    //   1271: iload_3
    //   1272: istore 6
    //   1274: aload_0
    //   1275: aload_1
    //   1276: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1279: putfield 199	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:name_	I
    //   1282: goto -1246 -> 36
    //   1285: iload_3
    //   1286: istore 4
    //   1288: iload_3
    //   1289: istore 5
    //   1291: iload_3
    //   1292: istore 6
    //   1294: aload_0
    //   1295: aload_0
    //   1296: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1299: iconst_2
    //   1300: ior
    //   1301: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:bitField0_	I
    //   1304: iload_3
    //   1305: istore 4
    //   1307: iload_3
    //   1308: istore 5
    //   1310: iload_3
    //   1311: istore 6
    //   1313: aload_0
    //   1314: aload_1
    //   1315: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1318: putfield 201	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:oldFlags_	I
    //   1321: goto -1285 -> 36
    //   1324: iconst_1
    //   1325: istore 8
    //   1327: goto -1291 -> 36
    //   1330: iload 10
    //   1332: ifne -1296 -> 36
    //   1335: goto -11 -> 1324
    //   1338: astore_1
    //   1339: goto +35 -> 1374
    //   1342: astore_1
    //   1343: iload 5
    //   1345: istore 4
    //   1347: new 59	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1350: dup
    //   1351: aload_1
    //   1352: invokevirtual 205	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1355: invokespecial 208	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   1358: aload_0
    //   1359: invokevirtual 212	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   1362: athrow
    //   1363: astore_1
    //   1364: iload 6
    //   1366: istore 4
    //   1368: aload_1
    //   1369: aload_0
    //   1370: invokevirtual 212	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   1373: athrow
    //   1374: iload 4
    //   1376: bipush 32
    //   1378: iand
    //   1379: bipush 32
    //   1381: if_icmpne +14 -> 1395
    //   1384: aload_0
    //   1385: aload_0
    //   1386: getfield 192	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeParameter_	Ljava/util/List;
    //   1389: invokestatic 218	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1392: putfield 192	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeParameter_	Ljava/util/List;
    //   1395: iload 4
    //   1397: sipush 256
    //   1400: iand
    //   1401: sipush 256
    //   1404: if_icmpne +14 -> 1418
    //   1407: aload_0
    //   1408: aload_0
    //   1409: getfield 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:valueParameter_	Ljava/util/List;
    //   1412: invokestatic 218	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1415: putfield 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:valueParameter_	Ljava/util/List;
    //   1418: iload 4
    //   1420: sipush 1024
    //   1423: iand
    //   1424: sipush 1024
    //   1427: if_icmpne +14 -> 1441
    //   1430: aload_0
    //   1431: aload_0
    //   1432: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:versionRequirement_	Ljava/util/List;
    //   1435: invokestatic 218	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1438: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:versionRequirement_	Ljava/util/List;
    //   1441: aload 16
    //   1443: invokevirtual 221	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1446: aload_0
    //   1447: aload 15
    //   1449: invokevirtual 227	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1452: putfield 229	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1455: goto +15 -> 1470
    //   1458: astore_1
    //   1459: aload_0
    //   1460: aload 15
    //   1462: invokevirtual 227	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1465: putfield 229	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1468: aload_1
    //   1469: athrow
    //   1470: aload_0
    //   1471: invokevirtual 232	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:makeExtensionsImmutable	()V
    //   1474: aload_1
    //   1475: athrow
    //   1476: iload_3
    //   1477: bipush 32
    //   1479: iand
    //   1480: bipush 32
    //   1482: if_icmpne +14 -> 1496
    //   1485: aload_0
    //   1486: aload_0
    //   1487: getfield 192	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeParameter_	Ljava/util/List;
    //   1490: invokestatic 218	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1493: putfield 192	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:typeParameter_	Ljava/util/List;
    //   1496: iload_3
    //   1497: sipush 256
    //   1500: iand
    //   1501: sipush 256
    //   1504: if_icmpne +14 -> 1518
    //   1507: aload_0
    //   1508: aload_0
    //   1509: getfield 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:valueParameter_	Ljava/util/List;
    //   1512: invokestatic 218	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1515: putfield 171	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:valueParameter_	Ljava/util/List;
    //   1518: iload_3
    //   1519: sipush 1024
    //   1522: iand
    //   1523: sipush 1024
    //   1526: if_icmpne +14 -> 1540
    //   1529: aload_0
    //   1530: aload_0
    //   1531: getfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:versionRequirement_	Ljava/util/List;
    //   1534: invokestatic 218	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1537: putfield 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:versionRequirement_	Ljava/util/List;
    //   1540: aload 16
    //   1542: invokevirtual 221	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1545: aload_0
    //   1546: aload 15
    //   1548: invokevirtual 227	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1551: putfield 229	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1554: goto +15 -> 1569
    //   1557: astore_1
    //   1558: aload_0
    //   1559: aload 15
    //   1561: invokevirtual 227	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1564: putfield 229	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1567: aload_1
    //   1568: athrow
    //   1569: aload_0
    //   1570: invokevirtual 232	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:makeExtensionsImmutable	()V
    //   1573: return
    //   1574: astore_2
    //   1575: goto -129 -> 1446
    //   1578: astore_1
    //   1579: goto -34 -> 1545
    //   1582: goto -1390 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1585	0	this	Function
    //   0	1585	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	1585	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   35	1488	3	i	int
    //   42	1382	4	j	int
    //   45	1299	5	k	int
    //   48	1317	6	m	int
    //   54	1055	7	n	int
    //   32	1294	8	i1	int
    //   364	127	9	i2	int
    //   211	1120	10	bool	boolean
    //   66	1150	11	localObject1	java.lang.Object
    //   57	521	12	localObject2	java.lang.Object
    //   60	849	13	localObject3	java.lang.Object
    //   63	1052	14	localObject4	java.lang.Object
    //   21	1539	15	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	1512	16	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	1338	finally
    //   201	213	1338	finally
    //   225	239	1338	finally
    //   248	257	1338	finally
    //   266	281	1338	finally
    //   295	305	1338	finally
    //   314	323	1338	finally
    //   332	344	1338	finally
    //   356	366	1338	finally
    //   392	399	1338	finally
    //   408	419	1338	finally
    //   438	445	1338	finally
    //   457	474	1338	finally
    //   489	495	1338	finally
    //   524	535	1338	finally
    //   554	571	1338	finally
    //   590	604	1338	finally
    //   613	622	1338	finally
    //   631	646	1338	finally
    //   660	670	1338	finally
    //   679	688	1338	finally
    //   697	709	1338	finally
    //   721	731	1338	finally
    //   740	748	1338	finally
    //   760	771	1338	finally
    //   780	788	1338	finally
    //   800	811	1338	finally
    //   820	828	1338	finally
    //   854	865	1338	finally
    //   884	902	1338	finally
    //   921	933	1338	finally
    //   942	951	1338	finally
    //   960	975	1338	finally
    //   989	999	1338	finally
    //   1008	1017	1338	finally
    //   1026	1037	1338	finally
    //   1061	1072	1338	finally
    //   1090	1108	1338	finally
    //   1127	1139	1338	finally
    //   1148	1157	1338	finally
    //   1166	1181	1338	finally
    //   1195	1205	1338	finally
    //   1214	1223	1338	finally
    //   1232	1243	1338	finally
    //   1255	1265	1338	finally
    //   1274	1282	1338	finally
    //   1294	1304	1338	finally
    //   1313	1321	1338	finally
    //   1347	1363	1338	finally
    //   1368	1374	1338	finally
    //   50	56	1342	java/io/IOException
    //   201	213	1342	java/io/IOException
    //   225	239	1342	java/io/IOException
    //   248	257	1342	java/io/IOException
    //   266	281	1342	java/io/IOException
    //   295	305	1342	java/io/IOException
    //   314	323	1342	java/io/IOException
    //   332	344	1342	java/io/IOException
    //   356	366	1342	java/io/IOException
    //   392	399	1342	java/io/IOException
    //   408	419	1342	java/io/IOException
    //   438	445	1342	java/io/IOException
    //   457	474	1342	java/io/IOException
    //   489	495	1342	java/io/IOException
    //   524	535	1342	java/io/IOException
    //   554	571	1342	java/io/IOException
    //   590	604	1342	java/io/IOException
    //   613	622	1342	java/io/IOException
    //   631	646	1342	java/io/IOException
    //   660	670	1342	java/io/IOException
    //   679	688	1342	java/io/IOException
    //   697	709	1342	java/io/IOException
    //   721	731	1342	java/io/IOException
    //   740	748	1342	java/io/IOException
    //   760	771	1342	java/io/IOException
    //   780	788	1342	java/io/IOException
    //   800	811	1342	java/io/IOException
    //   820	828	1342	java/io/IOException
    //   854	865	1342	java/io/IOException
    //   884	902	1342	java/io/IOException
    //   921	933	1342	java/io/IOException
    //   942	951	1342	java/io/IOException
    //   960	975	1342	java/io/IOException
    //   989	999	1342	java/io/IOException
    //   1008	1017	1342	java/io/IOException
    //   1026	1037	1342	java/io/IOException
    //   1061	1072	1342	java/io/IOException
    //   1090	1108	1342	java/io/IOException
    //   1127	1139	1342	java/io/IOException
    //   1148	1157	1342	java/io/IOException
    //   1166	1181	1342	java/io/IOException
    //   1195	1205	1342	java/io/IOException
    //   1214	1223	1342	java/io/IOException
    //   1232	1243	1342	java/io/IOException
    //   1255	1265	1342	java/io/IOException
    //   1274	1282	1342	java/io/IOException
    //   1294	1304	1342	java/io/IOException
    //   1313	1321	1342	java/io/IOException
    //   50	56	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   201	213	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   225	239	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   248	257	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   266	281	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   295	305	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   314	323	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   332	344	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   356	366	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   392	399	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   408	419	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   438	445	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   457	474	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   489	495	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   524	535	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   554	571	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   590	604	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   613	622	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   631	646	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   660	670	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   679	688	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   697	709	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   721	731	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   740	748	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   760	771	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   780	788	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   800	811	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   820	828	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   854	865	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   884	902	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   921	933	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   942	951	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   960	975	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   989	999	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1008	1017	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1026	1037	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1061	1072	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1090	1108	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1127	1139	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1148	1157	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1166	1181	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1195	1205	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1214	1223	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1232	1243	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1255	1265	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1274	1282	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1294	1304	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1313	1321	1363	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1441	1446	1458	finally
    //   1540	1545	1557	finally
    //   1441	1446	1574	java/io/IOException
    //   1540	1545	1578	java/io/IOException
  }
  
  private ProtoBuf$Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Function(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Function getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.flags_ = 6;
    this.oldFlags_ = 6;
    this.name_ = 0;
    this.returnType_ = ProtoBuf.Type.getDefaultInstance();
    this.returnTypeId_ = 0;
    this.typeParameter_ = Collections.emptyList();
    this.receiverType_ = ProtoBuf.Type.getDefaultInstance();
    this.receiverTypeId_ = 0;
    this.valueParameter_ = Collections.emptyList();
    this.typeTable_ = ProtoBuf.TypeTable.getDefaultInstance();
    this.versionRequirement_ = Collections.emptyList();
    this.contract_ = ProtoBuf.Contract.getDefaultInstance();
  }
  
  public static ProtoBuf.Function.Builder newBuilder()
  {
    return ProtoBuf.Function.Builder.access$13300();
  }
  
  public static ProtoBuf.Function.Builder newBuilder(Function paramFunction)
  {
    return newBuilder().mergeFrom(paramFunction);
  }
  
  public static Function parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (Function)PARSER.parseFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public ProtoBuf.Contract getContract()
  {
    return this.contract_;
  }
  
  public Function getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public int getName()
  {
    return this.name_;
  }
  
  public int getOldFlags()
  {
    return this.oldFlags_;
  }
  
  public Parser<Function> getParserForType()
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
    int m = 0;
    i = j;
    j = m;
    while (j < this.valueParameter_.size())
    {
      i += CodedOutputStream.computeMessageSize(6, (MessageLite)this.valueParameter_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
    }
    i = j;
    if ((this.bitField0_ & 0x40) == 64) {
      i = j + CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
    }
    j = i;
    if ((this.bitField0_ & 0x1) == 1) {
      j = i + CodedOutputStream.computeInt32Size(9, this.flags_);
    }
    i = j;
    if ((this.bitField0_ & 0x80) == 128) {
      i = j + CodedOutputStream.computeMessageSize(30, this.typeTable_);
    }
    m = 0;
    j = k;
    k = m;
    while (j < this.versionRequirement_.size())
    {
      k += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.versionRequirement_.get(j)).intValue());
      j += 1;
    }
    j = i + k + getVersionRequirementList().size() * 2;
    i = j;
    if ((this.bitField0_ & 0x100) == 256) {
      i = j + CodedOutputStream.computeMessageSize(32, this.contract_);
    }
    i = i + extensionsSerializedSize() + this.unknownFields.size();
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
  
  public ProtoBuf.TypeTable getTypeTable()
  {
    return this.typeTable_;
  }
  
  public ProtoBuf.ValueParameter getValueParameter(int paramInt)
  {
    return (ProtoBuf.ValueParameter)this.valueParameter_.get(paramInt);
  }
  
  public int getValueParameterCount()
  {
    return this.valueParameter_.size();
  }
  
  public List<ProtoBuf.ValueParameter> getValueParameterList()
  {
    return this.valueParameter_;
  }
  
  public List<Integer> getVersionRequirementList()
  {
    return this.versionRequirement_;
  }
  
  public boolean hasContract()
  {
    return (this.bitField0_ & 0x100) == 256;
  }
  
  public boolean hasFlags()
  {
    return (this.bitField0_ & 0x1) == 1;
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
  
  public boolean hasTypeTable()
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
    i = 0;
    while (i < getValueParameterCount())
    {
      if (!getValueParameter(i).isInitialized())
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
    if ((hasContract()) && (!getContract().isInitialized()))
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
  
  public ProtoBuf.Function.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Function.Builder toBuilder()
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
    i = 0;
    while (i < this.valueParameter_.size())
    {
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.valueParameter_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeInt32(7, this.returnTypeId_);
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeInt32(8, this.receiverTypeId_);
    }
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(9, this.flags_);
    }
    i = j;
    if ((this.bitField0_ & 0x80) == 128)
    {
      paramCodedOutputStream.writeMessage(30, this.typeTable_);
      i = j;
    }
    while (i < this.versionRequirement_.size())
    {
      paramCodedOutputStream.writeInt32(31, ((Integer)this.versionRequirement_.get(i)).intValue());
      i += 1;
    }
    if ((this.bitField0_ & 0x100) == 256) {
      paramCodedOutputStream.writeMessage(32, this.contract_);
    }
    localExtensionWriter.writeUntil(19000, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function
 * JD-Core Version:    0.7.0.1
 */