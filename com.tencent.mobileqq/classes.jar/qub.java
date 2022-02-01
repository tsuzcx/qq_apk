import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class qub
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  qub(qua paramqua) {}
  
  public void onGlobalLayout()
  {
    if ((qua.a(this.a).isShown()) && (!qua.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      qua.a(this.a, true);
    }
    if ((!qua.a(this.a).isShown()) && (qua.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      qua.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qub
 * JD-Core Version:    0.7.0.1
 */