package com.tencent.mobileqq.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessInfo;

class MessageForGrayTips$HightlightClickableSpan$1
  implements DialogInterface.OnClickListener
{
  MessageForGrayTips$HightlightClickableSpan$1(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo, ConfessChatPie paramConfessChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ConfessHandler)this.a.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).a(this.b, this.c, this.d, this.e, -1);
    this.f.a(0, ConfessConfig.h, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan.1
 * JD-Core Version:    0.7.0.1
 */