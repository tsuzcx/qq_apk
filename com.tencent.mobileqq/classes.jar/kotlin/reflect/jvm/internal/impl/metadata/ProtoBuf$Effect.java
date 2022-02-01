package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$Effect
  extends GeneratedMessageLite
  implements ProtoBuf.EffectOrBuilder
{
  public static Parser<Effect> PARSER = new ProtoBuf.Effect.1();
  private static final Effect defaultInstance = new Effect(true);
  private int bitField0_;
  private ProtoBuf.Expression conclusionOfConditionalEffect_;
  private List<ProtoBuf.Expression> effectConstructorArgument_;
  private ProtoBuf.Effect.EffectType effectType_;
  private ProtoBuf.Effect.InvocationKind kind_;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$Effect(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 51	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 53	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 55	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 44	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:initFields	()V
    //   18: invokestatic 61	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 11
    //   23: aload 11
    //   25: iconst_1
    //   26: invokestatic 67	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 12
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +587 -> 625
    //   41: iload_3
    //   42: istore 5
    //   44: iload_3
    //   45: istore 6
    //   47: iload_3
    //   48: istore 7
    //   50: aload_1
    //   51: invokevirtual 73	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 4
    //   56: iload 4
    //   58: ifeq +471 -> 529
    //   61: iload 4
    //   63: bipush 8
    //   65: if_icmpeq +356 -> 421
    //   68: iload 4
    //   70: bipush 18
    //   72: if_icmpeq +278 -> 350
    //   75: iload 4
    //   77: bipush 26
    //   79: if_icmpeq +143 -> 222
    //   82: iload 4
    //   84: bipush 32
    //   86: if_icmpeq +28 -> 114
    //   89: iload_3
    //   90: istore 5
    //   92: iload_3
    //   93: istore 6
    //   95: iload_3
    //   96: istore 7
    //   98: aload_0
    //   99: aload_1
    //   100: aload 12
    //   102: aload_2
    //   103: iload 4
    //   105: invokevirtual 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   108: ifne -72 -> 36
    //   111: goto +418 -> 529
    //   114: iload_3
    //   115: istore 5
    //   117: iload_3
    //   118: istore 6
    //   120: iload_3
    //   121: istore 7
    //   123: aload_1
    //   124: invokevirtual 80	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   127: istore 9
    //   129: iload_3
    //   130: istore 5
    //   132: iload_3
    //   133: istore 6
    //   135: iload_3
    //   136: istore 7
    //   138: iload 9
    //   140: invokestatic 86	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$InvocationKind:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$InvocationKind;
    //   143: astore 10
    //   145: aload 10
    //   147: ifnonnull +38 -> 185
    //   150: iload_3
    //   151: istore 5
    //   153: iload_3
    //   154: istore 6
    //   156: iload_3
    //   157: istore 7
    //   159: aload 12
    //   161: iload 4
    //   163: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   166: iload_3
    //   167: istore 5
    //   169: iload_3
    //   170: istore 6
    //   172: iload_3
    //   173: istore 7
    //   175: aload 12
    //   177: iload 9
    //   179: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   182: goto -146 -> 36
    //   185: iload_3
    //   186: istore 5
    //   188: iload_3
    //   189: istore 6
    //   191: iload_3
    //   192: istore 7
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:bitField0_	I
    //   199: iconst_4
    //   200: ior
    //   201: putfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:bitField0_	I
    //   204: iload_3
    //   205: istore 5
    //   207: iload_3
    //   208: istore 6
    //   210: iload_3
    //   211: istore 7
    //   213: aload_0
    //   214: aload 10
    //   216: putfield 94	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:kind_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$InvocationKind;
    //   219: goto -183 -> 36
    //   222: aconst_null
    //   223: astore 10
    //   225: iload_3
    //   226: istore 5
    //   228: iload_3
    //   229: istore 6
    //   231: iload_3
    //   232: istore 7
    //   234: aload_0
    //   235: getfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:bitField0_	I
    //   238: iconst_2
    //   239: iand
    //   240: iconst_2
    //   241: if_icmpne +21 -> 262
    //   244: iload_3
    //   245: istore 5
    //   247: iload_3
    //   248: istore 6
    //   250: iload_3
    //   251: istore 7
    //   253: aload_0
    //   254: getfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:conclusionOfConditionalEffect_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression;
    //   257: invokevirtual 102	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$Builder;
    //   260: astore 10
    //   262: iload_3
    //   263: istore 5
    //   265: iload_3
    //   266: istore 6
    //   268: iload_3
    //   269: istore 7
    //   271: aload_0
    //   272: aload_1
    //   273: getstatic 103	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   276: aload_2
    //   277: invokevirtual 107	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   280: checkcast 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression
    //   283: putfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:conclusionOfConditionalEffect_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression;
    //   286: aload 10
    //   288: ifnull +40 -> 328
    //   291: iload_3
    //   292: istore 5
    //   294: iload_3
    //   295: istore 6
    //   297: iload_3
    //   298: istore 7
    //   300: aload 10
    //   302: aload_0
    //   303: getfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:conclusionOfConditionalEffect_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression;
    //   306: invokevirtual 113	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$Builder;
    //   309: pop
    //   310: iload_3
    //   311: istore 5
    //   313: iload_3
    //   314: istore 6
    //   316: iload_3
    //   317: istore 7
    //   319: aload_0
    //   320: aload 10
    //   322: invokevirtual 117	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression;
    //   325: putfield 96	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:conclusionOfConditionalEffect_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression;
    //   328: iload_3
    //   329: istore 5
    //   331: iload_3
    //   332: istore 6
    //   334: iload_3
    //   335: istore 7
    //   337: aload_0
    //   338: aload_0
    //   339: getfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:bitField0_	I
    //   342: iconst_2
    //   343: ior
    //   344: putfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:bitField0_	I
    //   347: goto -311 -> 36
    //   350: iload_3
    //   351: istore 4
    //   353: iload_3
    //   354: iconst_2
    //   355: iand
    //   356: iconst_2
    //   357: if_icmpeq +28 -> 385
    //   360: iload_3
    //   361: istore 5
    //   363: iload_3
    //   364: istore 6
    //   366: iload_3
    //   367: istore 7
    //   369: aload_0
    //   370: new 119	java/util/ArrayList
    //   373: dup
    //   374: invokespecial 120	java/util/ArrayList:<init>	()V
    //   377: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:effectConstructorArgument_	Ljava/util/List;
    //   380: iload_3
    //   381: iconst_2
    //   382: ior
    //   383: istore 4
    //   385: iload 4
    //   387: istore 5
    //   389: iload 4
    //   391: istore 6
    //   393: iload 4
    //   395: istore 7
    //   397: aload_0
    //   398: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:effectConstructorArgument_	Ljava/util/List;
    //   401: aload_1
    //   402: getstatic 103	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   405: aload_2
    //   406: invokevirtual 107	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   409: invokeinterface 128 2 0
    //   414: pop
    //   415: iload 4
    //   417: istore_3
    //   418: goto -382 -> 36
    //   421: iload_3
    //   422: istore 5
    //   424: iload_3
    //   425: istore 6
    //   427: iload_3
    //   428: istore 7
    //   430: aload_1
    //   431: invokevirtual 80	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readEnum	()I
    //   434: istore 9
    //   436: iload_3
    //   437: istore 5
    //   439: iload_3
    //   440: istore 6
    //   442: iload_3
    //   443: istore 7
    //   445: iload 9
    //   447: invokestatic 133	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$EffectType:valueOf	(I)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$EffectType;
    //   450: astore 10
    //   452: aload 10
    //   454: ifnonnull +38 -> 492
    //   457: iload_3
    //   458: istore 5
    //   460: iload_3
    //   461: istore 6
    //   463: iload_3
    //   464: istore 7
    //   466: aload 12
    //   468: iload 4
    //   470: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   473: iload_3
    //   474: istore 5
    //   476: iload_3
    //   477: istore 6
    //   479: iload_3
    //   480: istore 7
    //   482: aload 12
    //   484: iload 9
    //   486: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:writeRawVarint32	(I)V
    //   489: goto -453 -> 36
    //   492: iload_3
    //   493: istore 5
    //   495: iload_3
    //   496: istore 6
    //   498: iload_3
    //   499: istore 7
    //   501: aload_0
    //   502: aload_0
    //   503: getfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:bitField0_	I
    //   506: iconst_1
    //   507: ior
    //   508: putfield 92	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:bitField0_	I
    //   511: iload_3
    //   512: istore 5
    //   514: iload_3
    //   515: istore 6
    //   517: iload_3
    //   518: istore 7
    //   520: aload_0
    //   521: aload 10
    //   523: putfield 135	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:effectType_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$EffectType;
    //   526: goto -490 -> 36
    //   529: iconst_1
    //   530: istore 8
    //   532: goto -496 -> 36
    //   535: astore_1
    //   536: goto +35 -> 571
    //   539: astore_1
    //   540: iload 6
    //   542: istore 5
    //   544: new 48	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   547: dup
    //   548: aload_1
    //   549: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   552: invokespecial 142	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   555: aload_0
    //   556: invokevirtual 146	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   559: athrow
    //   560: astore_1
    //   561: iload 7
    //   563: istore 5
    //   565: aload_1
    //   566: aload_0
    //   567: invokevirtual 146	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   570: athrow
    //   571: iload 5
    //   573: iconst_2
    //   574: iand
    //   575: iconst_2
    //   576: if_icmpne +14 -> 590
    //   579: aload_0
    //   580: aload_0
    //   581: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:effectConstructorArgument_	Ljava/util/List;
    //   584: invokestatic 152	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   587: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:effectConstructorArgument_	Ljava/util/List;
    //   590: aload 12
    //   592: invokevirtual 155	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   595: aload_0
    //   596: aload 11
    //   598: invokevirtual 161	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   601: putfield 163	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   604: goto +15 -> 619
    //   607: astore_1
    //   608: aload_0
    //   609: aload 11
    //   611: invokevirtual 161	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   614: putfield 163	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   617: aload_1
    //   618: athrow
    //   619: aload_0
    //   620: invokevirtual 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:makeExtensionsImmutable	()V
    //   623: aload_1
    //   624: athrow
    //   625: iload_3
    //   626: iconst_2
    //   627: iand
    //   628: iconst_2
    //   629: if_icmpne +14 -> 643
    //   632: aload_0
    //   633: aload_0
    //   634: getfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:effectConstructorArgument_	Ljava/util/List;
    //   637: invokestatic 152	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   640: putfield 122	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:effectConstructorArgument_	Ljava/util/List;
    //   643: aload 12
    //   645: invokevirtual 155	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   648: aload_0
    //   649: aload 11
    //   651: invokevirtual 161	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   654: putfield 163	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   657: goto +15 -> 672
    //   660: astore_1
    //   661: aload_0
    //   662: aload 11
    //   664: invokevirtual 161	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   667: putfield 163	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   670: aload_1
    //   671: athrow
    //   672: aload_0
    //   673: invokevirtual 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:makeExtensionsImmutable	()V
    //   676: return
    //   677: astore_2
    //   678: goto -83 -> 595
    //   681: astore_1
    //   682: goto -34 -> 648
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	Effect
    //   0	685	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	685	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   35	593	3	i	int
    //   54	415	4	j	int
    //   42	533	5	k	int
    //   45	496	6	m	int
    //   48	514	7	n	int
    //   32	499	8	i1	int
    //   127	358	9	i2	int
    //   143	379	10	localObject	java.lang.Object
    //   21	642	11	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	615	12	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	535	finally
    //   98	111	535	finally
    //   123	129	535	finally
    //   138	145	535	finally
    //   159	166	535	finally
    //   175	182	535	finally
    //   194	204	535	finally
    //   213	219	535	finally
    //   234	244	535	finally
    //   253	262	535	finally
    //   271	286	535	finally
    //   300	310	535	finally
    //   319	328	535	finally
    //   337	347	535	finally
    //   369	380	535	finally
    //   397	415	535	finally
    //   430	436	535	finally
    //   445	452	535	finally
    //   466	473	535	finally
    //   482	489	535	finally
    //   501	511	535	finally
    //   520	526	535	finally
    //   544	560	535	finally
    //   565	571	535	finally
    //   50	56	539	java/io/IOException
    //   98	111	539	java/io/IOException
    //   123	129	539	java/io/IOException
    //   138	145	539	java/io/IOException
    //   159	166	539	java/io/IOException
    //   175	182	539	java/io/IOException
    //   194	204	539	java/io/IOException
    //   213	219	539	java/io/IOException
    //   234	244	539	java/io/IOException
    //   253	262	539	java/io/IOException
    //   271	286	539	java/io/IOException
    //   300	310	539	java/io/IOException
    //   319	328	539	java/io/IOException
    //   337	347	539	java/io/IOException
    //   369	380	539	java/io/IOException
    //   397	415	539	java/io/IOException
    //   430	436	539	java/io/IOException
    //   445	452	539	java/io/IOException
    //   466	473	539	java/io/IOException
    //   482	489	539	java/io/IOException
    //   501	511	539	java/io/IOException
    //   520	526	539	java/io/IOException
    //   50	56	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   98	111	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   123	129	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   138	145	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   159	166	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   175	182	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   194	204	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   213	219	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   234	244	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   253	262	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   271	286	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   300	310	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   319	328	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   337	347	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   369	380	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   397	415	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   430	436	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   445	452	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   466	473	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   482	489	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   501	511	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   520	526	560	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   590	595	607	finally
    //   643	648	660	finally
    //   590	595	677	java/io/IOException
    //   643	648	681	java/io/IOException
  }
  
  private ProtoBuf$Effect(GeneratedMessageLite.Builder paramBuilder)
  {
    super(paramBuilder);
    this.unknownFields = paramBuilder.getUnknownFields();
  }
  
  private ProtoBuf$Effect(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static Effect getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.effectType_ = ProtoBuf.Effect.EffectType.RETURNS_CONSTANT;
    this.effectConstructorArgument_ = Collections.emptyList();
    this.conclusionOfConditionalEffect_ = ProtoBuf.Expression.getDefaultInstance();
    this.kind_ = ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE;
  }
  
  public static ProtoBuf.Effect.Builder newBuilder()
  {
    return ProtoBuf.Effect.Builder.access$22800();
  }
  
  public static ProtoBuf.Effect.Builder newBuilder(Effect paramEffect)
  {
    return newBuilder().mergeFrom(paramEffect);
  }
  
  public ProtoBuf.Expression getConclusionOfConditionalEffect()
  {
    return this.conclusionOfConditionalEffect_;
  }
  
  public Effect getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public ProtoBuf.Expression getEffectConstructorArgument(int paramInt)
  {
    return (ProtoBuf.Expression)this.effectConstructorArgument_.get(paramInt);
  }
  
  public int getEffectConstructorArgumentCount()
  {
    return this.effectConstructorArgument_.size();
  }
  
  public ProtoBuf.Effect.EffectType getEffectType()
  {
    return this.effectType_;
  }
  
  public ProtoBuf.Effect.InvocationKind getKind()
  {
    return this.kind_;
  }
  
  public Parser<Effect> getParserForType()
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
      i = CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0;
    } else {
      i = 0;
    }
    while (j < this.effectConstructorArgument_.size())
    {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.effectConstructorArgument_.get(j));
      j += 1;
    }
    j = i;
    if ((this.bitField0_ & 0x2) == 2) {
      j = i + CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
    }
    i = j;
    if ((this.bitField0_ & 0x4) == 4) {
      i = j + CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
    }
    i += this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasConclusionOfConditionalEffect()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasEffectType()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasKind()
  {
    return (this.bitField0_ & 0x4) == 4;
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
    while (i < getEffectConstructorArgumentCount())
    {
      if (!getEffectConstructorArgument(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if ((hasConclusionOfConditionalEffect()) && (!getConclusionOfConditionalEffect().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.Effect.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.Effect.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeEnum(1, this.effectType_.getNumber());
    }
    int i = 0;
    while (i < this.effectConstructorArgument_.size())
    {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.effectConstructorArgument_.get(i));
      i += 1;
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeEnum(4, this.kind_.getNumber());
    }
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect
 * JD-Core Version:    0.7.0.1
 */