import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class jtg
  implements Handler.Callback
{
  public jtg(CallbackWaitingActivityExt paramCallbackWaitingActivityExt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!CallbackWaitingActivityExt.a(this.a))
      {
        CallbackWaitingActivityExt.a(this.a).a().f = true;
        paramMessage = CallbackWaitingActivityExt.a(this.a).getApp();
        Intent localIntent = new Intent(paramMessage, PSTNC2CActivity.class);
        localIntent.setFlags(268566528);
        paramMessage.startActivity(localIntent);
        continue;
        CallbackWaitingActivityExt.b(this.a);
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jtg
 * JD-Core Version:    0.7.0.1
 */