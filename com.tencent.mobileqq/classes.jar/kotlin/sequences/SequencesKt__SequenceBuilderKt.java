package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"State_Done", "", "Lkotlin/sequences/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", "T", "builderAction", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "iterator", "block", "sequence", "SequenceBuilder", "Lkotlin/Deprecated;", "message", "Use SequenceScope class instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "SequenceScope<T>", "level", "Lkotlin/DeprecationLevel;", "ERROR", "State", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/sequences/SequencesKt")
public class SequencesKt__SequenceBuilderKt
{
  private static final int State_Done = 4;
  private static final int State_Failed = 5;
  private static final int State_ManyNotReady = 1;
  private static final int State_ManyReady = 2;
  private static final int State_NotReady = 0;
  private static final int State_Ready = 3;
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use 'iterator { }' function instead.", replaceWith=@ReplaceWith(expression="iterator(builderAction)", imports={}))
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> Iterator<T> buildIterator(@BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return SequencesKt.iterator(paramFunction2);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use 'sequence { }' function instead.", replaceWith=@ReplaceWith(expression="sequence(builderAction)", imports={}))
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> Sequence<T> buildSequence(@BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return (Sequence)new SequencesKt__SequenceBuilderKt.buildSequence..inlined.Sequence.1(paramFunction2);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> Iterator<T> iterator(@BuilderInference @NotNull Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "block");
    SequenceBuilderIterator localSequenceBuilderIterator = new SequenceBuilderIterator();
    localSequenceBuilderIterator.setNextStep(IntrinsicsKt.createCoroutineUnintercepted(paramFunction2, localSequenceBuilderIterator, (Continuation)localSequenceBuilderIterator));
    return (Iterator)localSequenceBuilderIterator;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> Sequence<T> sequence(@BuilderInference @NotNull Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "block");
    return (Sequence)new SequencesKt__SequenceBuilderKt.sequence..inlined.Sequence.1(paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.sequences.SequencesKt__SequenceBuilderKt
 * JD-Core Version:    0.7.0.1
 */