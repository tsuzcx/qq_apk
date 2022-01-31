import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;

public final class lxf
  implements Parcelable.Creator
{
  public DislikeInfo a(Parcel paramParcel)
  {
    return new DislikeInfo(paramParcel);
  }
  
  public DislikeInfo[] a(int paramInt)
  {
    return new DislikeInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxf
 * JD-Core Version:    0.7.0.1
 */