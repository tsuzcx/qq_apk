import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.OpenRedPacketResultStruct;

public final class qfv
  implements Parcelable.Creator<RIJRedPacketManager.OpenRedPacketResultStruct>
{
  public RIJRedPacketManager.OpenRedPacketResultStruct a(Parcel paramParcel)
  {
    return new RIJRedPacketManager.OpenRedPacketResultStruct(paramParcel);
  }
  
  public RIJRedPacketManager.OpenRedPacketResultStruct[] a(int paramInt)
  {
    return new RIJRedPacketManager.OpenRedPacketResultStruct[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qfv
 * JD-Core Version:    0.7.0.1
 */