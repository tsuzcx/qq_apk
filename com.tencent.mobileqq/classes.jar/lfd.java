import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class lfd
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  public static final String a;
  private static final String b = EffectConfigBase.b + "beauty" + File.separator;
  private static final String c = b + "SKINCOLOR" + File.separator;
  
  static
  {
    jdField_a_of_type_JavaLangString = b;
  }
  
  public static float a()
  {
    if (jdField_a_of_type_Float != -1.0F) {
      return jdField_a_of_type_Float;
    }
    for (;;)
    {
      try
      {
        ler localler = ler.a();
        if (localler == null) {
          continue;
        }
        jdField_a_of_type_Float = localler.a();
        krx.c("EffectBeautyTools", "mBeautyRatio:" + jdField_a_of_type_Float);
      }
      catch (Exception localException)
      {
        krx.c("EffectBeautyTools", "getNewBeautyRatio Exception:" + localException);
        jdField_a_of_type_Float = 1.0F;
        continue;
      }
      return jdField_a_of_type_Float;
      jdField_a_of_type_Float = 1.0F;
    }
  }
  
  private static lff a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      krx.c("EffectBeautyTools", "parseConfig|content is empty.");
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
        locallff = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        locallff = new lff(i, str1, str2);
        try
        {
          krx.c("EffectBeautyTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return locallff;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        locallff = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        krx.c("EffectBeautyTools", "parseConfig failed. info = " + localJSONObject);
        return locallff;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        krx.c("EffectBeautyTools", "parseConfig|parse failed.context = " + paramString);
        return locallff;
      }
    }
  }
  
  private static void a()
  {
    SharedPreferences.Editor localEditor = EffectConfigBase.a(180, EffectConfigBase.d).edit();
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
        if (new File(c).exists()) {
          bace.a(c);
        }
      }
      paramContext = a(EffectConfigBase.b(180, EffectConfigBase.d));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(c + "params.json");
        krx.c("EffectBeautyTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new axro();
          ((axro)localObject).jdField_a_of_type_Axrt = new lfe();
          ((axro)localObject).jdField_a_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
          ((axro)localObject).jdField_a_of_type_Int = 0;
          ((axro)localObject).c = (b + "skin_color.zip");
          ((axro)localObject).a(paramContext);
          kry.a().a((axsp)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramString, EffectConfigBase.b(180, EffectConfigBase.d));
    EffectConfigBase.a(180, EffectConfigBase.d, paramInt, paramString);
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
        bace.a(c);
      }
      while ((paramString1 == null) || (paramContext.b.equals(paramString1.b))) {
        return;
      }
      bace.a(c);
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
        ler localler = ler.a();
        if ((localler == null) || (!localler.a()) || (!c())) {
          continue;
        }
        jdField_a_of_type_Int = 2;
        krx.c("EffectBeautyTools", "mIsSupportFlag:" + jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        krx.c("EffectBeautyTools", "isSupportNewBeauty Exception:" + localException);
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
    int i = EffectConfigBase.a(180, EffectConfigBase.d).getInt("qav_effect_beauty_config_first_launch", 0);
    krx.c("EffectBeautyTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c()
  {
    int i = EffectConfigBase.c(180, EffectConfigBase.d);
    return (new File(c + "params.json").exists()) && (i != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfd
 * JD-Core Version:    0.7.0.1
 */