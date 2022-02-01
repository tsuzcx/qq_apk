package com.tencent.mobileqq.kandian.base.mvp;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ListPresenter$1
  implements ListContract.FirstPageCallback<BEAN>
{
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt1, Boolean paramBoolean1, int paramInt2, String paramString)
  {
    if (ListPresenter.a(this.a) != null)
    {
      if (paramBoolean)
      {
        ListPresenter.a(this.a).setHeaderSuccess();
        this.a.a(paramInt1, paramList);
        return;
      }
      paramList = new StringBuilder();
      paramList.append("refreshPage error, errorCode=");
      paramList.append(paramInt2);
      paramList.append(", errorMsg= ");
      paramList.append(paramString);
      QLog.i("ListPresenter", 2, paramList.toString());
      ListPresenter.a(this.a).setHeaderError(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.mvp.ListPresenter.1
 * JD-Core Version:    0.7.0.1
 */