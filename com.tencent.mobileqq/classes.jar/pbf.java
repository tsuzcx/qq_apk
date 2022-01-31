import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem.ReadInJoyDraftboxContent;

public final class pbf
  implements Parcelable.Creator<ReadInJoyDraftboxItem.ReadInJoyDraftboxContent>
{
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent a(Parcel paramParcel)
  {
    return new ReadInJoyDraftboxItem.ReadInJoyDraftboxContent(paramParcel);
  }
  
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent[] a(int paramInt)
  {
    return new ReadInJoyDraftboxItem.ReadInJoyDraftboxContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbf
 * JD-Core Version:    0.7.0.1
 */