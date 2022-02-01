import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class lid
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
            } while (lic.a() == null);
            lic.c();
            lic.a(24, lic.b());
            try
            {
              lic.a().sendEmptyMessageDelayed(1, 5000L);
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
            lic.a(i, true);
          } while (lic.a(i, true, bool));
          if ((bool) && (lic.a(33, true)))
          {
            lbj.b("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + lib.a(i));
            return false;
          }
          lic.a(i + "", l2 + "", bool);
          lic.a(i, l2, true);
          lbj.b("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + lib.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          lic.a(i, false);
        } while (lic.a(i, false, bool));
        if ((bool) && (lic.a(33, false)))
        {
          lbj.b("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + lib.a(i));
          return false;
        }
        if (lic.a(i)) {
          lbj.a("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + lib.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        lic.b(i + "", l2 + "", bool);
        lic.a(i, l2, false);
        return false;
        paramMessage = lic.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          lbj.a("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          bdkl.a(null, "dc03209", paramMessage);
          lic.e();
        }
      } while ((lic.a() == null) || (lic.a().size() == 0));
      lic.j();
      return false;
      paramMessage = lic.b();
      lbj.b("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    bdkl.a(null, "dc03209", paramMessage);
    lic.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lid
 * JD-Core Version:    0.7.0.1
 */