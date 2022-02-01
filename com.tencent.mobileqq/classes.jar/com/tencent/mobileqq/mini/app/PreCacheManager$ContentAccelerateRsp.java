package com.tencent.mobileqq.mini.app;

import NS_COMM.COMM.Entry;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class PreCacheManager$ContentAccelerateRsp
  implements Parcelable
{
  public static final Parcelable.Creator<ContentAccelerateRsp> CREATOR = new PreCacheManager.ContentAccelerateRsp.1();
  public byte[] cacheData;
  public int httpReturnCode;
  public List<COMM.Entry> rspHeaders;
  
  public PreCacheManager$ContentAccelerateRsp() {}
  
  protected PreCacheManager$ContentAccelerateRsp(Parcel paramParcel)
  {
    this.rspHeaders = new ArrayList();
    paramParcel.readList(this.rspHeaders, COMM.Entry.class.getClassLoader());
    this.cacheData = paramParcel.createByteArray();
    this.httpReturnCode = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.rspHeaders);
    paramParcel.writeByteArray(this.cacheData);
    paramParcel.writeInt(this.httpReturnCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.ContentAccelerateRsp
 * JD-Core Version:    0.7.0.1
 */