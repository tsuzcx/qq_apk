package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

class BannerResManager$4
  implements Runnable
{
  BannerResManager$4(BannerResManager paramBannerResManager, Bitmap paramBitmap, LoadHeadListener paramLoadHeadListener) {}
  
  public void run()
  {
    Bitmap localBitmap = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getRoundFaceBitmap(this.a);
    ThreadManager.getUIHandler().post(new BannerResManager.4.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager.4
 * JD-Core Version:    0.7.0.1
 */