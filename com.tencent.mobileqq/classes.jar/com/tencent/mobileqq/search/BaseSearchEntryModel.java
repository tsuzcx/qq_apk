package com.tencent.mobileqq.search;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseSearchEntryModel
{
  public int a;
  public long a;
  
  public BaseSearchEntryModel(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static BaseSearchEntryModel a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("BaseSearchEntryModel", 2, "createSearchEntryModel, modelType = " + paramInt1 + ", tabType = " + paramInt2);
      }
      return null;
    case 0: 
      return new HistorySearchEntryModel(paramInt2);
    case 1: 
      return new HotWordSearchEntryModel(paramInt2);
    case 2: 
      return new OperationSearchEntryModel(paramInt2);
    }
    return new BusinessSearchEntryModel(paramInt2);
  }
  
  public abstract View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void a() {}
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel) {}
  
  public void b() {}
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.BaseSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */