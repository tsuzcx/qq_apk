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
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a.getQBaseActivity() != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a.getQBaseActivity().isFinishing()) {
        return;
      }
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a, this.jdField_a_of_type_Boolean);
      DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a);
      if (QLog.isColorLevel())
      {
        String str = DrawRedpacketPannelPreviewFragment.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("---onRecog---");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a))
      {
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a).setTextColor(Color.parseColor("#00D9B5"));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a).setCompoundDrawablesWithIntrinsicBounds(R.drawable.P, 0, 0, 0);
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a).setCompoundDrawablePadding(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a.getQBaseActivity(), 5.0F));
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a).setText(HardCodeUtil.a(R.string.aB));
      }
      else
      {
        DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        if ((DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a).a(false, false) == 0)) {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a).setText("......");
        } else {
          DrawRedpacketPannelPreviewFragment.d(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a).setText(HardCodeUtil.a(R.string.at));
        }
      }
      if (DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a)) {
        DrawRedpacketPannelPreviewFragment.b(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawRedpacketPannelPreviewFragment$4.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.4.1
 * JD-Core Version:    0.7.0.1
 */