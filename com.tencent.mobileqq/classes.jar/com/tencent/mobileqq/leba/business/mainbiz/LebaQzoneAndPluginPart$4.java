package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashMap;

class LebaQzoneAndPluginPart$4
  implements Runnable
{
  LebaQzoneAndPluginPart$4(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, RedTouchManager paramRedTouchManager, LebaViewItem paramLebaViewItem) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.a.uiResId + "");
    HashMap localHashMap = new HashMap();
    if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() == 0) {}
    for (localObject = "1";; localObject = "0")
    {
      localHashMap.put("ext_int1", localObject);
      ExpandReportUtils.a("expose#all_page#dynamic_entrance", true, -1L, -1L, localHashMap, true, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.4
 * JD-Core Version:    0.7.0.1
 */