package kotlin.streams.jdk8;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", "T", "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k=2, mv={1, 1, 16}, pn="kotlin.streams")
@JvmName(name="StreamsKt")
public final class StreamsKt
{
  @SinceKotlin(version="1.2")
  @NotNull
  public static final Sequence<Double> asSequence(@NotNull DoubleStream paramDoubleStream)
  {
    Intrinsics.checkParameterIsNotNull(paramDoubleStream, "$this$asSequence");
    return (Sequence)new StreamsKt.asSequence..inlined.Sequence.4(paramDoubleStream);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final Sequence<Integer> asSequence(@NotNull IntStream paramIntStream)
  {
    Intrinsics.checkParameterIsNotNull(paramIntStream, "$this$asSequence");
    return (Sequence)new StreamsKt.asSequence..inlined.Sequence.2(paramIntStream);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final Sequence<Long> asSequence(@NotNull LongStream paramLongStream)
  {
    Intrinsics.checkParameterIsNotNull(paramLongStream, "$this$asSequence");
    return (Sequence)new StreamsKt.asSequence..inlined.Sequence.3(paramLongStream);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> Sequence<T> asSequence(@NotNull Stream<T> paramStream)
  {
    Intrinsics.checkParameterIsNotNull(paramStream, "$this$asSequence");
    return (Sequence)new StreamsKt.asSequence..inlined.Sequence.1(paramStream);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> Stream<T> asStream(@NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$asStream");
    paramSequence = StreamSupport.stream((Supplier)new StreamsKt.asStream.1(paramSequence), 16, false);
    Intrinsics.checkExpressionValueIsNotNull(paramSequence, "StreamSupport.stream({ S…literator.ORDERED, false)");
    return paramSequence;
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final List<Double> toList(@NotNull DoubleStream paramDoubleStream)
  {
    Intrinsics.checkParameterIsNotNull(paramDoubleStream, "$this$toList");
    paramDoubleStream = paramDoubleStream.toArray();
    Intrinsics.checkExpressionValueIsNotNull(paramDoubleStream, "toArray()");
    return ArraysKt.asList(paramDoubleStream);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final List<Integer> toList(@NotNull IntStream paramIntStream)
  {
    Intrinsics.checkParameterIsNotNull(paramIntStream, "$this$toList");
    paramIntStream = paramIntStream.toArray();
    Intrinsics.checkExpressionValueIsNotNull(paramIntStream, "toArray()");
    return ArraysKt.asList(paramIntStream);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final List<Long> toList(@NotNull LongStream paramLongStream)
  {
    Intrinsics.checkParameterIsNotNull(paramLongStream, "$this$toList");
    paramLongStream = paramLongStream.toArray();
    Intrinsics.checkExpressionValueIsNotNull(paramLongStream, "toArray()");
    return ArraysKt.asList(paramLongStream);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <T> List<T> toList(@NotNull Stream<T> paramStream)
  {
    Intrinsics.checkParameterIsNotNull(paramStream, "$this$toList");
    paramStream = paramStream.collect(Collectors.toList());
    Intrinsics.checkExpressionValueIsNotNull(paramStream, "collect(Collectors.toList<T>())");
    return (List)paramStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.streams.jdk8.StreamsKt
 * JD-Core Version:    0.7.0.1
 */