package com.tencent.mobileqq.config;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ConfigUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class CfgProcess
{
  private final SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(10);
  private final ConcurrentHashMap<String, CopyOnWriteArraySet<CfgProcess.OnGetConfigListener>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public CfgProcess()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(271, "batch_add_friend_for_troop_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(275, "confess_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(358, "contact_top_entry_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(372, "breaking_ice_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(326, "sosointerface_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(357, "register_invitation_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(330, "hiboom_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(296, "extend_friend_config_785");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(369, "account_logout_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(379, "qqsettingme_f2f_guide_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(378, "profile_btn_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(381, "profile_switch_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(401, "smart_devices_discovery_config");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(407, "hide_qq_xman");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(405, "add_contact_page_public_account_switch");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(408, "select_member_entry_switch");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(355, "troop_member_list_config");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      String str = (String)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new CopyOnWriteArraySet());
      i += 1;
    }
    a("qqsettingme_f2f_guide_config", new OnF2FConfigListener());
    a("smart_devices_discovery_config", new OnSmartDeviceDiscoveryCfgListener());
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return SharedPreUtils.a(BaseApplicationImpl.getApplication(), paramString1, paramString2);
  }
  
  private CopyOnWriteArraySet<CfgProcess.OnGetConfigListener> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfValue(paramString) < 0) {
      return null;
    }
    return (CopyOnWriteArraySet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
      QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "handleConfigFail [id: %s, tag: %s, isSuc: %s, result: %s]", new Object[] { Integer.valueOf(paramInt1), paramQQAppInterface, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) }));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig, int paramInt)
  {
    String str1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (TextUtils.isEmpty(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("CfgProcess", 2, String.format(" handleConfig tag is null ! config: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    String str2;
    BaseApplication localBaseApplication;
    CfgProcess.CfgParseResult localCfgParseResult;
    do
    {
      return;
      str2 = paramQQAppInterface.getCurrentAccountUin();
      localBaseApplication = paramQQAppInterface.getApp();
      localCfgParseResult = new CfgProcess.CfgParseResult();
      localCfgParseResult.jdField_b_of_type_Int = paramConfig.version.get();
      localCfgParseResult.jdField_a_of_type_Int = SharedPreUtils.c(localBaseApplication, str2, str1);
      if (localCfgParseResult.jdField_b_of_type_Int != localCfgParseResult.jdField_a_of_type_Int) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CfgProcess", 2, new Object[] { " handleConfig config version is the same. [tag: %s, version: %s]", str1, Integer.valueOf(localCfgParseResult.jdField_b_of_type_Int) });
    return;
    localCfgParseResult.c = 0;
    Object localObject1 = null;
    int j = 0;
    int i;
    Object localObject2;
    if (paramConfig.msg_content_list.size() > 0)
    {
      localObject1 = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (!"extend_friend_config_785".equals(str1)) {
        break label931;
      }
      i = 0;
      while (i < paramConfig.msg_content_list.size())
      {
        localObject2 = localObject1;
        if (((ConfigurationService.Content)paramConfig.msg_content_list.get(i)).task_id.get() > ((ConfigurationService.Content)localObject1).task_id.get()) {
          localObject2 = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    label341:
    ConfigurationService.Config localConfig;
    label673:
    label931:
    for (paramConfig = (ConfigurationService.Config)localObject1;; paramConfig = localConfig)
    {
      if (paramConfig == null) {
        i = -1;
      }
      for (;;)
      {
        if (QLog.isDebugVersion()) {
          QLog.d("CfgProcess", 2, " config task id " + i);
        }
        if (paramConfig == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CfgProcess", 2, " handleConfig content is null !");
          }
          localCfgParseResult.c = 1;
          localObject1 = paramConfig;
          j = i;
          if (localCfgParseResult.jdField_a_of_type_JavaLangString == null) {
            localCfgParseResult.jdField_a_of_type_JavaLangString = "";
          }
          localCfgParseResult.jdField_b_of_type_Boolean = true;
          localCfgParseResult.jdField_a_of_type_Boolean = false;
          if (localCfgParseResult.c != 0) {}
        }
        else
        {
          try
          {
            for (;;)
            {
              ConfigUtil.a(paramQQAppInterface, str1, localCfgParseResult, j);
              if (localCfgParseResult.jdField_a_of_type_Boolean) {
                break label739;
              }
              SharedPreUtils.a(localBaseApplication, str2, str1, localCfgParseResult.jdField_a_of_type_JavaLangString);
              paramConfig = a(str1);
              if ((paramConfig == null) || (paramConfig.size() <= 0)) {
                break label775;
              }
              paramConfig = paramConfig.iterator();
              while (paramConfig.hasNext())
              {
                localObject2 = (CfgProcess.OnGetConfigListener)paramConfig.next();
                try
                {
                  ((CfgProcess.OnGetConfigListener)localObject2).a(paramQQAppInterface, paramInt, str1, localCfgParseResult);
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
                if (QLog.isColorLevel()) {
                  QLog.i("CfgProcess", 2, "handleConfig OnGetConfigListener fail:  " + str1);
                }
              }
              i = paramConfig.task_id.get();
              break;
              if (paramConfig.compress.get() != 1) {
                break label673;
              }
              localObject1 = OlympicUtil.a(paramConfig.content.get().toByteArray());
              if (localObject1 == null) {
                break label635;
              }
              try
              {
                localCfgParseResult.jdField_a_of_type_JavaLangString = new String((byte[])localObject1, "UTF-8");
                j = i;
                localObject1 = paramConfig;
              }
              catch (Throwable localThrowable)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("CfgProcess", 2, " handleConfig Throwable:" + localThrowable.getMessage());
                }
                localCfgParseResult.c = 2;
                j = i;
                localConfig = paramConfig;
              }
            }
            break label341;
            label635:
            localCfgParseResult.c = 3;
            j = i;
            localConfig = paramConfig;
            if (!QLog.isColorLevel()) {
              break label341;
            }
            QLog.d("CfgProcess", 2, " handleConfig inflateConfigString error!");
            j = i;
            localConfig = paramConfig;
            break label341;
            localCfgParseResult.jdField_a_of_type_JavaLangString = paramConfig.content.get().toStringUtf8();
            j = i;
            localConfig = paramConfig;
          }
          catch (Throwable paramConfig)
          {
            for (;;)
            {
              paramConfig.printStackTrace();
              if (QLog.isColorLevel())
              {
                QLog.i("CfgProcess", 2, "handleConfig call save individual fail:  " + str1);
                continue;
                label739:
                if (QLog.isColorLevel()) {
                  QLog.i("CfgProcess", 2, "handleConfig self save config tag: " + str1);
                }
              }
            }
          }
        }
      }
      int k;
      int m;
      if (localCfgParseResult.jdField_b_of_type_Boolean)
      {
        i = localCfgParseResult.jdField_b_of_type_Int;
        SharedPreUtils.c(localBaseApplication, str2, str1, i);
        if (!QLog.isColorLevel()) {
          break;
        }
        paramQQAppInterface = Locale.getDefault();
        j = localCfgParseResult.jdField_a_of_type_Int;
        k = localCfgParseResult.jdField_b_of_type_Int;
        m = localCfgParseResult.c;
        if (localConfig != null) {
          break label918;
        }
      }
      for (i = 0;; i = localConfig.task_id.get())
      {
        QLog.i("CfgProcess", 2, String.format(paramQQAppInterface, "handleConfigForTag  configId: %s, tag: %s, localVersion: %s, version: %s, result: %s, task_id:%s, strContent: %s", new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), localCfgParseResult.jdField_a_of_type_JavaLangString }));
        return;
        i = 0;
        break;
      }
    }
  }
  
  public void a(ConfigurationService.ConfigSeq paramConfigSeq, QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "initConfigVersion tag is null, configId: %s", new Object[] { Integer.valueOf(paramInt) }));
      }
      return;
    }
    String str2 = paramQQAppInterface.getCurrentUin();
    paramQQAppInterface = paramQQAppInterface.getApp();
    int i;
    if (SharedPreUtils.d(paramQQAppInterface, str2, str1) != AppSetting.a())
    {
      SharedPreUtils.d(paramQQAppInterface, str2, str1, AppSetting.a());
      SharedPreUtils.c(paramQQAppInterface, str2, str1, 0);
      paramConfigSeq.version.set(0);
      i = 0;
    }
    for (;;)
    {
      paramConfigSeq.compress.set(1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CfgProcess", 2, String.format(Locale.getDefault(), "initConfigVersion [id: %s, tag: %s, version: %s]", new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(i) }));
      return;
      i = SharedPreUtils.c(paramQQAppInterface, str2, str1);
      paramConfigSeq.version.set(i);
    }
  }
  
  public boolean a(CfgProcess.OnGetConfigListener paramOnGetConfigListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((CopyOnWriteArraySet)localIterator.next()).remove(paramOnGetConfigListener) | bool) {}
    return bool;
  }
  
  public boolean a(String paramString, CfgProcess.OnGetConfigListener paramOnGetConfigListener)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = paramString.add(paramOnGetConfigListener);
    }
    return bool;
  }
  
  public boolean b(String paramString, CfgProcess.OnGetConfigListener paramOnGetConfigListener)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = paramString.remove(paramOnGetConfigListener);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.CfgProcess
 * JD-Core Version:    0.7.0.1
 */