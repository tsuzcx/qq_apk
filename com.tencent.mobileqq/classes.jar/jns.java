import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvMsg;

public final class jns
  implements Parcelable.Creator
{
  public RecvMsg a(Parcel paramParcel)
  {
    return new RecvMsg(paramParcel);
  }
  
  public RecvMsg[] a(int paramInt)
  {
    return new RecvMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jns
 * JD-Core Version:    0.7.0.1
 */