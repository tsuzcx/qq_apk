package com.tencent.mobileqq.flashshow.api.data;

import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import java.util.HashMap;

public class DataBuilder
{
  private int actionType;
  private byte[] commExtReportInfo;
  private String dtPgId;
  private String dtRefPgId;
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
  private byte[] feedReportInfo;
  private byte[] msgReportInfo;
  private int subActionType;
  private int thrActionType;
  private String toUin;
  private String vid;
  
  public DataBuilder(FSReportBean paramFSReportBean)
  {
    wrapPageIdInfo(paramFSReportBean);
  }
  
  private void wrapPageIdInfo(FSReportBean paramFSReportBean)
  {
    if (paramFSReportBean != null)
    {
      setPageId(paramFSReportBean.getPageId());
      setFromPageId(paramFSReportBean.getFromPageId());
    }
  }
  
  public int getActionType()
  {
    return this.actionType;
  }
  
  public byte[] getCommExtReportInfo()
  {
    return this.commExtReportInfo;
  }
  
  public String getDtPgId()
  {
    return this.dtPgId;
  }
  
  public String getDtRefPgId()
  {
    return this.dtRefPgId;
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
  
  public byte[] getMsgReportInfo()
  {
    return this.msgReportInfo;
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
  
  public DataBuilder setFromPageId(String paramString)
  {
    this.dtRefPgId = paramString;
    return this;
  }
  
  public DataBuilder setMsgReportInfo(byte[] paramArrayOfByte)
  {
    this.msgReportInfo = paramArrayOfByte;
    return this;
  }
  
  public DataBuilder setPageId(String paramString)
  {
    this.dtPgId = paramString;
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
  
  public DataBuilder setvid(String paramString)
  {
    this.vid = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.data.DataBuilder
 * JD-Core Version:    0.7.0.1
 */