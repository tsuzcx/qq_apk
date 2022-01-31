import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.utils.ImageUtil;

public class kpt
  implements URLDrawable.URLDrawableListener
{
  public kpt(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.a(paramURLDrawable);
    Bitmap localBitmap = ImageUtil.c(paramURLDrawable, 110, 110);
    this.a.c.setImageBitmap(localBitmap);
    paramURLDrawable.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kpt
 * JD-Core Version:    0.7.0.1
 */