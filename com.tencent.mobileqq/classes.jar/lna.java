import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.GaInviteActivity;

public class lna
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public lna(GaInviteActivity paramGaInviteActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.l()) {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.g(true);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.d();
        break;
        if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.e) {
          this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.l();
        }
      }
      this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lna
 * JD-Core Version:    0.7.0.1
 */