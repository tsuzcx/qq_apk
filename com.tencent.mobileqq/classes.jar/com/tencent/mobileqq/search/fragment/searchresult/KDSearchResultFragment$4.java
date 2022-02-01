package com.tencent.mobileqq.search.fragment.searchresult;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.util.UiThreadUtil;

class KDSearchResultFragment$4
  implements ValueCallback<String>
{
  KDSearchResultFragment$4(KDSearchResultFragment paramKDSearchResultFragment) {}
  
  public void a(String paramString)
  {
    QLog.d("KDSearchResultFragment", 2, "onReceiveValue: " + paramString);
    if (!KDSearchResultFragment.a(this.a, paramString)) {
      UiThreadUtil.a(new KDSearchResultFragment.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultFragment.4
 * JD-Core Version:    0.7.0.1
 */