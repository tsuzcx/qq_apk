import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public final class qkg
  implements Parcelable.Creator<ArticleInfo>
{
  public ArticleInfo a(Parcel paramParcel)
  {
    return new ArticleInfo(paramParcel);
  }
  
  public ArticleInfo[] a(int paramInt)
  {
    return new ArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qkg
 * JD-Core Version:    0.7.0.1
 */