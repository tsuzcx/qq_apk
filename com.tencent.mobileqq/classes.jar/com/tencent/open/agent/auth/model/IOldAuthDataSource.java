package com.tencent.open.agent.auth.model;

import android.os.Bundle;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.model.AccountInfo;
import java.util.List;

public abstract interface IOldAuthDataSource
{
  public abstract void a(Bundle paramBundle, AccountInfo paramAccountInfo, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver);
  
  public abstract void a(List<Permission> paramList, Bundle paramBundle, AccountInfo paramAccountInfo, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver);
  
  public abstract void b(Bundle paramBundle, AccountInfo paramAccountInfo, Object[] paramArrayOfObject, OpensdkBusinessObserver paramOpensdkBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.model.IOldAuthDataSource
 * JD-Core Version:    0.7.0.1
 */