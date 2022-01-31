import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer.CacheFileAttribute;

public final class pif
  implements Parcelable.Creator
{
  public QzoneResumeTransfer.CacheFileAttribute a(Parcel paramParcel)
  {
    return new QzoneResumeTransfer.CacheFileAttribute(paramParcel);
  }
  
  public QzoneResumeTransfer.CacheFileAttribute[] a(int paramInt)
  {
    return new QzoneResumeTransfer.CacheFileAttribute[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pif
 * JD-Core Version:    0.7.0.1
 */