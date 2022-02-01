package com.tencent.mobileqq.imcore.proxy.db;

public class SQLiteFTSUtilsProxy
{
  private static SQLiteFTSUtilsProxy.Proxy proxy;
  
  public static int getFTSNotifyFlag()
  {
    if (proxy != null) {
      return proxy.getFTSNotifyFlag();
    }
    return 0;
  }
  
  public static void registerProxy(SQLiteFTSUtilsProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.db.SQLiteFTSUtilsProxy
 * JD-Core Version:    0.7.0.1
 */