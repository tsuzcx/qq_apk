package com.tencent.open.agent.auth;

import android.content.Context;
import com.tencent.open.agent.auth.model.LocalDataSource;
import com.tencent.open.agent.auth.model.OldAuthDataSourceImpl;
import com.tencent.open.agent.auth.model.VirtualCreatorDataSourceImpl;
import com.tencent.open.agent.auth.presenter.NewAuthorityPresenter;
import com.tencent.open.agent.auth.presenter.OldAuthorityPresenter;
import com.tencent.open.agent.auth.presenter.SelectPermissionPresenter;
import com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter;

public class ContractBuilder
{
  public static void a(INewAuthorityContract.View paramView, Context paramContext)
  {
    paramView.a(new NewAuthorityPresenter(paramView, new LocalDataSource(paramContext)));
  }
  
  public static void a(IOldAuthorityContract.View paramView, Context paramContext)
  {
    paramView.a(new OldAuthorityPresenter(paramView, new OldAuthDataSourceImpl(), new LocalDataSource(paramContext)));
  }
  
  public static void a(ISelectPermissionContract.View paramView, Context paramContext)
  {
    paramView.a(new SelectPermissionPresenter(paramView, new LocalDataSource(paramContext)));
  }
  
  public static void a(IVirtualCreatorContract.View paramView)
  {
    paramView.a(new VirtualCreatorPresenter(paramView, new VirtualCreatorDataSourceImpl()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.ContractBuilder
 * JD-Core Version:    0.7.0.1
 */