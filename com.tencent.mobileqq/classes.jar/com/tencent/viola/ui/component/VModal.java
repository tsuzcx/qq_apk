package com.tencent.viola.ui.component;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VModalView;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VModal
  extends VComponentContainer<VModalView>
{
  private boolean mHasAddView = false;
  private boolean mIsSus = false;
  private Window mWindow = null;
  private WindowManager mWindowManager;
  
  public VModal(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void destroy()
  {
    if ((this.mWindow != null) && (getHostView() != null) && (this.mHasAddView)) {}
    for (;;)
    {
      try
      {
        if (!this.mIsSus) {
          continue;
        }
        this.mWindowManager.removeView(getHostView());
        this.mHasAddView = false;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VModal", localException.getMessage());
        continue;
      }
      super.destroy();
      return;
      ((ViewGroup)((VModalView)getHostView()).getParent()).removeView(getHostView());
    }
  }
  
  @JSMethod(uiThread=true)
  public void hide()
  {
    if (getHostView() != null)
    {
      ((VModalView)getHostView()).setVisibility(8);
      try
      {
        if (this.mIsSus) {
          this.mWindowManager.removeView(getHostView());
        }
        for (;;)
        {
          this.mHasAddView = false;
          if ((getInstance() == null) || (!this.mAppendEvents.contains("hide"))) {
            break;
          }
          JSONArray localJSONArray = new JSONArray();
          if (!TextUtils.isEmpty(getRef())) {
            localJSONArray.put(getRef());
          }
          localJSONArray.put("hide");
          ViolaBridgeManager.getInstance().callbackJavascript(getInstance().getInstanceId(), "dom", "fireEvent", localJSONArray, new JSONObject(), true);
          return;
          ((ViewGroup)((VModalView)getHostView()).getParent()).removeView(getHostView());
        }
        return;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VModal", "hide,exception:" + localException.getMessage());
      }
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
    for (;;)
    {
      try
      {
        if ((getHostView() == null) || (((VModalView)getHostView()).getVisibility() == 0) || (getInstance() == null) || (getInstance().getActivity() == null) || (getInstance().getActivity().getWindow() == null)) {
          break;
        }
        if ((((VModalView)getHostView()).getParent() instanceof View)) {
          ((ViewGroup)((VModalView)getHostView()).getParent()).removeView(getHostView());
        }
        this.mWindow = getInstance().getActivity().getWindow();
        if (((VModalView)getHostView()).getParent() != null) {
          break;
        }
        if ((getInstance().getUrl().contains("v_present=2")) || (getInstance().getUrl().contains("v_present=1")) || (getInstance().getUrl().contains("v_old_modal=1"))) {
          this.mIsSus = true;
        }
        if (this.mIsSus)
        {
          Object localObject = new WindowManager.LayoutParams();
          ((WindowManager.LayoutParams)localObject).width = -1;
          ((WindowManager.LayoutParams)localObject).height = -1;
          ((WindowManager.LayoutParams)localObject).format = -2;
          if (Build.VERSION.SDK_INT > 27)
          {
            ((WindowManager.LayoutParams)localObject).flags = 65544;
            this.mWindowManager = this.mWindow.getWindowManager();
            this.mWindowManager.addView(getHostView(), (ViewGroup.LayoutParams)localObject);
            this.mHasAddView = true;
            ((VModalView)getHostView()).setVisibility(0);
            if ((getInstance() == null) || (!this.mAppendEvents.contains("show"))) {
              break;
            }
            localObject = new JSONArray();
            if (!TextUtils.isEmpty(getRef())) {
              ((JSONArray)localObject).put(getRef());
            }
            ((JSONArray)localObject).put("show");
            ViolaBridgeManager.getInstance().callbackJavascript(getInstance().getInstanceId(), "dom", "fireEvent", localObject, new JSONObject(), true);
            return;
          }
          ((WindowManager.LayoutParams)localObject).flags = -2147483640;
          continue;
        }
        localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VModal", "show,exception:" + localException.getMessage());
        return;
      }
      ViewGroup.LayoutParams localLayoutParams;
      this.mWindow.addContentView(getHostView(), localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VModal
 * JD-Core Version:    0.7.0.1
 */