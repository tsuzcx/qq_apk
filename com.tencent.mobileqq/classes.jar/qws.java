import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qws
  implements View.OnClickListener
{
  public qws(ComponentJump paramComponentJump, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    pyr.a(2, this.jdField_a_of_type_JavaLangString);
    pay.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.getContext(), this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qws
 * JD-Core Version:    0.7.0.1
 */