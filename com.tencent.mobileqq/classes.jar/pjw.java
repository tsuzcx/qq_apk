import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.impl.ipc.Const.SimpleRequest;

public final class pjw
  implements Parcelable.Creator
{
  public Const.SimpleRequest a(Parcel paramParcel)
  {
    return new Const.SimpleRequest(paramParcel);
  }
  
  public Const.SimpleRequest[] a(int paramInt)
  {
    return new Const.SimpleRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjw
 * JD-Core Version:    0.7.0.1
 */