package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import java.util.ArrayList;
import java.util.List;

public abstract class FileSelectorSearchResultModel
  extends ISearchResultPositionModel
{
  protected int a;
  protected String b;
  protected Bundle c;
  
  public FileSelectorSearchResultModel(String paramString, int paramInt)
  {
    this.b = paramString;
    this.a = paramInt;
  }
  
  public List<ISearchResultModel> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return new ArrayList(0);
  }
  
  public void a(Bundle paramBundle)
  {
    this.c = paramBundle;
  }
  
  public void a(View paramView)
  {
    int i = i();
    if (i == 1)
    {
      if (paramView.getId() == 2131433103)
      {
        b(paramView);
        return;
      }
      c(paramView);
      return;
    }
    if (i > 1) {
      d(paramView);
    }
  }
  
  protected abstract void b(View paramView);
  
  protected abstract void c(View paramView);
  
  protected abstract void d(View paramView);
  
  public String g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public int i()
  {
    return 0;
  }
  
  public abstract String j();
  
  public abstract String k();
  
  public abstract int l();
  
  public abstract boolean m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultModel
 * JD-Core Version:    0.7.0.1
 */