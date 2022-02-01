import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.avgame.ipc.MapParcelable;
import java.util.HashMap;

public final class nfh
  implements Parcelable.Creator<MapParcelable>
{
  public MapParcelable a(Parcel paramParcel)
  {
    MapParcelable localMapParcelable = new MapParcelable();
    localMapParcelable.a = paramParcel.readHashMap(HashMap.class.getClassLoader());
    return localMapParcelable;
  }
  
  public MapParcelable[] a(int paramInt)
  {
    return new MapParcelable[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfh
 * JD-Core Version:    0.7.0.1
 */