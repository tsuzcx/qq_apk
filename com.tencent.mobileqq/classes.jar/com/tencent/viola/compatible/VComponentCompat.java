package com.tencent.viola.compatible;

import android.view.View;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import java.util.Set;
import org.json.JSONObject;

public class VComponentCompat<C extends VComponent, D extends DomObject>
{
  protected C component;
  protected D dom;
  
  public VComponentCompat(C paramC, D paramD)
  {
    this.component = paramC;
    this.dom = paramD;
  }
  
  public void fireEvent(String paramString, JSONObject paramJSONObject)
  {
    this.component.fireEvent(paramString, paramJSONObject);
  }
  
  public C getComponent()
  {
    return this.component;
  }
  
  public D getDom()
  {
    return this.dom;
  }
  
  protected <T extends View> T getHostView()
  {
    return this.component.getHostView();
  }
  
  protected String getInstanceId()
  {
    VComponent localVComponent = this.component;
    if ((localVComponent != null) && (localVComponent.getInstance() != null)) {
      return this.component.getInstance().getInstanceId();
    }
    return null;
  }
  
  protected boolean isContainEvent(String paramString)
  {
    return this.component.mAppendEvents.contains(paramString);
  }
  
  protected float px2dp(float paramFloat)
  {
    return FlexConvertUtils.px2dip(paramFloat);
  }
  
  protected int px2dp(int paramInt)
  {
    return (int)FlexConvertUtils.px2dip(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.compatible.VComponentCompat
 * JD-Core Version:    0.7.0.1
 */