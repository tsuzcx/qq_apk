import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class lrw
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  private static final String jdField_a_of_type_JavaLangString = len.h() + "SKINCOLOR" + File.separator;
  
  public static float a()
  {
    if (jdField_a_of_type_Float != -1.0F) {
      return jdField_a_of_type_Float;
    }
    for (;;)
    {
      try
      {
        lrf locallrf = lrf.a();
        if (locallrf == null) {
          continue;
        }
        jdField_a_of_type_Float = locallrf.a();
        lek.c("EffectBeautyTools", "mBeautyRatio:" + jdField_a_of_type_Float);
      }
      catch (Exception localException)
      {
        lek.c("EffectBeautyTools", "getNewBeautyRatio Exception:" + localException);
        jdField_a_of_type_Float = 1.0F;
        continue;
      }
      return jdField_a_of_type_Float;
      jdField_a_of_type_Float = 1.0F;
    }
  }
  
  private static lry a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      lek.c("EffectBeautyTools", "parseConfig|content is empty.");
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString).getJSONObject("skinColorFilter");
      }
      catch (JSONException localJSONException3)
      {
        JSONObject localJSONObject;
        int i;
        String str1;
        String str2;
        locallry = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        locallry = new lry(i, str1, str2);
        try
        {
          lek.c("EffectBeautyTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return locallry;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        locallry = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        lek.c("EffectBeautyTools", "parseConfig failed. info = " + localJSONObject);
        return locallry;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        lek.c("EffectBeautyTools", "parseConfig|parse failed.context = " + paramString);
        return locallry;
      }
    }
  }
  
  private static void a()
  {
    SharedPreferences.Editor localEditor = EffectConfigBase.a(180, EffectConfigBase.c).edit();
    localEditor.putInt("qav_effect_beauty_config_first_launch", 1);
    localEditor.commit();
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (b())
      {
        a();
        if (new File(jdField_a_of_type_JavaLangString).exists()) {
          bdcs.a(jdField_a_of_type_JavaLangString);
        }
      }
      paramContext = a(EffectConfigBase.b(180, EffectConfigBase.c));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(jdField_a_of_type_JavaLangString + "params.json");
        lek.c("EffectBeautyTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new baps();
          ((baps)localObject).jdField_a_of_type_Bapx = new lrx();
          ((baps)localObject).jdField_a_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
          ((baps)localObject).jdField_a_of_type_Int = 0;
          ((baps)localObject).c = (len.h() + "skin_color.zip");
          ((baps)localObject).a(paramContext);
          lel.a().a((baqv)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramString, EffectConfigBase.b(180, EffectConfigBase.c));
    EffectConfigBase.a(180, EffectConfigBase.c, paramInt, paramString);
    if (paramBoolean) {
      a(paramContext);
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (paramContext = a(paramString1);; paramContext = null)
    {
      paramString1 = localObject;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = a(paramString2);
      }
      if (paramContext == null) {
        bdcs.a(jdField_a_of_type_JavaLangString);
      }
      while ((paramString1 == null) || (paramContext.b.equals(paramString1.b))) {
        return;
      }
      bdcs.a(jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Int != 0) {
      return jdField_a_of_type_Int == 2;
    }
    for (;;)
    {
      try
      {
        lrf locallrf = lrf.a();
        if ((locallrf == null) || (!locallrf.a()) || (!c())) {
          continue;
        }
        jdField_a_of_type_Int = 2;
        lek.c("EffectBeautyTools", "mIsSupportFlag:" + jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        lek.c("EffectBeautyTools", "isSupportNewBeauty Exception:" + localException);
        jdField_a_of_type_Int = 1;
        continue;
      }
      if (jdField_a_of_type_Int == 2) {
        break;
      }
      return false;
      jdField_a_of_type_Int = 1;
    }
  }
  
  private static boolean b()
  {
    boolean bool = false;
    int i = EffectConfigBase.a(180, EffectConfigBase.c).getInt("qav_effect_beauty_config_first_launch", 0);
    lek.c("EffectBeautyTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c()
  {
    int i = EffectConfigBase.c(180, EffectConfigBase.c);
    return (new File(jdField_a_of_type_JavaLangString + "params.json").exists()) && (i != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrw
 * JD-Core Version:    0.7.0.1
 */