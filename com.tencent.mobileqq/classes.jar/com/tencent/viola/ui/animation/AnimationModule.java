package com.tencent.viola.ui.animation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.ui.action.MethodAnimation;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimationModule
  extends BaseModule
{
  public static final String MODULE_NAME = "animation";
  public static final String TAG = "AnimationModule";
  
  @JSMethod
  public void animate(@Nullable String paramString1, @NonNull JSONObject paramJSONObject1, @NonNull JSONObject paramJSONObject2, @Nullable String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramJSONObject1 != null) && (paramJSONObject2 != null) && (getViolaInstance() != null)) {}
    try
    {
      paramJSONObject2.put("styles", paramJSONObject1);
      if (paramJSONObject2 != null) {
        transition(paramString1, paramJSONObject2, paramString2);
      }
      return;
    }
    catch (JSONException paramString1)
    {
      ViolaLogUtils.e("AnimationModule", "animate JSONException e :" + paramString1.getMessage());
    }
  }
  
  @JSMethod
  public void transition(@Nullable String paramString1, @Nullable JSONObject paramJSONObject, @Nullable String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramJSONObject != null) && (getViolaInstance() != null))
    {
      paramString1 = new MethodAnimation(paramString1, paramJSONObject, paramString2);
      ViolaSDKManager.getInstance().getDomManager().postActionDelay(getViolaInstance().getInstanceId(), paramString1, false, 16L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.animation.AnimationModule
 * JD-Core Version:    0.7.0.1
 */