import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mer
  implements View.OnClickListener
{
  public mer(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong, Intent paramIntent, lez paramlez) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_Lez);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mer
 * JD-Core Version:    0.7.0.1
 */