import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidPs;

public final class ooc
  implements Parcelable.Creator<AndroidPs>
{
  public AndroidPs a(Parcel paramParcel)
  {
    return new AndroidPs(paramParcel);
  }
  
  public AndroidPs[] a(int paramInt)
  {
    return new AndroidPs[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooc
 * JD-Core Version:    0.7.0.1
 */