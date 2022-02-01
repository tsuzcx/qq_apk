import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.PicData;

public final class pwa
  implements Parcelable.Creator<ReadInJoyDraftboxItem.PicData>
{
  public ReadInJoyDraftboxItem.PicData a(Parcel paramParcel)
  {
    return new ReadInJoyDraftboxItem.PicData(paramParcel);
  }
  
  public ReadInJoyDraftboxItem.PicData[] a(int paramInt)
  {
    return new ReadInJoyDraftboxItem.PicData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwa
 * JD-Core Version:    0.7.0.1
 */