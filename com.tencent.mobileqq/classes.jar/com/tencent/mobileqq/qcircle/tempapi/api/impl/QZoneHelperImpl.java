package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.INewFriendListApi;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.router.PageRouterBuilder;
import com.tencent.mobileqq.flutter.router.QFlutterPageRouter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.FontManager;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.FriendSysMsg;

public class QZoneHelperImpl
  implements IQZoneHelper
{
  private static final Map<String, String> darkColorMap;
  private static final Map<String, String> lightColorMap = new ConcurrentHashMap();
  
  static
  {
    darkColorMap = new ConcurrentHashMap();
    lightColorMap.put("color-bg-default", "#FFFAFAFB");
    lightColorMap.put("color-bg-detailspage", "#FF252525");
    lightColorMap.put("color-bg-backplate", "#FFF2F2F5");
    lightColorMap.put("color-bg-divider", "#FFE0E0E6");
    lightColorMap.put("color-bg-tag", "#FFEBEBF0");
    lightColorMap.put("color-bg-tag-unselected", "#FFF3F4F6");
    lightColorMap.put("color-icon-primary", "#FF000000");
    lightColorMap.put("color-icon-secondary", "#FF7A7A8D");
    lightColorMap.put("color-icon-light", "#FFB8B9C7");
    lightColorMap.put("color-icon-ghost", "#FFFFFFFF");
    lightColorMap.put("color-icon-warning", "#FFF44E4E");
    lightColorMap.put("color-icon-link", "#FF3067FF");
    lightColorMap.put("color-text-primary", "##FF000000");
    lightColorMap.put("color-text-secondary", "#FF7A7A8D");
    lightColorMap.put("color-text-light", "#FFB8B9C7");
    lightColorMap.put("color-text-ghost", "#FFFFFFFF");
    lightColorMap.put("color-text-warning", "#FFF44E4E");
    lightColorMap.put("color-text-link", "#FF3067FF");
    darkColorMap.put("color-bg-default", "#FF1A1A1A");
    darkColorMap.put("color-bg-detailspage", "#FF121212");
    darkColorMap.put("color-bg-backplate", "#FF121212");
    darkColorMap.put("color-bg-divider", "#FF333333");
    darkColorMap.put("color-bg-tag", "#33FFFFFF");
    darkColorMap.put("color-bg-tag-unselected", "#1AFFFFFF");
    darkColorMap.put("color-icon-primary", "#B3FFFFFF");
    darkColorMap.put("color-icon-secondary", "#8CFFFFFF");
    darkColorMap.put("color-icon-light", "#66FFFFFF");
    darkColorMap.put("color-icon-ghost", "#FFFFFFFF");
    darkColorMap.put("color-icon-warning", "#FFF44E4E");
    darkColorMap.put("color-icon-link", "#FF3067FF");
    darkColorMap.put("color-text-primary", "#E6FFFFFF");
    darkColorMap.put("color-text-secondary", "#99FFFFFF");
    darkColorMap.put("color-text-light", "#66FFFFFF");
    darkColorMap.put("color-text-ghost", "#FFFFFFFF");
    darkColorMap.put("color-text-warning", "#FFF44E4E");
    darkColorMap.put("color-text-link", "#FF3067FF");
  }
  
  private static void necessaryFlutterParams(Map<String, Object> paramMap)
  {
    paramMap.put("currentUin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    paramMap.put("qua", QUA.getQUA3());
    if (SubscribeUtils.a())
    {
      paramMap.put("themeStyle", "1");
      paramMap.put("themeResource", darkColorMap);
      return;
    }
    paramMap.put("themeStyle", "0");
    paramMap.put("themeResource", lightColorMap);
  }
  
  public String AUTHORITY_ACTION()
  {
    return "com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify";
  }
  
  public String FRAGMENT_CLASS()
  {
    return "fragment_class";
  }
  
  public String GO_PUBLISH_ACTIVITY()
  {
    return "go_publish_activity";
  }
  
  public String KEY_CONFIRM_TEXT()
  {
    return "confirm_text";
  }
  
  public String KEY_TITLE_STYLE()
  {
    return "titleStyle";
  }
  
  public String KEY_UPLOAD_ENTRANCE()
  {
    return "key_upload_entrance";
  }
  
  public int PA_FRIEND_PROFILE()
  {
    return 1;
  }
  
  public String PHOTO_PATHS()
  {
    return "PhotoConst.PHOTO_PATHS";
  }
  
  public int QZONE_BUSSINESS_ID()
  {
    return 1000027;
  }
  
  public int QZONE_VIDEO()
  {
    return 102;
  }
  
  public int REQUEST_CODE_TAKE_VIDEO()
  {
    return 20000;
  }
  
  public void cancelQzoneAlive()
  {
    ThreadManager.getSubThreadHandler().post(new QZoneHelperImpl.2(this));
  }
  
  public void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    QZoneHelper.forwardToMoodSelectLocation(paramContext, paramString, paramInt, paramBundle);
  }
  
  public boolean isVideoSDKReady()
  {
    return QQVideoPlaySDKManager.a();
  }
  
  public void openFlutterPageForQCircle(Context paramContext, String paramString1, String paramString2, Map<String, Object> paramMap, Bundle paramBundle)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    necessaryFlutterParams((Map)localObject);
    QFlutterPageRouter.a(paramContext, new PageRouterBuilder().a((Map)localObject).a(paramString1).b(paramString2).a(true).b(true).c(true).a(), paramBundle);
  }
  
  public void preloadHippy()
  {
    HippyQQLibraryManager.getInstance().preDownload();
  }
  
  public void preloadQZoneProcess()
  {
    ThreadManager.getSubThreadHandler().post(new QZoneHelperImpl.1(this));
  }
  
  public void reportDC02880(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new LpReportInfo_dc02880(2, 2, null, paramString2);
    paramString1.reserves6 = paramString3;
    LpReportManager.getInstance().reportToDC02880(paramString1, false, true);
  }
  
  public void startAddFriend(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramContext, 1, String.valueOf(paramString1), "", 3050, 3, paramString2, null, null, null, null);
    paramString1.putExtra("qcircle_isfollow", paramBoolean1);
    paramString1.putExtra("key_qcircle_stick", paramBoolean2);
    paramContext.startActivity(paramString1);
  }
  
  public void startAddFriend(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte)
  {
    Intent localIntent = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramContext, 1, String.valueOf(paramString1), "", 3050, 3, paramString2, null, null, null, null);
    localIntent.putExtra("qcircle_isfollow", paramBoolean1);
    localIntent.putExtra("key_qcircle_stick", paramBoolean2);
    localIntent.putExtra("key_qcircle_trans_info", paramArrayOfByte);
    paramString2 = localIntent.getBundleExtra("flc_extra_param");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = new Bundle();
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString2 = new FrdSysMsg.FriendSysMsg();
      paramString2.bytes_paster_info.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      paramString1.putByteArray("friend_src_desc", paramString2.toByteArray());
    }
    localIntent.putExtra("flc_extra_param", paramString1);
    paramContext.startActivity(localIntent);
  }
  
  public void startFontSoDownload()
  {
    FontManager.getInstance().startFontSoDownload(null);
  }
  
  public void startNewFriendList(Context paramContext)
  {
    paramContext.startActivity(((INewFriendListApi)QRoute.api(INewFriendListApi.class)).startNewFriendList(paramContext, 0));
  }
  
  public void startProfileCardActivity(Context paramContext, String paramString)
  {
    int i = 115;
    if (paramString.equals(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount())) {
      i = 0;
    }
    for (;;)
    {
      ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).openProfileCard(paramContext, paramString, i, 128, 3050, 1);
      return;
      if (((FriendsManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString)) {
        i = 1;
      }
    }
  }
  
  public void startQCircleHippyActivity(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.a(paramContext, paramIntent, QCircleHippyFragment.class);
  }
  
  public void startUnlockActivity()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.context, GesturePWDUnlockActivity.class);
    BaseApplicationImpl.context.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QZoneHelperImpl
 * JD-Core Version:    0.7.0.1
 */