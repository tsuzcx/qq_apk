package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;

public class TencentDocTipsConfigBean
{
  private boolean a = false;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private double h = 0.0D;
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private Map<String, String> o = new HashMap();
  private Map<String, TencentDocTipsConfigBean.KeyWords> p = new HashMap();
  private Map<String, String> q = new HashMap();
  private SparseArray<TencentDocTipsConfigBean.KeyWords> r = new SparseArray();
  private List<TencentDocTipsConfigBean.TeamworkKeyWords> s = new ArrayList();
  
  public static TencentDocTipsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      boolean bool = false;
      Object localObject1 = paramArrayOfQConfItem[0].b;
      paramArrayOfQConfItem = new TencentDocTipsConfigBean();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TencentDocTipsConfigBean", 2, "updateConfig json parse faild");
        }
        return paramArrayOfQConfItem;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("File");
        paramArrayOfQConfItem.b = localJSONObject.optInt("maxCount");
        paramArrayOfQConfItem.c = localJSONObject.optInt("insertDur");
        Object localObject2 = localJSONObject.optJSONObject("fileType");
        Object localObject3 = new StringBuilder();
        Object localObject4 = ((JSONObject)localObject2).keys();
        Object localObject5 = new StringBuilder();
        Object localObject6;
        Object localObject7;
        while (((Iterator)localObject4).hasNext())
        {
          localObject6 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject6);
          ((StringBuilder)localObject3).append("|");
          localObject7 = ((JSONObject)localObject2).getString((String)localObject6);
          Object localObject8 = paramArrayOfQConfItem.o;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fileType_");
          localStringBuilder.append((String)localObject6);
          ((Map)localObject8).put(localStringBuilder.toString(), localObject7);
          ((StringBuilder)localObject5).append((String)localObject7);
          ((StringBuilder)localObject5).append("|");
          localObject8 = new TencentDocTipsConfigBean.KeyWords();
          ((TencentDocTipsConfigBean.KeyWords)localObject8).d = a((String)localObject7);
          paramArrayOfQConfItem.p.put(localObject6, localObject8);
        }
        if (((StringBuilder)localObject5).length() > 0) {
          ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
        }
        if (((StringBuilder)localObject3).length() > 0) {
          ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
        }
        paramArrayOfQConfItem.k = ((StringBuilder)localObject3).toString();
        paramArrayOfQConfItem.l = ((StringBuilder)localObject5).toString();
        localObject2 = localJSONObject.optJSONObject("Similarity");
        paramArrayOfQConfItem.d = ((JSONObject)localObject2).optInt("durTime");
        paramArrayOfQConfItem.e = ((JSONObject)localObject2).optInt("maxQuery");
        paramArrayOfQConfItem.h = ((JSONObject)localObject2).getDouble("Percentage");
        paramArrayOfQConfItem.i = ((JSONObject)localObject2).optString("Tips");
        paramArrayOfQConfItem.j = ((JSONObject)localObject2).optString("Link");
        localJSONObject = localJSONObject.optJSONObject("KeyWords");
        localObject2 = paramArrayOfQConfItem.p.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject6 = localJSONObject.optJSONObject((String)localObject3);
          localObject4 = (TencentDocTipsConfigBean.KeyWords)paramArrayOfQConfItem.p.get(localObject3);
          localObject5 = ((JSONObject)localObject6).optString("key");
          ((TencentDocTipsConfigBean.KeyWords)localObject4).a = a((String)localObject5);
          if (paramArrayOfQConfItem.f == 1)
          {
            ((TencentDocTipsConfigBean.KeyWords)localObject4).b = ((JSONObject)localObject6).optString("Tips1");
            ((TencentDocTipsConfigBean.KeyWords)localObject4).c = ((JSONObject)localObject6).optString("Link1");
          }
          else
          {
            ((TencentDocTipsConfigBean.KeyWords)localObject4).b = ((JSONObject)localObject6).optString("Tips0");
            ((TencentDocTipsConfigBean.KeyWords)localObject4).c = ((JSONObject)localObject6).optString("Link0");
          }
          paramArrayOfQConfItem.p.put(localObject3, localObject4);
          localObject6 = paramArrayOfQConfItem.q;
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("key_str_key_words");
          ((StringBuilder)localObject7).append((String)localObject3);
          ((Map)localObject6).put(((StringBuilder)localObject7).toString(), localObject5);
          localObject5 = paramArrayOfQConfItem.q;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("key_str_key_tips");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((Map)localObject5).put(((StringBuilder)localObject6).toString(), ((TencentDocTipsConfigBean.KeyWords)localObject4).b);
          localObject5 = paramArrayOfQConfItem.q;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("key_str_key_link");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((Map)localObject5).put(((StringBuilder)localObject6).toString(), ((TencentDocTipsConfigBean.KeyWords)localObject4).c);
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("Text");
        if (localObject1 != null)
        {
          paramArrayOfQConfItem.m = ((JSONObject)localObject1).toString();
          if (((JSONObject)localObject1).optInt("textSwitch", 0) == 1) {
            bool = true;
          }
          paramArrayOfQConfItem.a = bool;
          a((JSONObject)localObject1, paramArrayOfQConfItem);
          return paramArrayOfQConfItem;
        }
      }
      catch (Exception localException)
      {
        QLog.e("TencentDocTipsConfigBean", 2, localException.toString());
        localException.printStackTrace();
      }
      return paramArrayOfQConfItem;
    }
    return null;
  }
  
  private static void a(JSONObject paramJSONObject, TencentDocTipsConfigBean paramTencentDocTipsConfigBean)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i1 = 0;
    while (i1 < localJSONArray.length())
    {
      int i3 = localJSONArray.getJSONObject(i1).optInt("template_type", -1);
      TencentDocTipsConfigBean.KeyWords localKeyWords = new TencentDocTipsConfigBean.KeyWords();
      paramTencentDocTipsConfigBean.g = paramJSONObject.optInt("containKeyword");
      if (paramTencentDocTipsConfigBean.g == 1)
      {
        localKeyWords.b = paramJSONObject.optString("Tips1");
        localKeyWords.c = paramJSONObject.optString("Link1");
      }
      else
      {
        localKeyWords.b = paramJSONObject.optString("Tips0");
        localKeyWords.c = paramJSONObject.optString("Link0");
      }
      int i2 = i3;
      if (i3 == -1) {
        i2 = i1;
      }
      paramTencentDocTipsConfigBean.r.put(i2, localKeyWords);
      i1 += 1;
    }
  }
  
  private static String[] a(String paramString)
  {
    Object localObject = new StringTokenizer(paramString, "|");
    boolean bool = ((StringTokenizer)localObject).hasMoreTokens();
    int i1 = 0;
    if (!bool)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("split String faild :");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("TencentDocTipsConfigBean", 1, ((StringBuilder)localObject).toString());
      }
      return new String[0];
    }
    paramString = new String[((StringTokenizer)localObject).countTokens()];
    while (((StringTokenizer)localObject).hasMoreTokens())
    {
      paramString[i1] = ((StringTokenizer)localObject).nextToken();
      i1 += 1;
    }
    return paramString;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = "";
    } else {
      localObject = paramJSONObject.toString();
    }
    this.n = ((String)localObject);
    if (paramJSONObject == null)
    {
      this.a = false;
      return;
    }
    for (;;)
    {
      int i1;
      try
      {
        localObject = paramJSONObject.optJSONArray("template_list");
        if (paramJSONObject.optInt("retcode", -1) == 0) {
          break label219;
        }
        this.a = false;
        return;
      }
      catch (Exception paramJSONObject)
      {
        int i3;
        int i2;
        JSONObject localJSONObject;
        TencentDocTipsConfigBean.TeamworkKeyWords localTeamworkKeyWords;
        QLog.e("TencentDocTipsConfigBean", 2, paramJSONObject.toString());
      }
      if (i1 < ((JSONArray)localObject).length())
      {
        paramJSONObject = ((JSONArray)localObject).getJSONObject(i1);
        i3 = paramJSONObject.optInt("template_type", -1);
        if (paramJSONObject.optJSONArray("infos") != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("infos");
          i2 = 0;
          if (i2 < paramJSONObject.length())
          {
            localJSONObject = paramJSONObject.getJSONObject(i2);
            localTeamworkKeyWords = new TencentDocTipsConfigBean.TeamworkKeyWords();
            localTeamworkKeyWords.a = localJSONObject.optString("template_name");
            localTeamworkKeyWords.b = localJSONObject.optInt("template_id", -1);
            if (localTeamworkKeyWords.b == -1) {
              QLog.d("TencentDocTipsConfigBean", 2, "template has no id");
            }
            localTeamworkKeyWords.c = i3;
            this.s.add(localTeamworkKeyWords);
            i2 += 1;
            continue;
          }
        }
        i1 += 1;
      }
      else
      {
        label219:
        while (localObject == null) {
          return;
        }
        i1 = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public double e()
  {
    return this.h;
  }
  
  public String f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.j;
  }
  
  public String h()
  {
    return this.l;
  }
  
  public String i()
  {
    return this.m;
  }
  
  public Map<String, TencentDocTipsConfigBean.KeyWords> j()
  {
    return this.p;
  }
  
  public SparseArray<TencentDocTipsConfigBean.KeyWords> k()
  {
    return this.r;
  }
  
  public List<TencentDocTipsConfigBean.TeamworkKeyWords> l()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean
 * JD-Core Version:    0.7.0.1
 */