import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.utils.InviteBaseData;

public final class mun
  implements Parcelable.Creator<InviteBaseData>
{
  public InviteBaseData a(Parcel paramParcel)
  {
    return new InviteBaseData(paramParcel);
  }
  
  public InviteBaseData[] a(int paramInt)
  {
    return new InviteBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mun
 * JD-Core Version:    0.7.0.1
 */