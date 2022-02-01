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

public final class ProtoBuf$Constructor
  extends GeneratedMessageLite.ExtendableMessage<Constructor>
  implements ProtoBuf.ConstructorOrBuilder
{
  public static Parser<Constructor> PARSER = new ProtoBuf.Constructor.1();
  private static final Constructor defaultInstance = new Constructor(true);
  private int bitField0_;
  private int flags_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private final ByteString unknownFields;
  private List<ProtoBuf.ValueParameter> valueParameter_;
  private List<Integer> versionRequirement_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Constructor(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 49	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 51	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 53	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 42	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:initFields	()V
    //   18: invokestatic 59	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 10
    //   23: aload 10
    //   25: iconst_1
    //   26: invokestatic 65	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 11
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +521 -> 559
    //   41: iload_3
    //   42: istore 4
    //   44: iload_3
    //   45: istore 5
    //   47: iload_3
    //   48: istore 6
    //   50: aload_1
    //   51: invokevirtual 71	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 7
    //   56: iload 7
    //   58: ifeq +386 -> 444
    //   61: iload 7
    //   63: bipush 8
    //   65: if_icmpeq +340 -> 405
    //   68: iload 7
    //   70: bipush 18
    //   72: if_icmpeq +262 -> 334
    //   75: iload 7
    //   77: sipush 248
    //   80: if_icmpeq +184 -> 264
    //   83: iload 7
    //   85: sipush 250
    //   88: if_icmpeq +28 -> 116
    //   91: iload_3
    //   92: istore 4
    //   94: iload_3
    //   95: istore 5
    //   97: iload_3
    //   98: istore 6
    //   100: aload_0
    //   101: aload_1
    //   102: aload 11
    //   104: aload_2
    //   105: iload 7
    //   107: invokevirtual 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   110: ifne -74 -> 36
    //   113: goto +331 -> 444
    //   116: iload_3
    //   117: istore 4
    //   119: iload_3
    //   120: istore 5
    //   122: iload_3
    //   123: istore 6
    //   125: aload_1
    //   126: aload_1
    //   127: invokevirtual 78	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   130: invokevirtual 82	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   133: istore 9
    //   135: iload_3
    //   136: istore 7
    //   138: iload_3
    //   139: iconst_4
    //   140: iand
    //   141: iconst_4
    //   142: if_icmpeq +47 -> 189
    //   145: iload_3
    //   146: istore 7
    //   148: iload_3
    //   149: istore 4
    //   151: iload_3
    //   152: istore 5
    //   154: iload_3
    //   155: istore 6
    //   157: aload_1
    //   158: invokevirtual 85	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   161: ifle +28 -> 189
    //   164: iload_3
    //   165: istore 4
    //   167: iload_3
    //   168: istore 5
    //   170: iload_3
    //   171: istore 6
    //   173: aload_0
    //   174: new 87	java/util/ArrayList
    //   177: dup
    //   178: invokespecial 88	java/util/ArrayList:<init>	()V
    //   181: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:versionRequirement_	Ljava/util/List;
    //   184: iload_3
    //   185: iconst_4
    //   186: ior
    //   187: istore 7
    //   189: iload 7
    //   191: istore 4
    //   193: iload 7
    //   195: istore 5
    //   197: iload 7
    //   199: istore 6
    //   201: aload_1
    //   202: invokevirtual 85	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   205: ifle +35 -> 240
    //   208: iload 7
    //   210: istore 4
    //   212: iload 7
    //   214: istore 5
    //   216: iload 7
    //   218: istore 6
    //   220: aload_0
    //   221: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:versionRequirement_	Ljava/util/List;
    //   224: aload_1
    //   225: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   228: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: invokeinterface 105 2 0
    //   236: pop
    //   237: goto -48 -> 189
    //   240: iload 7
    //   242: istore 4
    //   244: iload 7
    //   246: istore 5
    //   248: iload 7
    //   250: istore 6
    //   252: aload_1
    //   253: iload 9
    //   255: invokevirtual 109	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   258: iload 7
    //   260: istore_3
    //   261: goto -225 -> 36
    //   264: iload_3
    //   265: istore 7
    //   267: iload_3
    //   268: iconst_4
    //   269: iand
    //   270: iconst_4
    //   271: if_icmpeq +28 -> 299
    //   274: iload_3
    //   275: istore 4
    //   277: iload_3
    //   278: istore 5
    //   280: iload_3
    //   281: istore 6
    //   283: aload_0
    //   284: new 87	java/util/ArrayList
    //   287: dup
    //   288: invokespecial 88	java/util/ArrayList:<init>	()V
    //   291: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:versionRequirement_	Ljava/util/List;
    //   294: iload_3
    //   295: iconst_4
    //   296: ior
    //   297: istore 7
    //   299: iload 7
    //   301: istore 4
    //   303: iload 7
    //   305: istore 5
    //   307: iload 7
    //   309: istore 6
    //   311: aload_0
    //   312: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:versionRequirement_	Ljava/util/List;
    //   315: aload_1
    //   316: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   319: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   322: invokeinterface 105 2 0
    //   327: pop
    //   328: iload 7
    //   330: istore_3
    //   331: goto -295 -> 36
    //   334: iload_3
    //   335: istore 7
    //   337: iload_3
    //   338: iconst_2
    //   339: iand
    //   340: iconst_2
    //   341: if_icmpeq +28 -> 369
    //   344: iload_3
    //   345: istore 4
    //   347: iload_3
    //   348: istore 5
    //   350: iload_3
    //   351: istore 6
    //   353: aload_0
    //   354: new 87	java/util/ArrayList
    //   357: dup
    //   358: invokespecial 88	java/util/ArrayList:<init>	()V
    //   361: putfield 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:valueParameter_	Ljava/util/List;
    //   364: iload_3
    //   365: iconst_2
    //   366: ior
    //   367: istore 7
    //   369: iload 7
    //   371: istore 4
    //   373: iload 7
    //   375: istore 5
    //   377: iload 7
    //   379: istore 6
    //   381: aload_0
    //   382: getfield 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:valueParameter_	Ljava/util/List;
    //   385: aload_1
    //   386: getstatic 114	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   389: aload_2
    //   390: invokevirtual 118	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   393: invokeinterface 105 2 0
    //   398: pop
    //   399: iload 7
    //   401: istore_3
    //   402: goto -366 -> 36
    //   405: iload_3
    //   406: istore 4
    //   408: iload_3
    //   409: istore 5
    //   411: iload_3
    //   412: istore 6
    //   414: aload_0
    //   415: aload_0
    //   416: getfield 120	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:bitField0_	I
    //   419: iconst_1
    //   420: ior
    //   421: putfield 120	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:bitField0_	I
    //   424: iload_3
    //   425: istore 4
    //   427: iload_3
    //   428: istore 5
    //   430: iload_3
    //   431: istore 6
    //   433: aload_0
    //   434: aload_1
    //   435: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   438: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:flags_	I
    //   441: goto -405 -> 36
    //   444: iconst_1
    //   445: istore 8
    //   447: goto -411 -> 36
    //   450: astore_1
    //   451: goto +35 -> 486
    //   454: astore_1
    //   455: iload 5
    //   457: istore 4
    //   459: new 46	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   462: dup
    //   463: aload_1
    //   464: invokevirtual 126	java/io/IOException:getMessage	()Ljava/lang/String;
    //   467: invokespecial 129	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   470: aload_0
    //   471: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   474: athrow
    //   475: astore_1
    //   476: iload 6
    //   478: istore 4
    //   480: aload_1
    //   481: aload_0
    //   482: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   485: athrow
    //   486: iload 4
    //   488: iconst_2
    //   489: iand
    //   490: iconst_2
    //   491: if_icmpne +14 -> 505
    //   494: aload_0
    //   495: aload_0
    //   496: getfield 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:valueParameter_	Ljava/util/List;
    //   499: invokestatic 139	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   502: putfield 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:valueParameter_	Ljava/util/List;
    //   505: iload 4
    //   507: iconst_4
    //   508: iand
    //   509: iconst_4
    //   510: if_icmpne +14 -> 524
    //   513: aload_0
    //   514: aload_0
    //   515: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:versionRequirement_	Ljava/util/List;
    //   518: invokestatic 139	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   521: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:versionRequirement_	Ljava/util/List;
    //   524: aload 11
    //   526: invokevirtual 142	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   529: aload_0
    //   530: aload 10
    //   532: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   535: putfield 150	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   538: goto +15 -> 553
    //   541: astore_1
    //   542: aload_0
    //   543: aload 10
    //   545: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   548: putfield 150	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   551: aload_1
    //   552: athrow
    //   553: aload_0
    //   554: invokevirtual 153	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:makeExtensionsImmutable	()V
    //   557: aload_1
    //   558: athrow
    //   559: iload_3
    //   560: iconst_2
    //   561: iand
    //   562: iconst_2
    //   563: if_icmpne +14 -> 577
    //   566: aload_0
    //   567: aload_0
    //   568: getfield 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:valueParameter_	Ljava/util/List;
    //   571: invokestatic 139	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   574: putfield 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:valueParameter_	Ljava/util/List;
    //   577: iload_3
    //   578: iconst_4
    //   579: iand
    //   580: iconst_4
    //   581: if_icmpne +14 -> 595
    //   584: aload_0
    //   585: aload_0
    //   586: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:versionRequirement_	Ljava/util/List;
    //   589: invokestatic 139	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   592: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:versionRequirement_	Ljava/util/List;
    //   595: aload 11
    //   597: invokevirtual 142	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   600: aload_0
    //   601: aload 10
    //   603: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   606: putfield 150	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   609: goto +15 -> 624
    //   612: astore_1
    //   613: aload_0
    //   614: aload 10
    //   616: invokevirtual 148	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   619: putfield 150	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   622: aload_1
    //   623: athrow
    //   624: aload_0
    //   625: invokevirtual 153	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:makeExtensionsImmutable	()V
    //   628: return
    //   629: astore_2
    //   630: goto -101 -> 529
    //   633: astore_1
    //   634: goto -34 -> 600
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	Constructor
    //   0	637	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	637	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	545	3	i	int
    //   42	467	4	j	int
    //   45	411	5	k	int
    //   48	429	6	m	int
    //   54	346	7	n	int
    //   32	414	8	i1	int
    //   133	121	9	i2	int
    //   21	594	10	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	567	11	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	450	finally
    //   100	113	450	finally
    //   125	135	450	finally
    //   157	164	450	finally
    //   173	184	450	finally
    //   201	208	450	finally
    //   220	237	450	finally
    //   252	258	450	finally
    //   283	294	450	finally
    //   311	328	450	finally
    //   353	364	450	finally
    //   381	399	450	finally
    //   414	424	450	finally
    //   433	441	450	finally
    //   459	475	450	finally
    //   480	486	450	finally
    //   50	56	454	java/io/IOException
    //   100	113	454	java/io/IOException
    //   125	135	454	java/io/IOException
    //   157	164	454	java/io/IOException
    //   173	184	454	java/io/IOException
    //   201	208	454	java/io/IOException
    //   220	237	454	java/io/IOException
    //   252	258	454	java/io/IOException
    //   283	294	454	java/io/IOException
    //   311	328	454	java/io/IOException
    //   353	364	454	java/io/IOException
    //   381	399	454	java/io/IOException
    //   414	424	454	java/io/IOException
    //   433	441	454	java/io/IOException
    //   50	56	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   100	113	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   125	135	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   157	164	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   173	184	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   201	208	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   220	237	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   252	258	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   283	294	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   311	328	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   353	364	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   381	399	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   414	424	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   433	441	475	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   524	529	541	finally
    //   595	600	612	finally
    //   524	529	629	java/io/IOException
    //   595	600	633	java/io/IOException
  }
  
  private ProtoBuf$Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Constructor(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Constructor getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.flags_ = 6;
    this.valueParameter_ = Collections.emptyList();
    this.versionRequirement_ = Collections.emptyList();
  }
  
  public static ProtoBuf.Constructor.Builder newBuilder()
  {
    return ProtoBuf.Constructor.Builder.access$12500();
  }
  
  public static ProtoBuf.Constructor.Builder newBuilder(Constructor paramConstructor)
  {
    return newBuilder().mergeFrom(paramConstructor);
  }
  
  public Constructor getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public Parser<Constructor> getParserForType()
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
    int j = 0;
    while (j < this.valueParameter_.size())
    {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.valueParameter_.get(j));
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
  
  public boolean hasFlags()
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
    if (!extensionsAreInitialized())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Constructor.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Constructor.Builder toBuilder()
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
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.valueParameter_.size()) {
        break;
      }
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.valueParameter_.get(i));
      i += 1;
    }
    while (j < this.versionRequirement_.size())
    {
      paramCodedOutputStream.writeInt32(31, ((Integer)this.versionRequirement_.get(j)).intValue());
      j += 1;
    }
    localExtensionWriter.writeUntil(19000, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor
 * JD-Core Version:    0.7.0.1
 */