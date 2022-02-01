package com.tencent.mobileqq.search.business.group.model;

import android.view.View;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class SearchResultGroupModelImpl
  extends ISearchResultGroupModel
{
  public int f;
  public int g;
  public int h;
  
  public int a(int paramInt)
  {
    int i;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          i = -1;
        } else {
          i = this.h;
        }
      }
      else {
        i = this.g;
      }
    }
    else {
      i = this.f;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPosition(). type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  position=");
      localStringBuilder.append(i);
      QLog.d("Q.uniteSearch.SearchResultGroupModelImpl", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        this.h = paramInt2;
        return;
      }
      this.g = paramInt2;
      return;
    }
    this.f = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(2, paramInt1);
    a(1, paramInt2);
    a(3, paramInt3);
  }
  
  public void a(View paramView) {}
  
  public List<ISearchResultModel> b()
  {
    return null;
  }
  
  public String c()
  {
    return null;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.SearchResultGroupModelImpl
 * JD-Core Version:    0.7.0.1
 */