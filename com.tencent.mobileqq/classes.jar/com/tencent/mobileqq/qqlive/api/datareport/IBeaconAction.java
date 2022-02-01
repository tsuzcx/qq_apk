package com.tencent.mobileqq.qqlive.api.datareport;

import java.util.Map;

public abstract interface IBeaconAction
{
  public abstract void reportEvent(String paramString);
  
  public abstract void reportEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.datareport.IBeaconAction
 * JD-Core Version:    0.7.0.1
 */