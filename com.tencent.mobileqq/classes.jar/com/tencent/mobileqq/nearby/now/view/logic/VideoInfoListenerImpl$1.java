package com.tencent.mobileqq.nearby.now.view.logic;

import android.app.Activity;
import axwa;
import axyd;
import axzk;
import axzv;
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
  public VideoInfoListenerImpl$1(axzv paramaxzv) {}
  
  public void run()
  {
    if (((axzv.a(this.this$0).jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)axzv.a(this.this$0).jdField_a_of_type_AndroidContentContext).isFinishing())) {}
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
            } while ((axzv.a(this.this$0).jdField_a_of_type_Int < 0) || (axzv.a(this.this$0).jdField_a_of_type_Int >= axzv.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size()));
            if (axzv.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a == null) {
              break label246;
            }
            if (!axzv.a(this.this$0).b) {
              break;
            }
            axzv.a(this.this$0).jdField_a_of_type_Axyd.b();
          } while (!QLog.isColorLevel());
          QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          return;
          if (axzv.a(this.this$0).b()) {
            break;
          }
          axzv.a(this.this$0).jdField_a_of_type_Axyd.b();
        } while (!QLog.isColorLevel());
        QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
        return;
        if (axzv.a(this.this$0).jdField_a_of_type_Int != axzv.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size() - 1) {
          break;
        }
      } while (!(axzv.a(this.this$0).a() instanceof Activity));
      ((Activity)axzv.a(this.this$0).a()).finish();
      return;
      Object localObject = (VideoData)axzv.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(axzv.a(this.this$0).jdField_a_of_type_Int);
      ((VideoData)localObject).i = 0;
      ((VideoData)localObject).c = false;
      localObject = axzv.a(this.this$0);
      ((StoryPlayController)localObject).jdField_a_of_type_Int += 1;
      if (axzv.a(this.this$0).jdField_a_of_type_Int < axzv.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size())
      {
        axzv.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(axzv.a(this.this$0).jdField_a_of_type_Int, true);
        return;
      }
    } while (!axzv.a(this.this$0).jdField_a_of_type_Axwa.a());
    axzv.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */