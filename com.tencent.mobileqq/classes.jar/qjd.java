import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class qjd
{
  public static void a(long paramLong, KandianUrlImageView paramKandianUrlImageView)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new qje(paramLong, paramKandianUrlImageView));
    if (localReadInJoyUserInfo != null) {
      b(localReadInJoyUserInfo, paramKandianUrlImageView);
    }
  }
  
  private static void b(ReadInJoyUserInfo paramReadInJoyUserInfo, KandianUrlImageView paramKandianUrlImageView)
  {
    if (paramReadInJoyUserInfo == null) {
      QLog.d("ReadInJoyVIconHelper", 2, "[setVIconWithUserInfo], userInfo is null.");
    }
    do
    {
      do
      {
        return;
      } while (paramKandianUrlImageView == null);
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyVIconHelper", 2, "[refreshVIcon], userInfo = " + paramReadInJoyUserInfo);
      }
      try
      {
        if (!TextUtils.isEmpty(paramReadInJoyUserInfo.smallIconUrl))
        {
          paramKandianUrlImageView.setImageResource(2130841262);
          paramKandianUrlImageView.setVisibility(0);
          paramKandianUrlImageView.a(new URL(paramReadInJoyUserInfo.smallIconUrl));
          return;
        }
      }
      catch (MalformedURLException paramReadInJoyUserInfo)
      {
        QLog.e("ReadInJoyVIconHelper", 1, "[refreshVIcon], e = " + paramReadInJoyUserInfo);
        return;
      }
    } while (TextUtils.isEmpty(paramReadInJoyUserInfo.largeIconUrl));
    paramKandianUrlImageView.setImageResource(2130841262);
    paramKandianUrlImageView.setVisibility(0);
    paramKandianUrlImageView.a(new URL(paramReadInJoyUserInfo.largeIconUrl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjd
 * JD-Core Version:    0.7.0.1
 */