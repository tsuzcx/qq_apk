import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.Switch;

public class oab
  implements DialogInterface.OnKeyListener
{
  public oab(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt == 4)
    {
      ReadInJoySettingActivity.a(this.a, true);
      paramDialogInterface = ReadInJoySettingActivity.a(this.a);
      if (ReadInJoySettingActivity.a(this.a)) {
        break label53;
      }
    }
    for (;;)
    {
      paramDialogInterface.setChecked(bool);
      ReadInJoySettingActivity.a(this.a).cancel();
      return false;
      label53:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oab
 * JD-Core Version:    0.7.0.1
 */