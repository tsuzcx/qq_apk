import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;

public final class qnk
  implements Parcelable.Creator<TopicInfo>
{
  public TopicInfo a(Parcel paramParcel)
  {
    return new TopicInfo(paramParcel);
  }
  
  public TopicInfo[] a(int paramInt)
  {
    return new TopicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qnk
 * JD-Core Version:    0.7.0.1
 */