package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class ShortVideoShareUtil$7$1
  implements WXShareHelper.WXShareListener
{
  ShortVideoShareUtil$7$1(ShortVideoShareUtil.7 param7) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.a.a, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode == 0)
      {
        if (this.a.b != null) {
          this.a.b.a(true);
        }
      }
      else if (this.a.b != null) {
        this.a.b.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.7.1
 * JD-Core Version:    0.7.0.1
 */