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
    return "UniteDownloadEntity{source='" + this.source + '\'' + ", apkMd5='" + this.apkMd5 + '\'' + ", apkPath='" + this.apkPath + '\'' + ", downloadTimestamp=" + this.downloadTimestamp + ", appId='" + this.appId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.UniteDownloadEntity
 * JD-Core Version:    0.7.0.1
 */