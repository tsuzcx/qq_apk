package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType;
import com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType.TypeItem;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MutualMarkConfBean
{
  public String a;
  public ArrayList<Long> a;
  public HashMap<Long, MutualMarkConfigIRType> a;
  public String b;
  public ArrayList<Long> b;
  public String c;
  public ArrayList<Long> c;
  public String d;
  public ArrayList<Long> d;
  public String e = "aHR0cHM6Ly90aS5xcS5jb20vdjIvaW50ZXJhY3RpdmUvc2V0dGluZw==";
  public String f = "https://static-res.qq.com/static-res/interactiveResource";
  
  public MutualMarkConfBean()
  {
    this.jdField_a_of_type_JavaLangString = "aHR0cDovL2QudXJsLmNuL215YXBwL3FxX2Rlc2svcXFfdGVybS9URVNULzEwNzQvc2hpcEFuaW1hdGlvbi56aXA=";
    this.jdField_b_of_type_JavaLangString = "518EB9C3CA09942475B9F0A7424CD33E";
    this.jdField_c_of_type_JavaLangString = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vaW50ZXI/dGFyZ2V0X3Vpbj14eHgmX3d2PTY3MTA4ODY3Jl93dng9MiZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
    this.jdField_d_of_type_JavaLangString = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vYWxsP193dj02NzEwODg2NyZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static MutualMarkConfBean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(MutualMarkUtils.a());
  }
  
  public static MutualMarkConfBean a(String paramString)
  {
    MutualMarkConfBean localMutualMarkConfBean = new MutualMarkConfBean();
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse content: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("MutualMarkConfBean", 1, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("IRResource"))
        {
          paramString = localJSONObject.optJSONObject("IRResource");
          localMutualMarkConfBean.jdField_a_of_type_JavaLangString = paramString.optString("path");
          localMutualMarkConfBean.jdField_b_of_type_JavaLangString = paramString.optString("md5");
          localMutualMarkConfBean.jdField_c_of_type_JavaLangString = paramString.optString("c2cIntimateUrl");
          localMutualMarkConfBean.jdField_d_of_type_JavaLangString = paramString.optString("intimateListUrl");
          if (!TextUtils.isEmpty(paramString.optString("emojieggSettingUrl"))) {
            localMutualMarkConfBean.e = paramString.optString("emojieggSettingUrl");
          }
        }
        if (localJSONObject.has("sort")) {
          paramString = localJSONObject.getJSONArray("sort");
        } else {
          paramString = new JSONArray("[7, 12, 8, 6, 4, 1, 2, 3, 5]");
        }
        if (localJSONObject.has("aio_left_sort")) {
          localObject1 = localJSONObject.getJSONArray("aio_left_sort");
        } else {
          localObject1 = new JSONArray("[7, 12, 4, 5, 8, 6]");
        }
        if (localJSONObject.has("aio_right_sort")) {
          localObject2 = localJSONObject.getJSONArray("aio_right_sort");
        } else {
          localObject2 = new JSONArray("[1, 2, 3]");
        }
        a(paramString, localMutualMarkConfBean.jdField_b_of_type_JavaUtilArrayList);
        a((JSONArray)localObject1, localMutualMarkConfBean.jdField_c_of_type_JavaUtilArrayList);
        a((JSONArray)localObject2, localMutualMarkConfBean.jdField_d_of_type_JavaUtilArrayList);
        if (localJSONObject.has("IRType"))
        {
          paramString = localJSONObject.optJSONArray("IRType");
          i = 0;
          if (i < paramString.length())
          {
            localObject1 = MutualMarkConfigIRType.a(paramString.getJSONObject(i));
            if (localObject1 == null) {
              break label595;
            }
            if (localMutualMarkConfBean.jdField_d_of_type_JavaUtilArrayList.contains(Long.valueOf(((MutualMarkConfigIRType)localObject1).jdField_a_of_type_Long)))
            {
              ((MutualMarkConfigIRType)localObject1).jdField_a_of_type_Boolean = true;
              ((MutualMarkConfigIRType)localObject1).b = localMutualMarkConfBean.jdField_d_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((MutualMarkConfigIRType)localObject1).jdField_a_of_type_Long));
            }
            else
            {
              j = localMutualMarkConfBean.jdField_c_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((MutualMarkConfigIRType)localObject1).jdField_a_of_type_Long));
              if (j >= 0) {
                ((MutualMarkConfigIRType)localObject1).b = j;
              }
            }
            int j = localMutualMarkConfBean.jdField_b_of_type_JavaUtilArrayList.indexOf(Long.valueOf(((MutualMarkConfigIRType)localObject1).jdField_a_of_type_Long));
            if (j >= 0) {
              ((MutualMarkConfigIRType)localObject1).jdField_a_of_type_Int = j;
            }
            localMutualMarkConfBean.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((MutualMarkConfigIRType)localObject1).jdField_a_of_type_Long), localObject1);
            localMutualMarkConfBean.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((MutualMarkConfigIRType)localObject1).jdField_a_of_type_Long));
            break label595;
          }
        }
        if (!localJSONObject.has("resourceDomain")) {
          break label592;
        }
        localMutualMarkConfBean.f = new String(Base64Util.decode(localJSONObject.optString("resourceDomain"), 0));
        return localMutualMarkConfBean;
      }
      catch (JSONException paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse error->");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("MutualMarkConfBean", 1, ((StringBuilder)localObject1).toString());
        return localMutualMarkConfBean;
      }
      localObject1 = new RuntimeException("524 manager content null：");
      ((RuntimeException)localObject1).fillInStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse content may null: ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", bean:");
      ((StringBuilder)localObject2).append(localMutualMarkConfBean);
      ((StringBuilder)localObject2).append("，stack = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("MutualMarkConfBean", 1, ((StringBuilder)localObject2).toString());
      label592:
      return localMutualMarkConfBean;
      label595:
      i += 1;
    }
  }
  
  private static void a(JSONArray paramJSONArray, ArrayList<Long> paramArrayList)
  {
    if (paramJSONArray == null) {
      return;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      paramArrayList.add(Long.valueOf(paramJSONArray.optLong(i)));
      i += 1;
    }
  }
  
  public int a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(((MutualMarkConfigIRType)localEntry.getValue()).jdField_a_of_type_JavaLangString)) && (((MutualMarkConfigIRType)localEntry.getValue()).jdField_a_of_type_JavaLangString.equals(paramString))) {
          return (int)((MutualMarkConfigIRType)localEntry.getValue()).jdField_a_of_type_Long;
        }
      }
    }
    return 0;
  }
  
  public MutualMarkConfigIRType.TypeItem a(long paramLong1, long paramLong2)
  {
    MutualMarkConfigIRType localMutualMarkConfigIRType = (MutualMarkConfigIRType)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localMutualMarkConfigIRType != null) {
      return localMutualMarkConfigIRType.a(paramLong2);
    }
    return null;
  }
  
  public MutualMarkConfigIRType.TypeItem a(String paramString)
  {
    return a(MutualMarkUtils.b(paramString), MutualMarkUtils.a(paramString));
  }
  
  public MutualMarkConfigIRType a(long paramLong)
  {
    return (MutualMarkConfigIRType)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public String a()
  {
    return new String(Base64Util.decode(MutualMarkConfProcessor.a().e, 0));
  }
  
  public String a(String paramString)
  {
    return new String(Base64Util.decode(MutualMarkConfProcessor.a().jdField_c_of_type_JavaLangString, 0)).replace("xxx", paramString);
  }
  
  public ArrayList<MutualMarkConfigIRType> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    MutualMarkConfigIRType localMutualMarkConfigIRType1 = (MutualMarkConfigIRType)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localMutualMarkConfigIRType1 != null) && (!TextUtils.isEmpty(localMutualMarkConfigIRType1.jdField_a_of_type_JavaLangString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        MutualMarkConfigIRType localMutualMarkConfigIRType2 = (MutualMarkConfigIRType)((Map.Entry)localIterator.next()).getValue();
        if ((localMutualMarkConfigIRType2 != null) && (localMutualMarkConfigIRType2.jdField_a_of_type_Long != paramLong) && (TextUtils.equals(localMutualMarkConfigIRType1.jdField_a_of_type_JavaLangString, localMutualMarkConfigIRType2.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localMutualMarkConfigIRType2);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(long paramLong)
  {
    MutualMarkConfigIRType localMutualMarkConfigIRType = (MutualMarkConfigIRType)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localMutualMarkConfigIRType != null) {
      return localMutualMarkConfigIRType.a();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    MutualMarkConfigIRType localMutualMarkConfigIRType = (MutualMarkConfigIRType)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localMutualMarkConfigIRType != null) {
      return localMutualMarkConfigIRType.a(paramLong2);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkConfBean{iRResourcePath='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRResourcePathMd5='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRResourceC2cIntimateUrl='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRResourceIntimateListUrl='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRResourceEmojiEggSettingUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRTypes=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilHashMap);
    localStringBuilder.append(", iRTypesSortForShowReactivePage=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append(", iRTypesSortForNormal=");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuilder.append(", iRTypesSortForAIOTitleLeft1=");
    localStringBuilder.append(this.jdField_c_of_type_JavaUtilArrayList);
    localStringBuilder.append(", iRTypesSortForAIOTitleLeft2=");
    localStringBuilder.append(this.jdField_d_of_type_JavaUtilArrayList);
    localStringBuilder.append(", resourceDomain='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MutualMarkConfBean
 * JD-Core Version:    0.7.0.1
 */