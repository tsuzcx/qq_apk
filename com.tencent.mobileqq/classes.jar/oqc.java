import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;

public final class oqc
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqc
 * JD-Core Version:    0.7.0.1
 */