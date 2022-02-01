package com.tencent.mobileqq.troop.shortcutbar.essencemsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver;

class EssenceMsgProcessor$2
  extends TroopShortcutBarObserver
{
  EssenceMsgProcessor$2(EssenceMsgProcessor paramEssenceMsgProcessor, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (paramInt == 0)
    {
      EssenceMsgProcessor.a(this.a, false);
      return;
    }
    this.a.b(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.essencemsg.EssenceMsgProcessor.2
 * JD-Core Version:    0.7.0.1
 */