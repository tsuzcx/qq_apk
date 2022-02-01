package com.tencent.mobileqq.troop.data;

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
    if ((paramObject instanceof TroopAIONotifyItem))
    {
      String str = this.id;
      if (str != null) {
        return str.equals(((TroopAIONotifyItem)paramObject).id);
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append(", summary=");
    localStringBuilder.append(this.summary);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.url);
    localStringBuilder.append(", iconUrl=");
    localStringBuilder.append(this.icon);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", expireTime=");
    localStringBuilder.append(DateFormat.format("yyyy-MM-dd kk.mm.ss", this.expireTime * 1000L).toString());
    localStringBuilder.append(", hideMode=");
    localStringBuilder.append(this.hideMode);
    localStringBuilder.append(", troopUin=");
    localStringBuilder.append(this.troopUin);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.appId);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAIONotifyItem
 * JD-Core Version:    0.7.0.1
 */