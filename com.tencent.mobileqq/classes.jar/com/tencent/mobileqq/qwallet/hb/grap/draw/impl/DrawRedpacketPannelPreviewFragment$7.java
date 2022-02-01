package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.qphone.base.util.QLog;

class DrawRedpacketPannelPreviewFragment$7
  implements DoodleLayout.DoodleLayoutListener
{
  DrawRedpacketPannelPreviewFragment$7(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onLineBegin---");
    }
    DrawRedpacketPannelPreviewFragment.a(this.a, false);
    DrawRedpacketPannelPreviewFragment.k(this.a);
    DrawRedpacketPannelPreviewFragment.m(this.a).setTextColor(Color.parseColor("#878B99"));
    DrawRedpacketPannelPreviewFragment.m(this.a).setText(HardCodeUtil.a(R.string.ay));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(DrawRedpacketPannelPreviewFragment.a, 2, "---onLineFinish---");
    }
    DrawRedpacketPannelPreviewFragment.q(this.a);
  }
  
  public void a(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.7
 * JD-Core Version:    0.7.0.1
 */