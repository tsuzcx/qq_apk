package com.tencent.viola.ui.context;

import com.tencent.viola.ui.action.RenderAction;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import java.util.Map;

public abstract interface DOMActionContext
  extends ActionContext
{
  public abstract void addAnimationForElement(String paramString, Map<String, Object> paramMap);
  
  @Deprecated
  public abstract void addDomInfo(String paramString, VComponent paramVComponent);
  
  public abstract DomObject.Consumer getAddDOMConsumer();
  
  public abstract DomObject.Consumer getApplyStyleConsumer();
  
  public abstract DomObject getDomByRef(String paramString);
  
  public abstract String getInstanceId();
  
  public abstract DomObject.Consumer getRemoveElementConsumer();
  
  public abstract String getRootRef();
  
  public abstract boolean isDestory();
  
  public abstract void markDirty();
  
  public abstract void postRenderTask(RenderAction paramRenderAction);
  
  public abstract void registerDOMObject(String paramString, DomObject paramDomObject);
  
  public abstract void setRootRef(String paramString);
  
  public abstract DomObject unregisterDOMObject(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContext
 * JD-Core Version:    0.7.0.1
 */