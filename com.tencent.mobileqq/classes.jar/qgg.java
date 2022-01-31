import android.view.ViewGroup;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class qgg
  extends bhnr
{
  qgg(qgf paramqgf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.a.a.removeView(qgf.a(this.a));
      return;
    }
    catch (Exception paramAnimation)
    {
      QLog.d("BaseRIJRedPacketDialog", 2, QLog.getStackTraceString(paramAnimation));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qgg
 * JD-Core Version:    0.7.0.1
 */