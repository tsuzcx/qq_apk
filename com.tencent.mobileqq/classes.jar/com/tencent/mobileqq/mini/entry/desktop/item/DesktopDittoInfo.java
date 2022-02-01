package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DesktopDittoInfo
  extends DesktopItemInfo
{
  public List<MiniAppInfo> appInfoList = new ArrayList();
  public Map<String, MiniAppInfo> appInfoMap = new HashMap();
  public AtomicInteger currentIndex = new AtomicInteger(0);
  public String dittoDls;
  public MiniAppInfo jumpMoreInfo;
  public int subType;
  public String title;
  
  public DesktopDittoInfo(int paramInt)
  {
    this.mModuleType = paramInt;
    this.dragEnable = false;
    this.dropEnable = false;
    this.deleteEnable = false;
  }
  
  private boolean hasRepeatApp()
  {
    return this.subType == 5;
  }
  
  public void incrementIndex()
  {
    this.currentIndex.incrementAndGet();
  }
  
  public void mergePbData(INTERFACE.StModuleInfo paramStModuleInfo)
  {
    this.title = paramStModuleInfo.title.get();
    this.dittoDls = paramStModuleInfo.dittoDsl.get();
    this.jumpMoreInfo = MiniAppInfo.from(paramStModuleInfo.jumpMoreApp);
    this.subType = paramStModuleInfo.subTypes.get();
    if ((paramStModuleInfo.userAppList != null) && (paramStModuleInfo.userAppList.get().size() > 0))
    {
      paramStModuleInfo = paramStModuleInfo.userAppList.get().iterator();
      while (paramStModuleInfo.hasNext())
      {
        MiniAppInfo localMiniAppInfo = MiniAppInfo.from((INTERFACE.StUserAppInfo)paramStModuleInfo.next());
        if (localMiniAppInfo != null) {
          if (hasRepeatApp()) {
            this.appInfoList.add(localMiniAppInfo);
          } else {
            this.appInfoMap.put(localMiniAppInfo.appId, localMiniAppInfo);
          }
        }
      }
    }
  }
  
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
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo
 * JD-Core Version:    0.7.0.1
 */