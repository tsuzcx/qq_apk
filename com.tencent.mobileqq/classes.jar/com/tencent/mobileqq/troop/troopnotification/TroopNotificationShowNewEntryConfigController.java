package com.tencent.mobileqq.troop.troopnotification;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class TroopNotificationShowNewEntryConfigController
  extends TroopNotificationController
{
  private List<ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener> a;
  
  public TroopNotificationShowNewEntryConfigController(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationShowNewEntryConfigController", 1, "updateRecentUserListWhenNewEntryNotShow, Recent need to create and add");
    }
    Object localObject = ((ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "")).getMessageRecordListFromCache();
    int k = 0;
    int j = 0;
    int i;
    RecentUser localRecentUser;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = GroupSystemMsgController.a().a();
      if (localObject != null)
      {
        long l = ((structmsg.StructMsg)localObject).msg_time.get();
        localObject = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        i = j;
        if (localObject != null)
        {
          i = j;
          if (this.jdField_a_of_type_MqqAppAppRuntime.getAccount() != null)
          {
            localRecentUser = ((RecentUserProxy)localObject).a(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
            i = j;
            if (localRecentUser != null)
            {
              localRecentUser.uin = AppConstants.TROOP_NOTIFICATION_UIN;
              localRecentUser.setType(9000);
              localRecentUser.displayName = HardCodeUtil.a(2131691101);
              localRecentUser.lastmsgtime = l;
              localRecentUser.lastmsgdrafttime = l;
              ((RecentUserProxy)localObject).b(localRecentUser);
              i = 1;
            }
          }
        }
        if (i != 0)
        {
          localObject = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
          if (localObject != null) {
            ((ITroopSysMsgDependApiService)localObject).refreshConversationList();
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationShowNewEntryConfigController", 1, "updateRecentUserListWhenNewEntryNotShow, Recent be Added");
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("TroopNotificationShowNewEntryConfigController", 1, "updateRecentUserListWhenNewEntryNotShow, structMsg is null");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationShowNewEntryConfigController", 1, "updateRecentUserListWhenNewEntryNotShow, getMessageRecordListFromCache() is null or empty");
      }
      localObject = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      i = k;
      if (localObject != null)
      {
        i = k;
        if (this.jdField_a_of_type_MqqAppAppRuntime.getAccount() != null)
        {
          localRecentUser = ((RecentUserProxy)localObject).b(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
          i = k;
          if (localRecentUser != null)
          {
            ((RecentUserProxy)localObject).a(localRecentUser);
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        localObject = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localObject != null) {
          ((ITroopSysMsgDependApiService)localObject).refreshConversationList();
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationShowNewEntryConfigController", 1, "updateRecentUserListWhenNewEntryNotShow, getMessageRecordListFromCache() is null or empty。 when deleteRecent");
        }
      }
    }
  }
  
  private void b(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationShowNewEntryConfigController.2(this, paramTroopNotificationEntryConfig));
  }
  
  private void c(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    Object localObject;
    if (QLog.isColorLevel()) {
      if (paramTroopNotificationEntryConfig != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRecentUserListWhenHasNewConf, newConf = ");
        ((StringBuilder)localObject).append(paramTroopNotificationEntryConfig.toString());
        QLog.d("TroopNotificationShowNewEntryConfigController", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        QLog.d("TroopNotificationShowNewEntryConfigController", 1, "updateRecentUserListWhenHasNewConf, newConf is null ");
      }
    }
    if ((paramTroopNotificationEntryConfig != null) && (paramTroopNotificationEntryConfig.a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationShowNewEntryConfigController", 1, "updateRecentUserListWhenHasNewConf, delete notification entry in recent");
      }
      paramTroopNotificationEntryConfig = ((IRecentUserProxyService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      if ((paramTroopNotificationEntryConfig != null) && (this.jdField_a_of_type_MqqAppAppRuntime.getAccount() != null))
      {
        localObject = paramTroopNotificationEntryConfig.b(AppConstants.TROOP_NOTIFICATION_UIN, 9000);
        if (localObject != null) {
          paramTroopNotificationEntryConfig.a((RecentUser)localObject);
        }
      }
      paramTroopNotificationEntryConfig = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (paramTroopNotificationEntryConfig != null) {
        paramTroopNotificationEntryConfig.refreshConversationList();
      }
    }
    else
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationShowNewEntryConfigController", 1, "updateRecentUserListWhenHasNewConf, call updateRecentUserListWhenNewEntryNotShow");
      }
    }
  }
  
  @Nullable
  protected String a()
  {
    return "TroopNotificationShowNewEntryConfigController";
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationShowNewEntryConfigController.1(this, paramInt));
  }
  
  public void a(ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener)
  {
    if (paramINewTroopNotificationUnreadCountOrConfigChangedListener != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramINewTroopNotificationUnreadCountOrConfigChangedListener);
    }
  }
  
  public void a(TroopNotificationEntryConfig paramTroopNotificationEntryConfig)
  {
    if (paramTroopNotificationEntryConfig == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("INewTroopNotificationUnreadCountChangedListener, newConf = ");
      localStringBuilder.append(paramTroopNotificationEntryConfig.toString());
      QLog.d("TroopNotificationShowNewEntryConfigController", 1, localStringBuilder.toString());
    }
    b(paramTroopNotificationEntryConfig);
    c(paramTroopNotificationEntryConfig);
  }
  
  public void b(ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener paramINewTroopNotificationUnreadCountOrConfigChangedListener)
  {
    if (paramINewTroopNotificationUnreadCountOrConfigChangedListener != null) {
      this.jdField_a_of_type_JavaUtilList.remove(paramINewTroopNotificationUnreadCountOrConfigChangedListener);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationShowNewEntryConfigController
 * JD-Core Version:    0.7.0.1
 */