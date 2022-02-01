package com.tencent.mobileqq.hotpic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.util.ArrayList;

public class VideoItemEventManager
{
  private static volatile VideoItemEventManager b;
  BroadcastReceiver a = new VideoItemEventManager.2(this);
  private Context c;
  private boolean d = false;
  private ArrayList<VideoItemEventManager.onVideoItemEventListener> e = new ArrayList();
  private INetInfoHandler f = new VideoItemEventManager.1(this);
  
  private VideoItemEventManager(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    a(true);
  }
  
  public static VideoItemEventManager a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new VideoItemEventManager(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(VideoItemEventManager.onVideoItemEventListener paramonVideoItemEventListener)
  {
    if ((!this.e.contains(paramonVideoItemEventListener)) && (paramonVideoItemEventListener != null)) {
      this.e.add(paramonVideoItemEventListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      localIntentFilter.addAction("VolumeBtnDown");
      this.c.registerReceiver(this.a, localIntentFilter);
      AppNetConnInfo.registerConnectionChangeReceiver(this.c, this.f);
      return;
    }
    this.c.unregisterReceiver(this.a);
    this.e.clear();
    AppNetConnInfo.unregisterNetInfoHandler(this.f);
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.e;
    boolean bool = false;
    if (localArrayList == null) {
      return false;
    }
    if (localArrayList.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public void b(VideoItemEventManager.onVideoItemEventListener paramonVideoItemEventListener)
  {
    if ((paramonVideoItemEventListener != null) && (this.e.contains(paramonVideoItemEventListener))) {
      this.e.remove(paramonVideoItemEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoItemEventManager
 * JD-Core Version:    0.7.0.1
 */