package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE.StAppMode;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBBoolField;

public class AppMode
  implements Parcelable
{
  public static final Parcelable.Creator<AppMode> CREATOR = new AppMode.1();
  public boolean authoritySilent;
  public boolean closeTopRightCapsule;
  public boolean disableAddToMyApp;
  public boolean disableAddToMyFavor;
  public boolean disableShareToAIO;
  public boolean disableShareToQZone;
  public boolean disableShareToWeChat;
  public boolean hideAppSearch;
  public boolean interLoading;
  public boolean interMode;
  public boolean isAppStore;
  public boolean isLimitedAccess;
  public boolean isPayForFriend;
  public boolean isWangKa;
  public boolean keepOffPullList;
  public boolean openNativeApi;
  public boolean reloadWithFirstPageChange;
  public boolean unlimitedApiRight;
  public boolean useAppInfoWhenNavigate;
  
  public static final int booleanToInt(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  public static AppMode from(INTERFACE.StAppMode paramStAppMode)
  {
    AppMode localAppMode = new AppMode();
    if (paramStAppMode != null)
    {
      localAppMode.interMode = paramStAppMode.interMode.get();
      localAppMode.authoritySilent = paramStAppMode.authoritySilent.get();
      localAppMode.keepOffPullList = paramStAppMode.keepOffPullList.get();
      localAppMode.closeTopRightCapsule = paramStAppMode.closeTopRightCapsule.get();
      localAppMode.openNativeApi = paramStAppMode.openNativeApi.get();
      localAppMode.hideAppSearch = paramStAppMode.hideAppSearch.get();
      localAppMode.isAppStore = paramStAppMode.isAppStore.get();
      localAppMode.isWangKa = paramStAppMode.isWangKa.get();
      localAppMode.interLoading = paramStAppMode.interLoading.get();
      localAppMode.isLimitedAccess = paramStAppMode.isLimitedAccess.get();
      localAppMode.isPayForFriend = paramStAppMode.isPayForFriend.get();
      localAppMode.useAppInfoWhenNavigate = paramStAppMode.useAppInfoWhenNavigate.get();
      localAppMode.disableAddToMyApp = paramStAppMode.disableAddToMyApp.get();
      localAppMode.disableAddToMyFavor = paramStAppMode.disableAddToMyFavor.get();
      localAppMode.reloadWithFirstPageChange = paramStAppMode.reloadWithFirstPageChange.get();
      localAppMode.unlimitedApiRight = paramStAppMode.unlimitedApiRight.get();
      localAppMode.disableShareToAIO = paramStAppMode.disableShareToAIO.get();
      localAppMode.disableShareToQZone = paramStAppMode.disableShareToQZone.get();
      localAppMode.disableShareToWeChat = paramStAppMode.disableShareToWeChat.get();
    }
    return localAppMode;
  }
  
  public static final boolean isEqOne(int paramInt)
  {
    return paramInt == 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(booleanToInt(this.interMode));
    paramParcel.writeInt(booleanToInt(this.authoritySilent));
    paramParcel.writeInt(booleanToInt(this.keepOffPullList));
    paramParcel.writeInt(booleanToInt(this.closeTopRightCapsule));
    paramParcel.writeInt(booleanToInt(this.openNativeApi));
    paramParcel.writeInt(booleanToInt(this.hideAppSearch));
    paramParcel.writeInt(booleanToInt(this.isAppStore));
    paramParcel.writeInt(booleanToInt(this.isWangKa));
    paramParcel.writeInt(booleanToInt(this.interLoading));
    paramParcel.writeInt(booleanToInt(this.isLimitedAccess));
    paramParcel.writeInt(booleanToInt(this.isPayForFriend));
    paramParcel.writeInt(booleanToInt(this.useAppInfoWhenNavigate));
    paramParcel.writeInt(booleanToInt(this.disableAddToMyApp));
    paramParcel.writeInt(booleanToInt(this.disableAddToMyFavor));
    paramParcel.writeInt(booleanToInt(this.reloadWithFirstPageChange));
    paramParcel.writeInt(booleanToInt(this.unlimitedApiRight));
    paramParcel.writeInt(booleanToInt(this.disableShareToAIO));
    paramParcel.writeInt(booleanToInt(this.disableShareToQZone));
    paramParcel.writeInt(booleanToInt(this.disableShareToWeChat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.AppMode
 * JD-Core Version:    0.7.0.1
 */