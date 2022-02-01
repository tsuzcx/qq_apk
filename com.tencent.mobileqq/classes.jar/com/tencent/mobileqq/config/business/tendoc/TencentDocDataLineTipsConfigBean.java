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

public class TencentDocDataLineTipsConfigBean
{
  private boolean a = false;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private Map<String, String> j = new HashMap();
  private Map<String, TencentDocDataLineTipsConfigBean.KeyWords> k = new HashMap();
  private Map<String, String> l = new HashMap();
  private SparseArray<TencentDocDataLineTipsConfigBean.KeyWords> m = new SparseArray();
  private List<TencentDocDataLineTipsConfigBean.TeamworkKeyWords> n = new ArrayList();
  
  public static TencentDocDataLineTipsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      boolean bool = false;
      Object localObject1 = paramArrayOfQConfItem[0].b;
      paramArrayOfQConfItem = new TencentDocDataLineTipsConfigBean();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TencentDocDataLineTipsConfigBean", 2, "updateConfig json parse faild");
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
          Object localObject8 = paramArrayOfQConfItem.j;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fileType_");
          localStringBuilder.append((String)localObject6);
          ((Map)localObject8).put(localStringBuilder.toString(), localObject7);
          ((StringBuilder)localObject5).append((String)localObject7);
          ((StringBuilder)localObject5).append("|");
          localObject8 = new TencentDocDataLineTipsConfigBean.KeyWords();
          ((TencentDocDataLineTipsConfigBean.KeyWords)localObject8).d = a((String)localObject7);
          paramArrayOfQConfItem.k.put(localObject6, localObject8);
        }
        if (((StringBuilder)localObject5).length() > 0) {
          ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
        }
        if (((StringBuilder)localObject3).length() > 0) {
          ((StringBuilder)localObject3).deleteCharAt(((StringBuilder)localObject3).length() - 1);
        }
        paramArrayOfQConfItem.f = ((StringBuilder)localObject3).toString();
        paramArrayOfQConfItem.g = ((StringBuilder)localObject5).toString();
        localJSONObject = localJSONObject.optJSONObject("KeyWords");
        localObject2 = paramArrayOfQConfItem.k.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject6 = localJSONObject.optJSONObject((String)localObject3);
          localObject4 = (TencentDocDataLineTipsConfigBean.KeyWords)paramArrayOfQConfItem.k.get(localObject3);
          localObject5 = ((JSONObject)localObject6).optString("key");
          ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).a = a((String)localObject5);
          if (paramArrayOfQConfItem.d == 1)
          {
            ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).b = ((JSONObject)localObject6).optString("Tips1");
            ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).c = ((JSONObject)localObject6).optString("Link1");
          }
          else
          {
            ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).b = ((JSONObject)localObject6).optString("Tips0");
            ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).c = ((JSONObject)localObject6).optString("Link0");
          }
          paramArrayOfQConfItem.k.put(localObject3, localObject4);
          localObject6 = paramArrayOfQConfItem.l;
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("key_str_key_words");
          ((StringBuilder)localObject7).append((String)localObject3);
          ((Map)localObject6).put(((StringBuilder)localObject7).toString(), localObject5);
          localObject5 = paramArrayOfQConfItem.l;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("key_str_key_tips");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((Map)localObject5).put(((StringBuilder)localObject6).toString(), ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).b);
          localObject5 = paramArrayOfQConfItem.l;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("key_str_key_link");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((Map)localObject5).put(((StringBuilder)localObject6).toString(), ((TencentDocDataLineTipsConfigBean.KeyWords)localObject4).c);
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("Text");
        if (localObject1 != null)
        {
          paramArrayOfQConfItem.h = ((JSONObject)localObject1).toString();
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
        QLog.e("TencentDocDataLineTipsConfigBean", 2, localException.toString());
        localException.printStackTrace();
      }
      return paramArrayOfQConfItem;
    }
    return null;
  }
  
  private static void a(JSONObject paramJSONObject, TencentDocDataLineTipsConfigBean paramTencentDocDataLineTipsConfigBean)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("template_list");
    int i1 = 0;
    while (i1 < localJSONArray.length())
    {
      int i3 = localJSONArray.getJSONObject(i1).optInt("template_type", -1);
      TencentDocDataLineTipsConfigBean.KeyWords localKeyWords = new TencentDocDataLineTipsConfigBean.KeyWords();
      paramTencentDocDataLineTipsConfigBean.e = paramJSONObject.optInt("containKeyword");
      if (paramTencentDocDataLineTipsConfigBean.e == 1)
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
      paramTencentDocDataLineTipsConfigBean.m.put(i2, localKeyWords);
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
        QLog.i("TencentDocDataLineTipsConfigBean", 1, ((StringBuilder)localObject).toString());
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
  
  public int a()
  {
    return this.b;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = "";
    } else {
      localObject = paramJSONObject.toString();
    }
    this.i = ((String)localObject);
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
          break label217;
        }
        this.a = false;
        return;
      }
      catch (Exception paramJSONObject)
      {
        int i3;
        int i2;
        JSONObject localJSONObject;
        TencentDocDataLineTipsConfigBean.TeamworkKeyWords localTeamworkKeyWords;
        QLog.e("TencentDocDataLineTipsConfigBean", 2, paramJSONObject.toString());
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
            localTeamworkKeyWords = new TencentDocDataLineTipsConfigBean.TeamworkKeyWords();
            localTeamworkKeyWords.a = localJSONObject.optString("template_name");
            localTeamworkKeyWords.b = localJSONObject.optInt("template_id", -1);
            if (localTeamworkKeyWords.b == -1) {
              QLog.d("TencentDocDataLineTipsConfigBean", 2, "template has no id");
            }
            localTeamworkKeyWords.c = i3;
            this.n.add(localTeamworkKeyWords);
            i2 += 1;
            continue;
          }
        }
        i1 += 1;
      }
      else
      {
        label217:
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
  
  public int b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public Map<String, TencentDocDataLineTipsConfigBean.KeyWords> e()
  {
    return this.k;
  }
  
  public List<TencentDocDataLineTipsConfigBean.TeamworkKeyWords> f()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigBean
 * JD-Core Version:    0.7.0.1
 */