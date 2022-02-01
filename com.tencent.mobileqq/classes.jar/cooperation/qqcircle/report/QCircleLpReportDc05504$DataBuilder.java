package cooperation.qqcircle.report;

import java.util.HashMap;

public class QCircleLpReportDc05504$DataBuilder
{
  private int actionType;
  private byte[] commExtReportInfo;
  private String ext1;
  private String ext10;
  private String ext11;
  private String ext12;
  private String ext13;
  private String ext14;
  private String ext15;
  private String ext16;
  private String ext17;
  private String ext18;
  private String ext2;
  private String ext3;
  private String ext4;
  private String ext5;
  private String ext6;
  private String ext7;
  private String ext8;
  private String ext9;
  private HashMap<String, String> extras = new HashMap();
  private int fPageId = -1;
  private byte[] feedReportInfo;
  private int ffPageId = -1;
  private byte[] msgReportInfo;
  private int pageId;
  private int subActionType;
  private int thrActionType;
  private String toUin;
  private String vid;
  
  public QCircleLpReportDc05504$DataBuilder() {}
  
  public QCircleLpReportDc05504$DataBuilder(DataBuilder paramDataBuilder)
  {
    if (paramDataBuilder == null) {
      return;
    }
    this.toUin = paramDataBuilder.toUin;
    this.actionType = paramDataBuilder.actionType;
    this.subActionType = paramDataBuilder.subActionType;
    this.thrActionType = paramDataBuilder.thrActionType;
    this.pageId = paramDataBuilder.pageId;
    this.fPageId = paramDataBuilder.fPageId;
    this.ffPageId = paramDataBuilder.ffPageId;
    this.vid = paramDataBuilder.vid;
    this.ext1 = paramDataBuilder.ext1;
    this.ext2 = paramDataBuilder.ext2;
    this.ext3 = paramDataBuilder.ext3;
    this.ext4 = paramDataBuilder.ext4;
    this.ext5 = paramDataBuilder.ext5;
    this.ext6 = paramDataBuilder.ext6;
    this.ext7 = paramDataBuilder.ext7;
    this.ext8 = paramDataBuilder.ext8;
    this.ext9 = paramDataBuilder.ext9;
    this.ext10 = paramDataBuilder.ext10;
    this.ext11 = paramDataBuilder.ext11;
    this.ext12 = paramDataBuilder.ext12;
    this.ext13 = paramDataBuilder.ext13;
    this.ext14 = paramDataBuilder.ext14;
    this.ext15 = paramDataBuilder.ext15;
    this.ext16 = paramDataBuilder.ext16;
    this.ext17 = paramDataBuilder.ext17;
    this.ext18 = paramDataBuilder.ext18;
    this.feedReportInfo = paramDataBuilder.feedReportInfo;
    this.msgReportInfo = paramDataBuilder.msgReportInfo;
    this.commExtReportInfo = paramDataBuilder.commExtReportInfo;
    this.extras = new HashMap();
    this.extras.putAll(paramDataBuilder.extras);
  }
  
  public DataBuilder setActionType(int paramInt)
  {
    this.actionType = paramInt;
    return this;
  }
  
  public DataBuilder setCommonReportInfo(byte[] paramArrayOfByte)
  {
    this.commExtReportInfo = paramArrayOfByte;
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
  
  public DataBuilder setExt11(String paramString)
  {
    this.ext11 = paramString;
    return this;
  }
  
  public DataBuilder setExt12(String paramString)
  {
    this.ext12 = paramString;
    return this;
  }
  
  public DataBuilder setExt13(String paramString)
  {
    this.ext13 = paramString;
    return this;
  }
  
  public DataBuilder setExt14(String paramString)
  {
    this.ext14 = paramString;
    return this;
  }
  
  public DataBuilder setExt15(String paramString)
  {
    this.ext15 = paramString;
    return this;
  }
  
  public DataBuilder setExt16(String paramString)
  {
    this.ext16 = paramString;
    return this;
  }
  
  public DataBuilder setExt17(String paramString)
  {
    this.ext17 = paramString;
    return this;
  }
  
  public DataBuilder setExt18(String paramString)
  {
    this.ext18 = paramString;
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
    this.extras = paramHashMap;
    return this;
  }
  
  public DataBuilder setFeedReportInfo(byte[] paramArrayOfByte)
  {
    this.feedReportInfo = paramArrayOfByte;
    return this;
  }
  
  public DataBuilder setMsgReportInfo(byte[] paramArrayOfByte)
  {
    this.msgReportInfo = paramArrayOfByte;
    return this;
  }
  
  public DataBuilder setPageId(int paramInt)
  {
    this.pageId = paramInt;
    return this;
  }
  
  public DataBuilder setSubActionType(int paramInt)
  {
    this.subActionType = paramInt;
    return this;
  }
  
  public DataBuilder setThrActionType(int paramInt)
  {
    this.thrActionType = paramInt;
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
  
  public DataBuilder setffPageId(int paramInt)
  {
    this.ffPageId = paramInt;
    return this;
  }
  
  public DataBuilder setvid(String paramString)
  {
    this.vid = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder
 * JD-Core Version:    0.7.0.1
 */