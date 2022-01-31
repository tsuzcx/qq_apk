package com.tencent.mobileqq.mini.servlet;

import com.tencent.mobileqq.pb.MessageMicro;

public abstract interface MiniAppSSOCmdHelper$MiniAppCmdCallback<RESPONSE extends MessageMicro<RESPONSE>>
{
  public abstract void onReceived(boolean paramBoolean, RESPONSE paramRESPONSE);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback
 * JD-Core Version:    0.7.0.1
 */