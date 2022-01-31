import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class msy
{
  protected static aysb a;
  
  static
  {
    jdField_a_of_type_Aysb = new mta();
  }
  
  public static long a(String paramString)
  {
    long[] arrayOfLong = new long[4];
    paramString = paramString.split("\\.");
    int k = paramString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      arrayOfLong[j] = Long.parseLong(paramString[i]);
      j += 1;
      i += 1;
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
      lcg.c("ScoreManager", "saveAVChatInfosForScore error ");
    }
    do
    {
      return;
      if (lct.a(270) != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ScoreManager", 1, "saveAVChatInfosForScore, 没有配置, infos[" + paramString + "]");
    return;
    SharedPreferences.Editor localEditor = EffectConfigBase.a(270, EffectConfigBase.c).edit();
    localEditor.putString("scoreInfos", paramString);
    localEditor.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, mtb parammtb)
  {
    paramQQAppInterface = paramQQAppInterface.getNetEngine(0);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 2, "requestToDownload");
    }
    if (parammtb == null) {
      return false;
    }
    msz localmsz = new msz(parammtb);
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = localmsz;
    localayrx.jdField_a_of_type_JavaLangString = parammtb.jdField_a_of_type_JavaLangString;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.c = parammtb.c;
    localayrx.e = 1;
    localayrx.jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
    paramQQAppInterface.a(localayrx);
    parammtb.jdField_a_of_type_Ayrx = localayrx;
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 1, "submitDownloadTask. url = " + parammtb.jdField_a_of_type_JavaLangString);
    }
    return true;
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      lcg.c("ScoreManager", "parse config: " + paramString1 + ", curUin : " + paramString2);
      paramString2 = bbkb.e(paramString2);
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
          break label393;
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
          localObject = new mtb();
          ((mtb)localObject).jdField_a_of_type_JavaLangString = paramString1;
          ((mtb)localObject).c = (mrs.b() + ((mtb)localObject).jdField_a_of_type_JavaLangString.substring(((mtb)localObject).jdField_a_of_type_JavaLangString.lastIndexOf(".")));
          ((mtb)localObject).b = paramString2;
          a(paramQQAppInterface, (mtb)localObject);
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        lcg.c("ScoreManager", "parse exception: " + paramQQAppInterface.toString());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ScoreManager", 2, "parse exception: " + paramQQAppInterface.toString());
        return;
      }
      lcg.c("ScoreManager", "parse|config is empty!");
      if (QLog.isColorLevel())
      {
        QLog.i("ScoreManager", 2, "parse|config is empty!");
        return;
        label393:
        paramString1 = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     msy
 * JD-Core Version:    0.7.0.1
 */