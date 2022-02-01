package com.tencent.mobileqq.msf.core;

import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.qphone.base.util.QLog;

class ad
  implements IAsyncQimeiListener
{
  ad(ac paramac) {}
  
  public void onQimeiDispatch(Qimei paramQimei)
  {
    ac.d(paramQimei.getQimeiNew());
    QLog.d("libboot_MSF.C.NetConnTag", 1, "onQimeiDispatch, sQimei = " + ac.s() + ", qimeiOld = " + paramQimei.getQimeiOld());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ad
 * JD-Core Version:    0.7.0.1
 */