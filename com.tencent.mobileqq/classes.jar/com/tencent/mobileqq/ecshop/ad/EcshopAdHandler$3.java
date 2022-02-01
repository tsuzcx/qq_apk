package com.tencent.mobileqq.ecshop.ad;

import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;

class EcshopAdHandler$3
  implements Runnable
{
  EcshopAdHandler$3(EcshopAdHandler paramEcshopAdHandler, int paramInt, List paramList1, List paramList2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        qq_ad.QQAdGet localQQAdGet = new qq_ad.QQAdGet();
        localQQAdGet.trigger_type.set(this.a);
        Object localObject1 = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject1).a = "cd22b9";
        long l = System.currentTimeMillis();
        localObject1 = GdtDeviceInfoHelper.a(MobileQQ.sMobileQQ.getApplicationContext(), (GdtDeviceInfoHelper.Params)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((GdtDeviceInfoHelper.Result)localObject1).a;
          Object localObject3 = GdtJsonPbUtil.a((PBField)localObject1);
          if ((localObject3 != null) && (localObject3 != JSONObject.NULL))
          {
            localObject3 = localObject3.toString();
            if (QLog.isColorLevel()) {
              QLog.i("Ecshop_EcshopAdHandler", 2, (String)localObject3);
            }
            if (!StringUtil.isEmpty((String)localObject3)) {
              localQQAdGet.device_info.set((String)localObject3);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("get deviceInfo cost：");
            ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
            ((StringBuilder)localObject3).append(", result = ");
            if (localObject1 == null) {
              break label327;
            }
            bool = true;
            ((StringBuilder)localObject3).append(bool);
            QLog.i("Ecshop_EcshopAdHandler", 2, ((StringBuilder)localObject3).toString());
          }
          if (this.b != null) {
            localQQAdGet.pos_id.set(this.b);
          }
          if (this.c != null) {
            localQQAdGet.ad_count.set(this.c);
          }
          localQQAdGet.get_back.set(this.d);
          localQQAdGet.last_req_time.set(this.this$0.a);
          localObject1 = new ToServiceMsg("mobileqq.service", AppUtils.a().getCurrentUin(), this.e);
          ((ToServiceMsg)localObject1).putWupBuffer(localQQAdGet.toByteArray());
          this.this$0.sendPbReq((ToServiceMsg)localObject1);
          this.this$0.a = (System.currentTimeMillis() / 1000L);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      Object localObject2 = null;
      continue;
      label327:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.EcshopAdHandler.3
 * JD-Core Version:    0.7.0.1
 */