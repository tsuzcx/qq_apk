package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$EnumEntry
  extends GeneratedMessageLite.ExtendableMessage<EnumEntry>
  implements ProtoBuf.EnumEntryOrBuilder
{
  public static Parser<EnumEntry> PARSER = new ProtoBuf.EnumEntry.1();
  private static final EnumEntry defaultInstance = new EnumEntry(true);
  private int bitField0_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int name_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$EnumEntry(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 46	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 48	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 37	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:initFields	()V
    //   18: invokestatic 54	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 5
    //   23: aload 5
    //   25: iconst_1
    //   26: invokestatic 60	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 6
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +126 -> 160
    //   37: aload_1
    //   38: invokevirtual 66	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +47 -> 92
    //   48: iload 4
    //   50: bipush 8
    //   52: if_icmpeq +19 -> 71
    //   55: aload_0
    //   56: aload_1
    //   57: aload 6
    //   59: aload_2
    //   60: iload 4
    //   62: invokevirtual 70	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   65: ifne -32 -> 33
    //   68: goto +24 -> 92
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 72	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:bitField0_	I
    //   76: iconst_1
    //   77: ior
    //   78: putfield 72	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:bitField0_	I
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 75	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   86: putfield 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:name_	I
    //   89: goto -56 -> 33
    //   92: iconst_1
    //   93: istore_3
    //   94: goto -61 -> 33
    //   97: astore_1
    //   98: goto +27 -> 125
    //   101: astore_1
    //   102: new 41	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   105: dup
    //   106: aload_1
    //   107: invokevirtual 81	java/io/IOException:getMessage	()Ljava/lang/String;
    //   110: invokespecial 84	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   113: aload_0
    //   114: invokevirtual 88	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: aload_0
    //   121: invokevirtual 88	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   124: athrow
    //   125: aload 6
    //   127: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   130: aload_0
    //   131: aload 5
    //   133: invokevirtual 97	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   136: putfield 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   139: goto +15 -> 154
    //   142: astore_1
    //   143: aload_0
    //   144: aload 5
    //   146: invokevirtual 97	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   149: putfield 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   152: aload_1
    //   153: athrow
    //   154: aload_0
    //   155: invokevirtual 102	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:makeExtensionsImmutable	()V
    //   158: aload_1
    //   159: athrow
    //   160: aload 6
    //   162: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   165: aload_0
    //   166: aload 5
    //   168: invokevirtual 97	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   171: putfield 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   174: goto +15 -> 189
    //   177: astore_1
    //   178: aload_0
    //   179: aload 5
    //   181: invokevirtual 97	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   184: putfield 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   187: aload_1
    //   188: athrow
    //   189: aload_0
    //   190: invokevirtual 102	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:makeExtensionsImmutable	()V
    //   193: return
    //   194: astore_2
    //   195: goto -65 -> 130
    //   198: astore_1
    //   199: goto -34 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	EnumEntry
    //   0	202	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	202	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   32	62	3	i	int
    //   41	20	4	j	int
    //   21	159	5	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	132	6	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	43	97	finally
    //   55	68	97	finally
    //   71	89	97	finally
    //   102	118	97	finally
    //   119	125	97	finally
    //   37	43	101	java/io/IOException
    //   55	68	101	java/io/IOException
    //   71	89	101	java/io/IOException
    //   37	43	118	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   55	68	118	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   71	89	118	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   125	130	142	finally
    //   160	165	177	finally
    //   125	130	194	java/io/IOException
    //   160	165	198	java/io/IOException
  }
  
  private ProtoBuf$EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$EnumEntry(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static EnumEntry getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.name_ = 0;
  }
  
  public static ProtoBuf.EnumEntry.Builder newBuilder()
  {
    return ProtoBuf.EnumEntry.Builder.access$19200();
  }
  
  public static ProtoBuf.EnumEntry.Builder newBuilder(EnumEntry paramEnumEntry)
  {
    return newBuilder().mergeFrom(paramEnumEntry);
  }
  
  public EnumEntry getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getName()
  {
    return this.name_;
  }
  
  public Parser<EnumEntry> getParserForType()
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
      i = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
    }
    i = i + extensionsSerializedSize() + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasName()
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
    if (!extensionsAreInitialized())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.EnumEntry.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.EnumEntry.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    GeneratedMessageLite.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.name_);
    }
    localExtensionWriter.writeUntil(200, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry
 * JD-Core Version:    0.7.0.1
 */