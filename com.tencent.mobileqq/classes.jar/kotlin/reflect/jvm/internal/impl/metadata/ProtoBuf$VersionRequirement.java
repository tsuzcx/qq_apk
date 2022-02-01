package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$VersionRequirement
  extends GeneratedMessageLite
  implements ProtoBuf.VersionRequirementOrBuilder
{
  public static Parser<VersionRequirement> PARSER = new ProtoBuf.VersionRequirement.1();
  private static final VersionRequirement defaultInstance = new VersionRequirement(true);
  private int bitField0_;
  private int errorCode_;
  private ProtoBuf.VersionRequirement.Level level_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int message_;
  private final ByteString unknownFields;
  private int versionFull_;
  private ProtoBuf.VersionRequirement.VersionKind versionKind_;
  private int version_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$VersionRequirement(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 50	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 52	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 54	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 43	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:initFields	()V
    //   18: invokestatic 60	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 6
    //   23: aload 6
    //   25: iconst_1
    //   26: invokestatic 66	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 7
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +335 -> 369
    //   37: aload_1
    //   38: invokevirtual 72	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +256 -> 301
    //   48: iload 4
    //   50: bipush 8
    //   52: if_icmpeq +228 -> 280
    //   55: iload 4
    //   57: bipush 16
    //   59: if_icmpeq +200 -> 259
    //   62: iload 4
    //   64: bipush 24
    //   66: if_icmpeq +139 -> 205
    //   69: iload 4
    //   71: bipush 32
    //   73: if_icmpeq +110 -> 183
    //   76: iload 4
    //   78: bipush 40
    //   80: if_icmpeq +81 -> 161
    //   83: iload 4
    //   85: bipush 48
    //   87: if_icmpeq +19 -> 106
    //   90: aload_0
    //   91: aload_1
    //   92: aload 7
    //   94: aload_2
    //   95: iload 4
    //   97: invokevirtual 76	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   100: ifne -67 -> 33
    //   103: goto +198 -> 301
    //   106: aload_1
    //   107: invokevirtual 79	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   110: istore 5
    //   112: iload 5
    //   114: invokestatic 85	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$VersionKind:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$VersionKind;
    //   117: astore 8
    //   119: aload 8
    //   121: ifnonnull +20 -> 141
    //   124: aload 7
    //   126: iload 4
    //   128: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   131: aload 7
    //   133: iload 5
    //   135: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   138: goto -105 -> 33
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   146: bipush 32
    //   148: ior
    //   149: putfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   152: aload_0
    //   153: aload 8
    //   155: putfield 93	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:versionKind_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$VersionKind;
    //   158: goto -125 -> 33
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   166: bipush 16
    //   168: ior
    //   169: putfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 96	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   177: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:message_	I
    //   180: goto -147 -> 33
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   188: bipush 8
    //   190: ior
    //   191: putfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   194: aload_0
    //   195: aload_1
    //   196: invokevirtual 96	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   199: putfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:errorCode_	I
    //   202: goto -169 -> 33
    //   205: aload_1
    //   206: invokevirtual 79	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   209: istore 5
    //   211: iload 5
    //   213: invokestatic 105	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$Level:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$Level;
    //   216: astore 8
    //   218: aload 8
    //   220: ifnonnull +20 -> 240
    //   223: aload 7
    //   225: iload 4
    //   227: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   230: aload 7
    //   232: iload 5
    //   234: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   237: goto -204 -> 33
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   245: iconst_4
    //   246: ior
    //   247: putfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   250: aload_0
    //   251: aload 8
    //   253: putfield 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:level_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement$Level;
    //   256: goto -223 -> 33
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   264: iconst_2
    //   265: ior
    //   266: putfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   269: aload_0
    //   270: aload_1
    //   271: invokevirtual 96	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   274: putfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:versionFull_	I
    //   277: goto -244 -> 33
    //   280: aload_0
    //   281: aload_0
    //   282: getfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   285: iconst_1
    //   286: ior
    //   287: putfield 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:bitField0_	I
    //   290: aload_0
    //   291: aload_1
    //   292: invokevirtual 96	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   295: putfield 111	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:version_	I
    //   298: goto -265 -> 33
    //   301: iconst_1
    //   302: istore_3
    //   303: goto -270 -> 33
    //   306: astore_1
    //   307: goto +27 -> 334
    //   310: astore_1
    //   311: new 47	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   314: dup
    //   315: aload_1
    //   316: invokevirtual 115	java/io/IOException:getMessage	()Ljava/lang/String;
    //   319: invokespecial 118	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   322: aload_0
    //   323: invokevirtual 122	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   326: athrow
    //   327: astore_1
    //   328: aload_1
    //   329: aload_0
    //   330: invokevirtual 122	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   333: athrow
    //   334: aload 7
    //   336: invokevirtual 125	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   339: aload_0
    //   340: aload 6
    //   342: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   345: putfield 133	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   348: goto +15 -> 363
    //   351: astore_1
    //   352: aload_0
    //   353: aload 6
    //   355: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   358: putfield 133	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   361: aload_1
    //   362: athrow
    //   363: aload_0
    //   364: invokevirtual 136	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:makeExtensionsImmutable	()V
    //   367: aload_1
    //   368: athrow
    //   369: aload 7
    //   371: invokevirtual 125	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   374: aload_0
    //   375: aload 6
    //   377: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   380: putfield 133	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   383: goto +15 -> 398
    //   386: astore_1
    //   387: aload_0
    //   388: aload 6
    //   390: invokevirtual 131	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   393: putfield 133	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   396: aload_1
    //   397: athrow
    //   398: aload_0
    //   399: invokevirtual 136	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirement:makeExtensionsImmutable	()V
    //   402: return
    //   403: astore_2
    //   404: goto -65 -> 339
    //   407: astore_1
    //   408: goto -34 -> 374
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	VersionRequirement
    //   0	411	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	411	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   32	271	3	i	int
    //   41	185	4	j	int
    //   110	123	5	k	int
    //   21	368	6	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	341	7	localCodedOutputStream	CodedOutputStream
    //   117	135	8	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   37	43	306	finally
    //   90	103	306	finally
    //   106	119	306	finally
    //   124	138	306	finally
    //   141	158	306	finally
    //   161	180	306	finally
    //   183	202	306	finally
    //   205	218	306	finally
    //   223	237	306	finally
    //   240	256	306	finally
    //   259	277	306	finally
    //   280	298	306	finally
    //   311	327	306	finally
    //   328	334	306	finally
    //   37	43	310	java/io/IOException
    //   90	103	310	java/io/IOException
    //   106	119	310	java/io/IOException
    //   124	138	310	java/io/IOException
    //   141	158	310	java/io/IOException
    //   161	180	310	java/io/IOException
    //   183	202	310	java/io/IOException
    //   205	218	310	java/io/IOException
    //   223	237	310	java/io/IOException
    //   240	256	310	java/io/IOException
    //   259	277	310	java/io/IOException
    //   280	298	310	java/io/IOException
    //   37	43	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   90	103	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   106	119	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   124	138	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   141	158	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   161	180	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   183	202	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   205	218	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   223	237	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   240	256	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   259	277	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   280	298	327	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   334	339	351	finally
    //   369	374	386	finally
    //   334	339	403	java/io/IOException
    //   369	374	407	java/io/IOException
  }
  
  private ProtoBuf$VersionRequirement(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$VersionRequirement(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static VersionRequirement getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.version_ = 0;
    this.versionFull_ = 0;
    this.level_ = ProtoBuf.VersionRequirement.Level.ERROR;
    this.errorCode_ = 0;
    this.message_ = 0;
    this.versionKind_ = ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION;
  }
  
  public static ProtoBuf.VersionRequirement.Builder newBuilder()
  {
    return ProtoBuf.VersionRequirement.Builder.access$19800();
  }
  
  public static ProtoBuf.VersionRequirement.Builder newBuilder(VersionRequirement paramVersionRequirement)
  {
    return newBuilder().mergeFrom(paramVersionRequirement);
  }
  
  public VersionRequirement getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getErrorCode()
  {
    return this.errorCode_;
  }
  
  public ProtoBuf.VersionRequirement.Level getLevel()
  {
    return this.level_;
  }
  
  public int getMessage()
  {
    return this.message_;
  }
  
  public Parser<VersionRequirement> getParserForType()
  {
    return PARSER;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = 0 + CodedOutputStream.computeInt32Size(1, this.version_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeInt32Size(2, this.versionFull_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeInt32Size(4, this.errorCode_);
    }
    j = i;
    if ((this.bitField0_ & 0x10) == 16) {
      j = i + CodedOutputStream.computeInt32Size(5, this.message_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
    }
    i += this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getVersion()
  {
    return this.version_;
  }
  
  public int getVersionFull()
  {
    return this.versionFull_;
  }
  
  public ProtoBuf.VersionRequirement.VersionKind getVersionKind()
  {
    return this.versionKind_;
  }
  
  public boolean hasErrorCode()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasLevel()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasMessage()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasVersion()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasVersionFull()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasVersionKind()
  {
    return (this.bitField0_ & 0x20) == 32;
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
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.VersionRequirement.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.VersionRequirement.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.version_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(2, this.versionFull_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeEnum(3, this.level_.getNumber());
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeInt32(4, this.errorCode_);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeInt32(5, this.message_);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeEnum(6, this.versionKind_.getNumber());
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement
 * JD-Core Version:    0.7.0.1
 */