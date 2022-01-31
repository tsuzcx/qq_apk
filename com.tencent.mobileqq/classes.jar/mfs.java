import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;

public class mfs
  implements DialogInterface.OnClickListener
{
  public mfs(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a != null) && (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.d()))
    {
      MultiVideoCtrlLayerUIBase.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase, true);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.e();
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.f(this.jdField_a_of_type_Long, 65535);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.a().ao = true;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfs
 * JD-Core Version:    0.7.0.1
 */