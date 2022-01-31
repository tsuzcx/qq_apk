import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.EncryptUinInfo;

public final class nkz
  implements Parcelable.Creator<EncryptUinInfo>
{
  public EncryptUinInfo a(Parcel paramParcel)
  {
    return new EncryptUinInfo(paramParcel);
  }
  
  public EncryptUinInfo[] a(int paramInt)
  {
    return new EncryptUinInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkz
 * JD-Core Version:    0.7.0.1
 */