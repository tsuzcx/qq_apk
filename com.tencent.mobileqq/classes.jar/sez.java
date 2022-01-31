import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;

public final class sez
  implements Parcelable.Creator<ProfileParams>
{
  public ProfileParams a(Parcel paramParcel)
  {
    sfa localsfa = new sfa();
    localsfa.a(paramParcel.readString()).a(paramParcel.readInt()).b(paramParcel.readString()).c(paramParcel.readString()).d(paramParcel.readString()).a((ProfileParams.CurLoginUsr)paramParcel.readParcelable(ProfileParams.CurLoginUsr.CREATOR.getClass().getClassLoader()));
    return localsfa.a();
  }
  
  public ProfileParams[] a(int paramInt)
  {
    return new ProfileParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sez
 * JD-Core Version:    0.7.0.1
 */