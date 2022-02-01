package com.tencent.mobileqq.kandian.biz.skin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RefreshRes
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = -1L;
  private static String jdField_a_of_type_JavaLangString = "";
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static int jdField_b_of_type_Int = -1;
  private static String jdField_b_of_type_JavaLangString;
  private static int jdField_c_of_type_Int = -1;
  private static String jdField_c_of_type_JavaLangString;
  
  public static int a()
  {
    if (jdField_a_of_type_Int == 0) {
      a();
    }
    return jdField_a_of_type_Int;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".readInjoy/refresh_res/");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".readInjoy/refresh_res/");
    localStringBuilder.append(paramString);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static List<String> a()
  {
    Object localObject = jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      return localObject;
    }
    if (jdField_a_of_type_Int == 0) {
      a();
    }
    int i = jdField_a_of_type_Int;
    if ((i != 1) && (i != 3))
    {
      if (i == 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(c());
        ((StringBuilder)localObject).append("refreshRandomPictures");
        ((StringBuilder)localObject).append("/");
        localObject = new File(((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = null;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append("refreshAnimatePictures");
      ((StringBuilder)localObject).append("/");
      localObject = new File(((StringBuilder)localObject).toString());
    }
    if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if (localObject == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].getName().endsWith(".png")) {
          localArrayList.add(localObject[i].getName());
        }
        i += 1;
      }
      jdField_a_of_type_JavaUtilList = localArrayList;
      return localArrayList;
    }
    return null;
  }
  
  public static void a()
  {
    JSONObject localJSONObject = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localJSONObject;
    try
    {
      Object localObject4 = new StringBuilder();
      localObject1 = localObject3;
      localObject2 = localJSONObject;
      ((StringBuilder)localObject4).append(c());
      localObject1 = localObject3;
      localObject2 = localJSONObject;
      ((StringBuilder)localObject4).append("refreshConfig.json");
      localObject1 = localObject3;
      localObject2 = localJSONObject;
      localObject4 = new File(((StringBuilder)localObject4).toString());
      localObject1 = localObject3;
      localObject2 = localJSONObject;
      if (((File)localObject4).exists())
      {
        localObject1 = localObject3;
        localObject2 = localJSONObject;
        localObject3 = FileUtils.readFileToString((File)localObject4);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localJSONObject = new JSONObject((String)localObject3);
        localObject1 = localObject3;
        localObject2 = localObject3;
        jdField_a_of_type_Int = localJSONObject.optInt("refresh_type");
        localObject1 = localObject3;
        localObject2 = localObject3;
        jdField_b_of_type_JavaLangString = localJSONObject.optString("voice_path");
        localObject1 = localObject3;
        localObject2 = localObject3;
        jdField_c_of_type_JavaLangString = localJSONObject.optString("rain_animate_path");
        localObject1 = localObject3;
        localObject2 = localObject3;
        jdField_b_of_type_Int = localJSONObject.optInt("refresh_sub_type");
        localObject1 = localObject3;
        localObject2 = localObject3;
        jdField_c_of_type_Int = localJSONObject.optInt("refresh_length_type", 0);
        return;
      }
      localObject1 = localObject3;
      localObject2 = localJSONObject;
      QLog.e("RefreshRes", 1, "parseRefreshParaJson error refreshConfig not exist ");
      return;
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("parseRefreshParaJson error json = ");
      ((StringBuilder)localObject3).append(localObject1);
      QLog.e("RefreshRes", 1, localException, new Object[] { ((StringBuilder)localObject3).toString() });
      localException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("parseRefreshParaJson JSONException json = ");
      ((StringBuilder)localObject3).append(localException);
      QLog.e("RefreshRes", 1, ((StringBuilder)localObject3).toString());
      localJSONException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
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
    return SceneBuilder.a(new File(a(paramString)));
  }
  
  public static int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".readInjoy/refresh_res/");
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("/");
    localStringBuilder.append("refresh");
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("refreshGuideConfig");
    return localStringBuilder.toString();
  }
  
  public static String e()
  {
    if ((TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) && (jdField_a_of_type_Int == 0)) {
      a();
    }
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append(jdField_b_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String f()
  {
    if ((TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) && (jdField_a_of_type_Int == 0)) {
      a();
    }
    if (!TextUtils.isEmpty(jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append(jdField_c_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.RefreshRes
 * JD-Core Version:    0.7.0.1
 */