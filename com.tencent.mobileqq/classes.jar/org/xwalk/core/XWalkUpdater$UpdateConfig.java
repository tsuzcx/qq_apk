package org.xwalk.core;

import com.tencent.xweb.xwalk.updater.Scheduler;

public class XWalkUpdater$UpdateConfig
{
  public String abi;
  public boolean alreadyUnZiped;
  public int apkVer = -1;
  public boolean bTryUseSharedCore;
  public boolean bUseCdn;
  public String downUrl;
  public String downloadFileMd5;
  public boolean isMatchMd5;
  public boolean isPatchUpdate;
  public int nPatchTargetVersion;
  public String patchEndFileMd5;
  public Scheduler scheduler;
  public String versionDetail;
  
  private XWalkUpdater$UpdateConfig(int paramInt, String paramString1, String paramString2)
  {
    this.apkVer = paramInt;
    this.abi = paramString1;
    this.versionDetail = paramString2;
  }
  
  public XWalkUpdater$UpdateConfig(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
  {
    this.isMatchMd5 = false;
    this.isPatchUpdate = paramBoolean;
    this.downUrl = paramString1;
    this.apkVer = paramInt1;
    this.abi = paramString2;
    this.nPatchTargetVersion = paramInt2;
    if (checkValid()) {
      return;
    }
    throw new RuntimeException("royle:UpdateConfig is not valid");
  }
  
  public XWalkUpdater$UpdateConfig(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    this.isMatchMd5 = true;
    this.downloadFileMd5 = paramString1;
    this.isPatchUpdate = paramBoolean;
    this.patchEndFileMd5 = paramString2;
    this.downUrl = paramString3;
    this.apkVer = paramInt1;
    this.abi = paramString4;
    this.nPatchTargetVersion = paramInt2;
    if (checkValid()) {
      return;
    }
    throw new RuntimeException("royle:UpdateConfig is not valid");
  }
  
  public static UpdateConfig createTempConfig(int paramInt, String paramString1, String paramString2)
  {
    return new UpdateConfig(paramInt, paramString1, paramString2);
  }
  
  public boolean checkValid()
  {
    if (this.isMatchMd5)
    {
      str = this.downloadFileMd5;
      if ((str == null) || (str.isEmpty())) {
        return false;
      }
    }
    String str = this.downUrl;
    if (str != null)
    {
      if (str.isEmpty()) {
        return false;
      }
      if (this.apkVer == -1) {
        return false;
      }
      if ((this.isMatchMd5) && (this.isPatchUpdate))
      {
        str = this.patchEndFileMd5;
        if ((str == null) || (str.isEmpty())) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public String getDownloadPath()
  {
    if (checkValid())
    {
      if (this.isPatchUpdate) {
        return XWalkEnvironment.getDownloadPatchPath(this.apkVer);
      }
      return XWalkEnvironment.getDownloadZipDir(this.apkVer);
    }
    throw new RuntimeException("royle:UpdateConfig is not valid");
  }
  
  public String getLogSelf()
  {
    if (checkValid())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UpdateConfig isMatchMd5:");
      localStringBuilder.append(this.isMatchMd5);
      localStringBuilder.append(" downloadFileMd5:");
      localStringBuilder.append(this.downloadFileMd5);
      localStringBuilder.append(",isPatchUpdate:");
      localStringBuilder.append(this.isPatchUpdate);
      localStringBuilder.append(",downUrl:");
      localStringBuilder.append(this.downUrl);
      localStringBuilder.append(",apkVer:");
      localStringBuilder.append(this.apkVer);
      localStringBuilder.append(",useCDN:");
      localStringBuilder.append(this.bUseCdn);
      localStringBuilder.append(",downloadPath:");
      localStringBuilder.append(getDownloadPath());
      localStringBuilder.append(".");
      return localStringBuilder.toString();
    }
    return "UpdateConfig is not valid";
  }
  
  public int getUpdateBizType()
  {
    if (this.isPatchUpdate) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.UpdateConfig
 * JD-Core Version:    0.7.0.1
 */