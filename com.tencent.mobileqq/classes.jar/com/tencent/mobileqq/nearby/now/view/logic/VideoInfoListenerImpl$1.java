package com.tencent.mobileqq.nearby.now.view.logic;

import android.app.Activity;
import aycq;
import ayet;
import ayga;
import aygl;
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
  public VideoInfoListenerImpl$1(aygl paramaygl) {}
  
  public void run()
  {
    if (((aygl.a(this.this$0).jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)aygl.a(this.this$0).jdField_a_of_type_AndroidContentContext).isFinishing())) {}
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
            } while ((aygl.a(this.this$0).jdField_a_of_type_Int < 0) || (aygl.a(this.this$0).jdField_a_of_type_Int >= aygl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size()));
            if (aygl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a == null) {
              break label246;
            }
            if (!aygl.a(this.this$0).b) {
              break;
            }
            aygl.a(this.this$0).jdField_a_of_type_Ayet.b();
          } while (!QLog.isColorLevel());
          QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          return;
          if (aygl.a(this.this$0).b()) {
            break;
          }
          aygl.a(this.this$0).jdField_a_of_type_Ayet.b();
        } while (!QLog.isColorLevel());
        QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
        return;
        if (aygl.a(this.this$0).jdField_a_of_type_Int != aygl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size() - 1) {
          break;
        }
      } while (!(aygl.a(this.this$0).a() instanceof Activity));
      ((Activity)aygl.a(this.this$0).a()).finish();
      return;
      Object localObject = (VideoData)aygl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(aygl.a(this.this$0).jdField_a_of_type_Int);
      ((VideoData)localObject).i = 0;
      ((VideoData)localObject).c = false;
      localObject = aygl.a(this.this$0);
      ((StoryPlayController)localObject).jdField_a_of_type_Int += 1;
      if (aygl.a(this.this$0).jdField_a_of_type_Int < aygl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size())
      {
        aygl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(aygl.a(this.this$0).jdField_a_of_type_Int, true);
        return;
      }
    } while (!aygl.a(this.this$0).jdField_a_of_type_Aycq.a());
    aygl.a(this.this$0).jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */