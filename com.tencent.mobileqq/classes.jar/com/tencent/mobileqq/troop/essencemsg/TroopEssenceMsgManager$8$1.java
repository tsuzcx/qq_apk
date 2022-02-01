package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem;
import java.util.ArrayList;

class TroopEssenceMsgManager$8$1
  implements Runnable
{
  TroopEssenceMsgManager$8$1(TroopEssenceMsgManager.8 param8, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = TroopEssenceUtil.a(TroopEssenceMsgManager.a(this.b.b), this.b.a);
    if (localObject != null) {
      UniteGrayTipMsgUtil.a(TroopEssenceMsgManager.a(this.b.b), (MessageForUniteGrayTip)localObject);
    }
    localObject = this.a;
    TroopEssenceMsgManager.a(this.b.b, this.b.a.a, (ArrayList)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.8.1
 * JD-Core Version:    0.7.0.1
 */