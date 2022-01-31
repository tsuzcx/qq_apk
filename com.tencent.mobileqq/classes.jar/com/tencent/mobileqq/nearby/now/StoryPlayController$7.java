package com.tencent.mobileqq.nearby.now;

import android.text.TextUtils;
import aszf;
import atix;
import axrc;
import com.tencent.mobileqq.nearby.now.model.VideoData;

class StoryPlayController$7
  implements Runnable
{
  StoryPlayController$7(StoryPlayController paramStoryPlayController, VideoData paramVideoData, aszf paramaszf) {}
  
  public void run()
  {
    axrc localaxrc = new axrc(this.this$0.a).a("dc00899").b("grp_lbs").c("video").d("playpage_right_slide").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long));
    int i = this.jdField_a_of_type_Aszf.b();
    String str2 = atix.jdField_a_of_type_JavaLangString;
    if (TextUtils.equals(atix.jdField_a_of_type_JavaLangString, "2")) {}
    for (String str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);; str1 = "")
    {
      localaxrc.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.7
 * JD-Core Version:    0.7.0.1
 */