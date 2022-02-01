package com.tencent.ttpic.filter.aifilter;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class ReportInfo
  implements Serializable
{
  public static final int INVALID_VALUE = -999;
  private int accountType;
  @NotNull
  private String act;
  private int certification;
  @NotNull
  private String chatId;
  private int contentType;
  private String deviceInfo;
  private long duration;
  private int extInt1;
  private int extInt2;
  private int extInt3;
  private int extInt4;
  private int extInt5;
  @NotNull
  private String extStr1;
  @NotNull
  private String extStr2;
  @NotNull
  private String extStr3;
  @NotNull
  private String extStr4;
  @NotNull
  private String extStr5;
  @NotNull
  private String feedId;
  private int feedPraise;
  private int feedType;
  @NotNull
  private String feedUin;
  @NotNull
  private String filterId;
  @NotNull
  private String fromPage;
  @NotNull
  private String fromSubPage;
  private int homepage;
  private String imei;
  @NotNull
  private String loginSource;
  private int networkType;
  private String openid;
  @NotNull
  private String page;
  private String pageModule;
  private int pituAppid;
  private int position;
  private String qua;
  @NotNull
  private String recommendReason;
  private int relation;
  private int relationshipNumber;
  private int sex;
  private int shareChannel;
  private int shareType;
  private int status;
  @NotNull
  private String subPage;
  private long timestamp;
  @NotNull
  private String toUid;
  private String uid;
  
  public ReportInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.act = paramString1;
    this.page = paramString2;
    this.pageModule = paramString3;
    this.subPage = "";
    this.fromSubPage = "";
    this.fromPage = "";
    this.position = -999;
    this.feedId = "";
    this.feedType = -999;
    this.duration = -1L;
    this.toUid = "";
    this.recommendReason = "";
    this.homepage = -999;
    this.shareChannel = -999;
    this.shareType = -999;
    this.feedPraise = -999;
    this.relation = -999;
    this.relationshipNumber = -999;
    this.sex = -999;
    this.extStr1 = "";
    this.extStr2 = "";
    this.extStr3 = "";
    this.extStr4 = "";
    this.extStr5 = "";
    this.extInt1 = -999;
    this.extInt2 = -999;
    this.extInt3 = -999;
    this.extInt4 = -999;
    this.extInt5 = -999;
    this.loginSource = "";
    this.chatId = "";
    this.contentType = -999;
    this.feedUin = "";
    this.filterId = "";
    this.deviceInfo = "";
    this.imei = "";
    this.networkType = -999;
    this.pituAppid = -999;
    this.qua = "";
    this.uid = "";
    this.openid = "";
    this.accountType = -999;
    this.status = -999;
    this.certification = -999;
  }
  
  private final void buildDefaultParams() {}
  
  private final String convertName(String paramString)
  {
    if (paramString != null)
    {
      char[] arrayOfChar = paramString.toCharArray();
      int m = arrayOfChar.length;
      int j = 0;
      int i = 0;
      for (;;)
      {
        str = paramString;
        if (j >= m) {
          break;
        }
        char c = arrayOfChar[j];
        str = paramString;
        int k = i;
        if (Character.isUpperCase(c))
        {
          str = paramString.substring(0, i);
          paramString = paramString.substring(i + 1);
          str = str + "_" + Character.toLowerCase(c) + paramString;
          k = i + 1;
        }
        j += 1;
        i = k + 1;
        paramString = str;
      }
    }
    String str = paramString;
    return str;
  }
  
  @NotNull
  public final String buildEventName()
  {
    return String.format("%s#%s#%s", new Object[] { this.act, this.page, this.pageModule });
  }
  
  @Nullable
  public final JSONObject buildReportItemObj()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Field[] arrayOfField = getClass().getDeclaredFields();
        if (arrayOfField.length == 0) {
          return null;
        }
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localField = arrayOfField[i];
          localObject = localField.getType();
          if (localObject != String.class) {}
        }
      }
      catch (Exception localException)
      {
        int i;
        Field localField;
        Object localObject;
        Class localClass;
        localException.printStackTrace();
      }
      try
      {
        localObject = (String)localField.get(this);
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          localJSONObject.put(localField.getName(), localObject);
        }
      }
      catch (IllegalAccessException localIllegalAccessException3)
      {
        continue;
      }
      i += 1;
      continue;
      localObject = localField.getType();
      localClass = Integer.TYPE;
      if (localObject == localClass)
      {
        try
        {
          int k = ((Integer)localField.get(this)).intValue();
          if (k == -999) {
            continue;
          }
          localJSONObject.put(localField.getName(), k);
        }
        catch (IllegalAccessException localIllegalAccessException1) {}
      }
      else
      {
        localObject = localIllegalAccessException1.getType();
        localClass = Long.TYPE;
        if (localObject == localClass) {
          try
          {
            long l = ((Long)localIllegalAccessException1.get(this)).longValue();
            if (l > 0L) {
              localJSONObject.put(localIllegalAccessException1.getName(), l);
            }
          }
          catch (IllegalAccessException localIllegalAccessException2) {}
        }
      }
    }
    return localJSONObject;
  }
  
  @NotNull
  public final HashMap buildReportParams()
  {
    buildDefaultParams();
    HashMap localHashMap = new HashMap();
    Field[] arrayOfField = getClass().getDeclaredFields();
    if (arrayOfField.length == 0) {
      return localHashMap;
    }
    int i = arrayOfField.length;
    int j = arrayOfField.length;
    i = 0;
    if (i < j)
    {
      Field localField = arrayOfField[i];
      if (localField.getType() == String.class) {}
      for (;;)
      {
        try
        {
          String str = (String)localField.get(this);
          if ((str != null) && (str.length() > 0)) {
            localHashMap.put(convertName(localField.getName()), str);
          }
        }
        catch (IllegalAccessException localIllegalAccessException3)
        {
          continue;
        }
        i += 1;
        break;
        if (localField.getType() == Integer.TYPE) {
          try
          {
            int k = ((Integer)localField.get(this)).intValue();
            if (k == -999) {
              continue;
            }
            localHashMap.put(convertName(localField.getName()), String.valueOf(k));
          }
          catch (IllegalAccessException localIllegalAccessException1) {}
        } else if (localIllegalAccessException1.getType() == Long.TYPE) {
          try
          {
            long l = ((Long)localIllegalAccessException1.get(this)).longValue();
            if (l > 0L) {
              localHashMap.put(convertName(localIllegalAccessException1.getName()), String.valueOf(l));
            }
          }
          catch (IllegalAccessException localIllegalAccessException2) {}
        }
      }
    }
    return localHashMap;
  }
  
  @NotNull
  public final String getAct()
  {
    return this.act;
  }
  
  @NotNull
  public final String getChatId()
  {
    return this.chatId;
  }
  
  public final int getContentType()
  {
    return this.contentType;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final int getExtInt1()
  {
    return this.extInt1;
  }
  
  public final int getExtInt2()
  {
    return this.extInt2;
  }
  
  public final int getExtInt3()
  {
    return this.extInt3;
  }
  
  public final int getExtInt4()
  {
    return this.extInt4;
  }
  
  public final int getExtInt5()
  {
    return this.extInt5;
  }
  
  @NotNull
  public final String getExtStr1()
  {
    return this.extStr1;
  }
  
  @NotNull
  public final String getExtStr2()
  {
    return this.extStr2;
  }
  
  @NotNull
  public final String getExtStr3()
  {
    return this.extStr3;
  }
  
  @NotNull
  public final String getExtStr4()
  {
    return this.extStr4;
  }
  
  @NotNull
  public final String getExtStr5()
  {
    return this.extStr5;
  }
  
  @NotNull
  public final String getFeedId()
  {
    return this.feedId;
  }
  
  public final int getFeedPraise()
  {
    return this.feedPraise;
  }
  
  public final int getFeedType()
  {
    return this.feedType;
  }
  
  @NotNull
  public final String getFeedUin()
  {
    return this.feedUin;
  }
  
  @NotNull
  public final String getFilterId()
  {
    return this.filterId;
  }
  
  @NotNull
  public final String getFromPage()
  {
    return this.fromPage;
  }
  
  @NotNull
  public final String getFromSubPage()
  {
    return this.fromSubPage;
  }
  
  public final int getHomepage()
  {
    return this.homepage;
  }
  
  @NotNull
  public final String getLoginSource()
  {
    return this.loginSource;
  }
  
  @NotNull
  public final String getPage()
  {
    return this.page;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  @NotNull
  public final String getRecommendReason()
  {
    return this.recommendReason;
  }
  
  public final int getRelation()
  {
    return this.relation;
  }
  
  public final int getRelationshipNumber()
  {
    return this.relationshipNumber;
  }
  
  public final int getSex()
  {
    return this.sex;
  }
  
  public final int getShareChannel()
  {
    return this.shareChannel;
  }
  
  public final int getShareType()
  {
    return this.shareType;
  }
  
  @NotNull
  public final String getSubPage()
  {
    return this.subPage;
  }
  
  public final long getTimestamp()
  {
    return this.timestamp;
  }
  
  @NotNull
  public final String getToUid()
  {
    return this.toUid;
  }
  
  public final void reset()
  {
    Field[] arrayOfField = getClass().getDeclaredFields();
    if (arrayOfField.length != 0)
    {
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Field localField = arrayOfField[i];
        if ((localField.getName() == "serialVersionUID") || (localField.getName() == "act") || (localField.getName() == "page") || (localField.getName() == "pageModule")) {}
        for (;;)
        {
          i += 1;
          break;
          if (localField.getType() == String.class) {
            try
            {
              String str = (String)localField.get(this);
              if ((str == null) || (str.length() <= 0)) {
                continue;
              }
              localField.set(this, "");
            }
            catch (IllegalAccessException localIllegalAccessException1) {}
          } else if (localIllegalAccessException1.getType() == Integer.TYPE) {
            try
            {
              if (((Integer)localIllegalAccessException1.get(this)).intValue() == -999) {
                continue;
              }
              localIllegalAccessException1.set(this, Integer.valueOf(-999));
            }
            catch (IllegalAccessException localIllegalAccessException2) {}
          } else if (localIllegalAccessException2.getType() == Long.TYPE) {
            try
            {
              if (((Long)localIllegalAccessException2.get(this)).longValue() > 0L) {
                localIllegalAccessException2.set(this, Integer.valueOf(-1));
              }
            }
            catch (IllegalAccessException localIllegalAccessException3) {}
          }
        }
      }
    }
  }
  
  public final void setAct(@NotNull String paramString)
  {
    this.act = paramString;
  }
  
  public final void setChatId(@NotNull String paramString)
  {
    this.chatId = paramString;
  }
  
  public final void setContentType(int paramInt)
  {
    this.contentType = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setExtInt1(int paramInt)
  {
    this.extInt1 = paramInt;
  }
  
  public final void setExtInt2(int paramInt)
  {
    this.extInt2 = paramInt;
  }
  
  public final void setExtInt3(int paramInt)
  {
    this.extInt3 = paramInt;
  }
  
  public final void setExtInt4(int paramInt)
  {
    this.extInt4 = paramInt;
  }
  
  public final void setExtInt5(int paramInt)
  {
    this.extInt5 = paramInt;
  }
  
  public final void setExtStr1(@NotNull String paramString)
  {
    this.extStr1 = paramString;
  }
  
  public final void setExtStr2(@NotNull String paramString)
  {
    this.extStr2 = paramString;
  }
  
  public final void setExtStr3(@NotNull String paramString)
  {
    this.extStr3 = paramString;
  }
  
  public final void setExtStr4(@NotNull String paramString)
  {
    this.extStr4 = paramString;
  }
  
  public final void setExtStr5(@NotNull String paramString)
  {
    this.extStr5 = paramString;
  }
  
  public final void setFeedId(@NotNull String paramString)
  {
    this.feedId = paramString;
  }
  
  public final void setFeedInfo(@NotNull String paramString, int paramInt)
  {
    this.feedId = paramString;
    this.feedType = paramInt;
  }
  
  public final void setFeedInfo(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    this.feedId = paramString1;
    this.feedType = paramInt;
    this.recommendReason = paramString2;
    if (paramString2.length() == 0) {
      this.recommendReason = "none";
    }
  }
  
  public final void setFeedPraise(int paramInt)
  {
    this.feedPraise = paramInt;
  }
  
  public final void setFeedPraise(int paramInt1, int paramInt2)
  {
    this.feedPraise = paramInt1;
    this.relation = paramInt2;
  }
  
  public final void setFeedType(int paramInt)
  {
    this.feedType = paramInt;
  }
  
  public final void setFeedUin(@NotNull String paramString)
  {
    this.feedUin = paramString;
  }
  
  public final void setFilterId(@NotNull String paramString)
  {
    this.filterId = paramString;
  }
  
  public final void setFromPage(@NotNull String paramString)
  {
    this.fromPage = paramString;
  }
  
  public final void setFromSubPage(@NotNull String paramString)
  {
    this.fromSubPage = paramString;
  }
  
  public final void setHomepage(int paramInt)
  {
    this.homepage = paramInt;
  }
  
  public final void setLoginSource(@NotNull String paramString)
  {
    this.loginSource = paramString;
  }
  
  public final void setPage(@NotNull String paramString)
  {
    this.page = paramString;
  }
  
  public final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final void setRecmdUserInfo(@NotNull String paramString1, @NotNull String paramString2)
  {
    this.toUid = paramString1;
    this.recommendReason = paramString2;
    if (paramString2.length() == 0) {
      this.recommendReason = "none";
    }
  }
  
  public final void setRecommendReason(@NotNull String paramString)
  {
    this.recommendReason = paramString;
  }
  
  public final void setRelation(int paramInt)
  {
    this.relation = paramInt;
  }
  
  public final void setRelationshipNumber(int paramInt)
  {
    this.relationshipNumber = paramInt;
  }
  
  public final void setSex(int paramInt)
  {
    this.sex = paramInt;
  }
  
  public final void setShareChannel(int paramInt)
  {
    this.shareChannel = paramInt;
  }
  
  public final void setShareInfo(int paramInt1, int paramInt2)
  {
    this.shareType = paramInt1;
    this.shareChannel = paramInt2;
  }
  
  public final void setShareType(int paramInt)
  {
    this.shareType = paramInt;
  }
  
  public final void setSubPage(@NotNull String paramString)
  {
    this.subPage = paramString;
  }
  
  public final void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public final void setToUid(@NotNull String paramString)
  {
    this.toUid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.ReportInfo
 * JD-Core Version:    0.7.0.1
 */