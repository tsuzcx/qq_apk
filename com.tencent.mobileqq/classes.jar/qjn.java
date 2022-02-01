import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class qjn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  qjn(qjm paramqjm) {}
  
  public void onGlobalLayout()
  {
    if ((qjm.a(this.a).isShown()) && (!qjm.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      qjm.a(this.a, true);
    }
    if ((!qjm.a(this.a).isShown()) && (qjm.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      qjm.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjn
 * JD-Core Version:    0.7.0.1
 */