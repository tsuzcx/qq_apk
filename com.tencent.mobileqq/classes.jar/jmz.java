import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.AVRedPacketConfig;

public final class jmz
  implements Parcelable.Creator
{
  public AVRedPacketConfig a(Parcel paramParcel)
  {
    return new AVRedPacketConfig(paramParcel);
  }
  
  public AVRedPacketConfig[] a(int paramInt)
  {
    return new AVRedPacketConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmz
 * JD-Core Version:    0.7.0.1
 */