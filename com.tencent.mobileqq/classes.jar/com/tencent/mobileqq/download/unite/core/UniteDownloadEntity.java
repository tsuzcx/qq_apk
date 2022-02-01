package com.tencent.mobileqq.download.unite.core;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.open.base.MD5;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="apkMd5")
public class UniteDownloadEntity
  extends Entity
{
  private static final String TAG = "[UniteDownload] UniteDownloadEntity";
  public String apkMd5;
  public String apkPath;
  public String appId;
  public long downloadTimestamp;
  public String source;
  
  public static UniteDownloadEntity fromDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    UniteDownloadEntity localUniteDownloadEntity = new UniteDownloadEntity();
    localUniteDownloadEntity.downloadTimestamp = NetConnInfoCenter.getServerTimeMillis();
    localUniteDownloadEntity.apkPath = paramDownloadInfo.l;
    localUniteDownloadEntity.apkMd5 = MD5.a(new File(paramDownloadInfo.l));
    localUniteDownloadEntity.source = paramDownloadInfo.m;
    localUniteDownloadEntity.appId = paramDownloadInfo.c;
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] UniteDownloadEntity", 2, new Object[] { "[db] fromDownloadInfo: invoked. ", " uniteDownloadEntity: ", localUniteDownloadEntity });
    }
    return localUniteDownloadEntity;
  }
  
  public static String tableName()
  {
    return new UniteDownloadEntity().getTableName();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UniteDownloadEntity{source='");
    localStringBuilder.append(this.source);
    localStringBuilder.append('\'');
    localStringBuilder.append(", apkMd5='");
    localStringBuilder.append(this.apkMd5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", apkPath='");
    localStringBuilder.append(this.apkPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadTimestamp=");
    localStringBuilder.append(this.downloadTimestamp);
    localStringBuilder.append(", appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.UniteDownloadEntity
 * JD-Core Version:    0.7.0.1
 */