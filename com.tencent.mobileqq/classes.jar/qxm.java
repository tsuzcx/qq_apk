import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;

public class qxm
  extends RecyclerView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  
  private qxm(MultiVideoFragment paramMultiVideoFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {}
    qxo.a(MultiVideoFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoFragment), new qxn(this, paramInt));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    paramRecyclerView = (RelativeLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoFragment.getActivity().getWindow().getDecorView().findViewById(2131363285);
    if ((paramRecyclerView != null) && (paramRecyclerView.getVisibility() != 4)) {
      paramRecyclerView.setVisibility(4);
    }
    paramRecyclerView = (RelativeLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoFragment.getActivity().getWindow().getDecorView().findViewById(2131363286);
    if ((paramRecyclerView != null) && (paramRecyclerView.getVisibility() != 4)) {
      paramRecyclerView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxm
 * JD-Core Version:    0.7.0.1
 */