package com.tencent.mobileqq.inputstatus;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;

public class InputStatusPushManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "InputStatusPushManager";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new InputStatusPushManager.1(this);
  private WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  public InputStatusPushManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private InputStatusHelper a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      return (InputStatusHelper)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(16);
    }
    return null;
  }
  
  private boolean a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && ((localWeakReference.get() instanceof LimitChatPie))) {
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
        boolean bool = localConfig.b;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    return true;
  }
  
  void a()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("receive fromUin =");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("，toUin，timeStamp =");
      ((StringBuilder)localObject2).append(paramLong3);
      ((StringBuilder)localObject2).append("，interval =");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("，showTime =");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("，eventType = ");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("，statusText =");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (a()))
    {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (a() != null)
      {
        a().a = (paramInt1 * 1000);
        a().b = paramLong3;
      }
      localObject1 = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localObject2 = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((TextUtils.equals((CharSequence)localObject1, String.valueOf(paramLong1))) && (TextUtils.equals((CharSequence)localObject2, String.valueOf(paramLong2))))
      {
        boolean bool;
        if (paramInt3 != 2) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool)
        {
          localObject1 = paramString;
          if (TextUtils.isEmpty(paramString))
          {
            if (paramInt3 == 1) {
              paramInt1 = 2131705860;
            } else {
              paramInt1 = 2131705861;
            }
            localObject1 = HardCodeUtil.a(paramInt1);
          }
          a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt2 * 1000);
        }
        else
        {
          localObject1 = "";
        }
        if (a() != null) {
          a().a(bool, (String)localObject1);
        }
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusPushManager
 * JD-Core Version:    0.7.0.1
 */