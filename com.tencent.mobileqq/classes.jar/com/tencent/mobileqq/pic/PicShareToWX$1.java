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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWXShareResp resp.errCode = ");
      localStringBuilder.append(paramBaseResp.errCode);
      localStringBuilder.append(", fromType = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("PicShareToWX", 1, localStringBuilder.toString());
    }
    if (paramBaseResp.errCode == 0)
    {
      PicShareToWX.a(this.jdField_a_of_type_Int, true);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, true, 0, 1);
    }
    else
    {
      PicShareToWX.a(this.jdField_a_of_type_Int, false);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, false, paramBaseResp.errCode, 1);
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.1
 * JD-Core Version:    0.7.0.1
 */