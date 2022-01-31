import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class kyk
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        long l1;
        int i;
        long l2;
        boolean bool;
        do
        {
          do
          {
            do
            {
              return false;
            } while (kyj.a() == null);
            kyj.c();
            kyj.a(24, kyj.b());
            try
            {
              kyj.a().sendEmptyMessageDelayed(1, 5000L);
              return false;
            }
            catch (NullPointerException paramMessage)
            {
              paramMessage.printStackTrace();
              return false;
            }
            l1 = localBundle.getLong("roomId");
            i = localBundle.getInt("node");
            l2 = localBundle.getLong("value");
            bool = localBundle.getBoolean("isNode");
            kyj.a(i, true);
          } while (kyj.a(i, true, bool));
          if ((bool) && (kyj.a(33, true)))
          {
            krx.b("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + kyi.a(i));
            return false;
          }
          kyj.a(i + "", l2 + "", bool);
          kyj.a(i, l2, true);
          krx.b("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + kyi.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          kyj.a(i, false);
        } while (kyj.a(i, false, bool));
        if ((bool) && (kyj.a(33, false)))
        {
          krx.b("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + kyi.a(i));
          return false;
        }
        if (kyj.a(i)) {
          krx.a("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + kyi.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        kyj.b(i + "", l2 + "", bool);
        kyj.a(i, l2, false);
        return false;
        paramMessage = kyj.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          krx.a("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          awpy.a(null, "dc03209", paramMessage);
          kyj.e();
        }
      } while ((kyj.a() == null) || (kyj.a().size() == 0));
      kyj.j();
      return false;
      paramMessage = kyj.b();
      krx.b("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    awpy.a(null, "dc03209", paramMessage);
    kyj.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kyk
 * JD-Core Version:    0.7.0.1
 */