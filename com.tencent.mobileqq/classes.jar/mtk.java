import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo.ChannelInfo;

public final class mtk
  implements Parcelable.Creator
{
  public FastWebVideoInfo.ChannelInfo a(Parcel paramParcel)
  {
    return new FastWebVideoInfo.ChannelInfo(paramParcel);
  }
  
  public FastWebVideoInfo.ChannelInfo[] a(int paramInt)
  {
    return new FastWebVideoInfo.ChannelInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtk
 * JD-Core Version:    0.7.0.1
 */