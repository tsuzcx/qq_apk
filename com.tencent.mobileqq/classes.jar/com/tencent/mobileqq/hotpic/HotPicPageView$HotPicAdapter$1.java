package com.tencent.mobileqq.hotpic;

import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class HotPicPageView$HotPicAdapter$1
  implements HotVideoData.HotVideoGetUrlCallBack
{
  HotPicPageView$HotPicAdapter$1(HotPicPageView.HotPicAdapter paramHotPicAdapter, HotVideoData paramHotVideoData, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, URLDrawable paramURLDrawable) {}
  
  public void a(HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult)
  {
    if (paramHotVideoGetUrlResult.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramHotVideoGetUrlResult.a();
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(this.jdField_a_of_type_ComTencentImageURLDrawable);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
        this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFileDownloadFailed:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex);
        localStringBuilder.append(" GetUrlFailed msg:");
        localStringBuilder.append(paramHotVideoGetUrlResult.jdField_a_of_type_JavaLangString);
        QLog.d("HotPicManagerHotPicPageView", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a() == this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$MyVideoViewHolder.a(-10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.HotPicAdapter.1
 * JD-Core Version:    0.7.0.1
 */