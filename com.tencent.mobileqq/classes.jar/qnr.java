import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;

public final class qnr
  implements Parcelable.Creator<UrlJumpInfo>
{
  public UrlJumpInfo a(Parcel paramParcel)
  {
    return new UrlJumpInfo(paramParcel);
  }
  
  public UrlJumpInfo[] a(int paramInt)
  {
    return new UrlJumpInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qnr
 * JD-Core Version:    0.7.0.1
 */