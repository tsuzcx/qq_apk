package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class ShortVideoShareUtil$7$2
  implements WXShareHelper.WXShareListener
{
  ShortVideoShareUtil$7$2(ShortVideoShareUtil.7 param7) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label59;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowShareShortVideoShareUtil$OnShareCallBack != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowShareShortVideoShareUtil$OnShareCallBack.a(true);
      }
    }
    label59:
    while (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowShareShortVideoShareUtil$OnShareCallBack == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowShareShortVideoShareUtil$OnShareCallBack.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.7.2
 * JD-Core Version:    0.7.0.1
 */