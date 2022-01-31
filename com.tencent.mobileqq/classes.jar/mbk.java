import com.tencent.av.ui.AVActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

public class mbk
  implements URLDrawable.URLDrawableListener
{
  public mbk(AVActivity paramAVActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    AVActivity.a(this.a, false);
    QLog.i(this.a.b, 1, "MoreBtnTips. onLoadCanceled().");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    AVActivity.a(this.a, false);
    QLog.i(this.a.b, 1, "MoreBtnTips. onLoadFialed().");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.i(this.a.b, 1, "MoreBtnTips. onLoadProgressed(). i = " + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    AVActivity.a(this.a, true);
    QLog.i(this.a.b, 1, "MoreBtnTips. onLoadSuccessed().");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbk
 * JD-Core Version:    0.7.0.1
 */