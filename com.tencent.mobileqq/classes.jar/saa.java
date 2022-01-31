import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public final class saa
  implements Parcelable.Creator<BaseData>
{
  public BaseData a(Parcel paramParcel)
  {
    return new BaseData(paramParcel);
  }
  
  public BaseData[] a(int paramInt)
  {
    return new BaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     saa
 * JD-Core Version:    0.7.0.1
 */