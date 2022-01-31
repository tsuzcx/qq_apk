import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;

public class rhb
  implements DialogInterface.OnClickListener
{
  public rhb(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyTabFrame", 2, "showLocationChangedDialog remain cancel");
    }
    paramDialogInterface = osg.a().a();
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
    osg.a().b(41695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rhb
 * JD-Core Version:    0.7.0.1
 */