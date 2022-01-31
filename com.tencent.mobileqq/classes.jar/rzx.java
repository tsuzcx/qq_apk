import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;

public final class rzx
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rzx
 * JD-Core Version:    0.7.0.1
 */