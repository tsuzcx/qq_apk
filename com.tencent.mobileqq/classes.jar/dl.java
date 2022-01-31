import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.DLFileInfo;

public final class dl
  implements Parcelable.Creator
{
  public DLFileInfo a(Parcel paramParcel)
  {
    return new DLFileInfo(paramParcel, null);
  }
  
  public DLFileInfo[] a(int paramInt)
  {
    return new DLFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     dl
 * JD-Core Version:    0.7.0.1
 */