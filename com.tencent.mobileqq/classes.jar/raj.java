import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class raj
  extends pfh
{
  public raj(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    QLog.d("ReadInJoyDeliverUGCActivity", 1, "onDeliverUGCResult retCode=" + paramInt1 + ", feedsId=" + paramLong + ", rowkey=" + paramString1 + ", status=" + paramInt2 + ", comment=" + paramString2 + ", errorMsg: " + paramString3);
    ReadInJoyDeliverUGCActivity.f(this.a, true);
    if (ReadInJoyDeliverUGCActivity.a(this.a) != null) {
      ReadInJoyDeliverUGCActivity.a(this.a).removeCallbacksAndMessages(null);
    }
    this.a.l();
    ReadInJoyDeliverUGCActivity.c(this.a, paramInt1);
    if (paramInt1 == 0)
    {
      ReadInJoyDeliverUGCActivity.d(this.a, 2, this.a.getString(2131717111));
      ReadInJoyDeliverUGCActivity.d(this.a, -1);
      ReadInJoyDeliverUGCActivity.g(this.a, true);
    }
    try
    {
      ReadInJoyDeliverUGCActivity.a(this.a).put("feedsId", String.valueOf(paramLong));
      ReadInJoyDeliverUGCActivity.a(this.a).put("rowkey", paramString1);
      ReadInJoyDeliverUGCActivity.a(this.a).put("status", paramInt2);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ReadInJoyDeliverUGCActivity.a(this.a).put("comment", new String(bhkv.encode(paramString1.getBytes(), 0)));
      if (ReadInJoyDeliverUGCActivity.e(this.a) != 12) {
        break label452;
      }
      ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 4);
    }
    catch (Exception paramString1)
    {
      label273:
      label294:
      label452:
      break label273;
    }
    if (ReadInJoyDeliverUGCActivity.e(this.a))
    {
      KandianSubscribeManager.a(this.a.getActivity(), 4);
      if (ReadInJoyDeliverUGCActivity.f(this.a)) {
        paramString1 = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if (!ReadInJoyDeliverUGCActivity.d(this.a)) {
          continue;
        }
        paramInt1 = 70;
        paramString1.put("channel_id", paramInt1);
        paramString1.put("rowkey", "0");
        paramString1.put("topicid", ReadInJoyDeliverUGCActivity.c(this.a));
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
        continue;
      }
      ocd.a(null, "CliOper", "", "", "0X800982D", "0X800982D", 0, 0, paramLong + "", "1", "", paramString1.toString(), false);
      if (ReadInJoyDeliverUGCActivity.f(this.a) != -1L) {
        ReadInJoyDeliverUGCActivity.h(this.a).a(ReadInJoyDeliverUGCActivity.g(this.a));
      }
      ReadInJoyDeliverUGCActivity.d(this.a);
      this.a.finish();
      return;
      if (ReadInJoyDeliverUGCActivity.e(this.a) == 13)
      {
        ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 5);
        break;
      }
      ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 4);
      break;
      pfa.a().b(true);
      break label294;
      paramInt1 = 0;
    }
    if (paramInt1 == 33)
    {
      ReadInJoyDeliverUGCActivity.e(this.a, 1, paramString3);
      return;
    }
    ReadInJoyDeliverUGCActivity.f(this.a, 1, paramString3);
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     raj
 * JD-Core Version:    0.7.0.1
 */