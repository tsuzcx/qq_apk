import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

class mpa
  implements View.OnClickListener
{
  mpa(moz parammoz, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onClick: " + moz.a(this.jdField_a_of_type_Moz).mChannelCoverName);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    ReadInJoyHelper.a(moz.a(this.jdField_a_of_type_Moz).mChannelCoverId, true);
    moz.a(this.jdField_a_of_type_Moz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpa
 * JD-Core Version:    0.7.0.1
 */