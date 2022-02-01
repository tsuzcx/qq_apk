package com.tencent.mobileqq.vashealth;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

class RunningBannerProcessor$3
  implements ImageLoader.ImageLoadListener
{
  RunningBannerProcessor$3(RunningBannerProcessor paramRunningBannerProcessor, Bundle paramBundle, Message paramMessage) {}
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putParcelable("icon", paramBitmap);
    BannerManager.a().a(RunningBannerProcessor.a, 2, this.jdField_a_of_type_AndroidOsMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.RunningBannerProcessor.3
 * JD-Core Version:    0.7.0.1
 */