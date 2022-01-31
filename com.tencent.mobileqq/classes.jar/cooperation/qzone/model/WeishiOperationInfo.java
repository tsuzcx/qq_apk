package cooperation.qzone.model;

import anco;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

public class WeishiOperationInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new anco();
  public Map a = new HashMap();
  
  public WeishiOperationInfo(Parcel paramParcel)
  {
    paramParcel.readMap(this.a, Map.class.getClassLoader());
  }
  
  public WeishiOperationInfo(Map paramMap)
  {
    this.a = paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.WeishiOperationInfo
 * JD-Core Version:    0.7.0.1
 */