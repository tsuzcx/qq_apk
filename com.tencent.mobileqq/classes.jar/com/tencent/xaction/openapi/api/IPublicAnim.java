package com.tencent.xaction.openapi.api;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IPublicAnim;", "", "end", "", "play", "preStart", "view", "Landroid/view/View;", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublicAnim
{
  public abstract void end();
  
  public abstract void play();
  
  public abstract void preStart(@NotNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IPublicAnim
 * JD-Core Version:    0.7.0.1
 */