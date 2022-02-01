package com.tencent.mobileqq.gamecenter.data;

import android.graphics.Bitmap;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class GameNoticeCenter$5
  implements ImageLoader.ImageLoadListener
{
  GameNoticeCenter$5(GameNoticeCenter paramGameNoticeCenter, TipsBar paramTipsBar) {}
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "updateGameCenterBar onImageLoaded url= " + paramString1 + ",image=" + paramBitmap);
    }
    GameNoticeCenter.access$200(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).post(new GameNoticeCenter.5.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter.5
 * JD-Core Version:    0.7.0.1
 */