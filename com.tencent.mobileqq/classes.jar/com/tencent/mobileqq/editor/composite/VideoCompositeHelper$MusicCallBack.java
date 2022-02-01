package com.tencent.mobileqq.editor.composite;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;

@TargetApi(14)
public class VideoCompositeHelper$MusicCallBack
  extends ExecuteBinResponseCallback
{
  private int jdField_a_of_type_Int = 941000;
  private long jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  private VideoCompositeHelper.VideoCompositeCallBack jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$VideoCompositeCallBack;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public VideoCompositeHelper$MusicCallBack(String paramString1, String paramString2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$VideoCompositeCallBack = paramVideoCompositeCallBack;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onFailure(String paramString)
  {
    if (paramString.equals(String.valueOf(941001))) {
      this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$VideoCompositeCallBack.a(941001, paramString, "");
    } else if (paramString.equals(String.valueOf(941002))) {
      this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$VideoCompositeCallBack.a(941002, paramString, "");
    } else {
      this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$VideoCompositeCallBack.a(this.jdField_a_of_type_Int, paramString, "");
    }
    SLog.d(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "combine audio fail %s, %d", new Object[] { paramString, Integer.valueOf(this.jdField_a_of_type_Int) });
    FileUtils.g(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(String paramString)
  {
    SLog.a(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqEditorCompositeVideoCompositeHelper$VideoCompositeCallBack.a(0, "", this.b);
    FileUtils.g(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.MusicCallBack
 * JD-Core Version:    0.7.0.1
 */