package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$18
  implements Runnable
{
  ReadinjoySPEventReport$18(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(1);
    localAttributeList1.att_name.set("FolderStatus");
    localAttributeList1.att_value.set(String.valueOf(this.a));
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(2);
    localAttributeList2.att_name.set("StrategyID");
    Object localObject1 = localAttributeList2.att_value;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append("");
    ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
    localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("AlgorithmID");
    localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("");
    ((PBStringField)localObject2).set(localStringBuilder.toString());
    localObject2 = new ArrayList();
    ((List)localObject2).add(localAttributeList1);
    ((List)localObject2).add(localAttributeList2);
    ((List)localObject2).add(localObject1);
    ReadinjoyReportUtils.a(this.d, (List)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.18
 * JD-Core Version:    0.7.0.1
 */