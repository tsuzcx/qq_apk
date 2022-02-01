package com.tencent.xaction.api;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IAnim;", "Lcom/tencent/xaction/api/ITimeline;", "end", "", "play", "preStart", "view", "Landroid/view/View;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract interface IAnim
  extends ITimeline
{
  public abstract void end();
  
  public abstract void preStart(@NotNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.IAnim
 * JD-Core Version:    0.7.0.1
 */