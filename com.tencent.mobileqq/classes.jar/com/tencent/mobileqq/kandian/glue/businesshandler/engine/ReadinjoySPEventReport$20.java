package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$20
  implements Runnable
{
  ReadinjoySPEventReport$20(int paramInt1, Map paramMap, int paramInt2) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("op_type");
    Object localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject3).append("");
    ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
    localArrayList.add(localObject1);
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("daily_folderstatus");
      if (this.jdField_a_of_type_JavaUtilMap.containsKey("folder_status")) {
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("folder_status"));
      } else {
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set("1");
      }
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("strategy_id");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("strategy_id"));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(4);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("algorithm_id");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set((String)this.jdField_a_of_type_JavaUtilMap.get("algorithm_id"));
      localArrayList.add(localObject1);
    }
    int i = this.jdField_a_of_type_Int;
    long l2 = 0L;
    long l1;
    if (i == 1)
    {
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("operation_bitmap");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.b);
      ((StringBuilder)localObject3).append("");
      ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject1);
      localObject1 = ReadinjoySPEventReport.a().b;
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(7);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("staticDurationAfterEnter");
      if (((ReadinjoySPEventReport.UserOptInfo)localObject1).a > 0L) {
        l1 = ((ReadinjoySPEventReport.UserOptInfo)localObject1).a - ((ReadinjoySPEventReport.UserOptInfo)localObject1).d;
      } else {
        l1 = 0L;
      }
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      ((PBStringField)localObject3).set(localStringBuilder.toString());
      localArrayList.add(localObject2);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(8);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("staticDurationBeforeExit");
      l1 = l2;
      if (((ReadinjoySPEventReport.UserOptInfo)localObject1).c > 0L) {
        l1 = ((ReadinjoySPEventReport.UserOptInfo)localObject1).e - ((ReadinjoySPEventReport.UserOptInfo)localObject1).c;
      }
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      ((PBStringField)localObject3).set(localStringBuilder.toString());
      localArrayList.add(localObject2);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(9);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("articleInfoList");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject1).a());
      localArrayList.add(localObject2);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(10);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("scrollInfoList");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((ReadinjoySPEventReport.UserOptInfo)localObject1).b());
      localArrayList.add(localObject2);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(11);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("stayDuration");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((ReadinjoySPEventReport.UserOptInfo)localObject1).e - ((ReadinjoySPEventReport.UserOptInfo)localObject1).d);
      localStringBuilder.append("");
      ((PBStringField)localObject3).set(localStringBuilder.toString());
      localArrayList.add(localObject2);
    }
    else
    {
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(6);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("durationBeforeEnter");
      l2 = System.currentTimeMillis();
      if (ReadinjoySPEventReport.f() <= 0L) {
        l1 = ReadinjoySPEventReport.a;
      } else {
        l1 = ReadinjoySPEventReport.f();
      }
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(l2 - l1);
      ((StringBuilder)localObject3).append("");
      ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject1);
      ReadinjoySPEventReport.n();
    }
    ReadinjoyReportUtils.a(90, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.20
 * JD-Core Version:    0.7.0.1
 */