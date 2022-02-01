package cooperation.qqpim;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QQPimTipsInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QQPimTipsInfo> CREATOR = new QQPimTipsInfo.1();
  public int a;
  public String b;
  public byte c;
  public int d;
  
  public QQPimTipsInfo() {}
  
  private QQPimTipsInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readByte();
    this.d = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeByte(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimTipsInfo
 * JD-Core Version:    0.7.0.1
 */