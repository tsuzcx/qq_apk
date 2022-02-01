package com.tencent.mobileqq.mini.entry;

import anud;
import anui;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MiniAppEntryHandler
  extends anud
{
  public MiniAppEntryHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public Class<? extends anui> observerClass()
  {
    return MiniAppEntryObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryHandler
 * JD-Core Version:    0.7.0.1
 */