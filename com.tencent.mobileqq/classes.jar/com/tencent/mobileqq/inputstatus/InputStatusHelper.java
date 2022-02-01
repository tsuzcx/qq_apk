package com.tencent.mobileqq.inputstatus;

import android.os.Handler;
import android.os.Looper;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;

public class InputStatusHelper
  implements ILifeCycleHelper
{
  private static final String jdField_a_of_type_JavaLangString = "InputStatusHelper";
  private int jdField_a_of_type_Int = 0;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new InputStatusHelper.1(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private InputStatusObserver jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver;
  private InputStatusPushManager jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusPushManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new InputStatusHelper.2(this);
  private boolean jdField_a_of_type_Boolean = true;
  public long b;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  
  public InputStatusHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Long = 5000L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private InputStatusPushManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusPushManager == null)
    {
      Manager localManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_INPUT_STATUS_MANAGER);
      if ((localManager instanceof InputStatusPushManager)) {
        this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusPushManager = ((InputStatusPushManager)localManager);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusPushManager;
  }
  
  private void a(int paramInt)
  {
    if ((e()) && (f()) && (a())) {
      try
      {
        this.jdField_a_of_type_Int = paramInt;
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        InputStatusHandler localInputStatusHandler = (InputStatusHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER);
        if (localInputStatusHandler != null)
        {
          localInputStatusHandler.a(paramInt, l);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
      }
    }
  }
  
  private boolean a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof LimitChatPie))) {
      return c();
    }
    return b();
  }
  
  private boolean b()
  {
    try
    {
      InputStatusConfig.Config localConfig = (InputStatusConfig.Config)QConfigManager.a().a(445);
      if (localConfig != null)
      {
        boolean bool = localConfig.jdField_a_of_type_Boolean;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    return false;
  }
  
  private boolean c()
  {
    try
    {
      InputStatusConfig.Config localConfig = (InputStatusConfig.Config)QConfigManager.a().a(445);
      if (localConfig != null)
      {
        boolean bool = localConfig.jdField_b_of_type_Boolean;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    return true;
  }
  
  private boolean d()
  {
    AppRuntime.Status localStatus = ((IOnlineStatusService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    return (localStatus != AppRuntime.Status.away) && (localStatus != AppRuntime.Status.busy) && (localStatus != AppRuntime.Status.dnd) && (localStatus != AppRuntime.Status.invisiable);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (f()) && (a())) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        InputStatusHandler localInputStatusHandler = (InputStatusHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER);
        if (localInputStatusHandler != null)
        {
          localInputStatusHandler.a(2, l);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
      }
    }
  }
  
  private boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof LimitChatPie)) {
      return true;
    }
    return d();
  }
  
  private boolean f()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof LimitChatPie))) {
      return true;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void a()
  {
    if (!this.d)
    {
      this.d = true;
      if ((f()) && (a())) {
        a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    boolean bool = this.jdField_b_of_type_Boolean;
    if (!bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(bool, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  void a(boolean paramBoolean, String paramString)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      paramString = this.jdField_b_of_type_JavaLangString;
    }
    localBaseChatPie.a(paramBoolean, paramString);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
    if (a() != null) {
      a().a();
    }
  }
  
  public void c()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((f()) && (a())) {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        InputStatusHandler localInputStatusHandler = (InputStatusHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER);
        if (localInputStatusHandler != null)
        {
          localInputStatusHandler.a(2, l);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
      }
    }
  }
  
  public void d()
  {
    this.d = false;
    this.c = false;
  }
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    d();
    if (paramInt != 9)
    {
      if (paramInt != 15) {
        return;
      }
      if (a() != null) {
        a().onDestroy();
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject != null)
      {
        if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver);
      }
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      e();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver = new InputStatusHelper.InnerInputStatusObserver(this, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getVisibilityForInputStatus(true);
      if (f())
      {
        if (a() != null) {
          a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusHelper
 * JD-Core Version:    0.7.0.1
 */