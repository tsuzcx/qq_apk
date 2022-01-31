import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;

public final class ods
  implements Parcelable.Creator
{
  public EditTakeGifSource a(Parcel paramParcel)
  {
    return new EditTakeGifSource(paramParcel);
  }
  
  public EditTakeGifSource[] a(int paramInt)
  {
    return new EditTakeGifSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ods
 * JD-Core Version:    0.7.0.1
 */