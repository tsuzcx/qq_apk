package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.mobileqq.search.view.RichTemplateOneSearchResultView;

class RichSearchResultPresenter$3
  implements RichSearchResultPresenter.OnActionListener
{
  RichSearchResultPresenter$3(RichSearchResultPresenter paramRichSearchResultPresenter, RichTemplateOneSearchResultView paramRichTemplateOneSearchResultView, ISearchResultPositionModel paramISearchResultPositionModel) {}
  
  public void a()
  {
    String str;
    if (TextUtils.isEmpty(this.a.a())) {
      str = String.valueOf(this.b.d());
    } else {
      str = this.a.a();
    }
    SearchReportUtil.a(this.b.ah, this.b.z(), this.b.g(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.RichSearchResultPresenter.3
 * JD-Core Version:    0.7.0.1
 */