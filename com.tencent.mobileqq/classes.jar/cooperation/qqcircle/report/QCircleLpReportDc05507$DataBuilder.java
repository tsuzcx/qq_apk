package cooperation.qqcircle.report;

import java.util.HashMap;

public class QCircleLpReportDc05507$DataBuilder
{
  private long actTime;
  private int actionType;
  private String authorUin = "";
  private int clear;
  private int cubage;
  private String errorCode = "";
  private String ext1 = "";
  private String ext10 = "";
  private String ext2 = "";
  private String ext3 = "";
  private String ext4 = "";
  private String ext5 = "";
  private String ext6 = "";
  private String ext7 = "";
  private String ext8 = "";
  private String ext9 = "";
  private HashMap<String, String> extras = new HashMap();
  private int fPageId;
  private String feedId = "";
  private String feedTag = "";
  private int feedType1;
  private int feedType2;
  private int feedType3;
  private String feedUrl = "";
  private int ffPageId = -1;
  private int height;
  private boolean isAutoPlay = false;
  private String itemDetail = "";
  private String lloc = "";
  private int pageId;
  private String picInfo = "";
  private String playId = "";
  private int playScene;
  private String playUrl = "";
  private int position;
  private byte[] reportInfo;
  private String requestId = "";
  private String ruleId = "";
  private int subActionType;
  private String toUin = "";
  private String vid = "";
  private long videoPlayTime;
  private long videoSoloTime;
  private String videoTag = "";
  private int videoTotalTime;
  private String videoType = "";
  private int width;
  
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
  
  public long getActTime()
  {
    return this.actTime;
  }
  
  public int getActionType()
  {
    return this.actionType;
  }
  
  public String getAuthorUin()
  {
    return this.authorUin;
  }
  
  public int getClear()
  {
    return this.clear;
  }
  
  public int getCubage()
  {
    return this.cubage;
  }
  
  public String getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getExt1()
  {
    return this.ext1;
  }
  
  public String getExt10()
  {
    return this.ext10;
  }
  
  public String getExt2()
  {
    return this.ext2;
  }
  
  public String getExt3()
  {
    return this.ext3;
  }
  
  public String getExt4()
  {
    return this.ext4;
  }
  
  public String getExt5()
  {
    return this.ext5;
  }
  
  public String getExt6()
  {
    return this.ext6;
  }
  
  public String getExt7()
  {
    return this.ext7;
  }
  
  public String getExt8()
  {
    return this.ext8;
  }
  
  public String getExt9()
  {
    return this.ext9;
  }
  
  public HashMap<String, String> getExtras()
  {
    return this.extras;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public String getFeedTag()
  {
    return this.feedTag;
  }
  
  public int getFeedType1()
  {
    return this.feedType1;
  }
  
  public int getFeedType2()
  {
    return this.feedType2;
  }
  
  public int getFeedType3()
  {
    return this.feedType3;
  }
  
  public String getFeedUrl()
  {
    return this.feedUrl;
  }
  
  public int getFfPageId()
  {
    return this.ffPageId;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getItemDetail()
  {
    return this.itemDetail;
  }
  
  public String getLloc()
  {
    return this.lloc;
  }
  
  public int getPageId()
  {
    return this.pageId;
  }
  
  public String getPicInfo()
  {
    return this.picInfo;
  }
  
  public String getPlayId()
  {
    return this.playId;
  }
  
  public int getPlayScene()
  {
    return this.playScene;
  }
  
  public String getPlayUrl()
  {
    return this.playUrl;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public byte[] getReportInfo()
  {
    return this.reportInfo;
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public String getRuleId()
  {
    return this.ruleId;
  }
  
  public int getSubActionType()
  {
    return this.subActionType;
  }
  
  public String getToUin()
  {
    return this.toUin;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public long getVideoPlayTime()
  {
    return this.videoPlayTime;
  }
  
  public long getVideoSoloTime()
  {
    return this.videoSoloTime;
  }
  
  public String getVideoTag()
  {
    return this.videoTag;
  }
  
  public int getVideoTotalTime()
  {
    return this.videoTotalTime;
  }
  
  public String getVideoType()
  {
    return this.videoType;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int getfPageId()
  {
    return this.fPageId;
  }
  
  public boolean isAutoPlay()
  {
    return this.isAutoPlay;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder
 * JD-Core Version:    0.7.0.1
 */