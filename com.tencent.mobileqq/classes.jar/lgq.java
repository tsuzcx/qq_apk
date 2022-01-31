import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class lgq
  extends ReadInJoyObserver
{
  public lgq(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void c(int paramInt)
  {
    boolean bool = true;
    ReadInJoyDeliverBiuActivity.b(this.a, true);
    ReadInJoyDeliverBiuActivity.b(this.a);
    long l = NetConnInfoCenter.getServerTimeMillis() - ReadInJoyDeliverBiuActivity.a(this.a);
    if (paramInt == 0)
    {
      QQToast.a(this.a, 2, this.a.getString(2131438868), 0).b(this.a.getTitleBarHeight());
      ReadInJoyDeliverBiuActivity.e(this.a, -1);
      ReadInJoyDeliverBiuActivity.c(this.a);
      this.a.finish();
      ReadInJoyLogicEngine.a().b(true);
      if (paramInt != 0) {
        break label325;
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", paramInt + "");
      localHashMap.put("param_FromType", ReadInJoyDeliverBiuActivity.o(this.a) + "");
      StatisticCollector.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actMultiBiuResult", bool, l, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "doStatisticReport-->success:" + bool + ", costTime:" + l + ", retcode:" + paramInt);
      }
      if (bool) {
        ReadInJoyDeliverBiuActivity.a(this.a, bool);
      }
      return;
      if (paramInt == 33)
      {
        QQToast.a(this.a, 1, this.a.getString(2131438869), 0).b(this.a.getTitleBarHeight());
        break;
      }
      QQToast.a(this.a, 1, this.a.getString(2131438867), 0).b(this.a.getTitleBarHeight());
      break;
      label325:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgq
 * JD-Core Version:    0.7.0.1
 */