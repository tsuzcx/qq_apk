package com.tencent.mobileqq.hotpic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoItemEventManager$2
  extends BroadcastReceiver
{
  private final String b = "reason";
  private final String c = "homekey";
  
  VideoItemEventManager$2(VideoItemEventManager paramVideoItemEventManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive ===>");
      localStringBuilder.append(paramContext);
      QLog.d("VideoItemEventManager", 2, localStringBuilder.toString());
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      paramContext = VideoItemEventManager.a(this.a).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).b(false);
      }
      return;
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      paramContext = VideoItemEventManager.a(this.a).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).b(true);
      }
      return;
    }
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      paramContext = VideoItemEventManager.a(this.a).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).c(true);
      }
      return;
    }
    if ("tencent.av.v2q.StopVideoChat".equals(paramContext))
    {
      paramContext = VideoItemEventManager.a(this.a).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).c(false);
      }
      return;
    }
    if ("VolumeBtnDown".equals(paramIntent.getAction()))
    {
      paramContext = VideoItemEventManager.a(this.a).iterator();
      while (paramContext.hasNext()) {
        ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).k();
      }
      return;
    }
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext == null) {
        return;
      }
      if (paramContext.equals("homekey"))
      {
        paramContext = VideoItemEventManager.a(this.a).iterator();
        while (paramContext.hasNext())
        {
          ((VideoItemEventManager.onVideoItemEventListener)paramContext.next()).j();
          QLog.d("VideoItemEventManager", 2, "onReceive ===>homekey press");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoItemEventManager.2
 * JD-Core Version:    0.7.0.1
 */