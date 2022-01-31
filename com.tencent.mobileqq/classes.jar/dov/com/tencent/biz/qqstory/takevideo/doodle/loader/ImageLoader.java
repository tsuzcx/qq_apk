package dov.com.tencent.biz.qqstory.takevideo.doodle.loader;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;

public class ImageLoader
{
  private static ImageLoader a = new ImageLoader();
  
  public static ImageLoader a()
  {
    return a;
  }
  
  public URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
    }
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      SLog.e("ImageLoader", "ImageView or uri is null.");
      return;
    }
    SLog.b("ImageLoader", "uri:" + paramString + ",width:" + paramInt1 + ",height:" + paramInt2);
    paramImageView.setImageDrawable(a(paramString, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.loader.ImageLoader
 * JD-Core Version:    0.7.0.1
 */