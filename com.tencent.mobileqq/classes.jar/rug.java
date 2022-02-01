import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class rug
{
  public static void a(ReadInJoyUserInfo paramReadInJoyUserInfo, NativeReadInjoyImageView paramNativeReadInjoyImageView)
  {
    if (paramReadInJoyUserInfo == null) {
      QLog.d("ReadInJoyVIconHelper", 2, "[setVIconWithUserInfo], userInfo is null.");
    }
    do
    {
      do
      {
        return;
      } while (paramNativeReadInjoyImageView == null);
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyVIconHelper", 2, "[refreshVIcon], userInfo = " + paramReadInJoyUserInfo);
      }
      if (!TextUtils.isEmpty(paramReadInJoyUserInfo.smallIconUrl))
      {
        paramNativeReadInjoyImageView.setImageResource(2130841680);
        paramNativeReadInjoyImageView.setVisibility(0);
        paramNativeReadInjoyImageView.setImageSrc(paramReadInJoyUserInfo.smallIconUrl);
        return;
      }
    } while (TextUtils.isEmpty(paramReadInJoyUserInfo.largeIconUrl));
    paramNativeReadInjoyImageView.setImageResource(2130841680);
    paramNativeReadInjoyImageView.setVisibility(0);
    paramNativeReadInjoyImageView.setImageSrc(paramReadInJoyUserInfo.largeIconUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rug
 * JD-Core Version:    0.7.0.1
 */