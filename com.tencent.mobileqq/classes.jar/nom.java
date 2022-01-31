import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class nom
{
  public static void a(AppInterface paramAppInterface, VideoInfo paramVideoInfo, ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      paramReadInJoyHeadImageView.setImageDrawable(azwp.a(paramAppInterface, 1, paramVideoInfo.j, 3, bacm.b(), bacm.b()));
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = bacm.b();
    localURLDrawableOptions.mFailedDrawable = bacm.b();
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramVideoInfo.E)) {
          break label140;
        }
        paramAppInterface = new URL("http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
        paramAppInterface = URLDrawable.getDrawable(paramAppInterface, localURLDrawableOptions);
        paramAppInterface.setDecodeHandler(azue.a);
        paramReadInJoyHeadImageView.setImageDrawable(paramAppInterface);
        return;
      }
      catch (MalformedURLException paramAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MultiVideoIconHelper", 2, "initVideoItemContentUI() ERROR e = " + paramAppInterface.getMessage());
      return;
      label140:
      paramAppInterface = new URL(paramVideoInfo.E);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nom
 * JD-Core Version:    0.7.0.1
 */