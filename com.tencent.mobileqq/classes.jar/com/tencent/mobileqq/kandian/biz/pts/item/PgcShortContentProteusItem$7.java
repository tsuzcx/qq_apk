package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.IReadInJoyListItemAutoPlayCallback;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;

class PgcShortContentProteusItem$7
  implements IReadInJoyListItemAutoPlayCallback
{
  PgcShortContentProteusItem$7(PgcShortContentProteusItem paramPgcShortContentProteusItem, View paramView, PgcShortContentProteusItem.Bool paramBool, VideoView paramVideoView) {}
  
  public void a()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.getLocationInWindow(arrayOfInt);
    if ((arrayOfInt[0] != this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.lastLocation[0]) || (arrayOfInt[1] != this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.lastLocation[1]))
    {
      VideoView localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
      localVideoView.lastLocation = arrayOfInt;
      if ((localVideoView.getPlayMode() == VideoView.PLAYMODE_AUTO) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.getAction() != 3)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.startPlay();
      }
    }
  }
  
  public boolean a()
  {
    View localView1 = (View)this.jdField_a_of_type_AndroidViewView.getParent();
    View localView2 = (View)((View)localView1.getParent()).getParent();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localView2 != null)
    {
      View localView3 = (View)localView2.getParent();
      bool1 = bool2;
      if (localView3 != null)
      {
        int i = localView1.getTop();
        int j = localView2.getTop();
        int k = localView3.getPaddingTop();
        int m = localView3.getBottom();
        int n = localView2.getTop();
        int i1 = localView1.getBottom();
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemPgcShortContentProteusItem$Bool.a())
        {
          double d1 = i + j - k;
          double d2 = -localView1.getHeight();
          Double.isNaN(d2);
          bool1 = bool2;
          if (d1 >= d2 * 0.3D)
          {
            d1 = m - n - i1;
            d2 = -localView1.getHeight();
            Double.isNaN(d2);
            bool1 = bool2;
            if (d1 >= d2 * 0.3D) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.onScrollFromList(false);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.getPlayMode() == VideoView.PLAYMODE_AUTO) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.getAction() != 6)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.7
 * JD-Core Version:    0.7.0.1
 */