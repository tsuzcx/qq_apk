package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$ValueParameter
  extends GeneratedMessageLite.ExtendableMessage<ValueParameter>
  implements ProtoBuf.ValueParameterOrBuilder
{
  public static Parser<ValueParameter> PARSER = new ProtoBuf.ValueParameter.1();
  private static final ValueParameter defaultInstance = new ValueParameter(true);
  private int bitField0_;
  private int flags_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private int name_;
  private int typeId_;
  private ProtoBuf.Type type_;
  private final ByteString unknownFields;
  private int varargElementTypeId_;
  private ProtoBuf.Type varargElementType_;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$ValueParameter(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 50	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 52	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 54	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 43	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:initFields	()V
    //   18: invokestatic 60	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 7
    //   23: aload 7
    //   25: iconst_1
    //   26: invokestatic 66	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 8
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +381 -> 415
    //   37: aload_1
    //   38: invokevirtual 72	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +302 -> 347
    //   48: iload 4
    //   50: bipush 8
    //   52: if_icmpeq +274 -> 326
    //   55: iload 4
    //   57: bipush 16
    //   59: if_icmpeq +246 -> 305
    //   62: aconst_null
    //   63: astore 6
    //   65: aconst_null
    //   66: astore 5
    //   68: iload 4
    //   70: bipush 26
    //   72: if_icmpeq +158 -> 230
    //   75: iload 4
    //   77: bipush 34
    //   79: if_icmpeq +77 -> 156
    //   82: iload 4
    //   84: bipush 40
    //   86: if_icmpeq +48 -> 134
    //   89: iload 4
    //   91: bipush 48
    //   93: if_icmpeq +19 -> 112
    //   96: aload_0
    //   97: aload_1
    //   98: aload 8
    //   100: aload_2
    //   101: iload 4
    //   103: invokevirtual 76	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   106: ifne -73 -> 33
    //   109: goto +238 -> 347
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   117: bipush 32
    //   119: ior
    //   120: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 81	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   128: putfield 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:varargElementTypeId_	I
    //   131: goto -98 -> 33
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   139: bipush 8
    //   141: ior
    //   142: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   145: aload_0
    //   146: aload_1
    //   147: invokevirtual 81	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   150: putfield 85	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:typeId_	I
    //   153: goto -120 -> 33
    //   156: aload_0
    //   157: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   160: bipush 16
    //   162: iand
    //   163: bipush 16
    //   165: if_icmpne +12 -> 177
    //   168: aload_0
    //   169: getfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:varargElementType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   172: invokevirtual 93	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   175: astore 5
    //   177: aload_0
    //   178: aload_1
    //   179: getstatic 94	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   182: aload_2
    //   183: invokevirtual 98	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   186: checkcast 89	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   189: putfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:varargElementType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   192: aload 5
    //   194: ifnull +22 -> 216
    //   197: aload 5
    //   199: aload_0
    //   200: getfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:varargElementType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   203: invokevirtual 104	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   206: pop
    //   207: aload_0
    //   208: aload 5
    //   210: invokevirtual 108	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   213: putfield 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:varargElementType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   221: bipush 16
    //   223: ior
    //   224: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   227: goto -194 -> 33
    //   230: aload 6
    //   232: astore 5
    //   234: aload_0
    //   235: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   238: iconst_4
    //   239: iand
    //   240: iconst_4
    //   241: if_icmpne +12 -> 253
    //   244: aload_0
    //   245: getfield 110	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   248: invokevirtual 93	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   251: astore 5
    //   253: aload_0
    //   254: aload_1
    //   255: getstatic 94	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   258: aload_2
    //   259: invokevirtual 98	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   262: checkcast 89	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   265: putfield 110	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   268: aload 5
    //   270: ifnull +22 -> 292
    //   273: aload 5
    //   275: aload_0
    //   276: getfield 110	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   279: invokevirtual 104	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   282: pop
    //   283: aload_0
    //   284: aload 5
    //   286: invokevirtual 108	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   289: putfield 110	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:type_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;
    //   292: aload_0
    //   293: aload_0
    //   294: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   297: iconst_4
    //   298: ior
    //   299: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   302: goto -269 -> 33
    //   305: aload_0
    //   306: aload_0
    //   307: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   310: iconst_2
    //   311: ior
    //   312: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   315: aload_0
    //   316: aload_1
    //   317: invokevirtual 81	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   320: putfield 112	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:name_	I
    //   323: goto -290 -> 33
    //   326: aload_0
    //   327: aload_0
    //   328: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   331: iconst_1
    //   332: ior
    //   333: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:bitField0_	I
    //   336: aload_0
    //   337: aload_1
    //   338: invokevirtual 81	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   341: putfield 114	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:flags_	I
    //   344: goto -311 -> 33
    //   347: iconst_1
    //   348: istore_3
    //   349: goto -316 -> 33
    //   352: astore_1
    //   353: goto +27 -> 380
    //   356: astore_1
    //   357: new 47	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   360: dup
    //   361: aload_1
    //   362: invokevirtual 118	java/io/IOException:getMessage	()Ljava/lang/String;
    //   365: invokespecial 121	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   368: aload_0
    //   369: invokevirtual 125	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   372: athrow
    //   373: astore_1
    //   374: aload_1
    //   375: aload_0
    //   376: invokevirtual 125	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   379: athrow
    //   380: aload 8
    //   382: invokevirtual 128	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   385: aload_0
    //   386: aload 7
    //   388: invokevirtual 134	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   391: putfield 136	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   394: goto +15 -> 409
    //   397: astore_1
    //   398: aload_0
    //   399: aload 7
    //   401: invokevirtual 134	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   404: putfield 136	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   407: aload_1
    //   408: athrow
    //   409: aload_0
    //   410: invokevirtual 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:makeExtensionsImmutable	()V
    //   413: aload_1
    //   414: athrow
    //   415: aload 8
    //   417: invokevirtual 128	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   420: aload_0
    //   421: aload 7
    //   423: invokevirtual 134	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   426: putfield 136	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   429: goto +15 -> 444
    //   432: astore_1
    //   433: aload_0
    //   434: aload 7
    //   436: invokevirtual 134	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   439: putfield 136	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   442: aload_1
    //   443: athrow
    //   444: aload_0
    //   445: invokevirtual 139	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:makeExtensionsImmutable	()V
    //   448: return
    //   449: astore_2
    //   450: goto -65 -> 385
    //   453: astore_1
    //   454: goto -34 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	ValueParameter
    //   0	457	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	457	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   32	317	3	i	int
    //   41	61	4	j	int
    //   66	219	5	localObject1	java.lang.Object
    //   63	168	6	localObject2	java.lang.Object
    //   21	414	7	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	387	8	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	43	352	finally
    //   96	109	352	finally
    //   112	131	352	finally
    //   134	153	352	finally
    //   156	177	352	finally
    //   177	192	352	finally
    //   197	216	352	finally
    //   216	227	352	finally
    //   234	253	352	finally
    //   253	268	352	finally
    //   273	292	352	finally
    //   292	302	352	finally
    //   305	323	352	finally
    //   326	344	352	finally
    //   357	373	352	finally
    //   374	380	352	finally
    //   37	43	356	java/io/IOException
    //   96	109	356	java/io/IOException
    //   112	131	356	java/io/IOException
    //   134	153	356	java/io/IOException
    //   156	177	356	java/io/IOException
    //   177	192	356	java/io/IOException
    //   197	216	356	java/io/IOException
    //   216	227	356	java/io/IOException
    //   234	253	356	java/io/IOException
    //   253	268	356	java/io/IOException
    //   273	292	356	java/io/IOException
    //   292	302	356	java/io/IOException
    //   305	323	356	java/io/IOException
    //   326	344	356	java/io/IOException
    //   37	43	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   96	109	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   112	131	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   134	153	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   156	177	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   177	192	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   197	216	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   216	227	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   234	253	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   253	268	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   273	292	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   292	302	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   305	323	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   326	344	373	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   380	385	397	finally
    //   415	420	432	finally
    //   380	385	449	java/io/IOException
    //   415	420	453	java/io/IOException
  }
  
  private ProtoBuf$ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$ValueParameter(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static ValueParameter getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.flags_ = 0;
    this.name_ = 0;
    this.type_ = ProtoBuf.Type.getDefaultInstance();
    this.typeId_ = 0;
    this.varargElementType_ = ProtoBuf.Type.getDefaultInstance();
    this.varargElementTypeId_ = 0;
  }
  
  public static ProtoBuf.ValueParameter.Builder newBuilder()
  {
    return ProtoBuf.ValueParameter.Builder.access$16700();
  }
  
  public static ProtoBuf.ValueParameter.Builder newBuilder(ValueParameter paramValueParameter)
  {
    return newBuilder().mergeFrom(paramValueParameter);
  }
  
  public ValueParameter getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public int getFlags()
  {
    return this.flags_;
  }
  
  public int getName()
  {
    return this.name_;
  }
  
  public Parser<ValueParameter> getParserForType()
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
      j = 0 + CodedOutputStream.computeInt32Size(1, this.flags_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeInt32Size(2, this.name_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeMessageSize(3, this.type_);
    }
    i = j;
    if ((this.bitField0_ & 0x10) == 16) {
      i = j + CodedOutputStream.computeMessageSize(4, this.varargElementType_);
    }
    j = i;
    if ((this.bitField0_ & 0x8) == 8) {
      j = i + CodedOutputStream.computeInt32Size(5, this.typeId_);
    }
    i = j;
    if ((this.bitField0_ & 0x20) == 32) {
      i = j + CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
    }
    i = i + extensionsSerializedSize() + this.unknownFields.size();
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
  
  public ProtoBuf.Type getVarargElementType()
  {
    return this.varargElementType_;
  }
  
  public int getVarargElementTypeId()
  {
    return this.varargElementTypeId_;
  }
  
  public boolean hasFlags()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasType()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasTypeId()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasVarargElementType()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public boolean hasVarargElementTypeId()
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
    if (!hasName())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if ((hasType()) && (!getType().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if ((hasVarargElementType()) && (!getVarargElementType().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
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
  
  public ProtoBuf.ValueParameter.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.ValueParameter.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    GeneratedMessageLite.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeInt32(1, this.flags_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeInt32(2, this.name_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeMessage(3, this.type_);
    }
    if ((this.bitField0_ & 0x10) == 16) {
      paramCodedOutputStream.writeMessage(4, this.varargElementType_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeInt32(5, this.typeId_);
    }
    if ((this.bitField0_ & 0x20) == 32) {
      paramCodedOutputStream.writeInt32(6, this.varargElementTypeId_);
    }
    localExtensionWriter.writeUntil(200, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter
 * JD-Core Version:    0.7.0.1
 */