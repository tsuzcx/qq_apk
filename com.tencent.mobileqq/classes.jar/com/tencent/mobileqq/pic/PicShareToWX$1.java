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
      localStringBuilder.append(this.a);
      QLog.d("PicShareToWX", 1, localStringBuilder.toString());
    }
    if (paramBaseResp.errCode == 0)
    {
      PicShareToWX.a(this.a, true);
      PicShareToWX.a(this.b, true, 0, 1);
    }
    else
    {
      PicShareToWX.a(this.a, false);
      PicShareToWX.a(this.b, false, paramBaseResp.errCode, 1);
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.1
 * JD-Core Version:    0.7.0.1
 */