import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class plj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  plj(pli parampli) {}
  
  public void onGlobalLayout()
  {
    if ((pli.a(this.a).isShown()) && (!pli.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "resumeAnimation");
      this.a.a();
      pli.a(this.a, true);
    }
    if ((!pli.a(this.a).isShown()) && (pli.a(this.a)))
    {
      QLog.d("ReadInJoyLottieView", 2, "pauseAnimation");
      this.a.b();
      pli.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plj
 * JD-Core Version:    0.7.0.1
 */