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
  private MutableLiveData<OnlineStatusData> a = new MutableLiveData();
  private MutableLiveData<OnlineStatusData> b = new MutableLiveData();
  private MutableLiveData<List<AutoReplyText>> c = new MutableLiveData();
  private MutableLiveData<Integer> d = new MutableLiveData();
  private MutableLiveData<OnlineStatusResult> e = new MutableLiveData();
  private MutableLiveData<OnlineStatusPermissionChecker.OnlineStatusPermissionItem> f = new MutableLiveData();
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem g;
  private boolean h = false;
  private boolean i = false;
  private Handler j = ThreadManagerV2.getUIHandlerV2();
  
  public AccountOnlineStateViewModel(AccountOnlineStateRepository paramAccountOnlineStateRepository)
  {
    super(paramAccountOnlineStateRepository);
  }
  
  public MutableLiveData<OnlineStatusData> a()
  {
    return this.a;
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
          this.h = false;
          this.f.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramAppInterface.allHasPermission, paramAppInterface.permissionUins));
        }
        else
        {
          this.h = true;
          this.f.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null));
        }
      }
      else
      {
        this.h = false;
      }
    }
    else
    {
      this.h = false;
    }
    if (this.f.getValue() != null) {
      ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue()).filterNotFriend();
    }
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.h) {
      this.f.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins));
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime.Status localStatus = OnLineStatusHelper.a().b(paramOnlineStatusItem);
    if ((localStatus != null) && (!a(paramOnlineStatusItem, localStatus)))
    {
      a(true);
      ((IOnlineStatusService)localAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(localStatus, paramOnlineStatusItem.b);
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
      this.g = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue());
    }
    this.f.setValue(paramOnlineStatusPermissionItem);
  }
  
  public void a(OnlineStatusData paramOnlineStatusData, AppInterface paramAppInterface, AutoReplyText paramAutoReplyText)
  {
    OnlineStatusDataReporter.a(paramAppInterface, paramOnlineStatusData.a, paramOnlineStatusData.b);
    OnlineStatusDataReporter.a(paramAppInterface, paramOnlineStatusData.a, paramOnlineStatusData.b, paramAutoReplyText);
    int k = AutoReplyUtils.a(paramOnlineStatusData.a);
    if (k > 0) {
      ReportHelperKt.a("0X800B23A", k);
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
    this.i = paramBoolean;
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
        if (this.g == null) {
          localObject = "null";
        } else {
          localObject = " not null";
        }
        QLog.d("AccountOnlineStateViewModel", 2, new Object[] { "account_online_status_show_part! mLastPartPermission:", localObject });
      }
      Object localObject = this.g;
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
    Handler localHandler = this.j;
    if (localHandler != null) {
      localHandler.post(new AccountOnlineStateViewModel.2(this, paramBoolean, paramList));
    }
  }
  
  public boolean a(OnlineStatusItem paramOnlineStatusItem, BaseOnlineStatusDisplayInfo paramBaseOnlineStatusDisplayInfo, AppInterface paramAppInterface)
  {
    AppRuntime.Status localStatus = OnLineStatusHelper.a().b(paramOnlineStatusItem);
    paramAppInterface = (IOnlineStatusService)paramAppInterface.getRuntimeService(IOnlineStatusService.class, "");
    if ((localStatus != null) && (!a(paramOnlineStatusItem, localStatus)))
    {
      if (paramBaseOnlineStatusDisplayInfo != null)
      {
        a(true);
        paramBaseOnlineStatusDisplayInfo.a(false, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue());
        return false;
      }
      paramAppInterface.updateOnlineStatus(localStatus, paramOnlineStatusItem.b);
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
    return (paramStatus == localStatus) && ((l == paramOnlineStatusItem.b) || ((l > 40000L) && (paramOnlineStatusItem.b > 40000L)));
  }
  
  public MutableLiveData<OnlineStatusData> b()
  {
    return this.b;
  }
  
  public void b(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramOnlineStatusPermissionItem != null)
    {
      a(paramOnlineStatusPermissionItem);
      ReportHelperKt.a("0X800AF4A", 2);
    }
  }
  
  public boolean b(AppRuntime paramAppRuntime)
  {
    AppRuntime.Status localStatus = ((IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    long l = OnLineStatusHelper.a().a(paramAppRuntime);
    return (((OnlineStatusData)this.a.getValue()).a == localStatus) && ((l == ((OnlineStatusData)this.a.getValue()).b) || ((l > 40000L) && (((OnlineStatusData)this.a.getValue()).b > 40000L)));
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
  
  public boolean g()
  {
    return this.i;
  }
  
  public void h()
  {
    ((AccountOnlineStateRepository)this.z).a();
  }
  
  public OnlineStatusPermissionChecker.OnlineStatusPermissionItem i()
  {
    if (this.h) {
      return null;
    }
    return (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)this.f.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel
 * JD-Core Version:    0.7.0.1
 */