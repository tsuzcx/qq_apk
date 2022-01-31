import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class lbw
  implements Runnable
{
  public lbw(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    int i = 1;
    long l1;
    Object localObject1;
    if ((this.a.msgtype == -2011) && (!this.a.isSend()))
    {
      l1 = System.currentTimeMillis();
      localStructMsgItemVideo = PAVideoStructMsgUtil.a(this.a);
      if (localStructMsgItemVideo != null) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("vid", localStructMsgItemVideo.w);
        ((JSONObject)localObject2).put("os", "1");
        if (!MsgProxyUtils.c(this.a.istroop)) {
          continue;
        }
        ((JSONObject)localObject2).put("aiotype", i);
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        long l2;
        localException.printStackTrace();
        continue;
        String str = localStructMsgItemVideo.B;
        continue;
      }
      if (localStructMsgItemVideo.B != null) {
        continue;
      }
      localObject2 = "0";
      PublicAccountReportUtils.a(null, "", "0X80077DF", "0X80077DF", 0, 0, "0", "2", (String)localObject2, (String)localObject1, false);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoReporter", 2, "reportVideoStructMsgRecv cost = " + (l2 - l1) + "ms");
      }
      return;
      if (this.a.istroop == 1)
      {
        i = 2;
      }
      else
      {
        i = this.a.istroop;
        if (i == 3000) {
          i = 3;
        } else {
          i = 4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbw
 * JD-Core Version:    0.7.0.1
 */