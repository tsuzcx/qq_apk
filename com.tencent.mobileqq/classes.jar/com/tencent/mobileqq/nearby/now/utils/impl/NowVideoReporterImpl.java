package com.tencent.mobileqq.nearby.now.utils.impl;

import android.content.SharedPreferences;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

public class NowVideoReporterImpl
  implements INowVideoReporter
{
  public static String anchorUin = "";
  public static String feedId = "";
  public static String feedType = "";
  public static String from = "";
  public static long playTimeBegin;
  public static int rePlayCount;
  protected String d1 = "";
  protected String d2 = "";
  protected String d3 = "";
  protected String d4 = "";
  protected String feed_type = "";
  protected String feedid = "";
  boolean genderInd1 = false;
  boolean lvInd1 = false;
  protected int mCount = 1;
  protected int mOpIn;
  protected String mOpName = "";
  protected int mOpResult;
  protected String mOpType = "";
  protected String mToUin = "";
  protected String networktype = "";
  protected String source = "";
  protected String timelong = "";
  
  public NowVideoReporterImpl LvInd1()
  {
    this.lvInd1 = true;
    return this;
  }
  
  public NowVideoReporterImpl count(int paramInt)
  {
    this.mCount = paramInt;
    return this;
  }
  
  public NowVideoReporterImpl d1(String paramString)
  {
    this.d1 = paramString;
    return this;
  }
  
  public NowVideoReporterImpl d2(String paramString)
  {
    this.d2 = paramString;
    return this;
  }
  
  public NowVideoReporterImpl d3(String paramString)
  {
    this.d3 = paramString;
    return this;
  }
  
  public NowVideoReporterImpl d4(String paramString)
  {
    this.d4 = paramString;
    return this;
  }
  
  public NowVideoReporterImpl feed_type(String paramString)
  {
    this.feed_type = paramString;
    return this;
  }
  
  public NowVideoReporterImpl feedid(String paramString)
  {
    this.feedid = paramString;
    return this;
  }
  
  public NowVideoReporterImpl genderInd1()
  {
    this.genderInd1 = true;
    return this;
  }
  
  public String getAnchorUin()
  {
    return anchorUin;
  }
  
  public String getFeedId()
  {
    return feedId;
  }
  
  public String getFeedType()
  {
    return feedType;
  }
  
  public String getFrom()
  {
    return from;
  }
  
  public long getPlayTimeBegin()
  {
    return playTimeBegin;
  }
  
  public int getRePlayCount()
  {
    return rePlayCount;
  }
  
  public NowVideoReporterImpl networktype(String paramString)
  {
    this.networktype = paramString;
    return this;
  }
  
  public NowVideoReporterImpl opIn(int paramInt)
  {
    this.mOpIn = paramInt;
    return this;
  }
  
  public NowVideoReporterImpl opName(String paramString)
  {
    this.mOpName = paramString;
    return this;
  }
  
  public NowVideoReporterImpl opResult(int paramInt)
  {
    this.mOpResult = paramInt;
    return this;
  }
  
  public NowVideoReporterImpl opType(String paramString)
  {
    this.mOpType = paramString;
    return this;
  }
  
  public void report(AppInterface paramAppInterface)
  {
    paramAppInterface = (QQAppInterface)paramAppInterface;
    if ((this.lvInd1) && (paramAppInterface != null))
    {
      localObject1 = BaseApplicationImpl.getApplication();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("self_info");
      ((StringBuilder)localObject2).append(paramAppInterface.getCurrentAccountUin());
      this.d1 = String.valueOf(((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4).getInt("charm_level", 0));
    }
    if ((this.genderInd1) && (paramAppInterface != null))
    {
      this.genderInd1 = true;
      localObject1 = BaseApplicationImpl.getApplication();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("self_info");
      ((StringBuilder)localObject2).append(paramAppInterface.getCurrentAccountUin());
      this.d1 = String.valueOf(((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4).getInt("gender", 0));
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HttpUtil.getNetWorkType());
    ((StringBuilder)localObject1).append("");
    this.networktype = ((StringBuilder)localObject1).toString();
    localObject1 = this.mToUin;
    Object localObject2 = this.mOpType;
    String str1 = this.mOpName;
    int i = this.mOpIn;
    int j = this.mCount;
    int k = this.mOpResult;
    String str2 = this.d1;
    String str3 = this.d2;
    String str4 = this.d3;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d4);
    localStringBuilder.append("|");
    localStringBuilder.append(this.timelong);
    localStringBuilder.append("|");
    localStringBuilder.append(this.feedid);
    localStringBuilder.append("|");
    localStringBuilder.append(this.feed_type);
    localStringBuilder.append("|");
    localStringBuilder.append(this.source);
    localStringBuilder.append("|");
    localStringBuilder.append(this.networktype);
    ReportController.b(paramAppInterface, "dc02676", "grp_lbs", (String)localObject1, (String)localObject2, str1, i, j, k, str2, str3, str4, localStringBuilder.toString());
  }
  
  public void reportByVideo(AppInterface paramAppInterface)
  {
    paramAppInterface = (QQAppInterface)paramAppInterface;
    if (this.lvInd1)
    {
      localObject1 = BaseApplicationImpl.getApplication();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("self_info");
      ((StringBuilder)localObject2).append(paramAppInterface.getCurrentAccountUin());
      this.d1 = String.valueOf(((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4).getInt("charm_level", 0));
    }
    if (this.genderInd1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
      this.d1 = ((StringBuilder)localObject1).toString();
    }
    long l = System.currentTimeMillis() - playTimeBegin;
    if (l % 1000L > 500L) {
      i = (int)l / 1000 + 1;
    } else {
      i = (int)l / 1000;
    }
    l = i;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(l);
    ((StringBuilder)localObject1).append("");
    this.timelong = ((StringBuilder)localObject1).toString();
    this.feedid = feedId;
    this.feed_type = feedType;
    this.source = from;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HttpUtil.getNetWorkType());
    ((StringBuilder)localObject1).append("");
    this.networktype = ((StringBuilder)localObject1).toString();
    localObject1 = this.mToUin;
    Object localObject2 = this.mOpType;
    String str1 = this.mOpName;
    int i = this.mOpIn;
    int j = this.mCount;
    int k = this.mOpResult;
    String str2 = this.d1;
    String str3 = this.d2;
    String str4 = this.d3;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d4);
    localStringBuilder.append("|");
    localStringBuilder.append(this.timelong);
    localStringBuilder.append("|");
    localStringBuilder.append(this.feedid);
    localStringBuilder.append("|");
    localStringBuilder.append(this.feed_type);
    localStringBuilder.append("|");
    localStringBuilder.append(this.source);
    localStringBuilder.append("|");
    localStringBuilder.append(this.networktype);
    ReportController.b(paramAppInterface, "dc02676", "grp_lbs", (String)localObject1, (String)localObject2, str1, i, j, k, str2, str3, str4, localStringBuilder.toString());
  }
  
  public void setAnchorUin(String paramString)
  {
    anchorUin = paramString;
  }
  
  public void setFeedId(String paramString)
  {
    feedId = paramString;
  }
  
  public void setFeedType(String paramString)
  {
    feedType = paramString;
  }
  
  public void setFrom(String paramString)
  {
    from = paramString;
  }
  
  public void setPlayTimeBegin(long paramLong)
  {
    playTimeBegin = paramLong;
  }
  
  public void setRePlayCount(int paramInt)
  {
    rePlayCount = paramInt;
  }
  
  public NowVideoReporterImpl source(String paramString)
  {
    this.source = paramString;
    return this;
  }
  
  public NowVideoReporterImpl timelong(String paramString)
  {
    this.timelong = paramString;
    return this;
  }
  
  public NowVideoReporterImpl toUin(String paramString)
  {
    this.mToUin = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.impl.NowVideoReporterImpl
 * JD-Core Version:    0.7.0.1
 */