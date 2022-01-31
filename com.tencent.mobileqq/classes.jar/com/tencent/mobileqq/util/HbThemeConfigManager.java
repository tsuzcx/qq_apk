package com.tencent.mobileqq.util;

import akac;
import akad;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class HbThemeConfigManager
{
  private static HbThemeConfigManager jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager;
  private static String jdField_a_of_type_JavaLangString;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  /* Error */
  public static HbThemeConfigManager a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager	Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 13	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 20	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager	Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/mobileqq/util/HbThemeConfigManager
    //   24: dup
    //   25: invokespecial 21	com/tencent/mobileqq/util/HbThemeConfigManager:<init>	()V
    //   28: putstatic 20	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager	Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 20	com/tencent/mobileqq/util/HbThemeConfigManager:jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager	Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject2	Object
    //   42	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	31	42	finally
    //   31	33	42	finally
    //   43	45	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   45	47	47	finally
  }
  
  private String a(AppInterface paramAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppInterface.getApp().getFilesDir().getPath());
    localStringBuilder.append("/QWallet/").append(paramAppInterface.getCurrentAccountUin()).append(File.separator);
    return localStringBuilder.toString();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a(Context paramContext)
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null)
    {
      paramContext = paramContext.getSharedPreferences("qb_tenpay_share_face", 0).getString("hb_face", "");
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramContext);
      return this.jdField_a_of_type_OrgJsonJSONObject;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      jdField_a_of_type_ComTencentMobileqqUtilHbThemeConfigManager = null;
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "update hbTheme config, but AppInterface is null or account is empty return. ");
      }
      return;
    }
    ThreadManager.post(new akad(this, paramString, paramQQAppInterface), 5, null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HbThemeConfigManager", 2, "updateFaceConfig failed : config = null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HbThemeConfigManager", 2, "updateFaceConfig config = " + paramJSONObject.toString());
    }
    paramQQAppInterface = new akac(this, paramQQAppInterface.getApp(), paramJSONObject, paramQQAppInterface);
    ThreadManager.getFileThreadHandler().post(paramQQAppInterface);
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.util.HbThemeConfigManager
 * JD-Core Version:    0.7.0.1
 */