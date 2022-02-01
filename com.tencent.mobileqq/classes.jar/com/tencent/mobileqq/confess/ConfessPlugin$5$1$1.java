package com.tencent.mobileqq.confess;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class ConfessPlugin$5$1$1
  implements WXShareHelper.WXShareListener
{
  ConfessPlugin$5$1$1(ConfessPlugin.5.1 param1) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWXShareResp resp.errCode=");
      localStringBuilder.append(paramBaseResp.errCode);
      QLog.d("ConfessPlugin", 2, localStringBuilder.toString());
    }
    int i = paramBaseResp.errCode;
    if (i != -2)
    {
      if (i != 0)
      {
        ConfessPlugin.a(this.a.g.this$0, false);
        ConfessPlugin.a(this.a.g.this$0, 1, 2131916544);
        return;
      }
      ConfessPlugin.a(this.a.g.this$0, true);
      ConfessPlugin.a(this.a.g.this$0, 2, 2131916563);
      return;
    }
    ConfessPlugin.a(this.a.g.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.5.1.1
 * JD-Core Version:    0.7.0.1
 */