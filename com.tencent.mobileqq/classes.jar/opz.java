import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class opz
{
  public static void a(Drawable paramDrawable)
  {
    if (!a()) {
      QLog.i("DailyDynamicHeaderBackgroundController", 1, "blurBackground, isNeedToBlurBackground : NO");
    }
    while (!(paramDrawable instanceof URLDrawable)) {
      return;
    }
    ((URLDrawable)paramDrawable).setDecodeHandler(new oqa());
  }
  
  public static void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (b())
    {
      paramImageView.setColorFilter(855638016, PorterDuff.Mode.DARKEN);
      return;
    }
    paramImageView.clearColorFilter();
  }
  
  private static boolean a()
  {
    Object localObject = (pvp)((QQAppInterface)pkh.a()).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((pvp)localObject).a().a();
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("is_blur_background", "0");
        QLog.i("DailyDynamicHeaderBackgroundController", 1, "isNeedToBlurBackground, isBlurBackground = " + (String)localObject);
        return "1".equals(localObject);
      }
    }
    return false;
  }
  
  private static boolean b()
  {
    Object localObject = (pvp)((QQAppInterface)pkh.a()).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((pvp)localObject).a().a();
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("is_cover_background", "0");
        QLog.i("DailyDynamicHeaderBackgroundController", 1, "isNeedGrayLayer, isCoverBackground = " + (String)localObject);
        return "1".equals(localObject);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opz
 * JD-Core Version:    0.7.0.1
 */