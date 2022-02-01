package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.base.event.ModuleEventInterface;
import com.tencent.ilive.litepages.room.webmodule.event.ContentLoadedEvent;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.IDataReportMgr;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.HalfSizeWebviewDialog;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class LiteAppJs
  extends AppJavascriptInterface
{
  private static final long KANDIAN_SHARE_APP_ID = 1105290942L;
  private static final String KANDIAN_SHARE_SOURCE_ICON = "https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaELBTuqnBHfumzaZXAdm0GuZb8C6VaAZIdCEsprHohWPbA/0";
  private static final String KANDIAN_SHARE_SOURCE_NAME = "看点直播";
  private static final String SHARE_TO_QQ = "2";
  private static final String SHARE_TO_QZONE = "3";
  private static final String SHARE_TO_WECHAT = "0";
  private static final String SHARE_TO_WECHAT_MOMENTS = "1";
  private static final String TAG = "LiteAppJs";
  private HalfSizeWebviewDialog halfSizeWebviewDialog;
  private LiteAppJs.OnRefreshTokenListener onRefreshTokenListener;
  
  public LiteAppJs(Context paramContext, View paramView, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramView, paramJsBizAdapter);
  }
  
  private String getUin()
  {
    return BusinessManager.a.a();
  }
  
  public static void handleShareKandianLive(long paramLong, String paramString, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramLong == 1105290942L) && (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://ilive.qq.com")))
    {
      paramIntent.putExtra("struct_share_key_source_icon", "https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaELBTuqnBHfumzaZXAdm0GuZb8C6VaAZIdCEsprHohWPbA/0");
      paramIntent.putExtra("struct_share_key_source_name", "看点直播");
      paramIntent.putExtra("struct_share_key_source_url", "");
      paramIntent.putExtra("struct_share_key_source_a_action_data", "");
    }
  }
  
  private void shareToQQ(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", getUin());
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/share/toqq/activity");
  }
  
  private void shareToQzone(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    localBundle.putString("detail_url", paramString4);
    localBundle.putString("url", paramString4);
    paramString1 = new ArrayList(1);
    paramString1.add(paramString3);
    localBundle.putStringArrayList("image_url", paramString1);
    localBundle.putLong("req_share_id", 0L);
    QZoneShareManager.jumpToQzoneShare(getUin(), paramContext, localBundle, null, -1);
  }
  
  private void shareToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt)
  {
    if (!WXShareHelper.a().a())
    {
      QRUtils.a(0, 2131720478);
      return;
    }
    if (!WXShareHelper.a().b())
    {
      QRUtils.a(0, 2131720479);
      return;
    }
    String str = String.valueOf(System.currentTimeMillis());
    WXShareHelper.a().a(new LiteAppJs.3(this, str));
    WXShareHelper.a().a(str, paramString1, paramBitmap, paramString2, paramString3, paramInt);
  }
  
  @NewJavascriptInterface
  public void closePendantWebview(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface closePendantWebview js fun");
    Object localObject = this.halfSizeWebviewDialog;
    if (localObject != null) {
      ((HalfSizeWebviewDialog)localObject).dismiss();
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("url", paramMap.get("url"));
      callJsFunctionByNative("__PENDANT_WEBVIEW_CLOSE", (JSONObject)localObject);
      return;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  @NewJavascriptInterface
  public void contentLoaded(Map<String, String> paramMap)
  {
    Log.d("LiteAppJs", "AppJavascriptInterface contentLoaded js fun");
    Object localObject1 = new ContentLoadedEvent();
    ((ContentLoadedEvent)localObject1).mContentLoaded = true;
    postEvent((ModuleEventInterface)localObject1);
    Object localObject2;
    if (paramMap != null)
    {
      localObject1 = (String)paramMap.get("program_id");
      localObject2 = (String)paramMap.get("state");
      String str1 = (String)paramMap.get("ilive_type");
      String str2 = (String)paramMap.get("followed");
      String str3 = (String)paramMap.get("anchor_uid");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AppJavascriptInterface contentLoaded programId = ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", state = ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(", ilive_type = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", followed = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", anchor_uid = ");
      localStringBuilder.append(str3);
      logI("LiteAppJs", localStringBuilder.toString());
      localObject1 = new RoomExtInfo((String)localObject1, (String)localObject2, str1, str2, str3);
      if (getJsBizAdapter() != null) {
        getJsBizAdapter().onGetRoomInfo((RoomExtInfo)localObject1);
      }
    }
    if (paramMap != null) {
      paramMap = (String)paramMap.get("callback");
    } else {
      paramMap = "";
    }
    int i = CUKingCardUtils.a();
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("ab_token", ((IDataReportMgr)QRoute.api(IDataReportMgr.class)).getCurrentRoomReportInfo().get("ab_token"));
      if (i != 0) {
        j = 1;
      }
      ((JSONObject)localObject1).put("kingCard", j);
      ((JSONObject)localObject1).put("statusBarHeight", UIUtil.getStatusBarHeight(this.mContext));
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("result", localObject1);
      callJsFunctionByNative(paramMap, (JSONObject)localObject2);
      return;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  @NewJavascriptInterface
  public void doShare(Map<String, String> paramMap)
  {
    try
    {
      QLog.i("LiteAppJs", 1, "AppJavascriptInterface doShare js fun");
      localObject = (String)paramMap.get("type");
      String str1 = (String)paramMap.get("url");
      String str2 = (String)paramMap.get("title");
      String str3 = (String)paramMap.get("desc");
      String str4 = (String)paramMap.get("image");
      if ((!"0".equals(localObject)) && (!"1".equals(localObject)))
      {
        if ("2".equals(localObject))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("title", str2);
          ((Bundle)localObject).putString("imageurl", str4);
          ((Bundle)localObject).putString("imageUrl", str4);
          ((Bundle)localObject).putString("targeturl", str1);
          ((Bundle)localObject).putString("targetUrl", str1);
          ((Bundle)localObject).putString("summary", str3);
          if (BusinessManager.a.b())
          {
            ((Bundle)localObject).putString("sourcename", "看点直播");
            ((Bundle)localObject).putString("sourceIcon", "https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaELBTuqnBHfumzaZXAdm0GuZb8C6VaAZIdCEsprHohWPbA/0");
            if (paramMap.get("actionData") == null) {
              paramMap = "";
            } else {
              paramMap = (String)paramMap.get("actionData");
            }
            ((Bundle)localObject).putString("liveActionData", paramMap);
          }
          shareToQQ((Bundle)localObject);
          return;
        }
        if ("3".equals(localObject)) {
          shareToQzone(this.mContext, str2, str3, str4, str1);
        }
      }
      else
      {
        ThreadManager.getSubThreadHandler().post(new LiteAppJs.1(this, str4, str2, str3, str1, (String)localObject));
        return;
      }
    }
    catch (Exception paramMap)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("share err ");
      ((StringBuilder)localObject).append(paramMap.getMessage());
      QLog.e("LiteAppJs", 1, ((StringBuilder)localObject).toString());
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131718871), 0).a();
    }
  }
  
  @NewJavascriptInterface
  public void navigateToMiniProgram(Map<String, String> paramMap)
  {
    paramMap = String.format("mqqapi://wxminiapp/launch?user_name=%s&path=%s&appid=%s", new Object[] { (String)paramMap.get("username"), (String)paramMap.get("path"), (String)paramMap.get("appid") });
    try
    {
      Intent localIntent = new Intent(this.mContext, JumpActivity.class);
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramMap));
      this.mContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public void onJsDestroy()
  {
    super.onJsDestroy();
    HalfSizeWebviewDialog localHalfSizeWebviewDialog = this.halfSizeWebviewDialog;
    if (localHalfSizeWebviewDialog != null) {
      localHalfSizeWebviewDialog.dismiss();
    }
  }
  
  @NewJavascriptInterface
  public void openLoginPage(Map<String, String> paramMap)
  {
    QLog.i("LiteAppJs", 1, "AppJavascriptInterface openLoginPage js fun");
    paramMap = this.onRefreshTokenListener;
    if (paramMap != null) {
      paramMap.a();
    }
  }
  
  @NewJavascriptInterface
  public void openPendantWebview(Map<String, String> paramMap)
  {
    Log.d("AppJavascriptInterface", "AppJavascriptInterface openPendantWebview js fun");
    Bundle localBundle = new Bundle();
    int i = 0;
    localBundle.putBoolean("showTitleBar", false);
    localBundle.putString("url", (String)paramMap.get("url"));
    localBundle.putBoolean("isLandscape", false);
    localBundle.putFloat("dimAmount", 0.0F);
    localBundle.putBoolean("leftClickClose", true);
    localBundle.putBoolean("plantCookieWhenResume", true);
    try
    {
      int j = Integer.valueOf((String)paramMap.get("height")).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (i == 0) {
      i = (int)(UIUtil.getScreenHeight(this.mContext) * 0.6F);
    } else {
      i = UIUtil.getScreenHeight(this.mContext) * i / 100;
    }
    localBundle.putInt("height", i);
    this.halfSizeWebviewDialog = new HalfSizeWebviewDialog();
    this.halfSizeWebviewDialog.setArguments(localBundle);
    this.halfSizeWebviewDialog.a(getJsBizAdapter().getModuleEvent());
    this.halfSizeWebviewDialog.a(new LiteAppJs.2(this, paramMap));
    this.halfSizeWebviewDialog.show(((FragmentActivity)this.mContext).getSupportFragmentManager(), "");
  }
  
  public LiteAppJs setOnRefreshTokenListener(LiteAppJs.OnRefreshTokenListener paramOnRefreshTokenListener)
  {
    this.onRefreshTokenListener = paramOnRefreshTokenListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs
 * JD-Core Version:    0.7.0.1
 */