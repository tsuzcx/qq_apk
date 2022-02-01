package com.tencent.qqmini.miniapp.action;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class NativeViewAction
  implements Action<Boolean>
{
  private static final int ADD_NATIVE_VIEW = 1;
  private static final int DEL_NATIVE_VIEW = 2;
  private static final String TAG = "NativeViewAction";
  private static final int UNKNOWN_ACTION = 0;
  private int action = 0;
  private ViewGroup.LayoutParams layoutParams;
  private IMiniAppContext miniAppContext;
  private View nativeView;
  
  public static NativeViewAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    NativeViewAction localNativeViewAction = new NativeViewAction();
    localNativeViewAction.miniAppContext = paramIMiniAppContext;
    return localNativeViewAction;
  }
  
  public boolean add(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.action = 1;
    this.nativeView = paramView;
    this.layoutParams = paramLayoutParams;
    return ((Boolean)this.miniAppContext.performAction(this)).booleanValue();
  }
  
  public boolean del(View paramView)
  {
    this.action = 2;
    this.nativeView = paramView;
    return ((Boolean)this.miniAppContext.performAction(this)).booleanValue();
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      QMLog.d("NativeViewAction", "Page is invalid");
      return null;
    }
    boolean bool = false;
    paramBaseRuntime = (AppBrandPageContainer)paramBaseRuntime;
    int i = this.action;
    if (i != 1)
    {
      if (i != 2) {
        QMLog.e("NativeViewAction", "Unknown action");
      } else {
        bool = paramBaseRuntime.removeNativeView(this.nativeView);
      }
    }
    else {
      bool = paramBaseRuntime.addNativeView(this.nativeView, this.layoutParams);
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.NativeViewAction
 * JD-Core Version:    0.7.0.1
 */