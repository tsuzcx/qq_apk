import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;

public final class obg
  implements Parcelable.Creator
{
  public EditLocalPhotoSource a(Parcel paramParcel)
  {
    return new EditLocalPhotoSource(paramParcel);
  }
  
  public EditLocalPhotoSource[] a(int paramInt)
  {
    return new EditLocalPhotoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obg
 * JD-Core Version:    0.7.0.1
 */