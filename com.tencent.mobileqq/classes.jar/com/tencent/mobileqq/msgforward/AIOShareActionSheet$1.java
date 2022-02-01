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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WXShareResult trans:");
    localStringBuilder.append(paramBaseResp.transaction);
    localStringBuilder.append(" ,errCode:");
    localStringBuilder.append(paramBaseResp.errCode);
    localStringBuilder.append(" ,errStr:");
    localStringBuilder.append(paramBaseResp.errStr);
    QLog.d("AIOShareActionSheet", 1, localStringBuilder.toString());
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgforward.AIOShareActionSheet.1
 * JD-Core Version:    0.7.0.1
 */