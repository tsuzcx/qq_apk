package com.tencent.mobileqq.onlinestatus.viewmodel;

import android.content.Intent;
import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.onlinestatus.AutoReplyManagerImpl;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusDataReporter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.IAutoReplyManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.ReceiveDataListener;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusData;
import com.tencent.mobileqq.onlinestatus.model.OnlineStatusResult;
import com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository;
import com.tencent.mobileqq.onlinestatus.utils.AutoReplyUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AccountOnlineStateViewModel
  extends BaseViewModel<AccountOnlineStateRepository>
  implements OnlineStatusPermissionManager.ReceiveDataListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = ThreadManagerV2.getUIHandlerV2();
  private MutableLiveData<OnlineStatusData> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private boolean jdField_a_of_type_Boolean = false;
  private MutableLiveData<OnlineStatusData> jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private boolean jdField_b_of_type_Boolean = false;
  private MutableLiveData<List<AutoReplyText>> c = new MutableLiveData();
  private MutableLiveData<Integer> d = new MutableLiveData();
  private MutableLiveData<OnlineStatusResult> e = new MutableLiveData();
  private MutableLiveData<OnlineStatusPermissionChecker.OnlineStatusPermissionItem> f = new MutableLiveData();
  
  public AccountOnlineStateViewModel(AccountOnlineStateRepository paramAccountOnlineStateRepository)
  {
    super(paramAccountOnlineStateRepository);
  }
  
  public MutableLiveData<OnlineStatusData> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public OnlineStatusPermissionChecker.OnlineStatusPermissionItem a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return null;
    }
    return (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue();
  }
  
  public void a()
  {
    ((AccountOnlineStateRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
  }
  
  public void a(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (this.f.getValue() == null)
    {
      this.f.setValue((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramQBaseActivity.getIntent().getSerializableExtra("online_status_permission_item"));
      if (this.f.getValue() == null)
      {
        paramAppInterface = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)paramAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(40001L, false, this);
        if (paramAppInterface != null)
        {
          this.jdField_a_of_type_Boolean = false;
          this.f.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramAppInterface.allHasPermission, paramAppInterface.permissionUins));
        }
        else
        {
          this.jdField_a_of_type_Boolean = true;
          this.f.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null));
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.f.getValue() != null) {
      ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue()).filterNotFriend();
    }
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.f.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins));
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime.Status localStatus = OnLineStatusHelper.a().a(paramOnlineStatusItem);
    if ((localStatus != null) && (!a(paramOnlineStatusItem, localStatus)))
    {
      a(true);
      ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(localStatus, paramOnlineStatusItem.jdField_a_of_type_Long);
      return;
    }
    this.e.setValue(new OnlineStatusResult(true, 0));
  }
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramOnlineStatusPermissionItem == null) {
      return;
    }
    if ((this.f.getValue() != null) && (!((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue()).isAllHasPermission()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateViewModel", 2, "account_online_status_show_all! mOnlinePermission is part");
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue());
    }
    this.f.setValue(paramOnlineStatusPermissionItem);
  }
  
  public void a(OnlineStatusData paramOnlineStatusData, AppInterface paramAppInterface, AutoReplyText paramAutoReplyText)
  {
    OnlineStatusDataReporter.a(paramAppInterface, paramOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusData.jdField_a_of_type_Long);
    OnlineStatusDataReporter.a(paramAppInterface, paramOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status, paramOnlineStatusData.jdField_a_of_type_Long, paramAutoReplyText);
    int i = AutoReplyUtils.a(paramOnlineStatusData.jdField_a_of_type_MqqAppAppRuntime$Status);
    if (i > 0) {
      ReportHelperKt.a("0X800B23A", i);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((AutoReplyManagerImpl)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoReplyManager.class)).a();
    this.c.setValue(paramAppRuntime);
    ThreadManager.getSubThreadHandler().post(new AccountOnlineStateViewModel.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateViewModel", 2, "account_online_status_show_part!");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null) {
          localObject = "null";
        } else {
          localObject = " not null";
        }
        QLog.d("AccountOnlineStateViewModel", 2, new Object[] { "account_online_status_show_part! mLastPartPermission:", localObject });
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
      if (localObject == null) {
        OnlineStatusPermissionChecker.a(paramAppInterface, paramQBaseActivity, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue(), false);
      } else {
        this.f.setValue(localObject);
      }
    }
    else
    {
      OnlineStatusPermissionChecker.a(paramAppInterface, paramQBaseActivity, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue(), false);
    }
    ReportHelperKt.a("0X800AF99", 2);
  }
  
  public void a(boolean paramBoolean, List<AutoReplyText> paramList)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(new AccountOnlineStateViewModel.2(this, paramBoolean, paramList));
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(OnlineStatusItem paramOnlineStatusItem, BaseOnlineStatusDisplayInfo paramBaseOnlineStatusDisplayInfo, AppInterface paramAppInterface)
  {
    AppRuntime.Status localStatus = OnLineStatusHelper.a().a(paramOnlineStatusItem);
    paramAppInterface = (IOnlineStatusService)paramAppInterface.getRuntimeService(IOnlineStatusService.class, "");
    if ((localStatus != null) && (!a(paramOnlineStatusItem, localStatus)))
    {
      if (paramBaseOnlineStatusDisplayInfo != null)
      {
        a(true);
        paramBaseOnlineStatusDisplayInfo.a(false, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue());
        return false;
      }
      paramAppInterface.updateOnlineStatus(localStatus, paramOnlineStatusItem.jdField_a_of_type_Long);
      a(true);
      return false;
    }
    if (paramBaseOnlineStatusDisplayInfo != null)
    {
      a(true);
      paramBaseOnlineStatusDisplayInfo.a(true, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue());
      return false;
    }
    e().setValue(new OnlineStatusResult(true, 0));
    return false;
  }
  
  public boolean a(OnlineStatusItem paramOnlineStatusItem, AppRuntime.Status paramStatus)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime.Status localStatus = ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a(localAppRuntime);
    return (paramStatus == localStatus) && ((l == paramOnlineStatusItem.jdField_a_of_type_Long) || ((l > 40000L) && (paramOnlineStatusItem.jdField_a_of_type_Long > 40000L)));
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    AppRuntime.Status localStatus = ((IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a(paramAppRuntime);
    return (((OnlineStatusData)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).jdField_a_of_type_MqqAppAppRuntime$Status == localStatus) && ((l == ((OnlineStatusData)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).jdField_a_of_type_Long) || ((l > 40000L) && (((OnlineStatusData)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).jdField_a_of_type_Long > 40000L)));
  }
  
  public MutableLiveData<OnlineStatusData> b()
  {
    return this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void b(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramOnlineStatusPermissionItem != null)
    {
      a(paramOnlineStatusPermissionItem);
      ReportHelperKt.a("0X800AF4A", 2);
    }
  }
  
  public MutableLiveData<List<AutoReplyText>> c()
  {
    return this.c;
  }
  
  public MutableLiveData<Integer> d()
  {
    return this.d;
  }
  
  public MutableLiveData<OnlineStatusResult> e()
  {
    return this.e;
  }
  
  public MutableLiveData<OnlineStatusPermissionChecker.OnlineStatusPermissionItem> f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel
 * JD-Core Version:    0.7.0.1
 */