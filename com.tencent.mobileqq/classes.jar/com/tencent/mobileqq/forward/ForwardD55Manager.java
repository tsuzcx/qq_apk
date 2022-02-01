package com.tencent.mobileqq.forward;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class ForwardD55Manager
{
  private int jdField_a_of_type_Int;
  private AppInfo jdField_a_of_type_ComTencentMobileqqForwardAppInfo;
  private Map<Long, AppInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private WeakReference<ForwardD55Manager.D55ResultListener> jdField_a_of_type_MqqUtilWeakReference;
  
  public AppInfo a()
  {
    try
    {
      AppInfo localAppInfo = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo;
      return localAppInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public AppInfo a(long paramLong)
  {
    try
    {
      AppInfo localAppInfo = (AppInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      return localAppInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String a()
  {
    try
    {
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo != null) {
        str = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.f();
      } else {
        str = "";
      }
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong, AppInfo paramAppInfo)
  {
    try
    {
      QLog.d("ForwardD55Manager", 1, new Object[] { "--> onResult appId=", Long.valueOf(paramLong), ", appInfo=", paramAppInfo.toString() });
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramAppInfo);
      if (this.jdField_a_of_type_MqqUtilWeakReference != null)
      {
        QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener");
        if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
        {
          QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener.get()");
          ((ForwardD55Manager.D55ResultListener)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
        }
        else
        {
          QLog.d("ForwardD55Manager", 1, "--> onResult null == mListener.get()");
        }
      }
      else
      {
        QLog.d("ForwardD55Manager", 1, "--> onResult null == mListener");
      }
      return;
    }
    finally {}
  }
  
  public void a(ForwardD55Manager.D55ResultListener paramD55ResultListener)
  {
    try
    {
      QLog.d("ForwardD55Manager", 1, new Object[] { "--> setD55Listener=", paramD55ResultListener });
      if (paramD55ResultListener == null) {
        paramD55ResultListener = null;
      } else {
        paramD55ResultListener = new WeakReference(paramD55ResultListener);
      }
      this.jdField_a_of_type_MqqUtilWeakReference = paramD55ResultListener;
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QLog.d("ForwardD55Manager", 1, new Object[] { "fetchAppInfoByD55 openId=", paramString1, ", appId=", Long.valueOf(paramLong), ", pkgName=", paramString2 });
    ForwardStatisticsReporter.a("KEY_STAGE_1_D55");
    localObject = ((QQAppInterface)localObject).getMsgHandler();
    if (paramString1 == null) {
      paramString1 = "";
    }
    ((MessageHandler)localObject).a(false, paramString1, false, 0L, paramLong, 1, 2, paramString2, true, ForwardShareByServerHelper.a(), new ForwardD55Manager.1(this, paramString2, paramLong));
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo != null)
      {
        int i = this.jdField_a_of_type_Int;
        if (i == 0)
        {
          bool = true;
          break label25;
        }
      }
      boolean bool = false;
      label25:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo != null)
      {
        int i = this.jdField_a_of_type_Int;
        if (i > 0)
        {
          bool = true;
          break label25;
        }
      }
      boolean bool = false;
      label25:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo != null)
      {
        int i = this.jdField_a_of_type_Int;
        if (i <= -1)
        {
          bool = true;
          break label26;
        }
      }
      boolean bool = false;
      label26:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager
 * JD-Core Version:    0.7.0.1
 */