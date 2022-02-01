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
    if (FastWebShareUtils.a(this.c) != null)
    {
      if (!FastWebShareUtils.a(this.c).equals(paramBaseResp.transaction)) {
        return;
      }
      int i = paramBaseResp.errCode;
      if (i != -2) {
        if (i != 0)
        {
          QRUtils.b(1, 2131916544);
        }
        else
        {
          QRUtils.b(2, 2131916563);
          bool = true;
          break label65;
        }
      }
      boolean bool = false;
      label65:
      paramBaseResp = (AppInterface)ReadInJoyUtils.b();
      ReportUtil.b(paramBaseResp.getApplication().getApplicationContext(), paramBaseResp, this.a, this.b, -1, false, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils.1
 * JD-Core Version:    0.7.0.1
 */