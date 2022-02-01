import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.AVPbInfo;

public final class lwh
  implements Parcelable.Creator<AVPbInfo>
{
  public AVPbInfo a(Parcel paramParcel)
  {
    return new AVPbInfo(paramParcel);
  }
  
  public AVPbInfo[] a(int paramInt)
  {
    return new AVPbInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lwh
 * JD-Core Version:    0.7.0.1
 */