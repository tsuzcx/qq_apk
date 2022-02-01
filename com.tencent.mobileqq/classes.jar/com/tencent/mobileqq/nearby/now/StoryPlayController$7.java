package com.tencent.mobileqq.nearby.now;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.statistics.ReportTask;

class StoryPlayController$7
  implements Runnable
{
  StoryPlayController$7(StoryPlayController paramStoryPlayController, VideoData paramVideoData, NearbyCardManager paramNearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(this.this$0.a).a("dc00899").b("grp_lbs").c("video").d("playpage_right_slide").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long));
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyCardManager.b();
    String str2 = NowVideoReporter.jdField_a_of_type_JavaLangString;
    if (TextUtils.equals(NowVideoReporter.jdField_a_of_type_JavaLangString, "2")) {}
    for (String str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);; str1 = "")
    {
      localReportTask.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.7
 * JD-Core Version:    0.7.0.1
 */