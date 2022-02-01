package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IQCirclePreLoaderService
  extends IRuntimeService
{
  public abstract void requestWhiteList(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService
 * JD-Core Version:    0.7.0.1
 */