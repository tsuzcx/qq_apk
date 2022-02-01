package cooperation.vip.jsoninflate.model;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.util.URLUtil;

public class ImageViewModel
  extends ViewModel
{
  public ImageViewModel(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  private ImageView.ScaleType b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("center_crop".equals(paramString)) {
      return ImageView.ScaleType.CENTER_CROP;
    }
    if ("fit_center".equals(paramString)) {
      return ImageView.ScaleType.FIT_CENTER;
    }
    return ImageView.ScaleType.CENTER_CROP;
  }
  
  protected void a(String paramString)
  {
    if (!URLUtil.e(paramString)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if ((this.j > 0) && (this.k > 0))
    {
      localURLDrawableOptions.mRequestWidth = this.j;
      localURLDrawableOptions.mRequestHeight = this.k;
    }
    localURLDrawableOptions.mPlayGifImage = false;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString != null) {
      ((ImageView)this.h).setImageDrawable(paramString);
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.h instanceof ImageView)) {
      return;
    }
    if ("content".equals(paramString1))
    {
      a(paramString2);
      return;
    }
    if ("scale_type".equals(paramString1)) {
      ((ImageView)this.h).setScaleType(b(paramString2));
    }
  }
  
  protected void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.ImageViewModel
 * JD-Core Version:    0.7.0.1
 */