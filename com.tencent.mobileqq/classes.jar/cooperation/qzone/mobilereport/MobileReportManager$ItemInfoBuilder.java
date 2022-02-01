package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ActionInfo;
import NS_USER_ACTION_REPORT.ItemInfo;
import java.util.ArrayList;

public class MobileReportManager$ItemInfoBuilder
{
  private ArrayList<ActionInfo> actionInfos = new ArrayList();
  private String busiInfo = "";
  private String itemId = "";
  private String itemType = "";
  private String moduleId = "";
  private String subModuleId = "";
  
  public ItemInfoBuilder addActionInfo(ActionInfo paramActionInfo)
  {
    this.actionInfos.add(paramActionInfo);
    return this;
  }
  
  public ItemInfo build()
  {
    ItemInfo localItemInfo = new ItemInfo();
    localItemInfo.item_id = this.itemId;
    localItemInfo.action_infos = this.actionInfos;
    localItemInfo.busi_info = this.busiInfo;
    localItemInfo.module_id = this.moduleId;
    localItemInfo.item_type = this.itemType;
    localItemInfo.sub_module_id = this.subModuleId;
    return localItemInfo;
  }
  
  public ItemInfoBuilder setBusiInfo(String paramString)
  {
    this.busiInfo = paramString;
    return this;
  }
  
  public ItemInfoBuilder setItemId(String paramString)
  {
    this.itemId = paramString;
    return this;
  }
  
  public ItemInfoBuilder setItemType(String paramString)
  {
    this.itemType = paramString;
    return this;
  }
  
  public ItemInfoBuilder setModuleId(String paramString)
  {
    this.moduleId = paramString;
    return this;
  }
  
  public ItemInfoBuilder setSubModuleId(String paramString)
  {
    this.subModuleId = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager.ItemInfoBuilder
 * JD-Core Version:    0.7.0.1
 */