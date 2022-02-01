import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;

class pyb
  implements ViewTreeObserver.OnPreDrawListener
{
  pyb(pya parampya, ReadInJoyStaticGridView paramReadInJoyStaticGridView) {}
  
  public boolean onPreDraw()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.getChildAt(0);
    Object localObject2 = new int[2];
    ((View)localObject1).getLocationOnScreen((int[])localObject2);
    localObject2 = this.jdField_a_of_type_Pya.a.a(pya.a(this.jdField_a_of_type_Pya), (int[])localObject2);
    ReadInJoyChannelPanelFragment.a(localObject2[0], 0.0F, localObject2[1], 0.0F, (View)localObject1);
    localObject1 = (ViewTreeObserver.OnPreDrawListener)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.getTag(2131376157);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)localObject1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.setTag(2131376157, null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyb
 * JD-Core Version:    0.7.0.1
 */