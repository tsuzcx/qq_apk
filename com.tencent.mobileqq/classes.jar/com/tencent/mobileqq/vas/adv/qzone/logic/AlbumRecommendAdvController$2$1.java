package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import cooperation.qzone.util.QZLog;

class AlbumRecommendAdvController$2$1
  implements Runnable
{
  AlbumRecommendAdvController$2$1(AlbumRecommendAdvController.2 param2, Drawable paramDrawable) {}
  
  public void run()
  {
    AlbumRecommendAdvController.e(this.b.b).setImageDrawable(this.a);
    this.b.b.a(1, this.b.a.recCookie);
    QZLog.i("AlbumRecomAdvInfoView", "@getGdtInfo setDataChanged onImageLoaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.2.1
 * JD-Core Version:    0.7.0.1
 */