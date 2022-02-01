package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsWeiShiUtils
{
  private static DownloadInfo a;
  
  public static DownloadInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new DownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      ((DownloadInfo)localObject).c = localJSONObject.getString("appid");
      ((DownloadInfo)localObject).d = localJSONObject.getString("url");
      ((DownloadInfo)localObject).e = localJSONObject.getString("packageName");
      ((DownloadInfo)localObject).h = localJSONObject.getString("via");
      ((DownloadInfo)localObject).w = true;
      ((DownloadInfo)localObject).G = true;
      ((DownloadInfo)localObject).C = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
      String str = localJSONObject.getString("isAutoInstall");
      if (str != null) {
        ((DownloadInfo)localObject).w = str.equals("1");
      }
      str = localJSONObject.getString("isAutoInstallBySDK");
      if (str != null) {
        ((DownloadInfo)localObject).G = str.equals("1");
      }
      str = localJSONObject.getString("isShowNotification");
      if (str != null)
      {
        int i;
        if (str.equals("1")) {
          i = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
        } else {
          i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
        }
        ((DownloadInfo)localObject).C = i;
      }
      ((DownloadInfo)localObject).A = true;
      ((DownloadInfo)localObject).r = RIJJumpUtils.a(40677);
      ((DownloadInfo)localObject).f = localJSONObject.getString("appName");
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      label196:
      break label196;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("json err:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("VideoFeedsWeiShiUtils", 4, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", RIJJumpUtils.a(40677));
    localIntent.putExtra("big_brother_ref_source_key", RIJJumpUtils.a(0));
    localIntent.setData(Uri.parse(e(paramString)));
    if (VideoFeedsHelper.a(paramContext, localIntent)) {
      paramContext.startActivity(localIntent);
    }
  }
  
  public static DownloadInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new DownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.optBoolean("isWeb", false))
      {
        ((DownloadInfo)localObject).d = localJSONObject.optString("url");
        ((DownloadInfo)localObject).e = localJSONObject.optString("packageName", null);
        ((DownloadInfo)localObject).r = RIJJumpUtils.a(0);
        return localObject;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      label69:
      break label69;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("json err:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("VideoFeedsWeiShiUtils", 4, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!TextUtils.isEmpty(d(paramString))) {
      a = a(d(paramString));
    }
    if (a != null)
    {
      if (NetworkState.getNetworkType() == 1)
      {
        DownloadManager.b().a(a);
        return;
      }
      paramContext = DialogUtil.a(paramContext, 230);
      paramContext.setTitle(null);
      paramContext.setMessage(HardCodeUtil.a(2131913425));
      paramContext.setNegativeButton(HardCodeUtil.a(2131898212), new VideoFeedsWeiShiUtils.3()).setPositiveButton(HardCodeUtil.a(2131913370), new VideoFeedsWeiShiUtils.2());
      paramContext.show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", c(paramString));
    localIntent.putExtra("big_brother_source_key", RIJJumpUtils.a(40677));
    paramContext.startActivity(localIntent);
  }
  
  private static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.equals("video_type_videocard")) {
      return "https://act.qzone.qq.com/vip/meteor/m/p/3f04eaa353710dd5c996e09588244bf93066";
    }
    if (paramString.equals("video_type_videoguid")) {
      return "https://act.qzone.qq.com/vip/meteor/m/p/01e512f4384e934f8b42e30f9e16f1283064";
    }
    if (paramString.equals("video_type_videopublic")) {
      return "https://act.qzone.qq.com/vip/meteor/m/p/f644be070eeed9bcba017b43a8c7980a3065";
    }
    return null;
  }
  
  private static String d(String paramString)
  {
    return null;
  }
  
  private static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.equals("video_type_videocard")) {
      return "weishi://main?goto=recommend&logsour=5001";
    }
    if (paramString.equals("video_type_videoguid")) {
      return "weishi://main?goto=recommend&logsour=5002";
    }
    if (paramString.equals("video_type_videopublic")) {
      return "weishi://main?goto=recommend&logsour=5003";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtils
 * JD-Core Version:    0.7.0.1
 */