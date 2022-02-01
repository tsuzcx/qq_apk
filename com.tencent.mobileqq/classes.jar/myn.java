import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.wtogether.data.ChooseFileInfo;

public final class myn
  implements Parcelable.Creator<ChooseFileInfo>
{
  public ChooseFileInfo a(Parcel paramParcel)
  {
    return new ChooseFileInfo(paramParcel);
  }
  
  public ChooseFileInfo[] a(int paramInt)
  {
    return new ChooseFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myn
 * JD-Core Version:    0.7.0.1
 */