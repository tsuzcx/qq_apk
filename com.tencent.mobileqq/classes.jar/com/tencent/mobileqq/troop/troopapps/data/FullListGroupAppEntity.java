package com.tencent.mobileqq.troop.troopapps.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FullListGroupAppEntity
  extends Entity
{
  private static final String TAG = "FullListGroupAppEntity";
  @notColumn
  public List<TroopAIOAppInfo> troopAIOAppInfos = new ArrayList(20);
  public byte[] troopAIOAppInfosData;
  
  protected void postRead()
  {
    super.postRead();
    Object localObject = GroupUtil.a(this.troopAIOAppInfosData);
    if (localObject != null) {
      try
      {
        this.troopAIOAppInfos = ((List)localObject);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FullListGroupAppEntity", 2, "postRead: failed. ", localException);
        }
      }
    }
  }
  
  protected void prewrite()
  {
    super.prewrite();
    this.troopAIOAppInfosData = GroupUtil.a(this.troopAIOAppInfos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity
 * JD-Core Version:    0.7.0.1
 */