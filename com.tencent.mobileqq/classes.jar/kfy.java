import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.utils.InviteBaseData;

public final class kfy
  implements Parcelable.Creator
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfy
 * JD-Core Version:    0.7.0.1
 */