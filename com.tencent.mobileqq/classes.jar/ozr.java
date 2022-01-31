import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class ozr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ozr(ozq paramozq) {}
  
  public void onGlobalLayout()
  {
    if ((ozq.a(this.a).isShown()) && (!ozq.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      ozq.a(this.a, true);
    }
    if ((!ozq.a(this.a).isShown()) && (ozq.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      ozq.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozr
 * JD-Core Version:    0.7.0.1
 */