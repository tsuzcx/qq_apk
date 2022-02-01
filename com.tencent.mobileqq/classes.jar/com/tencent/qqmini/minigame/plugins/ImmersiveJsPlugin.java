package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONObject;

@JsPlugin
public class ImmersiveJsPlugin
  extends BaseJsPlugin
{
  public static final String API_SET_MEUN_STYLE = "setMenuStyle";
  public static final String API_SET_STATUS_BAR_STYLE = "setStatusBarStyle";
  private static final String STATUS_BAR_STYLE_BLACK = "black";
  private static final String STATUS_BAR_STYLE_WHITE = "white";
  private static final String STYLE_TAG = "style";
  private static final String TAG = "ImmersivePlugin";
  
  private static void setStatusBarTextColor(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = paramActivity.getWindow();
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.getDecorView().setSystemUiVisibility(1282);
      paramActivity.setStatusBarColor(0);
      paramActivity.setNavigationBarColor(0);
    }
    else if (Build.VERSION.SDK_INT >= 19)
    {
      WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
      localLayoutParams.flags = (0x4000000 | localLayoutParams.flags);
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean)) {
      paramActivity.getDecorView().setSystemUiVisibility(9218);
    }
  }
  
  public boolean onInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    if (!this.mIsMiniGame)
    {
      paramRequestEvent.fail();
      return true;
    }
    return super.onInterceptJsEvent(paramRequestEvent);
  }
  
  @JsEvent({"setMenuStyle"})
  public String setMenuStyle(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label15:
      StringBuilder localStringBuilder;
      break label15;
    }
    localObject = new JSONObject();
    if (this.mMiniAppContext.getAttachedActivity() == null) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "activity not exist").toString();
    }
    localObject = ((JSONObject)localObject).optString("style", null);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("light".equals(localObject)) || ("dark".equals(localObject))))
    {
      MiniAppEnv.g().setMenuStyle((String)localObject);
      return paramRequestEvent.ok();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid style ");
    localStringBuilder.append((String)localObject);
    return paramRequestEvent.fail(localStringBuilder.toString());
  }
  
  @JsEvent({"setStatusBarStyle"})
  public String setStatusBarStyle(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      label15:
      Object localObject2;
      break label15;
    }
    localObject1 = new JSONObject();
    localObject2 = this.mMiniAppContext.getAttachedActivity();
    if (localObject2 == null) {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "activity not exist").toString();
    }
    localObject1 = ((JSONObject)localObject1).optString("style", null);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (("white".equals(localObject1)) || ("black".equals(localObject1))))
    {
      ((Activity)localObject2).runOnUiThread(new ImmersiveJsPlugin.1(this, (Activity)localObject2, (String)localObject1));
      return paramRequestEvent.ok();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("invalid style ");
    ((StringBuilder)localObject2).append((String)localObject1);
    return paramRequestEvent.fail(((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.ImmersiveJsPlugin
 * JD-Core Version:    0.7.0.1
 */