package com.tencent.mobileqq.cmshow.engine.render;

import android.view.View;
import com.tencent.mobileqq.apollo.touch.ICMTouchManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "", "getInitHeight", "", "getRenderHeight", "getRenderWidth", "getTouchManager", "Lcom/tencent/mobileqq/apollo/touch/ICMTouchManager;", "getView", "Landroid/view/View;", "pause", "", "resume", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ICMShowView
{
  public abstract int getInitHeight();
  
  public abstract int getRenderHeight();
  
  public abstract int getRenderWidth();
  
  @NotNull
  public abstract ICMTouchManager getTouchManager();
  
  @NotNull
  public abstract View getView();
  
  public abstract void pause();
  
  public abstract void resume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.render.ICMShowView
 * JD-Core Version:    0.7.0.1
 */