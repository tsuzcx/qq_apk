import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;

class rcb
  implements View.OnClickListener
{
  rcb(rca paramrca, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onClick: " + rca.a(this.jdField_a_of_type_Rca).mChannelCoverName);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    bgmq.a(rca.a(this.jdField_a_of_type_Rca).mChannelCoverId, true);
    rca.a(this.jdField_a_of_type_Rca);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcb
 * JD-Core Version:    0.7.0.1
 */