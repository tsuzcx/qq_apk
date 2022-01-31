package com.tencent.mobileqq.triton.views;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@TTNativeModule(name="GameUserInfoBtnManager")
public class GameUserInfoBtnManager
  implements IUserInfoBtnManager
{
  protected static final String NAME = "GameUserInfoBtnManager";
  private static final String TAG = "GameUserInfoBtnManager";
  private Activity mContext;
  private ViewGroup mParent;
  private float mScale;
  private TTEngine mTritonEngine;
  private WeakReference<GameUserInfoBtnManager> mUserInfoBtnManagerRef;
  private Map<Long, UserInfoButton> mUserInfoButtonList = new HashMap();
  
  public GameUserInfoBtnManager(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private void createUserInfoButton(UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam)
  {
    this.mParent.post(new GameUserInfoBtnManager.1(this, paramUserInfoButtonParam));
  }
  
  public void createUserInfoButton(long paramLong, String paramString)
  {
    UserInfoButton.UserInfoButtonParam localUserInfoButtonParam = new UserInfoButton.UserInfoButtonParam();
    localUserInfoButtonParam.style = new UserInfoButton.UserInfoButtonType();
    try
    {
      paramString = new JSONObject(paramString);
      localUserInfoButtonParam.buttonType = paramString.optInt("buttonType", 1);
      localUserInfoButtonParam.type = paramString.optString("type", "text");
      localUserInfoButtonParam.text = paramString.optString("text", "获取用户信息");
      localUserInfoButtonParam.image = paramString.optString("image");
      localUserInfoButtonParam.withCredentials = paramString.optBoolean("withCredentials");
      localUserInfoButtonParam.lang = paramString.optString("lang", "en");
      localUserInfoButtonParam.address = paramLong;
      localUserInfoButtonParam.openId = paramString.optString("openid");
      paramString = paramString.optJSONObject("style");
      if (paramString != null)
      {
        localUserInfoButtonParam.style.left = ((int)(paramString.optInt("left") * this.mScale));
        localUserInfoButtonParam.style.top = ((int)(paramString.optInt("top") * this.mScale));
        localUserInfoButtonParam.style.width = ((int)(paramString.optInt("width") * this.mScale));
        localUserInfoButtonParam.style.height = ((int)(paramString.optInt("height") * this.mScale));
        localUserInfoButtonParam.style.backgroundColor = paramString.optString("backgroundColor");
        localUserInfoButtonParam.style.borderColor = paramString.optString("borderColor");
        localUserInfoButtonParam.style.borderWidth = paramString.optInt("borderWidth");
        localUserInfoButtonParam.style.borderRadius = paramString.optInt("borderRadius");
        localUserInfoButtonParam.style.textAlign = paramString.optString("textAlign");
        localUserInfoButtonParam.style.fontSize = paramString.optInt("fontSize");
        localUserInfoButtonParam.style.color = paramString.optString("color", "#ffffff");
        localUserInfoButtonParam.style.lineHeight = ((int)(paramString.optInt("lineHeight") * this.mScale));
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        TTLog.e("GameUserInfoBtnManager", "createUserInfoButton error " + paramString.getMessage());
      }
    }
    createUserInfoButton(localUserInfoButtonParam);
  }
  
  public void destroyUserInfoButton(long paramLong)
  {
    this.mParent.post(new GameUserInfoBtnManager.3(this, paramLong));
  }
  
  public void init(Activity paramActivity, ViewGroup paramViewGroup, float paramFloat)
  {
    this.mParent = paramViewGroup;
    this.mScale = paramFloat;
    this.mContext = paramActivity;
    this.mUserInfoBtnManagerRef = new WeakReference(this);
  }
  
  @TTNativeCall
  public void nativeCreateUserInfoButton(long paramLong, String paramString)
  {
    if ((this.mUserInfoBtnManagerRef == null) || (this.mUserInfoBtnManagerRef.get() == null)) {
      return;
    }
    ((GameUserInfoBtnManager)this.mUserInfoBtnManagerRef.get()).createUserInfoButton(paramLong, paramString);
  }
  
  @TTNativeCall
  public void nativeDestroyUserInfoButton(long paramLong)
  {
    if ((this.mUserInfoBtnManagerRef == null) || (this.mUserInfoBtnManagerRef.get() == null)) {
      return;
    }
    ((GameUserInfoBtnManager)this.mUserInfoBtnManagerRef.get()).destroyUserInfoButton(paramLong);
  }
  
  @TTNativeCall
  public void nativeSetUserInfoButtonVisible(long paramLong, boolean paramBoolean)
  {
    if ((this.mUserInfoBtnManagerRef == null) || (this.mUserInfoBtnManagerRef.get() == null)) {
      return;
    }
    ((GameUserInfoBtnManager)this.mUserInfoBtnManagerRef.get()).setUserInfoButtonVisible(paramLong, paramBoolean);
  }
  
  public void setUserInfoButtonVisible(long paramLong, boolean paramBoolean)
  {
    this.mParent.post(new GameUserInfoBtnManager.2(this, paramLong, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.views.GameUserInfoBtnManager
 * JD-Core Version:    0.7.0.1
 */