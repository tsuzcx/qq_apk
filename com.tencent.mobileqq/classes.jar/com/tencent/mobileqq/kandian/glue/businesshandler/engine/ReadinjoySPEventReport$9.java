package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

class ReadinjoySPEventReport$9
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    Object localObject1 = localAttributeList.att_value;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.folderStatus);
    ((StringBuilder)localObject2).append("");
    ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
    localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("StrategyID");
    localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.a.strategyID);
    ((StringBuilder)localObject3).append("");
    ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
    localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(3);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("AlgorithmID");
    localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.algorithmID);
    localStringBuilder.append("");
    ((PBStringField)localObject3).set(localStringBuilder.toString());
    localArrayList.add(localAttributeList);
    localArrayList.add(localObject1);
    localArrayList.add(localObject2);
    int i = this.b;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      i = 17;
    }
    else
    {
      i = 16;
    }
    ReadinjoyReportUtils.a(i, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.9
 * JD-Core Version:    0.7.0.1
 */