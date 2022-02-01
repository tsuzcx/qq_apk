package com.tencent.mobileqq.editor.composite;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;

class VideoCompositeHelper$1
  implements Runnable
{
  VideoCompositeHelper$1(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack) {}
  
  public void run()
  {
    try
    {
      SLog.d(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "composite thread try get lock");
      try
      {
        SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "composite thread get lock and start doComposite");
        this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$VideoCompositeCallBack);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "do composite exception", localException);
      this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$VideoCompositeCallBack.a(942012, localException.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.1
 * JD-Core Version:    0.7.0.1
 */