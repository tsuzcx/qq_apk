import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class jyv
  implements Handler.Callback
{
  public jyv(PSTNC2CActivity paramPSTNC2CActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!PSTNC2CActivity.a(this.a))
      {
        this.a.a.a().f = true;
        paramMessage = this.a.a.getApp();
        Intent localIntent = new Intent(paramMessage, PSTNC2CActivity.class);
        localIntent.setFlags(268566528);
        paramMessage.startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyv
 * JD-Core Version:    0.7.0.1
 */