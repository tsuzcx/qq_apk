package cooperation.qzone.statistic.serverip;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjpb;

public class WebAppIpRecord
  implements Parcelable
{
  public static final Parcelable.Creator<WebAppIpRecord> CREATOR = new bjpb();
  public long a;
  public WebAppIpRecord.FixedSizeLinkedHashMap<Integer, Long> a;
  
  public WebAppIpRecord() {}
  
  public WebAppIpRecord(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    paramParcel = paramParcel.readHashMap(getClass().getClassLoader());
    this.jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap = new WebAppIpRecord.FixedSizeLinkedHashMap();
    this.jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap.putAll(paramParcel);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (this.jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap == null) {
      this.jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap = new WebAppIpRecord.FixedSizeLinkedHashMap();
    }
    this.jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeMap(this.jdField_a_of_type_CooperationQzoneStatisticServeripWebAppIpRecord$FixedSizeLinkedHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.statistic.serverip.WebAppIpRecord
 * JD-Core Version:    0.7.0.1
 */