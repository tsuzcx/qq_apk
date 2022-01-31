import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

class rgm
  implements View.OnLayoutChangeListener
{
  rgm(rgl paramrgl) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    VideoFeedsRecommendFragment.a(this.a.a).removeOnLayoutChangeListener(this);
    VideoFeedsRecommendFragment.a(this.a.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgm
 * JD-Core Version:    0.7.0.1
 */