package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqmini.minigame.widget.CustomButton;
import com.tencent.qqmini.minigame.widget.CustomButton.ButtonParam;
import com.tencent.qqmini.minigame.widget.CustomButton.ButtonStyle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class CustomButtonManager
{
  private static final String TAG = "CustomButtonManager";
  private String mAppId;
  private Activity mContext;
  private Map<Long, CustomButton> mCustomButtonList = new HashMap();
  private ViewGroup mGameContainer;
  private float mScale;
  
  public CustomButtonManager(Activity paramActivity, ViewGroup paramViewGroup, String paramString, float paramFloat)
  {
    this.mGameContainer = paramViewGroup;
    this.mScale = paramFloat;
    this.mAppId = paramString;
    this.mContext = paramActivity;
  }
  
  private CustomButton.ButtonParam parseButtonParam(JSONObject paramJSONObject)
  {
    CustomButton.ButtonParam localButtonParam = new CustomButton.ButtonParam();
    localButtonParam.style = new CustomButton.ButtonStyle();
    localButtonParam.componentId = paramJSONObject.optLong("compId");
    localButtonParam.type = paramJSONObject.optString("type", "text");
    localButtonParam.text = paramJSONObject.optString("text", "获取用户信息");
    localButtonParam.image = paramJSONObject.optString("image");
    localButtonParam.withCredentials = paramJSONObject.optBoolean("withCredentials");
    localButtonParam.lang = paramJSONObject.optString("lang", "en");
    localButtonParam.openId = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optJSONObject("style");
    if (paramJSONObject != null)
    {
      localButtonParam.style.left = ((int)(paramJSONObject.optInt("left") * this.mScale));
      localButtonParam.style.top = ((int)(paramJSONObject.optInt("top") * this.mScale));
      localButtonParam.style.width = ((int)(paramJSONObject.optInt("width") * this.mScale));
      localButtonParam.style.height = ((int)(paramJSONObject.optInt("height") * this.mScale));
      localButtonParam.style.backgroundColor = paramJSONObject.optString("backgroundColor");
      localButtonParam.style.borderColor = paramJSONObject.optString("borderColor");
      localButtonParam.style.borderWidth = ((int)(paramJSONObject.optInt("borderWidth") * this.mScale));
      localButtonParam.style.borderRadius = ((int)(paramJSONObject.optInt("borderRadius") * this.mScale));
      localButtonParam.style.textAlign = paramJSONObject.optString("textAlign");
      localButtonParam.style.fontSize = paramJSONObject.optInt("fontSize");
      localButtonParam.style.color = paramJSONObject.optString("color", "#ffffff");
      localButtonParam.style.lineHeight = ((int)(paramJSONObject.optInt("lineHeight") * this.mScale));
    }
    return localButtonParam;
  }
  
  private void setButtonParam(CustomButton.ButtonParam paramButtonParam, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramButtonParam == null) {
      return;
    }
    this.mGameContainer.post(new CustomButtonManager.3(this, paramButtonParam, paramBoolean, paramOnClickListener));
  }
  
  public boolean createCustomButton(JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    setButtonParam(parseButtonParam(paramJSONObject), paramOnClickListener, false);
    return true;
  }
  
  public boolean destroyCustomButton(long paramLong)
  {
    if (this.mCustomButtonList.get(Long.valueOf(paramLong)) != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mGameContainer.post(new CustomButtonManager.2(this, paramLong));
      return bool;
    }
  }
  
  public boolean setCustomButtonVisible(long paramLong, boolean paramBoolean)
  {
    if (this.mCustomButtonList.get(Long.valueOf(paramLong)) != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mGameContainer.post(new CustomButtonManager.1(this, paramLong, paramBoolean));
      return bool;
    }
  }
  
  public boolean updateCustomButton(JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    paramJSONObject = parseButtonParam(paramJSONObject);
    if (this.mCustomButtonList.get(Long.valueOf(paramJSONObject.componentId)) == null) {
      return false;
    }
    setButtonParam(paramJSONObject, paramOnClickListener, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.CustomButtonManager
 * JD-Core Version:    0.7.0.1
 */