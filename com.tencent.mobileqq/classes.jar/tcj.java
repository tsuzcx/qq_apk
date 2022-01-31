import android.os.Bundle;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.nearby.NearbyEnterUpdateObserver;
import com.tencent.qphone.base.util.QLog;

public class tcj
  extends NearbyEnterUpdateObserver
{
  public tcj(Leba paramLeba) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "NearbyEnterUpdateObserver onReceive");
    }
    Leba.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcj
 * JD-Core Version:    0.7.0.1
 */