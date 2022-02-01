import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class lhx
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
            } while (lhw.a() == null);
            lhw.c();
            lhw.a(24, lhw.b());
            try
            {
              lhw.a().sendEmptyMessageDelayed(1, 5000L);
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
            lhw.a(i, true);
          } while (lhw.a(i, true, bool));
          if ((bool) && (lhw.a(33, true)))
          {
            lba.e("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + lhv.a(i));
            return false;
          }
          lhw.a(i + "", l2 + "", bool);
          lhw.a(i, l2, true);
          lba.e("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + lhv.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          lhw.a(i, false);
        } while (lhw.a(i, false, bool));
        if ((bool) && (lhw.a(33, false)))
        {
          lba.e("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + lhv.a(i));
          return false;
        }
        if (lhw.a(i)) {
          lba.d("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + lhv.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        lhw.b(i + "", l2 + "", bool);
        lhw.a(i, l2, false);
        return false;
        paramMessage = lhw.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          lba.d("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          bcdf.a(null, "dc03209", paramMessage);
          lhw.e();
        }
      } while ((lhw.a() == null) || (lhw.a().size() == 0));
      lhw.j();
      return false;
      paramMessage = lhw.b();
      lba.e("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    bcdf.a(null, "dc03209", paramMessage);
    lhw.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhx
 * JD-Core Version:    0.7.0.1
 */