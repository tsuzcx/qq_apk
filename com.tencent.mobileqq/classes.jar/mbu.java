import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class mbu
  extends ReadInJoyObserver
{
  public mbu(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "onDeliverUGCResult retCode=" + paramInt1 + ", feedsId=" + paramLong + ", rowkey=" + paramString1 + ", status=" + paramInt2 + ", comment=" + paramString2);
    }
    ReadInJoyDeliverUGCActivity.d(this.a, true);
    ReadInJoyDeliverUGCActivity.e(this.a);
    ReadInJoyDeliverUGCActivity.b(this.a, paramInt1);
    if (paramInt1 == 0)
    {
      ReadInJoyDeliverUGCActivity.c(this.a, 2, this.a.getString(2131438907));
      ReadInJoyDeliverUGCActivity.c(this.a, -1);
      ReadInJoyDeliverUGCActivity.e(this.a, true);
      for (;;)
      {
        try
        {
          ReadInJoyDeliverUGCActivity.a(this.a).put("feedsId", String.valueOf(paramLong));
          ReadInJoyDeliverUGCActivity.a(this.a).put("rowkey", paramString1);
          ReadInJoyDeliverUGCActivity.a(this.a).put("status", paramInt2);
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = "";
          }
          ReadInJoyDeliverUGCActivity.a(this.a).put("comment", new String(Base64Util.encode(paramString1.getBytes(), 0)));
          if (ReadInJoyDeliverUGCActivity.c(this.a) != 12) {
            continue;
          }
          ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 4);
        }
        catch (Exception paramString1)
        {
          continue;
        }
        this.a.finish();
        ReadInJoyLogicEngine.a().b(true);
        return;
        if (ReadInJoyDeliverUGCActivity.c(this.a) == 13) {
          ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 5);
        }
      }
    }
    if (paramInt1 == 33)
    {
      ReadInJoyDeliverUGCActivity.d(this.a, 1, this.a.getString(2131438893));
      return;
    }
    ReadInJoyDeliverUGCActivity.e(this.a, 1, this.a.getString(2131438908));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbu
 * JD-Core Version:    0.7.0.1
 */