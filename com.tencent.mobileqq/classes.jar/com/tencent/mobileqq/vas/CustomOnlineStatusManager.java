package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.qvip.CustomOnlineStatusConfig;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class CustomOnlineStatusManager
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private final ArrayList<WeakReference<Runnable>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int b = 30000;
  private int c = -1;
  
  public static CustomOnlineStatusManager a()
  {
    return CustomOnlineStatusManager.SingletonInstance.a();
  }
  
  private final void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "resetOnEnableToggle");
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new CustomOnlineStatusManager.1(this));
  }
  
  public final String a()
  {
    if (a())
    {
      long l = System.currentTimeMillis();
      if (Math.abs(this.jdField_a_of_type_Long - l) > this.b)
      {
        this.jdField_a_of_type_Long = l;
        if (QLog.isDevelopLevel()) {
          QLog.d("CustomOnlineStatusManager", 4, "sync owner status");
        }
        CustomOnlineStatusManager.Utils.a();
      }
      if (CustomOnlineStatusManager.Utils.a(this.jdField_a_of_type_Int)) {
        return this.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public final void a(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    this.jdField_a_of_type_Int = CustomOnlineStatusManager.Utils.b(paramCustomOnlineStatusMsg);
    this.jdField_a_of_type_JavaLangString = CustomOnlineStatusManager.Utils.a(paramCustomOnlineStatusMsg);
    this.b = CustomOnlineStatusManager.Utils.a(paramCustomOnlineStatusMsg);
    b();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramRunnable));
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public final boolean a()
  {
    int j = this.c;
    CustomOnlineStatusConfig localCustomOnlineStatusConfig = (CustomOnlineStatusConfig)QConfigManager.a().a(479);
    if ((localCustomOnlineStatusConfig == null) || (localCustomOnlineStatusConfig.a)) {}
    for (int i = 1;; i = 0)
    {
      this.c = i;
      if (j != this.c) {
        a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "featureEnable = " + this.c);
      }
      if (this.c != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (paramString != null)
    {
      paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (paramString != null) {
        return Math.abs(System.currentTimeMillis() - paramString.longValue()) > this.b;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.CustomOnlineStatusManager
 * JD-Core Version:    0.7.0.1
 */