import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;

public final class qdz
  implements Parcelable.Creator<VideoColumnInfo>
{
  public VideoColumnInfo a(Parcel paramParcel)
  {
    return new VideoColumnInfo(paramParcel);
  }
  
  public VideoColumnInfo[] a(int paramInt)
  {
    return new VideoColumnInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdz
 * JD-Core Version:    0.7.0.1
 */