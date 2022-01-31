import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.report.VideoNodeConstant;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.mobileqq.statistics.DcReportUtil;
import java.util.Map;

public final class jik
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
            return false;
            VideoNodeManager.c();
            VideoNodeManager.a(24, VideoNodeManager.b());
            VideoNodeManager.a().sendEmptyMessageDelayed(1, 5000L);
            return false;
            l1 = localBundle.getLong("roomId");
            i = localBundle.getInt("node");
            l2 = localBundle.getLong("value");
            bool = localBundle.getBoolean("isNode");
            VideoNodeManager.a(i, true);
          } while (VideoNodeManager.a(i, true, bool));
          if ((bool) && (VideoNodeManager.a(33, true)))
          {
            AVLog.b("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + VideoNodeConstant.a(i));
            return false;
          }
          VideoNodeManager.a(i + "", l2 + "", bool);
          VideoNodeManager.a(i, l2, true);
          AVLog.b("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + l1 + "  node = " + VideoNodeConstant.a(i) + ", value = " + l2 + "   isNode = " + bool);
          return false;
          l1 = localBundle.getLong("roomId");
          i = localBundle.getInt("node");
          l2 = localBundle.getLong("value");
          bool = localBundle.getBoolean("isNode");
          VideoNodeManager.a(i, false);
        } while (VideoNodeManager.a(i, false, bool));
        if ((bool) && (VideoNodeManager.a(33, false)))
        {
          AVLog.b("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + VideoNodeConstant.a(i));
          return false;
        }
        if (VideoNodeManager.a(i)) {
          AVLog.a("VideoNodeManager", "reportToHandler  roomId = " + l1 + "  node = " + VideoNodeConstant.a(i) + ",  value = " + l2 + "   isNode = " + bool);
        }
        VideoNodeManager.b(i + "", l2 + "", bool);
        VideoNodeManager.a(i, l2, false);
        return false;
        paramMessage = VideoNodeManager.a();
        if (!TextUtils.isEmpty(paramMessage))
        {
          AVLog.a("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + paramMessage);
          DcReportUtil.a(null, "dc03209", paramMessage);
          VideoNodeManager.e();
        }
      } while ((VideoNodeManager.a() == null) || (VideoNodeManager.a().size() == 0));
      VideoNodeManager.j();
      return false;
      paramMessage = VideoNodeManager.b();
      AVLog.b("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + paramMessage);
    } while (TextUtils.isEmpty(paramMessage));
    DcReportUtil.a(null, "dc03209", paramMessage);
    VideoNodeManager.f();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jik
 * JD-Core Version:    0.7.0.1
 */