import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;

public final class obk
  implements Parcelable.Creator
{
  public EditLocalVideoSource a(Parcel paramParcel)
  {
    return new EditLocalVideoSource(paramParcel);
  }
  
  public EditLocalVideoSource[] a(int paramInt)
  {
    return new EditLocalVideoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obk
 * JD-Core Version:    0.7.0.1
 */