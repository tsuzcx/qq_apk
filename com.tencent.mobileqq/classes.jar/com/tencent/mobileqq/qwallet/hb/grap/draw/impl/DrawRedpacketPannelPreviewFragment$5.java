package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.widget.TextView;

class DrawRedpacketPannelPreviewFragment$5
  implements Runnable
{
  DrawRedpacketPannelPreviewFragment$5(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (this.this$0.a.getVisibility() != 0) {
        this.this$0.a.setVisibility(0);
      }
      TextView localTextView = this.this$0.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("当前识别结果：---- 当前识别成功阈值：");
      localStringBuilder.append(DrawClassifier.a().a);
      localStringBuilder.append("\n");
      localStringBuilder.append(this.a);
      localTextView.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */