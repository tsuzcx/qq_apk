package com.tencent.mobileqq.troop.troopcreate.ui;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import com.tencent.qphone.base.util.BaseApplication;

class TroopCreateLogicActivity$1
  implements IWXShareHelperListener
{
  TroopCreateLogicActivity$1(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  public void onWXShareResp(WXShareRsp paramWXShareRsp)
  {
    if (this.a.f != null)
    {
      if (!this.a.f.equals(paramWXShareRsp.transaction)) {
        return;
      }
      if (paramWXShareRsp.errCode == ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).ERR_OK()) {
        QQToast.makeText(BaseApplication.getContext(), 2, 2131916563, 1).show();
      } else if (paramWXShareRsp.errCode != ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).ERR_USER_CANCEL()) {
        QQToast.makeText(BaseApplication.getContext(), 2, 2131916544, 1).show();
      }
      ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity.1
 * JD-Core Version:    0.7.0.1
 */