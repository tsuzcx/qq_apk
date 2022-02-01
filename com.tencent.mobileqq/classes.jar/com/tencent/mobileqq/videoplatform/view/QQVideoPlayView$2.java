package com.tencent.mobileqq.videoplatform.view;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

class QQVideoPlayView$2
  implements Runnable
{
  QQVideoPlayView$2(QQVideoPlayView paramQQVideoPlayView, String paramString) {}
  
  public void run()
  {
    this.this$0.mBufferPanel.setVisibility(8);
    QQVideoPlayView.access$100(this.this$0).setVisibility(0);
    QQVideoPlayView.access$200(this.this$0).setVisibility(8);
    this.this$0.mPlayButton.setImageResource(2130850758);
    TextView localTextView = (TextView)QQVideoPlayView.access$100(this.this$0).findViewById(2131366077);
    if (localTextView != null) {
      localTextView.setText(this.val$erroText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.view.QQVideoPlayView.2
 * JD-Core Version:    0.7.0.1
 */