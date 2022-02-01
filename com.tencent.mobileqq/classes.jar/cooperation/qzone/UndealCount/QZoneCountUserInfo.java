package cooperation.qzone.UndealCount;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.util.JceUtils;
import java.util.ArrayList;

public class QZoneCountUserInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QZoneCountUserInfo> CREATOR = new QZoneCountUserInfo.1();
  public int iYellowLevel;
  public int iYellowType;
  public byte isAnnualVip;
  public String nickName;
  public PassiveFeedsPush pushData;
  public long uin;
  public ArrayList<feed_info> vec_feedInfos = null;
  
  public QZoneCountUserInfo() {}
  
  protected QZoneCountUserInfo(Parcel paramParcel)
  {
    this.uin = paramParcel.readLong();
    this.iYellowType = paramParcel.readInt();
    this.iYellowLevel = paramParcel.readInt();
    this.isAnnualVip = paramParcel.readByte();
    this.pushData = ((PassiveFeedsPush)JceUtils.decodeWup(PassiveFeedsPush.class, paramParcel.createByteArray()));
    this.vec_feedInfos = getFeed_infos(paramParcel);
    this.nickName = paramParcel.readString();
  }
  
  private ArrayList<feed_info> getFeed_infos(Parcel paramParcel)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new feed_info());
    try
    {
      paramParcel = paramParcel.createByteArray();
      if (paramParcel != null)
      {
        if (paramParcel.length == 0) {
          return null;
        }
        paramParcel = new JceInputStream(paramParcel);
        paramParcel.setServerEncoding("utf8");
        paramParcel = (ArrayList)paramParcel.read(localArrayList, 0, false);
        return paramParcel;
      }
      return null;
    }
    catch (Exception paramParcel)
    {
      paramParcel.printStackTrace();
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool4 = paramObject instanceof QZoneCountUserInfo;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (bool4)
    {
      paramObject = (QZoneCountUserInfo)paramObject;
      bool1 = bool3;
      if (this.uin == paramObject.uin)
      {
        bool1 = bool3;
        if (this.iYellowType == paramObject.iYellowType)
        {
          bool1 = bool3;
          if (this.isAnnualVip != paramObject.isAnnualVip)
          {
            if (this.iYellowLevel == paramObject.iYellowLevel) {
              return false;
            }
            PassiveFeedsPush localPassiveFeedsPush = this.pushData;
            if ((localPassiveFeedsPush != null) && (paramObject.pushData != null))
            {
              if ((localPassiveFeedsPush.stBubbleSkin != null) && (paramObject.pushData.stBubbleSkin != null)) {
                return TextUtils.equals(this.pushData.stBubbleSkin.strBubbleZipUrl, paramObject.pushData.stBubbleSkin.strBubbleZipUrl);
              }
              bool1 = bool2;
              if (this.pushData.stBubbleSkin == paramObject.pushData.stBubbleSkin) {
                bool1 = true;
              }
              return bool1;
            }
            bool1 = bool3;
            if (this.pushData == paramObject.pushData) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uin);
    paramParcel.writeInt(this.iYellowType);
    paramParcel.writeInt(this.iYellowLevel);
    paramParcel.writeByte(this.isAnnualVip);
    Object localObject1 = this.pushData;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = JceUtils.encodeWup((JceStruct)localObject1);
    }
    paramParcel.writeByteArray((byte[])localObject1);
    localObject1 = this.vec_feedInfos;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = JceUtils.encodeWup((ArrayList)localObject1);
    }
    paramParcel.writeByteArray((byte[])localObject1);
    paramParcel.writeString(this.nickName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.UndealCount.QZoneCountUserInfo
 * JD-Core Version:    0.7.0.1
 */