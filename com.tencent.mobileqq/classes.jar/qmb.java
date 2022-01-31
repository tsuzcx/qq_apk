import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;

public final class qmb
  implements Parcelable.Creator<SocializeFeedsInfo.BiuCommentInfo>
{
  public SocializeFeedsInfo.BiuCommentInfo a(Parcel paramParcel)
  {
    return new SocializeFeedsInfo.BiuCommentInfo(paramParcel);
  }
  
  public SocializeFeedsInfo.BiuCommentInfo[] a(int paramInt)
  {
    return new SocializeFeedsInfo.BiuCommentInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qmb
 * JD-Core Version:    0.7.0.1
 */