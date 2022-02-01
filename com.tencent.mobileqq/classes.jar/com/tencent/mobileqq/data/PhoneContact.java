package com.tencent.mobileqq.data;

import com.tencent.mobileqq.friend.status.OnlineStatusIconHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class PhoneContact
  extends Entity
  implements Serializable, Cloneable
{
  private static final String TAG = "PhoneContact";
  public int ability;
  public long abilityBits = 0L;
  public int age;
  public long bindingDate;
  public int contactID;
  public byte detalStatusFlag;
  public int eNetworkType;
  @Deprecated
  public String faceUrl;
  public boolean hasSendAddReq = false;
  public long highLightTimeStamp;
  public int iTermType;
  public boolean isHiden;
  public boolean isNewRecommend;
  public int isRecommend;
  public boolean isUploaded = false;
  public String label;
  @Deprecated
  public long lastScanTime;
  public String md5;
  @Deprecated
  public String mobileCode;
  @unique
  public String mobileNo;
  public String name;
  @Deprecated
  public String nationCode;
  public int netTypeIconId = 0;
  public int netTypeIconIdIphoneOrWphoneNoWifi = 0;
  public String nickName;
  @Deprecated
  public long originBinder;
  public String pinyinAll;
  @notColumn
  public String pinyinFirst;
  public String pinyinInitial;
  public String remark;
  public byte[] richBuffer;
  public long richTime;
  public int samFriend;
  public int sex;
  public int sortWeight = 0;
  public String strTermDesc = "";
  public int type;
  public String uin;
  public String unifiedCode;
  
  private static int getNetTypeByIconType(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 != 1)
    {
      i = 2;
      if (paramInt1 != 2)
      {
        i = 3;
        if (paramInt1 != 3)
        {
          i = 4;
          if (paramInt1 != 4)
          {
            if (paramInt1 != 12) {
              return paramInt2;
            }
            return 5;
          }
        }
      }
    }
    return i;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhoneContact clone failed.");
        localStringBuilder.append(localCloneNotSupportedException.toString());
        QLog.d("PhoneContact", 2, localStringBuilder.toString());
      }
    }
    return this;
  }
  
  public int getNetWorkType()
  {
    int i;
    if (this.detalStatusFlag == -55)
    {
      i = this.iTermType;
      if (((i == 67586) || (i == 66566) || (i == 72194) || (i == 65804) || (i == 72706)) && ((this.abilityBits & 1L) == 0L)) {
        return getNetTypeByIconType(this.netTypeIconIdIphoneOrWphoneNoWifi, this.eNetworkType);
      }
    }
    if ((this.detalStatusFlag != -55) || (this.iTermType != 68361) || ((1L & this.abilityBits) != 0L))
    {
      i = this.iTermType;
      if (i != 68104)
      {
        if (i == 65805) {
          return 0;
        }
        OnlineStatusIconHelper localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
        if (this.eNetworkType == 0)
        {
          i = this.iTermType;
          if ((i != 69378) && (i != 73474))
          {
            if (i == 73730) {
              return 0;
            }
            if (1 != localOnlineStatusIconHelper.a(i, 1)) {
              return 2;
            }
          }
          else
          {
            return 0;
          }
        }
        if (1 != localOnlineStatusIconHelper.a(this.iTermType, 1)) {
          return getNetTypeByIconType(this.netTypeIconId, this.eNetworkType);
        }
        return this.eNetworkType;
      }
    }
    return 0;
  }
  
  public void setRichBuffer(byte[] paramArrayOfByte, long paramLong)
  {
    this.richBuffer = paramArrayOfByte;
    this.richTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.PhoneContact
 * JD-Core Version:    0.7.0.1
 */