import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;

class pxy
  implements sdy
{
  pxy(pxl parampxl, View paramView, pyc parampyc, VideoView paramVideoView) {}
  
  public void a()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.getLocationInWindow(arrayOfInt);
    if ((arrayOfInt[0] != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.lastLocation[0]) || (arrayOfInt[1] != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.lastLocation[1]))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.lastLocation = arrayOfInt;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.getPlayMode() == VideoView.PLAYMODE_AUTO) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.getAction() != 3)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.startPlay();
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    View localView1 = (View)this.jdField_a_of_type_AndroidViewView.getParent();
    View localView2 = (View)((View)localView1.getParent()).getParent();
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
        if ((!this.jdField_a_of_type_Pyc.a()) || (i + j - k < -localView1.getHeight() * 0.3D) || (m - n - i1 < -localView1.getHeight() * 0.3D)) {
          break label159;
        }
      }
    }
    label159:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.onScrollFromList(false);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.getPlayMode() == VideoView.PLAYMODE_AUTO) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.getAction() != 5)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxy
 * JD-Core Version:    0.7.0.1
 */