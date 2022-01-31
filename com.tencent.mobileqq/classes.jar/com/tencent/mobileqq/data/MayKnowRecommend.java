package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.richstatus.RichStatus;
import java.io.Serializable;

public class MayKnowRecommend
  extends Entity
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public short age;
  public byte[] algBuffer;
  public String category;
  public String city;
  public String country;
  public int friendStatus;
  public short gender = 255;
  public boolean hasQZoneUpdate;
  public String nick;
  public String province;
  public String recommendReason;
  public String remark;
  @Deprecated
  public String richBuffer;
  public byte[] richSingature;
  @notColumn
  public RichStatus richStatus;
  public String uin;
  
  public RichStatus getRichStatus()
  {
    if (this.richStatus == null) {
      this.richStatus = RichStatus.parseStatus(this.richSingature);
    }
    return this.richStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MayKnowRecommend
 * JD-Core Version:    0.7.0.1
 */