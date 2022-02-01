package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2", f="Channels.common.kt", i={0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l={2201, 2191, 2193}, m="invokeSuspend", n={"$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "element1", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "element1", "element2"}, s={"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10"})
final class ChannelsKt__Channels_commonKt$zip$2
  extends SuspendLambda
  implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$10;
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
  
  ChannelsKt__Channels_commonKt$zip$2(ReceiveChannel paramReceiveChannel1, ReceiveChannel paramReceiveChannel2, Function2 paramFunction2, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    paramContinuation = new 2(this.$this_zip, this.$other, this.$transform, paramContinuation);
    paramContinuation.p$ = ((ProducerScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((2)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  /* Error */
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 117	kotlin/coroutines/intrinsics/IntrinsicsKt:getCOROUTINE_SUSPENDED	()Ljava/lang/Object;
    //   3: astore 9
    //   5: aload_0
    //   6: getfield 119	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:label	I
    //   9: istore 5
    //   11: iconst_1
    //   12: istore_3
    //   13: iconst_1
    //   14: istore 4
    //   16: iconst_1
    //   17: istore_2
    //   18: iload 5
    //   20: ifeq +407 -> 427
    //   23: iload 5
    //   25: iconst_1
    //   26: if_icmpeq +283 -> 309
    //   29: iload 5
    //   31: iconst_2
    //   32: if_icmpeq +142 -> 174
    //   35: iload 5
    //   37: iconst_3
    //   38: if_icmpne +126 -> 164
    //   41: aload_0
    //   42: getfield 121	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$10	Ljava/lang/Object;
    //   45: astore 6
    //   47: aload_0
    //   48: getfield 123	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$9	Ljava/lang/Object;
    //   51: astore 6
    //   53: aload_0
    //   54: getfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$8	Ljava/lang/Object;
    //   57: astore 6
    //   59: aload_0
    //   60: getfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$7	Ljava/lang/Object;
    //   63: checkcast 129	kotlinx/coroutines/channels/ChannelIterator
    //   66: astore 11
    //   68: aload_0
    //   69: getfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$6	Ljava/lang/Object;
    //   72: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   75: astore 14
    //   77: aload_0
    //   78: getfield 135	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$5	Ljava/lang/Object;
    //   81: checkcast 111	java/lang/Throwable
    //   84: astore 12
    //   86: aload_0
    //   87: getfield 137	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$4	Ljava/lang/Object;
    //   90: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   93: astore 10
    //   95: aload_0
    //   96: getfield 139	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$3	Ljava/lang/Object;
    //   99: checkcast 2	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2
    //   102: astore 15
    //   104: aload_0
    //   105: getfield 141	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$2	Ljava/lang/Object;
    //   108: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   111: astore 16
    //   113: aload_0
    //   114: getfield 143	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$1	Ljava/lang/Object;
    //   117: checkcast 129	kotlinx/coroutines/channels/ChannelIterator
    //   120: astore 17
    //   122: aload_0
    //   123: getfield 145	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$0	Ljava/lang/Object;
    //   126: checkcast 90	kotlinx/coroutines/channels/ProducerScope
    //   129: astore 19
    //   131: aload 12
    //   133: astore 6
    //   135: aload 10
    //   137: astore 7
    //   139: aload 10
    //   141: astore 8
    //   143: aload_1
    //   144: invokestatic 151	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   147: aload 9
    //   149: astore 20
    //   151: aload_0
    //   152: astore 18
    //   154: aload 12
    //   156: astore 9
    //   158: aload 10
    //   160: astore_1
    //   161: goto +1181 -> 1342
    //   164: new 153	java/lang/IllegalStateException
    //   167: dup
    //   168: ldc 155
    //   170: invokespecial 158	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   173: athrow
    //   174: aload_0
    //   175: getfield 123	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$9	Ljava/lang/Object;
    //   178: astore 10
    //   180: aload_0
    //   181: getfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$8	Ljava/lang/Object;
    //   184: astore 19
    //   186: aload_0
    //   187: getfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$7	Ljava/lang/Object;
    //   190: checkcast 129	kotlinx/coroutines/channels/ChannelIterator
    //   193: astore 11
    //   195: aload_0
    //   196: getfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$6	Ljava/lang/Object;
    //   199: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   202: astore 14
    //   204: aload_0
    //   205: getfield 135	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$5	Ljava/lang/Object;
    //   208: checkcast 111	java/lang/Throwable
    //   211: astore 8
    //   213: aload_0
    //   214: getfield 137	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$4	Ljava/lang/Object;
    //   217: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   220: astore 6
    //   222: aload_0
    //   223: getfield 139	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$3	Ljava/lang/Object;
    //   226: checkcast 2	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2
    //   229: astore 15
    //   231: aload_0
    //   232: getfield 141	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$2	Ljava/lang/Object;
    //   235: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   238: astore 16
    //   240: aload_0
    //   241: getfield 143	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$1	Ljava/lang/Object;
    //   244: checkcast 129	kotlinx/coroutines/channels/ChannelIterator
    //   247: astore 17
    //   249: aload_0
    //   250: getfield 145	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$0	Ljava/lang/Object;
    //   253: checkcast 90	kotlinx/coroutines/channels/ProducerScope
    //   256: astore 12
    //   258: aload_1
    //   259: invokestatic 151	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   262: aload_1
    //   263: astore 7
    //   265: aload 6
    //   267: astore_1
    //   268: aload 10
    //   270: astore 6
    //   272: aload 9
    //   274: astore 13
    //   276: aload_0
    //   277: astore 10
    //   279: iload 4
    //   281: istore_2
    //   282: aload 8
    //   284: astore 9
    //   286: aload 6
    //   288: astore 20
    //   290: aload 7
    //   292: astore 18
    //   294: goto +659 -> 953
    //   297: astore_1
    //   298: goto +1014 -> 1312
    //   301: astore_1
    //   302: aload 6
    //   304: astore 7
    //   306: goto +1001 -> 1307
    //   309: aload_0
    //   310: getfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$7	Ljava/lang/Object;
    //   313: checkcast 129	kotlinx/coroutines/channels/ChannelIterator
    //   316: astore 11
    //   318: aload_0
    //   319: getfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$6	Ljava/lang/Object;
    //   322: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   325: astore 14
    //   327: aload_0
    //   328: getfield 135	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$5	Ljava/lang/Object;
    //   331: checkcast 111	java/lang/Throwable
    //   334: astore 13
    //   336: aload_0
    //   337: getfield 137	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$4	Ljava/lang/Object;
    //   340: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   343: astore 12
    //   345: aload_0
    //   346: getfield 139	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$3	Ljava/lang/Object;
    //   349: checkcast 2	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2
    //   352: astore 15
    //   354: aload_0
    //   355: getfield 141	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$2	Ljava/lang/Object;
    //   358: checkcast 133	kotlinx/coroutines/channels/ReceiveChannel
    //   361: astore 16
    //   363: aload_0
    //   364: getfield 143	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$1	Ljava/lang/Object;
    //   367: checkcast 129	kotlinx/coroutines/channels/ChannelIterator
    //   370: astore 17
    //   372: aload_0
    //   373: getfield 145	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$0	Ljava/lang/Object;
    //   376: checkcast 90	kotlinx/coroutines/channels/ProducerScope
    //   379: astore 19
    //   381: aload 13
    //   383: astore 6
    //   385: aload 12
    //   387: astore 7
    //   389: aload 12
    //   391: astore 8
    //   393: aload_1
    //   394: invokestatic 151	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   397: aload_1
    //   398: astore 6
    //   400: aload 9
    //   402: astore 18
    //   404: aload_0
    //   405: astore 10
    //   407: iload_3
    //   408: istore_2
    //   409: aload 13
    //   411: astore 9
    //   413: aload 12
    //   415: astore_1
    //   416: aload 19
    //   418: astore 12
    //   420: aload 6
    //   422: astore 19
    //   424: goto +273 -> 697
    //   427: aload_1
    //   428: invokestatic 151	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   431: aload_0
    //   432: getfield 92	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:p$	Lkotlinx/coroutines/channels/ProducerScope;
    //   435: astore 12
    //   437: aload_0
    //   438: getfield 76	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:$other	Lkotlinx/coroutines/channels/ReceiveChannel;
    //   441: invokeinterface 162 1 0
    //   446: astore 17
    //   448: aload_0
    //   449: getfield 74	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:$this_zip	Lkotlinx/coroutines/channels/ReceiveChannel;
    //   452: astore_1
    //   453: aconst_null
    //   454: checkcast 111	java/lang/Throwable
    //   457: astore 11
    //   459: aload 11
    //   461: astore 6
    //   463: aload_1
    //   464: astore 7
    //   466: aload_1
    //   467: astore 8
    //   469: aload_1
    //   470: invokeinterface 162 1 0
    //   475: astore 13
    //   477: aload_0
    //   478: astore 10
    //   480: aload_1
    //   481: astore 14
    //   483: aload 14
    //   485: astore 16
    //   487: aload 13
    //   489: astore 6
    //   491: aload 10
    //   493: astore 15
    //   495: aload 9
    //   497: astore 13
    //   499: aload 11
    //   501: astore 9
    //   503: aload 6
    //   505: astore 11
    //   507: aload 9
    //   509: astore 6
    //   511: aload_1
    //   512: astore 7
    //   514: aload_1
    //   515: astore 8
    //   517: aload 10
    //   519: aload 12
    //   521: putfield 145	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$0	Ljava/lang/Object;
    //   524: aload 9
    //   526: astore 6
    //   528: aload_1
    //   529: astore 7
    //   531: aload_1
    //   532: astore 8
    //   534: aload 10
    //   536: aload 17
    //   538: putfield 143	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$1	Ljava/lang/Object;
    //   541: aload 9
    //   543: astore 6
    //   545: aload_1
    //   546: astore 7
    //   548: aload_1
    //   549: astore 8
    //   551: aload 10
    //   553: aload 16
    //   555: putfield 141	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$2	Ljava/lang/Object;
    //   558: aload 9
    //   560: astore 6
    //   562: aload_1
    //   563: astore 7
    //   565: aload_1
    //   566: astore 8
    //   568: aload 10
    //   570: aload 15
    //   572: putfield 139	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$3	Ljava/lang/Object;
    //   575: aload 9
    //   577: astore 6
    //   579: aload_1
    //   580: astore 7
    //   582: aload_1
    //   583: astore 8
    //   585: aload 10
    //   587: aload_1
    //   588: putfield 137	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$4	Ljava/lang/Object;
    //   591: aload 9
    //   593: astore 6
    //   595: aload_1
    //   596: astore 7
    //   598: aload_1
    //   599: astore 8
    //   601: aload 10
    //   603: aload 9
    //   605: putfield 135	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$5	Ljava/lang/Object;
    //   608: aload 9
    //   610: astore 6
    //   612: aload_1
    //   613: astore 7
    //   615: aload_1
    //   616: astore 8
    //   618: aload 10
    //   620: aload 14
    //   622: putfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$6	Ljava/lang/Object;
    //   625: aload 9
    //   627: astore 6
    //   629: aload_1
    //   630: astore 7
    //   632: aload_1
    //   633: astore 8
    //   635: aload 10
    //   637: aload 11
    //   639: putfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$7	Ljava/lang/Object;
    //   642: aload 9
    //   644: astore 6
    //   646: aload_1
    //   647: astore 7
    //   649: aload_1
    //   650: astore 8
    //   652: aload 10
    //   654: iload_2
    //   655: putfield 119	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:label	I
    //   658: aload 9
    //   660: astore 6
    //   662: aload_1
    //   663: astore 7
    //   665: aload_1
    //   666: astore 8
    //   668: aload 11
    //   670: aload 15
    //   672: invokeinterface 166 2 0
    //   677: astore 20
    //   679: aload 13
    //   681: astore 18
    //   683: aload 20
    //   685: astore 19
    //   687: aload 20
    //   689: aload 13
    //   691: if_acmpne +6 -> 697
    //   694: aload 13
    //   696: areturn
    //   697: aload 9
    //   699: astore 6
    //   701: aload_1
    //   702: astore 7
    //   704: aload_1
    //   705: astore 8
    //   707: aload 19
    //   709: checkcast 168	java/lang/Boolean
    //   712: invokevirtual 172	java/lang/Boolean:booleanValue	()Z
    //   715: ifeq +550 -> 1265
    //   718: aload 9
    //   720: astore 6
    //   722: aload_1
    //   723: astore 7
    //   725: aload_1
    //   726: astore 8
    //   728: aload 11
    //   730: invokeinterface 175 1 0
    //   735: astore 20
    //   737: aload 9
    //   739: astore 6
    //   741: aload_1
    //   742: astore 7
    //   744: aload_1
    //   745: astore 8
    //   747: aload 10
    //   749: aload 12
    //   751: putfield 145	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$0	Ljava/lang/Object;
    //   754: aload 9
    //   756: astore 6
    //   758: aload_1
    //   759: astore 7
    //   761: aload_1
    //   762: astore 8
    //   764: aload 10
    //   766: aload 17
    //   768: putfield 143	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$1	Ljava/lang/Object;
    //   771: aload 9
    //   773: astore 6
    //   775: aload_1
    //   776: astore 7
    //   778: aload_1
    //   779: astore 8
    //   781: aload 10
    //   783: aload 16
    //   785: putfield 141	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$2	Ljava/lang/Object;
    //   788: aload 9
    //   790: astore 6
    //   792: aload_1
    //   793: astore 7
    //   795: aload_1
    //   796: astore 8
    //   798: aload 10
    //   800: aload 15
    //   802: putfield 139	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$3	Ljava/lang/Object;
    //   805: aload 9
    //   807: astore 6
    //   809: aload_1
    //   810: astore 7
    //   812: aload_1
    //   813: astore 8
    //   815: aload 10
    //   817: aload_1
    //   818: putfield 137	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$4	Ljava/lang/Object;
    //   821: aload 9
    //   823: astore 6
    //   825: aload_1
    //   826: astore 7
    //   828: aload_1
    //   829: astore 8
    //   831: aload 10
    //   833: aload 9
    //   835: putfield 135	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$5	Ljava/lang/Object;
    //   838: aload 9
    //   840: astore 6
    //   842: aload_1
    //   843: astore 7
    //   845: aload_1
    //   846: astore 8
    //   848: aload 10
    //   850: aload 14
    //   852: putfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$6	Ljava/lang/Object;
    //   855: aload 9
    //   857: astore 6
    //   859: aload_1
    //   860: astore 7
    //   862: aload_1
    //   863: astore 8
    //   865: aload 10
    //   867: aload 11
    //   869: putfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$7	Ljava/lang/Object;
    //   872: aload 9
    //   874: astore 6
    //   876: aload_1
    //   877: astore 7
    //   879: aload_1
    //   880: astore 8
    //   882: aload 10
    //   884: aload 20
    //   886: putfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$8	Ljava/lang/Object;
    //   889: aload 9
    //   891: astore 6
    //   893: aload_1
    //   894: astore 7
    //   896: aload_1
    //   897: astore 8
    //   899: aload 10
    //   901: aload 20
    //   903: putfield 123	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$9	Ljava/lang/Object;
    //   906: aload 9
    //   908: astore 6
    //   910: aload_1
    //   911: astore 7
    //   913: aload_1
    //   914: astore 8
    //   916: aload 10
    //   918: iconst_2
    //   919: putfield 119	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:label	I
    //   922: aload 9
    //   924: astore 6
    //   926: aload_1
    //   927: astore 7
    //   929: aload_1
    //   930: astore 8
    //   932: aload 17
    //   934: aload 10
    //   936: invokeinterface 166 2 0
    //   941: astore 21
    //   943: aload 21
    //   945: aload 18
    //   947: if_acmpne +380 -> 1327
    //   950: aload 18
    //   952: areturn
    //   953: aload 9
    //   955: astore 6
    //   957: aload_1
    //   958: astore 7
    //   960: aload_1
    //   961: astore 8
    //   963: aload 18
    //   965: checkcast 168	java/lang/Boolean
    //   968: invokevirtual 172	java/lang/Boolean:booleanValue	()Z
    //   971: ifne +6 -> 977
    //   974: goto -467 -> 507
    //   977: aload 9
    //   979: astore 6
    //   981: aload_1
    //   982: astore 7
    //   984: aload_1
    //   985: astore 8
    //   987: aload 17
    //   989: invokeinterface 175 1 0
    //   994: astore 18
    //   996: aload 9
    //   998: astore 6
    //   1000: aload_1
    //   1001: astore 7
    //   1003: aload_1
    //   1004: astore 8
    //   1006: aload 10
    //   1008: getfield 78	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:$transform	Lkotlin/jvm/functions/Function2;
    //   1011: aload 20
    //   1013: aload 18
    //   1015: invokeinterface 177 3 0
    //   1020: astore 21
    //   1022: aload 9
    //   1024: astore 6
    //   1026: aload_1
    //   1027: astore 7
    //   1029: aload_1
    //   1030: astore 8
    //   1032: aload 10
    //   1034: aload 12
    //   1036: putfield 145	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$0	Ljava/lang/Object;
    //   1039: aload 9
    //   1041: astore 6
    //   1043: aload_1
    //   1044: astore 7
    //   1046: aload_1
    //   1047: astore 8
    //   1049: aload 10
    //   1051: aload 17
    //   1053: putfield 143	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$1	Ljava/lang/Object;
    //   1056: aload 9
    //   1058: astore 6
    //   1060: aload_1
    //   1061: astore 7
    //   1063: aload_1
    //   1064: astore 8
    //   1066: aload 10
    //   1068: aload 16
    //   1070: putfield 141	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$2	Ljava/lang/Object;
    //   1073: aload 9
    //   1075: astore 6
    //   1077: aload_1
    //   1078: astore 7
    //   1080: aload_1
    //   1081: astore 8
    //   1083: aload 10
    //   1085: aload 15
    //   1087: putfield 139	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$3	Ljava/lang/Object;
    //   1090: aload 9
    //   1092: astore 6
    //   1094: aload_1
    //   1095: astore 7
    //   1097: aload_1
    //   1098: astore 8
    //   1100: aload 10
    //   1102: aload_1
    //   1103: putfield 137	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$4	Ljava/lang/Object;
    //   1106: aload 9
    //   1108: astore 6
    //   1110: aload_1
    //   1111: astore 7
    //   1113: aload_1
    //   1114: astore 8
    //   1116: aload 10
    //   1118: aload 9
    //   1120: putfield 135	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$5	Ljava/lang/Object;
    //   1123: aload 9
    //   1125: astore 6
    //   1127: aload_1
    //   1128: astore 7
    //   1130: aload_1
    //   1131: astore 8
    //   1133: aload 10
    //   1135: aload 14
    //   1137: putfield 131	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$6	Ljava/lang/Object;
    //   1140: aload 9
    //   1142: astore 6
    //   1144: aload_1
    //   1145: astore 7
    //   1147: aload_1
    //   1148: astore 8
    //   1150: aload 10
    //   1152: aload 11
    //   1154: putfield 127	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$7	Ljava/lang/Object;
    //   1157: aload 9
    //   1159: astore 6
    //   1161: aload_1
    //   1162: astore 7
    //   1164: aload_1
    //   1165: astore 8
    //   1167: aload 10
    //   1169: aload 19
    //   1171: putfield 125	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$8	Ljava/lang/Object;
    //   1174: aload 9
    //   1176: astore 6
    //   1178: aload_1
    //   1179: astore 7
    //   1181: aload_1
    //   1182: astore 8
    //   1184: aload 10
    //   1186: aload 20
    //   1188: putfield 123	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$9	Ljava/lang/Object;
    //   1191: aload 9
    //   1193: astore 6
    //   1195: aload_1
    //   1196: astore 7
    //   1198: aload_1
    //   1199: astore 8
    //   1201: aload 10
    //   1203: aload 18
    //   1205: putfield 121	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:L$10	Ljava/lang/Object;
    //   1208: aload 9
    //   1210: astore 6
    //   1212: aload_1
    //   1213: astore 7
    //   1215: aload_1
    //   1216: astore 8
    //   1218: aload 10
    //   1220: iconst_3
    //   1221: putfield 119	kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt$zip$2:label	I
    //   1224: aload 9
    //   1226: astore 6
    //   1228: aload_1
    //   1229: astore 7
    //   1231: aload_1
    //   1232: astore 8
    //   1234: aload 10
    //   1236: astore 18
    //   1238: aload 12
    //   1240: astore 19
    //   1242: aload 13
    //   1244: astore 20
    //   1246: aload 12
    //   1248: aload 21
    //   1250: aload 10
    //   1252: invokeinterface 181 3 0
    //   1257: aload 13
    //   1259: if_acmpne +83 -> 1342
    //   1262: aload 13
    //   1264: areturn
    //   1265: aload 9
    //   1267: astore 6
    //   1269: aload_1
    //   1270: astore 7
    //   1272: aload_1
    //   1273: astore 8
    //   1275: getstatic 106	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   1278: astore 10
    //   1280: aload_1
    //   1281: aload 9
    //   1283: invokestatic 187	kotlinx/coroutines/channels/ChannelsKt:cancelConsumed	(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)V
    //   1286: getstatic 106	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   1289: areturn
    //   1290: astore_1
    //   1291: aload 6
    //   1293: astore 8
    //   1295: aload 7
    //   1297: astore 6
    //   1299: goto +13 -> 1312
    //   1302: astore_1
    //   1303: aload 8
    //   1305: astore 7
    //   1307: aload_1
    //   1308: astore 6
    //   1310: aload_1
    //   1311: athrow
    //   1312: aload 6
    //   1314: aload 8
    //   1316: invokestatic 187	kotlinx/coroutines/channels/ChannelsKt:cancelConsumed	(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)V
    //   1319: goto +5 -> 1324
    //   1322: aload_1
    //   1323: athrow
    //   1324: goto -2 -> 1322
    //   1327: aload 20
    //   1329: astore 19
    //   1331: aload 18
    //   1333: astore 13
    //   1335: aload 21
    //   1337: astore 18
    //   1339: goto -386 -> 953
    //   1342: iconst_1
    //   1343: istore_2
    //   1344: aload 18
    //   1346: astore 10
    //   1348: aload 19
    //   1350: astore 12
    //   1352: aload 20
    //   1354: astore 13
    //   1356: goto -849 -> 507
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1359	0	this	2
    //   0	1359	1	paramObject	Object
    //   17	1327	2	i	int
    //   12	396	3	j	int
    //   14	266	4	k	int
    //   9	30	5	m	int
    //   45	1268	6	localObject1	Object
    //   137	1169	7	localObject2	Object
    //   141	1174	8	localObject3	Object
    //   3	1279	9	localObject4	Object
    //   93	1254	10	localObject5	Object
    //   66	1087	11	localObject6	Object
    //   84	1267	12	localObject7	Object
    //   274	1081	13	localObject8	Object
    //   75	1061	14	localObject9	Object
    //   102	984	15	localObject10	Object
    //   111	958	16	localObject11	Object
    //   120	932	17	localChannelIterator	ChannelIterator
    //   152	1193	18	localObject12	Object
    //   129	1220	19	localObject13	Object
    //   149	1204	20	localObject14	Object
    //   941	395	21	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   258	262	297	finally
    //   258	262	301	java/lang/Throwable
    //   143	147	1290	finally
    //   393	397	1290	finally
    //   469	477	1290	finally
    //   517	524	1290	finally
    //   534	541	1290	finally
    //   551	558	1290	finally
    //   568	575	1290	finally
    //   585	591	1290	finally
    //   601	608	1290	finally
    //   618	625	1290	finally
    //   635	642	1290	finally
    //   652	658	1290	finally
    //   668	679	1290	finally
    //   707	718	1290	finally
    //   728	737	1290	finally
    //   747	754	1290	finally
    //   764	771	1290	finally
    //   781	788	1290	finally
    //   798	805	1290	finally
    //   815	821	1290	finally
    //   831	838	1290	finally
    //   848	855	1290	finally
    //   865	872	1290	finally
    //   882	889	1290	finally
    //   899	906	1290	finally
    //   916	922	1290	finally
    //   932	943	1290	finally
    //   963	974	1290	finally
    //   987	996	1290	finally
    //   1006	1022	1290	finally
    //   1032	1039	1290	finally
    //   1049	1056	1290	finally
    //   1066	1073	1290	finally
    //   1083	1090	1290	finally
    //   1100	1106	1290	finally
    //   1116	1123	1290	finally
    //   1133	1140	1290	finally
    //   1150	1157	1290	finally
    //   1167	1174	1290	finally
    //   1184	1191	1290	finally
    //   1201	1208	1290	finally
    //   1218	1224	1290	finally
    //   1246	1262	1290	finally
    //   1275	1280	1290	finally
    //   1310	1312	1290	finally
    //   143	147	1302	java/lang/Throwable
    //   393	397	1302	java/lang/Throwable
    //   469	477	1302	java/lang/Throwable
    //   517	524	1302	java/lang/Throwable
    //   534	541	1302	java/lang/Throwable
    //   551	558	1302	java/lang/Throwable
    //   568	575	1302	java/lang/Throwable
    //   585	591	1302	java/lang/Throwable
    //   601	608	1302	java/lang/Throwable
    //   618	625	1302	java/lang/Throwable
    //   635	642	1302	java/lang/Throwable
    //   652	658	1302	java/lang/Throwable
    //   668	679	1302	java/lang/Throwable
    //   707	718	1302	java/lang/Throwable
    //   728	737	1302	java/lang/Throwable
    //   747	754	1302	java/lang/Throwable
    //   764	771	1302	java/lang/Throwable
    //   781	788	1302	java/lang/Throwable
    //   798	805	1302	java/lang/Throwable
    //   815	821	1302	java/lang/Throwable
    //   831	838	1302	java/lang/Throwable
    //   848	855	1302	java/lang/Throwable
    //   865	872	1302	java/lang/Throwable
    //   882	889	1302	java/lang/Throwable
    //   899	906	1302	java/lang/Throwable
    //   916	922	1302	java/lang/Throwable
    //   932	943	1302	java/lang/Throwable
    //   963	974	1302	java/lang/Throwable
    //   987	996	1302	java/lang/Throwable
    //   1006	1022	1302	java/lang/Throwable
    //   1032	1039	1302	java/lang/Throwable
    //   1049	1056	1302	java/lang/Throwable
    //   1066	1073	1302	java/lang/Throwable
    //   1083	1090	1302	java/lang/Throwable
    //   1100	1106	1302	java/lang/Throwable
    //   1116	1123	1302	java/lang/Throwable
    //   1133	1140	1302	java/lang/Throwable
    //   1150	1157	1302	java/lang/Throwable
    //   1167	1174	1302	java/lang/Throwable
    //   1184	1191	1302	java/lang/Throwable
    //   1201	1208	1302	java/lang/Throwable
    //   1218	1224	1302	java/lang/Throwable
    //   1246	1262	1302	java/lang/Throwable
    //   1275	1280	1302	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.zip.2
 * JD-Core Version:    0.7.0.1
 */