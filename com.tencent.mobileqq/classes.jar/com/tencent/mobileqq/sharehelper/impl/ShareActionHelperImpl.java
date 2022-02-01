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
      if (ShareActionSheetInjectUtil.b.size() > 0)
      {
        sShareActionInjectInterface = (IShareActionInterface)((Class)ShareActionSheetInjectUtil.b.get(0)).newInstance();
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
    localObject = (Class)ShareActionSheetInjectUtil.a.get(paramString);
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
      paramString.h(paramInt);
    }
  }
  
  void dispatchAfterSharePicToWX(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.m(paramInt);
    }
  }
  
  void dispatchBeforeShareLinkToWX(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.g(paramInt);
    }
  }
  
  void dispatchBeforeSharePicToWX(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.l(paramInt);
    }
  }
  
  void dispatchHandleWXLinkRespCancel(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.e(paramInt);
    }
  }
  
  void dispatchHandleWXLinkRespDenied(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.f(paramInt);
    }
  }
  
  void dispatchHandleWXLinkRespOK(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.d(paramInt);
    }
  }
  
  void dispatchHandleWXPicRespCancel(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.j(paramInt);
    }
  }
  
  void dispatchHandleWXPicRespDenied(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.k(paramInt);
    }
  }
  
  void dispatchHandleWXPicRespOK(String paramString, int paramInt)
  {
    paramString = createInjectShare(paramString);
    if (paramString != null) {
      paramString.i(paramInt);
    }
  }
  
  public void doSharTextToWeChat(String paramString1, int paramInt, Activity paramActivity, String paramString2, String paramString3)
  {
    paramActivity = new WXShareHelper.WXShareListener[1];
    ShareActionHelperImpl.1 local1 = new ShareActionHelperImpl.1(this, paramString2, paramActivity, paramString1, paramInt);
    int i = 0;
    paramActivity[0] = local1;
    WXShareHelper.a().a(paramActivity[0]);
    dispatchBeforeShareLinkToWX(paramString1, paramInt);
    if (paramInt != 9) {
      i = 1;
    }
    WXShareHelper.a().a(paramString3, i, paramString2);
    QLog.d("ShareActionHelperImpl", 1, "shareTextToWeChat success");
    dispatchAfterShareLinkToWX(paramString1, paramInt);
  }
  
  public void doShareArkBySelect(String paramString, Activity paramActivity, ArkShareInfo paramArkShareInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 27);
    localIntent.putExtra("is_ark_display_share", true);
    localIntent.putExtra("forward_ark_app_name", paramArkShareInfo.a());
    localIntent.putExtra("forward_ark_app_view", paramArkShareInfo.b());
    localIntent.putExtra("forward_ark_app_ver", paramArkShareInfo.c());
    localIntent.putExtra("forward_ark_app_prompt", paramArkShareInfo.d());
    localIntent.putExtra("selection_mode", 2);
    localIntent.putExtra(paramArkShareInfo.g(), true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareArkIntent metaDataString: ");
    localStringBuilder.append(paramArkShareInfo.e());
    QLog.d("ShareActionHelperImpl", 1, localStringBuilder.toString());
    localIntent.putExtra("forward_ark_app_meta", paramArkShareInfo.e());
    localIntent.putExtras(paramArkShareInfo.f());
    if ("guildShare".equals(paramString)) {
      localIntent.putExtra("req_type", 6);
    }
    RouteUtils.a(paramActivity, localIntent, "/base/forwardRecent", -1);
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
    paramString1.putExtra(paramArkShareInfo.g(), true);
    String str = paramArkShareInfo.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareArkIntent metaDataString: ");
    localStringBuilder.append(str);
    QLog.d("ShareActionHelperImpl", 1, localStringBuilder.toString());
    paramString1.putExtra("forward_ark_app_meta", str);
    paramString1.putExtras(paramArkShareInfo.f());
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
      QQToast.makeText(paramActivity, 1, 2131887438, 0).show();
      return;
    }
    if (!WXShareHelper.a().b())
    {
      QLog.e("ShareActionHelperImpl", 1, "shareLinkToWeChat error: wechat not install");
      QQToast.makeText(paramActivity, 1, 2131918154, 0).show();
      return;
    }
    if (!WXShareHelper.a().c())
    {
      QLog.e("ShareActionHelperImpl", 1, "shareLinkToWeChat error: wechat version not support");
      QQToast.makeText(paramActivity, 1, 2131918155, 0).show();
      return;
    }
    Object localObject = new WXShareHelper.WXShareListener[1];
    localObject[0] = new ShareActionHelperImpl.2(this, paramString3, (WXShareHelper.WXShareListener[])localObject, paramString1, paramInt);
    WXShareHelper.a().a(localObject[0]);
    localObject = new QQProgressDialog(paramActivity);
    paramString1 = new ShareActionHelperImpl.3(this, paramString1, paramInt, (QQProgressDialog)localObject, localHashMap, paramString3, paramString5, paramString4, paramString2);
    ((QQProgressDialog)localObject).c(2131891516);
    ((QQProgressDialog)localObject).show();
    ThreadManager.post(new ShareActionHelperImpl.4(this, paramActivity, paramString6, localHashMap, paramString1), 8, null, false);
  }
  
  public void doSharePicToWX(String paramString1, Activity paramActivity, String paramString2, String paramString3, int paramInt)
  {
    HashMap localHashMap = new HashMap(1);
    if (!WXShareHelper.a().b())
    {
      QLog.e("ShareActionHelperImpl", 1, "shareToWeChat error: wechat not install");
      QQToast.makeText(paramActivity, 1, 2131918154, 0).show();
      return;
    }
    if (!WXShareHelper.a().c())
    {
      QLog.e("ShareActionHelperImpl", 1, "shareToWeChat error: wechat version not support");
      QQToast.makeText(paramActivity, 1, 2131918155, 0).show();
      return;
    }
    Object localObject = new WXShareHelper.WXShareListener[1];
    localObject[0] = new ShareActionHelperImpl.5(this, paramString2, (WXShareHelper.WXShareListener[])localObject, paramString1, paramInt);
    WXShareHelper.a().a(localObject[0]);
    localObject = new QQProgressDialog(paramActivity);
    paramString1 = new ShareActionHelperImpl.6(this, paramString1, paramInt, (QQProgressDialog)localObject, localHashMap, paramString3, paramString2);
    ((QQProgressDialog)localObject).c(2131891516);
    ((QQProgressDialog)localObject).show();
    ThreadManager.post(new ShareActionHelperImpl.7(this, paramString3, localHashMap, paramActivity, paramString1), 8, null, false);
  }
  
  public void doShareTextBySelect(String paramString1, Activity paramActivity, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("ShareActionHelperImpl", 1, "doShareTextDirectly: error, content is empty");
      return;
    }
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", -1);
    paramString1.putString("forward_text", paramString2);
    paramString2 = new Intent();
    paramString2.putExtra("isFromShare", true);
    paramString2.putExtras(paramString1);
    RouteUtils.a(paramActivity, paramString2, "/base/forwardRecent", -1);
  }
  
  public void doShareTextDirectly(String paramString1, Activity paramActivity, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("ShareActionHelperImpl", 1, "doShareTextDirectly: error, content is empty");
      return;
    }
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", -1);
    paramString1.putString("forward_text", paramString2);
    paramString1.putInt("key_req", 1);
    paramString1.putInt("key_direct_show_uin_type", paramInt);
    paramString1.putString("key_direct_show_uin", paramString3);
    paramString2 = new Intent();
    paramString2.putExtra("isFromShare", true);
    paramString2.putExtras(paramString1);
    RouteUtils.a(paramActivity, paramString2, "/base/forwardRecentTrans", -1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl
 * JD-Core Version:    0.7.0.1
 */