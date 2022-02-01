package com.tencent.tavcut.render.audio.wave;

import android.media.MediaExtractor;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.tavcut.render.audio.wave.MediaCodecAudioWaveDataProcessor$decodeForWaveData$1", f="MediaCodecAudioWaveDataProcessor.kt", i={}, l={}, m="invokeSuspend", n={}, s={})
final class MediaCodecAudioWaveDataProcessor$decodeForWaveData$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  int label;
  private CoroutineScope p$;
  
  MediaCodecAudioWaveDataProcessor$decodeForWaveData$1(MediaCodecAudioWaveDataProcessor paramMediaCodecAudioWaveDataProcessor, int paramInt, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.this$0, this.$perSecondSampleCnt, paramContinuation);
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
      if (MediaCodecAudioWaveDataProcessor.a(this.this$0))
      {
        paramObject = this.this$0;
        MediaCodecAudioWaveDataProcessor.a(paramObject, new AudioWaveDataCalculator(MediaCodecAudioWaveDataProcessor.b(paramObject), MediaCodecAudioWaveDataProcessor.c(this.this$0), MediaCodecAudioWaveDataProcessor.d(this.this$0), this.$perSecondSampleCnt));
        MediaCodecAudioWaveDataProcessor.e(this.this$0);
      }
      else
      {
        MediaCodecAudioWaveDataProcessor.f(this.this$0).release();
        paramObject = MediaCodecAudioWaveDataProcessor.g(this.this$0);
        if (paramObject != null) {
          paramObject.a(2, "Init mediaExtractor failed");
        }
      }
      return Unit.INSTANCE;
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.wave.MediaCodecAudioWaveDataProcessor.decodeForWaveData.1
 * JD-Core Version:    0.7.0.1
 */