package com.tencent.mobileqq.msgforward;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class AIOShareActionSheet$1
  implements WXShareHelper.WXShareListener
{
  AIOShareActionSheet$1(AIOShareActionSheet paramAIOShareActionSheet) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    QLog.d("AIOShareActionSheet", 1, "WXShareResult trans:" + paramBaseResp.transaction + " ,errCode:" + paramBaseResp.errCode + " ,errStr:" + paramBaseResp.errStr);
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.1
 * JD-Core Version:    0.7.0.1
 */