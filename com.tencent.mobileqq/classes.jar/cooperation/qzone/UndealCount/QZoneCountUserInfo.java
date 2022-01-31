package cooperation.qzone.UndealCount;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import anba;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import cooperation.qzone.util.JceUtils;

public class QZoneCountUserInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new anba();
  public byte a;
  public int a;
  public long a;
  public PassiveFeedsPush a;
  public int b;
  
  public QZoneCountUserInfo() {}
  
  public QZoneCountUserInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_Byte = paramParcel.readByte();
    this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush = ((PassiveFeedsPush)JceUtils.a(PassiveFeedsPush.class, paramParcel.createByteArray()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof QZoneCountUserInfo))
    {
      paramObject = (QZoneCountUserInfo)paramObject;
      if ((this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.jdField_a_of_type_Byte == paramObject.jdField_a_of_type_Byte) || (this.b == paramObject.b)) {
        bool = false;
      }
      do
      {
        do
        {
          return bool;
          if ((this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush != null) && (paramObject.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush != null)) {
            break;
          }
        } while (this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush == paramObject.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush);
        return false;
        if ((this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush.stBubbleSkin != null) && (paramObject.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush.stBubbleSkin != null)) {
          break;
        }
      } while (this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush.stBubbleSkin == paramObject.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush.stBubbleSkin);
      return false;
      return TextUtils.equals(this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush.stBubbleSkin.strBubbleZipUrl, paramObject.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush.stBubbleSkin.strBubbleZipUrl);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeByte(this.jdField_a_of_type_Byte);
    if (this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush == null) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = JceUtils.a(this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush))
    {
      paramParcel.writeByteArray(arrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.UndealCount.QZoneCountUserInfo
 * JD-Core Version:    0.7.0.1
 */