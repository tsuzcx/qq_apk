import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.wtogether.data.WTFileInfo;

public final class myq
  implements Parcelable.Creator<WTFileInfo>
{
  public WTFileInfo a(Parcel paramParcel)
  {
    return new WTFileInfo(paramParcel);
  }
  
  public WTFileInfo[] a(int paramInt)
  {
    return new WTFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myq
 * JD-Core Version:    0.7.0.1
 */