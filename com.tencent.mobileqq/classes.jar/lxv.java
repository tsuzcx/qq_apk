import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvMsg;

public final class lxv
  implements Parcelable.Creator<RecvMsg>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lxv
 * JD-Core Version:    0.7.0.1
 */