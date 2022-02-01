package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class TeamWorkTransparentShareActivity$1
  implements WXShareHelper.WXShareListener
{
  TeamWorkTransparentShareActivity$1(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity, String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!this.a.equals(paramBaseResp.transaction)) {
      return;
    }
    BaseApplicationImpl.getContext();
    int i = paramBaseResp.errCode;
    if (i != -2) {
      if (i != 0) {
        QRUtils.a(1, 2131916544);
      } else {
        QRUtils.a(2, 2131916563);
      }
    }
    WXShareHelper.a().b(this.b.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity.1
 * JD-Core Version:    0.7.0.1
 */