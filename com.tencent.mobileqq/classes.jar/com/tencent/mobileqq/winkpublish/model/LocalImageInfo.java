package com.tencent.mobileqq.winkpublish.model;

import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;

public class LocalImageInfo
  implements SmartParcelable
{
  @NeedParcel
  protected String a;
  @NeedParcel
  protected String b;
  @NeedParcel
  protected long c;
  @NeedParcel
  protected long d;
  @NeedParcel
  protected CharSequence e;
  
  private boolean a(LocalImageInfo paramLocalImageInfo)
  {
    Object localObject1 = this.a;
    Object localObject2 = paramLocalImageInfo.a;
    if ((localObject1 == localObject2) || ((localObject1 != null) && (((String)localObject1).equals(localObject2))))
    {
      localObject1 = this.b;
      localObject2 = paramLocalImageInfo.b;
      if ((localObject1 == localObject2) || ((localObject1 != null) && (((String)localObject1).equals(localObject2))))
      {
        localObject1 = this.e;
        localObject2 = paramLocalImageInfo.e;
        if (((localObject1 == localObject2) || ((localObject1 != null) && (localObject1.equals(localObject2)))) && (this.c == paramLocalImageInfo.c) && (this.d == paramLocalImageInfo.d)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof LocalImageInfo))) {
      return a((LocalImageInfo)paramObject);
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = this.b;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = this.e;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    long l = this.c;
    int m = (int)(l ^ l >>> 32);
    l = this.d;
    return ((((527 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l ^ l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.LocalImageInfo
 * JD-Core Version:    0.7.0.1
 */