package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DesktopPopularModuleInfo
  extends DesktopItemInfo
{
  public String backgroundUrl;
  public MiniAppInfo moreAppInfo;
  public List<MiniAppInfo> popularAppList = new ArrayList();
  public String title;
  public String titleIconUrl;
  
  public DesktopPopularModuleInfo(int paramInt)
  {
    this.mModuleType = paramInt;
    this.dragEnable = false;
    this.dropEnable = false;
    this.deleteEnable = false;
  }
  
  public void mergePbData(INTERFACE.StModuleInfo paramStModuleInfo)
  {
    this.title = paramStModuleInfo.title.get();
    this.titleIconUrl = paramStModuleInfo.titleIcon.get();
    this.backgroundUrl = paramStModuleInfo.backgroundPic.get();
    this.moreAppInfo = MiniAppInfo.from(paramStModuleInfo.jumpMoreApp);
    if ((paramStModuleInfo.userAppList != null) && (paramStModuleInfo.userAppList.get().size() > 0))
    {
      paramStModuleInfo = paramStModuleInfo.userAppList.get().iterator();
      while (paramStModuleInfo.hasNext())
      {
        MiniAppInfo localMiniAppInfo = MiniAppInfo.from((INTERFACE.StUserAppInfo)paramStModuleInfo.next());
        this.popularAppList.add(localMiniAppInfo);
      }
    }
  }
  
  public String toString()
  {
    return this.title + "_" + this.mModuleType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopPopularModuleInfo
 * JD-Core Version:    0.7.0.1
 */