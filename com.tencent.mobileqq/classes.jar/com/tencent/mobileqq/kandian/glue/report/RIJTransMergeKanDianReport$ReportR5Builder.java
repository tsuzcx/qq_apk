package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.report.api.IReportR5Builder;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.RelatedSearchData.SearchWord;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJTransMergeKanDianReport$ReportR5Builder
  implements IReportR5Builder
{
  int channelId = -1;
  String channelVersion = null;
  int guideRedDotStyle = 1;
  boolean isIconTab = false;
  JSONObject r5 = new JSONObject();
  int refreshCategory = -1;
  boolean reportAntiCheat = false;
  boolean reportFolderStatus = false;
  boolean reportGuideRedStyle = false;
  boolean reportKandianMode = false;
  boolean reportKandianModeNew = false;
  boolean reportOS = false;
  boolean reportRedStyle = false;
  boolean reportSessionId = false;
  boolean reportTabSource = false;
  boolean reportTime = false;
  String skinId = null;
  int skinVoice = -1;
  
  public RIJTransMergeKanDianReport$ReportR5Builder() {}
  
  public RIJTransMergeKanDianReport$ReportR5Builder(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.r5 = paramJSONObject;
    }
  }
  
  public ReportR5Builder addAdRelativePos(int paramInt)
  {
    this.r5.put("ad_relative_pos", paramInt);
    return this;
  }
  
  public ReportR5Builder addAlgorithmId(long paramLong)
  {
    this.r5.put("algorithm_id", paramLong);
    return this;
  }
  
  public ReportR5Builder addAlgorithmId(String paramString)
  {
    this.r5.put("algorithm_id", paramString);
    return this;
  }
  
  public ReportR5Builder addAntiCheat()
  {
    this.reportAntiCheat = true;
    return this;
  }
  
  public ReportR5Builder addArticleID(long paramLong)
  {
    this.r5.put("article_id", paramLong);
    return this;
  }
  
  public ReportR5Builder addBiu(int paramInt)
  {
    this.r5.put("biu", paramInt);
    return this;
  }
  
  public ReportR5Builder addButtonState(boolean paramBoolean)
  {
    this.r5.put("button_state", paramBoolean ^ true);
    return this;
  }
  
  public ReportR5Builder addChannelCity(String paramString)
  {
    JSONObject localJSONObject = this.r5;
    if (paramString == null) {
      paramString = "";
    }
    localJSONObject.put("channel_city", paramString);
    return this;
  }
  
  public ReportR5Builder addChannelId(int paramInt)
  {
    this.channelId = paramInt;
    return this;
  }
  
  public ReportR5Builder addChannelTabType(boolean paramBoolean)
  {
    this.isIconTab = paramBoolean;
    return this;
  }
  
  public ReportR5Builder addChannelVersion(String paramString)
  {
    JSONObject localJSONObject = this.r5;
    if (paramString == null) {
      paramString = "";
    }
    localJSONObject.put("channel_version", paramString);
    return this;
  }
  
  public ReportR5Builder addComments(int paramInt)
  {
    this.r5.put("comment", paramInt);
    return this;
  }
  
  public ReportR5Builder addContentType(int paramInt)
  {
    this.r5.put("content_type", paramInt);
    return this;
  }
  
  public ReportR5Builder addFeedSources(String paramString)
  {
    this.r5.put("feeds_source", paramString);
    return this;
  }
  
  public ReportR5Builder addFeedsType(int paramInt)
  {
    this.r5.put("feeds_type", paramInt);
    return this;
  }
  
  public ReportR5Builder addFolderStatus()
  {
    this.reportFolderStatus = true;
    return this;
  }
  
  public ReportR5Builder addGuideRedStyle(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    this.reportGuideRedStyle = true;
    if ((RIJXTabBadgeStore.a.d(paramTabChannelCoverInfo.mChannelCoverId)) && (paramTabChannelCoverInfo.needBadgeGuide))
    {
      this.guideRedDotStyle = 1;
      return this;
    }
    if (RIJXTabBadgeStore.b(paramTabChannelCoverInfo.mChannelCoverId) != null)
    {
      this.guideRedDotStyle = 2;
      return this;
    }
    this.guideRedDotStyle = 0;
    return this;
  }
  
  public ReportR5Builder addIMEI()
  {
    this.r5.put("imei", RIJDeviceUtil.a());
    return this;
  }
  
  public ReportR5Builder addIMSI()
  {
    this.r5.put("imsi", RIJDeviceUtil.b());
    return this;
  }
  
  public ReportR5Builder addInt(String paramString, int paramInt)
  {
    this.r5.put(paramString, paramInt);
    return this;
  }
  
  public ReportR5Builder addJSONObject(@NotNull JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      try
      {
        this.r5.put(str, localObject);
      }
      catch (JSONException localJSONException)
      {
        label45:
        StringBuilder localStringBuilder;
        break label45;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" : ");
      localStringBuilder.append(localObject);
      AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(localStringBuilder.toString()));
    }
    return this;
  }
  
  public ReportR5Builder addKandianMode()
  {
    this.reportKandianMode = true;
    return this;
  }
  
  public ReportR5Builder addKandianModeNew()
  {
    this.reportKandianModeNew = true;
    return this;
  }
  
  public ReportR5Builder addLikes(int paramInt)
  {
    this.r5.put("likes", paramInt);
    return this;
  }
  
  public ReportR5Builder addLocation(int paramInt)
  {
    this.r5.put("location", paramInt);
    return this;
  }
  
  public ReportR5Builder addNetworkType()
  {
    JSONObject localJSONObject = this.r5;
    int i;
    if (NetworkUtil.isWifiConnected(null)) {
      i = 2;
    } else {
      i = 1;
    }
    localJSONObject.put("network_type", i);
    return this;
  }
  
  public ReportR5Builder addNumber(int paramInt)
  {
    this.r5.put("number", paramInt);
    return this;
  }
  
  public ReportR5Builder addOS()
  {
    this.reportOS = true;
    return this;
  }
  
  public ReportR5Builder addRedDotNum(int paramInt)
  {
    this.r5.put("reddot_num", paramInt);
    return this;
  }
  
  public ReportR5Builder addRedDotStatus(int paramInt)
  {
    this.r5.put("reddot_status", paramInt + 1);
    return this;
  }
  
  public ReportR5Builder addRedDotStatus(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.r5;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 0;
    }
    localJSONObject.put("reddot_status", i);
    return this;
  }
  
  public ReportR5Builder addRedStyle()
  {
    this.reportRedStyle = true;
    return this;
  }
  
  public ReportR5Builder addReddot(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.r5;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    localJSONObject.put("reddot", i);
    return this;
  }
  
  public ReportR5Builder addRefreshCategory(int paramInt)
  {
    this.refreshCategory = paramInt;
    return this;
  }
  
  public ReportR5Builder addRelatedSearch(RelatedSearchData.SearchWord paramSearchWord, int paramInt)
  {
    if (paramSearchWord != null)
    {
      this.r5.put("modelID", paramSearchWord.e);
      this.r5.put("modelName", paramSearchWord.d);
      this.r5.put("score", paramSearchWord.c);
      this.r5.put("searchWord", paramSearchWord.a);
      this.r5.put("position", paramInt);
    }
    return this;
  }
  
  public ReportR5Builder addRowkey(String paramString)
  {
    this.r5.put("rowkey", paramString);
    return this;
  }
  
  public ReportR5Builder addSessionId()
  {
    this.reportSessionId = true;
    return this;
  }
  
  public ReportR5Builder addShareOption(int paramInt)
  {
    this.r5.put("share_option", paramInt);
    return this;
  }
  
  public ReportR5Builder addSid(String paramString)
  {
    JSONObject localJSONObject = this.r5;
    if (paramString == null) {
      paramString = "";
    }
    localJSONObject.put("sid", paramString);
    return this;
  }
  
  public ReportR5Builder addSkinId(String paramString)
  {
    this.skinId = paramString;
    return this;
  }
  
  public ReportR5Builder addSkinVoice(int paramInt)
  {
    this.skinVoice = paramInt;
    return this;
  }
  
  public ReportR5Builder addStrategyID(long paramLong)
  {
    this.r5.put("strategy_id", paramLong);
    return this;
  }
  
  public ReportR5Builder addStrategyID(String paramString)
  {
    this.r5.put("strategy_id", paramString);
    return this;
  }
  
  public ReportR5Builder addString(String paramString1, String paramString2)
  {
    this.r5.put(paramString1, paramString2);
    return this;
  }
  
  public ReportR5Builder addStringNotThrow(String paramString, int paramInt)
  {
    try
    {
      this.r5.put(paramString, paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      label12:
      StringBuilder localStringBuilder;
      break label12;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" : ");
    localStringBuilder.append(paramInt);
    AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(localStringBuilder.toString()));
    return this;
  }
  
  public ReportR5Builder addStringNotThrow(String paramString, long paramLong)
  {
    try
    {
      this.r5.put(paramString, paramLong);
      return this;
    }
    catch (JSONException localJSONException)
    {
      label12:
      StringBuilder localStringBuilder;
      break label12;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" : ");
    localStringBuilder.append(paramLong);
    AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(localStringBuilder.toString()));
    return this;
  }
  
  public ReportR5Builder addStringNotThrow(String paramString1, String paramString2)
  {
    try
    {
      this.r5.put(paramString1, paramString2);
      return this;
    }
    catch (JSONException localJSONException)
    {
      label12:
      StringBuilder localStringBuilder;
      break label12;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" : ");
    localStringBuilder.append(paramString2);
    AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(localStringBuilder.toString()));
    return this;
  }
  
  public ReportR5Builder addTabSource()
  {
    this.reportTabSource = true;
    return this;
  }
  
  public ReportR5Builder addTime()
  {
    this.reportTime = true;
    return this;
  }
  
  public ReportR5Builder addTitle(String paramString)
  {
    JSONObject localJSONObject = this.r5;
    if (paramString == null) {
      paramString = "";
    }
    localJSONObject.put("title", paramString);
    return this;
  }
  
  public ReportR5Builder addTopicId(long paramLong)
  {
    this.r5.put("topicid", paramLong);
    return this;
  }
  
  public ReportR5Builder addType(int paramInt)
  {
    this.r5.put("type", paramInt);
    return this;
  }
  
  public ReportR5Builder addUniqueID(String paramString)
  {
    this.r5.put("uniqueID", paramString);
    return this;
  }
  
  public ReportR5Builder addValueSafe(String paramString, Object paramObject)
  {
    try
    {
      this.r5.put(paramString, paramObject);
      return this;
    }
    catch (JSONException localJSONException)
    {
      label12:
      StringBuilder localStringBuilder;
      break label12;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" : ");
    localStringBuilder.append(paramObject);
    AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(localStringBuilder.toString()));
    return this;
  }
  
  public ReportR5Builder addVersion()
  {
    return addStringNotThrow("version", VideoReporter.a);
  }
  
  public ReportR5Builder addWords(int paramInt)
  {
    this.r5.put("words", paramInt);
    return this;
  }
  
  public String build()
  {
    for (;;)
    {
      try
      {
        if (this.reportFolderStatus) {
          this.r5.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        }
        if (this.reportTime) {
          this.r5.put("time", System.currentTimeMillis());
        }
        if (this.channelId != -1) {
          this.r5.put("channel_id", this.channelId);
        }
        this.r5.put("channel_icon", RIJXTabFrameUtils.INSTANCE.isIconTab(this.isIconTab));
        if (this.reportKandianMode) {
          this.r5.put("kandian_mode", RIJAppSetting.b());
        }
        if (this.reportKandianModeNew) {
          this.r5.put("kandian_mode_new", VideoReporter.c());
        }
        if (this.reportTabSource) {
          this.r5.put("tab_source", RIJTransMergeKanDianReport.b());
        }
        if (this.reportSessionId) {
          this.r5.put("session_id", RIJKanDianFolderStatus.reportSessionId);
        }
        if (this.skinId != null) {
          this.r5.put("skin_id", this.skinId);
        }
        if (this.skinVoice != -1) {
          this.r5.put("skin_voice", this.skinVoice);
        }
        if (this.refreshCategory != -1) {
          this.r5.put("skin_type", this.refreshCategory);
        }
        Object localObject;
        if (this.reportRedStyle)
        {
          localObject = this.r5;
          int j = ReadInJoyHelper.ah(BaseApplicationImpl.getApplication().getRuntime());
          i = 1;
          if (j == 1) {
            ((JSONObject)localObject).put("reddot_style", i);
          }
        }
        else
        {
          if (this.reportGuideRedStyle) {
            this.r5.put("red_dot_type", this.guideRedDotStyle);
          }
          if (this.reportAntiCheat) {
            VideoReporter.a(this.r5);
          }
          if (this.reportOS) {
            this.r5.put("os", "1");
          }
          localObject = this.r5.toString();
          return localObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      int i = 0;
    }
  }
  
  @NotNull
  public IReportR5Builder create()
  {
    return new ReportR5Builder();
  }
  
  public JSONObject getR5Object()
  {
    return this.r5;
  }
  
  public String toString()
  {
    return build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder
 * JD-Core Version:    0.7.0.1
 */