package com.tencent.mobileqq.vas.VasResEngine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class VasRes
  implements Handler.Callback, AbsVasRes
{
  private VasResAdapter a;
  private Handler b = new Handler(Looper.getMainLooper(), this);
  private VasResController c;
  
  public VasRes(AppRuntime paramAppRuntime, int paramInt)
  {
    this.c = new VasResController(paramInt, this.b);
  }
  
  public void a()
  {
    VasResAdapter localVasResAdapter = this.a;
    if (localVasResAdapter != null) {
      localVasResAdapter.b();
    }
  }
  
  public void a(VasResAdapter paramVasResAdapter)
  {
    this.a = paramVasResAdapter;
    this.a.a();
  }
  
  public VasResController b()
  {
    return this.c;
  }
  
  public VasResAdapter c()
  {
    return this.a;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.a == null) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 10002)
    {
      if (i != 10003) {
        return true;
      }
      this.a.a();
      return true;
    }
    this.a.a(paramMessage.arg1, (Bundle)paramMessage.obj);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasRes
 * JD-Core Version:    0.7.0.1
 */