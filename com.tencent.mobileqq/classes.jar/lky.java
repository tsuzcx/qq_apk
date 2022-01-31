import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class lky
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
            } while (lkx.a() == null);
            lkx.c();
            lkx.a(24, lkx.b());
            try
            {
              lkx.a().sendEmptyMessageDelayed(1, 5000L);
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
            lkx.a(i, true);
          } while (lkx.a(i, true, bool));
          if ((bool) && (lkx.a(33, true)))
          {
            lek.b("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + lkw.a(i));
            return false;
          }
          lkx.a(i + "", l2 + "", bool);
          lkx.a(i, l2, true);
          lek.b("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + lkw.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          lkx.a(i, false);
        } while (lkx.a(i, false, bool));
        if ((bool) && (lkx.a(33, false)))
        {
          lek.b("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + lkw.a(i));
          return false;
        }
        if (lkx.a(i)) {
          lek.a("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + lkw.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        lkx.b(i + "", l2 + "", bool);
        lkx.a(i, l2, false);
        return false;
        paramMessage = lkx.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          lek.a("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          azlj.a(null, "dc03209", paramMessage);
          lkx.e();
        }
      } while ((lkx.a() == null) || (lkx.a().size() == 0));
      lkx.j();
      return false;
      paramMessage = lkx.b();
      lek.b("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    azlj.a(null, "dc03209", paramMessage);
    lkx.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lky
 * JD-Core Version:    0.7.0.1
 */