import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.LBSInfo;

public final class lzm
  implements Parcelable.Creator<LBSInfo>
{
  public LBSInfo a(Parcel paramParcel)
  {
    return new LBSInfo(paramParcel);
  }
  
  public LBSInfo[] a(int paramInt)
  {
    return new LBSInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lzm
 * JD-Core Version:    0.7.0.1
 */