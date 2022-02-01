import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;

public final class pvz
  implements Parcelable.Creator<ReadInJoyDraftboxItem>
{
  public ReadInJoyDraftboxItem a(Parcel paramParcel)
  {
    return new ReadInJoyDraftboxItem(paramParcel);
  }
  
  public ReadInJoyDraftboxItem[] a(int paramInt)
  {
    return new ReadInJoyDraftboxItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvz
 * JD-Core Version:    0.7.0.1
 */