package com.tencent.mobileqq.qqemoticon.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IEmoticonManager
  extends IRuntimeService
{
  public abstract String getSmallEmoticonDescription(String paramString1, String paramString2);
  
  public abstract String syncGetEmoticonDescriptionById(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.IEmoticonManager
 * JD-Core Version:    0.7.0.1
 */