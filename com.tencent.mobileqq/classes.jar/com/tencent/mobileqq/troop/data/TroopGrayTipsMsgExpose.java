package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.activity.aio.messageexpose.OnAIOMessageExposeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarUtil;

public class TroopGrayTipsMsgExpose
  implements OnAIOMessageExposeListener
{
  private void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramQQAppInterface == null) || (paramMessageForUniteGrayTip == null)) {
      return;
    }
    if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.b == 131090)) {
      TroopEssenceUtil.b(paramQQAppInterface, paramMessageForUniteGrayTip.frienduin);
    }
    TroopEssenceReportUtil.a(paramQQAppInterface, paramMessageForUniteGrayTip.frienduin);
  }
  
  private void b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramQQAppInterface == null) || (paramMessageForUniteGrayTip == null)) {}
    while ((paramMessageForUniteGrayTip.tipParam == null) || (paramMessageForUniteGrayTip.tipParam.b != 131091)) {
      return;
    }
    TroopShortcutBarUtil.a(paramQQAppInterface, paramMessageForUniteGrayTip.frienduin);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForUniteGrayTip))) {
      return;
    }
    paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
    a(paramQQAppInterface, paramMessageRecord);
    b(paramQQAppInterface, paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopGrayTipsMsgExpose
 * JD-Core Version:    0.7.0.1
 */