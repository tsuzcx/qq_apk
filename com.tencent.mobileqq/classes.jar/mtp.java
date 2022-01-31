import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.Builder;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;

public final class mtp
  implements Parcelable.Creator
{
  public ProfileParams a(Parcel paramParcel)
  {
    ProfileParams.Builder localBuilder = new ProfileParams.Builder();
    localBuilder.a(paramParcel.readString()).a(paramParcel.readInt()).b(paramParcel.readString()).c(paramParcel.readString()).d(paramParcel.readString()).a((ProfileParams.CurLoginUsr)paramParcel.readParcelable(ProfileParams.CurLoginUsr.CREATOR.getClass().getClassLoader()));
    return localBuilder.a();
  }
  
  public ProfileParams[] a(int paramInt)
  {
    return new ProfileParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtp
 * JD-Core Version:    0.7.0.1
 */