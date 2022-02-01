package com.tencent.mobileqq.winkpublish.model;

import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;

public class VideoUrl
  implements SmartParcelable
{
  @NeedParcel
  public String a;
  @NeedParcel
  public int b;
  @NeedParcel
  public int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoUrl [url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", decoderType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", videoRate=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.VideoUrl
 * JD-Core Version:    0.7.0.1
 */