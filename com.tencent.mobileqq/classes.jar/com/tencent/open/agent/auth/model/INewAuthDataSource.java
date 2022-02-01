package com.tencent.open.agent.auth.model;

import android.os.Bundle;
import com.tencent.open.agent.authority.CGICallback;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.model.AccountInfo;
import java.util.List;

public abstract interface INewAuthDataSource
{
  public abstract void a(long paramLong, AccountInfo paramAccountInfo, boolean paramBoolean, CGICallback paramCGICallback);
  
  public abstract void a(Bundle paramBundle, AccountInfo paramAccountInfo, boolean paramBoolean, String paramString1, String paramString2, List<Permission> paramList, long paramLong, String paramString3, String paramString4, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver);
  
  public abstract void a(Bundle paramBundle, AccountInfo paramAccountInfo, boolean paramBoolean, String paramString1, String paramString2, List<Permission> paramList, long paramLong, String paramString3, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, AccountInfo paramAccountInfo, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.INewAuthDataSource
 * JD-Core Version:    0.7.0.1
 */