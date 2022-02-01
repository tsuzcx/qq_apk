package com.tencent.open.agent.util;

import com.tencent.open.model.AccountInfo;
import java.util.HashMap;

public abstract interface IAuthBeaconReporter
{
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, long paramLong);
  
  public abstract void a(String paramString, AccountInfo paramAccountInfo);
  
  public abstract void a(String paramString, AccountInfo paramAccountInfo, HashMap<String, String> paramHashMap, boolean paramBoolean);
  
  public abstract void a(String paramString, AccountInfo paramAccountInfo, boolean paramBoolean);
  
  public abstract void a(String paramString1, String paramString2, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.IAuthBeaconReporter
 * JD-Core Version:    0.7.0.1
 */