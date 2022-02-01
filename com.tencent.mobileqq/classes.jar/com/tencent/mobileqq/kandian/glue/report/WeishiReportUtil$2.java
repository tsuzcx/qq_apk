package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class WeishiReportUtil$2
  implements Runnable
{
  WeishiReportUtil$2(int paramInt, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("ExitType");
    localAttributeList.att_value.set(WeishiReportUtil.a(this.jdField_a_of_type_Int));
    localArrayList.add(localAttributeList);
    localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(2);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(String.valueOf(this.jdField_a_of_type_JavaLangString));
    localArrayList.add(localAttributeList);
    localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(3);
    localAttributeList.att_name.set("Time");
    localAttributeList.att_value.set(String.valueOf(ReadinjoySPEventReport.a(this.jdField_a_of_type_Long) / 1000L));
    localArrayList.add(localAttributeList);
    if (!"1".equals(this.jdField_a_of_type_JavaLangString))
    {
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(5);
      localAttributeList.att_name.set("StrategyID");
      localAttributeList.att_value.set(this.b);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(6);
      localAttributeList.att_name.set("AlgorithmID");
      localAttributeList.att_value.set(this.c);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(7);
      localAttributeList.att_name.set("costtime");
      PBStringField localPBStringField = localAttributeList.att_value;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.d);
      localPBStringField.set(localStringBuilder.toString());
      localArrayList.add(localAttributeList);
    }
    ReadinjoyReportUtils.a(26, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil.2
 * JD-Core Version:    0.7.0.1
 */