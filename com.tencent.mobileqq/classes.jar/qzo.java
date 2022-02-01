import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class qzo
  extends bkfi
{
  qzo(qzn paramqzn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.a.a.removeView(qzn.a(this.a));
      return;
    }
    catch (Exception paramAnimation)
    {
      QLog.d("BaseRIJRedPacketDialog", 2, QLog.getStackTraceString(paramAnimation));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzo
 * JD-Core Version:    0.7.0.1
 */