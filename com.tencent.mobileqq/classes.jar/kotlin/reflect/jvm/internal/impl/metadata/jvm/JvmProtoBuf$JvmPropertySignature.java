package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class JvmProtoBuf$JvmPropertySignature
  extends GeneratedMessageLite
  implements JvmProtoBuf.JvmPropertySignatureOrBuilder
{
  public static Parser<JvmPropertySignature> PARSER = new JvmProtoBuf.JvmPropertySignature.1();
  private static final JvmPropertySignature defaultInstance = new JvmPropertySignature(true);
  private int bitField0_;
  private JvmProtoBuf.JvmFieldSignature field_;
  private JvmProtoBuf.JvmMethodSignature getter_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private JvmProtoBuf.JvmMethodSignature setter_;
  private JvmProtoBuf.JvmMethodSignature syntheticMethod_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private JvmProtoBuf$JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 48	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 50	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 52	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 41	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:initFields	()V
    //   18: invokestatic 58	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 9
    //   23: aload 9
    //   25: iconst_1
    //   26: invokestatic 64	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 10
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: ifne +437 -> 471
    //   37: aload_1
    //   38: invokevirtual 70	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   41: istore 4
    //   43: iload 4
    //   45: ifeq +358 -> 403
    //   48: aconst_null
    //   49: astore 6
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 8
    //   57: aconst_null
    //   58: astore 5
    //   60: iload 4
    //   62: bipush 10
    //   64: if_icmpeq +264 -> 328
    //   67: iload 4
    //   69: bipush 18
    //   71: if_icmpeq +182 -> 253
    //   74: iload 4
    //   76: bipush 26
    //   78: if_icmpeq +100 -> 178
    //   81: iload 4
    //   83: bipush 34
    //   85: if_icmpeq +19 -> 104
    //   88: aload_0
    //   89: aload_1
    //   90: aload 10
    //   92: aload_2
    //   93: iload 4
    //   95: invokevirtual 74	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   98: ifne -65 -> 33
    //   101: goto +302 -> 403
    //   104: aload_0
    //   105: getfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   108: bipush 8
    //   110: iand
    //   111: bipush 8
    //   113: if_icmpne +12 -> 125
    //   116: aload_0
    //   117: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:setter_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   120: invokevirtual 84	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder;
    //   123: astore 5
    //   125: aload_0
    //   126: aload_1
    //   127: getstatic 85	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   130: aload_2
    //   131: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   134: checkcast 80	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature
    //   137: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:setter_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   140: aload 5
    //   142: ifnull +22 -> 164
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 78	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:setter_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   151: invokevirtual 95	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder;
    //   154: pop
    //   155: aload_0
    //   156: aload 5
    //   158: invokevirtual 99	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   161: putfield 78	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:setter_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   164: aload_0
    //   165: aload_0
    //   166: getfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   169: bipush 8
    //   171: ior
    //   172: putfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   175: goto -142 -> 33
    //   178: aload 6
    //   180: astore 5
    //   182: aload_0
    //   183: getfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   186: iconst_4
    //   187: iand
    //   188: iconst_4
    //   189: if_icmpne +12 -> 201
    //   192: aload_0
    //   193: getfield 101	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:getter_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   196: invokevirtual 84	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder;
    //   199: astore 5
    //   201: aload_0
    //   202: aload_1
    //   203: getstatic 85	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   206: aload_2
    //   207: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   210: checkcast 80	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature
    //   213: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:getter_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   216: aload 5
    //   218: ifnull +22 -> 240
    //   221: aload 5
    //   223: aload_0
    //   224: getfield 101	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:getter_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   227: invokevirtual 95	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder;
    //   230: pop
    //   231: aload_0
    //   232: aload 5
    //   234: invokevirtual 99	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   237: putfield 101	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:getter_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   245: iconst_4
    //   246: ior
    //   247: putfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   250: goto -217 -> 33
    //   253: aload 7
    //   255: astore 5
    //   257: aload_0
    //   258: getfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   261: iconst_2
    //   262: iand
    //   263: iconst_2
    //   264: if_icmpne +12 -> 276
    //   267: aload_0
    //   268: getfield 103	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:syntheticMethod_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   271: invokevirtual 84	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder;
    //   274: astore 5
    //   276: aload_0
    //   277: aload_1
    //   278: getstatic 85	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   281: aload_2
    //   282: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   285: checkcast 80	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature
    //   288: putfield 103	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:syntheticMethod_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   291: aload 5
    //   293: ifnull +22 -> 315
    //   296: aload 5
    //   298: aload_0
    //   299: getfield 103	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:syntheticMethod_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   302: invokevirtual 95	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder;
    //   305: pop
    //   306: aload_0
    //   307: aload 5
    //   309: invokevirtual 99	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   312: putfield 103	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:syntheticMethod_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   320: iconst_2
    //   321: ior
    //   322: putfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   325: goto -292 -> 33
    //   328: aload 8
    //   330: astore 5
    //   332: aload_0
    //   333: getfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   336: iconst_1
    //   337: iand
    //   338: iconst_1
    //   339: if_icmpne +12 -> 351
    //   342: aload_0
    //   343: getfield 105	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:field_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature;
    //   346: invokevirtual 110	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature$Builder;
    //   349: astore 5
    //   351: aload_0
    //   352: aload_1
    //   353: getstatic 111	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   356: aload_2
    //   357: invokevirtual 89	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   360: checkcast 107	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature
    //   363: putfield 105	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:field_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature;
    //   366: aload 5
    //   368: ifnull +22 -> 390
    //   371: aload 5
    //   373: aload_0
    //   374: getfield 105	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:field_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature;
    //   377: invokevirtual 116	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature$Builder;
    //   380: pop
    //   381: aload_0
    //   382: aload 5
    //   384: invokevirtual 119	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature;
    //   387: putfield 105	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:field_	Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmFieldSignature;
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   395: iconst_1
    //   396: ior
    //   397: putfield 76	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:bitField0_	I
    //   400: goto -367 -> 33
    //   403: iconst_1
    //   404: istore_3
    //   405: goto -372 -> 33
    //   408: astore_1
    //   409: goto +27 -> 436
    //   412: astore_1
    //   413: new 45	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   416: dup
    //   417: aload_1
    //   418: invokevirtual 123	java/io/IOException:getMessage	()Ljava/lang/String;
    //   421: invokespecial 126	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   424: aload_0
    //   425: invokevirtual 130	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   428: athrow
    //   429: astore_1
    //   430: aload_1
    //   431: aload_0
    //   432: invokevirtual 130	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   435: athrow
    //   436: aload 10
    //   438: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   441: aload_0
    //   442: aload 9
    //   444: invokevirtual 139	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   447: putfield 141	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   450: goto +15 -> 465
    //   453: astore_1
    //   454: aload_0
    //   455: aload 9
    //   457: invokevirtual 139	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   460: putfield 141	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   463: aload_1
    //   464: athrow
    //   465: aload_0
    //   466: invokevirtual 144	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:makeExtensionsImmutable	()V
    //   469: aload_1
    //   470: athrow
    //   471: aload 10
    //   473: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   476: aload_0
    //   477: aload 9
    //   479: invokevirtual 139	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   482: putfield 141	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   485: goto +15 -> 500
    //   488: astore_1
    //   489: aload_0
    //   490: aload 9
    //   492: invokevirtual 139	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   495: putfield 141	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   498: aload_1
    //   499: athrow
    //   500: aload_0
    //   501: invokevirtual 144	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:makeExtensionsImmutable	()V
    //   504: return
    //   505: astore_2
    //   506: goto -65 -> 441
    //   509: astore_1
    //   510: goto -34 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	JvmPropertySignature
    //   0	513	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	513	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   32	373	3	i	int
    //   41	53	4	j	int
    //   58	325	5	localObject1	java.lang.Object
    //   49	130	6	localObject2	java.lang.Object
    //   52	202	7	localObject3	java.lang.Object
    //   55	274	8	localObject4	java.lang.Object
    //   21	470	9	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	443	10	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   37	43	408	finally
    //   88	101	408	finally
    //   104	125	408	finally
    //   125	140	408	finally
    //   145	164	408	finally
    //   164	175	408	finally
    //   182	201	408	finally
    //   201	216	408	finally
    //   221	240	408	finally
    //   240	250	408	finally
    //   257	276	408	finally
    //   276	291	408	finally
    //   296	315	408	finally
    //   315	325	408	finally
    //   332	351	408	finally
    //   351	366	408	finally
    //   371	390	408	finally
    //   390	400	408	finally
    //   413	429	408	finally
    //   430	436	408	finally
    //   37	43	412	java/io/IOException
    //   88	101	412	java/io/IOException
    //   104	125	412	java/io/IOException
    //   125	140	412	java/io/IOException
    //   145	164	412	java/io/IOException
    //   164	175	412	java/io/IOException
    //   182	201	412	java/io/IOException
    //   201	216	412	java/io/IOException
    //   221	240	412	java/io/IOException
    //   240	250	412	java/io/IOException
    //   257	276	412	java/io/IOException
    //   276	291	412	java/io/IOException
    //   296	315	412	java/io/IOException
    //   315	325	412	java/io/IOException
    //   332	351	412	java/io/IOException
    //   351	366	412	java/io/IOException
    //   371	390	412	java/io/IOException
    //   390	400	412	java/io/IOException
    //   37	43	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   88	101	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   104	125	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   125	140	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   145	164	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   164	175	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   182	201	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   201	216	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   221	240	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   240	250	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   257	276	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   276	291	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   296	315	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   315	325	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   332	351	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   351	366	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   371	390	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   390	400	429	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   436	441	453	finally
    //   471	476	488	finally
    //   436	441	505	java/io/IOException
    //   471	476	509	java/io/IOException
  }
  
  private JvmProtoBuf$JvmPropertySignature(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private JvmProtoBuf$JvmPropertySignature(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static JvmPropertySignature getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.field_ = JvmProtoBuf.JvmFieldSignature.getDefaultInstance();
    this.syntheticMethod_ = JvmProtoBuf.JvmMethodSignature.getDefaultInstance();
    this.getter_ = JvmProtoBuf.JvmMethodSignature.getDefaultInstance();
    this.setter_ = JvmProtoBuf.JvmMethodSignature.getDefaultInstance();
  }
  
  public static JvmProtoBuf.JvmPropertySignature.Builder newBuilder()
  {
    return JvmProtoBuf.JvmPropertySignature.Builder.access$3200();
  }
  
  public static JvmProtoBuf.JvmPropertySignature.Builder newBuilder(JvmPropertySignature paramJvmPropertySignature)
  {
    return newBuilder().mergeFrom(paramJvmPropertySignature);
  }
  
  public JvmPropertySignature getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public JvmProtoBuf.JvmFieldSignature getField()
  {
    return this.field_;
  }
  
  public JvmProtoBuf.JvmMethodSignature getGetter()
  {
    return this.getter_;
  }
  
  public Parser<JvmPropertySignature> getParserForType()
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
      j = 0 + CodedOutputStream.computeMessageSize(1, this.field_);
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
    }
    j = i;
    if ((this.bitField0_ & 0x4) == 4) {
      j = i + CodedOutputStream.computeMessageSize(3, this.getter_);
    }
    i = j;
    if ((this.bitField0_ & 0x8) == 8) {
      i = j + CodedOutputStream.computeMessageSize(4, this.setter_);
    }
    i += this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public JvmProtoBuf.JvmMethodSignature getSetter()
  {
    return this.setter_;
  }
  
  public JvmProtoBuf.JvmMethodSignature getSyntheticMethod()
  {
    return this.syntheticMethod_;
  }
  
  public boolean hasField()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasGetter()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasSetter()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasSyntheticMethod()
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
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public JvmProtoBuf.JvmPropertySignature.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public JvmProtoBuf.JvmPropertySignature.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeMessage(1, this.field_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeMessage(2, this.syntheticMethod_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeMessage(3, this.getter_);
    }
    if ((this.bitField0_ & 0x8) == 8) {
      paramCodedOutputStream.writeMessage(4, this.setter_);
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature
 * JD-Core Version:    0.7.0.1
 */