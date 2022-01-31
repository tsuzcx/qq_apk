import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.util.file.SendInfo;

public final class dn
  implements Parcelable.Creator
{
  public SendInfo a(Parcel paramParcel)
  {
    return new SendInfo(paramParcel, null);
  }
  
  public SendInfo[] a(int paramInt)
  {
    return new SendInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     dn
 * JD-Core Version:    0.7.0.1
 */