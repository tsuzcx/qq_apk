import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;

class pnu
  implements rpw
{
  pnu(pnh parampnh, View paramView, pny parampny, VideoView paramVideoView) {}
  
  public void a()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.getLocationInWindow(arrayOfInt);
    if ((arrayOfInt[0] != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.a[0]) || (arrayOfInt[1] != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.a[1]))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.a = arrayOfInt;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.c() == VideoView.b) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.b() != 3)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.c();
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
        if ((!this.jdField_a_of_type_Pny.a()) || (i + j - k < -localView1.getHeight() * 0.3D) || (m - n - i1 < -localView1.getHeight() * 0.3D)) {
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.a(false);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.c() == VideoView.b) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.b() != 5)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pnu
 * JD-Core Version:    0.7.0.1
 */