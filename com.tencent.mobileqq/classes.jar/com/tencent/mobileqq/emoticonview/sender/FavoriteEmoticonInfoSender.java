package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FavoriteEmoticonInfoSender
{
  static final long ONE_SEC = 1000L;
  private static final String TAG = "FavoriteEmoticonInfoSender";
  static long lastTime;
  
  public static void send(FavoriteEmoticonInfo paramFavoriteEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if ((paramAppRuntime != null) && (paramParcelable != null))
    {
      if (!(paramAppRuntime instanceof BaseQQAppInterface)) {
        return;
      }
      paramAppRuntime = (BaseQQAppInterface)paramAppRuntime;
      paramEditText = (BaseSessionInfo)paramParcelable;
      long l = System.currentTimeMillis();
      if (l - lastTime < 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FavoriteEmoticonInfo", 2, "send to offen,please try it later");
        }
        return;
      }
      lastTime = l;
      paramParcelable = paramFavoriteEmoticonInfo.path;
      String str = paramFavoriteEmoticonInfo.eId;
      paramFavoriteEmoticonInfo = paramFavoriteEmoticonInfo.actionData;
      if (((IEmosmService)QRoute.api(IEmosmService.class)).isComeFromComic(paramFavoriteEmoticonInfo))
      {
        sendStructMsgForImage(paramAppRuntime, paramEditText, paramParcelable, paramFavoriteEmoticonInfo);
        return;
      }
      if (((paramContext instanceof QBaseActivity)) && (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramEditText.a, paramEditText.b)))
      {
        paramFavoriteEmoticonInfo = (QBaseActivity)paramContext;
        QQToast.makeText(paramAppRuntime.getApp(), HardCodeUtil.a(2131899546), 0).show(paramFavoriteEmoticonInfo.getTitleBarHeight());
        return;
      }
      CustomEmotionSenderUtil.sendCustomEmotion(paramAppRuntime, paramContext, paramEditText, paramParcelable, true, TextUtils.isEmpty(str) ^ true, str, null);
      if ((!TextUtils.isEmpty(paramParcelable)) && (paramParcelable.contains("qto_")))
      {
        ReportController.b(paramAppRuntime, "CliOper", "", "", "0X8005C74", "0X8005C74", 0, 0, String.valueOf(FunnyPicHelper.a(str)), "", FunnyPicHelperConstant.a(paramParcelable), "");
        return;
      }
      ReportController.b(paramAppRuntime, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "1", "");
      return;
    }
    QLog.e("FavoriteEmoticonInfoSender", 2, "app or sessionInfo is null.");
  }
  
  public static void sendStructMsgForImage(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", paramString1);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", HardCodeUtil.a(2131897793));
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", paramString2);
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendStructMsgForImage(paramBaseQQAppInterface, paramString2, localBundle, paramBaseSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.FavoriteEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */