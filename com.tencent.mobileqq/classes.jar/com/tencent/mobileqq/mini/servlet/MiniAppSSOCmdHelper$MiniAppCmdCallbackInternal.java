package com.tencent.mobileqq.mini.servlet;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.MessageMicro;

abstract interface MiniAppSSOCmdHelper$MiniAppCmdCallbackInternal<RESPONSE extends MessageMicro<RESPONSE>>
  extends MiniAppSSOCmdHelper.MiniAppCmdCallback<RESPONSE>
{
  @NonNull
  public abstract Class<? extends RESPONSE> getResponseClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal
 * JD-Core Version:    0.7.0.1
 */