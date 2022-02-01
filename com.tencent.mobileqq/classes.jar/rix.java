import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rix
  implements View.OnClickListener
{
  public rix(ComponentJump paramComponentJump, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    qkw.a(2, this.jdField_a_of_type_JavaLangString);
    pkh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.getContext(), this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rix
 * JD-Core Version:    0.7.0.1
 */