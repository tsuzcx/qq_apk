package com.tencent.mobileqq.simpleui;

import QC.UniSetRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

class SimpleUIHandler$2
  implements BusinessObserver
{
  SimpleUIHandler$2(SimpleUIHandler paramSimpleUIHandler, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder("sendSwitchBubbleUnread onUpdate");
    localStringBuilder.append(" type=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",success=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",data=");
    if (paramObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    boolean bool = paramObject instanceof UniSetRsp;
    if (bool)
    {
      localStringBuilder.append(",ret=");
      localStringBuilder.append(((UniSetRsp)paramObject).ret);
    }
    QLog.i("SimpleUILog.SimpleUIHandler", 1, localStringBuilder.toString());
    if ((paramBoolean) && (bool) && (((UniSetRsp)paramObject).ret == 0))
    {
      this.f.a(this.a, this.b, this.c, this.d, this.e);
      return;
    }
    if ((paramBoolean) && (bool) && (((UniSetRsp)paramObject).ret != 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.f.a(false, this.a, this.b, this.d, this.c, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIHandler.2
 * JD-Core Version:    0.7.0.1
 */