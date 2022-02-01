package com.tencent.mobileqq.mini.entry.search.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import mqq.util.WeakReference;

class MiniAppSearchFragment$SearchEditTextWatcher
  implements TextWatcher
{
  private WeakReference<SearchResultAdapter.DataChangedListener> weakReferenceListener;
  
  public MiniAppSearchFragment$SearchEditTextWatcher(SearchResultAdapter.DataChangedListener paramDataChangedListener)
  {
    this.weakReferenceListener = new WeakReference(paramDataChangedListener);
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SearchResultAdapter.DataChangedListener localDataChangedListener = (SearchResultAdapter.DataChangedListener)this.weakReferenceListener.get();
    if (localDataChangedListener != null) {
      localDataChangedListener.onTextChanged(paramCharSequence.toString());
    }
    if (!TextUtils.isEmpty(paramCharSequence)) {
      ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).sendSearchAppRequest(paramCharSequence.toString());
    }
    while (localDataChangedListener == null) {
      return;
    }
    localDataChangedListener.onResultDataChanged(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.SearchEditTextWatcher
 * JD-Core Version:    0.7.0.1
 */