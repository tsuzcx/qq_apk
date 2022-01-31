package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjkx;

public class KingCardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KingCardInfo> CREATOR = new bjkx();
  public String a;
  public boolean a;
  public String b;
  
  public KingCardInfo() {}
  
  public KingCardInfo(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.b = paramParcel.readString();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "KingCardInfo [showGuide=" + this.jdField_a_of_type_Boolean + ", buttonTitle=" + this.jdField_a_of_type_JavaLangString + ", jumpUrl=" + this.b + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeString(this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.model.KingCardInfo
 * JD-Core Version:    0.7.0.1
 */