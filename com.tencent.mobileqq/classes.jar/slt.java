import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;

public class slt
  implements DialogInterface.OnClickListener
{
  public slt(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyTabFrame", 2, "showLocationChangedDialog remain cancel");
    }
    paramDialogInterface = pfa.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
    pfa.a().b(41695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slt
 * JD-Core Version:    0.7.0.1
 */