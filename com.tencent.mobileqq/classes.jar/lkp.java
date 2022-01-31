import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasAdapter;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

public class lkp
  implements URLDrawableDownListener
{
  public lkp(ReadInJoyAtlasAdapter paramReadInJoyAtlasAdapter, ImageView paramImageView, AtlasModelImage paramAtlasModelImage, URLImageView paramURLImageView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if ((paramView instanceof Animatable))
      {
        paramView = (Animatable)paramView;
        if (!paramView.isRunning()) {
          paramView.start();
        }
      }
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    int i = paramURLDrawable.getIntrinsicWidth();
    int j = paramURLDrawable.getIntrinsicHeight();
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModelImage;
    if (j / i >= 3) {}
    for (i = 1;; i = 0)
    {
      paramView.picType = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter.a(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModelImage.modelImageShowTime = System.currentTimeMillis();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkp
 * JD-Core Version:    0.7.0.1
 */