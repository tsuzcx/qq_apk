package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.relation.api.ICardHandler;
import com.tencent.mobileqq.relation.api.ICardHandler.AutoReplyInterface;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class CardHandlerImpl
  implements ICardHandler
{
  public void getAutoReplyList()
  {
    ((CardHandler)((QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).p();
  }
  
  public BusinessObserver newCardHandlerForAutoReply(ICardHandler.AutoReplyInterface paramAutoReplyInterface)
  {
    return new CardHandlerImpl.1(this, paramAutoReplyInterface);
  }
  
  public void setAutoReplyList(ArrayList<AutoReplyText> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ((CardHandler)((QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramArrayList, paramInt1, paramInt2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.CardHandlerImpl
 * JD-Core Version:    0.7.0.1
 */