import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public final class ojz
  implements Parcelable.Creator
{
  public PublishParam a(Parcel paramParcel)
  {
    return new PublishParam(paramParcel);
  }
  
  public PublishParam[] a(int paramInt)
  {
    return new PublishParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojz
 * JD-Core Version:    0.7.0.1
 */