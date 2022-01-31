package com.tencent.mobileqq.nearby.now.view.logic;

import android.app.Activity;
import athf;
import atjg;
import atkn;
import atky;
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
  public VideoInfoListenerImpl$1(atky paramatky) {}
  
  public void run()
  {
    if (((atky.a(this.this$0).jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)atky.a(this.this$0).jdField_a_of_type_AndroidContentContext).isFinishing())) {}
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
            } while ((atky.a(this.this$0).jdField_a_of_type_Int < 0) || (atky.a(this.this$0).jdField_a_of_type_Int >= atky.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size()));
            if (atky.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a == null) {
              break label246;
            }
            if (!atky.a(this.this$0).b) {
              break;
            }
            atky.a(this.this$0).jdField_a_of_type_Atjg.b();
          } while (!QLog.isColorLevel());
          QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          return;
          if (atky.a(this.this$0).b()) {
            break;
          }
          atky.a(this.this$0).jdField_a_of_type_Atjg.b();
        } while (!QLog.isColorLevel());
        QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
        return;
        if (atky.a(this.this$0).jdField_a_of_type_Int != atky.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size() - 1) {
          break;
        }
      } while (!(atky.a(this.this$0).a() instanceof Activity));
      ((Activity)atky.a(this.this$0).a()).finish();
      return;
      Object localObject = (VideoData)atky.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(atky.a(this.this$0).jdField_a_of_type_Int);
      ((VideoData)localObject).i = 0;
      ((VideoData)localObject).c = false;
      localObject = atky.a(this.this$0);
      ((StoryPlayController)localObject).jdField_a_of_type_Int += 1;
      if (atky.a(this.this$0).jdField_a_of_type_Int < atky.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size())
      {
        atky.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(atky.a(this.this$0).jdField_a_of_type_Int, true);
        return;
      }
    } while (!atky.a(this.this$0).jdField_a_of_type_Athf.a());
    atky.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */