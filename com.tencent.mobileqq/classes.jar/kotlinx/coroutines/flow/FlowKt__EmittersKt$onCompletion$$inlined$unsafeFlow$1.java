package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1
  implements Flow<T>
{
  public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow paramFlow, Function3 paramFunction3) {}
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public Object collect(@org.jetbrains.annotations.NotNull FlowCollector paramFlowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation paramContinuation)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 45
    //   4: ifeq +36 -> 40
    //   7: aload_2
    //   8: checkcast 45	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
    //   11: astore 10
    //   13: aload 10
    //   15: getfield 49	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:label	I
    //   18: ldc 50
    //   20: iand
    //   21: ifeq +19 -> 40
    //   24: aload 10
    //   26: aload 10
    //   28: getfield 49	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:label	I
    //   31: ldc 50
    //   33: iadd
    //   34: putfield 49	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:label	I
    //   37: goto +14 -> 51
    //   40: new 45	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
    //   43: dup
    //   44: aload_0
    //   45: aload_2
    //   46: invokespecial 53	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:<init>	(Lkotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;Lkotlin/coroutines/Continuation;)V
    //   49: astore 10
    //   51: aload 10
    //   53: getfield 57	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:result	Ljava/lang/Object;
    //   56: astore 11
    //   58: invokestatic 63	kotlin/coroutines/intrinsics/IntrinsicsKt:getCOROUTINE_SUSPENDED	()Ljava/lang/Object;
    //   61: astore 12
    //   63: aload 10
    //   65: getfield 49	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:label	I
    //   68: istore_3
    //   69: iload_3
    //   70: ifeq +228 -> 298
    //   73: iload_3
    //   74: iconst_1
    //   75: if_icmpeq +146 -> 221
    //   78: iload_3
    //   79: iconst_2
    //   80: if_icmpeq +88 -> 168
    //   83: iload_3
    //   84: iconst_3
    //   85: if_icmpne +73 -> 158
    //   88: aload 10
    //   90: getfield 66	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$5	Ljava/lang/Object;
    //   93: checkcast 43	java/lang/Throwable
    //   96: astore_2
    //   97: aload 10
    //   99: getfield 69	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$4	Ljava/lang/Object;
    //   102: checkcast 71	kotlinx/coroutines/flow/internal/SafeCollector
    //   105: astore_1
    //   106: aload 10
    //   108: getfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   111: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   114: astore 4
    //   116: aload 10
    //   118: getfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   121: checkcast 81	kotlin/coroutines/Continuation
    //   124: astore 4
    //   126: aload 10
    //   128: getfield 84	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   131: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   134: astore 4
    //   136: aload 10
    //   138: getfield 87	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   141: checkcast 2	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1
    //   144: astore 4
    //   146: aload 11
    //   148: invokestatic 93	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   151: goto +343 -> 494
    //   154: astore_2
    //   155: goto +354 -> 509
    //   158: new 95	java/lang/IllegalStateException
    //   161: dup
    //   162: ldc 97
    //   164: invokespecial 100	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   167: athrow
    //   168: aload 10
    //   170: getfield 69	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$4	Ljava/lang/Object;
    //   173: checkcast 43	java/lang/Throwable
    //   176: astore_1
    //   177: aload 10
    //   179: getfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   182: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   185: astore_2
    //   186: aload 10
    //   188: getfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   191: checkcast 81	kotlin/coroutines/Continuation
    //   194: astore_2
    //   195: aload 10
    //   197: getfield 84	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   200: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   203: astore_2
    //   204: aload 10
    //   206: getfield 87	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   209: checkcast 2	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1
    //   212: astore_2
    //   213: aload 11
    //   215: invokestatic 93	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   218: goto +391 -> 609
    //   221: aload 10
    //   223: getfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   226: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   229: astore 8
    //   231: aload 10
    //   233: getfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   236: checkcast 81	kotlin/coroutines/Continuation
    //   239: astore 5
    //   241: aload 10
    //   243: getfield 84	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   246: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   249: astore 6
    //   251: aload 10
    //   253: getfield 87	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   256: checkcast 2	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1
    //   259: astore 7
    //   261: aload 5
    //   263: astore 4
    //   265: aload 6
    //   267: astore_2
    //   268: aload 7
    //   270: astore_1
    //   271: aload 8
    //   273: astore 9
    //   275: aload 11
    //   277: invokestatic 93	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   280: goto +94 -> 374
    //   283: astore 5
    //   285: aload 9
    //   287: astore 7
    //   289: aload_1
    //   290: astore 6
    //   292: aload 5
    //   294: astore_1
    //   295: goto +237 -> 532
    //   298: aload 11
    //   300: invokestatic 93	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   303: aload 10
    //   305: checkcast 81	kotlin/coroutines/Continuation
    //   308: astore 5
    //   310: aload_0
    //   311: getfield 33	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1:$this_onCompletion$inlined	Lkotlinx/coroutines/flow/Flow;
    //   314: astore_2
    //   315: aload 10
    //   317: aload_0
    //   318: putfield 87	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   321: aload 10
    //   323: aload_1
    //   324: putfield 84	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   327: aload 10
    //   329: aload 5
    //   331: putfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   334: aload 10
    //   336: aload_1
    //   337: putfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   340: aload 10
    //   342: iconst_1
    //   343: putfield 49	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:label	I
    //   346: aload_2
    //   347: aload_1
    //   348: aload 10
    //   350: invokestatic 106	kotlinx/coroutines/flow/FlowKt:catchImpl	(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    //   353: astore 11
    //   355: aload 11
    //   357: aload 12
    //   359: if_acmpne +6 -> 365
    //   362: aload 12
    //   364: areturn
    //   365: aload_0
    //   366: astore 7
    //   368: aload_1
    //   369: astore 6
    //   371: aload_1
    //   372: astore 8
    //   374: aload 5
    //   376: astore 4
    //   378: aload 6
    //   380: astore_2
    //   381: aload 7
    //   383: astore_1
    //   384: aload 8
    //   386: astore 9
    //   388: aload 11
    //   390: checkcast 43	java/lang/Throwable
    //   393: astore 11
    //   395: new 71	kotlinx/coroutines/flow/internal/SafeCollector
    //   398: dup
    //   399: aload 8
    //   401: aload 10
    //   403: invokeinterface 110 1 0
    //   408: invokespecial 113	kotlinx/coroutines/flow/internal/SafeCollector:<init>	(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V
    //   411: astore_1
    //   412: aload_1
    //   413: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   416: astore_2
    //   417: aload 7
    //   419: getfield 35	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1:$action$inlined	Lkotlin/jvm/functions/Function3;
    //   422: astore 4
    //   424: aload 10
    //   426: aload 7
    //   428: putfield 87	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   431: aload 10
    //   433: aload 6
    //   435: putfield 84	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   438: aload 10
    //   440: aload 5
    //   442: putfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   445: aload 10
    //   447: aload 8
    //   449: putfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   452: aload 10
    //   454: aload_1
    //   455: putfield 69	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$4	Ljava/lang/Object;
    //   458: aload 10
    //   460: aload 11
    //   462: putfield 66	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$5	Ljava/lang/Object;
    //   465: aload 10
    //   467: iconst_3
    //   468: putfield 49	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:label	I
    //   471: aload_2
    //   472: aload 4
    //   474: aload 11
    //   476: aload 10
    //   478: invokestatic 119	kotlinx/coroutines/flow/FlowKt__EmittersKt:invokeSafely$FlowKt__EmittersKt	(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    //   481: astore_2
    //   482: aload_2
    //   483: aload 12
    //   485: if_acmpne +6 -> 491
    //   488: aload 12
    //   490: areturn
    //   491: aload 11
    //   493: astore_2
    //   494: aload_1
    //   495: invokevirtual 122	kotlinx/coroutines/flow/internal/SafeCollector:releaseIntercepted	()V
    //   498: aload_2
    //   499: ifnonnull +7 -> 506
    //   502: getstatic 128	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   505: areturn
    //   506: aload_2
    //   507: athrow
    //   508: astore_2
    //   509: aload_1
    //   510: invokevirtual 122	kotlinx/coroutines/flow/internal/SafeCollector:releaseIntercepted	()V
    //   513: aload_2
    //   514: athrow
    //   515: astore 4
    //   517: aload_0
    //   518: astore 6
    //   520: aload_1
    //   521: astore_2
    //   522: aload 4
    //   524: astore_1
    //   525: aload_2
    //   526: astore 7
    //   528: aload 5
    //   530: astore 4
    //   532: new 130	kotlinx/coroutines/flow/ThrowingCollector
    //   535: dup
    //   536: aload_1
    //   537: invokespecial 133	kotlinx/coroutines/flow/ThrowingCollector:<init>	(Ljava/lang/Throwable;)V
    //   540: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   543: astore 5
    //   545: aload 6
    //   547: getfield 35	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1:$action$inlined	Lkotlin/jvm/functions/Function3;
    //   550: astore 8
    //   552: aload 10
    //   554: aload 6
    //   556: putfield 87	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   559: aload 10
    //   561: aload_2
    //   562: putfield 84	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   565: aload 10
    //   567: aload 4
    //   569: putfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   572: aload 10
    //   574: aload 7
    //   576: putfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   579: aload 10
    //   581: aload_1
    //   582: putfield 69	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:L$4	Ljava/lang/Object;
    //   585: aload 10
    //   587: iconst_2
    //   588: putfield 49	kotlinx/coroutines/flow/FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1:label	I
    //   591: aload 5
    //   593: aload 8
    //   595: aconst_null
    //   596: aload 10
    //   598: invokestatic 119	kotlinx/coroutines/flow/FlowKt__EmittersKt:invokeSafely$FlowKt__EmittersKt	(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    //   601: aload 12
    //   603: if_acmpne +6 -> 609
    //   606: aload 12
    //   608: areturn
    //   609: aload_1
    //   610: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	611	0	this	1
    //   0	611	1	paramFlowCollector	FlowCollector
    //   0	611	2	paramContinuation	kotlin.coroutines.Continuation
    //   68	18	3	i	int
    //   114	359	4	localObject1	Object
    //   515	8	4	localThrowable1	java.lang.Throwable
    //   530	38	4	localObject2	Object
    //   239	23	5	localContinuation	kotlin.coroutines.Continuation
    //   283	10	5	localThrowable2	java.lang.Throwable
    //   308	284	5	localObject3	Object
    //   249	306	6	localObject4	Object
    //   259	316	7	localObject5	Object
    //   229	365	8	localObject6	Object
    //   273	114	9	localObject7	Object
    //   11	586	10	local1	FlowKt__EmittersKt.onCompletion..inlined.unsafeFlow.1.1
    //   56	436	11	localObject8	Object
    //   61	546	12	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   146	151	154	finally
    //   275	280	283	java/lang/Throwable
    //   388	395	283	java/lang/Throwable
    //   412	482	508	finally
    //   310	355	515	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__EmittersKt.onCompletion..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */