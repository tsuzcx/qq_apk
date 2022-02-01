package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

final class ReadinjoySPEventReport$2
  implements Runnable
{
  public void run()
  {
    if (ReadinjoySPEventReport.b(8))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new oidb_cmd0x80a.AttributeList();
      Object localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_id;
      int i = 1;
      ((PBUInt32Field)localObject2).set(1);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("DTHasRed");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      if (!ReadinjoySPEventReport.b()) {
        i = 0;
      }
      ((PBStringField)localObject2).set(String.valueOf(i));
      localArrayList.add(localObject1);
      localObject1 = BaseActivity.sTopActivity;
      if ((localObject1 != null) && ((localObject1 instanceof SplashActivity)))
      {
        localObject2 = (MainFragment)((SplashActivity)localObject1).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = ((MainFragment)localObject2).c();
        }
        if (localObject1 != null)
        {
          if (((String)localObject1).equals(Conversation.class.getName())) {
            localObject1 = "1";
          } else if (((String)localObject1).equals(Contacts.class.getName())) {
            localObject1 = "2";
          } else if (((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLeba((String)localObject1)) {
            localObject1 = "4";
          } else if (RIJXTabFrameUtils.INSTANCE.isKandianTabFrame((String)localObject1)) {
            localObject1 = "3";
          } else {
            localObject1 = "0";
          }
          localObject2 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(2);
          ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("tab");
          ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      ReadinjoyReportUtils.a(8, localArrayList);
      ReadinjoySPEventReport.b(System.currentTimeMillis());
      ReadinjoySPEventReport.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.2
 * JD-Core Version:    0.7.0.1
 */