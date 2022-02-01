package dov.com.tencent.mobileqq.activity.richmedia;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class SaveVideoActivity$SaveVideoTask$2
  extends ExecuteBinResponseCallback
{
  SaveVideoActivity$SaveVideoTask$2(SaveVideoActivity.SaveVideoTask paramSaveVideoTask, String paramString1, PeakActivity paramPeakActivity, String paramString2, String paramString3, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void onFailure(String paramString)
  {
    SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "combine music finish: " + paramBoolean);
    }
    FileUtils.e(this.jdField_a_of_type_JavaLangString);
    if (paramBoolean)
    {
      SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakActivity, this.b, this.c, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      return;
    }
    SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity.SaveVideoTask.2
 * JD-Core Version:    0.7.0.1
 */