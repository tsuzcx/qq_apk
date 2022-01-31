import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONObject;

public class mbx
  extends ReadInJoyObserver
{
  public mbx(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void b(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliverUpMasterResult retCode=" + paramInt1 + ", feedsId=" + paramLong + ", rowkey=" + paramString1 + ", status=" + paramInt2 + ", comment=" + paramString2);
    }
    ReadInJoyDeliverVideoActivity.b(this.a, true);
    ReadInJoyDeliverVideoActivity.a(this.a, paramInt1);
    ReadInJoyDeliverVideoActivity.b(this.a, paramInt1);
    if (paramInt1 == 0)
    {
      ReadInJoyDeliverVideoActivity.a(this.a, 100.0F);
      if (ReadInJoyDeliverVideoActivity.a(this.a))
      {
        ThreadManager.post(new mby(this), 5, null, false);
        ReadInJoyDeliverVideoActivity.a(this.a);
        ReadInJoyDeliverVideoActivity.a(this.a, -1);
        ReadInJoyDeliverVideoActivity.c(this.a, true);
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          if (!TextUtils.isEmpty(paramString2)) {
            continue;
          }
          paramString2 = "";
          localJSONObject.put("type", 4);
          localJSONObject.put("comment", new String(Base64Util.encode(paramString2.getBytes(), 0)));
          localJSONObject.put("feedsId", String.valueOf(paramLong));
          localJSONObject.put("status", paramInt2);
          localJSONObject.put("ugcVideoCoverUrl", ReadInJoyDeliverVideoActivity.a(this.a));
          localJSONObject.put("ugcVideoDuration", ReadInJoyDeliverVideoActivity.a(this.a));
          localJSONObject.put("ugcVideoRowkey", paramString1);
          localJSONObject.put("ugcVideoWidth", ReadInJoyDeliverVideoActivity.a(this.a));
          localJSONObject.put("ugcVideoHeight", ReadInJoyDeliverVideoActivity.b(this.a));
          if (ReadInJoyDeliverVideoActivity.c(this.a) != 12) {
            continue;
          }
          localJSONObject.put("feedsType", 4);
          paramString1 = localJSONObject.toString();
          this.a.getIntent().putExtra("arg_result_json", paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyDeliverVideoActivity", 2, "onDeliverUpMasterResult resultJson=" + paramString1);
          }
        }
        catch (Exception paramString1)
        {
          JSONObject localJSONObject;
          continue;
        }
        if (!ReadInJoyDeliverVideoActivity.a(this.a)) {
          this.a.finish();
        }
        ReadInJoyDeliverVideoActivity.c(this.a, 0);
        ReadInJoyLogicEngine.a().b(true);
        ReadInJoyHelper.z(this.a.app, 1);
        ReadInJoyDeliverVideoActivity.a(this.a).a(ReadInJoyDeliverVideoActivity.b(this.a));
        return;
        ReadInJoyDeliverVideoActivity.b(this.a);
        ReadInJoyDeliverVideoActivity.a(this.a, 2, this.a.getString(2131438907));
        break;
        localJSONObject.put("type", 5);
        continue;
        if (ReadInJoyDeliverVideoActivity.c(this.a) == 13) {
          localJSONObject.put("feedsType", 5);
        }
      }
    }
    if (paramInt1 == 33)
    {
      ReadInJoyDeliverVideoActivity.b(this.a);
      ReadInJoyDeliverVideoActivity.b(this.a, 1, this.a.getString(2131438893));
      ReadInJoyDeliverVideoActivity.c(this.a, 1006);
      return;
    }
    ReadInJoyDeliverVideoActivity.b(this.a);
    ReadInJoyDeliverVideoActivity.c(this.a, 1, this.a.getString(2131438908));
    ReadInJoyDeliverVideoActivity.c(this.a, 1006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbx
 * JD-Core Version:    0.7.0.1
 */