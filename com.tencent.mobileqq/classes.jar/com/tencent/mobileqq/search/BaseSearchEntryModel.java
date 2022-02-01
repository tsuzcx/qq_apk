package com.tencent.mobileqq.search;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseSearchEntryModel<T extends View>
{
  protected int a;
  public long b;
  public boolean c = true;
  
  public BaseSearchEntryModel(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static BaseSearchEntryModel a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 6)
          {
            if ((paramInt1 != 7) && (paramInt1 != 8))
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("createSearchEntryModel, modelType = ");
                localStringBuilder.append(paramInt1);
                localStringBuilder.append(", tabType = ");
                localStringBuilder.append(paramInt2);
                QLog.d("BaseSearchEntryModel", 2, localStringBuilder.toString());
              }
              return null;
            }
          }
          else {
            return new SearchWordHistoryEntryModel(paramInt2);
          }
        }
        else {
          return new BusinessSearchEntryModel(paramInt2, paramBoolean);
        }
      }
      return new HotWordSearchEntryModel(paramInt1, paramInt2, paramBoolean);
    }
    return new HistorySearchEntryModel(paramInt2);
  }
  
  public abstract T a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void a() {}
  
  public void a(SearchEntryDataModel paramSearchEntryDataModel) {}
  
  public void b() {}
  
  public void b(SearchEntryDataModel paramSearchEntryDataModel) {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.BaseSearchEntryModel
 * JD-Core Version:    0.7.0.1
 */