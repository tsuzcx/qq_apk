package com.tencent.mobileqq.weiyun.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunGrayTipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.qphone.base.util.BaseApplication;

public class WeiyunGrayTipHelperImpl
  implements IWeiyunGrayTipHelper
{
  public void insertAIOGrayTips(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      Object localObject1 = (IWeiyunHelper)QRoute.api(IWeiyunHelper.class);
      Object localObject2;
      if (paramInt2 == 1127)
      {
        localObject2 = paramAppInterface.getApp().getString(2131891085);
        localObject1 = ((IWeiyunHelper)localObject1).getOpenQQVipH5(paramAppInterface.getCurrentAccountUin(), "mvip.n.a.zcwy_xht");
      }
      for (;;)
      {
        break;
        if (paramInt2 == 22000)
        {
          localObject2 = paramAppInterface.getApp().getString(2131891085);
          localObject1 = ((IWeiyunHelper)localObject1).getOpenQQVipH5(paramAppInterface.getCurrentAccountUin(), "mvip.n.a.zcwy_xht");
        }
        else if (paramInt2 == 1053)
        {
          localObject2 = paramAppInterface.getApp().getString(2131891096);
          localObject1 = ((IWeiyunHelper)localObject1).getOpenWeiyunVipH5(paramAppInterface.getCurrentAccountUin(), "qq_aio_capacity_open_vip");
        }
        else if (paramInt2 == 22081)
        {
          localObject2 = paramAppInterface.getApp().getString(2131891095);
          localObject1 = ((IWeiyunHelper)localObject1).getOpenWeiyunVipH5(paramAppInterface.getCurrentAccountUin(), "qq_aio_capacity_open_vip");
        }
        else if (paramInt2 == 22121)
        {
          localObject2 = paramAppInterface.getApp().getString(2131891094);
          localObject1 = ((IWeiyunHelper)localObject1).getOpenWeiyunBuySpaceH5();
        }
        else
        {
          localObject1 = "";
          localObject2 = localObject1;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      paramInt2 = paramString3.indexOf((String)localObject2);
      if (paramInt2 == -1) {
        return;
      }
      new Thread(new WeiyunGrayTipHelperImpl.1(this, paramAppInterface, paramString1, paramString2, paramString3, paramInt1, (String)localObject1, paramInt2, (String)localObject2)).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunGrayTipHelperImpl
 * JD-Core Version:    0.7.0.1
 */