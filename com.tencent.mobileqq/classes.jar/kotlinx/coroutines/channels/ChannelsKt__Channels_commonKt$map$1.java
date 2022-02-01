package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1", f="Channels.common.kt", i={0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l={2201, 1400, 1400}, m="invokeSuspend", n={"$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "it", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "it"}, s={"L$0", "L$1", "L$3", "L$4", "L$5", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8"})
final class ChannelsKt__Channels_commonKt$map$1
  extends SuspendLambda
  implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  Object L$5;
  Object L$6;
  Object L$7;
  Object L$8;
  Object L$9;
  int label;
  private ProducerScope p$;
  
  ChannelsKt__Channels_commonKt$map$1(ReceiveChannel paramReceiveChannel, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 1(this.$this_map, this.$transform, paramContinuation);
    paramContinuation.p$ = ((ProducerScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  /* Error */
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 109	kotlin/coroutines/intrinsics/IntrinsicsKt:getCOROUTINE_SUSPENDED	()Ljava/lang/Object;
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 111	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:label	I
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +390 -> 401
    //   14: iload_2
    //   15: iconst_1
    //   16: if_icmpeq +277 -> 293
    //   19: iload_2
    //   20: iconst_2
    //   21: if_icmpeq +130 -> 151
    //   24: iload_2
    //   25: iconst_3
    //   26: if_icmpne +115 -> 141
    //   29: aload_0
    //   30: getfield 113	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$8	Ljava/lang/Object;
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 115	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$7	Ljava/lang/Object;
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 117	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$6	Ljava/lang/Object;
    //   43: checkcast 119	kotlinx/coroutines/channels/ChannelIterator
    //   46: astore 11
    //   48: aload_0
    //   49: getfield 121	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$5	Ljava/lang/Object;
    //   52: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   55: astore 13
    //   57: aload_0
    //   58: getfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$4	Ljava/lang/Object;
    //   61: checkcast 103	java/lang/Throwable
    //   64: astore 8
    //   66: aload_0
    //   67: getfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$3	Ljava/lang/Object;
    //   70: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   73: astore 7
    //   75: aload_0
    //   76: getfield 129	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$2	Ljava/lang/Object;
    //   79: checkcast 2	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1
    //   82: astore 10
    //   84: aload_0
    //   85: getfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$1	Ljava/lang/Object;
    //   88: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   91: astore 12
    //   93: aload_0
    //   94: getfield 133	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$0	Ljava/lang/Object;
    //   97: checkcast 82	kotlinx/coroutines/channels/ProducerScope
    //   100: astore 9
    //   102: aload 8
    //   104: astore 4
    //   106: aload 7
    //   108: astore 5
    //   110: aload 7
    //   112: astore_3
    //   113: aload_1
    //   114: invokestatic 139	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   117: aload 6
    //   119: astore_3
    //   120: aload 8
    //   122: astore 4
    //   124: aload 13
    //   126: astore 6
    //   128: aload_0
    //   129: astore 8
    //   131: aload 11
    //   133: astore 5
    //   135: aload 7
    //   137: astore_1
    //   138: goto +997 -> 1135
    //   141: new 141	java/lang/IllegalStateException
    //   144: dup
    //   145: ldc 143
    //   147: invokespecial 146	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   150: athrow
    //   151: aload_0
    //   152: getfield 148	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$9	Ljava/lang/Object;
    //   155: checkcast 82	kotlinx/coroutines/channels/ProducerScope
    //   158: astore 14
    //   160: aload_0
    //   161: getfield 113	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$8	Ljava/lang/Object;
    //   164: astore 4
    //   166: aload_0
    //   167: getfield 115	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$7	Ljava/lang/Object;
    //   170: astore 5
    //   172: aload_0
    //   173: getfield 117	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$6	Ljava/lang/Object;
    //   176: checkcast 119	kotlinx/coroutines/channels/ChannelIterator
    //   179: astore 13
    //   181: aload_0
    //   182: getfield 121	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$5	Ljava/lang/Object;
    //   185: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   188: astore 9
    //   190: aload_0
    //   191: getfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$4	Ljava/lang/Object;
    //   194: checkcast 103	java/lang/Throwable
    //   197: astore 7
    //   199: aload_0
    //   200: getfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$3	Ljava/lang/Object;
    //   203: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   206: astore_3
    //   207: aload_0
    //   208: getfield 129	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$2	Ljava/lang/Object;
    //   211: checkcast 2	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1
    //   214: astore 15
    //   216: aload_0
    //   217: getfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$1	Ljava/lang/Object;
    //   220: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   223: astore 12
    //   225: aload_0
    //   226: getfield 133	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$0	Ljava/lang/Object;
    //   229: checkcast 82	kotlinx/coroutines/channels/ProducerScope
    //   232: astore 16
    //   234: aload_1
    //   235: invokestatic 139	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   238: aload 6
    //   240: astore 10
    //   242: aload_0
    //   243: astore 8
    //   245: aload_3
    //   246: astore 11
    //   248: aload 16
    //   250: astore 6
    //   252: aload_1
    //   253: astore_3
    //   254: aload 11
    //   256: astore_1
    //   257: aload 15
    //   259: astore 11
    //   261: aload 5
    //   263: astore 15
    //   265: aload_3
    //   266: astore 16
    //   268: aload 4
    //   270: astore 17
    //   272: goto +567 -> 839
    //   275: astore 5
    //   277: aload 7
    //   279: astore 4
    //   281: aload_3
    //   282: astore_1
    //   283: aload 5
    //   285: astore_3
    //   286: goto +783 -> 1069
    //   289: astore_1
    //   290: goto +771 -> 1061
    //   293: aload_0
    //   294: getfield 117	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$6	Ljava/lang/Object;
    //   297: checkcast 119	kotlinx/coroutines/channels/ChannelIterator
    //   300: astore 10
    //   302: aload_0
    //   303: getfield 121	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$5	Ljava/lang/Object;
    //   306: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   309: astore 9
    //   311: aload_0
    //   312: getfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$4	Ljava/lang/Object;
    //   315: checkcast 103	java/lang/Throwable
    //   318: astore 7
    //   320: aload_0
    //   321: getfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$3	Ljava/lang/Object;
    //   324: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   327: astore 11
    //   329: aload_0
    //   330: getfield 129	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$2	Ljava/lang/Object;
    //   333: checkcast 2	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1
    //   336: astore 8
    //   338: aload_0
    //   339: getfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$1	Ljava/lang/Object;
    //   342: checkcast 123	kotlinx/coroutines/channels/ReceiveChannel
    //   345: astore 12
    //   347: aload_0
    //   348: getfield 133	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$0	Ljava/lang/Object;
    //   351: checkcast 82	kotlinx/coroutines/channels/ProducerScope
    //   354: astore 14
    //   356: aload 7
    //   358: astore 4
    //   360: aload 11
    //   362: astore 5
    //   364: aload 11
    //   366: astore_3
    //   367: aload_1
    //   368: invokestatic 139	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   371: aload_1
    //   372: astore_3
    //   373: aload 8
    //   375: astore 4
    //   377: aload_0
    //   378: astore 8
    //   380: aload 11
    //   382: astore_1
    //   383: aload 6
    //   385: astore 13
    //   387: aload 14
    //   389: astore 6
    //   391: aload 4
    //   393: astore 11
    //   395: aload_3
    //   396: astore 14
    //   398: goto +181 -> 579
    //   401: aload_1
    //   402: invokestatic 139	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   405: aload_0
    //   406: getfield 84	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:p$	Lkotlinx/coroutines/channels/ProducerScope;
    //   409: astore 10
    //   411: aload_0
    //   412: getfield 68	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:$this_map	Lkotlinx/coroutines/channels/ReceiveChannel;
    //   415: astore_1
    //   416: aconst_null
    //   417: checkcast 103	java/lang/Throwable
    //   420: astore 7
    //   422: aload 7
    //   424: astore 4
    //   426: aload_1
    //   427: astore 5
    //   429: aload_1
    //   430: astore_3
    //   431: aload_1
    //   432: invokeinterface 152 1 0
    //   437: astore 8
    //   439: aload_0
    //   440: astore_3
    //   441: aload 7
    //   443: astore 4
    //   445: aload_1
    //   446: astore 12
    //   448: aload 12
    //   450: astore 9
    //   452: aload 10
    //   454: astore 7
    //   456: aload 8
    //   458: astore 5
    //   460: aload_3
    //   461: astore 8
    //   463: aload_3
    //   464: astore 10
    //   466: aload_1
    //   467: astore_3
    //   468: aload 8
    //   470: aload 7
    //   472: putfield 133	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$0	Ljava/lang/Object;
    //   475: aload_1
    //   476: astore_3
    //   477: aload 8
    //   479: aload 12
    //   481: putfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$1	Ljava/lang/Object;
    //   484: aload_1
    //   485: astore_3
    //   486: aload 8
    //   488: aload 10
    //   490: putfield 129	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$2	Ljava/lang/Object;
    //   493: aload_1
    //   494: astore_3
    //   495: aload 8
    //   497: aload_1
    //   498: putfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$3	Ljava/lang/Object;
    //   501: aload_1
    //   502: astore_3
    //   503: aload 8
    //   505: aload 4
    //   507: putfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$4	Ljava/lang/Object;
    //   510: aload_1
    //   511: astore_3
    //   512: aload 8
    //   514: aload 9
    //   516: putfield 121	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$5	Ljava/lang/Object;
    //   519: aload_1
    //   520: astore_3
    //   521: aload 8
    //   523: aload 5
    //   525: putfield 117	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$6	Ljava/lang/Object;
    //   528: aload_1
    //   529: astore_3
    //   530: aload 8
    //   532: iconst_1
    //   533: putfield 111	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:label	I
    //   536: aload_1
    //   537: astore_3
    //   538: aload 5
    //   540: aload 10
    //   542: invokeinterface 156 2 0
    //   547: astore 14
    //   549: aload 14
    //   551: aload 6
    //   553: if_acmpne +6 -> 559
    //   556: aload 6
    //   558: areturn
    //   559: aload 6
    //   561: astore 13
    //   563: aload 10
    //   565: astore 11
    //   567: aload 7
    //   569: astore 6
    //   571: aload 4
    //   573: astore 7
    //   575: aload 5
    //   577: astore 10
    //   579: aload 7
    //   581: astore 4
    //   583: aload_1
    //   584: astore 5
    //   586: aload_1
    //   587: astore_3
    //   588: aload 14
    //   590: checkcast 158	java/lang/Boolean
    //   593: invokevirtual 162	java/lang/Boolean:booleanValue	()Z
    //   596: ifeq +429 -> 1025
    //   599: aload 7
    //   601: astore 4
    //   603: aload_1
    //   604: astore 5
    //   606: aload_1
    //   607: astore_3
    //   608: aload 10
    //   610: invokeinterface 165 1 0
    //   615: astore 15
    //   617: aload 7
    //   619: astore 4
    //   621: aload_1
    //   622: astore 5
    //   624: aload_1
    //   625: astore_3
    //   626: aload 8
    //   628: getfield 70	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:$transform	Lkotlin/jvm/functions/Function2;
    //   631: astore 14
    //   633: aload 7
    //   635: astore 4
    //   637: aload_1
    //   638: astore 5
    //   640: aload_1
    //   641: astore_3
    //   642: aload 8
    //   644: aload 6
    //   646: putfield 133	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$0	Ljava/lang/Object;
    //   649: aload 7
    //   651: astore 4
    //   653: aload_1
    //   654: astore 5
    //   656: aload_1
    //   657: astore_3
    //   658: aload 8
    //   660: aload 12
    //   662: putfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$1	Ljava/lang/Object;
    //   665: aload 7
    //   667: astore 4
    //   669: aload_1
    //   670: astore 5
    //   672: aload_1
    //   673: astore_3
    //   674: aload 8
    //   676: aload 11
    //   678: putfield 129	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$2	Ljava/lang/Object;
    //   681: aload 7
    //   683: astore 4
    //   685: aload_1
    //   686: astore 5
    //   688: aload_1
    //   689: astore_3
    //   690: aload 8
    //   692: aload_1
    //   693: putfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$3	Ljava/lang/Object;
    //   696: aload 7
    //   698: astore 4
    //   700: aload_1
    //   701: astore 5
    //   703: aload_1
    //   704: astore_3
    //   705: aload 8
    //   707: aload 7
    //   709: putfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$4	Ljava/lang/Object;
    //   712: aload 7
    //   714: astore 4
    //   716: aload_1
    //   717: astore 5
    //   719: aload_1
    //   720: astore_3
    //   721: aload 8
    //   723: aload 9
    //   725: putfield 121	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$5	Ljava/lang/Object;
    //   728: aload 7
    //   730: astore 4
    //   732: aload_1
    //   733: astore 5
    //   735: aload_1
    //   736: astore_3
    //   737: aload 8
    //   739: aload 10
    //   741: putfield 117	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$6	Ljava/lang/Object;
    //   744: aload 7
    //   746: astore 4
    //   748: aload_1
    //   749: astore 5
    //   751: aload_1
    //   752: astore_3
    //   753: aload 8
    //   755: aload 15
    //   757: putfield 115	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$7	Ljava/lang/Object;
    //   760: aload 7
    //   762: astore 4
    //   764: aload_1
    //   765: astore 5
    //   767: aload_1
    //   768: astore_3
    //   769: aload 8
    //   771: aload 15
    //   773: putfield 113	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$8	Ljava/lang/Object;
    //   776: aload 7
    //   778: astore 4
    //   780: aload_1
    //   781: astore 5
    //   783: aload_1
    //   784: astore_3
    //   785: aload 8
    //   787: aload 6
    //   789: putfield 148	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$9	Ljava/lang/Object;
    //   792: aload 7
    //   794: astore 4
    //   796: aload_1
    //   797: astore 5
    //   799: aload_1
    //   800: astore_3
    //   801: aload 8
    //   803: iconst_2
    //   804: putfield 111	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:label	I
    //   807: aload 7
    //   809: astore 4
    //   811: aload_1
    //   812: astore 5
    //   814: aload_1
    //   815: astore_3
    //   816: aload 14
    //   818: aload 15
    //   820: aload 8
    //   822: invokeinterface 167 3 0
    //   827: astore 16
    //   829: aload 16
    //   831: aload 13
    //   833: if_acmpne +250 -> 1083
    //   836: aload 13
    //   838: areturn
    //   839: aload 7
    //   841: astore 4
    //   843: aload_1
    //   844: astore 5
    //   846: aload_1
    //   847: astore_3
    //   848: aload 8
    //   850: aload 6
    //   852: putfield 133	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$0	Ljava/lang/Object;
    //   855: aload 7
    //   857: astore 4
    //   859: aload_1
    //   860: astore 5
    //   862: aload_1
    //   863: astore_3
    //   864: aload 8
    //   866: aload 12
    //   868: putfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$1	Ljava/lang/Object;
    //   871: aload 7
    //   873: astore 4
    //   875: aload_1
    //   876: astore 5
    //   878: aload_1
    //   879: astore_3
    //   880: aload 8
    //   882: aload 11
    //   884: putfield 129	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$2	Ljava/lang/Object;
    //   887: aload 7
    //   889: astore 4
    //   891: aload_1
    //   892: astore 5
    //   894: aload_1
    //   895: astore_3
    //   896: aload 8
    //   898: aload_1
    //   899: putfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$3	Ljava/lang/Object;
    //   902: aload 7
    //   904: astore 4
    //   906: aload_1
    //   907: astore 5
    //   909: aload_1
    //   910: astore_3
    //   911: aload 8
    //   913: aload 7
    //   915: putfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$4	Ljava/lang/Object;
    //   918: aload 7
    //   920: astore 4
    //   922: aload_1
    //   923: astore 5
    //   925: aload_1
    //   926: astore_3
    //   927: aload 8
    //   929: aload 9
    //   931: putfield 121	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$5	Ljava/lang/Object;
    //   934: aload 7
    //   936: astore 4
    //   938: aload_1
    //   939: astore 5
    //   941: aload_1
    //   942: astore_3
    //   943: aload 8
    //   945: aload 13
    //   947: putfield 117	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$6	Ljava/lang/Object;
    //   950: aload 7
    //   952: astore 4
    //   954: aload_1
    //   955: astore 5
    //   957: aload_1
    //   958: astore_3
    //   959: aload 8
    //   961: aload 15
    //   963: putfield 115	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$7	Ljava/lang/Object;
    //   966: aload 7
    //   968: astore 4
    //   970: aload_1
    //   971: astore 5
    //   973: aload_1
    //   974: astore_3
    //   975: aload 8
    //   977: aload 17
    //   979: putfield 113	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:L$8	Ljava/lang/Object;
    //   982: aload 7
    //   984: astore 4
    //   986: aload_1
    //   987: astore 5
    //   989: aload_1
    //   990: astore_3
    //   991: aload 8
    //   993: iconst_3
    //   994: putfield 111	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$map$1:label	I
    //   997: aload 7
    //   999: astore 4
    //   1001: aload_1
    //   1002: astore 5
    //   1004: aload_1
    //   1005: astore_3
    //   1006: aload 14
    //   1008: aload 16
    //   1010: aload 8
    //   1012: invokeinterface 171 3 0
    //   1017: aload 10
    //   1019: if_acmpne +89 -> 1108
    //   1022: aload 10
    //   1024: areturn
    //   1025: aload 7
    //   1027: astore 4
    //   1029: aload_1
    //   1030: astore 5
    //   1032: aload_1
    //   1033: astore_3
    //   1034: getstatic 98	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   1037: astore 6
    //   1039: aload_1
    //   1040: aload 7
    //   1042: invokestatic 177	kotlinx/coroutines/channels/ChannelsKt:cancelConsumed	(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)V
    //   1045: getstatic 98	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   1048: areturn
    //   1049: astore_3
    //   1050: goto +19 -> 1069
    //   1053: astore_3
    //   1054: aload 5
    //   1056: astore_1
    //   1057: goto +12 -> 1069
    //   1060: astore_1
    //   1061: aload_1
    //   1062: astore 4
    //   1064: aload_3
    //   1065: astore 5
    //   1067: aload_1
    //   1068: athrow
    //   1069: aload_1
    //   1070: aload 4
    //   1072: invokestatic 177	kotlinx/coroutines/channels/ChannelsKt:cancelConsumed	(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)V
    //   1075: goto +5 -> 1080
    //   1078: aload_3
    //   1079: athrow
    //   1080: goto -2 -> 1078
    //   1083: aload 13
    //   1085: astore 4
    //   1087: aload 15
    //   1089: astore_3
    //   1090: aload 10
    //   1092: astore 13
    //   1094: aload 6
    //   1096: astore 14
    //   1098: aload 4
    //   1100: astore 10
    //   1102: aload_3
    //   1103: astore 17
    //   1105: goto -266 -> 839
    //   1108: aload 13
    //   1110: astore 5
    //   1112: aload 7
    //   1114: astore 4
    //   1116: aload 6
    //   1118: astore 7
    //   1120: aload 9
    //   1122: astore 6
    //   1124: aload 10
    //   1126: astore_3
    //   1127: aload 7
    //   1129: astore 9
    //   1131: aload 11
    //   1133: astore 10
    //   1135: aload 9
    //   1137: astore 7
    //   1139: aload 6
    //   1141: astore 9
    //   1143: aload_3
    //   1144: astore 6
    //   1146: goto -680 -> 466
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1149	0	this	1
    //   0	1149	1	paramObject	Object
    //   9	18	2	i	int
    //   33	1001	3	localObject1	Object
    //   1049	1	3	localObject2	Object
    //   1053	26	3	localObject3	Object
    //   1089	55	3	localObject4	Object
    //   104	1011	4	localObject5	Object
    //   108	154	5	localObject6	Object
    //   275	9	5	localObject7	Object
    //   362	749	5	localObject8	Object
    //   3	1142	6	localObject9	Object
    //   73	1065	7	localObject10	Object
    //   64	947	8	localObject11	Object
    //   100	1042	9	localObject12	Object
    //   82	1052	10	localObject13	Object
    //   46	1086	11	localObject14	Object
    //   91	776	12	localObject15	Object
    //   55	1054	13	localObject16	Object
    //   158	939	14	localObject17	Object
    //   214	874	15	localObject18	Object
    //   232	777	16	localObject19	Object
    //   270	834	17	localObject20	Object
    // Exception table:
    //   from	to	target	type
    //   234	238	275	finally
    //   234	238	289	java/lang/Throwable
    //   468	475	1049	finally
    //   477	484	1049	finally
    //   486	493	1049	finally
    //   495	501	1049	finally
    //   503	510	1049	finally
    //   512	519	1049	finally
    //   521	528	1049	finally
    //   530	536	1049	finally
    //   538	549	1049	finally
    //   113	117	1053	finally
    //   367	371	1053	finally
    //   431	439	1053	finally
    //   588	599	1053	finally
    //   608	617	1053	finally
    //   626	633	1053	finally
    //   642	649	1053	finally
    //   658	665	1053	finally
    //   674	681	1053	finally
    //   690	696	1053	finally
    //   705	712	1053	finally
    //   721	728	1053	finally
    //   737	744	1053	finally
    //   753	760	1053	finally
    //   769	776	1053	finally
    //   785	792	1053	finally
    //   801	807	1053	finally
    //   816	829	1053	finally
    //   848	855	1053	finally
    //   864	871	1053	finally
    //   880	887	1053	finally
    //   896	902	1053	finally
    //   911	918	1053	finally
    //   927	934	1053	finally
    //   943	950	1053	finally
    //   959	966	1053	finally
    //   975	982	1053	finally
    //   991	997	1053	finally
    //   1006	1022	1053	finally
    //   1034	1039	1053	finally
    //   1067	1069	1053	finally
    //   113	117	1060	java/lang/Throwable
    //   367	371	1060	java/lang/Throwable
    //   431	439	1060	java/lang/Throwable
    //   468	475	1060	java/lang/Throwable
    //   477	484	1060	java/lang/Throwable
    //   486	493	1060	java/lang/Throwable
    //   495	501	1060	java/lang/Throwable
    //   503	510	1060	java/lang/Throwable
    //   512	519	1060	java/lang/Throwable
    //   521	528	1060	java/lang/Throwable
    //   530	536	1060	java/lang/Throwable
    //   538	549	1060	java/lang/Throwable
    //   588	599	1060	java/lang/Throwable
    //   608	617	1060	java/lang/Throwable
    //   626	633	1060	java/lang/Throwable
    //   642	649	1060	java/lang/Throwable
    //   658	665	1060	java/lang/Throwable
    //   674	681	1060	java/lang/Throwable
    //   690	696	1060	java/lang/Throwable
    //   705	712	1060	java/lang/Throwable
    //   721	728	1060	java/lang/Throwable
    //   737	744	1060	java/lang/Throwable
    //   753	760	1060	java/lang/Throwable
    //   769	776	1060	java/lang/Throwable
    //   785	792	1060	java/lang/Throwable
    //   801	807	1060	java/lang/Throwable
    //   816	829	1060	java/lang/Throwable
    //   848	855	1060	java/lang/Throwable
    //   864	871	1060	java/lang/Throwable
    //   880	887	1060	java/lang/Throwable
    //   896	902	1060	java/lang/Throwable
    //   911	918	1060	java/lang/Throwable
    //   927	934	1060	java/lang/Throwable
    //   943	950	1060	java/lang/Throwable
    //   959	966	1060	java/lang/Throwable
    //   975	982	1060	java/lang/Throwable
    //   991	997	1060	java/lang/Throwable
    //   1006	1022	1060	java/lang/Throwable
    //   1034	1039	1060	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.map.1
 * JD-Core Version:    0.7.0.1
 */