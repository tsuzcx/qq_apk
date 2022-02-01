package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={""})
public abstract interface ICardHandler
  extends QRouteApi
{
  public abstract void getAutoReplyList();
  
  public abstract BusinessObserver newCardHandlerForAutoReply(ICardHandler.AutoReplyInterface paramAutoReplyInterface);
  
  public abstract void setAutoReplyList(ArrayList<AutoReplyText> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.ICardHandler
 * JD-Core Version:    0.7.0.1
 */