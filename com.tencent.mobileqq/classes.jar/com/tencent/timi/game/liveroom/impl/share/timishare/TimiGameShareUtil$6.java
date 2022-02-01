package com.tencent.timi.game.liveroom.impl.share.timishare;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.timi.game.ui.widget.CustomToastView;

final class TimiGameShareUtil$6
  implements WXShareHelper.WXShareListener
{
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    int i = paramBaseResp.errCode;
    if ((i != -2) && (i != 0)) {
      CustomToastView.a(2131916544);
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.timishare.TimiGameShareUtil.6
 * JD-Core Version:    0.7.0.1
 */