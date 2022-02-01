package cooperation.qqcircle.report;

import java.util.HashMap;

public class QCircleLpReportDc05507$DataBuilder
{
  public long actTime;
  public int actionType;
  public String authorUin = "";
  public int clear;
  public int cubage;
  public String errorCode = "";
  public String ext1 = "";
  public String ext10 = "";
  public String ext2 = "";
  public String ext3 = "";
  public String ext4 = "";
  public String ext5 = "";
  public String ext6 = "";
  public String ext7 = "";
  public String ext8 = "";
  public String ext9 = "";
  public HashMap<String, String> extras = new HashMap();
  public int fPageId;
  public String feedId = "";
  public String feedTag = "";
  public int feedType1;
  public int feedType2;
  public int feedType3;
  public String feedUrl = "";
  public int ffPageId = -1;
  public int height;
  public boolean isAutoPlay;
  public String itemDetail = "";
  public String lloc = "";
  public int pageId;
  public String picInfo = "";
  public String playId = "";
  public int playScene;
  public String playUrl = "";
  public int position;
  public byte[] reportInfo;
  public String requestId = "";
  public String ruleId = "";
  public int subActionType;
  public String toUin = "";
  public String vid = "";
  public long videoPlayTime;
  public long videoSoloTime;
  public String videoTag = "";
  public int videoTotalTime;
  public String videoType = "";
  public int width;
  
  public QCircleLpReportDc05507$DataBuilder() {}
  
