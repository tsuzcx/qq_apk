import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.avgame.util.AVGameStep;

public final class njg
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njg
 * JD-Core Version:    0.7.0.1
 */