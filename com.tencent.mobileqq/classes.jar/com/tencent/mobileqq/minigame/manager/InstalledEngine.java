package com.tencent.mobileqq.minigame.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class InstalledEngine
  implements Parcelable, Comparable<InstalledEngine>
{
  public static final Parcelable.Creator<InstalledEngine> CREATOR = new InstalledEngine.1();
  public static final String LOG_TAG = "InstalledEngine";
  public static final int STATUS_DEFAULT = 1;
  public static final int STATUS_LOAD_FAILED = 2;
  public static final int STATUS_LOAD_SUCC = 3;
  public String engineDir;
  public String engineName;
  public int engineType;
  public EngineVersion engineVersion;
  public boolean isPersist;
  public boolean isVerify;
  public volatile int loadStatus = 1;
  
  public int compareTo(@NonNull InstalledEngine paramInstalledEngine)
  {
    return this.engineVersion.compareTo(paramInstalledEngine.engineVersion);
  }
  
  @Deprecated
  public void deleteFiles()
  {
    if (!TextUtils.isEmpty(this.engineDir))
    {
      FileUtils.delete(this.engineDir, false);
      EngineInstaller.getSp().edit().remove(this.engineDir).apply();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] delete engine ");
    localStringBuilder.append(this);
    localStringBuilder.append(", pName=");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getQQProcessName());
    QLog.i("InstalledEngine", 1, localStringBuilder.toString());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isLoadSuccess()
  {
    return this.loadStatus == 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InstalledEngine{engineDir=");
    localStringBuilder.append(this.engineDir);
    localStringBuilder.append(", engineName=");
    localStringBuilder.append(this.engineName);
    localStringBuilder.append(", engineVersion=");
    localStringBuilder.append(this.engineVersion);
    localStringBuilder.append(", engineType=");
    localStringBuilder.append(this.engineType);
    localStringBuilder.append(", isVerify=");
    localStringBuilder.append(this.isVerify);
    localStringBuilder.append(", isPersist=");
    localStringBuilder.append(this.isPersist);
    localStringBuilder.append(", loadStatus=");
    localStringBuilder.append(this.loadStatus);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.engineName);
    paramParcel.writeString(this.engineDir);
    paramParcel.writeParcelable(this.engineVersion, 0);
    paramParcel.writeInt(this.engineType);
    paramParcel.writeByte((byte)this.isVerify);
    paramParcel.writeByte((byte)this.isPersist);
    paramParcel.writeInt(this.loadStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.InstalledEngine
 * JD-Core Version:    0.7.0.1
 */