package com.tencent.mobileqq.leba.business.itemfilter;

import com.tencent.biz.now.NowLiveManager;
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

public class LebaSpecificPluginFilter
  implements ILebaItemFilter
{
  public boolean a()
  {
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab();
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
      if (paramQQAppInterface.A < 1) {
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
    if (paramLebaViewItem.b.uiResId == 905L) {
      return true;
    }
    if (paramLebaViewItem.b.uiResId == NowLiveManager.a)
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
    if ((paramLebaViewItem.b.uiResId == 1130L) && (a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
      }
      return true;
    }
    if (((localObject instanceof QQAppInterface)) && (a((QQAppInterface)localObject, paramLebaViewItem.b.uiResId)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getLebaMgrList, ");
        ((StringBuilder)localObject).append(paramLebaViewItem.b.uiResId);
        ((StringBuilder)localObject).append(" is filtered");
        QLog.d("Q.lebatab.mgr", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.itemfilter.LebaSpecificPluginFilter
 * JD-Core Version:    0.7.0.1
 */