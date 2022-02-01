package com.tencent.mobileqq.data;

import android.text.format.DateFormat;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TroopAIONotifyItem
  extends Entity
{
  public static final int HIDE_AFTER_CLICK = 2;
  public static final int HIDE_AFTER_SHOW = 1;
  public static final int TYPE_APP_NOTIFY = 1;
  public static final int TYPE_PUSH_NOTIFY = 2;
  public long appId;
  public long expireTime;
  public int hideMode;
  public String icon;
  @unique
  public String id;
  public String summary;
  public String title;
  public String troopUin;
  public int type;
  public String url;
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof TroopAIONotifyItem)) && (this.id != null)) {
      return this.id.equals(((TroopAIONotifyItem)paramObject).id);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("id=").append(this.id);
    localStringBuilder.append(", title=").append(this.title);
    localStringBuilder.append(", summary=").append(this.summary);
    localStringBuilder.append(", jumpUrl=").append(this.url);
    localStringBuilder.append(", iconUrl=").append(this.icon);
    localStringBuilder.append(", type=").append(this.type);
    localStringBuilder.append(", expireTime=").append(DateFormat.format("yyyy-MM-dd kk.mm.ss", this.expireTime * 1000L).toString());
    localStringBuilder.append(", hideMode=").append(this.hideMode);
    localStringBuilder.append(", troopUin=").append(this.troopUin);
    localStringBuilder.append(", appId=").append(this.appId);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopAIONotifyItem
 * JD-Core Version:    0.7.0.1
 */