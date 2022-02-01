package cooperation.readinjoy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

public class ReadInJoyShareManager
{
  public static final boolean a(AppRuntime paramAppRuntime, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (paramBundle == null) {
      return false;
    }
    paramAppRuntime = new Intent();
    paramAppRuntime.putExtra("share_data", paramBundle);
    paramAppRuntime.putExtra("readinjoy_launch_style", 2);
    paramAppRuntime.putExtra("readinjoy_launch_source", 11);
    paramAppRuntime.putExtra("channel_id", 9999);
    ReportController.b(null, "CliOper", "", "", "0X80059F4", "0X80059F4", 0, 0, "", "", "", "");
    ReadInJoyHelper.a((Activity)paramContext, paramAppRuntime, paramInt, paramOnDismissListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyShareManager
 * JD-Core Version:    0.7.0.1
 */