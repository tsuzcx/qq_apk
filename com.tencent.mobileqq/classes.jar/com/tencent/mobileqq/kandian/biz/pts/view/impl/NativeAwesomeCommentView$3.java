package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.res.Resources;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.biz.ui.CenteredImageSpan;
import com.tencent.image.URLDrawable.DownloadListener;

class NativeAwesomeCommentView$3
  implements URLDrawable.DownloadListener
{
  NativeAwesomeCommentView$3(NativeAwesomeCommentView paramNativeAwesomeCommentView, SpannableString paramSpannableString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    CenteredImageSpan localCenteredImageSpan = new CenteredImageSpan(this.b.getResources().getDrawable(2130843797));
    this.a.setSpan(localCenteredImageSpan, 0, 1, 17);
    NativeAwesomeCommentView.b(this.b).setText(this.a);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView.3
 * JD-Core Version:    0.7.0.1
 */