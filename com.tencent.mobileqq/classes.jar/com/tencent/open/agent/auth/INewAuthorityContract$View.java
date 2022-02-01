package com.tencent.open.agent.auth;

import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import java.util.List;

public abstract interface INewAuthorityContract$View
  extends IBaseView
{
  public abstract long a();
  
  public abstract void a();
  
  public abstract void a(int paramInt, List<VirtualAccountInfo> paramList, long paramLong);
  
  public abstract void a(INewAuthorityContract.Presenter paramPresenter);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(List<VirtualAccountInfo> paramList, String paramString);
  
  public abstract boolean a(List<Permission> paramList, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.INewAuthorityContract.View
 * JD-Core Version:    0.7.0.1
 */