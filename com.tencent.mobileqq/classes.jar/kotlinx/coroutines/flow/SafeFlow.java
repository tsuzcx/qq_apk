package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/SafeFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "collect", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class SafeFlow<T>
  implements Flow<T>
{
  private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> block;
  
  public SafeFlow(@NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    this.block = paramFunction2;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public Object collect(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Continuation<? super Unit> paramContinuation)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 48
    //   4: ifeq +39 -> 43
    //   7: aload_2
    //   8: checkcast 48	kotlinx/coroutines/flow/SafeFlow$collect$1
    //   11: astore 4
    //   13: aload 4
    //   15: getfield 52	kotlinx/coroutines/flow/SafeFlow$collect$1:label	I
    //   18: ldc 53
    //   20: iand
    //   21: ifeq +22 -> 43
    //   24: aload 4
    //   26: aload 4
    //   28: getfield 52	kotlinx/coroutines/flow/SafeFlow$collect$1:label	I
    //   31: ldc 53
    //   33: iadd
    //   34: putfield 52	kotlinx/coroutines/flow/SafeFlow$collect$1:label	I
    //   37: aload 4
    //   39: astore_2
    //   40: goto +13 -> 53
    //   43: new 48	kotlinx/coroutines/flow/SafeFlow$collect$1
    //   46: dup
    //   47: aload_0
    //   48: aload_2
    //   49: invokespecial 56	kotlinx/coroutines/flow/SafeFlow$collect$1:<init>	(Lkotlinx/coroutines/flow/SafeFlow;Lkotlin/coroutines/Continuation;)V
    //   52: astore_2
    //   53: aload_2
    //   54: getfield 60	kotlinx/coroutines/flow/SafeFlow$collect$1:result	Ljava/lang/Object;
    //   57: astore 4
    //   59: invokestatic 66	kotlin/coroutines/intrinsics/IntrinsicsKt:getCOROUTINE_SUSPENDED	()Ljava/lang/Object;
    //   62: astore 5
    //   64: aload_2
    //   65: getfield 52	kotlinx/coroutines/flow/SafeFlow$collect$1:label	I
    //   68: istore_3
    //   69: iload_3
    //   70: ifeq +60 -> 130
    //   73: iload_3
    //   74: iconst_1
    //   75: if_icmpne +45 -> 120
    //   78: aload_2
    //   79: getfield 69	kotlinx/coroutines/flow/SafeFlow$collect$1:L$2	Ljava/lang/Object;
    //   82: checkcast 71	kotlinx/coroutines/flow/internal/SafeCollector
    //   85: astore_1
    //   86: aload_2
    //   87: getfield 74	kotlinx/coroutines/flow/SafeFlow$collect$1:L$1	Ljava/lang/Object;
    //   90: checkcast 76	kotlinx/coroutines/flow/FlowCollector
    //   93: astore 5
    //   95: aload_2
    //   96: getfield 79	kotlinx/coroutines/flow/SafeFlow$collect$1:L$0	Ljava/lang/Object;
    //   99: checkcast 2	kotlinx/coroutines/flow/SafeFlow
    //   102: astore_2
    //   103: aload 4
    //   105: invokestatic 85	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   108: goto +93 -> 201
    //   111: astore_2
    //   112: aload_1
    //   113: astore 4
    //   115: aload_2
    //   116: astore_1
    //   117: goto +93 -> 210
    //   120: new 87	java/lang/IllegalStateException
    //   123: dup
    //   124: ldc 89
    //   126: invokespecial 92	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   129: athrow
    //   130: aload 4
    //   132: invokestatic 85	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   135: new 71	kotlinx/coroutines/flow/internal/SafeCollector
    //   138: dup
    //   139: aload_1
    //   140: aload_2
    //   141: invokeinterface 98 1 0
    //   146: invokespecial 101	kotlinx/coroutines/flow/internal/SafeCollector:<init>	(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V
    //   149: astore 4
    //   151: aload_0
    //   152: getfield 41	kotlinx/coroutines/flow/SafeFlow:block	Lkotlin/jvm/functions/Function2;
    //   155: astore 6
    //   157: aload_2
    //   158: aload_0
    //   159: putfield 79	kotlinx/coroutines/flow/SafeFlow$collect$1:L$0	Ljava/lang/Object;
    //   162: aload_2
    //   163: aload_1
    //   164: putfield 74	kotlinx/coroutines/flow/SafeFlow$collect$1:L$1	Ljava/lang/Object;
    //   167: aload_2
    //   168: aload 4
    //   170: putfield 69	kotlinx/coroutines/flow/SafeFlow$collect$1:L$2	Ljava/lang/Object;
    //   173: aload_2
    //   174: iconst_1
    //   175: putfield 52	kotlinx/coroutines/flow/SafeFlow$collect$1:label	I
    //   178: aload 6
    //   180: aload 4
    //   182: aload_2
    //   183: invokeinterface 107 3 0
    //   188: astore_1
    //   189: aload_1
    //   190: aload 5
    //   192: if_acmpne +6 -> 198
    //   195: aload 5
    //   197: areturn
    //   198: aload 4
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 110	kotlinx/coroutines/flow/internal/SafeCollector:releaseIntercepted	()V
    //   205: getstatic 116	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   208: areturn
    //   209: astore_1
    //   210: aload 4
    //   212: invokevirtual 110	kotlinx/coroutines/flow/internal/SafeCollector:releaseIntercepted	()V
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	SafeFlow
    //   0	217	1	paramFlowCollector	FlowCollector<? super T>
    //   0	217	2	paramContinuation	Continuation<? super Unit>
    //   68	8	3	i	int
    //   11	200	4	localObject1	Object
    //   62	134	5	localObject2	Object
    //   155	24	6	localFunction2	Function2
    // Exception table:
    //   from	to	target	type
    //   103	108	111	finally
    //   151	189	209	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.SafeFlow
 * JD-Core Version:    0.7.0.1
 */