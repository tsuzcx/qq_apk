package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonInfoSender;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import mqq.app.AppRuntime;

public class FavoriteEmoticonInfoSender
  implements IEmoticonInfoSender<FavoriteEmoticonInfo>
{
  static final long ONE_SEC = 1000L;
  private static final String TAG = "FavoriteEmoticonInfoSender";
  static long lastTime;
  
  private void sendStructMsgForImage(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", paramString1);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", HardCodeUtil.a(2131704406));
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", paramString2);
    StructMsgForImageShare.sendAndUploadImageShare(paramQQAppInterface, (StructMsgForImageShare)StructMsgFactory.a(localBundle), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b, 0);
    paramSessionInfo = AIOGallerySceneWithBusiness.a(paramString2);
    if ((paramSessionInfo != null) && (paramSessionInfo.length >= 8)) {
      VipComicReportUtils.a(paramQQAppInterface, "100007", "2", "40051", paramSessionInfo[0], new String[] { paramSessionInfo[2], paramSessionInfo[4], AIOGallerySceneWithBusiness.a(paramString2) });
    }
  }
  
  public void send(FavoriteEmoticonInfo paramFavoriteEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramAppRuntime == null) {
      QLog.e("FavoriteEmoticonInfoSender", 2, "app is null.");
    }
    long l;
    do
    {
      do
      {
        return;
      } while (!(paramAppRuntime instanceof QQAppInterface));
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      paramEditText = (SessionInfo)paramParcelable;
      l = System.currentTimeMillis();
      if (l - lastTime >= 1000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("FavoriteEmoticonInfo", 2, "send to offen,please try it later");
    return;
    lastTime = l;
    paramParcelable = paramFavoriteEmoticonInfo.path;
    String str = paramFavoriteEmoticonInfo.eId;
    paramFavoriteEmoticonInfo = paramFavoriteEmoticonInfo.actionData;
    if (AIOGallerySceneWithBusiness.a(paramFavoriteEmoticonInfo))
    {
      sendStructMsgForImage(paramAppRuntime, paramEditText, paramParcelable, paramFavoriteEmoticonInfo);
      return;
    }
    if (((paramContext instanceof BaseActivity)) && (HotChatUtil.a(paramEditText.jdField_a_of_type_Int, paramEditText.jdField_a_of_type_JavaLangString)))
    {
      paramFavoriteEmoticonInfo = (BaseActivity)paramContext;
      QQToast.a(paramAppRuntime.getApp(), HardCodeUtil.a(2131704408), 0).b(paramFavoriteEmoticonInfo.getTitleBarHeight());
      return;
    }
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool = true;; bool = false)
    {
      ChatActivityFacade.a(paramAppRuntime, paramContext, paramEditText, paramParcelable, true, bool, str, null);
      if ((TextUtils.isEmpty(paramParcelable)) || (!paramParcelable.contains("qto_"))) {
        break;
      }
      ReportController.b(((BaseActivity)paramContext).app, "CliOper", "", "", "0X8005C74", "0X8005C74", 0, 0, String.valueOf(FunnyPicHelper.a(str)), "", FunnyPicHelper.a(paramParcelable), "");
      return;
    }
    ReportController.b(((BaseActivity)paramContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "1", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.FavoriteEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */