package com.tencent.mobileqq.kandian.biz.search.searchresult;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.util.UiThreadUtil;

class KDSearchResultFragment$5
  implements ValueCallback<String>
{
  KDSearchResultFragment$5(KDSearchResultFragment paramKDSearchResultFragment) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveValue: ");
    localStringBuilder.append(paramString);
    QLog.d("KDSearchResultFragment", 2, localStringBuilder.toString());
    if (!KDSearchResultFragment.e(this.a, paramString)) {
      UiThreadUtil.a(new KDSearchResultFragment.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultFragment.5
 * JD-Core Version:    0.7.0.1
 */