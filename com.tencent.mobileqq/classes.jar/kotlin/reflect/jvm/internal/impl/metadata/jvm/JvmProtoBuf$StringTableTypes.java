package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class JvmProtoBuf$StringTableTypes
  extends GeneratedMessageLite
  implements JvmProtoBuf.StringTableTypesOrBuilder
{
  public static Parser<StringTableTypes> PARSER = new JvmProtoBuf.StringTableTypes.1();
  private static final StringTableTypes defaultInstance = new StringTableTypes(true);
  private int localNameMemoizedSerializedSize = -1;
  private List<Integer> localName_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private List<JvmProtoBuf.StringTableTypes.Record> record_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private JvmProtoBuf$StringTableTypes(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 49	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localNameMemoizedSerializedSize	I
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 51	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:memoizedIsInitialized	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 53	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:memoizedSerializedSize	I
    //   19: aload_0
    //   20: invokespecial 40	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:initFields	()V
    //   23: invokestatic 59	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   26: astore 10
    //   28: aload 10
    //   30: iconst_1
    //   31: invokestatic 65	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   34: astore 11
    //   36: iconst_0
    //   37: istore 8
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 8
    //   43: ifne +473 -> 516
    //   46: iload_3
    //   47: istore 4
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 71	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   59: istore 7
    //   61: iload 7
    //   63: ifeq +338 -> 401
    //   66: iload 7
    //   68: bipush 10
    //   70: if_icmpeq +260 -> 330
    //   73: iload 7
    //   75: bipush 40
    //   77: if_icmpeq +183 -> 260
    //   80: iload 7
    //   82: bipush 42
    //   84: if_icmpeq +28 -> 112
    //   87: iload_3
    //   88: istore 4
    //   90: iload_3
    //   91: istore 5
    //   93: iload_3
    //   94: istore 6
    //   96: aload_0
    //   97: aload_1
    //   98: aload 11
    //   100: aload_2
    //   101: iload 7
    //   103: invokevirtual 75	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   106: ifne -65 -> 41
    //   109: goto +292 -> 401
    //   112: iload_3
    //   113: istore 4
    //   115: iload_3
    //   116: istore 5
    //   118: iload_3
    //   119: istore 6
    //   121: aload_1
    //   122: aload_1
    //   123: invokevirtual 78	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readRawVarint32	()I
    //   126: invokevirtual 82	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:pushLimit	(I)I
    //   129: istore 9
    //   131: iload_3
    //   132: istore 7
    //   134: iload_3
    //   135: iconst_2
    //   136: iand
    //   137: iconst_2
    //   138: if_icmpeq +47 -> 185
    //   141: iload_3
    //   142: istore 7
    //   144: iload_3
    //   145: istore 4
    //   147: iload_3
    //   148: istore 5
    //   150: iload_3
    //   151: istore 6
    //   153: aload_1
    //   154: invokevirtual 85	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   157: ifle +28 -> 185
    //   160: iload_3
    //   161: istore 4
    //   163: iload_3
    //   164: istore 5
    //   166: iload_3
    //   167: istore 6
    //   169: aload_0
    //   170: new 87	java/util/ArrayList
    //   173: dup
    //   174: invokespecial 88	java/util/ArrayList:<init>	()V
    //   177: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localName_	Ljava/util/List;
    //   180: iload_3
    //   181: iconst_2
    //   182: ior
    //   183: istore 7
    //   185: iload 7
    //   187: istore 4
    //   189: iload 7
    //   191: istore 5
    //   193: iload 7
    //   195: istore 6
    //   197: aload_1
    //   198: invokevirtual 85	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:getBytesUntilLimit	()I
    //   201: ifle +35 -> 236
    //   204: iload 7
    //   206: istore 4
    //   208: iload 7
    //   210: istore 5
    //   212: iload 7
    //   214: istore 6
    //   216: aload_0
    //   217: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localName_	Ljava/util/List;
    //   220: aload_1
    //   221: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   224: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokeinterface 105 2 0
    //   232: pop
    //   233: goto -48 -> 185
    //   236: iload 7
    //   238: istore 4
    //   240: iload 7
    //   242: istore 5
    //   244: iload 7
    //   246: istore 6
    //   248: aload_1
    //   249: iload 9
    //   251: invokevirtual 109	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:popLimit	(I)V
    //   254: iload 7
    //   256: istore_3
    //   257: goto -216 -> 41
    //   260: iload_3
    //   261: istore 7
    //   263: iload_3
    //   264: iconst_2
    //   265: iand
    //   266: iconst_2
    //   267: if_icmpeq +28 -> 295
    //   270: iload_3
    //   271: istore 4
    //   273: iload_3
    //   274: istore 5
    //   276: iload_3
    //   277: istore 6
    //   279: aload_0
    //   280: new 87	java/util/ArrayList
    //   283: dup
    //   284: invokespecial 88	java/util/ArrayList:<init>	()V
    //   287: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localName_	Ljava/util/List;
    //   290: iload_3
    //   291: iconst_2
    //   292: ior
    //   293: istore 7
    //   295: iload 7
    //   297: istore 4
    //   299: iload 7
    //   301: istore 5
    //   303: iload 7
    //   305: istore 6
    //   307: aload_0
    //   308: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localName_	Ljava/util/List;
    //   311: aload_1
    //   312: invokevirtual 93	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readInt32	()I
    //   315: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: invokeinterface 105 2 0
    //   323: pop
    //   324: iload 7
    //   326: istore_3
    //   327: goto -286 -> 41
    //   330: iload_3
    //   331: istore 7
    //   333: iload_3
    //   334: iconst_1
    //   335: iand
    //   336: iconst_1
    //   337: if_icmpeq +28 -> 365
    //   340: iload_3
    //   341: istore 4
    //   343: iload_3
    //   344: istore 5
    //   346: iload_3
    //   347: istore 6
    //   349: aload_0
    //   350: new 87	java/util/ArrayList
    //   353: dup
    //   354: invokespecial 88	java/util/ArrayList:<init>	()V
    //   357: putfield 111	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:record_	Ljava/util/List;
    //   360: iload_3
    //   361: iconst_1
    //   362: ior
    //   363: istore 7
    //   365: iload 7
    //   367: istore 4
    //   369: iload 7
    //   371: istore 5
    //   373: iload 7
    //   375: istore 6
    //   377: aload_0
    //   378: getfield 111	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:record_	Ljava/util/List;
    //   381: aload_1
    //   382: getstatic 114	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Record:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   385: aload_2
    //   386: invokevirtual 118	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   389: invokeinterface 105 2 0
    //   394: pop
    //   395: iload 7
    //   397: istore_3
    //   398: goto -357 -> 41
    //   401: iconst_1
    //   402: istore 8
    //   404: goto -363 -> 41
    //   407: astore_1
    //   408: goto +35 -> 443
    //   411: astore_1
    //   412: iload 5
    //   414: istore 4
    //   416: new 44	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   419: dup
    //   420: aload_1
    //   421: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   424: invokespecial 125	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   427: aload_0
    //   428: invokevirtual 129	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   431: athrow
    //   432: astore_1
    //   433: iload 6
    //   435: istore 4
    //   437: aload_1
    //   438: aload_0
    //   439: invokevirtual 129	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   442: athrow
    //   443: iload 4
    //   445: iconst_1
    //   446: iand
    //   447: iconst_1
    //   448: if_icmpne +14 -> 462
    //   451: aload_0
    //   452: aload_0
    //   453: getfield 111	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:record_	Ljava/util/List;
    //   456: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   459: putfield 111	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:record_	Ljava/util/List;
    //   462: iload 4
    //   464: iconst_2
    //   465: iand
    //   466: iconst_2
    //   467: if_icmpne +14 -> 481
    //   470: aload_0
    //   471: aload_0
    //   472: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localName_	Ljava/util/List;
    //   475: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   478: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localName_	Ljava/util/List;
    //   481: aload 11
    //   483: invokevirtual 138	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   486: aload_0
    //   487: aload 10
    //   489: invokevirtual 144	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   492: putfield 146	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   495: goto +15 -> 510
    //   498: astore_1
    //   499: aload_0
    //   500: aload 10
    //   502: invokevirtual 144	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   505: putfield 146	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   508: aload_1
    //   509: athrow
    //   510: aload_0
    //   511: invokevirtual 149	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:makeExtensionsImmutable	()V
    //   514: aload_1
    //   515: athrow
    //   516: iload_3
    //   517: iconst_1
    //   518: iand
    //   519: iconst_1
    //   520: if_icmpne +14 -> 534
    //   523: aload_0
    //   524: aload_0
    //   525: getfield 111	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:record_	Ljava/util/List;
    //   528: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   531: putfield 111	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:record_	Ljava/util/List;
    //   534: iload_3
    //   535: iconst_2
    //   536: iand
    //   537: iconst_2
    //   538: if_icmpne +14 -> 552
    //   541: aload_0
    //   542: aload_0
    //   543: getfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localName_	Ljava/util/List;
    //   546: invokestatic 135	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   549: putfield 90	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:localName_	Ljava/util/List;
    //   552: aload 11
    //   554: invokevirtual 138	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   557: aload_0
    //   558: aload 10
    //   560: invokevirtual 144	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   563: putfield 146	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   566: goto +15 -> 581
    //   569: astore_1
    //   570: aload_0
    //   571: aload 10
    //   573: invokevirtual 144	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   576: putfield 146	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   579: aload_1
    //   580: athrow
    //   581: aload_0
    //   582: invokevirtual 149	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:makeExtensionsImmutable	()V
    //   585: return
    //   586: astore_2
    //   587: goto -101 -> 486
    //   590: astore_1
    //   591: goto -34 -> 557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	StringTableTypes
    //   0	594	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	594	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   40	497	3	i	int
    //   47	419	4	j	int
    //   50	363	5	k	int
    //   53	381	6	m	int
    //   59	337	7	n	int
    //   37	366	8	i1	int
    //   129	121	9	i2	int
    //   26	546	10	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   34	519	11	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   55	61	407	finally
    //   96	109	407	finally
    //   121	131	407	finally
    //   153	160	407	finally
    //   169	180	407	finally
    //   197	204	407	finally
    //   216	233	407	finally
    //   248	254	407	finally
    //   279	290	407	finally
    //   307	324	407	finally
    //   349	360	407	finally
    //   377	395	407	finally
    //   416	432	407	finally
    //   437	443	407	finally
    //   55	61	411	java/io/IOException
    //   96	109	411	java/io/IOException
    //   121	131	411	java/io/IOException
    //   153	160	411	java/io/IOException
    //   169	180	411	java/io/IOException
    //   197	204	411	java/io/IOException
    //   216	233	411	java/io/IOException
    //   248	254	411	java/io/IOException
    //   279	290	411	java/io/IOException
    //   307	324	411	java/io/IOException
    //   349	360	411	java/io/IOException
    //   377	395	411	java/io/IOException
    //   55	61	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   96	109	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   121	131	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   153	160	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   169	180	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   197	204	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   216	233	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   248	254	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   279	290	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   307	324	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   349	360	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   377	395	432	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   481	486	498	finally
    //   552	557	569	finally
    //   481	486	586	java/io/IOException
    //   552	557	590	java/io/IOException
  }
  
  private JvmProtoBuf$StringTableTypes(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private JvmProtoBuf$StringTableTypes(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static StringTableTypes getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.record_ = Collections.emptyList();
    this.localName_ = Collections.emptyList();
  }
  
  public static JvmProtoBuf.StringTableTypes.Builder newBuilder()
  {
    return JvmProtoBuf.StringTableTypes.Builder.access$1200();
  }
  
  public static JvmProtoBuf.StringTableTypes.Builder newBuilder(StringTableTypes paramStringTableTypes)
  {
    return newBuilder().mergeFrom(paramStringTableTypes);
  }
  
  public static StringTableTypes parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (StringTableTypes)PARSER.parseDelimitedFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public StringTableTypes getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public List<Integer> getLocalNameList()
  {
    return this.localName_;
  }
  
  public Parser<StringTableTypes> getParserForType()
  {
    return PARSER;
  }
  
  public List<JvmProtoBuf.StringTableTypes.Record> getRecordList()
  {
    return this.record_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    int k = 0;
    int j = 0;
    i = 0;
    while (j < this.record_.size())
    {
      i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.record_.get(j));
      j += 1;
    }
    j = 0;
    while (k < this.localName_.size())
    {
      j += CodedOutputStream.computeInt32SizeNoTag(((Integer)this.localName_.get(k)).intValue());
      k += 1;
    }
    k = i + j;
    i = k;
    if (!getLocalNameList().isEmpty()) {
      i = k + 1 + CodedOutputStream.computeInt32SizeNoTag(j);
    }
    this.localNameMemoizedSerializedSize = j;
    i += this.unknownFields.size();
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
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public JvmProtoBuf.StringTableTypes.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public JvmProtoBuf.StringTableTypes.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    int j = 0;
    int i = 0;
    while (i < this.record_.size())
    {
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.record_.get(i));
      i += 1;
    }
    i = j;
    if (getLocalNameList().size() > 0)
    {
      paramCodedOutputStream.writeRawVarint32(42);
      paramCodedOutputStream.writeRawVarint32(this.localNameMemoizedSerializedSize);
      i = j;
    }
    while (i < this.localName_.size())
    {
      paramCodedOutputStream.writeInt32NoTag(((Integer)this.localName_.get(i)).intValue());
      i += 1;
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes
 * JD-Core Version:    0.7.0.1
 */