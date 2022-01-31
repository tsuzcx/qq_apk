import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.ucrop.model.AspectRatio;

public final class shs
  implements Parcelable.Creator<AspectRatio>
{
  public AspectRatio a(Parcel paramParcel)
  {
    return new AspectRatio(paramParcel);
  }
  
  public AspectRatio[] a(int paramInt)
  {
    return new AspectRatio[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     shs
 * JD-Core Version:    0.7.0.1
 */