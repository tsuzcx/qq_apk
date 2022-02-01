package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DesktopChessRoomCardModuleInfo
  extends DesktopItemInfo
{
  public List<MiniAppInfo> appList = new ArrayList();
  public String backgroundUrl;
  public int chessEntranceTabIndex;
  public MiniAppInfo moreAppInfo;
  public String title;
  
  public DesktopChessRoomCardModuleInfo(int paramInt)
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
    this.backgroundUrl = paramStModuleInfo.backgroundPic.get();
    this.chessEntranceTabIndex = getChessEntranceTabIndex(paramStModuleInfo);
    this.moreAppInfo = MiniAppInfo.from(paramStModuleInfo.jumpMoreApp);
    if ((paramStModuleInfo.userAppList.get() != null) && (paramStModuleInfo.userAppList.get().size() > 0))
    {
      paramStModuleInfo = paramStModuleInfo.userAppList.get().iterator();
      while (paramStModuleInfo.hasNext())
      {
        MiniAppInfo localMiniAppInfo = MiniAppInfo.from((INTERFACE.StUserAppInfo)paramStModuleInfo.next());
        this.appList.add(localMiniAppInfo);
      }
    }
  }
  
  @NonNull
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
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopChessRoomCardModuleInfo
 * JD-Core Version:    0.7.0.1
 */