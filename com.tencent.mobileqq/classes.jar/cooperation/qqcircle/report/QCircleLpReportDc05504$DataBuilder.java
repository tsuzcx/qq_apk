package cooperation.qqcircle.report;

import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
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
  
  public QCircleLpReportDc05504$DataBuilder(QCircleLpReportDc05504DataBuilder paramQCircleLpReportDc05504DataBuilder)
  {
    if (paramQCircleLpReportDc05504DataBuilder == null) {
      return;
    }
    this.toUin = paramQCircleLpReportDc05504DataBuilder.getToUin();
    this.actionType = paramQCircleLpReportDc05504DataBuilder.getActionType();
    this.subActionType = paramQCircleLpReportDc05504DataBuilder.getSubActionType();
    this.thrActionType = paramQCircleLpReportDc05504DataBuilder.getThrActionType();
    this.pageId = paramQCircleLpReportDc05504DataBuilder.getPageId();
    this.fPageId = paramQCircleLpReportDc05504DataBuilder.getfPageId();
    this.ffPageId = paramQCircleLpReportDc05504DataBuilder.getFfPageId();
    this.vid = paramQCircleLpReportDc05504DataBuilder.getVid();
    this.ext1 = paramQCircleLpReportDc05504DataBuilder.getExt1();
    this.ext2 = paramQCircleLpReportDc05504DataBuilder.getExt2();
    this.ext3 = paramQCircleLpReportDc05504DataBuilder.getExt3();
    this.ext4 = paramQCircleLpReportDc05504DataBuilder.getExt4();
    this.ext5 = paramQCircleLpReportDc05504DataBuilder.getExt5();
    this.ext6 = paramQCircleLpReportDc05504DataBuilder.getExt6();
    this.ext7 = paramQCircleLpReportDc05504DataBuilder.getExt7();
    this.ext8 = paramQCircleLpReportDc05504DataBuilder.getExt8();
    this.ext9 = paramQCircleLpReportDc05504DataBuilder.getExt9();
    this.ext10 = paramQCircleLpReportDc05504DataBuilder.getExt10();
    this.ext11 = paramQCircleLpReportDc05504DataBuilder.getExt11();
    this.ext12 = paramQCircleLpReportDc05504DataBuilder.getExt12();
    this.ext13 = paramQCircleLpReportDc05504DataBuilder.getExt13();
    this.ext14 = paramQCircleLpReportDc05504DataBuilder.getExt14();
    this.ext15 = paramQCircleLpReportDc05504DataBuilder.getExt15();
    this.ext16 = paramQCircleLpReportDc05504DataBuilder.getExt16();
    this.ext17 = paramQCircleLpReportDc05504DataBuilder.getExt17();
    this.ext18 = paramQCircleLpReportDc05504DataBuilder.getExt18();
    this.feedReportInfo = paramQCircleLpReportDc05504DataBuilder.getFeedReportInfo();
    this.msgReportInfo = paramQCircleLpReportDc05504DataBuilder.getMsgReportInfo();
    this.commExtReportInfo = paramQCircleLpReportDc05504DataBuilder.getCommExtReportInfo();
    this.extras = new HashMap();
    this.extras.putAll(paramQCircleLpReportDc05504DataBuilder.getExtras());
  }
  
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
  
  public int getActionType()
  {
    return this.actionType;
  }
  
  public byte[] getCommExtReportInfo()
  {
    return this.commExtReportInfo;
  }
  
  public String getExt1()
  {
    return this.ext1;
  }
  
  public String getExt10()
  {
    return this.ext10;
  }
  
  public String getExt11()
  {
    return this.ext11;
  }
  
  public String getExt12()
  {
    return this.ext12;
  }
  
  public String getExt13()
  {
    return this.ext13;
  }
  
  public String getExt14()
  {
    return this.ext14;
  }
  
  public String getExt15()
  {
    return this.ext15;
  }
  
  public String getExt16()
  {
    return this.ext16;
  }
  
  public String getExt17()
  {
    return this.ext17;
  }
  
  public String getExt18()
  {
    return this.ext18;
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
  
  public byte[] getFeedReportInfo()
  {
    return this.feedReportInfo;
  }
  
  public int getFfPageId()
  {
    return this.ffPageId;
  }
  
  public byte[] getMsgReportInfo()
  {
    return this.msgReportInfo;
  }
  
  public int getPageId()
  {
    return this.pageId;
  }
  
  public int getSubActionType()
  {
    return this.subActionType;
  }
  
  public int getThrActionType()
  {
    return this.thrActionType;
  }
  
  public String getToUin()
  {
    return this.toUin;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public int getfPageId()
  {
    return this.fPageId;
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
  
  public DataBuilder setFfPageId(int paramInt)
  {
    this.ffPageId = paramInt;
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
  
  public DataBuilder setvid(String paramString)
  {
    this.vid = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder
 * JD-Core Version:    0.7.0.1
 */