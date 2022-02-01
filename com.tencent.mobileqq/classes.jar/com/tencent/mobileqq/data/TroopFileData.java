package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class TroopFileData
  extends Entity
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public String FromUin = null;
  public int bisID = 0;
  public String dspFileName = null;
  public String dspFileSize = null;
  public int duration;
  public long entitySessionId;
  public String fileName = null;
  @unique
  public String fileUrl = null;
  public int height;
  public long lastTime = 0L;
  public long lfileSize = 0L;
  public String md5 = null;
  public String sha1 = null;
  public String uuid = null;
  public int width;
  public String yybApkIconUrl;
  public String yybApkName;
  public String yybApkPackageName;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopFileData{dspFileSize='");
    localStringBuilder.append(this.dspFileSize);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dspFileName='");
    localStringBuilder.append(this.dspFileName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bisID=");
    localStringBuilder.append(this.bisID);
    localStringBuilder.append(", fileUrl='");
    localStringBuilder.append(this.fileUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileName='");
    localStringBuilder.append(this.fileName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lfileSize=");
    localStringBuilder.append(this.lfileSize);
    localStringBuilder.append(", uuid='");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", FromUin='");
    localStringBuilder.append(this.FromUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastTime=");
    localStringBuilder.append(this.lastTime);
    localStringBuilder.append(", entitySessionId=");
    localStringBuilder.append(this.entitySessionId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopFileData
 * JD-Core Version:    0.7.0.1
 */