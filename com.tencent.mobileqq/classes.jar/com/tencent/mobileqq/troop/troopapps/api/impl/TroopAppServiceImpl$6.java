package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.util.SparseArray;

class TroopAppServiceImpl$6
  extends TroopAppServiceImpl.ClickReportObserver
{
  TroopAppServiceImpl$6(TroopAppServiceImpl paramTroopAppServiceImpl) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.a.mAppIdNums)
      {
        this.a.mAppIdNums.clear();
        TroopAppServiceImpl.access$200(this.a);
        TroopAppServiceImpl.access$300(this.a);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */