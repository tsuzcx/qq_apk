import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;

final class sgv
  implements DialogInterface.OnClickListener
{
  sgv(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      bnrf.d(1);
      bnrf.a(true);
      oix.a(this.a, 9);
    }
    for (;;)
    {
      if ((this.a instanceof Activity)) {
        ((Activity)this.a).finish();
      }
      return;
      paramDialogInterface = new Intent(this.a, SplashActivity.class);
      paramDialogInterface.putExtra("fragment_id", 1);
      paramDialogInterface.putExtra("open_kandian_tab_fragment", true);
      paramDialogInterface.putExtra("arg_channel_cover_id", 0);
      paramDialogInterface.setFlags(335544320);
      this.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgv
 * JD-Core Version:    0.7.0.1
 */