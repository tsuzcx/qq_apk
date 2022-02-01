package cooperation.qqlive.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QQLiveAudienceGiftData
  implements Parcelable
{
  public static final Parcelable.Creator<QQLiveAudienceGiftData> CREATOR = new QQLiveAudienceGiftData.1();
  public int a;
  public String b = "";
  public long c;
  public long d;
  public long e;
  public String f = "";
  public String g = "";
  public String h = "";
  public int i;
  public String j = "";
  public String k;
  public String l;
  public boolean m = false;
  
  public QQLiveAudienceGiftData(int paramInt1, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramLong3;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.i = paramInt2;
    this.j = paramString5;
    this.k = paramString6;
    this.l = paramString7;
    this.m = paramBoolean;
  }
  
  protected QQLiveAudienceGiftData(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    boolean[] arrayOfBoolean = new boolean[1];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.m = arrayOfBoolean[0];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeBooleanArray(new boolean[] { this.m });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.data.QQLiveAudienceGiftData
 * JD-Core Version:    0.7.0.1
 */