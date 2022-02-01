package com.tencent.vas.update.callback;

public abstract interface IVasUpdateFactory
{
  public abstract ICmdManager getCmdManager();
  
  public abstract ICommonManager getCommonManager();
  
  public abstract IDbManager getDbManager();
  
  public abstract IHttpDownloader getHttpDownloader();
  
  public abstract IVasLog getLog();
  
  public abstract IReportManager getReportManager();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.callback.IVasUpdateFactory
 * JD-Core Version:    0.7.0.1
 */