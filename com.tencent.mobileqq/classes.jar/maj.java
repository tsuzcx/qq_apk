import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvGVideoLevelInfo.Medal;

public final class maj
  implements Parcelable.Creator<RecvGVideoLevelInfo.Medal>
{
  public RecvGVideoLevelInfo.Medal a(Parcel paramParcel)
  {
    return new RecvGVideoLevelInfo.Medal(paramParcel);
  }
  
  public RecvGVideoLevelInfo.Medal[] a(int paramInt)
  {
    return new RecvGVideoLevelInfo.Medal[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     maj
 * JD-Core Version:    0.7.0.1
 */