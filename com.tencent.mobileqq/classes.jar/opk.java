import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyUgcVideoReportItem;

public final class opk
  implements Parcelable.Creator<ReadInJoyUgcVideoReportItem>
{
  public ReadInJoyUgcVideoReportItem a(Parcel paramParcel)
  {
    return new ReadInJoyUgcVideoReportItem(paramParcel);
  }
  
  public ReadInJoyUgcVideoReportItem[] a(int paramInt)
  {
    return new ReadInJoyUgcVideoReportItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opk
 * JD-Core Version:    0.7.0.1
 */