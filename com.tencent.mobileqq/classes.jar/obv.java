import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mqq.os.MqqHandler;

class obv
  extends BroadcastReceiver
{
  obv(obj paramobj, boolean paramBoolean, MqqHandler paramMqqHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.biz.pubaccount.scanResultData");
    int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.scanResultType", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Obj.a(str, i, 12, -1, null);
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(19);
      }
    }
    try
    {
      for (;;)
      {
        paramContext.unregisterReceiver(this.jdField_a_of_type_Obj.a);
        label65:
        this.jdField_a_of_type_Obj.a = null;
        return;
        this.jdField_a_of_type_Obj.a(str, i, 11, -1, null);
      }
    }
    catch (Exception paramContext)
    {
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obv
 * JD-Core Version:    0.7.0.1
 */