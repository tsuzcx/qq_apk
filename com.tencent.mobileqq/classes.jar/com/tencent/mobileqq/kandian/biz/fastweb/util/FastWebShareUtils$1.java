package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import mqq.app.MobileQQ;

class FastWebShareUtils$1
  implements WXShareHelper.WXShareListener
{
  FastWebShareUtils$1(FastWebShareUtils paramFastWebShareUtils, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (FastWebShareUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebShareUtils) != null)
    {
      if (!FastWebShareUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebUtilFastWebShareUtils).equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2) {
        if (i != 0)
        {
          QRUtils.b(1, 2131719009);
        }
        else
        {
          QRUtils.b(2, 2131719027);
          bool = true;
          break label65;
        }
      }
      boolean bool = false;
      label65:
      paramBaseResp = (AppInterface)ReadInJoyUtils.a();
      ReportUtil.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_Int, -1, false, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils.1
 * JD-Core Version:    0.7.0.1
 */