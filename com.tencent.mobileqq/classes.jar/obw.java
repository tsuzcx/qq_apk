import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class obw
  extends BroadcastReceiver
{
  final String jdField_a_of_type_JavaLangString = "reason";
  final String b = "globalactions";
  final String c = "recentapps";
  final String d = "homekey";
  
  obw(obv paramobv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (obv.a(this.jdField_a_of_type_Obv) != null))
      {
        if (!paramContext.equals("homekey")) {
          break label55;
        }
        obv.a(this.jdField_a_of_type_Obv).a();
      }
    }
    label55:
    while (!paramContext.equals("recentapps")) {
      return;
    }
    obv.a(this.jdField_a_of_type_Obv).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obw
 * JD-Core Version:    0.7.0.1
 */