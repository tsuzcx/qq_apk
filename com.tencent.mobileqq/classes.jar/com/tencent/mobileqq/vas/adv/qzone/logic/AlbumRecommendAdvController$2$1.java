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
    AlbumRecommendAdvController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAlbumRecommendAdvController$2.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAlbumRecommendAdvController).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAlbumRecommendAdvController$2.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAlbumRecommendAdvController.a(1, this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAlbumRecommendAdvController$2.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.recCookie);
    QZLog.i("AlbumRecomAdvInfoView", "@getGdtInfo setDataChanged onImageLoaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.2.1
 * JD-Core Version:    0.7.0.1
 */