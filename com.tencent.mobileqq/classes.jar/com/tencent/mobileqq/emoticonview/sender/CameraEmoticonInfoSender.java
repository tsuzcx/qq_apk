package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class CameraEmoticonInfoSender
{
  static final long ONE_SEC = 1000L;
  static long lastTime;
  
  public static void send(CameraEmoticonInfo paramCameraEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CameraEmoticonInfo", 2, "send to offen,please try it later");
      }
      return;
    }
    if ((paramAppRuntime != null) && (paramContext != null))
    {
      if (paramParcelable == null) {
        return;
      }
      if (!(paramAppRuntime instanceof BaseQQAppInterface)) {
        return;
      }
      paramAppRuntime = (BaseQQAppInterface)paramAppRuntime;
      paramEditText = (BaseSessionInfo)paramParcelable;
      paramParcelable = paramCameraEmoticonInfo.templateId;
      String str1 = paramCameraEmoticonInfo.eId;
      String str2 = paramCameraEmoticonInfo.path;
      String str3 = paramCameraEmoticonInfo.contextKey;
      lastTime = l;
      if (((paramContext instanceof QBaseActivity)) && (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(paramEditText.jdField_a_of_type_Int, paramEditText.jdField_a_of_type_JavaLangString)))
      {
        paramCameraEmoticonInfo = (QBaseActivity)paramContext;
        QQToast.a(paramAppRuntime.getApp(), HardCodeUtil.a(2131701523), 0).b(paramCameraEmoticonInfo.getTitleBarHeight());
        return;
      }
      paramCameraEmoticonInfo = null;
      if (!TextUtils.isEmpty(paramParcelable))
      {
        paramCameraEmoticonInfo = new Bundle();
        paramCameraEmoticonInfo.putString("widgetinfo", paramParcelable);
      }
      CustomEmotionSenderUtil.sendCustomEmotion(paramAppRuntime, paramContext, paramEditText, str2, true, str3, paramCameraEmoticonInfo);
      if (!TextUtils.isEmpty(str1)) {
        ReportController.b(paramAppRuntime, "dc00898", "", "", "0X800A371", "0X800A371", 0, 0, "", "", str1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.CameraEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */