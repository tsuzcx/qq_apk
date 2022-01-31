import android.os.Message;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class mbt
  extends TransProcessorHandler
{
  public mbt(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = (FileMsg)paramMessage.obj;
    if ((localObject1 == null) || (((FileMsg)localObject1).b != 24) || (((FileMsg)localObject1).c != 10)) {}
    while (((FileMsg)localObject1).f.equals(ReadInJoyDeliverUGCActivity.c(this.a))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1003: 
      ReadInJoyDeliverUGCActivity.f(this.a, NetConnInfoCenter.getServerTimeMillis());
      PublicAccountReportUtils.a(this.a.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(this.a)), String.valueOf(ReadInJoyDeliverUGCActivity.b(this.a)), String.valueOf(ReadInJoyDeliverUGCActivity.c(this.a) - ReadInJoyDeliverUGCActivity.d(this.a)), String.valueOf(ReadInJoyDeliverUGCActivity.e(this.a) - ReadInJoyDeliverUGCActivity.f(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send finished!");
      }
      break;
    }
    try
    {
      ReadInJoyDeliverUGCActivity.a(this.a).put("picCount", 1);
      paramMessage = new JSONArray();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("url", ((FileMsg)localObject1).i);
      ((JSONObject)localObject2).put("width", ReadInJoyDeliverUGCActivity.a(this.a).d);
      ((JSONObject)localObject2).put("height", ReadInJoyDeliverUGCActivity.a(this.a).e);
      ((JSONObject)localObject2).put("md5", ((FileMsg)localObject1).f);
      paramMessage.put(localObject2);
      ReadInJoyDeliverUGCActivity.a(this.a).put("picList", paramMessage);
      ReadInJoyDeliverUGCActivity.a(this.a, ((FileMsg)localObject1).f);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=" + ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.a(this.a).toString()));
      }
      label354:
      paramMessage = ReadInJoyLogicEngine.a();
      localObject2 = this.a.app.c();
      String str1 = ReadInJoyDeliverUGCActivity.d(this.a);
      int i = ReadInJoyDeliverUGCActivity.c(this.a);
      String str2 = ReadInJoyDeliverUGCActivity.e(this.a);
      String str3 = ((FileMsg)localObject1).i;
      int j = ReadInJoyDeliverUGCActivity.a(this.a).d;
      int k = ReadInJoyDeliverUGCActivity.a(this.a).e;
      localObject1 = ((FileMsg)localObject1).f;
      if (ReadInJoyDeliverUGCActivity.a(this.a).f == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramMessage.a((String)localObject2, str1, i, 2, str2, str3, j, k, (String)localObject1, bool, null, ReadInJoyDeliverUGCActivity.d(this.a), ReadInJoyDeliverUGCActivity.a(this.a), ReadInJoyDeliverUGCActivity.b(this.a));
        return;
      }
      ReadInJoyDeliverUGCActivity.f(this.a, NetConnInfoCenter.getServerTimeMillis());
      PublicAccountReportUtils.a(this.a.app, "", "0X800817F", "0X800817F", 0, 1, String.valueOf(ReadInJoyDeliverUGCActivity.a(this.a)), String.valueOf(ReadInJoyDeliverUGCActivity.b(this.a)), String.valueOf(ReadInJoyDeliverUGCActivity.c(this.a) - ReadInJoyDeliverUGCActivity.d(this.a)), String.valueOf(ReadInJoyDeliverUGCActivity.e(this.a) - ReadInJoyDeliverUGCActivity.f(this.a)));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send error or cancel!");
      }
      ReadInJoyDeliverUGCActivity.c(this.a, true);
      ReadInJoyDeliverUGCActivity.d(this.a);
      ReadInJoyDeliverUGCActivity.b(this.a, 1, this.a.getString(2131438908));
      ReadInJoyDeliverUGCActivity.b(this.a, 1002);
      return;
    }
    catch (Exception paramMessage)
    {
      break label354;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbt
 * JD-Core Version:    0.7.0.1
 */