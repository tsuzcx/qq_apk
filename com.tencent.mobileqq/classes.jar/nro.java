import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mqq.os.MqqHandler;

class nro
  extends BroadcastReceiver
{
  nro(nrc paramnrc, boolean paramBoolean, MqqHandler paramMqqHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.biz.pubaccount.scanResultData");
    int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.scanResultType", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Nrc.a(str, i, 12, -1, null);
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(19);
      }
    }
    try
    {
      for (;;)
      {
        paramContext.unregisterReceiver(this.jdField_a_of_type_Nrc.a);
        label65:
        this.jdField_a_of_type_Nrc.a = null;
        return;
        this.jdField_a_of_type_Nrc.a(str, i, 11, -1, null);
      }
    }
    catch (Exception paramContext)
    {
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nro
 * JD-Core Version:    0.7.0.1
 */