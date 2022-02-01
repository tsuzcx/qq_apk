package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$19
  implements Runnable
{
  ReadinjoySPEventReport$19(int paramInt1, Map paramMap, int paramInt2) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("op_type");
    PBStringField localPBStringField = localAttributeList.att_value;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    localPBStringField.set(localStringBuilder.toString());
    localArrayList.add(localAttributeList);
    if (this.b != null)
    {
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(2);
      localAttributeList.att_name.set("subscribe_folderstatus");
      if (this.b.containsKey("folder_status")) {
        localAttributeList.att_value.set((String)this.b.get("folder_status"));
      } else {
        localAttributeList.att_value.set("1");
      }
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("strategy_id");
      localAttributeList.att_value.set((String)this.b.get("strategy_id"));
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(4);
      localAttributeList.att_name.set("algorithm_id");
      localAttributeList.att_value.set((String)this.b.get("algorithm_id"));
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(5);
      localAttributeList.att_name.set("action_data");
      localAttributeList.att_value.set((String)this.b.get("action_data"));
      localArrayList.add(localAttributeList);
    }
    if (this.a == 1)
    {
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(6);
      localAttributeList.att_name.set("operation_bitmap");
      localPBStringField = localAttributeList.att_value;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      localPBStringField.set(localStringBuilder.toString());
      localArrayList.add(localAttributeList);
    }
    ReadinjoyReportUtils.a(70, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.19
 * JD-Core Version:    0.7.0.1
 */