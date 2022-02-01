package com.tencent.mobileqq.troop.activity;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class TroopCreateLogicActivity$1
  implements WXShareHelper.WXShareListener
{
  TroopCreateLogicActivity$1(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a.a == null) || (!this.a.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131719291, 1).a();
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131719309, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity.1
 * JD-Core Version:    0.7.0.1
 */