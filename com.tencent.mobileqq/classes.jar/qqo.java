import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qqo
  implements View.OnClickListener
{
  public qqo(ComponentJump paramComponentJump, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    psx.a(2, this.jdField_a_of_type_JavaLangString);
    ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.getContext(), this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqo
 * JD-Core Version:    0.7.0.1
 */