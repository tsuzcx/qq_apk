package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class JvmProtoBuf$JvmMethodSignature
  extends GeneratedMessageLite
  implements JvmProtoBuf.JvmMethodSignatureOrBuilder
{
  public static Parser<JvmMethodSignature> PARSER = new JvmProtoBuf.JvmMethodSignature.1();
  private static final JvmMethodSignature defaultInstance = new JvmMethodSignature(true);
  private int bitField0_;
  private int desc_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int name_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private JvmProtoBuf$JvmMethodSignature(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 46	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 48	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 37	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:initFields	()V
    //   18: invokestatic 54	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 5
    //   23: aload 5
    //   25: iconst_1
    //   26: invokestatic 60	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 6
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +154 -> 188
    //   37: aload_1
    //   38: invokevirtual 66	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +75 -> 120
    //   48: iload 4
    //   50: bipush 8
    //   52: if_icmpeq +47 -> 99
    //   55: iload 4
    //   57: bipush 16
    //   59: if_icmpeq +19 -> 78
    //   62: aload_0
    //   63: aload_1
    //   64: aload 6
    //   66: aload_2
    //   67: iload 4
    //   69: invokevirtual 70	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   72: ifne -39 -> 33
    //   75: goto +45 -> 120
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 72	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:bitField0_	I
    //   83: iconst_2
    //   84: ior
    //   85: putfield 72	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:bitField0_	I
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 75	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   93: putfield 77	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:desc_	I
    //   96: goto -63 -> 33
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 72	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:bitField0_	I
    //   104: iconst_1
    //   105: ior
    //   106: putfield 72	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:bitField0_	I
    //   109: aload_0
    //   110: aload_1
    //   111: invokevirtual 75	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   114: putfield 79	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:name_	I
    //   117: goto -84 -> 33
    //   120: iconst_1
    //   121: istore_3
    //   122: goto -89 -> 33
    //   125: astore_1
    //   126: goto +27 -> 153
    //   129: astore_1
    //   130: new 41	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   133: dup
    //   134: aload_1
    //   135: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   138: invokespecial 86	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   141: aload_0
    //   142: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: aload_0
    //   149: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   152: athrow
    //   153: aload 6
    //   155: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   158: aload_0
    //   159: aload 5
    //   161: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   164: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   167: goto +15 -> 182
    //   170: astore_1
    //   171: aload_0
    //   172: aload 5
    //   174: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   177: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   180: aload_1
    //   181: athrow
    //   182: aload_0
    //   183: invokevirtual 104	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:makeExtensionsImmutable	()V
    //   186: aload_1
    //   187: athrow
    //   188: aload 6
    //   190: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   193: aload_0
    //   194: aload 5
    //   196: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   199: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   202: goto +15 -> 217
    //   205: astore_1
    //   206: aload_0
    //   207: aload 5
    //   209: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   212: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   215: aload_1
    //   216: athrow
    //   217: aload_0
    //   218: invokevirtual 104	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:makeExtensionsImmutable	()V
    //   221: return
    //   222: astore_2
    //   223: goto -65 -> 158
    //   226: astore_1
    //   227: goto -34 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	JvmMethodSignature
    //   0	230	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	230	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   32	90	3	i	int
    //   41	27	4	j	int
    //   21	187	5	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	160	6	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	43	125	finally
    //   62	75	125	finally
    //   78	96	125	finally
    //   99	117	125	finally
    //   130	146	125	finally
    //   147	153	125	finally
    //   37	43	129	java/io/IOException
    //   62	75	129	java/io/IOException
    //   78	96	129	java/io/IOException
    //   99	117	129	java/io/IOException
    //   37	43	146	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   62	75	146	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   78	96	146	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   99	117	146	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   153	158	170	finally
    //   188	193	205	finally
    //   153	158	222	java/io/IOException
    //   188	193	226	java/io/IOException
  }
  
  private JvmProtoBuf$JvmMethodSignature(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private JvmProtoBuf$JvmMethodSignature(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static JvmMethodSignature getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.name_ = 0;
    this.desc_ = 0;
  }
  
  public static JvmProtoBuf.JvmMethodSignature.Builder newBuilder()
  {
    return JvmProtoBuf.JvmMethodSignature.Builder.access$1800();
  }
  
  public static JvmProtoBuf.JvmMethodSignature.Builder newBuilder(JvmMethodSignature paramJvmMethodSignature)
  {
    return newBuilder().mergeFrom(paramJvmMethodSignature);
  }
  
  public JvmMethodSignature getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getDesc()
  {
    return this.desc_;
  }
  
  public int getName()
  {
    return this.name_;
  }
  
  public Parser<JvmMethodSignature> getParserForType()
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
    int j = i;
    if ((this.bitField0_ & 0x2) == 2) {
      j = i + CodedOutputStream.computeInt32Size(2, this.desc_);
    }
    i = j + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasDesc()
  {
    return (this.bitField0_ & 0x2) == 2;
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
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public JvmProtoBuf.JvmMethodSignature.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public JvmProtoBuf.JvmMethodSignature.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.name_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(2, this.desc_);
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature
 * JD-Core Version:    0.7.0.1
 */