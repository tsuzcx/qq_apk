import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;

public class ozq
  extends ReadInjoyXRecyclerView
{
  public ozq(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setData(this.a.a(), this.a.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ozq
 * JD-Core Version:    0.7.0.1
 */