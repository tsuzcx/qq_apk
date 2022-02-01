package kotlin.coroutines.experimental;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"State_Done", "", "Lkotlin/coroutines/experimental/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", "T", "builderAction", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/SequenceBuilder;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "State", "kotlin-stdlib-coroutines"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/coroutines/experimental/SequenceBuilderKt")
class SequenceBuilderKt__SequenceBuilderKt
{
  private static final int State_Done = 4;
  private static final int State_Failed = 5;
  private static final int State_ManyNotReady = 1;
  private static final int State_ManyReady = 2;
  private static final int State_NotReady = 0;
  private static final int State_Ready = 3;
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T> Iterator<T> buildIterator(@BuilderInference @NotNull Function2<? super SequenceBuilder<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "builderAction");
    SequenceBuilderIterator localSequenceBuilderIterator = new SequenceBuilderIterator();
    localSequenceBuilderIterator.setNextStep(IntrinsicsKt.createCoroutineUnchecked(paramFunction2, localSequenceBuilderIterator, (Continuation)localSequenceBuilderIterator));
    return (Iterator)localSequenceBuilderIterator;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T> Sequence<T> buildSequence(@BuilderInference @NotNull Function2<? super SequenceBuilder<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "builderAction");
    return (Sequence)new SequenceBuilderKt__SequenceBuilderKt.buildSequence..inlined.Sequence.1(paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.experimental.SequenceBuilderKt__SequenceBuilderKt
 * JD-Core Version:    0.7.0.1
 */