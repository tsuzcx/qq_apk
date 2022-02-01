package com.tencent.open.pcpush;

import java.util.List;

public abstract interface PCPushProxy$OnDownloadListener
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(PCPushProxy.PkgEntry paramPkgEntry, int paramInt1, String paramString, int paramInt2);
  
  public abstract void a(List<PCPushProxy.PkgEntry> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.pcpush.PCPushProxy.OnDownloadListener
 * JD-Core Version:    0.7.0.1
 */