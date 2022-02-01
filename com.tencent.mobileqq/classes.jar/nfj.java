import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.avgame.ipc.UserInfo;

public final class nfj
  implements Parcelable.Creator<UserInfo>
{
  public UserInfo a(Parcel paramParcel)
  {
    return new UserInfo(paramParcel);
  }
  
  public UserInfo[] a(int paramInt)
  {
    return new UserInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfj
 * JD-Core Version:    0.7.0.1
 */