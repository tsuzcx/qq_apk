import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.DLFileInfo;

public final class ex
  implements Parcelable.Creator<DLFileInfo>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ex
 * JD-Core Version:    0.7.0.1
 */