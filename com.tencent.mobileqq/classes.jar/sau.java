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

public class sau
  implements URLDrawableDownListener
{
  sau(sat paramsat) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    QLog.d("Q.readinjoy.fast_web", 2, " onLoadFailed: " + paramURLDrawable.getURL().toString() + " retryCnt: " + sat.a(this.a));
    paramThrowable = (ImageData)this.a.a;
    boolean bool = sas.a(paramURLDrawable.getURL().getFile());
    if (bool) {}
    for (paramView = sas.a(paramThrowable.jdField_a_of_type_JavaLangString, paramThrowable);; paramView = paramThrowable.jdField_a_of_type_JavaLangString)
    {
      paramView = swu.a(paramView, 4);
      if ((paramView == null) || (!paramView.equals(paramURLDrawable.getURL()))) {
        break;
      }
      if (sat.b(this.a) < 2) {
        sat.c(this.a);
      }
      sat.d(this.a);
      if ((bool) && (sat.a(this.a) < 3))
      {
        paramThrowable.jdField_a_of_type_Boolean = false;
        ThreadManager.getUIHandler().post(new WebFastImageViewCreator.ImageViewHolder.1.1(this, paramThrowable));
      }
      paramView = new HashMap();
      paramView.put("isSharpP", String.valueOf(bool));
      paramView.put("url", paramThrowable.jdField_a_of_type_JavaLangString);
      azri.a(BaseApplication.getContext()).a(null, "NativeWebImageUI", false, 0L, 0L, paramView, "", true);
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
    boolean bool = sas.a(paramURLDrawable.getURL().getFile());
    if (bool) {}
    for (paramView = sas.a(localImageData.jdField_a_of_type_JavaLangString, localImageData);; paramView = localImageData.jdField_a_of_type_JavaLangString)
    {
      paramView = swu.a(paramView, 4);
      if ((paramView == null) || (!paramView.equals(paramURLDrawable.getURL()))) {
        break;
      }
      if ((localImageData.jdField_a_of_type_Int == 0) || (localImageData.b == 0))
      {
        sat.a(this.a, paramURLDrawable);
        sat.a(this.a).setImageDrawable(paramURLDrawable);
      }
      paramView = new HashMap();
      paramView.put("isSharpP", String.valueOf(bool));
      paramView.put("url", localImageData.jdField_a_of_type_JavaLangString);
      azri.a(BaseApplication.getContext()).a(null, "NativeWebImageUI", true, 0L, 0L, paramView, "", true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sau
 * JD-Core Version:    0.7.0.1
 */