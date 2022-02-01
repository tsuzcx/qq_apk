package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class ShortVideoShareUtil$4
  implements WXShareHelper.WXShareListener
{
  ShortVideoShareUtil$4(String paramString, IShortVideoShareUtil.OnShareCallBack paramOnShareCallBack) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.a, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode == 0)
      {
        paramBaseResp = this.b;
        if (paramBaseResp != null) {
          paramBaseResp.a(true);
        }
      }
      else
      {
        paramBaseResp = this.b;
        if (paramBaseResp != null) {
          paramBaseResp.a(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.4
 * JD-Core Version:    0.7.0.1
 */