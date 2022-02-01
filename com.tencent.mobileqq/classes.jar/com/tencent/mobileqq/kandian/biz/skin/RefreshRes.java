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
  private static String a = "";
  private static long b = -1L;
  private static int c = 0;
  private static String d;
  private static String e;
  private static List<String> f;
  private static int g = -1;
  private static int h = -1;
  
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
  
  static void a(String paramString, long paramLong)
  {
    if ((!a.equals(paramString)) || (b != paramLong))
    {
      a = paramString;
      l();
    }
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".readInjoy/refresh_res/");
    localStringBuilder.append(a);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static boolean b(String paramString)
  {
    return SceneBuilder.a(new File(a(paramString)));
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
  
  public static void e()
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
        c = localJSONObject.optInt("refresh_type");
        localObject1 = localObject3;
        localObject2 = localObject3;
        d = localJSONObject.optString("voice_path");
        localObject1 = localObject3;
        localObject2 = localObject3;
        e = localJSONObject.optString("rain_animate_path");
        localObject1 = localObject3;
        localObject2 = localObject3;
        g = localJSONObject.optInt("refresh_sub_type");
        localObject1 = localObject3;
        localObject2 = localObject3;
        h = localJSONObject.optInt("refresh_length_type", 0);
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
  
  public static int f()
  {
    if (c == 0) {
      e();
    }
    return c;
  }
  
  public static int g()
  {
    return g;
  }
  
  public static String h()
  {
    if ((TextUtils.isEmpty(d)) && (c == 0)) {
      e();
    }
    if (!TextUtils.isEmpty(d))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append(d);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String i()
  {
    if ((TextUtils.isEmpty(e)) && (c == 0)) {
      e();
    }
    if (!TextUtils.isEmpty(e))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(c());
      localStringBuilder.append(e);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static boolean j()
  {
    if (h < 0) {
      e();
    }
    return h > 0;
  }
  
  public static List<String> k()
  {
    Object localObject = f;
    if (localObject != null) {
      return localObject;
    }
    if (c == 0) {
      e();
    }
    int i = c;
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
      f = localArrayList;
      return localArrayList;
    }
    return null;
  }
  
  private static void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RefreshRes", 2, "clearDataAfterSetRefreshInfo()");
    }
    c = 0;
    d = null;
    e = null;
    f = null;
    g = -1;
    b = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.RefreshRes
 * JD-Core Version:    0.7.0.1
 */