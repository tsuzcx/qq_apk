package com.tencent.mobileqq.qcircle.tempapi.avatar;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="mUin,mTimestamp,mDownLoadUrl")
public class QCircleAvatarInfo
  extends Entity
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = -4357612325647192547L;
  public String mDownLoadUrl;
  public String mTimestamp;
  @unique
  public String mUin;
  
  public static long getSerialVersionUID()
  {
    return -4357612325647192547L;
  }
  
  public String getDownLoadUrl()
  {
    return this.mDownLoadUrl;
  }
  
  public String getTimestamp()
  {
    return this.mTimestamp;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public QCircleAvatarInfo setDownLoadUrl(String paramString)
  {
    this.mDownLoadUrl = paramString;
    return this;
  }
  
  public QCircleAvatarInfo setTimestamp(String paramString)
  {
    this.mTimestamp = paramString;
    return this;
  }
  
  public QCircleAvatarInfo setUin(String paramString)
  {
    this.mUin = paramString;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleAvatarInfo{mUin='");
    localStringBuilder.append(this.mUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTimestamp='");
    localStringBuilder.append(this.mTimestamp);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDownLoadUrl='");
    localStringBuilder.append(this.mDownLoadUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo
 * JD-Core Version:    0.7.0.1
 */