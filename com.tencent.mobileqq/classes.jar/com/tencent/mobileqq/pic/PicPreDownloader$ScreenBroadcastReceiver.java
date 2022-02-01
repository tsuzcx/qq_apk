package com.tencent.mobileqq.pic;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;

public class PicPreDownloader$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  String a;
  
  public PicPreDownloader$ScreenBroadcastReceiver(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent))
    {
      PicPreDownloader.a(PicPreDownloader.a);
      PicPreDownloader.a = a(paramContext) ^ true;
    }
    else if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
    {
      PicPreDownloader.a(PicPreDownloader.a);
      PicPreDownloader.a = false;
    }
    else if ("android.intent.action.USER_PRESENT".equals(paramIntent))
    {
      PicPreDownloader.a(PicPreDownloader.a);
      PicPreDownloader.a = true;
    }
    paramContext = new StringBuilder();
    paramContext.append("isScreenOn:");
    paramContext.append(PicPreDownloader.a);
    paramContext.append(",lastScreenOnState:");
    paramContext.append(PicPreDownloader.a());
    Logger.a("PIC_TAG_PRELOAD", "onReceive", paramContext.toString());
    if ((PicPreDownloader.a() == PicPreDownloader.a) && (!PicPreDownloader.a)) {
      return;
    }
    ThreadManager.excute(new PicPreDownloader.ScreenBroadcastReceiver.1(this), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */