import android.os.SystemClock;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.GVideoGrayConfig.GVideoGrayConfigListener;
import com.tencent.av.utils.GVideoGrayConfig.GVideoPreDownloadListener;
import com.tencent.av.utils.GVideoGrayConfig.Record;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.Map;

public class kft
  extends TroopObserver
{
  public kft(GVideoGrayConfig paramGVideoGrayConfig) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong)
  {
    GVideoGrayConfig.GVideoGrayConfigListener localGVideoGrayConfigListener = (GVideoGrayConfig.GVideoGrayConfigListener)GVideoGrayConfig.a(this.a).a(paramLong);
    if (paramBoolean)
    {
      GVideoGrayConfig.a(this.a, SystemClock.elapsedRealtime());
      paramString2 = new GVideoGrayConfig.Record(SystemClock.elapsedRealtime(), paramInt3, paramString2, paramString3, paramString4);
      GVideoGrayConfig.a(this.a).put(paramString1, paramString2);
      if (localGVideoGrayConfigListener != null)
      {
        localGVideoGrayConfigListener.a(paramInt3, paramString2, paramInt5);
        GVideoGrayConfig.a(this.a).a(paramLong);
        this.a.a = paramInt4;
        if (GVideoGrayConfig.a(this.a) == null) {
          break label261;
        }
        GVideoGrayConfig.a(this.a).a(paramInt4);
        GVideoGrayConfig.a(this.a, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "onGetTroopHideWebConfig record gVideoStrategy:" + paramInt3 + " isSucc:" + paramBoolean);
      }
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoGrayConfigListener is null");
      break;
      paramString1 = (GVideoGrayConfig.GVideoGrayConfigListener)GVideoGrayConfig.a(this.a).a(paramLong);
      if (paramString1 != null)
      {
        paramString1.a(-1, null, paramInt5);
        GVideoGrayConfig.a(this.a).a(paramLong);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoGrayConfigListener is null");
      break;
      label261:
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoPreDownloadListener is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kft
 * JD-Core Version:    0.7.0.1
 */