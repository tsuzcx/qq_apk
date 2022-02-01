package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.kandian.biz.share.ShareResultCallback;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class VideoShareUtils$1
  implements WXShareHelper.WXShareListener
{
  VideoShareUtils$1(String paramString, ShareResultCallback paramShareResultCallback) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null)
    {
      if (!str.equals(paramBaseResp.transaction)) {
        return;
      }
      boolean bool2 = false;
      BaseApplicationImpl.getContext();
      int i = paramBaseResp.errCode;
      boolean bool1 = bool2;
      if (i != -2) {
        if (i != 0)
        {
          QRUtils.b(1, 2131719009);
          bool1 = bool2;
        }
        else
        {
          QRUtils.b(2, 2131719027);
          bool1 = true;
        }
      }
      WXShareHelper.a().b(this);
      paramBaseResp = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareShareResultCallback;
      if (paramBaseResp != null) {
        paramBaseResp.a(bool1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoShareUtils.1
 * JD-Core Version:    0.7.0.1
 */