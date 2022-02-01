package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$14
  implements Runnable
{
  public void run()
  {
    if (ReadinjoySPEventReport.b(24))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = BaseActivity.sTopActivity;
      if ((localObject1 instanceof SplashActivity)) {
        try
        {
          Object localObject2 = (MainFragment)((SplashActivity)localObject1).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
          if (localObject2 == null) {
            return;
          }
          localObject1 = ((MainFragment)localObject2).a();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(FrameControllerUtil.a);
          ((StringBuilder)localObject3).append("_num");
          localObject1 = (View)((HashMap)localObject1).get(((StringBuilder)localObject3).toString());
          if (localObject1 == null) {
            return;
          }
          int i = ((View)localObject1).getVisibility();
          localObject3 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(1);
          ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("MsgRedStatus");
          PBStringField localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
          if (i == 0) {
            localObject1 = String.valueOf(1);
          } else {
            localObject1 = String.valueOf(0);
          }
          localPBStringField.set((String)localObject1);
          localArrayList.add(localObject3);
          boolean bool = ((MainFragment)localObject2).a(FrameControllerUtil.b).c();
          localObject3 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(2);
          ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("ContactsRedStatus");
          localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
          if (bool) {
            localObject1 = String.valueOf(1);
          } else {
            localObject1 = String.valueOf(0);
          }
          localPBStringField.set((String)localObject1);
          localArrayList.add(localObject3);
          bool = ((MainFragment)localObject2).a(FrameControllerUtil.d).c();
          localObject3 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(3);
          ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("TrendsRedStatus");
          localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
          if (bool) {
            localObject1 = String.valueOf(1);
          } else {
            localObject1 = String.valueOf(0);
          }
          localPBStringField.set((String)localObject1);
          localArrayList.add(localObject3);
          if (ReadInJoyHelper.m())
          {
            localObject1 = ((MainFragment)localObject2).a(FrameControllerUtil.f);
            if (localObject1 != null)
            {
              bool = ((RedTouch)localObject1).c();
              localObject3 = new oidb_cmd0x80a.AttributeList();
              ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(4);
              ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("KandianRedStatus");
              localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject3).att_value;
              if (bool) {
                localObject1 = String.valueOf(1);
              } else {
                localObject1 = String.valueOf(0);
              }
              localPBStringField.set((String)localObject1);
              localArrayList.add(localObject3);
            }
          }
          localObject1 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
          ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("tab");
          i = ReadinjoySPEventReport.b(((MainFragment)localObject2).a());
          localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(i);
          ((PBStringField)localObject2).set(((StringBuilder)localObject3).toString());
          localArrayList.add(localObject1);
          localObject1 = RIJMergeKanDianMessage.a(1008);
          if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject2 = new oidb_cmd0x80a.AttributeList();
            ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(6);
            ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FuncRed");
            ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
            localArrayList.add(localObject2);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadinjoySPEventReport", 2, "reportTabExposure_ERROR : ", localException);
          }
        }
      }
      ReadinjoyReportUtils.a(24, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.14
 * JD-Core Version:    0.7.0.1
 */