package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpay.ui.R.string;

class DrawRedpacketPannelPreviewFragment$2$1
  implements Runnable
{
  DrawRedpacketPannelPreviewFragment$2$1(DrawRedpacketPannelPreviewFragment.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.b.b.getQBaseActivity() != null)
    {
      if (this.b.b.getQBaseActivity().isFinishing()) {
        return;
      }
      if (this.a)
      {
        DrawRedpacketPannelPreviewFragment.a(this.b.b).setVisibility(4);
        DrawRedpacketPannelPreviewFragment.b(this.b.b).setVisibility(4);
        DrawRedpacketPannelPreviewFragment.c(this.b.b).setVisibility(0);
        DrawRedpacketPannelPreviewFragment.d(this.b.b).setVisibility(0);
        DrawRedpacketPannelPreviewFragment.e(this.b.b).setVisibility(0);
        DrawRedpacketPannelPreviewFragment.f(this.b.b).setVisibility(0);
        TextView localTextView = DrawRedpacketPannelPreviewFragment.e(this.b.b);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("【");
        localStringBuilder.append(this.b.a);
        localStringBuilder.append("】");
        localTextView.setText(localStringBuilder.toString());
        return;
      }
      DrawRedpacketPannelPreviewFragment.a(this.b.b).setVisibility(4);
      DrawRedpacketPannelPreviewFragment.b(this.b.b).setText(HardCodeUtil.a(R.string.aE));
      DrawRedpacketPannelPreviewFragment.c(this.b.b).setVisibility(8);
      DrawRedpacketPannelPreviewFragment.d(this.b.b).setVisibility(8);
      DrawRedpacketPannelPreviewFragment.g(this.b.b).setVisibility(0);
      DrawRedpacketPannelPreviewFragment.e(this.b.b).setVisibility(4);
      DrawRedpacketPannelPreviewFragment.f(this.b.b).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.2.1
 * JD-Core Version:    0.7.0.1
 */