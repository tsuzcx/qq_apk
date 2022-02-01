package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$QualifiedNameTable$QualifiedName
  extends GeneratedMessageLite
  implements ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
{
  public static Parser<QualifiedName> PARSER = new ProtoBuf.QualifiedNameTable.QualifiedName.1();
  private static final QualifiedName defaultInstance = new QualifiedName(true);
  private int bitField0_;
  private ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int parentQualifiedName_;
  private int shortName_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$QualifiedNameTable$QualifiedName(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 48	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 50	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 39	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:initFields	()V
    //   18: invokestatic 56	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 6
    //   23: aload 6
    //   25: iconst_1
    //   26: invokestatic 62	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 7
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +215 -> 249
    //   37: aload_1
    //   38: invokevirtual 68	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +136 -> 181
    //   48: iload 4
    //   50: bipush 8
    //   52: if_icmpeq +108 -> 160
    //   55: iload 4
    //   57: bipush 16
    //   59: if_icmpeq +80 -> 139
    //   62: iload 4
    //   64: bipush 24
    //   66: if_icmpeq +19 -> 85
    //   69: aload_0
    //   70: aload_1
    //   71: aload 7
    //   73: aload_2
    //   74: iload 4
    //   76: invokevirtual 72	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   79: ifne -46 -> 33
    //   82: goto +99 -> 181
    //   85: aload_1
    //   86: invokevirtual 75	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   89: istore 5
    //   91: iload 5
    //   93: invokestatic 81	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName$Kind:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName$Kind;
    //   96: astore 8
    //   98: aload 8
    //   100: ifnonnull +20 -> 120
    //   103: aload 7
    //   105: iload 4
    //   107: invokevirtual 85	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   110: aload 7
    //   112: iload 5
    //   114: invokevirtual 85	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   117: goto -84 -> 33
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:bitField0_	I
    //   125: iconst_4
    //   126: ior
    //   127: putfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:bitField0_	I
    //   130: aload_0
    //   131: aload 8
    //   133: putfield 89	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:kind_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName$Kind;
    //   136: goto -103 -> 33
    //   139: aload_0
    //   140: aload_0
    //   141: getfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:bitField0_	I
    //   144: iconst_2
    //   145: ior
    //   146: putfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:bitField0_	I
    //   149: aload_0
    //   150: aload_1
    //   151: invokevirtual 92	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   154: putfield 94	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:shortName_	I
    //   157: goto -124 -> 33
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:bitField0_	I
    //   165: iconst_1
    //   166: ior
    //   167: putfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:bitField0_	I
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual 92	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   175: putfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:parentQualifiedName_	I
    //   178: goto -145 -> 33
    //   181: iconst_1
    //   182: istore_3
    //   183: goto -150 -> 33
    //   186: astore_1
    //   187: goto +27 -> 214
    //   190: astore_1
    //   191: new 43	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   194: dup
    //   195: aload_1
    //   196: invokevirtual 100	java/io/IOException:getMessage	()Ljava/lang/String;
    //   199: invokespecial 103	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   202: aload_0
    //   203: invokevirtual 107	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   206: athrow
    //   207: astore_1
    //   208: aload_1
    //   209: aload_0
    //   210: invokevirtual 107	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   213: athrow
    //   214: aload 7
    //   216: invokevirtual 110	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   219: aload_0
    //   220: aload 6
    //   222: invokevirtual 116	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   225: putfield 118	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   228: goto +15 -> 243
    //   231: astore_1
    //   232: aload_0
    //   233: aload 6
    //   235: invokevirtual 116	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   238: putfield 118	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   241: aload_1
    //   242: athrow
    //   243: aload_0
    //   244: invokevirtual 121	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:makeExtensionsImmutable	()V
    //   247: aload_1
    //   248: athrow
    //   249: aload 7
    //   251: invokevirtual 110	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   254: aload_0
    //   255: aload 6
    //   257: invokevirtual 116	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   260: putfield 118	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   263: goto +15 -> 278
    //   266: astore_1
    //   267: aload_0
    //   268: aload 6
    //   270: invokevirtual 116	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   273: putfield 118	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   276: aload_1
    //   277: athrow
    //   278: aload_0
    //   279: invokevirtual 121	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:makeExtensionsImmutable	()V
    //   282: return
    //   283: astore_2
    //   284: goto -65 -> 219
    //   287: astore_1
    //   288: goto -34 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	QualifiedName
    //   0	291	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	291	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   32	151	3	i	int
    //   41	65	4	j	int
    //   89	24	5	k	int
    //   21	248	6	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	221	7	localCodedOutputStream	CodedOutputStream
    //   96	36	8	localKind	ProtoBuf.QualifiedNameTable.QualifiedName.Kind
    // Exception table:
    //   from	to	target	type
    //   37	43	186	finally
    //   69	82	186	finally
    //   85	98	186	finally
    //   103	117	186	finally
    //   120	136	186	finally
    //   139	157	186	finally
    //   160	178	186	finally
    //   191	207	186	finally
    //   208	214	186	finally
    //   37	43	190	java/io/IOException
    //   69	82	190	java/io/IOException
    //   85	98	190	java/io/IOException
    //   103	117	190	java/io/IOException
    //   120	136	190	java/io/IOException
    //   139	157	190	java/io/IOException
    //   160	178	190	java/io/IOException
    //   37	43	207	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   69	82	207	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   85	98	207	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   103	117	207	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   120	136	207	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   139	157	207	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   160	178	207	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   214	219	231	finally
    //   249	254	266	finally
    //   214	219	283	java/io/IOException
    //   249	254	287	java/io/IOException
  }
  
  private ProtoBuf$QualifiedNameTable$QualifiedName(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$QualifiedNameTable$QualifiedName(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static QualifiedName getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.parentQualifiedName_ = -1;
    this.shortName_ = 0;
    this.kind_ = ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE;
  }
  
  public static ProtoBuf.QualifiedNameTable.QualifiedName.Builder newBuilder()
  {
    return ProtoBuf.QualifiedNameTable.QualifiedName.Builder.access$700();
  }
  
  public static ProtoBuf.QualifiedNameTable.QualifiedName.Builder newBuilder(QualifiedName paramQualifiedName)
  {
    return newBuilder().mergeFrom(paramQualifiedName);
  }
  
  public QualifiedName getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public ProtoBuf.QualifiedNameTable.QualifiedName.Kind getKind()
  {
    return this.kind_;
  }
  
  public int getParentQualifiedName()
  {
    return this.parentQualifiedName_;
  }
  
  public Parser<QualifiedName> getParserForType()
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
      j = 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeInt32Size(2, this.shortName_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
    }
    i = j + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public int getShortName()
  {
    return this.shortName_;
  }
  
  public boolean hasKind()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasParentQualifiedName()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasShortName()
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
    if (!hasShortName())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.QualifiedNameTable.QualifiedName.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.QualifiedNameTable.QualifiedName.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.parentQualifiedName_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(2, this.shortName_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeEnum(3, this.kind_.getNumber());
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName
 * JD-Core Version:    0.7.0.1
 */