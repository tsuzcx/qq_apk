package cooperation.vip.webview.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qzone.util.QZLog;

class BaseTranslucentController$1
  extends BroadcastReceiver
{
  BaseTranslucentController$1(BaseTranslucentController paramBaseTranslucentController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = paramIntent.getAction();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reveiver action = ");
      localStringBuilder.append(paramContext);
      QZLog.i("BaseTranslucentControll", 4, localStringBuilder.toString());
      this.a.a(paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
      QZLog.e("BaseTranslucentControll", "onReceive error", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.webview.controller.BaseTranslucentController.1
 * JD-Core Version:    0.7.0.1
 */