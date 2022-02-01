package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.QBaseActivity;

class DrawRedpacketPannelPreviewFragment$2
  implements DrawClassifier.OnClassifierInitListener
{
  DrawRedpacketPannelPreviewFragment$2(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment.getQBaseActivity() != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment.getQBaseActivity().isFinishing()) {
        return;
      }
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment).post(new DrawRedpacketPannelPreviewFragment.2.1(this, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */