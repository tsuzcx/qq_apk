import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class nrh
  extends BroadcastReceiver
{
  nrh(nrc paramnrc, String paramString, boolean paramBoolean) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    double d1 = Double.parseDouble(paramIntent.getStringExtra("latitude"));
    double d2 = Double.parseDouble(paramIntent.getStringExtra("longitude"));
    paramIntent = paramIntent.getStringExtra("name");
    this.jdField_a_of_type_Nrc.a(d1, d2, paramIntent, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    try
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_Nrc.c);
      label58:
      this.jdField_a_of_type_Nrc.c = null;
      return;
    }
    catch (Exception paramContext)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nrh
 * JD-Core Version:    0.7.0.1
 */