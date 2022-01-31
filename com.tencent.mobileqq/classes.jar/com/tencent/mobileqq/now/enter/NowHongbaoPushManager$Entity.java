package com.tencent.mobileqq.now.enter;

import java.io.Serializable;
import java.util.HashMap;

public class NowHongbaoPushManager$Entity
  implements Serializable, Cloneable
{
  public static final int NOT_INIT = -1;
  public static final int NOT_SHOW = 2;
  public static final int SHOW = 1;
  private static final long serialVersionUID = 10088L;
  private transient int a = -1;
  public long endTime;
  private int isShow = -1;
  public long startTime;
  public long taskId;
  public int type = -1;
  public long version;
  
  private void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected Entity clone()
  {
    Entity localEntity = new Entity();
    localEntity.type = this.type;
    localEntity.isShow = this.isShow;
    localEntity.endTime = this.endTime;
    localEntity.startTime = this.startTime;
    return localEntity;
  }
  
  public int getShowState()
  {
    return this.isShow;
  }
  
  public boolean inShowTimeRange()
  {
    if (this.isShow == 1)
    {
      long l = NowHongbaoPushManager.a();
      if ((l >= this.startTime) && (l <= this.endTime)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isHideState()
  {
    return this.isShow == 2;
  }
  
  public boolean isNotified()
  {
    return this.a != -1;
  }
  
  public boolean isShowState()
  {
    return this.isShow == 1;
  }
  
  public boolean isThisStateNotified(int paramInt)
  {
    return paramInt == this.a;
  }
  
  public boolean isTimeOut()
  {
    return NowHongbaoPushManager.a() > this.endTime;
  }
  
  public boolean isTimeValid()
  {
    return (this.isShow == 1) && (NowHongbaoPushManager.a() <= this.endTime);
  }
  
  public void notifyClose()
  {
    a(2);
  }
  
  public void notifyShow()
  {
    a(1);
  }
  
  public void resetNotifyState()
  {
    this.a = -1;
  }
  
  public void setState(int paramInt)
  {
    this.isShow = paramInt;
  }
  
  public String toString()
  {
    return (String)NowHongbaoPushManager.a().get(Integer.valueOf(this.type)) + ", startTime= " + NowHongbaoPushManager.a(this.startTime) + ", endTime= " + NowHongbaoPushManager.a(this.endTime) + ", type= " + this.type + ", isShow= " + this.isShow + ", taskId= " + this.taskId + ", version= " + this.version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Entity
 * JD-Core Version:    0.7.0.1
 */