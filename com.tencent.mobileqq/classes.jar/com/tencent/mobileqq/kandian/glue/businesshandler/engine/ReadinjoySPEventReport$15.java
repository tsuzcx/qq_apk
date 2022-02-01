package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$15
  implements Runnable
{
  ReadinjoySPEventReport$15(List paramList, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ReadinjoySPEventReport.b(60))
    {
      long l1 = ReadinjoySPEventReport.b();
      long l2 = ReadinjoySPEventReport.a(l1 * 1000L) / 1000L;
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      int k = 0;
      int j = 0;
      while (i >= 0)
      {
        localObject1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
        if (((ChatMessage)localObject1).time <= l1) {
          break;
        }
        if (((ChatMessage)localObject1).isSendFromLocal()) {
          k = 1;
        } else {
          j = 1;
        }
        i -= 1;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("aiotype");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(ReadinjoySPEventReport.a(this.jdField_a_of_type_Int)));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("unreadmsg");
      Object localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.b);
      ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject1);
      localObject3 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("hassendmsg");
      PBStringField localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
      localObject2 = "1";
      if (k != 0) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      localPBStringField.set((String)localObject1);
      localArrayList.add(localObject3);
      localObject3 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(4);
      ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("hasrecvmsg");
      localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
      if (j != 0) {
        localObject1 = localObject2;
      } else {
        localObject1 = "0";
      }
      localPBStringField.set((String)localObject1);
      localArrayList.add(localObject3);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("costtime");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(l2);
      ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
      localArrayList.add(localObject1);
      ReadinjoyReportUtils.a(60, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.15
 * JD-Core Version:    0.7.0.1
 */