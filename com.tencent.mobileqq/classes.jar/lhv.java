import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class lhv
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
            } while (lhu.a() == null);
            lhu.c();
            lhu.a(24, lhu.b());
            try
            {
              lhu.a().sendEmptyMessageDelayed(1, 5000L);
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
            lhu.a(i, true);
          } while (lhu.a(i, true, bool));
          if ((bool) && (lhu.a(33, true)))
          {
            lbc.b("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + lht.a(i));
            return false;
          }
          lhu.a(i + "", l2 + "", bool);
          lhu.a(i, l2, true);
          lbc.b("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + lht.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          lhu.a(i, false);
        } while (lhu.a(i, false, bool));
        if ((bool) && (lhu.a(33, false)))
        {
          lbc.b("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + lht.a(i));
          return false;
        }
        if (lhu.a(i)) {
          lbc.a("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + lht.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        lhu.b(i + "", l2 + "", bool);
        lhu.a(i, l2, false);
        return false;
        paramMessage = lhu.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          lbc.a("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          bcrt.a(null, "dc03209", paramMessage);
          lhu.e();
        }
      } while ((lhu.a() == null) || (lhu.a().size() == 0));
      lhu.j();
      return false;
      paramMessage = lhu.b();
      lbc.b("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    bcrt.a(null, "dc03209", paramMessage);
    lhu.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhv
 * JD-Core Version:    0.7.0.1
 */