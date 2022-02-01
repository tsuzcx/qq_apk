import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class lpb
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  private static final String jdField_a_of_type_JavaLangString = lbh.h() + "SKINCOLOR" + File.separator;
  
  public static float a()
  {
    if (jdField_a_of_type_Float != -1.0F) {
      return jdField_a_of_type_Float;
    }
    for (;;)
    {
      try
      {
        lol locallol = lol.a();
        if (locallol == null) {
          continue;
        }
        jdField_a_of_type_Float = locallol.a();
        lbd.f("EffectBeautyTools", "mBeautyRatio:" + jdField_a_of_type_Float);
      }
      catch (Exception localException)
      {
        lbd.f("EffectBeautyTools", "getNewBeautyRatio Exception:" + localException);
        jdField_a_of_type_Float = 1.0F;
        continue;
      }
      return jdField_a_of_type_Float;
      jdField_a_of_type_Float = 1.0F;
    }
  }
  
  private static lpd a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      lbd.f("EffectBeautyTools", "parseConfig|content is empty.");
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
        locallpd = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        locallpd = new lpd(i, str1, str2);
        try
        {
          lbd.f("EffectBeautyTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return locallpd;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        locallpd = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        lbd.f("EffectBeautyTools", "parseConfig failed. info = " + localJSONObject);
        return locallpd;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        lbd.f("EffectBeautyTools", "parseConfig|parse failed.context = " + paramString);
        return locallpd;
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
          FileUtils.deleteDirectory(jdField_a_of_type_JavaLangString);
        }
      }
      paramContext = a(EffectConfigBase.b(180, EffectConfigBase.c));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(jdField_a_of_type_JavaLangString + "params.json");
        lbd.f("EffectBeautyTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).mCallback = new lpc();
          ((HttpNetReq)localObject).mReqUrl = paramContext.jdField_a_of_type_JavaLangString;
          ((HttpNetReq)localObject).mHttpMethod = 0;
          ((HttpNetReq)localObject).mOutPath = (lbh.h() + "skin_color.zip");
          ((HttpNetReq)localObject).setUserData(paramContext);
          lbf.a().sendReq((NetReq)localObject);
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
        FileUtils.deleteDirectory(jdField_a_of_type_JavaLangString);
      }
      while ((paramString1 == null) || (paramContext.b.equals(paramString1.b))) {
        return;
      }
      FileUtils.deleteDirectory(jdField_a_of_type_JavaLangString);
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
        lol locallol = lol.a();
        if ((locallol == null) || (!locallol.a()) || (!c())) {
          continue;
        }
        jdField_a_of_type_Int = 2;
        lbd.f("EffectBeautyTools", "mIsSupportFlag:" + jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        lbd.f("EffectBeautyTools", "isSupportNewBeauty Exception:" + localException);
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
    lbd.f("EffectBeautyTools", "getIsFirstLauncher:" + i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lpb
 * JD-Core Version:    0.7.0.1
 */