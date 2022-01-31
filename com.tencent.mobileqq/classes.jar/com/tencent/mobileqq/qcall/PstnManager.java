package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PstnManager
  implements Manager
{
  public int a;
  public long a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
  private PstnSwitchConfig jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_b_of_type_Int = -1;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_c_of_type_Int = -1;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int jdField_d_of_type_Int = -1;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int e = -1;
  private int f = -1;
  private int g = 3;
  private int h = 3;
  
  public PstnManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 30;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    this.g = paramQQAppInterface.getInt("key_c2c_warning_time", 3);
    this.h = paramQQAppInterface.getInt("key_multi_warning_time", 3);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PstnManager", 2, "=== app is null ===");
      }
    }
    Resources localResources;
    do
    {
      return;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
    } while ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (localResources == null));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_no_try_chance_tips", localResources.getString(2131438370));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_has_try_chance_tips", localResources.getString(2131438371));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_c2c_recharge_title", localResources.getString(2131438372));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_c2c_recharge_content", localResources.getString(2131438373));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_c2c_recharge_confirm_text", localResources.getString(2131438374));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_multi_recharge_title", localResources.getString(2131438375));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_multi_recharge_content", localResources.getString(2131438376));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_multi_recharge_confirm_text", localResources.getString(2131438377));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_c2c_recharge_title", localResources.getString(2131438378));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_c2c_recharge_content", localResources.getString(2131438379));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_c2c_recharge_confirm_text", localResources.getString(2131438380));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_multi_recharge_title", localResources.getString(2131438381));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_multi_recharge_content", localResources.getString(2131438382));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_multi_recharge_confirm_text", localResources.getString(2131438383));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_c2c_try_over_recharge_title", localResources.getString(2131438384));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_c2c_try_over_recharge_content", localResources.getString(2131438385));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_c2c_try_over_recharge_confirm_text", localResources.getString(2131438386));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_try_over_recharge_title", localResources.getString(2131438387));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_try_over_recharge_content", localResources.getString(2131438388));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_try_over_recharge_confirm_text", localResources.getString(2131438389));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_c2c_trans_wording", localResources.getString(2131438390));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_c2c_trans_check_wording", localResources.getString(2131438391));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_c2c_trans_setting_wording", localResources.getString(2131438392));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_multi_trans_wording", localResources.getString(2131438393));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_multi_trans_check_wording", localResources.getString(2131438394));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_multi_trans_setting_wording", localResources.getString(2131438395));
  }
  
  public int a()
  {
    int j = this.jdField_b_of_type_Int;
    int i = j;
    if (j == -1) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("user_pstn_gray_flag", 0);
    }
    return i;
  }
  
  public MessageRecord a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (MessageRecord)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public ByteStringMicro a()
  {
    ByteStringMicro localByteStringMicro2 = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
    ByteStringMicro localByteStringMicro1;
    String str;
    if (localByteStringMicro2 != null)
    {
      localByteStringMicro1 = localByteStringMicro2;
      if (localByteStringMicro2.toString().length() != 0) {}
    }
    else
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("user_pstn_gray_cookies", "00");
      QLog.d("PstnManager", 1, " === get cookies : " + str + " ====");
      if ((str == null) || (!str.equals("00"))) {
        break label96;
      }
      localByteStringMicro1 = null;
    }
    label96:
    do
    {
      return localByteStringMicro1;
      localByteStringMicro1 = localByteStringMicro2;
    } while (TextUtils.isEmpty(str));
    return ByteStringMicro.copyFrom(HexUtil.a(str));
  }
  
  public PstnCardInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("PstnManager", 1, " getPstnCardInfo uin is null ");
      paramString = null;
    }
    PstnCardInfo localPstnCardInfo;
    do
    {
      do
      {
        return paramString;
        localPstnCardInfo = (PstnCardInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        paramString = localPstnCardInfo;
      } while (localPstnCardInfo == null);
      paramString = localPstnCardInfo;
    } while (!QLog.isColorLevel());
    QLog.d("PstnManager", 2, "getPstnCardInfo, " + localPstnCardInfo.toString());
    return localPstnCardInfo;
  }
  
  public PstnSwitchConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig = new PstnSwitchConfig();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_a_of_type_Int = localSharedPreferences.getInt("key_pstn_c2c_aio_flag", 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_c_of_type_Int = localSharedPreferences.getInt("key_pstn_c2c_ip_call_flag", 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_b_of_type_Int = localSharedPreferences.getInt("key_pstn_c2c_profile_card_flag", 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_d_of_type_Int = localSharedPreferences.getInt("key_pstn_multi_aio_flag", 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.e = localSharedPreferences.getInt("key_pstn_auto_trans_time", 100000);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.f = localSharedPreferences.getInt("key_pstn_miss_delay_time", 20);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.g = localSharedPreferences.getInt("key_pstn_miss_show_time", 60);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PstnManager", 2, "getPstnSwitchConfig, " + this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig;
  }
  
  public String a(String paramString)
  {
    Object localObject = "";
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("PstnManager", 1, " getPstnTips key is null");
    }
    String str;
    do
    {
      do
      {
        do
        {
          return localObject;
          if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
          }
          if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            a();
          }
          str = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = str;
        } while (!TextUtils.isEmpty(str));
        localObject = str;
      } while (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString(paramString, (String)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
      localObject = str;
    } while (TextUtils.isEmpty(str));
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, str);
    return str;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("key_gray_switch_need_popup_confirm", paramInt);
    localEditor.commit();
  }
  
  public void a(int paramInt1, int paramInt2, ByteStringMicro paramByteStringMicro, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramByteStringMicro;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("user_pstn_gray_flag", paramInt1);
    localEditor.putInt("user_pstn_req_gray_inter", paramInt2);
    if (paramByteStringMicro != null)
    {
      paramByteStringMicro = HexUtil.a(paramByteStringMicro.toByteArray());
      if (!TextUtils.isEmpty(paramByteStringMicro)) {
        localEditor.putString("user_pstn_gray_cookies", paramByteStringMicro);
      }
    }
    localEditor.putInt("user_pstn_c2c_trial_authority", paramInt3);
    localEditor.putInt("user_pstn_multi_trial_authority", paramInt4);
    localEditor.commit();
  }
  
  public void a(PstnCardInfo paramPstnCardInfo)
  {
    if ((paramPstnCardInfo == null) || (TextUtils.isEmpty(paramPstnCardInfo.uin)))
    {
      QLog.d("PstnManager", 1, " savePstnCardInfo pstnCardInfo is null or uin is null ");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramPstnCardInfo.uin)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPstnCardInfo.uin);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramPstnCardInfo.uin, paramPstnCardInfo);
  }
  
  public void a(PstnSwitchConfig paramPstnSwitchConfig)
  {
    if (paramPstnSwitchConfig == null)
    {
      QLog.i("PstnManager", 1, " setpstnswitchconfig  config is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig = paramPstnSwitchConfig;
    paramPstnSwitchConfig = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramPstnSwitchConfig.putInt("key_pstn_c2c_aio_flag", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_a_of_type_Int);
    paramPstnSwitchConfig.putInt("key_pstn_c2c_ip_call_flag", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_c_of_type_Int);
    paramPstnSwitchConfig.putInt("key_pstn_c2c_profile_card_flag", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_b_of_type_Int);
    paramPstnSwitchConfig.putInt("key_pstn_multi_aio_flag", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_d_of_type_Int);
    paramPstnSwitchConfig.putInt("key_pstn_auto_trans_time", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.e);
    paramPstnSwitchConfig.putInt("key_pstn_miss_delay_time", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.f);
    paramPstnSwitchConfig.putInt("key_pstn_miss_show_time", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.g);
    paramPstnSwitchConfig.commit();
  }
  
  public void a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMessageRecord == null)) {
      return;
    }
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramMessageRecord);
  }
  
  public void a(HashMap paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(paramHashMap);
      }
      SharedPreferences.Editor localEditor;
      for (;;)
      {
        localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
        Object localObject = paramHashMap.keySet();
        if ((localObject == null) || (((Set)localObject).size() <= 0)) {
          break;
        }
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = (String)paramHashMap.get(str1);
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            localEditor.putString(str1, str2);
          }
        }
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramHashMap);
      }
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.i("PstnManager", 2, " setPstnTips, " + paramHashMap.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("key_pstn_c2c_switch_setting", paramBoolean);
    localEditor.commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("key_pstn_c2c_switch_setting", false);
  }
  
  public int b()
  {
    int j = this.jdField_c_of_type_Int;
    int i = j;
    if (j == -1) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("user_pstn_c2c_trial_authority", 0);
    }
    return i;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("key_gray_switch_no_need_add_address", paramInt);
    localEditor.commit();
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("key_pstn_multi_switch_setting", paramBoolean);
    localEditor.commit();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("key_pstn_multi_switch_setting", false);
  }
  
  public int c()
  {
    int j = this.jdField_d_of_type_Int;
    int i = j;
    if (j == -1) {
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("user_pstn_multi_trial_authority", 0);
    }
    return i;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("key_c2c_warning_time", this.g);
    localEditor.commit();
  }
  
  public int d()
  {
    if (this.e == -1) {
      this.e = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("key_gray_switch_need_popup_confirm", 0);
    }
    return this.e;
  }
  
  public void d(int paramInt)
  {
    this.h = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("key_multi_warning_time", this.h);
  }
  
  public int e()
  {
    return this.g;
  }
  
  public int f()
  {
    return this.h;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.PstnManager
 * JD-Core Version:    0.7.0.1
 */