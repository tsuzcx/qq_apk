package com.tencent.mobileqq.structmsg;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class StructMsgForGeneralShare$GeneralClickHandler$2
  extends QIPCModule
{
  StructMsgForGeneralShare$GeneralClickHandler$2(StructMsgForGeneralShare.GeneralClickHandler paramGeneralClickHandler, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("receipt_set_read".equals(paramString)) {
      StructMsgForGeneralShare.GeneralClickHandler.a(this.a, paramBundle);
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, "unknown action");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.2
 * JD-Core Version:    0.7.0.1
 */