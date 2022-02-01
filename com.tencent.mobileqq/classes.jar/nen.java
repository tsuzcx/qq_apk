import android.os.Handler;
import com.tencent.avgame.gameroom.video.AVGameNetWorkQualityManager;
import com.tencent.qphone.base.util.QLog;

public class nen
  extends mxs
{
  public nen(AVGameNetWorkQualityManager paramAVGameNetWorkQualityManager) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameNetWorkQualityManager", 2, "onNetTypeChange, [" + paramInt1 + "-->" + paramInt2 + "]");
    }
    AVGameNetWorkQualityManager.b(this.a).removeCallbacks(AVGameNetWorkQualityManager.a(this.a));
    AVGameNetWorkQualityManager.b(this.a).post(AVGameNetWorkQualityManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nen
 * JD-Core Version:    0.7.0.1
 */