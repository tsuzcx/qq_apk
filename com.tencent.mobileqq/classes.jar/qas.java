import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo;

public final class qas
  implements Parcelable.Creator<BaseVideoArticleInfo>
{
  public BaseVideoArticleInfo a(Parcel paramParcel)
  {
    return new BaseVideoArticleInfo(paramParcel);
  }
  
  public BaseVideoArticleInfo[] a(int paramInt)
  {
    return new BaseVideoArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qas
 * JD-Core Version:    0.7.0.1
 */