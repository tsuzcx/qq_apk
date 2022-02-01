import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo;

public final class riu
  implements Parcelable.Creator<WeishiRedDotInfo>
{
  public WeishiRedDotInfo a(Parcel paramParcel)
  {
    return new WeishiRedDotInfo(paramParcel);
  }
  
  public WeishiRedDotInfo[] a(int paramInt)
  {
    return new WeishiRedDotInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     riu
 * JD-Core Version:    0.7.0.1
 */