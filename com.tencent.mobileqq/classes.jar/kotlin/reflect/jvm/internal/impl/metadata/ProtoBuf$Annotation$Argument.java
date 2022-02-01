package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$Annotation$Argument
  extends GeneratedMessageLite
  implements ProtoBuf.Annotation.ArgumentOrBuilder
{
  public static Parser<Argument> PARSER = new ProtoBuf.Annotation.Argument.1();
  private static final Argument defaultInstance = new Argument(true);
  private int bitField0_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int nameId_;
  private final ByteString unknownFields;
  private ProtoBuf.Annotation.Argument.Value value_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Annotation$Argument(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 45	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 47	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 49	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 38	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:initFields	()V
    //   18: invokestatic 55	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 6
    //   23: aload 6
    //   25: iconst_1
    //   26: invokestatic 61	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 7
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +207 -> 241
    //   37: aload_1
    //   38: invokevirtual 67	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +128 -> 173
    //   48: iload 4
    //   50: bipush 8
    //   52: if_icmpeq +100 -> 152
    //   55: iload 4
    //   57: bipush 18
    //   59: if_icmpeq +19 -> 78
    //   62: aload_0
    //   63: aload_1
    //   64: aload 7
    //   66: aload_2
    //   67: iload 4
    //   69: invokevirtual 71	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   72: ifne -39 -> 33
    //   75: goto +98 -> 173
    //   78: aconst_null
    //   79: astore 5
    //   81: aload_0
    //   82: getfield 73	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:bitField0_	I
    //   85: iconst_2
    //   86: iand
    //   87: iconst_2
    //   88: if_icmpne +12 -> 100
    //   91: aload_0
    //   92: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:value_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value;
    //   95: invokevirtual 81	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Builder;
    //   98: astore 5
    //   100: aload_0
    //   101: aload_1
    //   102: getstatic 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   105: aload_2
    //   106: invokevirtual 86	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   109: checkcast 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value
    //   112: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:value_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value;
    //   115: aload 5
    //   117: ifnull +22 -> 139
    //   120: aload 5
    //   122: aload_0
    //   123: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:value_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value;
    //   126: invokevirtual 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Builder;
    //   129: pop
    //   130: aload_0
    //   131: aload 5
    //   133: invokevirtual 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value;
    //   136: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:value_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value;
    //   139: aload_0
    //   140: aload_0
    //   141: getfield 73	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:bitField0_	I
    //   144: iconst_2
    //   145: ior
    //   146: putfield 73	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:bitField0_	I
    //   149: goto -116 -> 33
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 73	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:bitField0_	I
    //   157: iconst_1
    //   158: ior
    //   159: putfield 73	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:bitField0_	I
    //   162: aload_0
    //   163: aload_1
    //   164: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   167: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:nameId_	I
    //   170: goto -137 -> 33
    //   173: iconst_1
    //   174: istore_3
    //   175: goto -142 -> 33
    //   178: astore_1
    //   179: goto +27 -> 206
    //   182: astore_1
    //   183: new 42	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   186: dup
    //   187: aload_1
    //   188: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
    //   191: invokespecial 108	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: invokevirtual 112	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: aload_0
    //   202: invokevirtual 112	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   205: athrow
    //   206: aload 7
    //   208: invokevirtual 115	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   211: aload_0
    //   212: aload 6
    //   214: invokevirtual 121	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   217: putfield 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   220: goto +15 -> 235
    //   223: astore_1
    //   224: aload_0
    //   225: aload 6
    //   227: invokevirtual 121	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   230: putfield 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   233: aload_1
    //   234: athrow
    //   235: aload_0
    //   236: invokevirtual 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:makeExtensionsImmutable	()V
    //   239: aload_1
    //   240: athrow
    //   241: aload 7
    //   243: invokevirtual 115	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   246: aload_0
    //   247: aload 6
    //   249: invokevirtual 121	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   252: putfield 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   255: goto +15 -> 270
    //   258: astore_1
    //   259: aload_0
    //   260: aload 6
    //   262: invokevirtual 121	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   265: putfield 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   268: aload_1
    //   269: athrow
    //   270: aload_0
    //   271: invokevirtual 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:makeExtensionsImmutable	()V
    //   274: return
    //   275: astore_2
    //   276: goto -65 -> 211
    //   279: astore_1
    //   280: goto -34 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	Argument
    //   0	283	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	283	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   32	143	3	i	int
    //   41	27	4	j	int
    //   79	53	5	localBuilder	ProtoBuf.Annotation.Argument.Value.Builder
    //   21	240	6	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	213	7	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	43	178	finally
    //   62	75	178	finally
    //   81	100	178	finally
    //   100	115	178	finally
    //   120	139	178	finally
    //   139	149	178	finally
    //   152	170	178	finally
    //   183	199	178	finally
    //   200	206	178	finally
    //   37	43	182	java/io/IOException
    //   62	75	182	java/io/IOException
    //   81	100	182	java/io/IOException
    //   100	115	182	java/io/IOException
    //   120	139	182	java/io/IOException
    //   139	149	182	java/io/IOException
    //   152	170	182	java/io/IOException
    //   37	43	199	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   62	75	199	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   81	100	199	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   100	115	199	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   120	139	199	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   139	149	199	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   152	170	199	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   206	211	223	finally
    //   241	246	258	finally
    //   206	211	275	java/io/IOException
    //   241	246	279	java/io/IOException
  }
  
  private ProtoBuf$Annotation$Argument(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Annotation$Argument(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Argument getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.nameId_ = 0;
    this.value_ = ProtoBuf.Annotation.Argument.Value.getDefaultInstance();
  }
  
  public static ProtoBuf.Annotation.Argument.Builder newBuilder()
  {
    return ProtoBuf.Annotation.Argument.Builder.access$3600();
  }
  
  public static ProtoBuf.Annotation.Argument.Builder newBuilder(Argument paramArgument)
  {
    return newBuilder().mergeFrom(paramArgument);
  }
  
  public Argument getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getNameId()
  {
    return this.nameId_;
  }
  
  public Parser<Argument> getParserForType()
  {
    return PARSER;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      i = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
    }
    int j = i;
    if ((this.bitField0_ & 0x2) == 2) {
      j = i + CodedOutputStream.computeMessageSize(2, this.value_);
    }
    i = j + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ProtoBuf.Annotation.Argument.Value getValue()
  {
    return this.value_;
  }
  
  public boolean hasNameId()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasValue()
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
    if (!hasNameId())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if (!hasValue())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if (!getValue().isInitialized())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Annotation.Argument.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Annotation.Argument.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.nameId_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeMessage(2, this.value_);
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument
 * JD-Core Version:    0.7.0.1
 */