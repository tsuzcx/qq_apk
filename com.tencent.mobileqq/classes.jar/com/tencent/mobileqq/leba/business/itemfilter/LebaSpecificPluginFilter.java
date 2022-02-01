package com.tencent.mobileqq.leba.business.itemfilter;

import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.leba.business.ILebaItemFilter;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LebaSpecificPluginFilter
  implements ILebaItemFilter
{
  public boolean a()
  {
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab();
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == NowLiveManager.jdField_a_of_type_Int;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool = true;
    if (paramQQAppInterface == null) {
      return true;
    }
    if (7720L == paramLong) {
      return true ^ ((IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramQQAppInterface);
    }
    if (7759L == paramLong)
    {
      paramQQAppInterface = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
      if (paramQQAppInterface == null) {
        break label75;
      }
      if (paramQQAppInterface.i < 1) {
        return true;
      }
    }
    bool = false;
    label75:
    return bool;
  }
  
  public boolean a(LebaViewItem paramLebaViewItem)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 905L) {
      return true;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == NowLiveManager.jdField_a_of_type_Int)
    {
      boolean bool;
      if ((localObject instanceof QQAppInterface)) {
        bool = ((QQAppInterface)localObject).getNowLiveManager().a();
      } else {
        bool = false;
      }
      if (!bool) {
        return true;
      }
    }
    if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 1130L) && (a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
      }
      return true;
    }
    if (((localObject instanceof QQAppInterface)) && (a((QQAppInterface)localObject, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getLebaMgrList, ");
        ((StringBuilder)localObject).append(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
        ((StringBuilder)localObject).append(" is filtered");
        QLog.d("Q.lebatab.mgr", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, StringBuffer paramStringBuffer, LebaViewItem paramLebaViewItem)
  {
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 905L) {
      return true;
    }
    if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 1130L) && (a()))
    {
      paramStringBuffer.append("hide leba kandian,");
      return true;
    }
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId))
      {
        paramStringBuffer.append("isNowTabAdded");
        paramAppRuntime.getNowLiveManager();
        paramStringBuffer.append(NowLiveManager.c);
        paramStringBuffer.append("  isNowTabShow:");
        paramStringBuffer.append(paramAppRuntime.getNowLiveManager().jdField_a_of_type_Boolean);
        paramStringBuffer.append("  isSDKAPISupportStory:");
        paramStringBuffer.append(QQStoryManager.i());
        paramStringBuffer.append(",");
        if ((!paramAppRuntime.getNowLiveManager().a()) || (paramLebaViewItem.jdField_a_of_type_Byte == 1)) {
          return true;
        }
      }
      if (a(paramAppRuntime, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId))
      {
        paramStringBuffer.append(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId);
        paramStringBuffer.append(" is filtered");
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.itemfilter.LebaSpecificPluginFilter
 * JD-Core Version:    0.7.0.1
 */