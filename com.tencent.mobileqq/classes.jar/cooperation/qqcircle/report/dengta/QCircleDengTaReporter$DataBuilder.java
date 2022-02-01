package cooperation.qqcircle.report.dengta;

import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleDengTaReporter$DataBuilder
{
  private String actionType;
  private String authorUin;
  private String elementId;
  private String ext1;
  private String ext2;
  private String ext3;
  private String ext4;
  private String ext5;
  private String ext6;
  private String ext7;
  private String ext8;
  private String feedId;
  private int feedIndex = -1;
  private String feedTag;
  private int feedType1;
  private int feedType2;
  private int feedType3;
  private boolean isReaded;
  private int positionIndex = -1;
  private String qqToUin;
  private QCircleReportBean reportBean;
  private String videoPlayTime;
  private String videoTotalTime;
  
  public QCircleDengTaReporter$DataBuilder() {}
  
  public QCircleDengTaReporter$DataBuilder(DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null) {
      return;
    }
    this.elementId = paramDataBuilder.elementId;
    this.actionType = paramDataBuilder.actionType;
    this.qqToUin = paramDataBuilder.qqToUin;
    this.positionIndex = paramDataBuilder.positionIndex;
    this.ext1 = paramDataBuilder.ext1;
    this.ext2 = paramDataBuilder.ext2;
    this.ext3 = paramDataBuilder.ext3;
    this.ext4 = paramDataBuilder.ext4;
    this.ext5 = paramDataBuilder.ext5;
    this.ext6 = paramDataBuilder.ext6;
    this.ext7 = paramDataBuilder.ext7;
    this.ext8 = paramDataBuilder.ext8;
    this.feedIndex = paramDataBuilder.feedIndex;
    this.isReaded = paramDataBuilder.isReaded;
    this.videoTotalTime = paramDataBuilder.videoTotalTime;
    this.videoPlayTime = paramDataBuilder.videoPlayTime;
    if (paramDataBuilder.reportBean != null) {}
    for (QCircleReportBean localQCircleReportBean = paramDataBuilder.reportBean.clone();; localQCircleReportBean = new QCircleReportBean())
    {
      this.reportBean = localQCircleReportBean;
      this.feedId = paramDataBuilder.feedId;
      this.feedTag = paramDataBuilder.feedTag;
      this.authorUin = paramDataBuilder.authorUin;
      this.feedType1 = paramDataBuilder.feedType1;
      this.feedType2 = paramDataBuilder.feedType2;
      this.feedType3 = paramDataBuilder.feedType3;
      return;
    }
  }
  
  public DataBuilder setActionType(String paramString)
  {
    this.actionType = paramString;
    return this;
  }
  
  public DataBuilder setAuthorUin(String paramString)
  {
    this.authorUin = paramString;
    return this;
  }
  
  public DataBuilder setElementId(String paramString)
  {
    this.elementId = paramString;
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
  
  public DataBuilder setFeedId(String paramString)
  {
    this.feedId = paramString;
    return this;
  }
  
  public DataBuilder setFeedIndex(int paramInt)
  {
    this.feedIndex = paramInt;
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
  
  public DataBuilder setIsReaded(boolean paramBoolean)
  {
    this.isReaded = paramBoolean;
    return this;
  }
  
  public DataBuilder setPositionIndex(int paramInt)
  {
    this.positionIndex = paramInt;
    return this;
  }
  
  public DataBuilder setQQToUin(String paramString)
  {
    this.qqToUin = paramString;
    return this;
  }
  
  public DataBuilder setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.reportBean = paramQCircleReportBean;
    return this;
  }
  
  public DataBuilder setVideoPlayTime(String paramString)
  {
    this.videoPlayTime = paramString;
    return this;
  }
  
  public DataBuilder setVideoTotalTime(String paramString)
  {
    this.videoTotalTime = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.dengta.QCircleDengTaReporter.DataBuilder
 * JD-Core Version:    0.7.0.1
 */