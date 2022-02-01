import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ocy
  extends BroadcastReceiver
{
  ocy(ocw paramocw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.a == 1)
    {
      int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.picResultData", -1);
      paramIntent = paramIntent.getStringArrayListExtra("com.tencent.biz.pubaccount.picResult_md5s");
      this.a.a(null, 0, 13, i, paramIntent);
    }
    try
    {
      paramContext.unregisterReceiver(this.a.b);
      label50:
      this.a.b = null;
      this.a.a = 0;
      return;
    }
    catch (Exception paramContext)
    {
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ocy
 * JD-Core Version:    0.7.0.1
 */