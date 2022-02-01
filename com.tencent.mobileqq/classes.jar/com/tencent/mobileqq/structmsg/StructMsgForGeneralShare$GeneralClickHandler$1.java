package com.tencent.mobileqq.structmsg;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class StructMsgForGeneralShare$GeneralClickHandler$1
  implements Runnable
{
  StructMsgForGeneralShare$GeneralClickHandler$1(StructMsgForGeneralShare.GeneralClickHandler paramGeneralClickHandler, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.a.containsKey("msgSeq")) && (this.a.containsKey("uin")) && (this.a.containsKey("sessionType")))
    {
      l = this.a.getLong("msgSeq");
      localObject = this.a.getString("uin");
      i = this.a.getInt("sessionType");
      localQQMessageFacade = this.this$0.a.getMessageFacade();
      localObject = localQQMessageFacade.a((String)localObject, i, l);
      ((MessageRecord)localObject).saveExtInfoToExtStr("receipt_msg_is_read", "1");
      localQQMessageFacade.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject).extLong));
      localQQMessageFacade.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extStr", ((MessageRecord)localObject).extStr);
    }
    while (!QLog.isColorLevel())
    {
      long l;
      Object localObject;
      int i;
      QQMessageFacade localQQMessageFacade;
      return;
    }
    QLog.w(StructMsgForGeneralShare.access$000(), 2, "set receipt msg read missing param");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.1
 * JD-Core Version:    0.7.0.1
 */