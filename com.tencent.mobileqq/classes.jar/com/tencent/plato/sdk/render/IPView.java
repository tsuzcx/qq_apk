package com.tencent.plato.sdk.render;

import android.animation.Animator;
import android.view.View;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.sdk.render.data.ElementItem;
import java.util.List;
import java.util.Map;

public abstract interface IPView
{
  public abstract void addAnimator(String paramString, Animator paramAnimator);
  
  public abstract void addChild(IPView paramIPView, int paramInt);
  
  public abstract void attachEvent(List<String> paramList);
  
  public abstract void attachTransform(Map<String, Object> paramMap);
  
  public abstract void draw(int paramInt1, int paramInt2);
  
  public abstract List<Animator> getAnimator(String paramString);
  
  public abstract IPView getChild(int paramInt);
  
  public abstract int getChildCount();
  
  public abstract int getHeight();
  
  public abstract int getId();
  
  public abstract int getPageId();
  
  public abstract IPView getParent();
  
  public abstract View getView();
  
  public abstract int getWidth();
  
  public abstract void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem);
  
  public abstract void removeAnimator(String paramString);
  
  public abstract void removeChild(IPView paramIPView);
  
  public abstract IPView removeChildAt(int paramInt);
  
  public abstract void setPageId(int paramInt);
  
  public abstract void setStyles(IReadableMap paramIReadableMap);
  
  public abstract void setTopView(IPView paramIPView);
  
  public abstract void updateRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.render.IPView
 * JD-Core Version:    0.7.0.1
 */