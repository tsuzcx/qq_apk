package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class NotifyLightUtil
{
  public static boolean a(Context paramContext, AppInterface paramAppInterface)
  {
    return (SettingCloneUtil.readValue(paramContext, paramAppInterface.getCurrentAccountUin(), paramContext.getString(2131718680), "qqsetting_notify_blncontrol_key", true)) && ((paramAppInterface.isBackgroundPause) || (!ReflectionUtil.a(BaseApplication.getContext()))) && (!NoDisturbUtil.a(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.NotifyLightUtil
 * JD-Core Version:    0.7.0.1
 */