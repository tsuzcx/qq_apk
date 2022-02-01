import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class stw
  implements View.OnClickListener
{
  stw(stv paramstv, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onClick: " + stv.a(this.jdField_a_of_type_Stv).mChannelCoverName);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    bnrf.a(stv.a(this.jdField_a_of_type_Stv).mChannelCoverId, true);
    stv.a(this.jdField_a_of_type_Stv);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stw
 * JD-Core Version:    0.7.0.1
 */