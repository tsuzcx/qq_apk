import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;

public class mgs
  implements DialogInterface.OnClickListener
{
  public mgs(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a != null) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.d()))
    {
      MultiVideoCtrlLayerUIBase.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase, true);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.e();
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.i(this.jdField_a_of_type_Long, 16777215);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.a().aq = true;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mgs
 * JD-Core Version:    0.7.0.1
 */