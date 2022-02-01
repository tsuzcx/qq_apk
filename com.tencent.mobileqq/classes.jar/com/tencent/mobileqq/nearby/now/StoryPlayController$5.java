package com.tencent.mobileqq.nearby.now;

import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.PlayResultListener;

class StoryPlayController$5
  implements PlayResultListener
{
  StoryPlayController$5(StoryPlayController paramStoryPlayController) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int j = 1;
    int i = 1;
    if (paramInt1 != 100)
    {
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a.a;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.c()) {}
      for (;;)
      {
        QualityReporter.a(paramString1, i, String.valueOf(paramInt1), String.valueOf(paramInt2));
        return;
        i = 2;
      }
    }
    QualityReporter.e();
    paramString1 = StoryPlayController.a(this.a);
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.c()) {}
    for (paramInt1 = j;; paramInt1 = 2)
    {
      QualityReporter.a(paramString1, paramInt1, this.a.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.5
 * JD-Core Version:    0.7.0.1
 */