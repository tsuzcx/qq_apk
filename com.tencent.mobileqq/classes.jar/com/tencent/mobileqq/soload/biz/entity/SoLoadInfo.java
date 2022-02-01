package com.tencent.mobileqq.soload.biz.entity;

import java.io.Serializable;

public class SoLoadInfo
  implements Serializable
{
  public static SoLoadInfo sDefault = new SoLoadInfo();
  public int curCode = 6;
  public String failDetail;
  public boolean isFinishDownload;
  public boolean isFirstlyLoad = true;
  public boolean isNeedDownload = true;
  public String rFileFolder;
  public SoDetailInfo soDetailInfo;
  public String soPathToLoad;
  public int subErrCode;
  
  public String getVer()
  {
    SoDetailInfo localSoDetailInfo = this.soDetailInfo;
    if (localSoDetailInfo == null) {
      return null;
    }
    return localSoDetailInfo.ver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoLoadInfo
 * JD-Core Version:    0.7.0.1
 */