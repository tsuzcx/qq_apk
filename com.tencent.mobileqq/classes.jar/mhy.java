import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.ViewHolder;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

public class mhy
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  public mhy(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt, ReadInJoyBaseAdapter.ViewHolder paramViewHolder, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList paramArrayList, Object paramObject)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.k();
      ((Animation)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$ViewHolder.f.getTag(2131362291)).setAnimationListener(new mhz(this, paramArrayList, paramObject));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$ViewHolder.f.startAnimation((Animation)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$ViewHolder.f.getTag(2131362291));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhy
 * JD-Core Version:    0.7.0.1
 */