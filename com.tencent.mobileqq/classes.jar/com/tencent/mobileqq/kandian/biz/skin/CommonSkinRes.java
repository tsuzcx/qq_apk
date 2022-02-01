package com.tencent.mobileqq.kandian.biz.skin;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonSkinRes
  extends BaseSkinRes
{
  private static String a = "";
  private static JSONObject b;
  private static int c;
  private static String d;
  private static String e;
  private static List<String> f;
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".readInjoy/skin_res/");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static boolean c(String paramString)
  {
    return SceneBuilder.a(new File(a(paramString)));
  }
  
  public static String d()
  {
    return a(a);
  }
  
  public static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".readInjoy/skin_guide/");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("/");
    localStringBuilder.append("refresh");
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public static JSONObject g()
  {
    if (b == null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(d());
        localStringBuilder.append("/colors.json");
        b = new JSONObject(FileUtils.readFileToString(new File(localStringBuilder.toString())));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    return b;
  }
  
  public static void h()
  {
    String str2 = null;
    String str1 = str2;
    try
    {
      localObject = new StringBuilder();
      str1 = str2;
      ((StringBuilder)localObject).append(f());
      str1 = str2;
      ((StringBuilder)localObject).append("refreshConfig.json");
      str1 = str2;
      str2 = FileUtils.readFileToString(new File(((StringBuilder)localObject).toString()));
      str1 = str2;
      localObject = new JSONObject(str2);
      str1 = str2;
      c = ((JSONObject)localObject).optInt("refresh_type");
      str1 = str2;
      d = ((JSONObject)localObject).optString("voice_path");
      str1 = str2;
      e = ((JSONObject)localObject).optString("rain_animate_path");
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseRefreshParaJson error json = ");
      ((StringBuilder)localObject).append(str1);
      QLog.e("CommonSkinRes", 1, ((StringBuilder)localObject).toString());
      localJSONException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static int i()
  {
    if (c == 0) {
      h();
    }
    return c;
  }
  
  public static String j()
  {
    if ((TextUtils.isEmpty(d)) && (c == 0)) {
      h();
    }
    if (!TextUtils.isEmpty(d))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(f());
      localStringBuilder.append(d);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String k()
  {
    if ((TextUtils.isEmpty(e)) && (c == 0)) {
      h();
    }
    if (!TextUtils.isEmpty(e))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(f());
      localStringBuilder.append(e);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static List<String> l()
  {
    Object localObject = f;
    if (localObject != null) {
      return localObject;
    }
    if (c == 0) {
      h();
    }
    int i = c;
    if (i == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f());
      ((StringBuilder)localObject).append("refreshAnimatePictures");
      ((StringBuilder)localObject).append("/");
      localObject = new File(((StringBuilder)localObject).toString());
    }
    else if (i == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(f());
      ((StringBuilder)localObject).append("refreshRandomPictures");
      ((StringBuilder)localObject).append("/");
      localObject = new File(((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = null;
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
  
  public Drawable a(Resources paramResources, String paramString1, String paramString2)
  {
    paramResources = new CommonSkinRes.SkinStateListDrawable();
    paramResources.a = d(paramString1);
    paramResources.b = d(paramString2);
    paramString1 = paramResources.b;
    paramResources.addState(new int[] { 16842913 }, paramString1);
    paramString1 = paramResources.b;
    paramResources.addState(new int[] { 16842912 }, paramString1);
    paramString1 = paramResources.a;
    paramResources.addState(new int[] { -16842919 }, paramString1);
    return paramResources;
  }
  
  public Drawable d(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(d());
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(paramString);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    paramString = new StringBuilder();
    paramString.append((String)localObject2);
    paramString.append(".gif");
    localObject1 = new File(paramString.toString());
    paramString = (String)localObject1;
    if (!((File)localObject1).exists())
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject2);
      paramString.append(".png");
      localObject1 = new File(paramString.toString());
      paramString = (String)localObject1;
      if (!((File)localObject1).exists())
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject2);
        paramString.append(".jpg");
        paramString = new File(paramString.toString());
        if (!paramString.exists()) {
          break label247;
        }
      }
    }
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = BaseImageUtil.c(paramString.getAbsolutePath());
    localObject1 = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mUseMemoryCache = false;
    try
    {
      localObject1 = paramString.toURL();
      paramString = (String)localObject1;
      if (((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage) {
        paramString = new URL("readinjoy_skin_gif", ((URL)localObject1).getAuthority(), ((URL)localObject1).getFile());
      }
      paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    label247:
    return new ColorDrawable(0);
  }
  
  public int e(String paramString)
  {
    JSONObject localJSONObject = g();
    if (localJSONObject == null) {
      return 0;
    }
    return Color.parseColor(localJSONObject.optString(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.CommonSkinRes
 * JD-Core Version:    0.7.0.1
 */