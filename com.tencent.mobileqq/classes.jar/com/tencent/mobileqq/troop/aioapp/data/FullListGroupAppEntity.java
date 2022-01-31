package com.tencent.mobileqq.troop.aioapp.data;

import awge;
import awhp;
import bbmp;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FullListGroupAppEntity
  extends awge
{
  private static final String TAG = "FullListGroupAppEntity";
  @awhp
  public List<TroopAIOAppInfo> troopAIOAppInfos = new ArrayList(20);
  public byte[] troopAIOAppInfosData;
  
  public void postRead()
  {
    super.postRead();
    Object localObject = bbmp.a(this.troopAIOAppInfosData);
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
    this.troopAIOAppInfosData = bbmp.a(this.troopAIOAppInfos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity
 * JD-Core Version:    0.7.0.1
 */