package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.FlowPreview;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@FlowPreview
public abstract class AbstractFlow<T>
  implements Flow<T>
{
  /* Error */
  @kotlinx.coroutines.InternalCoroutinesApi
  @Nullable
  public final Object collect(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Continuation<? super Unit> paramContinuation)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 39
    //   4: ifeq +39 -> 43
    //   7: aload_2
    //   8: checkcast 39	kotlinx/coroutines/flow/AbstractFlow$collect$1
    //   11: astore 4
    //   13: aload 4
    //   15: getfield 43	kotlinx/coroutines/flow/AbstractFlow$collect$1:label	I
    //   18: ldc 44
    //   20: iand
    //   21: ifeq +22 -> 43
    //   24: aload 4
    //   26: aload 4
    //   28: getfield 43	kotlinx/coroutines/flow/AbstractFlow$collect$1:label	I
    //   31: ldc 44
    //   33: iadd
    //   34: putfield 43	kotlinx/coroutines/flow/AbstractFlow$collect$1:label	I
    //   37: aload 4
    //   39: astore_2
    //   40: goto +13 -> 53
    //   43: new 39	kotlinx/coroutines/flow/AbstractFlow$collect$1
    //   46: dup
    //   47: aload_0
    //   48: aload_2
    //   49: invokespecial 47	kotlinx/coroutines/flow/AbstractFlow$collect$1:<init>	(Lkotlinx/coroutines/flow/AbstractFlow;Lkotlin/coroutines/Continuation;)V
    //   52: astore_2
    //   53: aload_2
    //   54: getfield 51	kotlinx/coroutines/flow/AbstractFlow$collect$1:result	Ljava/lang/Object;
    //   57: astore 4
    //   59: invokestatic 57	kotlin/coroutines/intrinsics/IntrinsicsKt:getCOROUTINE_SUSPENDED	()Ljava/lang/Object;
    //   62: astore 5
    //   64: aload_2
    //   65: getfield 43	kotlinx/coroutines/flow/AbstractFlow$collect$1:label	I
    //   68: istore_3
    //   69: iload_3
    //   70: ifeq +60 -> 130
    //   73: iload_3
    //   74: iconst_1
    //   75: if_icmpne +45 -> 120
    //   78: aload_2
    //   79: getfield 60	kotlinx/coroutines/flow/AbstractFlow$collect$1:L$2	Ljava/lang/Object;
    //   82: checkcast 62	kotlinx/coroutines/flow/internal/SafeCollector
    //   85: astore_1
    //   86: aload_2
    //   87: getfield 65	kotlinx/coroutines/flow/AbstractFlow$collect$1:L$1	Ljava/lang/Object;
    //   90: checkcast 67	kotlinx/coroutines/flow/FlowCollector
    //   93: astore 5
    //   95: aload_2
    //   96: getfield 70	kotlinx/coroutines/flow/AbstractFlow$collect$1:L$0	Ljava/lang/Object;
    //   99: checkcast 2	kotlinx/coroutines/flow/AbstractFlow
    //   102: astore_2
    //   103: aload 4
    //   105: invokestatic 76	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   108: goto +91 -> 199
    //   111: astore_2
    //   112: aload_1
    //   113: astore 4
    //   115: aload_2
    //   116: astore_1
    //   117: goto +91 -> 208
    //   120: new 78	java/lang/IllegalStateException
    //   123: dup
    //   124: ldc 80
    //   126: invokespecial 83	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   129: athrow
    //   130: aload 4
    //   132: invokestatic 76	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   135: new 62	kotlinx/coroutines/flow/internal/SafeCollector
    //   138: dup
    //   139: aload_1
    //   140: aload_2
    //   141: invokeinterface 89 1 0
    //   146: invokespecial 92	kotlinx/coroutines/flow/internal/SafeCollector:<init>	(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V
    //   149: astore 4
    //   151: aload 4
    //   153: checkcast 67	kotlinx/coroutines/flow/FlowCollector
    //   156: astore 6
    //   158: aload_2
    //   159: aload_0
    //   160: putfield 70	kotlinx/coroutines/flow/AbstractFlow$collect$1:L$0	Ljava/lang/Object;
    //   163: aload_2
    //   164: aload_1
    //   165: putfield 65	kotlinx/coroutines/flow/AbstractFlow$collect$1:L$1	Ljava/lang/Object;
    //   168: aload_2
    //   169: aload 4
    //   171: putfield 60	kotlinx/coroutines/flow/AbstractFlow$collect$1:L$2	Ljava/lang/Object;
    //   174: aload_2
    //   175: iconst_1
    //   176: putfield 43	kotlinx/coroutines/flow/AbstractFlow$collect$1:label	I
    //   179: aload_0
    //   180: aload 6
    //   182: aload_2
    //   183: invokevirtual 94	kotlinx/coroutines/flow/AbstractFlow:collectSafely	(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    //   186: astore_1
    //   187: aload_1
    //   188: aload 5
    //   190: if_acmpne +6 -> 196
    //   193: aload 5
    //   195: areturn
    //   196: aload 4
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 97	kotlinx/coroutines/flow/internal/SafeCollector:releaseIntercepted	()V
    //   203: getstatic 103	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   206: areturn
    //   207: astore_1
    //   208: aload 4
    //   210: invokevirtual 97	kotlinx/coroutines/flow/internal/SafeCollector:releaseIntercepted	()V
    //   213: aload_1
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	AbstractFlow
    //   0	215	1	paramFlowCollector	FlowCollector<? super T>
    //   0	215	2	paramContinuation	Continuation<? super Unit>
    //   68	8	3	i	int
    //   11	198	4	localObject1	Object
    //   62	132	5	localObject2	Object
    //   156	25	6	localFlowCollector	FlowCollector
    // Exception table:
    //   from	to	target	type
    //   103	108	111	finally
    //   151	187	207	finally
  }
  
  @Nullable
  public abstract Object collectSafely(@NotNull FlowCollector<? super T> paramFlowCollector, @NotNull Continuation<? super Unit> paramContinuation);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.AbstractFlow
 * JD-Core Version:    0.7.0.1
 */