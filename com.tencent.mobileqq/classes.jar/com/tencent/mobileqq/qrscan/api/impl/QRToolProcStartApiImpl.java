package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qrscan.IToolProcStart;
import com.tencent.mobileqq.qrscan.api.IQRToolProcStartApi;
import com.tencent.mobileqq.qrscan.ipc.PreCallUpToolProc;
import mqq.app.MobileQQ;

public class QRToolProcStartApiImpl
  implements IQRToolProcStartApi
{
  public IToolProcStart get()
  {
    return new PreCallUpToolProc(MobileQQ.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRToolProcStartApiImpl
 * JD-Core Version:    0.7.0.1
 */