package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class DesktopChessRoomModuleInfo
  extends DesktopItemInfo
{
  public int chessEntranceTabIndex;
  public MiniAppInfo moreAppInfo;
  public List<INTERFACE.StUserAppInfo> tabList;
  public String title;
  
  public DesktopChessRoomModuleInfo(int paramInt)
  {
    this.mModuleType = paramInt;
    this.dragEnable = false;
    this.dropEnable = false;
    this.deleteEnable = false;
  }
  
  private static int getChessEntranceTabIndex(@NonNull INTERFACE.StModuleInfo paramStModuleInfo)
  {
    if ((paramStModuleInfo.jumpMoreApp != null) && (paramStModuleInfo.jumpMoreApp.appInfo != null)) {
      return paramStModuleInfo.jumpMoreApp.appInfo.tabIndex.get();
    }
    return 0;
  }
  
  public void mergePbData(@NonNull INTERFACE.StModuleInfo paramStModuleInfo)
  {
    this.title = paramStModuleInfo.title.get();
    this.chessEntranceTabIndex = getChessEntranceTabIndex(paramStModuleInfo);
    this.moreAppInfo = MiniAppInfo.from(paramStModuleInfo.jumpMoreApp);
    this.tabList = paramStModuleInfo.userAppList.get();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.title);
    localStringBuilder.append("_");
    localStringBuilder.append(this.mModuleType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopChessRoomModuleInfo
 * JD-Core Version:    0.7.0.1
 */