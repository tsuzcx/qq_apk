package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.relation.api.ICardHandler.AutoReplyInterface;
import java.util.List;

class CardHandlerImpl$1
  extends CardObserver
{
  CardHandlerImpl$1(CardHandlerImpl paramCardHandlerImpl, ICardHandler.AutoReplyInterface paramAutoReplyInterface) {}
  
  protected void onGetAutoReplyList(boolean paramBoolean, List<AutoReplyText> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRelationApiICardHandler$AutoReplyInterface.a(paramBoolean, paramList, paramInt);
  }
  
  protected void onSetAutoReplyList(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRelationApiICardHandler$AutoReplyInterface.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.CardHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */