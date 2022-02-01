package com.tencent.mobileqq.kandian.base.mvp;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class ListModel$3
  implements ListModel.LoadDataFromNetworkCallback<BEAN, COOKIE>
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.b.a.addAll(paramArrayList);
    if (paramBoolean1)
    {
      ListModel.a(this.b, paramCOOKIE);
      ListModel.a(this.b, paramBoolean2 ^ true);
    }
    this.a.a(paramBoolean1, this.b.a, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.mvp.ListModel.3
 * JD-Core Version:    0.7.0.1
 */