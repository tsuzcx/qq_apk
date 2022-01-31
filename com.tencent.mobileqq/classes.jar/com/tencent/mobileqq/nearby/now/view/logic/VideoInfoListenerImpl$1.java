package com.tencent.mobileqq.nearby.now.view.logic;

import android.app.Activity;
import auye;
import avag;
import avbn;
import avby;
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
  public VideoInfoListenerImpl$1(avby paramavby) {}
  
  public void run()
  {
    if (((avby.a(this.this$0).jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)avby.a(this.this$0).jdField_a_of_type_AndroidContentContext).isFinishing())) {}
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
            } while ((avby.a(this.this$0).jdField_a_of_type_Int < 0) || (avby.a(this.this$0).jdField_a_of_type_Int >= avby.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size()));
            if (avby.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a == null) {
              break label246;
            }
            if (!avby.a(this.this$0).b) {
              break;
            }
            avby.a(this.this$0).jdField_a_of_type_Avag.b();
          } while (!QLog.isColorLevel());
          QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          return;
          if (avby.a(this.this$0).b()) {
            break;
          }
          avby.a(this.this$0).jdField_a_of_type_Avag.b();
        } while (!QLog.isColorLevel());
        QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
        return;
        if (avby.a(this.this$0).jdField_a_of_type_Int != avby.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size() - 1) {
          break;
        }
      } while (!(avby.a(this.this$0).a() instanceof Activity));
      ((Activity)avby.a(this.this$0).a()).finish();
      return;
      Object localObject = (VideoData)avby.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(avby.a(this.this$0).jdField_a_of_type_Int);
      ((VideoData)localObject).i = 0;
      ((VideoData)localObject).c = false;
      localObject = avby.a(this.this$0);
      ((StoryPlayController)localObject).jdField_a_of_type_Int += 1;
      if (avby.a(this.this$0).jdField_a_of_type_Int < avby.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size())
      {
        avby.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(avby.a(this.this$0).jdField_a_of_type_Int, true);
        return;
      }
    } while (!avby.a(this.this$0).jdField_a_of_type_Auye.a());
    avby.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */