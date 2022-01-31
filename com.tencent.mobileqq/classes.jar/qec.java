import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;

public final class qec
  implements Parcelable.Creator<VisibleSetParam>
{
  public VisibleSetParam a(Parcel paramParcel)
  {
    return new VisibleSetParam(paramParcel);
  }
  
  public VisibleSetParam[] a(int paramInt)
  {
    return new VisibleSetParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qec
 * JD-Core Version:    0.7.0.1
 */