package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MapParcelable$1
  implements Parcelable.Creator<MapParcelable>
{
  public MapParcelable createFromParcel(Parcel paramParcel)
  {
    return new MapParcelable(paramParcel.readHashMap(getClass().getClassLoader()));
  }
  
  public MapParcelable[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.MapParcelable.1
 * JD-Core Version:    0.7.0.1
 */