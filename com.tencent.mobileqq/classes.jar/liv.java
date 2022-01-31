import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class liv
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
            } while (liu.a() == null);
            liu.c();
            liu.a(24, liu.b());
            try
            {
              liu.a().sendEmptyMessageDelayed(1, 5000L);
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
            liu.a(i, true);
          } while (liu.a(i, true, bool));
          if ((bool) && (liu.a(33, true)))
          {
            lcg.b("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + lit.a(i));
            return false;
          }
          liu.a(i + "", l2 + "", bool);
          liu.a(i, l2, true);
          lcg.b("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + lit.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          liu.a(i, false);
        } while (liu.a(i, false, bool));
        if ((bool) && (liu.a(33, false)))
        {
          lcg.b("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + lit.a(i));
          return false;
        }
        if (liu.a(i)) {
          lcg.a("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + lit.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        liu.b(i + "", l2 + "", bool);
        liu.a(i, l2, false);
        return false;
        paramMessage = liu.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          lcg.a("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          axpy.a(null, "dc03209", paramMessage);
          liu.e();
        }
      } while ((liu.a() == null) || (liu.a().size() == 0));
      liu.j();
      return false;
      paramMessage = liu.b();
      lcg.b("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    axpy.a(null, "dc03209", paramMessage);
    liu.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     liv
 * JD-Core Version:    0.7.0.1
 */