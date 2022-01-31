package cooperation.qqreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

public class QRAioCmdReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QRAioCmdReceiver", 2, "action : " + (String)localObject + ", intent = " + paramIntent);
    }
    if ("cooperation.qqreader.aioback2reader".equals(localObject))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramIntent);
      ((Intent)localObject).putExtra("readtype", "15");
      ((Intent)localObject).setClassName(paramContext, "cooperation.qqreader.QRBridgeActivity");
      ((Intent)localObject).addFlags(268435456);
      paramContext.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.QRAioCmdReceiver
 * JD-Core Version:    0.7.0.1
 */