package com.tencent.mobileqq.search.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class RichTemplateOneSearchResultView$RichTemplateSearchResultHelper$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  RichTemplateOneSearchResultView$RichTemplateSearchResultHelper$1(RichTemplateOneSearchResultView.RichTemplateSearchResultHelper paramRichTemplateSearchResultHelper) {}
  
  public void onGlobalLayout()
  {
    if (RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.a(this.a).getWidth() / 2.3F));
        RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.1
 * JD-Core Version:    0.7.0.1
 */