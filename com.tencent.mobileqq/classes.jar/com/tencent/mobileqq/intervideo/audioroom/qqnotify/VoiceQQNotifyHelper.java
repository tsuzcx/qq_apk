package com.tencent.mobileqq.intervideo.audioroom.qqnotify;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils;
import com.tencent.mobileqq.intervideo.audioroom.utils.QQVoiceUtil;
import com.tencent.qphone.base.util.QLog;

public class VoiceQQNotifyHelper
{
  public static void querySubscribe(@NonNull String paramString1, String paramString2, String paramString3, @NonNull IVoiceQQNotifyListener paramIVoiceQQNotifyListener)
  {
    QQNotifyUtils.a(paramString1, paramString2, paramString3, paramIVoiceQQNotifyListener);
  }
  
  public static void showSubscribeDialog(@NonNull Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Activity localActivity = QQVoiceUtil.getActFromShadowContext(paramContext);
    if (localActivity == null)
    {
      QLog.w("VoiceQQNotifyHelper", 1, "context is invalid, " + paramContext.getClass().getName());
      return;
    }
    QQNotifyUtils.a(localActivity, paramString1, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.qqnotify.VoiceQQNotifyHelper
 * JD-Core Version:    0.7.0.1
 */