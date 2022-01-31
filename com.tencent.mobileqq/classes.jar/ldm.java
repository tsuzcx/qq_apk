import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;

public class ldm
  implements DialogInterface.OnClickListener
{
  public ldm(VideoController paramVideoController, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("onHowling_click", this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, true, false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    if (this.b) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Mtq.d();
    }
    axqy.b(null, "CliOper", "", "", "0x8006993", "0x8006993", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ldm
 * JD-Core Version:    0.7.0.1
 */