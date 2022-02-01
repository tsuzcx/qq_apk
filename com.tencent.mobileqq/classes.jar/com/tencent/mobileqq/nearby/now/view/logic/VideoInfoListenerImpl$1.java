package com.tencent.mobileqq.nearby.now.view.logic;

import android.app.Activity;
import awpy;
import awsb;
import awti;
import awtt;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VideoInfoListenerImpl$1
  implements Runnable
{
  public VideoInfoListenerImpl$1(awtt paramawtt) {}
  
  public void run()
  {
    if (((awtt.a(this.this$0).jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)awtt.a(this.this$0).jdField_a_of_type_AndroidContentContext).isFinishing())) {}
    label35:
    label246:
    do
    {
      do
      {
        do
        {
          do
          {
            break label35;
            break label35;
            do
            {
              return;
            } while ((awtt.a(this.this$0).jdField_a_of_type_Int < 0) || (awtt.a(this.this$0).jdField_a_of_type_Int >= awtt.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size()));
            if (awtt.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a == null) {
              break label246;
            }
            if (!awtt.a(this.this$0).b) {
              break;
            }
            awtt.a(this.this$0).jdField_a_of_type_Awsb.b();
          } while (!QLog.isColorLevel());
          QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          return;
          if (awtt.a(this.this$0).b()) {
            break;
          }
          awtt.a(this.this$0).jdField_a_of_type_Awsb.b();
        } while (!QLog.isColorLevel());
        QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
        return;
        if (awtt.a(this.this$0).jdField_a_of_type_Int != awtt.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size() - 1) {
          break;
        }
      } while (!(awtt.a(this.this$0).a() instanceof Activity));
      ((Activity)awtt.a(this.this$0).a()).finish();
      return;
      Object localObject = (VideoData)awtt.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(awtt.a(this.this$0).jdField_a_of_type_Int);
      ((VideoData)localObject).i = 0;
      ((VideoData)localObject).c = false;
      localObject = awtt.a(this.this$0);
      ((StoryPlayController)localObject).jdField_a_of_type_Int += 1;
      if (awtt.a(this.this$0).jdField_a_of_type_Int < awtt.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size())
      {
        awtt.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(awtt.a(this.this$0).jdField_a_of_type_Int, true);
        return;
      }
    } while (!awtt.a(this.this$0).jdField_a_of_type_Awpy.a());
    awtt.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */