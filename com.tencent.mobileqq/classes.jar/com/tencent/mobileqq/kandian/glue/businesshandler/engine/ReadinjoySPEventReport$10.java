package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

class ReadinjoySPEventReport$10
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("action");
    Object localObject = localAttributeList.att_value;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    ((PBStringField)localObject).set(localStringBuilder.toString());
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("leavetime");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(this.jdField_a_of_type_Long / 1000L));
    localArrayList.add(localAttributeList);
    localArrayList.add(localObject);
    ReadinjoyReportUtils.a(20, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.10
 * JD-Core Version:    0.7.0.1
 */