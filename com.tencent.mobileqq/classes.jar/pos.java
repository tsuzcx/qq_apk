import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;

public final class pos
  implements Parcelable.Creator
{
  public DownloadGlobalStrategy.StrategyInfo a(Parcel paramParcel)
  {
    return new DownloadGlobalStrategy.StrategyInfo(paramParcel);
  }
  
  public DownloadGlobalStrategy.StrategyInfo[] a(int paramInt)
  {
    return new DownloadGlobalStrategy.StrategyInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pos
 * JD-Core Version:    0.7.0.1
 */