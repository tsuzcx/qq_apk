import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;

public final class qmi
  implements Parcelable.Creator<SocializeFeedsInfo.JumpInfo>
{
  public SocializeFeedsInfo.JumpInfo a(Parcel paramParcel)
  {
    return new SocializeFeedsInfo.JumpInfo(paramParcel);
  }
  
  public SocializeFeedsInfo.JumpInfo[] a(int paramInt)
  {
    return new SocializeFeedsInfo.JumpInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qmi
 * JD-Core Version:    0.7.0.1
 */