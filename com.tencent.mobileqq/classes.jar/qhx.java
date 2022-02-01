import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class qhx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  qhx(qhw paramqhw) {}
  
  public void onGlobalLayout()
  {
    if ((qhw.a(this.a).isShown()) && (!qhw.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      qhw.a(this.a, true);
    }
    if ((!qhw.a(this.a).isShown()) && (qhw.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      qhw.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhx
 * JD-Core Version:    0.7.0.1
 */