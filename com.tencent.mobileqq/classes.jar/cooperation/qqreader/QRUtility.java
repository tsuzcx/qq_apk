package cooperation.qqreader;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import java.io.File;

public class QRUtility
{
  public static String a = "{\"id\":\"220628\",\"title\":\"天才魔音师\",\"author\":\"紫漠蝶\",\"downloadURL\":\"\",\"coverURL\":\"http://wfqqreader.3g.qq.com/cover/628/220628/b_220628.jpg\",\"contentUrl\":\"http://allreader.3g.qq.com/readonline\",\"is_real_url\": 0,\"type\":0,\"version\":417,\"chapterId\":-1,\"chapterTitle\": \"第1章 诡异事件\", \"drm\":0, \"finished\": 1, \"fileFormat\":\"txt\", \"sourceurl\":\"\"}";
  
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getInt("QR_USERPREF58", -1);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    int i = j;
    int k;
    if (paramQQAppInterface != null)
    {
      k = VipUtils.a(paramQQAppInterface, paramString);
      if ((k & 0x4) == 0) {
        break label26;
      }
      i = 2;
    }
    label26:
    do
    {
      return i;
      i = j;
    } while ((k & 0x2) == 0);
    return 1;
  }
  
  public static String a(Context paramContext)
  {
    return b(paramContext) + "pluginBooks";
  }
  
  public static short a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return VipUtils.a(paramQQAppInterface, paramString);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("QR_SETTING", 0).edit();
    paramContext.putInt("QR_USERPREF58", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("QR_SETTING", 0).edit();
    paramContext.putInt("QR_USERPREF58", paramInt);
    paramContext.putBoolean("QR_USERPREF_FROM_NET", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      paramAppInterface = (PublicAccountDataManager)paramAppInterface.getManager(55);
      if (paramAppInterface != null) {
        return paramAppInterface.b("1805987832") != null;
      }
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    if (Utils.a()) {
      return Environment.getExternalStorageDirectory().getPath() + "/Tencent/ReaderZone/";
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("QR_SETTING", 0).edit();
    paramContext.putInt("QR_USERPREF58", paramInt);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.QRUtility
 * JD-Core Version:    0.7.0.1
 */