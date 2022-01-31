import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class odw
  extends osm
{
  public odw(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    super.a(paramInt1, paramLong, paramString1, paramInt2, paramString2, paramString3);
    ReadInJoyDeliverBiuActivity.b(this.a, true);
    ReadInJoyDeliverBiuActivity.b(this.a);
    QLog.d("ReadInJoyDeliverBiuActivity", 2, "onDeliverUGCResult retCode=" + paramInt1 + ", feedsId=" + paramLong + ", rowkey=" + paramString1 + ", status=" + paramInt2 + ", comment=" + paramString2);
    if (paramInt1 == 0)
    {
      bcql.a(this.a, 2, this.a.getString(2131718407), 0).b(this.a.getTitleBarHeight());
      ReadInJoyDeliverBiuActivity.e(this.a, -1);
      ReadInJoyDeliverBiuActivity.c(this.a);
      this.a.getIntent().putExtra("KEY_VIDEO_BIU_SUCCESS", true);
      this.a.finish();
      if (ReadInJoyDeliverBiuActivity.o(this.a) != 14) {
        osg.a().b(true);
      }
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (ReadInJoyDeliverBiuActivity.b(this.a))) {
        this.a.finish();
      }
      return;
      bcql.a(this.a, 1, paramString3, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    boolean bool = true;
    QLog.i("ReadInJoyDeliverBiuActivity", 1, "onBiuResult: retCode = " + paramInt + " errorMsg = " + paramString);
    ReadInJoyDeliverBiuActivity.c(this.a, true);
    ReadInJoyDeliverBiuActivity.d(this.a);
    paramLong = NetConnInfoCenter.getServerTimeMillis() - ReadInJoyDeliverBiuActivity.a(this.a);
    if (paramInt == 0)
    {
      paramString = this.a.getString(2131718407);
      if (ReadInJoyDeliverBiuActivity.g(this.a)) {
        paramString = this.a.getString(2131718400);
      }
      ReadInJoyDeliverBiuActivity.d(this.a, false);
      bcql.a(this.a, 2, paramString, 0).b(this.a.getTitleBarHeight());
      ReadInJoyDeliverBiuActivity.f(this.a, -1);
      ReadInJoyDeliverBiuActivity.c(this.a);
      this.a.getIntent().putExtra("KEY_VIDEO_BIU_SUCCESS", true);
      this.a.finish();
      if (ReadInJoyDeliverBiuActivity.o(this.a) != 14) {
        osg.a().b(true);
      }
      if (paramInt != 0) {
        break label401;
      }
    }
    for (;;)
    {
      paramString = new HashMap();
      paramString.put("param_FailCode", paramInt + "");
      paramString.put("param_FromType", ReadInJoyDeliverBiuActivity.o(this.a) + "");
      axrn.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actMultiBiuResult", bool, paramLong, 0L, paramString, "");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "doStatisticReport-->success:" + bool + ", costTime:" + paramLong + ", retcode:" + paramInt);
      }
      if (bool) {
        ReadInJoyDeliverBiuActivity.a(this.a, bool);
      }
      if ((paramInt != 0) && (ReadInJoyDeliverBiuActivity.b(this.a))) {
        this.a.finish();
      }
      return;
      bcql.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
      break;
      label401:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odw
 * JD-Core Version:    0.7.0.1
 */