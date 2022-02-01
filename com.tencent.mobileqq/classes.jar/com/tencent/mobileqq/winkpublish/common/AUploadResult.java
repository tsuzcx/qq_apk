package com.tencent.mobileqq.winkpublish.common;

import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;
import com.tencent.mobileqq.winkpublish.common.feedInterface.IResult;

public class AUploadResult
  implements SmartParcelable, IResult, Cloneable
{
  @NeedParcel
  public int a;
  @NeedParcel
  private int b;
  @NeedParcel
  private int c;
  @NeedParcel
  private String d;
  @NeedParcel
  private Object e;
  @NeedParcel
  private final Bundle f = new Bundle();
  
  public AUploadResult() {}
  
  public AUploadResult(AUploadResult paramAUploadResult)
  {
    this.a = paramAUploadResult.a;
    this.b = paramAUploadResult.b;
    this.c = paramAUploadResult.c;
    this.d = paramAUploadResult.d;
    this.e = paramAUploadResult.e;
  }
  
  public AUploadResult a()
  {
    return new AUploadResult(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.AUploadResult
 * JD-Core Version:    0.7.0.1
 */