import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.GaInviteActivity;

public class lpz
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public lpz(GaInviteActivity paramGaInviteActivity, int paramInt)
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
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.h(true);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.d();
        break;
        if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.e) {
          this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.a.m();
        }
      }
      this.jdField_a_of_type_ComTencentAvGaudioGaInviteActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lpz
 * JD-Core Version:    0.7.0.1
 */