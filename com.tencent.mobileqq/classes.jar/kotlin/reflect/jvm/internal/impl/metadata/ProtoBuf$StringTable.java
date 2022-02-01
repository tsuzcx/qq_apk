package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;

public final class ProtoBuf$StringTable
  extends GeneratedMessageLite
  implements ProtoBuf.StringTableOrBuilder
{
  public static Parser<StringTable> PARSER = new ProtoBuf.StringTable.1();
  private static final StringTable defaultInstance = new StringTable(true);
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private LazyStringList string_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$StringTable(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 43	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 45	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 47	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 36	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:initFields	()V
    //   18: invokestatic 53	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 9
    //   23: aload 9
    //   25: iconst_1
    //   26: invokestatic 59	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 10
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +232 -> 270
    //   41: iload_3
    //   42: istore 5
    //   44: iload_3
    //   45: istore 6
    //   47: iload_3
    //   48: istore 7
    //   50: aload_1
    //   51: invokevirtual 65	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 4
    //   56: iload 4
    //   58: ifeq +114 -> 172
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
    //   84: invokevirtual 69	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   87: ifne -51 -> 36
    //   90: goto +82 -> 172
    //   93: iload_3
    //   94: istore 5
    //   96: iload_3
    //   97: istore 6
    //   99: iload_3
    //   100: istore 7
    //   102: aload_1
    //   103: invokevirtual 73	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readBytes	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   106: astore 11
    //   108: iload_3
    //   109: istore 4
    //   111: iload_3
    //   112: iconst_1
    //   113: iand
    //   114: iconst_1
    //   115: if_icmpeq +28 -> 143
    //   118: iload_3
    //   119: istore 5
    //   121: iload_3
    //   122: istore 6
    //   124: iload_3
    //   125: istore 7
    //   127: aload_0
    //   128: new 75	kotlin/reflect/jvm/internal/impl/protobuf/LazyStringArrayList
    //   131: dup
    //   132: invokespecial 76	kotlin/reflect/jvm/internal/impl/protobuf/LazyStringArrayList:<init>	()V
    //   135: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:string_	Lkotlin/reflect/jvm/internal/impl/protobuf/LazyStringList;
    //   138: iload_3
    //   139: iconst_1
    //   140: ior
    //   141: istore 4
    //   143: iload 4
    //   145: istore 5
    //   147: iload 4
    //   149: istore 6
    //   151: iload 4
    //   153: istore 7
    //   155: aload_0
    //   156: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:string_	Lkotlin/reflect/jvm/internal/impl/protobuf/LazyStringList;
    //   159: aload 11
    //   161: invokeinterface 84 2 0
    //   166: iload 4
    //   168: istore_3
    //   169: goto -133 -> 36
    //   172: iconst_1
    //   173: istore 8
    //   175: goto -139 -> 36
    //   178: astore_1
    //   179: goto +35 -> 214
    //   182: astore_1
    //   183: iload 6
    //   185: istore 5
    //   187: new 40	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   190: dup
    //   191: aload_1
    //   192: invokevirtual 88	java/io/IOException:getMessage	()Ljava/lang/String;
    //   195: invokespecial 91	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   202: athrow
    //   203: astore_1
    //   204: iload 7
    //   206: istore 5
    //   208: aload_1
    //   209: aload_0
    //   210: invokevirtual 95	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   213: athrow
    //   214: iload 5
    //   216: iconst_1
    //   217: iand
    //   218: iconst_1
    //   219: if_icmpne +16 -> 235
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:string_	Lkotlin/reflect/jvm/internal/impl/protobuf/LazyStringList;
    //   227: invokeinterface 99 1 0
    //   232: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:string_	Lkotlin/reflect/jvm/internal/impl/protobuf/LazyStringList;
    //   235: aload 10
    //   237: invokevirtual 102	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   240: aload_0
    //   241: aload 9
    //   243: invokevirtual 107	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   246: putfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   249: goto +15 -> 264
    //   252: astore_1
    //   253: aload_0
    //   254: aload 9
    //   256: invokevirtual 107	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   259: putfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   262: aload_1
    //   263: athrow
    //   264: aload_0
    //   265: invokevirtual 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:makeExtensionsImmutable	()V
    //   268: aload_1
    //   269: athrow
    //   270: iload_3
    //   271: iconst_1
    //   272: iand
    //   273: iconst_1
    //   274: if_icmpne +16 -> 290
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:string_	Lkotlin/reflect/jvm/internal/impl/protobuf/LazyStringList;
    //   282: invokeinterface 99 1 0
    //   287: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:string_	Lkotlin/reflect/jvm/internal/impl/protobuf/LazyStringList;
    //   290: aload 10
    //   292: invokevirtual 102	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   295: aload_0
    //   296: aload 9
    //   298: invokevirtual 107	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   301: putfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   304: goto +15 -> 319
    //   307: astore_1
    //   308: aload_0
    //   309: aload 9
    //   311: invokevirtual 107	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   314: putfield 109	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   317: aload_1
    //   318: athrow
    //   319: aload_0
    //   320: invokevirtual 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:makeExtensionsImmutable	()V
    //   323: return
    //   324: astore_2
    //   325: goto -85 -> 240
    //   328: astore_1
    //   329: goto -34 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	StringTable
    //   0	332	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	332	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	238	3	i	int
    //   54	113	4	j	int
    //   42	176	5	k	int
    //   45	139	6	m	int
    //   48	157	7	n	int
    //   32	142	8	i1	int
    //   21	289	9	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	262	10	localCodedOutputStream	CodedOutputStream
    //   106	54	11	localByteString	ByteString
    // Exception table:
    //   from	to	target	type
    //   50	56	178	finally
    //   77	90	178	finally
    //   102	108	178	finally
    //   127	138	178	finally
    //   155	166	178	finally
    //   187	203	178	finally
    //   208	214	178	finally
    //   50	56	182	java/io/IOException
    //   77	90	182	java/io/IOException
    //   102	108	182	java/io/IOException
    //   127	138	182	java/io/IOException
    //   155	166	182	java/io/IOException
    //   50	56	203	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   77	90	203	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   102	108	203	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   127	138	203	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   155	166	203	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   235	240	252	finally
    //   290	295	307	finally
    //   235	240	324	java/io/IOException
    //   290	295	328	java/io/IOException
  }
  
  private ProtoBuf$StringTable(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$StringTable(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static StringTable getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.string_ = LazyStringArrayList.EMPTY;
  }
  
  public static ProtoBuf.StringTable.Builder newBuilder()
  {
    return ProtoBuf.StringTable.Builder.access$100();
  }
  
  public static ProtoBuf.StringTable.Builder newBuilder(StringTable paramStringTable)
  {
    return newBuilder().mergeFrom(paramStringTable);
  }
  
  public StringTable getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public Parser<StringTable> getParserForType()
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
    while (i < this.string_.size())
    {
      j += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i));
      i += 1;
    }
    i = 0 + j + getStringList().size() * 1 + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getString(int paramInt)
  {
    return (String)this.string_.get(paramInt);
  }
  
  public ProtocolStringList getStringList()
  {
    return this.string_;
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
  
  public ProtoBuf.StringTable.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.StringTable.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    int i = 0;
    while (i < this.string_.size())
    {
      paramCodedOutputStream.writeBytes(1, this.string_.getByteString(i));
      i += 1;
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable
 * JD-Core Version:    0.7.0.1
 */