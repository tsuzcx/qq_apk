package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class ShortVideoShareUtil$6
  implements WXShareHelper.WXShareListener
{
  ShortVideoShareUtil$6(String paramString, ShortVideoShareUtil.OnShareCallBack paramOnShareCallBack) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label50;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowShareShortVideoShareUtil$OnShareCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowShareShortVideoShareUtil$OnShareCallBack.a(true);
      }
    }
    label50:
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowShareShortVideoShareUtil$OnShareCallBack == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowShareShortVideoShareUtil$OnShareCallBack.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.6
 * JD-Core Version:    0.7.0.1
 */