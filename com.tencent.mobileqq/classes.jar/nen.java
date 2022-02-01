import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.qphone.base.util.QLog;

public class nen
  implements bggu
{
  public nen(AVGameActivity paramAVGameActivity) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameActivity", 2, String.format("fps=%.1f", new Object[] { Double.valueOf(paramDouble) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nen
 * JD-Core Version:    0.7.0.1
 */