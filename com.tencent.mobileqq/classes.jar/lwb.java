import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.ui.AVActivity;
import mqq.util.WeakReference;

public class lwb
  implements DialogInterface.OnClickListener
{
  public lwb(ScreenShareCtrl paramScreenShareCtrl, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = null;
    bdla.b(null, "dc00898", "", "", "0X800B48F", "0X800B48F", this.jdField_a_of_type_Int, 0, "", "", "", "");
    if (ScreenShareCtrl.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl) != null)
    {
      paramDialogInterface = (AVActivity)ScreenShareCtrl.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl).get();
      if (paramDialogInterface != null) {
        break label95;
      }
    }
    label95:
    for (paramDialogInterface = localObject;; paramDialogInterface = paramDialogInterface.a())
    {
      if (paramDialogInterface != null)
      {
        paramDialogInterface.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a());
        paramDialogInterface.a(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl.a());
        paramDialogInterface.a();
      }
      return;
      paramDialogInterface = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lwb
 * JD-Core Version:    0.7.0.1
 */