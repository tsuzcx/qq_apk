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

public final class ProtoBuf$Type
  extends GeneratedMessageLite.ExtendableMessage<Type>
  implements ProtoBuf.TypeOrBuilder
{
  public static Parser<Type> PARSER = new ProtoBuf.Type.1();
  private static final Type defaultInstance = new Type(true);
  private int abbreviatedTypeId_;
  private Type abbreviatedType_;
  private List<ProtoBuf.Type.Argument> argument_;
  private int bitField0_;
  private int className_;
  private int flags_;
  private int flexibleTypeCapabilitiesId_;
  private int flexibleUpperBoundId_;
  private Type flexibleUpperBound_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private boolean nullable_;
  private int outerTypeId_;
  private Type outerType_;
  private int typeAliasName_;
  private int typeParameterName_;
  private int typeParameter_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Type(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 60	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 62	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 64	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 53	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:initFields	()V
    //   18: invokestatic 70	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 13
    //   23: aload 13
    //   25: iconst_1
    //   26: invokestatic 76	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 14
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +1154 -> 1192
    //   41: iload_3
    //   42: istore 5
    //   44: iload_3
    //   45: istore 6
    //   47: iload_3
    //   48: istore 7
    //   50: aload_1
    //   51: invokevirtual 82	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 4
    //   56: aconst_null
    //   57: astore 11
    //   59: aconst_null
    //   60: astore 12
    //   62: aconst_null
    //   63: astore 10
    //   65: iload 4
    //   67: lookupswitch	default:+1185->1252, 0:+1021->1088, 8:+980->1047, 18:+909->976, 24:+870->937, 32:+831->898, 42:+702->769, 48:+662->729, 56:+622->689, 64:+582->649, 72:+542->609, 82:+407->474, 88:+366->433, 96:+325->392, 106:+194->261, 112:+153->220
    //   197: istore 5
    //   199: iload_3
    //   200: istore 6
    //   202: iload_3
    //   203: istore 7
    //   205: aload_0
    //   206: aload_1
    //   207: aload 14
    //   209: aload_2
    //   210: iload 4
    //   212: invokevirtual 86	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   215: istore 9
    //   217: goto +877 -> 1094
    //   220: iload_3
    //   221: istore 5
    //   223: iload_3
    //   224: istore 6
    //   226: iload_3
    //   227: istore 7
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   234: sipush 2048
    //   237: ior
    //   238: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   241: iload_3
    //   242: istore 5
    //   244: iload_3
    //   245: istore 6
    //   247: iload_3
    //   248: istore 7
    //   250: aload_0
    //   251: aload_1
    //   252: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   255: putfield 93	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:abbreviatedTypeId_	I
    //   258: goto -222 -> 36
    //   261: iload_3
    //   262: istore 5
    //   264: iload_3
    //   265: istore 6
    //   267: iload_3
    //   268: istore 7
    //   270: aload_0
    //   271: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   274: sipush 1024
    //   277: iand
    //   278: sipush 1024
    //   281: if_icmpne +21 -> 302
    //   284: iload_3
    //   285: istore 5
    //   287: iload_3
    //   288: istore 6
    //   290: iload_3
    //   291: istore 7
    //   293: aload_0
    //   294: getfield 95	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:abbreviatedType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   297: invokevirtual 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   300: astore 10
    //   302: iload_3
    //   303: istore 5
    //   305: iload_3
    //   306: istore 6
    //   308: iload_3
    //   309: istore 7
    //   311: aload_0
    //   312: aload_1
    //   313: getstatic 45	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   316: aload_2
    //   317: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   320: checkcast 2	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   323: putfield 95	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:abbreviatedType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   326: aload 10
    //   328: ifnull +40 -> 368
    //   331: iload_3
    //   332: istore 5
    //   334: iload_3
    //   335: istore 6
    //   337: iload_3
    //   338: istore 7
    //   340: aload 10
    //   342: aload_0
    //   343: getfield 95	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:abbreviatedType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   346: invokevirtual 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   349: pop
    //   350: iload_3
    //   351: istore 5
    //   353: iload_3
    //   354: istore 6
    //   356: iload_3
    //   357: istore 7
    //   359: aload_0
    //   360: aload 10
    //   362: invokevirtual 113	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   365: putfield 95	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:abbreviatedType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   368: iload_3
    //   369: istore 5
    //   371: iload_3
    //   372: istore 6
    //   374: iload_3
    //   375: istore 7
    //   377: aload_0
    //   378: aload_0
    //   379: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   382: sipush 1024
    //   385: ior
    //   386: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   389: goto -353 -> 36
    //   392: iload_3
    //   393: istore 5
    //   395: iload_3
    //   396: istore 6
    //   398: iload_3
    //   399: istore 7
    //   401: aload_0
    //   402: aload_0
    //   403: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   406: sipush 128
    //   409: ior
    //   410: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   413: iload_3
    //   414: istore 5
    //   416: iload_3
    //   417: istore 6
    //   419: iload_3
    //   420: istore 7
    //   422: aload_0
    //   423: aload_1
    //   424: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   427: putfield 115	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:typeAliasName_	I
    //   430: goto -394 -> 36
    //   433: iload_3
    //   434: istore 5
    //   436: iload_3
    //   437: istore 6
    //   439: iload_3
    //   440: istore 7
    //   442: aload_0
    //   443: aload_0
    //   444: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   447: sipush 512
    //   450: ior
    //   451: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   454: iload_3
    //   455: istore 5
    //   457: iload_3
    //   458: istore 6
    //   460: iload_3
    //   461: istore 7
    //   463: aload_0
    //   464: aload_1
    //   465: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   468: putfield 117	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:outerTypeId_	I
    //   471: goto -435 -> 36
    //   474: aload 11
    //   476: astore 10
    //   478: iload_3
    //   479: istore 5
    //   481: iload_3
    //   482: istore 6
    //   484: iload_3
    //   485: istore 7
    //   487: aload_0
    //   488: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   491: sipush 256
    //   494: iand
    //   495: sipush 256
    //   498: if_icmpne +21 -> 519
    //   501: iload_3
    //   502: istore 5
    //   504: iload_3
    //   505: istore 6
    //   507: iload_3
    //   508: istore 7
    //   510: aload_0
    //   511: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:outerType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   514: invokevirtual 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   517: astore 10
    //   519: iload_3
    //   520: istore 5
    //   522: iload_3
    //   523: istore 6
    //   525: iload_3
    //   526: istore 7
    //   528: aload_0
    //   529: aload_1
    //   530: getstatic 45	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   533: aload_2
    //   534: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   537: checkcast 2	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   540: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:outerType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   543: aload 10
    //   545: ifnull +40 -> 585
    //   548: iload_3
    //   549: istore 5
    //   551: iload_3
    //   552: istore 6
    //   554: iload_3
    //   555: istore 7
    //   557: aload 10
    //   559: aload_0
    //   560: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:outerType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   563: invokevirtual 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   566: pop
    //   567: iload_3
    //   568: istore 5
    //   570: iload_3
    //   571: istore 6
    //   573: iload_3
    //   574: istore 7
    //   576: aload_0
    //   577: aload 10
    //   579: invokevirtual 113	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   582: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:outerType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   585: iload_3
    //   586: istore 5
    //   588: iload_3
    //   589: istore 6
    //   591: iload_3
    //   592: istore 7
    //   594: aload_0
    //   595: aload_0
    //   596: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   599: sipush 256
    //   602: ior
    //   603: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   606: goto -570 -> 36
    //   609: iload_3
    //   610: istore 5
    //   612: iload_3
    //   613: istore 6
    //   615: iload_3
    //   616: istore 7
    //   618: aload_0
    //   619: aload_0
    //   620: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   623: bipush 64
    //   625: ior
    //   626: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   629: iload_3
    //   630: istore 5
    //   632: iload_3
    //   633: istore 6
    //   635: iload_3
    //   636: istore 7
    //   638: aload_0
    //   639: aload_1
    //   640: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   643: putfield 121	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:typeParameterName_	I
    //   646: goto -610 -> 36
    //   649: iload_3
    //   650: istore 5
    //   652: iload_3
    //   653: istore 6
    //   655: iload_3
    //   656: istore 7
    //   658: aload_0
    //   659: aload_0
    //   660: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   663: bipush 8
    //   665: ior
    //   666: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   669: iload_3
    //   670: istore 5
    //   672: iload_3
    //   673: istore 6
    //   675: iload_3
    //   676: istore 7
    //   678: aload_0
    //   679: aload_1
    //   680: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   683: putfield 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:flexibleUpperBoundId_	I
    //   686: goto -650 -> 36
    //   689: iload_3
    //   690: istore 5
    //   692: iload_3
    //   693: istore 6
    //   695: iload_3
    //   696: istore 7
    //   698: aload_0
    //   699: aload_0
    //   700: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   703: bipush 32
    //   705: ior
    //   706: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   709: iload_3
    //   710: istore 5
    //   712: iload_3
    //   713: istore 6
    //   715: iload_3
    //   716: istore 7
    //   718: aload_0
    //   719: aload_1
    //   720: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   723: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:typeParameter_	I
    //   726: goto -690 -> 36
    //   729: iload_3
    //   730: istore 5
    //   732: iload_3
    //   733: istore 6
    //   735: iload_3
    //   736: istore 7
    //   738: aload_0
    //   739: aload_0
    //   740: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   743: bipush 16
    //   745: ior
    //   746: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   749: iload_3
    //   750: istore 5
    //   752: iload_3
    //   753: istore 6
    //   755: iload_3
    //   756: istore 7
    //   758: aload_0
    //   759: aload_1
    //   760: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   763: putfield 127	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:className_	I
    //   766: goto -730 -> 36
    //   769: aload 12
    //   771: astore 10
    //   773: iload_3
    //   774: istore 5
    //   776: iload_3
    //   777: istore 6
    //   779: iload_3
    //   780: istore 7
    //   782: aload_0
    //   783: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   786: iconst_4
    //   787: iand
    //   788: iconst_4
    //   789: if_icmpne +21 -> 810
    //   792: iload_3
    //   793: istore 5
    //   795: iload_3
    //   796: istore 6
    //   798: iload_3
    //   799: istore 7
    //   801: aload_0
    //   802: getfield 129	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:flexibleUpperBound_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   805: invokevirtual 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   808: astore 10
    //   810: iload_3
    //   811: istore 5
    //   813: iload_3
    //   814: istore 6
    //   816: iload_3
    //   817: istore 7
    //   819: aload_0
    //   820: aload_1
    //   821: getstatic 45	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   824: aload_2
    //   825: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   828: checkcast 2	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   831: putfield 129	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:flexibleUpperBound_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   834: aload 10
    //   836: ifnull +40 -> 876
    //   839: iload_3
    //   840: istore 5
    //   842: iload_3
    //   843: istore 6
    //   845: iload_3
    //   846: istore 7
    //   848: aload 10
    //   850: aload_0
    //   851: getfield 129	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:flexibleUpperBound_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   854: invokevirtual 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   857: pop
    //   858: iload_3
    //   859: istore 5
    //   861: iload_3
    //   862: istore 6
    //   864: iload_3
    //   865: istore 7
    //   867: aload_0
    //   868: aload 10
    //   870: invokevirtual 113	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   873: putfield 129	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:flexibleUpperBound_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   876: iload_3
    //   877: istore 5
    //   879: iload_3
    //   880: istore 6
    //   882: iload_3
    //   883: istore 7
    //   885: aload_0
    //   886: aload_0
    //   887: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   890: iconst_4
    //   891: ior
    //   892: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   895: goto -859 -> 36
    //   898: iload_3
    //   899: istore 5
    //   901: iload_3
    //   902: istore 6
    //   904: iload_3
    //   905: istore 7
    //   907: aload_0
    //   908: aload_0
    //   909: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   912: iconst_2
    //   913: ior
    //   914: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   917: iload_3
    //   918: istore 5
    //   920: iload_3
    //   921: istore 6
    //   923: iload_3
    //   924: istore 7
    //   926: aload_0
    //   927: aload_1
    //   928: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   931: putfield 131	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:flexibleTypeCapabilitiesId_	I
    //   934: goto -898 -> 36
    //   937: iload_3
    //   938: istore 5
    //   940: iload_3
    //   941: istore 6
    //   943: iload_3
    //   944: istore 7
    //   946: aload_0
    //   947: aload_0
    //   948: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   951: iconst_1
    //   952: ior
    //   953: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   956: iload_3
    //   957: istore 5
    //   959: iload_3
    //   960: istore 6
    //   962: iload_3
    //   963: istore 7
    //   965: aload_0
    //   966: aload_1
    //   967: invokevirtual 135	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readBool	()Z
    //   970: putfield 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:nullable_	Z
    //   973: goto -937 -> 36
    //   976: iload_3
    //   977: istore 4
    //   979: iload_3
    //   980: iconst_1
    //   981: iand
    //   982: iconst_1
    //   983: if_icmpeq +28 -> 1011
    //   986: iload_3
    //   987: istore 5
    //   989: iload_3
    //   990: istore 6
    //   992: iload_3
    //   993: istore 7
    //   995: aload_0
    //   996: new 139	java/util/ArrayList
    //   999: dup
    //   1000: invokespecial 140	java/util/ArrayList:<init>	()V
    //   1003: putfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:argument_	Ljava/util/List;
    //   1006: iload_3
    //   1007: iconst_1
    //   1008: ior
    //   1009: istore 4
    //   1011: iload 4
    //   1013: istore 5
    //   1015: iload 4
    //   1017: istore 6
    //   1019: iload 4
    //   1021: istore 7
    //   1023: aload_0
    //   1024: getfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:argument_	Ljava/util/List;
    //   1027: aload_1
    //   1028: getstatic 145	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   1031: aload_2
    //   1032: invokevirtual 103	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   1035: invokeinterface 151 2 0
    //   1040: pop
    //   1041: iload 4
    //   1043: istore_3
    //   1044: goto -1008 -> 36
    //   1047: iload_3
    //   1048: istore 5
    //   1050: iload_3
    //   1051: istore 6
    //   1053: iload_3
    //   1054: istore 7
    //   1056: aload_0
    //   1057: aload_0
    //   1058: getfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   1061: sipush 4096
    //   1064: ior
    //   1065: putfield 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:bitField0_	I
    //   1068: iload_3
    //   1069: istore 5
    //   1071: iload_3
    //   1072: istore 6
    //   1074: iload_3
    //   1075: istore 7
    //   1077: aload_0
    //   1078: aload_1
    //   1079: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   1082: putfield 153	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:flags_	I
    //   1085: goto -1049 -> 36
    //   1088: iconst_1
    //   1089: istore 8
    //   1091: goto -1055 -> 36
    //   1094: iload 9
    //   1096: ifne -1060 -> 36
    //   1099: goto -11 -> 1088
    //   1102: astore_1
    //   1103: goto +35 -> 1138
    //   1106: astore_1
    //   1107: iload 6
    //   1109: istore 5
    //   1111: new 57	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1114: dup
    //   1115: aload_1
    //   1116: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1119: invokespecial 160	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   1122: aload_0
    //   1123: invokevirtual 164	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   1126: athrow
    //   1127: astore_1
    //   1128: iload 7
    //   1130: istore 5
    //   1132: aload_1
    //   1133: aload_0
    //   1134: invokevirtual 164	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   1137: athrow
    //   1138: iload 5
    //   1140: iconst_1
    //   1141: iand
    //   1142: iconst_1
    //   1143: if_icmpne +14 -> 1157
    //   1146: aload_0
    //   1147: aload_0
    //   1148: getfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:argument_	Ljava/util/List;
    //   1151: invokestatic 170	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1154: putfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:argument_	Ljava/util/List;
    //   1157: aload 14
    //   1159: invokevirtual 173	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1162: aload_0
    //   1163: aload 13
    //   1165: invokevirtual 179	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1168: putfield 181	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1171: goto +15 -> 1186
    //   1174: astore_1
    //   1175: aload_0
    //   1176: aload 13
    //   1178: invokevirtual 179	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1181: putfield 181	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1184: aload_1
    //   1185: athrow
    //   1186: aload_0
    //   1187: invokevirtual 184	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:makeExtensionsImmutable	()V
    //   1190: aload_1
    //   1191: athrow
    //   1192: iload_3
    //   1193: iconst_1
    //   1194: iand
    //   1195: iconst_1
    //   1196: if_icmpne +14 -> 1210
    //   1199: aload_0
    //   1200: aload_0
    //   1201: getfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:argument_	Ljava/util/List;
    //   1204: invokestatic 170	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1207: putfield 142	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:argument_	Ljava/util/List;
    //   1210: aload 14
    //   1212: invokevirtual 173	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   1215: aload_0
    //   1216: aload 13
    //   1218: invokevirtual 179	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1221: putfield 181	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1224: goto +15 -> 1239
    //   1227: astore_1
    //   1228: aload_0
    //   1229: aload 13
    //   1231: invokevirtual 179	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1234: putfield 181	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   1237: aload_1
    //   1238: athrow
    //   1239: aload_0
    //   1240: invokevirtual 184	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:makeExtensionsImmutable	()V
    //   1243: return
    //   1244: astore_2
    //   1245: goto -83 -> 1162
    //   1248: astore_1
    //   1249: goto -34 -> 1215
    //   1252: goto -1056 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1255	0	this	Type
    //   0	1255	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	1255	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	1160	3	i	int
    //   54	988	4	j	int
    //   42	1100	5	k	int
    //   45	1063	6	m	int
    //   48	1081	7	n	int
    //   32	1058	8	i1	int
    //   215	880	9	bool	boolean
    //   63	806	10	localObject1	java.lang.Object
    //   57	418	11	localObject2	java.lang.Object
    //   60	710	12	localObject3	java.lang.Object
    //   21	1209	13	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	1182	14	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	1102	finally
    //   205	217	1102	finally
    //   229	241	1102	finally
    //   250	258	1102	finally
    //   270	284	1102	finally
    //   293	302	1102	finally
    //   311	326	1102	finally
    //   340	350	1102	finally
    //   359	368	1102	finally
    //   377	389	1102	finally
    //   401	413	1102	finally
    //   422	430	1102	finally
    //   442	454	1102	finally
    //   463	471	1102	finally
    //   487	501	1102	finally
    //   510	519	1102	finally
    //   528	543	1102	finally
    //   557	567	1102	finally
    //   576	585	1102	finally
    //   594	606	1102	finally
    //   618	629	1102	finally
    //   638	646	1102	finally
    //   658	669	1102	finally
    //   678	686	1102	finally
    //   698	709	1102	finally
    //   718	726	1102	finally
    //   738	749	1102	finally
    //   758	766	1102	finally
    //   782	792	1102	finally
    //   801	810	1102	finally
    //   819	834	1102	finally
    //   848	858	1102	finally
    //   867	876	1102	finally
    //   885	895	1102	finally
    //   907	917	1102	finally
    //   926	934	1102	finally
    //   946	956	1102	finally
    //   965	973	1102	finally
    //   995	1006	1102	finally
    //   1023	1041	1102	finally
    //   1056	1068	1102	finally
    //   1077	1085	1102	finally
    //   1111	1127	1102	finally
    //   1132	1138	1102	finally
    //   50	56	1106	java/io/IOException
    //   205	217	1106	java/io/IOException
    //   229	241	1106	java/io/IOException
    //   250	258	1106	java/io/IOException
    //   270	284	1106	java/io/IOException
    //   293	302	1106	java/io/IOException
    //   311	326	1106	java/io/IOException
    //   340	350	1106	java/io/IOException
    //   359	368	1106	java/io/IOException
    //   377	389	1106	java/io/IOException
    //   401	413	1106	java/io/IOException
    //   422	430	1106	java/io/IOException
    //   442	454	1106	java/io/IOException
    //   463	471	1106	java/io/IOException
    //   487	501	1106	java/io/IOException
    //   510	519	1106	java/io/IOException
    //   528	543	1106	java/io/IOException
    //   557	567	1106	java/io/IOException
    //   576	585	1106	java/io/IOException
    //   594	606	1106	java/io/IOException
    //   618	629	1106	java/io/IOException
    //   638	646	1106	java/io/IOException
    //   658	669	1106	java/io/IOException
    //   678	686	1106	java/io/IOException
    //   698	709	1106	java/io/IOException
    //   718	726	1106	java/io/IOException
    //   738	749	1106	java/io/IOException
    //   758	766	1106	java/io/IOException
    //   782	792	1106	java/io/IOException
    //   801	810	1106	java/io/IOException
    //   819	834	1106	java/io/IOException
    //   848	858	1106	java/io/IOException
    //   867	876	1106	java/io/IOException
    //   885	895	1106	java/io/IOException
    //   907	917	1106	java/io/IOException
    //   926	934	1106	java/io/IOException
    //   946	956	1106	java/io/IOException
    //   965	973	1106	java/io/IOException
    //   995	1006	1106	java/io/IOException
    //   1023	1041	1106	java/io/IOException
    //   1056	1068	1106	java/io/IOException
    //   1077	1085	1106	java/io/IOException
    //   50	56	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   205	217	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   229	241	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   250	258	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   270	284	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   293	302	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   311	326	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   340	350	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   359	368	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   377	389	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   401	413	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   422	430	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   442	454	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   463	471	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   487	501	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   510	519	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   528	543	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   557	567	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   576	585	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   594	606	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   618	629	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   638	646	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   658	669	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   678	686	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   698	709	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   718	726	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   738	749	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   758	766	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   782	792	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   801	810	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   819	834	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   848	858	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   867	876	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   885	895	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   907	917	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   926	934	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   946	956	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   965	973	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   995	1006	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1023	1041	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1056	1068	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1077	1085	1127	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   1157	1162	1174	finally
    //   1210	1215	1227	finally
    //   1157	1162	1244	java/io/IOException
    //   1210	1215	1248	java/io/IOException
  }
  
  private ProtoBuf$Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Type(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Type getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.argument_ = Collections.emptyList();
    this.nullable_ = false;
    this.flexibleTypeCapabilitiesId_ = 0;
    this.flexibleUpperBound_ = getDefaultInstance();
    this.flexibleUpperBoundId_ = 0;
    this.className_ = 0;
    this.typeParameter_ = 0;
    this.typeParameterName_ = 0;
    this.typeAliasName_ = 0;
    this.outerType_ = getDefaultInstance();
    this.outerTypeId_ = 0;
    this.abbreviatedType_ = getDefaultInstance();
    this.abbreviatedTypeId_ = 0;
    this.flags_ = 0;
  }
  
  public static ProtoBuf.Type.Builder newBuilder()
  {
    return ProtoBuf.Type.Builder.access$5700();
  }
  
  public static ProtoBuf.Type.Builder newBuilder(Type paramType)
  {
    return newBuilder().mergeFrom(paramType);
  }
  
  public Type getAbbreviatedType()
  {
    return this.abbreviatedType_;
  }
  
  public int getAbbreviatedTypeId()
  {
    return this.abbreviatedTypeId_;
  }
  
  public ProtoBuf.Type.Argument getArgument(int paramInt)
  {
    return (ProtoBuf.Type.Argument)this.argument_.get(paramInt);
  }
  
  public int getArgumentCount()
  {
    return this.argument_.size();
  }
  
  public List<ProtoBuf.Type.Argument> getArgumentList()
  {
    return this.argument_;
  }
  
  public int getClassName()
  {
    return this.className_;
  }
  
  public Type getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public int getFlexibleTypeCapabilitiesId()
  {
    return this.flexibleTypeCapabilitiesId_;
  }
  
  public Type getFlexibleUpperBound()
  {
    return this.flexibleUpperBound_;
  }
  
  public int getFlexibleUpperBoundId()
  {
    return this.flexibleUpperBoundId_;
  }
  
  public boolean getNullable()
  {
    return this.nullable_;
  }
  
  public Type getOuterType()
  {
    return this.outerType_;
  }
  
  public int getOuterTypeId()
  {
    return this.outerTypeId_;
  }
  
  public Parser<Type> getParserForType()
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
    int j = 0;
    if ((i & 0x1000) == 4096) {
      i = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
    } else {
      i = 0;
    }
    while (j < this.argument_.size())
    {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.argument_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x1) == 1) {
      j = i + CodedOutputStream.computeBoolSize(3, this.nullable_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
    }
    i = j;
    if ((this.bitField0_ & 0x10) == 16) {
      i = j + CodedOutputStream.computeInt32Size(6, this.className_);
    }
    j = i;
    if ((this.bitField0_ & 0x20) == 32) {
      j = i + CodedOutputStream.computeInt32Size(7, this.typeParameter_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
    }
    j = i;
    if ((this.bitField0_ & 0x40) == 64) {
      j = i + CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
    }
    i = j;
    if ((this.bitField0_ & 0x100) == 256) {
      i = j + CodedOutputStream.computeMessageSize(10, this.outerType_);
    }
    j = i;
    if ((this.bitField0_ & 0x200) == 512) {
      j = i + CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
    }
    i = j;
    if ((this.bitField0_ & 0x80) == 128) {
      i = j + CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
    }
    j = i;
    if ((this.bitField0_ & 0x400) == 1024) {
      j = i + CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
    }
    i = j;
    if ((this.bitField0_ & 0x800) == 2048) {
      i = j + CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
    }
    i = i + extensionsSerializedSize() + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getTypeAliasName()
  {
    return this.typeAliasName_;
  }
  
  public int getTypeParameter()
  {
    return this.typeParameter_;
  }
  
  public int getTypeParameterName()
  {
    return this.typeParameterName_;
  }
  
  public boolean hasAbbreviatedType()
  {
    return (this.bitField0_ & 0x400) == 1024;
  }
  
  public boolean hasAbbreviatedTypeId()
  {
    return (this.bitField0_ & 0x800) == 2048;
  }
  
  public boolean hasClassName()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasFlags()
  {
    return (this.bitField0_ & 0x1000) == 4096;
  }
  
  public boolean hasFlexibleTypeCapabilitiesId()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasFlexibleUpperBound()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasFlexibleUpperBoundId()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasNullable()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasOuterType()
  {
    return (this.bitField0_ & 0x100) == 256;
  }
  
  public boolean hasOuterTypeId()
  {
    return (this.bitField0_ & 0x200) == 512;
  }
  
  public boolean hasTypeAliasName()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public boolean hasTypeParameter()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasTypeParameterName()
  {
    return (this.bitField0_ & 0x40) == 64;
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
    while (i < getArgumentCount())
    {
      if (!getArgument(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if ((hasFlexibleUpperBound()) && (!getFlexibleUpperBound().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if ((hasOuterType()) && (!getOuterType().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if ((hasAbbreviatedType()) && (!getAbbreviatedType().isInitialized()))
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
  
  public ProtoBuf.Type.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Type.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    GeneratedMessageLite.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1000) == 4096) {
      paramCodedOutputStream.writeInt32(1, this.flags_);
    }
    int i = 0;
    while (i < this.argument_.size())
    {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.argument_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeBool(3, this.nullable_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeMessage(5, this.flexibleUpperBound_);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeInt32(6, this.className_);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeInt32(7, this.typeParameter_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
    }
    if ((this.bitField0_ & 0x40) == 64) {
      paramCodedOutputStream.writeInt32(9, this.typeParameterName_);
    }
    if ((this.bitField0_ & 0x100) == 256) {
      paramCodedOutputStream.writeMessage(10, this.outerType_);
    }
    if ((this.bitField0_ & 0x200) == 512) {
      paramCodedOutputStream.writeInt32(11, this.outerTypeId_);
    }
    if ((this.bitField0_ & 0x80) == 128) {
      paramCodedOutputStream.writeInt32(12, this.typeAliasName_);
    }
    if ((this.bitField0_ & 0x400) == 1024) {
      paramCodedOutputStream.writeMessage(13, this.abbreviatedType_);
    }
    if ((this.bitField0_ & 0x800) == 2048) {
      paramCodedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
    }
    localExtensionWriter.writeUntil(200, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type
 * JD-Core Version:    0.7.0.1
 */