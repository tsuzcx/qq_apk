import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;

public final class qba
  implements Parcelable.Creator<FusionBiuInfo>
{
  public FusionBiuInfo a(Parcel paramParcel)
  {
    return new FusionBiuInfo(paramParcel);
  }
  
  public FusionBiuInfo[] a(int paramInt)
  {
    return new FusionBiuInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qba
 * JD-Core Version:    0.7.0.1
 */