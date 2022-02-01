package com.tencent.mobileqq.kandian.base.view.api;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/api/IFontSizePanel;", "", "dismiss", "", "getTextSize", "", "index", "", "isShowing", "", "onDestroy", "showAtLocation", "parent", "Landroid/view/View;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFontSizePanel
{
  public abstract float a(int paramInt);
  
  @NotNull
  public abstract IFontSizePanel a(@Nullable View paramView);
  
  public abstract void a();
  
  public abstract boolean b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.api.IFontSizePanel
 * JD-Core Version:    0.7.0.1
 */