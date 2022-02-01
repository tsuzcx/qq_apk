package cooperation.qqcircle.report;

import java.util.HashMap;

public class QCircleLpReportDc05501$DataBuilder
{
  private long actTime;
  private int actionType;
  private String authorUin;
  private int containerSeq = -1;
  private String ext1;
  private String ext2;
  private String ext3;
  private String ext4;
  private String ext5;
  private String ext6;
  private String ext7;
  private String ext8;
  private HashMap<String, String> extras = new HashMap();
  private int fPageId = -1;
  private String feedId;
  private String feedTag;
  private int feedType1;
  private int feedType2;
  private int feedType3;
  private int ffPageId = -1;
  private int index = -1;
  private boolean isReaded;
  private int pageId;
  private byte[] reportInfo;
  private String requestId;
  private String ruleId;
  private int subActionType;
  private String toUin;
  
  public QCircleLpReportDc05501$DataBuilder() {}
  
  public QCircleLpReportDc05501$DataBuilder(DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null) {
      return;
    }
    this.toUin = paramDataBuilder.toUin;
    this.feedType1 = paramDataBuilder.feedType1;
    this.feedType2 = paramDataBuilder.feedType2;
    this.feedType3 = paramDataBuilder.feedType3;
    this.actionType = paramDataBuilder.actionType;
    this.subActionType = paramDataBuilder.subActionType;
    this.index = paramDataBuilder.index;
    this.feedId = paramDataBuilder.feedId;
    this.feedTag = paramDataBuilder.feedTag;
    this.isReaded = paramDataBuilder.isReaded;
    this.pageId = paramDataBuilder.pageId;
    this.fPageId = paramDataBuilder.fPageId;
    this.ffPageId = paramDataBuilder.ffPageId;
    this.ruleId = paramDataBuilder.ruleId;
    this.containerSeq = paramDataBuilder.containerSeq;
    this.actTime = paramDataBuilder.actTime;
    this.authorUin = paramDataBuilder.authorUin;
    this.requestId = paramDataBuilder.requestId;
    this.ext1 = paramDataBuilder.ext1;
    this.ext2 = paramDataBuilder.ext2;
    this.ext3 = paramDataBuilder.ext3;
    this.ext4 = paramDataBuilder.ext4;
    this.ext5 = paramDataBuilder.ext5;
    this.ext6 = paramDataBuilder.ext6;
    this.ext7 = paramDataBuilder.ext7;
    this.ext8 = paramDataBuilder.ext8;
    this.reportInfo = paramDataBuilder.reportInfo;
    this.extras = new HashMap();
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
  
  public int getContainerSeq()
  {
    return this.containerSeq;
  }
  
  public String getExt1()
  {
    return this.ext1;
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
  
  public int getFfPageId()
  {
    return this.ffPageId;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getPageId()
  {
    return this.pageId;
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
  
  public int getfPageId()
  {
    return this.fPageId;
  }
  
  public boolean isReaded()
  {
    return this.isReaded;
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
  
  public DataBuilder setContainerSeq(int paramInt)
  {
    this.containerSeq = paramInt;
    return this;
  }
  
  public DataBuilder setExt1(String paramString)
  {
    this.ext1 = paramString;
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
  
  public DataBuilder setExtras(HashMap<String, String> paramHashMap)
  {
    this.extras = paramHashMap;
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
  
  public DataBuilder setFfPageId(int paramInt)
  {
    this.ffPageId = paramInt;
    return this;
  }
  
  public DataBuilder setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataBuilder setPageId(int paramInt)
  {
    this.pageId = paramInt;
    return this;
  }
  
  public DataBuilder setReaded(boolean paramBoolean)
  {
    this.isReaded = paramBoolean;
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
  
  public DataBuilder setfPageId(int paramInt)
  {
    this.fPageId = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder
 * JD-Core Version:    0.7.0.1
 */