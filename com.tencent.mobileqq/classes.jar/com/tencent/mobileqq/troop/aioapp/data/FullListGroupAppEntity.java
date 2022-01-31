package com.tencent.mobileqq.troop.aioapp.data;

import atmo;
import atnz;
import ayjf;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FullListGroupAppEntity
  extends atmo
{
  private static final String TAG = "FullListGroupAppEntity";
  @atnz
  public List<TroopAIOAppInfo> troopAIOAppInfos = new ArrayList(20);
  public byte[] troopAIOAppInfosData;
  
  public void postRead()
  {
    super.postRead();
    Object localObject = ayjf.a(this.troopAIOAppInfosData);
    if (localObject != null) {}
    try
    {
      this.troopAIOAppInfos = ((List)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FullListGroupAppEntity", 2, "postRead: failed. ", localException);
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
    this.troopAIOAppInfosData = ayjf.a(this.troopAIOAppInfos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity
 * JD-Core Version:    0.7.0.1
 */