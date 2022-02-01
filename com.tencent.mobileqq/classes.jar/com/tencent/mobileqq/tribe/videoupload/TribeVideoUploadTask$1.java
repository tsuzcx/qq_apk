package com.tencent.mobileqq.tribe.videoupload;

import com.tencent.biz.qqstory.base.videoupload.UploadResult;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;

class TribeVideoUploadTask$1
  implements UploadObject.UploadFinishListener
{
  TribeVideoUploadTask$1(TribeVideoUploadTask paramTribeVideoUploadTask, TribeVideoTaskInfo paramTribeVideoTaskInfo) {}
  
  public void a(UploadObject paramUploadObject)
  {
    paramUploadObject = (TribeVideoFileObject)paramUploadObject;
    this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoTaskInfo.b = paramUploadObject.a.c;
    this.jdField_a_of_type_ComTencentMobileqqTribeVideouploadTribeVideoTaskInfo.c = paramUploadObject.a.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.videoupload.TribeVideoUploadTask.1
 * JD-Core Version:    0.7.0.1
 */