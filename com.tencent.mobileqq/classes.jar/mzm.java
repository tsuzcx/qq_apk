import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.app.FontSettingManager;

class mzm
  implements DialogInterface.OnClickListener
{
  mzm(mzl parammzl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FontSettingManager.a();
    this.a.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzm
 * JD-Core Version:    0.7.0.1
 */