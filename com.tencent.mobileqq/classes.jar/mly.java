import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastImageViewCreator;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class mly
  implements URLDrawableDownListener
{
  mly(mlx parammlx, ImageData paramImageData) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("Q.readinjoy.fast_web", 2, " onLoadFailed: " + paramURLDrawable.getURL().toString() + " retryCnt: " + mlx.a(this.jdField_a_of_type_Mlx));
    if (((ImageData)this.jdField_a_of_type_Mlx.a).jdField_a_of_type_JavaLangString.equals(paramURLDrawable.getURL().getFile()))
    {
      int i = 0;
      if (WebFastImageViewCreator.a() < WebFastImageViewCreator.b())
      {
        WebFastImageViewCreator.c();
        i = 1;
      }
      if (mlx.a(this.jdField_a_of_type_Mlx) < 3)
      {
        mlx.b(this.jdField_a_of_type_Mlx);
        i = 1;
      }
      if (i != 0) {
        this.jdField_a_of_type_Mlx.b(this.jdField_a_of_type_Mlx.a, this.jdField_a_of_type_Mlx.a, true);
      }
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (((ImageData)this.jdField_a_of_type_Mlx.a).jdField_a_of_type_JavaLangString.equals(paramURLDrawable.getURL().getFile()))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataImageData.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataImageData.b != 0)) {
        mlx.a(this.jdField_a_of_type_Mlx).setImageDrawable(paramURLDrawable);
      }
    }
    else {
      return;
    }
    mlx.a(this.jdField_a_of_type_Mlx, paramURLDrawable);
    mlx.a(this.jdField_a_of_type_Mlx).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mly
 * JD-Core Version:    0.7.0.1
 */