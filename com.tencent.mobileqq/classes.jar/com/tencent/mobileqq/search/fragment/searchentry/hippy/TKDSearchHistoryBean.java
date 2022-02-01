package com.tencent.mobileqq.search.fragment.searchentry.hippy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class TKDSearchHistoryBean
{
  private String aid;
  private int fromWhere;
  private int id;
  private String jsonStr;
  private String keyword;
  private String label;
  private String title;
  private String url;
  
  @NonNull
  public static TKDSearchHistoryBean createFromJson(@NonNull JsonObject paramJsonObject)
  {
    TKDSearchHistoryBean localTKDSearchHistoryBean = new TKDSearchHistoryBean();
    try
    {
      paramJsonObject = (TKDSearchHistoryBean)new Gson().fromJson(paramJsonObject, TKDSearchHistoryBean.class);
      return paramJsonObject;
    }
    catch (Exception paramJsonObject)
    {
      label27:
      break label27;
    }
    return localTKDSearchHistoryBean;
  }
  
  @NonNull
  public static TKDSearchHistoryBean createFromKeyword(@NonNull String paramString)
  {
    TKDSearchHistoryBean localTKDSearchHistoryBean = new TKDSearchHistoryBean();
    localTKDSearchHistoryBean.keyword = paramString;
    localTKDSearchHistoryBean.title = paramString;
    localTKDSearchHistoryBean.url = paramString;
    localTKDSearchHistoryBean.fromWhere = 5;
    localTKDSearchHistoryBean.id = paramString.hashCode();
    return localTKDSearchHistoryBean;
  }
  
  @NonNull
  private String safetyStrValue(@Nullable String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (TKDSearchHistoryBean)paramObject;
      return this.id == paramObject.id;
    }
    return false;
  }
  
  @NonNull
  public String getAid()
  {
    return safetyStrValue(this.aid);
  }
  
  public int getFromWhere()
  {
    return this.fromWhere;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  @NonNull
  public String getJsonStr()
  {
    return safetyStrValue(this.jsonStr);
  }
  
  @NonNull
  public String getKeyword()
  {
    return safetyStrValue(this.keyword);
  }
  
  @NonNull
  public String getLabel()
  {
    return safetyStrValue(this.label);
  }
  
  @NonNull
  public String getTitle()
  {
    return safetyStrValue(this.title);
  }
  
  @NonNull
  public String getUrl()
  {
    return safetyStrValue(this.url);
  }
  
  public int hashCode()
  {
    return this.id;
  }
  
  public void setAid(String paramString)
  {
    this.aid = paramString;
  }
  
  public void setFromWhere(int paramInt)
  {
    this.fromWhere = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setJsonStr(String paramString)
  {
    this.jsonStr = paramString;
  }
  
  public void setKeyword(String paramString)
  {
    this.keyword = paramString;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  @NonNull
  public String toJsonStr()
  {
    try
    {
      String str = new Gson().toJson(this);
      return str;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    return new JsonObject().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hippy.TKDSearchHistoryBean
 * JD-Core Version:    0.7.0.1
 */