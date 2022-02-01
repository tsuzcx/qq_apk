import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

public class pmj
{
  public static boolean a(Context paramContext, String paramString)
  {
    pmh.a(paramString);
    QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "jumpToKDTab, scheme = " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], scheme is empty.");
      return false;
    }
    String str2;
    String str4;
    boolean bool;
    do
    {
      String str3;
      String str5;
      do
      {
        try
        {
          paramString = Uri.parse(paramString);
          str1 = paramString.getQueryParameter("target");
          if (!"2".equals(str1))
          {
            QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], target = " + str1 + ", do not jump to channel.");
            return false;
          }
        }
        catch (Exception paramContext)
        {
          QLog.e("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], e = " + paramContext);
          QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], do not handle.");
          return false;
        }
        String str1 = paramString.getQueryParameter("channelid");
        int i = -1;
        try
        {
          int j = Integer.parseInt(str1);
          i = j;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            QLog.e("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], e = " + localNumberFormatException);
          }
          str2 = paramString.getQueryParameter("rowkey");
          str3 = paramString.getQueryParameter("algorithmid");
          str4 = paramString.getQueryParameter("article_url");
          str5 = URLDecoder.decode(str4, "utf-8");
          bool = TextUtils.equals("1", paramString.getQueryParameter("show_floating_window"));
          QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], articleURLDecoded = " + str5);
        }
        if (i != 0)
        {
          QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], not recommend tab.");
          return false;
        }
      } while ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)));
      if (!bnrf.h())
      {
        ozs.a(paramContext, str5);
        QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], open article directly.");
        return true;
      }
    } while (!bool);
    paramContext.startActivity(oix.a(paramContext, 12, str2, str4));
    QLog.i("ReadInJoyDailyJumpToKDTabUtils", 1, "[jumpToKDTab], open floating window.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmj
 * JD-Core Version:    0.7.0.1
 */