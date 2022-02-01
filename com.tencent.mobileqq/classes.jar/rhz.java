import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;

public final class rhz
  implements Parcelable.Creator<TagInfo>
{
  public TagInfo a(Parcel paramParcel)
  {
    return new TagInfo(paramParcel);
  }
  
  public TagInfo[] a(int paramInt)
  {
    return new TagInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhz
 * JD-Core Version:    0.7.0.1
 */