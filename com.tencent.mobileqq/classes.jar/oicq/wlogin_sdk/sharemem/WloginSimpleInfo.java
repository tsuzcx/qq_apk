package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class WloginSimpleInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<WloginSimpleInfo> CREATOR = new WloginSimpleInfo.1();
  private static final long serialVersionUID = 1L;
  public byte[] _age;
  public byte[] _face;
  public byte[] _gender;
  public byte[] _img_format;
  public byte[] _img_type;
  public byte[] _img_url;
  public byte[] _nick;
  public long _uin;
  public byte[] mainDisplayName;
  
  public WloginSimpleInfo()
  {
    this._uin = 0L;
    this._face = new byte[0];
    this._age = new byte[0];
    this._gender = new byte[0];
    this._nick = new byte[0];
    this._img_type = new byte[0];
    this._img_format = new byte[0];
    this._img_url = new byte[0];
    this.mainDisplayName = new byte[0];
  }
  
  public WloginSimpleInfo(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7)
  {
    this._uin = paramLong;
    if (paramArrayOfByte1 != null) {
      this._face = ((byte[])paramArrayOfByte1.clone());
    } else {
      this._face = new byte[0];
    }
    if (paramArrayOfByte2 != null) {
      this._age = ((byte[])paramArrayOfByte2.clone());
    } else {
      this._age = new byte[0];
    }
    if (paramArrayOfByte3 != null) {
      this._gender = ((byte[])paramArrayOfByte3.clone());
    } else {
      this._gender = new byte[0];
    }
    if (paramArrayOfByte4 != null) {
      this._nick = ((byte[])paramArrayOfByte4.clone());
    } else {
      this._nick = new byte[0];
    }
    if (paramArrayOfByte5 != null) {
      this._img_type = ((byte[])paramArrayOfByte5.clone());
    } else {
      this._img_type = new byte[0];
    }
    if (paramArrayOfByte6 != null) {
      this._img_format = ((byte[])paramArrayOfByte6.clone());
    } else {
      this._img_format = new byte[0];
    }
    if (paramArrayOfByte7 != null)
    {
      this._img_url = ((byte[])paramArrayOfByte7.clone());
      return;
    }
    this._img_url = new byte[0];
  }
  
  public WloginSimpleInfo(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[][] paramArrayOfByte)
  {
    this._uin = paramLong;
    if (paramArrayOfByte1 != null) {
      this._face = ((byte[])paramArrayOfByte1.clone());
    } else {
      this._face = new byte[0];
    }
    if (paramArrayOfByte2 != null) {
      this._age = ((byte[])paramArrayOfByte2.clone());
    } else {
      this._age = new byte[0];
    }
    if (paramArrayOfByte3 != null) {
      this._gender = ((byte[])paramArrayOfByte3.clone());
    } else {
      this._gender = new byte[0];
    }
    if (paramArrayOfByte4 != null) {
      this._nick = ((byte[])paramArrayOfByte4.clone());
    } else {
      this._nick = new byte[0];
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 3))
    {
      this._img_type = ((byte[])paramArrayOfByte[0].clone());
      this._img_format = ((byte[])paramArrayOfByte[1].clone());
      this._img_url = ((byte[])paramArrayOfByte[2].clone());
      return;
    }
    this._img_type = new byte[0];
    this._img_format = new byte[0];
    this._img_url = new byte[0];
  }
  
  private WloginSimpleInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public WloginSimpleInfo get_clone()
  {
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    localWloginSimpleInfo._uin = this._uin;
    byte[] arrayOfByte = this._face;
    if (arrayOfByte != null) {
      localWloginSimpleInfo._face = ((byte[])arrayOfByte.clone());
    }
    arrayOfByte = this._age;
    if (arrayOfByte != null) {
      localWloginSimpleInfo._age = ((byte[])arrayOfByte.clone());
    }
    arrayOfByte = this._gender;
    if (arrayOfByte != null) {
      localWloginSimpleInfo._gender = ((byte[])arrayOfByte.clone());
    }
    arrayOfByte = this._nick;
    if (arrayOfByte != null) {
      localWloginSimpleInfo._nick = ((byte[])arrayOfByte.clone());
    }
    arrayOfByte = this._img_type;
    if (arrayOfByte != null) {
      localWloginSimpleInfo._img_type = ((byte[])arrayOfByte.clone());
    }
    arrayOfByte = this._img_format;
    if (arrayOfByte != null) {
      localWloginSimpleInfo._img_format = ((byte[])arrayOfByte.clone());
    }
    arrayOfByte = this._img_url;
    if (arrayOfByte != null) {
      localWloginSimpleInfo._img_url = ((byte[])arrayOfByte.clone());
    }
    arrayOfByte = this.mainDisplayName;
    if (arrayOfByte != null) {
      localWloginSimpleInfo.mainDisplayName = ((byte[])arrayOfByte.clone());
    }
    return localWloginSimpleInfo;
  }
  
  public void get_clone(WloginSimpleInfo paramWloginSimpleInfo)
  {
    this._uin = paramWloginSimpleInfo._uin;
    byte[] arrayOfByte = paramWloginSimpleInfo._face;
    if (arrayOfByte != null) {
      this._face = ((byte[])arrayOfByte.clone());
    } else {
      this._face = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._age;
    if (arrayOfByte != null) {
      this._age = ((byte[])arrayOfByte.clone());
    } else {
      this._age = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._gender;
    if (arrayOfByte != null) {
      this._gender = ((byte[])arrayOfByte.clone());
    } else {
      this._gender = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._nick;
    if (arrayOfByte != null) {
      this._nick = ((byte[])arrayOfByte.clone());
    } else {
      this._nick = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._img_type;
    if (arrayOfByte != null) {
      this._img_type = ((byte[])arrayOfByte.clone());
    } else {
      this._img_type = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._img_format;
    if (arrayOfByte != null) {
      this._img_format = ((byte[])arrayOfByte.clone());
    } else {
      this._img_format = new byte[0];
    }
    paramWloginSimpleInfo = paramWloginSimpleInfo._img_url;
    if (paramWloginSimpleInfo != null)
    {
      this._img_url = ((byte[])paramWloginSimpleInfo.clone());
      return;
    }
    this._img_url = new byte[0];
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this._uin = paramParcel.readLong();
    this._face = paramParcel.createByteArray();
    this._age = paramParcel.createByteArray();
    this._gender = paramParcel.createByteArray();
    this._nick = paramParcel.createByteArray();
    this._img_type = paramParcel.createByteArray();
    this._img_format = paramParcel.createByteArray();
    this._img_url = paramParcel.createByteArray();
    this.mainDisplayName = paramParcel.createByteArray();
  }
  
  public void setAge(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      this._age = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public void setFace(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      this._face = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public void setGender(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      this._gender = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public void setImgFormat(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      this._img_format = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public void setImgType(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      this._img_type = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public void setImgUrl(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      this._img_url = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public void setMainDisplayName(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      this.mainDisplayName = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public void setNick(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      this._nick = ((byte[])paramArrayOfByte.clone());
    }
  }
  
  public void setReserveUinInfo(byte[][] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 3) && (paramArrayOfByte[0].length > 0) && (paramArrayOfByte[1].length > 0) && (paramArrayOfByte[2].length > 0))
    {
      this._img_type = ((byte[])paramArrayOfByte[0].clone());
      this._img_format = ((byte[])paramArrayOfByte[1].clone());
      this._img_url = ((byte[])paramArrayOfByte[2].clone());
    }
  }
  
  public void setUin(long paramLong)
  {
    this._uin = paramLong;
  }
  
  public void set_info(WloginSimpleInfo paramWloginSimpleInfo)
  {
    this._uin = paramWloginSimpleInfo._uin;
    byte[] arrayOfByte = paramWloginSimpleInfo._face;
    if (arrayOfByte != null) {
      this._face = ((byte[])arrayOfByte.clone());
    } else {
      this._face = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._age;
    if (arrayOfByte != null) {
      this._age = ((byte[])arrayOfByte.clone());
    } else {
      this._age = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._gender;
    if (arrayOfByte != null) {
      this._gender = ((byte[])arrayOfByte.clone());
    } else {
      this._gender = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._nick;
    if (arrayOfByte != null) {
      this._nick = ((byte[])arrayOfByte.clone());
    } else {
      this._nick = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._img_type;
    if (arrayOfByte != null) {
      this._img_type = ((byte[])arrayOfByte.clone());
    } else {
      this._img_type = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._img_format;
    if (arrayOfByte != null) {
      this._img_format = ((byte[])arrayOfByte.clone());
    } else {
      this._img_format = new byte[0];
    }
    arrayOfByte = paramWloginSimpleInfo._img_url;
    if (arrayOfByte != null) {
      this._img_url = ((byte[])arrayOfByte.clone());
    } else {
      this._img_url = new byte[0];
    }
    paramWloginSimpleInfo = paramWloginSimpleInfo.mainDisplayName;
    if (paramWloginSimpleInfo != null)
    {
      this.mainDisplayName = ((byte[])paramWloginSimpleInfo.clone());
      return;
    }
    this.mainDisplayName = new byte[0];
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this._uin);
    paramParcel.writeByteArray(this._face);
    paramParcel.writeByteArray(this._age);
    paramParcel.writeByteArray(this._gender);
    paramParcel.writeByteArray(this._nick);
    paramParcel.writeByteArray(this._img_type);
    paramParcel.writeByteArray(this._img_format);
    paramParcel.writeByteArray(this._img_url);
    paramParcel.writeByteArray(this.mainDisplayName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginSimpleInfo
 * JD-Core Version:    0.7.0.1
 */