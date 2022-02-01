package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.QBaseActivity;

class DrawRedpacketPannelPreviewFragment$2
  implements DrawClassifier.OnClassifierInitListener
{
  DrawRedpacketPannelPreviewFragment$2(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.b.getQBaseActivity() != null)
    {
      if (this.b.getQBaseActivity().isFinishing()) {
        return;
      }
      DrawRedpacketPannelPreviewFragment.h(this.b).post(new DrawRedpacketPannelPreviewFragment.2.1(this, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */