package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBStringField;

public class DesktopRecommendModuleInfo
  extends DesktopItemInfo
{
  @Nullable
  public final MiniAppInfo jumpMoreInfo;
  @NonNull
  public final INTERFACE.StModuleInfo moduleInfo;
  
  public DesktopRecommendModuleInfo(int paramInt, INTERFACE.StModuleInfo paramStModuleInfo)
  {
    this.mModuleType = paramInt;
    this.moduleInfo = paramStModuleInfo;
    this.jumpMoreInfo = MiniAppInfo.from(paramStModuleInfo.jumpMoreApp);
  }
  
  public String toString()
  {
    if (this.moduleInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.moduleInfo.title.get());
      localStringBuilder.append("_");
      localStringBuilder.append(this.mModuleType);
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopRecommendModuleInfo
 * JD-Core Version:    0.7.0.1
 */