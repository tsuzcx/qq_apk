package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DesktopAppGroupInfo
  extends DesktopItemInfo
{
  public List<DesktopAppInfo> datas = new ArrayList();
  
  public DesktopAppGroupInfo(int paramInt)
  {
    this.mModuleType = paramInt;
  }
  
  public void addPbData(PBRepeatMessageField<INTERFACE.StUserAppInfo> paramPBRepeatMessageField)
  {
    if (paramPBRepeatMessageField == null) {
      return;
    }
    this.datas.clear();
    paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
    while (paramPBRepeatMessageField.hasNext())
    {
      Object localObject = (INTERFACE.StUserAppInfo)paramPBRepeatMessageField.next();
      localObject = new DesktopAppInfo(this.mModuleType, MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject));
      this.datas.add(localObject);
    }
  }
  
  public void setData(List<DesktopAppInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.datas.clear();
    this.datas.addAll(paramList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppGroup_");
    localStringBuilder.append(this.mModuleType);
    localStringBuilder.append("_");
    localStringBuilder.append(this.datas.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppGroupInfo
 * JD-Core Version:    0.7.0.1
 */