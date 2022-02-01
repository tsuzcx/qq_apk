package com.tencent.mobileqq.data;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="busId,them,actId")
public class AioPushData
  extends Entity
  implements Comparable<AioPushData>
{
  public String actId;
  public int begTs;
  public int busId;
  public int busType;
  public int dotId;
  public int endTs;
  public String folderIconUrl;
  public boolean isShow;
  public int priority;
  public int spRegion;
  public String them;
  public String url;
  public String wording;
  
  public int compareTo(@NonNull AioPushData paramAioPushData)
  {
    return this.begTs - paramAioPushData.begTs;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof AioPushData)) && (((AioPushData)paramObject).getKey().equals(getKey()));
  }
  
  public String getKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(this.busId));
    localStringBuilder.append(this.them);
    localStringBuilder.append(this.actId);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.busType).append("#").append(this.busId).append("#").append(this.dotId).append("#").append(this.priority).append("#").append(this.begTs).append("#").append(this.endTs).append("#").append(this.wording).append("#").append(this.url).append("#").append(this.them).append("#").append(this.actId).append("#").append(this.isShow).append("#").append(getId()).append("#").append(getStatus());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.AioPushData
 * JD-Core Version:    0.7.0.1
 */