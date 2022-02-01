package kotlin.time.jdk8;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(D)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)D", "kotlin-stdlib-jdk8"}, k=2, mv={1, 1, 16}, pn="kotlin.time")
@JvmName(name="DurationConversionsJDK8Kt")
public final class DurationConversionsJDK8Kt
{
  @SinceKotlin(version="1.3")
  @InlineOnly
  @ExperimentalTime
  private static final java.time.Duration toJavaDuration-LRDsOJo(double paramDouble)
  {
    java.time.Duration localDuration = java.time.Duration.ofSeconds(kotlin.time.Duration.getInSeconds-impl(paramDouble), kotlin.time.Duration.getNanosecondsComponent-impl(paramDouble));
    Intrinsics.checkExpressionValueIsNotNull(localDuration, "java.time.Duration.ofSec…ds, nanoseconds.toLong())");
    Intrinsics.checkExpressionValueIsNotNull(localDuration, "toComponents { seconds, …, nanoseconds.toLong()) }");
    return localDuration;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  @ExperimentalTime
  private static final double toKotlinDuration(@NotNull java.time.Duration paramDuration)
  {
    return kotlin.time.Duration.plus-LRDsOJo(DurationKt.getSeconds(paramDuration.getSeconds()), DurationKt.getNanoseconds(paramDuration.getNano()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.time.jdk8.DurationConversionsJDK8Kt
 * JD-Core Version:    0.7.0.1
 */