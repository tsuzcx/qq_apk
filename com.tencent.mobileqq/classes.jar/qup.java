import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;

public class qup
  implements DialogInterface.OnClickListener
{
  public qup(ReadinjoyTabFrame paramReadinjoyTabFrame, SelectPositionModule.PositionData paramPositionData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyTabFrame", 2, "showLocationChangedDialog change confirm");
    }
    paramDialogInterface = ogy.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
    }
    paramDialogInterface = ogy.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.b(41695);
    }
    ogy.a().a(41695, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city);
    ohb.a().g(41695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qup
 * JD-Core Version:    0.7.0.1
 */