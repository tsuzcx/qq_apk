package com.tencent.mobileqq.winkpublish.model;

import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;

public class KingCardInfo
  implements SmartParcelable
{
  @NeedParcel
  public boolean a;
  @NeedParcel
  public String b;
  @NeedParcel
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KingCardInfo [showGuide=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", buttonTitle=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.KingCardInfo
 * JD-Core Version:    0.7.0.1
 */