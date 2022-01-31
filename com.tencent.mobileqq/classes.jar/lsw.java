import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.random.RandomController.5;
import com.tencent.qphone.base.util.QLog;

public class lsw
  implements DialogInterface.OnClickListener
{
  public lsw(RandomController.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, " [random room owner] kick member fail because of network bad");
    }
    this.a.this$0.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsw
 * JD-Core Version:    0.7.0.1
 */