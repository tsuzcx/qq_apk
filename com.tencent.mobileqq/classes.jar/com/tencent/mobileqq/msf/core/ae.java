package com.tencent.mobileqq.msf.core;

import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.qphone.base.util.QLog;

class ae
  implements IAsyncQimeiListener
{
  ae(ad paramad) {}
  
  public void onQimeiDispatch(Qimei paramQimei)
  {
    ad.d(paramQimei.getQimeiNew());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQimeiDispatch, sQimei = ");
    localStringBuilder.append(ad.s());
    localStringBuilder.append(", qimeiOld = ");
    localStringBuilder.append(paramQimei.getQimeiOld());
    QLog.d("libboot_MSF.C.NetConnTag", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ae
 * JD-Core Version:    0.7.0.1
 */