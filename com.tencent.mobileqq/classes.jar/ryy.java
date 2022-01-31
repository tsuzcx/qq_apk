import android.content.Intent;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ryy
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null) {
      Log.e("weishi", "***onReceive request is null");
    }
    while ((!(paramIntent instanceof WeishiIntent)) || (((WeishiIntent)paramIntent).a == null)) {
      return;
    }
    ((WeishiIntent)paramIntent).a.a.a(paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      Log.e("weishi", "onSend request is null");
      return;
    }
    for (;;)
    {
      try
      {
        if ((paramIntent instanceof WeishiIntent))
        {
          ryz localryz = ((WeishiIntent)paramIntent).a;
          ryw localryw = localryz.a;
          byte[] arrayOfByte2 = localryw.encode();
          byte[] arrayOfByte1 = arrayOfByte2;
          if (arrayOfByte2 == null)
          {
            Log.e("weishi-Servlet", "onSend request encode result is null.cmd=" + localryz.a.uniKey());
            arrayOfByte1 = new byte[4];
          }
          paramPacket.setTimeout(30000L);
          Log.e("timeout", "timeout:30000");
          paramPacket.setSSOCommand("SQQzoneSvc." + localryz.a.c());
          Log.e("weishi-Servlet", "WNS命令字: " + "SQQzoneSvc." + localryz.a.c());
          localryw.d = arrayOfByte1.length;
          paramPacket.putSendData(arrayOfByte1);
          Log.i("weishi-Servlet", "onSend request cmd=" + localryz.a.uniKey() + " is correct");
          ((WeishiIntent)paramIntent).a.a.a = System.currentTimeMillis();
          return;
        }
      }
      catch (Exception paramIntent)
      {
        Log.e("weishi-Servlet", "onSend occur exception.Exception detail=" + Log.getStackTraceString(paramIntent));
        return;
      }
      Log.e("weishi-Servlet", "onSend request instanceod WeishiIntent is false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryy
 * JD-Core Version:    0.7.0.1
 */