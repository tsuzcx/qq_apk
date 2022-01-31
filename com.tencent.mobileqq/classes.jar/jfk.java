import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.app.PstnSessionInfo;

public final class jfk
  implements Parcelable.Creator
{
  public PstnSessionInfo a(Parcel paramParcel)
  {
    return new PstnSessionInfo(paramParcel);
  }
  
  public PstnSessionInfo[] a(int paramInt)
  {
    return new PstnSessionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     jfk
 * JD-Core Version:    0.7.0.1
 */