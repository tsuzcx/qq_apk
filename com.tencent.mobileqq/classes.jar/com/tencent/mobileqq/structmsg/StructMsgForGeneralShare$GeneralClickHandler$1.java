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
      long l = this.a.getLong("msgSeq");
      Object localObject = this.a.getString("uin");
      int i = this.a.getInt("sessionType");
      QQMessageFacade localQQMessageFacade = this.this$0.b.getMessageFacade();
      localObject = localQQMessageFacade.a((String)localObject, i, l);
      ((MessageRecord)localObject).saveExtInfoToExtStr("receipt_msg_is_read", "1");
      localQQMessageFacade.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject).extLong));
      localQQMessageFacade.a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extStr", ((MessageRecord)localObject).extStr);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(StructMsgForGeneralShare.access$000(), 2, "set receipt msg read missing param");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler.1
 * JD-Core Version:    0.7.0.1
 */