package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$Type$Argument
  extends GeneratedMessageLite
  implements ProtoBuf.Type.ArgumentOrBuilder
{
  public static Parser<Argument> PARSER = new ProtoBuf.Type.Argument.1();
  private static final Argument defaultInstance = new Argument(true);
  private int bitField0_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private ProtoBuf.Type.Argument.Projection projection_;
  private int typeId_;
  private ProtoBuf.Type type_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Type$Argument(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 49	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 51	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 40	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:initFields	()V
    //   18: invokestatic 57	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 7
    //   23: aload 7
    //   25: iconst_1
    //   26: invokestatic 63	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 8
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +268 -> 302
    //   37: aload_1
    //   38: invokevirtual 69	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +189 -> 234
    //   48: iload 4
    //   50: bipush 8
    //   52: if_icmpeq +128 -> 180
    //   55: iload 4
    //   57: bipush 18
    //   59: if_icmpeq +47 -> 106
    //   62: iload 4
    //   64: bipush 24
    //   66: if_icmpeq +19 -> 85
    //   69: aload_0
    //   70: aload_1
    //   71: aload 8
    //   73: aload_2
    //   74: iload 4
    //   76: invokevirtual 73	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   79: ifne -46 -> 33
    //   82: goto +152 -> 234
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:bitField0_	I
    //   90: iconst_4
    //   91: ior
    //   92: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:bitField0_	I
    //   95: aload_0
    //   96: aload_1
    //   97: invokevirtual 78	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   100: putfield 80	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:typeId_	I
    //   103: goto -70 -> 33
    //   106: aconst_null
    //   107: astore 6
    //   109: aload_0
    //   110: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:bitField0_	I
    //   113: iconst_2
    //   114: iand
    //   115: iconst_2
    //   116: if_icmpne +12 -> 128
    //   119: aload_0
    //   120: getfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   123: invokevirtual 88	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   126: astore 6
    //   128: aload_0
    //   129: aload_1
    //   130: getstatic 89	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   133: aload_2
    //   134: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   137: checkcast 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   140: putfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   143: aload 6
    //   145: ifnull +22 -> 167
    //   148: aload 6
    //   150: aload_0
    //   151: getfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   154: invokevirtual 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   157: pop
    //   158: aload_0
    //   159: aload 6
    //   161: invokevirtual 103	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   164: putfield 82	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:bitField0_	I
    //   172: iconst_2
    //   173: ior
    //   174: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:bitField0_	I
    //   177: goto -144 -> 33
    //   180: aload_1
    //   181: invokevirtual 106	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   184: istore 5
    //   186: iload 5
    //   188: invokestatic 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument$Projection:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument$Projection;
    //   191: astore 6
    //   193: aload 6
    //   195: ifnonnull +20 -> 215
    //   198: aload 8
    //   200: iload 4
    //   202: invokevirtual 116	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   205: aload 8
    //   207: iload 5
    //   209: invokevirtual 116	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   212: goto -179 -> 33
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:bitField0_	I
    //   220: iconst_1
    //   221: ior
    //   222: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:bitField0_	I
    //   225: aload_0
    //   226: aload 6
    //   228: putfield 118	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:projection_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument$Projection;
    //   231: goto -198 -> 33
    //   234: iconst_1
    //   235: istore_3
    //   236: goto -203 -> 33
    //   239: astore_1
    //   240: goto +27 -> 267
    //   243: astore_1
    //   244: new 44	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   247: dup
    //   248: aload_1
    //   249: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   252: invokespecial 125	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   255: aload_0
    //   256: invokevirtual 129	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   259: athrow
    //   260: astore_1
    //   261: aload_1
    //   262: aload_0
    //   263: invokevirtual 129	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   266: athrow
    //   267: aload 8
    //   269: invokevirtual 132	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   272: aload_0
    //   273: aload 7
    //   275: invokevirtual 138	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   278: putfield 140	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   281: goto +15 -> 296
    //   284: astore_1
    //   285: aload_0
    //   286: aload 7
    //   288: invokevirtual 138	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   291: putfield 140	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   294: aload_1
    //   295: athrow
    //   296: aload_0
    //   297: invokevirtual 143	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:makeExtensionsImmutable	()V
    //   300: aload_1
    //   301: athrow
    //   302: aload 8
    //   304: invokevirtual 132	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   307: aload_0
    //   308: aload 7
    //   310: invokevirtual 138	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   313: putfield 140	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   316: goto +15 -> 331
    //   319: astore_1
    //   320: aload_0
    //   321: aload 7
    //   323: invokevirtual 138	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   326: putfield 140	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   329: aload_1
    //   330: athrow
    //   331: aload_0
    //   332: invokevirtual 143	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:makeExtensionsImmutable	()V
    //   335: return
    //   336: astore_2
    //   337: goto -65 -> 272
    //   340: astore_1
    //   341: goto -34 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	Argument
    //   0	344	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	344	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   32	204	3	i	int
    //   41	160	4	j	int
    //   184	24	5	k	int
    //   107	120	6	localObject	java.lang.Object
    //   21	301	7	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	274	8	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	43	239	finally
    //   69	82	239	finally
    //   85	103	239	finally
    //   109	128	239	finally
    //   128	143	239	finally
    //   148	167	239	finally
    //   167	177	239	finally
    //   180	193	239	finally
    //   198	212	239	finally
    //   215	231	239	finally
    //   244	260	239	finally
    //   261	267	239	finally
    //   37	43	243	java/io/IOException
    //   69	82	243	java/io/IOException
    //   85	103	243	java/io/IOException
    //   109	128	243	java/io/IOException
    //   128	143	243	java/io/IOException
    //   148	167	243	java/io/IOException
    //   167	177	243	java/io/IOException
    //   180	193	243	java/io/IOException
    //   198	212	243	java/io/IOException
    //   215	231	243	java/io/IOException
    //   37	43	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   69	82	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   85	103	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   109	128	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   128	143	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   148	167	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   167	177	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   180	193	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   198	212	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   215	231	260	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   267	272	284	finally
    //   302	307	319	finally
    //   267	272	336	java/io/IOException
    //   302	307	340	java/io/IOException
  }
  
  private ProtoBuf$Type$Argument(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Type$Argument(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Argument getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.projection_ = ProtoBuf.Type.Argument.Projection.INV;
    this.type_ = ProtoBuf.Type.getDefaultInstance();
    this.typeId_ = 0;
  }
  
  public static ProtoBuf.Type.Argument.Builder newBuilder()
  {
    return ProtoBuf.Type.Argument.Builder.access$5000();
  }
  
  public static ProtoBuf.Type.Argument.Builder newBuilder(Argument paramArgument)
  {
    return newBuilder().mergeFrom(paramArgument);
  }
  
  public Argument getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public Parser<Argument> getParserForType()
  {
    return PARSER;
  }
  
  public ProtoBuf.Type.Argument.Projection getProjection()
  {
    return this.projection_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bitField0_ & 0x1) == 1) {
      j = 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeMessageSize(2, this.type_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeInt32Size(3, this.typeId_);
    }
    i = j + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ProtoBuf.Type getType()
  {
    return this.type_;
  }
  
  public int getTypeId()
  {
    return this.typeId_;
  }
  
  public boolean hasProjection()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasType()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasTypeId()
  {
    return (this.bitField0_ & 0x4) == 4;
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
    if ((hasType()) && (!getType().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Type.Argument.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Type.Argument.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeEnum(1, this.projection_.getNumber());
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeMessage(2, this.type_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeInt32(3, this.typeId_);
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument
 * JD-Core Version:    0.7.0.1
 */