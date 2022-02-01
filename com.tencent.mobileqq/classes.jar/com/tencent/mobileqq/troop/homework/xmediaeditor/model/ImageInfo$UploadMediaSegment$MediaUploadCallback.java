package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import mqq.os.MqqHandler;

class ImageInfo$UploadMediaSegment$MediaUploadCallback
  implements TroopHomeworkHelper.UploadCallback
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public ImageInfo$UploadMediaSegment$MediaUploadCallback(ImageInfo.UploadMediaSegment paramUploadMediaSegment)
  {
    int i = ImageInfo.UploadMediaSegment.a(paramUploadMediaSegment);
    if (i != 1)
    {
      if (i != 2)
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Float = 1.0F;
        return;
      }
      this.jdField_a_of_type_Int = 95;
      this.jdField_a_of_type_Float = 0.05F;
      return;
    }
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_Float = 0.85F;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment)), ", info hash=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).hashCode()), ", info status=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).f), ", progress=", Integer.valueOf(paramInt) });
    }
    long l = System.currentTimeMillis();
    paramInt = this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float * paramInt);
    if ((paramInt < 100) && (l - this.jdField_a_of_type_Long > 500L))
    {
      this.jdField_a_of_type_Long = l;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.isCanceled())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment)), ", info hash=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).hashCode()), ", info status=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).f) });
    }
    int i = ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment);
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2) {
          break label166;
        }
      }
      else
      {
        VideoInfo localVideoInfo = (VideoInfo)ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment);
        localVideoInfo.e = paramString;
        ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localVideoInfo));
        break label166;
      }
    }
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).b = paramString;
    label166:
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.isCanceled())
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment;
      ImageInfo.UploadMediaSegment.a(paramString, ImageInfo.UploadMediaSegment.a(paramString));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment).b()), ", mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment)) });
    }
    if (ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment) == 2)
    {
      ImageInfo.UploadMediaSegment localUploadMediaSegment = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment;
      ImageInfo.UploadMediaSegment.b(localUploadMediaSegment, ImageInfo.UploadMediaSegment.a(localUploadMediaSegment));
      return;
    }
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo$UploadMediaSegment, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback
 * JD-Core Version:    0.7.0.1
 */