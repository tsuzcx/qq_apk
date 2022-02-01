package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$3
  implements Runnable
{
  ReadinjoySPEventReport$3(boolean paramBoolean) {}
  
  public void run()
  {
    if ((!this.a) && (!ReadinjoySPEventReport.x())) {
      return;
    }
    if (this.a)
    {
      ReadinjoySPEventReport.e(System.currentTimeMillis());
      ReadinjoySPEventReport.e(true);
    }
    ReadinjoySPEventReport.f(this.a);
    if (ReadinjoySPEventReport.j(9))
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("isOn");
      PBStringField localPBStringField = localAttributeList.att_value;
      Object localObject;
      if (this.a) {
        localObject = String.valueOf(1);
      } else {
        localObject = String.valueOf(0);
      }
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      if (!this.a)
      {
        long l = ReadinjoySPEventReport.y();
        l = (System.currentTimeMillis() - l) / 1000L;
        localObject = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
        ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("time");
        ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(l));
        localArrayList.add(localObject);
        localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(3);
        localAttributeList.att_name.set("isScreenTime");
        localPBStringField = localAttributeList.att_value;
        if (ReadinjoySPEventReport.z()) {
          localObject = "1";
        } else {
          localObject = "0";
        }
        localPBStringField.set((String)localObject);
        localArrayList.add(localAttributeList);
      }
      ReadinjoyReportUtils.a(9, localArrayList);
      if (this.a)
      {
        ReadinjoySPEventReport.f(System.currentTimeMillis());
        ReadinjoySPEventReport.k(0);
      }
      else
      {
        ReadinjoySPEventReport.A();
      }
    }
    if (ReadinjoySPEventReport.ForeBackGround.a == 1) {
      ReadinjoySPEventReport.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.3
 * JD-Core Version:    0.7.0.1
 */