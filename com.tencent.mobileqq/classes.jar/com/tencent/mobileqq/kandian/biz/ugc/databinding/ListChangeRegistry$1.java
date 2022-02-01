package com.tencent.mobileqq.kandian.biz.ugc.databinding;

final class ListChangeRegistry$1
  extends CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChangeRegistry.ListChanges>
{
  public void a(ObservableList.OnListChangedCallback paramOnListChangedCallback, ObservableList paramObservableList, int paramInt, ListChangeRegistry.ListChanges paramListChanges)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            paramOnListChangedCallback.a(paramObservableList);
            return;
          }
          paramOnListChangedCallback.c(paramObservableList, paramListChanges.a, paramListChanges.b);
          return;
        }
        paramOnListChangedCallback.a(paramObservableList, paramListChanges.a, paramListChanges.c, paramListChanges.b);
        return;
      }
      paramOnListChangedCallback.b(paramObservableList, paramListChanges.a, paramListChanges.b);
      return;
    }
    paramOnListChangedCallback.a(paramObservableList, paramListChanges.a, paramListChanges.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.databinding.ListChangeRegistry.1
 * JD-Core Version:    0.7.0.1
 */