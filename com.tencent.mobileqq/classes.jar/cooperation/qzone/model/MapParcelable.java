package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Map;

public class MapParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<MapParcelable> CREATOR = new MapParcelable.1();
  private Map<Integer, String> singleMap;
  
  public MapParcelable(Map<Integer, String> paramMap)
  {
    this.singleMap = paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Map<Integer, String> getSingleMap()
  {
    return this.singleMap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.singleMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.MapParcelable
 * JD-Core Version:    0.7.0.1
 */