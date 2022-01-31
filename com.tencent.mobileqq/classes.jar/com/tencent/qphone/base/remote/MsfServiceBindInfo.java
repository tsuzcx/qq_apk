package com.tencent.qphone.base.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MsfServiceBindInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new MsfServiceBindInfo.1();
  private int appid;
  private String bootBoradcastName;
  private IMsfServiceCallbacker msfServiceCallbacker;
  private String processName;
  
  public MsfServiceBindInfo(int paramInt, String paramString1, String paramString2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    this.appid = paramInt;
    this.processName = paramString1;
    this.bootBoradcastName = paramString2;
    this.msfServiceCallbacker = paramIMsfServiceCallbacker;
  }
  
  public MsfServiceBindInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  private void readFromParcel(Parcel paramParcel)
  {
    this.appid = paramParcel.readInt();
    this.processName = paramParcel.readString();
    this.bootBoradcastName = paramParcel.readString();
    this.msfServiceCallbacker = IMsfServiceCallbacker.Stub.asInterface(paramParcel.readStrongBinder());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAppid()
  {
    return this.appid;
  }
  
  public String getBootBoradcastName()
  {
    return this.bootBoradcastName;
  }
  
  public IMsfServiceCallbacker getMsfServiceCallbacker()
  {
    return this.msfServiceCallbacker;
  }
  
  public String getProcessName()
  {
    return this.processName;
  }
  
  public void setAppid(int paramInt)
  {
    this.appid = paramInt;
  }
  
  public void setBootBoradcastName(String paramString)
  {
    this.bootBoradcastName = paramString;
  }
  
  public void setMsfSericeCallbacker(IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    this.msfServiceCallbacker = paramIMsfServiceCallbacker;
  }
  
  public void setProcessName(String paramString)
  {
    this.processName = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.appid);
    paramParcel.writeString(this.processName);
    paramParcel.writeString(this.bootBoradcastName);
    paramParcel.writeStrongInterface(this.msfServiceCallbacker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.MsfServiceBindInfo
 * JD-Core Version:    0.7.0.1
 */