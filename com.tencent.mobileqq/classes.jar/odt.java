import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;

public final class odt
  implements Parcelable.Creator
{
  public EditTakePhotoSource a(Parcel paramParcel)
  {
    return new EditTakePhotoSource(paramParcel);
  }
  
  public EditTakePhotoSource[] a(int paramInt)
  {
    return new EditTakePhotoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odt
 * JD-Core Version:    0.7.0.1
 */