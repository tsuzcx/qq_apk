import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class sgd
  extends TransProcessorHandler
{
  final WeakReference a;
  
  public sgd(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    Conversation localConversation = (Conversation)this.a.get();
    if (localConversation == null) {}
    do
    {
      FileMsg localFileMsg;
      int k;
      int i;
      do
      {
        do
        {
          return;
          localFileMsg = (FileMsg)paramMessage.obj;
        } while ((localConversation.a == null) || (localFileMsg == null) || (TextUtils.isEmpty(localFileMsg.p)));
        k = paramMessage.what;
        if (localFileMsg.b != 1)
        {
          i = j;
          if (localFileMsg.b != 2) {}
        }
        else if ((k != 1001) && (k != 1002) && (k != 1000) && (k != 1005))
        {
          i = j;
          if (k != 1003) {}
        }
        else
        {
          i = 1;
        }
      } while ((i == 0) && (((k != 1003) && (k != 2003)) || ((localFileMsg.b != 2) && (!localConversation.h))));
      localConversation.a(8, localFileMsg.p, -2147483648);
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "refresh recent, from_transferListener2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgd
 * JD-Core Version:    0.7.0.1
 */