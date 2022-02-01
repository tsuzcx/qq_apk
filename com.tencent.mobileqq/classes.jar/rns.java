import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class rns
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString = "";
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static int jdField_b_of_type_Int = -1;
  private static String jdField_b_of_type_JavaLangString;
  private static int jdField_c_of_type_Int = -1;
  private static String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Int == 0) {
      a();
    }
    return jdField_a_of_type_Int;
  }
  
  public static String a()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".readInjoy/refresh_res/");
  }
  
  public static String a(String paramString)
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".readInjoy/refresh_res/" + paramString);
  }
  
  public static List<String> a()
  {
    Object localObject3 = null;
    Object localObject2;
    if (jdField_a_of_type_JavaUtilList != null)
    {
      localObject2 = jdField_a_of_type_JavaUtilList;
      return localObject2;
    }
    if (jdField_a_of_type_Int == 0) {
      a();
    }
    Object localObject1;
    if ((jdField_a_of_type_Int == 1) || (jdField_a_of_type_Int == 3)) {
      localObject1 = new File(c() + "refreshAnimatePictures" + "/");
    }
    for (;;)
    {
      localObject2 = localObject3;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject3;
      if (!((File)localObject1).exists()) {
        break;
      }
      localObject2 = localObject3;
      if (!((File)localObject1).isDirectory()) {
        break;
      }
      localObject1 = ((File)localObject1).listFiles();
      localObject2 = localObject3;
      if (localObject1 == null) {
        break;
      }
      localObject2 = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i < localObject1.length)
        {
          if (localObject1[i].getName().endsWith(".png")) {
            ((List)localObject2).add(localObject1[i].getName());
          }
          i += 1;
          continue;
          if (jdField_a_of_type_Int != 2) {
            break label206;
          }
          localObject1 = new File(c() + "refreshRandomPictures" + "/");
          break;
        }
      }
      jdField_a_of_type_JavaUtilList = (List)localObject2;
      return localObject2;
      label206:
      localObject1 = null;
    }
  }
  
  public static void a()
  {
    JSONObject localJSONObject = null;
    String str2 = null;
    String str1 = str2;
    Object localObject = localJSONObject;
    try
    {
      File localFile = new File(c() + "refreshConfig.json");
      str1 = str2;
      localObject = localJSONObject;
      if (localFile.exists())
      {
        str1 = str2;
        localObject = localJSONObject;
        str2 = FileUtils.readFileToString(localFile);
        str1 = str2;
        localObject = str2;
        localJSONObject = new JSONObject(str2);
        if (localJSONObject != null)
        {
          str1 = str2;
          localObject = str2;
          jdField_a_of_type_Int = localJSONObject.optInt("refresh_type");
          str1 = str2;
          localObject = str2;
          jdField_b_of_type_JavaLangString = localJSONObject.optString("voice_path");
          str1 = str2;
          localObject = str2;
          jdField_c_of_type_JavaLangString = localJSONObject.optString("rain_animate_path");
          str1 = str2;
          localObject = str2;
          jdField_b_of_type_Int = localJSONObject.optInt("refresh_sub_type");
          str1 = str2;
          localObject = str2;
          jdField_c_of_type_Int = localJSONObject.optInt("refresh_length_type", 0);
        }
      }
      else
      {
        str1 = str2;
        localObject = localJSONObject;
        QLog.e("RefreshRes", 1, "parseRefreshParaJson error refreshConfig not exist ");
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("RefreshRes", 1, "parseRefreshParaJson JSONException json = " + localIOException);
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RefreshRes", 1, localException, new Object[] { "parseRefreshParaJson error json = " + localJSONException });
      localException.printStackTrace();
    }
  }
  
  static void a(String paramString, long paramLong)
  {
    if ((!jdField_a_of_type_JavaLangString.equals(paramString)) || (jdField_a_of_type_Long != paramLong))
    {
      jdField_a_of_type_JavaLangString = paramString;
      b();
    }
  }
  
  public static boolean a()
  {
    if (jdField_c_of_type_Int < 0) {
      a();
    }
    return jdField_c_of_type_Int > 0;
  }
  
  public static boolean a(String paramString)
  {
    return bdyn.a(new File(a(paramString)));
  }
  
  public static int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public static String b()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".readInjoy/refresh_res/" + jdField_a_of_type_JavaLangString);
  }
  
  private static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RefreshRes", 2, "clearDataAfterSetRefreshInfo()");
    }
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
    jdField_a_of_type_JavaUtilList = null;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_Long = -1L;
  }
  
  public static String c()
  {
    return b() + "/" + "refresh" + "/";
  }
  
  public static String d()
  {
    return c() + "refreshGuideConfig";
  }
  
  public static String e()
  {
    if ((TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) && (jdField_a_of_type_Int == 0)) {
      a();
    }
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      return c() + jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String f()
  {
    if ((TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) && (jdField_a_of_type_Int == 0)) {
      a();
    }
    if (!TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) {
      return c() + jdField_c_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rns
 * JD-Core Version:    0.7.0.1
 */