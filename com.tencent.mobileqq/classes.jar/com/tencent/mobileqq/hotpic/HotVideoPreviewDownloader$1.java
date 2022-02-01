package com.tencent.mobileqq.hotpic;

import com.tencent.image.URLDrawableHandler;
import java.io.File;

class HotVideoPreviewDownloader$1
  implements HotVideoData.HotVideoGetUrlCallBack
{
  HotVideoPreviewDownloader$1(HotVideoPreviewDownloader paramHotVideoPreviewDownloader, HotVideoData paramHotVideoData, File paramFile, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void a(HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult)
  {
    if (paramHotVideoGetUrlResult.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.url = paramHotVideoGetUrlResult.a();
      HotVideoPreviewDownloader.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoPreviewDownloader, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
      return;
    }
    this.jdField_a_of_type_JavaIoFile.delete();
    paramHotVideoGetUrlResult = this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData;
    paramHotVideoGetUrlResult.onFileDownloadFailed(paramHotVideoGetUrlResult.picIndex);
    paramHotVideoGetUrlResult = this.jdField_a_of_type_ComTencentImageURLDrawableHandler;
    if (paramHotVideoGetUrlResult != null) {
      paramHotVideoGetUrlResult.onFileDownloadFailed(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData.picIndex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader.1
 * JD-Core Version:    0.7.0.1
 */