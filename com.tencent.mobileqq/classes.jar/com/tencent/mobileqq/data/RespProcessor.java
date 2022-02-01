package com.tencent.mobileqq.data;

import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;

public abstract interface RespProcessor
{
  public abstract void a(MSFServlet paramMSFServlet, QzoneCommonIntent paramQzoneCommonIntent, FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.RespProcessor
 * JD-Core Version:    0.7.0.1
 */