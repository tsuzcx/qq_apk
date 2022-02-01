package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

public final class ProtoBuf$PackageFragment
  extends GeneratedMessageLite.ExtendableMessage<PackageFragment>
  implements ProtoBuf.PackageFragmentOrBuilder
{
  public static Parser<PackageFragment> PARSER = new ProtoBuf.PackageFragment.1();
  private static final PackageFragment defaultInstance = new PackageFragment(true);
  private int bitField0_;
  private List<ProtoBuf.Class> class__;
  private byte memoizedIsInitialized = -1;
  private int memoizedSerializedSize = -1;
  private ProtoBuf.Package package_;
  private ProtoBuf.QualifiedNameTable qualifiedNames_;
  private ProtoBuf.StringTable strings_;
  private final ByteString unknownFields;
  
  static
  {
    defaultInstance.initFields();
  }
  
  /* Error */
  private ProtoBuf$PackageFragment(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 52	kotlin/reflect/jvm/internal/impl/protobuf/GeneratedMessageLite$ExtendableMessage:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 54	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:memoizedIsInitialized	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 56	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:memoizedSerializedSize	I
    //   14: aload_0
    //   15: invokespecial 45	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:initFields	()V
    //   18: invokestatic 62	kotlin/reflect/jvm/internal/impl/protobuf/ByteString:newOutput	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output;
    //   21: astore 12
    //   23: aload 12
    //   25: iconst_1
    //   26: invokestatic 68	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:newInstance	(Ljava/io/OutputStream;I)Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;
    //   29: astore 13
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 8
    //   38: ifne +640 -> 678
    //   41: iload_3
    //   42: istore 5
    //   44: iload_3
    //   45: istore 6
    //   47: iload_3
    //   48: istore 7
    //   50: aload_1
    //   51: invokevirtual 74	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readTag	()I
    //   54: istore 4
    //   56: iload 4
    //   58: ifeq +522 -> 580
    //   61: aconst_null
    //   62: astore 10
    //   64: aconst_null
    //   65: astore 11
    //   67: aconst_null
    //   68: astore 9
    //   70: iload 4
    //   72: bipush 10
    //   74: if_icmpeq +377 -> 451
    //   77: iload 4
    //   79: bipush 18
    //   81: if_icmpeq +241 -> 322
    //   84: iload 4
    //   86: bipush 26
    //   88: if_icmpeq +109 -> 197
    //   91: iload 4
    //   93: bipush 34
    //   95: if_icmpeq +28 -> 123
    //   98: iload_3
    //   99: istore 5
    //   101: iload_3
    //   102: istore 6
    //   104: iload_3
    //   105: istore 7
    //   107: aload_0
    //   108: aload_1
    //   109: aload 13
    //   111: aload_2
    //   112: iload 4
    //   114: invokevirtual 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:parseUnknownField	(Lkotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;I)Z
    //   117: ifne -81 -> 36
    //   120: goto +460 -> 580
    //   123: iload_3
    //   124: istore 4
    //   126: iload_3
    //   127: bipush 8
    //   129: iand
    //   130: bipush 8
    //   132: if_icmpeq +29 -> 161
    //   135: iload_3
    //   136: istore 5
    //   138: iload_3
    //   139: istore 6
    //   141: iload_3
    //   142: istore 7
    //   144: aload_0
    //   145: new 80	java/util/ArrayList
    //   148: dup
    //   149: invokespecial 81	java/util/ArrayList:<init>	()V
    //   152: putfield 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:class__	Ljava/util/List;
    //   155: iload_3
    //   156: bipush 8
    //   158: ior
    //   159: istore 4
    //   161: iload 4
    //   163: istore 5
    //   165: iload 4
    //   167: istore 6
    //   169: iload 4
    //   171: istore 7
    //   173: aload_0
    //   174: getfield 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:class__	Ljava/util/List;
    //   177: aload_1
    //   178: getstatic 86	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   181: aload_2
    //   182: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   185: invokeinterface 96 2 0
    //   190: pop
    //   191: iload 4
    //   193: istore_3
    //   194: goto -158 -> 36
    //   197: iload_3
    //   198: istore 5
    //   200: iload_3
    //   201: istore 6
    //   203: iload_3
    //   204: istore 7
    //   206: aload_0
    //   207: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   210: iconst_4
    //   211: iand
    //   212: iconst_4
    //   213: if_icmpne +21 -> 234
    //   216: iload_3
    //   217: istore 5
    //   219: iload_3
    //   220: istore 6
    //   222: iload_3
    //   223: istore 7
    //   225: aload_0
    //   226: getfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:package_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;
    //   229: invokevirtual 106	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package$Builder;
    //   232: astore 9
    //   234: iload_3
    //   235: istore 5
    //   237: iload_3
    //   238: istore 6
    //   240: iload_3
    //   241: istore 7
    //   243: aload_0
    //   244: aload_1
    //   245: getstatic 107	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   248: aload_2
    //   249: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   252: checkcast 102	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package
    //   255: putfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:package_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;
    //   258: aload 9
    //   260: ifnull +40 -> 300
    //   263: iload_3
    //   264: istore 5
    //   266: iload_3
    //   267: istore 6
    //   269: iload_3
    //   270: istore 7
    //   272: aload 9
    //   274: aload_0
    //   275: getfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:package_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;
    //   278: invokevirtual 113	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package$Builder;
    //   281: pop
    //   282: iload_3
    //   283: istore 5
    //   285: iload_3
    //   286: istore 6
    //   288: iload_3
    //   289: istore 7
    //   291: aload_0
    //   292: aload 9
    //   294: invokevirtual 117	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;
    //   297: putfield 100	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:package_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;
    //   300: iload_3
    //   301: istore 5
    //   303: iload_3
    //   304: istore 6
    //   306: iload_3
    //   307: istore 7
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   314: iconst_4
    //   315: ior
    //   316: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   319: goto -283 -> 36
    //   322: aload 10
    //   324: astore 9
    //   326: iload_3
    //   327: istore 5
    //   329: iload_3
    //   330: istore 6
    //   332: iload_3
    //   333: istore 7
    //   335: aload_0
    //   336: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   339: iconst_2
    //   340: iand
    //   341: iconst_2
    //   342: if_icmpne +21 -> 363
    //   345: iload_3
    //   346: istore 5
    //   348: iload_3
    //   349: istore 6
    //   351: iload_3
    //   352: istore 7
    //   354: aload_0
    //   355: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:qualifiedNames_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable;
    //   358: invokevirtual 124	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$Builder;
    //   361: astore 9
    //   363: iload_3
    //   364: istore 5
    //   366: iload_3
    //   367: istore 6
    //   369: iload_3
    //   370: istore 7
    //   372: aload_0
    //   373: aload_1
    //   374: getstatic 125	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   377: aload_2
    //   378: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   381: checkcast 121	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable
    //   384: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:qualifiedNames_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable;
    //   387: aload 9
    //   389: ifnull +40 -> 429
    //   392: iload_3
    //   393: istore 5
    //   395: iload_3
    //   396: istore 6
    //   398: iload_3
    //   399: istore 7
    //   401: aload 9
    //   403: aload_0
    //   404: getfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:qualifiedNames_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable;
    //   407: invokevirtual 130	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$Builder;
    //   410: pop
    //   411: iload_3
    //   412: istore 5
    //   414: iload_3
    //   415: istore 6
    //   417: iload_3
    //   418: istore 7
    //   420: aload_0
    //   421: aload 9
    //   423: invokevirtual 133	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable;
    //   426: putfield 119	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:qualifiedNames_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable;
    //   429: iload_3
    //   430: istore 5
    //   432: iload_3
    //   433: istore 6
    //   435: iload_3
    //   436: istore 7
    //   438: aload_0
    //   439: aload_0
    //   440: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   443: iconst_2
    //   444: ior
    //   445: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   448: goto -412 -> 36
    //   451: aload 11
    //   453: astore 9
    //   455: iload_3
    //   456: istore 5
    //   458: iload_3
    //   459: istore 6
    //   461: iload_3
    //   462: istore 7
    //   464: aload_0
    //   465: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   468: iconst_1
    //   469: iand
    //   470: iconst_1
    //   471: if_icmpne +21 -> 492
    //   474: iload_3
    //   475: istore 5
    //   477: iload_3
    //   478: istore 6
    //   480: iload_3
    //   481: istore 7
    //   483: aload_0
    //   484: getfield 135	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:strings_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable;
    //   487: invokevirtual 140	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:toBuilder	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable$Builder;
    //   490: astore 9
    //   492: iload_3
    //   493: istore 5
    //   495: iload_3
    //   496: istore 6
    //   498: iload_3
    //   499: istore 7
    //   501: aload_0
    //   502: aload_1
    //   503: getstatic 141	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   506: aload_2
    //   507: invokevirtual 90	kotlin/reflect/jvm/internal/impl/protobuf/CodedInputStream:readMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;Lkotlin/reflect/jvm/internal/impl/protobuf/ExtensionRegistryLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   510: checkcast 137	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable
    //   513: putfield 135	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:strings_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable;
    //   516: aload 9
    //   518: ifnull +40 -> 558
    //   521: iload_3
    //   522: istore 5
    //   524: iload_3
    //   525: istore 6
    //   527: iload_3
    //   528: istore 7
    //   530: aload 9
    //   532: aload_0
    //   533: getfield 135	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:strings_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable;
    //   536: invokevirtual 146	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable$Builder;
    //   539: pop
    //   540: iload_3
    //   541: istore 5
    //   543: iload_3
    //   544: istore 6
    //   546: iload_3
    //   547: istore 7
    //   549: aload_0
    //   550: aload 9
    //   552: invokevirtual 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable$Builder:buildPartial	()Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable;
    //   555: putfield 135	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:strings_	Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable;
    //   558: iload_3
    //   559: istore 5
    //   561: iload_3
    //   562: istore 6
    //   564: iload_3
    //   565: istore 7
    //   567: aload_0
    //   568: aload_0
    //   569: getfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   572: iconst_1
    //   573: ior
    //   574: putfield 98	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:bitField0_	I
    //   577: goto -541 -> 36
    //   580: iconst_1
    //   581: istore 8
    //   583: goto -547 -> 36
    //   586: astore_1
    //   587: goto +35 -> 622
    //   590: astore_1
    //   591: iload 6
    //   593: istore 5
    //   595: new 49	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   598: dup
    //   599: aload_1
    //   600: invokevirtual 153	java/io/IOException:getMessage	()Ljava/lang/String;
    //   603: invokespecial 156	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:<init>	(Ljava/lang/String;)V
    //   606: aload_0
    //   607: invokevirtual 160	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   610: athrow
    //   611: astore_1
    //   612: iload 7
    //   614: istore 5
    //   616: aload_1
    //   617: aload_0
    //   618: invokevirtual 160	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:setUnfinishedMessage	(Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;)Lkotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException;
    //   621: athrow
    //   622: iload 5
    //   624: bipush 8
    //   626: iand
    //   627: bipush 8
    //   629: if_icmpne +14 -> 643
    //   632: aload_0
    //   633: aload_0
    //   634: getfield 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:class__	Ljava/util/List;
    //   637: invokestatic 166	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   640: putfield 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:class__	Ljava/util/List;
    //   643: aload 13
    //   645: invokevirtual 169	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   648: aload_0
    //   649: aload 12
    //   651: invokevirtual 175	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   654: putfield 177	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   657: goto +15 -> 672
    //   660: astore_1
    //   661: aload_0
    //   662: aload 12
    //   664: invokevirtual 175	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   667: putfield 177	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   670: aload_1
    //   671: athrow
    //   672: aload_0
    //   673: invokevirtual 180	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:makeExtensionsImmutable	()V
    //   676: aload_1
    //   677: athrow
    //   678: iload_3
    //   679: bipush 8
    //   681: iand
    //   682: bipush 8
    //   684: if_icmpne +14 -> 698
    //   687: aload_0
    //   688: aload_0
    //   689: getfield 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:class__	Ljava/util/List;
    //   692: invokestatic 166	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   695: putfield 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:class__	Ljava/util/List;
    //   698: aload 13
    //   700: invokevirtual 169	kotlin/reflect/jvm/internal/impl/protobuf/CodedOutputStream:flush	()V
    //   703: aload_0
    //   704: aload 12
    //   706: invokevirtual 175	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   709: putfield 177	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   712: goto +15 -> 727
    //   715: astore_1
    //   716: aload_0
    //   717: aload 12
    //   719: invokevirtual 175	kotlin/reflect/jvm/internal/impl/protobuf/ByteString$Output:toByteString	()Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   722: putfield 177	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:unknownFields	Lkotlin/reflect/jvm/internal/impl/protobuf/ByteString;
    //   725: aload_1
    //   726: athrow
    //   727: aload_0
    //   728: invokevirtual 180	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:makeExtensionsImmutable	()V
    //   731: return
    //   732: astore_2
    //   733: goto -85 -> 648
    //   736: astore_1
    //   737: goto -34 -> 703
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	this	PackageFragment
    //   0	740	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	740	2	paramExtensionRegistryLite	ExtensionRegistryLite
    //   35	647	3	i	int
    //   54	138	4	j	int
    //   42	585	5	k	int
    //   45	547	6	m	int
    //   48	565	7	n	int
    //   32	550	8	i1	int
    //   68	483	9	localObject1	java.lang.Object
    //   62	261	10	localObject2	java.lang.Object
    //   65	387	11	localObject3	java.lang.Object
    //   21	697	12	localOutput	kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
    //   29	670	13	localCodedOutputStream	CodedOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	56	586	finally
    //   107	120	586	finally
    //   144	155	586	finally
    //   173	191	586	finally
    //   206	216	586	finally
    //   225	234	586	finally
    //   243	258	586	finally
    //   272	282	586	finally
    //   291	300	586	finally
    //   309	319	586	finally
    //   335	345	586	finally
    //   354	363	586	finally
    //   372	387	586	finally
    //   401	411	586	finally
    //   420	429	586	finally
    //   438	448	586	finally
    //   464	474	586	finally
    //   483	492	586	finally
    //   501	516	586	finally
    //   530	540	586	finally
    //   549	558	586	finally
    //   567	577	586	finally
    //   595	611	586	finally
    //   616	622	586	finally
    //   50	56	590	java/io/IOException
    //   107	120	590	java/io/IOException
    //   144	155	590	java/io/IOException
    //   173	191	590	java/io/IOException
    //   206	216	590	java/io/IOException
    //   225	234	590	java/io/IOException
    //   243	258	590	java/io/IOException
    //   272	282	590	java/io/IOException
    //   291	300	590	java/io/IOException
    //   309	319	590	java/io/IOException
    //   335	345	590	java/io/IOException
    //   354	363	590	java/io/IOException
    //   372	387	590	java/io/IOException
    //   401	411	590	java/io/IOException
    //   420	429	590	java/io/IOException
    //   438	448	590	java/io/IOException
    //   464	474	590	java/io/IOException
    //   483	492	590	java/io/IOException
    //   501	516	590	java/io/IOException
    //   530	540	590	java/io/IOException
    //   549	558	590	java/io/IOException
    //   567	577	590	java/io/IOException
    //   50	56	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   107	120	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   144	155	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   173	191	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   206	216	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   225	234	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   243	258	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   272	282	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   291	300	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   309	319	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   335	345	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   354	363	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   372	387	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   401	411	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   420	429	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   438	448	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   464	474	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   483	492	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   501	516	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   530	540	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   549	558	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   567	577	611	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   643	648	660	finally
    //   698	703	715	finally
    //   643	648	732	java/io/IOException
    //   698	703	736	java/io/IOException
  }
  
  private ProtoBuf$PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> paramExtendableBuilder)
  {
    super(paramExtendableBuilder);
    this.unknownFields = paramExtendableBuilder.getUnknownFields();
  }
  
  private ProtoBuf$PackageFragment(boolean paramBoolean)
  {
    this.unknownFields = ByteString.EMPTY;
  }
  
  public static PackageFragment getDefaultInstance()
  {
    return defaultInstance;
  }
  
  private void initFields()
  {
    this.strings_ = ProtoBuf.StringTable.getDefaultInstance();
    this.qualifiedNames_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
    this.package_ = ProtoBuf.Package.getDefaultInstance();
    this.class__ = Collections.emptyList();
  }
  
  public static ProtoBuf.PackageFragment.Builder newBuilder()
  {
    return ProtoBuf.PackageFragment.Builder.access$21400();
  }
  
  public static ProtoBuf.PackageFragment.Builder newBuilder(PackageFragment paramPackageFragment)
  {
    return newBuilder().mergeFrom(paramPackageFragment);
  }
  
  public static PackageFragment parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    return (PackageFragment)PARSER.parseFrom(paramInputStream, paramExtensionRegistryLite);
  }
  
  public ProtoBuf.Class getClass_(int paramInt)
  {
    return (ProtoBuf.Class)this.class__.get(paramInt);
  }
  
  public int getClass_Count()
  {
    return this.class__.size();
  }
  
  public List<ProtoBuf.Class> getClass_List()
  {
    return this.class__;
  }
  
  public PackageFragment getDefaultInstanceForType()
  {
    return defaultInstance;
  }
  
  public ProtoBuf.Package getPackage()
  {
    return this.package_;
  }
  
  public Parser<PackageFragment> getParserForType()
  {
    return PARSER;
  }
  
  public ProtoBuf.QualifiedNameTable getQualifiedNames()
  {
    return this.qualifiedNames_;
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSerializedSize;
    if (i != -1) {
      return i;
    }
    i = this.bitField0_;
    int m = 0;
    if ((i & 0x1) == 1) {
      j = CodedOutputStream.computeMessageSize(1, this.strings_) + 0;
    } else {
      j = 0;
    }
    i = j;
    if ((this.bitField0_ & 0x2) == 2) {
      i = j + CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
    }
    int j = i;
    int k = m;
    if ((this.bitField0_ & 0x4) == 4)
    {
      j = i + CodedOutputStream.computeMessageSize(3, this.package_);
      k = m;
    }
    while (k < this.class__.size())
    {
      j += CodedOutputStream.computeMessageSize(4, (MessageLite)this.class__.get(k));
      k += 1;
    }
    i = j + extensionsSerializedSize() + this.unknownFields.size();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public ProtoBuf.StringTable getStrings()
  {
    return this.strings_;
  }
  
  public boolean hasPackage()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasQualifiedNames()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasStrings()
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
    if ((hasQualifiedNames()) && (!getQualifiedNames().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    if ((hasPackage()) && (!getPackage().isInitialized()))
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    i = 0;
    while (i < getClass_Count())
    {
      if (!getClass_(i).isInitialized())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      i += 1;
    }
    if (!extensionsAreInitialized())
    {
      this.memoizedIsInitialized = 0;
      return false;
    }
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public ProtoBuf.PackageFragment.Builder newBuilderForType()
  {
    return newBuilder();
  }
  
  public ProtoBuf.PackageFragment.Builder toBuilder()
  {
    return newBuilder(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    getSerializedSize();
    GeneratedMessageLite.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
    if ((this.bitField0_ & 0x1) == 1) {
      paramCodedOutputStream.writeMessage(1, this.strings_);
    }
    if ((this.bitField0_ & 0x2) == 2) {
      paramCodedOutputStream.writeMessage(2, this.qualifiedNames_);
    }
    if ((this.bitField0_ & 0x4) == 4) {
      paramCodedOutputStream.writeMessage(3, this.package_);
    }
    int i = 0;
    while (i < this.class__.size())
    {
      paramCodedOutputStream.writeMessage(4, (MessageLite)this.class__.get(i));
      i += 1;
    }
    localExtensionWriter.writeUntil(200, paramCodedOutputStream);
    paramCodedOutputStream.writeRawBytes(this.unknownFields);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment
 * JD-Core Version:    0.7.0.1
 */