package com.tencent.mobileqq.troop.enterEffect;

import airp;
import airr;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class TroopEnterEffectManager
  implements Manager
{
  public int a;
  public long a;
  public Handler a;
  protected SparseArray a;
  public QQAppInterface a;
  public TroopEnterEffectConfig a;
  protected HashMap a;
  private AtomicBoolean a;
  public int b;
  private long b;
  protected HashMap b;
  public int c;
  private HashMap c;
  public int d;
  public int e;
  
  public TroopEnterEffectManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig = new TroopEnterEffectConfig();
    a();
  }
  
  public static void a(String paramString1, String paramString2, String... paramVarArgs)
  {
    String str1;
    String str2;
    label20:
    String str3;
    if (paramVarArgs.length > 0)
    {
      str1 = paramVarArgs[0];
      if (paramVarArgs.length <= 1) {
        break label68;
      }
      str2 = paramVarArgs[1];
      if (paramVarArgs.length <= 2) {
        break label75;
      }
      str3 = paramVarArgs[2];
      label31:
      if (paramVarArgs.length <= 3) {
        break label82;
      }
    }
    label68:
    label75:
    label82:
    for (paramVarArgs = paramVarArgs[3];; paramVarArgs = "")
    {
      ReportController.b(null, "dc00899", "Grp_action", "", paramString1, paramString2, 0, 0, str1, str2, str3, paramVarArgs);
      return;
      str1 = "";
      break;
      str2 = "";
      break label20;
      str3 = "";
      break label31;
    }
  }
  
  private TroopEnterEffectConfig.EffectInfo b()
  {
    Object localObject = FileUtils.a(BaseApplication.getContext().getFileStreamPath("troop_enter_effect_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    if (localObject != null)
    {
      group_effect_commu.TGetMyEffectRsp0x2 localTGetMyEffectRsp0x2 = new group_effect_commu.TGetMyEffectRsp0x2();
      try
      {
        localTGetMyEffectRsp0x2.mergeFrom((byte[])localObject);
        localObject = new TroopEnterEffectConfig.EffectInfo();
        ((TroopEnterEffectConfig.EffectInfo)localObject).a(localTGetMyEffectRsp0x2);
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("TroopEnterEffect", 1, "readEffectInfo error: " + localException.getMessage());
      }
    }
    return null;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo != null)
    {
      paramString = (TroopEnterEffectConfig.EffectInfoData)this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        return paramString.jdField_a_of_type_Int;
      }
    }
    return 0;
  }
  
  public SharedPreferences a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("troop_enter_effect_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public TroopEnterEffectConfig.EffectInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo;
  }
  
  public TroopEnterEffectConfig.EffectInfoData a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo != null) {
      return (TroopEnterEffectConfig.EffectInfoData)this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public TroopEnterEffectConfig a()
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a(true);
      }
      TroopEnterEffectConfig localTroopEnterEffectConfig = this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig;
      return localTroopEnterEffectConfig;
    }
    finally {}
  }
  
  public TroopEnterEffectController.TroopEnterEffectData a(String paramString)
  {
    paramString = (LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (TroopEnterEffectController.TroopEnterEffectData)paramString.get(0);
    }
    return null;
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l <= i * 60) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "updateVipInfo");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey((String)localObject);
    ((VipInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(str, (String)localObject);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "updateGlobalEffectInfo: effectId = " + paramInt1 + " effectName = " + paramString + " svipLevel = " + paramInt2 + " svipType = " + paramInt3);
    }
    this.jdField_a_of_type_Int = 8;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.e = paramInt1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
      {
        paramString = new ArrayList();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if (((TroopEnterEffectConfig.EffectInfoData)localEntry.getValue()).jdField_a_of_type_Boolean) {
            paramString.add(localEntry.getKey());
          }
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.a());
    }
  }
  
  public void a(TroopEnterEffectConfig.EffectInfo paramEffectInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo = paramEffectInfo;
  }
  
  public void a(TroopEnterEffectConfig.GrayTipsConfig paramGrayTipsConfig, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "addGrayTips uin = " + paramString + " wording = " + paramGrayTipsConfig.jdField_a_of_type_JavaLangString);
    }
    paramString = new UniteGrayTipParam(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramGrayTipsConfig.jdField_a_of_type_JavaLangString, 1, -5020, 131078, MessageCache.a());
    int i = 0;
    Object localObject;
    if (i < paramGrayTipsConfig.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (TroopEnterEffectConfig.GrayTipsConfig.Link)paramGrayTipsConfig.jdField_a_of_type_JavaUtilArrayList.get(i);
      Bundle localBundle = new Bundle();
      if (paramGrayTipsConfig.jdField_c_of_type_Int == 1)
      {
        localBundle.putInt("key_action", 1);
        localBundle.putString("key_action_DATA", ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        paramString.a(((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).jdField_a_of_type_Int, ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).jdField_b_of_type_Int, localBundle);
        i += 1;
        break;
        if (paramGrayTipsConfig.jdField_c_of_type_Int == 2)
        {
          localBundle.putInt("key_action", 30);
          localBundle.putString("key_action_DATA", VasH5PayUtil.a(paramGrayTipsConfig.jdField_b_of_type_JavaLangString, paramGrayTipsConfig.d, paramGrayTipsConfig.e, paramGrayTipsConfig.f, paramGrayTipsConfig.jdField_c_of_type_JavaLangString));
        }
      }
    }
    if (paramGrayTipsConfig.jdField_b_of_type_Boolean)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_action", 29);
      ((Bundle)localObject).putString("key_action_DATA", paramGrayTipsConfig.jdField_a_of_type_Int + "");
      paramString.a(paramGrayTipsConfig.jdField_a_of_type_JavaLangString.length() - 4, paramGrayTipsConfig.jdField_a_of_type_JavaLangString.length(), (Bundle)localObject);
    }
    paramGrayTipsConfig = new MessageForUniteGrayTip();
    paramGrayTipsConfig.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramGrayTipsConfig);
    a().edit().putLong("show_gray_tips_time", System.currentTimeMillis()).commit();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "style", "0X8009132", "", 1, 0, 0, "", "", "");
  }
  
  public void a(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    LinkedList localLinkedList2 = (LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(paramTroopEnterEffectData.jdField_b_of_type_JavaLangString);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramTroopEnterEffectData.jdField_b_of_type_JavaLangString, localLinkedList1);
    }
    if (paramTroopEnterEffectData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      localLinkedList1.addFirst(paramTroopEnterEffectData);
      return;
    }
    localLinkedList1.add(paramTroopEnterEffectData);
  }
  
  public void a(String paramString)
  {
    a().edit().putBoolean("gray_tips_no_longer_" + paramString, true).commit();
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "updateEffectStatus size = " + paramArrayList.size());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo != null))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        paramArrayList = ((String)localIterator.next()).split(",");
        if (paramArrayList.length == 2)
        {
          Object localObject1 = paramArrayList[0];
          Object localObject2 = paramArrayList[1];
          TroopEnterEffectConfig.EffectInfoData localEffectInfoData = (TroopEnterEffectConfig.EffectInfoData)this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
          paramArrayList = localEffectInfoData;
          if (localEffectInfoData == null) {
            paramArrayList = new TroopEnterEffectConfig.EffectInfoData();
          }
          if (localObject2.equals("1"))
          {
            paramArrayList.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, paramArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("TroopEnterEffect", 2, "updateEffectStatus off group uin = " + localObject1);
            }
          }
          else if (localObject2.equals("0"))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_b_of_type_Int > 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect", 2, "updateEffectStatus on group uin = " + localObject1 + " has globaleffect remove infodata");
              }
            }
            else
            {
              paramArrayList.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, paramArrayList);
              if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect", 2, "updateEffectStatus on group uin = " + localObject1 + " not has globaleffect update infoData");
              }
            }
          }
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.a());
    }
  }
  
  public void a(group_effect_commu.TGetMyEffectRsp0x2 paramTGetMyEffectRsp0x2)
  {
    paramTGetMyEffectRsp0x2 = new airr(this, paramTGetMyEffectRsp0x2);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramTGetMyEffectRsp0x2, 5, null, true);
      return;
    }
    paramTGetMyEffectRsp0x2.run();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "readEffectConfigData start");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + File.separator + "groupeffect_config.json";
    localObject = VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1000L, "groupeffect_config.json", (String)localObject, paramBoolean, null);
    if (localObject != null)
    {
      localObject = FileUtils.a((File)localObject, -1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.a((String)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "readEffectConfigData success");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    a(b());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean a()
  {
    long l1 = a().getLong("show_gray_tips_time", 0L);
    if (l1 == 0L) {}
    do
    {
      return false;
      if (this.jdField_b_of_type_Long == 0L)
      {
        long l2 = System.currentTimeMillis();
        this.jdField_b_of_type_Long = (l2 - l2 % 86400000L);
      }
    } while (l1 - l1 % 86400000L != this.jdField_b_of_type_Long);
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      TroopEnterEffectConfig.EffectInfoData localEffectInfoData = (TroopEnterEffectConfig.EffectInfoData)this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localEffectInfoData == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopEnterEffect", 2, "isEffectOn troopUin = " + paramString + " globalEffectId = " + this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_b_of_type_Int);
        }
        return this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_b_of_type_Int > 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "isEffectOn troopUin = " + paramString + " isOn = " + localEffectInfoData.jdField_a_of_type_Boolean);
      }
      return localEffectInfoData.jdField_a_of_type_Boolean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "isEffectOn troopUin = " + paramString + " effectInfo is Empty");
    }
    return false;
  }
  
  public void b(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    LinkedList localLinkedList = (LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(paramTroopEnterEffectData.jdField_b_of_type_JavaLangString);
    if (localLinkedList != null) {
      localLinkedList.remove(paramTroopEnterEffectData);
    }
  }
  
  public void b(String paramString)
  {
    paramString = (LinkedList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
  
  public boolean b()
  {
    return a().jdField_a_of_type_Boolean;
  }
  
  public boolean b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo != null)
    {
      paramString = (TroopEnterEffectConfig.EffectInfoData)this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      return (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig$EffectInfo.jdField_b_of_type_Int > 0) || ((paramString != null) && (paramString.jdField_a_of_type_Int > 0));
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "notifyEnterTroop troopUin: " + paramString);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      ThreadManager.post(new airp(this, paramString), 8, null, true);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectConfig.jdField_a_of_type_Boolean) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopEnterEffect", 2, "notifyEnterTroop function not enable");
          return;
        } while (!a(paramString));
        if (!AnonymousChatHelper.a().a(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopEnterEffect", 2, "notifyEnterTroop is Anonymous");
      return;
      long l = 0L;
      if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString)) {
        l = ((Long)this.jdField_c_of_type_JavaUtilHashMap.get(paramString)).longValue();
      }
      if (l + this.jdField_a_of_type_Long < System.currentTimeMillis())
      {
        l = Long.parseLong(paramString);
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(8192L, l);
        this.jdField_c_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopEnterEffect", 2, "notifyEnterTroop in time interval");
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager
 * JD-Core Version:    0.7.0.1
 */