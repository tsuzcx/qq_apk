package com.tencent.mobileqq.editor.composite;

import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.dov.story.api.IVSReporter;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qroute.QRoute;

class VideoCompositeHelper$3
  extends MusicDownloadListener
{
  private long jdField_a_of_type_Long = 0L;
  
  VideoCompositeHelper$3(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, VideoCompositeHelper.RetCode paramRetCode, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a(-3);
    this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a("task canceled");
    VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = VideoCompositeHelper.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeId:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.fakeVid);
    localStringBuilder.append(" music onStart download");
    SLog.c(paramString, localStringBuilder.toString());
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = VideoCompositeHelper.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeId:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.fakeVid);
    localStringBuilder.append(" music onStart download onFinish ");
    SLog.c((String)localObject, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (paramInt != -104)
    {
      if (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a("unknown error the music download failed");
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a(0);
        this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a("music downloadSuccess");
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a(-2);
      this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a("none network");
    }
    localObject = (IVSReporter)QRoute.api(IVSReporter.class);
    ((IVSReporter)localObject).reportPerfEvent("edit_music_download", ((IVSReporter)localObject).newPerfEntries(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$RetCode.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, FileUtils.a(paramString)));
    VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper, "needAndStartDownloadMusic");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.3
 * JD-Core Version:    0.7.0.1
 */