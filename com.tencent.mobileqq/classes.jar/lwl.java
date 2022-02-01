import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.AVRedPacketConfig.ExpressionInfo;

public final class lwl
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lwl
 * JD-Core Version:    0.7.0.1
 */