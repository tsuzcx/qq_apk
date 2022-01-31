import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.AVRedPacketConfig.ExpressionInfo;

public final class llp
  implements Parcelable.Creator<AVRedPacketConfig.ExpressionInfo>
{
  public AVRedPacketConfig.ExpressionInfo a(Parcel paramParcel)
  {
    return new AVRedPacketConfig.ExpressionInfo(paramParcel);
  }
  
  public AVRedPacketConfig.ExpressionInfo[] a(int paramInt)
  {
    return new AVRedPacketConfig.ExpressionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     llp
 * JD-Core Version:    0.7.0.1
 */