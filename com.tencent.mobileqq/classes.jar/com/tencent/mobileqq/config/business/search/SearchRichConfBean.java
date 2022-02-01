package com.tencent.mobileqq.config.business.search;

import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchRichConfBean
{
  private int a = 0;
  private int b = 1;
  private int c = 1;
  private int d = 1;
  private int e = 1;
  private int f = 1;
  private ArrayMap<String, ArrayList<SearchRichConfBean.RichBaseTemplate>> g = new ArrayMap(5);
  
  public static SearchRichConfBean a()
  {
    return (SearchRichConfBean)QConfigManager.b().b(432);
  }
  
  public static SearchRichConfBean a(QConfItem paramQConfItem)
  {
    SearchRichConfBean localSearchRichConfBean = new SearchRichConfBean();
    Object localObject;
    if (paramQConfItem != null) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse taskid->");
        ((StringBuilder)localObject).append(paramQConfItem.a);
        ((StringBuilder)localObject).append(" content->");
        ((StringBuilder)localObject).append(paramQConfItem.b);
        QLog.d("SearchRichConfBean", 2, ((StringBuilder)localObject).toString());
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.b);
        i = 0;
        int j = paramQConfItem.optInt("switch", 0);
        int k = paramQConfItem.optInt("ftsEnableMsgSwitch", 1);
        int m = paramQConfItem.optInt("showMessageResult", 1);
        int n = paramQConfItem.optInt("ftsEnableSwitch", 1);
        int i1 = paramQConfItem.optInt("ftsEnableTroopSwitch", 1);
        int i2 = paramQConfItem.optInt("ftsEnableFtsFilter", 1);
        localSearchRichConfBean.a(j);
        localSearchRichConfBean.b(k);
        localSearchRichConfBean.c(m);
        localSearchRichConfBean.c = n;
        localSearchRichConfBean.e = i1;
        localSearchRichConfBean.f = i2;
        paramQConfItem = paramQConfItem.optJSONArray("templateinfo");
        if (paramQConfItem != null)
        {
          localObject = new ArrayList(10);
          ArrayList localArrayList = new ArrayList(10);
          j = paramQConfItem.length();
          if (i < j)
          {
            JSONObject localJSONObject = paramQConfItem.optJSONObject(i);
            if (localJSONObject == null) {
              break label422;
            }
            SearchRichConfBean.RichBaseTemplate localRichBaseTemplate = new SearchRichConfBean.RichBaseTemplate();
            localRichBaseTemplate.a = localJSONObject.optInt("templateid");
            localRichBaseTemplate.b = localJSONObject.optString("templatetype");
            localRichBaseTemplate.d = localJSONObject.optString("templatever");
            localRichBaseTemplate.c = localJSONObject.optString("templatename");
            localRichBaseTemplate.e = localJSONObject.optString("templateview");
            if ("ark".equals(localRichBaseTemplate.b))
            {
              ((ArrayList)localObject).add(localRichBaseTemplate);
              break label422;
            }
            if (!"native".equals(localRichBaseTemplate.b)) {
              break label422;
            }
            localArrayList.add(localRichBaseTemplate);
            break label422;
          }
          localSearchRichConfBean.a("ark", (ArrayList)localObject);
          localSearchRichConfBean.a("native", localArrayList);
          return localSearchRichConfBean;
        }
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parse error->");
          ((StringBuilder)localObject).append(paramQConfItem.toString());
          QLog.d("SearchRichConfBean", 2, ((StringBuilder)localObject).toString());
        }
      }
      return localSearchRichConfBean;
      label422:
      i += 1;
    }
  }
  
  public ArrayList<SearchRichConfBean.RichBaseTemplate> a(String paramString)
  {
    ArrayMap localArrayMap = this.g;
    if (localArrayMap != null) {
      return (ArrayList)localArrayMap.get(paramString);
    }
    return null;
  }
  
  void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(String paramString, ArrayList<SearchRichConfBean.RichBaseTemplate> paramArrayList)
  {
    ArrayMap localArrayMap = this.g;
    if ((localArrayMap != null) && (paramString != null)) {
      localArrayMap.put(paramString, paramArrayList);
    }
  }
  
  void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean b()
  {
    return this.a == 1;
  }
  
  void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean c()
  {
    return this.c == 1;
  }
  
  public boolean d()
  {
    return this.e == 1;
  }
  
  public boolean e()
  {
    return this.f == 1;
  }
  
  public boolean f()
  {
    return this.d == 1;
  }
  
  public boolean g()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    int i = this.a;
    Object localObject = this.g;
    if (localObject != null) {
      localObject = ((ArrayMap)localObject).toString();
    } else {
      localObject = "null";
    }
    return String.format("mRichSwitch:%d  templateData:%s", new Object[] { Integer.valueOf(i), localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchRichConfBean
 * JD-Core Version:    0.7.0.1
 */