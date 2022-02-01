import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;

public final class rhp
  implements Parcelable.Creator<ResultRecord>
{
  public ResultRecord a(Parcel paramParcel)
  {
    return new ResultRecord(paramParcel);
  }
  
  public ResultRecord[] a(int paramInt)
  {
    return new ResultRecord[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhp
 * JD-Core Version:    0.7.0.1
 */