package com.tencent.mobileqq.kandian.base.mvp;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ListPresenter$3
  implements ListContract.NextPageCallback<BEAN>
{
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, String paramString)
  {
    if (ListPresenter.a(this.a) != null)
    {
      if (paramBoolean)
      {
        ListPresenter.a(this.a).a(paramList, true);
        if (ListPresenter.b(this.a).a())
        {
          ListPresenter.a(this.a).f();
          return;
        }
        ListPresenter.a(this.a).e();
        return;
      }
      paramList = new StringBuilder();
      paramList.append("loadNextPage error, errorCode=");
      paramList.append(paramInt);
      paramList.append(", errorMsg= ");
      paramList.append(paramString);
      QLog.i("ListPresenter", 2, paramList.toString());
      ListPresenter.a(this.a).c(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.mvp.ListPresenter.3
 * JD-Core Version:    0.7.0.1
 */