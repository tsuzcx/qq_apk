package com.tencent.mobileqq.pluginsdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PluginBaseInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<PluginBaseInfo> CREATOR = new PluginBaseInfo.1();
  public static final int INSTALL_TYPE_DEAMON = 0;
  public static final int INSTALL_TYPE_NOTICE = 1;
  public static final int STATE_CANCEL = -1;
  public static final int STATE_DOWNLOADED = 2;
  public static final int STATE_DOWNLOADING = 1;
  public static final int STATE_ERROR = -2;
  public static final int STATE_INSTALLED = 4;
  public static final int STATE_INSTALLING = 3;
  public static final int STATE_NODOWNLOAD = 0;
  public static final int STATE_WAITING_INST_OR_DOWN = 5;
  public static final int SUB_TYPE_DYNAMIC_FEATURE_PLUGIN = 2;
  public static final int SUB_TYPE_QQ_PLUGIN = 0;
  public static final int SUB_TYPE_SHADOW_PLUGIN = 1;
  public static final int TYPE_APP = 2;
  public static final int TYPE_COUNT = 3;
  public static final int TYPE_PART = 0;
  public static final int TYPE_PLUGIN = 1;
  public static final int UPDATE_TYPE_FORCE = 1;
  public static final int UPDATE_TYPE_OPTIONAL = 0;
  public long costApk;
  public long costDex2Oat;
  public long costDownload;
  public long costLib;
  public long downloadDuration = 0L;
  public int installCode = 0;
  public long mCurVersion = 0L;
  public float mDownloadProgress;
  public String mFingerPrint = "";
  public int mForceUrl;
  public String mID = "";
  public int mInstallType = 0;
  public String mInstalledPath;
  public long mLength = 0L;
  public String mMD5 = "";
  public String mName = "";
  public String mPackageName = "";
  public String[] mProcesses = new String[0];
  public int mState;
  public int mSubType;
  public int mType;
  public String mURL = "";
  public int mUpdateType = 1;
  public String mVersion = "";
  public int startDownloadNetType;
  
  public PluginBaseInfo() {}
  
  protected PluginBaseInfo(Parcel paramParcel)
  {
    this.mProcesses = paramParcel.createStringArray();
    this.mID = paramParcel.readString();
    this.mName = paramParcel.readString();
    this.mVersion = paramParcel.readString();
    this.mURL = paramParcel.readString();
    this.mMD5 = paramParcel.readString();
    this.mLength = paramParcel.readLong();
    this.mType = paramParcel.readInt();
    this.mSubType = paramParcel.readInt();
    this.mCurVersion = paramParcel.readLong();
    this.mPackageName = paramParcel.readString();
    this.mInstalledPath = paramParcel.readString();
    this.mUpdateType = paramParcel.readInt();
    this.mInstallType = paramParcel.readInt();
    this.mState = paramParcel.readInt();
    this.mDownloadProgress = paramParcel.readFloat();
    this.mForceUrl = paramParcel.readInt();
    this.mFingerPrint = paramParcel.readString();
    this.startDownloadNetType = paramParcel.readInt();
    this.installCode = paramParcel.readInt();
    this.downloadDuration = paramParcel.readLong();
    this.costDex2Oat = paramParcel.readLong();
    this.costApk = paramParcel.readLong();
    this.costLib = paramParcel.readLong();
    this.costDownload = paramParcel.readLong();
  }
  
  public PluginBaseInfo clone()
  {
    try
    {
      PluginBaseInfo localPluginBaseInfo = (PluginBaseInfo)super.clone();
      return localPluginBaseInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.mID);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mPackageName);
    localStringBuilder.append(", ");
    localStringBuilder.append(super.hashCode());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(this.mProcesses);
    paramParcel.writeString(this.mID);
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mVersion);
    paramParcel.writeString(this.mURL);
    paramParcel.writeString(this.mMD5);
    paramParcel.writeLong(this.mLength);
    paramParcel.writeInt(this.mType);
    paramParcel.writeInt(this.mSubType);
    paramParcel.writeLong(this.mCurVersion);
    paramParcel.writeString(this.mPackageName);
    paramParcel.writeString(this.mInstalledPath);
    paramParcel.writeInt(this.mUpdateType);
    paramParcel.writeInt(this.mInstallType);
    paramParcel.writeInt(this.mState);
    paramParcel.writeFloat(this.mDownloadProgress);
    paramParcel.writeInt(this.mForceUrl);
    paramParcel.writeString(this.mFingerPrint);
    paramParcel.writeInt(this.startDownloadNetType);
    paramParcel.writeInt(this.installCode);
    paramParcel.writeLong(this.downloadDuration);
    paramParcel.writeLong(this.costDex2Oat);
    paramParcel.writeLong(this.costApk);
    paramParcel.writeLong(this.costLib);
    paramParcel.writeLong(this.costDownload);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBaseInfo
 * JD-Core Version:    0.7.0.1
 */