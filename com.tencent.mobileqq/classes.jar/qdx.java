import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;

public final class qdx
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdx
 * JD-Core Version:    0.7.0.1
 */