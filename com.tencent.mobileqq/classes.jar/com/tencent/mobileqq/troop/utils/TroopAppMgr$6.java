package com.tencent.mobileqq.troop.utils;

import android.util.SparseArray;

class TroopAppMgr$6
  extends TroopAppMgr.ClickReportObserver
{
  TroopAppMgr$6(TroopAppMgr paramTroopAppMgr) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    synchronized (this.a.a)
    {
      this.a.a.clear();
      this.a.b();
      TroopAppMgr.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.6
 * JD-Core Version:    0.7.0.1
 */