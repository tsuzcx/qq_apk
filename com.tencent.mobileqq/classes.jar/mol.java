import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo;

public final class mol
  implements Parcelable.Creator
{
  public FastWebVideoInfo a(Parcel paramParcel)
  {
    return new FastWebVideoInfo(paramParcel);
  }
  
  public FastWebVideoInfo[] a(int paramInt)
  {
    return new FastWebVideoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mol
 * JD-Core Version:    0.7.0.1
 */