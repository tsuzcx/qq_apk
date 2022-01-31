import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;

public final class qnd
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qnd
 * JD-Core Version:    0.7.0.1
 */