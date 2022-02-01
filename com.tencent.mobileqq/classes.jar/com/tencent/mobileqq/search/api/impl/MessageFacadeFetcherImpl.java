package com.tencent.mobileqq.search.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.api.IMessageFacadeFetcher;

public class MessageFacadeFetcherImpl
  implements IMessageFacadeFetcher
{
  public Message getLastMessage(String paramString, int paramInt)
  {
    return ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getMessageFacade().getLastMessage(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.impl.MessageFacadeFetcherImpl
 * JD-Core Version:    0.7.0.1
 */