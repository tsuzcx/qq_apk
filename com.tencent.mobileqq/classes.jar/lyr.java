import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.qphone.base.util.QLog;

public class lyr
  implements DialogInterface.OnClickListener
{
  public lyr(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyDeliverVideoActivity", 2, "qbShowShareResultDialog back");
      }
      ForwardSdkShareOption.a(this.a, true, "shareToQQ", ReadInJoyDeliverVideoActivity.b(this.a));
      Util.a(this.a, 0, "", "");
      this.a.finish();
      return;
    }
    ReadInJoyDeliverVideoActivity.c(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyr
 * JD-Core Version:    0.7.0.1
 */