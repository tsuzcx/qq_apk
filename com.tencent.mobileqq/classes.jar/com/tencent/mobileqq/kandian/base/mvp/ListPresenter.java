package com.tencent.mobileqq.kandian.base.mvp;

import android.support.annotation.Nullable;
import java.util.List;

public class ListPresenter<BEAN, VIEW extends ListContract.IListView<BEAN>>
  implements ListContract.IListPresenter<BEAN, VIEW>
{
  private ListContract.IListModel<BEAN> a;
  private ListContract.IListView<BEAN> b;
  private boolean c;
  
  private void a(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ListContract.IListView localIListView = this.b;
      if (localIListView != null)
      {
        localIListView.d();
        this.b.a(paramList, false);
        this.b.e();
        this.b.a();
      }
      this.c = true;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, List<BEAN> paramList)
  {
    if (paramBoolean)
    {
      a(paramList);
      return;
    }
    b(paramInt, paramList);
  }
  
  private void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, @Nullable String paramString)
  {
    ListContract.IListView localIListView;
    if (this.c)
    {
      localIListView = this.b;
      if (localIListView != null) {
        localIListView.a(paramInt, paramString);
      }
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean))
    {
      localIListView = this.b;
      if (localIListView != null)
      {
        localIListView.d();
        this.b.a(paramList, false);
        this.b.e();
        return;
      }
    }
    if (!this.c)
    {
      paramList = this.b;
      if (paramList != null)
      {
        paramList.b(paramInt, paramString);
        this.b.a(0);
      }
    }
  }
  
  private void b(int paramInt, List<BEAN> paramList)
  {
    ListContract.IListView localIListView = this.b;
    if (localIListView != null)
    {
      if (this.c) {
        localIListView.b();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a(int paramInt, List<BEAN> paramList)
  {
    ListContract.IListView localIListView = this.b;
    if (localIListView != null)
    {
      localIListView.a(paramInt);
      this.b.a(paramList, false);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.b.d();
        if (this.a.a())
        {
          this.b.f();
          return;
        }
        this.b.e();
        return;
      }
      this.b.c();
      this.b.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.mvp.ListPresenter
 * JD-Core Version:    0.7.0.1
 */