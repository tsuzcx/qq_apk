package com.tencent.mobileqq.nearby.now;

import android.text.TextUtils;
import axup;
import ayek;
import bdlq;
import com.tencent.mobileqq.nearby.now.model.VideoData;

class StoryPlayController$7
  implements Runnable
{
  StoryPlayController$7(StoryPlayController paramStoryPlayController, VideoData paramVideoData, axup paramaxup) {}
  
  public void run()
  {
    bdlq localbdlq = new bdlq(this.this$0.a).a("dc00899").b("grp_lbs").c("video").d("playpage_right_slide").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long));
    int i = this.jdField_a_of_type_Axup.b();
    String str2 = ayek.jdField_a_of_type_JavaLangString;
    if (TextUtils.equals(ayek.jdField_a_of_type_JavaLangString, "2")) {}
    for (String str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);; str1 = "")
    {
      localbdlq.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.7
 * JD-Core Version:    0.7.0.1
 */