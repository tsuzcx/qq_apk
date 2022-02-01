package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

public class WeishiOperationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiOperationInfo> CREATOR = new WeishiOperationInfo.1();
  public String actionUrl;
  public Map<Integer, String> weishiOperationInfo = new HashMap();
  
  protected WeishiOperationInfo(Parcel paramParcel)
  {
    paramParcel.readMap(this.weishiOperationInfo, Map.class.getClassLoader());
    this.actionUrl = paramParcel.readString();
  }
  
  public WeishiOperationInfo(Map<Integer, String> paramMap)
  {
    this.weishiOperationInfo = paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.weishiOperationInfo);
    paramParcel.writeString(this.actionUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.WeishiOperationInfo
 * JD-Core Version:    0.7.0.1
 */