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
    QLog.i("InstalledEngine", 1, "[MiniEng] delete engine " + this + ", pName=" + BaseApplicationImpl.getApplication().getQQProcessName());
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
    return "InstalledEngine{engineDir=" + this.engineDir + ", engineName=" + this.engineName + ", engineVersion=" + this.engineVersion + ", engineType=" + this.engineType + ", isVerify=" + this.isVerify + ", isPersist=" + this.isPersist + ", loadStatus=" + this.loadStatus + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.engineName);
    paramParcel.writeString(this.engineDir);
    paramParcel.writeParcelable(this.engineVersion, 0);
    paramParcel.writeInt(this.engineType);
    if (this.isVerify)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.isPersist) {
        break label79;
      }
    }
    label79:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.loadStatus);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.InstalledEngine
 * JD-Core Version:    0.7.0.1
 */