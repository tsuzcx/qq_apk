package com.tencent.mobileqq.theme;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinTint;
import com.tencent.theme.SkinEngine;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TintManager
  implements ISkinTint
{
  private QuickUpdateListener jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackQuickUpdateListener = new TintManager.1(this);
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private JSONObject b;
  
  private Integer a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        localJSONObject = this.b;
      } while (localJSONObject == null);
      paramString = localJSONObject.optString(paramString);
    } while (TextUtils.isEmpty(paramString));
    try
    {
      int i = Color.parseColor(paramString);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(int[] paramArrayOfInt, int paramInt, Integer paramInteger)
  {
    if ((paramInteger != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > paramInt)) {
      paramArrayOfInt[paramInt] = paramInteger.intValue();
    }
  }
  
  public JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject;
    if (paramJSONObject2 == null)
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = paramJSONObject2.keys();
    for (;;)
    {
      localObject = paramJSONObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      String str2 = (String)localIterator.next();
      String str1 = paramJSONObject2.optString(str2);
      if (!TextUtils.isEmpty(str1))
      {
        String str3 = paramJSONObject1.optString(str2);
        localObject = str1;
        if (!TextUtils.isEmpty(str3)) {
          localObject = str1 + "," + str3;
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
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new JSONObject(paramString1);
        this.jdField_a_of_type_OrgJsonJSONObject = paramString1.optJSONObject("mapping");
        this.b = paramString1.optJSONObject("plate");
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new JSONObject(paramString2);
        paramString2 = paramString1.optJSONObject("mapping");
        JSONObject localJSONObject = paramString1.optJSONObject("plate");
        this.jdField_a_of_type_OrgJsonJSONArray = paramString1.optJSONArray("forbidden");
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        if (this.jdField_a_of_type_OrgJsonJSONArray != null)
        {
          int i = 0;
          while (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_OrgJsonJSONArray.optString(i), Boolean.valueOf(true));
            i += 1;
          }
        }
        if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
          this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
        }
        if (this.b == null) {
          this.b = new JSONObject();
        }
        a(this.jdField_a_of_type_OrgJsonJSONObject, paramString2);
        a(this.b, localJSONObject);
      }
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  protected boolean a(Paint paramPaint, String paramString)
  {
    Object localObject;
    if (this.b != null)
    {
      localObject = a(paramString);
      if ((localObject != null) && (paramPaint != null)) {
        paramPaint.setColorFilter(new LightingColorFilter(0, ((Integer)localObject).intValue()));
      }
    }
    int i;
    do
    {
      return true;
      localObject = BaseApplication.getContext();
      if ((localObject == null) || (!paramString.contains(".xml"))) {
        break;
      }
      paramString = paramString.replace(".xml", "");
      i = BaseApplication.getContext().getResources().getIdentifier(paramString, "color", ((Context)localObject).getPackageName());
      if (i <= 0) {
        break;
      }
      localObject = Integer.valueOf(SkinEngine.getInstances().getColor(i));
      if ((localObject == null) || (paramPaint == null)) {
        break;
      }
      paramPaint.setColorFilter(new LightingColorFilter(0, ((Integer)localObject).intValue()));
    } while (!QLog.isColorLevel());
    QLog.i("TintManager", 1, " skin_bar_textcolorName:" + paramString + " colorId:" + i + " rgbColor:" + Integer.toString(16777215 - ((Integer)localObject).intValue(), 16) + " " + Integer.toHexString(16777215 - ((Integer)localObject).intValue()) + " " + localObject);
    return true;
    return false;
  }
  
  public void clear()
  {
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.b = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public boolean isTint(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {}
    while ((localJSONObject == null) || (TextUtils.isEmpty(localJSONObject.optString(paramString)))) {
      return false;
    }
    return true;
  }
  
  public void loadConfig(Resources paramResources, String paramString)
  {
    clear();
    ThreadManagerV2.executeOnFileThread(new TintManager.2(this, paramString));
  }
  
  public void tint(Paint paramPaint, String paramString)
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if ((localObject == null) || (paramPaint == null) || (TextUtils.isEmpty(paramString))) {}
    int i;
    label100:
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("TintManager", 2, " fileName:" + paramString);
      }
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
            break label100;
          }
          if (paramString.equals(this.jdField_a_of_type_OrgJsonJSONArray.optString(i))) {
            break;
          }
          i += 1;
        }
      }
      str = ((JSONObject)localObject).optString(paramString);
    } while (TextUtils.isEmpty(str));
    if (paramString.contains(".")) {}
    for (localObject = paramString.split("\\.")[0];; localObject = paramString)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (localBaseApplication != null)
      {
        i = BaseApplication.getContext().getResources().getIdentifier((String)localObject, "drawable", localBaseApplication.getPackageName());
        if ((i > 0) && (SkinEngine.getInstances().checkResExist(i)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("TintManager", 2, "checkResExist fileName:" + paramString);
          return;
        }
      }
      if (str.contains(","))
      {
        paramString = str.split("\\,");
        int k = paramString.length;
        i = j;
        while ((i < k) && (!a(paramPaint, paramString[i]))) {
          i += 1;
        }
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TintManager", 2, "plateName:" + str + " fileName:" + paramString);
      }
      a(paramPaint, str);
      return;
    }
  }
  
  public void tintColorState(int[] paramArrayOfInt, int[][] paramArrayOfInt1, String paramString)
  {
    int i = 0;
    paramArrayOfInt1 = this.jdField_a_of_type_OrgJsonJSONObject;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt1 != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramArrayOfInt1 = paramArrayOfInt1.optString(paramString);
      if (paramArrayOfInt1.contains(","))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.TintManager
 * JD-Core Version:    0.7.0.1
 */