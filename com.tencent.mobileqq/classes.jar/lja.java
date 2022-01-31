import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class lja
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
            } while (liz.a() == null);
            liz.c();
            liz.a(24, liz.b());
            try
            {
              liz.a().sendEmptyMessageDelayed(1, 5000L);
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
            liz.a(i, true);
          } while (liz.a(i, true, bool));
          if ((bool) && (liz.a(33, true)))
          {
            lcl.b("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + liy.a(i));
            return false;
          }
          liz.a(i + "", l2 + "", bool);
          liz.a(i, l2, true);
          lcl.b("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + liy.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          liz.a(i, false);
        } while (liz.a(i, false, bool));
        if ((bool) && (liz.a(33, false)))
        {
          lcl.b("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + liy.a(i));
          return false;
        }
        if (liz.a(i)) {
          lcl.a("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + liy.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        liz.b(i + "", l2 + "", bool);
        liz.a(i, l2, false);
        return false;
        paramMessage = liz.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          lcl.a("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          axpw.a(null, "dc03209", paramMessage);
          liz.e();
        }
      } while ((liz.a() == null) || (liz.a().size() == 0));
      liz.j();
      return false;
      paramMessage = liz.b();
      lcl.b("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    axpw.a(null, "dc03209", paramMessage);
    liz.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lja
 * JD-Core Version:    0.7.0.1
 */