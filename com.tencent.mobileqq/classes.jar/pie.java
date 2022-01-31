import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.component.network.downloader.impl.ipc.Const.SimpleRequest;
import com.tencent.component.network.downloader.impl.ipc.DownloadSerice;

public class pie
  extends Handler
{
  public pie(DownloadSerice paramDownloadSerice) {}
  
  public void handleMessage(Message paramMessage)
  {
    Log.i("DownloadSerice", "on msg:" + paramMessage.what);
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 101: 
          super.handleMessage(paramMessage);
          return;
        }
      }
      catch (Throwable paramMessage)
      {
        Log.e("DownloadSerice", "", paramMessage);
        return;
      }
      if (paramMessage.getData() == null) {
        break;
      }
      Object localObject = paramMessage.getData();
      ((Bundle)localObject).setClassLoader(this.a.getClassLoader());
      localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
      DownloadSerice.a(this.a, (Const.SimpleRequest)localObject, paramMessage.replyTo);
      return;
      if (paramMessage.getData() == null) {
        break;
      }
      localObject = paramMessage.getData();
      ((Bundle)localObject).setClassLoader(this.a.getClassLoader());
      localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
      DownloadSerice.b(this.a, (Const.SimpleRequest)localObject, paramMessage.replyTo);
      return;
      if (paramMessage.getData() == null) {
        break;
      }
      localObject = paramMessage.getData();
      ((Bundle)localObject).setClassLoader(this.a.getClassLoader());
      localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
      DownloadSerice.c(this.a, (Const.SimpleRequest)localObject, paramMessage.replyTo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pie
 * JD-Core Version:    0.7.0.1
 */