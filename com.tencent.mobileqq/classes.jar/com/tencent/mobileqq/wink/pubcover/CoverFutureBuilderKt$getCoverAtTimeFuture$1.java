package com.tencent.mobileqq.wink.pubcover;

import android.graphics.Bitmap;
import com.tencent.tavcut.render.cover.ICoverProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.mobileqq.wink.pubcover.CoverFutureBuilderKt$getCoverAtTimeFuture$1", f="CoverFutureBuilder.kt", i={}, l={}, m="invokeSuspend", n={}, s={})
final class CoverFutureBuilderKt$getCoverAtTimeFuture$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object>
{
  int label;
  private CoroutineScope p$;
  
  CoverFutureBuilderKt$getCoverAtTimeFuture$1(ICoverProvider paramICoverProvider, long paramLong, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.$coverProvider, this.$currentTime, paramContinuation);
    paramContinuation.p$ = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.label == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      return this.$coverProvider.a(this.$currentTime);
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pubcover.CoverFutureBuilderKt.getCoverAtTimeFuture.1
 * JD-Core Version:    0.7.0.1
 */