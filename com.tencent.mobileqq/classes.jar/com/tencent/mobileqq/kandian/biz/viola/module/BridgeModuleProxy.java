package com.tencent.mobileqq.kandian.biz.viola.module;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.kandian.biz.viola.api.IBridgeModule;
import com.tencent.mobileqq.kandian.biz.viola.api.InvokeCallJSCallback;
import com.tencent.viola.core.ViolaInstance;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/module/BridgeModuleProxy;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IBridgeModule;", "()V", "addFavorite", "", "jsonObject", "Lorg/json/JSONObject;", "c2sReport", "cancelUploadingVideo", "callbackId", "", "cancelVideoPreDownload", "dwellTimeMillisReport", "getDeviceInfo", "getFailInvokeObj", "errorMsg", "getMotiveAd", "callBack", "getSuccInvokeObj", "data", "", "getUploadVideoPermission", "callback", "getUploadingVideoInfo", "getUserInfo", "getViolaInstance", "Lcom/tencent/viola/core/ViolaInstance;", "handleClick", "hideTopicVideoComment", "invoke", "callBackId", "openAddVideoView", "openApp", "schema", "openLevelDialog", "openVideo", "pauseUploadingVideo", "performLikeAnimation", "popBack", "resetSatusBarBlackStyle", "resetSatusBarWhiteStyle", "resumeUploadingVideo", "sendRequest", "params", "setInvokeCallJSCallback", "Lcom/tencent/mobileqq/kandian/biz/viola/api/InvokeCallJSCallback;", "setNavBtnWithFragment", "fragment", "Landroidx/fragment/app/Fragment;", "setTitle", "shareVideoWithFriend", "showShareReadInJoyMenu", "currentFragment", "startImagePreDownload", "startVideoPreDownload", "updateIndepentTabState", "kandian-api_release"}, k=1, mv={1, 1, 16})
public class BridgeModuleProxy
  implements IBridgeModule
{
  public void addFavorite(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.addFavorite(paramJSONObject);
  }
  
  public void c2sReport(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.c2sReport(paramJSONObject);
  }
  
  public void cancelUploadingVideo(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.cancelUploadingVideo(paramJSONObject, paramString);
  }
  
  public void cancelVideoPreDownload()
  {
    this.$$delegate_0.cancelVideoPreDownload();
  }
  
  public void dwellTimeMillisReport(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.dwellTimeMillisReport(paramJSONObject);
  }
  
  @Nullable
  public JSONObject getDeviceInfo()
  {
    return this.$$delegate_0.getDeviceInfo();
  }
  
  @Nullable
  public JSONObject getFailInvokeObj(@Nullable String paramString)
  {
    return this.$$delegate_0.getFailInvokeObj(paramString);
  }
  
  public void getMotiveAd(@Nullable String paramString, @Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.getMotiveAd(paramString, paramJSONObject);
  }
  
  @Nullable
  public JSONObject getSuccInvokeObj(@Nullable Object paramObject)
  {
    return this.$$delegate_0.getSuccInvokeObj(paramObject);
  }
  
  public void getUploadVideoPermission(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.getUploadVideoPermission(paramJSONObject, paramString);
  }
  
  public void getUploadingVideoInfo(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.getUploadingVideoInfo(paramJSONObject, paramString);
  }
  
  @Nullable
  public JSONObject getUserInfo()
  {
    return this.$$delegate_0.getUserInfo();
  }
  
  @Nullable
  public ViolaInstance getViolaInstance()
  {
    return this.$$delegate_0.getViolaInstance();
  }
  
  public void handleClick(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.handleClick(paramJSONObject);
  }
  
  public void hideTopicVideoComment(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.hideTopicVideoComment(paramJSONObject);
  }
  
  public void invoke(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.invoke(paramJSONObject, paramString);
  }
  
  public void openAddVideoView(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.openAddVideoView(paramJSONObject, paramString);
  }
  
  public void openApp(@Nullable String paramString)
  {
    this.$$delegate_0.openApp(paramString);
  }
  
  public void openLevelDialog(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.openLevelDialog(paramJSONObject, paramString);
  }
  
  public void openVideo(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.openVideo(paramJSONObject);
  }
  
  public void pauseUploadingVideo(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.pauseUploadingVideo(paramJSONObject, paramString);
  }
  
  public void performLikeAnimation(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.performLikeAnimation(paramJSONObject);
  }
  
  public void popBack(@Nullable String paramString)
  {
    this.$$delegate_0.popBack(paramString);
  }
  
  public void resetSatusBarBlackStyle()
  {
    this.$$delegate_0.resetSatusBarBlackStyle();
  }
  
  public void resetSatusBarWhiteStyle()
  {
    this.$$delegate_0.resetSatusBarWhiteStyle();
  }
  
  public void resumeUploadingVideo(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.resumeUploadingVideo(paramJSONObject, paramString);
  }
  
  public void sendRequest(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.sendRequest(paramJSONObject, paramString);
  }
  
  public void setInvokeCallJSCallback(@Nullable InvokeCallJSCallback paramInvokeCallJSCallback)
  {
    this.$$delegate_0.setInvokeCallJSCallback(paramInvokeCallJSCallback);
  }
  
  public void setNavBtnWithFragment(@Nullable JSONObject paramJSONObject, @Nullable String paramString, @Nullable Fragment paramFragment)
  {
    this.$$delegate_0.setNavBtnWithFragment(paramJSONObject, paramString, paramFragment);
  }
  
  public void setTitle(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.setTitle(paramJSONObject, paramString);
  }
  
  public void shareVideoWithFriend(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.$$delegate_0.shareVideoWithFriend(paramJSONObject, paramString);
  }
  
  public void showShareReadInJoyMenu(@Nullable JSONObject paramJSONObject, @Nullable String paramString, @Nullable Fragment paramFragment)
  {
    this.$$delegate_0.showShareReadInJoyMenu(paramJSONObject, paramString, paramFragment);
  }
  
  public void startImagePreDownload(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.startImagePreDownload(paramJSONObject);
  }
  
  public void startVideoPreDownload(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.startVideoPreDownload(paramJSONObject);
  }
  
  public void updateIndepentTabState(@Nullable JSONObject paramJSONObject)
  {
    this.$$delegate_0.updateIndepentTabState(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.module.BridgeModuleProxy
 * JD-Core Version:    0.7.0.1
 */