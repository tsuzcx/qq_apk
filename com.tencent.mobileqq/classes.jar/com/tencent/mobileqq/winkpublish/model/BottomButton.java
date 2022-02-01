package com.tencent.mobileqq.winkpublish.model;

import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;

public class BottomButton
  implements SmartParcelable
{
  @NeedParcel
  public String a = "";
  @NeedParcel
  public int b;
  @NeedParcel
  public String c = "";
  @NeedParcel
  public String d = "";
  @NeedParcel
  public String e = "";
  @NeedParcel
  public String f = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ButtomButton [button_text=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", actionUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", buttonImg=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", buttonBackgroundImg=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", buttonIcon=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.BottomButton
 * JD-Core Version:    0.7.0.1
 */