package com.tencent.tavkit.component;

import android.support.annotation.NonNull;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tavkit.composition.TAVComposition;

public abstract interface TAVPlayer$ICompositionBuilder
  extends OnCompositionUpdateListener
{
  @NonNull
  public abstract TAVComposition buildComposition();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.ICompositionBuilder
 * JD-Core Version:    0.7.0.1
 */