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
  public String a = "aHR0cDovL2QudXJsLmNuL215YXBwL3FxX2Rlc2svcXFfdGVybS9URVNULzEwNzQvc2hpcEFuaW1hdGlvbi56aXA=";
  public String b = "518EB9C3CA09942475B9F0A7424CD33E";
  public String c = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vaW50ZXI/dGFyZ2V0X3Vpbj14eHgmX3d2PTY3MTA4ODY3Jl93dng9MiZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
  public String d = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vYWxsP193dj02NzEwODg2NyZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
  public String e = "aHR0cHM6Ly90aS5xcS5jb20vdjIvaW50ZXJhY3RpdmUvc2V0dGluZw==";
  public HashMap<Long, MutualMarkConfigIRType> f = new HashMap();
  public ArrayList<Long> g = new ArrayList();
  public ArrayList<Long> h = new ArrayList();
  public ArrayList<Long> i = new ArrayList();
  public ArrayList<Long> j = new ArrayList();
  public String k = "https://static-res.qq.com/static-res/interactiveResource";
  
  public static MutualMarkConfBean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(MutualMarkUtils.b());
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
      int m;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("IRResource"))
        {
          paramString = localJSONObject.optJSONObject("IRResource");
          localMutualMarkConfBean.a = paramString.optString("path");
          localMutualMarkConfBean.b = paramString.optString("md5");
          localMutualMarkConfBean.c = paramString.optString("c2cIntimateUrl");
          localMutualMarkConfBean.d = paramString.optString("intimateListUrl");
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
        a(paramString, localMutualMarkConfBean.h);
        a((JSONArray)localObject1, localMutualMarkConfBean.i);
        a((JSONArray)localObject2, localMutualMarkConfBean.j);
        if (localJSONObject.has("IRType"))
        {
          paramString = localJSONObject.optJSONArray("IRType");
          m = 0;
          if (m < paramString.length())
          {
            localObject1 = MutualMarkConfigIRType.a(paramString.getJSONObject(m));
            if (localObject1 == null) {
              break label595;
            }
            if (localMutualMarkConfBean.j.contains(Long.valueOf(((MutualMarkConfigIRType)localObject1).a)))
            {
              ((MutualMarkConfigIRType)localObject1).d = true;
              ((MutualMarkConfigIRType)localObject1).e = localMutualMarkConfBean.j.indexOf(Long.valueOf(((MutualMarkConfigIRType)localObject1).a));
            }
            else
            {
              n = localMutualMarkConfBean.i.indexOf(Long.valueOf(((MutualMarkConfigIRType)localObject1).a));
              if (n >= 0) {
                ((MutualMarkConfigIRType)localObject1).e = n;
              }
            }
            int n = localMutualMarkConfBean.h.indexOf(Long.valueOf(((MutualMarkConfigIRType)localObject1).a));
            if (n >= 0) {
              ((MutualMarkConfigIRType)localObject1).c = n;
            }
            localMutualMarkConfBean.f.put(Long.valueOf(((MutualMarkConfigIRType)localObject1).a), localObject1);
            localMutualMarkConfBean.g.add(Long.valueOf(((MutualMarkConfigIRType)localObject1).a));
            break label595;
          }
        }
        if (!localJSONObject.has("resourceDomain")) {
          break label592;
        }
        localMutualMarkConfBean.k = new String(Base64Util.decode(localJSONObject.optString("resourceDomain"), 0));
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
      m += 1;
    }
  }
  
  private static void a(JSONArray paramJSONArray, ArrayList<Long> paramArrayList)
  {
    if (paramJSONArray == null) {
      return;
    }
    int m = 0;
    while (m < paramJSONArray.length())
    {
      paramArrayList.add(Long.valueOf(paramJSONArray.optLong(m)));
      m += 1;
    }
  }
  
  public boolean a(long paramLong)
  {
    MutualMarkConfigIRType localMutualMarkConfigIRType = (MutualMarkConfigIRType)this.f.get(Long.valueOf(paramLong));
    if (localMutualMarkConfigIRType != null) {
      return localMutualMarkConfigIRType.a();
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    MutualMarkConfigIRType localMutualMarkConfigIRType = (MutualMarkConfigIRType)this.f.get(Long.valueOf(paramLong1));
    if (localMutualMarkConfigIRType != null) {
      return localMutualMarkConfigIRType.b(paramLong2);
    }
    return false;
  }
  
  public MutualMarkConfigIRType.TypeItem b(long paramLong1, long paramLong2)
  {
    MutualMarkConfigIRType localMutualMarkConfigIRType = (MutualMarkConfigIRType)this.f.get(Long.valueOf(paramLong1));
    if (localMutualMarkConfigIRType != null) {
      return localMutualMarkConfigIRType.a(paramLong2);
    }
    return null;
  }
  
  public MutualMarkConfigIRType.TypeItem b(String paramString)
  {
    return b(MutualMarkUtils.b(paramString), MutualMarkUtils.a(paramString));
  }
  
  public MutualMarkConfigIRType b(long paramLong)
  {
    return (MutualMarkConfigIRType)this.f.get(Long.valueOf(paramLong));
  }
  
  public String b()
  {
    return new String(Base64Util.decode(MutualMarkConfProcessor.a().e, 0));
  }
  
  public int c(String paramString)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ((!TextUtils.isEmpty(((MutualMarkConfigIRType)localEntry.getValue()).b)) && (((MutualMarkConfigIRType)localEntry.getValue()).b.equals(paramString))) {
          return (int)((MutualMarkConfigIRType)localEntry.getValue()).a;
        }
      }
    }
    return 0;
  }
  
  public ArrayList<MutualMarkConfigIRType> c(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    MutualMarkConfigIRType localMutualMarkConfigIRType1 = (MutualMarkConfigIRType)this.f.get(Long.valueOf(paramLong));
    if ((localMutualMarkConfigIRType1 != null) && (!TextUtils.isEmpty(localMutualMarkConfigIRType1.b)))
    {
      Iterator localIterator = this.f.entrySet().iterator();
      while (localIterator.hasNext())
      {
        MutualMarkConfigIRType localMutualMarkConfigIRType2 = (MutualMarkConfigIRType)((Map.Entry)localIterator.next()).getValue();
        if ((localMutualMarkConfigIRType2 != null) && (localMutualMarkConfigIRType2.a != paramLong) && (TextUtils.equals(localMutualMarkConfigIRType1.b, localMutualMarkConfigIRType2.b))) {
          localArrayList.add(localMutualMarkConfigIRType2);
        }
      }
    }
    return localArrayList;
  }
  
  public String d(String paramString)
  {
    return new String(Base64Util.decode(MutualMarkConfProcessor.a().c, 0)).replace("xxx", paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkConfBean{iRResourcePath='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRResourcePathMd5='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRResourceC2cIntimateUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRResourceIntimateListUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRResourceEmojiEggSettingUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iRTypes=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", iRTypesSortForShowReactivePage=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", iRTypesSortForNormal=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", iRTypesSortForAIOTitleLeft1=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", iRTypesSortForAIOTitleLeft2=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", resourceDomain='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MutualMarkConfBean
 * JD-Core Version:    0.7.0.1
 */