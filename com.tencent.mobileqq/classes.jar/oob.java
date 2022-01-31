import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs;

public final class oob
  implements Parcelable.Creator<AndroidAPs>
{
  public AndroidAPs a(Parcel paramParcel)
  {
    return new AndroidAPs(paramParcel);
  }
  
  public AndroidAPs[] a(int paramInt)
  {
    return new AndroidAPs[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oob
 * JD-Core Version:    0.7.0.1
 */