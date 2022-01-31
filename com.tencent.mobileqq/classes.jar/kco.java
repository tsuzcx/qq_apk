import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.ui.VoiceChangeChooseDialog;

public class kco
  extends BroadcastReceiver
{
  public kco(VoiceChangeChooseDialog paramVoiceChangeChooseDialog) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.HEADSET_PLUG")) && (paramIntent.hasExtra("state")))
    {
      int i = paramIntent.getIntExtra("state", 0);
      paramContext = this.a;
      if (i != 1) {
        break label114;
      }
    }
    for (;;)
    {
      paramContext.jdField_a_of_type_Boolean = bool;
      if ((this.a.jdField_a_of_type_Boolean) && (VoiceChangeChooseDialog.a(this.a) == 2))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131429604);
        VoiceChangeChooseDialog.a(this.a, 0);
      }
      return;
      label114:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kco
 * JD-Core Version:    0.7.0.1
 */