import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class nzu
{
  public static void a(VideoInfo paramVideoInfo, ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    Drawable localDrawable = bbef.a(true);
    if (!TextUtils.isEmpty(paramVideoInfo.E))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
      localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      try
      {
        paramVideoInfo = URLDrawable.getDrawable(new URL(paramVideoInfo.E), localURLDrawableOptions);
        paramVideoInfo.setDecodeHandler(bavw.a);
        paramReadInJoyHeadImageView.setImageDrawable(paramVideoInfo);
        return;
      }
      catch (MalformedURLException paramVideoInfo)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("MultiVideoIconHelper", 2, "initVideoItemContentUI() ERROR e = " + paramVideoInfo.getMessage());
        return;
      }
    }
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      paramReadInJoyHeadImageView.a(localDrawable);
      paramReadInJoyHeadImageView.setHeadImgByUin(Long.valueOf(paramVideoInfo.j).longValue(), false);
      return;
    }
    paramReadInJoyHeadImageView.setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzu
 * JD-Core Version:    0.7.0.1
 */