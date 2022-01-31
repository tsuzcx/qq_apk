package com.tencent.plato.sdk.dom;

import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.IPlatoSurface;
import com.tencent.plato.IPlatoSurface.ISurfaceRender;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.sdk.animation.PKeyFrame;
import java.util.Map;
import org.json.JSONObject;

public abstract interface IDom
  extends IPlatoSurface.ISurfaceRender
{
  public abstract void addElement(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap, int paramInt1, int paramInt2);
  
  public abstract void addElementById(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void addEvent(int paramInt, String paramString);
  
  public abstract void addKeyFrame(IReadableMap paramIReadableMap);
  
  public abstract void addKeyFrame(String paramString);
  
  public abstract void bindSurface(IPlatoSurface paramIPlatoSurface);
  
  public abstract void createBody(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap);
  
  public abstract void createElement(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap);
  
  public abstract void destroy();
  
  public abstract JSONObject dumpNodeInfo();
  
  public abstract Map<String, PKeyFrame> getKeyFrames();
  
  public abstract void moveElement(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void pause(int paramInt, String paramString);
  
  public abstract void play(int paramInt, String paramString1, String paramString2);
  
  public abstract void removeAttr(int paramInt, String paramString);
  
  public abstract void removeElement(int paramInt);
  
  public abstract void removeEvent(int paramInt, String paramString);
  
  public abstract void resume(int paramInt, String paramString);
  
  public abstract void scrollTo(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void setAttr(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap);
  
  public abstract void setStyles(IPlatoRuntime paramIPlatoRuntime, int paramInt, IReadableMap paramIReadableMap);
  
  public abstract void stop(int paramInt, String paramString);
  
  public abstract void updateFinish();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.dom.IDom
 * JD-Core Version:    0.7.0.1
 */