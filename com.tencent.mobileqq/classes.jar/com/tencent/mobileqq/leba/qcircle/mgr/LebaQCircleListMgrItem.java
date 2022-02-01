package com.tencent.mobileqq.leba.qcircle.mgr;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.leba.business.ILebaListMgrItemBiz;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LebaQCircleListMgrItem
  implements ILebaListMgrItemBiz
{
  public void a(ArrayList<LebaViewItem> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramArrayList.size() > 0)
        {
          localObject = paramArrayList.iterator();
          if (((Iterator)localObject).hasNext())
          {
            LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
            if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != 1001L)) {
              continue;
            }
            paramArrayList.remove(localLebaViewItem);
          }
        }
        if ((!QzoneConfig.isQQCircleShowLebaEntrance(StudyModeManager.a())) || (!QzoneConfig.isQQCircleShowSwitchButton())) {
          break;
        }
        Object localObject = new LebaViewItem();
        ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo = new LebaPluginInfo();
        ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId = 1001L;
        if (QzoneConfig.isQQCircleShowLebaBySwitchButton(StudyModeManager.a()))
        {
          i = 0;
          ((LebaViewItem)localObject).jdField_a_of_type_Byte = ((byte)i);
          ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName = HardCodeUtil.a(2131719715);
          ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResURL = "https://sola.gtimg.cn/aoi/sola/20201012111557_48i6yoJLfi.png";
          QLog.e("LebaQCircleListMgrItem", 1, "showQcircleItem");
          paramArrayList.add(0, localObject);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        QLog.e("LebaQCircleListMgrItem", 1, "getQcircleItem" + paramArrayList);
        return;
      }
      int i = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str = "";
    Object localObject;
    HashMap localHashMap;
    if (paramBoolean)
    {
      localObject = "1";
      localHashMap = new HashMap();
      if ((StudyModeManager.a()) || (!paramBoolean)) {
        break label127;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        localHashMap.put("qqcircle_entrance_enable_on_children_mode", str);
        QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", str);
      }
      localHashMap.put("qqcircle_entrance_enable", localObject);
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable", (String)localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("qqcircle", localHashMap);
      localObject = new QCircleSetMultiCircleWnsConfigRequest((HashMap)localObject);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new LebaQCircleListMgrItem.1(this, paramBoolean, str));
      return;
      localObject = "0";
      break;
      label127:
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      }
    }
  }
  
  public boolean a(RedTouch paramRedTouch, LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 1001L)
    {
      a(paramBoolean);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleListMgrItem
 * JD-Core Version:    0.7.0.1
 */