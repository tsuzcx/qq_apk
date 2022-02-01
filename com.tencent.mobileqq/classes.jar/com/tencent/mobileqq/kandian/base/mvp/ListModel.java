package com.tencent.mobileqq.kandian.base.mvp;

import android.support.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class ListModel<BEAN, COOKIE>
  implements ListContract.IListModel<BEAN>
{
  protected CopyOnWriteArrayList<BEAN> a = new CopyOnWriteArrayList();
  protected int b = 0;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private int f = 0;
  private String g = "";
  @Nullable
  private COOKIE h = null;
  private boolean i = false;
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, List<BEAN> paramList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString, ListContract.FirstPageCallback<BEAN> paramFirstPageCallback)
  {
    this.c = true;
    if ((paramBoolean2) && (paramInt1 >= 0)) {
      this.b = paramInt1;
    }
    if (this.d)
    {
      if (paramBoolean2)
      {
        this.a.clear();
        this.a.addAll(paramList);
        a(paramList);
        this.h = paramCOOKIE;
        this.i = (paramBoolean3 ^ true);
      }
      paramFirstPageCallback.a(paramBoolean2, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
      return;
    }
    if (paramBoolean2)
    {
      this.a.clear();
      this.a.addAll(paramList);
      this.h = paramCOOKIE;
      this.i = (paramBoolean3 ^ true);
      paramFirstPageCallback.a(true, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
      return;
    }
    this.e = true;
    this.f = paramInt2;
    this.g = paramString;
    if (!paramBoolean1) {
      paramFirstPageCallback.a(false, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
    }
  }
  
  public abstract void a(List<BEAN> paramList);
  
  public boolean a()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.mvp.ListModel
 * JD-Core Version:    0.7.0.1
 */