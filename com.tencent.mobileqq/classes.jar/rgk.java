import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class rgk
  extends RecyclerView.OnScrollListener
  implements RecyclerView.OnItemTouchListener
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private rgk(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      abvl.a().a("list_video_feeds", false);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 0) || (paramInt != 1)) {
        break label91;
      }
    }
    label91:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.b = true;
        VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
      }
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (paramInt == 2)) {
        this.b = false;
      }
      this.jdField_a_of_type_Int = paramInt;
      return;
      abvl.a().a("list_video_feeds");
      break;
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).a();
    if (paramRecyclerView != null)
    {
      paramRecyclerView = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).getChildViewHolder(paramRecyclerView);
      RecyclerView.ViewHolder localViewHolder1 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).findViewHolderForLayoutPosition(paramRecyclerView.getLayoutPosition() - 1);
      RecyclerView.ViewHolder localViewHolder2 = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).findViewHolderForLayoutPosition(paramRecyclerView.getLayoutPosition() + 1);
      if ((paramRecyclerView instanceof rbl)) {
        ((rbl)paramRecyclerView).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), true);
      }
      if ((localViewHolder1 instanceof rbl)) {
        ((rbl)localViewHolder1).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), false);
      }
      if ((localViewHolder2 instanceof rbl)) {
        ((rbl)localViewHolder2).a(VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), VideoFeedsRecommendFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment), false);
      }
    }
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgk
 * JD-Core Version:    0.7.0.1
 */