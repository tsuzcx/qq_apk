package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;

class TroopFileProtoReqMgrImpl$ProtoRequestRunnable
  implements Runnable
{
  TroopFileProtoReqMgrImpl.ProtoResponse a;
  NewIntent b;
  long c;
  boolean d = false;
  boolean e = false;
  long f;
  long g;
  boolean h = false;
  
  TroopFileProtoReqMgrImpl$ProtoRequestRunnable(TroopFileProtoReqMgrImpl paramTroopFileProtoReqMgrImpl) {}
  
  public void run()
  {
    int i = this.b.getIntExtra("key_runnable_index", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cookie<");
    ((StringBuilder)localObject).append(this.a.b.o);
    ((StringBuilder)localObject).append("> sendToMsf. scheduleIndex:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" timeOut:");
    ((StringBuilder)localObject).append(this.c);
    QLog.i("TroopFileProtoReqMgr", 1, ((StringBuilder)localObject).toString());
    this.d = true;
    this.f = System.currentTimeMillis();
    this.b.putExtra("timeout", this.c);
    localObject = this.a.f;
    ((StatictisInfo)localObject).c += 1;
    TroopFileProtoReqMgrImpl.access$000(this.this$0).put(this.b, this.a);
    this.this$0.sendToMsf(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.TroopFileProtoReqMgrImpl.ProtoRequestRunnable
 * JD-Core Version:    0.7.0.1
 */