  public QCircleLpReportDc05507$DataBuilder(DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null) {
      return;
    }
    setToUin(paramDataBuilder.toUin);
    setActionType(paramDataBuilder.actionType);
    setSubActionType(paramDataBuilder.subActionType);
    setFeedType1(paramDataBuilder.feedType1);
    setFeedType2(paramDataBuilder.feedType2);
    setFeedType3(paramDataBuilder.feedType3);
    setFeedId(paramDataBuilder.feedId);
    setAuthorUin(paramDataBuilder.authorUin);
    setPlayScene(paramDataBuilder.playScene);
    setPageId(paramDataBuilder.pageId);
    setfpageid(paramDataBuilder.fPageId);
    setffPageId(paramDataBuilder.ffPageId);
    setRuleId(paramDataBuilder.ruleId);
    setRequestId(paramDataBuilder.requestId);
    setFeedUrl(paramDataBuilder.feedUrl);
    setPosition(paramDataBuilder.position);
    setVideoTotalTime(paramDataBuilder.videoTotalTime);
    setVideoPlayTime(paramDataBuilder.videoPlayTime);
    setVideoSoloTime(paramDataBuilder.videoSoloTime);
    setVideoType(paramDataBuilder.videoType);
    setIsAutoPlay(paramDataBuilder.isAutoPlay);
    setCubage(paramDataBuilder.cubage);
    setWidth(paramDataBuilder.width);
    setHeight(paramDataBuilder.height);
    setClear(paramDataBuilder.clear);
    setPlayId(paramDataBuilder.playId);
    setActTime(paramDataBuilder.actTime);
    setVid(paramDataBuilder.vid);
    setLloc(paramDataBuilder.lloc);
    setFeedTag(paramDataBuilder.feedTag);
    setPlayUrl(paramDataBuilder.playUrl);
    setErrorCode(paramDataBuilder.errorCode);
    setVideoTag(paramDataBuilder.videoTag);
    setPicInfo(paramDataBuilder.picInfo);
    setItemDetail(paramDataBuilder.itemDetail);
    setExt1(paramDataBuilder.ext1);
    setExt2(paramDataBuilder.ext2);
    setExt3(paramDataBuilder.ext3);
    setExt4(paramDataBuilder.ext4);
    setExt5(paramDataBuilder.ext5);
    setExt6(paramDataBuilder.ext6);
    setExt7(paramDataBuilder.ext7);
    setExt8(paramDataBuilder.ext8);
    setExt9(paramDataBuilder.ext9);
    setExt10(paramDataBuilder.ext10);
    setReportInfo(paramDataBuilder.reportInfo);
    this.extras.putAll(paramDataBuilder.extras);
  }
  
  public DataBuilder setActTime(long paramLong)
  {
    this.actTime = paramLong;
    return this;
  }
  
  public DataBuilder setActionType(int paramInt)
  {
    this.actionType = paramInt;
    return this;
  }
  
  public DataBuilder setAuthorUin(String paramString)
  {
    this.authorUin = paramString;
    return this;
  }
  
  public DataBuilder setAutoPlay(boolean paramBoolean)
  {
    this.isAutoPlay = paramBoolean;
    return this;
  }
  
  public DataBuilder setClear(int paramInt)
  {
    this.clear = paramInt;
    return this;
  }
  
  public DataBuilder setCubage(int paramInt)
  {
    this.cubage = paramInt;
    return this;
  }
  
  public DataBuilder setErrorCode(String paramString)
  {
    this.errorCode = paramString;
    return this;
  }
  
  public DataBuilder setExt1(String paramString)
  {
    this.ext1 = paramString;
    return this;
  }
  
  public DataBuilder setExt10(String paramString)
  {
    this.ext10 = paramString;
    return this;
  }
  
  public DataBuilder setExt2(String paramString)
  {
    this.ext2 = paramString;
    return this;
  }
  
  public DataBuilder setExt3(String paramString)
  {
    this.ext3 = paramString;
    return this;
  }
  
  public DataBuilder setExt4(String paramString)
  {
    this.ext4 = paramString;
    return this;
  }
  
  public DataBuilder setExt5(String paramString)
  {
    this.ext5 = paramString;
    return this;
  }
  
  public DataBuilder setExt6(String paramString)
  {
    this.ext6 = paramString;
    return this;
  }
  
  public DataBuilder setExt7(String paramString)
  {
    this.ext7 = paramString;
    return this;
  }
  
  public DataBuilder setExt8(String paramString)
  {
    this.ext8 = paramString;
    return this;
  }
  
  public DataBuilder setExt9(String paramString)
  {
    this.ext9 = paramString;
    return this;
  }
  
  public DataBuilder setExtras(HashMap<String, String> paramHashMap)
  {
    this.extras.putAll(paramHashMap);
    return this;
  }
  
  public DataBuilder setFeedId(String paramString)
  {
    this.feedId = paramString;
    return this;
  }
  
  public DataBuilder setFeedTag(String paramString)
  {
    this.feedTag = paramString;
    return this;
  }
  
  public DataBuilder setFeedType1(int paramInt)
  {
    this.feedType1 = paramInt;
    return this;
  }
  
  public DataBuilder setFeedType2(int paramInt)
  {
    this.feedType2 = paramInt;
    return this;
  }
  
  public DataBuilder setFeedType3(int paramInt)
  {
    this.feedType3 = paramInt;
    return this;
  }
  
  public DataBuilder setFeedUrl(String paramString)
  {
    this.feedUrl = paramString;
    return this;
  }
  
  public DataBuilder setHeight(int paramInt)
  {
    this.height = paramInt;
    return this;
  }
  
  public DataBuilder setIsAutoPlay(boolean paramBoolean)
  {
    this.isAutoPlay = paramBoolean;
    return this;
  }
  
  public DataBuilder setItemDetail(String paramString)
  {
    this.itemDetail = paramString;
    return this;
  }
  
  public DataBuilder setLloc(String paramString)
  {
    this.lloc = paramString;
    return this;
  }
  
  public DataBuilder setPageId(int paramInt)
  {
    this.pageId = paramInt;
    return this;
  }
  
  public DataBuilder setPicInfo(String paramString)
  {
    this.picInfo = paramString;
    return this;
  }
  
  public DataBuilder setPlayId(String paramString)
  {
    this.playId = paramString;
    return this;
  }
  
  public DataBuilder setPlayScene(int paramInt)
  {
    this.playScene = paramInt;
    return this;
  }
  
  public DataBuilder setPlayUrl(String paramString)
  {
    this.playUrl = paramString;
    return this;
  }
  
  public DataBuilder setPosition(int paramInt)
  {
    this.position = paramInt;
    return this;
  }
  
  public DataBuilder setReportInfo(byte[] paramArrayOfByte)
  {
    this.reportInfo = paramArrayOfByte;
    return this;
  }
  
  public DataBuilder setRequestId(String paramString)
  {
    this.requestId = paramString;
    return this;
  }
  
  public DataBuilder setRuleId(String paramString)
  {
    this.ruleId = paramString;
    return this;
  }
  
  public DataBuilder setSubActionType(int paramInt)
  {
    this.subActionType = paramInt;
    return this;
  }
  
  public DataBuilder setToUin(String paramString)
  {
    this.toUin = paramString;
    return this;
  }
  
  public DataBuilder setVid(String paramString)
  {
    this.vid = paramString;
    return this;
  }
  
  public DataBuilder setVideoPlayTime(long paramLong)
  {
    this.videoPlayTime = paramLong;
    return this;
  }
  
  public DataBuilder setVideoSoloTime(long paramLong)
  {
    this.videoSoloTime = paramLong;
    return this;
  }
  
  public DataBuilder setVideoTag(String paramString)
  {
    this.videoTag = paramString;
    return this;
  }
  
  public DataBuilder setVideoTotalTime(int paramInt)
  {
    this.videoTotalTime = paramInt;
    return this;
  }
  
  public DataBuilder setVideoType(String paramString)
  {
    this.videoType = paramString;
    return this;
  }
  
  public DataBuilder setWidth(int paramInt)
  {
    this.width = paramInt;
    return this;
  }
  
  public DataBuilder setffPageId(int paramInt)
  {
    this.ffPageId = paramInt;
    return this;
  }
  
  public DataBuilder setfpageid(int paramInt)
  {
    this.fPageId = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder
 * JD-Core Version:    0.7.0.1
 */