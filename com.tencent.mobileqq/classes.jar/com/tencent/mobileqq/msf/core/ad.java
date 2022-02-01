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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQimeiDispatch, sQimei = ");
    localStringBuilder.append(ac.s());
    localStringBuilder.append(", qimeiOld = ");
    localStringBuilder.append(paramQimei.getQimeiOld());
    QLog.d("libboot_MSF.C.NetConnTag", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ad
 * JD-Core Version:    0.7.0.1
 */