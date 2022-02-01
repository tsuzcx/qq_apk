package com.tencent.mobileqq.leba.business.itemfilter;

import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.leba.business.ILebaItemFilter;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.AppRuntime;

public class LebaSpecificPluginFilter
  implements ILebaItemFilter
{
  public boolean a()
  {
    return ReadInJoyHelper.o();
  }
  
  public boolean a(long paramLong)
  {
    return paramLong == NowLiveManager.jdField_a_of_type_Int;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (7720L == paramLong)
      {
        if (((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramQQAppInterface)) {}
        for (boolean bool = false;; bool = true) {
          return bool;
        }
      }
      if (7759L != paramLong) {
        break;
      }
      paramQQAppInterface = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.i < 1));
    return false;
    return false;
  }
  
  public boolean a(LebaViewItem paramLebaViewItem)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 905L) {
      return true;
    }
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == NowLiveManager.jdField_a_of_type_Int) {
      if (!(localAppRuntime instanceof QQAppInterface)) {
        break label170;
      }
    }
    label170:
    for (boolean bool = ((QQAppInterface)localAppRuntime).getNowLiveManager().a();; bool = false)
    {
      if (!bool) {
        return true;
      }
      if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 1130L) && (a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
        }
        return true;
      }
      if (((localAppRuntime instanceof QQAppInterface)) && (a((QQAppInterface)localAppRuntime, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList, " + paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId + " is filtered");
        }
        return true;
      }
      return false;
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, StringBuffer paramStringBuffer, LebaViewItem paramLebaViewItem)
  {
    if (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 905L) {}
    do
    {
      return true;
      if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 1130L) && (a()))
      {
        paramStringBuffer.append("hide leba kandian,");
        return true;
      }
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        break label177;
      }
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (!a(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)) {
        break;
      }
      StringBuffer localStringBuffer = paramStringBuffer.append("isNowTabAdded");
      paramAppRuntime.getNowLiveManager();
      localStringBuffer.append(NowLiveManager.c).append("  isNowTabShow:").append(paramAppRuntime.getNowLiveManager().jdField_a_of_type_Boolean).append("  isSDKAPISupportStory:").append(QQStoryManager.i()).append(",");
    } while ((!paramAppRuntime.getNowLiveManager().a()) || (paramLebaViewItem.jdField_a_of_type_Byte == 1));
    if (a(paramAppRuntime, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId))
    {
      paramStringBuffer.append(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId).append(" is filtered");
      return true;
    }
    label177:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.itemfilter.LebaSpecificPluginFilter
 * JD-Core Version:    0.7.0.1
 */