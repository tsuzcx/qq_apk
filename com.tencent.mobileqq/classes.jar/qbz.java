import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class qbz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  qbz(qby paramqby) {}
  
  public void onGlobalLayout()
  {
    if ((qby.a(this.a).isShown()) && (!qby.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      qby.a(this.a, true);
    }
    if ((!qby.a(this.a).isShown()) && (qby.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      qby.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbz
 * JD-Core Version:    0.7.0.1
 */