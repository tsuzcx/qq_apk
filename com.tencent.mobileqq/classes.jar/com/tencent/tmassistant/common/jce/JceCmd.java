package com.tencent.tmassistant.common.jce;

import java.io.Serializable;

public final class JceCmd
  implements Serializable
{
  public static final JceCmd Empty;
  public static final JceCmd GetAppSimpleDetail;
  public static final JceCmd GetAppUpdate;
  public static final JceCmd GetConfig;
  public static final JceCmd GetHalleyUrl;
  public static final JceCmd GetHotSdkUpdate;
  public static final JceCmd GetMobilePhoneQqApkInfo;
  public static final JceCmd GetPkgInfo;
  public static final JceCmd GetPush;
  public static final JceCmd GetRecmdIdBatch;
  public static final JceCmd GetSettings;
  public static final JceCmd ReportApkFileInfo;
  public static final JceCmd ReportLog;
  public static final JceCmd SDKDataReport;
  public static final JceCmd StatReport;
  public static final int _Empty = 0;
  public static final int _GetAppSimpleDetail = 5;
  public static final int _GetAppUpdate = 3;
  public static final int _GetConfig = 7;
  public static final int _GetHalleyUrl = 10;
  public static final int _GetHotSdkUpdate = 11;
  public static final int _GetMobilePhoneQqApkInfo = 15;
  public static final int _GetPkgInfo = 12;
  public static final int _GetPush = 8;
  public static final int _GetRecmdIdBatch = 14;
  public static final int _GetSettings = 2;
  public static final int _ReportApkFileInfo = 4;
  public static final int _ReportLog = 1;
  public static final int _SDKDataReport = 13;
  public static final int _StatReport = 9;
  private static JceCmd[] __values;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!JceCmd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      __values = new JceCmd[15];
      Empty = new JceCmd(0, 0, "Empty");
      ReportLog = new JceCmd(1, 1, "ReportLog");
      GetSettings = new JceCmd(2, 2, "GetSettings");
      GetAppUpdate = new JceCmd(3, 3, "GetAppUpdate");
      ReportApkFileInfo = new JceCmd(4, 4, "ReportApkFileInfo");
      GetAppSimpleDetail = new JceCmd(5, 5, "GetAppSimpleDetail");
      GetConfig = new JceCmd(6, 7, "GetConfig");
      GetPush = new JceCmd(7, 8, "GetPush");
      StatReport = new JceCmd(8, 9, "StatReport");
      GetHalleyUrl = new JceCmd(9, 10, "GetHalleyUrl");
      GetHotSdkUpdate = new JceCmd(10, 11, "GetHotSdkUpdate");
      GetPkgInfo = new JceCmd(11, 12, "GetPkgInfo");
      SDKDataReport = new JceCmd(12, 13, "SDKDataReport");
      GetRecmdIdBatch = new JceCmd(13, 14, "GetRecmdIdBatch");
      GetMobilePhoneQqApkInfo = new JceCmd(14, 15, "GetMobilePhoneQqApkInfo");
      return;
    }
  }
  
  private JceCmd(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    __values[paramInt1] = this;
  }
  
  public static JceCmd convert(int paramInt)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].value() == paramInt) {
        return __values[i];
      }
      i += 1;
    }
    if (!a) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static JceCmd convert(String paramString)
  {
    int i = 0;
    while (i < __values.length)
    {
      if (__values[i].toString().equals(paramString)) {
        return __values[i];
      }
      i += 1;
    }
    if (!a) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.JceCmd
 * JD-Core Version:    0.7.0.1
 */