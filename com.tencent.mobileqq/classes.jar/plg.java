import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class plg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  plg(plf paramplf) {}
  
  public void onGlobalLayout()
  {
    if ((plf.a(this.a).isShown()) && (!plf.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      plf.a(this.a, true);
    }
    if ((!plf.a(this.a).isShown()) && (plf.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      plf.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plg
 * JD-Core Version:    0.7.0.1
 */