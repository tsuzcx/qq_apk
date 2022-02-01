package com.tencent.qqmini.sdk.launcher.model;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.MiniSDK;

public class ShareData
  implements Parcelable
{
  public static final Parcelable.Creator<ShareData> CREATOR = new ShareData.1();
  protected static final String TAG = "ShareData";
  public boolean isLocalPic;
  protected MiniAppInfo miniAppInfo;
  public boolean needShareCallback;
  public boolean shareInMiniProcess;
  public int shareItemId;
  public String sharePicPath;
  public int shareSource;
  public int shareTarget;
  public String summary;
  public String targetUrl;
  public String title;
  
  protected ShareData() {}
  
  public ShareData(Parcel paramParcel)
  {
    this.shareSource = paramParcel.readInt();
    this.shareTarget = paramParcel.readInt();
    this.shareItemId = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.summary = paramParcel.readString();
    this.sharePicPath = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.isLocalPic = bool1;
      this.targetUrl = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label129;
      }
      bool1 = true;
      label87:
      this.needShareCallback = bool1;
      if (paramParcel.readInt() != 1) {
        break label134;
      }
    }
    label129:
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.shareInMiniProcess = bool1;
      this.miniAppInfo = ((MiniAppInfo)paramParcel.readParcelable(MiniAppInfo.class.getClassLoader()));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label87;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMiniAppIconUrl()
  {
    return this.miniAppInfo.iconUrl;
  }
  
  public String getMiniAppId()
  {
    return this.miniAppInfo.appId;
  }
  
  public String getMiniAppName()
  {
    return this.miniAppInfo.name;
  }
  
  public void notifyShareResult(Context paramContext, int paramInt)
  {
    notifyShareResult(paramContext, paramInt, false);
  }
  
  public void notifyShareResult(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if ((this.needShareCallback) || (paramBoolean))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_share_result", paramInt);
      MiniSDK.notifyShareResult(paramContext, this.miniAppInfo, localBundle);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.shareSource);
    paramParcel.writeInt(this.shareTarget);
    paramParcel.writeInt(this.shareItemId);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.sharePicPath);
    if (this.isLocalPic)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.targetUrl);
      if (!this.needShareCallback) {
        break label115;
      }
      paramInt = 1;
      label81:
      paramParcel.writeInt(paramInt);
      if (!this.shareInMiniProcess) {
        break label120;
      }
    }
    label115:
    label120:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(this.miniAppInfo, 0);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ShareData
 * JD-Core Version:    0.7.0.1
 */