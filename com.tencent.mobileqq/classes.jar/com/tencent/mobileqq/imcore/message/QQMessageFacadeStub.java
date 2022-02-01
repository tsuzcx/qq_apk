package com.tencent.mobileqq.imcore.message;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;

public abstract interface QQMessageFacadeStub
{
  public abstract DraftSummaryInfo getDraftSummaryInfo(String paramString, int paramInt);
  
  public abstract Message getLastMessage(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.message.QQMessageFacadeStub
 * JD-Core Version:    0.7.0.1
 */