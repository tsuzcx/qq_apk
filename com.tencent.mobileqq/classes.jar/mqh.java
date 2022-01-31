import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

class mqh
  implements View.OnClickListener
{
  mqh(mqg parammqg, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onClick: " + mqg.a(this.jdField_a_of_type_Mqg).mChannelCoverName);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    ReadInJoyHelper.a(mqg.a(this.jdField_a_of_type_Mqg).mChannelCoverId, true);
    mqg.a(this.jdField_a_of_type_Mqg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqh
 * JD-Core Version:    0.7.0.1
 */