import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;

public final class qkp
  implements Parcelable.Creator<DislikeInfo>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qkp
 * JD-Core Version:    0.7.0.1
 */