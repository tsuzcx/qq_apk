package com.tencent.mobileqq.kandian.biz.viola.api;

import androidx.fragment.app.Fragment;
import com.tencent.viola.core.ViolaInstance;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IBridgeModule;", "", "addFavorite", "", "jsonObject", "Lorg/json/JSONObject;", "c2sReport", "cancelUploadingVideo", "callbackId", "", "cancelVideoPreDownload", "dwellTimeMillisReport", "getDeviceInfo", "getFailInvokeObj", "errorMsg", "getMotiveAd", "callBack", "getSuccInvokeObj", "data", "getUploadVideoPermission", "callback", "getUploadingVideoInfo", "getUserInfo", "getViolaInstance", "Lcom/tencent/viola/core/ViolaInstance;", "handleClick", "hideTopicVideoComment", "invoke", "callBackId", "openAddVideoView", "openApp", "schema", "openLevelDialog", "openVideo", "pauseUploadingVideo", "performLikeAnimation", "popBack", "resetSatusBarBlackStyle", "resetSatusBarWhiteStyle", "resumeUploadingVideo", "sendRequest", "params", "setInvokeCallJSCallback", "Lcom/tencent/mobileqq/kandian/biz/viola/api/InvokeCallJSCallback;", "setNavBtnWithFragment", "fragment", "Landroidx/fragment/app/Fragment;", "setTitle", "shareVideoWithFriend", "showShareReadInJoyMenu", "currentFragment", "startImagePreDownload", "startVideoPreDownload", "updateIndepentTabState", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IBridgeModule
{
  public abstract void addFavorite(@Nullable JSONObject paramJSONObject);
  
  public abstract void c2sReport(@Nullable JSONObject paramJSONObject);
  
  public abstract void cancelUploadingVideo(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void cancelVideoPreDownload();
  
  public abstract void dwellTimeMillisReport(@Nullable JSONObject paramJSONObject);
  
  @Nullable
  public abstract JSONObject getDeviceInfo();
  
  @Nullable
  public abstract JSONObject getFailInvokeObj(@Nullable String paramString);
  
  public abstract void getMotiveAd(@Nullable String paramString, @Nullable JSONObject paramJSONObject);
  
  @Nullable
  public abstract JSONObject getSuccInvokeObj(@Nullable Object paramObject);
  
  public abstract void getUploadVideoPermission(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void getUploadingVideoInfo(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  @Nullable
  public abstract JSONObject getUserInfo();
  
  @Nullable
  public abstract ViolaInstance getViolaInstance();
  
  public abstract void handleClick(@Nullable JSONObject paramJSONObject);
  
  public abstract void hideTopicVideoComment(@Nullable JSONObject paramJSONObject);
  
  public abstract void invoke(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void openAddVideoView(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void openApp(@Nullable String paramString);
  
  public abstract void openLevelDialog(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void openVideo(@Nullable JSONObject paramJSONObject);
  
  public abstract void pauseUploadingVideo(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void performLikeAnimation(@Nullable JSONObject paramJSONObject);
  
  public abstract void popBack(@Nullable String paramString);
  
  public abstract void resetSatusBarBlackStyle();
  
  public abstract void resetSatusBarWhiteStyle();
  
  public abstract void resumeUploadingVideo(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void sendRequest(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void setInvokeCallJSCallback(@Nullable InvokeCallJSCallback paramInvokeCallJSCallback);
  
  public abstract void setNavBtnWithFragment(@Nullable JSONObject paramJSONObject, @Nullable String paramString, @Nullable Fragment paramFragment);
  
  public abstract void setTitle(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void shareVideoWithFriend(@Nullable JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract void showShareReadInJoyMenu(@Nullable JSONObject paramJSONObject, @Nullable String paramString, @Nullable Fragment paramFragment);
  
  public abstract void startImagePreDownload(@Nullable JSONObject paramJSONObject);
  
  public abstract void startVideoPreDownload(@Nullable JSONObject paramJSONObject);
  
  public abstract void updateIndepentTabState(@Nullable JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IBridgeModule
 * JD-Core Version:    0.7.0.1
 */