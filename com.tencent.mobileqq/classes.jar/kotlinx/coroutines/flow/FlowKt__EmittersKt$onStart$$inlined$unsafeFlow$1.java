package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1
  implements Flow<T>
{
  public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Flow paramFlow, Function2 paramFunction2) {}
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public Object collect(@org.jetbrains.annotations.NotNull FlowCollector paramFlowCollector, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation paramContinuation)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 43
    //   4: ifeq +39 -> 43
    //   7: aload_2
    //   8: checkcast 43	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
    //   11: astore 4
    //   13: aload 4
    //   15: getfield 47	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:label	I
    //   18: ldc 48
    //   20: iand
    //   21: ifeq +22 -> 43
    //   24: aload 4
    //   26: aload 4
    //   28: getfield 47	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:label	I
    //   31: ldc 48
    //   33: iadd
    //   34: putfield 47	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:label	I
    //   37: aload 4
    //   39: astore_2
    //   40: goto +13 -> 53
    //   43: new 43	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
    //   46: dup
    //   47: aload_0
    //   48: aload_2
    //   49: invokespecial 51	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:<init>	(Lkotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;Lkotlin/coroutines/Continuation;)V
    //   52: astore_2
    //   53: aload_2
    //   54: getfield 55	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:result	Ljava/lang/Object;
    //   57: astore 7
    //   59: invokestatic 61	kotlin/coroutines/intrinsics/IntrinsicsKt:getCOROUTINE_SUSPENDED	()Ljava/lang/Object;
    //   62: astore 9
    //   64: aload_2
    //   65: getfield 47	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:label	I
    //   68: istore_3
    //   69: iload_3
    //   70: ifeq +135 -> 205
    //   73: iload_3
    //   74: iconst_1
    //   75: if_icmpeq +66 -> 141
    //   78: iload_3
    //   79: iconst_2
    //   80: if_icmpne +51 -> 131
    //   83: aload_2
    //   84: getfield 64	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$4	Ljava/lang/Object;
    //   87: checkcast 66	kotlinx/coroutines/flow/internal/SafeCollector
    //   90: astore_1
    //   91: aload_2
    //   92: getfield 69	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   95: checkcast 71	kotlinx/coroutines/flow/FlowCollector
    //   98: astore_1
    //   99: aload_2
    //   100: getfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   103: checkcast 76	kotlin/coroutines/Continuation
    //   106: astore_1
    //   107: aload_2
    //   108: getfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   111: checkcast 71	kotlinx/coroutines/flow/FlowCollector
    //   114: astore_1
    //   115: aload_2
    //   116: getfield 82	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   119: checkcast 2	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1
    //   122: astore_1
    //   123: aload 7
    //   125: invokestatic 88	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   128: goto +240 -> 368
    //   131: new 90	java/lang/IllegalStateException
    //   134: dup
    //   135: ldc 92
    //   137: invokespecial 95	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   140: athrow
    //   141: aload_2
    //   142: getfield 64	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$4	Ljava/lang/Object;
    //   145: checkcast 66	kotlinx/coroutines/flow/internal/SafeCollector
    //   148: astore_1
    //   149: aload_2
    //   150: getfield 69	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   153: checkcast 71	kotlinx/coroutines/flow/FlowCollector
    //   156: astore 4
    //   158: aload_2
    //   159: getfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   162: checkcast 76	kotlin/coroutines/Continuation
    //   165: astore 8
    //   167: aload_2
    //   168: getfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   171: checkcast 71	kotlinx/coroutines/flow/FlowCollector
    //   174: astore 5
    //   176: aload_2
    //   177: getfield 82	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   180: checkcast 2	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1
    //   183: astore 6
    //   185: aload 7
    //   187: invokestatic 88	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   190: aload_1
    //   191: astore 7
    //   193: goto +112 -> 305
    //   196: astore_2
    //   197: aload_1
    //   198: astore 4
    //   200: aload_2
    //   201: astore_1
    //   202: goto +171 -> 373
    //   205: aload 7
    //   207: invokestatic 88	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   210: aload_2
    //   211: checkcast 76	kotlin/coroutines/Continuation
    //   214: astore 8
    //   216: new 66	kotlinx/coroutines/flow/internal/SafeCollector
    //   219: dup
    //   220: aload_1
    //   221: aload_2
    //   222: invokeinterface 99 1 0
    //   227: invokespecial 102	kotlinx/coroutines/flow/internal/SafeCollector:<init>	(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V
    //   230: astore 4
    //   232: aload_0
    //   233: getfield 35	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1:$action$inlined	Lkotlin/jvm/functions/Function2;
    //   236: astore 5
    //   238: aload_2
    //   239: aload_0
    //   240: putfield 82	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   243: aload_2
    //   244: aload_1
    //   245: putfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   248: aload_2
    //   249: aload 8
    //   251: putfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   254: aload_2
    //   255: aload_1
    //   256: putfield 69	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   259: aload_2
    //   260: aload 4
    //   262: putfield 64	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$4	Ljava/lang/Object;
    //   265: aload_2
    //   266: iconst_1
    //   267: putfield 47	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:label	I
    //   270: aload 5
    //   272: aload 4
    //   274: aload_2
    //   275: invokeinterface 108 3 0
    //   280: astore 5
    //   282: aload 5
    //   284: aload 9
    //   286: if_acmpne +6 -> 292
    //   289: aload 9
    //   291: areturn
    //   292: aload_0
    //   293: astore 6
    //   295: aload_1
    //   296: astore 5
    //   298: aload 4
    //   300: astore 7
    //   302: aload_1
    //   303: astore 4
    //   305: aload 7
    //   307: invokevirtual 111	kotlinx/coroutines/flow/internal/SafeCollector:releaseIntercepted	()V
    //   310: aload 6
    //   312: getfield 33	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1:$this_onStart$inlined	Lkotlinx/coroutines/flow/Flow;
    //   315: astore_1
    //   316: aload_2
    //   317: aload 6
    //   319: putfield 82	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$0	Ljava/lang/Object;
    //   322: aload_2
    //   323: aload 5
    //   325: putfield 79	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$1	Ljava/lang/Object;
    //   328: aload_2
    //   329: aload 8
    //   331: putfield 74	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$2	Ljava/lang/Object;
    //   334: aload_2
    //   335: aload 4
    //   337: putfield 69	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$3	Ljava/lang/Object;
    //   340: aload_2
    //   341: aload 7
    //   343: putfield 64	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:L$4	Ljava/lang/Object;
    //   346: aload_2
    //   347: iconst_2
    //   348: putfield 47	kotlinx/coroutines/flow/FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1:label	I
    //   351: aload_1
    //   352: aload 4
    //   354: aload_2
    //   355: invokeinterface 113 3 0
    //   360: aload 9
    //   362: if_acmpne +6 -> 368
    //   365: aload 9
    //   367: areturn
    //   368: getstatic 119	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   371: areturn
    //   372: astore_1
    //   373: aload 4
    //   375: invokevirtual 111	kotlinx/coroutines/flow/internal/SafeCollector:releaseIntercepted	()V
    //   378: aload_1
    //   379: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	1
    //   0	380	1	paramFlowCollector	FlowCollector
    //   0	380	2	paramContinuation	kotlin.coroutines.Continuation
    //   68	13	3	i	int
    //   11	363	4	localObject1	Object
    //   174	150	5	localObject2	Object
    //   183	135	6	local1	1
    //   57	285	7	localObject3	Object
    //   165	165	8	localContinuation	kotlin.coroutines.Continuation
    //   62	304	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   185	190	196	finally
    //   232	282	372	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__EmittersKt.onStart..inlined.unsafeFlow.1
 * JD-Core Version:    0.7.0.1
 */