package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.qphone.base.util.QLog;

class TroopEssenceMsgManager$7$1$1
  implements Runnable
{
  TroopEssenceMsgManager$7$1$1(TroopEssenceMsgManager.7.1 param1) {}
  
  public void run()
  {
    if (TroopEssenceMsgManager.a(this.a.a.b, this.a.a.a.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgManager", 2, "AddEssenceMsgGrayTip");
      }
      TroopEssenceMsgManager.b(this.a.a.b, this.a.a.a);
      MessageForUniteGrayTip localMessageForUniteGrayTip = TroopEssenceUtil.a(TroopEssenceMsgManager.a(this.a.a.b), this.a.a.a);
      if (localMessageForUniteGrayTip != null)
      {
        UniteGrayTipMsgUtil.a(TroopEssenceMsgManager.a(this.a.a.b), localMessageForUniteGrayTip);
        this.a.a.a.a.graytipuniseq = localMessageForUniteGrayTip.uniseq;
      }
    }
    TroopEssenceMsgManager.b(this.a.a.b, this.a.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.7.1.1
 * JD-Core Version:    0.7.0.1
 */