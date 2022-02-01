import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import java.util.Map;

final class lij
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
            } while (lii.a() == null);
            lii.c();
            lii.a(24, lii.b());
            try
            {
              lii.a().sendEmptyMessageDelayed(1, 5000L);
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
            lii.a(i, true);
          } while (lii.a(i, true, bool));
          if ((bool) && (lii.a(33, true)))
          {
            lbd.e("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + lih.a(i));
            return false;
          }
          lii.a(i + "", l2 + "", bool);
          lii.a(i, l2, true);
          lbd.e("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + lih.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          lii.a(i, false);
        } while (lii.a(i, false, bool));
        if ((bool) && (lii.a(33, false)))
        {
          lbd.e("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + lih.a(i));
          return false;
        }
        if (lii.a(i)) {
          lbd.d("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + lih.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        lii.b(i + "", l2 + "", bool);
        lii.a(i, l2, false);
        return false;
        paramMessage = lii.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          lbd.d("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          bdka.a(null, "dc03209", paramMessage);
          lii.e();
        }
      } while ((lii.a() == null) || (lii.a().size() == 0));
      lii.j();
      return false;
      paramMessage = lii.b();
      lbd.e("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    bdka.a(null, "dc03209", paramMessage);
    lii.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lij
 * JD-Core Version:    0.7.0.1
 */