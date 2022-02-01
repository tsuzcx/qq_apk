import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;

public final class rsf
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsf
 * JD-Core Version:    0.7.0.1
 */