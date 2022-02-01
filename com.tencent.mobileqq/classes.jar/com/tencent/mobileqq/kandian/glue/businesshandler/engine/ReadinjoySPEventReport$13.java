package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$13
  implements Runnable
{
  ReadinjoySPEventReport$13(int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (ReadinjoySPEventReport.b(7))
    {
      oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(1);
      localAttributeList1.att_name.set("tab");
      localAttributeList1.att_value.set(String.valueOf(this.jdField_a_of_type_Int));
      oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(4);
      localAttributeList2.att_name.set("redStatus");
      PBStringField localPBStringField = localAttributeList2.att_value;
      if (this.jdField_a_of_type_Boolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localPBStringField.set((String)localObject);
      Object localObject = new ArrayList();
      ((List)localObject).add(localAttributeList1);
      ((List)localObject).add(localAttributeList2);
      ReadinjoyReportUtils.a(7, (List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.13
 * JD-Core Version:    0.7.0.1
 */