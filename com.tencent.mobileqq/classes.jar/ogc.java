import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ogc
{
  private static ExecutorService a;
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = paramString1.replace("ARTICLE_ID", paramString2).replace("USER_QQ", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin()).replace("ACTION_TYPE", paramString3);
    Log.d("DE_KUAIB", paramString2 + "|" + paramString3);
    return paramString1;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (a == null) {
      a = Executors.newFixedThreadPool(1);
    }
    a.execute(new KandianUGStatisticUtils.1(paramString));
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramString1.contains("?")) {
      return paramString1 + "&acttype=" + paramString2 + "&subpos=" + paramString3;
    }
    return paramString1 + "?acttype=" + paramString2 + "&subpos=" + paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogc
 * JD-Core Version:    0.7.0.1
 */