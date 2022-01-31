import android.os.Handler;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.qphone.base.util.QLog;

public class tcd
  extends NearbyObserver
{
  public tcd(NearbyActivity paramNearbyActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.heart_beat", 2, "onNearbyHeartBeat:isSucc=" + paramBoolean + ", cmd=" + paramString + ", interval=" + paramLong);
    }
    if ("OidbSvc.0xafc_1".equals(paramString))
    {
      if (paramBoolean) {
        this.a.n = paramLong;
      }
      if (!this.a.c)
      {
        this.a.b.removeMessages(this.a.d);
        this.a.b.sendEmptyMessageDelayed(this.a.d, this.a.n);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcd
 * JD-Core Version:    0.7.0.1
 */