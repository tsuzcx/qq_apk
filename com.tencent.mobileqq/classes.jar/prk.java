import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class prk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  prk(prj paramprj) {}
  
  public void onGlobalLayout()
  {
    if ((prj.a(this.a).isShown()) && (!prj.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      prj.a(this.a, true);
    }
    if ((!prj.a(this.a).isShown()) && (prj.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      prj.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     prk
 * JD-Core Version:    0.7.0.1
 */