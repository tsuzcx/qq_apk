package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$Annotation
  extends GeneratedMessageLite
  implements ProtoBuf.AnnotationOrBuilder
{
  public static Parser<Annotation> PARSER = new ProtoBuf.Annotation.1();
  private static final Annotation defaultInstance = new Annotation(true);
  private List<ProtoBuf.Annotation.Argument> argument_;
  private int bitField0_;
  private int id_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Annotation(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 48	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 50	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 39	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:initFields	()V
    //   18: invokestatic 56	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 9
    //   23: aload 9
    //   25: iconst_1
    //   26: invokestatic 62	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 10
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +268 -> 306
    //   41: iload_3
    //   42: istore 5
    //   44: iload_3
    //   45: istore 6
    //   47: iload_3
    //   48: istore 7
    //   50: aload_1
    //   51: invokevirtual 68	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 4
    //   56: iload 4
    //   58: ifeq +152 -> 210
    //   61: iload 4
    //   63: bipush 8
    //   65: if_icmpeq +106 -> 171
    //   68: iload 4
    //   70: bipush 18
    //   72: if_icmpeq +28 -> 100
    //   75: iload_3
    //   76: istore 5
    //   78: iload_3
    //   79: istore 6
    //   81: iload_3
    //   82: istore 7
    //   84: aload_0
    //   85: aload_1
    //   86: aload 10
    //   88: aload_2
    //   89: iload 4
    //   91: invokevirtual 72	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   94: ifne -58 -> 36
    //   97: goto +113 -> 210
    //   100: iload_3
    //   101: istore 4
    //   103: iload_3
    //   104: iconst_2
    //   105: iand
    //   106: iconst_2
    //   107: if_icmpeq +28 -> 135
    //   110: iload_3
    //   111: istore 5
    //   113: iload_3
    //   114: istore 6
    //   116: iload_3
    //   117: istore 7
    //   119: aload_0
    //   120: new 74	java/util/ArrayList
    //   123: dup
    //   124: invokespecial 75	java/util/ArrayList:<init>	()V
    //   127: putfield 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:argument_	Ljava/util/List;
    //   130: iload_3
    //   131: iconst_2
    //   132: ior
    //   133: istore 4
    //   135: iload 4
    //   137: istore 5
    //   139: iload 4
    //   141: istore 6
    //   143: iload 4
    //   145: istore 7
    //   147: aload_0
    //   148: getfield 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:argument_	Ljava/util/List;
    //   151: aload_1
    //   152: getstatic 80	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   155: aload_2
    //   156: invokevirtual 84	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   159: invokeinterface 90 2 0
    //   164: pop
    //   165: iload 4
    //   167: istore_3
    //   168: goto -132 -> 36
    //   171: iload_3
    //   172: istore 5
    //   174: iload_3
    //   175: istore 6
    //   177: iload_3
    //   178: istore 7
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:bitField0_	I
    //   185: iconst_1
    //   186: ior
    //   187: putfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:bitField0_	I
    //   190: iload_3
    //   191: istore 5
    //   193: iload_3
    //   194: istore 6
    //   196: iload_3
    //   197: istore 7
    //   199: aload_0
    //   200: aload_1
    //   201: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   204: putfield 97	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:id_	I
    //   207: goto -171 -> 36
    //   210: iconst_1
    //   211: istore 8
    //   213: goto -177 -> 36
    //   216: astore_1
    //   217: goto +35 -> 252
    //   220: astore_1
    //   221: iload 6
    //   223: istore 5
    //   225: new 43	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   228: dup
    //   229: aload_1
    //   230: invokevirtual 101	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokespecial 104	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   236: aload_0
    //   237: invokevirtual 108	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   240: athrow
    //   241: astore_1
    //   242: iload 7
    //   244: istore 5
    //   246: aload_1
    //   247: aload_0
    //   248: invokevirtual 108	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   251: athrow
    //   252: iload 5
    //   254: iconst_2
    //   255: iand
    //   256: iconst_2
    //   257: if_icmpne +14 -> 271
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:argument_	Ljava/util/List;
    //   265: invokestatic 114	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   268: putfield 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:argument_	Ljava/util/List;
    //   271: aload 10
    //   273: invokevirtual 117	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   276: aload_0
    //   277: aload 9
    //   279: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   282: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   285: goto +15 -> 300
    //   288: astore_1
    //   289: aload_0
    //   290: aload 9
    //   292: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   295: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   298: aload_1
    //   299: athrow
    //   300: aload_0
    //   301: invokevirtual 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:makeExtensionsImmutable	()V
    //   304: aload_1
    //   305: athrow
    //   306: iload_3
    //   307: iconst_2
    //   308: iand
    //   309: iconst_2
    //   310: if_icmpne +14 -> 324
    //   313: aload_0
    //   314: aload_0
    //   315: getfield 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:argument_	Ljava/util/List;
    //   318: invokestatic 114	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   321: putfield 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:argument_	Ljava/util/List;
    //   324: aload 10
    //   326: invokevirtual 117	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   329: aload_0
    //   330: aload 9
    //   332: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   335: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   338: goto +15 -> 353
    //   341: astore_1
    //   342: aload_0
    //   343: aload 9
    //   345: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   348: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   351: aload_1
    //   352: athrow
    //   353: aload_0
    //   354: invokevirtual 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:makeExtensionsImmutable	()V
    //   357: return
    //   358: astore_2
    //   359: goto -83 -> 276
    //   362: astore_1
    //   363: goto -34 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	Annotation
    //   0	366	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	366	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	274	3	i	int
    //   54	112	4	j	int
    //   42	214	5	k	int
    //   45	177	6	m	int
    //   48	195	7	n	int
    //   32	180	8	i1	int
    //   21	323	9	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	296	10	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	216	finally
    //   84	97	216	finally
    //   119	130	216	finally
    //   147	165	216	finally
    //   180	190	216	finally
    //   199	207	216	finally
    //   225	241	216	finally
    //   246	252	216	finally
    //   50	56	220	java/io/IOException
    //   84	97	220	java/io/IOException
    //   119	130	220	java/io/IOException
    //   147	165	220	java/io/IOException
    //   180	190	220	java/io/IOException
    //   199	207	220	java/io/IOException
    //   50	56	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   84	97	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   119	130	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   147	165	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   180	190	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   199	207	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   271	276	288	finally
    //   324	329	341	finally
    //   271	276	358	java/io/IOException
    //   324	329	362	java/io/IOException
  }
  
  private ProtoBuf$Annotation(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Annotation(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Annotation getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.id_ = 0;
    this.argument_ = Collections.emptyList();
  }
  
  public static ProtoBuf.Annotation.Builder newBuilder()
  {
    return ProtoBuf.Annotation.Builder.access$4200();
  }
  
  public static ProtoBuf.Annotation.Builder newBuilder(Annotation paramAnnotation)
  {
    return newBuilder().mergeFrom(paramAnnotation);
  }
  
  public ProtoBuf.Annotation.Argument getArgument(int paramInt)
  {
    return (ProtoBuf.Annotation.Argument)this.argument_.get(paramInt);
  }
  
  public int getArgumentCount()
  {
    return this.argument_.size();
  }
  
  public List<ProtoBuf.Annotation.Argument> getArgumentList()
  {
    return this.argument_;
  }
  
  public Annotation getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getId()
  {
    return this.id_;
  }
  
  public Parser<Annotation> getParserForType()
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
    if ((i & 0x1) == 1) {
      i = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
    } else {
      i = 0;
    }
    while (j < this.argument_.size())
    {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.argument_.get(j));
      j += 1;
    }
    i += this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasId()
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
    if (!hasId())
    {
      this.memoizedIsInitialized = 0;
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
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Annotation.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Annotation.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.id_);
    }
    int i = 0;
    while (i < this.argument_.size())
    {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.argument_.get(i));
      i += 1;
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation
 * JD-Core Version:    0.7.0.1
 */