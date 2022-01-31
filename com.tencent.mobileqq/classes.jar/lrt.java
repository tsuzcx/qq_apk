import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.magic.models.Status;

public final class lrt
  implements Parcelable.Creator
{
  public Status a(Parcel paramParcel)
  {
    return new Status(paramParcel, null);
  }
  
  public Status[] a(int paramInt)
  {
    return new Status[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrt
 * JD-Core Version:    0.7.0.1
 */