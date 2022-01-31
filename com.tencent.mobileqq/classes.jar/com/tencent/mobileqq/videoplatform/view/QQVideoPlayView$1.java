package com.tencent.mobileqq.videoplatform.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

class QQVideoPlayView$1
  implements View.OnClickListener
{
  QQVideoPlayView$1(QQVideoPlayView paramQQVideoPlayView) {}
  
  public void onClick(View paramView)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(QQVideoPlayView.access$000(this.this$0), 2, "mCenterPlayBtn onClick.");
    }
    this.this$0.play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.view.QQVideoPlayView.1
 * JD-Core Version:    0.7.0.1
 */