import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;

public class rmy
  extends RecyclerView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  
  private rmy(MultiVideoFragment paramMultiVideoFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {}
    rna.a(MultiVideoFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoFragment), new rmz(this, paramInt));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rmy
 * JD-Core Version:    0.7.0.1
 */