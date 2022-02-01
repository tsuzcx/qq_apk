package com.tencent.mobileqq.sharehelper.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.sharehelper.ArkShareInfo;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharehelper.IShareActionInterface;
import com.tencent.mobileqq.sharehelper.IShareBusinessInterface;
import com.tencent.mobileqq.sharehelper.ImageShareInfo;
import com.tencent.mobileqq.sharehelper.QzoneLinkShareInfo;
import com.tencent.mobileqq.sharehelper.ShareActionSheetInjectUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class ShareActionHelperImpl
  implements IShareActionHelper
{
  public static final String HTTP_METHOD_GET = "GET";
  public static final int MAX_BITMAP_ICON_SIZE = 8000;
  public static final String TAG = "ShareActionHelperImpl";
  public static final String WRAP_IMAGE_KEY = "image";
  private static IShareActionInterface sShareActionInjectInterface;
  
  static
  {
    try
    {
      if (ShareActionSheetInjectUtil.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        sShareActionInjectInterface = (IShareActionInterface)((Class)ShareActionSheetInjectUtil.jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
        QLog.d("ShareActionHelperImpl", 1, "ShareActionSheetInjectUtil newInstance");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ShareActionHelperImpl", 1, "ShareActionSheetInjectUtil static statement: ", localException);
    }
  }
  
  private IShareBusinessInterface createInjectShare(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createInjectShare type: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ShareActionHelperImpl", 1, ((StringBuilder)localObject).toString());
    localObject = (Class)ShareActionSheetInjectUtil.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    try
    {
      localObject = (IShareBusinessInterface)((Class)localObject).newInstance();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createInjectShare type: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" error: ");
      localStringBuilder.append(localException);
      QLog.e("ShareActionHelperImpl", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  void dispatchAfterShareLinkToWX(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.f(paramInt);
    }
  }
  
  void dispatchAfterSharePicToWX(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.k(paramInt);
    }
  }
  
  void dispatchBeforeShareLinkToWX(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.e(paramInt);
    }
  }
  
  void dispatchBeforeSharePicToWX(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.j(paramInt);
    }
  }
  
  void dispatchHandleWXLinkRespCancel(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.c(paramInt);
    }
  }
  
  void dispatchHandleWXLinkRespDenied(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.d(paramInt);
    }
  }
  
  void dispatchHandleWXLinkRespOK(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.b(paramInt);
    }
  }
  
  void dispatchHandleWXPicRespCancel(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.h(paramInt);
    }
  }
  
  void dispatchHandleWXPicRespDenied(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.i(paramInt);
    }
  }
  
  void dispatchHandleWXPicRespOK(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.g(paramInt);
    }
  }
  
  public void doShareArkBySelect(String paramString, Activity paramActivity, ArkShareInfo paramArkShareInfo)
  {
    paramString = new Intent();
    paramString.putExtra("forward_type", 27);
    paramString.putExtra("is_ark_display_share", true);
    paramString.putExtra("forward_ark_app_name", paramArkShareInfo.a());
    paramString.putExtra("forward_ark_app_view", paramArkShareInfo.b());
    paramString.putExtra("forward_ark_app_ver", paramArkShareInfo.c());
    paramString.putExtra("forward_ark_app_prompt", paramArkShareInfo.d());
    paramString.putExtra("selection_mode", 2);
    paramString.putExtra(paramArkShareInfo.f(), true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareArkIntent metaDataString: ");
    localStringBuilder.append(paramArkShareInfo.e());
    QLog.d("ShareActionHelperImpl", 1, localStringBuilder.toString());
    paramString.putExtra("forward_ark_app_meta", paramArkShareInfo.e());
    paramString.putExtras(paramArkShareInfo.a());
    RouteUtils.a(paramActivity, paramString, "/base/forwardRecent", -1);
    QLog.d("ShareActionHelperImpl", 1, "shareToQQ success");
  }
  
  public void doShareArkDirectly(String paramString1, Activity paramActivity, ArkShareInfo paramArkShareInfo, int paramInt, String paramString2)
  {
    paramString1 = new Intent();
    paramString1.putExtra("forward_type", 27);
    paramString1.putExtra("is_ark_display_share", true);
    paramString1.putExtra("forward_ark_app_name", paramArkShareInfo.a());
    paramString1.putExtra("forward_ark_app_view", paramArkShareInfo.b());
    paramString1.putExtra("forward_ark_app_ver", paramArkShareInfo.c());
    paramString1.putExtra("forward_ark_app_prompt", paramArkShareInfo.d());
    paramString1.putExtra("selection_mode", 2);
    paramString1.putExtra(paramArkShareInfo.f(), true);
    String str = paramArkShareInfo.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareArkIntent metaDataString: ");
    localStringBuilder.append(str);
    QLog.d("ShareActionHelperImpl", 1, localStringBuilder.toString());
    paramString1.putExtra("forward_ark_app_meta", str);
    paramString1.putExtras(paramArkShareInfo.a());
    paramArkShareInfo = new Bundle();
    paramArkShareInfo.putInt("key_req", 1);
    paramArkShareInfo.putInt("key_direct_show_uin_type", paramInt);
    paramArkShareInfo.putString("key_direct_show_uin", paramString2);
    paramString1.putExtras(paramArkShareInfo);
    paramString1.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    paramString1.putExtra("forward_source_business_type", -1);
    paramString1.putExtra("forward_source_sub_business_type", "");
    RouteUtils.a(paramActivity, paramString1, "/base/forwardRecentTrans", -1);
  }
  
  public void doShareImageToQQBySelect(String paramString, Activity paramActivity, ImageShareInfo paramImageShareInfo)
  {
    paramString = new Intent();
    paramString.putExtra("key_help_forward_pic", true);
    paramString.putExtra("forward_type", 1);
    paramString.putExtra("key_allow_multiple_forward_from_limit", false);
    paramString.putExtra("selection_mode", 2);
    paramString.putExtra(paramImageShareInfo.b(), true);
    paramString.setData(Uri.parse(paramImageShareInfo.a()));
    RouteUtils.a(paramActivity, paramString, "/base/forwardRecent", -1);
  }
  
  public void doShareImageToQQDirectly(String paramString1, Activity paramActivity, ImageShareInfo paramImageShareInfo, int paramInt, String paramString2)
  {
    paramString1 = new Intent();
    paramString1.putExtra("key_help_forward_pic", true);
    paramString1.putExtra("forward_type", 1);
    paramString1.putExtra("key_allow_multiple_forward_from_limit", false);
    paramString1.putExtra("selection_mode", 2);
    paramString1.putExtra(paramImageShareInfo.b(), true);
    paramString1.setData(Uri.parse(paramImageShareInfo.a()));
    paramImageShareInfo = new Bundle();
    paramImageShareInfo.putInt("key_req", 1);
    paramImageShareInfo.putInt("key_direct_show_uin_type", paramInt);
    paramImageShareInfo.putString("key_direct_show_uin", paramString2);
    paramString1.putExtras(paramImageShareInfo);
    paramString1.putExtra("caller_name", paramActivity.getClass().getSimpleName());
    paramString1.putExtra("forward_source_business_type", -1);
    paramString1.putExtra("forward_source_sub_business_type", "");
    RouteUtils.a(paramActivity, paramString1, "/base/forwardRecentTrans", -1);
  }
  
  public void doShareLinkToWeChat(String paramString1, int paramInt, String paramString2, Activity paramActivity, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap(1);
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("ShareActionHelperImpl", 1, "shareLinkToWeChat error: params wrong");
      QQToast.a(paramActivity, 1, 2131690527, 0).a();
      return;
    }
    if (!WXShareHelper.a().a())
    {
      QLog.e("ShareActionHelperImpl", 1, "shareLinkToWeChat error: wechat not install");
      QQToast.a(paramActivity, 1, 2131720478, 0).a();
      return;
    }
    if (!WXShareHelper.a().b())
    {
      QLog.e("ShareActionHelperImpl", 1, "shareLinkToWeChat error: wechat version not support");
      QQToast.a(paramActivity, 1, 2131720479, 0).a();
      return;
    }
    Object localObject = new WXShareHelper.WXShareListener[1];
    localObject[0] = new ShareActionHelperImpl.1(this, paramString3, (WXShareHelper.WXShareListener[])localObject, paramString1, paramInt);
    WXShareHelper.a().a(localObject[0]);
    localObject = new QQProgressDialog(paramActivity);
    paramString1 = new ShareActionHelperImpl.2(this, paramString1, paramInt, (QQProgressDialog)localObject, localHashMap, paramString3, paramString5, paramString4, paramString2);
    ((QQProgressDialog)localObject).c(2131693895);
    ((QQProgressDialog)localObject).show();
    ThreadManager.post(new ShareActionHelperImpl.3(this, paramActivity, paramString6, localHashMap, paramString1), 8, null, false);
  }
  
  public void doSharePicToWX(String paramString1, Activity paramActivity, String paramString2, String paramString3, int paramInt)
  {
    HashMap localHashMap = new HashMap(1);
    if (!WXShareHelper.a().a())
    {
      QLog.e("ShareActionHelperImpl", 1, "shareToWeChat error: wechat not install");
      QQToast.a(paramActivity, 1, 2131720478, 0).a();
      return;
    }
    if (!WXShareHelper.a().b())
    {
      QLog.e("ShareActionHelperImpl", 1, "shareToWeChat error: wechat version not support");
      QQToast.a(paramActivity, 1, 2131720479, 0).a();
      return;
    }
    Object localObject = new WXShareHelper.WXShareListener[1];
    localObject[0] = new ShareActionHelperImpl.4(this, paramString2, (WXShareHelper.WXShareListener[])localObject, paramString1, paramInt);
    WXShareHelper.a().a(localObject[0]);
    localObject = new QQProgressDialog(paramActivity);
    paramString1 = new ShareActionHelperImpl.5(this, paramString1, paramInt, (QQProgressDialog)localObject, localHashMap, paramString3, paramString2);
    ((QQProgressDialog)localObject).c(2131693895);
    ((QQProgressDialog)localObject).show();
    ThreadManager.post(new ShareActionHelperImpl.6(this, paramString3, localHashMap, paramActivity, paramString1), 8, null, false);
  }
  
  public void doShareToQZoneWithLink(String paramString, Context paramContext, QzoneLinkShareInfo paramQzoneLinkShareInfo)
  {
    sShareActionInjectInterface.a(paramContext, paramQzoneLinkShareInfo);
  }
  
  public void doShareToQZoneWithPics(String paramString, Context paramContext, ArrayList<String> paramArrayList, int paramInt)
  {
    sShareActionInjectInterface.a(paramContext, paramArrayList, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl
 * JD-Core Version:    0.7.0.1
 */