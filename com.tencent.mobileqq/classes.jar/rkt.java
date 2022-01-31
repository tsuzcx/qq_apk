import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastImageViewCreator.ImageViewHolder.1.1;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class rkt
  implements URLDrawableDownListener
{
  rkt(rks paramrks) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    QLog.d("Q.readinjoy.fast_web", 2, " onLoadFailed: " + paramURLDrawable.getURL().toString() + " retryCnt: " + rks.a(this.a));
    paramThrowable = (ImageData)this.a.a;
    boolean bool = rkr.a(paramURLDrawable.getURL().getFile());
    if (bool) {}
    for (paramView = rkr.a(paramThrowable.jdField_a_of_type_JavaLangString, paramThrowable);; paramView = paramThrowable.jdField_a_of_type_JavaLangString)
    {
      paramView = sfa.a(paramView, 4);
      if ((paramView == null) || (!paramView.equals(paramURLDrawable.getURL()))) {
        break;
      }
      if (rks.b(this.a) < 2) {
        rks.c(this.a);
      }
      rks.d(this.a);
      if ((bool) && (rks.a(this.a) < 3))
      {
        paramThrowable.jdField_a_of_type_Boolean = false;
        ThreadManager.getUIHandler().post(new WebFastImageViewCreator.ImageViewHolder.1.1(this, paramThrowable));
      }
      paramView = new HashMap();
      paramView.put("isSharpP", String.valueOf(bool));
      paramView.put("url", paramThrowable.jdField_a_of_type_JavaLangString);
      axrn.a(BaseApplication.getContext()).a(null, "NativeWebImageUI", false, 0L, 0L, paramView, "", true);
      return;
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    ImageData localImageData = (ImageData)this.a.a;
    boolean bool = rkr.a(paramURLDrawable.getURL().getFile());
    if (bool) {}
    for (paramView = rkr.a(localImageData.jdField_a_of_type_JavaLangString, localImageData);; paramView = localImageData.jdField_a_of_type_JavaLangString)
    {
      paramView = sfa.a(paramView, 4);
      if ((paramView == null) || (!paramView.equals(paramURLDrawable.getURL()))) {
        break;
      }
      if ((localImageData.jdField_a_of_type_Int == 0) || (localImageData.b == 0))
      {
        rks.a(this.a, paramURLDrawable);
        rks.a(this.a).setImageDrawable(paramURLDrawable);
      }
      paramView = new HashMap();
      paramView.put("isSharpP", String.valueOf(bool));
      paramView.put("url", localImageData.jdField_a_of_type_JavaLangString);
      axrn.a(BaseApplication.getContext()).a(null, "NativeWebImageUI", true, 0L, 0L, paramView, "", true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rkt
 * JD-Core Version:    0.7.0.1
 */