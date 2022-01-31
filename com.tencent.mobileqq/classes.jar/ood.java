import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.magic.models.CG;

public final class ood
  implements Parcelable.Creator<CG>
{
  public CG a(Parcel paramParcel)
  {
    return new CG(paramParcel);
  }
  
  public CG[] a(int paramInt)
  {
    return new CG[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ood
 * JD-Core Version:    0.7.0.1
 */