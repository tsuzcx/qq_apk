package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$17
  implements Runnable
{
  ReadinjoySPEventReport$17(int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!ReadinjoySPEventReport.b(61)) {
          return;
        }
        int k = -1;
        Object localObject1 = BaseActivity.sTopActivity;
        boolean bool = localObject1 instanceof SplashActivity;
        int j = 4;
        i = k;
        if (bool)
        {
          localObject1 = (SplashActivity)localObject1;
          i = k;
          if (SplashActivity.currentFragment == 1)
          {
            i = ((SplashActivity)localObject1).getCurrentTab();
            if (i == FrameControllerUtil.g)
            {
              i = 3;
            }
            else if (i == FrameControllerUtil.c)
            {
              i = 2;
            }
            else if (i == FrameControllerUtil.a)
            {
              i = 1;
            }
            else
            {
              if (i != FrameControllerUtil.d) {
                break label365;
              }
              i = 4;
            }
          }
        }
        if (this.a == 22) {
          j = 1;
        } else if (this.a == 23) {
          j = 2;
        } else if (this.a == 24) {
          j = 3;
        }
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("tab");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(i));
        oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(2);
        localAttributeList.att_name.set("type");
        Object localObject2 = localAttributeList.att_value;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append("");
        ((PBStringField)localObject2).set(localStringBuilder.toString());
        localObject2 = new ArrayList();
        ((List)localObject2).add(localObject1);
        ((List)localObject2).add(localAttributeList);
        localObject1 = RIJMergeKanDianMessage.a(1008);
        if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(3);
          localAttributeList.att_name.set("FuncRed");
          localAttributeList.att_value.set((String)localObject1);
          ((List)localObject2).add(localAttributeList);
        }
        ReadinjoyReportUtils.a(61, (List)localObject2);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.fillInStackTrace();
        return;
      }
      label365:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.17
 * JD-Core Version:    0.7.0.1
 */