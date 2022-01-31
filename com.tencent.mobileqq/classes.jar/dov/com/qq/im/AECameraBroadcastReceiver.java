package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bhcw;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private bhcw a;
  
  public AECameraBroadcastReceiver(bhcw parambhcw)
  {
    this.a = parambhcw;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.a();
    if ((paramContext == null) || (paramContext.isFinishing())) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if ("key_notify_filter_so_ready".equals(paramContext))
      {
        this.a.l();
        return;
      }
    } while (!"key_notify_ptures_so_ready".equals(paramContext));
    awex.a = true;
    this.a.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */