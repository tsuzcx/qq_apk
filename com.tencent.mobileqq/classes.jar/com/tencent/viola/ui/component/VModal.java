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
import com.tencent.viola.ui.dom.Attr;
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
  private boolean mIsAutoLayout = false;
  private boolean mIsSus = false;
  private Window mWindow = null;
  private WindowManager mWindowManager;
  
  public VModal(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void destroy()
  {
    if ((this.mWindow != null) && (getHostView() != null) && (this.mHasAddView)) {
      try
      {
        if (this.mIsSus) {
          this.mWindowManager.removeView(getHostView());
        } else {
          ((ViewGroup)((VModalView)getHostView()).getParent()).removeView(getHostView());
        }
        this.mHasAddView = false;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VModal", localException.getMessage());
      }
    }
    super.destroy();
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
        } else {
          ((ViewGroup)((VModalView)getHostView()).getParent()).removeView(getHostView());
        }
        this.mHasAddView = false;
        if ((getInstance() != null) && (this.mAppendEvents.contains("hide")))
        {
          JSONArray localJSONArray = new JSONArray();
          if (!TextUtils.isEmpty(getRef())) {
            localJSONArray.put(getRef());
          }
          localJSONArray.put("hide");
          ViolaBridgeManager.getInstance().callbackJavascript(getInstance().getInstanceId(), "dom", "fireEvent", localJSONArray, new JSONObject(), true);
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hide,exception:");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e("VModal", localStringBuilder.toString());
      }
    }
  }
  
  public VModalView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VModalView(paramContext);
    paramContext.bindComponent(this);
    paramContext.setVisibility(8);
    if ((getDomObject() != null) && (getDomObject().getAttributes() != null) && (getDomObject().getAttributes().containsKey("autoLayout"))) {
      this.mIsAutoLayout = ((Boolean)getDomObject().getAttributes().get("autoLayout")).booleanValue();
    }
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
      if ((getHostView() != null) && (((VModalView)getHostView()).getVisibility() != 0) && (getInstance() != null) && (getInstance().getActivity() != null) && (getInstance().getActivity().getWindow() != null))
      {
        if ((((VModalView)getHostView()).getParent() instanceof View)) {
          ((ViewGroup)((VModalView)getHostView()).getParent()).removeView(getHostView());
        }
        this.mWindow = getInstance().getActivity().getWindow();
        if (((VModalView)getHostView()).getParent() == null)
        {
          if ((getInstance().getUrl().contains("v_present=2")) || (getInstance().getUrl().contains("v_present=1")) || (getInstance().getUrl().contains("v_old_modal=1")) || (this.mIsAutoLayout)) {
            this.mIsSus = true;
          }
          Object localObject;
          if (this.mIsSus)
          {
            localObject = new WindowManager.LayoutParams();
            ((WindowManager.LayoutParams)localObject).width = -1;
            ((WindowManager.LayoutParams)localObject).height = -1;
            ((WindowManager.LayoutParams)localObject).format = -2;
            if (Build.VERSION.SDK_INT > 27) {
              ((WindowManager.LayoutParams)localObject).flags = 65544;
            } else {
              ((WindowManager.LayoutParams)localObject).flags = -2147483640;
            }
            this.mWindowManager = this.mWindow.getWindowManager();
            this.mWindowManager.addView(getHostView(), (ViewGroup.LayoutParams)localObject);
          }
          else
          {
            localObject = new ViewGroup.LayoutParams(-1, -1);
            this.mWindow.addContentView(getHostView(), (ViewGroup.LayoutParams)localObject);
          }
          this.mHasAddView = true;
          ((VModalView)getHostView()).setVisibility(0);
          if ((getInstance() != null) && (this.mAppendEvents.contains("show")))
          {
            localObject = new JSONArray();
            if (!TextUtils.isEmpty(getRef())) {
              ((JSONArray)localObject).put(getRef());
            }
            ((JSONArray)localObject).put("show");
            ViolaBridgeManager.getInstance().callbackJavascript(getInstance().getInstanceId(), "dom", "fireEvent", localObject, new JSONObject(), true);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show,exception:");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e("VModal", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VModal
 * JD-Core Version:    0.7.0.1
 */