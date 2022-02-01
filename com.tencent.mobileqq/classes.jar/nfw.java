import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.avgame.util.AVGameStep;

public final class nfw
  implements Parcelable.Creator<AVGameStep>
{
  public AVGameStep a(Parcel paramParcel)
  {
    return new AVGameStep(paramParcel);
  }
  
  public AVGameStep[] a(int paramInt)
  {
    return new AVGameStep[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfw
 * JD-Core Version:    0.7.0.1
 */