package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

public abstract class TroopAppServiceImpl$ClickReportObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public TroopAppServiceImpl$ClickReportObserver()
  {
    super(false);
  }
  
  protected abstract void a(boolean paramBoolean);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("clickReport errorCode = ");
    paramArrayOfByte.append(paramInt);
    QLog.i(".troop.troop_app", 2, paramArrayOfByte.toString());
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.ClickReportObserver
 * JD-Core Version:    0.7.0.1
 */