package dov.com.tencent.mobileqq.activity.richmedia;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;

class SaveVideoActivity$SaveVideoTask$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  SaveVideoActivity$SaveVideoTask$1(SaveVideoActivity.SaveVideoTask paramSaveVideoTask, PeakActivity paramPeakActivity, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakActivity, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      return;
    }
    SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity.SaveVideoTask.1
 * JD-Core Version:    0.7.0.1
 */