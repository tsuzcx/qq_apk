package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationTroopHw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import java.util.HashMap;

public class TroopHWApiImpl
  implements ITroopHWApi
{
  public int getBknBySkey(String paramString)
  {
    return TroopUtils.a(paramString);
  }
  
  public String getFileSuffix(String paramString)
  {
    return HWTroopUtils.a(paramString);
  }
  
  public Intent getSelectMediaIntent(int paramInt, Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 47);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationTroopHw.a);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", paramInt);
    localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", true);
    return localIntent;
  }
  
  public HashMap<Integer, String[]> getTroopListUin(AppInterface paramAppInterface, int paramInt)
  {
    return ((QQAppInterface)paramAppInterface).getTroopListUin(paramInt);
  }
  
  public void goSelectMedia(Activity paramActivity, Object paramObject1, Object paramObject2, Intent paramIntent, byte paramByte)
  {
    if ((paramActivity instanceof AbsBaseWebViewActivity))
    {
      ((AbsBaseWebViewActivity)paramActivity).gotoSelectPicture((WebViewPlugin)paramObject2, paramIntent, paramByte);
      return;
    }
    if (paramObject1 != null) {
      WebViewUtil.a((WebViewPlugin)paramObject2, paramIntent, paramByte, (WebViewProvider)paramObject1);
    }
  }
  
  public void gotoSelectPicture(Activity paramActivity, Object paramObject1, Object paramObject2, int paramInt, byte paramByte)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/album/photolist");
    localActivityURIRequest.extra().putInt("enter_from", 47);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationTroopHw.a);
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", true);
    if (paramInt == 1) {
      localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    }
    if ((paramActivity instanceof AbsBaseWebViewActivity))
    {
      ((AbsBaseWebViewActivity)paramActivity).gotoSelectPicture((WebViewPlugin)paramObject2, localActivityURIRequest, paramByte);
      return;
    }
    if (paramObject1 != null) {
      WebViewUtil.a((WebViewPlugin)paramObject2, localActivityURIRequest, paramByte, (WebViewProvider)paramObject1);
    }
  }
  
  public boolean isAbsBaseWebViewActivity(Activity paramActivity)
  {
    return paramActivity instanceof AbsBaseWebViewActivity;
  }
  
  public void showOnePicture(Activity paramActivity, String paramString)
  {
    TroopNoticeJsHandler.a(paramActivity, paramString);
  }
  
  public void start_BulkSendMessageFragment(Activity paramActivity, Bundle paramBundle)
  {
    BulkSendMessageFragment.a(paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopHWApiImpl
 * JD-Core Version:    0.7.0.1
 */