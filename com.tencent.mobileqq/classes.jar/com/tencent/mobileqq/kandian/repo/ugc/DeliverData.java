package com.tencent.mobileqq.kandian.repo.ugc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DeliverData
  implements Parcelable
{
  public static final Parcelable.Creator<DeliverData> CREATOR = new DeliverData.1();
  private static int a = 9;
  private int[] b;
  private int[] c;
  private String[] d;
  private String[] e;
  
  public DeliverData()
  {
    int i = a;
    this.b = new int[i];
    this.c = new int[i];
    this.d = new String[i];
    this.e = new String[i];
  }
  
  public DeliverData(Parcel paramParcel)
  {
    int i = a;
    this.b = new int[i];
    this.c = new int[i];
    this.d = new String[i];
    this.e = new String[i];
    if (paramParcel.readInt() > 0) {
      paramParcel.readIntArray(this.b);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readIntArray(this.c);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readStringArray(this.d);
    }
    if (paramParcel.readInt() > 0) {
      paramParcel.readStringArray(this.e);
    }
  }
  
  public void a()
  {
    int i = a;
    this.b = new int[i];
    this.c = new int[i];
    this.d = new String[i];
    this.e = new String[i];
  }
  
  public void a(int paramInt, Integer paramInteger)
  {
    if (paramInt < a) {
      this.b[paramInt] = paramInteger.intValue();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt < a) {
      this.d[paramInt] = paramString;
    }
  }
  
  public void b(int paramInt, Integer paramInteger)
  {
    if (paramInt < a) {
      this.c[paramInt] = paramInteger.intValue();
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (paramInt < a) {
      this.e[paramInt] = paramString;
    }
  }
  
  public int[] b()
  {
    return this.b;
  }
  
  public int[] c()
  {
    return this.c;
  }
  
  public String[] d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String[] e()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeIntArray(this.b);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeIntArray(this.c);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeStringArray(this.d);
    }
    else
    {
      paramParcel.writeInt(0);
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramParcel.writeInt(localObject.length);
      paramParcel.writeStringArray(this.e);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.DeliverData
 * JD-Core Version:    0.7.0.1
 */