package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$Contract
  extends GeneratedMessageLite
  implements ProtoBuf.ContractOrBuilder
{
  public static Parser<Contract> PARSER = new ProtoBuf.Contract.1();
  private static final Contract defaultInstance = new Contract(true);
  private List<ProtoBuf.Effect> effect_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Contract(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 46	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 48	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 37	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:initFields	()V
    //   18: invokestatic 54	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 9
    //   23: aload 9
    //   25: iconst_1
    //   26: invokestatic 60	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 10
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +222 -> 260
    //   41: iload_3
    //   42: istore 5
    //   44: iload_3
    //   45: istore 6
    //   47: iload_3
    //   48: istore 7
    //   50: aload_1
    //   51: invokevirtual 66	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 4
    //   56: iload 4
    //   58: ifeq +106 -> 164
    //   61: iload 4
    //   63: bipush 10
    //   65: if_icmpeq +28 -> 93
    //   68: iload_3
    //   69: istore 5
    //   71: iload_3
    //   72: istore 6
    //   74: iload_3
    //   75: istore 7
    //   77: aload_0
    //   78: aload_1
    //   79: aload 10
    //   81: aload_2
    //   82: iload 4
    //   84: invokevirtual 70	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   87: ifne -51 -> 36
    //   90: goto +74 -> 164
    //   93: iload_3
    //   94: istore 4
    //   96: iload_3
    //   97: iconst_1
    //   98: iand
    //   99: iconst_1
    //   100: if_icmpeq +28 -> 128
    //   103: iload_3
    //   104: istore 5
    //   106: iload_3
    //   107: istore 6
    //   109: iload_3
    //   110: istore 7
    //   112: aload_0
    //   113: new 72	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 73	java/util/ArrayList:<init>	()V
    //   120: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:effect_	Ljava/util/List;
    //   123: iload_3
    //   124: iconst_1
    //   125: ior
    //   126: istore 4
    //   128: iload 4
    //   130: istore 5
    //   132: iload 4
    //   134: istore 6
    //   136: iload 4
    //   138: istore 7
    //   140: aload_0
    //   141: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:effect_	Ljava/util/List;
    //   144: aload_1
    //   145: getstatic 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   148: aload_2
    //   149: invokevirtual 82	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   152: invokeinterface 88 2 0
    //   157: pop
    //   158: iload 4
    //   160: istore_3
    //   161: goto -125 -> 36
    //   164: iconst_1
    //   165: istore 8
    //   167: goto -131 -> 36
    //   170: astore_1
    //   171: goto +35 -> 206
    //   174: astore_1
    //   175: iload 6
    //   177: istore 5
    //   179: new 41	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   182: dup
    //   183: aload_1
    //   184: invokevirtual 92	java/io/IOException:getMessage	()Ljava/lang/String;
    //   187: invokespecial 95	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   190: aload_0
    //   191: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   194: athrow
    //   195: astore_1
    //   196: iload 7
    //   198: istore 5
    //   200: aload_1
    //   201: aload_0
    //   202: invokevirtual 99	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   205: athrow
    //   206: iload 5
    //   208: iconst_1
    //   209: iand
    //   210: iconst_1
    //   211: if_icmpne +14 -> 225
    //   214: aload_0
    //   215: aload_0
    //   216: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:effect_	Ljava/util/List;
    //   219: invokestatic 105	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   222: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:effect_	Ljava/util/List;
    //   225: aload 10
    //   227: invokevirtual 108	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   230: aload_0
    //   231: aload 9
    //   233: invokevirtual 114	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   236: putfield 116	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   239: goto +15 -> 254
    //   242: astore_1
    //   243: aload_0
    //   244: aload 9
    //   246: invokevirtual 114	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   249: putfield 116	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   252: aload_1
    //   253: athrow
    //   254: aload_0
    //   255: invokevirtual 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:makeExtensionsImmutable	()V
    //   258: aload_1
    //   259: athrow
    //   260: iload_3
    //   261: iconst_1
    //   262: iand
    //   263: iconst_1
    //   264: if_icmpne +14 -> 278
    //   267: aload_0
    //   268: aload_0
    //   269: getfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:effect_	Ljava/util/List;
    //   272: invokestatic 105	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   275: putfield 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:effect_	Ljava/util/List;
    //   278: aload 10
    //   280: invokevirtual 108	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   283: aload_0
    //   284: aload 9
    //   286: invokevirtual 114	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   289: putfield 116	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   292: goto +15 -> 307
    //   295: astore_1
    //   296: aload_0
    //   297: aload 9
    //   299: invokevirtual 114	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   302: putfield 116	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   305: aload_1
    //   306: athrow
    //   307: aload_0
    //   308: invokevirtual 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:makeExtensionsImmutable	()V
    //   311: return
    //   312: astore_2
    //   313: goto -83 -> 230
    //   316: astore_1
    //   317: goto -34 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	Contract
    //   0	320	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	320	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	228	3	i	int
    //   54	105	4	j	int
    //   42	168	5	k	int
    //   45	131	6	m	int
    //   48	149	7	n	int
    //   32	134	8	i1	int
    //   21	277	9	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	250	10	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	170	finally
    //   77	90	170	finally
    //   112	123	170	finally
    //   140	158	170	finally
    //   179	195	170	finally
    //   200	206	170	finally
    //   50	56	174	java/io/IOException
    //   77	90	174	java/io/IOException
    //   112	123	174	java/io/IOException
    //   140	158	174	java/io/IOException
    //   50	56	195	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   77	90	195	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   112	123	195	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   140	158	195	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   225	230	242	finally
    //   278	283	295	finally
    //   225	230	312	java/io/IOException
    //   278	283	316	java/io/IOException
  }
  
  private ProtoBuf$Contract(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Contract(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Contract getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.effect_ = Collections.emptyList();
  }
  
  public static ProtoBuf.Contract.Builder newBuilder()
  {
    return ProtoBuf.Contract.Builder.access$22300();
  }
  
  public static ProtoBuf.Contract.Builder newBuilder(Contract paramContract)
  {
    return newBuilder().mergeFrom(paramContract);
  }
  
  public Contract getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public ProtoBuf.Effect getEffect(int paramInt)
  {
    return (ProtoBuf.Effect)this.effect_.get(paramInt);
  }
  
  public int getEffectCount()
  {
    return this.effect_.size();
  }
  
  public Parser<Contract> getParserForType()
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
    int j = 0;
    while (i < this.effect_.size())
    {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.effect_.get(i));
      i += 1;
    }
    i = j + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
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
    while (i < getEffectCount())
    {
      if (!getEffect(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Contract.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Contract.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    int i = 0;
    while (i < this.effect_.size())
    {
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.effect_.get(i));
      i += 1;
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract
 * JD-Core Version:    0.7.0.1
 */