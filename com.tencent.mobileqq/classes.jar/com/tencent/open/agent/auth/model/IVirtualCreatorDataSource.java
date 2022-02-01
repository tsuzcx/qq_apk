package com.tencent.open.agent.auth.model;

import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.model.AccountInfo;

public abstract interface IVirtualCreatorDataSource
{
  public abstract void a(long paramLong, String paramString1, String paramString2, AccountInfo paramAccountInfo, boolean paramBoolean, CGICallback paramCGICallback);
  
  public abstract boolean a(String paramString1, String paramString2, AccountInfo paramAccountInfo, boolean paramBoolean, CGICallback paramCGICallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.IVirtualCreatorDataSource
 * JD-Core Version:    0.7.0.1
 */