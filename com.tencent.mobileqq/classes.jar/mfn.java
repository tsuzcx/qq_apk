import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mfn
  implements View.OnClickListener
{
  public mfn(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong, Intent paramIntent, lfe paramlfe) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_Lfe);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mfn
 * JD-Core Version:    0.7.0.1
 */