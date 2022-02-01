package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.search.presenter.RichSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.rich.IRichNode;
import com.tencent.mobileqq.search.rich.RichNodeViewBase;
import com.tencent.qphone.base.util.QLog;

public class RichTemplateOneSearchResultView
  extends RichNodeViewBase
{
  private View b;
  private RichTemplateOneSearchResultView.RichTemplateSearchResultHelper c;
  
  public RichTemplateOneSearchResultView(IRichNode paramIRichNode, Context paramContext)
  {
    super(paramIRichNode, paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext).inflate(2131625853, null, false);
    this.c.a(this.b);
  }
  
  private void k()
  {
    String str = n();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("data->");
        localStringBuilder.append(str);
        QLog.e("RichTemplateOneSearchResultView", 2, localStringBuilder.toString());
      }
      this.c.a();
      this.c.a(str);
      this.c.b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RichTemplateOneSearchResultView", 2, "empty data");
    }
  }
  
  public View a(Context paramContext)
  {
    this.c = new RichTemplateOneSearchResultView.RichTemplateSearchResultHelper(paramContext);
    c(paramContext);
    k();
    return this.b;
  }
  
  public String a()
  {
    return this.c.c();
  }
  
  public void a(RichSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    this.c.a(paramOnActionListener);
  }
  
  public void j()
  {
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.RichTemplateOneSearchResultView
 * JD-Core Version:    0.7.0.1
 */