package com.tencent.mobileqq.vas.theme;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.TintConfigCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinTint;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TintManager
  implements ISkinTint
{
  public static volatile TintManager a;
  private JSONObject b;
  private JSONObject c;
  private JSONArray d;
  private HashMap<String, Boolean> e = new HashMap();
  private String f = "";
  private String g;
  private QuickUpdateListener h = new TintManager.1(this);
  
  public static TintManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TintManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(Paint paramPaint, String paramString, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString(paramString);
    if (!TextUtils.isEmpty(str))
    {
      boolean bool = paramString.contains(".");
      int i = 0;
      if (bool) {
        paramJSONObject = paramString.split("\\.")[0];
      } else {
        paramJSONObject = paramString;
      }
      BaseApplication localBaseApplication = BaseApplication.getContext();
      int j;
      if (localBaseApplication != null)
      {
        j = BaseApplication.getContext().getResources().getIdentifier(paramJSONObject, "drawable", localBaseApplication.getPackageName());
        if ((j > 0) && (SkinEngine.getInstances().checkResExist(j)))
        {
          if (QLog.isColorLevel())
          {
            paramPaint = new StringBuilder();
            paramPaint.append("checkResExist fileName:");
            paramPaint.append(paramString);
            QLog.i("TintManager", 2, paramPaint.toString());
          }
          return;
        }
      }
      if (str.contains(","))
      {
        paramString = str.split("\\,");
        j = paramString.length;
        while (i < j)
        {
          if (a(paramPaint, paramString[i])) {
            return;
          }
          i += 1;
        }
      }
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("plateName:");
        paramJSONObject.append(str);
        paramJSONObject.append(" fileName:");
        paramJSONObject.append(paramString);
        QLog.i("TintManager", 2, paramJSONObject.toString());
      }
      a(paramPaint, str);
    }
  }
  
  private void a(int[] paramArrayOfInt, int paramInt, Integer paramInteger)
  {
    if ((paramInteger != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > paramInt)) {
      paramArrayOfInt[paramInt] = paramInteger.intValue();
    }
  }
  
  public Integer a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = this.c;
    if (localJSONObject == null) {
      return null;
    }
    paramString = localJSONObject.optString(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = Color.parseColor(paramString);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject2 == null) {
      return null;
    }
    Iterator localIterator = paramJSONObject2.keys();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = paramJSONObject2.optString(str2);
      if (!TextUtils.isEmpty(str1))
      {
        String str3 = paramJSONObject1.optString(str2);
        Object localObject = str1;
        if (!TextUtils.isEmpty(str3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(str3);
          localObject = ((StringBuilder)localObject).toString();
        }
        try
        {
          paramJSONObject1.putOpt(str2, localObject);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return paramJSONObject1;
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString1);
      if (!bool)
      {
        paramString1 = new JSONObject(paramString1);
        this.b = paramString1.optJSONObject("mapping");
        this.c = paramString1.optJSONObject("plate");
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new JSONObject(paramString2);
        paramString2 = paramString1.optJSONObject("mapping");
        JSONObject localJSONObject = paramString1.optJSONObject("plate");
        this.d = paramString1.optJSONArray("forbidden");
        this.e.clear();
        if (this.d != null)
        {
          int i = 0;
          while (i < this.d.length())
          {
            this.e.put(this.d.optString(i), Boolean.valueOf(true));
            i += 1;
          }
        }
        if (this.b == null) {
          this.b = new JSONObject();
        }
        if (this.c == null) {
          this.c = new JSONObject();
        }
        a(this.b, paramString2);
        a(this.c, localJSONObject);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      QLog.e("TintManager", 1, "parseData error", paramString1);
    }
  }
  
  protected boolean a(Paint paramPaint, String paramString)
  {
    if (this.c != null)
    {
      localObject = a(paramString);
      if ((localObject != null) && (paramPaint != null))
      {
        paramPaint.setColorFilter(new LightingColorFilter(0, ((Integer)localObject).intValue()));
        return true;
      }
    }
    Object localObject = BaseApplication.getContext();
    if ((localObject != null) && (paramString.contains(".xml")))
    {
      paramString = paramString.replace(".xml", "");
      int i = BaseApplication.getContext().getResources().getIdentifier(paramString, "color", ((Context)localObject).getPackageName());
      if (i > 0)
      {
        localObject = Integer.valueOf(SkinEngine.getInstances().getColor(i));
        if ((localObject != null) && (paramPaint != null))
        {
          paramPaint.setColorFilter(new LightingColorFilter(0, ((Integer)localObject).intValue()));
          if (QLog.isColorLevel())
          {
            paramPaint = new StringBuilder();
            paramPaint.append(" skin_bar_textcolorName:");
            paramPaint.append(paramString);
            paramPaint.append(" colorId:");
            paramPaint.append(i);
            paramPaint.append(" rgbColor:");
            paramPaint.append(Integer.toString(16777215 - ((Integer)localObject).intValue(), 16));
            paramPaint.append(" ");
            paramPaint.append(Integer.toHexString(16777215 - ((Integer)localObject).intValue()));
            paramPaint.append(" ");
            paramPaint.append(localObject);
            QLog.i("TintManager", 1, paramPaint.toString());
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public void clear()
  {
    this.b = null;
    this.c = null;
    this.e.clear();
  }
  
  public boolean isTint(String paramString)
  {
    JSONObject localJSONObject = this.b;
    if (this.e.get(paramString) != null) {
      return false;
    }
    if (localJSONObject == null) {
      return false;
    }
    return TextUtils.isEmpty(localJSONObject.optString(paramString)) ^ true;
  }
  
  public void loadConfig(Resources paramResources, String paramString)
  {
    String str3 = "";
    SimpleTintManager.instance().clear();
    long l = System.currentTimeMillis();
    clear();
    this.g = paramString;
    for (;;)
    {
      Object localObject;
      try
      {
        if (!TextUtils.isEmpty(this.f)) {
          break label353;
        }
        String str1 = ThemeUpdateCallback.sInstance.getSavePath(MobileQQ.getContext(), "theme_mapping_config_android");
        paramResources = str1;
        try
        {
          if (!new File(str1).exists())
          {
            paramResources = str1;
            if (QLog.isColorLevel())
            {
              paramResources = str1;
              QLog.i("TintManager", 2, "download theme_mapping_config_android");
            }
            paramResources = str1;
            TintConfigCallback.sInstance.downloadAtMostTwice(this.h);
            return;
          }
          paramResources = str1;
          this.f = FileUtils.readFileContent(new File(str1));
          localObject = str3;
          paramResources = str1;
          if (!TextUtils.isEmpty(paramString))
          {
            paramResources = str1;
            localObject = new StringBuilder();
            paramResources = str1;
            ((StringBuilder)localObject).append("skinFilePath ");
            paramResources = str1;
            ((StringBuilder)localObject).append(paramString);
            paramResources = str1;
            QLog.i("TintManager", 2, ((StringBuilder)localObject).toString());
            paramResources = str1;
            File localFile = new File(paramString);
            localObject = str3;
            paramResources = str1;
            if (localFile.exists())
            {
              paramResources = str1;
              localObject = FileUtils.readFileContent(localFile);
            }
          }
          paramResources = str1;
          a(this.f, (String)localObject);
          paramResources = str1;
          localObject = new StringBuilder();
          paramResources = str1;
          ((StringBuilder)localObject).append("loadConfig elapse:");
          paramResources = str1;
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          paramResources = str1;
          QLog.i("TintManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
        catch (Exception localException1) {}
        localObject = new StringBuilder();
      }
      catch (Exception localException2)
      {
        paramResources = "";
      }
      ((StringBuilder)localObject).append("loadConfig error skinFilePath:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" filePath:");
      ((StringBuilder)localObject).append(paramResources);
      QLog.e("TintManager", 1, ((StringBuilder)localObject).toString(), localException2);
      return;
      label353:
      String str2 = "";
    }
  }
  
  public void tint(Paint paramPaint, String paramString)
  {
    JSONObject localJSONObject = this.b;
    if ((localJSONObject != null) && (paramPaint != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" fileName:");
        localStringBuilder.append(paramString);
        QLog.i("TintManager", 2, localStringBuilder.toString());
      }
      if (this.d != null)
      {
        int i = 0;
        while (i < this.d.length())
        {
          if (paramString.equals(this.d.optString(i))) {
            return;
          }
          i += 1;
        }
      }
      a(paramPaint, paramString, localJSONObject);
    }
  }
  
  public void tintColorState(int[] paramArrayOfInt, int[][] paramArrayOfInt1, String paramString)
  {
    paramArrayOfInt1 = this.b;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt1 != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramArrayOfInt1 = paramArrayOfInt1.optString(paramString);
      boolean bool = paramArrayOfInt1.contains(",");
      int i = 0;
      if (bool)
      {
        paramArrayOfInt1 = paramArrayOfInt1.split("\\,");
        while (i < paramArrayOfInt1.length)
        {
          a(paramArrayOfInt, i, a(paramArrayOfInt1[i]));
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(paramArrayOfInt1)) {
        a(paramArrayOfInt, 0, a(paramArrayOfInt1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.TintManager
 * JD-Core Version:    0.7.0.1
 */