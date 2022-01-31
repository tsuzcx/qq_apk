import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;

public final class ohm
  implements Parcelable.Creator
{
  public EditLocalGifSource a(Parcel paramParcel)
  {
    return new EditLocalGifSource(paramParcel);
  }
  
  public EditLocalGifSource[] a(int paramInt)
  {
    return new EditLocalGifSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohm
 * JD-Core Version:    0.7.0.1
 */