package cooperation.qzone.UndealCount;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bhaw;
import bhnw;
import com.qq.taf.jce.JceInputStream;
import java.util.ArrayList;

public class QZoneCountUserInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QZoneCountUserInfo> CREATOR = new bhaw();
  public byte a;
  public int a;
  public long a;
  public PassiveFeedsPush a;
  public String a;
  public ArrayList<feed_info> a;
  public int b;
  
  public QZoneCountUserInfo() {}
  
  public QZoneCountUserInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_Byte = paramParcel.readByte();
    this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush = ((PassiveFeedsPush)bhnw.a(PassiveFeedsPush.class, paramParcel.createByteArray()));
    this.jdField_a_of_type_JavaUtilArrayList = a(paramParcel);
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  @NonNull
  private ArrayList<feed_info> a(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new feed_info());
    try
    {
      paramParcel = paramParcel.createByteArray();
      if ((paramParcel != null) && (paramParcel.length != 0))
      {
        paramParcel = new JceInputStream(paramParcel);
        paramParcel.setServerEncoding("utf8");
        paramParcel = (ArrayList)paramParcel.read(localArrayList, 0, false);
        return paramParcel;
      }
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
      return null;
    }
    return null;
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
    Object localObject2 = null;
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeByte(this.jdField_a_of_type_Byte);
    if (this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush == null)
    {
      localObject1 = null;
      paramParcel.writeByteArray((byte[])localObject1);
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label84;
      }
    }
    label84:
    for (Object localObject1 = localObject2;; localObject1 = bhnw.a(this.jdField_a_of_type_JavaUtilArrayList))
    {
      paramParcel.writeByteArray((byte[])localObject1);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      return;
      localObject1 = bhnw.a(this.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.UndealCount.QZoneCountUserInfo
 * JD-Core Version:    0.7.0.1
 */