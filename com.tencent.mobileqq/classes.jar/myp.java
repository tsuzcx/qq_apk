import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.wtogether.data.ReqVideoAction;

public final class myp
  implements Parcelable.Creator<ReqVideoAction>
{
  public ReqVideoAction a(Parcel paramParcel)
  {
    return new ReqVideoAction(paramParcel);
  }
  
  public ReqVideoAction[] a(int paramInt)
  {
    return new ReqVideoAction[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myp
 * JD-Core Version:    0.7.0.1
 */