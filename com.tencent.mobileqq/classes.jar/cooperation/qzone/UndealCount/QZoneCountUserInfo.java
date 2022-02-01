package cooperation.qzone.UndealCount;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
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
  public ArrayList<feed_info> vec_feedInfos;
  
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
  
  @NonNull
  private ArrayList<feed_info> getFeed_infos(Parcel paramParcel)
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
      if ((this.uin != paramObject.uin) || (this.iYellowType != paramObject.iYellowType) || (this.isAnnualVip == paramObject.isAnnualVip) || (this.iYellowLevel == paramObject.iYellowLevel)) {
        bool = false;
      }
      do
      {
        do
        {
          return bool;
          if ((this.pushData != null) && (paramObject.pushData != null)) {
            break;
          }
        } while (this.pushData == paramObject.pushData);
        return false;
        if ((this.pushData.stBubbleSkin != null) && (paramObject.pushData.stBubbleSkin != null)) {
          break;
        }
      } while (this.pushData.stBubbleSkin == paramObject.pushData.stBubbleSkin);
      return false;
      return TextUtils.equals(this.pushData.stBubbleSkin.strBubbleZipUrl, paramObject.pushData.stBubbleSkin.strBubbleZipUrl);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    paramParcel.writeLong(this.uin);
    paramParcel.writeInt(this.iYellowType);
    paramParcel.writeInt(this.iYellowLevel);
    paramParcel.writeByte(this.isAnnualVip);
    if (this.pushData == null)
    {
      localObject1 = null;
      paramParcel.writeByteArray((byte[])localObject1);
      if (this.vec_feedInfos != null) {
        break label84;
      }
    }
    label84:
    for (Object localObject1 = localObject2;; localObject1 = JceUtils.encodeWup(this.vec_feedInfos))
    {
      paramParcel.writeByteArray((byte[])localObject1);
      paramParcel.writeString(this.nickName);
      return;
      localObject1 = JceUtils.encodeWup(this.pushData);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.UndealCount.QZoneCountUserInfo
 * JD-Core Version:    0.7.0.1
 */