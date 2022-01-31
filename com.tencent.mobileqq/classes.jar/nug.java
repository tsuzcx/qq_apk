import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.CardVideoInfo;

public final class nug
  implements Parcelable.Creator
{
  public CardItem.CardVideoInfo a(Parcel paramParcel)
  {
    return new CardItem.CardVideoInfo(paramParcel);
  }
  
  public CardItem.CardVideoInfo[] a(int paramInt)
  {
    return new CardItem.CardVideoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nug
 * JD-Core Version:    0.7.0.1
 */