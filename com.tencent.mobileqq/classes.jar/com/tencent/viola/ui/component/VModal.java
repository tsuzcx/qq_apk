package com.tencent.viola.ui.component;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VModalView;
import com.tencent.viola.utils.ViolaLogUtils;

public class VModal
  extends VComponentContainer<VModalView>
{
  private boolean mHasAddView = false;
  private WindowManager mWindowManager = (WindowManager)getContext().getSystemService("window");
  
  public VModal(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void destroy()
  {
    if ((this.mWindowManager != null) && (getHostView() != null) && (this.mHasAddView)) {}
    try
    {
      this.mWindowManager.removeView(getHostView());
      this.mHasAddView = false;
      super.destroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("VModal", localException.getMessage());
      }
    }
  }
  
  @JSMethod(uiThread=true)
  public void hide()
  {
    if (getHostView() != null) {
      ((VModalView)getHostView()).setVisibility(8);
    }
    try
    {
      this.mWindowManager.removeView(getHostView());
      this.mHasAddView = false;
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VModal", "hide,exception:" + localException.getMessage());
    }
  }
  
  public VModalView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VModalView(paramContext);
    paramContext.bindComponent(this);
    paramContext.setVisibility(8);
    return paramContext;
  }
  
  @VComponentProp(name="defaultShow")
  public void setDefaultShow(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      show();
    }
  }
  
  @JSMethod(uiThread=true)
  public void show()
  {
    try
    {
      if ((getHostView() != null) && (((VModalView)getHostView()).getVisibility() != 0))
      {
        if ((((VModalView)getHostView()).getParent() instanceof View)) {
          ((ViewGroup)((VModalView)getHostView()).getParent()).removeView(getHostView());
        }
        if ((((VModalView)getHostView()).getParent() == null) && (this.mWindowManager != null))
        {
          WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
          localLayoutParams.width = -1;
          localLayoutParams.height = -1;
          localLayoutParams.format = -2;
          if (Build.VERSION.SDK_INT > 27) {}
          for (localLayoutParams.flags = 65544;; localLayoutParams.flags = -2147483640)
          {
            this.mWindowManager.addView(getHostView(), localLayoutParams);
            this.mHasAddView = true;
            ((VModalView)getHostView()).setVisibility(0);
            return;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VModal", "show,exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VModal
 * JD-Core Version:    0.7.0.1
 */