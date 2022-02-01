package com.tencent.mobileqq.kandian.biz.search.searchresult;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageButton;

class KDSearchResultFragment$2
  implements TextWatcher
{
  KDSearchResultFragment$2(KDSearchResultFragment paramKDSearchResultFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (!TextUtils.isEmpty(paramEditable.toString())))
    {
      KDSearchResultFragment.a(this.a).setVisibility(0);
      return;
    }
    KDSearchResultFragment.a(this.a).setVisibility(8);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultFragment.2
 * JD-Core Version:    0.7.0.1
 */