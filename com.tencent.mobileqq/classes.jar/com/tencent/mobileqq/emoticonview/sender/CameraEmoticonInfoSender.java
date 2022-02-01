package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonInfoSender;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class CameraEmoticonInfoSender
  implements IEmoticonInfoSender<CameraEmoticonInfo>
{
  static final long ONE_SEC = 1000L;
  static long lastTime;
  
  public void send(CameraEmoticonInfo paramCameraEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    long l = System.currentTimeMillis();
    if (l - lastTime < 1000L) {
      if (QLog.isColorLevel()) {
        QLog.e("CameraEmoticonInfo", 2, "send to offen,please try it later");
      }
    }
    String str1;
    do
    {
      do
      {
        return;
      } while ((paramAppRuntime == null) || (paramContext == null) || (paramParcelable == null) || (!(paramAppRuntime instanceof QQAppInterface)));
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      paramEditText = (SessionInfo)paramParcelable;
      paramParcelable = paramCameraEmoticonInfo.templateId;
      str1 = paramCameraEmoticonInfo.eId;
      String str2 = paramCameraEmoticonInfo.path;
      String str3 = paramCameraEmoticonInfo.contextKey;
      lastTime = l;
      if (((paramContext instanceof BaseActivity)) && (HotChatUtil.a(paramEditText.jdField_a_of_type_Int, paramEditText.jdField_a_of_type_JavaLangString)))
      {
        paramCameraEmoticonInfo = (BaseActivity)paramContext;
        QQToast.a(paramAppRuntime.getApp(), HardCodeUtil.a(2131701383), 0).b(paramCameraEmoticonInfo.getTitleBarHeight());
        return;
      }
      paramCameraEmoticonInfo = null;
      if (!TextUtils.isEmpty(paramParcelable))
      {
        paramCameraEmoticonInfo = new Bundle();
        paramCameraEmoticonInfo.putString("widgetinfo", paramParcelable);
      }
      ChatActivityFacade.a(paramAppRuntime, paramContext, paramEditText, str2, true, str3, paramCameraEmoticonInfo);
    } while (TextUtils.isEmpty(str1));
    ReportController.b(paramAppRuntime, "dc00898", "", "", "0X800A371", "0X800A371", 0, 0, "", "", str1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.CameraEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */