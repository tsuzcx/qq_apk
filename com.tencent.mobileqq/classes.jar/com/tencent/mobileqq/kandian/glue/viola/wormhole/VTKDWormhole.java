package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.wormhole.WormholeManager;
import com.tencent.common.wormhole.views.HippyWormholeView;
import com.tencent.common.wormhole.views.ITKDWormhole;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaInstance.ViolaPageListener;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.component.VDiv;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VFrameLayout;
import org.json.JSONObject;

public class VTKDWormhole
  extends VDiv
  implements ITKDWormhole
{
  public static final String TAG = "VTKDWormhole";
  private VFrameLayout mFrameLayout;
  
  public VTKDWormhole(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void destroy()
  {
    super.destroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" VTKDWormhole destroy: ");
      localStringBuilder.append(getWormholeId());
      QLog.d("VTKDWormhole", 2, localStringBuilder.toString());
    }
    WormholeManager.a().a(Integer.valueOf(getRef()).intValue());
  }
  
  public int getRootId()
  {
    return ((DomObjectTKDWormhole)getDomObject()).b();
  }
  
  public View getView()
  {
    if (getHostView() != null) {
      return getHostView();
    }
    return this.mFrameLayout;
  }
  
  public String getWormholeId()
  {
    return ((DomObjectTKDWormhole)getDomObject()).a();
  }
  
  protected VFrameLayout initComponentHostView(@NonNull Context paramContext)
  {
    this.mFrameLayout = new VFrameLayout(paramContext);
    this.mFrameLayout.bindComponent(this);
    WormholeManager.a().a(this, getWormholeId());
    if (getInstance() != null) {
      getInstance().getViolaPageListener().onWormholeCreated(this.mFrameLayout);
    }
    return this.mFrameLayout;
  }
  
  public boolean isReuse()
  {
    return false;
  }
  
  public void onActivityDestroy()
  {
    super.destroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VTKDWormhole onActivityDestroy:");
      localStringBuilder.append(getWormholeId());
      QLog.d("VTKDWormhole", 2, localStringBuilder.toString());
    }
    WormholeManager.a().a(Integer.valueOf(getRef()).intValue());
    WormholeManager.a().b(getRootId());
  }
  
  public void removedByDiff()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VTKDWormhole removedByDiff: ");
      localStringBuilder.append(getWormholeId());
      QLog.d("VTKDWormhole", 2, localStringBuilder.toString());
    }
  }
  
  public void removedByJs()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VTKDWormhole removedByJs: ");
      localStringBuilder.append(getWormholeId());
      QLog.d("VTKDWormhole", 2, localStringBuilder.toString());
    }
    WormholeManager.a().a(Integer.valueOf(getRef()).intValue());
  }
  
  @JSMethod
  public void sendEventToWormholeView(JSONObject paramJSONObject)
  {
    if ((getHostView() != null) && (((VFrameLayout)getHostView()).getChildCount() > 0))
    {
      View localView = ((VFrameLayout)getHostView()).getChildAt(0);
      if ((localView != null) && ((localView instanceof HippyWormholeView))) {
        new HippyViewEvent("onCustomEvent").send(localView, paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.VTKDWormhole
 * JD-Core Version:    0.7.0.1
 */