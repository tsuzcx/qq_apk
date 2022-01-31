import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;

public final class nsh
  implements Parcelable.Creator<VideoAdInfo.NegFeedback>
{
  public VideoAdInfo.NegFeedback a(Parcel paramParcel)
  {
    return new VideoAdInfo.NegFeedback(paramParcel);
  }
  
  public VideoAdInfo.NegFeedback[] a(int paramInt)
  {
    return new VideoAdInfo.NegFeedback[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nsh
 * JD-Core Version:    0.7.0.1
 */