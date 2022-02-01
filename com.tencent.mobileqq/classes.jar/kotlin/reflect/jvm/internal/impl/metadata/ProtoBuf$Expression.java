package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$Expression
  extends GeneratedMessageLite
  implements ProtoBuf.ExpressionOrBuilder
{
  public static Parser<Expression> PARSER = new ProtoBuf.Expression.1();
  private static final Expression defaultInstance = new Expression(true);
  private List<Expression> andArgument_;
  private int bitField0_;
  private ProtoBuf.Expression.ConstantValue constantValue_;
  private int flags_;
  private int isInstanceTypeId_;
  private ProtoBuf.Type isInstanceType_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private List<Expression> orArgument_;
  private final ByteString unknownFields;
  private int valueParameterReference_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Expression(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 53	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 55	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 57	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 46	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:initFields	()V
    //   18: invokestatic 63	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 11
    //   23: aload 11
    //   25: iconst_1
    //   26: invokestatic 69	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 12
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +721 -> 759
    //   41: iload_3
    //   42: istore 4
    //   44: iload_3
    //   45: istore 6
    //   47: iload_3
    //   48: istore 7
    //   50: aload_1
    //   51: invokevirtual 75	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 5
    //   56: iload 5
    //   58: ifeq +582 -> 640
    //   61: iload 5
    //   63: bipush 8
    //   65: if_icmpeq +536 -> 601
    //   68: iload 5
    //   70: bipush 16
    //   72: if_icmpeq +490 -> 562
    //   75: iload 5
    //   77: bipush 24
    //   79: if_icmpeq +375 -> 454
    //   82: iload 5
    //   84: bipush 34
    //   86: if_icmpeq +237 -> 323
    //   89: iload 5
    //   91: bipush 40
    //   93: if_icmpeq +190 -> 283
    //   96: iload 5
    //   98: bipush 50
    //   100: if_icmpeq +109 -> 209
    //   103: iload 5
    //   105: bipush 58
    //   107: if_icmpeq +28 -> 135
    //   110: iload_3
    //   111: istore 4
    //   113: iload_3
    //   114: istore 6
    //   116: iload_3
    //   117: istore 7
    //   119: aload_0
    //   120: aload_1
    //   121: aload 12
    //   123: aload_2
    //   124: iload 5
    //   126: invokevirtual 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   129: ifne -93 -> 36
    //   132: goto +508 -> 640
    //   135: iload_3
    //   136: istore 5
    //   138: iload_3
    //   139: bipush 64
    //   141: iand
    //   142: bipush 64
    //   144: if_icmpeq +29 -> 173
    //   147: iload_3
    //   148: istore 4
    //   150: iload_3
    //   151: istore 6
    //   153: iload_3
    //   154: istore 7
    //   156: aload_0
    //   157: new 81	java/util/ArrayList
    //   160: dup
    //   161: invokespecial 82	java/util/ArrayList:<init>	()V
    //   164: putfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:orArgument_	Ljava/util/List;
    //   167: iload_3
    //   168: bipush 64
    //   170: ior
    //   171: istore 5
    //   173: iload 5
    //   175: istore 4
    //   177: iload 5
    //   179: istore 6
    //   181: iload 5
    //   183: istore 7
    //   185: aload_0
    //   186: getfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:orArgument_	Ljava/util/List;
    //   189: aload_1
    //   190: getstatic 38	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   193: aload_2
    //   194: invokevirtual 88	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   197: invokeinterface 94 2 0
    //   202: pop
    //   203: iload 5
    //   205: istore_3
    //   206: goto -170 -> 36
    //   209: iload_3
    //   210: istore 5
    //   212: iload_3
    //   213: bipush 32
    //   215: iand
    //   216: bipush 32
    //   218: if_icmpeq +29 -> 247
    //   221: iload_3
    //   222: istore 4
    //   224: iload_3
    //   225: istore 6
    //   227: iload_3
    //   228: istore 7
    //   230: aload_0
    //   231: new 81	java/util/ArrayList
    //   234: dup
    //   235: invokespecial 82	java/util/ArrayList:<init>	()V
    //   238: putfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:andArgument_	Ljava/util/List;
    //   241: iload_3
    //   242: bipush 32
    //   244: ior
    //   245: istore 5
    //   247: iload 5
    //   249: istore 4
    //   251: iload 5
    //   253: istore 6
    //   255: iload 5
    //   257: istore 7
    //   259: aload_0
    //   260: getfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:andArgument_	Ljava/util/List;
    //   263: aload_1
    //   264: getstatic 38	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   267: aload_2
    //   268: invokevirtual 88	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   271: invokeinterface 94 2 0
    //   276: pop
    //   277: iload 5
    //   279: istore_3
    //   280: goto -244 -> 36
    //   283: iload_3
    //   284: istore 4
    //   286: iload_3
    //   287: istore 6
    //   289: iload_3
    //   290: istore 7
    //   292: aload_0
    //   293: aload_0
    //   294: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   297: bipush 16
    //   299: ior
    //   300: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   303: iload_3
    //   304: istore 4
    //   306: iload_3
    //   307: istore 6
    //   309: iload_3
    //   310: istore 7
    //   312: aload_0
    //   313: aload_1
    //   314: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   317: putfield 103	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:isInstanceTypeId_	I
    //   320: goto -284 -> 36
    //   323: aconst_null
    //   324: astore 10
    //   326: iload_3
    //   327: istore 4
    //   329: iload_3
    //   330: istore 6
    //   332: iload_3
    //   333: istore 7
    //   335: aload_0
    //   336: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   339: bipush 8
    //   341: iand
    //   342: bipush 8
    //   344: if_icmpne +21 -> 365
    //   347: iload_3
    //   348: istore 4
    //   350: iload_3
    //   351: istore 6
    //   353: iload_3
    //   354: istore 7
    //   356: aload_0
    //   357: getfield 105	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:isInstanceType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   360: invokevirtual 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   363: astore 10
    //   365: iload_3
    //   366: istore 4
    //   368: iload_3
    //   369: istore 6
    //   371: iload_3
    //   372: istore 7
    //   374: aload_0
    //   375: aload_1
    //   376: getstatic 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   379: aload_2
    //   380: invokevirtual 88	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   383: checkcast 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   386: putfield 105	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:isInstanceType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   389: aload 10
    //   391: ifnull +40 -> 431
    //   394: iload_3
    //   395: istore 4
    //   397: iload_3
    //   398: istore 6
    //   400: iload_3
    //   401: istore 7
    //   403: aload 10
    //   405: aload_0
    //   406: getfield 105	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:isInstanceType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   409: invokevirtual 118	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   412: pop
    //   413: iload_3
    //   414: istore 4
    //   416: iload_3
    //   417: istore 6
    //   419: iload_3
    //   420: istore 7
    //   422: aload_0
    //   423: aload 10
    //   425: invokevirtual 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   428: putfield 105	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:isInstanceType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   431: iload_3
    //   432: istore 4
    //   434: iload_3
    //   435: istore 6
    //   437: iload_3
    //   438: istore 7
    //   440: aload_0
    //   441: aload_0
    //   442: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   445: bipush 8
    //   447: ior
    //   448: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   451: goto -415 -> 36
    //   454: iload_3
    //   455: istore 4
    //   457: iload_3
    //   458: istore 6
    //   460: iload_3
    //   461: istore 7
    //   463: aload_1
    //   464: invokevirtual 125	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   467: istore 9
    //   469: iload_3
    //   470: istore 4
    //   472: iload_3
    //   473: istore 6
    //   475: iload_3
    //   476: istore 7
    //   478: iload 9
    //   480: invokestatic 131	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$ConstantValue:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$ConstantValue;
    //   483: astore 10
    //   485: aload 10
    //   487: ifnonnull +38 -> 525
    //   490: iload_3
    //   491: istore 4
    //   493: iload_3
    //   494: istore 6
    //   496: iload_3
    //   497: istore 7
    //   499: aload 12
    //   501: iload 5
    //   503: invokevirtual 135	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   506: iload_3
    //   507: istore 4
    //   509: iload_3
    //   510: istore 6
    //   512: iload_3
    //   513: istore 7
    //   515: aload 12
    //   517: iload 9
    //   519: invokevirtual 135	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   522: goto -486 -> 36
    //   525: iload_3
    //   526: istore 4
    //   528: iload_3
    //   529: istore 6
    //   531: iload_3
    //   532: istore 7
    //   534: aload_0
    //   535: aload_0
    //   536: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   539: iconst_4
    //   540: ior
    //   541: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   544: iload_3
    //   545: istore 4
    //   547: iload_3
    //   548: istore 6
    //   550: iload_3
    //   551: istore 7
    //   553: aload_0
    //   554: aload 10
    //   556: putfield 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:constantValue_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$ConstantValue;
    //   559: goto -523 -> 36
    //   562: iload_3
    //   563: istore 4
    //   565: iload_3
    //   566: istore 6
    //   568: iload_3
    //   569: istore 7
    //   571: aload_0
    //   572: aload_0
    //   573: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   576: iconst_2
    //   577: ior
    //   578: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   581: iload_3
    //   582: istore 4
    //   584: iload_3
    //   585: istore 6
    //   587: iload_3
    //   588: istore 7
    //   590: aload_0
    //   591: aload_1
    //   592: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   595: putfield 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:valueParameterReference_	I
    //   598: goto -562 -> 36
    //   601: iload_3
    //   602: istore 4
    //   604: iload_3
    //   605: istore 6
    //   607: iload_3
    //   608: istore 7
    //   610: aload_0
    //   611: aload_0
    //   612: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   615: iconst_1
    //   616: ior
    //   617: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:bitField0_	I
    //   620: iload_3
    //   621: istore 4
    //   623: iload_3
    //   624: istore 6
    //   626: iload_3
    //   627: istore 7
    //   629: aload_0
    //   630: aload_1
    //   631: invokevirtual 101	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   634: putfield 141	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:flags_	I
    //   637: goto -601 -> 36
    //   640: iconst_1
    //   641: istore 8
    //   643: goto -607 -> 36
    //   646: astore_1
    //   647: goto +35 -> 682
    //   650: astore_1
    //   651: iload 6
    //   653: istore 4
    //   655: new 50	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   658: dup
    //   659: aload_1
    //   660: invokevirtual 145	java/io/IOException:getMessage	()Ljava/lang/String;
    //   663: invokespecial 148	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   666: aload_0
    //   667: invokevirtual 152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   670: athrow
    //   671: astore_1
    //   672: iload 7
    //   674: istore 4
    //   676: aload_1
    //   677: aload_0
    //   678: invokevirtual 152	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   681: athrow
    //   682: iload 4
    //   684: bipush 32
    //   686: iand
    //   687: bipush 32
    //   689: if_icmpne +14 -> 703
    //   692: aload_0
    //   693: aload_0
    //   694: getfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:andArgument_	Ljava/util/List;
    //   697: invokestatic 158	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   700: putfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:andArgument_	Ljava/util/List;
    //   703: iload 4
    //   705: bipush 64
    //   707: iand
    //   708: bipush 64
    //   710: if_icmpne +14 -> 724
    //   713: aload_0
    //   714: aload_0
    //   715: getfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:orArgument_	Ljava/util/List;
    //   718: invokestatic 158	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   721: putfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:orArgument_	Ljava/util/List;
    //   724: aload 12
    //   726: invokevirtual 161	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   729: aload_0
    //   730: aload 11
    //   732: invokevirtual 167	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   735: putfield 169	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   738: goto +15 -> 753
    //   741: astore_1
    //   742: aload_0
    //   743: aload 11
    //   745: invokevirtual 167	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   748: putfield 169	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   751: aload_1
    //   752: athrow
    //   753: aload_0
    //   754: invokevirtual 172	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:makeExtensionsImmutable	()V
    //   757: aload_1
    //   758: athrow
    //   759: iload_3
    //   760: bipush 32
    //   762: iand
    //   763: bipush 32
    //   765: if_icmpne +14 -> 779
    //   768: aload_0
    //   769: aload_0
    //   770: getfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:andArgument_	Ljava/util/List;
    //   773: invokestatic 158	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   776: putfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:andArgument_	Ljava/util/List;
    //   779: iload_3
    //   780: bipush 64
    //   782: iand
    //   783: bipush 64
    //   785: if_icmpne +14 -> 799
    //   788: aload_0
    //   789: aload_0
    //   790: getfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:orArgument_	Ljava/util/List;
    //   793: invokestatic 158	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   796: putfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:orArgument_	Ljava/util/List;
    //   799: aload 12
    //   801: invokevirtual 161	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   804: aload_0
    //   805: aload 11
    //   807: invokevirtual 167	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   810: putfield 169	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   813: goto +15 -> 828
    //   816: astore_1
    //   817: aload_0
    //   818: aload 11
    //   820: invokevirtual 167	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   823: putfield 169	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   826: aload_1
    //   827: athrow
    //   828: aload_0
    //   829: invokevirtual 172	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:makeExtensionsImmutable	()V
    //   832: return
    //   833: astore_2
    //   834: goto -105 -> 729
    //   837: astore_1
    //   838: goto -34 -> 804
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	Expression
    //   0	841	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	841	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	748	3	i	int
    //   42	666	4	j	int
    //   54	448	5	k	int
    //   45	607	6	m	int
    //   48	625	7	n	int
    //   32	610	8	i1	int
    //   467	51	9	i2	int
    //   324	231	10	localObject	java.lang.Object
    //   21	798	11	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	771	12	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	646	finally
    //   119	132	646	finally
    //   156	167	646	finally
    //   185	203	646	finally
    //   230	241	646	finally
    //   259	277	646	finally
    //   292	303	646	finally
    //   312	320	646	finally
    //   335	347	646	finally
    //   356	365	646	finally
    //   374	389	646	finally
    //   403	413	646	finally
    //   422	431	646	finally
    //   440	451	646	finally
    //   463	469	646	finally
    //   478	485	646	finally
    //   499	506	646	finally
    //   515	522	646	finally
    //   534	544	646	finally
    //   553	559	646	finally
    //   571	581	646	finally
    //   590	598	646	finally
    //   610	620	646	finally
    //   629	637	646	finally
    //   655	671	646	finally
    //   676	682	646	finally
    //   50	56	650	java/io/IOException
    //   119	132	650	java/io/IOException
    //   156	167	650	java/io/IOException
    //   185	203	650	java/io/IOException
    //   230	241	650	java/io/IOException
    //   259	277	650	java/io/IOException
    //   292	303	650	java/io/IOException
    //   312	320	650	java/io/IOException
    //   335	347	650	java/io/IOException
    //   356	365	650	java/io/IOException
    //   374	389	650	java/io/IOException
    //   403	413	650	java/io/IOException
    //   422	431	650	java/io/IOException
    //   440	451	650	java/io/IOException
    //   463	469	650	java/io/IOException
    //   478	485	650	java/io/IOException
    //   499	506	650	java/io/IOException
    //   515	522	650	java/io/IOException
    //   534	544	650	java/io/IOException
    //   553	559	650	java/io/IOException
    //   571	581	650	java/io/IOException
    //   590	598	650	java/io/IOException
    //   610	620	650	java/io/IOException
    //   629	637	650	java/io/IOException
    //   50	56	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   119	132	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   156	167	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   185	203	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   230	241	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   259	277	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   292	303	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   312	320	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   335	347	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   356	365	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   374	389	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   403	413	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   422	431	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   440	451	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   463	469	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   478	485	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   499	506	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   515	522	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   534	544	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   553	559	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   571	581	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   590	598	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   610	620	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   629	637	671	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   724	729	741	finally
    //   799	804	816	finally
    //   724	729	833	java/io/IOException
    //   799	804	837	java/io/IOException
  }
  
  private ProtoBuf$Expression(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Expression(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Expression getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.flags_ = 0;
    this.valueParameterReference_ = 0;
    this.constantValue_ = ProtoBuf.Expression.ConstantValue.TRUE;
    this.isInstanceType_ = ProtoBuf.Type.getDefaultInstance();
    this.isInstanceTypeId_ = 0;
    this.andArgument_ = Collections.emptyList();
    this.orArgument_ = Collections.emptyList();
  }
  
  public static ProtoBuf.Expression.Builder newBuilder()
  {
    return ProtoBuf.Expression.Builder.access$23700();
  }
  
  public static ProtoBuf.Expression.Builder newBuilder(Expression paramExpression)
  {
    return newBuilder().mergeFrom(paramExpression);
  }
  
  public Expression getAndArgument(int paramInt)
  {
    return (Expression)this.andArgument_.get(paramInt);
  }
  
  public int getAndArgumentCount()
  {
    return this.andArgument_.size();
  }
  
  public ProtoBuf.Expression.ConstantValue getConstantValue()
  {
    return this.constantValue_;
  }
  
  public Expression getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public ProtoBuf.Type getIsInstanceType()
  {
    return this.isInstanceType_;
  }
  
  public int getIsInstanceTypeId()
  {
    return this.isInstanceTypeId_;
  }
  
  public Expression getOrArgument(int paramInt)
  {
    return (Expression)this.orArgument_.get(paramInt);
  }
  
  public int getOrArgumentCount()
  {
    return this.orArgument_.size();
  }
  
  public Parser<Expression> getParserForType()
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
    int n = 0;
    if ((i & 0x1) == 1) {
      j = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
    }
    int j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
    }
    i = j;
    j = 0;
    int k;
    int m;
    for (;;)
    {
      k = i;
      m = n;
      if (j >= this.andArgument_.size()) {
        break;
      }
      i += CodedOutputStream.computeMessageSize(6, (MessageLite)this.andArgument_.get(j));
      j += 1;
    }
    while (m < this.orArgument_.size())
    {
      k += CodedOutputStream.computeMessageSize(7, (MessageLite)this.orArgument_.get(m));
      m += 1;
    }
    i = k + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getValueParameterReference()
  {
    return this.valueParameterReference_;
  }
  
  public boolean hasConstantValue()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasFlags()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasIsInstanceType()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasIsInstanceTypeId()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasValueParameterReference()
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
    if ((hasIsInstanceType()) && (!getIsInstanceType().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    i = 0;
    while (i < getAndArgumentCount())
    {
      if (!getAndArgument(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getOrArgumentCount())
    {
      if (!getOrArgument(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Expression.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Expression.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.flags_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(2, this.valueParameterReference_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeEnum(3, this.constantValue_.getNumber());
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeMessage(4, this.isInstanceType_);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeInt32(5, this.isInstanceTypeId_);
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.andArgument_.size()) {
        break;
      }
      paramCodedOutputStream.writeMessage(6, (MessageLite)this.andArgument_.get(i));
      i += 1;
    }
    while (j < this.orArgument_.size())
    {
      paramCodedOutputStream.writeMessage(7, (MessageLite)this.orArgument_.get(j));
      j += 1;
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression
 * JD-Core Version:    0.7.0.1
 */