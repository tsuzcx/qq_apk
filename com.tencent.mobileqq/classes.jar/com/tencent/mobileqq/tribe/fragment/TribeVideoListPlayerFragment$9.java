package com.tencent.mobileqq.tribe.fragment;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class TribeVideoListPlayerFragment$9
  implements Runnable
{
  TribeVideoListPlayerFragment$9(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, String paramString) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    TribeVideoListPlayerFragment.a(this.this$0).webView.callJs(this.a);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "callJsOnClicked: time = " + (l2 - l1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.9
 * JD-Core Version:    0.7.0.1
 */