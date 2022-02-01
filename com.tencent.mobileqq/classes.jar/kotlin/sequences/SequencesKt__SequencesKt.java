package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/sequences/SequencesKt")
class SequencesKt__SequencesKt
  extends SequencesKt__SequencesJVMKt
{
  @InlineOnly
  private static final <T> Sequence<T> Sequence(Function0<? extends Iterator<? extends T>> paramFunction0)
  {
    return (Sequence)new SequencesKt__SequencesKt.Sequence.1(paramFunction0);
  }
  
  @NotNull
  public static final <T> Sequence<T> asSequence(@NotNull Iterator<? extends T> paramIterator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "$this$asSequence");
    return SequencesKt.constrainOnce((Sequence)new SequencesKt__SequencesKt.asSequence..inlined.Sequence.1(paramIterator));
  }
  
  @NotNull
  public static final <T> Sequence<T> constrainOnce(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$constrainOnce");
    if ((paramSequence instanceof ConstrainedOnceSequence)) {
      return paramSequence;
    }
    return (Sequence)new ConstrainedOnceSequence(paramSequence);
  }
  
  @NotNull
  public static final <T> Sequence<T> emptySequence()
  {
    return (Sequence)EmptySequence.INSTANCE;
  }
  
  @NotNull
  public static final <T> Sequence<T> flatten(@NotNull Sequence<? extends Sequence<? extends T>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$flatten");
    return flatten$SequencesKt__SequencesKt(paramSequence, (Function1)SequencesKt__SequencesKt.flatten.1.INSTANCE);
  }
  
  private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(@NotNull Sequence<? extends T> paramSequence, Function1<? super T, ? extends Iterator<? extends R>> paramFunction1)
  {
    if ((paramSequence instanceof TransformingSequence)) {
      return ((TransformingSequence)paramSequence).flatten$kotlin_stdlib(paramFunction1);
    }
    return (Sequence)new FlatteningSequence(paramSequence, (Function1)SequencesKt__SequencesKt.flatten.3.INSTANCE, paramFunction1);
  }
  
  @JvmName(name="flattenSequenceOfIterable")
  @NotNull
  public static final <T> Sequence<T> flattenSequenceOfIterable(@NotNull Sequence<? extends Iterable<? extends T>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$flatten");
    return flatten$SequencesKt__SequencesKt(paramSequence, (Function1)SequencesKt__SequencesKt.flatten.2.INSTANCE);
  }
  
  @LowPriorityInOverloadResolution
  @NotNull
  public static final <T> Sequence<T> generateSequence(@Nullable T paramT, @NotNull Function1<? super T, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nextFunction");
    if (paramT == null) {
      return (Sequence)EmptySequence.INSTANCE;
    }
    return (Sequence)new GeneratorSequence((Function0)new SequencesKt__SequencesKt.generateSequence.2(paramT), paramFunction1);
  }
  
  @NotNull
  public static final <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "nextFunction");
    return SequencesKt.constrainOnce((Sequence)new GeneratorSequence(paramFunction0, (Function1)new SequencesKt__SequencesKt.generateSequence.1(paramFunction0)));
  }
  
  @NotNull
  public static final <T> Sequence<T> generateSequence(@NotNull Function0<? extends T> paramFunction0, @NotNull Function1<? super T, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "seedFunction");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nextFunction");
    return (Sequence)new GeneratorSequence(paramFunction0, paramFunction1);
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> Sequence<T> ifEmpty(@NotNull Sequence<? extends T> paramSequence, @NotNull Function0<? extends Sequence<? extends T>> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$ifEmpty");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    return SequencesKt.sequence((Function2)new SequencesKt__SequencesKt.ifEmpty.1(paramSequence, paramFunction0, null));
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> Sequence<T> orEmpty(@Nullable Sequence<? extends T> paramSequence)
  {
    if (paramSequence != null) {
      return paramSequence;
    }
    return SequencesKt.emptySequence();
  }
  
  @NotNull
  public static final <T> Sequence<T> sequenceOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    int i;
    if (paramVarArgs.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return SequencesKt.emptySequence();
    }
    return ArraysKt.asSequence(paramVarArgs);
  }
  
  @NotNull
  public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Sequence<? extends Pair<? extends T, ? extends R>> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$unzip");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext())
    {
      Pair localPair = (Pair)paramSequence.next();
      localArrayList1.add(localPair.getFirst());
      localArrayList2.add(localPair.getSecond());
    }
    return TuplesKt.to(localArrayList1, localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.SequencesKt__SequencesKt
 * JD-Core Version:    0.7.0.1
 */