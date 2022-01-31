import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mbo
  extends Handler
{
  final String a;
  
  public mbo(String paramString)
  {
    this.a = paramString;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof WeakReference)))
    {
      localObject = (WeakReference)paramMessage.obj;
      if (localObject != null)
      {
        localObject = ((WeakReference)localObject).get();
        if ((localObject == null) || (!(localObject instanceof AVLoadingDialogActivity))) {}
      }
    }
    for (Object localObject = new WeakReference((AVLoadingDialogActivity)localObject);; localObject = null)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while ((localObject == null) || (((WeakReference)localObject).get() == null));
        paramMessage = (Intent)((AVLoadingDialogActivity)((WeakReference)localObject).get()).getIntent().getParcelableExtra("avactivity_intent");
        paramMessage.setExtrasClassLoader(ResultRecord.class.getClassLoader());
        long l = mtj.a(paramMessage);
        QLog.w(this.a, 1, "avideo handleMessage MSG_START_AVACTIVITY, seq[" + l + "]");
        try
        {
          AudioHelper.a(this.a + ".MSG_START_AVACTIVITY", paramMessage.getExtras());
          ((AVLoadingDialogActivity)((WeakReference)localObject).get()).startActivity(paramMessage);
          ((AVLoadingDialogActivity)((WeakReference)localObject).get()).overridePendingTransition(2130772164, 0);
          return;
        }
        catch (Exception paramMessage)
        {
          QLog.w(this.a, 1, "MSG_START_AVACTIVITY, Exception, seq[" + l + "]", paramMessage);
          return;
        }
      } while ((localObject == null) || (((WeakReference)localObject).get() == null));
      ((AVLoadingDialogActivity)((WeakReference)localObject).get()).finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbo
 * JD-Core Version:    0.7.0.1
 */