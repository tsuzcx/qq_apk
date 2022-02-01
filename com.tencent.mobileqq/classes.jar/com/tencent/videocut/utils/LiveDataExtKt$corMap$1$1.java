package com.tencent.videocut.utils;

import androidx.lifecycle.LiveDataScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "X", "Y", "Landroidx/lifecycle/LiveDataScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
@DebugMetadata(c="com.tencent.videocut.utils.LiveDataExtKt$corMap$1$1", f="LiveDataExt.kt", i={}, l={82, 82}, m="invokeSuspend", n={}, s={})
final class LiveDataExtKt$corMap$1$1
  extends SuspendLambda
  implements Function2<LiveDataScope<Y>, Continuation<? super Unit>, Object>
{
  int label;
  
  LiveDataExtKt$corMap$1$1(LiveDataExtKt.corMap.1 param1, Object paramObject, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkNotNullParameter(paramContinuation, "completion");
    paramContinuation = new 1(this.this$0, this.$x, paramContinuation);
    paramContinuation.L$0 = paramObject;
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.label;
    LiveDataScope localLiveDataScope;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          ResultKt.throwOnFailure(paramObject);
          break label142;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      localLiveDataScope = (LiveDataScope)this.L$0;
      ResultKt.throwOnFailure(paramObject);
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localLiveDataScope = (LiveDataScope)this.L$0;
      paramObject = this.this$0.b;
      Object localObject1 = this.$x;
      this.L$0 = localLiveDataScope;
      this.label = 1;
      localObject1 = paramObject.invoke(localObject1, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    this.L$0 = null;
    this.label = 2;
    if (localLiveDataScope.emit(paramObject, this) == localObject2) {
      return localObject2;
    }
    label142:
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.LiveDataExtKt.corMap.1.1
 * JD-Core Version:    0.7.0.1
 */