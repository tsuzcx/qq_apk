import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;

public final class sss
  implements Parcelable.Creator<AdData>
{
  public AdData a(Parcel paramParcel)
  {
    return new AdData(paramParcel);
  }
  
  public AdData[] a(int paramInt)
  {
    return new AdData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sss
 * JD-Core Version:    0.7.0.1
 */