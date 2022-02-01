package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;

final class MiniAppConfig$1
  implements Parcelable.Creator<MiniAppConfig>
{
  public MiniAppConfig createFromParcel(Parcel paramParcel)
  {
    for (;;)
    {
      try
      {
        Object localObject = (MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader());
        LaunchParam localLaunchParam = (LaunchParam)paramParcel.readParcelable(LaunchParam.class.getClassLoader());
        BaseLibInfo localBaseLibInfo = (BaseLibInfo)paramParcel.readParcelable(BaseLibInfo.class.getClassLoader());
        int i = paramParcel.readInt();
        localObject = new MiniAppConfig((MiniAppInfo)localObject, localBaseLibInfo, null);
        try
        {
          ((MiniAppConfig)localObject).launchParam = localLaunchParam;
          ((MiniAppConfig)localObject).forceReroad = i;
          i = paramParcel.readInt();
          boolean bool2 = false;
          if (i != 1) {
            break label174;
          }
          bool1 = true;
          ((MiniAppConfig)localObject).isFromShowInfo = bool1;
          ((MiniAppConfig)localObject).link = paramParcel.readString();
          ((MiniAppConfig)localObject).linkType = paramParcel.readInt();
          ((MiniAppConfig)localObject).entryPath = paramParcel.readString();
          bool1 = bool2;
          if (paramParcel.readInt() == 1) {
            bool1 = true;
          }
          ((MiniAppConfig)localObject).isSdkMode = bool1;
          return localObject;
        }
        catch (Throwable localThrowable2)
        {
          paramParcel = (Parcel)localObject;
          localObject = localThrowable2;
        }
        QDLog.e("miniapp", "MiniAppConfig createFromParcel exception!", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        paramParcel = null;
      }
      return paramParcel;
      label174:
      boolean bool1 = false;
    }
  }
  
  public MiniAppConfig[] newArray(int paramInt)
  {
    return new MiniAppConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.MiniAppConfig.1
 * JD-Core Version:    0.7.0.1
 */