package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class QShareUtils$3
  implements WXShareHelper.WXShareListener
{
  QShareUtils$3(QShareUtils paramQShareUtils) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (QShareUtils.a(this.a) != null)
    {
      if (!QShareUtils.a(this.a).equals(paramBaseResp.transaction)) {
        return;
      }
      boolean bool2 = false;
      int i = paramBaseResp.errCode;
      boolean bool1 = bool2;
      if (i != -2) {
        if (i != 0)
        {
          QRUtils.a(1, 2131916544);
          bool1 = bool2;
        }
        else
        {
          QRUtils.a(2, 2131916563);
          bool1 = true;
        }
      }
      ShareReport.a.a(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils.3
 * JD-Core Version:    0.7.0.1
 */