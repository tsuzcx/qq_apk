package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$TypeTable
  extends GeneratedMessageLite
  implements ProtoBuf.TypeTableOrBuilder
{
  public static Parser<TypeTable> PARSER = new ProtoBuf.TypeTable.1();
  private static final TypeTable defaultInstance = new TypeTable(true);
  private int bitField0_;
  private int firstNullable_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private List<ProtoBuf.Type> type_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$TypeTable(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 46	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 48	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 50	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 39	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:initFields	()V
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
    //   63: bipush 10
    //   65: if_icmpeq +74 -> 139
    //   68: iload 4
    //   70: bipush 16
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
    //   91: invokevirtual 72	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   94: ifne -58 -> 36
    //   97: goto +113 -> 210
    //   100: iload_3
    //   101: istore 5
    //   103: iload_3
    //   104: istore 6
    //   106: iload_3
    //   107: istore 7
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 74	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:bitField0_	I
    //   114: iconst_1
    //   115: ior
    //   116: putfield 74	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:bitField0_	I
    //   119: iload_3
    //   120: istore 5
    //   122: iload_3
    //   123: istore 6
    //   125: iload_3
    //   126: istore 7
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual 77	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   133: putfield 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:firstNullable_	I
    //   136: goto -100 -> 36
    //   139: iload_3
    //   140: istore 4
    //   142: iload_3
    //   143: iconst_1
    //   144: iand
    //   145: iconst_1
    //   146: if_icmpeq +28 -> 174
    //   149: iload_3
    //   150: istore 5
    //   152: iload_3
    //   153: istore 6
    //   155: iload_3
    //   156: istore 7
    //   158: aload_0
    //   159: new 81	java/util/ArrayList
    //   162: dup
    //   163: invokespecial 82	java/util/ArrayList:<init>	()V
    //   166: putfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:type_	Ljava/util/List;
    //   169: iload_3
    //   170: iconst_1
    //   171: ior
    //   172: istore 4
    //   174: iload 4
    //   176: istore 5
    //   178: iload 4
    //   180: istore 6
    //   182: iload 4
    //   184: istore 7
    //   186: aload_0
    //   187: getfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:type_	Ljava/util/List;
    //   190: aload_1
    //   191: getstatic 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   194: aload_2
    //   195: invokevirtual 91	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   198: invokeinterface 97 2 0
    //   203: pop
    //   204: iload 4
    //   206: istore_3
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
    //   254: iconst_1
    //   255: iand
    //   256: iconst_1
    //   257: if_icmpne +14 -> 271
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:type_	Ljava/util/List;
    //   265: invokestatic 114	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   268: putfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:type_	Ljava/util/List;
    //   271: aload 10
    //   273: invokevirtual 117	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   276: aload_0
    //   277: aload 9
    //   279: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   282: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   285: goto +15 -> 300
    //   288: astore_1
    //   289: aload_0
    //   290: aload 9
    //   292: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   295: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   298: aload_1
    //   299: athrow
    //   300: aload_0
    //   301: invokevirtual 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:makeExtensionsImmutable	()V
    //   304: aload_1
    //   305: athrow
    //   306: iload_3
    //   307: iconst_1
    //   308: iand
    //   309: iconst_1
    //   310: if_icmpne +14 -> 324
    //   313: aload_0
    //   314: aload_0
    //   315: getfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:type_	Ljava/util/List;
    //   318: invokestatic 114	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   321: putfield 84	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:type_	Ljava/util/List;
    //   324: aload 10
    //   326: invokevirtual 117	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   329: aload_0
    //   330: aload 9
    //   332: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   335: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   338: goto +15 -> 353
    //   341: astore_1
    //   342: aload_0
    //   343: aload 9
    //   345: invokevirtual 123	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   348: putfield 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   351: aload_1
    //   352: athrow
    //   353: aload_0
    //   354: invokevirtual 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:makeExtensionsImmutable	()V
    //   357: return
    //   358: astore_2
    //   359: goto -83 -> 276
    //   362: astore_1
    //   363: goto -34 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	TypeTable
    //   0	366	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	366	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	274	3	i	int
    //   54	151	4	j	int
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
    //   109	119	216	finally
    //   128	136	216	finally
    //   158	169	216	finally
    //   186	204	216	finally
    //   225	241	216	finally
    //   246	252	216	finally
    //   50	56	220	java/io/IOException
    //   84	97	220	java/io/IOException
    //   109	119	220	java/io/IOException
    //   128	136	220	java/io/IOException
    //   158	169	220	java/io/IOException
    //   186	204	220	java/io/IOException
    //   50	56	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   84	97	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   109	119	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   128	136	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   158	169	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   186	204	241	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   271	276	288	finally
    //   324	329	341	finally
    //   271	276	358	java/io/IOException
    //   324	329	362	java/io/IOException
  }
  
  private ProtoBuf$TypeTable(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$TypeTable(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static TypeTable getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.type_ = Collections.emptyList();
    this.firstNullable_ = -1;
  }
  
  public static ProtoBuf.TypeTable.Builder newBuilder()
  {
    return ProtoBuf.TypeTable.Builder.access$11800();
  }
  
  public static ProtoBuf.TypeTable.Builder newBuilder(TypeTable paramTypeTable)
  {
    return newBuilder().mergeFrom(paramTypeTable);
  }
  
  public TypeTable getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getFirstNullable()
  {
    return this.firstNullable_;
  }
  
  public Parser<TypeTable> getParserForType()
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
    i = 0;
    while (j < this.type_.size())
    {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.type_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x1) == 1) {
      j = i + CodedOutputStream.computeInt32Size(2, this.firstNullable_);
    }
    i = j + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ProtoBuf.Type getType(int paramInt)
  {
    return (ProtoBuf.Type)this.type_.get(paramInt);
  }
  
  public int getTypeCount()
  {
    return this.type_.size();
  }
  
  public List<ProtoBuf.Type> getTypeList()
  {
    return this.type_;
  }
  
  public boolean hasFirstNullable()
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
    while (i < getTypeCount())
    {
      if (!getType(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.TypeTable.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.TypeTable.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    int i = 0;
    while (i < this.type_.size())
    {
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.type_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(2, this.firstNullable_);
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable
 * JD-Core Version:    0.7.0.1
 */