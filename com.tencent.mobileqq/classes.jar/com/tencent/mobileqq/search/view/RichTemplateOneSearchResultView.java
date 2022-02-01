package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.search.rich.IRichNode;
import com.tencent.mobileqq.search.rich.RichNodeViewBase;
import com.tencent.qphone.base.util.QLog;

public class RichTemplateOneSearchResultView
  extends RichNodeViewBase
{
  private View jdField_a_of_type_AndroidViewView;
  private RichTemplateOneSearchResultView.RichTemplateSearchResultHelper jdField_a_of_type_ComTencentMobileqqSearchViewRichTemplateOneSearchResultView$RichTemplateSearchResultHelper;
  
  public RichTemplateOneSearchResultView(IRichNode paramIRichNode, Context paramContext)
  {
    super(paramIRichNode, paramContext);
  }
  
  private void a()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("data->");
        localStringBuilder.append(str);
        QLog.e("RichTemplateOneSearchResultView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewRichTemplateOneSearchResultView$RichTemplateSearchResultHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqSearchViewRichTemplateOneSearchResultView$RichTemplateSearchResultHelper.a(str);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewRichTemplateOneSearchResultView$RichTemplateSearchResultHelper.b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RichTemplateOneSearchResultView", 2, "empty data");
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559810, null, false);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewRichTemplateOneSearchResultView$RichTemplateSearchResultHelper.a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public View a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewRichTemplateOneSearchResultView$RichTemplateSearchResultHelper = new RichTemplateOneSearchResultView.RichTemplateSearchResultHelper(paramContext);
    b(paramContext);
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void e()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.RichTemplateOneSearchResultView
 * JD-Core Version:    0.7.0.1
 */