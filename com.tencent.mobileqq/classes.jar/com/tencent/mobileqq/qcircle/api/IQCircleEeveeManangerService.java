package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQCircleEeveeManangerService
  extends IRuntimeService
{
  public abstract void onSend(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService
 * JD-Core Version:    0.7.0.1
 */