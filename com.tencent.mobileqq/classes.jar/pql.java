import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;

public final class pql
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pql
 * JD-Core Version:    0.7.0.1
 */