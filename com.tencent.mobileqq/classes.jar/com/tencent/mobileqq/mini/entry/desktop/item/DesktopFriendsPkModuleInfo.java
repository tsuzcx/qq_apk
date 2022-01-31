package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StFriendRanking;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public class DesktopFriendsPkModuleInfo
  extends DesktopItemInfo
{
  @Nullable
  public final MiniAppInfo appInfo;
  @Nullable
  public final MiniAppInfo jumpMoreInfo;
  @NonNull
  public final INTERFACE.StModuleInfo moduleInfo;
  @NonNull
  public final INTERFACE.StFriendRanking ranking;
  
  public DesktopFriendsPkModuleInfo(int paramInt, @NonNull INTERFACE.StModuleInfo paramStModuleInfo, @NonNull INTERFACE.StFriendRanking paramStFriendRanking)
  {
    this.mModuleType = paramInt;
    this.moduleInfo = paramStModuleInfo;
    this.ranking = paramStFriendRanking;
    this.jumpMoreInfo = MiniAppInfo.from(paramStModuleInfo.jumpMoreApp);
    this.appInfo = MiniAppInfo.from(paramStFriendRanking.gameInfo);
  }
  
  public String toString()
  {
    if (this.moduleInfo != null) {
      return this.moduleInfo.title.get() + "_" + this.moduleInfo.moduleType.get();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopFriendsPkModuleInfo
 * JD-Core Version:    0.7.0.1
 */