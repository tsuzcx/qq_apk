import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.internal.telephony.SmsRawData;

public final class g
  implements Parcelable.Creator
{
  public SmsRawData a(Parcel paramParcel)
  {
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    return new SmsRawData(arrayOfByte);
  }
  
  public SmsRawData[] a(int paramInt)
  {
    return new SmsRawData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     g
 * JD-Core Version:    0.7.0.1
 */