package com.tencent.mobileqq.mini.sdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import java.util.ArrayList;

final class LaunchParam$1
  implements Parcelable.Creator<LaunchParam>
{
  public LaunchParam createFromParcel(Parcel paramParcel)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    for (;;)
    {
      try
      {
        localLaunchParam.scene = paramParcel.readInt();
        localLaunchParam.miniAppId = paramParcel.readString();
        localLaunchParam.extraKey = paramParcel.readString();
        localLaunchParam.entryPath = paramParcel.readString();
        localLaunchParam.navigateExtData = paramParcel.readString();
        localLaunchParam.fromMiniAppId = paramParcel.readString();
        localLaunchParam.launchClickTimeMillis = paramParcel.readLong();
        localLaunchParam.tempState = paramParcel.readInt();
        localLaunchParam.timestamp = paramParcel.readLong();
        localLaunchParam.shareTicket = paramParcel.readString();
        localLaunchParam.envVersion = paramParcel.readString();
        localLaunchParam.reportData = paramParcel.readString();
        localLaunchParam.extendData = paramParcel.readString();
        localLaunchParam.entryModel = ((EntryModel)paramParcel.readParcelable(EntryModel.class.getClassLoader()));
        localLaunchParam.fromBackToMiniApp = paramParcel.readInt();
        localLaunchParam.fromEnvVersion = paramParcel.readString();
        localLaunchParam.fromMiniAppInfo = ((MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader()));
        localLaunchParam.privateExtraData = paramParcel.readString();
        localLaunchParam.fileMaterialInfoList = new ArrayList();
        paramParcel.readList(localLaunchParam.fileMaterialInfoList, MiniAppInfo.class.getClassLoader());
        localLaunchParam.forceReload = paramParcel.readInt();
        if (paramParcel.readInt() != 0)
        {
          bool = true;
          localLaunchParam.skipHotReload = bool;
          return localLaunchParam;
        }
      }
      catch (Throwable paramParcel)
      {
        QDLog.e("miniapp", "LaunchParam createFromParcel exception!", paramParcel);
        return localLaunchParam;
      }
      boolean bool = false;
    }
  }
  
  public LaunchParam[] newArray(int paramInt)
  {
    return new LaunchParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.LaunchParam.1
 * JD-Core Version:    0.7.0.1
 */