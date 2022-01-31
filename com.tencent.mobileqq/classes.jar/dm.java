import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.ImageInfo;

public final class dm
  implements Parcelable.Creator
{
  public ImageInfo a(Parcel paramParcel)
  {
    return new ImageInfo(paramParcel, null);
  }
  
  public ImageInfo[] a(int paramInt)
  {
    return new ImageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */