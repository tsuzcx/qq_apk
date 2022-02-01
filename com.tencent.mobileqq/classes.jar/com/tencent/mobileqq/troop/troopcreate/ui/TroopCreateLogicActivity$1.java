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
  
  public void a(WXShareRsp paramWXShareRsp)
  {
    if (this.a.a != null)
    {
      if (!this.a.a.equals(paramWXShareRsp.b)) {
        return;
      }
      if (paramWXShareRsp.a == ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).ERR_OK()) {
        QQToast.a(BaseApplication.getContext(), 2, 2131719027, 1).a();
      } else if (paramWXShareRsp.a != ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).ERR_USER_CANCEL()) {
        QQToast.a(BaseApplication.getContext(), 2, 2131719009, 1).a();
      }
      ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity.1
 * JD-Core Version:    0.7.0.1
 */