package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.scupdate.SCUpdatePB.ItemVersion;
import java.util.ArrayList;
import java.util.List;

public class VasQuickUpdateManager$SCPreloadOrReport
{
  public List<VasQuickUpdateManager.ItemVersion> itemList = new ArrayList();
  public long ver;
  
  public void setList(PBRepeatMessageField<SCUpdatePB.ItemVersion> paramPBRepeatMessageField)
  {
    int i = 0;
    while (i < paramPBRepeatMessageField.size())
    {
      VasQuickUpdateManager.ItemVersion localItemVersion = new VasQuickUpdateManager.ItemVersion();
      SCUpdatePB.ItemVersion localItemVersion1 = (SCUpdatePB.ItemVersion)paramPBRepeatMessageField.get(i);
      localItemVersion.bid = localItemVersion1.bid.get();
      localItemVersion.scid = localItemVersion1.scid.get();
      localItemVersion.version = localItemVersion1.version.get();
      localItemVersion.flag = localItemVersion1.flag.get();
      this.itemList.add(localItemVersion);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.SCPreloadOrReport
 * JD-Core Version:    0.7.0.1
 */