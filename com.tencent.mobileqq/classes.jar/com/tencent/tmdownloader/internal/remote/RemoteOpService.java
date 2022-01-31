package com.tencent.tmdownloader.internal.remote;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.t;

public class RemoteOpService
  extends Service
{
  private d a = new d();
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
  
  public void onCreate()
  {
    t.c();
    GlobalUtil.getInstance().setContext(this);
    l.a().post(new e(this));
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.remote.RemoteOpService
 * JD-Core Version:    0.7.0.1
 */