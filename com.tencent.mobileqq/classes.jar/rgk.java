import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.SimpleChannelInfo;

public final class rgk
  implements Parcelable.Creator<SimpleChannelInfo>
{
  public SimpleChannelInfo a(Parcel paramParcel)
  {
    return new SimpleChannelInfo(paramParcel);
  }
  
  public SimpleChannelInfo[] a(int paramInt)
  {
    return new SimpleChannelInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgk
 * JD-Core Version:    0.7.0.1
 */