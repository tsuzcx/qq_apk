package com.tencent.mobileqq.pic;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class PicShareToWX$1
  implements WXShareHelper.WXShareListener
{
  PicShareToWX$1(PicShareToWX paramPicShareToWX, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "onWXShareResp resp.errCode = " + paramBaseResp.errCode + ", fromType = " + this.jdField_a_of_type_Int);
    }
    if (paramBaseResp.errCode == 0)
    {
      PicShareToWX.a(this.jdField_a_of_type_Int, true);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, true, 0, 1);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      PicShareToWX.a(this.jdField_a_of_type_Int, false);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, false, paramBaseResp.errCode, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.1
 * JD-Core Version:    0.7.0.1
 */