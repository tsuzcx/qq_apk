import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class puv
  implements Drawable.Callback
{
  puv(puu parampuu, DrawableUtil.DrawableCallBack paramDrawableCallBack, URLDrawable paramURLDrawable) {}
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    QLog.i("Q.readinjoy.proteus", 1, "invalidateDrawable: ");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(true, this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     puv
 * JD-Core Version:    0.7.0.1
 */