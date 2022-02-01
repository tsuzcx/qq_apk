package com.tencent.mobileqq.troop.troopcreate.ui;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;

class TroopCreateLogicActivity$3
  implements TroopCreateLogicActivity.OnGetBitmapCallback
{
  TroopCreateLogicActivity$3(TroopCreateLogicActivity paramTroopCreateLogicActivity, String paramString1, String paramString2, String paramString3) {}
  
  public void a(Bitmap paramBitmap)
  {
    ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).addObserver(this.d.h);
    ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).shareTroopToWXFriend(this.d.f, this.a, paramBitmap, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity.3
 * JD-Core Version:    0.7.0.1
 */