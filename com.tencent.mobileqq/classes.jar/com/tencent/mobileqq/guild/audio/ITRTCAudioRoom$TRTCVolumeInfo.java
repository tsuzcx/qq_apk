package com.tencent.mobileqq.guild.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ITRTCAudioRoom$TRTCVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TRTCVolumeInfo> CREATOR = new ITRTCAudioRoom.TRTCVolumeInfo.1();
  public String a;
  public int b;
  
  public static TRTCVolumeInfo a(TRTCCloudDef.TRTCVolumeInfo paramTRTCVolumeInfo)
  {
    TRTCVolumeInfo localTRTCVolumeInfo = new TRTCVolumeInfo();
    localTRTCVolumeInfo.a = paramTRTCVolumeInfo.userId;
    localTRTCVolumeInfo.b = paramTRTCVolumeInfo.volume;
    return localTRTCVolumeInfo;
  }
  
  public static ArrayList<TRTCVolumeInfo> a(List<TRTCCloudDef.TRTCVolumeInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((TRTCCloudDef.TRTCVolumeInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TRTCVolumeInfo {userId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", volume=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.ITRTCAudioRoom.TRTCVolumeInfo
 * JD-Core Version:    0.7.0.1
 */