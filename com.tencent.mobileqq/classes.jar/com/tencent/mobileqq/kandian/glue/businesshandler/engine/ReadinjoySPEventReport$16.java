package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$16
  implements Runnable
{
  ReadinjoySPEventReport$16(List paramList) {}
  
  public void run()
  {
    if (ReadinjoySPEventReport.j(19))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new StringBuilder();
      int i = 0;
      long l = 0L;
      int j = 0;
      int k = 0;
      while (i < this.a.size())
      {
        localObject2 = (ReadinjoySPEventReport.ScrollStep)this.a.get(i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ReadinjoySPEventReport.ScrollStep)localObject2).a);
        localStringBuilder.append("-");
        localStringBuilder.append(((ReadinjoySPEventReport.ScrollStep)localObject2).b);
        localStringBuilder.append("-");
        localStringBuilder.append(((ReadinjoySPEventReport.ScrollStep)localObject2).d);
        localStringBuilder.append("-");
        localStringBuilder.append(((ReadinjoySPEventReport.ScrollStep)localObject2).e);
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
        if (i != this.a.size() - 1) {
          ((StringBuilder)localObject1).append(":");
        } else {
          k = ((ReadinjoySPEventReport.ScrollStep)localObject2).f;
        }
        j += ((ReadinjoySPEventReport.ScrollStep)localObject2).d;
        l += ((ReadinjoySPEventReport.ScrollStep)localObject2).b;
        i += 1;
      }
      Object localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("scrollstep");
      ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((StringBuilder)localObject1).toString());
      localArrayList.add(localObject2);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("distancetotal");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(j);
      ((PBStringField)localObject2).set(localStringBuilder.toString());
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("scrolltimetotal");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l);
      ((PBStringField)localObject2).set(localStringBuilder.toString());
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(4);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("items");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(k);
      ((PBStringField)localObject2).set(localStringBuilder.toString());
      localArrayList.add(localObject1);
      ReadinjoyReportUtils.a(19, localArrayList);
    }
    ReadinjoySPEventReport.ScrollReportUtil.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.16
 * JD-Core Version:    0.7.0.1
 */