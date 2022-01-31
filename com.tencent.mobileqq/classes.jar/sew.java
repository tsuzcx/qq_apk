import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;

public final class sew
  implements Parcelable.Creator<ProfileParams>
{
  public ProfileParams a(Parcel paramParcel)
  {
    sex localsex = new sex();
    localsex.a(paramParcel.readString()).a(paramParcel.readInt()).b(paramParcel.readString()).c(paramParcel.readString()).d(paramParcel.readString()).a((ProfileParams.CurLoginUsr)paramParcel.readParcelable(ProfileParams.CurLoginUsr.CREATOR.getClass().getClassLoader()));
    return localsex.a();
  }
  
  public ProfileParams[] a(int paramInt)
  {
    return new ProfileParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sew
 * JD-Core Version:    0.7.0.1
 */