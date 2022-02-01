package com.tencent.viola.ui.dom;

import java.util.ArrayList;

public class DomObjectVInstance$AppearEventRectangle
{
  DomObject dom;
  public int end;
  public int start;
  DomObjectCell.ComponentState state = DomObjectCell.ComponentState.DIDDISAPPEAR;
  
  DomObjectVInstance$AppearEventRectangle(DomObject paramDomObject)
  {
    this.dom = paramDomObject;
    initEvent(paramDomObject);
  }
  
  private void initEvent(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    int i = 0;
    Object localObject = paramDomObject;
    DomObject localDomObject;
    do
    {
      if ((localObject instanceof DomObjectVInstance))
      {
        this.start = i;
        this.end = ((int)(this.start + paramDomObject.getLayoutHeight()));
        return;
      }
      i = (int)(i + ((DomObject)localObject).getLayoutY());
      localDomObject = ((DomObject)localObject).getDomParent();
      localObject = localDomObject;
    } while (localDomObject != null);
  }
  
  private void transformState(DomObjectCell.ComponentState paramComponentState)
  {
    this.state = paramComponentState;
  }
  
  public String getRef()
  {
    return this.dom.getRef();
  }
  
  public boolean hasEvent(String paramString)
  {
    return this.dom.getEvents().contains(paramString);
  }
  
  public boolean isDidAppearState()
  {
    return this.state == DomObjectCell.ComponentState.DIDAPPEAR;
  }
  
  public boolean isDidDisappearState()
  {
    return this.state == DomObjectCell.ComponentState.DIDDISAPPEAR;
  }
  
  public boolean isWillAppearState()
  {
    return this.state == DomObjectCell.ComponentState.WILLAPPEAR;
  }
  
  public void transformToDidAppearState()
  {
    transformState(DomObjectCell.ComponentState.DIDAPPEAR);
  }
  
  public void transformToDidDisappearState()
  {
    transformState(DomObjectCell.ComponentState.DIDDISAPPEAR);
  }
  
  public void transformToWillAppearState()
  {
    transformState(DomObjectCell.ComponentState.WILLAPPEAR);
  }
  
  public boolean wantDidAppear()
  {
    return hasEvent("didAppear");
  }
  
  public boolean wantDidDisAppear()
  {
    return hasEvent("didDisappear");
  }
  
  public boolean wantWillAppear()
  {
    return hasEvent("willAppear");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectVInstance.AppearEventRectangle
 * JD-Core Version:    0.7.0.1
 */