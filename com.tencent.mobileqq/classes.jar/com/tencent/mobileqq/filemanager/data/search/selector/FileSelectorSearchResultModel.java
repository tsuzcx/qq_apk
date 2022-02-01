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
  protected Bundle a;
  protected String a;
  
  public FileSelectorSearchResultModel(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<ISearchResultModel> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return new ArrayList(0);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(View paramView)
  {
    int i = e_();
    if (i == 1)
    {
      if (paramView.getId() == 2131366781)
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
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected abstract void b(View paramView);
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract String c();
  
  protected abstract void c(View paramView);
  
  public abstract String d();
  
  protected abstract void d(View paramView);
  
  public int e_()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchResultModel
 * JD-Core Version:    0.7.0.1
 */