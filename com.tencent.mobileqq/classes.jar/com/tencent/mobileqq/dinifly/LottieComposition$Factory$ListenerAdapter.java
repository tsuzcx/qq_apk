package com.tencent.mobileqq.dinifly;

public final class LottieComposition$Factory$ListenerAdapter
  implements Cancellable, LottieListener<LottieComposition>
{
  private boolean cancelled = false;
  private final OnCompositionLoadedListener listener;
  
  public LottieComposition$Factory$ListenerAdapter(OnCompositionLoadedListener paramOnCompositionLoadedListener)
  {
    this.listener = paramOnCompositionLoadedListener;
  }
  
  public void cancel()
  {
    this.cancelled = true;
  }
  
  public void onResult(LottieComposition paramLottieComposition)
  {
    if (this.cancelled) {
      return;
    }
    this.listener.onCompositionLoaded(paramLottieComposition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieComposition.Factory.ListenerAdapter
 * JD-Core Version:    0.7.0.1
 */