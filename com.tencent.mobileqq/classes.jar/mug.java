import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class mug
{
  protected static INetEngine.IBreakDownFix a = new mui();
  
  public static long a(String paramString)
  {
    long[] arrayOfLong = new long[4];
    paramString = paramString.split("\\.");
    int k = paramString.length;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < k)
      {
        String str = paramString[i];
        try
        {
          arrayOfLong[j] = Long.parseLong(str);
          j += 1;
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            QLog.i("ScoreManager", 1, "ipStrToLong", localNumberFormatException);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.i("ScoreManager", 1, "ipStrToLong", localThrowable);
          }
        }
      }
    }
    return (arrayOfLong[0] << 24) + (arrayOfLong[1] << 16) + (arrayOfLong[2] << 8) + arrayOfLong[3];
  }
  
  public static String a()
  {
    String str = EffectConfigBase.a(270, EffectConfigBase.c).getString("scoreInfos", null);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 2, "getScoreInfos:" + str);
    }
    return str;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    b(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      lbd.f("ScoreManager", "saveAVChatInfosForScore error ");
    }
    do
    {
      return;
      if (lbt.a(270) != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ScoreManager", 1, "saveAVChatInfosForScore, 没有配置, infos[" + paramString + "]");
    return;
    SharedPreferences.Editor localEditor = EffectConfigBase.a(270, EffectConfigBase.c).edit();
    localEditor.putString("scoreInfos", paramString);
    localEditor.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, muj parammuj)
  {
    paramQQAppInterface = paramQQAppInterface.getNetEngine(0);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 2, "requestToDownload");
    }
    if (parammuj == null) {
      return false;
    }
    muh localmuh = new muh(parammuj);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = localmuh;
    localHttpNetReq.mReqUrl = parammuj.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = parammuj.c;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.mBreakDownFix = a;
    paramQQAppInterface.sendReq(localHttpNetReq);
    parammuj.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 1, "submitDownloadTask. url = " + parammuj.jdField_a_of_type_JavaLangString);
    }
    return true;
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      lbd.f("ScoreManager", "parse config: " + paramString1 + ", curUin : " + paramString2);
      paramString2 = bhhr.e(paramString2);
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString1);
        int i;
        if (((JSONObject)localObject).has("scoreSwitch"))
        {
          i = ((JSONObject)localObject).getInt("scoreSwitch");
          paramString2.edit().putInt("qav_score_switch", i).commit();
        }
        if (((JSONObject)localObject).has("scoreTime"))
        {
          i = ((JSONObject)localObject).getInt("scoreTime");
          paramString2.edit().putInt("qav_score_time", i).commit();
        }
        if (((JSONObject)localObject).has("scoreRate"))
        {
          i = ((JSONObject)localObject).getInt("scoreRate");
          paramString2.edit().putInt("qav_score_rate", i).commit();
        }
        if (!((JSONObject)localObject).has("scoreIconUrl")) {
          break label395;
        }
        paramString1 = ((JSONObject)localObject).getString("scoreIconUrl");
        paramString2 = "";
        if (((JSONObject)localObject).has("scoreIconMd5")) {
          paramString2 = ((JSONObject)localObject).getString("scoreIconMd5");
        }
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ScoreManager", 2, "parse|down load icons!");
          }
          localObject = new muj();
          ((muj)localObject).jdField_a_of_type_JavaLangString = paramString1;
          ((muj)localObject).c = (msw.b() + ((muj)localObject).jdField_a_of_type_JavaLangString.substring(((muj)localObject).jdField_a_of_type_JavaLangString.lastIndexOf(".")));
          ((muj)localObject).b = paramString2;
          a(paramQQAppInterface, (muj)localObject);
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        lbd.f("ScoreManager", "parse exception: " + paramQQAppInterface.toString());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ScoreManager", 2, "parse exception: " + paramQQAppInterface.toString());
        return;
      }
      lbd.f("ScoreManager", "parse|config is empty!");
      if (QLog.isColorLevel())
      {
        QLog.i("ScoreManager", 2, "parse|config is empty!");
        return;
        label395:
        paramString1 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mug
 * JD-Core Version:    0.7.0.1
 */