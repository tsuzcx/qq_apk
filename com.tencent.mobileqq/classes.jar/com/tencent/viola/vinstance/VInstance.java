package com.tencent.viola.vinstance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VCell;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectVInstance;
import com.tencent.viola.ui.dom.DomObjectVInstance.AppearEventRectangle;
import com.tencent.viola.ui.view.VFrameLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class VInstance
  extends VCell
{
  private static final String TAG = "VInstance";
  
  public VInstance(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    lazy(true);
  }
  
  private void didAppearToDidDisAppearState(int paramInt1, int paramInt2, int paramInt3, DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (isSatisfyToDidDisAppear(paramInt1, paramInt2, paramInt3, paramAppearEventRectangle)) {
      didAppearToDidDisAppearState(paramAppearEventRectangle);
    }
  }
  
  private void didAppearToDidDisAppearState(DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (!paramAppearEventRectangle.isDidDisappearState())
    {
      paramAppearEventRectangle.transformToDidDisappearState();
      if (paramAppearEventRectangle.wantDidDisAppear()) {
        fireEvent("didDisappear");
      }
    }
  }
  
  private void didDisAppearToDidAppear(DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (!paramAppearEventRectangle.isDidAppearState())
    {
      paramAppearEventRectangle.transformToDidAppearState();
      if (paramAppearEventRectangle.wantWillAppear()) {
        fireEvent("willAppear");
      }
      if (paramAppearEventRectangle.wantDidAppear()) {
        fireEvent("didAppear");
      }
    }
  }
  
  private void didDisAppearToWillAppearState(DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (!paramAppearEventRectangle.isWillAppearState())
    {
      paramAppearEventRectangle.transformToWillAppearState();
      if (paramAppearEventRectangle.wantWillAppear()) {
        fireEvent("willAppear");
      }
    }
  }
  
  private void didDisAppearToWillOrAppear(int paramInt1, int paramInt2, int paramInt3, DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (isSatisfyToWillAppear(paramInt1, paramInt2, paramInt3, paramAppearEventRectangle))
    {
      didDisAppearToWillAppearState(paramAppearEventRectangle);
      return;
    }
    if (isSatisfyToDidAppear(paramInt1, paramInt2, paramInt3, paramAppearEventRectangle)) {
      didDisAppearToDidAppear(paramAppearEventRectangle);
    }
  }
  
  private void fireEvent(String paramString)
  {
    fireEvent(paramString, getFireEventArgs(paramString), new JSONObject());
  }
  
  private ArrayMap<String, DomObjectVInstance.AppearEventRectangle> getEventMap()
  {
    return ((DomObjectVInstance)this.mDomObj).getAppearEventRectangleMap();
  }
  
  private boolean isSatisfyToDidAppear(int paramInt1, int paramInt2, int paramInt3, DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    paramInt1 = paramInt2 - paramInt1;
    if (paramInt3 >= 0) {
      return (paramAppearEventRectangle.start + paramInt3 <= paramInt1) && (paramInt3 + paramAppearEventRectangle.end <= paramInt1);
    }
    return paramInt3 + paramAppearEventRectangle.start >= 0;
  }
  
  private boolean isSatisfyToDidDisAppear(int paramInt1, int paramInt2, int paramInt3, DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (paramInt3 >= 0) {
      return paramInt3 + paramAppearEventRectangle.start >= paramInt2 - paramInt1;
    }
    return paramInt3 + paramAppearEventRectangle.end <= 0;
  }
  
  private boolean isSatisfyToWillAppear(int paramInt1, int paramInt2, int paramInt3, DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    paramInt1 = paramInt2 - paramInt1;
    if (paramInt3 < 0) {
      return paramInt3 + paramAppearEventRectangle.end >= 0;
    }
    return (paramAppearEventRectangle.start + paramInt3 <= paramInt1) && (paramInt3 + paramAppearEventRectangle.end > paramInt1);
  }
  
  private void transformState(int paramInt1, int paramInt2, int paramInt3, DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (paramAppearEventRectangle == null) {
      return;
    }
    if (paramAppearEventRectangle.isDidDisappearState())
    {
      didDisAppearToWillOrAppear(paramInt2, paramInt3, paramInt1, paramAppearEventRectangle);
      return;
    }
    if (paramAppearEventRectangle.isWillAppearState())
    {
      willAppearToDidAppearOrDidDisAppear(paramInt2, paramInt3, paramInt1, paramAppearEventRectangle);
      return;
    }
    if (paramAppearEventRectangle.isDidAppearState()) {
      didAppearToDidDisAppearState(paramInt2, paramInt3, paramInt1, paramAppearEventRectangle);
    }
  }
  
  private void willAppearToDidAppearOrDidDisAppear(int paramInt1, int paramInt2, int paramInt3, DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (isSatisfyToDidAppear(paramInt1, paramInt2, paramInt3, paramAppearEventRectangle))
    {
      willAppearToDidAppearState(paramAppearEventRectangle);
      return;
    }
    if (isSatisfyToDidDisAppear(paramInt1, paramInt2, paramInt3, paramAppearEventRectangle)) {
      willAppearToDidDisAppearState(paramAppearEventRectangle);
    }
  }
  
  private void willAppearToDidAppearState(DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (!paramAppearEventRectangle.isDidAppearState())
    {
      paramAppearEventRectangle.transformToDidAppearState();
      if (paramAppearEventRectangle.wantDidAppear()) {
        fireEvent("disappear");
      }
    }
  }
  
  private void willAppearToDidDisAppearState(DomObjectVInstance.AppearEventRectangle paramAppearEventRectangle)
  {
    if (!paramAppearEventRectangle.isDidDisappearState())
    {
      paramAppearEventRectangle.transformToDidDisappearState();
      if (paramAppearEventRectangle.wantDidDisAppear()) {
        fireEvent("didDisappear");
      }
    }
  }
  
  public void didDisAppear()
  {
    Object localObject = getEventMap();
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext()) {
      didAppearToDidDisAppearState((DomObjectVInstance.AppearEventRectangle)((Iterator)localObject).next());
    }
  }
  
  public String getId()
  {
    if (this.mDomObj == null) {
      return null;
    }
    return ((DomObjectVInstance)this.mDomObj).getId();
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VInstanceView(paramContext);
    paramContext.bindComponent(this);
    return paramContext;
  }
  
  public void tryFireAppearEventSet(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = getEventMap();
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      DomObjectVInstance.AppearEventRectangle localAppearEventRectangle = (DomObjectVInstance.AppearEventRectangle)((Iterator)localObject).next();
      transformState(paramInt1, 0, paramView.getHeight(), localAppearEventRectangle);
    }
  }
  
  public void willAppear(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = getEventMap();
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext()) {
      didDisAppearToWillOrAppear(paramInt2, paramInt3, paramInt1, (DomObjectVInstance.AppearEventRectangle)((Iterator)localObject).next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstance
 * JD-Core Version:    0.7.0.1
 */