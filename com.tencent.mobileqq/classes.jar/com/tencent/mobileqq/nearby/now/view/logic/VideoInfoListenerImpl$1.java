package com.tencent.mobileqq.nearby.now.view.logic;

import android.app.Activity;
import avcn;
import avep;
import avfw;
import avgh;
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
  public VideoInfoListenerImpl$1(avgh paramavgh) {}
  
  public void run()
  {
    if (((avgh.a(this.this$0).jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)avgh.a(this.this$0).jdField_a_of_type_AndroidContentContext).isFinishing())) {}
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
            } while ((avgh.a(this.this$0).jdField_a_of_type_Int < 0) || (avgh.a(this.this$0).jdField_a_of_type_Int >= avgh.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size()));
            if (avgh.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a == null) {
              break label246;
            }
            if (!avgh.a(this.this$0).b) {
              break;
            }
            avgh.a(this.this$0).jdField_a_of_type_Avep.b();
          } while (!QLog.isColorLevel());
          QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          return;
          if (avgh.a(this.this$0).b()) {
            break;
          }
          avgh.a(this.this$0).jdField_a_of_type_Avep.b();
        } while (!QLog.isColorLevel());
        QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
        return;
        if (avgh.a(this.this$0).jdField_a_of_type_Int != avgh.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size() - 1) {
          break;
        }
      } while (!(avgh.a(this.this$0).a() instanceof Activity));
      ((Activity)avgh.a(this.this$0).a()).finish();
      return;
      Object localObject = (VideoData)avgh.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(avgh.a(this.this$0).jdField_a_of_type_Int);
      ((VideoData)localObject).i = 0;
      ((VideoData)localObject).c = false;
      localObject = avgh.a(this.this$0);
      ((StoryPlayController)localObject).jdField_a_of_type_Int += 1;
      if (avgh.a(this.this$0).jdField_a_of_type_Int < avgh.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size())
      {
        avgh.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(avgh.a(this.this$0).jdField_a_of_type_Int, true);
        return;
      }
    } while (!avgh.a(this.this$0).jdField_a_of_type_Avcn.a());
    avgh.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */