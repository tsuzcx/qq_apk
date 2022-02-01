package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashMap;
import java.util.Map;

class LebaQzoneAndPluginPart$4
  implements Runnable
{
  LebaQzoneAndPluginPart$4(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, IRedTouchManager paramIRedTouchManager, LebaViewItem paramLebaViewItem) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b.b.uiResId);
    ((StringBuilder)localObject2).append("");
    localObject1 = ((IRedTouchManager)localObject1).getAppInfoByPath(((StringBuilder)localObject2).toString());
    localObject2 = new HashMap();
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).type.get() == 0) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    ((HashMap)localObject2).put("ext_int1", localObject1);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#all_page#dynamic_entrance", true, -1L, -1L, (Map)localObject2, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.4
 * JD-Core Version:    0.7.0.1
 */