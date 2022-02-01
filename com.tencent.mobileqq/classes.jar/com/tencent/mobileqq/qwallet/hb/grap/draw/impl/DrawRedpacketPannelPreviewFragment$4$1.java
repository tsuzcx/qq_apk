package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

class DrawRedpacketPannelPreviewFragment$4$1
  implements Runnable
{
  DrawRedpacketPannelPreviewFragment$4$1(DrawRedpacketPannelPreviewFragment.4 param4, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.b.a.getQBaseActivity() != null)
    {
      if (this.b.a.getQBaseActivity().isFinishing()) {
        return;
      }
      DrawRedpacketPannelPreviewFragment.a(this.b.a, this.a);
      DrawRedpacketPannelPreviewFragment.k(this.b.a);
      if (QLog.isColorLevel())
      {
        String str = DrawRedpacketPannelPreviewFragment.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("---onRecog---");
        localStringBuilder.append(this.a);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (DrawRedpacketPannelPreviewFragment.l(this.b.a))
      {
        DrawRedpacketPannelPreviewFragment.m(this.b.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.m(this.b.a).setCompoundDrawablesWithIntrinsicBounds(R.drawable.P, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.m(this.b.a).setCompoundDrawablePadding(DisplayUtil.a(this.b.a.getQBaseActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.m(this.b.a).setText(HardCodeUtil.a(R.string.aG));
      }
      else
      {
        DrawRedpacketPannelPreviewFragment.m(this.b.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.i(this.b.a) != null) && (DrawRedpacketPannelPreviewFragment.i(this.b.a).b(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.m(this.b.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.m(this.b.a).setText(HardCodeUtil.a(R.string.aA));
        }
      }
      if (DrawRedpacketPannelPreviewFragment.n(this.b.a)) {
        DrawRedpacketPannelPreviewFragment.o(this.b.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */