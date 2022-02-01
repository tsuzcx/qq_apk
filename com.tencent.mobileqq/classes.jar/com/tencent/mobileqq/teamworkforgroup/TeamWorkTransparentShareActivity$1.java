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
    if (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction)) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131719291);
    }
    for (;;)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTeamWorkTransparentShareActivity.a);
      return;
      QRUtils.a(2, 2131719309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity.1
 * JD-Core Version:    0.7.0.1
 */