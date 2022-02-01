import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvGVideoLevelInfo;

public final class lyc
  implements Parcelable.Creator<RecvGVideoLevelInfo>
{
  public RecvGVideoLevelInfo a(Parcel paramParcel)
  {
    return new RecvGVideoLevelInfo(paramParcel);
  }
  
  public RecvGVideoLevelInfo[] a(int paramInt)
  {
    return new RecvGVideoLevelInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyc
 * JD-Core Version:    0.7.0.1
 */