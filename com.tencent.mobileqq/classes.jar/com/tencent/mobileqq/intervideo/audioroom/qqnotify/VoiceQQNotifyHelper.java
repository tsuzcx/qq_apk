package com.tencent.mobileqq.intervideo.audioroom.qqnotify;

import agcp;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class VoiceQQNotifyHelper
{
  @Nullable
  private static Activity a(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      paramContext = (ContextWrapper)paramContext;
      if ((paramContext.getBaseContext() instanceof Activity)) {
        return (Activity)paramContext.getBaseContext();
      }
    }
    return null;
  }
  
  public static void querySubscribe(@NonNull String paramString1, String paramString2, String paramString3, @NonNull IVoiceQQNotifyListener paramIVoiceQQNotifyListener)
  {
    agcp.a(paramString1, paramString2, paramString3, paramIVoiceQQNotifyListener);
  }
  
  public static void showSubscribeDialog(@NonNull Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (a(paramContext) == null)
    {
      QLog.w("VoiceQQNotifyHelper", 1, "context is invalid, " + paramContext.getClass().getName());
      return;
    }
    agcp.a(a(paramContext), paramString1, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.qqnotify.VoiceQQNotifyHelper
 * JD-Core Version:    0.7.0.1
 */