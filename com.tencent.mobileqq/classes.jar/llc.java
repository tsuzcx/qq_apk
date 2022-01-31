import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;
import com.tencent.qphone.base.util.QLog;

public final class llc
  implements CUKingCardHelper.CUKingDialogListener
{
  public llc(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void callback(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUtils", 2, "showMobileNetConfirmDlg(), on CUKingCardHelper Callback：type=" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.a.onClick(null, -1);
      return;
    }
    this.b.onClick(null, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llc
 * JD-Core Version:    0.7.0.1
 */