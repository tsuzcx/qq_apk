package com.tencent.mobileqq.pic;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import azjq;
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
    boolean bool = false;
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent))
    {
      PicPreDownloader.a(PicPreDownloader.a);
      if (!a(paramContext)) {
        bool = true;
      }
      PicPreDownloader.a = bool;
    }
    for (;;)
    {
      azjq.a("PIC_TAG_PRELOAD", "onReceive", "isScreenOn:" + PicPreDownloader.a + ",lastScreenOnState:" + PicPreDownloader.a());
      if ((PicPreDownloader.a() != PicPreDownloader.a) || (PicPreDownloader.a)) {
        break;
      }
      return;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
      {
        PicPreDownloader.a(PicPreDownloader.a);
        PicPreDownloader.a = false;
      }
      else if ("android.intent.action.USER_PRESENT".equals(paramIntent))
      {
        PicPreDownloader.a(PicPreDownloader.a);
        PicPreDownloader.a = true;
      }
    }
    ThreadManager.excute(new PicPreDownloader.ScreenBroadcastReceiver.1(this), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */